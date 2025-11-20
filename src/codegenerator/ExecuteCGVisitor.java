package codegenerator;

import ast.Definition;
import ast.Invocation;
import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<ExecuteCGVisitor.ReturnDto,Void> {
    private CodeGenerator cg;
    private AddressCGVisitor address;
    private ValueCGVisitor value;
    public ExecuteCGVisitor(CodeGenerator out) {
        this.cg = out;
        this.address = new AddressCGVisitor();
        this.value = new ValueCGVisitor();
        this.address.setValue(this.value,out);
        this.value.setAddress(this.address,out);
    }

    @Override
    /**
     * execute[[Program:program->(vardefinition|funcdefinition)*]]= vardefinition*.forEach(vd -> execute[[vd]])
     *                                                              <call> <main>
     *                                                              <halt>
     *                                                              funcdefinition*.forEach(fd->execute[[fd]])
     */
    public Void visit(Program program, ReturnDto unused) {
        for(Definition def :program.programList){
            if(def instanceof VarDefinition){
                def.accept(this, unused);
            }
        }
        cg.pushLine();
        cg.call("main");
        cg.halt();
        cg.pushLine();
        for(Definition def :program.programList){
            if(def instanceof FuncDefinition){
                def.accept(this, unused);
            }
        }
        return null;
    }

    @Override
    /**
     * execute[[VarDefinition:vardefinition->ID type]]= ' * execute[[type]] ID (offset vardefinition.offset)
     */
    public Void visit(VarDefinition varDefinition, ReturnDto unused) {
        cg.pushComment(String.format("%s %s (offset %d)",varDefinition.getType().toCode(),varDefinition.getName(),varDefinition.offset));
        return null;
    }

    @Override
    /**
     * execute[[FuncDefinition:funcdefinition->ID type vardefinition* statement*]]= ID:
     *                                                                                  ' * Parameters
     *                                                                                  vardefinition*.forEach(vd->execute[[vd]])
     *                                                                                  ' * Local variables
     *                                                                                  int parametersSize = vardefinition*.stream().mapToInt(v.getType().numberOfBytes()).sum()
     *                                                                                  int localVarSize = (vardefinition*.get(vardefinition*.size()-1)).offset*-1;
     *                                                                                  <enter> funcdefinition.getType().numberOfBytes()
     *                                                                                  statement*.forEach(st->execute[[st]](localVarSize, parametersSize, funcdefinition.getType().returnType.numberOfBytes()))
     *                                                                                  if (bytesReturn==0)
     *                                                                                      <ret> funcdefinition.getType().returnType.numberOfBytes(),localVarSize,parametersSize
     */
    public Void visit(FuncDefinition funcDefinition, ReturnDto unused) {
        cg.pushLineDelimiter(funcDefinition.getLine());
        cg.pushLine();
        cg.pushLabel(funcDefinition.name);
        cg.pushComment("Parameters");
        int parametersSize=0;
        for(VarDefinition parameter:((FunctionType)funcDefinition.getType()).parameters){
            parameter.accept(this, unused);
            parametersSize+=parameter.getType().numberOfBytes();
        }
        cg.pushComment("Local variables");
        int i=0;
        for(;i<funcDefinition.body.size();i++){
            if(!(funcDefinition.body.get(i) instanceof VarDefinition)){
                break;
            }
            funcDefinition.body.get(i).accept(this, unused);
        }
        int localVarSize = i!=0?((VarDefinition)funcDefinition.body.get(i-1)).offset*-1:0;
        cg.enter(localVarSize);
        cg.pushLine();
        ReturnDto returnInfo=new ReturnDto(parametersSize,localVarSize,((FunctionType) funcDefinition.getType()).returnType.numberOfBytes());
        for(;i<funcDefinition.body.size();i++){
            funcDefinition.body.get(i).accept(this, returnInfo);
        }
        if(returnInfo.bytesReturn==0){
            cg.ret(returnInfo.bytesReturn,returnInfo.bytesLocals,returnInfo.bytesParams);
        }
        cg.pushLine();
        return null;
    }

    @Override
    /**
     * execute[[Assignment:statement->expression1 = expression2]]=  ' * Assignment
     *                                                              address[[expression1]]
     *                                                              value[[expression2]]
     *                                                              if(expression2.getType().getSuffix()!=expression1.getType().getSuffix())
     *                                                                  convertTo(expression2.getType().getSuffix(),expression1.getType().getSuffix());
     *                                                              <store> expression1.getType().getSuffix()
     */
    public Void visit(Assignment assignment, ReturnDto unused) {
        cg.pushLineDelimiter(assignment.getLine());
        cg.pushComment("Assignment");
        assignment.variable.accept(address, null);
        assignment.value.accept(value, null);
        if(assignment.value.getType().getSuffix()!=assignment.variable.getType().getSuffix())
            cg.convert(assignment.value.getType().getSuffix(),assignment.variable.getType().getSuffix());
        cg.store(assignment.variable.getType().getSuffix());
        cg.pushLine();
        return null;
    }

    @Override
    /**
     * execute[[Read:statement->expression*]]=  ' * Read
     *                                          expression*.forEach(e->{address[[e]]
     *                                                                  <in>e.getType().getSuffix()
     *                                                                  <store>e.getType().getSuffix()
     *                                                              })
     */
    public Void visit(Read read, ReturnDto unused) {
        cg.pushLineDelimiter(read.getLine());
        cg.pushComment("Read");
        read.expressions.forEach(e-> {
            e.accept(address, null);
            cg.input(e.getType().getSuffix());
            cg.store(e.getType().getSuffix());
        });
        cg.pushLine();
        return null;
    }

    @Override
    /**
     * execute[[Write:statement->expression*]]= expression*.forEach(e->{
     *                                                                  value[[e]]
     *                                                                  <out>e.getType().getSuffix()
     *                                                              })
     */
    public Void visit(Write write, ReturnDto unused) {
        cg.pushLineDelimiter(write.getLine());
        cg.pushComment("Write");
        write.expressions.forEach(e-> {
            e.accept(value, null);
            cg.output(e.getType().getSuffix());
        });
        cg.pushLine();
        return null;
    }


    @Override
    /**
     * execute[[IfElse:statement->expression statement1* statement2*]]= String elseLabel=cg.nextLabel();
     *                                                                  String end = cg.nextLabel();
     *                                                                  value[[expression]]
     *                                                                  <jz> elseLabel
     *                                                                  statement1*.forEach(st->execute[[st]]);
     *                                                                  <jmp> end
     *                                                                  elseLabel <:>
     *                                                                  statement2*.forEach(st->execute[[st]]);
     *                                                                  end <:>
     */
    public Void visit(IfElse ifElse, ReturnDto unused) {
        cg.pushComment("If");
        String elseLabel = cg.nextLabel();
        String end = cg.nextLabel();
        ifElse.condition.accept(value, null);
        cg.jumpZero(elseLabel);
        cg.pushComment("if body");
        ifElse.ifBody.forEach(st->st.accept(this, unused));
        cg.jump(end);
        cg.pushLabel(elseLabel);
        cg.pushComment("else body");
        ifElse.elseBody.forEach(st->st.accept(this, unused));
        cg.pushLabel(end);
        cg.pushLine();
        return null;
    }

    @Override
    /**
     * execute[[While:statement->expression statement*]]=String beginWhile = cg.nextLabel();
     *                                                  String end = cg.nextLabel();
     *                                                  beginWhile <:>
     *                                                  value[[expression]]
     *                                                  <jz> end
     *                                                  statement*.forEach(st->execute[[st]]);
     *                                                  <jmp> beginWhile
     *                                                  end <:>
     */
    public Void visit(While while_, ReturnDto unused) {
        cg.pushLineDelimiter(while_.getLine());
        cg.pushComment("While");
        cg.pushLine();
        String beginWhile = cg.nextLabel();
        String end = cg.nextLabel();
        cg.pushLabel(beginWhile);
        while_.condition.accept(value, null);
        cg.jumpZero(end);
        cg.pushComment("While body");
        while_.body.forEach(st->st.accept(this, unused));
        cg.jump(beginWhile);
        cg.pushLabel(end);
        cg.pushLine();
        return null;
    }

    @Override
    /**
     * execute[[Invocation:statement->ID expression*]]= value[[statement]]
     *                                                  if(!(((Expression)statement).getType() instanceof VoidType))
     *                                                      <pop>((Expression)statement).getType().getSuffix()
     */
    public Void visit(Invocation invocation, ReturnDto unused) {
        cg.pushLineDelimiter(invocation.getLine());
        invocation.accept(value, null);
        if(!(invocation.getType() instanceof VoidType)){
            cg.pop(invocation.getType().getSuffix());
        }
        cg.pushLine();
        return null;
    }

    @Override
    /**
     * execute[[Return:statement->expression]](int bytesLocals,int bytesParams, int bytesReturn)= value[[expression]]
     *                                                                                            <ret> bytesReturn , bytesLocals , bytesParams
     */
    public Void visit(Return return_, ReturnDto returnDto) {
        cg.pushLineDelimiter(return_.getLine());
        cg.pushComment("Return");
        return_.expression.accept(value, null);
        cg.ret(returnDto.bytesReturn,returnDto.bytesLocals,returnDto.bytesParams);
        return null;
    }
    public class ReturnDto{
        public int bytesLocals;
        public int bytesParams;
        public int bytesReturn;
        public ReturnDto(int bytesParams,int bytesLocals, int bytesReturn){
            this.bytesParams=bytesParams;
            this.bytesLocals=bytesLocals;
            this.bytesReturn=bytesReturn;
        }
    }
}


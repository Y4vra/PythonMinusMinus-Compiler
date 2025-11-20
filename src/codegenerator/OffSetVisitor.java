package codegenerator;

import ast.Definition;
import ast.Program;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.Field;
import ast.types.FunctionType;
import ast.types.StructType;
import visitor.VisitorImpl;

public class OffSetVisitor extends VisitorImpl<Void,Void> {
    private int globalBytesSum;
    private int localBytesSum;
    @Override
    public Void visit(Program program, Void tp) {
        globalBytesSum=0;
        for(Definition d :program.programList) {
            d.accept(this, tp);
        }
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Void tp) {
        varDefinition.type.accept(this, tp);
        if(varDefinition.getScope()>0){
            varDefinition.offset=localBytesSum-varDefinition.getType().numberOfBytes();
            localBytesSum= varDefinition.offset;
        }else{
            varDefinition.offset=globalBytesSum;
            globalBytesSum= globalBytesSum+varDefinition.getType().numberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void tp) {
        funcDefinition.type.accept(this, tp);
        localBytesSum=0;
        for(Statement t :funcDefinition.body){
            t.accept(this, tp);
        }
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void tp) {
        functionType.returnType.accept(this, tp);
        int offset=4;
        for(int i=functionType.parameters.size()-1;i>=0;i--) {
            VarDefinition varDefinition = functionType.parameters.get(i);
            varDefinition.offset=offset;
            offset= offset+varDefinition.getType().numberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(StructType structType, Void tp) {
        int offset=0;
        for(Field f :structType.fields){
            f.accept(this, tp);
            f.offset=offset;
            offset+=f.type.numberOfBytes();
        }
        return null;
    }

}

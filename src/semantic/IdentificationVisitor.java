package semantic;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.statements.IfElse;
import ast.statements.While;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.VisitorImpl;

public class IdentificationVisitor extends VisitorImpl<Void,Void> {
    private final SymbolTable st = new SymbolTable();
    @Override
    public Void visit(VarDefinition varDefinition, Void tp) {
        if(!st.insert(varDefinition)){
            new ErrorType("Duplicate variable definition: "+varDefinition.name,varDefinition);
        }
        super.visit(varDefinition, tp);
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void tp) {
        if(!st.insert(funcDefinition)){
            new ErrorType("Duplicate function definition: "+funcDefinition.name,funcDefinition);
        }
        st.set();
        super.visit(funcDefinition, tp);
        st.reset();
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void tp) {
        st.set();
        super.visit(ifElse, tp);
        st.reset();
        return null;
    }

    @Override
    public Void visit(While while_, Void tp) {
        st.set();
        super.visit(while_, tp);
        st.reset();
        return null;
    }

    @Override
    public Void visit(Variable variable, Void tp) {
        variable.definition=st.find(variable.name);
        if(variable.definition==null){
            variable.definition=new VarDefinition(variable.getLine(), variable.getColumn(), variable.name,new ErrorType("Invalid undefined variable: "+variable.name,variable));
        }
        super.visit(variable, tp);
        return null;
    }
}

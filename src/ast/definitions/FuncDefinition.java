package ast.definitions;

import ast.DefinitionImpl;
import ast.Statement;
import ast.types.FunctionType;
import ast.types.VoidType;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends DefinitionImpl {
    public List<Statement> body;

    public FuncDefinition(int line, int column,String funcName, FunctionType functionType, List<Statement> body) {
        super(line, column,funcName,functionType);
        this.body=body;
    }

    public FuncDefinition(int line, int column, List<Statement> body) {
        this(line,column,"main",new FunctionType(VoidType.getInstance(),new ArrayList<>()),body);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FuncDefinition{")
        .append(", statBody=").append(body)
        .append(", name='").append(name).append('\'')
        .append(", type=").append(type)
        .append(", line=").append(line)
        .append(", column=").append(column)
        .append('}');
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

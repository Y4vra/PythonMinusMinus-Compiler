package ast.definitions;


import ast.DefinitionImpl;
import ast.Statement;
import ast.Type;
import visitor.Visitor;


public class VarDefinition extends DefinitionImpl implements Statement {

    public int offset;

    public VarDefinition(int line, int column, String identifier, Type type) {
        super(line, column,identifier,type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VarDefinition{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", line=").append(line);
        sb.append(", column=").append(column);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (obj.getClass() != this.getClass()) return false;
        return name.equals(((VarDefinition)obj).name);
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

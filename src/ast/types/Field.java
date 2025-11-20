package ast.types;

import ast.LocatableImpl;
import ast.Type;
import ast.definitions.VarDefinition;
import visitor.Visitor;

public class Field extends LocatableImpl {
    public String name;
    public Type type;
    public int offset;

    public Field(int line, int column,String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Field{");
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
        return name.equals(((Field)obj).name);
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

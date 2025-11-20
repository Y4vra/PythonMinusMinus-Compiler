package ast.expressions;

import ast.Expression;
import ast.ExpressionImpl;
import visitor.Visitor;

public class ArrayAccess extends ExpressionImpl {
    public Expression array;
    public Expression index;

    public ArrayAccess(int line, int column, Expression array, Expression index) {
        super(line, column);
        this.array = array;
        this.index = index;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayAccess{");
        sb.append("array=").append(array);
        sb.append(", index=").append(index);
        sb.append(", line=").append(line);
        sb.append(", column=").append(column);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

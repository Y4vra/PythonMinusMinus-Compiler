package ast.expressions;

import ast.Expression;
import ast.ExpressionImpl;
import visitor.Visitor;

public class StructAccess extends ExpressionImpl {
    public String accessed;
    public Expression expression;

    public StructAccess(int line, int column, Expression expression, String accessed) {
        super(line, column);
        this.accessed = accessed;
        this.expression = expression;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StructAccess{");
        sb.append("accessed='").append(accessed).append('\'');
        sb.append(", expression=").append(expression);
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
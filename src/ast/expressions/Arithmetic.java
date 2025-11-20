package ast.expressions;

import ast.Expression;
import ast.ExpressionImpl;
import visitor.Visitor;

public class Arithmetic extends ExpressionImpl {
    public String operator;
    public Expression left;
    public Expression right;

    public Arithmetic(int line, int column, String operator, Expression left, Expression right) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Arithmetic{");
        sb.append("line=").append(line);
        sb.append(", column=").append(column);
        sb.append(", operator='").append(operator).append('\'');
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

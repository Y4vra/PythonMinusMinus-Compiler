package ast.expressions;

import ast.Expression;
import ast.ExpressionImpl;
import visitor.Visitor;

public class UnaryMinus extends ExpressionImpl {
    public Expression negativeExpression;

    public UnaryMinus(int line, int column, Expression negativeExpression) {
        super(line, column);
        this.negativeExpression = negativeExpression;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UnaryMinus{");
        sb.append("negativeExpression=").append(negativeExpression);
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

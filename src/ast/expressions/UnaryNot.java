package ast.expressions;

import ast.Expression;
import ast.ExpressionImpl;
import visitor.Visitor;

public class UnaryNot extends ExpressionImpl {
    public Expression negatedExpression;

    public UnaryNot(int line, int column, Expression negatedExpression) {
        super(line, column);
        this.negatedExpression = negatedExpression;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UnaryNot{");
        sb.append("negatedExpression=").append(negatedExpression);
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

package ast.expressions;

import ast.Expression;
import ast.ExpressionImpl;
import ast.Type;
import visitor.Visitor;

public class Cast extends ExpressionImpl {
    public Expression castedExpression;
    public Type typeCastedTo;

    public Cast(int line, int column, Type typeCastedTo,Expression castedExpression) {
        super(line, column);
        this.castedExpression = castedExpression;
        this.typeCastedTo = typeCastedTo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cast{");
        sb.append("castedExpression=").append(castedExpression);
        sb.append(", type=").append(typeCastedTo);
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

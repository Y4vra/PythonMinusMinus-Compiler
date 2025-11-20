package ast.expressions;

import ast.ExpressionImpl;
import visitor.Visitor;

public class CharLiteral extends ExpressionImpl {
    public char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CharLiteral{");
        sb.append("value=").append(value);
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

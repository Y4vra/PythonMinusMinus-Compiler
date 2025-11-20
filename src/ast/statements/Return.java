package ast.statements;

import ast.Expression;
import ast.LocatableImpl;
import ast.Statement;
import visitor.Visitor;

public class Return extends LocatableImpl implements Statement {
    public Expression expression;

    public Return(int line, int column,Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Return{");
        sb.append("expression=").append(expression);
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

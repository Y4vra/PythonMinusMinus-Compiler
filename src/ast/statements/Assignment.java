package ast.statements;

import ast.Expression;
import ast.LocatableImpl;
import ast.Statement;
import visitor.Visitor;

public class Assignment extends LocatableImpl implements Statement {
    public Expression variable;
    public Expression value;

    public Assignment(int line, int column,Expression variable,Expression asigned) {
        super(line, column);
        this.variable = variable;
        this.value = asigned;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Assignment{");
        sb.append("variable=").append(variable);
        sb.append(", asigned=").append(value);
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

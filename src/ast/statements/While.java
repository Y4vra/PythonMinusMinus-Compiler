package ast.statements;

import ast.Expression;
import ast.LocatableImpl;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class While extends LocatableImpl implements Statement {
    public List<Statement> body;
    public Expression condition;

    public While(int line, int column,Expression condition, List<Statement> body) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("While{");
        sb.append("body=").append(body);
        sb.append(", condition=").append(condition);
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

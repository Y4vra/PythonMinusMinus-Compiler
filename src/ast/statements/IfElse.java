package ast.statements;

import ast.Expression;
import ast.LocatableImpl;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class IfElse extends LocatableImpl implements Statement {
    public List<Statement> ifBody;
    public List<Statement> elseBody;
    public Expression condition;


    public IfElse(int line, int column, Expression condition,List<Statement> ifBody,List<Statement> elseBody) {
        super(line,column);
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IfElse{");
        sb.append("ifBody=").append(ifBody);
        sb.append(", elseBody=").append(elseBody);
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

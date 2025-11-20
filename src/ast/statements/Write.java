package ast.statements;

import ast.Expression;
import ast.ExpressionImpl;
import ast.LocatableImpl;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class Write extends LocatableImpl implements Statement {
    public List<Expression> expressions;

    public Write(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Write{");
        sb.append("expressions=").append(expressions);
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

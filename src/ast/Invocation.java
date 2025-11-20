package ast;

import ast.expressions.Variable;
import visitor.Visitor;

import java.util.List;
import java.util.stream.Collectors;

public class Invocation extends ExpressionImpl implements Statement {
    public Variable functionVar;
    public List<Expression> parameters;

    public Invocation(int line, int column,Variable functionName, List<Expression> parameters) {
        super(line, column);
        this.functionVar = functionName;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invocation{");
        sb.append("functionName='").append(functionVar).append('\'');
        sb.append(", parameters=").append(parameters);
        sb.append(", line=").append(line);
        sb.append(", column=").append(column);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    public List<Type> getParameterTypes() {
        return parameters.stream().map(Expression::getType).collect(Collectors.toList());
    }
}

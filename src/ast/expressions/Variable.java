package ast.expressions;


import ast.Definition;
import ast.ExpressionImpl;
import visitor.Visitor;

public class Variable extends ExpressionImpl {
    public String name;
    public Definition definition;

    public Variable(int line, int column,String name) {
        super(line, column);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Variable{" + "name='" + name + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

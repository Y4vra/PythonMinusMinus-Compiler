package ast;

public abstract class ExpressionImpl extends LocatableImpl implements Expression {

    private boolean lvalue;
    private Type type;

    public ExpressionImpl(int line, int column) {
        super(line, column);
    }
    public boolean getLvalue(){return lvalue;}
    public void setLvalue(boolean lvalue){this.lvalue = lvalue;}
    public Type getType(){return type;}
    public void setType(Type type){this.type = type;}
}

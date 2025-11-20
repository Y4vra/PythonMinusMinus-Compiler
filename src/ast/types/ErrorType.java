package ast.types;

import ast.Locatable;
import ast.Type;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends TypeImpl {

    private final String message;
    private final Locatable location;

    public ErrorType(String message, Locatable locatable) {
        this.message = message;
        this.location = locatable;
        ErrorHandler.getInstance().addError(this);
    }

    public int getLine() {
        return location.getLine();
    }
    public int getColumn() {
        return location.getColumn();
    }

    @Override
    public String toString() {
        return message +" at line and column: "+ location.getLine() + ", " + location.getColumn();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public Type dot(String field, Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable locatable) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, Locatable locatable) {
        return this;
    }
}

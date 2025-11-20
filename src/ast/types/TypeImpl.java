package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public abstract class TypeImpl implements Type {
    @Override
    public Type arithmetic(Locatable locatable) {
        return new ErrorType("Illegal type on unary arithmetic operation", locatable);
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }else {
            return new ErrorType("Illegal types on arithmetic operation with " + type.toString(), locatable);
        }
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }else {
            return new ErrorType("Illegal types on comparison with "+type.toString(), locatable);
        }
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }else {
            return new ErrorType("Cannot cast selected type into "+type.toString(), locatable);
        }
    }

    @Override
    public Type dot(String field, Locatable locatable) {
        return new ErrorType("Cannot access field "+field+" of non field-bearing type", locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return new ErrorType("Illegal type on unary logical operation", locatable);
    }

    @Override
    public Type logic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }else {
            return new ErrorType("Illegal type on logical operation with " + type.toString(), locatable);
        }
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
        new ErrorType("Type is not built in", locatable);
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
        new ErrorType("Illegal type used where a logical one was expected", locatable);
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof ErrorType)){
            new ErrorType("This type cannot promote to "+type.toString(), locatable);
        }
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable locatable) {
        for(Type type : types){
            if(type instanceof ErrorType){
                return type;
            }
        }
        return new ErrorType("This type does not accept parameters", locatable);
    }

    @Override
    public Type squareBrackets(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }else {
            return new ErrorType("Cannot access index of non indexed type", locatable);
        }
    }

    @Override
    public int numberOfBytes() {
        throw new IllegalStateException("Cannot call number of bytes on type without byte size");
    }

    @Override
    public char getSuffix() {
        throw new IllegalStateException("Cannot call getSuffix on type without suffix");
    }

    @Override
    public String toCode() {
        throw new IllegalStateException("No string found for code representation of this type");
    }
}

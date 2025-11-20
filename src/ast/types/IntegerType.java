package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class IntegerType extends TypeImpl {
    private static IntegerType instance;
    private IntegerType(){}
    public static IntegerType getInstance(){
        if(instance == null){
            instance = new IntegerType();
        }
        return instance;
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public String toString() {
        return "IntegerType";
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        if(type instanceof CharacterType){
            return this;
        }
        if(type instanceof IntegerType){
            return this;
        }
        if(type instanceof DoubleType){
            return DoubleType.getInstance();
        }
        return new ErrorType("Cannot perform arithmetic operation between integer and "+type.toString(),locatable);
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        }else if(type instanceof IntegerType){
            return IntegerType.getInstance();
        }
        return new ErrorType("Cannot perform comparison between integer and "+type.toString(),locatable);
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        if(type instanceof IntegerType){
            return this;
        }
        if(type instanceof DoubleType){
            return type;
        }
        if(type instanceof CharacterType){
            return type;
        }
        return new ErrorType("Cannot cast integer to "+type.toString(),locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Type type, Locatable locatable) {
        type.mustBeLogical(locatable);
        return this;
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {}

    @Override
    public void mustBeLogical(Locatable locatable) {}

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof ErrorType||type instanceof IntegerType||type instanceof DoubleType)){
            new ErrorType("Cannot promote integer to "+type.toString(),locatable);
        }
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public char getSuffix() {
        return 'i';
    }

    @Override
    public String toCode() {
        return "IntType";
    }
}

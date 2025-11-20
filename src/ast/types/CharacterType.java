package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class CharacterType extends TypeImpl {
    private static CharacterType instance;
    private CharacterType(){}
    public static CharacterType getInstance(){
        if(instance == null){
            instance = new CharacterType();
        }
        return instance;
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public String toString() {
        return "CharacterType";
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        if(type instanceof DoubleType){
            return DoubleType.getInstance();
        }
        if(type instanceof IntegerType){
            return IntegerType.getInstance();
        }
        if(type instanceof CharacterType){
            return IntegerType.getInstance();
        }
        return new ErrorType("Cannot perform arithmetic operation between character and "+type.toString(),locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return IntegerType.getInstance();
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        if(type instanceof IntegerType){
            return type;
        }
        if(type instanceof DoubleType){
            return type;
        }
        if(type.equals(this)){
            return this;
        }
        return new ErrorType("Cannot cast character to "+type.toString(),locatable);
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {}

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return;
        }
        if(!(type instanceof IntegerType || type instanceof DoubleType || type instanceof CharacterType)){
            new ErrorType("Cannot promote character type to "+type.toString(), locatable);
        }
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        }else if(type instanceof CharacterType){
            return IntegerType.getInstance();
        }
        return new ErrorType("Cannot perform comparison between character and "+type.toString(),locatable);
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public char getSuffix() {
        return 'b';
    }

    @Override
    public String toCode() {
        return "CharType";
    }
}

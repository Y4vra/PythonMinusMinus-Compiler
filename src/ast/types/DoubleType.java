package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends TypeImpl {

    private static DoubleType instance;
    private DoubleType(){}
    public static DoubleType getInstance(){
        if(instance == null){
            instance = new DoubleType();
        }
        return instance;
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public String toString() {
        return "DoubleType";
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        type.mustPromoteTo(this,locatable);
        return this;
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        if(!(type instanceof DoubleType || type instanceof CharacterType || type instanceof IntegerType)){
            return new ErrorType("Cannot cast double to "+type.toString(),locatable);
        }
        return type;
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {}

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof ErrorType||type instanceof DoubleType)){
            new ErrorType("Cannot promote double to "+type.toString(),locatable);
        }
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        }else if(type instanceof DoubleType){
            return IntegerType.getInstance();
        }
        return new ErrorType("Cannot perform comparison between double and "+type.toString(),locatable);
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public char getSuffix() {
        return 'f';
    }

    @Override
    public String toCode() {
        return "RealType";
    }
}

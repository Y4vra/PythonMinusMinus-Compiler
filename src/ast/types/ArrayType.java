package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class ArrayType extends TypeImpl {
    public int size;
    public Type of;

    public ArrayType(int size, Type of) {
        this.size = size;
        this.of = of;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayType{");
        sb.append("size=").append(size);
        sb.append(", of=").append(of);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public Type squareBrackets(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        if(!(type instanceof IntegerType)){
            new ErrorType("Error accessing non-integer index",locatable);
        }
        return of;
    }

    @Override
    public int numberOfBytes() {
        return of.numberOfBytes()*size;
    }

    @Override
    public String toCode() {
        return String.format("ArrayType[of:%s,size:%d]",of.toCode(),size);
    }
}

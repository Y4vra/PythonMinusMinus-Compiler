package ast.types;

import visitor.Visitor;

public class VoidType extends TypeImpl {
    private static VoidType instance;
    private VoidType() {}
    public static VoidType getInstance() {
        if(instance==null){
            instance = new VoidType();
        }
        return instance;
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public String toString() {
        return "VoidType";
    }

    @Override
    public String toCode() {
        return "None";
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }
}

package ast.types;

import ast.Locatable;
import ast.Type;
import ast.definitions.VarDefinition;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends TypeImpl {
    public Type returnType;
    public List<VarDefinition> parameters;

    public FunctionType(Type returnType, List<VarDefinition> parameters) {
        this.returnType = returnType;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FunctionType{");
        sb.append("returnType=").append(returnType);
        sb.append(", parameters=(");
        parameters.forEach(p -> sb.append(p.getType().toString()).append(" "));
        sb.append(")}");
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable locatable) {
        if (types.size() != parameters.size()){
            return new ErrorType("Invalid number of parameters",locatable);
        }
        for(int i = 0; i < types.size(); i++){
            types.get(i).mustBeBuiltIn(locatable);
            types.get(i).mustPromoteTo(parameters.get(i).getType(),locatable);
        }
        return returnType;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }
}

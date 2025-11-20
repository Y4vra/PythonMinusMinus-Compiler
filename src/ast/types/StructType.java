package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

import java.util.List;
import java.util.stream.Collectors;

public class StructType extends TypeImpl {
    public List<Field> fields;

    public StructType(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StructType{");
        sb.append("fields=(");
        fields.forEach(field -> sb.append(field.name).append(":").append(field.type.toString()).append(" "));
        sb.append(")}");
        return sb.toString();
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }

    @Override
    public Type dot(String field, Locatable locatable) {
        for(Field f : fields) {
            if(f.name.equals(field)) {
                return f.type;
            }
        }
        return new ErrorType("Cannot access non-existent field "+field,locatable);
    }

    @Override
    public int numberOfBytes() {
        return fields.stream().mapToInt(x -> x.type.numberOfBytes()).sum();
    }
    public Field getField(String name) {
        return fields.stream().filter(x -> x.name.equals(name)).findFirst().orElse(null);
    }

    @Override
    public String toCode() {
        StringBuilder sb = new StringBuilder().append("RecordType[fields:[");
        sb.append(fields.stream().map(field -> "Field[name:" + field.name
                        + ",type:" + field.type.toCode()
                        + " offset:" + field.offset + "]")
                .collect(Collectors.joining(", ")));
        sb.append("]]");
        return sb.toString();
    }
}

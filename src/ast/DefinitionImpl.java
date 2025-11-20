package ast;

public abstract class DefinitionImpl extends LocatableImpl implements Definition {
    public String name;
    public Type type;
    public int scope;

    public DefinitionImpl(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DefinitionImpl{" + "name='" + name + '\'' +
                ", type=" + type +
                ", line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int getScope() {
        return scope;
    }

}

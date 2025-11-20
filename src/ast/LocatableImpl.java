package ast;

public abstract class LocatableImpl implements Locatable {

    public int line;
    public int column;

    public LocatableImpl(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocatableImpl{");
        sb.append("line=").append(line);
        sb.append(", column=").append(column);
        sb.append('}');
        return sb.toString();
    }
}

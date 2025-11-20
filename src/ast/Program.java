package ast;

import visitor.Visitor;

import java.util.List;

public class Program implements ASTNode{
    public List<Definition> programList;
    public Program(List<Definition> program, Definition main) {
        this.programList = program;
        this.programList.add(main);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Program{");
        sb.append("program=").append(programList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this,p);
    }
}

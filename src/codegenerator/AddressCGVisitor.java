package codegenerator;

import ast.definitions.VarDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.StructAccess;
import ast.expressions.Variable;
import ast.types.ArrayType;
import ast.types.StructType;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {
    private ValueCGVisitor value;
    private CodeGenerator cg;

    public void setValue(ValueCGVisitor value, CodeGenerator out) {
        this.value = value;
        this.cg = out;
    }

    @Override
    /**
     * address[[Variable:expression1->ID]]= if(expression1.definition.getScope()>=0){
     *                                          <push> <bp>
     *                                          <pushi> expression1.definition.offset
     *                                          <addi>
     *                                      }else{
     *                                          <pusha> variable.definition.offset
     *                                      }
     */
    public Void visit(Variable variable, Void unused) {
        if(variable.definition.getScope()>0){
            cg.pushBP();
            cg.push(((VarDefinition)variable.definition).offset);
            cg.arithmetic("+",'i');//addi
        }else{
            cg.pushAddress(((VarDefinition)variable.definition).offset);
        }
        return null;
    }

    @Override
    /**
     * address[[ArrayAccess:expression1->expression2 expression3]]= address[[expression2]]
     *                                                              value[[expression3]]
     *                                                              <pushi> expression2.getType().of.numberOfBytes();
     *                                                              <muli>
     *                                                              <addi>
     */
    public Void visit(ArrayAccess arrayAccess, Void unused) {
        arrayAccess.array.accept(this, unused);
        arrayAccess.index.accept(value, unused);
        cg.push(((ArrayType)arrayAccess.array.getType()).of.numberOfBytes());
        cg.arithmetic("*",arrayAccess.index.getType().getSuffix());
        cg.arithmetic("+",arrayAccess.index.getType().getSuffix());
        return null;
    }

    @Override
    /**
     * address[[StructAccess:expression1->expression2 ID]]= address[[expression2]]
     *                                                      <pushi> expression2.getField(ID).offset
     *                                                      <addi>
     */
    public Void visit(StructAccess structAccess, Void unused) {
        structAccess.expression.accept(this, unused);
        cg.push(((StructType)structAccess.expression.getType()).getField(structAccess.accessed).offset);
        cg.arithmetic("+",'i');
        return null;
    }

}

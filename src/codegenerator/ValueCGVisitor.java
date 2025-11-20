package codegenerator;

import ast.Invocation;
import ast.expressions.*;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void>{
    private AddressCGVisitor address;
    private CodeGenerator cg;

    public void setAddress(AddressCGVisitor address,CodeGenerator out) {
        this.address = address;
        this.cg =out;
    }

    @Override
    /**
     * value[[IntLiteral:expression1->INT_CONSTANT]]= pushi INT_CONSTANT
     */
    public Void visit(IntLiteral intLiteral, Void unused) {
        cg.push(intLiteral.value);
        return null;
    }

    @Override
    /**
     * value[[DoubleLiteral:expression1->DOUBLE_CONSTANT]]= pushf DOUBLE_CONSTANT
     */
    public Void visit(DoubleLiteral doubleLiteral, Void unused) {
        cg.push(doubleLiteral.value);
        return null;
    }

    @Override
    /**
     * value[[CharLiteral:expression1->CHAR_CONSTANT]]= pushb INT_CONSTANT
     */
    public Void visit(CharLiteral charLiteral, Void unused) {
        cg.push(charLiteral.value);
        return null;
    }

    @Override
    /**
     * value[[Variable:expression1->ID]]=   address[[expression1]]
     *                                      <load>expression1.getType().getSuffix()
     */
    public Void visit(Variable variable, Void unused) {
        variable.accept(address,unused);
        cg.load(variable.definition.getType().getSuffix());
        return null;
    }

    @Override
    /**
     * value[[Arithmetic:expression1->e2=expression2 op=(+|-|*|/) e3=expression3]]=value[[e2]]
     *                                                                      if(e2.getType().getSuffix()!=expression1.getType().getSuffix())
     *                                                                          convertTo(e2.getType().getSuffix(),expression1.getType().getSuffix())
     *                                                                      value[[e3]]
     *                                                                      if(e3.getType().getSuffix()!=expression1.getType().getSuffix())
     *                                                                          convertTo(e3.getType().getSuffix(),expression1.getType().getSuffix())
     *                                                                      switch(op){
     *                                                                          "+": <add>expression1.getType().getSuffix(); break;
     *                                                                          "-": <sub>expression1.getType().getSuffix(); break;
     *                                                                          "*": <mul>expression1.getType().getSuffix(); break;
     *                                                                          "/": <div>expression1.getType().getSuffix(); break;
     *                                                                          "%": <mod>expression1.getType().getSuffix(); break;
     *                                                                      }
     */
    public Void visit(Arithmetic arithmetic, Void unused) {
        char endSuffix=arithmetic.getType().getSuffix();
        arithmetic.left.accept(this,unused);
        if(arithmetic.left.getType().getSuffix()!=endSuffix){
            cg.convert(arithmetic.left.getType().getSuffix(),endSuffix);
        }
        arithmetic.right.accept(this,unused);
        if(arithmetic.right.getType().getSuffix()!=endSuffix){
            cg.convert(arithmetic.right.getType().getSuffix(),endSuffix);
        }
        cg.arithmetic(arithmetic.operator,endSuffix);
        return null;
    }

    @Override
    /**
     * value[[Comparison:expression1->e2=expression2 (>|>=|<|<=|!=|==) e3=expression3]]=value[[e2]]
     *                                                                          if(e2.getType().getSuffix()!=expression1.getType().getSuffix())
     *                                                                              convertTo(e2.getType().getSuffix(),expression1.getType().getSuffix())
     *                                                                          value[[e3]]
     *                                                                          if(e3.getType().getSuffix()!=expression1.getType().getSuffix())
     *                                                                              convertTo(e3.getType().getSuffix(),expression1.getType().getSuffix())
     *                                                                          switch(op){
     *                                                                              ">":    <gt>expression1.getType().getSuffix(); break;
     *                                                                              ">=":   <ge>expression1.getType().getSuffix(); break;
     *                                                                              "<":    <lt>expression1.getType().getSuffix(); break;
     *                                                                              "<=":   <le>expression1.getType().getSuffix(); break;
     *                                                                              "!=":   <ne>expression1.getType().getSuffix(); break;
     *                                                                              "==":   <eq>expression1.getType().getSuffix(); break;
     *                                                                          }
     */
    public Void visit(Comparison comparison, Void unused) {
        char endSuffix=comparison.getType().getSuffix();
        comparison.left.accept(this,unused);
        if(comparison.left.getType().getSuffix()=='b'){
            cg.convert(comparison.left.getType().getSuffix(),'i');
        }
        comparison.right.accept(this,unused);
        if(comparison.right.getType().getSuffix()=='b'){
            cg.convert(comparison.right.getType().getSuffix(),'i');
        }
        cg.comparison(comparison.operator,endSuffix);
        return null;
    }

    @Override
    /**
     * value[[Logical:expression1->expression2 op=(&&|||) expression3]]= value[[expression2]]
     *                                                              value[[expression3]]
     *                                                              if(op.equals("&&")){
     *                                                                  <and>
     *                                                              }else if(op.equals("||")){
     *                                                                  <or>
     *                                                              }
     */
    public Void visit(Logical logical, Void unused) {
        logical.left.accept(this,unused);
        logical.right.accept(this,unused);
        if(logical.operator.equals("&&")){
            cg.and();
        }else if(logical.operator.equals("||")){
            cg.or();
        }else{
            throw new IllegalStateException("Illegal operator on logical expression");
        }
        return null;
    }

    @Override
    /**
     * value[[UnaryMinus:expression1->expression2]]= value[[expression2]]
     *                                              if(expression2.getType().getSuffix()=='b' || expression2.getType().getSuffix()=='i')
     *                                                  <muli> -1
     *                                              else if(expression2.getType().getSuffix()=='f')
     *                                                  <mulf> -1
     */
    public Void visit(UnaryMinus unaryMinus, Void unused) {
        unaryMinus.negativeExpression.accept(this,unused);
        char endSuffix=unaryMinus.getType().getSuffix();
        if(unaryMinus.negativeExpression.getType().getSuffix()!=endSuffix){
            cg.convert(unaryMinus.negativeExpression.getType().getSuffix(),endSuffix);
        }
        cg.push(endSuffix=='i'?-1:-1.0);
        cg.arithmetic("*",endSuffix);
        return null;
    }

    @Override
    /**
     * value[[UnaryNot:expression1->expression2]]=  value[[expression2]]
     *                                              <not>
     */
    public Void visit(UnaryNot unaryNot, Void unused) {
        unaryNot.negatedExpression.accept(this,unused);
        cg.not();
        return null;
    }

    @Override
    /**
     * value[[Cast:expression1->type expression2]]= value[[expression2]]
     *                                              convertTo(expression2.getType().getSuffix(),type.getSuffix())
     */
    public Void visit(Cast cast, Void unused) {
        cast.castedExpression.accept(this,unused);
        cg.convert(cast.castedExpression.getType().getSuffix(),cast.typeCastedTo.getSuffix());
        return null;
    }

    @Override
    /**
     * address[[ArrayAccess:expression1->expression2 expression3]]= address[[expression1]]
     *                                                              <load>expression1.getType().getSuffix()
     */
    public Void visit(ArrayAccess arrayAccess, Void unused) {
        arrayAccess.accept(address,unused);
        cg.load(arrayAccess.getType().getSuffix());
        return null;
    }

    @Override
    /**
     * address[[StructAccess:expression1->expression2 ID]]= address[[expression1]]
     *                                                      <load>expression1.getType().getSuffix()
     */
    public Void visit(StructAccess structAccess, Void unused) {
        structAccess.accept(address,unused);
        cg.load(structAccess.getType().getSuffix());
        return null;
    }

    @Override
    /**
     * value[[Invocation:expression1->expression2 expression3*]]= expression3*.forEach(e->value[[e]]);
     *                                                            <call> expression2.name
     */
    public Void visit(Invocation invocation, Void unused) {
        invocation.parameters.forEach(parameter -> parameter.accept(this,unused));
        cg.call(invocation.functionVar.name);
        return null;
    }
}

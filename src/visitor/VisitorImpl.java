package visitor;

import ast.Invocation;
import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public class VisitorImpl<TP,TR> implements Visitor<TP,TR> {
    @Override
    public TR visit(Program program, TP tp) {
        program.programList.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(Invocation invocation, TP tp) {
        invocation.parameters.forEach(t -> t.accept(this, tp));
        invocation.functionVar.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP tp) {
        funcDefinition.type.accept(this, tp);
        funcDefinition.body.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP tp) {
        varDefinition.type.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP tp) {
        arithmetic.left.accept(this, tp);
        arithmetic.right.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP tp) {
        arrayAccess.array.accept(this,tp);
        arrayAccess.index.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP tp) {
        cast.typeCastedTo.accept(this, tp);
        cast.castedExpression.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP tp) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP tp) {
        comparison.left.accept(this, tp);
        comparison.right.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP tp) {
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP tp) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP tp) {
        logical.left.accept(this, tp);
        logical.right.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(StructAccess structAccess, TP tp) {
        structAccess.expression.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP tp) {
        unaryMinus.negativeExpression.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP tp) {
        unaryNot.negatedExpression.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP tp) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP tp) {
        assignment.value.accept(this, tp);
        assignment.variable.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP tp) {
        ifElse.condition.accept(this, tp);
        ifElse.ifBody.forEach(t -> t.accept(this, tp));
        ifElse.elseBody.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(Read read, TP tp) {
        read.expressions.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(Return return_, TP tp) {
        return_.expression.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(While while_, TP tp) {
        while_.condition.accept(this, tp);
        while_.body.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(Write write, TP tp) {
        write.expressions.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP tp) {
        arrayType.of.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(CharacterType characterType, TP tp) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP tp) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP tp) {
        return null;
    }

    @Override
    public TR visit(Field field, TP tp) {
        field.type.accept(this, tp);
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP tp) {
        functionType.returnType.accept(this, tp);
        functionType.parameters.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(IntegerType integerType, TP tp) {
        return null;
    }

    @Override
    public TR visit(StructType structType, TP tp) {
        structType.fields.forEach(t -> t.accept(this, tp));
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP tp) {
        return null;
    }
}

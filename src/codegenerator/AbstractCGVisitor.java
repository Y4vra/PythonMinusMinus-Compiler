package codegenerator;

import ast.Invocation;
import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public abstract class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {
    @Override
    public TR visit(Program program, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Invocation invocation, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Cast cast, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Comparison comparison, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Logical logical, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(StructAccess structAccess, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Variable variable, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Assignment assignment, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(IfElse ifElse, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Read read, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Return return_, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(While while_, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Write write, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(ArrayType arrayType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(CharacterType characterType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(DoubleType doubleType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(ErrorType errorType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(Field field, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(FunctionType functionType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(IntegerType integerType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(StructType structType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }

    @Override
    public TR visit(VoidType voidType, TP unused) {
        throw new IllegalStateException("Cannot visit non existent code template function");
    }
}

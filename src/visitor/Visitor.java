package visitor;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.util.function.Function;

public interface Visitor<TP,TR>{
    public TR visit(Program program, TP tp);
    public TR visit(Invocation invocation, TP tp);

    public TR visit(FuncDefinition funcDefinition, TP tp);
    public TR visit(VarDefinition varDefinition, TP tp);

    public TR visit(Arithmetic arithmetic, TP tp);
    public TR visit(ArrayAccess arrayAccess, TP tp);
    public TR visit(Cast cast, TP tp);
    public TR visit(CharLiteral charLiteral, TP tp);
    public TR visit(Comparison comparison, TP tp);
    public TR visit(DoubleLiteral doubleLiteral, TP tp);
    public TR visit(IntLiteral intLiteral, TP tp);
    public TR visit(Logical logical, TP tp);
    public TR visit(StructAccess structAccess, TP tp);
    public TR visit(UnaryMinus unaryMinus, TP tp);
    public TR visit(UnaryNot unaryNot, TP tp);
    public TR visit(Variable variable, TP tp);

    public TR visit(Assignment assignment, TP tp);
    public TR visit(IfElse ifElse, TP tp);
    public TR visit(Read read, TP tp);
    public TR visit(Return return_, TP tp);
    public TR visit(While while_, TP tp);
    public TR visit(Write write, TP tp);

    public TR visit(ArrayType arrayType, TP tp);
    public TR visit(CharacterType characterType, TP tp);
    public TR visit(DoubleType doubleType, TP tp);
    public TR visit(ErrorType errorType, TP tp);
    public TR visit(Field field, TP tp);
    public TR visit(FunctionType functionType, TP tp);
    public TR visit(IntegerType integerType, TP tp);
    public TR visit(StructType structType, TP tp);
    public TR visit(VoidType voidType, TP tp);
}

package semantic;

import ast.Expression;
import ast.Invocation;
import ast.Type;
import ast.definitions.FuncDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.VisitorImpl;

public class TypeCheckingVisitor extends VisitorImpl<Type, Boolean> {

    @Override
    public Boolean visit(Arithmetic arithmetic, Type tp) {
        arithmetic.setLvalue(false);
        arithmetic.left.accept(this, tp);
        arithmetic.right.accept(this, tp);
        arithmetic.setType(arithmetic.left.getType().arithmetic(arithmetic.right.getType(), arithmetic));
        return null;
    }

    @Override
    public Boolean visit(ArrayAccess arrayAccess, Type tp) {
        arrayAccess.setLvalue(true);
        arrayAccess.array.accept(this, tp);
        arrayAccess.index.accept(this, tp);
        arrayAccess.setType(arrayAccess.array.getType().squareBrackets(arrayAccess.index.getType(),arrayAccess));
        return null;
    }

    @Override
    public Boolean visit(Cast cast, Type tp) {
        cast.setLvalue(false);
        cast.typeCastedTo.accept(this, tp);
        cast.castedExpression.accept(this, tp);
        cast.setType(cast.castedExpression.getType().canBeCastTo(cast.typeCastedTo,cast));
        return null;
    }

    @Override
    public Boolean visit(CharLiteral charLiteral, Type tp) {
        charLiteral.setLvalue(false);
        charLiteral.setType(CharacterType.getInstance());
        return null;
    }

    @Override
    public Boolean visit(Comparison comparison, Type tp) {
        comparison.setLvalue(false);
        comparison.left.accept(this, tp);
        comparison.right.accept(this, tp);
        comparison.setType(comparison.left.getType().comparison(comparison.right.getType(),comparison));
        return null;
    }

    @Override
    public Boolean visit(DoubleLiteral doubleLiteral, Type tp) {
        doubleLiteral.setLvalue(false);
        doubleLiteral.setType(DoubleType.getInstance());
        return null;
    }

    @Override
    public Boolean visit(IntLiteral intLiteral, Type tp) {
        intLiteral.setLvalue(false);
        intLiteral.setType(IntegerType.getInstance());
        return null;
    }

    @Override
    public Boolean visit(Invocation invocation, Type tp) {
        invocation.setLvalue(false);
        invocation.functionVar.accept(this, tp);
        invocation.parameters.forEach(t -> t.accept(this, tp));
        invocation.setType(invocation.functionVar.getType().parenthesis(invocation.getParameterTypes(),invocation));
        return null;
    }

    @Override
    public Boolean visit(Logical logical, Type tp) {
        logical.setLvalue(false);
        logical.left.accept(this, tp);
        logical.right.accept(this, tp);
        logical.setType(logical.left.getType().logic(logical.right.getType(),logical));
        return null;
    }

    @Override
    public Boolean visit(StructAccess structAccess, Type tp) {
        structAccess.setLvalue(true);
        structAccess.expression.accept(this, tp);
        structAccess.setType(structAccess.expression.getType().dot(structAccess.accessed,structAccess));
        return null;
    }

    @Override
    public Boolean visit(UnaryMinus unaryMinus, Type tp) {
        unaryMinus.setLvalue(false);
        unaryMinus.negativeExpression.accept(this, tp);
        unaryMinus.setType(unaryMinus.negativeExpression.getType().arithmetic(unaryMinus.negativeExpression));
        return null;
    }

    @Override
    public Boolean visit(UnaryNot unaryNot, Type tp) {
        unaryNot.setLvalue(false);
        unaryNot.negatedExpression.accept(this, tp);
        unaryNot.setType(unaryNot.negatedExpression.getType().logic(unaryNot.negatedExpression));
        return null;
    }

    @Override
    public Boolean visit(Variable variable, Type tp) {
        variable.setLvalue(true);
        variable.setType(variable.definition.getType());
        return null;
    }

    @Override
    public Boolean visit(Assignment assignment, Type tp) {
        assignment.variable.accept(this, tp);
        assignment.value.accept(this, tp);
        if(!assignment.variable.getLvalue()){
            new ErrorType("Semantic error: cannot assign value to non assignable expression.",assignment.value);
        }
        assignment.value.getType().mustPromoteTo(assignment.variable.getType(),assignment);
        return null;
    }

    @Override
    public Boolean visit(Read read, Type tp) {
        for (Expression expression : read.expressions) {
            expression.accept(this, tp);
            if(!expression.getLvalue()){
                new ErrorType("Invalid non assignable expression at read statement.",expression);
            }
            expression.getType().mustBeBuiltIn(expression);
        }
        return null;
    }


    @Override
    public Boolean visit(Return return_, Type type) {
        return_.expression.accept(this, type);
        return_.expression.getType().mustPromoteTo(type,return_);
        return null;
    }

    @Override
    public Boolean visit(FuncDefinition funcDefinition, Type type) {
        funcDefinition.type.accept(this, type);
        funcDefinition.body.forEach(t -> t.accept(this, ((FunctionType)funcDefinition.type).returnType));
        return null;
    }

    @Override
    public Boolean visit(IfElse ifElse, Type type) {
        ifElse.condition.accept(this, type);
        ifElse.condition.getType().mustBeLogical(ifElse.condition);
        ifElse.ifBody.forEach(t -> t.accept(this, type));
        ifElse.elseBody.forEach(t -> t.accept(this, type));
        return null;
    }

    @Override
    public Boolean visit(While while_, Type type) {
        while_.condition.accept(this, type);
        while_.condition.getType().mustBeLogical(while_.condition);
        while_.body.forEach(t -> t.accept(this, type));
        return null;
    }

    @Override
    public Boolean visit(Write write, Type type) {
        write.expressions.forEach(t -> {
            t.accept(this, type);
            t.getType().mustBeBuiltIn(t);
        });
        return null;
    }
}

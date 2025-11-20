// Generated from C:/Users/javie/Desktop/proyectos/Uniovi3/DLP/Intellij_project/DLP_PythonMinusMinus/src/parser/Pmm.g4 by ANTLR 4.13.2
package parser;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#mainDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMainDefinition(PmmParser.MainDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#mainDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMainDefinition(PmmParser.MainDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#funcDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefinition(PmmParser.FuncDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#funcDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefinition(PmmParser.FuncDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PmmParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PmmParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVarDefinition(PmmParser.VarDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVarDefinition(PmmParser.VarDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(PmmParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(PmmParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(PmmParser.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(PmmParser.BuiltInTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PmmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PmmParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(PmmParser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(PmmParser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
}
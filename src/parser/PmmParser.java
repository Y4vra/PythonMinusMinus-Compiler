// Generated from C:/Users/javie/Desktop/proyectos/Uniovi3/DLP/Intellij_project/DLP_PythonMinusMinus/src/parser/Pmm.g4 by ANTLR 4.13.2
package parser;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, ID=40, REAL_CONSTANT=41, INT_CONSTANT=42, CHAR_CONSTANT=43, 
		DIGIT=44, LETTER=45, IGNORED=46, COMMENT=47, MULTILINE_COMMENT=48;
	public static final int
		RULE_program = 0, RULE_mainDefinition = 1, RULE_definition = 2, RULE_funcDefinition = 3, 
		RULE_parameters = 4, RULE_varDefinition = 5, RULE_type = 6, RULE_field = 7, 
		RULE_builtInType = 8, RULE_statement = 9, RULE_block = 10, RULE_invocation = 11, 
		RULE_expression = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainDefinition", "definition", "funcDefinition", "parameters", 
			"varDefinition", "type", "field", "builtInType", "statement", "block", 
			"invocation", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "'->'", "'None'", "':'", "'{'", 
			"'}'", "','", "';'", "'['", "']'", "'struct'", "'double'", "'char'", 
			"'int'", "'print'", "'input'", "'='", "'while'", "'if'", "'else'", "'return'", 
			"'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", 
			"'<='", "'!='", "'=='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "REAL_CONSTANT", "INT_CONSTANT", "CHAR_CONSTANT", 
			"DIGIT", "LETTER", "IGNORED", "COMMENT", "MULTILINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> optional = new ArrayList<>();
		public DefinitionContext definition;
		public MainDefinitionContext mainDefinition;
		public MainDefinitionContext mainDefinition() {
			return getRuleContext(MainDefinitionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					((ProgramContext)_localctx).definition = definition();
					_localctx.optional.addAll(((ProgramContext)_localctx).definition.ast);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(34);
			((ProgramContext)_localctx).mainDefinition = mainDefinition();
			setState(35);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(_localctx.optional,((ProgramContext)_localctx).mainDefinition.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainDefinitionContext extends ParserRuleContext {
		public Definition ast;
		public List<Statement> body = new ArrayList<>();
		public Token id;
		public VarDefinitionContext varDefinition;
		public StatementContext statement;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterMainDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitMainDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitMainDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDefinitionContext mainDefinition() throws RecognitionException {
		MainDefinitionContext _localctx = new MainDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			((MainDefinitionContext)_localctx).id = match(T__1);
			setState(40);
			match(T__2);
			setState(41);
			match(T__3);
			setState(42);
			match(T__4);
			setState(43);
			match(T__5);
			setState(44);
			match(T__6);
			setState(45);
			match(T__7);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(46);
					((MainDefinitionContext)_localctx).varDefinition = varDefinition();
					_localctx.body.addAll(((MainDefinitionContext)_localctx).varDefinition.ast);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492899598344L) != 0)) {
				{
				{
				setState(54);
				((MainDefinitionContext)_localctx).statement = statement();
				_localctx.body.add(((MainDefinitionContext)_localctx).statement.ast);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__8);
			((MainDefinitionContext)_localctx).ast =  new FuncDefinition(((MainDefinitionContext)_localctx).id.getLine(),((MainDefinitionContext)_localctx).id.getCharPositionInLine(),_localctx.body);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public VarDefinitionContext varDefinition;
		public FuncDefinitionContext funcDefinition;
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FuncDefinitionContext funcDefinition() {
			return getRuleContext(FuncDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((DefinitionContext)_localctx).varDefinition = varDefinition();
				_localctx.ast.addAll(((DefinitionContext)_localctx).varDefinition.ast);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((DefinitionContext)_localctx).funcDefinition = funcDefinition();
				_localctx.ast.add(((DefinitionContext)_localctx).funcDefinition.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefinitionContext extends ParserRuleContext {
		public Definition ast;
		public Type returnType;
		public List<VarDefinition> params = new ArrayList<>();
		public List<Statement> body = new ArrayList<>();
		public Token ID;
		public ParametersContext parameters;
		public BuiltInTypeContext builtInType;
		public VarDefinitionContext varDefinition;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFuncDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFuncDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFuncDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefinitionContext funcDefinition() throws RecognitionException {
		FuncDefinitionContext _localctx = new FuncDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__0);
			setState(74);
			((FuncDefinitionContext)_localctx).ID = match(ID);
			setState(75);
			match(T__2);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(76);
				((FuncDefinitionContext)_localctx).parameters = parameters();
				((FuncDefinitionContext)_localctx).params = ((FuncDefinitionContext)_localctx).parameters.ast;
				}
			}

			setState(81);
			match(T__3);
			setState(82);
			match(T__4);
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
				{
				setState(83);
				((FuncDefinitionContext)_localctx).builtInType = builtInType();
				((FuncDefinitionContext)_localctx).returnType = ((FuncDefinitionContext)_localctx).builtInType.ast;
				}
				break;
			case T__5:
				{
				setState(86);
				match(T__5);
				((FuncDefinitionContext)_localctx).returnType = VoidType.getInstance();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(90);
			match(T__6);
			setState(91);
			match(T__7);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					((FuncDefinitionContext)_localctx).varDefinition = varDefinition();
					_localctx.body.addAll(((FuncDefinitionContext)_localctx).varDefinition.ast);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492899598344L) != 0)) {
				{
				{
				setState(100);
				((FuncDefinitionContext)_localctx).statement = statement();
				_localctx.body.add(((FuncDefinitionContext)_localctx).statement.ast);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(T__8);
			((FuncDefinitionContext)_localctx).ast =  new FuncDefinition(((FuncDefinitionContext)_localctx).ID.getLine(),((FuncDefinitionContext)_localctx).ID.getCharPositionInLine(),((FuncDefinitionContext)_localctx).ID.getText(),new FunctionType(_localctx.returnType,_localctx.params),_localctx.body);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public Token id1;
		public TypeContext t1;
		public Token id2;
		public TypeContext t2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((ParametersContext)_localctx).id1 = match(ID);
			setState(112);
			match(T__6);
			setState(113);
			((ParametersContext)_localctx).t1 = type();
			_localctx.ast.add(new VarDefinition(((ParametersContext)_localctx).id1.getLine(),((ParametersContext)_localctx).id1.getCharPositionInLine()+1,((ParametersContext)_localctx).id1.getText(),((ParametersContext)_localctx).t1.ast));
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(115);
				match(T__9);
				setState(116);
				((ParametersContext)_localctx).id2 = match(ID);
				setState(117);
				match(T__6);
				setState(118);
				((ParametersContext)_localctx).t2 = type();
				_localctx.ast.add(new VarDefinition(((ParametersContext)_localctx).id2.getLine(),((ParametersContext)_localctx).id2.getCharPositionInLine()+1,((ParametersContext)_localctx).id2.getText(),((ParametersContext)_localctx).t2.ast));
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public List<String> ids = new ArrayList<>();
		public Token id1;
		public Token id2;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterVarDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitVarDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVarDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((VarDefinitionContext)_localctx).id1 = match(ID);
			_localctx.ids.add(((VarDefinitionContext)_localctx).id1.getText());
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(128);
				match(T__9);
				setState(129);
				((VarDefinitionContext)_localctx).id2 = match(ID);
				_localctx.ids.add(((VarDefinitionContext)_localctx).id2.getText());
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			match(T__6);
			setState(137);
			((VarDefinitionContext)_localctx).type = type();
			setState(138);
			match(T__10);
			_localctx.ids.stream().forEach(id->{
			        var variable = new VarDefinition(((VarDefinitionContext)_localctx).id1.getLine(),((VarDefinitionContext)_localctx).id1.getCharPositionInLine()+1,id,((VarDefinitionContext)_localctx).type.ast);
			        if(_localctx.ast.contains(variable))new ErrorType("Duplicate identifier in variable definition",variable);
			        _localctx.ast.add(variable);
			    });
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<Field> aux;
		public BuiltInTypeContext builtInType;
		public Token INT_CONSTANT;
		public TypeContext t2;
		public FieldContext field;
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				((TypeContext)_localctx).builtInType = builtInType();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).builtInType.ast;
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(T__11);
				setState(145);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(146);
				match(T__12);
				setState(147);
				((TypeContext)_localctx).t2 = type();
				((TypeContext)_localctx).ast =  new ArrayType(LexerHelper.lexemeToInt(((TypeContext)_localctx).INT_CONSTANT.getText()),((TypeContext)_localctx).t2.ast);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(T__13);
				setState(151);
				match(T__7);
				((TypeContext)_localctx).aux = new ArrayList<>();
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(153);
					((TypeContext)_localctx).field = field();

					        ((TypeContext)_localctx).field.ast.forEach(fieldFound->{
					            if(_localctx.aux.contains(fieldFound))new ErrorType("Duplicate field in struct definition",fieldFound);
					            _localctx.aux.add(fieldFound);
					        });
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(T__8);
				((TypeContext)_localctx).ast =  new StructType(_localctx.aux);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList<>();
		public List<String> ids = new ArrayList<>();
		public Token id1;
		public Token id2;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			((FieldContext)_localctx).id1 = match(ID);
			_localctx.ids.add(((FieldContext)_localctx).id1.getText());
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(167);
				match(T__9);
				setState(168);
				((FieldContext)_localctx).id2 = match(ID);
				_localctx.ids.add(((FieldContext)_localctx).id2.getText());
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			match(T__6);
			setState(176);
			((FieldContext)_localctx).type = type();
			setState(177);
			match(T__10);
			_localctx.ids.stream().forEach(id->{
			        var field = new Field(((FieldContext)_localctx).id1.getLine(),((FieldContext)_localctx).id1.getCharPositionInLine()+1,id,((FieldContext)_localctx).type.ast);
			        if(_localctx.ast.contains(field))new ErrorType("Duplicate identifier in field definition",field);
			        _localctx.ast.add(field);
			    });
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BuiltInTypeContext extends ParserRuleContext {
		public Type ast;
		public BuiltInTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBuiltInType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBuiltInType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBuiltInType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltInTypeContext builtInType() throws RecognitionException {
		BuiltInTypeContext _localctx = new BuiltInTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_builtInType);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(T__14);
				((BuiltInTypeContext)_localctx).ast =  DoubleType.getInstance();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(T__15);
				((BuiltInTypeContext)_localctx).ast =  CharacterType.getInstance();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(T__16);
				((BuiltInTypeContext)_localctx).ast =  IntegerType.getInstance();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public List aux;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext exp;
		public BlockContext block;
		public BlockContext b1;
		public BlockContext b2;
		public InvocationContext invocation;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(T__17);
				setState(189);
				((StatementContext)_localctx).exp1 = expression(0);
				((StatementContext)_localctx).aux = new ArrayList<>();_localctx.aux.add(((StatementContext)_localctx).exp1.ast);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(191);
					match(T__9);
					setState(192);
					((StatementContext)_localctx).exp2 = expression(0);
					_localctx.aux.add(((StatementContext)_localctx).exp2.ast);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__10);
				((StatementContext)_localctx).ast =  new Write(((StatementContext)_localctx).exp1.ast.getLine(),((StatementContext)_localctx).exp1.ast.getColumn(),_localctx.aux);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(T__18);
				setState(204);
				((StatementContext)_localctx).exp1 = expression(0);
				((StatementContext)_localctx).aux = new ArrayList<>();_localctx.aux.add(((StatementContext)_localctx).exp1.ast);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(206);
					match(T__9);
					setState(207);
					((StatementContext)_localctx).exp2 = expression(0);
					_localctx.aux.add(((StatementContext)_localctx).exp2.ast);
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(215);
				match(T__10);
				((StatementContext)_localctx).ast =  new Read(((StatementContext)_localctx).exp1.ast.getLine(),((StatementContext)_localctx).exp1.ast.getColumn(),_localctx.aux);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(219);
				match(T__19);
				setState(220);
				((StatementContext)_localctx).exp2 = expression(0);
				setState(221);
				match(T__10);
				((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).exp1.ast.getLine(),((StatementContext)_localctx).exp1.ast.getColumn(),((StatementContext)_localctx).exp1.ast,((StatementContext)_localctx).exp2.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				match(T__20);
				setState(225);
				((StatementContext)_localctx).exp = expression(0);
				setState(226);
				match(T__6);
				setState(227);
				((StatementContext)_localctx).block = block();
				((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).exp.ast.getLine(),((StatementContext)_localctx).exp.ast.getColumn(),((StatementContext)_localctx).exp.ast,((StatementContext)_localctx).block.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(230);
				match(T__21);
				setState(231);
				((StatementContext)_localctx).exp = expression(0);
				setState(232);
				match(T__6);
				setState(233);
				((StatementContext)_localctx).b1 = block();
				((StatementContext)_localctx).aux = new ArrayList<>();
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(235);
					match(T__22);
					setState(236);
					match(T__6);
					setState(237);
					((StatementContext)_localctx).b2 = block();
					((StatementContext)_localctx).aux = ((StatementContext)_localctx).b2.ast;
					}
					break;
				}
				((StatementContext)_localctx).ast =  new IfElse(((StatementContext)_localctx).exp.ast.getLine(),((StatementContext)_localctx).exp.ast.getColumn(),((StatementContext)_localctx).exp.ast,((StatementContext)_localctx).b1.ast,_localctx.aux);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(244);
				match(T__23);
				setState(245);
				((StatementContext)_localctx).exp = expression(0);
				setState(246);
				match(T__10);
				((StatementContext)_localctx).ast = new Return(((StatementContext)_localctx).exp.ast.getLine(),((StatementContext)_localctx).exp.ast.getColumn(),((StatementContext)_localctx).exp.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(249);
				((StatementContext)_localctx).invocation = invocation();
				setState(250);
				match(T__10);
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).invocation.ast;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__17:
			case T__18:
			case T__20:
			case T__21:
			case T__23:
			case T__25:
			case T__26:
			case ID:
			case REAL_CONSTANT:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				((BlockContext)_localctx).statement = statement();
				_localctx.ast.add(((BlockContext)_localctx).statement.ast);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(T__7);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492899598344L) != 0)) {
					{
					{
					setState(259);
					((BlockContext)_localctx).statement = statement();
					_localctx.ast.add(((BlockContext)_localctx).statement.ast);
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(267);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InvocationContext extends ParserRuleContext {
		public Invocation ast;
		public List<Expression> params = new ArrayList<>();
		public Token ID;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			((InvocationContext)_localctx).ID = match(ID);
			setState(271);
			match(T__2);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492875743240L) != 0)) {
				{
				setState(272);
				((InvocationContext)_localctx).exp1 = expression(0);
				_localctx.params.add(((InvocationContext)_localctx).exp1.ast);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(274);
					match(T__9);
					setState(275);
					((InvocationContext)_localctx).exp2 = expression(0);
					_localctx.params.add(((InvocationContext)_localctx).exp2.ast);
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(285);
			match(T__3);
			((InvocationContext)_localctx).ast =  new Invocation(((InvocationContext)_localctx).ID.getLine(),((InvocationContext)_localctx).ID.getCharPositionInLine()+1,new Variable(((InvocationContext)_localctx).ID.getLine(),((InvocationContext)_localctx).ID.getCharPositionInLine()+1,((InvocationContext)_localctx).ID.getText()),_localctx.params);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp1;
		public Token ID;
		public Token REAL_CONSTANT;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public TypeContext type;
		public InvocationContext invocation;
		public Token id;
		public ExpressionContext exp2;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(289);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 2:
				{
				setState(291);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToReal(((ExpressionContext)_localctx).REAL_CONSTANT.getText()));
				}
				break;
			case 3:
				{
				setState(293);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt(((ExpressionContext)_localctx).INT_CONSTANT.getText()));
				}
				break;
			case 4:
				{
				setState(295);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar(((ExpressionContext)_localctx).CHAR_CONSTANT.getText()));
				}
				break;
			case 5:
				{
				setState(297);
				match(T__2);
				setState(298);
				((ExpressionContext)_localctx).exp1 = expression(0);
				setState(299);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp1.ast;
				}
				break;
			case 6:
				{
				setState(302);
				match(T__2);
				setState(303);
				((ExpressionContext)_localctx).type = type();
				setState(304);
				match(T__3);
				setState(305);
				((ExpressionContext)_localctx).exp1 = expression(8);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).exp1.ast);
				}
				break;
			case 7:
				{
				setState(308);
				match(T__25);
				setState(309);
				((ExpressionContext)_localctx).exp1 = expression(7);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).exp1.ast);
				}
				break;
			case 8:
				{
				setState(312);
				match(T__26);
				setState(313);
				((ExpressionContext)_localctx).exp1 = expression(6);
				((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).exp1.ast);
				}
				break;
			case 9:
				{
				setState(316);
				((ExpressionContext)_localctx).invocation = invocation();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).invocation.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(353);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(351);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(322);
						((ExpressionContext)_localctx).id = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
							((ExpressionContext)_localctx).id = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(323);
						((ExpressionContext)_localctx).exp2 = expression(6);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).id.getText(),((ExpressionContext)_localctx).exp1.ast,((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(327);
						((ExpressionContext)_localctx).id = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__30) ) {
							((ExpressionContext)_localctx).id = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(328);
						((ExpressionContext)_localctx).exp2 = expression(5);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).id.getText(),((ExpressionContext)_localctx).exp1.ast,((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(332);
						((ExpressionContext)_localctx).id = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 270582939648L) != 0)) ) {
							((ExpressionContext)_localctx).id = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(333);
						((ExpressionContext)_localctx).exp2 = expression(4);
						((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).id.getText(),((ExpressionContext)_localctx).exp1.ast,((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(337);
						((ExpressionContext)_localctx).id = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__37 || _la==T__38) ) {
							((ExpressionContext)_localctx).id = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(338);
						((ExpressionContext)_localctx).exp2 = expression(3);
						((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).id.getText(),((ExpressionContext)_localctx).exp1.ast,((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(342);
						match(T__11);
						setState(343);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(344);
						match(T__12);
						((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).exp1.ast,((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(348);
						match(T__24);
						setState(349);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new StructAccess(((ExpressionContext)_localctx).exp1.ast.getLine(),((ExpressionContext)_localctx).exp1.ast.getColumn(),((ExpressionContext)_localctx).exp1.ast,((ExpressionContext)_localctx).ID.getText());
						}
						break;
					}
					} 
				}
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u0165\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001e\b\u0000"+
		"\n\u0000\f\u0000!\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"2\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003P\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003Y\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003`\b\u0003\n\u0003\f\u0003c\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003h\b\u0003\n\u0003\f\u0003k\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004z\b\u0004\n\u0004\f\u0004}\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0084\b\u0005"+
		"\n\u0005\f\u0005\u0087\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u009d"+
		"\b\u0006\n\u0006\f\u0006\u00a0\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00a4\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00ab\b\u0007\n\u0007\f\u0007\u00ae\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00bb\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00c4\b\t\n\t\f\t\u00c7\t\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00d3\b\t\n\t\f\t\u00d6\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00f1\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00fe\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0107\b\n\n"+
		"\n\f\n\u010a\t\n\u0001\n\u0003\n\u010d\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0117\b\u000b\n\u000b\f\u000b\u011a\t\u000b\u0003\u000b\u011c\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0140\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0160\b\f\n\f\f\f\u0163"+
		"\t\f\u0001\f\u0000\u0001\u0018\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u0000\u0004\u0001\u0000\u001c\u001e\u0002\u0000"+
		"\u001a\u001a\u001f\u001f\u0001\u0000 %\u0001\u0000&\'\u0182\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004G\u0001\u0000"+
		"\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bo\u0001\u0000\u0000\u0000"+
		"\n~\u0001\u0000\u0000\u0000\f\u00a3\u0001\u0000\u0000\u0000\u000e\u00a5"+
		"\u0001\u0000\u0000\u0000\u0010\u00ba\u0001\u0000\u0000\u0000\u0012\u00fd"+
		"\u0001\u0000\u0000\u0000\u0014\u010c\u0001\u0000\u0000\u0000\u0016\u010e"+
		"\u0001\u0000\u0000\u0000\u0018\u013f\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0003\u0004\u0002\u0000\u001b\u001c\u0006\u0000\uffff\uffff\u0000\u001c"+
		"\u001e\u0001\u0000\u0000\u0000\u001d\u001a\u0001\u0000\u0000\u0000\u001e"+
		"!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000"+
		"\u0000\"#\u0003\u0002\u0001\u0000#$\u0005\u0000\u0000\u0001$%\u0006\u0000"+
		"\uffff\uffff\u0000%\u0001\u0001\u0000\u0000\u0000&\'\u0005\u0001\u0000"+
		"\u0000\'(\u0005\u0002\u0000\u0000()\u0005\u0003\u0000\u0000)*\u0005\u0004"+
		"\u0000\u0000*+\u0005\u0005\u0000\u0000+,\u0005\u0006\u0000\u0000,-\u0005"+
		"\u0007\u0000\u0000-3\u0005\b\u0000\u0000./\u0003\n\u0005\u0000/0\u0006"+
		"\u0001\uffff\uffff\u000002\u0001\u0000\u0000\u00001.\u0001\u0000\u0000"+
		"\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u00004;\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0003"+
		"\u0012\t\u000078\u0006\u0001\uffff\uffff\u00008:\u0001\u0000\u0000\u0000"+
		"96\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000>?\u0005\t\u0000\u0000?@\u0006\u0001\uffff\uffff\u0000@\u0003"+
		"\u0001\u0000\u0000\u0000AB\u0003\n\u0005\u0000BC\u0006\u0002\uffff\uffff"+
		"\u0000CH\u0001\u0000\u0000\u0000DE\u0003\u0006\u0003\u0000EF\u0006\u0002"+
		"\uffff\uffff\u0000FH\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000"+
		"GD\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000\u0000IJ\u0005\u0001"+
		"\u0000\u0000JK\u0005(\u0000\u0000KO\u0005\u0003\u0000\u0000LM\u0003\b"+
		"\u0004\u0000MN\u0006\u0003\uffff\uffff\u0000NP\u0001\u0000\u0000\u0000"+
		"OL\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000QR\u0005\u0004\u0000\u0000RX\u0005\u0005\u0000\u0000ST\u0003\u0010"+
		"\b\u0000TU\u0006\u0003\uffff\uffff\u0000UY\u0001\u0000\u0000\u0000VW\u0005"+
		"\u0006\u0000\u0000WY\u0006\u0003\uffff\uffff\u0000XS\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005\u0007"+
		"\u0000\u0000[a\u0005\b\u0000\u0000\\]\u0003\n\u0005\u0000]^\u0006\u0003"+
		"\uffff\uffff\u0000^`\u0001\u0000\u0000\u0000_\\\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bi\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0003\u0012"+
		"\t\u0000ef\u0006\u0003\uffff\uffff\u0000fh\u0001\u0000\u0000\u0000gd\u0001"+
		"\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000lm\u0005\t\u0000\u0000mn\u0006\u0003\uffff\uffff\u0000n\u0007\u0001"+
		"\u0000\u0000\u0000op\u0005(\u0000\u0000pq\u0005\u0007\u0000\u0000qr\u0003"+
		"\f\u0006\u0000r{\u0006\u0004\uffff\uffff\u0000st\u0005\n\u0000\u0000t"+
		"u\u0005(\u0000\u0000uv\u0005\u0007\u0000\u0000vw\u0003\f\u0006\u0000w"+
		"x\u0006\u0004\uffff\uffff\u0000xz\u0001\u0000\u0000\u0000ys\u0001\u0000"+
		"\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|\t\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005(\u0000\u0000\u007f\u0085\u0006\u0005\uffff\uffff\u0000\u0080"+
		"\u0081\u0005\n\u0000\u0000\u0081\u0082\u0005(\u0000\u0000\u0082\u0084"+
		"\u0006\u0005\uffff\uffff\u0000\u0083\u0080\u0001\u0000\u0000\u0000\u0084"+
		"\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0007\u0000\u0000\u0089"+
		"\u008a\u0003\f\u0006\u0000\u008a\u008b\u0005\u000b\u0000\u0000\u008b\u008c"+
		"\u0006\u0005\uffff\uffff\u0000\u008c\u000b\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0003\u0010\b\u0000\u008e\u008f\u0006\u0006\uffff\uffff\u0000\u008f"+
		"\u00a4\u0001\u0000\u0000\u0000\u0090\u0091\u0005\f\u0000\u0000\u0091\u0092"+
		"\u0005*\u0000\u0000\u0092\u0093\u0005\r\u0000\u0000\u0093\u0094\u0003"+
		"\f\u0006\u0000\u0094\u0095\u0006\u0006\uffff\uffff\u0000\u0095\u00a4\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005\u000e\u0000\u0000\u0097\u0098\u0005"+
		"\b\u0000\u0000\u0098\u009e\u0006\u0006\uffff\uffff\u0000\u0099\u009a\u0003"+
		"\u000e\u0007\u0000\u009a\u009b\u0006\u0006\uffff\uffff\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009d\u00a0"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\t\u0000\u0000\u00a2\u00a4\u0006"+
		"\u0006\uffff\uffff\u0000\u00a3\u008d\u0001\u0000\u0000\u0000\u00a3\u0090"+
		"\u0001\u0000\u0000\u0000\u00a3\u0096\u0001\u0000\u0000\u0000\u00a4\r\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005(\u0000\u0000\u00a6\u00ac\u0006\u0007"+
		"\uffff\uffff\u0000\u00a7\u00a8\u0005\n\u0000\u0000\u00a8\u00a9\u0005("+
		"\u0000\u0000\u00a9\u00ab\u0006\u0007\uffff\uffff\u0000\u00aa\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\u0007\u0000\u0000\u00b0\u00b1\u0003\f\u0006\u0000\u00b1\u00b2\u0005\u000b"+
		"\u0000\u0000\u00b2\u00b3\u0006\u0007\uffff\uffff\u0000\u00b3\u000f\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005\u000f\u0000\u0000\u00b5\u00bb\u0006"+
		"\b\uffff\uffff\u0000\u00b6\u00b7\u0005\u0010\u0000\u0000\u00b7\u00bb\u0006"+
		"\b\uffff\uffff\u0000\u00b8\u00b9\u0005\u0011\u0000\u0000\u00b9\u00bb\u0006"+
		"\b\uffff\uffff\u0000\u00ba\u00b4\u0001\u0000\u0000\u0000\u00ba\u00b6\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u0011\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0005\u0012\u0000\u0000\u00bd\u00be\u0003"+
		"\u0018\f\u0000\u00be\u00c5\u0006\t\uffff\uffff\u0000\u00bf\u00c0\u0005"+
		"\n\u0000\u0000\u00c0\u00c1\u0003\u0018\f\u0000\u00c1\u00c2\u0006\t\uffff"+
		"\uffff\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u000b"+
		"\u0000\u0000\u00c9\u00ca\u0006\t\uffff\uffff\u0000\u00ca\u00fe\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0005\u0013\u0000\u0000\u00cc\u00cd\u0003\u0018"+
		"\f\u0000\u00cd\u00d4\u0006\t\uffff\uffff\u0000\u00ce\u00cf\u0005\n\u0000"+
		"\u0000\u00cf\u00d0\u0003\u0018\f\u0000\u00d0\u00d1\u0006\t\uffff\uffff"+
		"\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u000b\u0000"+
		"\u0000\u00d8\u00d9\u0006\t\uffff\uffff\u0000\u00d9\u00fe\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0003\u0018\f\u0000\u00db\u00dc\u0005\u0014\u0000\u0000"+
		"\u00dc\u00dd\u0003\u0018\f\u0000\u00dd\u00de\u0005\u000b\u0000\u0000\u00de"+
		"\u00df\u0006\t\uffff\uffff\u0000\u00df\u00fe\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0005\u0015\u0000\u0000\u00e1\u00e2\u0003\u0018\f\u0000\u00e2\u00e3"+
		"\u0005\u0007\u0000\u0000\u00e3\u00e4\u0003\u0014\n\u0000\u00e4\u00e5\u0006"+
		"\t\uffff\uffff\u0000\u00e5\u00fe\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"\u0016\u0000\u0000\u00e7\u00e8\u0003\u0018\f\u0000\u00e8\u00e9\u0005\u0007"+
		"\u0000\u0000\u00e9\u00ea\u0003\u0014\n\u0000\u00ea\u00f0\u0006\t\uffff"+
		"\uffff\u0000\u00eb\u00ec\u0005\u0017\u0000\u0000\u00ec\u00ed\u0005\u0007"+
		"\u0000\u0000\u00ed\u00ee\u0003\u0014\n\u0000\u00ee\u00ef\u0006\t\uffff"+
		"\uffff\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00eb\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0006\t\uffff\uffff\u0000\u00f3\u00fe\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0005\u0018\u0000\u0000\u00f5\u00f6\u0003\u0018"+
		"\f\u0000\u00f6\u00f7\u0005\u000b\u0000\u0000\u00f7\u00f8\u0006\t\uffff"+
		"\uffff\u0000\u00f8\u00fe\u0001\u0000\u0000\u0000\u00f9\u00fa\u0003\u0016"+
		"\u000b\u0000\u00fa\u00fb\u0005\u000b\u0000\u0000\u00fb\u00fc\u0006\t\uffff"+
		"\uffff\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000\u00fd\u00bc\u0001\u0000"+
		"\u0000\u0000\u00fd\u00cb\u0001\u0000\u0000\u0000\u00fd\u00da\u0001\u0000"+
		"\u0000\u0000\u00fd\u00e0\u0001\u0000\u0000\u0000\u00fd\u00e6\u0001\u0000"+
		"\u0000\u0000\u00fd\u00f4\u0001\u0000\u0000\u0000\u00fd\u00f9\u0001\u0000"+
		"\u0000\u0000\u00fe\u0013\u0001\u0000\u0000\u0000\u00ff\u0100\u0003\u0012"+
		"\t\u0000\u0100\u0101\u0006\n\uffff\uffff\u0000\u0101\u010d\u0001\u0000"+
		"\u0000\u0000\u0102\u0108\u0005\b\u0000\u0000\u0103\u0104\u0003\u0012\t"+
		"\u0000\u0104\u0105\u0006\n\uffff\uffff\u0000\u0105\u0107\u0001\u0000\u0000"+
		"\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000"+
		"\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000"+
		"\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000"+
		"\u0000\u010b\u010d\u0005\t\u0000\u0000\u010c\u00ff\u0001\u0000\u0000\u0000"+
		"\u010c\u0102\u0001\u0000\u0000\u0000\u010d\u0015\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0005(\u0000\u0000\u010f\u011b\u0005\u0003\u0000\u0000\u0110"+
		"\u0111\u0003\u0018\f\u0000\u0111\u0118\u0006\u000b\uffff\uffff\u0000\u0112"+
		"\u0113\u0005\n\u0000\u0000\u0113\u0114\u0003\u0018\f\u0000\u0114\u0115"+
		"\u0006\u000b\uffff\uffff\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116"+
		"\u0112\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119"+
		"\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b"+
		"\u0110\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u0004\u0000\u0000\u011e"+
		"\u011f\u0006\u000b\uffff\uffff\u0000\u011f\u0017\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0006\f\uffff\uffff\u0000\u0121\u0122\u0005(\u0000\u0000"+
		"\u0122\u0140\u0006\f\uffff\uffff\u0000\u0123\u0124\u0005)\u0000\u0000"+
		"\u0124\u0140\u0006\f\uffff\uffff\u0000\u0125\u0126\u0005*\u0000\u0000"+
		"\u0126\u0140\u0006\f\uffff\uffff\u0000\u0127\u0128\u0005+\u0000\u0000"+
		"\u0128\u0140\u0006\f\uffff\uffff\u0000\u0129\u012a\u0005\u0003\u0000\u0000"+
		"\u012a\u012b\u0003\u0018\f\u0000\u012b\u012c\u0005\u0004\u0000\u0000\u012c"+
		"\u012d\u0006\f\uffff\uffff\u0000\u012d\u0140\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0005\u0003\u0000\u0000\u012f\u0130\u0003\f\u0006\u0000\u0130\u0131"+
		"\u0005\u0004\u0000\u0000\u0131\u0132\u0003\u0018\f\b\u0132\u0133\u0006"+
		"\f\uffff\uffff\u0000\u0133\u0140\u0001\u0000\u0000\u0000\u0134\u0135\u0005"+
		"\u001a\u0000\u0000\u0135\u0136\u0003\u0018\f\u0007\u0136\u0137\u0006\f"+
		"\uffff\uffff\u0000\u0137\u0140\u0001\u0000\u0000\u0000\u0138\u0139\u0005"+
		"\u001b\u0000\u0000\u0139\u013a\u0003\u0018\f\u0006\u013a\u013b\u0006\f"+
		"\uffff\uffff\u0000\u013b\u0140\u0001\u0000\u0000\u0000\u013c\u013d\u0003"+
		"\u0016\u000b\u0000\u013d\u013e\u0006\f\uffff\uffff\u0000\u013e\u0140\u0001"+
		"\u0000\u0000\u0000\u013f\u0120\u0001\u0000\u0000\u0000\u013f\u0123\u0001"+
		"\u0000\u0000\u0000\u013f\u0125\u0001\u0000\u0000\u0000\u013f\u0127\u0001"+
		"\u0000\u0000\u0000\u013f\u0129\u0001\u0000\u0000\u0000\u013f\u012e\u0001"+
		"\u0000\u0000\u0000\u013f\u0134\u0001\u0000\u0000\u0000\u013f\u0138\u0001"+
		"\u0000\u0000\u0000\u013f\u013c\u0001\u0000\u0000\u0000\u0140\u0161\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\n\u0005\u0000\u0000\u0142\u0143\u0007\u0000"+
		"\u0000\u0000\u0143\u0144\u0003\u0018\f\u0006\u0144\u0145\u0006\f\uffff"+
		"\uffff\u0000\u0145\u0160\u0001\u0000\u0000\u0000\u0146\u0147\n\u0004\u0000"+
		"\u0000\u0147\u0148\u0007\u0001\u0000\u0000\u0148\u0149\u0003\u0018\f\u0005"+
		"\u0149\u014a\u0006\f\uffff\uffff\u0000\u014a\u0160\u0001\u0000\u0000\u0000"+
		"\u014b\u014c\n\u0003\u0000\u0000\u014c\u014d\u0007\u0002\u0000\u0000\u014d"+
		"\u014e\u0003\u0018\f\u0004\u014e\u014f\u0006\f\uffff\uffff\u0000\u014f"+
		"\u0160\u0001\u0000\u0000\u0000\u0150\u0151\n\u0002\u0000\u0000\u0151\u0152"+
		"\u0007\u0003\u0000\u0000\u0152\u0153\u0003\u0018\f\u0003\u0153\u0154\u0006"+
		"\f\uffff\uffff\u0000\u0154\u0160\u0001\u0000\u0000\u0000\u0155\u0156\n"+
		"\n\u0000\u0000\u0156\u0157\u0005\f\u0000\u0000\u0157\u0158\u0003\u0018"+
		"\f\u0000\u0158\u0159\u0005\r\u0000\u0000\u0159\u015a\u0006\f\uffff\uffff"+
		"\u0000\u015a\u0160\u0001\u0000\u0000\u0000\u015b\u015c\n\t\u0000\u0000"+
		"\u015c\u015d\u0005\u0019\u0000\u0000\u015d\u015e\u0005(\u0000\u0000\u015e"+
		"\u0160\u0006\f\uffff\uffff\u0000\u015f\u0141\u0001\u0000\u0000\u0000\u015f"+
		"\u0146\u0001\u0000\u0000\u0000\u015f\u014b\u0001\u0000\u0000\u0000\u015f"+
		"\u0150\u0001\u0000\u0000\u0000\u015f\u0155\u0001\u0000\u0000\u0000\u015f"+
		"\u015b\u0001\u0000\u0000\u0000\u0160\u0163\u0001\u0000\u0000\u0000\u0161"+
		"\u015f\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u0019\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0019"+
		"\u001f3;GOXai{\u0085\u009e\u00a3\u00ac\u00ba\u00c5\u00d4\u00f0\u00fd\u0108"+
		"\u010c\u0118\u011b\u013f\u015f\u0161";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
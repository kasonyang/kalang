// Generated from Ell.g4 by ANTLR 4.5
package ell.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EllParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ABSTRACT=2, ASSERT=3, BOOLEAN=4, BREAK=5, BYTE=6, CASE=7, CATCH=8, 
		CHAR=9, CLASS=10, CONST=11, CONTINUE=12, DEFAULT=13, DO=14, DOUBLE=15, 
		ELSE=16, ENUM=17, EXTENDS=18, FINAL=19, FINALLY=20, FLOAT=21, FOR=22, 
		IF=23, GOTO=24, IMPLEMENTS=25, IMPORT=26, INSTANCEOF=27, INT=28, INTERFACE=29, 
		LONG=30, NATIVE=31, NEW=32, PACKAGE=33, PRIVATE=34, PROTECTED=35, PUBLIC=36, 
		RETURN=37, SHORT=38, STATIC=39, STRICTFP=40, SUPER=41, SWITCH=42, SYNCHRONIZED=43, 
		THIS=44, THROW=45, THROWS=46, TRANSIENT=47, TRY=48, VOID=49, VOLATILE=50, 
		WHILE=51, IntegerLiteral=52, FloatingPointLiteral=53, BooleanLiteral=54, 
		CharacterLiteral=55, StringLiteral=56, NullLiteral=57, LPAREN=58, RPAREN=59, 
		LBRACE=60, RBRACE=61, LBRACK=62, RBRACK=63, SEMI=64, COMMA=65, DOT=66, 
		ASSIGN=67, GT=68, LT=69, BANG=70, TILDE=71, QUESTION=72, COLON=73, EQUAL=74, 
		LE=75, GE=76, NOTEQUAL=77, AND=78, OR=79, INC=80, DEC=81, ADD=82, SUB=83, 
		MUL=84, DIV=85, BITAND=86, BITOR=87, CARET=88, MOD=89, ADD_ASSIGN=90, 
		SUB_ASSIGN=91, MUL_ASSIGN=92, DIV_ASSIGN=93, AND_ASSIGN=94, OR_ASSIGN=95, 
		XOR_ASSIGN=96, MOD_ASSIGN=97, LSHIFT_ASSIGN=98, RSHIFT_ASSIGN=99, URSHIFT_ASSIGN=100, 
		Identifier=101, AT=102, ELLIPSIS=103, WS=104, COMMENT=105, LINE_COMMENT=106;
	public static final int
		RULE_dslStatList = 0, RULE_dslStat = 1, RULE_dslExpr = 2, RULE_dslParamList = 3, 
		RULE_dslParam = 4, RULE_start = 5, RULE_compiliantUnit = 6, RULE_classBody = 7, 
		RULE_methodDeclList = 8, RULE_methodDecl = 9, RULE_type = 10, RULE_argumentDeclList = 11, 
		RULE_argumentDecl = 12, RULE_statList = 13, RULE_ifStat = 14, RULE_ifStatSuffix = 15, 
		RULE_stat = 16, RULE_returnStat = 17, RULE_varDeclStat = 18, RULE_varDecl = 19, 
		RULE_breakStat = 20, RULE_continueStat = 21, RULE_whileStat = 22, RULE_doWhileStat = 23, 
		RULE_forStat = 24, RULE_forInit = 25, RULE_forUpdate = 26, RULE_expressionList = 27, 
		RULE_exprStat = 28, RULE_expression = 29, RULE_offset = 30, RULE_primary = 31, 
		RULE_literal = 32, RULE_arguments = 33, RULE_argumentList = 34;
	public static final String[] ruleNames = {
		"dslStatList", "dslStat", "dslExpr", "dslParamList", "dslParam", "start", 
		"compiliantUnit", "classBody", "methodDeclList", "methodDecl", "type", 
		"argumentDeclList", "argumentDecl", "statList", "ifStat", "ifStatSuffix", 
		"stat", "returnStat", "varDeclStat", "varDecl", "breakStat", "continueStat", 
		"whileStat", "doWhileStat", "forStat", "forInit", "forUpdate", "expressionList", 
		"exprStat", "expression", "offset", "primary", "literal", "arguments", 
		"argumentList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'as'", "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", 
		"'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
		"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
		"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
		"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
		"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
		"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
		"'transient'", "'try'", "'void'", "'volatile'", "'while'", null, null, 
		null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
		"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
		"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
		"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", 
		"'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", null, 
		"'@'", "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", 
		"CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", 
		"ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
		"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", 
		"NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", 
		"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
		"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
		"SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", 
		"SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
		"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", 
		"AT", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
	};
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
	public String getGrammarFileName() { return "Ell.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EllParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DslStatListContext extends ParserRuleContext {
		public List<DslStatContext> dslStat() {
			return getRuleContexts(DslStatContext.class);
		}
		public DslStatContext dslStat(int i) {
			return getRuleContext(DslStatContext.class,i);
		}
		public DslStatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslStatList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslStatListContext dslStatList() throws RecognitionException {
		DslStatListContext _localctx = new DslStatListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dslStatList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(70);
				dslStat();
				}
				}
				setState(75);
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

	public static class DslStatContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public DslExprContext dslExpr() {
			return getRuleContext(DslExprContext.class,0);
		}
		public DslStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslStatContext dslStat() throws RecognitionException {
		DslStatContext _localctx = new DslStatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dslStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(Identifier);
			setState(77);
			match(COLON);
			setState(78);
			dslExpr();
			setState(79);
			match(SEMI);
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

	public static class DslExprContext extends ParserRuleContext {
		public DslExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslExpr; }
	 
		public DslExprContext() { }
		public void copyFrom(DslExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DslExpressionContext extends DslExprContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DslExpressionContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DslVarDeclContext extends DslExprContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public DslVarDeclContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DslVarNewContext extends DslExprContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public DslVarNewContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslVarNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslVarNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslVarNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DslChainStatContext extends DslExprContext {
		public List<TerminalNode> Identifier() { return getTokens(EllParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EllParser.Identifier, i);
		}
		public List<DslParamListContext> dslParamList() {
			return getRuleContexts(DslParamListContext.class);
		}
		public DslParamListContext dslParamList(int i) {
			return getRuleContext(DslParamListContext.class,i);
		}
		public DslChainStatContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslChainStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslChainStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslChainStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslExprContext dslExpr() throws RecognitionException {
		DslExprContext _localctx = new DslExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dslExpr);
		int _la;
		try {
			setState(92);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new DslVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__0);
				setState(82);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new DslVarNewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(NEW);
				setState(84);
				match(Identifier);
				}
				break;
			case 3:
				_localctx = new DslExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				expression(0);
				}
				break;
			case 4:
				_localctx = new DslChainStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					match(Identifier);
					setState(87);
					dslParamList();
					}
					}
					setState(90); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
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

	public static class DslParamListContext extends ParserRuleContext {
		public DslParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslParamList; }
	 
		public DslParamListContext() { }
		public void copyFrom(DslParamListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamNamedContext extends DslParamListContext {
		public List<TerminalNode> Identifier() { return getTokens(EllParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EllParser.Identifier, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParamNamedContext(DslParamListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterParamNamed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitParamNamed(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitParamNamed(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParamOrderedContext extends DslParamListContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParamOrderedContext(DslParamListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterParamOrdered(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitParamOrdered(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitParamOrdered(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslParamListContext dslParamList() throws RecognitionException {
		DslParamListContext _localctx = new DslParamListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dslParamList);
		int _la;
		try {
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ParamNamedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(Identifier);
				setState(95);
				match(ASSIGN);
				setState(96);
				expression(0);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(97);
					match(COMMA);
					setState(98);
					match(Identifier);
					setState(99);
					match(ASSIGN);
					setState(100);
					expression(0);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new ParamOrderedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				expression(0);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(107);
					match(COMMA);
					setState(108);
					expression(0);
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class DslParamContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DslParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDslParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDslParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDslParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslParamContext dslParam() throws RecognitionException {
		DslParamContext _localctx = new DslParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dslParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(Identifier);
			setState(117);
			match(ASSIGN);
			setState(118);
			expression(0);
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

	public static class StartContext extends ParserRuleContext {
		public DslStatListContext dslStatList() {
			return getRuleContext(DslStatListContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			dslStatList();
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

	public static class CompiliantUnitContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(EllParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EllParser.Identifier, i);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public CompiliantUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compiliantUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterCompiliantUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitCompiliantUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitCompiliantUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompiliantUnitContext compiliantUnit() throws RecognitionException {
		CompiliantUnitContext _localctx = new CompiliantUnitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compiliantUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(CLASS);
			setState(123);
			match(Identifier);
			setState(126);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(124);
				match(EXTENDS);
				setState(125);
				match(Identifier);
				}
			}

			setState(128);
			match(LBRACE);
			setState(129);
			classBody();
			setState(130);
			match(RBRACE);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public MethodDeclListContext methodDeclList() {
			return getRuleContext(MethodDeclListContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			methodDeclList();
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

	public static class MethodDeclListContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public MethodDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterMethodDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitMethodDeclList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitMethodDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclListContext methodDeclList() throws RecognitionException {
		MethodDeclListContext _localctx = new MethodDeclListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				{
				setState(134);
				methodDecl();
				}
				}
				setState(139);
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

	public static class MethodDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public ArgumentDeclListContext argumentDeclList() {
			return getRuleContext(ArgumentDeclListContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			type();
			setState(141);
			match(Identifier);
			setState(142);
			match(LPAREN);
			setState(144);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				setState(143);
				argumentDeclList();
				}
			}

			setState(146);
			match(RPAREN);
			setState(147);
			match(LBRACE);
			setState(148);
			statList();
			setState(149);
			match(RBRACE);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public TerminalNode DOUBLE() { return getToken(EllParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(EllParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(EllParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(EllParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ArgumentDeclListContext extends ParserRuleContext {
		public List<ArgumentDeclContext> argumentDecl() {
			return getRuleContexts(ArgumentDeclContext.class);
		}
		public ArgumentDeclContext argumentDecl(int i) {
			return getRuleContext(ArgumentDeclContext.class,i);
		}
		public ArgumentDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterArgumentDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitArgumentDeclList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitArgumentDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentDeclListContext argumentDeclList() throws RecognitionException {
		ArgumentDeclListContext _localctx = new ArgumentDeclListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_argumentDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			argumentDecl();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(154);
				match(COMMA);
				setState(155);
				argumentDecl();
				}
				}
				setState(160);
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

	public static class ArgumentDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public ArgumentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterArgumentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitArgumentDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitArgumentDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentDeclContext argumentDecl() throws RecognitionException {
		ArgumentDeclContext _localctx = new ArgumentDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argumentDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			type();
			setState(162);
			match(Identifier);
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

	public static class StatListContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (BANG - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (ADD - 70)) | (1L << (SUB - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				{
				setState(164);
				stat();
				}
				}
				setState(169);
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

	public static class IfStatContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(EllParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public IfStatSuffixContext ifStatSuffix() {
			return getRuleContext(IfStatSuffixContext.class,0);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(IF);
			setState(171);
			match(LPAREN);
			setState(172);
			expression(0);
			setState(173);
			match(RPAREN);
			setState(174);
			match(LBRACE);
			setState(175);
			statList();
			setState(176);
			match(RBRACE);
			setState(178);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(177);
				ifStatSuffix();
				}
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

	public static class IfStatSuffixContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(EllParser.ELSE, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public IfStatSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterIfStatSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitIfStatSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitIfStatSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatSuffixContext ifStatSuffix() throws RecognitionException {
		IfStatSuffixContext _localctx = new IfStatSuffixContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ELSE);
			setState(181);
			match(LBRACE);
			setState(182);
			statList();
			setState(183);
			match(RBRACE);
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

	public static class StatContext extends ParserRuleContext {
		public ExprStatContext exprStat() {
			return getRuleContext(ExprStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public DoWhileStatContext doWhileStat() {
			return getRuleContext(DoWhileStatContext.class,0);
		}
		public ForStatContext forStat() {
			return getRuleContext(ForStatContext.class,0);
		}
		public BreakStatContext breakStat() {
			return getRuleContext(BreakStatContext.class,0);
		}
		public ContinueStatContext continueStat() {
			return getRuleContext(ContinueStatContext.class,0);
		}
		public VarDeclStatContext varDeclStat() {
			return getRuleContext(VarDeclStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stat);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				exprStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				ifStat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				whileStat();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				doWhileStat();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(189);
				forStat();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 6);
				{
				setState(190);
				breakStat();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 7);
				{
				setState(191);
				continueStat();
				}
				break;
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				enterOuterAlt(_localctx, 8);
				{
				setState(192);
				varDeclStat();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				returnStat();
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

	public static class ReturnStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(RETURN);
			setState(198);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(197);
				expression(0);
				}
			}

			setState(200);
			match(SEMI);
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

	public static class VarDeclStatContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public VarDeclStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitVarDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			varDecl();
			setState(203);
			match(SEMI);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public TerminalNode INT() { return getToken(EllParser.INT, 0); }
		public TerminalNode LONG() { return getToken(EllParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(EllParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(EllParser.DOUBLE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(EllParser.IntegerLiteral, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(209);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(206);
				match(LBRACK);
				setState(207);
				match(IntegerLiteral);
				setState(208);
				match(RBRACK);
				}
			}

			setState(211);
			match(Identifier);
			setState(214);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(212);
				match(ASSIGN);
				setState(213);
				expression(0);
				}
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

	public static class BreakStatContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(EllParser.BREAK, 0); }
		public BreakStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(BREAK);
			setState(217);
			match(SEMI);
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

	public static class ContinueStatContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(EllParser.CONTINUE, 0); }
		public ContinueStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(CONTINUE);
			setState(220);
			match(SEMI);
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

	public static class WhileStatContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(EllParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(WHILE);
			setState(223);
			match(LPAREN);
			setState(224);
			expression(0);
			setState(225);
			match(RPAREN);
			setState(226);
			match(LBRACE);
			setState(227);
			statList();
			setState(228);
			match(RBRACE);
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

	public static class DoWhileStatContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(EllParser.DO, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(EllParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterDoWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitDoWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitDoWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(DO);
			setState(231);
			match(LBRACE);
			setState(232);
			statList();
			setState(233);
			match(RBRACE);
			setState(234);
			match(WHILE);
			setState(235);
			match(LPAREN);
			setState(236);
			expression(0);
			setState(237);
			match(RPAREN);
			setState(238);
			match(SEMI);
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

	public static class ForStatContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(EllParser.FOR, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(FOR);
			setState(241);
			match(LPAREN);
			setState(243);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (BANG - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (ADD - 70)) | (1L << (SUB - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				setState(242);
				forInit();
				}
			}

			setState(245);
			match(SEMI);
			setState(247);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(246);
				expression(0);
				}
			}

			setState(249);
			match(SEMI);
			setState(251);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(250);
				forUpdate();
				}
			}

			setState(253);
			match(RPAREN);
			setState(254);
			match(LBRACE);
			setState(255);
			statList();
			setState(256);
			match(RBRACE);
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

	public static class ForInitContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_forInit);
		try {
			setState(260);
			switch (_input.LA(1)) {
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				varDecl();
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				expressionList();
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

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			expressionList();
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			expression(0);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(265);
				match(COMMA);
				setState(266);
				expression(0);
				}
				}
				setState(271);
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

	public static class ExprStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			expression(0);
			setState(273);
			match(SEMI);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprPrimayContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExprPrimayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprPrimay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprPrimay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprPrimay(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAssignContext extends ExpressionContext {
		public TerminalNode ASSIGN() { return getToken(EllParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public ArrayAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitArrayAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitArrayAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMemberInvocationContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExprMemberInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprMemberInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprMemberInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprMemberInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAssignContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EllParser.ASSIGN, 0); }
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMidOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(EllParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(EllParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(EllParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(EllParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(EllParser.SUB, 0); }
		public ExprMidOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprMidOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprMidOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprMidOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprInvocationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExprInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNotOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprNotOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprNotOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprNotOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprNotOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprGetFieldContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(EllParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public ExprGetFieldContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprGetField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprGetField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprGetField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLogicCmpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LE() { return getToken(EllParser.LE, 0); }
		public TerminalNode GE() { return getToken(EllParser.GE, 0); }
		public TerminalNode GT() { return getToken(EllParser.GT, 0); }
		public TerminalNode LT() { return getToken(EllParser.LT, 0); }
		public TerminalNode EQUAL() { return getToken(EllParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(EllParser.NOTEQUAL, 0); }
		public ExprLogicCmpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprLogicCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprLogicCmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprLogicCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSelfOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(EllParser.INC, 0); }
		public TerminalNode DEC() { return getToken(EllParser.DEC, 0); }
		public ExprSelfOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprSelfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprSelfOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprSelfOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLogicContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(EllParser.AND, 0); }
		public TerminalNode OR() { return getToken(EllParser.OR, 0); }
		public ExprLogicContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSelfOpPreContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(EllParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(EllParser.SUB, 0); }
		public TerminalNode INC() { return getToken(EllParser.INC, 0); }
		public TerminalNode DEC() { return getToken(EllParser.DEC, 0); }
		public ExprSelfOpPreContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprSelfOpPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprSelfOpPre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprSelfOpPre(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprGetArrayElementContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public ExprGetArrayElementContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterExprGetArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitExprGetArrayElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitExprGetArrayElement(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(276);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (INC - 80)) | (1L << (DEC - 80)) | (1L << (ADD - 80)) | (1L << (SUB - 80)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(277);
				expression(10);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(BANG);
				setState(279);
				expression(9);
				}
				break;
			case 3:
				{
				_localctx = new ExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				match(Identifier);
				{
				setState(281);
				match(ASSIGN);
				}
				setState(282);
				expression(2);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(283);
				match(Identifier);
				setState(284);
				offset();
				}
				setState(286);
				match(ASSIGN);
				setState(287);
				expression(1);
				}
				break;
			case 5:
				{
				_localctx = new ExprPrimayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				primary();
				}
				break;
			case 6:
				{
				_localctx = new ExprMemberInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(Identifier);
				setState(291);
				arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(320);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(295);
						_la = _input.LA(1);
						if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (MUL - 84)) | (1L << (DIV - 84)) | (1L << (MOD - 84)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(296);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(298);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(299);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprLogicCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(301);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (GT - 68)) | (1L << (LT - 68)) | (1L << (LE - 68)) | (1L << (GE - 68)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(302);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprLogicCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(304);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(305);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprLogicContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(307);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(308);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(310);
						match(DOT);
						setState(311);
						match(Identifier);
						}
						break;
					case 7:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(313);
						match(DOT);
						setState(314);
						match(Identifier);
						setState(315);
						arguments();
						}
						break;
					case 8:
						{
						_localctx = new ExprSelfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(317);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					case 9:
						{
						_localctx = new ExprGetArrayElementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(319);
						offset();
						}
						break;
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class OffsetContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitOffset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitOffset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(LBRACK);
			setState(326);
			expression(0);
			setState(327);
			match(RBRACK);
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

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimayParenContext extends PrimaryContext {
		public TerminalNode LPAREN() { return getToken(EllParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EllParser.RPAREN, 0); }
		public PrimayParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterPrimayParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitPrimayParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitPrimayParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryIdentifierContext extends PrimaryContext {
		public TerminalNode Identifier() { return getToken(EllParser.Identifier, 0); }
		public PrimaryIdentifierContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterPrimaryIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitPrimaryIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitPrimaryIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryLiteralContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterPrimaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitPrimaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitPrimaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary);
		try {
			setState(335);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimayParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				match(LPAREN);
				setState(330);
				expression(0);
				setState(331);
				match(RPAREN);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
				_localctx = new PrimaryLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				match(Identifier);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(EllParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(EllParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(EllParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(EllParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(EllParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(LPAREN);
			setState(341);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(340);
				argumentList();
				}
			}

			setState(343);
			match(RPAREN);
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

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EllListener ) ((EllListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EllVisitor ) return ((EllVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			expression(0);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(346);
				match(COMMA);
				setState(347);
				expression(0);
				}
				}
				setState(352);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 29:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3l\u0164\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4[\n\4\r\4\16\4\\\5\4_\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5h\n\5\f\5\16\5k\13\5\3\5\3\5\3\5\7\5p\n\5\f\5\16"+
		"\5s\13\5\5\5u\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u0081\n"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\3\13"+
		"\3\13\3\13\3\13\5\13\u0093\n\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\r\7\r\u009f\n\r\f\r\16\r\u00a2\13\r\3\16\3\16\3\16\3\17\7\17\u00a8"+
		"\n\17\f\17\16\17\u00ab\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00b5\n\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u00c5\n\22\3\23\3\23\5\23\u00c9\n\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00d4\n\25\3\25\3\25\3\25\5\25"+
		"\u00d9\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\5\32\u00f6\n\32\3\32\3\32\5\32\u00fa\n\32\3\32\3\32\5\32\u00fe\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\5\33\u0107\n\33\3\34\3\34\3\35"+
		"\3\35\3\35\7\35\u010e\n\35\f\35\16\35\u0111\13\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u0127\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\7\37\u0143\n\37\f\37\16\37\u0146\13\37\3 \3 \3 \3 \3!"+
		"\3!\3!\3!\3!\3!\5!\u0152\n!\3\"\3\"\3#\3#\5#\u0158\n#\3#\3#\3$\3$\3$\7"+
		"$\u015f\n$\f$\16$\u0162\13$\3$\2\3<%\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\f\7\2\21\21\27\27\36\36  gg\6\2"+
		"\21\21\27\27\36\36  \3\2RU\4\2VW[[\3\2TU\4\2FGMN\4\2LLOO\3\2PQ\3\2RS\3"+
		"\2\66;\u0170\2K\3\2\2\2\4N\3\2\2\2\6^\3\2\2\2\bt\3\2\2\2\nv\3\2\2\2\f"+
		"z\3\2\2\2\16|\3\2\2\2\20\u0086\3\2\2\2\22\u008b\3\2\2\2\24\u008e\3\2\2"+
		"\2\26\u0099\3\2\2\2\30\u009b\3\2\2\2\32\u00a3\3\2\2\2\34\u00a9\3\2\2\2"+
		"\36\u00ac\3\2\2\2 \u00b6\3\2\2\2\"\u00c4\3\2\2\2$\u00c6\3\2\2\2&\u00cc"+
		"\3\2\2\2(\u00cf\3\2\2\2*\u00da\3\2\2\2,\u00dd\3\2\2\2.\u00e0\3\2\2\2\60"+
		"\u00e8\3\2\2\2\62\u00f2\3\2\2\2\64\u0106\3\2\2\2\66\u0108\3\2\2\28\u010a"+
		"\3\2\2\2:\u0112\3\2\2\2<\u0126\3\2\2\2>\u0147\3\2\2\2@\u0151\3\2\2\2B"+
		"\u0153\3\2\2\2D\u0155\3\2\2\2F\u015b\3\2\2\2HJ\5\4\3\2IH\3\2\2\2JM\3\2"+
		"\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2\2\2MK\3\2\2\2NO\7g\2\2OP\7K\2\2PQ\5\6"+
		"\4\2QR\7B\2\2R\5\3\2\2\2ST\7\3\2\2T_\7g\2\2UV\7\"\2\2V_\7g\2\2W_\5<\37"+
		"\2XY\7g\2\2Y[\5\b\5\2ZX\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2"+
		"\2\2^S\3\2\2\2^U\3\2\2\2^W\3\2\2\2^Z\3\2\2\2_\7\3\2\2\2`a\7g\2\2ab\7E"+
		"\2\2bi\5<\37\2cd\7C\2\2de\7g\2\2ef\7E\2\2fh\5<\37\2gc\3\2\2\2hk\3\2\2"+
		"\2ig\3\2\2\2ij\3\2\2\2ju\3\2\2\2ki\3\2\2\2lq\5<\37\2mn\7C\2\2np\5<\37"+
		"\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2ru\3\2\2\2sq\3\2\2\2t`\3\2\2"+
		"\2tl\3\2\2\2u\t\3\2\2\2vw\7g\2\2wx\7E\2\2xy\5<\37\2y\13\3\2\2\2z{\5\2"+
		"\2\2{\r\3\2\2\2|}\7\f\2\2}\u0080\7g\2\2~\177\7\24\2\2\177\u0081\7g\2\2"+
		"\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7"+
		">\2\2\u0083\u0084\5\20\t\2\u0084\u0085\7?\2\2\u0085\17\3\2\2\2\u0086\u0087"+
		"\5\22\n\2\u0087\21\3\2\2\2\u0088\u008a\5\24\13\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\23\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008e\u008f\5\26\f\2\u008f\u0090\7g\2\2\u0090\u0092"+
		"\7<\2\2\u0091\u0093\5\30\r\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\7=\2\2\u0095\u0096\7>\2\2\u0096\u0097\5\34"+
		"\17\2\u0097\u0098\7?\2\2\u0098\25\3\2\2\2\u0099\u009a\t\2\2\2\u009a\27"+
		"\3\2\2\2\u009b\u00a0\5\32\16\2\u009c\u009d\7C\2\2\u009d\u009f\5\32\16"+
		"\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\31\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\5\26\f\2\u00a4"+
		"\u00a5\7g\2\2\u00a5\33\3\2\2\2\u00a6\u00a8\5\"\22\2\u00a7\u00a6\3\2\2"+
		"\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\35"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7\31\2\2\u00ad\u00ae\7<\2\2\u00ae"+
		"\u00af\5<\37\2\u00af\u00b0\7=\2\2\u00b0\u00b1\7>\2\2\u00b1\u00b2\5\34"+
		"\17\2\u00b2\u00b4\7?\2\2\u00b3\u00b5\5 \21\2\u00b4\u00b3\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\37\3\2\2\2\u00b6\u00b7\7\22\2\2\u00b7\u00b8\7>\2"+
		"\2\u00b8\u00b9\5\34\17\2\u00b9\u00ba\7?\2\2\u00ba!\3\2\2\2\u00bb\u00c5"+
		"\5:\36\2\u00bc\u00c5\5\36\20\2\u00bd\u00c5\5.\30\2\u00be\u00c5\5\60\31"+
		"\2\u00bf\u00c5\5\62\32\2\u00c0\u00c5\5*\26\2\u00c1\u00c5\5,\27\2\u00c2"+
		"\u00c5\5&\24\2\u00c3\u00c5\5$\23\2\u00c4\u00bb\3\2\2\2\u00c4\u00bc\3\2"+
		"\2\2\u00c4\u00bd\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4"+
		"\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2"+
		"\2\2\u00c5#\3\2\2\2\u00c6\u00c8\7\'\2\2\u00c7\u00c9\5<\37\2\u00c8\u00c7"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7B\2\2\u00cb"+
		"%\3\2\2\2\u00cc\u00cd\5(\25\2\u00cd\u00ce\7B\2\2\u00ce\'\3\2\2\2\u00cf"+
		"\u00d3\t\3\2\2\u00d0\u00d1\7@\2\2\u00d1\u00d2\7\66\2\2\u00d2\u00d4\7A"+
		"\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d8\7g\2\2\u00d6\u00d7\7E\2\2\u00d7\u00d9\5<\37\2\u00d8\u00d6\3\2\2"+
		"\2\u00d8\u00d9\3\2\2\2\u00d9)\3\2\2\2\u00da\u00db\7\7\2\2\u00db\u00dc"+
		"\7B\2\2\u00dc+\3\2\2\2\u00dd\u00de\7\16\2\2\u00de\u00df\7B\2\2\u00df-"+
		"\3\2\2\2\u00e0\u00e1\7\65\2\2\u00e1\u00e2\7<\2\2\u00e2\u00e3\5<\37\2\u00e3"+
		"\u00e4\7=\2\2\u00e4\u00e5\7>\2\2\u00e5\u00e6\5\34\17\2\u00e6\u00e7\7?"+
		"\2\2\u00e7/\3\2\2\2\u00e8\u00e9\7\20\2\2\u00e9\u00ea\7>\2\2\u00ea\u00eb"+
		"\5\34\17\2\u00eb\u00ec\7?\2\2\u00ec\u00ed\7\65\2\2\u00ed\u00ee\7<\2\2"+
		"\u00ee\u00ef\5<\37\2\u00ef\u00f0\7=\2\2\u00f0\u00f1\7B\2\2\u00f1\61\3"+
		"\2\2\2\u00f2\u00f3\7\30\2\2\u00f3\u00f5\7<\2\2\u00f4\u00f6\5\64\33\2\u00f5"+
		"\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\7B"+
		"\2\2\u00f8\u00fa\5<\37\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fd\7B\2\2\u00fc\u00fe\5\66\34\2\u00fd\u00fc\3"+
		"\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7=\2\2\u0100"+
		"\u0101\7>\2\2\u0101\u0102\5\34\17\2\u0102\u0103\7?\2\2\u0103\63\3\2\2"+
		"\2\u0104\u0107\5(\25\2\u0105\u0107\58\35\2\u0106\u0104\3\2\2\2\u0106\u0105"+
		"\3\2\2\2\u0107\65\3\2\2\2\u0108\u0109\58\35\2\u0109\67\3\2\2\2\u010a\u010f"+
		"\5<\37\2\u010b\u010c\7C\2\2\u010c\u010e\5<\37\2\u010d\u010b\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u01109\3\2\2\2"+
		"\u0111\u010f\3\2\2\2\u0112\u0113\5<\37\2\u0113\u0114\7B\2\2\u0114;\3\2"+
		"\2\2\u0115\u0116\b\37\1\2\u0116\u0117\t\4\2\2\u0117\u0127\5<\37\f\u0118"+
		"\u0119\7H\2\2\u0119\u0127\5<\37\13\u011a\u011b\7g\2\2\u011b\u011c\7E\2"+
		"\2\u011c\u0127\5<\37\4\u011d\u011e\7g\2\2\u011e\u011f\5> \2\u011f\u0120"+
		"\3\2\2\2\u0120\u0121\7E\2\2\u0121\u0122\5<\37\3\u0122\u0127\3\2\2\2\u0123"+
		"\u0127\5@!\2\u0124\u0125\7g\2\2\u0125\u0127\5D#\2\u0126\u0115\3\2\2\2"+
		"\u0126\u0118\3\2\2\2\u0126\u011a\3\2\2\2\u0126\u011d\3\2\2\2\u0126\u0123"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0144\3\2\2\2\u0128\u0129\f\n\2\2\u0129"+
		"\u012a\t\5\2\2\u012a\u0143\5<\37\13\u012b\u012c\f\t\2\2\u012c\u012d\t"+
		"\6\2\2\u012d\u0143\5<\37\n\u012e\u012f\f\b\2\2\u012f\u0130\t\7\2\2\u0130"+
		"\u0143\5<\37\t\u0131\u0132\f\7\2\2\u0132\u0133\t\b\2\2\u0133\u0143\5<"+
		"\37\b\u0134\u0135\f\6\2\2\u0135\u0136\t\t\2\2\u0136\u0143\5<\37\7\u0137"+
		"\u0138\f\20\2\2\u0138\u0139\7D\2\2\u0139\u0143\7g\2\2\u013a\u013b\f\17"+
		"\2\2\u013b\u013c\7D\2\2\u013c\u013d\7g\2\2\u013d\u0143\5D#\2\u013e\u013f"+
		"\f\r\2\2\u013f\u0143\t\n\2\2\u0140\u0141\f\5\2\2\u0141\u0143\5> \2\u0142"+
		"\u0128\3\2\2\2\u0142\u012b\3\2\2\2\u0142\u012e\3\2\2\2\u0142\u0131\3\2"+
		"\2\2\u0142\u0134\3\2\2\2\u0142\u0137\3\2\2\2\u0142\u013a\3\2\2\2\u0142"+
		"\u013e\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0144\u0145\3\2\2\2\u0145=\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148"+
		"\7@\2\2\u0148\u0149\5<\37\2\u0149\u014a\7A\2\2\u014a?\3\2\2\2\u014b\u014c"+
		"\7<\2\2\u014c\u014d\5<\37\2\u014d\u014e\7=\2\2\u014e\u0152\3\2\2\2\u014f"+
		"\u0152\5B\"\2\u0150\u0152\7g\2\2\u0151\u014b\3\2\2\2\u0151\u014f\3\2\2"+
		"\2\u0151\u0150\3\2\2\2\u0152A\3\2\2\2\u0153\u0154\t\13\2\2\u0154C\3\2"+
		"\2\2\u0155\u0157\7<\2\2\u0156\u0158\5F$\2\u0157\u0156\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\7=\2\2\u015aE\3\2\2\2\u015b\u0160"+
		"\5<\37\2\u015c\u015d\7C\2\2\u015d\u015f\5<\37\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161G\3\2\2\2"+
		"\u0162\u0160\3\2\2\2\35K\\^iqt\u0080\u008b\u0092\u00a0\u00a9\u00b4\u00c4"+
		"\u00c8\u00d3\u00d8\u00f5\u00f9\u00fd\u0106\u010f\u0126\u0142\u0144\u0151"+
		"\u0157\u0160";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
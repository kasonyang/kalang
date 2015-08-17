// Generated from Kava.g4 by ANTLR 4.5
package kava.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KavaParser extends Parser {
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
		RULE_dslStatList = 0, RULE_dslStat = 1, RULE_dslExpr = 2, RULE_dslParam = 3, 
		RULE_start = 4, RULE_compiliantUnit = 5, RULE_classBody = 6, RULE_methodDeclList = 7, 
		RULE_methodDecl = 8, RULE_statList = 9, RULE_ifStat = 10, RULE_ifStatSuffix = 11, 
		RULE_stat = 12, RULE_varDeclStat = 13, RULE_varDecl = 14, RULE_breakStat = 15, 
		RULE_continueStat = 16, RULE_whileStat = 17, RULE_doWhileStat = 18, RULE_forStat = 19, 
		RULE_forInit = 20, RULE_forUpdate = 21, RULE_expressionList = 22, RULE_exprStat = 23, 
		RULE_expression = 24, RULE_offset = 25, RULE_primary = 26, RULE_literal = 27, 
		RULE_genericInvocation = 28, RULE_arguments = 29, RULE_argumentList = 30;
	public static final String[] ruleNames = {
		"dslStatList", "dslStat", "dslExpr", "dslParam", "start", "compiliantUnit", 
		"classBody", "methodDeclList", "methodDecl", "statList", "ifStat", "ifStatSuffix", 
		"stat", "varDeclStat", "varDecl", "breakStat", "continueStat", "whileStat", 
		"doWhileStat", "forStat", "forInit", "forUpdate", "expressionList", "exprStat", 
		"expression", "offset", "primary", "literal", "genericInvocation", "arguments", 
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
	public String getGrammarFileName() { return "Kava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KavaParser(TokenStream input) {
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslStatList(this);
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(62);
				dslStat();
				}
				}
				setState(67);
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
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public DslExprContext dslExpr() {
			return getRuleContext(DslExprContext.class,0);
		}
		public DslStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslStatContext dslStat() throws RecognitionException {
		DslStatContext _localctx = new DslStatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dslStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(Identifier);
			setState(69);
			match(COLON);
			setState(70);
			dslExpr();
			setState(71);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DslVarDeclContext extends DslExprContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public DslVarDeclContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DslVarNewContext extends DslExprContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public DslVarNewContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslVarNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslVarNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslVarNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DslChainStatContext extends DslExprContext {
		public List<TerminalNode> Identifier() { return getTokens(KavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KavaParser.Identifier, i);
		}
		public List<DslParamContext> dslParam() {
			return getRuleContexts(DslParamContext.class);
		}
		public DslParamContext dslParam(int i) {
			return getRuleContext(DslParamContext.class,i);
		}
		public DslChainStatContext(DslExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslChainStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslChainStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslChainStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslExprContext dslExpr() throws RecognitionException {
		DslExprContext _localctx = new DslExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dslExpr);
		int _la;
		try {
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new DslVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(T__0);
				setState(74);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new DslVarNewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(NEW);
				setState(76);
				match(Identifier);
				}
				break;
			case 3:
				_localctx = new DslExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				expression(0);
				}
				break;
			case 4:
				_localctx = new DslChainStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					match(Identifier);
					setState(79);
					dslParam();
					}
					}
					setState(82); 
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

	public static class DslParamContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DslParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDslParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDslParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDslParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslParamContext dslParam() throws RecognitionException {
		DslParamContext _localctx = new DslParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dslParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			expression(0);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(87);
				match(COMMA);
				setState(88);
				expression(0);
				}
				}
				setState(93);
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

	public static class StartContext extends ParserRuleContext {
		public CompiliantUnitContext compiliantUnit() {
			return getRuleContext(CompiliantUnitContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			compiliantUnit();
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
		public List<TerminalNode> Identifier() { return getTokens(KavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KavaParser.Identifier, i);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterCompiliantUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitCompiliantUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitCompiliantUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompiliantUnitContext compiliantUnit() throws RecognitionException {
		CompiliantUnitContext _localctx = new CompiliantUnitContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compiliantUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(CLASS);
			setState(97);
			match(Identifier);
			setState(100);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(98);
				match(EXTENDS);
				setState(99);
				match(Identifier);
				}
			}

			setState(102);
			match(LBRACE);
			setState(103);
			classBody();
			setState(104);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterMethodDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitMethodDeclList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitMethodDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclListContext methodDeclList() throws RecognitionException {
		MethodDeclListContext _localctx = new MethodDeclListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(108);
				methodDecl();
				}
				}
				setState(113);
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
		public List<TerminalNode> Identifier() { return getTokens(KavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KavaParser.Identifier, i);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(Identifier);
			setState(115);
			match(Identifier);
			setState(116);
			arguments();
			setState(117);
			match(LBRACE);
			setState(118);
			statList();
			setState(119);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (BANG - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (ADD - 70)) | (1L << (SUB - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				{
				setState(121);
				stat();
				}
				}
				setState(126);
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
		public TerminalNode IF() { return getToken(KavaParser.IF, 0); }
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(IF);
			setState(128);
			match(LPAREN);
			setState(129);
			expression(0);
			setState(130);
			match(RPAREN);
			setState(131);
			match(LBRACE);
			setState(132);
			statList();
			setState(133);
			match(RBRACE);
			setState(135);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(134);
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
		public TerminalNode ELSE() { return getToken(KavaParser.ELSE, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public IfStatSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterIfStatSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitIfStatSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitIfStatSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatSuffixContext ifStatSuffix() throws RecognitionException {
		IfStatSuffixContext _localctx = new IfStatSuffixContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ELSE);
			setState(138);
			match(LBRACE);
			setState(139);
			statList();
			setState(140);
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stat);
		try {
			setState(150);
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
				setState(142);
				exprStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				ifStat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				whileStat();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				doWhileStat();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				forStat();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				breakStat();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 7);
				{
				setState(148);
				continueStat();
				}
				break;
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				varDeclStat();
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitVarDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			varDecl();
			setState(153);
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
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public TerminalNode INT() { return getToken(KavaParser.INT, 0); }
		public TerminalNode LONG() { return getToken(KavaParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(KavaParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(KavaParser.DOUBLE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(KavaParser.IntegerLiteral, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(159);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(156);
				match(LBRACK);
				setState(157);
				match(IntegerLiteral);
				setState(158);
				match(RBRACK);
				}
			}

			setState(161);
			match(Identifier);
			setState(164);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(162);
				match(ASSIGN);
				setState(163);
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
		public TerminalNode BREAK() { return getToken(KavaParser.BREAK, 0); }
		public BreakStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(BREAK);
			setState(167);
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
		public TerminalNode CONTINUE() { return getToken(KavaParser.CONTINUE, 0); }
		public ContinueStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(CONTINUE);
			setState(170);
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
		public TerminalNode WHILE() { return getToken(KavaParser.WHILE, 0); }
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(WHILE);
			setState(173);
			match(LPAREN);
			setState(174);
			expression(0);
			setState(175);
			match(RPAREN);
			setState(176);
			match(LBRACE);
			setState(177);
			statList();
			setState(178);
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
		public TerminalNode DO() { return getToken(KavaParser.DO, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(KavaParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterDoWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitDoWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitDoWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(DO);
			setState(181);
			match(LBRACE);
			setState(182);
			statList();
			setState(183);
			match(RBRACE);
			setState(184);
			match(WHILE);
			setState(185);
			match(LPAREN);
			setState(186);
			expression(0);
			setState(187);
			match(RPAREN);
			setState(188);
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
		public TerminalNode FOR() { return getToken(KavaParser.FOR, 0); }
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(FOR);
			setState(191);
			match(LPAREN);
			setState(193);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (BANG - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (ADD - 70)) | (1L << (SUB - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				setState(192);
				forInit();
				}
			}

			setState(195);
			match(SEMI);
			setState(197);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(196);
				expression(0);
				}
			}

			setState(199);
			match(SEMI);
			setState(201);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(200);
				forUpdate();
				}
			}

			setState(203);
			match(RPAREN);
			setState(204);
			match(LBRACE);
			setState(205);
			statList();
			setState(206);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_forInit);
		try {
			setState(210);
			switch (_input.LA(1)) {
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
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
				setState(209);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			expression(0);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(215);
				match(COMMA);
				setState(216);
				expression(0);
				}
				}
				setState(221);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			expression(0);
			setState(223);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprPrimay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprPrimay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprPrimay(this);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprNotOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprNotOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprNotOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprGetFieldContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(KavaParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ExprGetFieldContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprGetField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprGetField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprGetField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAssignContext extends ExpressionContext {
		public TerminalNode ASSIGN() { return getToken(KavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public ArrayAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitArrayAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitArrayAssign(this);
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
		public TerminalNode LE() { return getToken(KavaParser.LE, 0); }
		public TerminalNode GE() { return getToken(KavaParser.GE, 0); }
		public TerminalNode GT() { return getToken(KavaParser.GT, 0); }
		public TerminalNode LT() { return getToken(KavaParser.LT, 0); }
		public TerminalNode EQUAL() { return getToken(KavaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(KavaParser.NOTEQUAL, 0); }
		public ExprLogicCmpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprLogicCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprLogicCmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprLogicCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAssignContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(KavaParser.ASSIGN, 0); }
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprAssign(this);
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
		public TerminalNode MUL() { return getToken(KavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(KavaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(KavaParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(KavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(KavaParser.SUB, 0); }
		public ExprMidOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprMidOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprMidOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprMidOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSelfOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(KavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(KavaParser.DEC, 0); }
		public ExprSelfOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprSelfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprSelfOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprSelfOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprInvocationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExprInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprInvocation(this);
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
		public TerminalNode AND() { return getToken(KavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(KavaParser.OR, 0); }
		public ExprLogicContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSelfOpPreContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(KavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(KavaParser.SUB, 0); }
		public TerminalNode INC() { return getToken(KavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(KavaParser.DEC, 0); }
		public ExprSelfOpPreContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprSelfOpPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprSelfOpPre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprSelfOpPre(this);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprGetArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprGetArrayElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitExprGetArrayElement(this);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(226);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (INC - 80)) | (1L << (DEC - 80)) | (1L << (ADD - 80)) | (1L << (SUB - 80)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(227);
				expression(10);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(BANG);
				setState(229);
				expression(9);
				}
				break;
			case 3:
				{
				_localctx = new ExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(Identifier);
				{
				setState(231);
				match(ASSIGN);
				}
				setState(232);
				expression(2);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(233);
				match(Identifier);
				setState(234);
				offset();
				}
				setState(236);
				match(ASSIGN);
				setState(237);
				expression(1);
				}
				break;
			case 5:
				{
				_localctx = new ExprPrimayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				primary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(268);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(243);
						_la = _input.LA(1);
						if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (MUL - 84)) | (1L << (DIV - 84)) | (1L << (MOD - 84)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(244);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(245);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(246);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(247);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprLogicCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(249);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (GT - 68)) | (1L << (LT - 68)) | (1L << (LE - 68)) | (1L << (GE - 68)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(250);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprLogicCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(252);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(253);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprLogicContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(255);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(256);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(258);
						match(DOT);
						setState(259);
						match(Identifier);
						}
						break;
					case 7:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(261);
						match(DOT);
						setState(262);
						match(Identifier);
						setState(263);
						arguments();
						}
						break;
					case 8:
						{
						_localctx = new ExprSelfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(265);
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
						setState(266);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(267);
						offset();
						}
						break;
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitOffset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitOffset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(LBRACK);
			setState(274);
			expression(0);
			setState(275);
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
		public TerminalNode LPAREN() { return getToken(KavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KavaParser.RPAREN, 0); }
		public PrimayParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterPrimayParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitPrimayParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitPrimayParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryIdentifierContext extends PrimaryContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public PrimaryIdentifierContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterPrimaryIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitPrimaryIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitPrimaryIdentifier(this);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterPrimaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitPrimaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitPrimaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary);
		try {
			setState(283);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimayParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				match(LPAREN);
				setState(278);
				expression(0);
				setState(279);
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
				setState(281);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
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
		public TerminalNode IntegerLiteral() { return getToken(KavaParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(KavaParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(KavaParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(KavaParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KavaParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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

	public static class GenericInvocationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public GenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitGenericInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitGenericInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericInvocationContext genericInvocation() throws RecognitionException {
		GenericInvocationContext _localctx = new GenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_genericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(Identifier);
			setState(288);
			arguments();
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(LPAREN);
			setState(292);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(291);
				argumentList();
				}
			}

			setState(294);
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KavaVisitor ) return ((KavaVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			expression(0);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(297);
				match(COMMA);
				setState(298);
				expression(0);
				}
				}
				setState(303);
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
		case 24:
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
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3l\u0133\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\6\4S\n\4\r\4\16\4T\5\4W\n\4\3\5\3\5\3\5\7\5\\\n\5\f\5\16\5_\13\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\5\7g\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\7\tp\n\t\f"+
		"\t\16\ts\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\7\13}\n\13\f\13\16\13\u0080"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008a\n\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0099\n\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\5\20\u00a2\n\20\3\20\3\20\3\20\5\20\u00a7\n\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25"+
		"\u00c4\n\25\3\25\3\25\5\25\u00c8\n\25\3\25\3\25\5\25\u00cc\n\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\5\26\u00d5\n\26\3\27\3\27\3\30\3\30\3\30"+
		"\7\30\u00dc\n\30\f\30\16\30\u00df\13\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00f3"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u010f\n\32\f\32\16\32\u0112\13\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u011e\n\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\5\37"+
		"\u0127\n\37\3\37\3\37\3 \3 \3 \7 \u012e\n \f \16 \u0131\13 \3 \2\3\62"+
		"!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\13"+
		"\6\2\21\21\27\27\36\36  \3\2RU\4\2VW[[\3\2TU\4\2FGMN\4\2LLOO\3\2PQ\3\2"+
		"RS\3\2\66;\u013c\2C\3\2\2\2\4F\3\2\2\2\6V\3\2\2\2\bX\3\2\2\2\n`\3\2\2"+
		"\2\fb\3\2\2\2\16l\3\2\2\2\20q\3\2\2\2\22t\3\2\2\2\24~\3\2\2\2\26\u0081"+
		"\3\2\2\2\30\u008b\3\2\2\2\32\u0098\3\2\2\2\34\u009a\3\2\2\2\36\u009d\3"+
		"\2\2\2 \u00a8\3\2\2\2\"\u00ab\3\2\2\2$\u00ae\3\2\2\2&\u00b6\3\2\2\2(\u00c0"+
		"\3\2\2\2*\u00d4\3\2\2\2,\u00d6\3\2\2\2.\u00d8\3\2\2\2\60\u00e0\3\2\2\2"+
		"\62\u00f2\3\2\2\2\64\u0113\3\2\2\2\66\u011d\3\2\2\28\u011f\3\2\2\2:\u0121"+
		"\3\2\2\2<\u0124\3\2\2\2>\u012a\3\2\2\2@B\5\4\3\2A@\3\2\2\2BE\3\2\2\2C"+
		"A\3\2\2\2CD\3\2\2\2D\3\3\2\2\2EC\3\2\2\2FG\7g\2\2GH\7K\2\2HI\5\6\4\2I"+
		"J\7B\2\2J\5\3\2\2\2KL\7\3\2\2LW\7g\2\2MN\7\"\2\2NW\7g\2\2OW\5\62\32\2"+
		"PQ\7g\2\2QS\5\b\5\2RP\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2"+
		"VK\3\2\2\2VM\3\2\2\2VO\3\2\2\2VR\3\2\2\2W\7\3\2\2\2X]\5\62\32\2YZ\7C\2"+
		"\2Z\\\5\62\32\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\t\3\2\2\2_]"+
		"\3\2\2\2`a\5\f\7\2a\13\3\2\2\2bc\7\f\2\2cf\7g\2\2de\7\24\2\2eg\7g\2\2"+
		"fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7>\2\2ij\5\16\b\2jk\7?\2\2k\r\3\2\2\2"+
		"lm\5\20\t\2m\17\3\2\2\2np\5\22\n\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2"+
		"\2\2r\21\3\2\2\2sq\3\2\2\2tu\7g\2\2uv\7g\2\2vw\5<\37\2wx\7>\2\2xy\5\24"+
		"\13\2yz\7?\2\2z\23\3\2\2\2{}\5\32\16\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2"+
		"\2\2~\177\3\2\2\2\177\25\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\31\2\2\u0082"+
		"\u0083\7<\2\2\u0083\u0084\5\62\32\2\u0084\u0085\7=\2\2\u0085\u0086\7>"+
		"\2\2\u0086\u0087\5\24\13\2\u0087\u0089\7?\2\2\u0088\u008a\5\30\r\2\u0089"+
		"\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\27\3\2\2\2\u008b\u008c\7\22\2"+
		"\2\u008c\u008d\7>\2\2\u008d\u008e\5\24\13\2\u008e\u008f\7?\2\2\u008f\31"+
		"\3\2\2\2\u0090\u0099\5\60\31\2\u0091\u0099\5\26\f\2\u0092\u0099\5$\23"+
		"\2\u0093\u0099\5&\24\2\u0094\u0099\5(\25\2\u0095\u0099\5 \21\2\u0096\u0099"+
		"\5\"\22\2\u0097\u0099\5\34\17\2\u0098\u0090\3\2\2\2\u0098\u0091\3\2\2"+
		"\2\u0098\u0092\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0095"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\33\3\2\2\2\u009a"+
		"\u009b\5\36\20\2\u009b\u009c\7B\2\2\u009c\35\3\2\2\2\u009d\u00a1\t\2\2"+
		"\2\u009e\u009f\7@\2\2\u009f\u00a0\7\66\2\2\u00a0\u00a2\7A\2\2\u00a1\u009e"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\7g\2\2\u00a4"+
		"\u00a5\7E\2\2\u00a5\u00a7\5\62\32\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3"+
		"\2\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\7\7\2\2\u00a9\u00aa\7B\2\2\u00aa!"+
		"\3\2\2\2\u00ab\u00ac\7\16\2\2\u00ac\u00ad\7B\2\2\u00ad#\3\2\2\2\u00ae"+
		"\u00af\7\65\2\2\u00af\u00b0\7<\2\2\u00b0\u00b1\5\62\32\2\u00b1\u00b2\7"+
		"=\2\2\u00b2\u00b3\7>\2\2\u00b3\u00b4\5\24\13\2\u00b4\u00b5\7?\2\2\u00b5"+
		"%\3\2\2\2\u00b6\u00b7\7\20\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9\5\24\13"+
		"\2\u00b9\u00ba\7?\2\2\u00ba\u00bb\7\65\2\2\u00bb\u00bc\7<\2\2\u00bc\u00bd"+
		"\5\62\32\2\u00bd\u00be\7=\2\2\u00be\u00bf\7B\2\2\u00bf\'\3\2\2\2\u00c0"+
		"\u00c1\7\30\2\2\u00c1\u00c3\7<\2\2\u00c2\u00c4\5*\26\2\u00c3\u00c2\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\7B\2\2\u00c6"+
		"\u00c8\5\62\32\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\u00cb\7B\2\2\u00ca\u00cc\5,\27\2\u00cb\u00ca\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7=\2\2\u00ce\u00cf\7>\2"+
		"\2\u00cf\u00d0\5\24\13\2\u00d0\u00d1\7?\2\2\u00d1)\3\2\2\2\u00d2\u00d5"+
		"\5\36\20\2\u00d3\u00d5\5.\30\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2"+
		"\u00d5+\3\2\2\2\u00d6\u00d7\5.\30\2\u00d7-\3\2\2\2\u00d8\u00dd\5\62\32"+
		"\2\u00d9\u00da\7C\2\2\u00da\u00dc\5\62\32\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de/\3\2\2\2"+
		"\u00df\u00dd\3\2\2\2\u00e0\u00e1\5\62\32\2\u00e1\u00e2\7B\2\2\u00e2\61"+
		"\3\2\2\2\u00e3\u00e4\b\32\1\2\u00e4\u00e5\t\3\2\2\u00e5\u00f3\5\62\32"+
		"\f\u00e6\u00e7\7H\2\2\u00e7\u00f3\5\62\32\13\u00e8\u00e9\7g\2\2\u00e9"+
		"\u00ea\7E\2\2\u00ea\u00f3\5\62\32\4\u00eb\u00ec\7g\2\2\u00ec\u00ed\5\64"+
		"\33\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7E\2\2\u00ef\u00f0\5\62\32\3\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00f3\5\66\34\2\u00f2\u00e3\3\2\2\2\u00f2\u00e6\3"+
		"\2\2\2\u00f2\u00e8\3\2\2\2\u00f2\u00eb\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u0110\3\2\2\2\u00f4\u00f5\f\n\2\2\u00f5\u00f6\t\4\2\2\u00f6\u010f\5\62"+
		"\32\13\u00f7\u00f8\f\t\2\2\u00f8\u00f9\t\5\2\2\u00f9\u010f\5\62\32\n\u00fa"+
		"\u00fb\f\b\2\2\u00fb\u00fc\t\6\2\2\u00fc\u010f\5\62\32\t\u00fd\u00fe\f"+
		"\7\2\2\u00fe\u00ff\t\7\2\2\u00ff\u010f\5\62\32\b\u0100\u0101\f\6\2\2\u0101"+
		"\u0102\t\b\2\2\u0102\u010f\5\62\32\7\u0103\u0104\f\17\2\2\u0104\u0105"+
		"\7D\2\2\u0105\u010f\7g\2\2\u0106\u0107\f\16\2\2\u0107\u0108\7D\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u010f\5<\37\2\u010a\u010b\f\r\2\2\u010b\u010f\t\t"+
		"\2\2\u010c\u010d\f\5\2\2\u010d\u010f\5\64\33\2\u010e\u00f4\3\2\2\2\u010e"+
		"\u00f7\3\2\2\2\u010e\u00fa\3\2\2\2\u010e\u00fd\3\2\2\2\u010e\u0100\3\2"+
		"\2\2\u010e\u0103\3\2\2\2\u010e\u0106\3\2\2\2\u010e\u010a\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\63\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7@\2\2\u0114\u0115"+
		"\5\62\32\2\u0115\u0116\7A\2\2\u0116\65\3\2\2\2\u0117\u0118\7<\2\2\u0118"+
		"\u0119\5\62\32\2\u0119\u011a\7=\2\2\u011a\u011e\3\2\2\2\u011b\u011e\5"+
		"8\35\2\u011c\u011e\7g\2\2\u011d\u0117\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011c\3\2\2\2\u011e\67\3\2\2\2\u011f\u0120\t\n\2\2\u01209\3\2\2\2\u0121"+
		"\u0122\7g\2\2\u0122\u0123\5<\37\2\u0123;\3\2\2\2\u0124\u0126\7<\2\2\u0125"+
		"\u0127\5> \2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2\2"+
		"\2\u0128\u0129\7=\2\2\u0129=\3\2\2\2\u012a\u012f\5\62\32\2\u012b\u012c"+
		"\7C\2\2\u012c\u012e\5\62\32\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2"+
		"\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130?\3\2\2\2\u0131\u012f\3"+
		"\2\2\2\30CTV]fq~\u0089\u0098\u00a1\u00a6\u00c3\u00c7\u00cb\u00d4\u00dd"+
		"\u00f2\u010e\u0110\u011d\u0126\u012f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
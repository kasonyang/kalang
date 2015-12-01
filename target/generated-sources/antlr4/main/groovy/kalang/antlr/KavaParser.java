// Generated from Kava.g4 by ANTLR 4.4
package main.groovy.kalang.antlr;
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

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
	public static final String[] tokenNames = {
		"<INVALID>", "'as'", "'abstract'", "'assert'", "'boolean'", "'break'", 
		"'byte'", "'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", 
		"'default'", "'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", 
		"'finally'", "'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", 
		"'instanceof'", "'int'", "'interface'", "'long'", "'native'", "'new'", 
		"'package'", "'private'", "'protected'", "'public'", "'return'", "'short'", 
		"'static'", "'strictfp'", "'super'", "'switch'", "'synchronized'", "'this'", 
		"'throw'", "'throws'", "'transient'", "'try'", "'void'", "'volatile'", 
		"'while'", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", 
		"CharacterLiteral", "StringLiteral", "'null'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", 
		"'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", 
		"'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", 
		"'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", 
		"'>>>='", "Identifier", "'@'", "'...'", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_dslStatList = 0, RULE_dslStat = 1, RULE_dslExpr = 2, RULE_dslParam = 3, 
		RULE_start = 4, RULE_compiliantUnit = 5, RULE_classBody = 6, RULE_methodDeclList = 7, 
		RULE_methodDecl = 8, RULE_type = 9, RULE_argumentDeclList = 10, RULE_argumentDecl = 11, 
		RULE_statList = 12, RULE_ifStat = 13, RULE_ifStatSuffix = 14, RULE_stat = 15, 
		RULE_returnStat = 16, RULE_varDeclStat = 17, RULE_varDecl = 18, RULE_breakStat = 19, 
		RULE_continueStat = 20, RULE_whileStat = 21, RULE_doWhileStat = 22, RULE_forStat = 23, 
		RULE_forInit = 24, RULE_forUpdate = 25, RULE_expressionList = 26, RULE_exprStat = 27, 
		RULE_expression = 28, RULE_offset = 29, RULE_primary = 30, RULE_literal = 31, 
		RULE_arguments = 32, RULE_argumentList = 33;
	public static final String[] ruleNames = {
		"dslStatList", "dslStat", "dslExpr", "dslParam", "start", "compiliantUnit", 
		"classBody", "methodDeclList", "methodDecl", "type", "argumentDeclList", 
		"argumentDecl", "statList", "ifStat", "ifStatSuffix", "stat", "returnStat", 
		"varDeclStat", "varDecl", "breakStat", "continueStat", "whileStat", "doWhileStat", 
		"forStat", "forInit", "forUpdate", "expressionList", "exprStat", "expression", 
		"offset", "primary", "literal", "arguments", "argumentList"
	};

	@Override
	public String getGrammarFileName() { return "Kava.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
	}

	public final DslStatListContext dslStatList() throws RecognitionException {
		DslStatListContext _localctx = new DslStatListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dslStatList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(68); dslStat();
				}
				}
				setState(73);
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
	}

	public final DslStatContext dslStat() throws RecognitionException {
		DslStatContext _localctx = new DslStatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dslStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(Identifier);
			setState(75); match(COLON);
			setState(76); dslExpr();
			setState(77); match(SEMI);
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
	}
	public static class DslChainStatContext extends DslExprContext {
		public List<TerminalNode> Identifier() { return getTokens(KavaParser.Identifier); }
		public DslParamContext dslParam(int i) {
			return getRuleContext(DslParamContext.class,i);
		}
		public TerminalNode Identifier(int i) {
			return getToken(KavaParser.Identifier, i);
		}
		public List<DslParamContext> dslParam() {
			return getRuleContexts(DslParamContext.class);
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
	}

	public final DslExprContext dslExpr() throws RecognitionException {
		DslExprContext _localctx = new DslExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dslExpr);
		int _la;
		try {
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new DslVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79); match(T__0);
				setState(80); match(Identifier);
				}
				break;
			case 2:
				_localctx = new DslVarNewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81); match(NEW);
				setState(82); match(Identifier);
				}
				break;
			case 3:
				_localctx = new DslExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83); expression(0);
				}
				break;
			case 4:
				_localctx = new DslChainStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(84); match(Identifier);
					setState(85); dslParam();
					}
					}
					setState(88); 
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}

	public final DslParamContext dslParam() throws RecognitionException {
		DslParamContext _localctx = new DslParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dslParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); expression(0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93); match(COMMA);
				setState(94); expression(0);
				}
				}
				setState(99);
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
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); compiliantUnit();
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
	}

	public final CompiliantUnitContext compiliantUnit() throws RecognitionException {
		CompiliantUnitContext _localctx = new CompiliantUnitContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compiliantUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(CLASS);
			setState(103); match(Identifier);
			setState(106);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(104); match(EXTENDS);
				setState(105); match(Identifier);
				}
			}

			setState(108); match(LBRACE);
			setState(109); classBody();
			setState(110); match(RBRACE);
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
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); methodDeclList();
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
	}

	public final MethodDeclListContext methodDeclList() throws RecognitionException {
		MethodDeclListContext _localctx = new MethodDeclListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				{
				setState(114); methodDecl();
				}
				}
				setState(119);
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
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ArgumentDeclListContext argumentDeclList() {
			return getRuleContext(ArgumentDeclListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); type();
			setState(121); match(Identifier);
			setState(122); match(LPAREN);
			setState(124);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				setState(123); argumentDeclList();
				}
			}

			setState(126); match(RPAREN);
			setState(127); match(LBRACE);
			setState(128); statList();
			setState(129); match(RBRACE);
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
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public TerminalNode LONG() { return getToken(KavaParser.LONG, 0); }
		public TerminalNode INT() { return getToken(KavaParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(KavaParser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(KavaParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterArgumentDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitArgumentDeclList(this);
		}
	}

	public final ArgumentDeclListContext argumentDeclList() throws RecognitionException {
		ArgumentDeclListContext _localctx = new ArgumentDeclListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argumentDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); argumentDecl();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(134); match(COMMA);
				setState(135); argumentDecl();
				}
				}
				setState(140);
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
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterArgumentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitArgumentDecl(this);
		}
	}

	public final ArgumentDeclContext argumentDecl() throws RecognitionException {
		ArgumentDeclContext _localctx = new ArgumentDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_argumentDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); type();
			setState(142); match(Identifier);
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
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
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
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (BANG - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (ADD - 70)) | (1L << (SUB - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				{
				setState(144); stat();
				}
				}
				setState(149);
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
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(IF);
			setState(151); match(LPAREN);
			setState(152); expression(0);
			setState(153); match(RPAREN);
			setState(154); match(LBRACE);
			setState(155); statList();
			setState(156); match(RBRACE);
			setState(158);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(157); ifStatSuffix();
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
	}

	public final IfStatSuffixContext ifStatSuffix() throws RecognitionException {
		IfStatSuffixContext _localctx = new IfStatSuffixContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(ELSE);
			setState(161); match(LBRACE);
			setState(162); statList();
			setState(163); match(RBRACE);
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
		public ContinueStatContext continueStat() {
			return getRuleContext(ContinueStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public ForStatContext forStat() {
			return getRuleContext(ForStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public DoWhileStatContext doWhileStat() {
			return getRuleContext(DoWhileStatContext.class,0);
		}
		public BreakStatContext breakStat() {
			return getRuleContext(BreakStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public ExprStatContext exprStat() {
			return getRuleContext(ExprStatContext.class,0);
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
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stat);
		try {
			setState(174);
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
				setState(165); exprStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); ifStat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(167); whileStat();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(168); doWhileStat();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(169); forStat();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 6);
				{
				setState(170); breakStat();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 7);
				{
				setState(171); continueStat();
				}
				break;
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				enterOuterAlt(_localctx, 8);
				{
				setState(172); varDeclStat();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(173); returnStat();
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
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(RETURN);
			setState(178);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(177); expression(0);
				}
			}

			setState(180); match(SEMI);
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
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); varDecl();
			setState(183); match(SEMI);
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
		public TerminalNode LONG() { return getToken(KavaParser.LONG, 0); }
		public TerminalNode IntegerLiteral() { return getToken(KavaParser.IntegerLiteral, 0); }
		public TerminalNode INT() { return getToken(KavaParser.INT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(KavaParser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(KavaParser.FLOAT, 0); }
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
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(189);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(186); match(LBRACK);
				setState(187); match(IntegerLiteral);
				setState(188); match(RBRACK);
				}
			}

			setState(191); match(Identifier);
			setState(194);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(192); match(ASSIGN);
				setState(193); expression(0);
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
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(BREAK);
			setState(197); match(SEMI);
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
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(CONTINUE);
			setState(200); match(SEMI);
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
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(WHILE);
			setState(203); match(LPAREN);
			setState(204); expression(0);
			setState(205); match(RPAREN);
			setState(206); match(LBRACE);
			setState(207); statList();
			setState(208); match(RBRACE);
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
		public TerminalNode WHILE() { return getToken(KavaParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
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
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(DO);
			setState(211); match(LBRACE);
			setState(212); statList();
			setState(213); match(RBRACE);
			setState(214); match(WHILE);
			setState(215); match(LPAREN);
			setState(216); expression(0);
			setState(217); match(RPAREN);
			setState(218); match(SEMI);
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
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public TerminalNode FOR() { return getToken(KavaParser.FOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
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
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(FOR);
			setState(221); match(LPAREN);
			setState(223);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (BANG - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (ADD - 70)) | (1L << (SUB - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				setState(222); forInit();
				}
			}

			setState(225); match(SEMI);
			setState(227);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(226); expression(0);
				}
			}

			setState(229); match(SEMI);
			setState(231);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(230); forUpdate();
				}
			}

			setState(233); match(RPAREN);
			setState(234); match(LBRACE);
			setState(235); statList();
			setState(236); match(RBRACE);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
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
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_forInit);
		try {
			setState(240);
			switch (_input.LA(1)) {
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(238); varDecl();
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
				setState(239); expressionList();
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
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); expressionList();
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); expression(0);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(245); match(COMMA);
				setState(246); expression(0);
				}
				}
				setState(251);
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
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); expression(0);
			setState(253); match(SEMI);
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
	}
	public static class ArrayAssignContext extends ExpressionContext {
		public TerminalNode ASSIGN() { return getToken(KavaParser.ASSIGN, 0); }
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}
	public static class ExprMemberInvocationContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExprMemberInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprMemberInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprMemberInvocation(this);
		}
	}
	public static class ExprAssignContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(KavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprAssign(this);
		}
	}
	public static class ExprMidOpContext extends ExpressionContext {
		public TerminalNode SUB() { return getToken(KavaParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(KavaParser.ADD, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MOD() { return getToken(KavaParser.MOD, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode DIV() { return getToken(KavaParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(KavaParser.MUL, 0); }
		public ExprMidOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprMidOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprMidOp(this);
		}
	}
	public static class ExprInvocationContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}
	public static class ExprGetFieldContext extends ExpressionContext {
		public TerminalNode DOT() { return getToken(KavaParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(KavaParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprGetFieldContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprGetField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprGetField(this);
		}
	}
	public static class ExprLogicCmpContext extends ExpressionContext {
		public TerminalNode EQUAL() { return getToken(KavaParser.EQUAL, 0); }
		public TerminalNode GE() { return getToken(KavaParser.GE, 0); }
		public TerminalNode LT() { return getToken(KavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(KavaParser.GT, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LE() { return getToken(KavaParser.LE, 0); }
		public TerminalNode NOTEQUAL() { return getToken(KavaParser.NOTEQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprLogicCmpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprLogicCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprLogicCmp(this);
		}
	}
	public static class ExprSelfOpContext extends ExpressionContext {
		public TerminalNode DEC() { return getToken(KavaParser.DEC, 0); }
		public TerminalNode INC() { return getToken(KavaParser.INC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprSelfOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprSelfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprSelfOp(this);
		}
	}
	public static class ExprLogicContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(KavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(KavaParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprLogicContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprLogic(this);
		}
	}
	public static class ExprSelfOpPreContext extends ExpressionContext {
		public TerminalNode DEC() { return getToken(KavaParser.DEC, 0); }
		public TerminalNode INC() { return getToken(KavaParser.INC, 0); }
		public TerminalNode SUB() { return getToken(KavaParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(KavaParser.ADD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprSelfOpPreContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterExprSelfOpPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitExprSelfOpPre(this);
		}
	}
	public static class ExprGetArrayElementContext extends ExpressionContext {
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(256);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (INC - 80)) | (1L << (DEC - 80)) | (1L << (ADD - 80)) | (1L << (SUB - 80)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(257); expression(10);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258); match(BANG);
				setState(259); expression(9);
				}
				break;
			case 3:
				{
				_localctx = new ExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260); match(Identifier);
				{
				setState(261); match(ASSIGN);
				}
				setState(262); expression(2);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(263); match(Identifier);
				setState(264); offset();
				}
				setState(266); match(ASSIGN);
				setState(267); expression(1);
				}
				break;
			case 5:
				{
				_localctx = new ExprPrimayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269); primary();
				}
				break;
			case 6:
				{
				_localctx = new ExprMemberInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270); match(Identifier);
				setState(271); arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(274);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(275);
						_la = _input.LA(1);
						if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (MUL - 84)) | (1L << (DIV - 84)) | (1L << (MOD - 84)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(276); expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(278);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(279); expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprLogicCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(281);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (GT - 68)) | (1L << (LT - 68)) | (1L << (LE - 68)) | (1L << (GE - 68)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(282); expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprLogicCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(284);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(285); expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprLogicContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(287);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(288); expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(290); match(DOT);
						setState(291); match(Identifier);
						}
						break;
					case 7:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(293); match(DOT);
						setState(294); match(Identifier);
						setState(295); arguments();
						}
						break;
					case 8:
						{
						_localctx = new ExprSelfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(297);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					case 9:
						{
						_localctx = new ExprGetArrayElementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(299); offset();
						}
						break;
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(LBRACK);
			setState(306); expression(0);
			setState(307); match(RBRACK);
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
		public TerminalNode RPAREN() { return getToken(KavaParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimayParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).enterPrimayParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KavaListener ) ((KavaListener)listener).exitPrimayParen(this);
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
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_primary);
		try {
			setState(315);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimayParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(309); match(LPAREN);
				setState(310); expression(0);
				setState(311); match(RPAREN);
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
				setState(313); literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(314); match(Identifier);
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
		public TerminalNode StringLiteral() { return getToken(KavaParser.StringLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(KavaParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(KavaParser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KavaParser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(KavaParser.CharacterLiteral, 0); }
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
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(LPAREN);
			setState(321);
			_la = _input.LA(1);
			if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (IntegerLiteral - 52)) | (1L << (FloatingPointLiteral - 52)) | (1L << (BooleanLiteral - 52)) | (1L << (CharacterLiteral - 52)) | (1L << (StringLiteral - 52)) | (1L << (NullLiteral - 52)) | (1L << (LPAREN - 52)) | (1L << (BANG - 52)) | (1L << (INC - 52)) | (1L << (DEC - 52)) | (1L << (ADD - 52)) | (1L << (SUB - 52)) | (1L << (Identifier - 52)))) != 0)) {
				{
				setState(320); argumentList();
				}
			}

			setState(323); match(RPAREN);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325); expression(0);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(326); match(COMMA);
				setState(327); expression(0);
				}
				}
				setState(332);
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
		case 28: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 8);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 14);
		case 6: return precpred(_ctx, 13);
		case 7: return precpred(_ctx, 11);
		case 8: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3l\u0150\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\7\2H\n\2\f\2\16\2K\13\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\6\4Y\n\4\r\4\16\4Z\5\4]\n\4\3\5\3\5\3\5\7\5b"+
		"\n\5\f\5\16\5e\13\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7m\n\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\t\7\tv\n\t\f\t\16\ty\13\t\3\n\3\n\3\n\3\n\5\n\177\n\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\f\u008b\n\f\f\f\16\f\u008e\13\f\3"+
		"\r\3\r\3\r\3\16\7\16\u0094\n\16\f\16\16\16\u0097\13\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00a1\n\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b1\n\21\3\22\3\22\5\22"+
		"\u00b5\n\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00c0\n"+
		"\24\3\24\3\24\3\24\5\24\u00c5\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\5\31\u00e2\n\31\3\31\3\31\5\31\u00e6\n"+
		"\31\3\31\3\31\5\31\u00ea\n\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\5\32"+
		"\u00f3\n\32\3\33\3\33\3\34\3\34\3\34\7\34\u00fa\n\34\f\34\16\34\u00fd"+
		"\13\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0113\n\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u012f\n\36\f\36\16\36\u0132"+
		"\13\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \5 \u013e\n \3!\3!\3\"\3\""+
		"\5\"\u0144\n\"\3\"\3\"\3#\3#\3#\7#\u014b\n#\f#\16#\u014e\13#\3#\2\3:$"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2"+
		"\f\7\2\21\21\27\27\36\36  gg\6\2\21\21\27\27\36\36  \3\2RU\4\2VW[[\3\2"+
		"TU\4\2FGMN\4\2LLOO\3\2PQ\3\2RS\3\2\66;\u015b\2I\3\2\2\2\4L\3\2\2\2\6\\"+
		"\3\2\2\2\b^\3\2\2\2\nf\3\2\2\2\fh\3\2\2\2\16r\3\2\2\2\20w\3\2\2\2\22z"+
		"\3\2\2\2\24\u0085\3\2\2\2\26\u0087\3\2\2\2\30\u008f\3\2\2\2\32\u0095\3"+
		"\2\2\2\34\u0098\3\2\2\2\36\u00a2\3\2\2\2 \u00b0\3\2\2\2\"\u00b2\3\2\2"+
		"\2$\u00b8\3\2\2\2&\u00bb\3\2\2\2(\u00c6\3\2\2\2*\u00c9\3\2\2\2,\u00cc"+
		"\3\2\2\2.\u00d4\3\2\2\2\60\u00de\3\2\2\2\62\u00f2\3\2\2\2\64\u00f4\3\2"+
		"\2\2\66\u00f6\3\2\2\28\u00fe\3\2\2\2:\u0112\3\2\2\2<\u0133\3\2\2\2>\u013d"+
		"\3\2\2\2@\u013f\3\2\2\2B\u0141\3\2\2\2D\u0147\3\2\2\2FH\5\4\3\2GF\3\2"+
		"\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\3\3\2\2\2KI\3\2\2\2LM\7g\2\2MN\7K"+
		"\2\2NO\5\6\4\2OP\7B\2\2P\5\3\2\2\2QR\7\3\2\2R]\7g\2\2ST\7\"\2\2T]\7g\2"+
		"\2U]\5:\36\2VW\7g\2\2WY\5\b\5\2XV\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2"+
		"\2[]\3\2\2\2\\Q\3\2\2\2\\S\3\2\2\2\\U\3\2\2\2\\X\3\2\2\2]\7\3\2\2\2^c"+
		"\5:\36\2_`\7C\2\2`b\5:\36\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\t"+
		"\3\2\2\2ec\3\2\2\2fg\5\f\7\2g\13\3\2\2\2hi\7\f\2\2il\7g\2\2jk\7\24\2\2"+
		"km\7g\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7>\2\2op\5\16\b\2pq\7?\2\2q"+
		"\r\3\2\2\2rs\5\20\t\2s\17\3\2\2\2tv\5\22\n\2ut\3\2\2\2vy\3\2\2\2wu\3\2"+
		"\2\2wx\3\2\2\2x\21\3\2\2\2yw\3\2\2\2z{\5\24\13\2{|\7g\2\2|~\7<\2\2}\177"+
		"\5\26\f\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7=\2\2"+
		"\u0081\u0082\7>\2\2\u0082\u0083\5\32\16\2\u0083\u0084\7?\2\2\u0084\23"+
		"\3\2\2\2\u0085\u0086\t\2\2\2\u0086\25\3\2\2\2\u0087\u008c\5\30\r\2\u0088"+
		"\u0089\7C\2\2\u0089\u008b\5\30\r\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\27\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008f\u0090\5\24\13\2\u0090\u0091\7g\2\2\u0091\31\3\2\2\2\u0092"+
		"\u0094\5 \21\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\33\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099"+
		"\7\31\2\2\u0099\u009a\7<\2\2\u009a\u009b\5:\36\2\u009b\u009c\7=\2\2\u009c"+
		"\u009d\7>\2\2\u009d\u009e\5\32\16\2\u009e\u00a0\7?\2\2\u009f\u00a1\5\36"+
		"\20\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a3"+
		"\7\22\2\2\u00a3\u00a4\7>\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\7?\2\2"+
		"\u00a6\37\3\2\2\2\u00a7\u00b1\58\35\2\u00a8\u00b1\5\34\17\2\u00a9\u00b1"+
		"\5,\27\2\u00aa\u00b1\5.\30\2\u00ab\u00b1\5\60\31\2\u00ac\u00b1\5(\25\2"+
		"\u00ad\u00b1\5*\26\2\u00ae\u00b1\5$\23\2\u00af\u00b1\5\"\22\2\u00b0\u00a7"+
		"\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b0\u00a9\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0"+
		"\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00af\3\2\2\2\u00b1!\3\2\2\2\u00b2\u00b4\7\'\2\2\u00b3\u00b5"+
		"\5:\36\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\7B\2\2\u00b7#\3\2\2\2\u00b8\u00b9\5&\24\2\u00b9\u00ba\7B\2\2\u00ba"+
		"%\3\2\2\2\u00bb\u00bf\t\3\2\2\u00bc\u00bd\7@\2\2\u00bd\u00be\7\66\2\2"+
		"\u00be\u00c0\7A\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00c4\7g\2\2\u00c2\u00c3\7E\2\2\u00c3\u00c5\5:\36\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\'\3\2\2\2\u00c6\u00c7\7\7\2\2"+
		"\u00c7\u00c8\7B\2\2\u00c8)\3\2\2\2\u00c9\u00ca\7\16\2\2\u00ca\u00cb\7"+
		"B\2\2\u00cb+\3\2\2\2\u00cc\u00cd\7\65\2\2\u00cd\u00ce\7<\2\2\u00ce\u00cf"+
		"\5:\36\2\u00cf\u00d0\7=\2\2\u00d0\u00d1\7>\2\2\u00d1\u00d2\5\32\16\2\u00d2"+
		"\u00d3\7?\2\2\u00d3-\3\2\2\2\u00d4\u00d5\7\20\2\2\u00d5\u00d6\7>\2\2\u00d6"+
		"\u00d7\5\32\16\2\u00d7\u00d8\7?\2\2\u00d8\u00d9\7\65\2\2\u00d9\u00da\7"+
		"<\2\2\u00da\u00db\5:\36\2\u00db\u00dc\7=\2\2\u00dc\u00dd\7B\2\2\u00dd"+
		"/\3\2\2\2\u00de\u00df\7\30\2\2\u00df\u00e1\7<\2\2\u00e0\u00e2\5\62\32"+
		"\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5"+
		"\7B\2\2\u00e4\u00e6\5:\36\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e9\7B\2\2\u00e8\u00ea\5\64\33\2\u00e9\u00e8\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\7=\2\2\u00ec"+
		"\u00ed\7>\2\2\u00ed\u00ee\5\32\16\2\u00ee\u00ef\7?\2\2\u00ef\61\3\2\2"+
		"\2\u00f0\u00f3\5&\24\2\u00f1\u00f3\5\66\34\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\63\3\2\2\2\u00f4\u00f5\5\66\34\2\u00f5\65\3\2\2\2"+
		"\u00f6\u00fb\5:\36\2\u00f7\u00f8\7C\2\2\u00f8\u00fa\5:\36\2\u00f9\u00f7"+
		"\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\67\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\5:\36\2\u00ff\u0100\7B\2\2"+
		"\u01009\3\2\2\2\u0101\u0102\b\36\1\2\u0102\u0103\t\4\2\2\u0103\u0113\5"+
		":\36\f\u0104\u0105\7H\2\2\u0105\u0113\5:\36\13\u0106\u0107\7g\2\2\u0107"+
		"\u0108\7E\2\2\u0108\u0113\5:\36\4\u0109\u010a\7g\2\2\u010a\u010b\5<\37"+
		"\2\u010b\u010c\3\2\2\2\u010c\u010d\7E\2\2\u010d\u010e\5:\36\3\u010e\u0113"+
		"\3\2\2\2\u010f\u0113\5> \2\u0110\u0111\7g\2\2\u0111\u0113\5B\"\2\u0112"+
		"\u0101\3\2\2\2\u0112\u0104\3\2\2\2\u0112\u0106\3\2\2\2\u0112\u0109\3\2"+
		"\2\2\u0112\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0130\3\2\2\2\u0114"+
		"\u0115\f\n\2\2\u0115\u0116\t\5\2\2\u0116\u012f\5:\36\13\u0117\u0118\f"+
		"\t\2\2\u0118\u0119\t\6\2\2\u0119\u012f\5:\36\n\u011a\u011b\f\b\2\2\u011b"+
		"\u011c\t\7\2\2\u011c\u012f\5:\36\t\u011d\u011e\f\7\2\2\u011e\u011f\t\b"+
		"\2\2\u011f\u012f\5:\36\b\u0120\u0121\f\6\2\2\u0121\u0122\t\t\2\2\u0122"+
		"\u012f\5:\36\7\u0123\u0124\f\20\2\2\u0124\u0125\7D\2\2\u0125\u012f\7g"+
		"\2\2\u0126\u0127\f\17\2\2\u0127\u0128\7D\2\2\u0128\u0129\7g\2\2\u0129"+
		"\u012f\5B\"\2\u012a\u012b\f\r\2\2\u012b\u012f\t\n\2\2\u012c\u012d\f\5"+
		"\2\2\u012d\u012f\5<\37\2\u012e\u0114\3\2\2\2\u012e\u0117\3\2\2\2\u012e"+
		"\u011a\3\2\2\2\u012e\u011d\3\2\2\2\u012e\u0120\3\2\2\2\u012e\u0123\3\2"+
		"\2\2\u012e\u0126\3\2\2\2\u012e\u012a\3\2\2\2\u012e\u012c\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131;\3\2\2\2"+
		"\u0132\u0130\3\2\2\2\u0133\u0134\7@\2\2\u0134\u0135\5:\36\2\u0135\u0136"+
		"\7A\2\2\u0136=\3\2\2\2\u0137\u0138\7<\2\2\u0138\u0139\5:\36\2\u0139\u013a"+
		"\7=\2\2\u013a\u013e\3\2\2\2\u013b\u013e\5@!\2\u013c\u013e\7g\2\2\u013d"+
		"\u0137\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e?\3\2\2\2"+
		"\u013f\u0140\t\13\2\2\u0140A\3\2\2\2\u0141\u0143\7<\2\2\u0142\u0144\5"+
		"D#\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\7=\2\2\u0146C\3\2\2\2\u0147\u014c\5:\36\2\u0148\u0149\7C\2\2\u0149"+
		"\u014b\5:\36\2\u014a\u0148\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014dE\3\2\2\2\u014e\u014c\3\2\2\2\33IZ\\clw"+
		"~\u008c\u0095\u00a0\u00b0\u00b4\u00bf\u00c4\u00e1\u00e5\u00e9\u00f2\u00fb"+
		"\u0112\u012e\u0130\u013d\u0143\u014c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
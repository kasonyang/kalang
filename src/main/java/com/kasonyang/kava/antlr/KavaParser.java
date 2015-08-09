// Generated from Kava.g4 by ANTLR 4.5
package com.kasonyang.kava.antlr;
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
		ABSTRACT=1, ASSERT=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CATCH=7, CHAR=8, 
		CLASS=9, CONST=10, CONTINUE=11, DEFAULT=12, DO=13, DOUBLE=14, ELSE=15, 
		ENUM=16, EXTENDS=17, FINAL=18, FINALLY=19, FLOAT=20, FOR=21, IF=22, GOTO=23, 
		IMPLEMENTS=24, IMPORT=25, INSTANCEOF=26, INT=27, INTERFACE=28, LONG=29, 
		NATIVE=30, NEW=31, PACKAGE=32, PRIVATE=33, PROTECTED=34, PUBLIC=35, RETURN=36, 
		SHORT=37, STATIC=38, STRICTFP=39, SUPER=40, SWITCH=41, SYNCHRONIZED=42, 
		THIS=43, THROW=44, THROWS=45, TRANSIENT=46, TRY=47, VOID=48, VOLATILE=49, 
		WHILE=50, IntegerLiteral=51, FloatingPointLiteral=52, BooleanLiteral=53, 
		CharacterLiteral=54, StringLiteral=55, NullLiteral=56, LPAREN=57, RPAREN=58, 
		LBRACE=59, RBRACE=60, LBRACK=61, RBRACK=62, SEMI=63, COMMA=64, DOT=65, 
		ASSIGN=66, GT=67, LT=68, BANG=69, TILDE=70, QUESTION=71, COLON=72, EQUAL=73, 
		LE=74, GE=75, NOTEQUAL=76, AND=77, OR=78, INC=79, DEC=80, ADD=81, SUB=82, 
		MUL=83, DIV=84, BITAND=85, BITOR=86, CARET=87, MOD=88, ADD_ASSIGN=89, 
		SUB_ASSIGN=90, MUL_ASSIGN=91, DIV_ASSIGN=92, AND_ASSIGN=93, OR_ASSIGN=94, 
		XOR_ASSIGN=95, MOD_ASSIGN=96, LSHIFT_ASSIGN=97, RSHIFT_ASSIGN=98, URSHIFT_ASSIGN=99, 
		Identifier=100, AT=101, ELLIPSIS=102, WS=103, COMMENT=104, LINE_COMMENT=105;
	public static final int
		RULE_start = 0, RULE_statList = 1, RULE_ifStat = 2, RULE_ifStatSuffix = 3, 
		RULE_stat = 4, RULE_whileStat = 5, RULE_doWhileStat = 6, RULE_forStat = 7, 
		RULE_forInit = 8, RULE_forUpdate = 9, RULE_expressionList = 10, RULE_exprStat = 11, 
		RULE_expression = 12, RULE_primary = 13, RULE_literal = 14, RULE_genericInvocation = 15, 
		RULE_arguments = 16, RULE_argumentList = 17;
	public static final String[] ruleNames = {
		"start", "statList", "ifStat", "ifStatSuffix", "stat", "whileStat", "doWhileStat", 
		"forStat", "forInit", "forUpdate", "expressionList", "exprStat", "expression", 
		"primary", "literal", "genericInvocation", "arguments", "argumentList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
		"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
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
		null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", 
		"CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", 
		"ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", 
		"IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", 
		"PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", 
		"SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", 
		"TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
		"DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
		"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", 
		"LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", "AT", 
		"ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
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
	public static class StartContext extends ParserRuleContext {
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
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
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			statList();
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
		enterRule(_localctx, 2, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DO) | (1L << FOR) | (1L << IF) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || _la==Identifier) {
				{
				{
				setState(38);
				stat();
				}
				}
				setState(43);
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
		enterRule(_localctx, 4, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(IF);
			setState(45);
			match(LPAREN);
			setState(46);
			expression(0);
			setState(47);
			match(RPAREN);
			setState(48);
			match(LBRACE);
			setState(49);
			statList();
			setState(50);
			match(RBRACE);
			setState(52);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(51);
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
		enterRule(_localctx, 6, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ELSE);
			setState(55);
			match(LBRACE);
			setState(56);
			statList();
			setState(57);
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
		enterRule(_localctx, 8, RULE_stat);
		try {
			setState(64);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				exprStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				ifStat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				whileStat();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				doWhileStat();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				forStat();
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
		enterRule(_localctx, 10, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(WHILE);
			setState(67);
			match(LPAREN);
			setState(68);
			expression(0);
			setState(69);
			match(RPAREN);
			setState(70);
			match(LBRACE);
			setState(71);
			statList();
			setState(72);
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
		enterRule(_localctx, 12, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(DO);
			setState(75);
			match(LBRACE);
			setState(76);
			statList();
			setState(77);
			match(RBRACE);
			setState(78);
			match(WHILE);
			setState(79);
			match(LPAREN);
			setState(80);
			expression(0);
			setState(81);
			match(RPAREN);
			setState(82);
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
		enterRule(_localctx, 14, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(FOR);
			setState(85);
			match(LPAREN);
			setState(87);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (IntegerLiteral - 51)) | (1L << (FloatingPointLiteral - 51)) | (1L << (BooleanLiteral - 51)) | (1L << (CharacterLiteral - 51)) | (1L << (StringLiteral - 51)) | (1L << (NullLiteral - 51)) | (1L << (LPAREN - 51)) | (1L << (Identifier - 51)))) != 0)) {
				{
				setState(86);
				forInit();
				}
			}

			setState(89);
			match(SEMI);
			setState(91);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (IntegerLiteral - 51)) | (1L << (FloatingPointLiteral - 51)) | (1L << (BooleanLiteral - 51)) | (1L << (CharacterLiteral - 51)) | (1L << (StringLiteral - 51)) | (1L << (NullLiteral - 51)) | (1L << (LPAREN - 51)) | (1L << (Identifier - 51)))) != 0)) {
				{
				setState(90);
				expression(0);
				}
			}

			setState(93);
			match(SEMI);
			setState(95);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (IntegerLiteral - 51)) | (1L << (FloatingPointLiteral - 51)) | (1L << (BooleanLiteral - 51)) | (1L << (CharacterLiteral - 51)) | (1L << (StringLiteral - 51)) | (1L << (NullLiteral - 51)) | (1L << (LPAREN - 51)) | (1L << (Identifier - 51)))) != 0)) {
				{
				setState(94);
				forUpdate();
				}
			}

			setState(97);
			match(RPAREN);
			setState(98);
			match(LBRACE);
			setState(99);
			statList();
			setState(100);
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
		enterRule(_localctx, 16, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		enterRule(_localctx, 18, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
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
		enterRule(_localctx, 20, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
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
		enterRule(_localctx, 22, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			expression(0);
			setState(115);
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
	public static class ExprAssignContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
	public static class ExprInvocationContext extends ExpressionContext {
		public GenericInvocationContext genericInvocation() {
			return getRuleContext(GenericInvocationContext.class,0);
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
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ExprPrimayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(118);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new ExprInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				genericInvocation();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(123);
						_la = _input.LA(1);
						if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (MUL - 83)) | (1L << (DIV - 83)) | (1L << (MOD - 83)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(124);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(126);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(127);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExprAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(129);
						match(ASSIGN);
						}
						setState(130);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 26, RULE_primary);
		try {
			setState(142);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimayParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(LPAREN);
				setState(137);
				expression(0);
				setState(138);
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
				setState(140);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
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
		enterRule(_localctx, 28, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
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
		enterRule(_localctx, 30, RULE_genericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(Identifier);
			setState(147);
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
		enterRule(_localctx, 32, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(LPAREN);
			setState(151);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (IntegerLiteral - 51)) | (1L << (FloatingPointLiteral - 51)) | (1L << (BooleanLiteral - 51)) | (1L << (CharacterLiteral - 51)) | (1L << (StringLiteral - 51)) | (1L << (NullLiteral - 51)) | (1L << (LPAREN - 51)) | (1L << (Identifier - 51)))) != 0)) {
				{
				setState(150);
				argumentList();
				}
			}

			setState(153);
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
		enterRule(_localctx, 34, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			expression(0);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(156);
				match(COMMA);
				setState(157);
				expression(0);
				}
				}
				setState(162);
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
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3k\u00a6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6C\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\5\tZ\n\t\3\t\3\t\5\t^\n\t\3\t\3\t\5\tb\n\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\fp\n\f\f\f\16\fs\13\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\5\16{\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u0086\n\16\f\16\16\16\u0089\13\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u0091\n\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u009a\n\22"+
		"\3\22\3\22\3\23\3\23\3\23\7\23\u00a1\n\23\f\23\16\23\u00a4\13\23\3\23"+
		"\2\3\32\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\4\2UVZZ\3\2"+
		"ST\3\2\65:\u00a5\2&\3\2\2\2\4+\3\2\2\2\6.\3\2\2\2\b8\3\2\2\2\nB\3\2\2"+
		"\2\fD\3\2\2\2\16L\3\2\2\2\20V\3\2\2\2\22h\3\2\2\2\24j\3\2\2\2\26l\3\2"+
		"\2\2\30t\3\2\2\2\32z\3\2\2\2\34\u0090\3\2\2\2\36\u0092\3\2\2\2 \u0094"+
		"\3\2\2\2\"\u0097\3\2\2\2$\u009d\3\2\2\2&\'\5\4\3\2\'\3\3\2\2\2(*\5\n\6"+
		"\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3\2\2\2./\7\30"+
		"\2\2/\60\7;\2\2\60\61\5\32\16\2\61\62\7<\2\2\62\63\7=\2\2\63\64\5\4\3"+
		"\2\64\66\7>\2\2\65\67\5\b\5\2\66\65\3\2\2\2\66\67\3\2\2\2\67\7\3\2\2\2"+
		"89\7\21\2\29:\7=\2\2:;\5\4\3\2;<\7>\2\2<\t\3\2\2\2=C\5\30\r\2>C\5\6\4"+
		"\2?C\5\f\7\2@C\5\16\b\2AC\5\20\t\2B=\3\2\2\2B>\3\2\2\2B?\3\2\2\2B@\3\2"+
		"\2\2BA\3\2\2\2C\13\3\2\2\2DE\7\64\2\2EF\7;\2\2FG\5\32\16\2GH\7<\2\2HI"+
		"\7=\2\2IJ\5\4\3\2JK\7>\2\2K\r\3\2\2\2LM\7\17\2\2MN\7=\2\2NO\5\4\3\2OP"+
		"\7>\2\2PQ\7\64\2\2QR\7;\2\2RS\5\32\16\2ST\7<\2\2TU\7A\2\2U\17\3\2\2\2"+
		"VW\7\27\2\2WY\7;\2\2XZ\5\22\n\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[]\7A\2\2"+
		"\\^\5\32\16\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_a\7A\2\2`b\5\24\13\2a`\3"+
		"\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7<\2\2de\7=\2\2ef\5\4\3\2fg\7>\2\2g\21\3"+
		"\2\2\2hi\5\26\f\2i\23\3\2\2\2jk\5\26\f\2k\25\3\2\2\2lq\5\32\16\2mn\7B"+
		"\2\2np\5\32\16\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\27\3\2\2\2s"+
		"q\3\2\2\2tu\5\32\16\2uv\7A\2\2v\31\3\2\2\2wx\b\16\1\2x{\5\34\17\2y{\5"+
		" \21\2zw\3\2\2\2zy\3\2\2\2{\u0087\3\2\2\2|}\f\5\2\2}~\t\2\2\2~\u0086\5"+
		"\32\16\6\177\u0080\f\4\2\2\u0080\u0081\t\3\2\2\u0081\u0086\5\32\16\5\u0082"+
		"\u0083\f\3\2\2\u0083\u0084\7D\2\2\u0084\u0086\5\32\16\3\u0085|\3\2\2\2"+
		"\u0085\177\3\2\2\2\u0085\u0082\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\33\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008b\7;\2\2\u008b\u008c\5\32\16\2\u008c\u008d\7<\2\2\u008d\u0091\3\2"+
		"\2\2\u008e\u0091\5\36\20\2\u008f\u0091\7f\2\2\u0090\u008a\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\35\3\2\2\2\u0092\u0093\t\4\2"+
		"\2\u0093\37\3\2\2\2\u0094\u0095\7f\2\2\u0095\u0096\5\"\22\2\u0096!\3\2"+
		"\2\2\u0097\u0099\7;\2\2\u0098\u009a\5$\23\2\u0099\u0098\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7<\2\2\u009c#\3\2\2\2\u009d"+
		"\u00a2\5\32\16\2\u009e\u009f\7B\2\2\u009f\u00a1\5\32\16\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"%\3\2\2\2\u00a4\u00a2\3\2\2\2\17+\66BY]aqz\u0085\u0087\u0090\u0099\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
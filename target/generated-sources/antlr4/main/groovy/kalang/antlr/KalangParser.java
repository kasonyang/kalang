// Generated from Kalang.g4 by ANTLR 4.4
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
public class KalangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, ABSTRACT=9, 
		ASSERT=10, BOOLEAN=11, BREAK=12, BYTE=13, CASE=14, CATCH=15, CHAR=16, 
		CLASS=17, CONST=18, CONTINUE=19, DEFAULT=20, DO=21, DOUBLE=22, ELSE=23, 
		ENUM=24, EXTENDS=25, FINAL=26, FINALLY=27, FLOAT=28, FOR=29, IF=30, GOTO=31, 
		IMPLEMENTS=32, IMPORT=33, INSTANCEOF=34, INT=35, INTERFACE=36, LONG=37, 
		NATIVE=38, NEW=39, PACKAGE=40, PRIVATE=41, PROTECTED=42, PUBLIC=43, RETURN=44, 
		SHORT=45, STATIC=46, STRICTFP=47, SUPER=48, SWITCH=49, SYNCHRONIZED=50, 
		THIS=51, THROW=52, THROWS=53, TRANSIENT=54, TRY=55, VOID=56, VOLATILE=57, 
		WHILE=58, IntegerLiteral=59, FloatingPointLiteral=60, BooleanLiteral=61, 
		CharacterLiteral=62, StringLiteral=63, NullLiteral=64, LPAREN=65, RPAREN=66, 
		LBRACE=67, RBRACE=68, LBRACK=69, RBRACK=70, SEMI=71, COMMA=72, DOT=73, 
		ASSIGN=74, GT=75, LT=76, BANG=77, TILDE=78, QUESTION=79, COLON=80, EQUAL=81, 
		LE=82, GE=83, NOTEQUAL=84, AND=85, OR=86, INC=87, DEC=88, ADD=89, SUB=90, 
		MUL=91, DIV=92, BITAND=93, BITOR=94, CARET=95, MOD=96, ADD_ASSIGN=97, 
		SUB_ASSIGN=98, MUL_ASSIGN=99, DIV_ASSIGN=100, AND_ASSIGN=101, OR_ASSIGN=102, 
		XOR_ASSIGN=103, MOD_ASSIGN=104, LSHIFT_ASSIGN=105, RSHIFT_ASSIGN=106, 
		URSHIFT_ASSIGN=107, Identifier=108, AT=109, ELLIPSIS=110, WS=111, COMMENT=112, 
		LINE_COMMENT=113;
	public static final String[] tokenNames = {
		"<INVALID>", "'set'", "'[]'", "'get'", "''", "'var'", "'as'", "'\\'", 
		"'val'", "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
		"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
		"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
		"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
		"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
		"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
		"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
		"'transient'", "'try'", "'void'", "'volatile'", "'while'", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", 
		"'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", 
		"'%='", "'<<='", "'>>='", "'>>>='", "Identifier", "'@'", "'...'", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_compiliantUnit = 0, RULE_importDeclList = 1, RULE_importDecl = 2, 
		RULE_qualifiedName = 3, RULE_classBody = 4, RULE_fieldDeclList = 5, RULE_fieldDecl = 6, 
		RULE_setter = 7, RULE_getter = 8, RULE_methodDeclList = 9, RULE_methodDecl = 10, 
		RULE_type = 11, RULE_noArrayType = 12, RULE_argumentDeclList = 13, RULE_argumentDecl = 14, 
		RULE_statList = 15, RULE_ifStat = 16, RULE_ifStatSuffix = 17, RULE_stat = 18, 
		RULE_tryStat = 19, RULE_returnStat = 20, RULE_postIfStmt = 21, RULE_varDeclStat = 22, 
		RULE_varDecl = 23, RULE_varInit = 24, RULE_breakStat = 25, RULE_continueStat = 26, 
		RULE_whileStat = 27, RULE_doWhileStat = 28, RULE_forStat = 29, RULE_forInit = 30, 
		RULE_forUpdate = 31, RULE_expressions = 32, RULE_exprStat = 33, RULE_expression = 34, 
		RULE_primary = 35, RULE_map = 36, RULE_listOrArray = 37, RULE_literal = 38, 
		RULE_arguments = 39;
	public static final String[] ruleNames = {
		"compiliantUnit", "importDeclList", "importDecl", "qualifiedName", "classBody", 
		"fieldDeclList", "fieldDecl", "setter", "getter", "methodDeclList", "methodDecl", 
		"type", "noArrayType", "argumentDeclList", "argumentDecl", "statList", 
		"ifStat", "ifStatSuffix", "stat", "tryStat", "returnStat", "postIfStmt", 
		"varDeclStat", "varDecl", "varInit", "breakStat", "continueStat", "whileStat", 
		"doWhileStat", "forStat", "forInit", "forUpdate", "expressions", "exprStat", 
		"expression", "primary", "map", "listOrArray", "literal", "arguments"
	};

	@Override
	public String getGrammarFileName() { return "Kalang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KalangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompiliantUnitContext extends ParserRuleContext {
		public Token classType;
		public Token parentClass;
		public Token Identifier;
		public List<Token> interfaces = new ArrayList<Token>();
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ImportDeclListContext importDeclList() {
			return getRuleContext(ImportDeclListContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public TerminalNode BANG() { return getToken(KalangParser.BANG, 0); }
		public CompiliantUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compiliantUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterCompiliantUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitCompiliantUnit(this);
		}
	}

	public final CompiliantUnitContext compiliantUnit() throws RecognitionException {
		CompiliantUnitContext _localctx = new CompiliantUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compiliantUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); importDeclList();
			setState(83);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(81); ((CompiliantUnitContext)_localctx).classType = match(CLASS);
				}
				break;
			case INTERFACE:
				{
				setState(82); ((CompiliantUnitContext)_localctx).classType = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(86);
			_la = _input.LA(1);
			if (_la==BANG || _la==QUESTION) {
				{
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==QUESTION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(90);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(88); match(EXTENDS);
				setState(89); ((CompiliantUnitContext)_localctx).parentClass = match(Identifier);
				}
			}

			setState(101);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(92); match(IMPLEMENTS);
				setState(93); ((CompiliantUnitContext)_localctx).Identifier = match(Identifier);
				((CompiliantUnitContext)_localctx).interfaces.add(((CompiliantUnitContext)_localctx).Identifier);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(94); match(COMMA);
					setState(95); ((CompiliantUnitContext)_localctx).Identifier = match(Identifier);
					((CompiliantUnitContext)_localctx).interfaces.add(((CompiliantUnitContext)_localctx).Identifier);
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(103); match(LBRACE);
			setState(104); classBody();
			setState(105); match(RBRACE);
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

	public static class ImportDeclListContext extends ParserRuleContext {
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterImportDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitImportDeclList(this);
		}
	}

	public final ImportDeclListContext importDeclList() throws RecognitionException {
		ImportDeclListContext _localctx = new ImportDeclListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(107); importDecl();
				}
				}
				setState(112);
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

	public static class ImportDeclContext extends ParserRuleContext {
		public Token root;
		public Token Identifier;
		public List<Token> path = new ArrayList<Token>();
		public Token name;
		public Token alias;
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitImportDecl(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(IMPORT);
			setState(114);
			((ImportDeclContext)_localctx).root = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__1) ) {
				((ImportDeclContext)_localctx).root = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(115); ((ImportDeclContext)_localctx).Identifier = match(Identifier);
			((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(116); match(T__1);
					setState(117); ((ImportDeclContext)_localctx).Identifier = match(Identifier);
					((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(123); match(T__1);
			setState(130);
			switch (_input.LA(1)) {
			case Identifier:
				{
				{
				setState(124); ((ImportDeclContext)_localctx).name = match(Identifier);
				setState(127);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(125); match(T__2);
					setState(126); ((ImportDeclContext)_localctx).alias = match(Identifier);
					}
				}

				}
				}
				break;
			case MUL:
				{
				{
				setState(129); ((ImportDeclContext)_localctx).name = match(MUL);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(132); match(SEMI);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitQualifiedName(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(Identifier);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(135); match(DOT);
				setState(136); match(Identifier);
				}
				}
				setState(141);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public MethodDeclListContext methodDeclList() {
			return getRuleContext(MethodDeclListContext.class,0);
		}
		public FieldDeclListContext fieldDeclList() {
			return getRuleContext(FieldDeclListContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); fieldDeclList();
			setState(143); methodDeclList();
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

	public static class FieldDeclListContext extends ParserRuleContext {
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public FieldDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterFieldDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitFieldDeclList(this);
		}
	}

	public final FieldDeclListContext fieldDeclList() throws RecognitionException {
		FieldDeclListContext _localctx = new FieldDeclListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldDeclList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145); fieldDecl();
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class FieldDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public SetterContext setter() {
			return getRuleContext(SetterContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
		public VarInitContext varInit() {
			return getRuleContext(VarInitContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public GetterContext getter() {
			return getRuleContext(GetterContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public TerminalNode BANG() { return getToken(KalangParser.BANG, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitFieldDecl(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(151); match(STATIC);
				}
			}

			setState(154);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(155); match(Identifier);
			setState(157);
			_la = _input.LA(1);
			if (_la==BANG || _la==QUESTION) {
				{
				setState(156);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==QUESTION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(161);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(159); match(T__2);
				setState(160); type();
				}
			}

			setState(164);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(163); varInit();
				}
			}

			setState(167);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(166); setter();
				}
			}

			setState(170);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(169); getter();
				}
			}

			setState(172); match(SEMI);
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

	public static class SetterContext extends ParserRuleContext {
		public ArgumentDeclListContext argumentDeclList() {
			return getRuleContext(ArgumentDeclListContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public SetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterSetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitSetter(this);
		}
	}

	public final SetterContext setter() throws RecognitionException {
		SetterContext _localctx = new SetterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_setter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(T__7);
			setState(175); match(LPAREN);
			setState(176); argumentDeclList();
			setState(177); match(RPAREN);
			setState(178); match(LBRACE);
			setState(179); statList();
			setState(180); match(RBRACE);
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

	public static class GetterContext extends ParserRuleContext {
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public GetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitGetter(this);
		}
	}

	public final GetterContext getter() throws RecognitionException {
		GetterContext _localctx = new GetterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_getter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); match(T__5);
			setState(183); match(LBRACE);
			setState(184); statList();
			setState(185); match(RBRACE);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterMethodDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitMethodDeclList(this);
		}
	}

	public final MethodDeclListContext methodDeclList() throws RecognitionException {
		MethodDeclListContext _localctx = new MethodDeclListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << STATIC) | (1L << VOID))) != 0)) {
				{
				{
				setState(187); methodDecl();
				}
				}
				setState(192);
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
		public Token prefix;
		public Token name;
		public Token Identifier;
		public List<Token> exceptionTypes = new ArrayList<Token>();
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public ArgumentDeclListContext argumentDeclList() {
			return getRuleContext(ArgumentDeclListContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public TerminalNode BANG() { return getToken(KalangParser.BANG, 0); }
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitMethodDecl(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(193); match(STATIC);
				}
			}

			setState(220);
			switch (_input.LA(1)) {
			case T__3:
				{
				{
				setState(196); ((MethodDeclContext)_localctx).prefix = match(T__3);
				setState(197); ((MethodDeclContext)_localctx).name = match(Identifier);
				setState(199);
				_la = _input.LA(1);
				if (_la==BANG || _la==QUESTION) {
					{
					setState(198);
					_la = _input.LA(1);
					if ( !(_la==BANG || _la==QUESTION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(201); match(LPAREN);
				setState(203);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(202); argumentDeclList();
					}
				}

				setState(205); match(RPAREN);
				setState(208);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(206); match(T__2);
					setState(207); type();
					}
				}

				}
				}
				break;
			case VOID:
				{
				{
				setState(210); ((MethodDeclContext)_localctx).prefix = match(VOID);
				setState(211); ((MethodDeclContext)_localctx).name = match(Identifier);
				setState(213);
				_la = _input.LA(1);
				if (_la==BANG || _la==QUESTION) {
					{
					setState(212);
					_la = _input.LA(1);
					if ( !(_la==BANG || _la==QUESTION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(215); match(LPAREN);
				setState(217);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(216); argumentDeclList();
					}
				}

				setState(219); match(RPAREN);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(231);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(222); match(THROWS);
				setState(223); ((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(224); match(COMMA);
					setState(225); ((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(238);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				{
				setState(233); match(LBRACE);
				setState(234); statList();
				setState(235); match(RBRACE);
				}
				}
				break;
			case SEMI:
				{
				setState(237); match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeContext extends ParserRuleContext {
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); noArrayType();
			setState(242);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(241); match(T__6);
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

	public static class NoArrayTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode LONG() { return getToken(KalangParser.LONG, 0); }
		public TerminalNode INT() { return getToken(KalangParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(KalangParser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(KalangParser.FLOAT, 0); }
		public NoArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noArrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterNoArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitNoArrayType(this);
		}
	}

	public final NoArrayTypeContext noArrayType() throws RecognitionException {
		NoArrayTypeContext _localctx = new NoArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_noArrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterArgumentDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitArgumentDeclList(this);
		}
	}

	public final ArgumentDeclListContext argumentDeclList() throws RecognitionException {
		ArgumentDeclListContext _localctx = new ArgumentDeclListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argumentDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); argumentDecl();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(247); match(COMMA);
				setState(248); argumentDecl();
				}
				}
				setState(253);
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterArgumentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitArgumentDecl(this);
		}
	}

	public final ArgumentDeclContext argumentDecl() throws RecognitionException {
		ArgumentDeclContext _localctx = new ArgumentDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argumentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(Identifier);
			setState(257);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(255); match(T__2);
				setState(256); type();
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitStatList(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__3) | (1L << T__0) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << TRY) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(259); stat();
				}
				}
				setState(264);
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
		public TerminalNode IF() { return getToken(KalangParser.IF, 0); }
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(IF);
			setState(266); match(LPAREN);
			setState(267); expression(0);
			setState(268); match(RPAREN);
			setState(269); match(LBRACE);
			setState(270); statList();
			setState(271); match(RBRACE);
			setState(273);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(272); ifStatSuffix();
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
		public TerminalNode ELSE() { return getToken(KalangParser.ELSE, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public IfStatSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterIfStatSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitIfStatSuffix(this);
		}
	}

	public final IfStatSuffixContext ifStatSuffix() throws RecognitionException {
		IfStatSuffixContext _localctx = new IfStatSuffixContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(ELSE);
			setState(276); match(LBRACE);
			setState(277); statList();
			setState(278); match(RBRACE);
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
		public PostIfStmtContext postIfStmt() {
			return getRuleContext(PostIfStmtContext.class,0);
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
		public TryStatContext tryStat() {
			return getRuleContext(TryStatContext.class,0);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stat);
		try {
			setState(291);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280); postIfStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281); exprStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282); ifStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(283); whileStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(284); doWhileStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(285); forStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(286); breakStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(287); continueStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(288); varDeclStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(289); returnStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(290); tryStat();
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

	public static class TryStatContext extends ParserRuleContext {
		public StatListContext tryStmtList;
		public NoArrayTypeContext noArrayType;
		public List<NoArrayTypeContext> catchTypes = new ArrayList<NoArrayTypeContext>();
		public Token Identifier;
		public List<Token> catchVarNames = new ArrayList<Token>();
		public StatListContext statList;
		public List<StatListContext> catchStmts = new ArrayList<StatListContext>();
		public StatListContext finalStmtList;
		public StatListContext statList(int i) {
			return getRuleContext(StatListContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<NoArrayTypeContext> noArrayType() {
			return getRuleContexts(NoArrayTypeContext.class);
		}
		public List<StatListContext> statList() {
			return getRuleContexts(StatListContext.class);
		}
		public NoArrayTypeContext noArrayType(int i) {
			return getRuleContext(NoArrayTypeContext.class,i);
		}
		public TryStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterTryStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitTryStat(this);
		}
	}

	public final TryStatContext tryStat() throws RecognitionException {
		TryStatContext _localctx = new TryStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(TRY);
			setState(294); match(LBRACE);
			setState(295); ((TryStatContext)_localctx).tryStmtList = statList();
			setState(296); match(RBRACE);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(297); match(CATCH);
				setState(298); match(LPAREN);
				setState(299); ((TryStatContext)_localctx).noArrayType = noArrayType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).noArrayType);
				setState(300); ((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(301); match(RPAREN);
				setState(302); match(LBRACE);
				setState(303); ((TryStatContext)_localctx).statList = statList();
				((TryStatContext)_localctx).catchStmts.add(((TryStatContext)_localctx).statList);
				setState(304); match(RBRACE);
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(311); match(FINALLY);
				setState(312); match(LBRACE);
				setState(313); ((TryStatContext)_localctx).finalStmtList = statList();
				setState(314); match(RBRACE);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(RETURN);
			setState(320);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(319); expression(0);
				}
			}

			setState(322); match(SEMI);
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

	public static class PostIfStmtContext extends ParserRuleContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PostIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPostIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPostIfStmt(this);
		}
	}

	public final PostIfStmtContext postIfStmt() throws RecognitionException {
		PostIfStmtContext _localctx = new PostIfStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_postIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); expression(0);
			setState(325); match(IF);
			setState(332);
			switch (_input.LA(1)) {
			case EQUAL:
				{
				setState(326); ((PostIfStmtContext)_localctx).op = match(EQUAL);
				}
				break;
			case LT:
				{
				setState(327); ((PostIfStmtContext)_localctx).op = match(LT);
				}
				break;
			case GT:
				{
				setState(328); ((PostIfStmtContext)_localctx).op = match(GT);
				}
				break;
			case NOTEQUAL:
				{
				setState(329); ((PostIfStmtContext)_localctx).op = match(NOTEQUAL);
				}
				break;
			case GE:
				{
				setState(330); ((PostIfStmtContext)_localctx).op = match(GE);
				}
				break;
			case LE:
				{
				setState(331); ((PostIfStmtContext)_localctx).op = match(LE);
				}
				break;
			case T__6:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LBRACE:
			case LBRACK:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(334); expression(0);
			setState(335); match(SEMI);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitVarDeclStat(this);
		}
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); varDecl();
			setState(338); match(SEMI);
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public VarInitContext varInit() {
			return getRuleContext(VarInitContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(341); match(Identifier);
			setState(344);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(342); match(T__2);
				setState(343); type();
				}
			}

			setState(347);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(346); varInit();
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

	public static class VarInitContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterVarInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitVarInit(this);
		}
	}

	public final VarInitContext varInit() throws RecognitionException {
		VarInitContext _localctx = new VarInitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_varInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); match(ASSIGN);
			setState(350); expression(0);
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
		public TerminalNode BREAK() { return getToken(KalangParser.BREAK, 0); }
		public BreakStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitBreakStat(this);
		}
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352); match(BREAK);
			setState(353); match(SEMI);
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
		public TerminalNode CONTINUE() { return getToken(KalangParser.CONTINUE, 0); }
		public ContinueStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitContinueStat(this);
		}
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355); match(CONTINUE);
			setState(356); match(SEMI);
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
		public TerminalNode WHILE() { return getToken(KalangParser.WHILE, 0); }
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitWhileStat(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358); match(WHILE);
			setState(359); match(LPAREN);
			setState(360); expression(0);
			setState(361); match(RPAREN);
			setState(362); match(LBRACE);
			setState(363); statList();
			setState(364); match(RBRACE);
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
		public TerminalNode DO() { return getToken(KalangParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(KalangParser.WHILE, 0); }
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterDoWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitDoWhileStat(this);
		}
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); match(DO);
			setState(367); match(LBRACE);
			setState(368); statList();
			setState(369); match(RBRACE);
			setState(370); match(WHILE);
			setState(371); match(LPAREN);
			setState(372); expression(0);
			setState(373); match(RPAREN);
			setState(374); match(SEMI);
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
		public TerminalNode FOR() { return getToken(KalangParser.FOR, 0); }
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitForStat(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376); match(FOR);
			setState(377); match(LPAREN);
			setState(379);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__3) | (1L << T__0) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(378); forInit();
				}
			}

			setState(381); match(SEMI);
			setState(383);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(382); expression(0);
				}
			}

			setState(385); match(SEMI);
			setState(387);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(386); forUpdate();
				}
			}

			setState(389); match(RPAREN);
			setState(390); match(LBRACE);
			setState(391); statList();
			setState(392); match(RBRACE);
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
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forInit);
		try {
			setState(396);
			switch (_input.LA(1)) {
			case T__3:
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(394); varDecl();
				}
				break;
			case T__6:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LBRACE:
			case LBRACK:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(395); expressions();
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
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); expressions();
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

	public static class ExpressionsContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); expression(0);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(401); match(COMMA);
				setState(402); expression(0);
				}
				}
				setState(407);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprStat(this);
		}
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408); expression(0);
			setState(409); match(SEMI);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprPrimay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprPrimay(this);
		}
	}
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitNewExpr(this);
		}
	}
	public static class CastExprContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitCastExpr(this);
		}
	}
	public static class ExprMemberInvocationContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExprMemberInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprMemberInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprMemberInvocation(this);
		}
	}
	public static class MapExprContext extends ExpressionContext {
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public MapExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterMapExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitMapExpr(this);
		}
	}
	public static class ExprMidOpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprMidOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprMidOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprMidOp(this);
		}
	}
	public static class ExprAssignContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprAssign(this);
		}
	}
	public static class ListOrArrayExprContext extends ExpressionContext {
		public ListOrArrayContext listOrArray() {
			return getRuleContext(ListOrArrayContext.class,0);
		}
		public ListOrArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterListOrArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitListOrArrayExpr(this);
		}
	}
	public static class ExprInvocationContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprInvocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprInvocation(this);
		}
	}
	public static class ExprGetFieldContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprGetFieldContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprGetField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprGetField(this);
		}
	}
	public static class ExprSelfOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprSelfOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprSelfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprSelfOp(this);
		}
	}
	public static class ExprQuestionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprQuestionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprQuestion(this);
		}
	}
	public static class ExprSelfOpPreContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprSelfOpPreContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprSelfOpPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprSelfOpPre(this);
		}
	}
	public static class ExprGetArrayElementContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprGetArrayElementContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprGetArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprGetArrayElement(this);
		}
	}
	public static class ExprNewArrayContext extends ExpressionContext {
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public ExprNewArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprNewArray(this);
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
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(412); match(LPAREN);
				setState(413); type();
				setState(414); match(RPAREN);
				setState(415); expression(15);
				}
				break;
			case 2:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(417);
				_la = _input.LA(1);
				if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (INC - 87)) | (1L << (DEC - 87)) | (1L << (ADD - 87)) | (1L << (SUB - 87)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(418); expression(13);
				}
				break;
			case 3:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(419);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(420); expression(12);
				}
				break;
			case 4:
				{
				_localctx = new ExprPrimayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(421); primary();
				}
				break;
			case 5:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(422); map();
				}
				break;
			case 6:
				{
				_localctx = new ListOrArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(423); listOrArray();
				}
				break;
			case 7:
				{
				_localctx = new ExprMemberInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(424); match(Identifier);
				setState(425); arguments();
				}
				break;
			case 8:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(426); match(NEW);
				setState(427); match(Identifier);
				setState(428); arguments();
				}
				break;
			case 9:
				{
				_localctx = new ExprNewArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(429); match(NEW);
				setState(430); noArrayType();
				setState(431); match(LBRACK);
				setState(432); expression(0);
				setState(433); match(RBRACK);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(497);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(495);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(438);
						_la = _input.LA(1);
						if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (MUL - 91)) | (1L << (DIV - 91)) | (1L << (MOD - 91)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(439); expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(440);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(441);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(442); expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(451);
						switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
						case 1:
							{
							setState(444); match(LT);
							setState(445); match(LT);
							}
							break;
						case 2:
							{
							setState(446); match(GT);
							setState(447); match(GT);
							setState(448); match(GT);
							}
							break;
						case 3:
							{
							setState(449); match(GT);
							setState(450); match(GT);
							}
							break;
						}
						setState(453); expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(454);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(455);
						_la = _input.LA(1);
						if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (GT - 75)) | (1L << (LT - 75)) | (1L << (LE - 75)) | (1L << (GE - 75)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(456); expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(457);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(458);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(459); expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(460);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(461); match(BITAND);
						setState(462); expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(463);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(464); match(CARET);
						setState(465); expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(466);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(467); match(BITOR);
						setState(468); expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(469);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(470);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(471); expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExprQuestionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(472);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(473); match(QUESTION);
						setState(474); expression(0);
						setState(475); match(COLON);
						setState(476); expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExprAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(478);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(479);
						_la = _input.LA(1);
						if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (ASSIGN - 74)) | (1L << (ADD_ASSIGN - 74)) | (1L << (SUB_ASSIGN - 74)) | (1L << (MUL_ASSIGN - 74)) | (1L << (DIV_ASSIGN - 74)) | (1L << (AND_ASSIGN - 74)) | (1L << (OR_ASSIGN - 74)) | (1L << (XOR_ASSIGN - 74)) | (1L << (MOD_ASSIGN - 74)) | (1L << (LSHIFT_ASSIGN - 74)) | (1L << (RSHIFT_ASSIGN - 74)) | (1L << (URSHIFT_ASSIGN - 74)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(480); expression(1);
						}
						break;
					case 12:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(481);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(482); match(DOT);
						setState(483); match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(484);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(485); match(DOT);
						setState(486); match(Identifier);
						setState(487); arguments();
						}
						break;
					case 14:
						{
						_localctx = new ExprGetArrayElementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(488);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(489); match(LBRACK);
						setState(490); expression(0);
						setState(491); match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new ExprSelfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(493);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(494);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					}
					} 
				}
				setState(499);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimayParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPrimayParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPrimayParen(this);
		}
	}
	public static class PrimaryIdentifierContext extends PrimaryContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public PrimaryIdentifierContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPrimaryIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPrimaryIdentifier(this);
		}
	}
	public static class PrimaryLiteralContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPrimaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPrimaryLiteral(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_primary);
		try {
			setState(506);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimayParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(500); match(LPAREN);
				setState(501); expression(0);
				setState(502); match(RPAREN);
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
				setState(504); literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(505); match(Identifier);
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

	public static class MapContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitMap(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				setState(508); noArrayType();
				}
			}

			setState(511); match(LBRACE);
			setState(524);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(512); match(Identifier);
				setState(513); match(COLON);
				setState(514); expression(0);
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(515); match(COMMA);
					setState(516); match(Identifier);
					setState(517); match(COLON);
					setState(518); expression(0);
					}
					}
					setState(523);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(526); match(RBRACE);
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

	public static class ListOrArrayContext extends ParserRuleContext {
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ListOrArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listOrArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterListOrArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitListOrArray(this);
		}
	}

	public final ListOrArrayContext listOrArray() throws RecognitionException {
		ListOrArrayContext _localctx = new ListOrArrayContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_listOrArray);
		int _la;
		try {
			setState(543);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(528); match(T__6);
				}
				break;
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case LBRACK:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(530);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
					{
					setState(529); noArrayType();
					}
				}

				setState(532); match(LBRACK);
				{
				setState(533); expression(0);
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(534); match(COMMA);
					setState(535); expression(0);
					}
					}
					setState(540);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(541); match(RBRACK);
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
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(KalangParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(KalangParser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KalangParser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(KalangParser.CharacterLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (IntegerLiteral - 59)) | (1L << (FloatingPointLiteral - 59)) | (1L << (BooleanLiteral - 59)) | (1L << (CharacterLiteral - 59)) | (1L << (StringLiteral - 59)) | (1L << (NullLiteral - 59)))) != 0)) ) {
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547); match(LPAREN);
			setState(556);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(548); expression(0);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(549); match(COMMA);
					setState(550); expression(0);
					}
					}
					setState(555);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(558); match(RPAREN);
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
		case 34: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);
		case 1: return precpred(_ctx, 10);
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		case 6: return precpred(_ctx, 5);
		case 7: return precpred(_ctx, 4);
		case 8: return precpred(_ctx, 3);
		case 9: return precpred(_ctx, 2);
		case 10: return precpred(_ctx, 1);
		case 11: return precpred(_ctx, 21);
		case 12: return precpred(_ctx, 20);
		case 13: return precpred(_ctx, 18);
		case 14: return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3s\u0233\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\5"+
		"\2V\n\2\3\2\5\2Y\n\2\3\2\3\2\5\2]\n\2\3\2\3\2\3\2\3\2\7\2c\n\2\f\2\16"+
		"\2f\13\2\5\2h\n\2\3\2\3\2\3\2\3\2\3\3\7\3o\n\3\f\3\16\3r\13\3\3\4\3\4"+
		"\3\4\3\4\3\4\7\4y\n\4\f\4\16\4|\13\4\3\4\3\4\3\4\3\4\5\4\u0082\n\4\3\4"+
		"\5\4\u0085\n\4\3\4\3\4\3\5\3\5\3\5\7\5\u008c\n\5\f\5\16\5\u008f\13\5\3"+
		"\6\3\6\3\6\3\7\7\7\u0095\n\7\f\7\16\7\u0098\13\7\3\b\5\b\u009b\n\b\3\b"+
		"\3\b\3\b\5\b\u00a0\n\b\3\b\3\b\5\b\u00a4\n\b\3\b\5\b\u00a7\n\b\3\b\5\b"+
		"\u00aa\n\b\3\b\5\b\u00ad\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13\3\f\5\f"+
		"\u00c5\n\f\3\f\3\f\3\f\5\f\u00ca\n\f\3\f\3\f\5\f\u00ce\n\f\3\f\3\f\3\f"+
		"\5\f\u00d3\n\f\3\f\3\f\3\f\5\f\u00d8\n\f\3\f\3\f\5\f\u00dc\n\f\3\f\5\f"+
		"\u00df\n\f\3\f\3\f\3\f\3\f\7\f\u00e5\n\f\f\f\16\f\u00e8\13\f\5\f\u00ea"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f1\n\f\3\r\3\r\5\r\u00f5\n\r\3\16\3\16"+
		"\3\17\3\17\3\17\7\17\u00fc\n\17\f\17\16\17\u00ff\13\17\3\20\3\20\3\20"+
		"\5\20\u0104\n\20\3\21\7\21\u0107\n\21\f\21\16\21\u010a\13\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0114\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0126\n\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u0135\n\25\f\25\16\25\u0138\13\25\3\25\3\25\3\25\3\25\3\25\5\25\u013f"+
		"\n\25\3\26\3\26\5\26\u0143\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u014f\n\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\5\31\u015b\n\31\3\31\5\31\u015e\n\31\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u017e\n\37"+
		"\3\37\3\37\5\37\u0182\n\37\3\37\3\37\5\37\u0186\n\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \5 \u018f\n \3!\3!\3\"\3\"\3\"\7\"\u0196\n\"\f\"\16\"\u0199"+
		"\13\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\5$\u01b6\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\5$\u01c6\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\7$\u01f2\n$\f$\16$\u01f5\13$\3%\3%\3%\3%\3%\3%\5%\u01fd\n%\3&\5&\u0200"+
		"\n&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u020a\n&\f&\16&\u020d\13&\5&\u020f\n&\3"+
		"&\3&\3\'\3\'\5\'\u0215\n\'\3\'\3\'\3\'\3\'\7\'\u021b\n\'\f\'\16\'\u021e"+
		"\13\'\3\'\3\'\5\'\u0222\n\'\3(\3(\3)\3)\3)\3)\7)\u022a\n)\f)\16)\u022d"+
		"\13)\5)\u022f\n)\3)\3)\3)\2\3F*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNP\2\20\4\2OOQQ\4\2\6\6\t\t\4\2\7\7\n"+
		"\n\7\2\30\30\36\36%%\'\'nn\3\2Y\\\3\2OP\4\2]^bb\3\2[\\\4\2MNTU\4\2SSV"+
		"V\3\2WX\4\2LLcm\3\2YZ\3\2=B\u0268\2R\3\2\2\2\4p\3\2\2\2\6s\3\2\2\2\b\u0088"+
		"\3\2\2\2\n\u0090\3\2\2\2\f\u0096\3\2\2\2\16\u009a\3\2\2\2\20\u00b0\3\2"+
		"\2\2\22\u00b8\3\2\2\2\24\u00c0\3\2\2\2\26\u00c4\3\2\2\2\30\u00f2\3\2\2"+
		"\2\32\u00f6\3\2\2\2\34\u00f8\3\2\2\2\36\u0100\3\2\2\2 \u0108\3\2\2\2\""+
		"\u010b\3\2\2\2$\u0115\3\2\2\2&\u0125\3\2\2\2(\u0127\3\2\2\2*\u0140\3\2"+
		"\2\2,\u0146\3\2\2\2.\u0153\3\2\2\2\60\u0156\3\2\2\2\62\u015f\3\2\2\2\64"+
		"\u0162\3\2\2\2\66\u0165\3\2\2\28\u0168\3\2\2\2:\u0170\3\2\2\2<\u017a\3"+
		"\2\2\2>\u018e\3\2\2\2@\u0190\3\2\2\2B\u0192\3\2\2\2D\u019a\3\2\2\2F\u01b5"+
		"\3\2\2\2H\u01fc\3\2\2\2J\u01ff\3\2\2\2L\u0221\3\2\2\2N\u0223\3\2\2\2P"+
		"\u0225\3\2\2\2RU\5\4\3\2SV\7\23\2\2TV\7&\2\2US\3\2\2\2UT\3\2\2\2VX\3\2"+
		"\2\2WY\t\2\2\2XW\3\2\2\2XY\3\2\2\2Y\\\3\2\2\2Z[\7\33\2\2[]\7n\2\2\\Z\3"+
		"\2\2\2\\]\3\2\2\2]g\3\2\2\2^_\7\"\2\2_d\7n\2\2`a\7J\2\2ac\7n\2\2b`\3\2"+
		"\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eh\3\2\2\2fd\3\2\2\2g^\3\2\2\2gh\3\2"+
		"\2\2hi\3\2\2\2ij\7E\2\2jk\5\n\6\2kl\7F\2\2l\3\3\2\2\2mo\5\6\4\2nm\3\2"+
		"\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\5\3\2\2\2rp\3\2\2\2st\7#\2\2tu\t\3"+
		"\2\2uz\7n\2\2vw\7\t\2\2wy\7n\2\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2"+
		"\2{}\3\2\2\2|z\3\2\2\2}\u0084\7\t\2\2~\u0081\7n\2\2\177\u0080\7\b\2\2"+
		"\u0080\u0082\7n\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0085\7]\2\2\u0084~\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0087\7I\2\2\u0087\7\3\2\2\2\u0088\u008d\7n\2\2\u0089\u008a"+
		"\7K\2\2\u008a\u008c\7n\2\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\t\3\2\2\2\u008f\u008d\3\2\2\2"+
		"\u0090\u0091\5\f\7\2\u0091\u0092\5\24\13\2\u0092\13\3\2\2\2\u0093\u0095"+
		"\5\16\b\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\r\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\7"+
		"\60\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\t\4\2\2\u009d\u009f\7n\2\2\u009e\u00a0\t\2\2\2\u009f\u009e\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u00a2\7\b\2\2\u00a2"+
		"\u00a4\5\30\r\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3"+
		"\2\2\2\u00a5\u00a7\5\62\32\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00aa\5\20\t\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00ad\5\22\n\2\u00ac\u00ab\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7I\2\2\u00af\17\3\2\2\2"+
		"\u00b0\u00b1\7\3\2\2\u00b1\u00b2\7C\2\2\u00b2\u00b3\5\34\17\2\u00b3\u00b4"+
		"\7D\2\2\u00b4\u00b5\7E\2\2\u00b5\u00b6\5 \21\2\u00b6\u00b7\7F\2\2\u00b7"+
		"\21\3\2\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\7E\2\2\u00ba\u00bb\5 \21\2"+
		"\u00bb\u00bc\7F\2\2\u00bc\23\3\2\2\2\u00bd\u00bf\5\26\f\2\u00be\u00bd"+
		"\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\25\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5\7\60\2\2\u00c4\u00c3\3\2\2"+
		"\2\u00c4\u00c5\3\2\2\2\u00c5\u00de\3\2\2\2\u00c6\u00c7\7\7\2\2\u00c7\u00c9"+
		"\7n\2\2\u00c8\u00ca\t\2\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\7C\2\2\u00cc\u00ce\5\34\17\2\u00cd\u00cc\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\7D\2\2\u00d0"+
		"\u00d1\7\b\2\2\u00d1\u00d3\5\30\r\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3"+
		"\2\2\2\u00d3\u00df\3\2\2\2\u00d4\u00d5\7:\2\2\u00d5\u00d7\7n\2\2\u00d6"+
		"\u00d8\t\2\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00db\7C\2\2\u00da\u00dc\5\34\17\2\u00db\u00da\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\7D\2\2\u00de\u00c6\3\2"+
		"\2\2\u00de\u00d4\3\2\2\2\u00df\u00e9\3\2\2\2\u00e0\u00e1\7\67\2\2\u00e1"+
		"\u00e6\7n\2\2\u00e2\u00e3\7J\2\2\u00e3\u00e5\7n\2\2\u00e4\u00e2\3\2\2"+
		"\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00e0\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00f0\3\2\2\2\u00eb\u00ec\7E\2\2\u00ec\u00ed\5 \21\2\u00ed\u00ee\7F\2"+
		"\2\u00ee\u00f1\3\2\2\2\u00ef\u00f1\7I\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\27\3\2\2\2\u00f2\u00f4\5\32\16\2\u00f3\u00f5\7\4\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\31\3\2\2\2\u00f6\u00f7\t\5\2"+
		"\2\u00f7\33\3\2\2\2\u00f8\u00fd\5\36\20\2\u00f9\u00fa\7J\2\2\u00fa\u00fc"+
		"\5\36\20\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe\35\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103"+
		"\7n\2\2\u0101\u0102\7\b\2\2\u0102\u0104\5\30\r\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\37\3\2\2\2\u0105\u0107\5&\24\2\u0106\u0105\3\2\2"+
		"\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109!"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7 \2\2\u010c\u010d\7C\2\2\u010d"+
		"\u010e\5F$\2\u010e\u010f\7D\2\2\u010f\u0110\7E\2\2\u0110\u0111\5 \21\2"+
		"\u0111\u0113\7F\2\2\u0112\u0114\5$\23\2\u0113\u0112\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114#\3\2\2\2\u0115\u0116\7\31\2\2\u0116\u0117\7E\2\2\u0117"+
		"\u0118\5 \21\2\u0118\u0119\7F\2\2\u0119%\3\2\2\2\u011a\u0126\5,\27\2\u011b"+
		"\u0126\5D#\2\u011c\u0126\5\"\22\2\u011d\u0126\58\35\2\u011e\u0126\5:\36"+
		"\2\u011f\u0126\5<\37\2\u0120\u0126\5\64\33\2\u0121\u0126\5\66\34\2\u0122"+
		"\u0126\5.\30\2\u0123\u0126\5*\26\2\u0124\u0126\5(\25\2\u0125\u011a\3\2"+
		"\2\2\u0125\u011b\3\2\2\2\u0125\u011c\3\2\2\2\u0125\u011d\3\2\2\2\u0125"+
		"\u011e\3\2\2\2\u0125\u011f\3\2\2\2\u0125\u0120\3\2\2\2\u0125\u0121\3\2"+
		"\2\2\u0125\u0122\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126"+
		"\'\3\2\2\2\u0127\u0128\79\2\2\u0128\u0129\7E\2\2\u0129\u012a\5 \21\2\u012a"+
		"\u0136\7F\2\2\u012b\u012c\7\21\2\2\u012c\u012d\7C\2\2\u012d\u012e\5\32"+
		"\16\2\u012e\u012f\7n\2\2\u012f\u0130\7D\2\2\u0130\u0131\7E\2\2\u0131\u0132"+
		"\5 \21\2\u0132\u0133\7F\2\2\u0133\u0135\3\2\2\2\u0134\u012b\3\2\2\2\u0135"+
		"\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u013e\3\2"+
		"\2\2\u0138\u0136\3\2\2\2\u0139\u013a\7\35\2\2\u013a\u013b\7E\2\2\u013b"+
		"\u013c\5 \21\2\u013c\u013d\7F\2\2\u013d\u013f\3\2\2\2\u013e\u0139\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f)\3\2\2\2\u0140\u0142\7.\2\2\u0141\u0143"+
		"\5F$\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0145\7I\2\2\u0145+\3\2\2\2\u0146\u0147\5F$\2\u0147\u014e\7 \2\2\u0148"+
		"\u014f\7S\2\2\u0149\u014f\7N\2\2\u014a\u014f\7M\2\2\u014b\u014f\7V\2\2"+
		"\u014c\u014f\7U\2\2\u014d\u014f\7T\2\2\u014e\u0148\3\2\2\2\u014e\u0149"+
		"\3\2\2\2\u014e\u014a\3\2\2\2\u014e\u014b\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\5F"+
		"$\2\u0151\u0152\7I\2\2\u0152-\3\2\2\2\u0153\u0154\5\60\31\2\u0154\u0155"+
		"\7I\2\2\u0155/\3\2\2\2\u0156\u0157\t\4\2\2\u0157\u015a\7n\2\2\u0158\u0159"+
		"\7\b\2\2\u0159\u015b\5\30\r\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2"+
		"\u015b\u015d\3\2\2\2\u015c\u015e\5\62\32\2\u015d\u015c\3\2\2\2\u015d\u015e"+
		"\3\2\2\2\u015e\61\3\2\2\2\u015f\u0160\7L\2\2\u0160\u0161\5F$\2\u0161\63"+
		"\3\2\2\2\u0162\u0163\7\16\2\2\u0163\u0164\7I\2\2\u0164\65\3\2\2\2\u0165"+
		"\u0166\7\25\2\2\u0166\u0167\7I\2\2\u0167\67\3\2\2\2\u0168\u0169\7<\2\2"+
		"\u0169\u016a\7C\2\2\u016a\u016b\5F$\2\u016b\u016c\7D\2\2\u016c\u016d\7"+
		"E\2\2\u016d\u016e\5 \21\2\u016e\u016f\7F\2\2\u016f9\3\2\2\2\u0170\u0171"+
		"\7\27\2\2\u0171\u0172\7E\2\2\u0172\u0173\5 \21\2\u0173\u0174\7F\2\2\u0174"+
		"\u0175\7<\2\2\u0175\u0176\7C\2\2\u0176\u0177\5F$\2\u0177\u0178\7D\2\2"+
		"\u0178\u0179\7I\2\2\u0179;\3\2\2\2\u017a\u017b\7\37\2\2\u017b\u017d\7"+
		"C\2\2\u017c\u017e\5> \2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0181\7I\2\2\u0180\u0182\5F$\2\u0181\u0180\3\2\2"+
		"\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\7I\2\2\u0184\u0186"+
		"\5@!\2\u0185\u0184\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0188\7D\2\2\u0188\u0189\7E\2\2\u0189\u018a\5 \21\2\u018a\u018b\7F\2"+
		"\2\u018b=\3\2\2\2\u018c\u018f\5\60\31\2\u018d\u018f\5B\"\2\u018e\u018c"+
		"\3\2\2\2\u018e\u018d\3\2\2\2\u018f?\3\2\2\2\u0190\u0191\5B\"\2\u0191A"+
		"\3\2\2\2\u0192\u0197\5F$\2\u0193\u0194\7J\2\2\u0194\u0196\5F$\2\u0195"+
		"\u0193\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198C\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\5F$\2\u019b\u019c"+
		"\7I\2\2\u019cE\3\2\2\2\u019d\u019e\b$\1\2\u019e\u019f\7C\2\2\u019f\u01a0"+
		"\5\30\r\2\u01a0\u01a1\7D\2\2\u01a1\u01a2\5F$\21\u01a2\u01b6\3\2\2\2\u01a3"+
		"\u01a4\t\6\2\2\u01a4\u01b6\5F$\17\u01a5\u01a6\t\7\2\2\u01a6\u01b6\5F$"+
		"\16\u01a7\u01b6\5H%\2\u01a8\u01b6\5J&\2\u01a9\u01b6\5L\'\2\u01aa\u01ab"+
		"\7n\2\2\u01ab\u01b6\5P)\2\u01ac\u01ad\7)\2\2\u01ad\u01ae\7n\2\2\u01ae"+
		"\u01b6\5P)\2\u01af\u01b0\7)\2\2\u01b0\u01b1\5\32\16\2\u01b1\u01b2\7G\2"+
		"\2\u01b2\u01b3\5F$\2\u01b3\u01b4\7H\2\2\u01b4\u01b6\3\2\2\2\u01b5\u019d"+
		"\3\2\2\2\u01b5\u01a3\3\2\2\2\u01b5\u01a5\3\2\2\2\u01b5\u01a7\3\2\2\2\u01b5"+
		"\u01a8\3\2\2\2\u01b5\u01a9\3\2\2\2\u01b5\u01aa\3\2\2\2\u01b5\u01ac\3\2"+
		"\2\2\u01b5\u01af\3\2\2\2\u01b6\u01f3\3\2\2\2\u01b7\u01b8\f\r\2\2\u01b8"+
		"\u01b9\t\b\2\2\u01b9\u01f2\5F$\16\u01ba\u01bb\f\f\2\2\u01bb\u01bc\t\t"+
		"\2\2\u01bc\u01f2\5F$\r\u01bd\u01c5\f\13\2\2\u01be\u01bf\7N\2\2\u01bf\u01c6"+
		"\7N\2\2\u01c0\u01c1\7M\2\2\u01c1\u01c2\7M\2\2\u01c2\u01c6\7M\2\2\u01c3"+
		"\u01c4\7M\2\2\u01c4\u01c6\7M\2\2\u01c5\u01be\3\2\2\2\u01c5\u01c0\3\2\2"+
		"\2\u01c5\u01c3\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01f2\5F$\f\u01c8\u01c9"+
		"\f\n\2\2\u01c9\u01ca\t\n\2\2\u01ca\u01f2\5F$\13\u01cb\u01cc\f\t\2\2\u01cc"+
		"\u01cd\t\13\2\2\u01cd\u01f2\5F$\n\u01ce\u01cf\f\b\2\2\u01cf\u01d0\7_\2"+
		"\2\u01d0\u01f2\5F$\t\u01d1\u01d2\f\7\2\2\u01d2\u01d3\7a\2\2\u01d3\u01f2"+
		"\5F$\b\u01d4\u01d5\f\6\2\2\u01d5\u01d6\7`\2\2\u01d6\u01f2\5F$\7\u01d7"+
		"\u01d8\f\5\2\2\u01d8\u01d9\t\f\2\2\u01d9\u01f2\5F$\6\u01da\u01db\f\4\2"+
		"\2\u01db\u01dc\7Q\2\2\u01dc\u01dd\5F$\2\u01dd\u01de\7R\2\2\u01de\u01df"+
		"\5F$\5\u01df\u01f2\3\2\2\2\u01e0\u01e1\f\3\2\2\u01e1\u01e2\t\r\2\2\u01e2"+
		"\u01f2\5F$\3\u01e3\u01e4\f\27\2\2\u01e4\u01e5\7K\2\2\u01e5\u01f2\7n\2"+
		"\2\u01e6\u01e7\f\26\2\2\u01e7\u01e8\7K\2\2\u01e8\u01e9\7n\2\2\u01e9\u01f2"+
		"\5P)\2\u01ea\u01eb\f\24\2\2\u01eb\u01ec\7G\2\2\u01ec\u01ed\5F$\2\u01ed"+
		"\u01ee\7H\2\2\u01ee\u01f2\3\2\2\2\u01ef\u01f0\f\20\2\2\u01f0\u01f2\t\16"+
		"\2\2\u01f1\u01b7\3\2\2\2\u01f1\u01ba\3\2\2\2\u01f1\u01bd\3\2\2\2\u01f1"+
		"\u01c8\3\2\2\2\u01f1\u01cb\3\2\2\2\u01f1\u01ce\3\2\2\2\u01f1\u01d1\3\2"+
		"\2\2\u01f1\u01d4\3\2\2\2\u01f1\u01d7\3\2\2\2\u01f1\u01da\3\2\2\2\u01f1"+
		"\u01e0\3\2\2\2\u01f1\u01e3\3\2\2\2\u01f1\u01e6\3\2\2\2\u01f1\u01ea\3\2"+
		"\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4G\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\7C\2\2\u01f7"+
		"\u01f8\5F$\2\u01f8\u01f9\7D\2\2\u01f9\u01fd\3\2\2\2\u01fa\u01fd\5N(\2"+
		"\u01fb\u01fd\7n\2\2\u01fc\u01f6\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fb"+
		"\3\2\2\2\u01fdI\3\2\2\2\u01fe\u0200\5\32\16\2\u01ff\u01fe\3\2\2\2\u01ff"+
		"\u0200\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u020e\7E\2\2\u0202\u0203\7n\2"+
		"\2\u0203\u0204\7R\2\2\u0204\u020b\5F$\2\u0205\u0206\7J\2\2\u0206\u0207"+
		"\7n\2\2\u0207\u0208\7R\2\2\u0208\u020a\5F$\2\u0209\u0205\3\2\2\2\u020a"+
		"\u020d\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020f\3\2"+
		"\2\2\u020d\u020b\3\2\2\2\u020e\u0202\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\u0210\3\2\2\2\u0210\u0211\7F\2\2\u0211K\3\2\2\2\u0212\u0222\7\4\2\2\u0213"+
		"\u0215\5\32\16\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3"+
		"\2\2\2\u0216\u0217\7G\2\2\u0217\u021c\5F$\2\u0218\u0219\7J\2\2\u0219\u021b"+
		"\5F$\2\u021a\u0218\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c"+
		"\u021d\3\2\2\2\u021d\u021f\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0220\7H"+
		"\2\2\u0220\u0222\3\2\2\2\u0221\u0212\3\2\2\2\u0221\u0214\3\2\2\2\u0222"+
		"M\3\2\2\2\u0223\u0224\t\17\2\2\u0224O\3\2\2\2\u0225\u022e\7C\2\2\u0226"+
		"\u022b\5F$\2\u0227\u0228\7J\2\2\u0228\u022a\5F$\2\u0229\u0227\3\2\2\2"+
		"\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022f"+
		"\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u0226\3\2\2\2\u022e\u022f\3\2\2\2\u022f"+
		"\u0230\3\2\2\2\u0230\u0231\7D\2\2\u0231Q\3\2\2\2<UX\\dgpz\u0081\u0084"+
		"\u008d\u0096\u009a\u009f\u00a3\u00a6\u00a9\u00ac\u00c0\u00c4\u00c9\u00cd"+
		"\u00d2\u00d7\u00db\u00de\u00e6\u00e9\u00f0\u00f4\u00fd\u0103\u0108\u0113"+
		"\u0125\u0136\u013e\u0142\u014e\u015a\u015d\u017d\u0181\u0185\u018e\u0197"+
		"\u01b5\u01c5\u01f1\u01f3\u01fc\u01ff\u020b\u020e\u0214\u021c\u0221\u022b"+
		"\u022e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
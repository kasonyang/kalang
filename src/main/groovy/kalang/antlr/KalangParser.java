// Generated from Kalang.g4 by ANTLR 4.5
package kalang.antlr;
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Modifier=7, ABSTRACT=8, 
		ASSERT=9, BOOLEAN=10, BREAK=11, BYTE=12, CASE=13, CATCH=14, CHAR=15, CLASS=16, 
		CONST=17, CONTINUE=18, DEFAULT=19, DO=20, DOUBLE=21, ELSE=22, ENUM=23, 
		EXTENDS=24, FINAL=25, FINALLY=26, FLOAT=27, FOR=28, IF=29, GOTO=30, IMPLEMENTS=31, 
		IMPORT=32, INSTANCEOF=33, INT=34, INTERFACE=35, LONG=36, NATIVE=37, NEW=38, 
		PACKAGE=39, PRIVATE=40, PROTECTED=41, PUBLIC=42, RETURN=43, SHORT=44, 
		STATIC=45, STRICTFP=46, SUPER=47, SWITCH=48, SYNCHRONIZED=49, THIS=50, 
		THROW=51, THROWS=52, TRANSIENT=53, TRY=54, VOID=55, VOLATILE=56, WHILE=57, 
		IntegerLiteral=58, FloatingPointLiteral=59, BooleanLiteral=60, CharacterLiteral=61, 
		StringLiteral=62, NullLiteral=63, LPAREN=64, RPAREN=65, LBRACE=66, RBRACE=67, 
		LBRACK=68, RBRACK=69, SEMI=70, COMMA=71, DOT=72, ASSIGN=73, GT=74, LT=75, 
		BANG=76, TILDE=77, QUESTION=78, COLON=79, EQUAL=80, LE=81, GE=82, NOTEQUAL=83, 
		AND=84, OR=85, INC=86, DEC=87, ADD=88, SUB=89, MUL=90, DIV=91, BITAND=92, 
		BITOR=93, CARET=94, MOD=95, ADD_ASSIGN=96, SUB_ASSIGN=97, MUL_ASSIGN=98, 
		DIV_ASSIGN=99, AND_ASSIGN=100, OR_ASSIGN=101, XOR_ASSIGN=102, MOD_ASSIGN=103, 
		LSHIFT_ASSIGN=104, RSHIFT_ASSIGN=105, URSHIFT_ASSIGN=106, Identifier=107, 
		AT=108, ELLIPSIS=109, WS=110, COMMENT=111, LINE_COMMENT=112;
	public static final int
		RULE_compiliantUnit = 0, RULE_importDeclList = 1, RULE_importDecl = 2, 
		RULE_importPath = 3, RULE_qualifiedName = 4, RULE_classBody = 5, RULE_fieldDeclList = 6, 
		RULE_fieldDecl = 7, RULE_setter = 8, RULE_getter = 9, RULE_methodDeclList = 10, 
		RULE_methodDecl = 11, RULE_type = 12, RULE_argumentDeclList = 13, RULE_argumentDecl = 14, 
		RULE_statList = 15, RULE_ifStat = 16, RULE_ifStatSuffix = 17, RULE_stat = 18, 
		RULE_returnStat = 19, RULE_varDeclStat = 20, RULE_varDecl = 21, RULE_varInit = 22, 
		RULE_breakStat = 23, RULE_continueStat = 24, RULE_whileStat = 25, RULE_doWhileStat = 26, 
		RULE_forStat = 27, RULE_forInit = 28, RULE_forUpdate = 29, RULE_expressions = 30, 
		RULE_exprStat = 31, RULE_expression = 32, RULE_primary = 33, RULE_literal = 34, 
		RULE_arguments = 35;
	public static final String[] ruleNames = {
		"compiliantUnit", "importDeclList", "importDecl", "importPath", "qualifiedName", 
		"classBody", "fieldDeclList", "fieldDecl", "setter", "getter", "methodDeclList", 
		"methodDecl", "type", "argumentDeclList", "argumentDecl", "statList", 
		"ifStat", "ifStatSuffix", "stat", "returnStat", "varDeclStat", "varDecl", 
		"varInit", "breakStat", "continueStat", "whileStat", "doWhileStat", "forStat", 
		"forInit", "forUpdate", "expressions", "exprStat", "expression", "primary", 
		"literal", "arguments"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'val'", "'var'", "'as'", "'set'", "'get'", "'[]'", null, "'abstract'", 
		"'assert'", "'boolean'", "'break'", "'byte'", "'case'", "'catch'", "'char'", 
		"'class'", "'const'", "'continue'", "'default'", "'do'", "'double'", "'else'", 
		"'enum'", "'extends'", "'final'", "'finally'", "'float'", "'for'", "'if'", 
		"'goto'", "'implements'", "'import'", "'instanceof'", "'int'", "'interface'", 
		"'long'", "'native'", "'new'", "'package'", "'private'", "'protected'", 
		"'public'", "'return'", "'short'", "'static'", "'strictfp'", "'super'", 
		"'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", "'transient'", 
		"'try'", "'void'", "'volatile'", "'while'", null, null, null, null, null, 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", 
		"'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", 
		"'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "Modifier", "ABSTRACT", "ASSERT", 
		"BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", 
		"CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", 
		"FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", 
		"INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", 
		"PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", 
		"SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRY", "VOID", 
		"VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", 
		"CharacterLiteral", "StringLiteral", "NullLiteral", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
		"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
		"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", 
		"BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
		"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", "AT", "ELLIPSIS", "WS", 
		"COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Kalang.g4"; }

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
		public ImportDeclListContext importDeclList() {
			return getRuleContext(ImportDeclListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode Modifier() { return getToken(KalangParser.Modifier, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitCompiliantUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompiliantUnitContext compiliantUnit() throws RecognitionException {
		CompiliantUnitContext _localctx = new CompiliantUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compiliantUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			importDeclList();
			setState(73);
			match(CLASS);
			setState(75);
			_la = _input.LA(1);
			if (_la==Modifier) {
				{
				setState(74);
				match(Modifier);
				}
			}

			setState(79);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(77);
				match(EXTENDS);
				setState(78);
				match(Identifier);
				}
			}

			setState(81);
			match(LBRACE);
			setState(82);
			classBody();
			setState(83);
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

	public static class ImportDeclListContext extends ParserRuleContext {
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitImportDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclListContext importDeclList() throws RecognitionException {
		ImportDeclListContext _localctx = new ImportDeclListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(85);
				importDecl();
				}
				}
				setState(90);
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
		public ImportPathContext importPath() {
			return getRuleContext(ImportPathContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitImportDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(IMPORT);
			setState(93);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(92);
				match(STATIC);
				}
			}

			setState(95);
			importPath();
			setState(96);
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

	public static class ImportPathContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterImportPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitImportPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitImportPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportPathContext importPath() throws RecognitionException {
		ImportPathContext _localctx = new ImportPathContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			qualifiedName();
			setState(101);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(99);
				match(DOT);
				setState(100);
				match(MUL);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(Identifier);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					match(DOT);
					setState(105);
					match(Identifier);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public FieldDeclListContext fieldDeclList() {
			return getRuleContext(FieldDeclListContext.class,0);
		}
		public MethodDeclListContext methodDeclList() {
			return getRuleContext(MethodDeclListContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			fieldDeclList();
			setState(112);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitFieldDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclListContext fieldDeclList() throws RecognitionException {
		FieldDeclListContext _localctx = new FieldDeclListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDeclList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					fieldDecl();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
		public TerminalNode Modifier() { return getToken(KalangParser.Modifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarInitContext varInit() {
			return getRuleContext(VarInitContext.class,0);
		}
		public SetterContext setter() {
			return getRuleContext(SetterContext.class,0);
		}
		public GetterContext getter() {
			return getRuleContext(GetterContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(120);
				match(STATIC);
				}
			}

			setState(123);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(124);
			match(Identifier);
			setState(126);
			_la = _input.LA(1);
			if (_la==Modifier) {
				{
				setState(125);
				match(Modifier);
				}
			}

			setState(130);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(128);
				match(T__2);
				setState(129);
				type();
				}
			}

			setState(133);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(132);
				varInit();
				}
			}

			setState(136);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(135);
				setter();
				}
			}

			setState(139);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(138);
				getter();
				}
			}

			setState(141);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitSetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetterContext setter() throws RecognitionException {
		SetterContext _localctx = new SetterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_setter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__3);
			setState(144);
			match(LPAREN);
			setState(145);
			argumentDeclList();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitGetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetterContext getter() throws RecognitionException {
		GetterContext _localctx = new GetterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_getter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__4);
			setState(152);
			match(LBRACE);
			setState(153);
			statList();
			setState(154);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitMethodDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclListContext methodDeclList() throws RecognitionException {
		MethodDeclListContext _localctx = new MethodDeclListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==STATIC) {
				{
				{
				setState(156);
				methodDecl();
				}
				}
				setState(161);
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
		public TerminalNode Modifier() { return getToken(KalangParser.Modifier, 0); }
		public ArgumentDeclListContext argumentDeclList() {
			return getRuleContext(ArgumentDeclListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(162);
				match(STATIC);
				}
			}

			setState(165);
			match(T__1);
			setState(166);
			match(Identifier);
			setState(168);
			_la = _input.LA(1);
			if (_la==Modifier) {
				{
				setState(167);
				match(Modifier);
				}
			}

			setState(170);
			match(LPAREN);
			setState(172);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(171);
				argumentDeclList();
				}
			}

			setState(174);
			match(RPAREN);
			setState(177);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(175);
				match(T__2);
				setState(176);
				type();
				}
			}

			setState(179);
			match(LBRACE);
			setState(180);
			statList();
			setState(181);
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode DOUBLE() { return getToken(KalangParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(KalangParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(KalangParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(KalangParser.INT, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(185);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(184);
				match(T__5);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitArgumentDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentDeclListContext argumentDeclList() throws RecognitionException {
		ArgumentDeclListContext _localctx = new ArgumentDeclListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argumentDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			argumentDecl();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(188);
				match(COMMA);
				setState(189);
				argumentDecl();
				}
				}
				setState(194);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitArgumentDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentDeclContext argumentDecl() throws RecognitionException {
		ArgumentDeclContext _localctx = new ArgumentDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argumentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(Identifier);
			setState(198);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(196);
				match(T__2);
				setState(197);
				type();
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(200);
				stat();
				}
				}
				setState(205);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(IF);
			setState(207);
			match(LPAREN);
			setState(208);
			expression(0);
			setState(209);
			match(RPAREN);
			setState(210);
			match(LBRACE);
			setState(211);
			statList();
			setState(212);
			match(RBRACE);
			setState(214);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(213);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitIfStatSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatSuffixContext ifStatSuffix() throws RecognitionException {
		IfStatSuffixContext _localctx = new IfStatSuffixContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(ELSE);
			setState(217);
			match(LBRACE);
			setState(218);
			statList();
			setState(219);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stat);
		try {
			setState(230);
			switch (_input.LA(1)) {
			case NEW:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				exprStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				ifStat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				whileStat();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				doWhileStat();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
				forStat();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 6);
				{
				setState(226);
				breakStat();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 7);
				{
				setState(227);
				continueStat();
				}
				break;
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 8);
				{
				setState(228);
				varDeclStat();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(229);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(RETURN);
			setState(234);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(233);
				expression(0);
				}
			}

			setState(236);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitVarDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			varDecl();
			setState(239);
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarInitContext varInit() {
			return getRuleContext(VarInitContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(242);
			match(Identifier);
			setState(245);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(243);
				match(T__2);
				setState(244);
				type();
				}
			}

			setState(248);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(247);
				varInit();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitVarInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarInitContext varInit() throws RecognitionException {
		VarInitContext _localctx = new VarInitContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_varInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ASSIGN);
			setState(251);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(BREAK);
			setState(254);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(CONTINUE);
			setState(257);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(WHILE);
			setState(260);
			match(LPAREN);
			setState(261);
			expression(0);
			setState(262);
			match(RPAREN);
			setState(263);
			match(LBRACE);
			setState(264);
			statList();
			setState(265);
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
		public TerminalNode DO() { return getToken(KalangParser.DO, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(KalangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitDoWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(DO);
			setState(268);
			match(LBRACE);
			setState(269);
			statList();
			setState(270);
			match(RBRACE);
			setState(271);
			match(WHILE);
			setState(272);
			match(LPAREN);
			setState(273);
			expression(0);
			setState(274);
			match(RPAREN);
			setState(275);
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
		public TerminalNode FOR() { return getToken(KalangParser.FOR, 0); }
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(FOR);
			setState(278);
			match(LPAREN);
			setState(280);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(279);
				forInit();
				}
			}

			setState(282);
			match(SEMI);
			setState(284);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(283);
				expression(0);
				}
			}

			setState(286);
			match(SEMI);
			setState(288);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(287);
				forUpdate();
				}
			}

			setState(290);
			match(RPAREN);
			setState(291);
			match(LBRACE);
			setState(292);
			statList();
			setState(293);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_forInit);
		try {
			setState(297);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				varDecl();
				}
				break;
			case NEW:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				expressions();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			expressions();
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			expression(0);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(302);
				match(COMMA);
				setState(303);
				expression(0);
				}
				}
				setState(308);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			expression(0);
			setState(310);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprPrimay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprPrimay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprPrimay(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprGetFieldContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ExprGetFieldContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprGetField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprGetField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprGetField(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprMemberInvocation(this);
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
		public ExprMidOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprMidOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprMidOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprMidOp(this);
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
		public TerminalNode ASSIGN() { return getToken(KalangParser.ASSIGN, 0); }
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprAssign(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprSelfOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprInvocationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprInvocation(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprSelfOpPre(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprGetArrayElementContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprGetArrayElement(this);
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
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(313);
				match(LPAREN);
				setState(314);
				type();
				setState(315);
				match(RPAREN);
				setState(316);
				expression(14);
				}
				break;
			case 2:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (INC - 86)) | (1L << (DEC - 86)) | (1L << (ADD - 86)) | (1L << (SUB - 86)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(319);
				expression(12);
				}
				break;
			case 3:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(320);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(321);
				expression(11);
				}
				break;
			case 4:
				{
				_localctx = new ExprPrimayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(322);
				primary();
				}
				break;
			case 5:
				{
				_localctx = new ExprMemberInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(323);
				match(Identifier);
				setState(324);
				arguments();
				}
				break;
			case 6:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				match(NEW);
				setState(326);
				match(Identifier);
				setState(327);
				arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(382);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(331);
						_la = _input.LA(1);
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (MUL - 90)) | (1L << (DIV - 90)) | (1L << (MOD - 90)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(332);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(334);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(335);
						expression(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(344);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(337);
							match(LT);
							setState(338);
							match(LT);
							}
							break;
						case 2:
							{
							setState(339);
							match(GT);
							setState(340);
							match(GT);
							setState(341);
							match(GT);
							}
							break;
						case 3:
							{
							setState(342);
							match(GT);
							setState(343);
							match(GT);
							}
							break;
						}
						setState(346);
						expression(9);
						}
						break;
					case 4:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(348);
						_la = _input.LA(1);
						if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (GT - 74)) | (1L << (LT - 74)) | (1L << (LE - 74)) | (1L << (GE - 74)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(349);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(350);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(351);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(352);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(354);
						match(BITAND);
						setState(355);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(356);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(357);
						match(CARET);
						setState(358);
						expression(5);
						}
						break;
					case 8:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(359);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(360);
						match(BITOR);
						setState(361);
						expression(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(362);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(363);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(364);
						expression(3);
						}
						break;
					case 10:
						{
						_localctx = new ExprAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(365);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(366);
						match(ASSIGN);
						}
						setState(367);
						expression(1);
						}
						break;
					case 11:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(368);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(369);
						match(DOT);
						setState(370);
						match(Identifier);
						}
						break;
					case 12:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(371);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(372);
						match(DOT);
						setState(373);
						match(Identifier);
						setState(374);
						arguments();
						}
						break;
					case 13:
						{
						_localctx = new ExprGetArrayElementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(375);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(376);
						match(LBRACK);
						setState(377);
						expression(0);
						setState(378);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExprSelfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(380);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(381);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public PrimayParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPrimayParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPrimayParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitPrimayParen(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitPrimaryIdentifier(this);
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
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPrimaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPrimaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitPrimaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_primary);
		try {
			setState(393);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimayParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(LPAREN);
				setState(388);
				expression(0);
				setState(389);
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
				setState(391);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(392);
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
		public TerminalNode IntegerLiteral() { return getToken(KalangParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(KalangParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(KalangParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KalangParser.BooleanLiteral, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(LPAREN);
			setState(406);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(398);
				expression(0);
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(399);
					match(COMMA);
					setState(400);
					expression(0);
					}
					}
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(408);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		case 10:
			return precpred(_ctx, 19);
		case 11:
			return precpred(_ctx, 18);
		case 12:
			return precpred(_ctx, 16);
		case 13:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3r\u019d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\5\2N\n\2\3\2\3\2\5\2R\n\2\3"+
		"\2\3\2\3\2\3\2\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\4\3\4\5\4`\n\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\5\5h\n\5\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6\3\7\3\7\3"+
		"\7\3\b\7\bv\n\b\f\b\16\by\13\b\3\t\5\t|\n\t\3\t\3\t\3\t\5\t\u0081\n\t"+
		"\3\t\3\t\5\t\u0085\n\t\3\t\5\t\u0088\n\t\3\t\5\t\u008b\n\t\3\t\5\t\u008e"+
		"\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\7\f\u00a0\n\f\f\f\16\f\u00a3\13\f\3\r\5\r\u00a6\n\r\3\r\3\r\3\r\5"+
		"\r\u00ab\n\r\3\r\3\r\5\r\u00af\n\r\3\r\3\r\3\r\5\r\u00b4\n\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\5\16\u00bc\n\16\3\17\3\17\3\17\7\17\u00c1\n\17\f\17\16"+
		"\17\u00c4\13\17\3\20\3\20\3\20\5\20\u00c9\n\20\3\21\7\21\u00cc\n\21\f"+
		"\21\16\21\u00cf\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d9"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00e9\n\24\3\25\3\25\5\25\u00ed\n\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\5\27\u00f8\n\27\3\27\5\27\u00fb\n\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\5\35\u011b\n\35\3\35\3\35\5\35\u011f\n\35\3\35\3\35\5\35\u0123\n\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\5\36\u012c\n\36\3\37\3\37\3 \3 \3 \7"+
		" \u0133\n \f \16 \u0136\13 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014b\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u015b\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0181\n\"\f\"\16"+
		"\"\u0184\13\"\3#\3#\3#\3#\3#\3#\5#\u018c\n#\3$\3$\3%\3%\3%\3%\7%\u0194"+
		"\n%\f%\16%\u0197\13%\5%\u0199\n%\3%\3%\3%\2\3B&\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\r\3\2\3\4\7\2\27\27\35"+
		"\35$$&&mm\3\2X[\3\2NO\4\2\\]aa\3\2Z[\4\2LMST\4\2RRUU\3\2VW\3\2XY\3\2<"+
		"A\u01b8\2J\3\2\2\2\4Z\3\2\2\2\6]\3\2\2\2\bd\3\2\2\2\ni\3\2\2\2\fq\3\2"+
		"\2\2\16w\3\2\2\2\20{\3\2\2\2\22\u0091\3\2\2\2\24\u0099\3\2\2\2\26\u00a1"+
		"\3\2\2\2\30\u00a5\3\2\2\2\32\u00b9\3\2\2\2\34\u00bd\3\2\2\2\36\u00c5\3"+
		"\2\2\2 \u00cd\3\2\2\2\"\u00d0\3\2\2\2$\u00da\3\2\2\2&\u00e8\3\2\2\2(\u00ea"+
		"\3\2\2\2*\u00f0\3\2\2\2,\u00f3\3\2\2\2.\u00fc\3\2\2\2\60\u00ff\3\2\2\2"+
		"\62\u0102\3\2\2\2\64\u0105\3\2\2\2\66\u010d\3\2\2\28\u0117\3\2\2\2:\u012b"+
		"\3\2\2\2<\u012d\3\2\2\2>\u012f\3\2\2\2@\u0137\3\2\2\2B\u014a\3\2\2\2D"+
		"\u018b\3\2\2\2F\u018d\3\2\2\2H\u018f\3\2\2\2JK\5\4\3\2KM\7\22\2\2LN\7"+
		"\t\2\2ML\3\2\2\2MN\3\2\2\2NQ\3\2\2\2OP\7\32\2\2PR\7m\2\2QO\3\2\2\2QR\3"+
		"\2\2\2RS\3\2\2\2ST\7D\2\2TU\5\f\7\2UV\7E\2\2V\3\3\2\2\2WY\5\6\4\2XW\3"+
		"\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\5\3\2\2\2\\Z\3\2\2\2]_\7\"\2\2"+
		"^`\7/\2\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\5\b\5\2bc\7H\2\2c\7\3\2\2\2"+
		"dg\5\n\6\2ef\7J\2\2fh\7\\\2\2ge\3\2\2\2gh\3\2\2\2h\t\3\2\2\2in\7m\2\2"+
		"jk\7J\2\2km\7m\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\13\3\2\2\2"+
		"pn\3\2\2\2qr\5\16\b\2rs\5\26\f\2s\r\3\2\2\2tv\5\20\t\2ut\3\2\2\2vy\3\2"+
		"\2\2wu\3\2\2\2wx\3\2\2\2x\17\3\2\2\2yw\3\2\2\2z|\7/\2\2{z\3\2\2\2{|\3"+
		"\2\2\2|}\3\2\2\2}~\t\2\2\2~\u0080\7m\2\2\177\u0081\7\t\2\2\u0080\177\3"+
		"\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\7\5\2\2\u0083"+
		"\u0085\5\32\16\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3"+
		"\2\2\2\u0086\u0088\5.\30\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u008b\5\22\n\2\u008a\u0089\3\2\2\2\u008a\u008b\3"+
		"\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5\24\13\2\u008d\u008c\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7H\2\2\u0090\21\3\2\2\2"+
		"\u0091\u0092\7\6\2\2\u0092\u0093\7B\2\2\u0093\u0094\5\34\17\2\u0094\u0095"+
		"\7C\2\2\u0095\u0096\7D\2\2\u0096\u0097\5 \21\2\u0097\u0098\7E\2\2\u0098"+
		"\23\3\2\2\2\u0099\u009a\7\7\2\2\u009a\u009b\7D\2\2\u009b\u009c\5 \21\2"+
		"\u009c\u009d\7E\2\2\u009d\25\3\2\2\2\u009e\u00a0\5\30\r\2\u009f\u009e"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\27\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\7/\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\4\2\2\u00a8\u00aa"+
		"\7m\2\2\u00a9\u00ab\7\t\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ae\7B\2\2\u00ad\u00af\5\34\17\2\u00ae\u00ad\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\7C\2\2\u00b1"+
		"\u00b2\7\5\2\2\u00b2\u00b4\5\32\16\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7D\2\2\u00b6\u00b7\5 \21\2\u00b7"+
		"\u00b8\7E\2\2\u00b8\31\3\2\2\2\u00b9\u00bb\t\3\2\2\u00ba\u00bc\7\b\2\2"+
		"\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\33\3\2\2\2\u00bd\u00c2"+
		"\5\36\20\2\u00be\u00bf\7I\2\2\u00bf\u00c1\5\36\20\2\u00c0\u00be\3\2\2"+
		"\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\35"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\7m\2\2\u00c6\u00c7\7\5\2\2\u00c7"+
		"\u00c9\5\32\16\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\37\3\2"+
		"\2\2\u00ca\u00cc\5&\24\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce!\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00d0\u00d1\7\37\2\2\u00d1\u00d2\7B\2\2\u00d2\u00d3\5B\"\2\u00d3\u00d4"+
		"\7C\2\2\u00d4\u00d5\7D\2\2\u00d5\u00d6\5 \21\2\u00d6\u00d8\7E\2\2\u00d7"+
		"\u00d9\5$\23\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9#\3\2\2\2"+
		"\u00da\u00db\7\30\2\2\u00db\u00dc\7D\2\2\u00dc\u00dd\5 \21\2\u00dd\u00de"+
		"\7E\2\2\u00de%\3\2\2\2\u00df\u00e9\5@!\2\u00e0\u00e9\5\"\22\2\u00e1\u00e9"+
		"\5\64\33\2\u00e2\u00e9\5\66\34\2\u00e3\u00e9\58\35\2\u00e4\u00e9\5\60"+
		"\31\2\u00e5\u00e9\5\62\32\2\u00e6\u00e9\5*\26\2\u00e7\u00e9\5(\25\2\u00e8"+
		"\u00df\3\2\2\2\u00e8\u00e0\3\2\2\2\u00e8\u00e1\3\2\2\2\u00e8\u00e2\3\2"+
		"\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e8\u00e5\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\'\3\2\2\2\u00ea\u00ec\7-\2\2"+
		"\u00eb\u00ed\5B\"\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00ef\7H\2\2\u00ef)\3\2\2\2\u00f0\u00f1\5,\27\2\u00f1\u00f2"+
		"\7H\2\2\u00f2+\3\2\2\2\u00f3\u00f4\t\2\2\2\u00f4\u00f7\7m\2\2\u00f5\u00f6"+
		"\7\5\2\2\u00f6\u00f8\5\32\16\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2"+
		"\u00f8\u00fa\3\2\2\2\u00f9\u00fb\5.\30\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb-\3\2\2\2\u00fc\u00fd\7K\2\2\u00fd\u00fe\5B\"\2\u00fe/\3"+
		"\2\2\2\u00ff\u0100\7\r\2\2\u0100\u0101\7H\2\2\u0101\61\3\2\2\2\u0102\u0103"+
		"\7\24\2\2\u0103\u0104\7H\2\2\u0104\63\3\2\2\2\u0105\u0106\7;\2\2\u0106"+
		"\u0107\7B\2\2\u0107\u0108\5B\"\2\u0108\u0109\7C\2\2\u0109\u010a\7D\2\2"+
		"\u010a\u010b\5 \21\2\u010b\u010c\7E\2\2\u010c\65\3\2\2\2\u010d\u010e\7"+
		"\26\2\2\u010e\u010f\7D\2\2\u010f\u0110\5 \21\2\u0110\u0111\7E\2\2\u0111"+
		"\u0112\7;\2\2\u0112\u0113\7B\2\2\u0113\u0114\5B\"\2\u0114\u0115\7C\2\2"+
		"\u0115\u0116\7H\2\2\u0116\67\3\2\2\2\u0117\u0118\7\36\2\2\u0118\u011a"+
		"\7B\2\2\u0119\u011b\5:\36\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011e\7H\2\2\u011d\u011f\5B\"\2\u011e\u011d\3\2\2"+
		"\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\7H\2\2\u0121\u0123"+
		"\5<\37\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0125\7C\2\2\u0125\u0126\7D\2\2\u0126\u0127\5 \21\2\u0127\u0128\7E\2"+
		"\2\u01289\3\2\2\2\u0129\u012c\5,\27\2\u012a\u012c\5> \2\u012b\u0129\3"+
		"\2\2\2\u012b\u012a\3\2\2\2\u012c;\3\2\2\2\u012d\u012e\5> \2\u012e=\3\2"+
		"\2\2\u012f\u0134\5B\"\2\u0130\u0131\7I\2\2\u0131\u0133\5B\"\2\u0132\u0130"+
		"\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"?\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\5B\"\2\u0138\u0139\7H\2\2\u0139"+
		"A\3\2\2\2\u013a\u013b\b\"\1\2\u013b\u013c\7B\2\2\u013c\u013d\5\32\16\2"+
		"\u013d\u013e\7C\2\2\u013e\u013f\5B\"\20\u013f\u014b\3\2\2\2\u0140\u0141"+
		"\t\4\2\2\u0141\u014b\5B\"\16\u0142\u0143\t\5\2\2\u0143\u014b\5B\"\r\u0144"+
		"\u014b\5D#\2\u0145\u0146\7m\2\2\u0146\u014b\5H%\2\u0147\u0148\7(\2\2\u0148"+
		"\u0149\7m\2\2\u0149\u014b\5H%\2\u014a\u013a\3\2\2\2\u014a\u0140\3\2\2"+
		"\2\u014a\u0142\3\2\2\2\u014a\u0144\3\2\2\2\u014a\u0145\3\2\2\2\u014a\u0147"+
		"\3\2\2\2\u014b\u0182\3\2\2\2\u014c\u014d\f\f\2\2\u014d\u014e\t\6\2\2\u014e"+
		"\u0181\5B\"\r\u014f\u0150\f\13\2\2\u0150\u0151\t\7\2\2\u0151\u0181\5B"+
		"\"\f\u0152\u015a\f\n\2\2\u0153\u0154\7M\2\2\u0154\u015b\7M\2\2\u0155\u0156"+
		"\7L\2\2\u0156\u0157\7L\2\2\u0157\u015b\7L\2\2\u0158\u0159\7L\2\2\u0159"+
		"\u015b\7L\2\2\u015a\u0153\3\2\2\2\u015a\u0155\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u0181\5B\"\13\u015d\u015e\f\t\2\2\u015e"+
		"\u015f\t\b\2\2\u015f\u0181\5B\"\n\u0160\u0161\f\b\2\2\u0161\u0162\t\t"+
		"\2\2\u0162\u0181\5B\"\t\u0163\u0164\f\7\2\2\u0164\u0165\7^\2\2\u0165\u0181"+
		"\5B\"\b\u0166\u0167\f\6\2\2\u0167\u0168\7`\2\2\u0168\u0181\5B\"\7\u0169"+
		"\u016a\f\5\2\2\u016a\u016b\7_\2\2\u016b\u0181\5B\"\6\u016c\u016d\f\4\2"+
		"\2\u016d\u016e\t\n\2\2\u016e\u0181\5B\"\5\u016f\u0170\f\3\2\2\u0170\u0171"+
		"\7K\2\2\u0171\u0181\5B\"\3\u0172\u0173\f\25\2\2\u0173\u0174\7J\2\2\u0174"+
		"\u0181\7m\2\2\u0175\u0176\f\24\2\2\u0176\u0177\7J\2\2\u0177\u0178\7m\2"+
		"\2\u0178\u0181\5H%\2\u0179\u017a\f\22\2\2\u017a\u017b\7F\2\2\u017b\u017c"+
		"\5B\"\2\u017c\u017d\7G\2\2\u017d\u0181\3\2\2\2\u017e\u017f\f\17\2\2\u017f"+
		"\u0181\t\13\2\2\u0180\u014c\3\2\2\2\u0180\u014f\3\2\2\2\u0180\u0152\3"+
		"\2\2\2\u0180\u015d\3\2\2\2\u0180\u0160\3\2\2\2\u0180\u0163\3\2\2\2\u0180"+
		"\u0166\3\2\2\2\u0180\u0169\3\2\2\2\u0180\u016c\3\2\2\2\u0180\u016f\3\2"+
		"\2\2\u0180\u0172\3\2\2\2\u0180\u0175\3\2\2\2\u0180\u0179\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183C\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7B\2\2\u0186\u0187"+
		"\5B\"\2\u0187\u0188\7C\2\2\u0188\u018c\3\2\2\2\u0189\u018c\5F$\2\u018a"+
		"\u018c\7m\2\2\u018b\u0185\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2"+
		"\2\2\u018cE\3\2\2\2\u018d\u018e\t\f\2\2\u018eG\3\2\2\2\u018f\u0198\7B"+
		"\2\2\u0190\u0195\5B\"\2\u0191\u0192\7I\2\2\u0192\u0194\5B\"\2\u0193\u0191"+
		"\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u0190\3\2\2\2\u0198\u0199\3\2"+
		"\2\2\u0199\u019a\3\2\2\2\u019a\u019b\7C\2\2\u019bI\3\2\2\2)MQZ_gnw{\u0080"+
		"\u0084\u0087\u008a\u008d\u00a1\u00a5\u00aa\u00ae\u00b3\u00bb\u00c2\u00c8"+
		"\u00cd\u00d8\u00e8\u00ec\u00f7\u00fa\u011a\u011e\u0122\u012b\u0134\u014a"+
		"\u015a\u0180\u0182\u018b\u0195\u0198";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
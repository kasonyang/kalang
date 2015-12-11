// Generated from Kalang.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ABSTRACT=7, ASSERT=8, 
		BOOLEAN=9, BREAK=10, BYTE=11, CASE=12, CATCH=13, CHAR=14, CLASS=15, CONST=16, 
		CONTINUE=17, DEFAULT=18, DO=19, DOUBLE=20, ELSE=21, ENUM=22, EXTENDS=23, 
		FINAL=24, FINALLY=25, FLOAT=26, FOR=27, IF=28, GOTO=29, IMPLEMENTS=30, 
		IMPORT=31, INSTANCEOF=32, INT=33, INTERFACE=34, LONG=35, NATIVE=36, NEW=37, 
		PACKAGE=38, PRIVATE=39, PROTECTED=40, PUBLIC=41, RETURN=42, SHORT=43, 
		STATIC=44, STRICTFP=45, SUPER=46, SWITCH=47, SYNCHRONIZED=48, THIS=49, 
		THROW=50, THROWS=51, TRANSIENT=52, TRY=53, VOID=54, VOLATILE=55, WHILE=56, 
		IntegerLiteral=57, FloatingPointLiteral=58, BooleanLiteral=59, CharacterLiteral=60, 
		StringLiteral=61, NullLiteral=62, LPAREN=63, RPAREN=64, LBRACE=65, RBRACE=66, 
		LBRACK=67, RBRACK=68, SEMI=69, COMMA=70, DOT=71, ASSIGN=72, GT=73, LT=74, 
		BANG=75, TILDE=76, QUESTION=77, COLON=78, EQUAL=79, LE=80, GE=81, NOTEQUAL=82, 
		AND=83, OR=84, INC=85, DEC=86, ADD=87, SUB=88, MUL=89, DIV=90, BITAND=91, 
		BITOR=92, CARET=93, MOD=94, ADD_ASSIGN=95, SUB_ASSIGN=96, MUL_ASSIGN=97, 
		DIV_ASSIGN=98, AND_ASSIGN=99, OR_ASSIGN=100, XOR_ASSIGN=101, MOD_ASSIGN=102, 
		LSHIFT_ASSIGN=103, RSHIFT_ASSIGN=104, URSHIFT_ASSIGN=105, Identifier=106, 
		AT=107, ELLIPSIS=108, WS=109, COMMENT=110, LINE_COMMENT=111;
	public static final int
		RULE_compiliantUnit = 0, RULE_importDecl = 1, RULE_qualifiedName = 2, 
		RULE_classBody = 3, RULE_fieldDecl = 4, RULE_methodDecl = 5, RULE_type = 6, 
		RULE_noArrayType = 7, RULE_varDecls = 8, RULE_statList = 9, RULE_ifStat = 10, 
		RULE_ifStatSuffix = 11, RULE_stat = 12, RULE_tryStat = 13, RULE_returnStat = 14, 
		RULE_postIfStmt = 15, RULE_varDeclStat = 16, RULE_varDecl = 17, RULE_breakStat = 18, 
		RULE_continueStat = 19, RULE_whileStat = 20, RULE_doWhileStat = 21, RULE_forStat = 22, 
		RULE_expressions = 23, RULE_exprStat = 24, RULE_expression = 25, RULE_map = 26, 
		RULE_listOrArray = 27, RULE_literal = 28, RULE_arguments = 29, RULE_varModifier = 30;
	public static final String[] ruleNames = {
		"compiliantUnit", "importDecl", "qualifiedName", "classBody", "fieldDecl", 
		"methodDecl", "type", "noArrayType", "varDecls", "statList", "ifStat", 
		"ifStatSuffix", "stat", "tryStat", "returnStat", "postIfStmt", "varDeclStat", 
		"varDecl", "breakStat", "continueStat", "whileStat", "doWhileStat", "forStat", 
		"expressions", "exprStat", "expression", "map", "listOrArray", "literal", 
		"arguments", "varModifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'as'", "'constructor'", "'[]'", "'var'", "'val'", "'abstract'", 
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
		null, null, null, null, null, null, null, "ABSTRACT", "ASSERT", "BOOLEAN", 
		"BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", 
		"DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", 
		"FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", 
		"INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", 
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
		public Token classType;
		public Token parentClass;
		public Token Identifier;
		public List<Token> interfaces = new ArrayList<Token>();
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(62);
				importDecl();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(68);
				varModifier();
				}
			}

			setState(73);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(71);
				((CompiliantUnitContext)_localctx).classType = match(CLASS);
				}
				break;
			case INTERFACE:
				{
				setState(72);
				((CompiliantUnitContext)_localctx).classType = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(77);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(75);
				match(EXTENDS);
				setState(76);
				((CompiliantUnitContext)_localctx).parentClass = match(Identifier);
				}
			}

			setState(88);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(79);
				match(IMPLEMENTS);
				setState(80);
				((CompiliantUnitContext)_localctx).Identifier = match(Identifier);
				((CompiliantUnitContext)_localctx).interfaces.add(((CompiliantUnitContext)_localctx).Identifier);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(81);
					match(COMMA);
					setState(82);
					((CompiliantUnitContext)_localctx).Identifier = match(Identifier);
					((CompiliantUnitContext)_localctx).interfaces.add(((CompiliantUnitContext)_localctx).Identifier);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(90);
			match(LBRACE);
			setState(91);
			classBody();
			setState(92);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitImportDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(IMPORT);
			setState(96);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(95);
				((ImportDeclContext)_localctx).root = match(T__0);
				}
			}

			setState(98);
			((ImportDeclContext)_localctx).Identifier = match(Identifier);
			((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					match(T__0);
					setState(100);
					((ImportDeclContext)_localctx).Identifier = match(Identifier);
					((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(106);
			match(T__0);
			setState(113);
			switch (_input.LA(1)) {
			case Identifier:
				{
				{
				setState(107);
				((ImportDeclContext)_localctx).name = match(Identifier);
				setState(110);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(108);
					match(T__1);
					setState(109);
					((ImportDeclContext)_localctx).alias = match(Identifier);
					}
				}

				}
				}
				break;
			case MUL:
				{
				{
				setState(112);
				((ImportDeclContext)_localctx).name = match(MUL);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
		enterRule(_localctx, 4, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(Identifier);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(118);
				match(DOT);
				setState(119);
				match(Identifier);
				}
				}
				setState(124);
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
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
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
		enterRule(_localctx, 6, RULE_classBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(125);
					fieldDecl();
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				{
				setState(131);
				methodDecl();
				}
				}
				setState(136);
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

	public static class FieldDeclContext extends ParserRuleContext {
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
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
		enterRule(_localctx, 8, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(137);
				varModifier();
				}
			}

			setState(140);
			varDecls();
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

	public static class MethodDeclContext extends ParserRuleContext {
		public Token name;
		public Token prefix;
		public Token Identifier;
		public List<Token> exceptionTypes = new ArrayList<Token>();
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
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
		enterRule(_localctx, 10, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(143);
				varModifier();
				}
			}

			setState(152);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case VOID:
			case Identifier:
				{
				{
				setState(148);
				switch (_input.LA(1)) {
				case BOOLEAN:
				case BYTE:
				case CHAR:
				case DOUBLE:
				case FLOAT:
				case INT:
				case LONG:
				case Identifier:
					{
					setState(146);
					type();
					}
					break;
				case VOID:
					{
					setState(147);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(150);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case T__2:
				{
				{
				setState(151);
				((MethodDeclContext)_localctx).prefix = match(T__2);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(154);
			match(LPAREN);
			setState(156);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				setState(155);
				varDecls();
				}
			}

			setState(158);
			match(RPAREN);
			setState(168);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(159);
				match(THROWS);
				setState(160);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161);
					match(COMMA);
					setState(162);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(175);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				{
				setState(170);
				match(LBRACE);
				setState(171);
				statList();
				setState(172);
				match(RBRACE);
				}
				}
				break;
			case SEMI:
				{
				setState(174);
				match(SEMI);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			noArrayType();
			setState(179);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(178);
				match(T__3);
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
		public TerminalNode DOUBLE() { return getToken(KalangParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(KalangParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(KalangParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(KalangParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(KalangParser.CHAR, 0); }
		public TerminalNode BOOLEAN() { return getToken(KalangParser.BOOLEAN, 0); }
		public TerminalNode BYTE() { return getToken(KalangParser.BYTE, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitNoArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoArrayTypeContext noArrayType() throws RecognitionException {
		NoArrayTypeContext _localctx = new NoArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_noArrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) ) {
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

	public static class VarDeclsContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public VarDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterVarDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitVarDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitVarDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclsContext varDecls() throws RecognitionException {
		VarDeclsContext _localctx = new VarDeclsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			varDecl();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(184);
				match(COMMA);
				setState(185);
				varDecl();
				}
				}
				setState(190);
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
		enterRule(_localctx, 18, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << THIS) | (1L << TRY) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				{
				setState(191);
				stat();
				}
				}
				setState(196);
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
		enterRule(_localctx, 20, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IF);
			setState(198);
			match(LPAREN);
			setState(199);
			expression(0);
			setState(200);
			match(RPAREN);
			setState(201);
			match(LBRACE);
			setState(202);
			statList();
			setState(203);
			match(RBRACE);
			setState(205);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(204);
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
		enterRule(_localctx, 22, RULE_ifStatSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(ELSE);
			setState(208);
			match(LBRACE);
			setState(209);
			statList();
			setState(210);
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
		public PostIfStmtContext postIfStmt() {
			return getRuleContext(PostIfStmtContext.class,0);
		}
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
		public TryStatContext tryStat() {
			return getRuleContext(TryStatContext.class,0);
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
		enterRule(_localctx, 24, RULE_stat);
		try {
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				postIfStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				exprStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				ifStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				whileStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				doWhileStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(217);
				forStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(218);
				breakStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(219);
				continueStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(220);
				varDeclStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(221);
				returnStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(222);
				tryStat();
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
		public List<StatListContext> statList() {
			return getRuleContexts(StatListContext.class);
		}
		public StatListContext statList(int i) {
			return getRuleContext(StatListContext.class,i);
		}
		public List<NoArrayTypeContext> noArrayType() {
			return getRuleContexts(NoArrayTypeContext.class);
		}
		public NoArrayTypeContext noArrayType(int i) {
			return getRuleContext(NoArrayTypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitTryStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatContext tryStat() throws RecognitionException {
		TryStatContext _localctx = new TryStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(TRY);
			setState(226);
			match(LBRACE);
			setState(227);
			((TryStatContext)_localctx).tryStmtList = statList();
			setState(228);
			match(RBRACE);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(229);
				match(CATCH);
				setState(230);
				match(LPAREN);
				setState(231);
				((TryStatContext)_localctx).noArrayType = noArrayType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).noArrayType);
				setState(232);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(233);
				match(RPAREN);
				setState(234);
				match(LBRACE);
				setState(235);
				((TryStatContext)_localctx).statList = statList();
				((TryStatContext)_localctx).catchStmts.add(((TryStatContext)_localctx).statList);
				setState(236);
				match(RBRACE);
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(243);
				match(FINALLY);
				setState(244);
				match(LBRACE);
				setState(245);
				((TryStatContext)_localctx).finalStmtList = statList();
				setState(246);
				match(RBRACE);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(RETURN);
			setState(252);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(251);
				expression(0);
				}
			}

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

	public static class PostIfStmtContext extends ParserRuleContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitPostIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIfStmtContext postIfStmt() throws RecognitionException {
		PostIfStmtContext _localctx = new PostIfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_postIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			expression(0);
			setState(257);
			match(IF);
			setState(264);
			switch (_input.LA(1)) {
			case EQUAL:
				{
				setState(258);
				((PostIfStmtContext)_localctx).op = match(EQUAL);
				}
				break;
			case LT:
				{
				setState(259);
				((PostIfStmtContext)_localctx).op = match(LT);
				}
				break;
			case GT:
				{
				setState(260);
				((PostIfStmtContext)_localctx).op = match(GT);
				}
				break;
			case NOTEQUAL:
				{
				setState(261);
				((PostIfStmtContext)_localctx).op = match(NOTEQUAL);
				}
				break;
			case GE:
				{
				setState(262);
				((PostIfStmtContext)_localctx).op = match(GE);
				}
				break;
			case LE:
				{
				setState(263);
				((PostIfStmtContext)_localctx).op = match(LE);
				}
				break;
			case T__3:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case THIS:
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
			setState(266);
			expression(0);
			setState(267);
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
		enterRule(_localctx, 32, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			varDecl();
			setState(270);
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
		public Token name;
		public TypeContext varType;
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 34, RULE_varDecl);
		int _la;
		try {
			setState(288);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(273);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(276);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(274);
					match(T__1);
					setState(275);
					type();
					}
				}

				setState(280);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(278);
					match(ASSIGN);
					setState(279);
					expression(0);
					}
				}

				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(282);
				((VarDeclContext)_localctx).varType = type();
				setState(283);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(286);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(284);
					match(ASSIGN);
					setState(285);
					expression(0);
					}
				}

				}
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
		enterRule(_localctx, 36, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(BREAK);
			setState(291);
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
		enterRule(_localctx, 38, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(CONTINUE);
			setState(294);
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
		enterRule(_localctx, 40, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(WHILE);
			setState(297);
			match(LPAREN);
			setState(298);
			expression(0);
			setState(299);
			match(RPAREN);
			setState(300);
			match(LBRACE);
			setState(301);
			statList();
			setState(302);
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
		enterRule(_localctx, 42, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(DO);
			setState(305);
			match(LBRACE);
			setState(306);
			statList();
			setState(307);
			match(RBRACE);
			setState(308);
			match(WHILE);
			setState(309);
			match(LPAREN);
			setState(310);
			expression(0);
			setState(311);
			match(RPAREN);
			setState(312);
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
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
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
		enterRule(_localctx, 44, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(FOR);
			setState(315);
			match(LPAREN);
			setState(317);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				setState(316);
				varDecls();
				}
			}

			setState(319);
			match(SEMI);
			setState(321);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(320);
				expression(0);
				}
			}

			setState(323);
			match(SEMI);
			setState(325);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(324);
				expressions();
				}
			}

			setState(327);
			match(RPAREN);
			setState(328);
			match(LBRACE);
			setState(329);
			statList();
			setState(330);
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
		enterRule(_localctx, 46, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			expression(0);
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(333);
				match(COMMA);
				setState(334);
				expression(0);
				}
				}
				setState(339);
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
		enterRule(_localctx, 48, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			expression(0);
			setState(341);
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
	public static class ExprIdentifierContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ExprIdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprIdentifier(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitMapExpr(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitListOrArrayExpr(this);
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
	public static class ExprLiteralContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParenContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public ExprParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprParen(this);
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
	public static class ExprQuestionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprQuestion(this);
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
	public static class ExprThisContext extends ExpressionContext {
		public ExprThisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprThis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprThis(this);
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
	public static class ExprNewArrayContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprNewArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprNewArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprNewArray(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(344);
				match(LPAREN);
				setState(345);
				type();
				setState(346);
				match(RPAREN);
				setState(347);
				expression(15);
				}
				break;
			case 2:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (INC - 85)) | (1L << (DEC - 85)) | (1L << (ADD - 85)) | (1L << (SUB - 85)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(350);
				expression(13);
				}
				break;
			case 3:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(351);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(352);
				expression(12);
				}
				break;
			case 4:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353);
				match(LPAREN);
				setState(354);
				expression(0);
				setState(355);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new ExprThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(357);
				match(THIS);
				}
				break;
			case 6:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(358);
				literal();
				}
				break;
			case 7:
				{
				_localctx = new ExprIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(359);
				match(Identifier);
				}
				break;
			case 8:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(360);
				map();
				}
				break;
			case 9:
				{
				_localctx = new ListOrArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(361);
				listOrArray();
				}
				break;
			case 10:
				{
				_localctx = new ExprMemberInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362);
				match(Identifier);
				setState(363);
				arguments();
				}
				break;
			case 11:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				match(NEW);
				setState(365);
				match(Identifier);
				setState(366);
				arguments();
				}
				break;
			case 12:
				{
				_localctx = new ExprNewArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367);
				match(NEW);
				setState(368);
				noArrayType();
				setState(369);
				match(LBRACK);
				setState(370);
				expression(0);
				setState(371);
				match(RBRACK);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(435);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(433);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(375);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(376);
						_la = _input.LA(1);
						if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (MUL - 89)) | (1L << (DIV - 89)) | (1L << (MOD - 89)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(377);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(378);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(379);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(380);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(381);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(389);
						switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
						case 1:
							{
							setState(382);
							match(LT);
							setState(383);
							match(LT);
							}
							break;
						case 2:
							{
							setState(384);
							match(GT);
							setState(385);
							match(GT);
							setState(386);
							match(GT);
							}
							break;
						case 3:
							{
							setState(387);
							match(GT);
							setState(388);
							match(GT);
							}
							break;
						}
						setState(391);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(392);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(393);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (GT - 73)) | (1L << (LT - 73)) | (1L << (LE - 73)) | (1L << (GE - 73)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(394);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(395);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(396);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(397);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(398);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(399);
						match(BITAND);
						setState(400);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(401);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(402);
						match(CARET);
						setState(403);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(404);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(405);
						match(BITOR);
						setState(406);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(407);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(408);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(409);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExprQuestionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(411);
						match(QUESTION);
						setState(412);
						expression(0);
						setState(413);
						match(COLON);
						setState(414);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExprAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(416);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(417);
						_la = _input.LA(1);
						if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (ASSIGN - 72)) | (1L << (ADD_ASSIGN - 72)) | (1L << (SUB_ASSIGN - 72)) | (1L << (MUL_ASSIGN - 72)) | (1L << (DIV_ASSIGN - 72)) | (1L << (AND_ASSIGN - 72)) | (1L << (OR_ASSIGN - 72)) | (1L << (XOR_ASSIGN - 72)) | (1L << (MOD_ASSIGN - 72)) | (1L << (LSHIFT_ASSIGN - 72)) | (1L << (RSHIFT_ASSIGN - 72)) | (1L << (URSHIFT_ASSIGN - 72)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(418);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(420);
						match(DOT);
						setState(421);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(423);
						match(DOT);
						setState(424);
						match(Identifier);
						setState(425);
						arguments();
						}
						break;
					case 14:
						{
						_localctx = new ExprGetArrayElementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(426);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(427);
						match(LBRACK);
						setState(428);
						expression(0);
						setState(429);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new ExprSelfOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(432);
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
				setState(437);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class MapContext extends ParserRuleContext {
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
				{
				setState(438);
				noArrayType();
				}
			}

			setState(441);
			match(LBRACE);
			setState(454);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(442);
				match(Identifier);
				setState(443);
				match(COLON);
				setState(444);
				expression(0);
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(445);
					match(COMMA);
					setState(446);
					match(Identifier);
					setState(447);
					match(COLON);
					setState(448);
					expression(0);
					}
					}
					setState(453);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(456);
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

	public static class ListOrArrayContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NoArrayTypeContext noArrayType() {
			return getRuleContext(NoArrayTypeContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitListOrArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListOrArrayContext listOrArray() throws RecognitionException {
		ListOrArrayContext _localctx = new ListOrArrayContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_listOrArray);
		int _la;
		try {
			setState(473);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(458);
				match(T__3);
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case LBRACK:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==Identifier) {
					{
					setState(459);
					noArrayType();
					}
				}

				setState(462);
				match(LBRACK);
				{
				setState(463);
				expression(0);
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(464);
					match(COMMA);
					setState(465);
					expression(0);
					}
					}
					setState(470);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(471);
				match(RBRACK);
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
		enterRule(_localctx, 56, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
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
		enterRule(_localctx, 58, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(LPAREN);
			setState(486);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(478);
				expression(0);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(479);
					match(COMMA);
					setState(480);
					expression(0);
					}
					}
					setState(485);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(488);
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

	public static class VarModifierContext extends ParserRuleContext {
		public VarModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterVarModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitVarModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitVarModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarModifierContext varModifier() throws RecognitionException {
		VarModifierContext _localctx = new VarModifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(490);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(493); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0) );
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
		case 25:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 21);
		case 12:
			return precpred(_ctx, 20);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3q\u01f2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\2\5\2H\n\2\3\2\3\2\5\2L\n\2\3\2\3\2\5\2P\n"+
		"\2\3\2\3\2\3\2\3\2\7\2V\n\2\f\2\16\2Y\13\2\5\2[\n\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\5\3c\n\3\3\3\3\3\3\3\7\3h\n\3\f\3\16\3k\13\3\3\3\3\3\3\3\3\3\5"+
		"\3q\n\3\3\3\5\3t\n\3\3\3\3\3\3\4\3\4\3\4\7\4{\n\4\f\4\16\4~\13\4\3\5\7"+
		"\5\u0081\n\5\f\5\16\5\u0084\13\5\3\5\7\5\u0087\n\5\f\5\16\5\u008a\13\5"+
		"\3\6\5\6\u008d\n\6\3\6\3\6\3\6\3\7\5\7\u0093\n\7\3\7\3\7\5\7\u0097\n\7"+
		"\3\7\3\7\5\7\u009b\n\7\3\7\3\7\5\7\u009f\n\7\3\7\3\7\3\7\3\7\3\7\7\7\u00a6"+
		"\n\7\f\7\16\7\u00a9\13\7\5\7\u00ab\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b2\n"+
		"\7\3\b\3\b\5\b\u00b6\n\b\3\t\3\t\3\n\3\n\3\n\7\n\u00bd\n\n\f\n\16\n\u00c0"+
		"\13\n\3\13\7\13\u00c3\n\13\f\13\16\13\u00c6\13\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00d0\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00e2\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00f1\n\17\f\17\16\17\u00f4"+
		"\13\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fb\n\17\3\20\3\20\5\20\u00ff\n"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u010b\n\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u0117\n\23\3\23"+
		"\3\23\5\23\u011b\n\23\3\23\3\23\3\23\3\23\5\23\u0121\n\23\5\23\u0123\n"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\5"+
		"\30\u0140\n\30\3\30\3\30\5\30\u0144\n\30\3\30\3\30\5\30\u0148\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u0152\n\31\f\31\16\31\u0155\13"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\5\33\u0178\n\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0188\n\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u01b4"+
		"\n\33\f\33\16\33\u01b7\13\33\3\34\5\34\u01ba\n\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\7\34\u01c4\n\34\f\34\16\34\u01c7\13\34\5\34\u01c9"+
		"\n\34\3\34\3\34\3\35\3\35\5\35\u01cf\n\35\3\35\3\35\3\35\3\35\7\35\u01d5"+
		"\n\35\f\35\16\35\u01d8\13\35\3\35\3\35\5\35\u01dc\n\35\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\7\37\u01e4\n\37\f\37\16\37\u01e7\13\37\5\37\u01e9\n\37"+
		"\3\37\3\37\3 \6 \u01ee\n \r \16 \u01ef\3 \2\3\64!\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\17\n\2\13\13\r\r\20\20\26"+
		"\26\34\34##%%ll\3\2\7\b\3\2WZ\3\2MN\4\2[\\``\3\2YZ\4\2KLRS\4\2QQTT\3\2"+
		"UV\4\2JJak\3\2WX\3\2;@\5\2\32\32)+..\u022b\2C\3\2\2\2\4`\3\2\2\2\6w\3"+
		"\2\2\2\b\u0082\3\2\2\2\n\u008c\3\2\2\2\f\u0092\3\2\2\2\16\u00b3\3\2\2"+
		"\2\20\u00b7\3\2\2\2\22\u00b9\3\2\2\2\24\u00c4\3\2\2\2\26\u00c7\3\2\2\2"+
		"\30\u00d1\3\2\2\2\32\u00e1\3\2\2\2\34\u00e3\3\2\2\2\36\u00fc\3\2\2\2 "+
		"\u0102\3\2\2\2\"\u010f\3\2\2\2$\u0122\3\2\2\2&\u0124\3\2\2\2(\u0127\3"+
		"\2\2\2*\u012a\3\2\2\2,\u0132\3\2\2\2.\u013c\3\2\2\2\60\u014e\3\2\2\2\62"+
		"\u0156\3\2\2\2\64\u0177\3\2\2\2\66\u01b9\3\2\2\28\u01db\3\2\2\2:\u01dd"+
		"\3\2\2\2<\u01df\3\2\2\2>\u01ed\3\2\2\2@B\5\4\3\2A@\3\2\2\2BE\3\2\2\2C"+
		"A\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2FH\5> \2GF\3\2\2\2GH\3\2\2\2HK"+
		"\3\2\2\2IL\7\21\2\2JL\7$\2\2KI\3\2\2\2KJ\3\2\2\2LO\3\2\2\2MN\7\31\2\2"+
		"NP\7l\2\2OM\3\2\2\2OP\3\2\2\2PZ\3\2\2\2QR\7 \2\2RW\7l\2\2ST\7H\2\2TV\7"+
		"l\2\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZQ\3"+
		"\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7C\2\2]^\5\b\5\2^_\7D\2\2_\3\3\2\2\2`b"+
		"\7!\2\2ac\7\3\2\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2di\7l\2\2ef\7\3\2\2fh\7"+
		"l\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2ls\7"+
		"\3\2\2mp\7l\2\2no\7\4\2\2oq\7l\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rt\7["+
		"\2\2sm\3\2\2\2sr\3\2\2\2tu\3\2\2\2uv\7G\2\2v\5\3\2\2\2w|\7l\2\2xy\7I\2"+
		"\2y{\7l\2\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\7\3\2\2\2~|\3\2\2"+
		"\2\177\u0081\5\n\6\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0088\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0087\5\f\7\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\t\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d"+
		"\5> \2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\5\22\n\2\u008f\u0090\7G\2\2\u0090\13\3\2\2\2\u0091\u0093\5> \2"+
		"\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009a\3\2\2\2\u0094\u0097"+
		"\5\16\b\2\u0095\u0097\78\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009b\7l\2\2\u0099\u009b\7\5\2\2\u009a\u0096\3\2"+
		"\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\7A\2\2\u009d"+
		"\u009f\5\22\n\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00aa\7B\2\2\u00a1\u00a2\7\65\2\2\u00a2\u00a7\7l\2\2\u00a3"+
		"\u00a4\7H\2\2\u00a4\u00a6\7l\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00b1\3\2\2\2\u00ac"+
		"\u00ad\7C\2\2\u00ad\u00ae\5\24\13\2\u00ae\u00af\7D\2\2\u00af\u00b2\3\2"+
		"\2\2\u00b0\u00b2\7G\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\r\3\2\2\2\u00b3\u00b5\5\20\t\2\u00b4\u00b6\7\6\2\2\u00b5\u00b4\3\2\2"+
		"\2\u00b5\u00b6\3\2\2\2\u00b6\17\3\2\2\2\u00b7\u00b8\t\2\2\2\u00b8\21\3"+
		"\2\2\2\u00b9\u00be\5$\23\2\u00ba\u00bb\7H\2\2\u00bb\u00bd\5$\23\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\23\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\5\32\16\2\u00c2"+
		"\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\25\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\36\2\2\u00c8\u00c9"+
		"\7A\2\2\u00c9\u00ca\5\64\33\2\u00ca\u00cb\7B\2\2\u00cb\u00cc\7C\2\2\u00cc"+
		"\u00cd\5\24\13\2\u00cd\u00cf\7D\2\2\u00ce\u00d0\5\30\r\2\u00cf\u00ce\3"+
		"\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\27\3\2\2\2\u00d1\u00d2\7\27\2\2\u00d2"+
		"\u00d3\7C\2\2\u00d3\u00d4\5\24\13\2\u00d4\u00d5\7D\2\2\u00d5\31\3\2\2"+
		"\2\u00d6\u00e2\5 \21\2\u00d7\u00e2\5\62\32\2\u00d8\u00e2\5\26\f\2\u00d9"+
		"\u00e2\5*\26\2\u00da\u00e2\5,\27\2\u00db\u00e2\5.\30\2\u00dc\u00e2\5&"+
		"\24\2\u00dd\u00e2\5(\25\2\u00de\u00e2\5\"\22\2\u00df\u00e2\5\36\20\2\u00e0"+
		"\u00e2\5\34\17\2\u00e1\u00d6\3\2\2\2\u00e1\u00d7\3\2\2\2\u00e1\u00d8\3"+
		"\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1"+
		"\u00dc\3\2\2\2\u00e1\u00dd\3\2\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e0\3\2\2\2\u00e2\33\3\2\2\2\u00e3\u00e4\7\67\2\2\u00e4\u00e5"+
		"\7C\2\2\u00e5\u00e6\5\24\13\2\u00e6\u00f2\7D\2\2\u00e7\u00e8\7\17\2\2"+
		"\u00e8\u00e9\7A\2\2\u00e9\u00ea\5\20\t\2\u00ea\u00eb\7l\2\2\u00eb\u00ec"+
		"\7B\2\2\u00ec\u00ed\7C\2\2\u00ed\u00ee\5\24\13\2\u00ee\u00ef\7D\2\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00fa\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f6\7\33\2\2\u00f6\u00f7\7C\2\2\u00f7\u00f8\5\24\13\2\u00f8\u00f9\7"+
		"D\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\35\3\2\2\2\u00fc\u00fe\7,\2\2\u00fd\u00ff\5\64\33\2\u00fe\u00fd\3\2\2"+
		"\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7G\2\2\u0101\37"+
		"\3\2\2\2\u0102\u0103\5\64\33\2\u0103\u010a\7\36\2\2\u0104\u010b\7Q\2\2"+
		"\u0105\u010b\7L\2\2\u0106\u010b\7K\2\2\u0107\u010b\7T\2\2\u0108\u010b"+
		"\7S\2\2\u0109\u010b\7R\2\2\u010a\u0104\3\2\2\2\u010a\u0105\3\2\2\2\u010a"+
		"\u0106\3\2\2\2\u010a\u0107\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\5\64\33\2\u010d"+
		"\u010e\7G\2\2\u010e!\3\2\2\2\u010f\u0110\5$\23\2\u0110\u0111\7G\2\2\u0111"+
		"#\3\2\2\2\u0112\u0113\t\3\2\2\u0113\u0116\7l\2\2\u0114\u0115\7\4\2\2\u0115"+
		"\u0117\5\16\b\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011a\3"+
		"\2\2\2\u0118\u0119\7J\2\2\u0119\u011b\5\64\33\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u0123\3\2\2\2\u011c\u011d\5\16\b\2\u011d\u0120\7"+
		"l\2\2\u011e\u011f\7J\2\2\u011f\u0121\5\64\33\2\u0120\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0112\3\2\2\2\u0122\u011c\3\2"+
		"\2\2\u0123%\3\2\2\2\u0124\u0125\7\f\2\2\u0125\u0126\7G\2\2\u0126\'\3\2"+
		"\2\2\u0127\u0128\7\23\2\2\u0128\u0129\7G\2\2\u0129)\3\2\2\2\u012a\u012b"+
		"\7:\2\2\u012b\u012c\7A\2\2\u012c\u012d\5\64\33\2\u012d\u012e\7B\2\2\u012e"+
		"\u012f\7C\2\2\u012f\u0130\5\24\13\2\u0130\u0131\7D\2\2\u0131+\3\2\2\2"+
		"\u0132\u0133\7\25\2\2\u0133\u0134\7C\2\2\u0134\u0135\5\24\13\2\u0135\u0136"+
		"\7D\2\2\u0136\u0137\7:\2\2\u0137\u0138\7A\2\2\u0138\u0139\5\64\33\2\u0139"+
		"\u013a\7B\2\2\u013a\u013b\7G\2\2\u013b-\3\2\2\2\u013c\u013d\7\35\2\2\u013d"+
		"\u013f\7A\2\2\u013e\u0140\5\22\n\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2"+
		"\2\2\u0140\u0141\3\2\2\2\u0141\u0143\7G\2\2\u0142\u0144\5\64\33\2\u0143"+
		"\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\7G"+
		"\2\2\u0146\u0148\5\60\31\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\7B\2\2\u014a\u014b\7C\2\2\u014b\u014c\5\24"+
		"\13\2\u014c\u014d\7D\2\2\u014d/\3\2\2\2\u014e\u0153\5\64\33\2\u014f\u0150"+
		"\7H\2\2\u0150\u0152\5\64\33\2\u0151\u014f\3\2\2\2\u0152\u0155\3\2\2\2"+
		"\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\61\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0156\u0157\5\64\33\2\u0157\u0158\7G\2\2\u0158\63\3\2\2\2\u0159"+
		"\u015a\b\33\1\2\u015a\u015b\7A\2\2\u015b\u015c\5\16\b\2\u015c\u015d\7"+
		"B\2\2\u015d\u015e\5\64\33\21\u015e\u0178\3\2\2\2\u015f\u0160\t\4\2\2\u0160"+
		"\u0178\5\64\33\17\u0161\u0162\t\5\2\2\u0162\u0178\5\64\33\16\u0163\u0164"+
		"\7A\2\2\u0164\u0165\5\64\33\2\u0165\u0166\7B\2\2\u0166\u0178\3\2\2\2\u0167"+
		"\u0178\7\63\2\2\u0168\u0178\5:\36\2\u0169\u0178\7l\2\2\u016a\u0178\5\66"+
		"\34\2\u016b\u0178\58\35\2\u016c\u016d\7l\2\2\u016d\u0178\5<\37\2\u016e"+
		"\u016f\7\'\2\2\u016f\u0170\7l\2\2\u0170\u0178\5<\37\2\u0171\u0172\7\'"+
		"\2\2\u0172\u0173\5\20\t\2\u0173\u0174\7E\2\2\u0174\u0175\5\64\33\2\u0175"+
		"\u0176\7F\2\2\u0176\u0178\3\2\2\2\u0177\u0159\3\2\2\2\u0177\u015f\3\2"+
		"\2\2\u0177\u0161\3\2\2\2\u0177\u0163\3\2\2\2\u0177\u0167\3\2\2\2\u0177"+
		"\u0168\3\2\2\2\u0177\u0169\3\2\2\2\u0177\u016a\3\2\2\2\u0177\u016b\3\2"+
		"\2\2\u0177\u016c\3\2\2\2\u0177\u016e\3\2\2\2\u0177\u0171\3\2\2\2\u0178"+
		"\u01b5\3\2\2\2\u0179\u017a\f\r\2\2\u017a\u017b\t\6\2\2\u017b\u01b4\5\64"+
		"\33\16\u017c\u017d\f\f\2\2\u017d\u017e\t\7\2\2\u017e\u01b4\5\64\33\r\u017f"+
		"\u0187\f\13\2\2\u0180\u0181\7L\2\2\u0181\u0188\7L\2\2\u0182\u0183\7K\2"+
		"\2\u0183\u0184\7K\2\2\u0184\u0188\7K\2\2\u0185\u0186\7K\2\2\u0186\u0188"+
		"\7K\2\2\u0187\u0180\3\2\2\2\u0187\u0182\3\2\2\2\u0187\u0185\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u01b4\5\64\33\f\u018a\u018b\f\n\2\2\u018b\u018c\t"+
		"\b\2\2\u018c\u01b4\5\64\33\13\u018d\u018e\f\t\2\2\u018e\u018f\t\t\2\2"+
		"\u018f\u01b4\5\64\33\n\u0190\u0191\f\b\2\2\u0191\u0192\7]\2\2\u0192\u01b4"+
		"\5\64\33\t\u0193\u0194\f\7\2\2\u0194\u0195\7_\2\2\u0195\u01b4\5\64\33"+
		"\b\u0196\u0197\f\6\2\2\u0197\u0198\7^\2\2\u0198\u01b4\5\64\33\7\u0199"+
		"\u019a\f\5\2\2\u019a\u019b\t\n\2\2\u019b\u01b4\5\64\33\6\u019c\u019d\f"+
		"\4\2\2\u019d\u019e\7O\2\2\u019e\u019f\5\64\33\2\u019f\u01a0\7P\2\2\u01a0"+
		"\u01a1\5\64\33\5\u01a1\u01b4\3\2\2\2\u01a2\u01a3\f\3\2\2\u01a3\u01a4\t"+
		"\13\2\2\u01a4\u01b4\5\64\33\3\u01a5\u01a6\f\27\2\2\u01a6\u01a7\7I\2\2"+
		"\u01a7\u01b4\7l\2\2\u01a8\u01a9\f\26\2\2\u01a9\u01aa\7I\2\2\u01aa\u01ab"+
		"\7l\2\2\u01ab\u01b4\5<\37\2\u01ac\u01ad\f\24\2\2\u01ad\u01ae\7E\2\2\u01ae"+
		"\u01af\5\64\33\2\u01af\u01b0\7F\2\2\u01b0\u01b4\3\2\2\2\u01b1\u01b2\f"+
		"\20\2\2\u01b2\u01b4\t\f\2\2\u01b3\u0179\3\2\2\2\u01b3\u017c\3\2\2\2\u01b3"+
		"\u017f\3\2\2\2\u01b3\u018a\3\2\2\2\u01b3\u018d\3\2\2\2\u01b3\u0190\3\2"+
		"\2\2\u01b3\u0193\3\2\2\2\u01b3\u0196\3\2\2\2\u01b3\u0199\3\2\2\2\u01b3"+
		"\u019c\3\2\2\2\u01b3\u01a2\3\2\2\2\u01b3\u01a5\3\2\2\2\u01b3\u01a8\3\2"+
		"\2\2\u01b3\u01ac\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5"+
		"\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\65\3\2\2\2\u01b7\u01b5\3\2\2"+
		"\2\u01b8\u01ba\5\20\t\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb\u01c8\7C\2\2\u01bc\u01bd\7l\2\2\u01bd\u01be\7P\2"+
		"\2\u01be\u01c5\5\64\33\2\u01bf\u01c0\7H\2\2\u01c0\u01c1\7l\2\2\u01c1\u01c2"+
		"\7P\2\2\u01c2\u01c4\5\64\33\2\u01c3\u01bf\3\2\2\2\u01c4\u01c7\3\2\2\2"+
		"\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5"+
		"\3\2\2\2\u01c8\u01bc\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cb\7D\2\2\u01cb\67\3\2\2\2\u01cc\u01dc\7\6\2\2\u01cd\u01cf\5\20\t"+
		"\2\u01ce\u01cd\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1"+
		"\7E\2\2\u01d1\u01d6\5\64\33\2\u01d2\u01d3\7H\2\2\u01d3\u01d5\5\64\33\2"+
		"\u01d4\u01d2\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\7F\2\2\u01da"+
		"\u01dc\3\2\2\2\u01db\u01cc\3\2\2\2\u01db\u01ce\3\2\2\2\u01dc9\3\2\2\2"+
		"\u01dd\u01de\t\r\2\2\u01de;\3\2\2\2\u01df\u01e8\7A\2\2\u01e0\u01e5\5\64"+
		"\33\2\u01e1\u01e2\7H\2\2\u01e2\u01e4\5\64\33\2\u01e3\u01e1\3\2\2\2\u01e4"+
		"\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e9\3\2"+
		"\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e0\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\7B\2\2\u01eb=\3\2\2\2\u01ec\u01ee\t\16\2\2"+
		"\u01ed\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0"+
		"\3\2\2\2\u01f0?\3\2\2\2\65CGKOWZbips|\u0082\u0088\u008c\u0092\u0096\u009a"+
		"\u009e\u00a7\u00aa\u00b1\u00b5\u00be\u00c4\u00cf\u00e1\u00f2\u00fa\u00fe"+
		"\u010a\u0116\u011a\u0120\u0122\u013f\u0143\u0147\u0153\u0177\u0187\u01b3"+
		"\u01b5\u01b9\u01c5\u01c8\u01ce\u01d6\u01db\u01e5\u01e8\u01ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
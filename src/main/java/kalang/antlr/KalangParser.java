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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OVERRIDE=9, 
		ABSTRACT=10, ASSERT=11, BOOLEAN=12, BREAK=13, BYTE=14, CASE=15, CATCH=16, 
		CHAR=17, CLASS=18, CONST=19, CONTINUE=20, DEFAULT=21, DO=22, DOUBLE=23, 
		ELSE=24, ENUM=25, EXTENDS=26, FINAL=27, FINALLY=28, FLOAT=29, FOR=30, 
		IF=31, GOTO=32, IMPLEMENTS=33, IMPORT=34, INSTANCEOF=35, INT=36, INTERFACE=37, 
		LONG=38, NATIVE=39, NEW=40, PACKAGE=41, PRIVATE=42, PROTECTED=43, PUBLIC=44, 
		RETURN=45, SHORT=46, STATIC=47, STRICTFP=48, SUPER=49, SWITCH=50, SYNCHRONIZED=51, 
		THIS=52, THROW=53, THROWS=54, TRANSIENT=55, TRY=56, VOID=57, VOLATILE=58, 
		WHILE=59, IntegerLiteral=60, FloatingPointLiteral=61, BooleanLiteral=62, 
		CharacterLiteral=63, StringLiteral=64, NullLiteral=65, LPAREN=66, RPAREN=67, 
		LBRACE=68, RBRACE=69, LBRACK=70, RBRACK=71, SEMI=72, COMMA=73, DOT=74, 
		LEFT_SHIFT=75, RIGHT_SHIFT=76, UNSIGNED_RIGHT_SHIFT=77, ASSIGN=78, GT=79, 
		LT=80, BANG=81, TILDE=82, QUESTION=83, COLON=84, EQUAL=85, LE=86, GE=87, 
		NOTEQUAL=88, AND=89, OR=90, INC=91, DEC=92, ADD=93, SUB=94, MUL=95, DIV=96, 
		BITAND=97, BITOR=98, CARET=99, MOD=100, ADD_ASSIGN=101, SUB_ASSIGN=102, 
		MUL_ASSIGN=103, DIV_ASSIGN=104, AND_ASSIGN=105, OR_ASSIGN=106, XOR_ASSIGN=107, 
		MOD_ASSIGN=108, LSHIFT_ASSIGN=109, RSHIFT_ASSIGN=110, URSHIFT_ASSIGN=111, 
		Identifier=112, AT=113, ELLIPSIS=114, WS=115, COMMENT=116, LINE_COMMENT=117;
	public static final int
		RULE_compilationUnit = 0, RULE_scriptDef = 1, RULE_classDef = 2, RULE_importDecl = 3, 
		RULE_qualifiedName = 4, RULE_classBody = 5, RULE_fieldDecl = 6, RULE_methodDecl = 7, 
		RULE_annotation = 8, RULE_type = 9, RULE_classType = 10, RULE_parameterizedElementType = 11, 
		RULE_wildcardType = 12, RULE_primitiveType = 13, RULE_localVarDecl = 14, 
		RULE_ifStat = 15, RULE_stat = 16, RULE_errorousStat = 17, RULE_throwStat = 18, 
		RULE_blockStmt = 19, RULE_tryStat = 20, RULE_returnStat = 21, RULE_postIfStmt = 22, 
		RULE_varDeclStat = 23, RULE_varDecl = 24, RULE_breakStat = 25, RULE_continueStat = 26, 
		RULE_whileStat = 27, RULE_doWhileStat = 28, RULE_forStat = 29, RULE_forEachStat = 30, 
		RULE_expressions = 31, RULE_exprStat = 32, RULE_expression = 33, RULE_literal = 34, 
		RULE_varModifier = 35;
	public static final String[] ruleNames = {
		"compilationUnit", "scriptDef", "classDef", "importDecl", "qualifiedName", 
		"classBody", "fieldDecl", "methodDecl", "annotation", "type", "classType", 
		"parameterizedElementType", "wildcardType", "primitiveType", "localVarDecl", 
		"ifStat", "stat", "errorousStat", "throwStat", "blockStmt", "tryStat", 
		"returnStat", "postIfStmt", "varDeclStat", "varDecl", "breakStat", "continueStat", 
		"whileStat", "doWhileStat", "forStat", "forEachStat", "expressions", "exprStat", 
		"expression", "literal", "varModifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'as'", "'constructor'", "'var'", "'val'", "'foreach'", 
		"'->'", "'*.'", "'override'", "'abstract'", "'assert'", "'boolean'", "'break'", 
		"'byte'", "'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", 
		"'default'", "'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", 
		"'finally'", "'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", 
		"'instanceof'", "'int'", "'interface'", "'long'", "'native'", "'new'", 
		"'package'", "'private'", "'protected'", "'public'", "'return'", "'short'", 
		"'static'", "'strictfp'", "'super'", "'switch'", "'synchronized'", "'this'", 
		"'throw'", "'throws'", "'transient'", "'try'", "'void'", "'volatile'", 
		"'while'", null, null, null, null, null, "'null'", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "';'", "','", "'.'", "'<<'", "'>>'", "'>>>'", "'='", 
		"'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", 
		"'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", 
		"'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", 
		"'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "OVERRIDE", "ABSTRACT", 
		"ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", 
		"CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", 
		"FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", 
		"INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", 
		"PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", 
		"SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", 
		"TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
		"DOT", "LEFT_SHIFT", "RIGHT_SHIFT", "UNSIGNED_RIGHT_SHIFT", "ASSIGN", 
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
	public static class CompilationUnitContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public ScriptDefContext scriptDef() {
			return getRuleContext(ScriptDefContext.class,0);
		}
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(72);
				importDecl();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(78);
				classDef();
				}
				break;
			case 2:
				{
				setState(79);
				scriptDef();
				}
				break;
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

	public static class ScriptDefContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ScriptDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterScriptDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitScriptDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitScriptDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptDefContext scriptDef() throws RecognitionException {
		ScriptDefContext _localctx = new ScriptDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_scriptDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << STATIC) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(84);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(82);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(83);
					stat();
					}
					break;
				}
				}
				setState(88);
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

	public static class ClassDefContext extends ParserRuleContext {
		public Token classKind;
		public Token Identifier;
		public List<Token> genericTypes = new ArrayList<Token>();
		public ClassTypeContext parentClass;
		public ClassTypeContext classType;
		public List<ClassTypeContext> interfaces = new ArrayList<ClassTypeContext>();
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(89);
				annotation();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(95);
				varModifier();
				}
			}

			setState(112);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(98);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(109);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(99);
					match(LT);
					setState(100);
					((ClassDefContext)_localctx).Identifier = match(Identifier);
					((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(101);
						match(COMMA);
						setState(102);
						((ClassDefContext)_localctx).Identifier = match(Identifier);
						((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
						}
						}
						setState(107);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(108);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(111);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(116);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(114);
				match(EXTENDS);
				setState(115);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(127);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(118);
				match(IMPLEMENTS);
				setState(119);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(120);
					match(COMMA);
					setState(121);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(129);
			match(LBRACE);
			setState(130);
			classBody();
			setState(131);
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
		public Token delim;
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
		enterRule(_localctx, 6, RULE_importDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(133);
				match(IMPORT);
				setState(135);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(134);
					((ImportDeclContext)_localctx).root = match(T__0);
					}
				}

				setState(137);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(138);
						match(T__0);
						setState(139);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(145);
				((ImportDeclContext)_localctx).delim = match(T__0);
				setState(152);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(146);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(149);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(147);
						match(T__1);
						setState(148);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(151);
					((ImportDeclContext)_localctx).name = match(MUL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				setState(154);
				match(IMPORT);
				setState(155);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(156);
						match(DOT);
						setState(157);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(162);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(163);
				((ImportDeclContext)_localctx).delim = match(DOT);
				setState(170);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(164);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(167);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(165);
						match(T__1);
						setState(166);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(169);
					((ImportDeclContext)_localctx).name = match(MUL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			setState(174);
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
		enterRule(_localctx, 8, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(Identifier);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(177);
				match(DOT);
				setState(178);
				match(Identifier);
				}
				}
				setState(183);
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
		enterRule(_localctx, 10, RULE_classBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(184);
					fieldDecl();
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier || _la==AT) {
				{
				{
				setState(190);
				methodDecl();
				}
				}
				setState(195);
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
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
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
		enterRule(_localctx, 12, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(196);
				varModifier();
				}
			}

			setState(199);
			varDecl();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(200);
				match(COMMA);
				setState(201);
				varDecl();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
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
		public TypeContext returnType;
		public Token name;
		public Token prefix;
		public TypeContext type;
		public List<TypeContext> paramTypes = new ArrayList<TypeContext>();
		public Token Identifier;
		public List<Token> paramIds = new ArrayList<Token>();
		public List<Token> exceptionTypes = new ArrayList<Token>();
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode OVERRIDE() { return getToken(KalangParser.OVERRIDE, 0); }
		public TerminalNode DEFAULT() { return getToken(KalangParser.DEFAULT, 0); }
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
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
		enterRule(_localctx, 14, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(209);
				annotation();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(215);
				match(OVERRIDE);
				}
			}

			setState(219);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(218);
				match(DEFAULT);
				}
			}

			setState(222);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(221);
				varModifier();
				}
			}

			setState(228);
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
				setState(224);
				((MethodDeclContext)_localctx).returnType = type(0);
				setState(225);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case T__2:
				{
				{
				setState(227);
				((MethodDeclContext)_localctx).prefix = match(T__2);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(230);
			match(LPAREN);
			setState(242);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				setState(231);
				((MethodDeclContext)_localctx).type = type(0);
				((MethodDeclContext)_localctx).paramTypes.add(((MethodDeclContext)_localctx).type);
				setState(232);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).paramIds.add(((MethodDeclContext)_localctx).Identifier);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(233);
					match(COMMA);
					setState(234);
					((MethodDeclContext)_localctx).type = type(0);
					((MethodDeclContext)_localctx).paramTypes.add(((MethodDeclContext)_localctx).type);
					setState(235);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).paramIds.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(244);
			match(RPAREN);
			setState(254);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(245);
				match(THROWS);
				setState(246);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(247);
					match(COMMA);
					setState(248);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(258);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(256);
				blockStmt();
				}
				break;
			case SEMI:
				{
				setState(257);
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

	public static class AnnotationContext extends ParserRuleContext {
		public Token annotationType;
		public Token Identifier;
		public List<Token> annotationValueKey = new ArrayList<Token>();
		public LiteralContext literal;
		public List<LiteralContext> annotationValue = new ArrayList<LiteralContext>();
		public LiteralContext annotationDefaultValue;
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(AT);
			setState(261);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(279);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(262);
				match(LPAREN);
				setState(276);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					{
					setState(263);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(264);
					match(ASSIGN);
					setState(265);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(266);
						match(COMMA);
						setState(267);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(268);
						match(ASSIGN);
						setState(269);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(274);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(275);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(278);
				match(RPAREN);
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

	public static class TypeContext extends ParserRuleContext {
		public Token nullable;
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(282);
				classType();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case VOID:
				{
				setState(283);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(286);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(287);
					match(LBRACK);
					setState(288);
					match(RBRACK);
					setState(290);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(289);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static class ClassTypeContext extends ParserRuleContext {
		public Token rawClass;
		public ParameterizedElementTypeContext parameterizedElementType;
		public List<ParameterizedElementTypeContext> parameterTypes = new ArrayList<ParameterizedElementTypeContext>();
		public Token nullable;
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public List<ParameterizedElementTypeContext> parameterizedElementType() {
			return getRuleContexts(ParameterizedElementTypeContext.class);
		}
		public ParameterizedElementTypeContext parameterizedElementType(int i) {
			return getRuleContext(ParameterizedElementTypeContext.class,i);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			((ClassTypeContext)_localctx).rawClass = match(Identifier);
			setState(309);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(298);
				match(LT);
				setState(299);
				((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
				((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(300);
					match(COMMA);
					setState(301);
					((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
					((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
					}
					}
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(307);
				match(GT);
				}
				break;
			}
			setState(312);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(311);
				((ClassTypeContext)_localctx).nullable = match(QUESTION);
				}
				break;
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

	public static class ParameterizedElementTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public WildcardTypeContext wildcardType() {
			return getRuleContext(WildcardTypeContext.class,0);
		}
		public ParameterizedElementTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterizedElementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterParameterizedElementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitParameterizedElementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitParameterizedElementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterizedElementTypeContext parameterizedElementType() throws RecognitionException {
		ParameterizedElementTypeContext _localctx = new ParameterizedElementTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameterizedElementType);
		try {
			setState(316);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				wildcardType();
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

	public static class WildcardTypeContext extends ParserRuleContext {
		public Token boundKind;
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public WildcardTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterWildcardType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitWildcardType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitWildcardType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardTypeContext wildcardType() throws RecognitionException {
		WildcardTypeContext _localctx = new WildcardTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(QUESTION);
			setState(319);
			((WildcardTypeContext)_localctx).boundKind = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
				((WildcardTypeContext)_localctx).boundKind = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(320);
			classType();
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(KalangParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(KalangParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(KalangParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(KalangParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(KalangParser.CHAR, 0); }
		public TerminalNode BOOLEAN() { return getToken(KalangParser.BOOLEAN, 0); }
		public TerminalNode BYTE() { return getToken(KalangParser.BYTE, 0); }
		public TerminalNode VOID() { return getToken(KalangParser.VOID, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0)) ) {
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

	public static class LocalVarDeclContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public LocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitLocalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitLocalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarDeclContext localVarDecl() throws RecognitionException {
		LocalVarDeclContext _localctx = new LocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			varDecl();
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(325);
				match(COMMA);
				setState(326);
				varDecl();
				}
				}
				setState(331);
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
		public StatContext trueStmt;
		public StatContext falseStmt;
		public TerminalNode IF() { return getToken(KalangParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(KalangParser.ELSE, 0); }
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
		enterRule(_localctx, 30, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(IF);
			setState(333);
			match(LPAREN);
			setState(334);
			expression(0);
			setState(335);
			match(RPAREN);
			setState(336);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(339);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(337);
				match(ELSE);
				setState(338);
				((IfStatContext)_localctx).falseStmt = stat();
				}
				break;
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

	public static class StatContext extends ParserRuleContext {
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public VarDeclStatContext varDeclStat() {
			return getRuleContext(VarDeclStatContext.class,0);
		}
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
		public ForEachStatContext forEachStat() {
			return getRuleContext(ForEachStatContext.class,0);
		}
		public BreakStatContext breakStat() {
			return getRuleContext(BreakStatContext.class,0);
		}
		public ContinueStatContext continueStat() {
			return getRuleContext(ContinueStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public TryStatContext tryStat() {
			return getRuleContext(TryStatContext.class,0);
		}
		public ThrowStatContext throwStat() {
			return getRuleContext(ThrowStatContext.class,0);
		}
		public ErrorousStatContext errorousStat() {
			return getRuleContext(ErrorousStatContext.class,0);
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
		enterRule(_localctx, 32, RULE_stat);
		try {
			setState(356);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				varDeclStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				postIfStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(344);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(345);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(346);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(347);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(348);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(349);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(350);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(351);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(352);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(353);
				tryStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(354);
				throwStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(355);
				errorousStat();
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

	public static class ErrorousStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ErrorousStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorousStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterErrorousStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitErrorousStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitErrorousStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorousStatContext errorousStat() throws RecognitionException {
		ErrorousStatContext _localctx = new ErrorousStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
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

	public static class ThrowStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterThrowStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitThrowStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitThrowStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatContext throwStat() throws RecognitionException {
		ThrowStatContext _localctx = new ThrowStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(THROW);
			setState(361);
			expression(0);
			setState(362);
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

	public static class BlockStmtContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(LBRACE);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(365);
				stat();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(371);
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

	public static class TryStatContext extends ParserRuleContext {
		public BlockStmtContext exec;
		public ClassTypeContext classType;
		public List<ClassTypeContext> catchTypes = new ArrayList<ClassTypeContext>();
		public Token Identifier;
		public List<Token> catchVarNames = new ArrayList<Token>();
		public BlockStmtContext blockStmt;
		public List<BlockStmtContext> catchExec = new ArrayList<BlockStmtContext>();
		public BlockStmtContext finallyExec;
		public List<BlockStmtContext> blockStmt() {
			return getRuleContexts(BlockStmtContext.class);
		}
		public BlockStmtContext blockStmt(int i) {
			return getRuleContext(BlockStmtContext.class,i);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
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
		enterRule(_localctx, 40, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(TRY);
			setState(374);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(375);
				match(CATCH);
				setState(376);
				match(LPAREN);
				setState(377);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(378);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(379);
				match(RPAREN);
				setState(380);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(389);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(387);
				match(FINALLY);
				setState(388);
				((TryStatContext)_localctx).finallyExec = blockStmt();
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
		enterRule(_localctx, 42, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(RETURN);
			setState(393);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(392);
				expression(0);
				}
			}

			setState(395);
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
		enterRule(_localctx, 44, RULE_postIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			expression(0);
			setState(398);
			match(IF);
			setState(405);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(399);
				((PostIfStmtContext)_localctx).op = match(EQUAL);
				}
				break;
			case 2:
				{
				setState(400);
				((PostIfStmtContext)_localctx).op = match(LT);
				}
				break;
			case 3:
				{
				setState(401);
				((PostIfStmtContext)_localctx).op = match(GT);
				}
				break;
			case 4:
				{
				setState(402);
				((PostIfStmtContext)_localctx).op = match(NOTEQUAL);
				}
				break;
			case 5:
				{
				setState(403);
				((PostIfStmtContext)_localctx).op = match(GE);
				}
				break;
			case 6:
				{
				setState(404);
				((PostIfStmtContext)_localctx).op = match(LE);
				}
				break;
			}
			setState(407);
			expression(0);
			setState(408);
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
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
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
		enterRule(_localctx, 46, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			localVarDecl();
			setState(411);
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
		enterRule(_localctx, 48, RULE_varDecl);
		int _la;
		try {
			setState(429);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(413);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(414);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(417);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(415);
					match(T__1);
					setState(416);
					type(0);
					}
				}

				setState(421);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(419);
					match(ASSIGN);
					setState(420);
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
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(423);
				((VarDeclContext)_localctx).varType = type(0);
				setState(424);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(427);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(425);
					match(ASSIGN);
					setState(426);
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
		enterRule(_localctx, 50, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(BREAK);
			setState(432);
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
		enterRule(_localctx, 52, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(CONTINUE);
			setState(435);
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
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
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
		enterRule(_localctx, 54, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(WHILE);
			setState(438);
			match(LPAREN);
			setState(439);
			expression(0);
			setState(440);
			match(RPAREN);
			setState(441);
			stat();
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
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
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
		enterRule(_localctx, 56, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(DO);
			setState(444);
			blockStmt();
			setState(445);
			match(WHILE);
			setState(446);
			match(LPAREN);
			setState(447);
			expression(0);
			setState(448);
			match(RPAREN);
			setState(449);
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
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
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
		enterRule(_localctx, 58, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(FOR);
			setState(452);
			match(LPAREN);
			setState(454);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				setState(453);
				localVarDecl();
				}
			}

			setState(456);
			match(SEMI);
			setState(458);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(457);
				expression(0);
				}
			}

			setState(460);
			match(SEMI);
			setState(462);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(461);
				expressions();
				}
			}

			setState(464);
			match(RPAREN);
			setState(465);
			stat();
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

	public static class ForEachStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ForEachStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forEachStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterForEachStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitForEachStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitForEachStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForEachStatContext forEachStat() throws RecognitionException {
		ForEachStatContext _localctx = new ForEachStatContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forEachStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(T__5);
			setState(468);
			match(LPAREN);
			setState(469);
			expression(0);
			setState(470);
			match(T__1);
			setState(473);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(471);
				match(Identifier);
				setState(472);
				match(COMMA);
				}
				break;
			}
			setState(475);
			match(Identifier);
			setState(476);
			match(RPAREN);
			setState(477);
			stat();
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
		enterRule(_localctx, 62, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			expression(0);
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(480);
				match(COMMA);
				setState(481);
				expression(0);
				}
				}
				setState(486);
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
		enterRule(_localctx, 64, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			expression(0);
			setState(488);
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
		public ExpressionContext expression;
		public List<ExpressionContext> params = new ArrayList<ExpressionContext>();
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
	public static class InvokeExprContext extends ExpressionContext {
		public ExpressionContext target;
		public Token refKey;
		public ExpressionContext expression;
		public List<ExpressionContext> params = new ArrayList<ExpressionContext>();
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InvokeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterInvokeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitInvokeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitInvokeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstanceofExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INSTANCEOF() { return getToken(KalangParser.INSTANCEOF, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public InstanceofExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterInstanceofExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitInstanceofExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitInstanceofExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IncExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitIncExpr(this);
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
	public static class MapExprContext extends ExpressionContext {
		public Token keyType;
		public Token valueType;
		public Token Identifier;
		public List<Token> keys = new ArrayList<Token>();
		public ExpressionContext expression;
		public List<ExpressionContext> values = new ArrayList<ExpressionContext>();
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
	public static class BinaryExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetFieldExprContext extends ExpressionContext {
		public Token refKey;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public GetFieldExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterGetFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitGetFieldExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitGetFieldExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuestionExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public QuestionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterQuestionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitQuestionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitQuestionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetArrayElementExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GetArrayElementExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterGetArrayElementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitGetArrayElementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitGetArrayElementExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreIncExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PreIncExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterPreIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitPreIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitPreIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorousMemberExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ErrorousMemberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterErrorousMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitErrorousMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitErrorousMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberInvocationExprContext extends ExpressionContext {
		public Token key;
		public ExpressionContext expression;
		public List<ExpressionContext> params = new ArrayList<ExpressionContext>();
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MemberInvocationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterMemberInvocationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitMemberInvocationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitMemberInvocationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayExprContext extends ExpressionContext {
		public ExpressionContext size;
		public ExpressionContext expression;
		public List<ExpressionContext> initExpr = new ArrayList<ExpressionContext>();
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterNewArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitNewArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitNewArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfRefExprContext extends ExpressionContext {
		public Token ref;
		public SelfRefExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterSelfRefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitSelfRefExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitSelfRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public IdentifierExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitIdentifierExpr(this);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(491);
				match(LPAREN);
				setState(492);
				type(0);
				setState(493);
				match(RPAREN);
				setState(494);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(497);
				expression(17);
				}
				break;
			case 3:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(498);
				((PreIncExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(499);
				expression(16);
				}
				break;
			case 4:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(501);
				expression(15);
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(502);
				match(LPAREN);
				setState(503);
				expression(0);
				setState(504);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(506);
				((SelfRefExprContext)_localctx).ref = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUPER || _la==THIS) ) {
					((SelfRefExprContext)_localctx).ref = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 7:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(507);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(513);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(508);
					match(LT);
					setState(509);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(510);
					match(COMMA);
					setState(511);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(512);
					match(GT);
					}
				}

				setState(533);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(515);
					match(LBRACK);
					setState(516);
					((MapExprContext)_localctx).Identifier = match(Identifier);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
					setState(517);
					match(COLON);
					setState(518);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(525);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(519);
						match(COMMA);
						setState(520);
						((MapExprContext)_localctx).Identifier = match(Identifier);
						((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
						setState(521);
						match(COLON);
						setState(522);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
						}
						}
						setState(527);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(528);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(530);
					match(LBRACK);
					setState(531);
					match(COLON);
					setState(532);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(539);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(535);
					match(LT);
					setState(536);
					type(0);
					setState(537);
					match(GT);
					}
				}

				setState(541);
				match(LBRACK);
				setState(550);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(542);
					expression(0);
					setState(547);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(543);
						match(COMMA);
						setState(544);
						expression(0);
						}
						}
						setState(549);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(552);
				match(RBRACK);
				}
				break;
			case 10:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(556);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(553);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(554);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(555);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(558);
				match(LPAREN);
				setState(567);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(559);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(564);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(560);
						match(COMMA);
						setState(561);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(566);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(569);
				match(RPAREN);
				}
				break;
			case 11:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(570);
				match(NEW);
				setState(571);
				classType();
				setState(572);
				match(LPAREN);
				setState(581);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(573);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(574);
						match(COMMA);
						setState(575);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(580);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(583);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(608);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(585);
					match(NEW);
					setState(586);
					type(0);
					setState(587);
					match(LBRACK);
					setState(588);
					((NewArrayExprContext)_localctx).size = expression(0);
					setState(589);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(591);
					match(NEW);
					setState(592);
					type(0);
					setState(593);
					match(LBRACK);
					setState(594);
					match(RBRACK);
					setState(595);
					match(LBRACE);
					setState(604);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						setState(596);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(601);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(597);
							match(COMMA);
							setState(598);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(603);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(606);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case 13:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(610);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(681);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(679);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(613);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(614);
						_la = _input.LA(1);
						if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (MUL - 95)) | (1L << (DIV - 95)) | (1L << (MOD - 95)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(615);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(616);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(617);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(618);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(619);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(620);
						_la = _input.LA(1);
						if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (LEFT_SHIFT - 75)) | (1L << (RIGHT_SHIFT - 75)) | (1L << (UNSIGNED_RIGHT_SHIFT - 75)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(621);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(622);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(623);
						_la = _input.LA(1);
						if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (GT - 79)) | (1L << (LT - 79)) | (1L << (LE - 79)) | (1L << (GE - 79)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(624);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(625);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(626);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(627);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(628);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(629);
						match(BITAND);
						setState(630);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(631);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(632);
						match(CARET);
						setState(633);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(634);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(635);
						match(BITOR);
						setState(636);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(637);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(638);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(639);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(640);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(641);
						match(QUESTION);
						setState(642);
						expression(0);
						setState(643);
						match(COLON);
						setState(644);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(646);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(647);
						_la = _input.LA(1);
						if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (ASSIGN - 78)) | (1L << (ADD_ASSIGN - 78)) | (1L << (SUB_ASSIGN - 78)) | (1L << (MUL_ASSIGN - 78)) | (1L << (DIV_ASSIGN - 78)) | (1L << (AND_ASSIGN - 78)) | (1L << (OR_ASSIGN - 78)) | (1L << (XOR_ASSIGN - 78)) | (1L << (MOD_ASSIGN - 78)) | (1L << (LSHIFT_ASSIGN - 78)) | (1L << (RSHIFT_ASSIGN - 78)) | (1L << (URSHIFT_ASSIGN - 78)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(648);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(649);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(650);
						((InvokeExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7 || _la==DOT) ) {
							((InvokeExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(651);
						match(Identifier);
						setState(652);
						match(LPAREN);
						setState(661);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(653);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(658);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(654);
								match(COMMA);
								setState(655);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(660);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(663);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(664);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(665);
						((GetFieldExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==DOT) ) {
							((GetFieldExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(666);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(667);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(668);
						match(LBRACK);
						setState(669);
						expression(0);
						setState(670);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(672);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(673);
						((IncExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((IncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					case 16:
						{
						_localctx = new InstanceofExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(674);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(675);
						match(INSTANCEOF);
						setState(676);
						match(Identifier);
						}
						break;
					case 17:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(677);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(678);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(683);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(KalangParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(KalangParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(KalangParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KalangParser.BooleanLiteral, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
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
		try {
			setState(693);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(684);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(685);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(686);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(687);
				match(StringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(688);
				match(BooleanLiteral);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(689);
				match(Identifier);
				setState(690);
				match(DOT);
				setState(691);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(692);
				match(NullLiteral);
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
		enterRule(_localctx, 70, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(695);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(698); 
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
		case 9:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 33:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 25);
		case 13:
			return precpred(_ctx, 24);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 18);
		case 16:
			return precpred(_ctx, 10);
		case 17:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3w\u02bf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\3\2\5\2"+
		"S\n\2\3\3\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\4\7\4]\n\4\f\4\16\4`\13\4\3\4"+
		"\5\4c\n\4\3\4\3\4\3\4\3\4\3\4\7\4j\n\4\f\4\16\4m\13\4\3\4\5\4p\n\4\3\4"+
		"\5\4s\n\4\3\4\3\4\5\4w\n\4\3\4\3\4\3\4\3\4\7\4}\n\4\f\4\16\4\u0080\13"+
		"\4\5\4\u0082\n\4\3\4\3\4\3\4\3\4\3\5\3\5\5\5\u008a\n\5\3\5\3\5\3\5\7\5"+
		"\u008f\n\5\f\5\16\5\u0092\13\5\3\5\3\5\3\5\3\5\5\5\u0098\n\5\3\5\5\5\u009b"+
		"\n\5\3\5\3\5\3\5\3\5\7\5\u00a1\n\5\f\5\16\5\u00a4\13\5\3\5\3\5\3\5\3\5"+
		"\5\5\u00aa\n\5\3\5\5\5\u00ad\n\5\5\5\u00af\n\5\3\5\3\5\3\6\3\6\3\6\7\6"+
		"\u00b6\n\6\f\6\16\6\u00b9\13\6\3\7\7\7\u00bc\n\7\f\7\16\7\u00bf\13\7\3"+
		"\7\7\7\u00c2\n\7\f\7\16\7\u00c5\13\7\3\b\5\b\u00c8\n\b\3\b\3\b\3\b\7\b"+
		"\u00cd\n\b\f\b\16\b\u00d0\13\b\3\b\3\b\3\t\7\t\u00d5\n\t\f\t\16\t\u00d8"+
		"\13\t\3\t\5\t\u00db\n\t\3\t\5\t\u00de\n\t\3\t\5\t\u00e1\n\t\3\t\3\t\3"+
		"\t\3\t\5\t\u00e7\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f0\n\t\f\t\16"+
		"\t\u00f3\13\t\5\t\u00f5\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u00fc\n\t\f\t\16\t"+
		"\u00ff\13\t\5\t\u0101\n\t\3\t\3\t\5\t\u0105\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u0111\n\n\f\n\16\n\u0114\13\n\3\n\5\n\u0117\n\n"+
		"\3\n\5\n\u011a\n\n\3\13\3\13\3\13\5\13\u011f\n\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0125\n\13\7\13\u0127\n\13\f\13\16\13\u012a\13\13\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u0131\n\f\f\f\16\f\u0134\13\f\3\f\3\f\5\f\u0138\n\f\3\f\5\f"+
		"\u013b\n\f\3\r\3\r\5\r\u013f\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\7\20\u014a\n\20\f\20\16\20\u014d\13\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0156\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0167\n\22\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\7\25\u0171\n\25\f\25\16\25\u0174\13\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0181\n\26\f\26\16"+
		"\26\u0184\13\26\3\26\3\26\5\26\u0188\n\26\3\27\3\27\5\27\u018c\n\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0198\n\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u01a4\n\32\3\32\3\32"+
		"\5\32\u01a8\n\32\3\32\3\32\3\32\3\32\5\32\u01ae\n\32\5\32\u01b0\n\32\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u01c9\n\37\3\37\3\37"+
		"\5\37\u01cd\n\37\3\37\3\37\5\37\u01d1\n\37\3\37\3\37\3\37\3 \3 \3 \3 "+
		"\3 \3 \5 \u01dc\n \3 \3 \3 \3 \3!\3!\3!\7!\u01e5\n!\f!\16!\u01e8\13!\3"+
		"\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\5#\u0204\n#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u020e\n#\f#\16#\u0211"+
		"\13#\3#\3#\3#\3#\3#\5#\u0218\n#\3#\3#\3#\3#\5#\u021e\n#\3#\3#\3#\3#\7"+
		"#\u0224\n#\f#\16#\u0227\13#\5#\u0229\n#\3#\3#\3#\3#\5#\u022f\n#\3#\3#"+
		"\3#\3#\7#\u0235\n#\f#\16#\u0238\13#\5#\u023a\n#\3#\3#\3#\3#\3#\3#\3#\7"+
		"#\u0243\n#\f#\16#\u0246\13#\5#\u0248\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\7#\u025a\n#\f#\16#\u025d\13#\5#\u025f\n#\3#\3#\5#\u0263"+
		"\n#\3#\5#\u0266\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\7#\u0293\n#\f#\16#\u0296\13#\5#\u0298\n#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u02aa\n#\f#\16#\u02ad\13#\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\5$\u02b8\n$\3%\6%\u02bb\n%\r%\16%\u02bc\3%\2\4\24D&\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2"+
		"\22\4\2\34\34\63\63\n\2\16\16\20\20\23\23\31\31\37\37&&((;;\3\2\6\7\3"+
		"\2_`\3\2]^\3\2ST\4\2\63\63\66\66\4\2abff\3\2MO\4\2QRXY\4\2WWZZ\3\2[\\"+
		"\4\2PPgq\4\2\t\nLL\4\2\t\tLL\5\2\35\35,.\61\61\u0320\2M\3\2\2\2\4X\3\2"+
		"\2\2\6^\3\2\2\2\b\u00ae\3\2\2\2\n\u00b2\3\2\2\2\f\u00bd\3\2\2\2\16\u00c7"+
		"\3\2\2\2\20\u00d6\3\2\2\2\22\u0106\3\2\2\2\24\u011e\3\2\2\2\26\u012b\3"+
		"\2\2\2\30\u013e\3\2\2\2\32\u0140\3\2\2\2\34\u0144\3\2\2\2\36\u0146\3\2"+
		"\2\2 \u014e\3\2\2\2\"\u0166\3\2\2\2$\u0168\3\2\2\2&\u016a\3\2\2\2(\u016e"+
		"\3\2\2\2*\u0177\3\2\2\2,\u0189\3\2\2\2.\u018f\3\2\2\2\60\u019c\3\2\2\2"+
		"\62\u01af\3\2\2\2\64\u01b1\3\2\2\2\66\u01b4\3\2\2\28\u01b7\3\2\2\2:\u01bd"+
		"\3\2\2\2<\u01c5\3\2\2\2>\u01d5\3\2\2\2@\u01e1\3\2\2\2B\u01e9\3\2\2\2D"+
		"\u0265\3\2\2\2F\u02b7\3\2\2\2H\u02ba\3\2\2\2JL\5\b\5\2KJ\3\2\2\2LO\3\2"+
		"\2\2MK\3\2\2\2MN\3\2\2\2NR\3\2\2\2OM\3\2\2\2PS\5\6\4\2QS\5\4\3\2RP\3\2"+
		"\2\2RQ\3\2\2\2S\3\3\2\2\2TW\5\20\t\2UW\5\"\22\2VT\3\2\2\2VU\3\2\2\2WZ"+
		"\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\5\3\2\2\2ZX\3\2\2\2[]\5\22\n\2\\[\3\2\2"+
		"\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2ac\5H%\2ba\3\2\2"+
		"\2bc\3\2\2\2cr\3\2\2\2do\7\24\2\2ef\7R\2\2fk\7r\2\2gh\7K\2\2hj\7r\2\2"+
		"ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2np\7Q\2\2"+
		"oe\3\2\2\2op\3\2\2\2ps\3\2\2\2qs\7\'\2\2rd\3\2\2\2rq\3\2\2\2sv\3\2\2\2"+
		"tu\7\34\2\2uw\5\26\f\2vt\3\2\2\2vw\3\2\2\2w\u0081\3\2\2\2xy\7#\2\2y~\5"+
		"\26\f\2z{\7K\2\2{}\5\26\f\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3"+
		"\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081x\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7F\2\2\u0084\u0085\5\f\7\2\u0085"+
		"\u0086\7G\2\2\u0086\7\3\2\2\2\u0087\u0089\7$\2\2\u0088\u008a\7\3\2\2\u0089"+
		"\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0090\7r"+
		"\2\2\u008c\u008d\7\3\2\2\u008d\u008f\7r\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u009a\7\3\2\2\u0094\u0097\7r\2\2\u0095"+
		"\u0096\7\4\2\2\u0096\u0098\7r\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u009b\7a\2\2\u009a\u0094\3\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\u00af\3\2\2\2\u009c\u009d\7$\2\2\u009d\u00a2\7r\2"+
		"\2\u009e\u009f\7L\2\2\u009f\u00a1\7r\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00ac\7L\2\2\u00a6\u00a9\7r\2\2\u00a7\u00a8\7\4\2"+
		"\2\u00a8\u00aa\7r\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad"+
		"\3\2\2\2\u00ab\u00ad\7a\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u0087\3\2\2\2\u00ae\u009c\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\7J\2\2\u00b1\t\3\2\2\2\u00b2\u00b7\7r\2\2\u00b3\u00b4"+
		"\7L\2\2\u00b4\u00b6\7r\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\13\3\2\2\2\u00b9\u00b7\3\2\2"+
		"\2\u00ba\u00bc\5\16\b\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c3\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c2\5\20\t\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\r\3\2\2\2\u00c5\u00c3\3\2\2\2"+
		"\u00c6\u00c8\5H%\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00ce\5\62\32\2\u00ca\u00cb\7K\2\2\u00cb\u00cd\5\62\32"+
		"\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7J\2\2\u00d2"+
		"\17\3\2\2\2\u00d3\u00d5\5\22\n\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2"+
		"\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00db\7\13\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2"+
		"\u00db\u00dd\3\2\2\2\u00dc\u00de\7\27\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\5H%\2\u00e0\u00df\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e6\3\2\2\2\u00e2\u00e3\5\24\13\2\u00e3\u00e4\7"+
		"r\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e7\7\5\2\2\u00e6\u00e2\3\2\2\2\u00e6"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00f4\7D\2\2\u00e9\u00ea\5\24"+
		"\13\2\u00ea\u00f1\7r\2\2\u00eb\u00ec\7K\2\2\u00ec\u00ed\5\24\13\2\u00ed"+
		"\u00ee\7r\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0\u00f3\3\2"+
		"\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00e9\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u0100\7E\2\2\u00f7\u00f8\78\2\2\u00f8\u00fd\7r\2\2\u00f9\u00fa"+
		"\7K\2\2\u00fa\u00fc\7r\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u0100\u00f7\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102"+
		"\u0105\5(\25\2\u0103\u0105\7J\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2"+
		"\2\2\u0105\21\3\2\2\2\u0106\u0107\7s\2\2\u0107\u0119\7r\2\2\u0108\u0116"+
		"\7D\2\2\u0109\u010a\7r\2\2\u010a\u010b\7P\2\2\u010b\u0112\5F$\2\u010c"+
		"\u010d\7K\2\2\u010d\u010e\7r\2\2\u010e\u010f\7P\2\2\u010f\u0111\5F$\2"+
		"\u0110\u010c\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0117\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\5F$\2\u0116"+
		"\u0109\3\2\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011a\7E\2\2\u0119\u0108\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\23\3\2\2\2\u011b\u011c\b\13\1\2\u011c\u011f\5\26\f\2\u011d\u011f\5\34"+
		"\17\2\u011e\u011b\3\2\2\2\u011e\u011d\3\2\2\2\u011f\u0128\3\2\2\2\u0120"+
		"\u0121\f\3\2\2\u0121\u0122\7H\2\2\u0122\u0124\7I\2\2\u0123\u0125\7U\2"+
		"\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0120"+
		"\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\25\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0137\7r\2\2\u012c\u012d\7R\2\2"+
		"\u012d\u0132\5\30\r\2\u012e\u012f\7K\2\2\u012f\u0131\5\30\r\2\u0130\u012e"+
		"\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7Q\2\2\u0136\u0138\3\2"+
		"\2\2\u0137\u012c\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139"+
		"\u013b\7U\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\27\3\2\2\2"+
		"\u013c\u013f\5\24\13\2\u013d\u013f\5\32\16\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013d\3\2\2\2\u013f\31\3\2\2\2\u0140\u0141\7U\2\2\u0141\u0142\t\2\2\2"+
		"\u0142\u0143\5\26\f\2\u0143\33\3\2\2\2\u0144\u0145\t\3\2\2\u0145\35\3"+
		"\2\2\2\u0146\u014b\5\62\32\2\u0147\u0148\7K\2\2\u0148\u014a\5\62\32\2"+
		"\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c\37\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\7!\2\2\u014f"+
		"\u0150\7D\2\2\u0150\u0151\5D#\2\u0151\u0152\7E\2\2\u0152\u0155\5\"\22"+
		"\2\u0153\u0154\7\32\2\2\u0154\u0156\5\"\22\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156!\3\2\2\2\u0157\u0167\5(\25\2\u0158\u0167\5\60\31"+
		"\2\u0159\u0167\5.\30\2\u015a\u0167\5B\"\2\u015b\u0167\5 \21\2\u015c\u0167"+
		"\58\35\2\u015d\u0167\5:\36\2\u015e\u0167\5<\37\2\u015f\u0167\5> \2\u0160"+
		"\u0167\5\64\33\2\u0161\u0167\5\66\34\2\u0162\u0167\5,\27\2\u0163\u0167"+
		"\5*\26\2\u0164\u0167\5&\24\2\u0165\u0167\5$\23\2\u0166\u0157\3\2\2\2\u0166"+
		"\u0158\3\2\2\2\u0166\u0159\3\2\2\2\u0166\u015a\3\2\2\2\u0166\u015b\3\2"+
		"\2\2\u0166\u015c\3\2\2\2\u0166\u015d\3\2\2\2\u0166\u015e\3\2\2\2\u0166"+
		"\u015f\3\2\2\2\u0166\u0160\3\2\2\2\u0166\u0161\3\2\2\2\u0166\u0162\3\2"+
		"\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167"+
		"#\3\2\2\2\u0168\u0169\5D#\2\u0169%\3\2\2\2\u016a\u016b\7\67\2\2\u016b"+
		"\u016c\5D#\2\u016c\u016d\7J\2\2\u016d\'\3\2\2\2\u016e\u0172\7F\2\2\u016f"+
		"\u0171\5\"\22\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3"+
		"\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u0176\7G\2\2\u0176)\3\2\2\2\u0177\u0178\7:\2\2\u0178\u0182\5(\25\2\u0179"+
		"\u017a\7\22\2\2\u017a\u017b\7D\2\2\u017b\u017c\5\26\f\2\u017c\u017d\7"+
		"r\2\2\u017d\u017e\7E\2\2\u017e\u017f\5(\25\2\u017f\u0181\3\2\2\2\u0180"+
		"\u0179\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0187\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7\36\2\2\u0186"+
		"\u0188\5(\25\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188+\3\2\2\2"+
		"\u0189\u018b\7/\2\2\u018a\u018c\5D#\2\u018b\u018a\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\7J\2\2\u018e-\3\2\2\2\u018f\u0190"+
		"\5D#\2\u0190\u0197\7!\2\2\u0191\u0198\7W\2\2\u0192\u0198\7R\2\2\u0193"+
		"\u0198\7Q\2\2\u0194\u0198\7Z\2\2\u0195\u0198\7Y\2\2\u0196\u0198\7X\2\2"+
		"\u0197\u0191\3\2\2\2\u0197\u0192\3\2\2\2\u0197\u0193\3\2\2\2\u0197\u0194"+
		"\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u019a\5D#\2\u019a\u019b\7J\2\2\u019b/\3\2\2\2\u019c"+
		"\u019d\5\36\20\2\u019d\u019e\7J\2\2\u019e\61\3\2\2\2\u019f\u01a0\t\4\2"+
		"\2\u01a0\u01a3\7r\2\2\u01a1\u01a2\7\4\2\2\u01a2\u01a4\5\24\13\2\u01a3"+
		"\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a6\7P"+
		"\2\2\u01a6\u01a8\5D#\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01b0"+
		"\3\2\2\2\u01a9\u01aa\5\24\13\2\u01aa\u01ad\7r\2\2\u01ab\u01ac\7P\2\2\u01ac"+
		"\u01ae\5D#\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\3\2\2"+
		"\2\u01af\u019f\3\2\2\2\u01af\u01a9\3\2\2\2\u01b0\63\3\2\2\2\u01b1\u01b2"+
		"\7\17\2\2\u01b2\u01b3\7J\2\2\u01b3\65\3\2\2\2\u01b4\u01b5\7\26\2\2\u01b5"+
		"\u01b6\7J\2\2\u01b6\67\3\2\2\2\u01b7\u01b8\7=\2\2\u01b8\u01b9\7D\2\2\u01b9"+
		"\u01ba\5D#\2\u01ba\u01bb\7E\2\2\u01bb\u01bc\5\"\22\2\u01bc9\3\2\2\2\u01bd"+
		"\u01be\7\30\2\2\u01be\u01bf\5(\25\2\u01bf\u01c0\7=\2\2\u01c0\u01c1\7D"+
		"\2\2\u01c1\u01c2\5D#\2\u01c2\u01c3\7E\2\2\u01c3\u01c4\7J\2\2\u01c4;\3"+
		"\2\2\2\u01c5\u01c6\7 \2\2\u01c6\u01c8\7D\2\2\u01c7\u01c9\5\36\20\2\u01c8"+
		"\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\7J"+
		"\2\2\u01cb\u01cd\5D#\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce"+
		"\3\2\2\2\u01ce\u01d0\7J\2\2\u01cf\u01d1\5@!\2\u01d0\u01cf\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\7E\2\2\u01d3\u01d4\5\""+
		"\22\2\u01d4=\3\2\2\2\u01d5\u01d6\7\b\2\2\u01d6\u01d7\7D\2\2\u01d7\u01d8"+
		"\5D#\2\u01d8\u01db\7\4\2\2\u01d9\u01da\7r\2\2\u01da\u01dc\7K\2\2\u01db"+
		"\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\7r"+
		"\2\2\u01de\u01df\7E\2\2\u01df\u01e0\5\"\22\2\u01e0?\3\2\2\2\u01e1\u01e6"+
		"\5D#\2\u01e2\u01e3\7K\2\2\u01e3\u01e5\5D#\2\u01e4\u01e2\3\2\2\2\u01e5"+
		"\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7A\3\2\2\2"+
		"\u01e8\u01e6\3\2\2\2\u01e9\u01ea\5D#\2\u01ea\u01eb\7J\2\2\u01ebC\3\2\2"+
		"\2\u01ec\u01ed\b#\1\2\u01ed\u01ee\7D\2\2\u01ee\u01ef\5\24\13\2\u01ef\u01f0"+
		"\7E\2\2\u01f0\u01f1\5D#\25\u01f1\u0266\3\2\2\2\u01f2\u01f3\t\5\2\2\u01f3"+
		"\u0266\5D#\23\u01f4\u01f5\t\6\2\2\u01f5\u0266\5D#\22\u01f6\u01f7\t\7\2"+
		"\2\u01f7\u0266\5D#\21\u01f8\u01f9\7D\2\2\u01f9\u01fa\5D#\2\u01fa\u01fb"+
		"\7E\2\2\u01fb\u0266\3\2\2\2\u01fc\u0266\t\b\2\2\u01fd\u0266\5F$\2\u01fe"+
		"\u01ff\7R\2\2\u01ff\u0200\7r\2\2\u0200\u0201\7K\2\2\u0201\u0202\7r\2\2"+
		"\u0202\u0204\7Q\2\2\u0203\u01fe\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0217"+
		"\3\2\2\2\u0205\u0206\7H\2\2\u0206\u0207\7r\2\2\u0207\u0208\7V\2\2\u0208"+
		"\u020f\5D#\2\u0209\u020a\7K\2\2\u020a\u020b\7r\2\2\u020b\u020c\7V\2\2"+
		"\u020c\u020e\5D#\2\u020d\u0209\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d"+
		"\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0212\3\2\2\2\u0211\u020f\3\2\2\2\u0212"+
		"\u0213\7I\2\2\u0213\u0218\3\2\2\2\u0214\u0215\7H\2\2\u0215\u0216\7V\2"+
		"\2\u0216\u0218\7I\2\2\u0217\u0205\3\2\2\2\u0217\u0214\3\2\2\2\u0218\u0266"+
		"\3\2\2\2\u0219\u021a\7R\2\2\u021a\u021b\5\24\13\2\u021b\u021c\7Q\2\2\u021c"+
		"\u021e\3\2\2\2\u021d\u0219\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3\2"+
		"\2\2\u021f\u0228\7H\2\2\u0220\u0225\5D#\2\u0221\u0222\7K\2\2\u0222\u0224"+
		"\5D#\2\u0223\u0221\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225"+
		"\u0226\3\2\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u0220\3\2"+
		"\2\2\u0228\u0229\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u0266\7I\2\2\u022b"+
		"\u022f\7r\2\2\u022c\u022f\7\66\2\2\u022d\u022f\7\63\2\2\u022e\u022b\3"+
		"\2\2\2\u022e\u022c\3\2\2\2\u022e\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230"+
		"\u0239\7D\2\2\u0231\u0236\5D#\2\u0232\u0233\7K\2\2\u0233\u0235\5D#\2\u0234"+
		"\u0232\3\2\2\2\u0235\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2"+
		"\2\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0239\u0231\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u0266\7E\2\2\u023c\u023d\7*\2"+
		"\2\u023d\u023e\5\26\f\2\u023e\u0247\7D\2\2\u023f\u0244\5D#\2\u0240\u0241"+
		"\7K\2\2\u0241\u0243\5D#\2\u0242\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244"+
		"\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2"+
		"\2\2\u0247\u023f\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024a\7E\2\2\u024a\u0266\3\2\2\2\u024b\u024c\7*\2\2\u024c\u024d\5\24"+
		"\13\2\u024d\u024e\7H\2\2\u024e\u024f\5D#\2\u024f\u0250\7I\2\2\u0250\u0263"+
		"\3\2\2\2\u0251\u0252\7*\2\2\u0252\u0253\5\24\13\2\u0253\u0254\7H\2\2\u0254"+
		"\u0255\7I\2\2\u0255\u025e\7F\2\2\u0256\u025b\5D#\2\u0257\u0258\7K\2\2"+
		"\u0258\u025a\5D#\2\u0259\u0257\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259"+
		"\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025e"+
		"\u0256\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\7G"+
		"\2\2\u0261\u0263\3\2\2\2\u0262\u024b\3\2\2\2\u0262\u0251\3\2\2\2\u0263"+
		"\u0266\3\2\2\2\u0264\u0266\7r\2\2\u0265\u01ec\3\2\2\2\u0265\u01f2\3\2"+
		"\2\2\u0265\u01f4\3\2\2\2\u0265\u01f6\3\2\2\2\u0265\u01f8\3\2\2\2\u0265"+
		"\u01fc\3\2\2\2\u0265\u01fd\3\2\2\2\u0265\u0203\3\2\2\2\u0265\u021d\3\2"+
		"\2\2\u0265\u022e\3\2\2\2\u0265\u023c\3\2\2\2\u0265\u0262\3\2\2\2\u0265"+
		"\u0264\3\2\2\2\u0266\u02ab\3\2\2\2\u0267\u0268\f\20\2\2\u0268\u0269\t"+
		"\t\2\2\u0269\u02aa\5D#\21\u026a\u026b\f\17\2\2\u026b\u026c\t\5\2\2\u026c"+
		"\u02aa\5D#\20\u026d\u026e\f\16\2\2\u026e\u026f\t\n\2\2\u026f\u02aa\5D"+
		"#\17\u0270\u0271\f\r\2\2\u0271\u0272\t\13\2\2\u0272\u02aa\5D#\16\u0273"+
		"\u0274\f\13\2\2\u0274\u0275\t\f\2\2\u0275\u02aa\5D#\f\u0276\u0277\f\n"+
		"\2\2\u0277\u0278\7c\2\2\u0278\u02aa\5D#\13\u0279\u027a\f\t\2\2\u027a\u027b"+
		"\7e\2\2\u027b\u02aa\5D#\n\u027c\u027d\f\b\2\2\u027d\u027e\7d\2\2\u027e"+
		"\u02aa\5D#\t\u027f\u0280\f\7\2\2\u0280\u0281\t\r\2\2\u0281\u02aa\5D#\b"+
		"\u0282\u0283\f\6\2\2\u0283\u0284\7U\2\2\u0284\u0285\5D#\2\u0285\u0286"+
		"\7V\2\2\u0286\u0287\5D#\7\u0287\u02aa\3\2\2\2\u0288\u0289\f\3\2\2\u0289"+
		"\u028a\t\16\2\2\u028a\u02aa\5D#\3\u028b\u028c\f\33\2\2\u028c\u028d\t\17"+
		"\2\2\u028d\u028e\7r\2\2\u028e\u0297\7D\2\2\u028f\u0294\5D#\2\u0290\u0291"+
		"\7K\2\2\u0291\u0293\5D#\2\u0292\u0290\3\2\2\2\u0293\u0296\3\2\2\2\u0294"+
		"\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0298\3\2\2\2\u0296\u0294\3\2"+
		"\2\2\u0297\u028f\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299\3\2\2\2\u0299"+
		"\u02aa\7E\2\2\u029a\u029b\f\32\2\2\u029b\u029c\t\20\2\2\u029c\u02aa\7"+
		"r\2\2\u029d\u029e\f\30\2\2\u029e\u029f\7H\2\2\u029f\u02a0\5D#\2\u02a0"+
		"\u02a1\7I\2\2\u02a1\u02aa\3\2\2\2\u02a2\u02a3\f\24\2\2\u02a3\u02aa\t\6"+
		"\2\2\u02a4\u02a5\f\f\2\2\u02a5\u02a6\7%\2\2\u02a6\u02aa\7r\2\2\u02a7\u02a8"+
		"\f\4\2\2\u02a8\u02aa\7L\2\2\u02a9\u0267\3\2\2\2\u02a9\u026a\3\2\2\2\u02a9"+
		"\u026d\3\2\2\2\u02a9\u0270\3\2\2\2\u02a9\u0273\3\2\2\2\u02a9\u0276\3\2"+
		"\2\2\u02a9\u0279\3\2\2\2\u02a9\u027c\3\2\2\2\u02a9\u027f\3\2\2\2\u02a9"+
		"\u0282\3\2\2\2\u02a9\u0288\3\2\2\2\u02a9\u028b\3\2\2\2\u02a9\u029a\3\2"+
		"\2\2\u02a9\u029d\3\2\2\2\u02a9\u02a2\3\2\2\2\u02a9\u02a4\3\2\2\2\u02a9"+
		"\u02a7\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2"+
		"\2\2\u02acE\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02b8\7>\2\2\u02af\u02b8"+
		"\7?\2\2\u02b0\u02b8\7A\2\2\u02b1\u02b8\7B\2\2\u02b2\u02b8\7@\2\2\u02b3"+
		"\u02b4\7r\2\2\u02b4\u02b5\7L\2\2\u02b5\u02b8\7\24\2\2\u02b6\u02b8\7C\2"+
		"\2\u02b7\u02ae\3\2\2\2\u02b7\u02af\3\2\2\2\u02b7\u02b0\3\2\2\2\u02b7\u02b1"+
		"\3\2\2\2\u02b7\u02b2\3\2\2\2\u02b7\u02b3\3\2\2\2\u02b7\u02b6\3\2\2\2\u02b8"+
		"G\3\2\2\2\u02b9\u02bb\t\21\2\2\u02ba\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2"+
		"\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bdI\3\2\2\2UMRVX^bkorv~\u0081"+
		"\u0089\u0090\u0097\u009a\u00a2\u00a9\u00ac\u00ae\u00b7\u00bd\u00c3\u00c7"+
		"\u00ce\u00d6\u00da\u00dd\u00e0\u00e6\u00f1\u00f4\u00fd\u0100\u0104\u0112"+
		"\u0116\u0119\u011e\u0124\u0128\u0132\u0137\u013a\u013e\u014b\u0155\u0166"+
		"\u0172\u0182\u0187\u018b\u0197\u01a3\u01a7\u01ad\u01af\u01c8\u01cc\u01d0"+
		"\u01db\u01e6\u0203\u020f\u0217\u021d\u0225\u0228\u022e\u0236\u0239\u0244"+
		"\u0247\u025b\u025e\u0262\u0265\u0294\u0297\u02a9\u02ab\u02b7\u02bc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
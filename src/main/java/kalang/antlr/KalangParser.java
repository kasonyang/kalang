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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, OVERRIDE=7, ABSTRACT=8, 
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
		RULE_compilationUnit = 0, RULE_scriptDef = 1, RULE_classDef = 2, RULE_importDecl = 3, 
		RULE_qualifiedName = 4, RULE_classBody = 5, RULE_fieldDecl = 6, RULE_methodDecl = 7, 
		RULE_annotation = 8, RULE_type = 9, RULE_singleType = 10, RULE_classType = 11, 
		RULE_parameterizedElementType = 12, RULE_wildcardType = 13, RULE_primitiveType = 14, 
		RULE_localVarDecl = 15, RULE_ifStat = 16, RULE_stat = 17, RULE_errorousStat = 18, 
		RULE_throwStat = 19, RULE_blockStmt = 20, RULE_tryStat = 21, RULE_returnStat = 22, 
		RULE_postIfStmt = 23, RULE_varDeclStat = 24, RULE_varDecl = 25, RULE_breakStat = 26, 
		RULE_continueStat = 27, RULE_whileStat = 28, RULE_doWhileStat = 29, RULE_forStat = 30, 
		RULE_expressions = 31, RULE_exprStat = 32, RULE_expression = 33, RULE_literal = 34, 
		RULE_varModifier = 35;
	public static final String[] ruleNames = {
		"compilationUnit", "scriptDef", "classDef", "importDecl", "qualifiedName", 
		"classBody", "fieldDecl", "methodDecl", "annotation", "type", "singleType", 
		"classType", "parameterizedElementType", "wildcardType", "primitiveType", 
		"localVarDecl", "ifStat", "stat", "errorousStat", "throwStat", "blockStmt", 
		"tryStat", "returnStat", "postIfStmt", "varDeclStat", "varDecl", "breakStat", 
		"continueStat", "whileStat", "doWhileStat", "forStat", "expressions", 
		"exprStat", "expression", "literal", "varModifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'as'", "'constructor'", "'var'", "'val'", "'->'", "'override'", 
		"'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
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
		null, null, null, null, null, null, null, "OVERRIDE", "ABSTRACT", "ASSERT", 
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << STATIC) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
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
		public Token name;
		public Token prefix;
		public Token Identifier;
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
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
				type(0);
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
			setState(239);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				setState(231);
				varDecl();
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(232);
					match(COMMA);
					setState(233);
					varDecl();
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(241);
			match(RPAREN);
			setState(251);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(242);
				match(THROWS);
				setState(243);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(244);
					match(COMMA);
					setState(245);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(255);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(253);
				blockStmt();
				}
				break;
			case SEMI:
				{
				setState(254);
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
			setState(257);
			match(AT);
			setState(258);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(276);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(259);
				match(LPAREN);
				setState(273);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					{
					setState(260);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(261);
					match(ASSIGN);
					setState(262);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(263);
						match(COMMA);
						setState(264);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(265);
						match(ASSIGN);
						setState(266);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(271);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(272);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(275);
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
		public TypeContext baseType;
		public Token nullable;
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
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
			{
			setState(279);
			singleType();
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.baseType = _prevctx;
					_localctx.baseType = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(281);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(282);
					match(LBRACK);
					setState(283);
					match(RBRACK);
					}
					setState(286);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						setState(285);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class SingleTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public SingleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterSingleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitSingleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitSingleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTypeContext singleType() throws RecognitionException {
		SingleTypeContext _localctx = new SingleTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_singleType);
		try {
			setState(295);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				primitiveType();
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
		enterRule(_localctx, 22, RULE_classType);
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
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
		enterRule(_localctx, 24, RULE_parameterizedElementType);
		try {
			setState(316);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(Identifier);
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
		enterRule(_localctx, 26, RULE_wildcardType);
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
		enterRule(_localctx, 28, RULE_primitiveType);
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
		enterRule(_localctx, 30, RULE_localVarDecl);
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
		enterRule(_localctx, 32, RULE_ifStat);
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
		enterRule(_localctx, 34, RULE_stat);
		try {
			setState(355);
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
				breakStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(350);
				continueStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(351);
				returnStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(352);
				tryStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(353);
				throwStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(354);
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
		enterRule(_localctx, 36, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
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
		enterRule(_localctx, 38, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(THROW);
			setState(360);
			expression(0);
			setState(361);
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
		enterRule(_localctx, 40, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(LBRACE);
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(364);
				stat();
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
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
		public SingleTypeContext singleType;
		public List<SingleTypeContext> catchTypes = new ArrayList<SingleTypeContext>();
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
		public List<SingleTypeContext> singleType() {
			return getRuleContexts(SingleTypeContext.class);
		}
		public SingleTypeContext singleType(int i) {
			return getRuleContext(SingleTypeContext.class,i);
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
		enterRule(_localctx, 42, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(TRY);
			setState(373);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(374);
				match(CATCH);
				setState(375);
				match(LPAREN);
				setState(376);
				((TryStatContext)_localctx).singleType = singleType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).singleType);
				setState(377);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(378);
				match(RPAREN);
				setState(379);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(386);
				match(FINALLY);
				setState(387);
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
		enterRule(_localctx, 44, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(RETURN);
			setState(392);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(391);
				expression(0);
				}
			}

			setState(394);
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
		enterRule(_localctx, 46, RULE_postIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			expression(0);
			setState(397);
			match(IF);
			setState(404);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(398);
				((PostIfStmtContext)_localctx).op = match(EQUAL);
				}
				break;
			case 2:
				{
				setState(399);
				((PostIfStmtContext)_localctx).op = match(LT);
				}
				break;
			case 3:
				{
				setState(400);
				((PostIfStmtContext)_localctx).op = match(GT);
				}
				break;
			case 4:
				{
				setState(401);
				((PostIfStmtContext)_localctx).op = match(NOTEQUAL);
				}
				break;
			case 5:
				{
				setState(402);
				((PostIfStmtContext)_localctx).op = match(GE);
				}
				break;
			case 6:
				{
				setState(403);
				((PostIfStmtContext)_localctx).op = match(LE);
				}
				break;
			}
			setState(406);
			expression(0);
			setState(407);
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
		enterRule(_localctx, 48, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			localVarDecl();
			setState(410);
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
		enterRule(_localctx, 50, RULE_varDecl);
		int _la;
		try {
			setState(428);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(412);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(413);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(416);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(414);
					match(T__1);
					setState(415);
					type(0);
					}
				}

				setState(420);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(418);
					match(ASSIGN);
					setState(419);
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
				setState(422);
				((VarDeclContext)_localctx).varType = type(0);
				setState(423);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(426);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(424);
					match(ASSIGN);
					setState(425);
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
		enterRule(_localctx, 52, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			match(BREAK);
			setState(431);
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
		enterRule(_localctx, 54, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(CONTINUE);
			setState(434);
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
		enterRule(_localctx, 56, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			match(WHILE);
			setState(437);
			match(LPAREN);
			setState(438);
			expression(0);
			setState(439);
			match(RPAREN);
			setState(440);
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
		enterRule(_localctx, 58, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(DO);
			setState(443);
			blockStmt();
			setState(444);
			match(WHILE);
			setState(445);
			match(LPAREN);
			setState(446);
			expression(0);
			setState(447);
			match(RPAREN);
			setState(448);
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
		enterRule(_localctx, 60, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(FOR);
			setState(451);
			match(LPAREN);
			setState(453);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				setState(452);
				localVarDecl();
				}
			}

			setState(455);
			match(SEMI);
			setState(457);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(456);
				expression(0);
				}
			}

			setState(459);
			match(SEMI);
			setState(461);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(460);
				expressions();
				}
			}

			setState(463);
			match(RPAREN);
			setState(464);
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
			setState(466);
			expression(0);
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(467);
				match(COMMA);
				setState(468);
				expression(0);
				}
				}
				setState(473);
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
			setState(474);
			expression(0);
			setState(475);
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
	public static class ExprInvocationContext extends ExpressionContext {
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
	public static class ExprSelfRefContext extends ExpressionContext {
		public Token ref;
		public ExprSelfRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprSelfRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprSelfRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprSelfRef(this);
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
	public static class ExprInstanceOfContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INSTANCEOF() { return getToken(KalangParser.INSTANCEOF, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public ExprInstanceOfContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprInstanceOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprInstanceOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprInstanceOf(this);
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
		public Token refKey;
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
	public static class ExprIncContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprIncContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprInc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprInc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprInc(this);
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
	public static class ListExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterListExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitListExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitListExpr(this);
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
		public ExpressionContext size;
		public ExpressionContext expression;
		public List<ExpressionContext> initExpr = new ArrayList<ExpressionContext>();
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
	public static class ExprIncPreContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprIncPreContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).enterExprIncPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangListener ) ((KalangListener)listener).exitExprIncPre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangVisitor ) return ((KalangVisitor<? extends T>)visitor).visitExprIncPre(this);
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
			setState(597);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(478);
				match(LPAREN);
				setState(479);
				type(0);
				setState(480);
				match(RPAREN);
				setState(481);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(483);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(484);
				expression(17);
				}
				break;
			case 3:
				{
				_localctx = new ExprIncPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(485);
				((ExprIncPreContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((ExprIncPreContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(486);
				expression(16);
				}
				break;
			case 4:
				{
				_localctx = new ExprSelfOpPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(487);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(488);
				expression(15);
				}
				break;
			case 5:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489);
				match(LPAREN);
				setState(490);
				expression(0);
				setState(491);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new ExprSelfRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				((ExprSelfRefContext)_localctx).ref = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUPER || _la==THIS) ) {
					((ExprSelfRefContext)_localctx).ref = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 7:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(494);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(495);
					match(LT);
					setState(496);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(497);
					match(COMMA);
					setState(498);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(499);
					match(GT);
					}
				}

				setState(520);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(502);
					match(LBRACK);
					setState(503);
					((MapExprContext)_localctx).Identifier = match(Identifier);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
					setState(504);
					match(COLON);
					setState(505);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(506);
						match(COMMA);
						setState(507);
						((MapExprContext)_localctx).Identifier = match(Identifier);
						((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
						setState(508);
						match(COLON);
						setState(509);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
						}
						}
						setState(514);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(515);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(517);
					match(LBRACK);
					setState(518);
					match(COLON);
					setState(519);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(525);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(522);
					match(LT);
					setState(523);
					match(Identifier);
					setState(524);
					match(GT);
					}
				}

				setState(527);
				match(LBRACK);
				setState(536);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(528);
					expression(0);
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(529);
						match(COMMA);
						setState(530);
						expression(0);
						}
						}
						setState(535);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(538);
				match(RBRACK);
				}
				break;
			case 10:
				{
				_localctx = new ExprMemberInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(542);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(539);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(540);
					((ExprMemberInvocationContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(541);
					((ExprMemberInvocationContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(544);
				match(LPAREN);
				setState(553);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(545);
					((ExprMemberInvocationContext)_localctx).expression = expression(0);
					((ExprMemberInvocationContext)_localctx).params.add(((ExprMemberInvocationContext)_localctx).expression);
					setState(550);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(546);
						match(COMMA);
						setState(547);
						((ExprMemberInvocationContext)_localctx).expression = expression(0);
						((ExprMemberInvocationContext)_localctx).params.add(((ExprMemberInvocationContext)_localctx).expression);
						}
						}
						setState(552);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(555);
				match(RPAREN);
				}
				break;
			case 11:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(556);
				match(NEW);
				setState(557);
				classType();
				setState(558);
				match(LPAREN);
				setState(567);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(559);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(564);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(560);
						match(COMMA);
						setState(561);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
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
			case 12:
				{
				_localctx = new ExprNewArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(594);
				switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
				case 1:
					{
					setState(571);
					match(NEW);
					setState(572);
					singleType();
					setState(573);
					match(LBRACK);
					setState(574);
					((ExprNewArrayContext)_localctx).size = expression(0);
					setState(575);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(577);
					match(NEW);
					setState(578);
					singleType();
					setState(579);
					match(LBRACK);
					setState(580);
					match(RBRACK);
					setState(581);
					match(LBRACE);
					setState(590);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						setState(582);
						((ExprNewArrayContext)_localctx).expression = expression(0);
						((ExprNewArrayContext)_localctx).initExpr.add(((ExprNewArrayContext)_localctx).expression);
						setState(587);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(583);
							match(COMMA);
							setState(584);
							((ExprNewArrayContext)_localctx).expression = expression(0);
							((ExprNewArrayContext)_localctx).initExpr.add(((ExprNewArrayContext)_localctx).expression);
							}
							}
							setState(589);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(592);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case 13:
				{
				_localctx = new ExprIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(596);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(675);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(673);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(599);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(600);
						_la = _input.LA(1);
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (MUL - 90)) | (1L << (DIV - 90)) | (1L << (MOD - 90)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(601);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(602);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(603);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(604);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(605);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(613);
						switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
						case 1:
							{
							setState(606);
							match(LT);
							setState(607);
							match(LT);
							}
							break;
						case 2:
							{
							setState(608);
							match(GT);
							setState(609);
							match(GT);
							setState(610);
							match(GT);
							}
							break;
						case 3:
							{
							setState(611);
							match(GT);
							setState(612);
							match(GT);
							}
							break;
						}
						setState(615);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(616);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(617);
						_la = _input.LA(1);
						if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (GT - 74)) | (1L << (LT - 74)) | (1L << (LE - 74)) | (1L << (GE - 74)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(618);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(619);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(620);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(621);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(622);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(623);
						match(BITAND);
						setState(624);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(625);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(626);
						match(CARET);
						setState(627);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(628);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(629);
						match(BITOR);
						setState(630);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExprMidOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(631);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(632);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(633);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExprQuestionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(634);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(635);
						match(QUESTION);
						setState(636);
						expression(0);
						setState(637);
						match(COLON);
						setState(638);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExprAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(640);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(641);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ASSIGN - 73)) | (1L << (ADD_ASSIGN - 73)) | (1L << (SUB_ASSIGN - 73)) | (1L << (MUL_ASSIGN - 73)) | (1L << (DIV_ASSIGN - 73)) | (1L << (AND_ASSIGN - 73)) | (1L << (OR_ASSIGN - 73)) | (1L << (XOR_ASSIGN - 73)) | (1L << (MOD_ASSIGN - 73)) | (1L << (LSHIFT_ASSIGN - 73)) | (1L << (RSHIFT_ASSIGN - 73)) | (1L << (URSHIFT_ASSIGN - 73)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(642);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new ExprInvocationContext(new ExpressionContext(_parentctx, _parentState));
						((ExprInvocationContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(643);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(644);
						((ExprInvocationContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==DOT) ) {
							((ExprInvocationContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(645);
						match(Identifier);
						setState(646);
						match(LPAREN);
						setState(655);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(647);
							((ExprInvocationContext)_localctx).expression = expression(0);
							((ExprInvocationContext)_localctx).params.add(((ExprInvocationContext)_localctx).expression);
							setState(652);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(648);
								match(COMMA);
								setState(649);
								((ExprInvocationContext)_localctx).expression = expression(0);
								((ExprInvocationContext)_localctx).params.add(((ExprInvocationContext)_localctx).expression);
								}
								}
								setState(654);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(657);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new ExprGetFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(658);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(659);
						((ExprGetFieldContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==DOT) ) {
							((ExprGetFieldContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(660);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExprGetArrayElementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(661);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(662);
						match(LBRACK);
						setState(663);
						expression(0);
						setState(664);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new ExprIncContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(666);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(667);
						((ExprIncContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((ExprIncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					case 16:
						{
						_localctx = new ExprInstanceOfContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(668);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(669);
						match(INSTANCEOF);
						setState(670);
						match(Identifier);
						}
						break;
					case 17:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(671);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(672);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(677);
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
			setState(687);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(678);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(679);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(680);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(681);
				match(StringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(682);
				match(BooleanLiteral);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(683);
				match(Identifier);
				setState(684);
				match(DOT);
				setState(685);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(686);
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
			setState(690); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(689);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(692); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3r\u02b9\4\2\t\2\4"+
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
		"\t\3\t\5\t\u00e7\n\t\3\t\3\t\3\t\3\t\7\t\u00ed\n\t\f\t\16\t\u00f0\13\t"+
		"\5\t\u00f2\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f9\n\t\f\t\16\t\u00fc\13\t\5"+
		"\t\u00fe\n\t\3\t\3\t\5\t\u0102\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\7\n\u010e\n\n\f\n\16\n\u0111\13\n\3\n\5\n\u0114\n\n\3\n\5\n\u0117"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0121\n\13\7\13\u0123"+
		"\n\13\f\13\16\13\u0126\13\13\3\f\3\f\5\f\u012a\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\7\r\u0131\n\r\f\r\16\r\u0134\13\r\3\r\3\r\5\r\u0138\n\r\3\r\5\r\u013b"+
		"\n\r\3\16\3\16\5\16\u013f\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\7\21\u014a\n\21\f\21\16\21\u014d\13\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0156\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0166\n\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\7\26\u0170\n\26\f\26\16\26\u0173\13\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0180\n\27\f\27\16\27\u0183\13"+
		"\27\3\27\3\27\5\27\u0187\n\27\3\30\3\30\5\30\u018b\n\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0197\n\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u01a3\n\33\3\33\3\33\5\33\u01a7\n"+
		"\33\3\33\3\33\3\33\3\33\5\33\u01ad\n\33\5\33\u01af\n\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \5 \u01c8\n \3 \3 \5 \u01cc\n \3 \3 \5 \u01d0"+
		"\n \3 \3 \3 \3!\3!\3!\7!\u01d8\n!\f!\16!\u01db\13!\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01f7"+
		"\n#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0201\n#\f#\16#\u0204\13#\3#\3#\3#\3#\3"+
		"#\5#\u020b\n#\3#\3#\3#\5#\u0210\n#\3#\3#\3#\3#\7#\u0216\n#\f#\16#\u0219"+
		"\13#\5#\u021b\n#\3#\3#\3#\3#\5#\u0221\n#\3#\3#\3#\3#\7#\u0227\n#\f#\16"+
		"#\u022a\13#\5#\u022c\n#\3#\3#\3#\3#\3#\3#\3#\7#\u0235\n#\f#\16#\u0238"+
		"\13#\5#\u023a\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u024c"+
		"\n#\f#\16#\u024f\13#\5#\u0251\n#\3#\3#\5#\u0255\n#\3#\5#\u0258\n#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0268\n#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\7#\u028d\n#\f#\16#\u0290\13#\5#\u0292\n#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u02a4\n#\f#\16#\u02a7\13#\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u02b2\n$\3%\6%\u02b5\n%\r%\16%\u02b6\3%\2\4"+
		"\24D&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFH\2\20\4\2\32\32\61\61\n\2\f\f\16\16\21\21\27\27\35\35$$&&99\3\2\6"+
		"\7\3\2Z[\3\2XY\3\2NO\4\2\61\61\64\64\4\2\\]aa\4\2LMST\4\2RRUU\3\2VW\4"+
		"\2KKbl\4\2\b\bJJ\5\2\33\33*,//\u031a\2M\3\2\2\2\4X\3\2\2\2\6^\3\2\2\2"+
		"\b\u00ae\3\2\2\2\n\u00b2\3\2\2\2\f\u00bd\3\2\2\2\16\u00c7\3\2\2\2\20\u00d6"+
		"\3\2\2\2\22\u0103\3\2\2\2\24\u0118\3\2\2\2\26\u0129\3\2\2\2\30\u012b\3"+
		"\2\2\2\32\u013e\3\2\2\2\34\u0140\3\2\2\2\36\u0144\3\2\2\2 \u0146\3\2\2"+
		"\2\"\u014e\3\2\2\2$\u0165\3\2\2\2&\u0167\3\2\2\2(\u0169\3\2\2\2*\u016d"+
		"\3\2\2\2,\u0176\3\2\2\2.\u0188\3\2\2\2\60\u018e\3\2\2\2\62\u019b\3\2\2"+
		"\2\64\u01ae\3\2\2\2\66\u01b0\3\2\2\28\u01b3\3\2\2\2:\u01b6\3\2\2\2<\u01bc"+
		"\3\2\2\2>\u01c4\3\2\2\2@\u01d4\3\2\2\2B\u01dc\3\2\2\2D\u0257\3\2\2\2F"+
		"\u02b1\3\2\2\2H\u02b4\3\2\2\2JL\5\b\5\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2"+
		"MN\3\2\2\2NR\3\2\2\2OM\3\2\2\2PS\5\6\4\2QS\5\4\3\2RP\3\2\2\2RQ\3\2\2\2"+
		"S\3\3\2\2\2TW\5\20\t\2UW\5$\23\2VT\3\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2"+
		"\2XY\3\2\2\2Y\5\3\2\2\2ZX\3\2\2\2[]\5\22\n\2\\[\3\2\2\2]`\3\2\2\2^\\\3"+
		"\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2ac\5H%\2ba\3\2\2\2bc\3\2\2\2cr\3\2"+
		"\2\2do\7\22\2\2ef\7M\2\2fk\7m\2\2gh\7I\2\2hj\7m\2\2ig\3\2\2\2jm\3\2\2"+
		"\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2np\7L\2\2oe\3\2\2\2op\3\2\2"+
		"\2ps\3\2\2\2qs\7%\2\2rd\3\2\2\2rq\3\2\2\2sv\3\2\2\2tu\7\32\2\2uw\5\30"+
		"\r\2vt\3\2\2\2vw\3\2\2\2w\u0081\3\2\2\2xy\7!\2\2y~\5\30\r\2z{\7I\2\2{"+
		"}\5\30\r\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3"+
		"\2\2\2\u0080~\3\2\2\2\u0081x\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3"+
		"\2\2\2\u0083\u0084\7D\2\2\u0084\u0085\5\f\7\2\u0085\u0086\7E\2\2\u0086"+
		"\7\3\2\2\2\u0087\u0089\7\"\2\2\u0088\u008a\7\3\2\2\u0089\u0088\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0090\7m\2\2\u008c\u008d"+
		"\7\3\2\2\u008d\u008f\7m\2\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u009a\7\3\2\2\u0094\u0097\7m\2\2\u0095\u0096\7\4\2\2\u0096"+
		"\u0098\7m\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u009b\7\\\2\2\u009a\u0094\3\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\u00af\3\2\2\2\u009c\u009d\7\"\2\2\u009d\u00a2\7m\2\2\u009e\u009f\7J\2"+
		"\2\u009f\u00a1\7m\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00ac\7J\2\2\u00a6\u00a9\7m\2\2\u00a7\u00a8\7\4\2\2\u00a8\u00aa\7m\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ad"+
		"\7\\\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u0087\3\2\2\2\u00ae\u009c\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7H"+
		"\2\2\u00b1\t\3\2\2\2\u00b2\u00b7\7m\2\2\u00b3\u00b4\7J\2\2\u00b4\u00b6"+
		"\7m\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\13\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\5\16\b"+
		"\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00c3\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2\5\20\t\2"+
		"\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\r\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c8\5H%\2\u00c7\u00c6"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ce\5\64\33\2"+
		"\u00ca\u00cb\7I\2\2\u00cb\u00cd\5\64\33\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0"+
		"\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d2\7H\2\2\u00d2\17\3\2\2\2\u00d3\u00d5\5\22\n"+
		"\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00db\7\t\2\2\u00da"+
		"\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00de\7\25"+
		"\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00e1\5H%\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e6\3\2\2"+
		"\2\u00e2\u00e3\5\24\13\2\u00e3\u00e4\7m\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e7\7\5\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00f1\7B\2\2\u00e9\u00ee\5\64\33\2\u00ea\u00eb\7I\2\2\u00eb"+
		"\u00ed\5\64\33\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3"+
		"\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00e9\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00fd\7C"+
		"\2\2\u00f4\u00f5\7\66\2\2\u00f5\u00fa\7m\2\2\u00f6\u00f7\7I\2\2\u00f7"+
		"\u00f9\7m\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00f4\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u0102\5*"+
		"\26\2\u0100\u0102\7H\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102"+
		"\21\3\2\2\2\u0103\u0104\7n\2\2\u0104\u0116\7m\2\2\u0105\u0113\7B\2\2\u0106"+
		"\u0107\7m\2\2\u0107\u0108\7K\2\2\u0108\u010f\5F$\2\u0109\u010a\7I\2\2"+
		"\u010a\u010b\7m\2\2\u010b\u010c\7K\2\2\u010c\u010e\5F$\2\u010d\u0109\3"+
		"\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0114\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0114\5F$\2\u0113\u0106\3\2\2"+
		"\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117"+
		"\7C\2\2\u0116\u0105\3\2\2\2\u0116\u0117\3\2\2\2\u0117\23\3\2\2\2\u0118"+
		"\u0119\b\13\1\2\u0119\u011a\5\26\f\2\u011a\u0124\3\2\2\2\u011b\u011c\f"+
		"\3\2\2\u011c\u011d\7F\2\2\u011d\u011e\7G\2\2\u011e\u0120\3\2\2\2\u011f"+
		"\u0121\7P\2\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2"+
		"\2\2\u0122\u011b\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\25\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u012a\5\30\r"+
		"\2\u0128\u012a\5\36\20\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\27\3\2\2\2\u012b\u0137\7m\2\2\u012c\u012d\7M\2\2\u012d\u0132\5\32\16"+
		"\2\u012e\u012f\7I\2\2\u012f\u0131\5\32\16\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7L\2\2\u0136\u0138\3\2\2\2\u0137"+
		"\u012c\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u013b\7P"+
		"\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\31\3\2\2\2\u013c\u013f"+
		"\7m\2\2\u013d\u013f\5\34\17\2\u013e\u013c\3\2\2\2\u013e\u013d\3\2\2\2"+
		"\u013f\33\3\2\2\2\u0140\u0141\7P\2\2\u0141\u0142\t\2\2\2\u0142\u0143\5"+
		"\30\r\2\u0143\35\3\2\2\2\u0144\u0145\t\3\2\2\u0145\37\3\2\2\2\u0146\u014b"+
		"\5\64\33\2\u0147\u0148\7I\2\2\u0148\u014a\5\64\33\2\u0149\u0147\3\2\2"+
		"\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c!"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\7\37\2\2\u014f\u0150\7B\2\2\u0150"+
		"\u0151\5D#\2\u0151\u0152\7C\2\2\u0152\u0155\5$\23\2\u0153\u0154\7\30\2"+
		"\2\u0154\u0156\5$\23\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156#"+
		"\3\2\2\2\u0157\u0166\5*\26\2\u0158\u0166\5\62\32\2\u0159\u0166\5\60\31"+
		"\2\u015a\u0166\5B\"\2\u015b\u0166\5\"\22\2\u015c\u0166\5:\36\2\u015d\u0166"+
		"\5<\37\2\u015e\u0166\5> \2\u015f\u0166\5\66\34\2\u0160\u0166\58\35\2\u0161"+
		"\u0166\5.\30\2\u0162\u0166\5,\27\2\u0163\u0166\5(\25\2\u0164\u0166\5&"+
		"\24\2\u0165\u0157\3\2\2\2\u0165\u0158\3\2\2\2\u0165\u0159\3\2\2\2\u0165"+
		"\u015a\3\2\2\2\u0165\u015b\3\2\2\2\u0165\u015c\3\2\2\2\u0165\u015d\3\2"+
		"\2\2\u0165\u015e\3\2\2\2\u0165\u015f\3\2\2\2\u0165\u0160\3\2\2\2\u0165"+
		"\u0161\3\2\2\2\u0165\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0164\3\2"+
		"\2\2\u0166%\3\2\2\2\u0167\u0168\5D#\2\u0168\'\3\2\2\2\u0169\u016a\7\65"+
		"\2\2\u016a\u016b\5D#\2\u016b\u016c\7H\2\2\u016c)\3\2\2\2\u016d\u0171\7"+
		"D\2\2\u016e\u0170\5$\23\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0174\u0175\7E\2\2\u0175+\3\2\2\2\u0176\u0177\78\2\2\u0177\u0181"+
		"\5*\26\2\u0178\u0179\7\20\2\2\u0179\u017a\7B\2\2\u017a\u017b\5\26\f\2"+
		"\u017b\u017c\7m\2\2\u017c\u017d\7C\2\2\u017d\u017e\5*\26\2\u017e\u0180"+
		"\3\2\2\2\u017f\u0178\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0186\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0185\7\34"+
		"\2\2\u0185\u0187\5*\26\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"-\3\2\2\2\u0188\u018a\7-\2\2\u0189\u018b\5D#\2\u018a\u0189\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\7H\2\2\u018d/\3\2\2\2\u018e"+
		"\u018f\5D#\2\u018f\u0196\7\37\2\2\u0190\u0197\7R\2\2\u0191\u0197\7M\2"+
		"\2\u0192\u0197\7L\2\2\u0193\u0197\7U\2\2\u0194\u0197\7T\2\2\u0195\u0197"+
		"\7S\2\2\u0196\u0190\3\2\2\2\u0196\u0191\3\2\2\2\u0196\u0192\3\2\2\2\u0196"+
		"\u0193\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u0198\3\2\2\2\u0198\u0199\5D#\2\u0199\u019a\7H\2\2\u019a\61"+
		"\3\2\2\2\u019b\u019c\5 \21\2\u019c\u019d\7H\2\2\u019d\63\3\2\2\2\u019e"+
		"\u019f\t\4\2\2\u019f\u01a2\7m\2\2\u01a0\u01a1\7\4\2\2\u01a1\u01a3\5\24"+
		"\13\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4"+
		"\u01a5\7K\2\2\u01a5\u01a7\5D#\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2"+
		"\2\u01a7\u01af\3\2\2\2\u01a8\u01a9\5\24\13\2\u01a9\u01ac\7m\2\2\u01aa"+
		"\u01ab\7K\2\2\u01ab\u01ad\5D#\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2"+
		"\2\u01ad\u01af\3\2\2\2\u01ae\u019e\3\2\2\2\u01ae\u01a8\3\2\2\2\u01af\65"+
		"\3\2\2\2\u01b0\u01b1\7\r\2\2\u01b1\u01b2\7H\2\2\u01b2\67\3\2\2\2\u01b3"+
		"\u01b4\7\24\2\2\u01b4\u01b5\7H\2\2\u01b59\3\2\2\2\u01b6\u01b7\7;\2\2\u01b7"+
		"\u01b8\7B\2\2\u01b8\u01b9\5D#\2\u01b9\u01ba\7C\2\2\u01ba\u01bb\5$\23\2"+
		"\u01bb;\3\2\2\2\u01bc\u01bd\7\26\2\2\u01bd\u01be\5*\26\2\u01be\u01bf\7"+
		";\2\2\u01bf\u01c0\7B\2\2\u01c0\u01c1\5D#\2\u01c1\u01c2\7C\2\2\u01c2\u01c3"+
		"\7H\2\2\u01c3=\3\2\2\2\u01c4\u01c5\7\36\2\2\u01c5\u01c7\7B\2\2\u01c6\u01c8"+
		"\5 \21\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01cb\7H\2\2\u01ca\u01cc\5D#\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2"+
		"\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\7H\2\2\u01ce\u01d0\5@!\2\u01cf\u01ce"+
		"\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\7C\2\2\u01d2"+
		"\u01d3\5$\23\2\u01d3?\3\2\2\2\u01d4\u01d9\5D#\2\u01d5\u01d6\7I\2\2\u01d6"+
		"\u01d8\5D#\2\u01d7\u01d5\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2"+
		"\2\u01d9\u01da\3\2\2\2\u01daA\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01dd"+
		"\5D#\2\u01dd\u01de\7H\2\2\u01deC\3\2\2\2\u01df\u01e0\b#\1\2\u01e0\u01e1"+
		"\7B\2\2\u01e1\u01e2\5\24\13\2\u01e2\u01e3\7C\2\2\u01e3\u01e4\5D#\25\u01e4"+
		"\u0258\3\2\2\2\u01e5\u01e6\t\5\2\2\u01e6\u0258\5D#\23\u01e7\u01e8\t\6"+
		"\2\2\u01e8\u0258\5D#\22\u01e9\u01ea\t\7\2\2\u01ea\u0258\5D#\21\u01eb\u01ec"+
		"\7B\2\2\u01ec\u01ed\5D#\2\u01ed\u01ee\7C\2\2\u01ee\u0258\3\2\2\2\u01ef"+
		"\u0258\t\b\2\2\u01f0\u0258\5F$\2\u01f1\u01f2\7M\2\2\u01f2\u01f3\7m\2\2"+
		"\u01f3\u01f4\7I\2\2\u01f4\u01f5\7m\2\2\u01f5\u01f7\7L\2\2\u01f6\u01f1"+
		"\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u020a\3\2\2\2\u01f8\u01f9\7F\2\2\u01f9"+
		"\u01fa\7m\2\2\u01fa\u01fb\7Q\2\2\u01fb\u0202\5D#\2\u01fc\u01fd\7I\2\2"+
		"\u01fd\u01fe\7m\2\2\u01fe\u01ff\7Q\2\2\u01ff\u0201\5D#\2\u0200\u01fc\3"+
		"\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203"+
		"\u0205\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0206\7G\2\2\u0206\u020b\3\2"+
		"\2\2\u0207\u0208\7F\2\2\u0208\u0209\7Q\2\2\u0209\u020b\7G\2\2\u020a\u01f8"+
		"\3\2\2\2\u020a\u0207\3\2\2\2\u020b\u0258\3\2\2\2\u020c\u020d\7M\2\2\u020d"+
		"\u020e\7m\2\2\u020e\u0210\7L\2\2\u020f\u020c\3\2\2\2\u020f\u0210\3\2\2"+
		"\2\u0210\u0211\3\2\2\2\u0211\u021a\7F\2\2\u0212\u0217\5D#\2\u0213\u0214"+
		"\7I\2\2\u0214\u0216\5D#\2\u0215\u0213\3\2\2\2\u0216\u0219\3\2\2\2\u0217"+
		"\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2"+
		"\2\2\u021a\u0212\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\u0258\7G\2\2\u021d\u0221\7m\2\2\u021e\u0221\7\64\2\2\u021f\u0221\7\61"+
		"\2\2\u0220\u021d\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u021f\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u022b\7B\2\2\u0223\u0228\5D#\2\u0224\u0225\7I\2\2"+
		"\u0225\u0227\5D#\2\u0226\u0224\3\2\2\2\u0227\u022a\3\2\2\2\u0228\u0226"+
		"\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022c\3\2\2\2\u022a\u0228\3\2\2\2\u022b"+
		"\u0223\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u0258\7C"+
		"\2\2\u022e\u022f\7(\2\2\u022f\u0230\5\30\r\2\u0230\u0239\7B\2\2\u0231"+
		"\u0236\5D#\2\u0232\u0233\7I\2\2\u0233\u0235\5D#\2\u0234\u0232\3\2\2\2"+
		"\u0235\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u023a"+
		"\3\2\2\2\u0238\u0236\3\2\2\2\u0239\u0231\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"\u023b\3\2\2\2\u023b\u023c\7C\2\2\u023c\u0258\3\2\2\2\u023d\u023e\7(\2"+
		"\2\u023e\u023f\5\26\f\2\u023f\u0240\7F\2\2\u0240\u0241\5D#\2\u0241\u0242"+
		"\7G\2\2\u0242\u0255\3\2\2\2\u0243\u0244\7(\2\2\u0244\u0245\5\26\f\2\u0245"+
		"\u0246\7F\2\2\u0246\u0247\7G\2\2\u0247\u0250\7D\2\2\u0248\u024d\5D#\2"+
		"\u0249\u024a\7I\2\2\u024a\u024c\5D#\2\u024b\u0249\3\2\2\2\u024c\u024f"+
		"\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0251\3\2\2\2\u024f"+
		"\u024d\3\2\2\2\u0250\u0248\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2"+
		"\2\2\u0252\u0253\7E\2\2\u0253\u0255\3\2\2\2\u0254\u023d\3\2\2\2\u0254"+
		"\u0243\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0258\7m\2\2\u0257\u01df\3\2"+
		"\2\2\u0257\u01e5\3\2\2\2\u0257\u01e7\3\2\2\2\u0257\u01e9\3\2\2\2\u0257"+
		"\u01eb\3\2\2\2\u0257\u01ef\3\2\2\2\u0257\u01f0\3\2\2\2\u0257\u01f6\3\2"+
		"\2\2\u0257\u020f\3\2\2\2\u0257\u0220\3\2\2\2\u0257\u022e\3\2\2\2\u0257"+
		"\u0254\3\2\2\2\u0257\u0256\3\2\2\2\u0258\u02a5\3\2\2\2\u0259\u025a\f\20"+
		"\2\2\u025a\u025b\t\t\2\2\u025b\u02a4\5D#\21\u025c\u025d\f\17\2\2\u025d"+
		"\u025e\t\5\2\2\u025e\u02a4\5D#\20\u025f\u0267\f\16\2\2\u0260\u0261\7M"+
		"\2\2\u0261\u0268\7M\2\2\u0262\u0263\7L\2\2\u0263\u0264\7L\2\2\u0264\u0268"+
		"\7L\2\2\u0265\u0266\7L\2\2\u0266\u0268\7L\2\2\u0267\u0260\3\2\2\2\u0267"+
		"\u0262\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u02a4\5D"+
		"#\17\u026a\u026b\f\r\2\2\u026b\u026c\t\n\2\2\u026c\u02a4\5D#\16\u026d"+
		"\u026e\f\13\2\2\u026e\u026f\t\13\2\2\u026f\u02a4\5D#\f\u0270\u0271\f\n"+
		"\2\2\u0271\u0272\7^\2\2\u0272\u02a4\5D#\13\u0273\u0274\f\t\2\2\u0274\u0275"+
		"\7`\2\2\u0275\u02a4\5D#\n\u0276\u0277\f\b\2\2\u0277\u0278\7_\2\2\u0278"+
		"\u02a4\5D#\t\u0279\u027a\f\7\2\2\u027a\u027b\t\f\2\2\u027b\u02a4\5D#\b"+
		"\u027c\u027d\f\6\2\2\u027d\u027e\7P\2\2\u027e\u027f\5D#\2\u027f\u0280"+
		"\7Q\2\2\u0280\u0281\5D#\7\u0281\u02a4\3\2\2\2\u0282\u0283\f\3\2\2\u0283"+
		"\u0284\t\r\2\2\u0284\u02a4\5D#\3\u0285\u0286\f\33\2\2\u0286\u0287\t\16"+
		"\2\2\u0287\u0288\7m\2\2\u0288\u0291\7B\2\2\u0289\u028e\5D#\2\u028a\u028b"+
		"\7I\2\2\u028b\u028d\5D#\2\u028c\u028a\3\2\2\2\u028d\u0290\3\2\2\2\u028e"+
		"\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2"+
		"\2\2\u0291\u0289\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293"+
		"\u02a4\7C\2\2\u0294\u0295\f\32\2\2\u0295\u0296\t\16\2\2\u0296\u02a4\7"+
		"m\2\2\u0297\u0298\f\30\2\2\u0298\u0299\7F\2\2\u0299\u029a\5D#\2\u029a"+
		"\u029b\7G\2\2\u029b\u02a4\3\2\2\2\u029c\u029d\f\24\2\2\u029d\u02a4\t\6"+
		"\2\2\u029e\u029f\f\f\2\2\u029f\u02a0\7#\2\2\u02a0\u02a4\7m\2\2\u02a1\u02a2"+
		"\f\4\2\2\u02a2\u02a4\7J\2\2\u02a3\u0259\3\2\2\2\u02a3\u025c\3\2\2\2\u02a3"+
		"\u025f\3\2\2\2\u02a3\u026a\3\2\2\2\u02a3\u026d\3\2\2\2\u02a3\u0270\3\2"+
		"\2\2\u02a3\u0273\3\2\2\2\u02a3\u0276\3\2\2\2\u02a3\u0279\3\2\2\2\u02a3"+
		"\u027c\3\2\2\2\u02a3\u0282\3\2\2\2\u02a3\u0285\3\2\2\2\u02a3\u0294\3\2"+
		"\2\2\u02a3\u0297\3\2\2\2\u02a3\u029c\3\2\2\2\u02a3\u029e\3\2\2\2\u02a3"+
		"\u02a1\3\2\2\2\u02a4\u02a7\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2"+
		"\2\2\u02a6E\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a8\u02b2\7<\2\2\u02a9\u02b2"+
		"\7=\2\2\u02aa\u02b2\7?\2\2\u02ab\u02b2\7@\2\2\u02ac\u02b2\7>\2\2\u02ad"+
		"\u02ae\7m\2\2\u02ae\u02af\7J\2\2\u02af\u02b2\7\22\2\2\u02b0\u02b2\7A\2"+
		"\2\u02b1\u02a8\3\2\2\2\u02b1\u02a9\3\2\2\2\u02b1\u02aa\3\2\2\2\u02b1\u02ab"+
		"\3\2\2\2\u02b1\u02ac\3\2\2\2\u02b1\u02ad\3\2\2\2\u02b1\u02b0\3\2\2\2\u02b2"+
		"G\3\2\2\2\u02b3\u02b5\t\17\2\2\u02b4\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2"+
		"\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7I\3\2\2\2UMRVX^bkorv~\u0081"+
		"\u0089\u0090\u0097\u009a\u00a2\u00a9\u00ac\u00ae\u00b7\u00bd\u00c3\u00c7"+
		"\u00ce\u00d6\u00da\u00dd\u00e0\u00e6\u00ee\u00f1\u00fa\u00fd\u0101\u010f"+
		"\u0113\u0116\u0120\u0124\u0129\u0132\u0137\u013a\u013e\u014b\u0155\u0165"+
		"\u0171\u0181\u0186\u018a\u0196\u01a2\u01a6\u01ac\u01ae\u01c7\u01cb\u01cf"+
		"\u01d9\u01f6\u0202\u020a\u020f\u0217\u021a\u0220\u0228\u022b\u0236\u0239"+
		"\u024d\u0250\u0254\u0257\u0267\u028e\u0291\u02a3\u02a5\u02b1\u02b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
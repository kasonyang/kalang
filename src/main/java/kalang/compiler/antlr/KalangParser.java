// Generated from KalangParser.g4 by ANTLR 4.7.2
package kalang.compiler.antlr;
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOUBLE_COLON=1, AS=2, IN=3, CONSTRUCTOR=4, VAR=5, VAL=6, FOREACH=7, ARROW=8, 
		LAMBDA_ARROW=9, DYNAMIC=10, STAR_DOT=11, STAR_DYNAMIC=12, QUESTION_DOT=13, 
		DOUBLE_QUESTION=14, QUESTION_DOTDOT=15, QUESTION_DYNAMIC=16, OVERRIDE=17, 
		ABSTRACT=18, ASSERT=19, BOOLEAN=20, BREAK=21, BYTE=22, CASE=23, CATCH=24, 
		CHAR=25, CLASS=26, CONST=27, CONTINUE=28, DEFAULT=29, DO=30, DOUBLE=31, 
		ELSE=32, ENUM=33, EXTENDS=34, FINAL=35, FINALLY=36, FLOAT=37, FOR=38, 
		IF=39, GOTO=40, IMPLEMENTS=41, IMPORT=42, INSTANCEOF=43, INT=44, INTERFACE=45, 
		LONG=46, NATIVE=47, NEW=48, PACKAGE=49, PRIVATE=50, PROTECTED=51, PUBLIC=52, 
		RETURN=53, SHORT=54, STATIC=55, STRICTFP=56, SUPER=57, SWITCH=58, SYNCHRONIZED=59, 
		THIS=60, THROW=61, THROWS=62, TRANSIENT=63, TRY=64, VOID=65, VOLATILE=66, 
		WHILE=67, MIXIN=68, WITH=69, IntegerLiteral=70, FloatingPointLiteral=71, 
		BooleanLiteral=72, CharacterLiteral=73, StringLiteral=74, MultiLineStringLiteral=75, 
		NullLiteral=76, LPAREN=77, RPAREN=78, LBRACE=79, RBRACE=80, LBRACK=81, 
		RBRACK=82, SEMI=83, COMMA=84, DOT=85, DOTDOT=86, ASSIGN=87, GT=88, LT=89, 
		BANG=90, TILDE=91, QUESTION=92, COLON=93, EQUAL=94, SAME=95, LE=96, GE=97, 
		NOTEQUAL=98, NOTSAME=99, AND=100, OR=101, INC=102, DEC=103, ADD=104, SUB=105, 
		MUL=106, DIV=107, BITAND=108, BITOR=109, CARET=110, MOD=111, ADD_ASSIGN=112, 
		SUB_ASSIGN=113, MUL_ASSIGN=114, DIV_ASSIGN=115, AND_ASSIGN=116, OR_ASSIGN=117, 
		XOR_ASSIGN=118, MOD_ASSIGN=119, LSHIFT_ASSIGN=120, RSHIFT_ASSIGN=121, 
		URSHIFT_ASSIGN=122, InterpolationPreffixString=123, Identifier=124, AT=125, 
		ELLIPSIS=126, COMPILE_OPTION_LINE=127, WS=128, COMMENT=129, LINE_COMMENT=130, 
		PACKAGE_DELIMITER=131, UNKNOWN_CHAR=132, INTERPOLATION_INTERUPT=133, INTERPOLATION_END=134, 
		INTERPOLATION_STRING=135;
	public static final int
		RULE_compilationUnit = 0, RULE_compileOption = 1, RULE_scriptDef = 2, 
		RULE_classDef = 3, RULE_importDecl = 4, RULE_qualifiedName = 5, RULE_classBody = 6, 
		RULE_fieldDecl = 7, RULE_methodDecl = 8, RULE_paramDecl = 9, RULE_annotation = 10, 
		RULE_type = 11, RULE_classType = 12, RULE_lambdaType = 13, RULE_parameterizedElementType = 14, 
		RULE_wildcardType = 15, RULE_primitiveType = 16, RULE_localVarDecl = 17, 
		RULE_destructuringLocalVarDecl = 18, RULE_ifStat = 19, RULE_stat = 20, 
		RULE_emptyStat = 21, RULE_errorousStat = 22, RULE_assertStmt = 23, RULE_throwStat = 24, 
		RULE_blockStmt = 25, RULE_tryStat = 26, RULE_returnStat = 27, RULE_varDeclStat = 28, 
		RULE_varDecl = 29, RULE_breakStat = 30, RULE_continueStat = 31, RULE_whileStat = 32, 
		RULE_doWhileStat = 33, RULE_forStat = 34, RULE_forEachStat = 35, RULE_expressions = 36, 
		RULE_exprStat = 37, RULE_expression = 38, RULE_literal = 39, RULE_varModifier = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "compileOption", "scriptDef", "classDef", "importDecl", 
			"qualifiedName", "classBody", "fieldDecl", "methodDecl", "paramDecl", 
			"annotation", "type", "classType", "lambdaType", "parameterizedElementType", 
			"wildcardType", "primitiveType", "localVarDecl", "destructuringLocalVarDecl", 
			"ifStat", "stat", "emptyStat", "errorousStat", "assertStmt", "throwStat", 
			"blockStmt", "tryStat", "returnStat", "varDeclStat", "varDecl", "breakStat", 
			"continueStat", "whileStat", "doWhileStat", "forStat", "forEachStat", 
			"expressions", "exprStat", "expression", "literal", "varModifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'::'", "'as'", "'in'", "'constructor'", "'var'", "'val'", "'foreach'", 
			"'->'", "'=>'", "'->>'", "'*.'", "'*->>'", "'?.'", "'??'", "'?..'", "'?->>'", 
			"'override'", "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", 
			"'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
			"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
			"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
			"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
			"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
			"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
			"'transient'", "'try'", "'void'", "'volatile'", "'while'", "'mixin'", 
			"'with'", null, null, null, null, null, null, "'null'", "'('", "')'", 
			"'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'..'", "'='", "'>'", 
			"'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'==='", "'<='", "'>='", "'!='", 
			"'!=='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", 
			"'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
			"'^='", "'%='", "'<<='", "'>>='", "'>>>='", null, null, "'@'", "'...'", 
			null, null, null, null, "'\\'", null, "'${'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOUBLE_COLON", "AS", "IN", "CONSTRUCTOR", "VAR", "VAL", "FOREACH", 
			"ARROW", "LAMBDA_ARROW", "DYNAMIC", "STAR_DOT", "STAR_DYNAMIC", "QUESTION_DOT", 
			"DOUBLE_QUESTION", "QUESTION_DOTDOT", "QUESTION_DYNAMIC", "OVERRIDE", 
			"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", 
			"CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", 
			"EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", 
			"IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", 
			"PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", 
			"STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", 
			"TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "MIXIN", "WITH", "IntegerLiteral", 
			"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
			"MultiLineStringLiteral", "NullLiteral", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "DOTDOT", "ASSIGN", 
			"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "SAME", "LE", 
			"GE", "NOTEQUAL", "NOTSAME", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
			"MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
			"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "InterpolationPreffixString", 
			"Identifier", "AT", "ELLIPSIS", "COMPILE_OPTION_LINE", "WS", "COMMENT", 
			"LINE_COMMENT", "PACKAGE_DELIMITER", "UNKNOWN_CHAR", "INTERPOLATION_INTERUPT", 
			"INTERPOLATION_END", "INTERPOLATION_STRING"
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
	public String getGrammarFileName() { return "KalangParser.g4"; }

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
		public List<CompileOptionContext> compileOption() {
			return getRuleContexts(CompileOptionContext.class);
		}
		public CompileOptionContext compileOption(int i) {
			return getRuleContext(CompileOptionContext.class,i);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitCompilationUnit(this);
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPILE_OPTION_LINE) {
				{
				{
				setState(82);
				compileOption();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(88);
				importDecl();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(94);
				classDef();
				}
				break;
			case 2:
				{
				setState(95);
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

	public static class CompileOptionContext extends ParserRuleContext {
		public TerminalNode COMPILE_OPTION_LINE() { return getToken(KalangParser.COMPILE_OPTION_LINE, 0); }
		public CompileOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterCompileOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitCompileOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitCompileOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileOptionContext compileOption() throws RecognitionException {
		CompileOptionContext _localctx = new CompileOptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_compileOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(COMPILE_OPTION_LINE);
			}
		}
		catch (RecognitionException re) {
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
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public ScriptDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterScriptDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitScriptDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitScriptDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptDefContext scriptDef() throws RecognitionException {
		ScriptDefContext _localctx = new ScriptDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_scriptDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << SUPER) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRANSIENT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (VOLATILE - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(100);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(101);
					stat();
					}
					break;
				case 3:
					{
					setState(102);
					classDef();
					}
					break;
				}
				}
				setState(107);
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
		public Token name;
		public ClassTypeContext parentClass;
		public ClassTypeContext classType;
		public List<ClassTypeContext> interfaces = new ArrayList<ClassTypeContext>();
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(KalangParser.CLASS, 0); }
		public TerminalNode INTERFACE() { return getToken(KalangParser.INTERFACE, 0); }
		public TerminalNode EXTENDS() { return getToken(KalangParser.EXTENDS, 0); }
		public TerminalNode IMPLEMENTS() { return getToken(KalangParser.IMPLEMENTS, 0); }
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(108);
				annotation();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) {
				{
				setState(114);
				varModifier();
				}
			}

			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(117);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(118);
					match(LT);
					setState(119);
					((ClassDefContext)_localctx).Identifier = match(Identifier);
					((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(120);
						match(COMMA);
						setState(121);
						((ClassDefContext)_localctx).Identifier = match(Identifier);
						((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
						}
						}
						setState(126);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(127);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(130);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(133);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(136);
				match(EXTENDS);
				setState(137);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(140);
				match(IMPLEMENTS);
				setState(141);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(142);
					match(COMMA);
					setState(143);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(151);
			match(LBRACE);
			setState(152);
			classBody();
			setState(153);
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
		public Token importMode;
		public Token root;
		public Token Identifier;
		public List<Token> path = new ArrayList<Token>();
		public Token delim;
		public Token name;
		public Token alias;
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public TerminalNode IMPORT() { return getToken(KalangParser.IMPORT, 0); }
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<TerminalNode> PACKAGE_DELIMITER() { return getTokens(KalangParser.PACKAGE_DELIMITER); }
		public TerminalNode PACKAGE_DELIMITER(int i) {
			return getToken(KalangParser.PACKAGE_DELIMITER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(KalangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(KalangParser.DOT, i);
		}
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
		public TerminalNode MIXIN() { return getToken(KalangParser.MIXIN, 0); }
		public TerminalNode MUL() { return getToken(KalangParser.MUL, 0); }
		public TerminalNode AS() { return getToken(KalangParser.AS, 0); }
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitImportDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitImportDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(155);
				match(IMPORT);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC || _la==MIXIN) {
					{
					setState(156);
					((ImportDeclContext)_localctx).importMode = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==STATIC || _la==MIXIN) ) {
						((ImportDeclContext)_localctx).importMode = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PACKAGE_DELIMITER) {
					{
					setState(159);
					((ImportDeclContext)_localctx).root = match(PACKAGE_DELIMITER);
					}
				}

				setState(162);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(163);
						match(PACKAGE_DELIMITER);
						setState(164);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(169);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(170);
				((ImportDeclContext)_localctx).delim = match(PACKAGE_DELIMITER);
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(171);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(172);
						match(AS);
						setState(173);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(176);
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
				setState(179);
				match(IMPORT);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC || _la==MIXIN) {
					{
					setState(180);
					((ImportDeclContext)_localctx).importMode = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==STATIC || _la==MIXIN) ) {
						((ImportDeclContext)_localctx).importMode = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(183);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(184);
						match(DOT);
						setState(185);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(190);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(191);
				((ImportDeclContext)_localctx).delim = match(DOT);
				setState(198);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(192);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(193);
						match(AS);
						setState(194);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(197);
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
			setState(202);
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
		public List<TerminalNode> DOT() { return getTokens(KalangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(KalangParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(Identifier);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(205);
				match(DOT);
				setState(206);
				match(Identifier);
				}
				}
				setState(211);
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
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (VOLATILE - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)) | (1L << (AT - 65)))) != 0)) {
				{
				setState(215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(212);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(213);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(214);
					classDef();
					}
					break;
				}
				}
				setState(219);
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
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public VarModifierContext varModifier() {
			return getRuleContext(VarModifierContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitFieldDecl(this);
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
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) {
				{
				setState(220);
				varModifier();
				}
			}

			setState(223);
			varDecl();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(224);
				match(COMMA);
				setState(225);
				varDecl();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
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
		public ParamDeclContext paramDecl;
		public List<ParamDeclContext> params = new ArrayList<ParamDeclContext>();
		public Token Identifier;
		public List<Token> exceptionTypes = new ArrayList<Token>();
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
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
		public TerminalNode THROWS() { return getToken(KalangParser.THROWS, 0); }
		public List<ParamDeclContext> paramDecl() {
			return getRuleContexts(ParamDeclContext.class);
		}
		public ParamDeclContext paramDecl(int i) {
			return getRuleContext(ParamDeclContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CONSTRUCTOR() { return getToken(KalangParser.CONSTRUCTOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(233);
				annotation();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(239);
				match(OVERRIDE);
				}
			}

			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(242);
				match(DEFAULT);
				}
			}

			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) {
				{
				setState(245);
				varModifier();
				}
			}

			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case BITAND:
			case Identifier:
				{
				{
				setState(248);
				((MethodDeclContext)_localctx).returnType = type(0);
				setState(249);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case CONSTRUCTOR:
				{
				{
				setState(251);
				((MethodDeclContext)_localctx).prefix = match(CONSTRUCTOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(254);
			match(LPAREN);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(255);
				((MethodDeclContext)_localctx).paramDecl = paramDecl();
				((MethodDeclContext)_localctx).params.add(((MethodDeclContext)_localctx).paramDecl);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(256);
					match(COMMA);
					setState(257);
					((MethodDeclContext)_localctx).paramDecl = paramDecl();
					((MethodDeclContext)_localctx).params.add(((MethodDeclContext)_localctx).paramDecl);
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(265);
			match(RPAREN);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(266);
				match(THROWS);
				setState(267);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(268);
					match(COMMA);
					setState(269);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(277);
				blockStmt();
				}
				break;
			case SEMI:
				{
				setState(278);
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

	public static class ParamDeclContext extends ParserRuleContext {
		public TypeContext paramType;
		public Token VARARGS;
		public Token paramId;
		public ExpressionContext paramDefVal;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(KalangParser.ASSIGN, 0); }
		public TerminalNode ELLIPSIS() { return getToken(KalangParser.ELLIPSIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParamDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterParamDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitParamDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitParamDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamDeclContext paramDecl() throws RecognitionException {
		ParamDeclContext _localctx = new ParamDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_paramDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((ParamDeclContext)_localctx).paramType = type(0);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELLIPSIS) {
				{
				setState(282);
				((ParamDeclContext)_localctx).VARARGS = match(ELLIPSIS);
				}
			}

			setState(285);
			((ParamDeclContext)_localctx).paramId = match(Identifier);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(286);
				match(ASSIGN);
				setState(287);
				((ParamDeclContext)_localctx).paramDefVal = expression(0);
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

	public static class AnnotationContext extends ParserRuleContext {
		public Token annotationType;
		public Token Identifier;
		public List<Token> annotationValueKey = new ArrayList<Token>();
		public LiteralContext literal;
		public List<LiteralContext> annotationValue = new ArrayList<LiteralContext>();
		public LiteralContext annotationDefaultValue;
		public TerminalNode AT() { return getToken(KalangParser.AT, 0); }
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(KalangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(KalangParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(AT);
			setState(291);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(292);
				match(LPAREN);
				setState(306);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					{
					setState(293);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(294);
					match(ASSIGN);
					setState(295);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(296);
						match(COMMA);
						setState(297);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(298);
						match(ASSIGN);
						setState(299);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(304);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(305);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(308);
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
		public TerminalNode LBRACK() { return getToken(KalangParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(KalangParser.RBRACK, 0); }
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitType(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BITAND:
			case Identifier:
				{
				setState(312);
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
			case SHORT:
			case VOID:
				{
				setState(313);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(316);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(317);
					match(LBRACK);
					setState(318);
					match(RBRACK);
					setState(320);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						setState(319);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		public Token Identifier;
		public List<Token> paths = new ArrayList<Token>();
		public Token rawClass;
		public ParameterizedElementTypeContext parameterizedElementType;
		public List<ParameterizedElementTypeContext> parameterTypes = new ArrayList<ParameterizedElementTypeContext>();
		public Token nullable;
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<TerminalNode> PACKAGE_DELIMITER() { return getTokens(KalangParser.PACKAGE_DELIMITER); }
		public TerminalNode PACKAGE_DELIMITER(int i) {
			return getToken(KalangParser.PACKAGE_DELIMITER, i);
		}
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public List<ParameterizedElementTypeContext> parameterizedElementType() {
			return getRuleContexts(ParameterizedElementTypeContext.class);
		}
		public ParameterizedElementTypeContext parameterizedElementType(int i) {
			return getRuleContext(ParameterizedElementTypeContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public LambdaTypeContext lambdaType() {
			return getRuleContext(LambdaTypeContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classType);
		int _la;
		try {
			int _alt;
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(327);
						((ClassTypeContext)_localctx).Identifier = match(Identifier);
						((ClassTypeContext)_localctx).paths.add(((ClassTypeContext)_localctx).Identifier);
						setState(328);
						match(PACKAGE_DELIMITER);
						}
						} 
					}
					setState(333);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				}
				setState(334);
				((ClassTypeContext)_localctx).rawClass = match(Identifier);
				setState(346);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(335);
					match(LT);
					setState(336);
					((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
					((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(337);
						match(COMMA);
						setState(338);
						((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
						((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
						}
						}
						setState(343);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(344);
					match(GT);
					}
					break;
				}
				setState(349);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(348);
					((ClassTypeContext)_localctx).nullable = match(QUESTION);
					}
					break;
				}
				}
				break;
			case BITAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				lambdaType();
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

	public static class LambdaTypeContext extends ParserRuleContext {
		public TypeContext returnType;
		public TypeContext type;
		public List<TypeContext> paramsTypes = new ArrayList<TypeContext>();
		public Token nullable;
		public TerminalNode BITAND() { return getToken(KalangParser.BITAND, 0); }
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public LambdaTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterLambdaType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitLambdaType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitLambdaType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaTypeContext lambdaType() throws RecognitionException {
		LambdaTypeContext _localctx = new LambdaTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lambdaType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(BITAND);
			setState(355);
			((LambdaTypeContext)_localctx).returnType = type(0);
			setState(356);
			match(LPAREN);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(357);
				((LambdaTypeContext)_localctx).type = type(0);
				((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(358);
					match(COMMA);
					setState(359);
					((LambdaTypeContext)_localctx).type = type(0);
					((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(367);
			match(RPAREN);
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(368);
				((LambdaTypeContext)_localctx).nullable = match(QUESTION);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterParameterizedElementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitParameterizedElementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitParameterizedElementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterizedElementTypeContext parameterizedElementType() throws RecognitionException {
		ParameterizedElementTypeContext _localctx = new ParameterizedElementTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameterizedElementType);
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case BITAND:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(371);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
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
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(KalangParser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(KalangParser.SUPER, 0); }
		public WildcardTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterWildcardType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitWildcardType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitWildcardType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardTypeContext wildcardType() throws RecognitionException {
		WildcardTypeContext _localctx = new WildcardTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(QUESTION);
			setState(376);
			((WildcardTypeContext)_localctx).boundKind = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
				((WildcardTypeContext)_localctx).boundKind = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(377);
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
		public TerminalNode SHORT() { return getToken(KalangParser.SHORT, 0); }
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_la = _input.LA(1);
			if ( !(((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (BOOLEAN - 20)) | (1L << (BYTE - 20)) | (1L << (CHAR - 20)) | (1L << (DOUBLE - 20)) | (1L << (FLOAT - 20)) | (1L << (INT - 20)) | (1L << (LONG - 20)) | (1L << (SHORT - 20)) | (1L << (VOID - 20)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public LocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitLocalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitLocalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarDeclContext localVarDecl() throws RecognitionException {
		LocalVarDeclContext _localctx = new LocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			varDecl();
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(382);
				match(COMMA);
				setState(383);
				varDecl();
				}
				}
				setState(388);
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

	public static class DestructuringLocalVarDeclContext extends ParserRuleContext {
		public Token key;
		public Token op;
		public TerminalNode ASSIGN() { return getToken(KalangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VAL() { return getToken(KalangParser.VAL, 0); }
		public TerminalNode VAR() { return getToken(KalangParser.VAR, 0); }
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
		public TerminalNode RBRACK() { return getToken(KalangParser.RBRACK, 0); }
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public TerminalNode LBRACK() { return getToken(KalangParser.LBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public DestructuringLocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructuringLocalVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterDestructuringLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitDestructuringLocalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitDestructuringLocalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DestructuringLocalVarDeclContext destructuringLocalVarDecl() throws RecognitionException {
		DestructuringLocalVarDeclContext _localctx = new DestructuringLocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_destructuringLocalVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			((DestructuringLocalVarDeclContext)_localctx).key = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VAR || _la==VAL) ) {
				((DestructuringLocalVarDeclContext)_localctx).key = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(390);
				((DestructuringLocalVarDeclContext)_localctx).op = match(LBRACE);
				setState(391);
				match(Identifier);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(392);
					match(COMMA);
					setState(393);
					match(Identifier);
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(399);
				match(RBRACE);
				}
				break;
			case LBRACK:
				{
				setState(400);
				((DestructuringLocalVarDeclContext)_localctx).op = match(LBRACK);
				setState(401);
				match(Identifier);
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(402);
					match(COMMA);
					setState(403);
					match(Identifier);
					}
					}
					setState(408);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(409);
				match(RBRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(412);
			match(ASSIGN);
			setState(413);
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

	public static class IfStatContext extends ParserRuleContext {
		public StatContext trueStmt;
		public StatContext falseStmt;
		public TerminalNode IF() { return getToken(KalangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(IF);
			setState(416);
			match(LPAREN);
			setState(417);
			expression(0);
			setState(418);
			match(RPAREN);
			setState(419);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(420);
				match(ELSE);
				setState(421);
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
		public EmptyStatContext emptyStat() {
			return getRuleContext(EmptyStatContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public VarDeclStatContext varDeclStat() {
			return getRuleContext(VarDeclStatContext.class,0);
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
		public AssertStmtContext assertStmt() {
			return getRuleContext(AssertStmtContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stat);
		try {
			setState(440);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				emptyStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				blockStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(428);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(429);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(430);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(431);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(432);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(433);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(434);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(435);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(436);
				tryStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(437);
				throwStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(438);
				errorousStat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(439);
				assertStmt();
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

	public static class EmptyStatContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public EmptyStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterEmptyStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitEmptyStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitEmptyStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatContext emptyStat() throws RecognitionException {
		EmptyStatContext _localctx = new EmptyStatContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_emptyStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterErrorousStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitErrorousStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitErrorousStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorousStatContext errorousStat() throws RecognitionException {
		ErrorousStatContext _localctx = new ErrorousStatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
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

	public static class AssertStmtContext extends ParserRuleContext {
		public ExpressionContext testCondition;
		public ExpressionContext failMessage;
		public TerminalNode ASSERT() { return getToken(KalangParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(KalangParser.COLON, 0); }
		public AssertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterAssertStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitAssertStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitAssertStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStmtContext assertStmt() throws RecognitionException {
		AssertStmtContext _localctx = new AssertStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(ASSERT);
			setState(447);
			((AssertStmtContext)_localctx).testCondition = expression(0);
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(448);
				match(COLON);
				setState(449);
				((AssertStmtContext)_localctx).failMessage = expression(0);
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

	public static class ThrowStatContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(KalangParser.THROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public ThrowStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterThrowStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitThrowStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitThrowStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatContext throwStat() throws RecognitionException {
		ThrowStatContext _localctx = new ThrowStatContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(THROW);
			setState(453);
			expression(0);
			setState(454);
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
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(LBRACE);
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(457);
				stat();
				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(463);
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
		public VarDeclContext varDecl;
		public List<VarDeclContext> resources = new ArrayList<VarDeclContext>();
		public BlockStmtContext exec;
		public ClassTypeContext classType;
		public List<ClassTypeContext> catchTypes = new ArrayList<ClassTypeContext>();
		public Token Identifier;
		public List<Token> catchVarNames = new ArrayList<Token>();
		public BlockStmtContext blockStmt;
		public List<BlockStmtContext> catchExec = new ArrayList<BlockStmtContext>();
		public BlockStmtContext finallyExec;
		public TerminalNode TRY() { return getToken(KalangParser.TRY, 0); }
		public List<BlockStmtContext> blockStmt() {
			return getRuleContexts(BlockStmtContext.class);
		}
		public BlockStmtContext blockStmt(int i) {
			return getRuleContext(BlockStmtContext.class,i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(KalangParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(KalangParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(KalangParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(KalangParser.RPAREN, i);
		}
		public List<TerminalNode> CATCH() { return getTokens(KalangParser.CATCH); }
		public TerminalNode CATCH(int i) {
			return getToken(KalangParser.CATCH, i);
		}
		public TerminalNode FINALLY() { return getToken(KalangParser.FINALLY, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
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
		public List<TerminalNode> SEMI() { return getTokens(KalangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(KalangParser.SEMI, i);
		}
		public TryStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterTryStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitTryStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitTryStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatContext tryStat() throws RecognitionException {
		TryStatContext _localctx = new TryStatContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_tryStat);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(TRY);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(466);
				match(LPAREN);
				setState(467);
				((TryStatContext)_localctx).varDecl = varDecl();
				((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(468);
						match(SEMI);
						setState(469);
						((TryStatContext)_localctx).varDecl = varDecl();
						((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
						}
						} 
					}
					setState(474);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(475);
					match(SEMI);
					}
				}

				setState(478);
				match(RPAREN);
				}
			}

			setState(482);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(483);
				match(CATCH);
				setState(484);
				match(LPAREN);
				setState(485);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(486);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(487);
				match(RPAREN);
				setState(488);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(495);
				match(FINALLY);
				setState(496);
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
		public TerminalNode RETURN() { return getToken(KalangParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(RETURN);
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(500);
				expression(0);
				}
			}

			setState(503);
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
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public DestructuringLocalVarDeclContext destructuringLocalVarDecl() {
			return getRuleContext(DestructuringLocalVarDeclContext.class,0);
		}
		public VarDeclStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitVarDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varDeclStat);
		try {
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(505);
				localVarDecl();
				setState(506);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(508);
				destructuringLocalVarDecl();
				setState(509);
				match(SEMI);
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

	public static class VarDeclContext extends ParserRuleContext {
		public Token varToken;
		public Token valToken;
		public Token name;
		public TypeContext varType;
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode VAR() { return getToken(KalangParser.VAR, 0); }
		public TerminalNode VAL() { return getToken(KalangParser.VAL, 0); }
		public TerminalNode AS() { return getToken(KalangParser.AS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(KalangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_varDecl);
		int _la;
		try {
			setState(532);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(515);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(513);
					((VarDeclContext)_localctx).varToken = match(VAR);
					}
					break;
				case VAL:
					{
					setState(514);
					((VarDeclContext)_localctx).valToken = match(VAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(517);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(518);
					match(AS);
					setState(519);
					type(0);
					}
				}

				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(522);
					match(ASSIGN);
					setState(523);
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
			case SHORT:
			case VOID:
			case BITAND:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(526);
				((VarDeclContext)_localctx).varType = type(0);
				setState(527);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(528);
					match(ASSIGN);
					setState(529);
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
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public BreakStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(BREAK);
			setState(535);
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
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public ContinueStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(CONTINUE);
			setState(538);
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
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(WHILE);
			setState(541);
			match(LPAREN);
			setState(542);
			expression(0);
			setState(543);
			match(RPAREN);
			setState(544);
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
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public DoWhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterDoWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitDoWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitDoWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(DO);
			setState(547);
			blockStmt();
			setState(548);
			match(WHILE);
			setState(549);
			match(LPAREN);
			setState(550);
			expression(0);
			setState(551);
			match(RPAREN);
			setState(552);
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
		public ExpressionsContext initExpressions;
		public ExpressionContext condition;
		public ExpressionsContext updateExpressions;
		public TerminalNode FOR() { return getToken(KalangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(KalangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(KalangParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
		}
		public List<ExpressionsContext> expressions() {
			return getRuleContexts(ExpressionsContext.class);
		}
		public ExpressionsContext expressions(int i) {
			return getRuleContext(ExpressionsContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(FOR);
			setState(555);
			match(LPAREN);
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(556);
				localVarDecl();
				}
				break;
			case 2:
				{
				setState(557);
				((ForStatContext)_localctx).initExpressions = expressions();
				}
				break;
			}
			setState(560);
			match(SEMI);
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(561);
				((ForStatContext)_localctx).condition = expression(0);
				}
			}

			setState(564);
			match(SEMI);
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(565);
				((ForStatContext)_localctx).updateExpressions = expressions();
				}
			}

			setState(568);
			match(RPAREN);
			setState(569);
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
		public Token valueId;
		public Token indexId;
		public TerminalNode FOR() { return getToken(KalangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode IN() { return getToken(KalangParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public TerminalNode COMMA() { return getToken(KalangParser.COMMA, 0); }
		public TerminalNode FOREACH() { return getToken(KalangParser.FOREACH, 0); }
		public TerminalNode AS() { return getToken(KalangParser.AS, 0); }
		public ForEachStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forEachStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterForEachStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitForEachStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitForEachStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForEachStatContext forEachStat() throws RecognitionException {
		ForEachStatContext _localctx = new ForEachStatContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_forEachStat);
		int _la;
		try {
			setState(595);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				match(FOR);
				setState(572);
				match(LPAREN);
				setState(573);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(574);
					match(COMMA);
					setState(575);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					}
				}

				setState(578);
				match(IN);
				setState(579);
				expression(0);
				setState(580);
				match(RPAREN);
				setState(581);
				stat();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				match(FOREACH);
				setState(584);
				match(LPAREN);
				setState(585);
				expression(0);
				setState(586);
				match(AS);
				setState(589);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(587);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					setState(588);
					match(COMMA);
					}
					break;
				}
				setState(591);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(592);
				match(RPAREN);
				setState(593);
				stat();
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

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			expression(0);
			setState(602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(598);
				match(COMMA);
				setState(599);
				expression(0);
				}
				}
				setState(604);
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
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public ExprStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			expression(0);
			setState(606);
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
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitNewExpr(this);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterInstanceofExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitInstanceofExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitInstanceofExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InterpolationExprContext extends ExpressionContext {
		public TerminalNode InterpolationPreffixString() { return getToken(KalangParser.InterpolationPreffixString, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(KalangParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(KalangParser.RBRACE, i);
		}
		public TerminalNode INTERPOLATION_END() { return getToken(KalangParser.INTERPOLATION_END, 0); }
		public List<TerminalNode> INTERPOLATION_INTERUPT() { return getTokens(KalangParser.INTERPOLATION_INTERUPT); }
		public TerminalNode INTERPOLATION_INTERUPT(int i) {
			return getToken(KalangParser.INTERPOLATION_INTERUPT, i);
		}
		public List<TerminalNode> INTERPOLATION_STRING() { return getTokens(KalangParser.INTERPOLATION_STRING); }
		public TerminalNode INTERPOLATION_STRING(int i) {
			return getToken(KalangParser.INTERPOLATION_STRING, i);
		}
		public InterpolationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterInterpolationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitInterpolationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitInterpolationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(KalangParser.INC, 0); }
		public TerminalNode DEC() { return getToken(KalangParser.DEC, 0); }
		public IncExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodRefExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOUBLE_COLON() { return getToken(KalangParser.DOUBLE_COLON, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public MethodRefExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterMethodRefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitMethodRefExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitMethodRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetFieldExprContext extends ExpressionContext {
		public Token refKey;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
		public TerminalNode DOT() { return getToken(KalangParser.DOT, 0); }
		public TerminalNode DYNAMIC() { return getToken(KalangParser.DYNAMIC, 0); }
		public TerminalNode STAR_DOT() { return getToken(KalangParser.STAR_DOT, 0); }
		public TerminalNode STAR_DYNAMIC() { return getToken(KalangParser.STAR_DYNAMIC, 0); }
		public TerminalNode QUESTION_DOT() { return getToken(KalangParser.QUESTION_DOT, 0); }
		public TerminalNode QUESTION_DYNAMIC() { return getToken(KalangParser.QUESTION_DYNAMIC, 0); }
		public GetFieldExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterGetFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitGetFieldExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitGetFieldExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitShiftExprContext extends ExpressionContext {
		public Token left;
		public Token stop;
		public Token uright;
		public Token right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(KalangParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(KalangParser.GT, i);
		}
		public List<TerminalNode> LT() { return getTokens(KalangParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(KalangParser.LT, i);
		}
		public BitShiftExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterBitShiftExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitBitShiftExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitBitShiftExpr(this);
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
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(KalangParser.COLON, 0); }
		public QuestionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterQuestionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitQuestionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitQuestionExpr(this);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(KalangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(KalangParser.SUB, 0); }
		public TerminalNode TILDE() { return getToken(KalangParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(KalangParser.BANG, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExpressionContext {
		public Token Identifier;
		public List<Token> lambdaParams = new ArrayList<Token>();
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
		public TerminalNode LAMBDA_ARROW() { return getToken(KalangParser.LAMBDA_ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaTypeContext lambdaType() {
			return getRuleContext(LambdaTypeContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public LambdaExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterLambdaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitLambdaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitLambdaExpr(this);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberInvocationExprContext extends ExpressionContext {
		public Token key;
		public ExpressionContext expression;
		public List<ExpressionContext> params = new ArrayList<ExpressionContext>();
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode THIS() { return getToken(KalangParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(KalangParser.SUPER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public MemberInvocationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterMemberInvocationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitMemberInvocationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitMemberInvocationExpr(this);
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
		public TerminalNode ASSIGN() { return getToken(KalangParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(KalangParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(KalangParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(KalangParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(KalangParser.DIV_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(KalangParser.AND_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(KalangParser.OR_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(KalangParser.XOR_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(KalangParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(KalangParser.URSHIFT_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(KalangParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(KalangParser.MOD_ASSIGN, 0); }
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayExprContext extends ExpressionContext {
		public ExpressionContext expression;
		public List<ExpressionContext> sizes = new ArrayList<ExpressionContext>();
		public Token s81;
		public List<Token> suffix = new ArrayList<Token>();
		public List<ExpressionContext> initExpr = new ArrayList<ExpressionContext>();
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(KalangParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(KalangParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(KalangParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(KalangParser.RBRACK, i);
		}
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public NewArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterNewArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitNewArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitNewArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfRefExprContext extends ExpressionContext {
		public Token ref;
		public TerminalNode THIS() { return getToken(KalangParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(KalangParser.SUPER, 0); }
		public SelfRefExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterSelfRefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitSelfRefExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitSelfRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvokeExprContext extends ExpressionContext {
		public ExpressionContext target;
		public Token refKey;
		public ExpressionContext expression;
		public List<ExpressionContext> params = new ArrayList<ExpressionContext>();
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
		public TerminalNode DOT() { return getToken(KalangParser.DOT, 0); }
		public TerminalNode DYNAMIC() { return getToken(KalangParser.DYNAMIC, 0); }
		public TerminalNode DOTDOT() { return getToken(KalangParser.DOTDOT, 0); }
		public TerminalNode STAR_DOT() { return getToken(KalangParser.STAR_DOT, 0); }
		public TerminalNode STAR_DYNAMIC() { return getToken(KalangParser.STAR_DYNAMIC, 0); }
		public TerminalNode QUESTION_DOT() { return getToken(KalangParser.QUESTION_DOT, 0); }
		public TerminalNode QUESTION_DYNAMIC() { return getToken(KalangParser.QUESTION_DYNAMIC, 0); }
		public TerminalNode QUESTION_DOTDOT() { return getToken(KalangParser.QUESTION_DOTDOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public InvokeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterInvokeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitInvokeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitInvokeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExpressionContext {
		public TerminalNode LBRACK() { return getToken(KalangParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(KalangParser.RBRACK, 0); }
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MapExprContext extends ExpressionContext {
		public Token keyType;
		public Token valueType;
		public ExpressionContext expression;
		public List<ExpressionContext> keys = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> values = new ArrayList<ExpressionContext>();
		public TerminalNode LBRACK() { return getToken(KalangParser.LBRACK, 0); }
		public List<TerminalNode> COLON() { return getTokens(KalangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(KalangParser.COLON, i);
		}
		public TerminalNode RBRACK() { return getToken(KalangParser.RBRACK, 0); }
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public MapExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterMapExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitMapExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitMapExpr(this);
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
		public TerminalNode MUL() { return getToken(KalangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(KalangParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(KalangParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(KalangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(KalangParser.SUB, 0); }
		public TerminalNode LE() { return getToken(KalangParser.LE, 0); }
		public TerminalNode GE() { return getToken(KalangParser.GE, 0); }
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TerminalNode EQUAL() { return getToken(KalangParser.EQUAL, 0); }
		public TerminalNode SAME() { return getToken(KalangParser.SAME, 0); }
		public TerminalNode NOTEQUAL() { return getToken(KalangParser.NOTEQUAL, 0); }
		public TerminalNode NOTSAME() { return getToken(KalangParser.NOTSAME, 0); }
		public TerminalNode BITAND() { return getToken(KalangParser.BITAND, 0); }
		public TerminalNode CARET() { return getToken(KalangParser.CARET, 0); }
		public TerminalNode BITOR() { return getToken(KalangParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(KalangParser.AND, 0); }
		public TerminalNode OR() { return getToken(KalangParser.OR, 0); }
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitBinaryExpr(this);
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
		public TerminalNode LBRACK() { return getToken(KalangParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(KalangParser.RBRACK, 0); }
		public GetArrayElementExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterGetArrayElementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitGetArrayElementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitGetArrayElementExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreIncExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(KalangParser.INC, 0); }
		public TerminalNode DEC() { return getToken(KalangParser.DEC, 0); }
		public PreIncExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterPreIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitPreIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitPreIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorousMemberExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(KalangParser.DOT, 0); }
		public ErrorousMemberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterErrorousMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitErrorousMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitErrorousMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullDefaultExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOUBLE_QUESTION() { return getToken(KalangParser.DOUBLE_QUESTION, 0); }
		public NullDefaultExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterNullDefaultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitNullDefaultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitNullDefaultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WithExprContext extends ExpressionContext {
		public TerminalNode WITH() { return getToken(KalangParser.WITH, 0); }
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public WithExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterWithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitWithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitWithExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public IdentifierExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitIdentifierExpr(this);
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(609);
				match(LPAREN);
				setState(610);
				expression(0);
				setState(611);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(613);
				((SelfRefExprContext)_localctx).ref = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUPER || _la==THIS) ) {
					((SelfRefExprContext)_localctx).ref = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(614);
				literal();
				}
				break;
			case 4:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(664);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
				case BITAND:
					{
					{
					setState(616);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==BITAND) {
						{
						setState(615);
						lambdaType();
						}
					}

					setState(618);
					match(LBRACE);
					setState(628);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						setState(619);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						setState(624);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(620);
							match(COMMA);
							setState(621);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							}
							}
							setState(626);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(627);
						match(LAMBDA_ARROW);
						}
						break;
					}
					setState(633);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						{
						setState(630);
						stat();
						}
						}
						setState(635);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(636);
					match(RBRACE);
					}
					}
					break;
				case LPAREN:
				case Identifier:
					{
					{
					setState(650);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAREN:
						{
						{
						setState(637);
						match(LPAREN);
						setState(646);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(638);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							setState(643);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(639);
								match(COMMA);
								setState(640);
								((LambdaExprContext)_localctx).Identifier = match(Identifier);
								((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
								}
								}
								setState(645);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(648);
						match(RPAREN);
						}
						}
						break;
					case Identifier:
						{
						setState(649);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(652);
					match(LAMBDA_ARROW);
					setState(662);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
					case 1:
						{
						{
						setState(653);
						match(LBRACE);
						setState(657);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							{
							setState(654);
							stat();
							}
							}
							setState(659);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(660);
						match(RBRACE);
						}
						}
						break;
					case 2:
						{
						setState(661);
						expression(0);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(666);
					match(LT);
					setState(667);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(668);
					match(COMMA);
					setState(669);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(670);
					match(GT);
					}
				}

				setState(695);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(673);
					match(LBRACK);
					setState(674);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
					setState(675);
					match(COLON);
					setState(676);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(684);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(677);
							match(COMMA);
							setState(678);
							((MapExprContext)_localctx).expression = expression(0);
							((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
							setState(679);
							match(COLON);
							setState(680);
							((MapExprContext)_localctx).expression = expression(0);
							((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
							}
							} 
						}
						setState(686);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
					}
					setState(688);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(687);
						match(COMMA);
						}
					}

					setState(690);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(692);
					match(LBRACK);
					setState(693);
					match(COLON);
					setState(694);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(697);
					match(LT);
					setState(698);
					type(0);
					setState(699);
					match(GT);
					}
				}

				setState(703);
				match(LBRACK);
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(704);
					expression(0);
					setState(709);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(705);
							match(COMMA);
							setState(706);
							expression(0);
							}
							} 
						}
						setState(711);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
					}
					}
				}

				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(714);
					match(COMMA);
					}
				}

				setState(717);
				match(RBRACK);
				}
				break;
			case 7:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(721);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(718);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(719);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(720);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(723);
				match(LPAREN);
				setState(732);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(724);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(729);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(725);
						match(COMMA);
						setState(726);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(731);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(734);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(735);
				match(NEW);
				setState(736);
				classType();
				setState(737);
				match(LPAREN);
				setState(746);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(738);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(743);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(739);
						match(COMMA);
						setState(740);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(745);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(748);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(784);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(750);
					match(NEW);
					setState(751);
					type(0);
					setState(756); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(752);
							match(LBRACK);
							setState(753);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).sizes.add(((NewArrayExprContext)_localctx).expression);
							setState(754);
							match(RBRACK);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(758); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(764);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(760);
							((NewArrayExprContext)_localctx).s81 = match(LBRACK);
							((NewArrayExprContext)_localctx).suffix.add(((NewArrayExprContext)_localctx).s81);
							setState(761);
							match(RBRACK);
							}
							} 
						}
						setState(766);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
					}
					}
					break;
				case 2:
					{
					setState(767);
					match(NEW);
					setState(768);
					type(0);
					setState(769);
					match(LBRACK);
					setState(770);
					match(RBRACK);
					setState(771);
					match(LBRACE);
					setState(780);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						setState(772);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(777);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(773);
							match(COMMA);
							setState(774);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(779);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(782);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(786);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(787);
				expression(21);
				}
				break;
			case 11:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(788);
				((PreIncExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(789);
				expression(20);
				}
				break;
			case 12:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(790);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(791);
				expression(19);
				}
				break;
			case 13:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(792);
				match(LPAREN);
				setState(793);
				type(0);
				setState(794);
				match(RPAREN);
				setState(795);
				expression(18);
				}
				break;
			case 14:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(797);
				match(Identifier);
				}
				break;
			case 15:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(798);
				match(InterpolationPreffixString);
				setState(799);
				expression(0);
				setState(808);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(800);
						match(RBRACE);
						setState(802);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(801);
							match(INTERPOLATION_STRING);
							}
						}

						setState(804);
						match(INTERPOLATION_INTERUPT);
						setState(805);
						expression(0);
						}
						} 
					}
					setState(810);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				setState(811);
				match(RBRACE);
				setState(813);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(812);
					match(INTERPOLATION_STRING);
					}
				}

				setState(815);
				match(INTERPOLATION_END);
				}
				break;
			case 16:
				{
				_localctx = new WithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(817);
				match(WITH);
				setState(818);
				match(LPAREN);
				setState(819);
				expression(0);
				setState(820);
				match(RPAREN);
				setState(821);
				match(LBRACE);
				setState(825);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					{
					setState(822);
					stat();
					}
					}
					setState(827);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(828);
				match(RBRACE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(914);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(912);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(832);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(833);
						_la = _input.LA(1);
						if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (MUL - 106)) | (1L << (DIV - 106)) | (1L << (MOD - 106)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(834);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(835);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(836);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(837);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(838);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(846);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
						case 1:
							{
							setState(839);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(840);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(841);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(842);
							match(GT);
							setState(843);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(844);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(845);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(848);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(849);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(850);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (GT - 88)) | (1L << (LT - 88)) | (1L << (LE - 88)) | (1L << (GE - 88)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(851);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(852);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(853);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (EQUAL - 94)) | (1L << (SAME - 94)) | (1L << (NOTEQUAL - 94)) | (1L << (NOTSAME - 94)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(854);
						expression(13);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(855);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(856);
						match(BITAND);
						setState(857);
						expression(12);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(858);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(859);
						match(CARET);
						setState(860);
						expression(11);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(861);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(862);
						match(BITOR);
						setState(863);
						expression(10);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(864);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(865);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(866);
						expression(9);
						}
						break;
					case 10:
						{
						_localctx = new NullDefaultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(867);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(868);
						match(DOUBLE_QUESTION);
						setState(869);
						expression(8);
						}
						break;
					case 11:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(870);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(871);
						match(QUESTION);
						setState(872);
						expression(0);
						setState(873);
						match(COLON);
						setState(874);
						expression(7);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(876);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(877);
						_la = _input.LA(1);
						if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ASSIGN - 87)) | (1L << (ADD_ASSIGN - 87)) | (1L << (SUB_ASSIGN - 87)) | (1L << (MUL_ASSIGN - 87)) | (1L << (DIV_ASSIGN - 87)) | (1L << (AND_ASSIGN - 87)) | (1L << (OR_ASSIGN - 87)) | (1L << (XOR_ASSIGN - 87)) | (1L << (MOD_ASSIGN - 87)) | (1L << (LSHIFT_ASSIGN - 87)) | (1L << (RSHIFT_ASSIGN - 87)) | (1L << (URSHIFT_ASSIGN - 87)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(878);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(879);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(880);
						((InvokeExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << STAR_DOT) | (1L << STAR_DYNAMIC) | (1L << QUESTION_DOT) | (1L << QUESTION_DOTDOT) | (1L << QUESTION_DYNAMIC))) != 0) || _la==DOT || _la==DOTDOT) ) {
							((InvokeExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(881);
						_la = _input.LA(1);
						if ( !(_la==StringLiteral || _la==Identifier) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(882);
						match(LPAREN);
						setState(891);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(883);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(888);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(884);
								match(COMMA);
								setState(885);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(890);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(893);
						match(RPAREN);
						}
						break;
					case 14:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(894);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(895);
						((GetFieldExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << STAR_DOT) | (1L << STAR_DYNAMIC) | (1L << QUESTION_DOT) | (1L << QUESTION_DYNAMIC))) != 0) || _la==DOT) ) {
							((GetFieldExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(896);
						_la = _input.LA(1);
						if ( !(_la==StringLiteral || _la==Identifier) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 15:
						{
						_localctx = new MethodRefExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(897);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(898);
						match(DOUBLE_COLON);
						setState(899);
						match(Identifier);
						}
						break;
					case 16:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(900);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(901);
						match(LBRACK);
						setState(902);
						expression(0);
						setState(903);
						match(RBRACK);
						}
						break;
					case 17:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(905);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(906);
						((IncExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((IncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 18:
						{
						_localctx = new InstanceofExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(907);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(908);
						match(INSTANCEOF);
						setState(909);
						match(Identifier);
						}
						break;
					case 19:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(910);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(911);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(916);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
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
		public Token arrayPrefix;
		public TerminalNode IntegerLiteral() { return getToken(KalangParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(KalangParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(KalangParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
		public TerminalNode MultiLineStringLiteral() { return getToken(KalangParser.MultiLineStringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KalangParser.BooleanLiteral, 0); }
		public TerminalNode DOT() { return getToken(KalangParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(KalangParser.CLASS, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode RBRACK() { return getToken(KalangParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(KalangParser.LBRACK, 0); }
		public TerminalNode NullLiteral() { return getToken(KalangParser.NullLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_literal);
		int _la;
		try {
			setState(934);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(917);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(918);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(919);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(920);
				match(StringLiteral);
				}
				break;
			case MultiLineStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(921);
				match(MultiLineStringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(922);
				match(BooleanLiteral);
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 7);
				{
				setState(925);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
				case BYTE:
				case CHAR:
				case DOUBLE:
				case FLOAT:
				case INT:
				case LONG:
				case SHORT:
				case VOID:
					{
					setState(923);
					primitiveType();
					}
					break;
				case Identifier:
					{
					setState(924);
					match(Identifier);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(929);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(927);
					((LiteralContext)_localctx).arrayPrefix = match(LBRACK);
					setState(928);
					match(RBRACK);
					}
				}

				setState(931);
				match(DOT);
				setState(932);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 8);
				{
				setState(933);
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
		public List<TerminalNode> STATIC() { return getTokens(KalangParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(KalangParser.STATIC, i);
		}
		public List<TerminalNode> FINAL() { return getTokens(KalangParser.FINAL); }
		public TerminalNode FINAL(int i) {
			return getToken(KalangParser.FINAL, i);
		}
		public List<TerminalNode> PRIVATE() { return getTokens(KalangParser.PRIVATE); }
		public TerminalNode PRIVATE(int i) {
			return getToken(KalangParser.PRIVATE, i);
		}
		public List<TerminalNode> PUBLIC() { return getTokens(KalangParser.PUBLIC); }
		public TerminalNode PUBLIC(int i) {
			return getToken(KalangParser.PUBLIC, i);
		}
		public List<TerminalNode> PROTECTED() { return getTokens(KalangParser.PROTECTED); }
		public TerminalNode PROTECTED(int i) {
			return getToken(KalangParser.PROTECTED, i);
		}
		public List<TerminalNode> SYNCHRONIZED() { return getTokens(KalangParser.SYNCHRONIZED); }
		public TerminalNode SYNCHRONIZED(int i) {
			return getToken(KalangParser.SYNCHRONIZED, i);
		}
		public List<TerminalNode> ABSTRACT() { return getTokens(KalangParser.ABSTRACT); }
		public TerminalNode ABSTRACT(int i) {
			return getToken(KalangParser.ABSTRACT, i);
		}
		public List<TerminalNode> NATIVE() { return getTokens(KalangParser.NATIVE); }
		public TerminalNode NATIVE(int i) {
			return getToken(KalangParser.NATIVE, i);
		}
		public List<TerminalNode> TRANSIENT() { return getTokens(KalangParser.TRANSIENT); }
		public TerminalNode TRANSIENT(int i) {
			return getToken(KalangParser.TRANSIENT, i);
		}
		public List<TerminalNode> VOLATILE() { return getTokens(KalangParser.VOLATILE); }
		public TerminalNode VOLATILE(int i) {
			return getToken(KalangParser.VOLATILE, i);
		}
		public VarModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterVarModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitVarModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitVarModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarModifierContext varModifier() throws RecognitionException {
		VarModifierContext _localctx = new VarModifierContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(936);
				_la = _input.LA(1);
				if ( !(((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(939); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		case 11:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 38:
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
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 1);
		case 13:
			return precpred(_ctx, 29);
		case 14:
			return precpred(_ctx, 28);
		case 15:
			return precpred(_ctx, 27);
		case 16:
			return precpred(_ctx, 25);
		case 17:
			return precpred(_ctx, 22);
		case 18:
			return precpred(_ctx, 13);
		case 19:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0089\u03b0\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\7\2"+
		"V\n\2\f\2\16\2Y\13\2\3\2\7\2\\\n\2\f\2\16\2_\13\2\3\2\3\2\5\2c\n\2\3\3"+
		"\3\3\3\4\3\4\3\4\7\4j\n\4\f\4\16\4m\13\4\3\5\7\5p\n\5\f\5\16\5s\13\5\3"+
		"\5\5\5v\n\5\3\5\3\5\3\5\3\5\3\5\7\5}\n\5\f\5\16\5\u0080\13\5\3\5\5\5\u0083"+
		"\n\5\3\5\5\5\u0086\n\5\3\5\5\5\u0089\n\5\3\5\3\5\5\5\u008d\n\5\3\5\3\5"+
		"\3\5\3\5\7\5\u0093\n\5\f\5\16\5\u0096\13\5\5\5\u0098\n\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\5\6\u00a0\n\6\3\6\5\6\u00a3\n\6\3\6\3\6\3\6\7\6\u00a8\n\6\f"+
		"\6\16\6\u00ab\13\6\3\6\3\6\3\6\3\6\5\6\u00b1\n\6\3\6\5\6\u00b4\n\6\3\6"+
		"\3\6\5\6\u00b8\n\6\3\6\3\6\3\6\7\6\u00bd\n\6\f\6\16\6\u00c0\13\6\3\6\3"+
		"\6\3\6\3\6\5\6\u00c6\n\6\3\6\5\6\u00c9\n\6\5\6\u00cb\n\6\3\6\3\6\3\7\3"+
		"\7\3\7\7\7\u00d2\n\7\f\7\16\7\u00d5\13\7\3\b\3\b\3\b\7\b\u00da\n\b\f\b"+
		"\16\b\u00dd\13\b\3\t\5\t\u00e0\n\t\3\t\3\t\3\t\7\t\u00e5\n\t\f\t\16\t"+
		"\u00e8\13\t\3\t\3\t\3\n\7\n\u00ed\n\n\f\n\16\n\u00f0\13\n\3\n\5\n\u00f3"+
		"\n\n\3\n\5\n\u00f6\n\n\3\n\5\n\u00f9\n\n\3\n\3\n\3\n\3\n\5\n\u00ff\n\n"+
		"\3\n\3\n\3\n\3\n\7\n\u0105\n\n\f\n\16\n\u0108\13\n\5\n\u010a\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u0111\n\n\f\n\16\n\u0114\13\n\5\n\u0116\n\n\3\n\3\n"+
		"\5\n\u011a\n\n\3\13\3\13\5\13\u011e\n\13\3\13\3\13\3\13\5\13\u0123\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u012f\n\f\f\f\16\f\u0132"+
		"\13\f\3\f\5\f\u0135\n\f\3\f\5\f\u0138\n\f\3\r\3\r\3\r\5\r\u013d\n\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0143\n\r\7\r\u0145\n\r\f\r\16\r\u0148\13\r\3\16\3"+
		"\16\7\16\u014c\n\16\f\16\16\16\u014f\13\16\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u0156\n\16\f\16\16\16\u0159\13\16\3\16\3\16\5\16\u015d\n\16\3\16\5"+
		"\16\u0160\n\16\3\16\5\16\u0163\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u016b\n\17\f\17\16\17\u016e\13\17\5\17\u0170\n\17\3\17\3\17\5\17\u0174"+
		"\n\17\3\20\3\20\5\20\u0178\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\7\23\u0183\n\23\f\23\16\23\u0186\13\23\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u018d\n\24\f\24\16\24\u0190\13\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0197\n\24\f\24\16\24\u019a\13\24\3\24\5\24\u019d\n\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01a9\n\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01bb"+
		"\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u01c5\n\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\7\33\u01cd\n\33\f\33\16\33\u01d0\13\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\7\34\u01d9\n\34\f\34\16\34\u01dc\13\34\3\34"+
		"\5\34\u01df\n\34\3\34\3\34\5\34\u01e3\n\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\7\34\u01ed\n\34\f\34\16\34\u01f0\13\34\3\34\3\34\5\34\u01f4"+
		"\n\34\3\35\3\35\5\35\u01f8\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0202\n\36\3\37\3\37\5\37\u0206\n\37\3\37\3\37\3\37\5\37\u020b\n"+
		"\37\3\37\3\37\5\37\u020f\n\37\3\37\3\37\3\37\3\37\5\37\u0215\n\37\5\37"+
		"\u0217\n\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\5$\u0231\n$\3$\3$\5$\u0235\n$\3$\3$\5$\u0239\n$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\5%\u0243\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5"+
		"%\u0250\n%\3%\3%\3%\3%\5%\u0256\n%\3&\3&\3&\7&\u025b\n&\f&\16&\u025e\13"+
		"&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u026b\n(\3(\3(\3(\3(\7(\u0271"+
		"\n(\f(\16(\u0274\13(\3(\5(\u0277\n(\3(\7(\u027a\n(\f(\16(\u027d\13(\3"+
		"(\3(\3(\3(\3(\7(\u0284\n(\f(\16(\u0287\13(\5(\u0289\n(\3(\3(\5(\u028d"+
		"\n(\3(\3(\3(\7(\u0292\n(\f(\16(\u0295\13(\3(\3(\5(\u0299\n(\5(\u029b\n"+
		"(\3(\3(\3(\3(\3(\5(\u02a2\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u02ad\n(\f"+
		"(\16(\u02b0\13(\3(\5(\u02b3\n(\3(\3(\3(\3(\3(\5(\u02ba\n(\3(\3(\3(\3("+
		"\5(\u02c0\n(\3(\3(\3(\3(\7(\u02c6\n(\f(\16(\u02c9\13(\5(\u02cb\n(\3(\5"+
		"(\u02ce\n(\3(\3(\3(\3(\5(\u02d4\n(\3(\3(\3(\3(\7(\u02da\n(\f(\16(\u02dd"+
		"\13(\5(\u02df\n(\3(\3(\3(\3(\3(\3(\3(\7(\u02e8\n(\f(\16(\u02eb\13(\5("+
		"\u02ed\n(\3(\3(\3(\3(\3(\3(\3(\3(\6(\u02f7\n(\r(\16(\u02f8\3(\3(\7(\u02fd"+
		"\n(\f(\16(\u0300\13(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u030a\n(\f(\16(\u030d"+
		"\13(\5(\u030f\n(\3(\3(\5(\u0313\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\5(\u0325\n(\3(\3(\7(\u0329\n(\f(\16(\u032c\13(\3(\3(\5("+
		"\u0330\n(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u033a\n(\f(\16(\u033d\13(\3(\3(\5"+
		"(\u0341\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0351\n(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0379\n(\f(\16(\u037c\13("+
		"\5(\u037e\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\7(\u0393\n(\f(\16(\u0396\13(\3)\3)\3)\3)\3)\3)\3)\3)\5)\u03a0\n)\3)\3"+
		")\5)\u03a4\n)\3)\3)\3)\5)\u03a9\n)\3*\6*\u03ac\n*\r*\16*\u03ad\3*\2\4"+
		"\30N+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFHJLNPR\2\23\4\299FF\4\2$$;;\13\2\26\26\30\30\33\33!!\'\'..\60\608"+
		"8CC\3\2\7\b\4\2;;>>\3\2jk\3\2hi\3\2\\]\4\2lmqq\4\2Z[bc\4\2`ade\3\2fg\4"+
		"\2YYr|\5\2\f\17\21\22WX\4\2LL~~\5\2\f\17\22\22WW\n\2\24\24%%\61\61\64"+
		"\6699==AADD\2\u043c\2W\3\2\2\2\4d\3\2\2\2\6k\3\2\2\2\bq\3\2\2\2\n\u00ca"+
		"\3\2\2\2\f\u00ce\3\2\2\2\16\u00db\3\2\2\2\20\u00df\3\2\2\2\22\u00ee\3"+
		"\2\2\2\24\u011b\3\2\2\2\26\u0124\3\2\2\2\30\u013c\3\2\2\2\32\u0162\3\2"+
		"\2\2\34\u0164\3\2\2\2\36\u0177\3\2\2\2 \u0179\3\2\2\2\"\u017d\3\2\2\2"+
		"$\u017f\3\2\2\2&\u0187\3\2\2\2(\u01a1\3\2\2\2*\u01ba\3\2\2\2,\u01bc\3"+
		"\2\2\2.\u01be\3\2\2\2\60\u01c0\3\2\2\2\62\u01c6\3\2\2\2\64\u01ca\3\2\2"+
		"\2\66\u01d3\3\2\2\28\u01f5\3\2\2\2:\u0201\3\2\2\2<\u0216\3\2\2\2>\u0218"+
		"\3\2\2\2@\u021b\3\2\2\2B\u021e\3\2\2\2D\u0224\3\2\2\2F\u022c\3\2\2\2H"+
		"\u0255\3\2\2\2J\u0257\3\2\2\2L\u025f\3\2\2\2N\u0340\3\2\2\2P\u03a8\3\2"+
		"\2\2R\u03ab\3\2\2\2TV\5\4\3\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X]\3\2\2\2YW\3\2\2\2Z\\\5\n\6\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2"+
		"\2^b\3\2\2\2_]\3\2\2\2`c\5\b\5\2ac\5\6\4\2b`\3\2\2\2ba\3\2\2\2c\3\3\2"+
		"\2\2de\7\u0081\2\2e\5\3\2\2\2fj\5\22\n\2gj\5*\26\2hj\5\b\5\2if\3\2\2\2"+
		"ig\3\2\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\7\3\2\2\2mk\3\2\2"+
		"\2np\5\26\f\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2ru\3\2\2\2sq\3\2"+
		"\2\2tv\5R*\2ut\3\2\2\2uv\3\2\2\2v\u0085\3\2\2\2w\u0082\7\34\2\2xy\7[\2"+
		"\2y~\7~\2\2z{\7V\2\2{}\7~\2\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\7Z\2\2\u0082x\3"+
		"\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0086\7/\2\2\u0085"+
		"w\3\2\2\2\u0085\u0084\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0089\7~\2\2\u0088"+
		"\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008b\7$"+
		"\2\2\u008b\u008d\5\32\16\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u0097\3\2\2\2\u008e\u008f\7+\2\2\u008f\u0094\5\32\16\2\u0090\u0091\7"+
		"V\2\2\u0091\u0093\5\32\16\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u008e\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\7Q\2\2\u009a\u009b\5\16\b\2\u009b\u009c\7R\2\2\u009c\t\3\2\2\2"+
		"\u009d\u009f\7,\2\2\u009e\u00a0\t\2\2\2\u009f\u009e\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3\7\u0085\2\2\u00a2\u00a1\3\2\2"+
		"\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a9\7~\2\2\u00a5\u00a6"+
		"\7\u0085\2\2\u00a6\u00a8\7~\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00b3\7\u0085\2\2\u00ad\u00b0\7~\2\2\u00ae\u00af\7\4\2"+
		"\2\u00af\u00b1\7~\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4"+
		"\3\2\2\2\u00b2\u00b4\7l\2\2\u00b3\u00ad\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4"+
		"\u00cb\3\2\2\2\u00b5\u00b7\7,\2\2\u00b6\u00b8\t\2\2\2\u00b7\u00b6\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00be\7~\2\2\u00ba"+
		"\u00bb\7W\2\2\u00bb\u00bd\7~\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c8\7W\2\2\u00c2\u00c5\7~\2\2\u00c3\u00c4\7\4\2\2\u00c4"+
		"\u00c6\7~\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c9\7l\2\2\u00c8\u00c2\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\u00cb\3\2\2\2\u00ca\u009d\3\2\2\2\u00ca\u00b5\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\7U\2\2\u00cd\13\3\2\2\2\u00ce\u00d3\7~\2\2\u00cf\u00d0"+
		"\7W\2\2\u00d0\u00d2\7~\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\r\3\2\2\2\u00d5\u00d3\3\2\2\2"+
		"\u00d6\u00da\5\20\t\2\u00d7\u00da\5\22\n\2\u00d8\u00da\5\b\5\2\u00d9\u00d6"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\17\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00de\u00e0\5R*\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e6\5<\37\2\u00e2\u00e3\7V\2\2\u00e3\u00e5\5<\37\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7U\2\2\u00ea"+
		"\21\3\2\2\2\u00eb\u00ed\5\26\f\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2"+
		"\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f1\u00f3\7\23\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2"+
		"\u00f3\u00f5\3\2\2\2\u00f4\u00f6\7\37\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f9\5R*\2\u00f8\u00f7\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fe\3\2\2\2\u00fa\u00fb\5\30\r\2\u00fb\u00fc\7"+
		"~\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00ff\7\6\2\2\u00fe\u00fa\3\2\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0109\7O\2\2\u0101\u0106\5\24"+
		"\13\2\u0102\u0103\7V\2\2\u0103\u0105\5\24\13\2\u0104\u0102\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010a\3\2"+
		"\2\2\u0108\u0106\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0115\7P\2\2\u010c\u010d\7@\2\2\u010d\u0112\7~\2"+
		"\2\u010e\u010f\7V\2\2\u010f\u0111\7~\2\2\u0110\u010e\3\2\2\2\u0111\u0114"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0115\u010c\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0119\3\2"+
		"\2\2\u0117\u011a\5\64\33\2\u0118\u011a\7U\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\23\3\2\2\2\u011b\u011d\5\30\r\2\u011c\u011e\7\u0080"+
		"\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0122\7~\2\2\u0120\u0121\7Y\2\2\u0121\u0123\5N(\2\u0122\u0120\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\25\3\2\2\2\u0124\u0125\7\177\2\2\u0125\u0137"+
		"\7~\2\2\u0126\u0134\7O\2\2\u0127\u0128\7~\2\2\u0128\u0129\7Y\2\2\u0129"+
		"\u0130\5P)\2\u012a\u012b\7V\2\2\u012b\u012c\7~\2\2\u012c\u012d\7Y\2\2"+
		"\u012d\u012f\5P)\2\u012e\u012a\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e"+
		"\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0135\3\2\2\2\u0132\u0130\3\2\2\2\u0133"+
		"\u0135\5P)\2\u0134\u0127\3\2\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2"+
		"\2\u0135\u0136\3\2\2\2\u0136\u0138\7P\2\2\u0137\u0126\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138\27\3\2\2\2\u0139\u013a\b\r\1\2\u013a\u013d\5\32\16\2\u013b"+
		"\u013d\5\"\22\2\u013c\u0139\3\2\2\2\u013c\u013b\3\2\2\2\u013d\u0146\3"+
		"\2\2\2\u013e\u013f\f\3\2\2\u013f\u0140\7S\2\2\u0140\u0142\7T\2\2\u0141"+
		"\u0143\7^\2\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2"+
		"\2\2\u0144\u013e\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\31\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\7~\2\2"+
		"\u014a\u014c\7\u0085\2\2\u014b\u0149\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0150\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u0150\u015c\7~\2\2\u0151\u0152\7[\2\2\u0152\u0157\5\36\20\2\u0153"+
		"\u0154\7V\2\2\u0154\u0156\5\36\20\2\u0155\u0153\3\2\2\2\u0156\u0159\3"+
		"\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015b\7Z\2\2\u015b\u015d\3\2\2\2\u015c\u0151\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u0160\7^\2\2\u015f"+
		"\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u0163\5\34"+
		"\17\2\u0162\u014d\3\2\2\2\u0162\u0161\3\2\2\2\u0163\33\3\2\2\2\u0164\u0165"+
		"\7n\2\2\u0165\u0166\5\30\r\2\u0166\u016f\7O\2\2\u0167\u016c\5\30\r\2\u0168"+
		"\u0169\7V\2\2\u0169\u016b\5\30\r\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2"+
		"\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0173\7P\2\2\u0172\u0174\7^\2\2\u0173\u0172\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0174\35\3\2\2\2\u0175\u0178\5\30\r\2\u0176\u0178\5 \21\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178\37\3\2\2\2\u0179\u017a\7^\2\2"+
		"\u017a\u017b\t\3\2\2\u017b\u017c\5\32\16\2\u017c!\3\2\2\2\u017d\u017e"+
		"\t\4\2\2\u017e#\3\2\2\2\u017f\u0184\5<\37\2\u0180\u0181\7V\2\2\u0181\u0183"+
		"\5<\37\2\u0182\u0180\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185%\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u019c\t\5\2\2"+
		"\u0188\u0189\7Q\2\2\u0189\u018e\7~\2\2\u018a\u018b\7V\2\2\u018b\u018d"+
		"\7~\2\2\u018c\u018a\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u019d\7R"+
		"\2\2\u0192\u0193\7S\2\2\u0193\u0198\7~\2\2\u0194\u0195\7V\2\2\u0195\u0197"+
		"\7~\2\2\u0196\u0194\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u019b\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019d\7T"+
		"\2\2\u019c\u0188\3\2\2\2\u019c\u0192\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019f\7Y\2\2\u019f\u01a0\5N(\2\u01a0\'\3\2\2\2\u01a1\u01a2\7)\2\2\u01a2"+
		"\u01a3\7O\2\2\u01a3\u01a4\5N(\2\u01a4\u01a5\7P\2\2\u01a5\u01a8\5*\26\2"+
		"\u01a6\u01a7\7\"\2\2\u01a7\u01a9\5*\26\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9)\3\2\2\2\u01aa\u01bb\5,\27\2\u01ab\u01bb\5\64\33\2\u01ac"+
		"\u01bb\5:\36\2\u01ad\u01bb\5L\'\2\u01ae\u01bb\5(\25\2\u01af\u01bb\5B\""+
		"\2\u01b0\u01bb\5D#\2\u01b1\u01bb\5F$\2\u01b2\u01bb\5H%\2\u01b3\u01bb\5"+
		"> \2\u01b4\u01bb\5@!\2\u01b5\u01bb\58\35\2\u01b6\u01bb\5\66\34\2\u01b7"+
		"\u01bb\5\62\32\2\u01b8\u01bb\5.\30\2\u01b9\u01bb\5\60\31\2\u01ba\u01aa"+
		"\3\2\2\2\u01ba\u01ab\3\2\2\2\u01ba\u01ac\3\2\2\2\u01ba\u01ad\3\2\2\2\u01ba"+
		"\u01ae\3\2\2\2\u01ba\u01af\3\2\2\2\u01ba\u01b0\3\2\2\2\u01ba\u01b1\3\2"+
		"\2\2\u01ba\u01b2\3\2\2\2\u01ba\u01b3\3\2\2\2\u01ba\u01b4\3\2\2\2\u01ba"+
		"\u01b5\3\2\2\2\u01ba\u01b6\3\2\2\2\u01ba\u01b7\3\2\2\2\u01ba\u01b8\3\2"+
		"\2\2\u01ba\u01b9\3\2\2\2\u01bb+\3\2\2\2\u01bc\u01bd\7U\2\2\u01bd-\3\2"+
		"\2\2\u01be\u01bf\5N(\2\u01bf/\3\2\2\2\u01c0\u01c1\7\25\2\2\u01c1\u01c4"+
		"\5N(\2\u01c2\u01c3\7_\2\2\u01c3\u01c5\5N(\2\u01c4\u01c2\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\61\3\2\2\2\u01c6\u01c7\7?\2\2\u01c7\u01c8\5N(\2\u01c8"+
		"\u01c9\7U\2\2\u01c9\63\3\2\2\2\u01ca\u01ce\7Q\2\2\u01cb\u01cd\5*\26\2"+
		"\u01cc\u01cb\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf"+
		"\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d2\7R\2\2\u01d2"+
		"\65\3\2\2\2\u01d3\u01e2\7B\2\2\u01d4\u01d5\7O\2\2\u01d5\u01da\5<\37\2"+
		"\u01d6\u01d7\7U\2\2\u01d7\u01d9\5<\37\2\u01d8\u01d6\3\2\2\2\u01d9\u01dc"+
		"\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01de\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dd\u01df\7U\2\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2"+
		"\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\7P\2\2\u01e1\u01e3\3\2\2\2\u01e2"+
		"\u01d4\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01ee\5\64"+
		"\33\2\u01e5\u01e6\7\32\2\2\u01e6\u01e7\7O\2\2\u01e7\u01e8\5\32\16\2\u01e8"+
		"\u01e9\7~\2\2\u01e9\u01ea\7P\2\2\u01ea\u01eb\5\64\33\2\u01eb\u01ed\3\2"+
		"\2\2\u01ec\u01e5\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee"+
		"\u01ef\3\2\2\2\u01ef\u01f3\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7&"+
		"\2\2\u01f2\u01f4\5\64\33\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\67\3\2\2\2\u01f5\u01f7\7\67\2\2\u01f6\u01f8\5N(\2\u01f7\u01f6\3\2\2\2"+
		"\u01f7\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa\7U\2\2\u01fa9\3\2"+
		"\2\2\u01fb\u01fc\5$\23\2\u01fc\u01fd\7U\2\2\u01fd\u0202\3\2\2\2\u01fe"+
		"\u01ff\5&\24\2\u01ff\u0200\7U\2\2\u0200\u0202\3\2\2\2\u0201\u01fb\3\2"+
		"\2\2\u0201\u01fe\3\2\2\2\u0202;\3\2\2\2\u0203\u0206\7\7\2\2\u0204\u0206"+
		"\7\b\2\2\u0205\u0203\3\2\2\2\u0205\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u020a\7~\2\2\u0208\u0209\7\4\2\2\u0209\u020b\5\30\r\2\u020a\u0208\3\2"+
		"\2\2\u020a\u020b\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020d\7Y\2\2\u020d"+
		"\u020f\5N(\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0217\3\2\2"+
		"\2\u0210\u0211\5\30\r\2\u0211\u0214\7~\2\2\u0212\u0213\7Y\2\2\u0213\u0215"+
		"\5N(\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2\2\2\u0216"+
		"\u0205\3\2\2\2\u0216\u0210\3\2\2\2\u0217=\3\2\2\2\u0218\u0219\7\27\2\2"+
		"\u0219\u021a\7U\2\2\u021a?\3\2\2\2\u021b\u021c\7\36\2\2\u021c\u021d\7"+
		"U\2\2\u021dA\3\2\2\2\u021e\u021f\7E\2\2\u021f\u0220\7O\2\2\u0220\u0221"+
		"\5N(\2\u0221\u0222\7P\2\2\u0222\u0223\5*\26\2\u0223C\3\2\2\2\u0224\u0225"+
		"\7 \2\2\u0225\u0226\5\64\33\2\u0226\u0227\7E\2\2\u0227\u0228\7O\2\2\u0228"+
		"\u0229\5N(\2\u0229\u022a\7P\2\2\u022a\u022b\7U\2\2\u022bE\3\2\2\2\u022c"+
		"\u022d\7(\2\2\u022d\u0230\7O\2\2\u022e\u0231\5$\23\2\u022f\u0231\5J&\2"+
		"\u0230\u022e\3\2\2\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232"+
		"\3\2\2\2\u0232\u0234\7U\2\2\u0233\u0235\5N(\2\u0234\u0233\3\2\2\2\u0234"+
		"\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238\7U\2\2\u0237\u0239\5J&"+
		"\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b"+
		"\7P\2\2\u023b\u023c\5*\26\2\u023cG\3\2\2\2\u023d\u023e\7(\2\2\u023e\u023f"+
		"\7O\2\2\u023f\u0242\7~\2\2\u0240\u0241\7V\2\2\u0241\u0243\7~\2\2\u0242"+
		"\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0245\7\5"+
		"\2\2\u0245\u0246\5N(\2\u0246\u0247\7P\2\2\u0247\u0248\5*\26\2\u0248\u0256"+
		"\3\2\2\2\u0249\u024a\7\t\2\2\u024a\u024b\7O\2\2\u024b\u024c\5N(\2\u024c"+
		"\u024f\7\4\2\2\u024d\u024e\7~\2\2\u024e\u0250\7V\2\2\u024f\u024d\3\2\2"+
		"\2\u024f\u0250\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\7~\2\2\u0252\u0253"+
		"\7P\2\2\u0253\u0254\5*\26\2\u0254\u0256\3\2\2\2\u0255\u023d\3\2\2\2\u0255"+
		"\u0249\3\2\2\2\u0256I\3\2\2\2\u0257\u025c\5N(\2\u0258\u0259\7V\2\2\u0259"+
		"\u025b\5N(\2\u025a\u0258\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2"+
		"\2\u025c\u025d\3\2\2\2\u025dK\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0260"+
		"\5N(\2\u0260\u0261\7U\2\2\u0261M\3\2\2\2\u0262\u0263\b(\1\2\u0263\u0264"+
		"\7O\2\2\u0264\u0265\5N(\2\u0265\u0266\7P\2\2\u0266\u0341\3\2\2\2\u0267"+
		"\u0341\t\6\2\2\u0268\u0341\5P)\2\u0269\u026b\5\34\17\2\u026a\u0269\3\2"+
		"\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u0276\7Q\2\2\u026d"+
		"\u0272\7~\2\2\u026e\u026f\7V\2\2\u026f\u0271\7~\2\2\u0270\u026e\3\2\2"+
		"\2\u0271\u0274\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0275"+
		"\3\2\2\2\u0274\u0272\3\2\2\2\u0275\u0277\7\13\2\2\u0276\u026d\3\2\2\2"+
		"\u0276\u0277\3\2\2\2\u0277\u027b\3\2\2\2\u0278\u027a\5*\26\2\u0279\u0278"+
		"\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c"+
		"\u027e\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u029b\7R\2\2\u027f\u0288\7O\2"+
		"\2\u0280\u0285\7~\2\2\u0281\u0282\7V\2\2\u0282\u0284\7~\2\2\u0283\u0281"+
		"\3\2\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0288\u0280\3\2\2\2\u0288\u0289\3\2"+
		"\2\2\u0289\u028a\3\2\2\2\u028a\u028d\7P\2\2\u028b\u028d\7~\2\2\u028c\u027f"+
		"\3\2\2\2\u028c\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0298\7\13\2\2"+
		"\u028f\u0293\7Q\2\2\u0290\u0292\5*\26\2\u0291\u0290\3\2\2\2\u0292\u0295"+
		"\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0296\3\2\2\2\u0295"+
		"\u0293\3\2\2\2\u0296\u0299\7R\2\2\u0297\u0299\5N(\2\u0298\u028f\3\2\2"+
		"\2\u0298\u0297\3\2\2\2\u0299\u029b\3\2\2\2\u029a\u026a\3\2\2\2\u029a\u028c"+
		"\3\2\2\2\u029b\u0341\3\2\2\2\u029c\u029d\7[\2\2\u029d\u029e\7~\2\2\u029e"+
		"\u029f\7V\2\2\u029f\u02a0\7~\2\2\u02a0\u02a2\7Z\2\2\u02a1\u029c\3\2\2"+
		"\2\u02a1\u02a2\3\2\2\2\u02a2\u02b9\3\2\2\2\u02a3\u02a4\7S\2\2\u02a4\u02a5"+
		"\5N(\2\u02a5\u02a6\7_\2\2\u02a6\u02ae\5N(\2\u02a7\u02a8\7V\2\2\u02a8\u02a9"+
		"\5N(\2\u02a9\u02aa\7_\2\2\u02aa\u02ab\5N(\2\u02ab\u02ad\3\2\2\2\u02ac"+
		"\u02a7\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2"+
		"\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b1\u02b3\7V\2\2\u02b2"+
		"\u02b1\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\7T"+
		"\2\2\u02b5\u02ba\3\2\2\2\u02b6\u02b7\7S\2\2\u02b7\u02b8\7_\2\2\u02b8\u02ba"+
		"\7T\2\2\u02b9\u02a3\3\2\2\2\u02b9\u02b6\3\2\2\2\u02ba\u0341\3\2\2\2\u02bb"+
		"\u02bc\7[\2\2\u02bc\u02bd\5\30\r\2\u02bd\u02be\7Z\2\2\u02be\u02c0\3\2"+
		"\2\2\u02bf\u02bb\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1"+
		"\u02ca\7S\2\2\u02c2\u02c7\5N(\2\u02c3\u02c4\7V\2\2\u02c4\u02c6\5N(\2\u02c5"+
		"\u02c3\3\2\2\2\u02c6\u02c9\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c7\u02c8\3\2"+
		"\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2\2\2\u02ca\u02c2\3\2\2\2\u02ca"+
		"\u02cb\3\2\2\2\u02cb\u02cd\3\2\2\2\u02cc\u02ce\7V\2\2\u02cd\u02cc\3\2"+
		"\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u0341\7T\2\2\u02d0"+
		"\u02d4\7~\2\2\u02d1\u02d4\7>\2\2\u02d2\u02d4\7;\2\2\u02d3\u02d0\3\2\2"+
		"\2\u02d3\u02d1\3\2\2\2\u02d3\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02de"+
		"\7O\2\2\u02d6\u02db\5N(\2\u02d7\u02d8\7V\2\2\u02d8\u02da\5N(\2\u02d9\u02d7"+
		"\3\2\2\2\u02da\u02dd\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02df\3\2\2\2\u02dd\u02db\3\2\2\2\u02de\u02d6\3\2\2\2\u02de\u02df\3\2"+
		"\2\2\u02df\u02e0\3\2\2\2\u02e0\u0341\7P\2\2\u02e1\u02e2\7\62\2\2\u02e2"+
		"\u02e3\5\32\16\2\u02e3\u02ec\7O\2\2\u02e4\u02e9\5N(\2\u02e5\u02e6\7V\2"+
		"\2\u02e6\u02e8\5N(\2\u02e7\u02e5\3\2\2\2\u02e8\u02eb\3\2\2\2\u02e9\u02e7"+
		"\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02ed\3\2\2\2\u02eb\u02e9\3\2\2\2\u02ec"+
		"\u02e4\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ef\7P"+
		"\2\2\u02ef\u0341\3\2\2\2\u02f0\u02f1\7\62\2\2\u02f1\u02f6\5\30\r\2\u02f2"+
		"\u02f3\7S\2\2\u02f3\u02f4\5N(\2\u02f4\u02f5\7T\2\2\u02f5\u02f7\3\2\2\2"+
		"\u02f6\u02f2\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9"+
		"\3\2\2\2\u02f9\u02fe\3\2\2\2\u02fa\u02fb\7S\2\2\u02fb\u02fd\7T\2\2\u02fc"+
		"\u02fa\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2"+
		"\2\2\u02ff\u0313\3\2\2\2\u0300\u02fe\3\2\2\2\u0301\u0302\7\62\2\2\u0302"+
		"\u0303\5\30\r\2\u0303\u0304\7S\2\2\u0304\u0305\7T\2\2\u0305\u030e\7Q\2"+
		"\2\u0306\u030b\5N(\2\u0307\u0308\7V\2\2\u0308\u030a\5N(\2\u0309\u0307"+
		"\3\2\2\2\u030a\u030d\3\2\2\2\u030b\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c"+
		"\u030f\3\2\2\2\u030d\u030b\3\2\2\2\u030e\u0306\3\2\2\2\u030e\u030f\3\2"+
		"\2\2\u030f\u0310\3\2\2\2\u0310\u0311\7R\2\2\u0311\u0313\3\2\2\2\u0312"+
		"\u02f0\3\2\2\2\u0312\u0301\3\2\2\2\u0313\u0341\3\2\2\2\u0314\u0315\t\7"+
		"\2\2\u0315\u0341\5N(\27\u0316\u0317\t\b\2\2\u0317\u0341\5N(\26\u0318\u0319"+
		"\t\t\2\2\u0319\u0341\5N(\25\u031a\u031b\7O\2\2\u031b\u031c\5\30\r\2\u031c"+
		"\u031d\7P\2\2\u031d\u031e\5N(\24\u031e\u0341\3\2\2\2\u031f\u0341\7~\2"+
		"\2\u0320\u0321\7}\2\2\u0321\u032a\5N(\2\u0322\u0324\7R\2\2\u0323\u0325"+
		"\7\u0089\2\2\u0324\u0323\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\3\2\2"+
		"\2\u0326\u0327\7\u0087\2\2\u0327\u0329\5N(\2\u0328\u0322\3\2\2\2\u0329"+
		"\u032c\3\2\2\2\u032a\u0328\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032d\3\2"+
		"\2\2\u032c\u032a\3\2\2\2\u032d\u032f\7R\2\2\u032e\u0330\7\u0089\2\2\u032f"+
		"\u032e\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0332\7\u0088"+
		"\2\2\u0332\u0341\3\2\2\2\u0333\u0334\7G\2\2\u0334\u0335\7O\2\2\u0335\u0336"+
		"\5N(\2\u0336\u0337\7P\2\2\u0337\u033b\7Q\2\2\u0338\u033a\5*\26\2\u0339"+
		"\u0338\3\2\2\2\u033a\u033d\3\2\2\2\u033b\u0339\3\2\2\2\u033b\u033c\3\2"+
		"\2\2\u033c\u033e\3\2\2\2\u033d\u033b\3\2\2\2\u033e\u033f\7R\2\2\u033f"+
		"\u0341\3\2\2\2\u0340\u0262\3\2\2\2\u0340\u0267\3\2\2\2\u0340\u0268\3\2"+
		"\2\2\u0340\u029a\3\2\2\2\u0340\u02a1\3\2\2\2\u0340\u02bf\3\2\2\2\u0340"+
		"\u02d3\3\2\2\2\u0340\u02e1\3\2\2\2\u0340\u0312\3\2\2\2\u0340\u0314\3\2"+
		"\2\2\u0340\u0316\3\2\2\2\u0340\u0318\3\2\2\2\u0340\u031a\3\2\2\2\u0340"+
		"\u031f\3\2\2\2\u0340\u0320\3\2\2\2\u0340\u0333\3\2\2\2\u0341\u0394\3\2"+
		"\2\2\u0342\u0343\f\23\2\2\u0343\u0344\t\n\2\2\u0344\u0393\5N(\24\u0345"+
		"\u0346\f\22\2\2\u0346\u0347\t\7\2\2\u0347\u0393\5N(\23\u0348\u0350\f\21"+
		"\2\2\u0349\u034a\7[\2\2\u034a\u0351\7[\2\2\u034b\u034c\7Z\2\2\u034c\u034d"+
		"\7Z\2\2\u034d\u0351\7Z\2\2\u034e\u034f\7Z\2\2\u034f\u0351\7Z\2\2\u0350"+
		"\u0349\3\2\2\2\u0350\u034b\3\2\2\2\u0350\u034e\3\2\2\2\u0351\u0352\3\2"+
		"\2\2\u0352\u0393\5N(\22\u0353\u0354\f\20\2\2\u0354\u0355\t\13\2\2\u0355"+
		"\u0393\5N(\21\u0356\u0357\f\16\2\2\u0357\u0358\t\f\2\2\u0358\u0393\5N"+
		"(\17\u0359\u035a\f\r\2\2\u035a\u035b\7n\2\2\u035b\u0393\5N(\16\u035c\u035d"+
		"\f\f\2\2\u035d\u035e\7p\2\2\u035e\u0393\5N(\r\u035f\u0360\f\13\2\2\u0360"+
		"\u0361\7o\2\2\u0361\u0393\5N(\f\u0362\u0363\f\n\2\2\u0363\u0364\t\r\2"+
		"\2\u0364\u0393\5N(\13\u0365\u0366\f\t\2\2\u0366\u0367\7\20\2\2\u0367\u0393"+
		"\5N(\n\u0368\u0369\f\b\2\2\u0369\u036a\7^\2\2\u036a\u036b\5N(\2\u036b"+
		"\u036c\7_\2\2\u036c\u036d\5N(\t\u036d\u0393\3\2\2\2\u036e\u036f\f\3\2"+
		"\2\u036f\u0370\t\16\2\2\u0370\u0393\5N(\3\u0371\u0372\f\37\2\2\u0372\u0373"+
		"\t\17\2\2\u0373\u0374\t\20\2\2\u0374\u037d\7O\2\2\u0375\u037a\5N(\2\u0376"+
		"\u0377\7V\2\2\u0377\u0379\5N(\2\u0378\u0376\3\2\2\2\u0379\u037c\3\2\2"+
		"\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037e\3\2\2\2\u037c\u037a"+
		"\3\2\2\2\u037d\u0375\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u037f\3\2\2\2\u037f"+
		"\u0393\7P\2\2\u0380\u0381\f\36\2\2\u0381\u0382\t\21\2\2\u0382\u0393\t"+
		"\20\2\2\u0383\u0384\f\35\2\2\u0384\u0385\7\3\2\2\u0385\u0393\7~\2\2\u0386"+
		"\u0387\f\33\2\2\u0387\u0388\7S\2\2\u0388\u0389\5N(\2\u0389\u038a\7T\2"+
		"\2\u038a\u0393\3\2\2\2\u038b\u038c\f\30\2\2\u038c\u0393\t\b\2\2\u038d"+
		"\u038e\f\17\2\2\u038e\u038f\7-\2\2\u038f\u0393\7~\2\2\u0390\u0391\f\6"+
		"\2\2\u0391\u0393\7W\2\2\u0392\u0342\3\2\2\2\u0392\u0345\3\2\2\2\u0392"+
		"\u0348\3\2\2\2\u0392\u0353\3\2\2\2\u0392\u0356\3\2\2\2\u0392\u0359\3\2"+
		"\2\2\u0392\u035c\3\2\2\2\u0392\u035f\3\2\2\2\u0392\u0362\3\2\2\2\u0392"+
		"\u0365\3\2\2\2\u0392\u0368\3\2\2\2\u0392\u036e\3\2\2\2\u0392\u0371\3\2"+
		"\2\2\u0392\u0380\3\2\2\2\u0392\u0383\3\2\2\2\u0392\u0386\3\2\2\2\u0392"+
		"\u038b\3\2\2\2\u0392\u038d\3\2\2\2\u0392\u0390\3\2\2\2\u0393\u0396\3\2"+
		"\2\2\u0394\u0392\3\2\2\2\u0394\u0395\3\2\2\2\u0395O\3\2\2\2\u0396\u0394"+
		"\3\2\2\2\u0397\u03a9\7H\2\2\u0398\u03a9\7I\2\2\u0399\u03a9\7K\2\2\u039a"+
		"\u03a9\7L\2\2\u039b\u03a9\7M\2\2\u039c\u03a9\7J\2\2\u039d\u03a0\5\"\22"+
		"\2\u039e\u03a0\7~\2\2\u039f\u039d\3\2\2\2\u039f\u039e\3\2\2\2\u03a0\u03a3"+
		"\3\2\2\2\u03a1\u03a2\7S\2\2\u03a2\u03a4\7T\2\2\u03a3\u03a1\3\2\2\2\u03a3"+
		"\u03a4\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6\7W\2\2\u03a6\u03a9\7\34"+
		"\2\2\u03a7\u03a9\7N\2\2\u03a8\u0397\3\2\2\2\u03a8\u0398\3\2\2\2\u03a8"+
		"\u0399\3\2\2\2\u03a8\u039a\3\2\2\2\u03a8\u039b\3\2\2\2\u03a8\u039c\3\2"+
		"\2\2\u03a8\u039f\3\2\2\2\u03a8\u03a7\3\2\2\2\u03a9Q\3\2\2\2\u03aa\u03ac"+
		"\t\22\2\2\u03ab\u03aa\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ab\3\2\2\2"+
		"\u03ad\u03ae\3\2\2\2\u03aeS\3\2\2\2\177W]bikqu~\u0082\u0085\u0088\u008c"+
		"\u0094\u0097\u009f\u00a2\u00a9\u00b0\u00b3\u00b7\u00be\u00c5\u00c8\u00ca"+
		"\u00d3\u00d9\u00db\u00df\u00e6\u00ee\u00f2\u00f5\u00f8\u00fe\u0106\u0109"+
		"\u0112\u0115\u0119\u011d\u0122\u0130\u0134\u0137\u013c\u0142\u0146\u014d"+
		"\u0157\u015c\u015f\u0162\u016c\u016f\u0173\u0177\u0184\u018e\u0198\u019c"+
		"\u01a8\u01ba\u01c4\u01ce\u01da\u01de\u01e2\u01ee\u01f3\u01f7\u0201\u0205"+
		"\u020a\u020e\u0214\u0216\u0230\u0234\u0238\u0242\u024f\u0255\u025c\u026a"+
		"\u0272\u0276\u027b\u0285\u0288\u028c\u0293\u0298\u029a\u02a1\u02ae\u02b2"+
		"\u02b9\u02bf\u02c7\u02ca\u02cd\u02d3\u02db\u02de\u02e9\u02ec\u02f8\u02fe"+
		"\u030b\u030e\u0312\u0324\u032a\u032f\u033b\u0340\u0350\u037a\u037d\u0392"+
		"\u0394\u039f\u03a3\u03a8\u03ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
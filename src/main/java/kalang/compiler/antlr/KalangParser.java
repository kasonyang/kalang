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
		PACKAGE_DELIMITER=131, UNTERMINATED_STRING=132, UNTERMINATED_MULTILINE_STRING=133, 
		UNCLOSED_COMMENT=134, UNKNOWN_CHAR=135, INTERPOLATION_INTERUPT=136, INTERPOLATION_END=137, 
		INTERPOLATION_STRING=138;
	public static final int
		RULE_standardCompilationUnit = 0, RULE_scriptCompilationUnit = 1, RULE_compileOption = 2, 
		RULE_scriptDef = 3, RULE_classDef = 4, RULE_importDecl = 5, RULE_qualifiedName = 6, 
		RULE_classBody = 7, RULE_fieldDecl = 8, RULE_methodDecl = 9, RULE_paramDecl = 10, 
		RULE_annotation = 11, RULE_type = 12, RULE_classType = 13, RULE_lambdaType = 14, 
		RULE_parameterizedElementType = 15, RULE_wildcardType = 16, RULE_typeParameter = 17, 
		RULE_primitiveType = 18, RULE_localVarDecl = 19, RULE_destructuringLocalVarDecl = 20, 
		RULE_ifStat = 21, RULE_stat = 22, RULE_unterminatedStmt = 23, RULE_emptyStat = 24, 
		RULE_errorousStat = 25, RULE_assertStmt = 26, RULE_throwStat = 27, RULE_blockStmt = 28, 
		RULE_tryStat = 29, RULE_returnStat = 30, RULE_varDeclStat = 31, RULE_varDecl = 32, 
		RULE_breakStat = 33, RULE_continueStat = 34, RULE_whileStat = 35, RULE_doWhileStat = 36, 
		RULE_forStat = 37, RULE_forEachStat = 38, RULE_expressions = 39, RULE_exprStat = 40, 
		RULE_expression = 41, RULE_optionalKeyValue = 42, RULE_literal = 43, RULE_varModifier = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"standardCompilationUnit", "scriptCompilationUnit", "compileOption", 
			"scriptDef", "classDef", "importDecl", "qualifiedName", "classBody", 
			"fieldDecl", "methodDecl", "paramDecl", "annotation", "type", "classType", 
			"lambdaType", "parameterizedElementType", "wildcardType", "typeParameter", 
			"primitiveType", "localVarDecl", "destructuringLocalVarDecl", "ifStat", 
			"stat", "unterminatedStmt", "emptyStat", "errorousStat", "assertStmt", 
			"throwStat", "blockStmt", "tryStat", "returnStat", "varDeclStat", "varDecl", 
			"breakStat", "continueStat", "whileStat", "doWhileStat", "forStat", "forEachStat", 
			"expressions", "exprStat", "expression", "optionalKeyValue", "literal", 
			"varModifier"
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
			null, null, null, null, "'\\'", null, null, null, null, "'${'", "'\"'"
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
			"LINE_COMMENT", "PACKAGE_DELIMITER", "UNTERMINATED_STRING", "UNTERMINATED_MULTILINE_STRING", 
			"UNCLOSED_COMMENT", "UNKNOWN_CHAR", "INTERPOLATION_INTERUPT", "INTERPOLATION_END", 
			"INTERPOLATION_STRING"
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

	public static class StandardCompilationUnitContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public TerminalNode EOF() { return getToken(KalangParser.EOF, 0); }
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public StandardCompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardCompilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterStandardCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitStandardCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitStandardCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandardCompilationUnitContext standardCompilationUnit() throws RecognitionException {
		StandardCompilationUnitContext _localctx = new StandardCompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_standardCompilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(90);
				importDecl();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			classDef();
			setState(97);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptCompilationUnitContext extends ParserRuleContext {
		public ScriptDefContext scriptDef() {
			return getRuleContext(ScriptDefContext.class,0);
		}
		public TerminalNode EOF() { return getToken(KalangParser.EOF, 0); }
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
		public ScriptCompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptCompilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterScriptCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitScriptCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitScriptCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptCompilationUnitContext scriptCompilationUnit() throws RecognitionException {
		ScriptCompilationUnitContext _localctx = new ScriptCompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_scriptCompilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPILE_OPTION_LINE) {
				{
				{
				setState(99);
				compileOption();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(105);
				importDecl();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			scriptDef();
			setState(112);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 4, RULE_compileOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
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
		enterRule(_localctx, 6, RULE_scriptDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << SUPER) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRANSIENT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (VOLATILE - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(116);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(117);
					stat();
					}
					break;
				case 3:
					{
					setState(118);
					classDef();
					}
					break;
				}
				}
				setState(123);
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
		public TypeParameterContext typeParameter;
		public List<TypeParameterContext> typeParam = new ArrayList<TypeParameterContext>();
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
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
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
		enterRule(_localctx, 8, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(124);
				annotation();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) {
				{
				setState(130);
				varModifier();
				}
			}

			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(133);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(134);
					match(LT);
					setState(135);
					((ClassDefContext)_localctx).typeParameter = typeParameter();
					((ClassDefContext)_localctx).typeParam.add(((ClassDefContext)_localctx).typeParameter);
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(136);
						match(COMMA);
						setState(137);
						((ClassDefContext)_localctx).typeParameter = typeParameter();
						((ClassDefContext)_localctx).typeParam.add(((ClassDefContext)_localctx).typeParameter);
						}
						}
						setState(142);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(143);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(147);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(150);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(153);
				match(EXTENDS);
				setState(154);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(157);
				match(IMPLEMENTS);
				setState(158);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(159);
					match(COMMA);
					setState(160);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(168);
			match(LBRACE);
			setState(169);
			classBody();
			setState(170);
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
		public Token star;
		public Token alias;
		public TerminalNode IMPORT() { return getToken(KalangParser.IMPORT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public TerminalNode DOT() { return getToken(KalangParser.DOT, 0); }
		public TerminalNode AS() { return getToken(KalangParser.AS, 0); }
		public TerminalNode MUL() { return getToken(KalangParser.MUL, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode STATIC() { return getToken(KalangParser.STATIC, 0); }
		public TerminalNode MIXIN() { return getToken(KalangParser.MIXIN, 0); }
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
		enterRule(_localctx, 10, RULE_importDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IMPORT);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC || _la==MIXIN) {
				{
				setState(173);
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

			setState(176);
			qualifiedName();
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(177);
				match(DOT);
				setState(178);
				((ImportDeclContext)_localctx).star = match(MUL);
				}
				break;
			case AS:
				{
				setState(179);
				match(AS);
				setState(180);
				((ImportDeclContext)_localctx).alias = match(Identifier);
				}
				break;
			case SEMI:
				break;
			default:
				break;
			}
			setState(183);
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
		public Token Identifier;
		public List<Token> names = new ArrayList<Token>();
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
		enterRule(_localctx, 12, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(185);
					((QualifiedNameContext)_localctx).Identifier = match(Identifier);
					((QualifiedNameContext)_localctx).names.add(((QualifiedNameContext)_localctx).Identifier);
					setState(186);
					match(DOT);
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(192);
			((QualifiedNameContext)_localctx).Identifier = match(Identifier);
			((QualifiedNameContext)_localctx).names.add(((QualifiedNameContext)_localctx).Identifier);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 14, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (VOLATILE - 65)) | (1L << (LT - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)) | (1L << (AT - 65)))) != 0)) {
				{
				setState(197);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(194);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(195);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(196);
					classDef();
					}
					break;
				}
				}
				setState(201);
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
		enterRule(_localctx, 16, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) {
				{
				setState(202);
				varModifier();
				}
			}

			setState(205);
			varDecl();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(206);
				match(COMMA);
				setState(207);
				varDecl();
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
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
		public TypeParameterContext typeParameter;
		public List<TypeParameterContext> typeParam = new ArrayList<TypeParameterContext>();
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
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
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
		enterRule(_localctx, 18, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(215);
				annotation();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(221);
				match(OVERRIDE);
				}
			}

			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(224);
				match(DEFAULT);
				}
			}

			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)))) != 0)) {
				{
				setState(227);
				varModifier();
				}
			}

			setState(247);
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
			case LT:
			case BITAND:
			case Identifier:
				{
				{
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(230);
					match(LT);
					setState(231);
					((MethodDeclContext)_localctx).typeParameter = typeParameter();
					((MethodDeclContext)_localctx).typeParam.add(((MethodDeclContext)_localctx).typeParameter);
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(232);
						match(COMMA);
						setState(233);
						((MethodDeclContext)_localctx).typeParameter = typeParameter();
						((MethodDeclContext)_localctx).typeParam.add(((MethodDeclContext)_localctx).typeParameter);
						}
						}
						setState(238);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(239);
					match(GT);
					}
				}

				setState(243);
				((MethodDeclContext)_localctx).returnType = type(0);
				setState(244);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case CONSTRUCTOR:
				{
				{
				setState(246);
				((MethodDeclContext)_localctx).prefix = match(CONSTRUCTOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(249);
			match(LPAREN);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(250);
				((MethodDeclContext)_localctx).paramDecl = paramDecl();
				((MethodDeclContext)_localctx).params.add(((MethodDeclContext)_localctx).paramDecl);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(251);
					match(COMMA);
					setState(252);
					((MethodDeclContext)_localctx).paramDecl = paramDecl();
					((MethodDeclContext)_localctx).params.add(((MethodDeclContext)_localctx).paramDecl);
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(260);
			match(RPAREN);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(261);
				match(THROWS);
				setState(262);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(263);
					match(COMMA);
					setState(264);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(272);
				blockStmt();
				}
				break;
			case SEMI:
				{
				setState(273);
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
		enterRule(_localctx, 20, RULE_paramDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			((ParamDeclContext)_localctx).paramType = type(0);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELLIPSIS) {
				{
				setState(277);
				((ParamDeclContext)_localctx).VARARGS = match(ELLIPSIS);
				}
			}

			setState(280);
			((ParamDeclContext)_localctx).paramId = match(Identifier);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(281);
				match(ASSIGN);
				setState(282);
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
		enterRule(_localctx, 22, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(AT);
			setState(286);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(287);
				match(LPAREN);
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					{
					setState(288);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(289);
					match(ASSIGN);
					setState(290);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(291);
						match(COMMA);
						setState(292);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(293);
						match(ASSIGN);
						setState(294);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(299);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(300);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(303);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BITAND:
			case Identifier:
				{
				setState(307);
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
				setState(308);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
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
					setState(311);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(312);
					match(LBRACK);
					setState(313);
					match(RBRACK);
					setState(315);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(314);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(321);
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
		public Token typeArgsPrefix;
		public ParameterizedElementTypeContext parameterizedElementType;
		public List<ParameterizedElementTypeContext> parameterTypes = new ArrayList<ParameterizedElementTypeContext>();
		public Token nullable;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode GT() { return getToken(KalangParser.GT, 0); }
		public TerminalNode LT() { return getToken(KalangParser.LT, 0); }
		public TerminalNode QUESTION() { return getToken(KalangParser.QUESTION, 0); }
		public List<ParameterizedElementTypeContext> parameterizedElementType() {
			return getRuleContexts(ParameterizedElementTypeContext.class);
		}
		public ParameterizedElementTypeContext parameterizedElementType(int i) {
			return getRuleContext(ParameterizedElementTypeContext.class,i);
		}
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
		enterRule(_localctx, 26, RULE_classType);
		int _la;
		try {
			setState(341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				qualifiedName();
				setState(335);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(323);
					((ClassTypeContext)_localctx).typeArgsPrefix = match(LT);
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (QUESTION - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						setState(324);
						((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
						((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
						setState(329);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(325);
							match(COMMA);
							setState(326);
							((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
							((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
							}
							}
							setState(331);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(334);
					match(GT);
					}
					break;
				}
				setState(338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(337);
					((ClassTypeContext)_localctx).nullable = match(QUESTION);
					}
					break;
				}
				}
				break;
			case BITAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
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
		enterRule(_localctx, 28, RULE_lambdaType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(BITAND);
			setState(344);
			((LambdaTypeContext)_localctx).returnType = type(0);
			setState(345);
			match(LPAREN);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(346);
				((LambdaTypeContext)_localctx).type = type(0);
				((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(347);
					match(COMMA);
					setState(348);
					((LambdaTypeContext)_localctx).type = type(0);
					((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(356);
			match(RPAREN);
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(357);
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
		enterRule(_localctx, 30, RULE_parameterizedElementType);
		try {
			setState(362);
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
				setState(360);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
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
		enterRule(_localctx, 32, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(QUESTION);
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==SUPER) {
				{
				setState(365);
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
				setState(366);
				classType();
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

	public static class TypeParameterContext extends ParserRuleContext {
		public ClassTypeContext classType;
		public List<ClassTypeContext> bounds = new ArrayList<ClassTypeContext>();
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode EXTENDS() { return getToken(KalangParser.EXTENDS, 0); }
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public List<TerminalNode> BITAND() { return getTokens(KalangParser.BITAND); }
		public TerminalNode BITAND(int i) {
			return getToken(KalangParser.BITAND, i);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(Identifier);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(370);
				match(EXTENDS);
				setState(371);
				((TypeParameterContext)_localctx).classType = classType();
				((TypeParameterContext)_localctx).bounds.add(((TypeParameterContext)_localctx).classType);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(372);
					match(BITAND);
					setState(373);
					((TypeParameterContext)_localctx).classType = classType();
					((TypeParameterContext)_localctx).bounds.add(((TypeParameterContext)_localctx).classType);
					}
					}
					setState(378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 36, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
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
		enterRule(_localctx, 38, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			varDecl();
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(384);
				match(COMMA);
				setState(385);
				varDecl();
				}
				}
				setState(390);
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
		enterRule(_localctx, 40, RULE_destructuringLocalVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
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
			setState(412);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(392);
				((DestructuringLocalVarDeclContext)_localctx).op = match(LBRACE);
				setState(393);
				match(Identifier);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(394);
					match(COMMA);
					setState(395);
					match(Identifier);
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(401);
				match(RBRACE);
				}
				break;
			case LBRACK:
				{
				setState(402);
				((DestructuringLocalVarDeclContext)_localctx).op = match(LBRACK);
				setState(403);
				match(Identifier);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(404);
					match(COMMA);
					setState(405);
					match(Identifier);
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(411);
				match(RBRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(414);
			match(ASSIGN);
			setState(415);
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
		enterRule(_localctx, 42, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(IF);
			setState(418);
			match(LPAREN);
			setState(419);
			expression(0);
			setState(420);
			match(RPAREN);
			setState(421);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(422);
				match(ELSE);
				setState(423);
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
		public AssertStmtContext assertStmt() {
			return getRuleContext(AssertStmtContext.class,0);
		}
		public UnterminatedStmtContext unterminatedStmt() {
			return getRuleContext(UnterminatedStmtContext.class,0);
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
		enterRule(_localctx, 44, RULE_stat);
		try {
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(426);
				emptyStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				blockStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(428);
				varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(429);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(430);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(431);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(432);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(433);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(434);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(435);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(436);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(437);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(438);
				tryStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(439);
				throwStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(440);
				assertStmt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(441);
				unterminatedStmt();
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

	public static class UnterminatedStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(KalangParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public UnterminatedStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unterminatedStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterUnterminatedStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitUnterminatedStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitUnterminatedStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnterminatedStmtContext unterminatedStmt() throws RecognitionException {
		UnterminatedStmtContext _localctx = new UnterminatedStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unterminatedStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			expression(0);
			setState(445);
			match(DOT);
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(446);
				match(Identifier);
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
		enterRule(_localctx, 48, RULE_emptyStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 50, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
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
		enterRule(_localctx, 52, RULE_assertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(ASSERT);
			setState(454);
			((AssertStmtContext)_localctx).testCondition = expression(0);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(455);
				match(COLON);
				setState(456);
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
		enterRule(_localctx, 54, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(THROW);
			setState(460);
			expression(0);
			setState(461);
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
		enterRule(_localctx, 56, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(LBRACE);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(464);
				stat();
				}
				}
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(470);
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
		enterRule(_localctx, 58, RULE_tryStat);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(TRY);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(473);
				match(LPAREN);
				setState(474);
				((TryStatContext)_localctx).varDecl = varDecl();
				((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
				setState(479);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(475);
						match(SEMI);
						setState(476);
						((TryStatContext)_localctx).varDecl = varDecl();
						((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
						}
						} 
					}
					setState(481);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(482);
					match(SEMI);
					}
				}

				setState(485);
				match(RPAREN);
				}
			}

			setState(489);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(490);
				match(CATCH);
				setState(491);
				match(LPAREN);
				setState(492);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(493);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(494);
				match(RPAREN);
				setState(495);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(502);
				match(FINALLY);
				setState(503);
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
		enterRule(_localctx, 60, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			match(RETURN);
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(507);
				expression(0);
				}
			}

			setState(510);
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
		enterRule(_localctx, 62, RULE_varDeclStat);
		try {
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				localVarDecl();
				setState(513);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(515);
				destructuringLocalVarDecl();
				setState(516);
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
		enterRule(_localctx, 64, RULE_varDecl);
		int _la;
		try {
			setState(539);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(522);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(520);
					((VarDeclContext)_localctx).varToken = match(VAR);
					}
					break;
				case VAL:
					{
					setState(521);
					((VarDeclContext)_localctx).valToken = match(VAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(524);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(525);
					match(AS);
					setState(526);
					type(0);
					}
				}

				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(529);
					match(ASSIGN);
					setState(530);
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
				setState(533);
				((VarDeclContext)_localctx).varType = type(0);
				setState(534);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(535);
					match(ASSIGN);
					setState(536);
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
		enterRule(_localctx, 66, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(BREAK);
			setState(542);
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
		enterRule(_localctx, 68, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(CONTINUE);
			setState(545);
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
		enterRule(_localctx, 70, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(WHILE);
			setState(548);
			match(LPAREN);
			setState(549);
			expression(0);
			setState(550);
			match(RPAREN);
			setState(551);
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
		enterRule(_localctx, 72, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(DO);
			setState(554);
			blockStmt();
			setState(555);
			match(WHILE);
			setState(556);
			match(LPAREN);
			setState(557);
			expression(0);
			setState(558);
			match(RPAREN);
			setState(559);
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
		enterRule(_localctx, 74, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(FOR);
			setState(562);
			match(LPAREN);
			setState(565);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(563);
				localVarDecl();
				}
				break;
			case 2:
				{
				setState(564);
				((ForStatContext)_localctx).initExpressions = expressions();
				}
				break;
			}
			setState(567);
			match(SEMI);
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(568);
				((ForStatContext)_localctx).condition = expression(0);
				}
			}

			setState(571);
			match(SEMI);
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(572);
				((ForStatContext)_localctx).updateExpressions = expressions();
				}
			}

			setState(575);
			match(RPAREN);
			setState(576);
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
		enterRule(_localctx, 76, RULE_forEachStat);
		int _la;
		try {
			setState(602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(578);
				match(FOR);
				setState(579);
				match(LPAREN);
				setState(580);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(581);
					match(COMMA);
					setState(582);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					}
				}

				setState(585);
				match(IN);
				setState(586);
				expression(0);
				setState(587);
				match(RPAREN);
				setState(588);
				stat();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(590);
				match(FOREACH);
				setState(591);
				match(LPAREN);
				setState(592);
				expression(0);
				setState(593);
				match(AS);
				setState(596);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(594);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					setState(595);
					match(COMMA);
					}
					break;
				}
				setState(598);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(599);
				match(RPAREN);
				setState(600);
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
		enterRule(_localctx, 78, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			expression(0);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(605);
				match(COMMA);
				setState(606);
				expression(0);
				}
				}
				setState(611);
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
		enterRule(_localctx, 80, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			expression(0);
			setState(613);
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
	public static class StructuringNewExprContext extends ExpressionContext {
		public OptionalKeyValueContext optionalKeyValue;
		public List<OptionalKeyValueContext> keyValues = new ArrayList<OptionalKeyValueContext>();
		public TerminalNode NEW() { return getToken(KalangParser.NEW, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(KalangParser.LPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(KalangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KalangParser.RBRACE, 0); }
		public TerminalNode RPAREN() { return getToken(KalangParser.RPAREN, 0); }
		public List<OptionalKeyValueContext> optionalKeyValue() {
			return getRuleContexts(OptionalKeyValueContext.class);
		}
		public OptionalKeyValueContext optionalKeyValue(int i) {
			return getRuleContext(OptionalKeyValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KalangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KalangParser.COMMA, i);
		}
		public StructuringNewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterStructuringNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitStructuringNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitStructuringNewExpr(this);
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
		public TerminalNode LAMBDA_ARROW() { return getToken(KalangParser.LAMBDA_ARROW, 0); }
		public TerminalNode ARROW() { return getToken(KalangParser.ARROW, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(616);
				match(LPAREN);
				setState(617);
				expression(0);
				setState(618);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(620);
				match(Identifier);
				}
				break;
			case 3:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(621);
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
			case 4:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(622);
				literal();
				}
				break;
			case 5:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(636);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					{
					setState(623);
					match(LPAREN);
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Identifier) {
						{
						setState(624);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						setState(629);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(625);
							match(COMMA);
							setState(626);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							}
							}
							setState(631);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(634);
					match(RPAREN);
					}
					}
					break;
				case Identifier:
					{
					setState(635);
					((LambdaExprContext)_localctx).Identifier = match(Identifier);
					((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(638);
				_la = _input.LA(1);
				if ( !(_la==ARROW || _la==LAMBDA_ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(641);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(639);
					blockStmt();
					}
					break;
				case BOOLEAN:
				case BYTE:
				case CHAR:
				case DOUBLE:
				case FLOAT:
				case INT:
				case LONG:
				case NEW:
				case SHORT:
				case SUPER:
				case THIS:
				case VOID:
				case WITH:
				case IntegerLiteral:
				case FloatingPointLiteral:
				case BooleanLiteral:
				case CharacterLiteral:
				case StringLiteral:
				case MultiLineStringLiteral:
				case NullLiteral:
				case LPAREN:
				case LBRACK:
				case LT:
				case BANG:
				case TILDE:
				case INC:
				case DEC:
				case ADD:
				case SUB:
				case InterpolationPreffixString:
				case Identifier:
					{
					setState(640);
					expression(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 6:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(643);
					match(LT);
					setState(644);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(645);
					match(COMMA);
					setState(646);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(647);
					match(GT);
					}
				}

				setState(672);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(650);
					match(LBRACK);
					setState(651);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
					setState(652);
					match(COLON);
					setState(653);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(661);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(654);
							match(COMMA);
							setState(655);
							((MapExprContext)_localctx).expression = expression(0);
							((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
							setState(656);
							match(COLON);
							setState(657);
							((MapExprContext)_localctx).expression = expression(0);
							((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
							}
							} 
						}
						setState(663);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
					}
					setState(665);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(664);
						match(COMMA);
						}
					}

					setState(667);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(669);
					match(LBRACK);
					setState(670);
					match(COLON);
					setState(671);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(674);
					match(LT);
					setState(675);
					type(0);
					setState(676);
					match(GT);
					}
				}

				setState(680);
				match(LBRACK);
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(681);
					expression(0);
					setState(686);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(682);
							match(COMMA);
							setState(683);
							expression(0);
							}
							} 
						}
						setState(688);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
					}
					}
				}

				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(691);
					match(COMMA);
					}
				}

				setState(694);
				match(RBRACK);
				}
				break;
			case 8:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(698);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(695);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(696);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(697);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(700);
				match(LPAREN);
				setState(709);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(701);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(706);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(702);
						match(COMMA);
						setState(703);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(708);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(711);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(712);
				match(NEW);
				setState(713);
				classType();
				setState(714);
				match(LPAREN);
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(715);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(720);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(716);
						match(COMMA);
						setState(717);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(722);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(725);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(761);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(727);
					match(NEW);
					setState(728);
					type(0);
					setState(733); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(729);
							match(LBRACK);
							setState(730);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).sizes.add(((NewArrayExprContext)_localctx).expression);
							setState(731);
							match(RBRACK);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(735); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(741);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(737);
							((NewArrayExprContext)_localctx).s81 = match(LBRACK);
							((NewArrayExprContext)_localctx).suffix.add(((NewArrayExprContext)_localctx).s81);
							setState(738);
							match(RBRACK);
							}
							} 
						}
						setState(743);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
					}
					}
					break;
				case 2:
					{
					setState(744);
					match(NEW);
					setState(745);
					type(0);
					setState(746);
					match(LBRACK);
					setState(747);
					match(RBRACK);
					setState(748);
					match(LBRACE);
					setState(757);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						setState(749);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(754);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(750);
							match(COMMA);
							setState(751);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(756);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(759);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new StructuringNewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(763);
				match(NEW);
				setState(764);
				classType();
				setState(765);
				match(LPAREN);
				setState(766);
				match(LBRACE);
				setState(767);
				((StructuringNewExprContext)_localctx).optionalKeyValue = optionalKeyValue();
				((StructuringNewExprContext)_localctx).keyValues.add(((StructuringNewExprContext)_localctx).optionalKeyValue);
				setState(772);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(768);
						match(COMMA);
						setState(769);
						((StructuringNewExprContext)_localctx).optionalKeyValue = optionalKeyValue();
						((StructuringNewExprContext)_localctx).keyValues.add(((StructuringNewExprContext)_localctx).optionalKeyValue);
						}
						} 
					}
					setState(774);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
				}
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(775);
					match(COMMA);
					}
				}

				setState(778);
				match(RBRACE);
				setState(779);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(781);
				match(LPAREN);
				setState(782);
				type(0);
				setState(783);
				match(RPAREN);
				setState(784);
				expression(21);
				}
				break;
			case 13:
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
				expression(19);
				}
				break;
			case 14:
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
				expression(18);
				}
				break;
			case 15:
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
				expression(17);
				}
				break;
			case 16:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(792);
				match(InterpolationPreffixString);
				setState(793);
				expression(0);
				setState(802);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(794);
						match(RBRACE);
						setState(796);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(795);
							match(INTERPOLATION_STRING);
							}
						}

						setState(798);
						match(INTERPOLATION_INTERUPT);
						setState(799);
						expression(0);
						}
						} 
					}
					setState(804);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				}
				setState(805);
				match(RBRACE);
				setState(807);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(806);
					match(INTERPOLATION_STRING);
					}
				}

				setState(809);
				match(INTERPOLATION_END);
				}
				break;
			case 17:
				{
				_localctx = new WithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(811);
				match(WITH);
				setState(812);
				match(LPAREN);
				setState(813);
				expression(0);
				setState(814);
				match(RPAREN);
				setState(815);
				match(LBRACE);
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					{
					setState(816);
					stat();
					}
					}
					setState(821);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(822);
				match(RBRACE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(909);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(907);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(826);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(827);
						_la = _input.LA(1);
						if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (MUL - 106)) | (1L << (DIV - 106)) | (1L << (MOD - 106)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(828);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(829);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(830);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(831);
						expression(16);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(832);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(840);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
						case 1:
							{
							setState(833);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(834);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(835);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(836);
							match(GT);
							setState(837);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(838);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(839);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(842);
						expression(15);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(843);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(844);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (GT - 88)) | (1L << (LT - 88)) | (1L << (LE - 88)) | (1L << (GE - 88)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(845);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(846);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(847);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (EQUAL - 94)) | (1L << (SAME - 94)) | (1L << (NOTEQUAL - 94)) | (1L << (NOTSAME - 94)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(848);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(849);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(850);
						match(BITAND);
						setState(851);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(852);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(853);
						match(CARET);
						setState(854);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(855);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(856);
						match(BITOR);
						setState(857);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(858);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(859);
						match(AND);
						setState(860);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(861);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(862);
						match(OR);
						setState(863);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new NullDefaultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(864);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(865);
						match(DOUBLE_QUESTION);
						setState(866);
						expression(6);
						}
						break;
					case 12:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(867);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(868);
						match(QUESTION);
						setState(869);
						expression(0);
						setState(870);
						match(COLON);
						setState(871);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(873);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(874);
						_la = _input.LA(1);
						if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ASSIGN - 87)) | (1L << (ADD_ASSIGN - 87)) | (1L << (SUB_ASSIGN - 87)) | (1L << (MUL_ASSIGN - 87)) | (1L << (DIV_ASSIGN - 87)) | (1L << (AND_ASSIGN - 87)) | (1L << (OR_ASSIGN - 87)) | (1L << (XOR_ASSIGN - 87)) | (1L << (MOD_ASSIGN - 87)) | (1L << (LSHIFT_ASSIGN - 87)) | (1L << (RSHIFT_ASSIGN - 87)) | (1L << (URSHIFT_ASSIGN - 87)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(875);
						expression(1);
						}
						break;
					case 14:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(876);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(877);
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
						setState(878);
						_la = _input.LA(1);
						if ( !(_la==StringLiteral || _la==Identifier) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(879);
						match(LPAREN);
						setState(888);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(880);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(885);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(881);
								match(COMMA);
								setState(882);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(887);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(890);
						match(RPAREN);
						}
						break;
					case 15:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(891);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(892);
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
						setState(893);
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
					case 16:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(894);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(895);
						match(LBRACK);
						setState(896);
						expression(0);
						setState(897);
						match(RBRACK);
						}
						break;
					case 17:
						{
						_localctx = new MethodRefExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(899);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(900);
						match(DOUBLE_COLON);
						setState(901);
						match(Identifier);
						}
						break;
					case 18:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(902);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(903);
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
					case 19:
						{
						_localctx = new InstanceofExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(904);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(905);
						match(INSTANCEOF);
						setState(906);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(911);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
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

	public static class OptionalKeyValueContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(KalangParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OptionalKeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalKeyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterOptionalKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitOptionalKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitOptionalKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionalKeyValueContext optionalKeyValue() throws RecognitionException {
		OptionalKeyValueContext _localctx = new OptionalKeyValueContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_optionalKeyValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(912);
			match(Identifier);
			setState(915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(913);
				match(COLON);
				setState(914);
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
		enterRule(_localctx, 86, RULE_literal);
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
		enterRule(_localctx, 88, RULE_varModifier);
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
		case 12:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 41:
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
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 1);
		case 14:
			return precpred(_ctx, 29);
		case 15:
			return precpred(_ctx, 28);
		case 16:
			return precpred(_ctx, 26);
		case 17:
			return precpred(_ctx, 22);
		case 18:
			return precpred(_ctx, 20);
		case 19:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008c\u03b0\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\7\2^\n\2\f\2\16\2a\13\2\3\2\3\2\3\2\3\3\7\3g\n\3"+
		"\f\3\16\3j\13\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\7\5z\n\5\f\5\16\5}\13\5\3\6\7\6\u0080\n\6\f\6\16\6\u0083\13\6\3"+
		"\6\5\6\u0086\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6"+
		"\3\6\3\6\5\6\u0094\n\6\3\6\5\6\u0097\n\6\3\6\5\6\u009a\n\6\3\6\3\6\5\6"+
		"\u009e\n\6\3\6\3\6\3\6\3\6\7\6\u00a4\n\6\f\6\16\6\u00a7\13\6\5\6\u00a9"+
		"\n\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7\u00b1\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b8"+
		"\n\7\3\7\3\7\3\b\3\b\7\b\u00be\n\b\f\b\16\b\u00c1\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\7\t\u00c8\n\t\f\t\16\t\u00cb\13\t\3\n\5\n\u00ce\n\n\3\n\3\n\3\n\7"+
		"\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\n\3\n\3\13\7\13\u00db\n\13\f\13\16"+
		"\13\u00de\13\13\3\13\5\13\u00e1\n\13\3\13\5\13\u00e4\n\13\3\13\5\13\u00e7"+
		"\n\13\3\13\3\13\3\13\3\13\7\13\u00ed\n\13\f\13\16\13\u00f0\13\13\3\13"+
		"\3\13\5\13\u00f4\n\13\3\13\3\13\3\13\3\13\5\13\u00fa\n\13\3\13\3\13\3"+
		"\13\3\13\7\13\u0100\n\13\f\13\16\13\u0103\13\13\5\13\u0105\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u010c\n\13\f\13\16\13\u010f\13\13\5\13\u0111\n"+
		"\13\3\13\3\13\5\13\u0115\n\13\3\f\3\f\5\f\u0119\n\f\3\f\3\f\3\f\5\f\u011e"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u012a\n\r\f\r\16\r\u012d"+
		"\13\r\3\r\5\r\u0130\n\r\3\r\5\r\u0133\n\r\3\16\3\16\3\16\5\16\u0138\n"+
		"\16\3\16\3\16\3\16\3\16\5\16\u013e\n\16\7\16\u0140\n\16\f\16\16\16\u0143"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\7\17\u014a\n\17\f\17\16\17\u014d\13\17"+
		"\5\17\u014f\n\17\3\17\5\17\u0152\n\17\3\17\5\17\u0155\n\17\3\17\5\17\u0158"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0160\n\20\f\20\16\20\u0163\13"+
		"\20\5\20\u0165\n\20\3\20\3\20\5\20\u0169\n\20\3\21\3\21\5\21\u016d\n\21"+
		"\3\22\3\22\3\22\5\22\u0172\n\22\3\23\3\23\3\23\3\23\3\23\7\23\u0179\n"+
		"\23\f\23\16\23\u017c\13\23\5\23\u017e\n\23\3\24\3\24\3\25\3\25\3\25\7"+
		"\25\u0185\n\25\f\25\16\25\u0188\13\25\3\26\3\26\3\26\3\26\3\26\7\26\u018f"+
		"\n\26\f\26\16\26\u0192\13\26\3\26\3\26\3\26\3\26\3\26\7\26\u0199\n\26"+
		"\f\26\16\26\u019c\13\26\3\26\5\26\u019f\n\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u01ab\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01bd\n\30\3\31"+
		"\3\31\3\31\5\31\u01c2\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\5\34"+
		"\u01cc\n\34\3\35\3\35\3\35\3\35\3\36\3\36\7\36\u01d4\n\36\f\36\16\36\u01d7"+
		"\13\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\7\37\u01e0\n\37\f\37\16\37\u01e3"+
		"\13\37\3\37\5\37\u01e6\n\37\3\37\3\37\5\37\u01ea\n\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\7\37\u01f4\n\37\f\37\16\37\u01f7\13\37\3\37\3"+
		"\37\5\37\u01fb\n\37\3 \3 \5 \u01ff\n \3 \3 \3!\3!\3!\3!\3!\3!\5!\u0209"+
		"\n!\3\"\3\"\5\"\u020d\n\"\3\"\3\"\3\"\5\"\u0212\n\"\3\"\3\"\5\"\u0216"+
		"\n\"\3\"\3\"\3\"\3\"\5\"\u021c\n\"\5\"\u021e\n\"\3#\3#\3#\3$\3$\3$\3%"+
		"\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\5\'\u0238\n\'"+
		"\3\'\3\'\5\'\u023c\n\'\3\'\3\'\5\'\u0240\n\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\5(\u024a\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0257\n(\3(\3(\3(\3"+
		"(\5(\u025d\n(\3)\3)\3)\7)\u0262\n)\f)\16)\u0265\13)\3*\3*\3*\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u0276\n+\f+\16+\u0279\13+\5+\u027b\n+\3"+
		"+\3+\5+\u027f\n+\3+\3+\3+\5+\u0284\n+\3+\3+\3+\3+\3+\5+\u028b\n+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\7+\u0296\n+\f+\16+\u0299\13+\3+\5+\u029c\n+\3+"+
		"\3+\3+\3+\3+\5+\u02a3\n+\3+\3+\3+\3+\5+\u02a9\n+\3+\3+\3+\3+\7+\u02af"+
		"\n+\f+\16+\u02b2\13+\5+\u02b4\n+\3+\5+\u02b7\n+\3+\3+\3+\3+\5+\u02bd\n"+
		"+\3+\3+\3+\3+\7+\u02c3\n+\f+\16+\u02c6\13+\5+\u02c8\n+\3+\3+\3+\3+\3+"+
		"\3+\3+\7+\u02d1\n+\f+\16+\u02d4\13+\5+\u02d6\n+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\6+\u02e0\n+\r+\16+\u02e1\3+\3+\7+\u02e6\n+\f+\16+\u02e9\13+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\7+\u02f3\n+\f+\16+\u02f6\13+\5+\u02f8\n+\3+\3+\5+\u02fc"+
		"\n+\3+\3+\3+\3+\3+\3+\3+\7+\u0305\n+\f+\16+\u0308\13+\3+\5+\u030b\n+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u031f\n+\3+\3"+
		"+\7+\u0323\n+\f+\16+\u0326\13+\3+\3+\5+\u032a\n+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\7+\u0334\n+\f+\16+\u0337\13+\3+\3+\5+\u033b\n+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\5+\u034b\n+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\7+\u0376\n+\f+\16+\u0379\13+\5+\u037b\n+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u038e\n+\f+\16+\u0391\13"+
		"+\3,\3,\3,\5,\u0396\n,\3-\3-\3-\3-\3-\3-\3-\3-\5-\u03a0\n-\3-\3-\5-\u03a4"+
		"\n-\3-\3-\3-\5-\u03a9\n-\3.\6.\u03ac\n.\r.\16.\u03ad\3.\2\4\32T/\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\2\23\4\299FF\4\2$$;;\13\2\26\26\30\30\33\33!!\'\'..\60\6088CC\3\2"+
		"\7\b\4\2;;>>\3\2\n\13\3\2jk\3\2hi\3\2\\]\4\2lmqq\4\2Z[bc\4\2`ade\4\2Y"+
		"Yr|\5\2\f\17\21\22WX\4\2LL~~\5\2\f\17\22\22WW\n\2\24\24%%\61\61\64\66"+
		"99==AADD\2\u0435\2_\3\2\2\2\4h\3\2\2\2\6t\3\2\2\2\b{\3\2\2\2\n\u0081\3"+
		"\2\2\2\f\u00ae\3\2\2\2\16\u00bf\3\2\2\2\20\u00c9\3\2\2\2\22\u00cd\3\2"+
		"\2\2\24\u00dc\3\2\2\2\26\u0116\3\2\2\2\30\u011f\3\2\2\2\32\u0137\3\2\2"+
		"\2\34\u0157\3\2\2\2\36\u0159\3\2\2\2 \u016c\3\2\2\2\"\u016e\3\2\2\2$\u0173"+
		"\3\2\2\2&\u017f\3\2\2\2(\u0181\3\2\2\2*\u0189\3\2\2\2,\u01a3\3\2\2\2."+
		"\u01bc\3\2\2\2\60\u01be\3\2\2\2\62\u01c3\3\2\2\2\64\u01c5\3\2\2\2\66\u01c7"+
		"\3\2\2\28\u01cd\3\2\2\2:\u01d1\3\2\2\2<\u01da\3\2\2\2>\u01fc\3\2\2\2@"+
		"\u0208\3\2\2\2B\u021d\3\2\2\2D\u021f\3\2\2\2F\u0222\3\2\2\2H\u0225\3\2"+
		"\2\2J\u022b\3\2\2\2L\u0233\3\2\2\2N\u025c\3\2\2\2P\u025e\3\2\2\2R\u0266"+
		"\3\2\2\2T\u033a\3\2\2\2V\u0392\3\2\2\2X\u03a8\3\2\2\2Z\u03ab\3\2\2\2\\"+
		"^\5\f\7\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2"+
		"bc\5\n\6\2cd\7\2\2\3d\3\3\2\2\2eg\5\6\4\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2"+
		"\2hi\3\2\2\2in\3\2\2\2jh\3\2\2\2km\5\f\7\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2"+
		"\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\5\b\5\2rs\7\2\2\3s\5\3\2\2\2tu\7\u0081"+
		"\2\2u\7\3\2\2\2vz\5\24\13\2wz\5.\30\2xz\5\n\6\2yv\3\2\2\2yw\3\2\2\2yx"+
		"\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\t\3\2\2\2}{\3\2\2\2~\u0080\5\30"+
		"\r\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\5Z.\2\u0085"+
		"\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0096\3\2\2\2\u0087\u0093\7\34"+
		"\2\2\u0088\u0089\7[\2\2\u0089\u008e\5$\23\2\u008a\u008b\7V\2\2\u008b\u008d"+
		"\5$\23\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7Z"+
		"\2\2\u0092\u0094\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0097\3\2\2\2\u0095\u0097\7/\2\2\u0096\u0087\3\2\2\2\u0096\u0095\3\2"+
		"\2\2\u0097\u0099\3\2\2\2\u0098\u009a\7~\2\2\u0099\u0098\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u009c\7$\2\2\u009c\u009e\5\34"+
		"\17\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a8\3\2\2\2\u009f"+
		"\u00a0\7+\2\2\u00a0\u00a5\5\34\17\2\u00a1\u00a2\7V\2\2\u00a2\u00a4\5\34"+
		"\17\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u009f\3\2"+
		"\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\7Q\2\2\u00ab"+
		"\u00ac\5\20\t\2\u00ac\u00ad\7R\2\2\u00ad\13\3\2\2\2\u00ae\u00b0\7,\2\2"+
		"\u00af\u00b1\t\2\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b7\5\16\b\2\u00b3\u00b4\7W\2\2\u00b4\u00b8\7l\2\2\u00b5"+
		"\u00b6\7\4\2\2\u00b6\u00b8\7~\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7U\2\2\u00ba"+
		"\r\3\2\2\2\u00bb\u00bc\7~\2\2\u00bc\u00be\7W\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7~\2\2\u00c3\17\3\2\2\2\u00c4\u00c8"+
		"\5\22\n\2\u00c5\u00c8\5\24\13\2\u00c6\u00c8\5\n\6\2\u00c7\u00c4\3\2\2"+
		"\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\21\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc"+
		"\u00ce\5Z.\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2"+
		"\2\u00cf\u00d4\5B\"\2\u00d0\u00d1\7V\2\2\u00d1\u00d3\5B\"\2\u00d2\u00d0"+
		"\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7U\2\2\u00d8\23\3\2\2\2"+
		"\u00d9\u00db\5\30\r\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e1\7\23\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3"+
		"\2\2\2\u00e2\u00e4\7\37\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e6\3\2\2\2\u00e5\u00e7\5Z.\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2"+
		"\2\u00e7\u00f9\3\2\2\2\u00e8\u00e9\7[\2\2\u00e9\u00ee\5$\23\2\u00ea\u00eb"+
		"\7V\2\2\u00eb\u00ed\5$\23\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f1\u00f2\7Z\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00e8\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\5\32\16\2\u00f6\u00f7\7"+
		"~\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00fa\7\6\2\2\u00f9\u00f3\3\2\2\2\u00f9"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u0104\7O\2\2\u00fc\u0101\5\26"+
		"\f\2\u00fd\u00fe\7V\2\2\u00fe\u0100\5\26\f\2\u00ff\u00fd\3\2\2\2\u0100"+
		"\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0105\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0104\u00fc\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0110\7P\2\2\u0107\u0108\7@\2\2\u0108\u010d\7~\2"+
		"\2\u0109\u010a\7V\2\2\u010a\u010c\7~\2\2\u010b\u0109\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0107\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0114\3\2"+
		"\2\2\u0112\u0115\5:\36\2\u0113\u0115\7U\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0113\3\2\2\2\u0115\25\3\2\2\2\u0116\u0118\5\32\16\2\u0117\u0119\7\u0080"+
		"\2\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011d\7~\2\2\u011b\u011c\7Y\2\2\u011c\u011e\5T+\2\u011d\u011b\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e\27\3\2\2\2\u011f\u0120\7\177\2\2\u0120\u0132"+
		"\7~\2\2\u0121\u012f\7O\2\2\u0122\u0123\7~\2\2\u0123\u0124\7Y\2\2\u0124"+
		"\u012b\5X-\2\u0125\u0126\7V\2\2\u0126\u0127\7~\2\2\u0127\u0128\7Y\2\2"+
		"\u0128\u012a\5X-\2\u0129\u0125\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129"+
		"\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u0130\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"\u0130\5X-\2\u012f\u0122\3\2\2\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2"+
		"\2\u0130\u0131\3\2\2\2\u0131\u0133\7P\2\2\u0132\u0121\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\31\3\2\2\2\u0134\u0135\b\16\1\2\u0135\u0138\5\34\17\2\u0136"+
		"\u0138\5&\24\2\u0137\u0134\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u0141\3\2"+
		"\2\2\u0139\u013a\f\3\2\2\u013a\u013b\7S\2\2\u013b\u013d\7T\2\2\u013c\u013e"+
		"\7^\2\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f"+
		"\u0139\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\33\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0151\5\16\b\2\u0145\u014e"+
		"\7[\2\2\u0146\u014b\5 \21\2\u0147\u0148\7V\2\2\u0148\u014a\5 \21\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0146\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\7Z\2\2\u0151\u0145\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0155\7^\2\2\u0154"+
		"\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0158\5\36"+
		"\20\2\u0157\u0144\3\2\2\2\u0157\u0156\3\2\2\2\u0158\35\3\2\2\2\u0159\u015a"+
		"\7n\2\2\u015a\u015b\5\32\16\2\u015b\u0164\7O\2\2\u015c\u0161\5\32\16\2"+
		"\u015d\u015e\7V\2\2\u015e\u0160\5\32\16\2\u015f\u015d\3\2\2\2\u0160\u0163"+
		"\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0165\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u015c\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2"+
		"\2\2\u0166\u0168\7P\2\2\u0167\u0169\7^\2\2\u0168\u0167\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\37\3\2\2\2\u016a\u016d\5\32\16\2\u016b\u016d\5\"\22\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016d!\3\2\2\2\u016e\u0171\7^\2\2\u016f"+
		"\u0170\t\3\2\2\u0170\u0172\5\34\17\2\u0171\u016f\3\2\2\2\u0171\u0172\3"+
		"\2\2\2\u0172#\3\2\2\2\u0173\u017d\7~\2\2\u0174\u0175\7$\2\2\u0175\u017a"+
		"\5\34\17\2\u0176\u0177\7n\2\2\u0177\u0179\5\34\17\2\u0178\u0176\3\2\2"+
		"\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017e"+
		"\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0174\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"%\3\2\2\2\u017f\u0180\t\4\2\2\u0180\'\3\2\2\2\u0181\u0186\5B\"\2\u0182"+
		"\u0183\7V\2\2\u0183\u0185\5B\"\2\u0184\u0182\3\2\2\2\u0185\u0188\3\2\2"+
		"\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187)\3\2\2\2\u0188\u0186"+
		"\3\2\2\2\u0189\u019e\t\5\2\2\u018a\u018b\7Q\2\2\u018b\u0190\7~\2\2\u018c"+
		"\u018d\7V\2\2\u018d\u018f\7~\2\2\u018e\u018c\3\2\2\2\u018f\u0192\3\2\2"+
		"\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0190"+
		"\3\2\2\2\u0193\u019f\7R\2\2\u0194\u0195\7S\2\2\u0195\u019a\7~\2\2\u0196"+
		"\u0197\7V\2\2\u0197\u0199\7~\2\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2"+
		"\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a"+
		"\3\2\2\2\u019d\u019f\7T\2\2\u019e\u018a\3\2\2\2\u019e\u0194\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\u01a1\7Y\2\2\u01a1\u01a2\5T+\2\u01a2+\3\2\2\2\u01a3"+
		"\u01a4\7)\2\2\u01a4\u01a5\7O\2\2\u01a5\u01a6\5T+\2\u01a6\u01a7\7P\2\2"+
		"\u01a7\u01aa\5.\30\2\u01a8\u01a9\7\"\2\2\u01a9\u01ab\5.\30\2\u01aa\u01a8"+
		"\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab-\3\2\2\2\u01ac\u01bd\5\62\32\2\u01ad"+
		"\u01bd\5:\36\2\u01ae\u01bd\5@!\2\u01af\u01bd\5R*\2\u01b0\u01bd\5,\27\2"+
		"\u01b1\u01bd\5H%\2\u01b2\u01bd\5J&\2\u01b3\u01bd\5L\'\2\u01b4\u01bd\5"+
		"N(\2\u01b5\u01bd\5D#\2\u01b6\u01bd\5F$\2\u01b7\u01bd\5> \2\u01b8\u01bd"+
		"\5<\37\2\u01b9\u01bd\58\35\2\u01ba\u01bd\5\66\34\2\u01bb\u01bd\5\60\31"+
		"\2\u01bc\u01ac\3\2\2\2\u01bc\u01ad\3\2\2\2\u01bc\u01ae\3\2\2\2\u01bc\u01af"+
		"\3\2\2\2\u01bc\u01b0\3\2\2\2\u01bc\u01b1\3\2\2\2\u01bc\u01b2\3\2\2\2\u01bc"+
		"\u01b3\3\2\2\2\u01bc\u01b4\3\2\2\2\u01bc\u01b5\3\2\2\2\u01bc\u01b6\3\2"+
		"\2\2\u01bc\u01b7\3\2\2\2\u01bc\u01b8\3\2\2\2\u01bc\u01b9\3\2\2\2\u01bc"+
		"\u01ba\3\2\2\2\u01bc\u01bb\3\2\2\2\u01bd/\3\2\2\2\u01be\u01bf\5T+\2\u01bf"+
		"\u01c1\7W\2\2\u01c0\u01c2\7~\2\2\u01c1\u01c0\3\2\2\2\u01c1\u01c2\3\2\2"+
		"\2\u01c2\61\3\2\2\2\u01c3\u01c4\7U\2\2\u01c4\63\3\2\2\2\u01c5\u01c6\5"+
		"T+\2\u01c6\65\3\2\2\2\u01c7\u01c8\7\25\2\2\u01c8\u01cb\5T+\2\u01c9\u01ca"+
		"\7_\2\2\u01ca\u01cc\5T+\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\67\3\2\2\2\u01cd\u01ce\7?\2\2\u01ce\u01cf\5T+\2\u01cf\u01d0\7U\2\2\u01d0"+
		"9\3\2\2\2\u01d1\u01d5\7Q\2\2\u01d2\u01d4\5.\30\2\u01d3\u01d2\3\2\2\2\u01d4"+
		"\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2"+
		"\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01d9\7R\2\2\u01d9;\3\2\2\2\u01da\u01e9"+
		"\7B\2\2\u01db\u01dc\7O\2\2\u01dc\u01e1\5B\"\2\u01dd\u01de\7U\2\2\u01de"+
		"\u01e0\5B\"\2\u01df\u01dd\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4"+
		"\u01e6\7U\2\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2"+
		"\2\2\u01e7\u01e8\7P\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01db\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01f5\5:\36\2\u01ec\u01ed\7\32"+
		"\2\2\u01ed\u01ee\7O\2\2\u01ee\u01ef\5\34\17\2\u01ef\u01f0\7~\2\2\u01f0"+
		"\u01f1\7P\2\2\u01f1\u01f2\5:\36\2\u01f2\u01f4\3\2\2\2\u01f3\u01ec\3\2"+
		"\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6"+
		"\u01fa\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01f9\7&\2\2\u01f9\u01fb\5:\36"+
		"\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb=\3\2\2\2\u01fc\u01fe"+
		"\7\67\2\2\u01fd\u01ff\5T+\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u0200\3\2\2\2\u0200\u0201\7U\2\2\u0201?\3\2\2\2\u0202\u0203\5(\25\2\u0203"+
		"\u0204\7U\2\2\u0204\u0209\3\2\2\2\u0205\u0206\5*\26\2\u0206\u0207\7U\2"+
		"\2\u0207\u0209\3\2\2\2\u0208\u0202\3\2\2\2\u0208\u0205\3\2\2\2\u0209A"+
		"\3\2\2\2\u020a\u020d\7\7\2\2\u020b\u020d\7\b\2\2\u020c\u020a\3\2\2\2\u020c"+
		"\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0211\7~\2\2\u020f\u0210\7\4"+
		"\2\2\u0210\u0212\5\32\16\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0215\3\2\2\2\u0213\u0214\7Y\2\2\u0214\u0216\5T+\2\u0215\u0213\3\2\2"+
		"\2\u0215\u0216\3\2\2\2\u0216\u021e\3\2\2\2\u0217\u0218\5\32\16\2\u0218"+
		"\u021b\7~\2\2\u0219\u021a\7Y\2\2\u021a\u021c\5T+\2\u021b\u0219\3\2\2\2"+
		"\u021b\u021c\3\2\2\2\u021c\u021e\3\2\2\2\u021d\u020c\3\2\2\2\u021d\u0217"+
		"\3\2\2\2\u021eC\3\2\2\2\u021f\u0220\7\27\2\2\u0220\u0221\7U\2\2\u0221"+
		"E\3\2\2\2\u0222\u0223\7\36\2\2\u0223\u0224\7U\2\2\u0224G\3\2\2\2\u0225"+
		"\u0226\7E\2\2\u0226\u0227\7O\2\2\u0227\u0228\5T+\2\u0228\u0229\7P\2\2"+
		"\u0229\u022a\5.\30\2\u022aI\3\2\2\2\u022b\u022c\7 \2\2\u022c\u022d\5:"+
		"\36\2\u022d\u022e\7E\2\2\u022e\u022f\7O\2\2\u022f\u0230\5T+\2\u0230\u0231"+
		"\7P\2\2\u0231\u0232\7U\2\2\u0232K\3\2\2\2\u0233\u0234\7(\2\2\u0234\u0237"+
		"\7O\2\2\u0235\u0238\5(\25\2\u0236\u0238\5P)\2\u0237\u0235\3\2\2\2\u0237"+
		"\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b\7U"+
		"\2\2\u023a\u023c\5T+\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023d\u023f\7U\2\2\u023e\u0240\5P)\2\u023f\u023e\3\2\2\2\u023f"+
		"\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\7P\2\2\u0242\u0243\5.\30"+
		"\2\u0243M\3\2\2\2\u0244\u0245\7(\2\2\u0245\u0246\7O\2\2\u0246\u0249\7"+
		"~\2\2\u0247\u0248\7V\2\2\u0248\u024a\7~\2\2\u0249\u0247\3\2\2\2\u0249"+
		"\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\7\5\2\2\u024c\u024d\5T"+
		"+\2\u024d\u024e\7P\2\2\u024e\u024f\5.\30\2\u024f\u025d\3\2\2\2\u0250\u0251"+
		"\7\t\2\2\u0251\u0252\7O\2\2\u0252\u0253\5T+\2\u0253\u0256\7\4\2\2\u0254"+
		"\u0255\7~\2\2\u0255\u0257\7V\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2"+
		"\2\u0257\u0258\3\2\2\2\u0258\u0259\7~\2\2\u0259\u025a\7P\2\2\u025a\u025b"+
		"\5.\30\2\u025b\u025d\3\2\2\2\u025c\u0244\3\2\2\2\u025c\u0250\3\2\2\2\u025d"+
		"O\3\2\2\2\u025e\u0263\5T+\2\u025f\u0260\7V\2\2\u0260\u0262\5T+\2\u0261"+
		"\u025f\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264\3\2"+
		"\2\2\u0264Q\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u0267\5T+\2\u0267\u0268"+
		"\7U\2\2\u0268S\3\2\2\2\u0269\u026a\b+\1\2\u026a\u026b\7O\2\2\u026b\u026c"+
		"\5T+\2\u026c\u026d\7P\2\2\u026d\u033b\3\2\2\2\u026e\u033b\7~\2\2\u026f"+
		"\u033b\t\6\2\2\u0270\u033b\5X-\2\u0271\u027a\7O\2\2\u0272\u0277\7~\2\2"+
		"\u0273\u0274\7V\2\2\u0274\u0276\7~\2\2\u0275\u0273\3\2\2\2\u0276\u0279"+
		"\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u027b\3\2\2\2\u0279"+
		"\u0277\3\2\2\2\u027a\u0272\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\3\2"+
		"\2\2\u027c\u027f\7P\2\2\u027d\u027f\7~\2\2\u027e\u0271\3\2\2\2\u027e\u027d"+
		"\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0283\t\7\2\2\u0281\u0284\5:\36\2\u0282"+
		"\u0284\5T+\2\u0283\u0281\3\2\2\2\u0283\u0282\3\2\2\2\u0284\u033b\3\2\2"+
		"\2\u0285\u0286\7[\2\2\u0286\u0287\7~\2\2\u0287\u0288\7V\2\2\u0288\u0289"+
		"\7~\2\2\u0289\u028b\7Z\2\2\u028a\u0285\3\2\2\2\u028a\u028b\3\2\2\2\u028b"+
		"\u02a2\3\2\2\2\u028c\u028d\7S\2\2\u028d\u028e\5T+\2\u028e\u028f\7_\2\2"+
		"\u028f\u0297\5T+\2\u0290\u0291\7V\2\2\u0291\u0292\5T+\2\u0292\u0293\7"+
		"_\2\2\u0293\u0294\5T+\2\u0294\u0296\3\2\2\2\u0295\u0290\3\2\2\2\u0296"+
		"\u0299\3\2\2\2\u0297\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029b\3\2"+
		"\2\2\u0299\u0297\3\2\2\2\u029a\u029c\7V\2\2\u029b\u029a\3\2\2\2\u029b"+
		"\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\7T\2\2\u029e\u02a3\3\2"+
		"\2\2\u029f\u02a0\7S\2\2\u02a0\u02a1\7_\2\2\u02a1\u02a3\7T\2\2\u02a2\u028c"+
		"\3\2\2\2\u02a2\u029f\3\2\2\2\u02a3\u033b\3\2\2\2\u02a4\u02a5\7[\2\2\u02a5"+
		"\u02a6\5\32\16\2\u02a6\u02a7\7Z\2\2\u02a7\u02a9\3\2\2\2\u02a8\u02a4\3"+
		"\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02b3\7S\2\2\u02ab"+
		"\u02b0\5T+\2\u02ac\u02ad\7V\2\2\u02ad\u02af\5T+\2\u02ae\u02ac\3\2\2\2"+
		"\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b4"+
		"\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02ab\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4"+
		"\u02b6\3\2\2\2\u02b5\u02b7\7V\2\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2"+
		"\2\2\u02b7\u02b8\3\2\2\2\u02b8\u033b\7T\2\2\u02b9\u02bd\7~\2\2\u02ba\u02bd"+
		"\7>\2\2\u02bb\u02bd\7;\2\2\u02bc\u02b9\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc"+
		"\u02bb\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02c7\7O\2\2\u02bf\u02c4\5T+"+
		"\2\u02c0\u02c1\7V\2\2\u02c1\u02c3\5T+\2\u02c2\u02c0\3\2\2\2\u02c3\u02c6"+
		"\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6"+
		"\u02c4\3\2\2\2\u02c7\u02bf\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c9\3\2"+
		"\2\2\u02c9\u033b\7P\2\2\u02ca\u02cb\7\62\2\2\u02cb\u02cc\5\34\17\2\u02cc"+
		"\u02d5\7O\2\2\u02cd\u02d2\5T+\2\u02ce\u02cf\7V\2\2\u02cf\u02d1\5T+\2\u02d0"+
		"\u02ce\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3\3\2"+
		"\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02cd\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d8\7P\2\2\u02d8\u033b\3\2"+
		"\2\2\u02d9\u02da\7\62\2\2\u02da\u02df\5\32\16\2\u02db\u02dc\7S\2\2\u02dc"+
		"\u02dd\5T+\2\u02dd\u02de\7T\2\2\u02de\u02e0\3\2\2\2\u02df\u02db\3\2\2"+
		"\2\u02e0\u02e1\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e7"+
		"\3\2\2\2\u02e3\u02e4\7S\2\2\u02e4\u02e6\7T\2\2\u02e5\u02e3\3\2\2\2\u02e6"+
		"\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02fc\3\2"+
		"\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02eb\7\62\2\2\u02eb\u02ec\5\32\16\2\u02ec"+
		"\u02ed\7S\2\2\u02ed\u02ee\7T\2\2\u02ee\u02f7\7Q\2\2\u02ef\u02f4\5T+\2"+
		"\u02f0\u02f1\7V\2\2\u02f1\u02f3\5T+\2\u02f2\u02f0\3\2\2\2\u02f3\u02f6"+
		"\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f8\3\2\2\2\u02f6"+
		"\u02f4\3\2\2\2\u02f7\u02ef\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\3\2"+
		"\2\2\u02f9\u02fa\7R\2\2\u02fa\u02fc\3\2\2\2\u02fb\u02d9\3\2\2\2\u02fb"+
		"\u02ea\3\2\2\2\u02fc\u033b\3\2\2\2\u02fd\u02fe\7\62\2\2\u02fe\u02ff\5"+
		"\34\17\2\u02ff\u0300\7O\2\2\u0300\u0301\7Q\2\2\u0301\u0306\5V,\2\u0302"+
		"\u0303\7V\2\2\u0303\u0305\5V,\2\u0304\u0302\3\2\2\2\u0305\u0308\3\2\2"+
		"\2\u0306\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u030a\3\2\2\2\u0308\u0306"+
		"\3\2\2\2\u0309\u030b\7V\2\2\u030a\u0309\3\2\2\2\u030a\u030b\3\2\2\2\u030b"+
		"\u030c\3\2\2\2\u030c\u030d\7R\2\2\u030d\u030e\7P\2\2\u030e\u033b\3\2\2"+
		"\2\u030f\u0310\7O\2\2\u0310\u0311\5\32\16\2\u0311\u0312\7P\2\2\u0312\u0313"+
		"\5T+\27\u0313\u033b\3\2\2\2\u0314\u0315\t\b\2\2\u0315\u033b\5T+\25\u0316"+
		"\u0317\t\t\2\2\u0317\u033b\5T+\24\u0318\u0319\t\n\2\2\u0319\u033b\5T+"+
		"\23\u031a\u031b\7}\2\2\u031b\u0324\5T+\2\u031c\u031e\7R\2\2\u031d\u031f"+
		"\7\u008c\2\2\u031e\u031d\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0320\3\2\2"+
		"\2\u0320\u0321\7\u008a\2\2\u0321\u0323\5T+\2\u0322\u031c\3\2\2\2\u0323"+
		"\u0326\3\2\2\2\u0324\u0322\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0327\3\2"+
		"\2\2\u0326\u0324\3\2\2\2\u0327\u0329\7R\2\2\u0328\u032a\7\u008c\2\2\u0329"+
		"\u0328\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c\7\u008b"+
		"\2\2\u032c\u033b\3\2\2\2\u032d\u032e\7G\2\2\u032e\u032f\7O\2\2\u032f\u0330"+
		"\5T+\2\u0330\u0331\7P\2\2\u0331\u0335\7Q\2\2\u0332\u0334\5.\30\2\u0333"+
		"\u0332\3\2\2\2\u0334\u0337\3\2\2\2\u0335\u0333\3\2\2\2\u0335\u0336\3\2"+
		"\2\2\u0336\u0338\3\2\2\2\u0337\u0335\3\2\2\2\u0338\u0339\7R\2\2\u0339"+
		"\u033b\3\2\2\2\u033a\u0269\3\2\2\2\u033a\u026e\3\2\2\2\u033a\u026f\3\2"+
		"\2\2\u033a\u0270\3\2\2\2\u033a\u027e\3\2\2\2\u033a\u028a\3\2\2\2\u033a"+
		"\u02a8\3\2\2\2\u033a\u02bc\3\2\2\2\u033a\u02ca\3\2\2\2\u033a\u02fb\3\2"+
		"\2\2\u033a\u02fd\3\2\2\2\u033a\u030f\3\2\2\2\u033a\u0314\3\2\2\2\u033a"+
		"\u0316\3\2\2\2\u033a\u0318\3\2\2\2\u033a\u031a\3\2\2\2\u033a\u032d\3\2"+
		"\2\2\u033b\u038f\3\2\2\2\u033c\u033d\f\22\2\2\u033d\u033e\t\13\2\2\u033e"+
		"\u038e\5T+\23\u033f\u0340\f\21\2\2\u0340\u0341\t\b\2\2\u0341\u038e\5T"+
		"+\22\u0342\u034a\f\20\2\2\u0343\u0344\7[\2\2\u0344\u034b\7[\2\2\u0345"+
		"\u0346\7Z\2\2\u0346\u0347\7Z\2\2\u0347\u034b\7Z\2\2\u0348\u0349\7Z\2\2"+
		"\u0349\u034b\7Z\2\2\u034a\u0343\3\2\2\2\u034a\u0345\3\2\2\2\u034a\u0348"+
		"\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u038e\5T+\21\u034d\u034e\f\17\2\2\u034e"+
		"\u034f\t\f\2\2\u034f\u038e\5T+\20\u0350\u0351\f\r\2\2\u0351\u0352\t\r"+
		"\2\2\u0352\u038e\5T+\16\u0353\u0354\f\f\2\2\u0354\u0355\7n\2\2\u0355\u038e"+
		"\5T+\r\u0356\u0357\f\13\2\2\u0357\u0358\7p\2\2\u0358\u038e\5T+\f\u0359"+
		"\u035a\f\n\2\2\u035a\u035b\7o\2\2\u035b\u038e\5T+\13\u035c\u035d\f\t\2"+
		"\2\u035d\u035e\7f\2\2\u035e\u038e\5T+\n\u035f\u0360\f\b\2\2\u0360\u0361"+
		"\7g\2\2\u0361\u038e\5T+\t\u0362\u0363\f\7\2\2\u0363\u0364\7\20\2\2\u0364"+
		"\u038e\5T+\b\u0365\u0366\f\6\2\2\u0366\u0367\7^\2\2\u0367\u0368\5T+\2"+
		"\u0368\u0369\7_\2\2\u0369\u036a\5T+\7\u036a\u038e\3\2\2\2\u036b\u036c"+
		"\f\3\2\2\u036c\u036d\t\16\2\2\u036d\u038e\5T+\3\u036e\u036f\f\37\2\2\u036f"+
		"\u0370\t\17\2\2\u0370\u0371\t\20\2\2\u0371\u037a\7O\2\2\u0372\u0377\5"+
		"T+\2\u0373\u0374\7V\2\2\u0374\u0376\5T+\2\u0375\u0373\3\2\2\2\u0376\u0379"+
		"\3\2\2\2\u0377\u0375\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u037b\3\2\2\2\u0379"+
		"\u0377\3\2\2\2\u037a\u0372\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037c\3\2"+
		"\2\2\u037c\u038e\7P\2\2\u037d\u037e\f\36\2\2\u037e\u037f\t\21\2\2\u037f"+
		"\u038e\t\20\2\2\u0380\u0381\f\34\2\2\u0381\u0382\7S\2\2\u0382\u0383\5"+
		"T+\2\u0383\u0384\7T\2\2\u0384\u038e\3\2\2\2\u0385\u0386\f\30\2\2\u0386"+
		"\u0387\7\3\2\2\u0387\u038e\7~\2\2\u0388\u0389\f\26\2\2\u0389\u038e\t\t"+
		"\2\2\u038a\u038b\f\16\2\2\u038b\u038c\7-\2\2\u038c\u038e\7~\2\2\u038d"+
		"\u033c\3\2\2\2\u038d\u033f\3\2\2\2\u038d\u0342\3\2\2\2\u038d\u034d\3\2"+
		"\2\2\u038d\u0350\3\2\2\2\u038d\u0353\3\2\2\2\u038d\u0356\3\2\2\2\u038d"+
		"\u0359\3\2\2\2\u038d\u035c\3\2\2\2\u038d\u035f\3\2\2\2\u038d\u0362\3\2"+
		"\2\2\u038d\u0365\3\2\2\2\u038d\u036b\3\2\2\2\u038d\u036e\3\2\2\2\u038d"+
		"\u037d\3\2\2\2\u038d\u0380\3\2\2\2\u038d\u0385\3\2\2\2\u038d\u0388\3\2"+
		"\2\2\u038d\u038a\3\2\2\2\u038e\u0391\3\2\2\2\u038f\u038d\3\2\2\2\u038f"+
		"\u0390\3\2\2\2\u0390U\3\2\2\2\u0391\u038f\3\2\2\2\u0392\u0395\7~\2\2\u0393"+
		"\u0394\7_\2\2\u0394\u0396\5T+\2\u0395\u0393\3\2\2\2\u0395\u0396\3\2\2"+
		"\2\u0396W\3\2\2\2\u0397\u03a9\7H\2\2\u0398\u03a9\7I\2\2\u0399\u03a9\7"+
		"K\2\2\u039a\u03a9\7L\2\2\u039b\u03a9\7M\2\2\u039c\u03a9\7J\2\2\u039d\u03a0"+
		"\5&\24\2\u039e\u03a0\7~\2\2\u039f\u039d\3\2\2\2\u039f\u039e\3\2\2\2\u03a0"+
		"\u03a3\3\2\2\2\u03a1\u03a2\7S\2\2\u03a2\u03a4\7T\2\2\u03a3\u03a1\3\2\2"+
		"\2\u03a3\u03a4\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6\7W\2\2\u03a6\u03a9"+
		"\7\34\2\2\u03a7\u03a9\7N\2\2\u03a8\u0397\3\2\2\2\u03a8\u0398\3\2\2\2\u03a8"+
		"\u0399\3\2\2\2\u03a8\u039a\3\2\2\2\u03a8\u039b\3\2\2\2\u03a8\u039c\3\2"+
		"\2\2\u03a8\u039f\3\2\2\2\u03a8\u03a7\3\2\2\2\u03a9Y\3\2\2\2\u03aa\u03ac"+
		"\t\22\2\2\u03ab\u03aa\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ab\3\2\2\2"+
		"\u03ad\u03ae\3\2\2\2\u03ae[\3\2\2\2z_hny{\u0081\u0085\u008e\u0093\u0096"+
		"\u0099\u009d\u00a5\u00a8\u00b0\u00b7\u00bf\u00c7\u00c9\u00cd\u00d4\u00dc"+
		"\u00e0\u00e3\u00e6\u00ee\u00f3\u00f9\u0101\u0104\u010d\u0110\u0114\u0118"+
		"\u011d\u012b\u012f\u0132\u0137\u013d\u0141\u014b\u014e\u0151\u0154\u0157"+
		"\u0161\u0164\u0168\u016c\u0171\u017a\u017d\u0186\u0190\u019a\u019e\u01aa"+
		"\u01bc\u01c1\u01cb\u01d5\u01e1\u01e5\u01e9\u01f5\u01fa\u01fe\u0208\u020c"+
		"\u0211\u0215\u021b\u021d\u0237\u023b\u023f\u0249\u0256\u025c\u0263\u0277"+
		"\u027a\u027e\u0283\u028a\u0297\u029b\u02a2\u02a8\u02b0\u02b3\u02b6\u02bc"+
		"\u02c4\u02c7\u02d2\u02d5\u02e1\u02e7\u02f4\u02f7\u02fb\u0306\u030a\u031e"+
		"\u0324\u0329\u0335\u033a\u034a\u0377\u037a\u038d\u038f\u0395\u039f\u03a3"+
		"\u03a8\u03ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
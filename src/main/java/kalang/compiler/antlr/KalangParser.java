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
		WHILE=67, MIXIN=68, WITH=69, ASYNC=70, AWAIT=71, YIELD=72, IntegerLiteral=73, 
		FloatingPointLiteral=74, BooleanLiteral=75, CharacterLiteral=76, StringLiteral=77, 
		MultiLineStringLiteral=78, NullLiteral=79, LPAREN=80, RPAREN=81, LBRACE=82, 
		RBRACE=83, LBRACK=84, RBRACK=85, SEMI=86, COMMA=87, DOT=88, DOTDOT=89, 
		ASSIGN=90, GT=91, LT=92, BANG=93, TILDE=94, QUESTION=95, COLON=96, EQUAL=97, 
		SAME=98, LE=99, GE=100, NOTEQUAL=101, NOTSAME=102, AND=103, OR=104, INC=105, 
		DEC=106, ADD=107, SUB=108, MUL=109, DIV=110, BITAND=111, BITOR=112, CARET=113, 
		MOD=114, ADD_ASSIGN=115, SUB_ASSIGN=116, MUL_ASSIGN=117, DIV_ASSIGN=118, 
		AND_ASSIGN=119, OR_ASSIGN=120, XOR_ASSIGN=121, MOD_ASSIGN=122, LSHIFT_ASSIGN=123, 
		RSHIFT_ASSIGN=124, URSHIFT_ASSIGN=125, InterpolationPreffixString=126, 
		Identifier=127, AT=128, ELLIPSIS=129, COMPILE_OPTION_LINE=130, WS=131, 
		COMMENT=132, LINE_COMMENT=133, PACKAGE_DELIMITER=134, UNTERMINATED_STRING=135, 
		UNTERMINATED_MULTILINE_STRING=136, UNCLOSED_COMMENT=137, UNKNOWN_CHAR=138, 
		INTERPOLATION_INTERUPT=139, INTERPOLATION_END=140, INTERPOLATION_STRING=141;
	public static final int
		RULE_standardCompilationUnit = 0, RULE_scriptCompilationUnit = 1, RULE_compileOption = 2, 
		RULE_scriptDef = 3, RULE_classDef = 4, RULE_importDecl = 5, RULE_qualifiedName = 6, 
		RULE_classBody = 7, RULE_fieldDecl = 8, RULE_methodDecl = 9, RULE_paramDecl = 10, 
		RULE_annotation = 11, RULE_type = 12, RULE_classType = 13, RULE_lambdaType = 14, 
		RULE_parameterizedElementType = 15, RULE_wildcardType = 16, RULE_typeParameter = 17, 
		RULE_primitiveType = 18, RULE_localVarDecl = 19, RULE_destructuringLocalVarDecl = 20, 
		RULE_ifStat = 21, RULE_stat = 22, RULE_unterminatedStmt = 23, RULE_emptyStat = 24, 
		RULE_errorousStat = 25, RULE_assertStmt = 26, RULE_throwStat = 27, RULE_blockStmt = 28, 
		RULE_tryStat = 29, RULE_returnStat = 30, RULE_yieldStat = 31, RULE_varDeclStat = 32, 
		RULE_varDecl = 33, RULE_breakStat = 34, RULE_continueStat = 35, RULE_whileStat = 36, 
		RULE_doWhileStat = 37, RULE_forStat = 38, RULE_forEachStat = 39, RULE_expressions = 40, 
		RULE_exprStat = 41, RULE_expression = 42, RULE_optionalKeyValue = 43, 
		RULE_literal = 44, RULE_varModifier = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"standardCompilationUnit", "scriptCompilationUnit", "compileOption", 
			"scriptDef", "classDef", "importDecl", "qualifiedName", "classBody", 
			"fieldDecl", "methodDecl", "paramDecl", "annotation", "type", "classType", 
			"lambdaType", "parameterizedElementType", "wildcardType", "typeParameter", 
			"primitiveType", "localVarDecl", "destructuringLocalVarDecl", "ifStat", 
			"stat", "unterminatedStmt", "emptyStat", "errorousStat", "assertStmt", 
			"throwStat", "blockStmt", "tryStat", "returnStat", "yieldStat", "varDeclStat", 
			"varDecl", "breakStat", "continueStat", "whileStat", "doWhileStat", "forStat", 
			"forEachStat", "expressions", "exprStat", "expression", "optionalKeyValue", 
			"literal", "varModifier"
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
			"'with'", "'async'", "'await'", "'yield'", null, null, null, null, null, 
			null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", 
			"'.'", "'..'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", 
			"'==='", "'<='", "'>='", "'!='", "'!=='", "'&&'", "'||'", "'++'", "'--'", 
			"'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", 
			"'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", 
			null, null, "'@'", "'...'", null, null, null, null, "'\\'", null, null, 
			null, null, "'${'", "'\"'"
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
			"TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "MIXIN", "WITH", "ASYNC", 
			"AWAIT", "YIELD", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", 
			"CharacterLiteral", "StringLiteral", "MultiLineStringLiteral", "NullLiteral", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
			"DOT", "DOTDOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", 
			"EQUAL", "SAME", "LE", "GE", "NOTEQUAL", "NOTSAME", "AND", "OR", "INC", 
			"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", 
			"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
			"URSHIFT_ASSIGN", "InterpolationPreffixString", "Identifier", "AT", "ELLIPSIS", 
			"COMPILE_OPTION_LINE", "WS", "COMMENT", "LINE_COMMENT", "PACKAGE_DELIMITER", 
			"UNTERMINATED_STRING", "UNTERMINATED_MULTILINE_STRING", "UNCLOSED_COMMENT", 
			"UNKNOWN_CHAR", "INTERPOLATION_INTERUPT", "INTERPOLATION_END", "INTERPOLATION_STRING"
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(92);
				importDecl();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			classDef();
			setState(99);
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
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPILE_OPTION_LINE) {
				{
				{
				setState(101);
				compileOption();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(107);
				importDecl();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			scriptDef();
			setState(114);
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
			setState(116);
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
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (CONSTRUCTOR - 4)) | (1L << (VAR - 4)) | (1L << (VAL - 4)) | (1L << (FOREACH - 4)) | (1L << (OVERRIDE - 4)) | (1L << (ABSTRACT - 4)) | (1L << (ASSERT - 4)) | (1L << (BOOLEAN - 4)) | (1L << (BREAK - 4)) | (1L << (BYTE - 4)) | (1L << (CHAR - 4)) | (1L << (CLASS - 4)) | (1L << (CONTINUE - 4)) | (1L << (DEFAULT - 4)) | (1L << (DO - 4)) | (1L << (DOUBLE - 4)) | (1L << (FINAL - 4)) | (1L << (FLOAT - 4)) | (1L << (FOR - 4)) | (1L << (IF - 4)) | (1L << (INT - 4)) | (1L << (INTERFACE - 4)) | (1L << (LONG - 4)) | (1L << (NATIVE - 4)) | (1L << (NEW - 4)) | (1L << (PRIVATE - 4)) | (1L << (PROTECTED - 4)) | (1L << (PUBLIC - 4)) | (1L << (RETURN - 4)) | (1L << (SHORT - 4)) | (1L << (STATIC - 4)) | (1L << (SUPER - 4)) | (1L << (SYNCHRONIZED - 4)) | (1L << (THIS - 4)) | (1L << (THROW - 4)) | (1L << (TRANSIENT - 4)) | (1L << (TRY - 4)) | (1L << (VOID - 4)) | (1L << (VOLATILE - 4)) | (1L << (WHILE - 4)))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (WITH - 69)) | (1L << (ASYNC - 69)) | (1L << (AWAIT - 69)) | (1L << (YIELD - 69)) | (1L << (IntegerLiteral - 69)) | (1L << (FloatingPointLiteral - 69)) | (1L << (BooleanLiteral - 69)) | (1L << (CharacterLiteral - 69)) | (1L << (StringLiteral - 69)) | (1L << (MultiLineStringLiteral - 69)) | (1L << (NullLiteral - 69)) | (1L << (LPAREN - 69)) | (1L << (LBRACE - 69)) | (1L << (LBRACK - 69)) | (1L << (SEMI - 69)) | (1L << (LT - 69)) | (1L << (BANG - 69)) | (1L << (TILDE - 69)) | (1L << (INC - 69)) | (1L << (DEC - 69)) | (1L << (ADD - 69)) | (1L << (SUB - 69)) | (1L << (MUL - 69)) | (1L << (BITAND - 69)) | (1L << (InterpolationPreffixString - 69)) | (1L << (Identifier - 69)) | (1L << (AT - 69)))) != 0)) {
				{
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(118);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(119);
					stat();
					}
					break;
				case 3:
					{
					setState(120);
					classDef();
					}
					break;
				}
				}
				setState(125);
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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(126);
				annotation();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)) | (1L << (ASYNC - 18)))) != 0)) {
				{
				setState(132);
				varModifier();
				}
			}

			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(135);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(136);
					match(LT);
					setState(137);
					((ClassDefContext)_localctx).typeParameter = typeParameter();
					((ClassDefContext)_localctx).typeParam.add(((ClassDefContext)_localctx).typeParameter);
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(138);
						match(COMMA);
						setState(139);
						((ClassDefContext)_localctx).typeParameter = typeParameter();
						((ClassDefContext)_localctx).typeParam.add(((ClassDefContext)_localctx).typeParameter);
						}
						}
						setState(144);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(145);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(149);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(152);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(155);
				match(EXTENDS);
				setState(156);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(159);
				match(IMPLEMENTS);
				setState(160);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161);
					match(COMMA);
					setState(162);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170);
			match(LBRACE);
			setState(171);
			classBody();
			setState(172);
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
			setState(174);
			match(IMPORT);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC || _la==MIXIN) {
				{
				setState(175);
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

			setState(178);
			qualifiedName();
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(179);
				match(DOT);
				setState(180);
				((ImportDeclContext)_localctx).star = match(MUL);
				}
				break;
			case AS:
				{
				setState(181);
				match(AS);
				setState(182);
				((ImportDeclContext)_localctx).alias = match(Identifier);
				}
				break;
			case SEMI:
				break;
			default:
				break;
			}
			setState(185);
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
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(187);
					((QualifiedNameContext)_localctx).Identifier = match(Identifier);
					((QualifiedNameContext)_localctx).names.add(((QualifiedNameContext)_localctx).Identifier);
					setState(188);
					match(DOT);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(194);
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
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (VOLATILE - 65)) | (1L << (ASYNC - 65)) | (1L << (LT - 65)) | (1L << (MUL - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)) | (1L << (AT - 65)))) != 0)) {
				{
				setState(199);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(196);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(197);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(198);
					classDef();
					}
					break;
				}
				}
				setState(203);
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
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)) | (1L << (ASYNC - 18)))) != 0)) {
				{
				setState(204);
				varModifier();
				}
			}

			setState(207);
			varDecl();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(208);
				match(COMMA);
				setState(209);
				varDecl();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
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
		public Token generatorSymbol;
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
		public TerminalNode MUL() { return getToken(KalangParser.MUL, 0); }
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
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(217);
				annotation();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(223);
				match(OVERRIDE);
				}
			}

			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(226);
				match(DEFAULT);
				}
			}

			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)) | (1L << (ASYNC - 18)))) != 0)) {
				{
				setState(229);
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
			case LT:
			case MUL:
			case BITAND:
			case Identifier:
				{
				{
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(232);
					match(LT);
					setState(233);
					((MethodDeclContext)_localctx).typeParameter = typeParameter();
					((MethodDeclContext)_localctx).typeParam.add(((MethodDeclContext)_localctx).typeParameter);
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(234);
						match(COMMA);
						setState(235);
						((MethodDeclContext)_localctx).typeParameter = typeParameter();
						((MethodDeclContext)_localctx).typeParam.add(((MethodDeclContext)_localctx).typeParameter);
						}
						}
						setState(240);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(241);
					match(GT);
					}
				}

				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MUL) {
					{
					setState(245);
					((MethodDeclContext)_localctx).generatorSymbol = match(MUL);
					}
				}

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
		enterRule(_localctx, 20, RULE_paramDecl);
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
		enterRule(_localctx, 22, RULE_annotation);
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
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_type, _p);
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
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
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
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				qualifiedName();
				setState(340);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(328);
					((ClassTypeContext)_localctx).typeArgsPrefix = match(LT);
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (QUESTION - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						setState(329);
						((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
						((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
						setState(334);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(330);
							match(COMMA);
							setState(331);
							((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
							((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
							}
							}
							setState(336);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(339);
					match(GT);
					}
					break;
				}
				setState(343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(342);
					((ClassTypeContext)_localctx).nullable = match(QUESTION);
					}
					break;
				}
				}
				break;
			case BITAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
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
			setState(348);
			match(BITAND);
			setState(349);
			((LambdaTypeContext)_localctx).returnType = type(0);
			setState(350);
			match(LPAREN);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (BITAND - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(351);
				((LambdaTypeContext)_localctx).type = type(0);
				((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(352);
					match(COMMA);
					setState(353);
					((LambdaTypeContext)_localctx).type = type(0);
					((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
					}
					}
					setState(358);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(361);
			match(RPAREN);
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(362);
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
			setState(367);
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
				setState(365);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
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
			setState(369);
			match(QUESTION);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==SUPER) {
				{
				setState(370);
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
				setState(371);
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
			setState(374);
			match(Identifier);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(375);
				match(EXTENDS);
				setState(376);
				((TypeParameterContext)_localctx).classType = classType();
				((TypeParameterContext)_localctx).bounds.add(((TypeParameterContext)_localctx).classType);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(377);
					match(BITAND);
					setState(378);
					((TypeParameterContext)_localctx).classType = classType();
					((TypeParameterContext)_localctx).bounds.add(((TypeParameterContext)_localctx).classType);
					}
					}
					setState(383);
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
			setState(386);
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
			setState(388);
			varDecl();
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(389);
				match(COMMA);
				setState(390);
				varDecl();
				}
				}
				setState(395);
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
			setState(396);
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
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(397);
				((DestructuringLocalVarDeclContext)_localctx).op = match(LBRACE);
				setState(398);
				match(Identifier);
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(399);
					match(COMMA);
					setState(400);
					match(Identifier);
					}
					}
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(406);
				match(RBRACE);
				}
				break;
			case LBRACK:
				{
				setState(407);
				((DestructuringLocalVarDeclContext)_localctx).op = match(LBRACK);
				setState(408);
				match(Identifier);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(409);
					match(COMMA);
					setState(410);
					match(Identifier);
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(416);
				match(RBRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(419);
			match(ASSIGN);
			setState(420);
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
			setState(422);
			match(IF);
			setState(423);
			match(LPAREN);
			setState(424);
			expression(0);
			setState(425);
			match(RPAREN);
			setState(426);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(427);
				match(ELSE);
				setState(428);
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
		public YieldStatContext yieldStat() {
			return getRuleContext(YieldStatContext.class,0);
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
			setState(448);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				emptyStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				blockStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(434);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(435);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(436);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(437);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(438);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(439);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(440);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(441);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(442);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(443);
				yieldStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(444);
				tryStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(445);
				throwStat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(446);
				assertStmt();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(447);
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
			setState(450);
			expression(0);
			setState(451);
			match(DOT);
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(452);
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
			setState(455);
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
			setState(457);
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
			setState(459);
			match(ASSERT);
			setState(460);
			((AssertStmtContext)_localctx).testCondition = expression(0);
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(461);
				match(COLON);
				setState(462);
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
			setState(465);
			match(THROW);
			setState(466);
			expression(0);
			setState(467);
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
			setState(469);
			match(LBRACE);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (AWAIT - 64)) | (1L << (YIELD - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(470);
				stat();
				}
				}
				setState(475);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(476);
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
			setState(478);
			match(TRY);
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(479);
				match(LPAREN);
				setState(480);
				((TryStatContext)_localctx).varDecl = varDecl();
				((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
				setState(485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(481);
						match(SEMI);
						setState(482);
						((TryStatContext)_localctx).varDecl = varDecl();
						((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
						}
						} 
					}
					setState(487);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(488);
					match(SEMI);
					}
				}

				setState(491);
				match(RPAREN);
				}
			}

			setState(495);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(496);
				match(CATCH);
				setState(497);
				match(LPAREN);
				setState(498);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(499);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(500);
				match(RPAREN);
				setState(501);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(508);
				match(FINALLY);
				setState(509);
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
			setState(512);
			match(RETURN);
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(513);
				expression(0);
				}
			}

			setState(516);
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

	public static class YieldStatContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(KalangParser.YIELD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(KalangParser.SEMI, 0); }
		public YieldStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterYieldStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitYieldStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitYieldStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldStatContext yieldStat() throws RecognitionException {
		YieldStatContext _localctx = new YieldStatContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_yieldStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			match(YIELD);
			setState(519);
			expression(0);
			setState(520);
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
		enterRule(_localctx, 64, RULE_varDeclStat);
		try {
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				localVarDecl();
				setState(523);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(525);
				destructuringLocalVarDecl();
				setState(526);
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
		enterRule(_localctx, 66, RULE_varDecl);
		int _la;
		try {
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(532);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(530);
					((VarDeclContext)_localctx).varToken = match(VAR);
					}
					break;
				case VAL:
					{
					setState(531);
					((VarDeclContext)_localctx).valToken = match(VAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(534);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(535);
					match(AS);
					setState(536);
					type(0);
					}
				}

				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(539);
					match(ASSIGN);
					setState(540);
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
				setState(543);
				((VarDeclContext)_localctx).varType = type(0);
				setState(544);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(545);
					match(ASSIGN);
					setState(546);
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
		enterRule(_localctx, 68, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			match(BREAK);
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
		enterRule(_localctx, 70, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(CONTINUE);
			setState(555);
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
		enterRule(_localctx, 72, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(WHILE);
			setState(558);
			match(LPAREN);
			setState(559);
			expression(0);
			setState(560);
			match(RPAREN);
			setState(561);
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
		enterRule(_localctx, 74, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(DO);
			setState(564);
			blockStmt();
			setState(565);
			match(WHILE);
			setState(566);
			match(LPAREN);
			setState(567);
			expression(0);
			setState(568);
			match(RPAREN);
			setState(569);
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
		enterRule(_localctx, 76, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(FOR);
			setState(572);
			match(LPAREN);
			setState(575);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(573);
				localVarDecl();
				}
				break;
			case 2:
				{
				setState(574);
				((ForStatContext)_localctx).initExpressions = expressions();
				}
				break;
			}
			setState(577);
			match(SEMI);
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(578);
				((ForStatContext)_localctx).condition = expression(0);
				}
			}

			setState(581);
			match(SEMI);
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(582);
				((ForStatContext)_localctx).updateExpressions = expressions();
				}
			}

			setState(585);
			match(RPAREN);
			setState(586);
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
		enterRule(_localctx, 78, RULE_forEachStat);
		int _la;
		try {
			setState(612);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(588);
				match(FOR);
				setState(589);
				match(LPAREN);
				setState(590);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(591);
					match(COMMA);
					setState(592);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					}
				}

				setState(595);
				match(IN);
				setState(596);
				expression(0);
				setState(597);
				match(RPAREN);
				setState(598);
				stat();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(600);
				match(FOREACH);
				setState(601);
				match(LPAREN);
				setState(602);
				expression(0);
				setState(603);
				match(AS);
				setState(606);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(604);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					setState(605);
					match(COMMA);
					}
					break;
				}
				setState(608);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(609);
				match(RPAREN);
				setState(610);
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
		enterRule(_localctx, 80, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			expression(0);
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(615);
				match(COMMA);
				setState(616);
				expression(0);
				}
				}
				setState(621);
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
		enterRule(_localctx, 82, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			expression(0);
			setState(623);
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
		public Token s84;
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
	public static class AwaitExprContext extends ExpressionContext {
		public TerminalNode AWAIT() { return getToken(KalangParser.AWAIT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AwaitExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterAwaitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitAwaitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitAwaitExpr(this);
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
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(626);
				match(LPAREN);
				setState(627);
				expression(0);
				setState(628);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(630);
				match(Identifier);
				}
				break;
			case 3:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(631);
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
				setState(632);
				literal();
				}
				break;
			case 5:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(646);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					{
					setState(633);
					match(LPAREN);
					setState(642);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Identifier) {
						{
						setState(634);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						setState(639);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(635);
							match(COMMA);
							setState(636);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							}
							}
							setState(641);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(644);
					match(RPAREN);
					}
					}
					break;
				case Identifier:
					{
					setState(645);
					((LambdaExprContext)_localctx).Identifier = match(Identifier);
					((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(648);
				_la = _input.LA(1);
				if ( !(_la==ARROW || _la==LAMBDA_ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(651);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(649);
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
				case AWAIT:
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
					setState(650);
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
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(653);
					match(LT);
					setState(654);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(655);
					match(COMMA);
					setState(656);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(657);
					match(GT);
					}
				}

				setState(682);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(660);
					match(LBRACK);
					setState(661);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
					setState(662);
					match(COLON);
					setState(663);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(671);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(664);
							match(COMMA);
							setState(665);
							((MapExprContext)_localctx).expression = expression(0);
							((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
							setState(666);
							match(COLON);
							setState(667);
							((MapExprContext)_localctx).expression = expression(0);
							((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
							}
							} 
						}
						setState(673);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
					}
					setState(675);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(674);
						match(COMMA);
						}
					}

					setState(677);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(679);
					match(LBRACK);
					setState(680);
					match(COLON);
					setState(681);
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
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(684);
					match(LT);
					setState(685);
					type(0);
					setState(686);
					match(GT);
					}
				}

				setState(690);
				match(LBRACK);
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(691);
					expression(0);
					setState(696);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(692);
							match(COMMA);
							setState(693);
							expression(0);
							}
							} 
						}
						setState(698);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
					}
					}
				}

				setState(702);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(701);
					match(COMMA);
					}
				}

				setState(704);
				match(RBRACK);
				}
				break;
			case 8:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(708);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(705);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(706);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(707);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(710);
				match(LPAREN);
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(711);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(716);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(712);
						match(COMMA);
						setState(713);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(718);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(721);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(722);
				match(NEW);
				setState(723);
				classType();
				setState(724);
				match(LPAREN);
				setState(733);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(725);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(726);
						match(COMMA);
						setState(727);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(732);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(735);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(771);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(737);
					match(NEW);
					setState(738);
					type(0);
					setState(743); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(739);
							match(LBRACK);
							setState(740);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).sizes.add(((NewArrayExprContext)_localctx).expression);
							setState(741);
							match(RBRACK);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(745); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(751);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(747);
							((NewArrayExprContext)_localctx).s84 = match(LBRACK);
							((NewArrayExprContext)_localctx).suffix.add(((NewArrayExprContext)_localctx).s84);
							setState(748);
							match(RBRACK);
							}
							} 
						}
						setState(753);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
					}
					}
					break;
				case 2:
					{
					setState(754);
					match(NEW);
					setState(755);
					type(0);
					setState(756);
					match(LBRACK);
					setState(757);
					match(RBRACK);
					setState(758);
					match(LBRACE);
					setState(767);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						setState(759);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(764);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(760);
							match(COMMA);
							setState(761);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(766);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(769);
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
				setState(773);
				match(NEW);
				setState(774);
				classType();
				setState(775);
				match(LPAREN);
				setState(776);
				match(LBRACE);
				setState(777);
				((StructuringNewExprContext)_localctx).optionalKeyValue = optionalKeyValue();
				((StructuringNewExprContext)_localctx).keyValues.add(((StructuringNewExprContext)_localctx).optionalKeyValue);
				setState(782);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(778);
						match(COMMA);
						setState(779);
						((StructuringNewExprContext)_localctx).optionalKeyValue = optionalKeyValue();
						((StructuringNewExprContext)_localctx).keyValues.add(((StructuringNewExprContext)_localctx).optionalKeyValue);
						}
						} 
					}
					setState(784);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
				}
				setState(786);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(785);
					match(COMMA);
					}
				}

				setState(788);
				match(RBRACE);
				setState(789);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(791);
				match(LPAREN);
				setState(792);
				type(0);
				setState(793);
				match(RPAREN);
				setState(794);
				expression(22);
				}
				break;
			case 13:
				{
				_localctx = new AwaitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(796);
				match(AWAIT);
				setState(797);
				expression(21);
				}
				break;
			case 14:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(798);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(799);
				expression(19);
				}
				break;
			case 15:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(800);
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
				setState(801);
				expression(18);
				}
				break;
			case 16:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(802);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(803);
				expression(17);
				}
				break;
			case 17:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(804);
				match(InterpolationPreffixString);
				setState(805);
				expression(0);
				setState(814);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(806);
						match(RBRACE);
						setState(808);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(807);
							match(INTERPOLATION_STRING);
							}
						}

						setState(810);
						match(INTERPOLATION_INTERUPT);
						setState(811);
						expression(0);
						}
						} 
					}
					setState(816);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				setState(817);
				match(RBRACE);
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(818);
					match(INTERPOLATION_STRING);
					}
				}

				setState(821);
				match(INTERPOLATION_END);
				}
				break;
			case 18:
				{
				_localctx = new WithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(823);
				match(WITH);
				setState(824);
				match(LPAREN);
				setState(825);
				expression(0);
				setState(826);
				match(RPAREN);
				setState(827);
				match(LBRACE);
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (AWAIT - 64)) | (1L << (YIELD - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					{
					setState(828);
					stat();
					}
					}
					setState(833);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(834);
				match(RBRACE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(921);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(919);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(838);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(839);
						_la = _input.LA(1);
						if ( !(((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (MUL - 109)) | (1L << (DIV - 109)) | (1L << (MOD - 109)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(840);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(841);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(842);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(843);
						expression(16);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(844);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(852);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
						case 1:
							{
							setState(845);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(846);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(847);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(848);
							match(GT);
							setState(849);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(850);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(851);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(854);
						expression(15);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(855);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(856);
						_la = _input.LA(1);
						if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (GT - 91)) | (1L << (LT - 91)) | (1L << (LE - 91)) | (1L << (GE - 91)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(857);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(858);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(859);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (EQUAL - 97)) | (1L << (SAME - 97)) | (1L << (NOTEQUAL - 97)) | (1L << (NOTSAME - 97)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(860);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(861);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(862);
						match(BITAND);
						setState(863);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(864);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(865);
						match(CARET);
						setState(866);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(867);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(868);
						match(BITOR);
						setState(869);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(870);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(871);
						match(AND);
						setState(872);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(873);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(874);
						match(OR);
						setState(875);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new NullDefaultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(876);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(877);
						match(DOUBLE_QUESTION);
						setState(878);
						expression(6);
						}
						break;
					case 12:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(879);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(880);
						match(QUESTION);
						setState(881);
						expression(0);
						setState(882);
						match(COLON);
						setState(883);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(885);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(886);
						_la = _input.LA(1);
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (ASSIGN - 90)) | (1L << (ADD_ASSIGN - 90)) | (1L << (SUB_ASSIGN - 90)) | (1L << (MUL_ASSIGN - 90)) | (1L << (DIV_ASSIGN - 90)) | (1L << (AND_ASSIGN - 90)) | (1L << (OR_ASSIGN - 90)) | (1L << (XOR_ASSIGN - 90)) | (1L << (MOD_ASSIGN - 90)) | (1L << (LSHIFT_ASSIGN - 90)) | (1L << (RSHIFT_ASSIGN - 90)) | (1L << (URSHIFT_ASSIGN - 90)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(887);
						expression(1);
						}
						break;
					case 14:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(888);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(889);
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
						setState(890);
						_la = _input.LA(1);
						if ( !(_la==StringLiteral || _la==Identifier) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(891);
						match(LPAREN);
						setState(900);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (WITH - 65)) | (1L << (AWAIT - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(892);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(897);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(893);
								match(COMMA);
								setState(894);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(899);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(902);
						match(RPAREN);
						}
						break;
					case 15:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(903);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(904);
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
						setState(905);
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
						setState(906);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(907);
						match(LBRACK);
						setState(908);
						expression(0);
						setState(909);
						match(RBRACK);
						}
						break;
					case 17:
						{
						_localctx = new MethodRefExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(911);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(912);
						match(DOUBLE_COLON);
						setState(913);
						match(Identifier);
						}
						break;
					case 18:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(914);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(915);
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
						setState(916);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(917);
						match(INSTANCEOF);
						setState(918);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(923);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
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
		enterRule(_localctx, 86, RULE_optionalKeyValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(924);
			match(Identifier);
			setState(927);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(925);
				match(COLON);
				setState(926);
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
		enterRule(_localctx, 88, RULE_literal);
		int _la;
		try {
			setState(946);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(929);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(930);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(931);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(932);
				match(StringLiteral);
				}
				break;
			case MultiLineStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(933);
				match(MultiLineStringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(934);
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
				setState(937);
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
					setState(935);
					primitiveType();
					}
					break;
				case Identifier:
					{
					setState(936);
					match(Identifier);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(941);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(939);
					((LiteralContext)_localctx).arrayPrefix = match(LBRACK);
					setState(940);
					match(RBRACK);
					}
				}

				setState(943);
				match(DOT);
				setState(944);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 8);
				{
				setState(945);
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
		public List<TerminalNode> ASYNC() { return getTokens(KalangParser.ASYNC); }
		public TerminalNode ASYNC(int i) {
			return getToken(KalangParser.ASYNC, i);
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
		enterRule(_localctx, 90, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(948);
				_la = _input.LA(1);
				if ( !(((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)) | (1L << (ASYNC - 18)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(951); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ABSTRACT - 18)) | (1L << (FINAL - 18)) | (1L << (NATIVE - 18)) | (1L << (PRIVATE - 18)) | (1L << (PROTECTED - 18)) | (1L << (PUBLIC - 18)) | (1L << (STATIC - 18)) | (1L << (SYNCHRONIZED - 18)) | (1L << (TRANSIENT - 18)) | (1L << (VOLATILE - 18)) | (1L << (ASYNC - 18)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		case 42:
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
			return precpred(_ctx, 30);
		case 15:
			return precpred(_ctx, 29);
		case 16:
			return precpred(_ctx, 27);
		case 17:
			return precpred(_ctx, 23);
		case 18:
			return precpred(_ctx, 20);
		case 19:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008f\u03bc\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\3\2\3\2\3\3\7\3"+
		"i\n\3\f\3\16\3l\13\3\3\3\7\3o\n\3\f\3\16\3r\13\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\7\5|\n\5\f\5\16\5\177\13\5\3\6\7\6\u0082\n\6\f\6\16\6\u0085"+
		"\13\6\3\6\5\6\u0088\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u008f\n\6\f\6\16\6\u0092"+
		"\13\6\3\6\3\6\5\6\u0096\n\6\3\6\5\6\u0099\n\6\3\6\5\6\u009c\n\6\3\6\3"+
		"\6\5\6\u00a0\n\6\3\6\3\6\3\6\3\6\7\6\u00a6\n\6\f\6\16\6\u00a9\13\6\5\6"+
		"\u00ab\n\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7\u00b3\n\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7\u00ba\n\7\3\7\3\7\3\b\3\b\7\b\u00c0\n\b\f\b\16\b\u00c3\13\b\3\b\3\b"+
		"\3\t\3\t\3\t\7\t\u00ca\n\t\f\t\16\t\u00cd\13\t\3\n\5\n\u00d0\n\n\3\n\3"+
		"\n\3\n\7\n\u00d5\n\n\f\n\16\n\u00d8\13\n\3\n\3\n\3\13\7\13\u00dd\n\13"+
		"\f\13\16\13\u00e0\13\13\3\13\5\13\u00e3\n\13\3\13\5\13\u00e6\n\13\3\13"+
		"\5\13\u00e9\n\13\3\13\3\13\3\13\3\13\7\13\u00ef\n\13\f\13\16\13\u00f2"+
		"\13\13\3\13\3\13\5\13\u00f6\n\13\3\13\5\13\u00f9\n\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00ff\n\13\3\13\3\13\3\13\3\13\7\13\u0105\n\13\f\13\16\13\u0108"+
		"\13\13\5\13\u010a\n\13\3\13\3\13\3\13\3\13\3\13\7\13\u0111\n\13\f\13\16"+
		"\13\u0114\13\13\5\13\u0116\n\13\3\13\3\13\5\13\u011a\n\13\3\f\3\f\5\f"+
		"\u011e\n\f\3\f\3\f\3\f\5\f\u0123\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\7\r\u012f\n\r\f\r\16\r\u0132\13\r\3\r\5\r\u0135\n\r\3\r\5\r\u0138"+
		"\n\r\3\16\3\16\3\16\5\16\u013d\n\16\3\16\3\16\3\16\3\16\5\16\u0143\n\16"+
		"\7\16\u0145\n\16\f\16\16\16\u0148\13\16\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u014f\n\17\f\17\16\17\u0152\13\17\5\17\u0154\n\17\3\17\5\17\u0157\n\17"+
		"\3\17\5\17\u015a\n\17\3\17\5\17\u015d\n\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u0165\n\20\f\20\16\20\u0168\13\20\5\20\u016a\n\20\3\20\3\20\5"+
		"\20\u016e\n\20\3\21\3\21\5\21\u0172\n\21\3\22\3\22\3\22\5\22\u0177\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u017e\n\23\f\23\16\23\u0181\13\23\5\23"+
		"\u0183\n\23\3\24\3\24\3\25\3\25\3\25\7\25\u018a\n\25\f\25\16\25\u018d"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\7\26\u0194\n\26\f\26\16\26\u0197\13\26"+
		"\3\26\3\26\3\26\3\26\3\26\7\26\u019e\n\26\f\26\16\26\u01a1\13\26\3\26"+
		"\5\26\u01a4\n\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u01b0\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u01c3\n\30\3\31\3\31\3\31\5\31\u01c8\n"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u01d2\n\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\7\36\u01da\n\36\f\36\16\36\u01dd\13\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\7\37\u01e6\n\37\f\37\16\37\u01e9\13\37\3\37"+
		"\5\37\u01ec\n\37\3\37\3\37\5\37\u01f0\n\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\7\37\u01fa\n\37\f\37\16\37\u01fd\13\37\3\37\3\37\5\37\u0201"+
		"\n\37\3 \3 \5 \u0205\n \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\""+
		"\u0213\n\"\3#\3#\5#\u0217\n#\3#\3#\3#\5#\u021c\n#\3#\3#\5#\u0220\n#\3"+
		"#\3#\3#\3#\5#\u0226\n#\5#\u0228\n#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\5(\u0242\n(\3(\3(\5(\u0246"+
		"\n(\3(\3(\5(\u024a\n(\3(\3(\3(\3)\3)\3)\3)\3)\5)\u0254\n)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\5)\u0261\n)\3)\3)\3)\3)\5)\u0267\n)\3*\3*\3*\7*"+
		"\u026c\n*\f*\16*\u026f\13*\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\7,\u0280\n,\f,\16,\u0283\13,\5,\u0285\n,\3,\3,\5,\u0289\n,\3,\3,\3,"+
		"\5,\u028e\n,\3,\3,\3,\3,\3,\5,\u0295\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,"+
		"\u02a0\n,\f,\16,\u02a3\13,\3,\5,\u02a6\n,\3,\3,\3,\3,\3,\5,\u02ad\n,\3"+
		",\3,\3,\3,\5,\u02b3\n,\3,\3,\3,\3,\7,\u02b9\n,\f,\16,\u02bc\13,\5,\u02be"+
		"\n,\3,\5,\u02c1\n,\3,\3,\3,\3,\5,\u02c7\n,\3,\3,\3,\3,\7,\u02cd\n,\f,"+
		"\16,\u02d0\13,\5,\u02d2\n,\3,\3,\3,\3,\3,\3,\3,\7,\u02db\n,\f,\16,\u02de"+
		"\13,\5,\u02e0\n,\3,\3,\3,\3,\3,\3,\3,\3,\6,\u02ea\n,\r,\16,\u02eb\3,\3"+
		",\7,\u02f0\n,\f,\16,\u02f3\13,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u02fd\n,\f,"+
		"\16,\u0300\13,\5,\u0302\n,\3,\3,\5,\u0306\n,\3,\3,\3,\3,\3,\3,\3,\7,\u030f"+
		"\n,\f,\16,\u0312\13,\3,\5,\u0315\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\5,\u032b\n,\3,\3,\7,\u032f\n,\f,\16,\u0332\13"+
		",\3,\3,\5,\u0336\n,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u0340\n,\f,\16,\u0343\13"+
		",\3,\3,\5,\u0347\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0357"+
		"\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u0382\n,"+
		"\f,\16,\u0385\13,\5,\u0387\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\7,\u039a\n,\f,\16,\u039d\13,\3-\3-\3-\5-\u03a2\n-\3.\3.\3."+
		"\3.\3.\3.\3.\3.\5.\u03ac\n.\3.\3.\5.\u03b0\n.\3.\3.\3.\5.\u03b5\n.\3/"+
		"\6/\u03b8\n/\r/\16/\u03b9\3/\2\4\32V\60\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\23\4\299FF\4\2$$"+
		";;\13\2\26\26\30\30\33\33!!\'\'..\60\6088CC\3\2\7\b\4\2;;>>\3\2\n\13\3"+
		"\2mn\3\2kl\3\2_`\4\2optt\4\2]^ef\4\2cdgh\4\2\\\\u\177\5\2\f\17\21\22Z"+
		"[\4\2OO\u0081\u0081\5\2\f\17\22\22ZZ\13\2\24\24%%\61\61\64\6699==AADD"+
		"HH\2\u0443\2a\3\2\2\2\4j\3\2\2\2\6v\3\2\2\2\b}\3\2\2\2\n\u0083\3\2\2\2"+
		"\f\u00b0\3\2\2\2\16\u00c1\3\2\2\2\20\u00cb\3\2\2\2\22\u00cf\3\2\2\2\24"+
		"\u00de\3\2\2\2\26\u011b\3\2\2\2\30\u0124\3\2\2\2\32\u013c\3\2\2\2\34\u015c"+
		"\3\2\2\2\36\u015e\3\2\2\2 \u0171\3\2\2\2\"\u0173\3\2\2\2$\u0178\3\2\2"+
		"\2&\u0184\3\2\2\2(\u0186\3\2\2\2*\u018e\3\2\2\2,\u01a8\3\2\2\2.\u01c2"+
		"\3\2\2\2\60\u01c4\3\2\2\2\62\u01c9\3\2\2\2\64\u01cb\3\2\2\2\66\u01cd\3"+
		"\2\2\28\u01d3\3\2\2\2:\u01d7\3\2\2\2<\u01e0\3\2\2\2>\u0202\3\2\2\2@\u0208"+
		"\3\2\2\2B\u0212\3\2\2\2D\u0227\3\2\2\2F\u0229\3\2\2\2H\u022c\3\2\2\2J"+
		"\u022f\3\2\2\2L\u0235\3\2\2\2N\u023d\3\2\2\2P\u0266\3\2\2\2R\u0268\3\2"+
		"\2\2T\u0270\3\2\2\2V\u0346\3\2\2\2X\u039e\3\2\2\2Z\u03b4\3\2\2\2\\\u03b7"+
		"\3\2\2\2^`\5\f\7\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2c"+
		"a\3\2\2\2de\5\n\6\2ef\7\2\2\3f\3\3\2\2\2gi\5\6\4\2hg\3\2\2\2il\3\2\2\2"+
		"jh\3\2\2\2jk\3\2\2\2kp\3\2\2\2lj\3\2\2\2mo\5\f\7\2nm\3\2\2\2or\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\5\b\5\2tu\7\2\2\3u\5\3\2\2"+
		"\2vw\7\u0084\2\2w\7\3\2\2\2x|\5\24\13\2y|\5.\30\2z|\5\n\6\2{x\3\2\2\2"+
		"{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\t\3\2\2\2\177}"+
		"\3\2\2\2\u0080\u0082\5\30\r\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0088\5\\/\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0098\3\2\2\2\u0089\u0095\7\34\2\2\u008a\u008b\7^\2\2\u008b\u0090\5$"+
		"\23\2\u008c\u008d\7Y\2\2\u008d\u008f\5$\23\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7]\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u008a\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0099\7/"+
		"\2\2\u0098\u0089\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u009c\7\u0081\2\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f"+
		"\3\2\2\2\u009d\u009e\7$\2\2\u009e\u00a0\5\34\17\2\u009f\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00aa\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2\u00a7"+
		"\5\34\17\2\u00a3\u00a4\7Y\2\2\u00a4\u00a6\5\34\17\2\u00a5\u00a3\3\2\2"+
		"\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ad\7T\2\2\u00ad\u00ae\5\20\t\2\u00ae\u00af\7U"+
		"\2\2\u00af\13\3\2\2\2\u00b0\u00b2\7,\2\2\u00b1\u00b3\t\2\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b9\5\16\b\2"+
		"\u00b5\u00b6\7Z\2\2\u00b6\u00ba\7o\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00ba"+
		"\7\u0081\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2"+
		"\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7X\2\2\u00bc\r\3\2\2\2\u00bd\u00be"+
		"\7\u0081\2\2\u00be\u00c0\7Z\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2"+
		"\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c5\7\u0081\2\2\u00c5\17\3\2\2\2\u00c6\u00ca\5\22\n\2"+
		"\u00c7\u00ca\5\24\13\2\u00c8\u00ca\5\n\6\2\u00c9\u00c6\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\21\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\5\\/\2"+
		"\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d6"+
		"\5D#\2\u00d2\u00d3\7Y\2\2\u00d3\u00d5\5D#\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7X\2\2\u00da\23\3\2\2\2\u00db\u00dd"+
		"\5\30\r\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2"+
		"\u00de\u00df\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3"+
		"\7\23\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2"+
		"\u00e4\u00e6\7\37\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8"+
		"\3\2\2\2\u00e7\u00e9\5\\/\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00fe\3\2\2\2\u00ea\u00eb\7^\2\2\u00eb\u00f0\5$\23\2\u00ec\u00ed\7Y\2"+
		"\2\u00ed\u00ef\5$\23\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f4\7]\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ea\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f9\7o\2\2\u00f8\u00f7\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\5\32\16\2\u00fb\u00fc\7"+
		"\u0081\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00ff\7\6\2\2\u00fe\u00f5\3\2\2\2"+
		"\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0109\7R\2\2\u0101\u0106"+
		"\5\26\f\2\u0102\u0103\7Y\2\2\u0103\u0105\5\26\f\2\u0104\u0102\3\2\2\2"+
		"\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010a"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0115\7S\2\2\u010c\u010d\7@\2\2\u010d\u0112\7\u0081"+
		"\2\2\u010e\u010f\7Y\2\2\u010f\u0111\7\u0081\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2"+
		"\2\2\u0114\u0112\3\2\2\2\u0115\u010c\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0119\3\2\2\2\u0117\u011a\5:\36\2\u0118\u011a\7X\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u0118\3\2\2\2\u011a\25\3\2\2\2\u011b\u011d\5\32\16\2\u011c"+
		"\u011e\7\u0083\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0122\7\u0081\2\2\u0120\u0121\7\\\2\2\u0121\u0123\5V,\2"+
		"\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\27\3\2\2\2\u0124\u0125"+
		"\7\u0082\2\2\u0125\u0137\7\u0081\2\2\u0126\u0134\7R\2\2\u0127\u0128\7"+
		"\u0081\2\2\u0128\u0129\7\\\2\2\u0129\u0130\5Z.\2\u012a\u012b\7Y\2\2\u012b"+
		"\u012c\7\u0081\2\2\u012c\u012d\7\\\2\2\u012d\u012f\5Z.\2\u012e\u012a\3"+
		"\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0135\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0135\5Z.\2\u0134\u0127\3\2\2"+
		"\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138"+
		"\7S\2\2\u0137\u0126\3\2\2\2\u0137\u0138\3\2\2\2\u0138\31\3\2\2\2\u0139"+
		"\u013a\b\16\1\2\u013a\u013d\5\34\17\2\u013b\u013d\5&\24\2\u013c\u0139"+
		"\3\2\2\2\u013c\u013b\3\2\2\2\u013d\u0146\3\2\2\2\u013e\u013f\f\3\2\2\u013f"+
		"\u0140\7V\2\2\u0140\u0142\7W\2\2\u0141\u0143\7a\2\2\u0142\u0141\3\2\2"+
		"\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u013e\3\2\2\2\u0145\u0148"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\33\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0149\u0156\5\16\b\2\u014a\u0153\7^\2\2\u014b\u0150\5 "+
		"\21\2\u014c\u014d\7Y\2\2\u014d\u014f\5 \21\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0154\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0153\u014b\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0157\7]\2\2\u0156\u014a\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\u0159\3\2\2\2\u0158\u015a\7a\2\2\u0159\u0158\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u015d\5\36\20\2\u015c\u0149\3"+
		"\2\2\2\u015c\u015b\3\2\2\2\u015d\35\3\2\2\2\u015e\u015f\7q\2\2\u015f\u0160"+
		"\5\32\16\2\u0160\u0169\7R\2\2\u0161\u0166\5\32\16\2\u0162\u0163\7Y\2\2"+
		"\u0163\u0165\5\32\16\2\u0164\u0162\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0169"+
		"\u0161\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\7S"+
		"\2\2\u016c\u016e\7a\2\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\37\3\2\2\2\u016f\u0172\5\32\16\2\u0170\u0172\5\"\22\2\u0171\u016f\3\2"+
		"\2\2\u0171\u0170\3\2\2\2\u0172!\3\2\2\2\u0173\u0176\7a\2\2\u0174\u0175"+
		"\t\3\2\2\u0175\u0177\5\34\17\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2"+
		"\u0177#\3\2\2\2\u0178\u0182\7\u0081\2\2\u0179\u017a\7$\2\2\u017a\u017f"+
		"\5\34\17\2\u017b\u017c\7q\2\2\u017c\u017e\5\34\17\2\u017d\u017b\3\2\2"+
		"\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0183"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0179\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"%\3\2\2\2\u0184\u0185\t\4\2\2\u0185\'\3\2\2\2\u0186\u018b\5D#\2\u0187"+
		"\u0188\7Y\2\2\u0188\u018a\5D#\2\u0189\u0187\3\2\2\2\u018a\u018d\3\2\2"+
		"\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c)\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018e\u01a3\t\5\2\2\u018f\u0190\7T\2\2\u0190\u0195\7\u0081\2"+
		"\2\u0191\u0192\7Y\2\2\u0192\u0194\7\u0081\2\2\u0193\u0191\3\2\2\2\u0194"+
		"\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2"+
		"\2\2\u0197\u0195\3\2\2\2\u0198\u01a4\7U\2\2\u0199\u019a\7V\2\2\u019a\u019f"+
		"\7\u0081\2\2\u019b\u019c\7Y\2\2\u019c\u019e\7\u0081\2\2\u019d\u019b\3"+
		"\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a2\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a4\7W\2\2\u01a3\u018f\3\2"+
		"\2\2\u01a3\u0199\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\7\\\2\2\u01a6"+
		"\u01a7\5V,\2\u01a7+\3\2\2\2\u01a8\u01a9\7)\2\2\u01a9\u01aa\7R\2\2\u01aa"+
		"\u01ab\5V,\2\u01ab\u01ac\7S\2\2\u01ac\u01af\5.\30\2\u01ad\u01ae\7\"\2"+
		"\2\u01ae\u01b0\5.\30\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0-"+
		"\3\2\2\2\u01b1\u01c3\5\62\32\2\u01b2\u01c3\5:\36\2\u01b3\u01c3\5B\"\2"+
		"\u01b4\u01c3\5T+\2\u01b5\u01c3\5,\27\2\u01b6\u01c3\5J&\2\u01b7\u01c3\5"+
		"L\'\2\u01b8\u01c3\5N(\2\u01b9\u01c3\5P)\2\u01ba\u01c3\5F$\2\u01bb\u01c3"+
		"\5H%\2\u01bc\u01c3\5> \2\u01bd\u01c3\5@!\2\u01be\u01c3\5<\37\2\u01bf\u01c3"+
		"\58\35\2\u01c0\u01c3\5\66\34\2\u01c1\u01c3\5\60\31\2\u01c2\u01b1\3\2\2"+
		"\2\u01c2\u01b2\3\2\2\2\u01c2\u01b3\3\2\2\2\u01c2\u01b4\3\2\2\2\u01c2\u01b5"+
		"\3\2\2\2\u01c2\u01b6\3\2\2\2\u01c2\u01b7\3\2\2\2\u01c2\u01b8\3\2\2\2\u01c2"+
		"\u01b9\3\2\2\2\u01c2\u01ba\3\2\2\2\u01c2\u01bb\3\2\2\2\u01c2\u01bc\3\2"+
		"\2\2\u01c2\u01bd\3\2\2\2\u01c2\u01be\3\2\2\2\u01c2\u01bf\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c1\3\2\2\2\u01c3/\3\2\2\2\u01c4\u01c5\5V,\2\u01c5"+
		"\u01c7\7Z\2\2\u01c6\u01c8\7\u0081\2\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8"+
		"\3\2\2\2\u01c8\61\3\2\2\2\u01c9\u01ca\7X\2\2\u01ca\63\3\2\2\2\u01cb\u01cc"+
		"\5V,\2\u01cc\65\3\2\2\2\u01cd\u01ce\7\25\2\2\u01ce\u01d1\5V,\2\u01cf\u01d0"+
		"\7b\2\2\u01d0\u01d2\5V,\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"\67\3\2\2\2\u01d3\u01d4\7?\2\2\u01d4\u01d5\5V,\2\u01d5\u01d6\7X\2\2\u01d6"+
		"9\3\2\2\2\u01d7\u01db\7T\2\2\u01d8\u01da\5.\30\2\u01d9\u01d8\3\2\2\2\u01da"+
		"\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01de\3\2"+
		"\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\7U\2\2\u01df;\3\2\2\2\u01e0\u01ef"+
		"\7B\2\2\u01e1\u01e2\7R\2\2\u01e2\u01e7\5D#\2\u01e3\u01e4\7X\2\2\u01e4"+
		"\u01e6\5D#\2\u01e5\u01e3\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2"+
		"\2\u01e7\u01e8\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01ec"+
		"\7X\2\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01ee\7S\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01e1\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01fb\5:\36\2\u01f2\u01f3\7\32\2\2\u01f3"+
		"\u01f4\7R\2\2\u01f4\u01f5\5\34\17\2\u01f5\u01f6\7\u0081\2\2\u01f6\u01f7"+
		"\7S\2\2\u01f7\u01f8\5:\36\2\u01f8\u01fa\3\2\2\2\u01f9\u01f2\3\2\2\2\u01fa"+
		"\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u0200\3\2"+
		"\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff\7&\2\2\u01ff\u0201\5:\36\2\u0200"+
		"\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201=\3\2\2\2\u0202\u0204\7\67\2\2"+
		"\u0203\u0205\5V,\2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206"+
		"\3\2\2\2\u0206\u0207\7X\2\2\u0207?\3\2\2\2\u0208\u0209\7J\2\2\u0209\u020a"+
		"\5V,\2\u020a\u020b\7X\2\2\u020bA\3\2\2\2\u020c\u020d\5(\25\2\u020d\u020e"+
		"\7X\2\2\u020e\u0213\3\2\2\2\u020f\u0210\5*\26\2\u0210\u0211\7X\2\2\u0211"+
		"\u0213\3\2\2\2\u0212\u020c\3\2\2\2\u0212\u020f\3\2\2\2\u0213C\3\2\2\2"+
		"\u0214\u0217\7\7\2\2\u0215\u0217\7\b\2\2\u0216\u0214\3\2\2\2\u0216\u0215"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021b\7\u0081\2\2\u0219\u021a\7\4\2"+
		"\2\u021a\u021c\5\32\16\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\u021f\3\2\2\2\u021d\u021e\7\\\2\2\u021e\u0220\5V,\2\u021f\u021d\3\2\2"+
		"\2\u021f\u0220\3\2\2\2\u0220\u0228\3\2\2\2\u0221\u0222\5\32\16\2\u0222"+
		"\u0225\7\u0081\2\2\u0223\u0224\7\\\2\2\u0224\u0226\5V,\2\u0225\u0223\3"+
		"\2\2\2\u0225\u0226\3\2\2\2\u0226\u0228\3\2\2\2\u0227\u0216\3\2\2\2\u0227"+
		"\u0221\3\2\2\2\u0228E\3\2\2\2\u0229\u022a\7\27\2\2\u022a\u022b\7X\2\2"+
		"\u022bG\3\2\2\2\u022c\u022d\7\36\2\2\u022d\u022e\7X\2\2\u022eI\3\2\2\2"+
		"\u022f\u0230\7E\2\2\u0230\u0231\7R\2\2\u0231\u0232\5V,\2\u0232\u0233\7"+
		"S\2\2\u0233\u0234\5.\30\2\u0234K\3\2\2\2\u0235\u0236\7 \2\2\u0236\u0237"+
		"\5:\36\2\u0237\u0238\7E\2\2\u0238\u0239\7R\2\2\u0239\u023a\5V,\2\u023a"+
		"\u023b\7S\2\2\u023b\u023c\7X\2\2\u023cM\3\2\2\2\u023d\u023e\7(\2\2\u023e"+
		"\u0241\7R\2\2\u023f\u0242\5(\25\2\u0240\u0242\5R*\2\u0241\u023f\3\2\2"+
		"\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0245"+
		"\7X\2\2\u0244\u0246\5V,\2\u0245\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246"+
		"\u0247\3\2\2\2\u0247\u0249\7X\2\2\u0248\u024a\5R*\2\u0249\u0248\3\2\2"+
		"\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\7S\2\2\u024c\u024d"+
		"\5.\30\2\u024dO\3\2\2\2\u024e\u024f\7(\2\2\u024f\u0250\7R\2\2\u0250\u0253"+
		"\7\u0081\2\2\u0251\u0252\7Y\2\2\u0252\u0254\7\u0081\2\2\u0253\u0251\3"+
		"\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0256\7\5\2\2\u0256"+
		"\u0257\5V,\2\u0257\u0258\7S\2\2\u0258\u0259\5.\30\2\u0259\u0267\3\2\2"+
		"\2\u025a\u025b\7\t\2\2\u025b\u025c\7R\2\2\u025c\u025d\5V,\2\u025d\u0260"+
		"\7\4\2\2\u025e\u025f\7\u0081\2\2\u025f\u0261\7Y\2\2\u0260\u025e\3\2\2"+
		"\2\u0260\u0261\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0263\7\u0081\2\2\u0263"+
		"\u0264\7S\2\2\u0264\u0265\5.\30\2\u0265\u0267\3\2\2\2\u0266\u024e\3\2"+
		"\2\2\u0266\u025a\3\2\2\2\u0267Q\3\2\2\2\u0268\u026d\5V,\2\u0269\u026a"+
		"\7Y\2\2\u026a\u026c\5V,\2\u026b\u0269\3\2\2\2\u026c\u026f\3\2\2\2\u026d"+
		"\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026eS\3\2\2\2\u026f\u026d\3\2\2\2"+
		"\u0270\u0271\5V,\2\u0271\u0272\7X\2\2\u0272U\3\2\2\2\u0273\u0274\b,\1"+
		"\2\u0274\u0275\7R\2\2\u0275\u0276\5V,\2\u0276\u0277\7S\2\2\u0277\u0347"+
		"\3\2\2\2\u0278\u0347\7\u0081\2\2\u0279\u0347\t\6\2\2\u027a\u0347\5Z.\2"+
		"\u027b\u0284\7R\2\2\u027c\u0281\7\u0081\2\2\u027d\u027e\7Y\2\2\u027e\u0280"+
		"\7\u0081\2\2\u027f\u027d\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2"+
		"\2\u0281\u0282\3\2\2\2\u0282\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u027c"+
		"\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0289\7S\2\2\u0287"+
		"\u0289\7\u0081\2\2\u0288\u027b\3\2\2\2\u0288\u0287\3\2\2\2\u0289\u028a"+
		"\3\2\2\2\u028a\u028d\t\7\2\2\u028b\u028e\5:\36\2\u028c\u028e\5V,\2\u028d"+
		"\u028b\3\2\2\2\u028d\u028c\3\2\2\2\u028e\u0347\3\2\2\2\u028f\u0290\7^"+
		"\2\2\u0290\u0291\7\u0081\2\2\u0291\u0292\7Y\2\2\u0292\u0293\7\u0081\2"+
		"\2\u0293\u0295\7]\2\2\u0294\u028f\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u02ac"+
		"\3\2\2\2\u0296\u0297\7V\2\2\u0297\u0298\5V,\2\u0298\u0299\7b\2\2\u0299"+
		"\u02a1\5V,\2\u029a\u029b\7Y\2\2\u029b\u029c\5V,\2\u029c\u029d\7b\2\2\u029d"+
		"\u029e\5V,\2\u029e\u02a0\3\2\2\2\u029f\u029a\3\2\2\2\u02a0\u02a3\3\2\2"+
		"\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1"+
		"\3\2\2\2\u02a4\u02a6\7Y\2\2\u02a5\u02a4\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6"+
		"\u02a7\3\2\2\2\u02a7\u02a8\7W\2\2\u02a8\u02ad\3\2\2\2\u02a9\u02aa\7V\2"+
		"\2\u02aa\u02ab\7b\2\2\u02ab\u02ad\7W\2\2\u02ac\u0296\3\2\2\2\u02ac\u02a9"+
		"\3\2\2\2\u02ad\u0347\3\2\2\2\u02ae\u02af\7^\2\2\u02af\u02b0\5\32\16\2"+
		"\u02b0\u02b1\7]\2\2\u02b1\u02b3\3\2\2\2\u02b2\u02ae\3\2\2\2\u02b2\u02b3"+
		"\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02bd\7V\2\2\u02b5\u02ba\5V,\2\u02b6"+
		"\u02b7\7Y\2\2\u02b7\u02b9\5V,\2\u02b8\u02b6\3\2\2\2\u02b9\u02bc\3\2\2"+
		"\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba"+
		"\3\2\2\2\u02bd\u02b5\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02c0\3\2\2\2\u02bf"+
		"\u02c1\7Y\2\2\u02c0\u02bf\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\3\2"+
		"\2\2\u02c2\u0347\7W\2\2\u02c3\u02c7\7\u0081\2\2\u02c4\u02c7\7>\2\2\u02c5"+
		"\u02c7\7;\2\2\u02c6\u02c3\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c6\u02c5\3\2"+
		"\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02d1\7R\2\2\u02c9\u02ce\5V,\2\u02ca\u02cb"+
		"\7Y\2\2\u02cb\u02cd\5V,\2\u02cc\u02ca\3\2\2\2\u02cd\u02d0\3\2\2\2\u02ce"+
		"\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d2\3\2\2\2\u02d0\u02ce\3\2"+
		"\2\2\u02d1\u02c9\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3"+
		"\u0347\7S\2\2\u02d4\u02d5\7\62\2\2\u02d5\u02d6\5\34\17\2\u02d6\u02df\7"+
		"R\2\2\u02d7\u02dc\5V,\2\u02d8\u02d9\7Y\2\2\u02d9\u02db\5V,\2\u02da\u02d8"+
		"\3\2\2\2\u02db\u02de\3\2\2\2\u02dc\u02da\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd"+
		"\u02e0\3\2\2\2\u02de\u02dc\3\2\2\2\u02df\u02d7\3\2\2\2\u02df\u02e0\3\2"+
		"\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e2\7S\2\2\u02e2\u0347\3\2\2\2\u02e3"+
		"\u02e4\7\62\2\2\u02e4\u02e9\5\32\16\2\u02e5\u02e6\7V\2\2\u02e6\u02e7\5"+
		"V,\2\u02e7\u02e8\7W\2\2\u02e8\u02ea\3\2\2\2\u02e9\u02e5\3\2\2\2\u02ea"+
		"\u02eb\3\2\2\2\u02eb\u02e9\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02f1\3\2"+
		"\2\2\u02ed\u02ee\7V\2\2\u02ee\u02f0\7W\2\2\u02ef\u02ed\3\2\2\2\u02f0\u02f3"+
		"\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u0306\3\2\2\2\u02f3"+
		"\u02f1\3\2\2\2\u02f4\u02f5\7\62\2\2\u02f5\u02f6\5\32\16\2\u02f6\u02f7"+
		"\7V\2\2\u02f7\u02f8\7W\2\2\u02f8\u0301\7T\2\2\u02f9\u02fe\5V,\2\u02fa"+
		"\u02fb\7Y\2\2\u02fb\u02fd\5V,\2\u02fc\u02fa\3\2\2\2\u02fd\u0300\3\2\2"+
		"\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0302\3\2\2\2\u0300\u02fe"+
		"\3\2\2\2\u0301\u02f9\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303"+
		"\u0304\7U\2\2\u0304\u0306\3\2\2\2\u0305\u02e3\3\2\2\2\u0305\u02f4\3\2"+
		"\2\2\u0306\u0347\3\2\2\2\u0307\u0308\7\62\2\2\u0308\u0309\5\34\17\2\u0309"+
		"\u030a\7R\2\2\u030a\u030b\7T\2\2\u030b\u0310\5X-\2\u030c\u030d\7Y\2\2"+
		"\u030d\u030f\5X-\2\u030e\u030c\3\2\2\2\u030f\u0312\3\2\2\2\u0310\u030e"+
		"\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0313"+
		"\u0315\7Y\2\2\u0314\u0313\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\3\2"+
		"\2\2\u0316\u0317\7U\2\2\u0317\u0318\7S\2\2\u0318\u0347\3\2\2\2\u0319\u031a"+
		"\7R\2\2\u031a\u031b\5\32\16\2\u031b\u031c\7S\2\2\u031c\u031d\5V,\30\u031d"+
		"\u0347\3\2\2\2\u031e\u031f\7I\2\2\u031f\u0347\5V,\27\u0320\u0321\t\b\2"+
		"\2\u0321\u0347\5V,\25\u0322\u0323\t\t\2\2\u0323\u0347\5V,\24\u0324\u0325"+
		"\t\n\2\2\u0325\u0347\5V,\23\u0326\u0327\7\u0080\2\2\u0327\u0330\5V,\2"+
		"\u0328\u032a\7U\2\2\u0329\u032b\7\u008f\2\2\u032a\u0329\3\2\2\2\u032a"+
		"\u032b\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\7\u008d\2\2\u032d\u032f"+
		"\5V,\2\u032e\u0328\3\2\2\2\u032f\u0332\3\2\2\2\u0330\u032e\3\2\2\2\u0330"+
		"\u0331\3\2\2\2\u0331\u0333\3\2\2\2\u0332\u0330\3\2\2\2\u0333\u0335\7U"+
		"\2\2\u0334\u0336\7\u008f\2\2\u0335\u0334\3\2\2\2\u0335\u0336\3\2\2\2\u0336"+
		"\u0337\3\2\2\2\u0337\u0338\7\u008e\2\2\u0338\u0347\3\2\2\2\u0339\u033a"+
		"\7G\2\2\u033a\u033b\7R\2\2\u033b\u033c\5V,\2\u033c\u033d\7S\2\2\u033d"+
		"\u0341\7T\2\2\u033e\u0340\5.\30\2\u033f\u033e\3\2\2\2\u0340\u0343\3\2"+
		"\2\2\u0341\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0344\3\2\2\2\u0343"+
		"\u0341\3\2\2\2\u0344\u0345\7U\2\2\u0345\u0347\3\2\2\2\u0346\u0273\3\2"+
		"\2\2\u0346\u0278\3\2\2\2\u0346\u0279\3\2\2\2\u0346\u027a\3\2\2\2\u0346"+
		"\u0288\3\2\2\2\u0346\u0294\3\2\2\2\u0346\u02b2\3\2\2\2\u0346\u02c6\3\2"+
		"\2\2\u0346\u02d4\3\2\2\2\u0346\u0305\3\2\2\2\u0346\u0307\3\2\2\2\u0346"+
		"\u0319\3\2\2\2\u0346\u031e\3\2\2\2\u0346\u0320\3\2\2\2\u0346\u0322\3\2"+
		"\2\2\u0346\u0324\3\2\2\2\u0346\u0326\3\2\2\2\u0346\u0339\3\2\2\2\u0347"+
		"\u039b\3\2\2\2\u0348\u0349\f\22\2\2\u0349\u034a\t\13\2\2\u034a\u039a\5"+
		"V,\23\u034b\u034c\f\21\2\2\u034c\u034d\t\b\2\2\u034d\u039a\5V,\22\u034e"+
		"\u0356\f\20\2\2\u034f\u0350\7^\2\2\u0350\u0357\7^\2\2\u0351\u0352\7]\2"+
		"\2\u0352\u0353\7]\2\2\u0353\u0357\7]\2\2\u0354\u0355\7]\2\2\u0355\u0357"+
		"\7]\2\2\u0356\u034f\3\2\2\2\u0356\u0351\3\2\2\2\u0356\u0354\3\2\2\2\u0357"+
		"\u0358\3\2\2\2\u0358\u039a\5V,\21\u0359\u035a\f\17\2\2\u035a\u035b\t\f"+
		"\2\2\u035b\u039a\5V,\20\u035c\u035d\f\r\2\2\u035d\u035e\t\r\2\2\u035e"+
		"\u039a\5V,\16\u035f\u0360\f\f\2\2\u0360\u0361\7q\2\2\u0361\u039a\5V,\r"+
		"\u0362\u0363\f\13\2\2\u0363\u0364\7s\2\2\u0364\u039a\5V,\f\u0365\u0366"+
		"\f\n\2\2\u0366\u0367\7r\2\2\u0367\u039a\5V,\13\u0368\u0369\f\t\2\2\u0369"+
		"\u036a\7i\2\2\u036a\u039a\5V,\n\u036b\u036c\f\b\2\2\u036c\u036d\7j\2\2"+
		"\u036d\u039a\5V,\t\u036e\u036f\f\7\2\2\u036f\u0370\7\20\2\2\u0370\u039a"+
		"\5V,\b\u0371\u0372\f\6\2\2\u0372\u0373\7a\2\2\u0373\u0374\5V,\2\u0374"+
		"\u0375\7b\2\2\u0375\u0376\5V,\7\u0376\u039a\3\2\2\2\u0377\u0378\f\3\2"+
		"\2\u0378\u0379\t\16\2\2\u0379\u039a\5V,\3\u037a\u037b\f \2\2\u037b\u037c"+
		"\t\17\2\2\u037c\u037d\t\20\2\2\u037d\u0386\7R\2\2\u037e\u0383\5V,\2\u037f"+
		"\u0380\7Y\2\2\u0380\u0382\5V,\2\u0381\u037f\3\2\2\2\u0382\u0385\3\2\2"+
		"\2\u0383\u0381\3\2\2\2\u0383\u0384\3\2\2\2\u0384\u0387\3\2\2\2\u0385\u0383"+
		"\3\2\2\2\u0386\u037e\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u0388\3\2\2\2\u0388"+
		"\u039a\7S\2\2\u0389\u038a\f\37\2\2\u038a\u038b\t\21\2\2\u038b\u039a\t"+
		"\20\2\2\u038c\u038d\f\35\2\2\u038d\u038e\7V\2\2\u038e\u038f\5V,\2\u038f"+
		"\u0390\7W\2\2\u0390\u039a\3\2\2\2\u0391\u0392\f\31\2\2\u0392\u0393\7\3"+
		"\2\2\u0393\u039a\7\u0081\2\2\u0394\u0395\f\26\2\2\u0395\u039a\t\t\2\2"+
		"\u0396\u0397\f\16\2\2\u0397\u0398\7-\2\2\u0398\u039a\7\u0081\2\2\u0399"+
		"\u0348\3\2\2\2\u0399\u034b\3\2\2\2\u0399\u034e\3\2\2\2\u0399\u0359\3\2"+
		"\2\2\u0399\u035c\3\2\2\2\u0399\u035f\3\2\2\2\u0399\u0362\3\2\2\2\u0399"+
		"\u0365\3\2\2\2\u0399\u0368\3\2\2\2\u0399\u036b\3\2\2\2\u0399\u036e\3\2"+
		"\2\2\u0399\u0371\3\2\2\2\u0399\u0377\3\2\2\2\u0399\u037a\3\2\2\2\u0399"+
		"\u0389\3\2\2\2\u0399\u038c\3\2\2\2\u0399\u0391\3\2\2\2\u0399\u0394\3\2"+
		"\2\2\u0399\u0396\3\2\2\2\u039a\u039d\3\2\2\2\u039b\u0399\3\2\2\2\u039b"+
		"\u039c\3\2\2\2\u039cW\3\2\2\2\u039d\u039b\3\2\2\2\u039e\u03a1\7\u0081"+
		"\2\2\u039f\u03a0\7b\2\2\u03a0\u03a2\5V,\2\u03a1\u039f\3\2\2\2\u03a1\u03a2"+
		"\3\2\2\2\u03a2Y\3\2\2\2\u03a3\u03b5\7K\2\2\u03a4\u03b5\7L\2\2\u03a5\u03b5"+
		"\7N\2\2\u03a6\u03b5\7O\2\2\u03a7\u03b5\7P\2\2\u03a8\u03b5\7M\2\2\u03a9"+
		"\u03ac\5&\24\2\u03aa\u03ac\7\u0081\2\2\u03ab\u03a9\3\2\2\2\u03ab\u03aa"+
		"\3\2\2\2\u03ac\u03af\3\2\2\2\u03ad\u03ae\7V\2\2\u03ae\u03b0\7W\2\2\u03af"+
		"\u03ad\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b2\7Z"+
		"\2\2\u03b2\u03b5\7\34\2\2\u03b3\u03b5\7Q\2\2\u03b4\u03a3\3\2\2\2\u03b4"+
		"\u03a4\3\2\2\2\u03b4\u03a5\3\2\2\2\u03b4\u03a6\3\2\2\2\u03b4\u03a7\3\2"+
		"\2\2\u03b4\u03a8\3\2\2\2\u03b4\u03ab\3\2\2\2\u03b4\u03b3\3\2\2\2\u03b5"+
		"[\3\2\2\2\u03b6\u03b8\t\22\2\2\u03b7\u03b6\3\2\2\2\u03b8\u03b9\3\2\2\2"+
		"\u03b9\u03b7\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba]\3\2\2\2{ajp{}\u0083\u0087"+
		"\u0090\u0095\u0098\u009b\u009f\u00a7\u00aa\u00b2\u00b9\u00c1\u00c9\u00cb"+
		"\u00cf\u00d6\u00de\u00e2\u00e5\u00e8\u00f0\u00f5\u00f8\u00fe\u0106\u0109"+
		"\u0112\u0115\u0119\u011d\u0122\u0130\u0134\u0137\u013c\u0142\u0146\u0150"+
		"\u0153\u0156\u0159\u015c\u0166\u0169\u016d\u0171\u0176\u017f\u0182\u018b"+
		"\u0195\u019f\u01a3\u01af\u01c2\u01c7\u01d1\u01db\u01e7\u01eb\u01ef\u01fb"+
		"\u0200\u0204\u0212\u0216\u021b\u021f\u0225\u0227\u0241\u0245\u0249\u0253"+
		"\u0260\u0266\u026d\u0281\u0284\u0288\u028d\u0294\u02a1\u02a5\u02ac\u02b2"+
		"\u02ba\u02bd\u02c0\u02c6\u02ce\u02d1\u02dc\u02df\u02eb\u02f1\u02fe\u0301"+
		"\u0305\u0310\u0314\u032a\u0330\u0335\u0341\u0346\u0356\u0383\u0386\u0399"+
		"\u039b\u03a1\u03ab\u03af\u03b4\u03b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
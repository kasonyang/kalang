// Generated from KalangParser.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOUBLE_COLON=1, AS=2, CONSTRUCTOR=3, VAR=4, VAL=5, FOREACH=6, ARROW=7, 
		LAMBDA_ARROW=8, STAR_DOT=9, STAR_ARROW=10, QUESTION_DOT=11, QUESTION_ARROW=12, 
		OVERRIDE=13, ABSTRACT=14, ASSERT=15, BOOLEAN=16, BREAK=17, BYTE=18, CASE=19, 
		CATCH=20, CHAR=21, CLASS=22, CONST=23, CONTINUE=24, DEFAULT=25, DO=26, 
		DOUBLE=27, ELSE=28, ENUM=29, EXTENDS=30, FINAL=31, FINALLY=32, FLOAT=33, 
		FOR=34, IF=35, GOTO=36, IMPLEMENTS=37, IMPORT=38, INSTANCEOF=39, INT=40, 
		INTERFACE=41, LONG=42, NATIVE=43, NEW=44, PACKAGE=45, PRIVATE=46, PROTECTED=47, 
		PUBLIC=48, RETURN=49, SHORT=50, STATIC=51, STRICTFP=52, SUPER=53, SWITCH=54, 
		SYNCHRONIZED=55, THIS=56, THROW=57, THROWS=58, TRANSIENT=59, TRY=60, VOID=61, 
		VOLATILE=62, WHILE=63, MIXIN=64, WITH=65, IntegerLiteral=66, FloatingPointLiteral=67, 
		BooleanLiteral=68, CharacterLiteral=69, StringLiteral=70, MultiLineStringLiteral=71, 
		NullLiteral=72, LPAREN=73, RPAREN=74, LBRACE=75, RBRACE=76, LBRACK=77, 
		RBRACK=78, SEMI=79, COMMA=80, DOT=81, ASSIGN=82, GT=83, LT=84, BANG=85, 
		TILDE=86, QUESTION=87, COLON=88, EQUAL=89, SAME=90, LE=91, GE=92, NOTEQUAL=93, 
		NOTSAME=94, AND=95, OR=96, INC=97, DEC=98, ADD=99, SUB=100, MUL=101, DIV=102, 
		BITAND=103, BITOR=104, CARET=105, MOD=106, ADD_ASSIGN=107, SUB_ASSIGN=108, 
		MUL_ASSIGN=109, DIV_ASSIGN=110, AND_ASSIGN=111, OR_ASSIGN=112, XOR_ASSIGN=113, 
		MOD_ASSIGN=114, LSHIFT_ASSIGN=115, RSHIFT_ASSIGN=116, URSHIFT_ASSIGN=117, 
		InterpolationPreffixString=118, Identifier=119, AT=120, ELLIPSIS=121, 
		COMPILE_OPTION_LINE=122, WS=123, COMMENT=124, LINE_COMMENT=125, PACKAGE_DELIMITER=126, 
		INTERPOLATION_INTERUPT=127, INTERPOLATION_END=128, INTERPOLATION_STRING=129;
	public static final int
		RULE_compilationUnit = 0, RULE_compileOption = 1, RULE_scriptDef = 2, 
		RULE_classDef = 3, RULE_importDecl = 4, RULE_qualifiedName = 5, RULE_classBody = 6, 
		RULE_fieldDecl = 7, RULE_methodDecl = 8, RULE_annotation = 9, RULE_type = 10, 
		RULE_classType = 11, RULE_lambdaType = 12, RULE_parameterizedElementType = 13, 
		RULE_wildcardType = 14, RULE_primitiveType = 15, RULE_localVarDecl = 16, 
		RULE_ifStat = 17, RULE_stat = 18, RULE_emptyStat = 19, RULE_errorousStat = 20, 
		RULE_assertStmt = 21, RULE_throwStat = 22, RULE_blockStmt = 23, RULE_tryStat = 24, 
		RULE_returnStat = 25, RULE_varDeclStat = 26, RULE_varDecl = 27, RULE_breakStat = 28, 
		RULE_continueStat = 29, RULE_whileStat = 30, RULE_doWhileStat = 31, RULE_forStat = 32, 
		RULE_forEachStat = 33, RULE_expressions = 34, RULE_exprStat = 35, RULE_expression = 36, 
		RULE_literal = 37, RULE_varModifier = 38;
	public static final String[] ruleNames = {
		"compilationUnit", "compileOption", "scriptDef", "classDef", "importDecl", 
		"qualifiedName", "classBody", "fieldDecl", "methodDecl", "annotation", 
		"type", "classType", "lambdaType", "parameterizedElementType", "wildcardType", 
		"primitiveType", "localVarDecl", "ifStat", "stat", "emptyStat", "errorousStat", 
		"assertStmt", "throwStat", "blockStmt", "tryStat", "returnStat", "varDeclStat", 
		"varDecl", "breakStat", "continueStat", "whileStat", "doWhileStat", "forStat", 
		"forEachStat", "expressions", "exprStat", "expression", "literal", "varModifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'::'", "'as'", "'constructor'", "'var'", "'val'", "'foreach'", 
		"'->'", "'=>'", "'*.'", "'*->'", "'?.'", "'?->'", "'override'", "'abstract'", 
		"'assert'", "'boolean'", "'break'", "'byte'", "'case'", "'catch'", "'char'", 
		"'class'", "'const'", "'continue'", "'default'", "'do'", "'double'", "'else'", 
		"'enum'", "'extends'", "'final'", "'finally'", "'float'", "'for'", "'if'", 
		"'goto'", "'implements'", "'import'", "'instanceof'", "'int'", "'interface'", 
		"'long'", "'native'", "'new'", "'package'", "'private'", "'protected'", 
		"'public'", "'return'", "'short'", "'static'", "'strictfp'", "'super'", 
		"'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", "'transient'", 
		"'try'", "'void'", "'volatile'", "'while'", "'mixin'", "'with'", null, 
		null, null, null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", 
		"':'", "'=='", "'==='", "'<='", "'>='", "'!='", "'!=='", "'&&'", "'||'", 
		"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", 
		"'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", 
		"'>>='", "'>>>='", null, null, "'@'", "'...'", null, null, null, null, 
		"'\\'", "'${'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOUBLE_COLON", "AS", "CONSTRUCTOR", "VAR", "VAL", "FOREACH", "ARROW", 
		"LAMBDA_ARROW", "STAR_DOT", "STAR_ARROW", "QUESTION_DOT", "QUESTION_ARROW", 
		"OVERRIDE", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", 
		"CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", 
		"ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
		"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", 
		"NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", 
		"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
		"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "MIXIN", "WITH", 
		"IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "MultiLineStringLiteral", "NullLiteral", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
		"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "SAME", "LE", 
		"GE", "NOTEQUAL", "NOTSAME", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
		"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", 
		"LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "InterpolationPreffixString", 
		"Identifier", "AT", "ELLIPSIS", "COMPILE_OPTION_LINE", "WS", "COMMENT", 
		"LINE_COMMENT", "PACKAGE_DELIMITER", "INTERPOLATION_INTERUPT", "INTERPOLATION_END", 
		"INTERPOLATION_STRING"
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPILE_OPTION_LINE) {
				{
				{
				setState(78);
				compileOption();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(84);
				importDecl();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(90);
				classDef();
				}
				break;
			case 2:
				{
				setState(91);
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
			setState(94);
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
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << SUPER) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRANSIENT) | (1L << TRY) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (SEMI - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)) | (1L << (AT - 65)))) != 0)) {
				{
				setState(99);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(96);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(97);
					stat();
					}
					break;
				case 3:
					{
					setState(98);
					classDef();
					}
					break;
				}
				}
				setState(103);
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
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(104);
				annotation();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0)) {
				{
				setState(110);
				varModifier();
				}
			}

			setState(127);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(113);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(124);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(114);
					match(LT);
					setState(115);
					((ClassDefContext)_localctx).Identifier = match(Identifier);
					((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(116);
						match(COMMA);
						setState(117);
						((ClassDefContext)_localctx).Identifier = match(Identifier);
						((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
						}
						}
						setState(122);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(123);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(126);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(130);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(129);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(134);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(132);
				match(EXTENDS);
				setState(133);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(145);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(136);
				match(IMPLEMENTS);
				setState(137);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(138);
					match(COMMA);
					setState(139);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(147);
			match(LBRACE);
			setState(148);
			classBody();
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

	public static class ImportDeclContext extends ParserRuleContext {
		public Token importMode;
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
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(151);
				match(IMPORT);
				setState(154);
				switch (_input.LA(1)) {
				case STATIC:
					{
					setState(152);
					((ImportDeclContext)_localctx).importMode = match(STATIC);
					}
					break;
				case MIXIN:
					{
					setState(153);
					match(MIXIN);
					}
					break;
				case Identifier:
				case PACKAGE_DELIMITER:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(157);
				_la = _input.LA(1);
				if (_la==PACKAGE_DELIMITER) {
					{
					setState(156);
					((ImportDeclContext)_localctx).root = match(PACKAGE_DELIMITER);
					}
				}

				setState(159);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(160);
						match(PACKAGE_DELIMITER);
						setState(161);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(167);
				((ImportDeclContext)_localctx).delim = match(PACKAGE_DELIMITER);
				setState(174);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(168);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(171);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(169);
						match(AS);
						setState(170);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(173);
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
				setState(176);
				match(IMPORT);
				setState(178);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(177);
					((ImportDeclContext)_localctx).importMode = match(STATIC);
					}
				}

				setState(180);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(181);
						match(DOT);
						setState(182);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(187);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(188);
				((ImportDeclContext)_localctx).delim = match(DOT);
				setState(195);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(189);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(192);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(190);
						match(AS);
						setState(191);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(194);
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
			setState(199);
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
			setState(201);
			match(Identifier);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(202);
				match(DOT);
				setState(203);
				match(Identifier);
				}
				}
				setState(208);
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
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE))) != 0) || ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (BITAND - 103)) | (1L << (Identifier - 103)) | (1L << (AT - 103)))) != 0)) {
				{
				setState(212);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(209);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(210);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(211);
					classDef();
					}
					break;
				}
				}
				setState(216);
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
			setState(218);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0)) {
				{
				setState(217);
				varModifier();
				}
			}

			setState(220);
			varDecl();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(221);
				match(COMMA);
				setState(222);
				varDecl();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
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
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(230);
				annotation();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(236);
				match(OVERRIDE);
				}
			}

			setState(240);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(239);
				match(DEFAULT);
				}
			}

			setState(243);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0)) {
				{
				setState(242);
				varModifier();
				}
			}

			setState(249);
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
				setState(245);
				((MethodDeclContext)_localctx).returnType = type(0);
				setState(246);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case CONSTRUCTOR:
				{
				{
				setState(248);
				((MethodDeclContext)_localctx).prefix = match(CONSTRUCTOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(251);
			match(LPAREN);
			setState(263);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << VOID))) != 0) || _la==BITAND || _la==Identifier) {
				{
				setState(252);
				((MethodDeclContext)_localctx).type = type(0);
				((MethodDeclContext)_localctx).paramTypes.add(((MethodDeclContext)_localctx).type);
				setState(253);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).paramIds.add(((MethodDeclContext)_localctx).Identifier);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(254);
					match(COMMA);
					setState(255);
					((MethodDeclContext)_localctx).type = type(0);
					((MethodDeclContext)_localctx).paramTypes.add(((MethodDeclContext)_localctx).type);
					setState(256);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).paramIds.add(((MethodDeclContext)_localctx).Identifier);
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
		enterRule(_localctx, 18, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(AT);
			setState(282);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(300);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(283);
				match(LPAREN);
				setState(297);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					{
					setState(284);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(285);
					match(ASSIGN);
					setState(286);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(287);
						match(COMMA);
						setState(288);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(289);
						match(ASSIGN);
						setState(290);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(295);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(296);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(299);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			switch (_input.LA(1)) {
			case BITAND:
			case Identifier:
				{
				setState(303);
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
				setState(304);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(307);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(308);
					match(LBRACK);
					setState(309);
					match(RBRACK);
					setState(311);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(310);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		public Token innerClass;
		public ParameterizedElementTypeContext parameterizedElementType;
		public List<ParameterizedElementTypeContext> parameterTypes = new ArrayList<ParameterizedElementTypeContext>();
		public Token nullable;
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
		}
		public List<ParameterizedElementTypeContext> parameterizedElementType() {
			return getRuleContexts(ParameterizedElementTypeContext.class);
		}
		public ParameterizedElementTypeContext parameterizedElementType(int i) {
			return getRuleContext(ParameterizedElementTypeContext.class,i);
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
		enterRule(_localctx, 22, RULE_classType);
		int _la;
		try {
			int _alt;
			setState(347);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(318);
						((ClassTypeContext)_localctx).Identifier = match(Identifier);
						((ClassTypeContext)_localctx).paths.add(((ClassTypeContext)_localctx).Identifier);
						setState(319);
						match(PACKAGE_DELIMITER);
						}
						} 
					}
					setState(324);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(325);
				((ClassTypeContext)_localctx).rawClass = match(Identifier);
				setState(328);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(326);
					match(DOUBLE_COLON);
					setState(327);
					((ClassTypeContext)_localctx).innerClass = match(Identifier);
					}
					break;
				}
				setState(341);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(330);
					match(LT);
					setState(331);
					((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
					((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(332);
						match(COMMA);
						setState(333);
						((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
						((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
						}
						}
						setState(338);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(339);
					match(GT);
					}
					break;
				}
				setState(344);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(343);
					((ClassTypeContext)_localctx).nullable = match(QUESTION);
					}
					break;
				}
				}
				break;
			case BITAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
		enterRule(_localctx, 24, RULE_lambdaType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(BITAND);
			setState(350);
			((LambdaTypeContext)_localctx).returnType = type(0);
			setState(351);
			match(LPAREN);
			setState(360);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << VOID))) != 0) || _la==BITAND || _la==Identifier) {
				{
				setState(352);
				((LambdaTypeContext)_localctx).type = type(0);
				((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(353);
					match(COMMA);
					setState(354);
					((LambdaTypeContext)_localctx).type = type(0);
					((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(362);
			match(RPAREN);
			setState(364);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(363);
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
		enterRule(_localctx, 26, RULE_parameterizedElementType);
		try {
			setState(368);
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
				setState(366);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
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
		enterRule(_localctx, 28, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(QUESTION);
			setState(371);
			((WildcardTypeContext)_localctx).boundKind = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
				((WildcardTypeContext)_localctx).boundKind = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(372);
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
		enterRule(_localctx, 30, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << VOID))) != 0)) ) {
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
		enterRule(_localctx, 32, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			varDecl();
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(377);
				match(COMMA);
				setState(378);
				varDecl();
				}
				}
				setState(383);
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
		enterRule(_localctx, 34, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(IF);
			setState(385);
			match(LPAREN);
			setState(386);
			expression(0);
			setState(387);
			match(RPAREN);
			setState(388);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(391);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(389);
				match(ELSE);
				setState(390);
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
		enterRule(_localctx, 36, RULE_stat);
		try {
			setState(409);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				emptyStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				blockStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(395);
				varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(396);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(397);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(398);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(399);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(400);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(401);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(402);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(403);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(404);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(405);
				tryStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(406);
				throwStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(407);
				errorousStat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(408);
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
		enterRule(_localctx, 38, RULE_emptyStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 40, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 42, RULE_assertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(ASSERT);
			setState(416);
			((AssertStmtContext)_localctx).testCondition = expression(0);
			setState(419);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(417);
				match(COLON);
				setState(418);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(THROW);
			setState(422);
			expression(0);
			setState(423);
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
		enterRule(_localctx, 46, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(LBRACE);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (SEMI - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				{
				setState(426);
				stat();
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
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
		enterRule(_localctx, 48, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(TRY);
			setState(435);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(436);
				match(CATCH);
				setState(437);
				match(LPAREN);
				setState(438);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(439);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(440);
				match(RPAREN);
				setState(441);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(450);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(448);
				match(FINALLY);
				setState(449);
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
		enterRule(_localctx, 50, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(RETURN);
			setState(454);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(453);
				expression(0);
				}
			}

			setState(456);
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
		enterRule(_localctx, 52, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			localVarDecl();
			setState(459);
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
		public Token varToken;
		public Token valToken;
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
		enterRule(_localctx, 54, RULE_varDecl);
		int _la;
		try {
			setState(480);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(463);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(461);
					((VarDeclContext)_localctx).varToken = match(VAR);
					}
					break;
				case VAL:
					{
					setState(462);
					((VarDeclContext)_localctx).valToken = match(VAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(465);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(468);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(466);
					match(AS);
					setState(467);
					type(0);
					}
				}

				setState(472);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(470);
					match(ASSIGN);
					setState(471);
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
				setState(474);
				((VarDeclContext)_localctx).varType = type(0);
				setState(475);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(478);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(476);
					match(ASSIGN);
					setState(477);
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
		enterRule(_localctx, 56, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(BREAK);
			setState(483);
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
		enterRule(_localctx, 58, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(CONTINUE);
			setState(486);
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
		enterRule(_localctx, 60, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(WHILE);
			setState(489);
			match(LPAREN);
			setState(490);
			expression(0);
			setState(491);
			match(RPAREN);
			setState(492);
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
		enterRule(_localctx, 62, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(DO);
			setState(495);
			blockStmt();
			setState(496);
			match(WHILE);
			setState(497);
			match(LPAREN);
			setState(498);
			expression(0);
			setState(499);
			match(RPAREN);
			setState(500);
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
		enterRule(_localctx, 64, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(FOR);
			setState(503);
			match(LPAREN);
			setState(506);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(504);
				localVarDecl();
				}
				break;
			case 2:
				{
				setState(505);
				((ForStatContext)_localctx).initExpressions = expressions();
				}
				break;
			}
			setState(508);
			match(SEMI);
			setState(510);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(509);
				((ForStatContext)_localctx).condition = expression(0);
				}
			}

			setState(512);
			match(SEMI);
			setState(514);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(513);
				((ForStatContext)_localctx).updateExpressions = expressions();
				}
			}

			setState(516);
			match(RPAREN);
			setState(517);
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
		enterRule(_localctx, 66, RULE_forEachStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			match(FOREACH);
			setState(520);
			match(LPAREN);
			setState(521);
			expression(0);
			setState(522);
			match(AS);
			setState(525);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(523);
				match(Identifier);
				setState(524);
				match(COMMA);
				}
				break;
			}
			setState(527);
			match(Identifier);
			setState(528);
			match(RPAREN);
			setState(529);
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
		enterRule(_localctx, 68, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			expression(0);
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(532);
				match(COMMA);
				setState(533);
				expression(0);
				}
				}
				setState(538);
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
		enterRule(_localctx, 70, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			expression(0);
			setState(540);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
	public static class GetFieldExprContext extends ExpressionContext {
		public Token refKey;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
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
	public static class WithExprContext extends ExpressionContext {
		public TerminalNode WITH() { return getToken(KalangParser.WITH, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(543);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(544);
				expression(20);
				}
				break;
			case 2:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(545);
				((PreIncExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(546);
				expression(19);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(547);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(548);
				expression(18);
				}
				break;
			case 4:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(549);
				match(LPAREN);
				setState(550);
				type(0);
				setState(551);
				match(RPAREN);
				setState(552);
				expression(17);
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(554);
				match(LPAREN);
				setState(555);
				expression(0);
				setState(556);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(558);
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
				setState(559);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(612);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					{
					setState(561);
					_la = _input.LA(1);
					if (_la==BITAND) {
						{
						setState(560);
						lambdaType();
						}
					}

					setState(563);
					match(LBRACE);
					setState(573);
					switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
					case 1:
						{
						setState(564);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						setState(569);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(565);
							match(COMMA);
							setState(566);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							}
							}
							setState(571);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(572);
						match(LAMBDA_ARROW);
						}
						break;
					}
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (SEMI - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						{
						setState(575);
						stat();
						}
						}
						setState(580);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(581);
					match(RBRACE);
					}
					}
					break;
				case 2:
					{
					{
					setState(598);
					switch (_input.LA(1)) {
					case LPAREN:
					case BITAND:
						{
						{
						setState(583);
						_la = _input.LA(1);
						if (_la==BITAND) {
							{
							setState(582);
							lambdaType();
							}
						}

						setState(585);
						match(LPAREN);
						setState(594);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(586);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							setState(591);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(587);
								match(COMMA);
								setState(588);
								((LambdaExprContext)_localctx).Identifier = match(Identifier);
								((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
								}
								}
								setState(593);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(596);
						match(RPAREN);
						}
						}
						break;
					case Identifier:
						{
						setState(597);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(600);
					match(LAMBDA_ARROW);
					setState(610);
					switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
					case 1:
						{
						{
						setState(601);
						match(LBRACE);
						setState(605);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (SEMI - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							{
							setState(602);
							stat();
							}
							}
							setState(607);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(608);
						match(RBRACE);
						}
						}
						break;
					case 2:
						{
						setState(609);
						expression(0);
						}
						break;
					}
					}
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(619);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(614);
					match(LT);
					setState(615);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(616);
					match(COMMA);
					setState(617);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(618);
					match(GT);
					}
				}

				setState(640);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(621);
					match(LBRACK);
					setState(622);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
					setState(623);
					match(COLON);
					setState(624);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(625);
						match(COMMA);
						setState(626);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
						setState(627);
						match(COLON);
						setState(628);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
						}
						}
						setState(634);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(635);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(637);
					match(LBRACK);
					setState(638);
					match(COLON);
					setState(639);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(646);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(642);
					match(LT);
					setState(643);
					type(0);
					setState(644);
					match(GT);
					}
				}

				setState(648);
				match(LBRACK);
				setState(657);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(649);
					expression(0);
					setState(654);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(650);
						match(COMMA);
						setState(651);
						expression(0);
						}
						}
						setState(656);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(659);
				match(RBRACK);
				}
				break;
			case 11:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(663);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(660);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(661);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(662);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(665);
				match(LPAREN);
				setState(674);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(666);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(671);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(667);
						match(COMMA);
						setState(668);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(673);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(676);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(677);
				match(NEW);
				setState(678);
				classType();
				setState(679);
				match(LPAREN);
				setState(688);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(680);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(685);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(681);
						match(COMMA);
						setState(682);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(687);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(690);
				match(RPAREN);
				}
				break;
			case 13:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(715);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(692);
					match(NEW);
					setState(693);
					type(0);
					setState(694);
					match(LBRACK);
					setState(695);
					((NewArrayExprContext)_localctx).size = expression(0);
					setState(696);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(698);
					match(NEW);
					setState(699);
					type(0);
					setState(700);
					match(LBRACK);
					setState(701);
					match(RBRACK);
					setState(702);
					match(LBRACE);
					setState(711);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
						{
						setState(703);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(708);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(704);
							match(COMMA);
							setState(705);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(710);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(713);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case 14:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(717);
				match(Identifier);
				}
				break;
			case 15:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(718);
				match(InterpolationPreffixString);
				setState(719);
				expression(0);
				setState(728);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(720);
						match(RBRACE);
						setState(722);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(721);
							match(INTERPOLATION_STRING);
							}
						}

						setState(724);
						match(INTERPOLATION_INTERUPT);
						setState(725);
						expression(0);
						}
						} 
					}
					setState(730);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
				}
				setState(731);
				match(RBRACE);
				setState(733);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(732);
					match(INTERPOLATION_STRING);
					}
				}

				setState(735);
				match(INTERPOLATION_END);
				}
				break;
			case 16:
				{
				_localctx = new WithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(737);
				match(WITH);
				setState(738);
				match(LPAREN);
				setState(739);
				expression(0);
				setState(740);
				match(RPAREN);
				setState(741);
				match(LBRACE);
				setState(745);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (SEMI - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					{
					setState(742);
					stat();
					}
					}
					setState(747);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(748);
				match(RBRACE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(828);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(826);
					switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(752);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(753);
						_la = _input.LA(1);
						if ( !(((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (MUL - 101)) | (1L << (DIV - 101)) | (1L << (MOD - 101)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(754);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(755);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(756);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(757);
						expression(16);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(758);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(766);
						switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
						case 1:
							{
							setState(759);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(760);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(761);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(762);
							match(GT);
							setState(763);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(764);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(765);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(768);
						expression(15);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(769);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(770);
						_la = _input.LA(1);
						if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (GT - 83)) | (1L << (LT - 83)) | (1L << (LE - 83)) | (1L << (GE - 83)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(771);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(772);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(773);
						_la = _input.LA(1);
						if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (EQUAL - 89)) | (1L << (SAME - 89)) | (1L << (NOTEQUAL - 89)) | (1L << (NOTSAME - 89)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(774);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(775);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(776);
						match(BITAND);
						setState(777);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(778);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(779);
						match(CARET);
						setState(780);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(781);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(782);
						match(BITOR);
						setState(783);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(784);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(785);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(786);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(787);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(788);
						match(QUESTION);
						setState(789);
						expression(0);
						setState(790);
						match(COLON);
						setState(791);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(793);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(794);
						_la = _input.LA(1);
						if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (ASSIGN - 82)) | (1L << (ADD_ASSIGN - 82)) | (1L << (SUB_ASSIGN - 82)) | (1L << (MUL_ASSIGN - 82)) | (1L << (DIV_ASSIGN - 82)) | (1L << (AND_ASSIGN - 82)) | (1L << (OR_ASSIGN - 82)) | (1L << (XOR_ASSIGN - 82)) | (1L << (MOD_ASSIGN - 82)) | (1L << (LSHIFT_ASSIGN - 82)) | (1L << (RSHIFT_ASSIGN - 82)) | (1L << (URSHIFT_ASSIGN - 82)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(795);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(796);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(797);
						((InvokeExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ARROW) | (1L << STAR_DOT) | (1L << STAR_ARROW) | (1L << QUESTION_DOT) | (1L << QUESTION_ARROW))) != 0) || _la==DOT) ) {
							((InvokeExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(798);
						match(Identifier);
						setState(799);
						match(LPAREN);
						setState(808);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (WITH - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (MultiLineStringLiteral - 65)) | (1L << (NullLiteral - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (LBRACK - 65)) | (1L << (LT - 65)) | (1L << (BANG - 65)) | (1L << (TILDE - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (BITAND - 65)) | (1L << (InterpolationPreffixString - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(800);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(805);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(801);
								match(COMMA);
								setState(802);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(807);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(810);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(811);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(812);
						((GetFieldExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ARROW) | (1L << STAR_DOT) | (1L << STAR_ARROW) | (1L << QUESTION_DOT) | (1L << QUESTION_ARROW))) != 0) || _la==DOT) ) {
							((GetFieldExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(813);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(814);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(815);
						match(LBRACK);
						setState(816);
						expression(0);
						setState(817);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(819);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(820);
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
						setState(821);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(822);
						match(INSTANCEOF);
						setState(823);
						match(Identifier);
						}
						break;
					case 17:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(824);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(825);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(830);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
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
		public TerminalNode MultiLineStringLiteral() { return getToken(KalangParser.MultiLineStringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(KalangParser.BooleanLiteral, 0); }
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
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
		enterRule(_localctx, 74, RULE_literal);
		try {
			setState(841);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(831);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(832);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(833);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(834);
				match(StringLiteral);
				}
				break;
			case MultiLineStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(835);
				match(MultiLineStringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(836);
				match(BooleanLiteral);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 7);
				{
				setState(837);
				match(Identifier);
				setState(838);
				match(DOT);
				setState(839);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 8);
				{
				setState(840);
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
		enterRule(_localctx, 76, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(843);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(846); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		case 10:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 36:
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
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 27);
		case 13:
			return precpred(_ctx, 26);
		case 14:
			return precpred(_ctx, 24);
		case 15:
			return precpred(_ctx, 21);
		case 16:
			return precpred(_ctx, 12);
		case 17:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0083\u0353\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\7\2R\n\2\f\2\16"+
		"\2U\13\2\3\2\7\2X\n\2\f\2\16\2[\13\2\3\2\3\2\5\2_\n\2\3\3\3\3\3\4\3\4"+
		"\3\4\7\4f\n\4\f\4\16\4i\13\4\3\5\7\5l\n\5\f\5\16\5o\13\5\3\5\5\5r\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5y\n\5\f\5\16\5|\13\5\3\5\5\5\177\n\5\3\5\5\5\u0082"+
		"\n\5\3\5\5\5\u0085\n\5\3\5\3\5\5\5\u0089\n\5\3\5\3\5\3\5\3\5\7\5\u008f"+
		"\n\5\f\5\16\5\u0092\13\5\5\5\u0094\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6"+
		"\u009d\n\6\3\6\5\6\u00a0\n\6\3\6\3\6\3\6\7\6\u00a5\n\6\f\6\16\6\u00a8"+
		"\13\6\3\6\3\6\3\6\3\6\5\6\u00ae\n\6\3\6\5\6\u00b1\n\6\3\6\3\6\5\6\u00b5"+
		"\n\6\3\6\3\6\3\6\7\6\u00ba\n\6\f\6\16\6\u00bd\13\6\3\6\3\6\3\6\3\6\5\6"+
		"\u00c3\n\6\3\6\5\6\u00c6\n\6\5\6\u00c8\n\6\3\6\3\6\3\7\3\7\3\7\7\7\u00cf"+
		"\n\7\f\7\16\7\u00d2\13\7\3\b\3\b\3\b\7\b\u00d7\n\b\f\b\16\b\u00da\13\b"+
		"\3\t\5\t\u00dd\n\t\3\t\3\t\3\t\7\t\u00e2\n\t\f\t\16\t\u00e5\13\t\3\t\3"+
		"\t\3\n\7\n\u00ea\n\n\f\n\16\n\u00ed\13\n\3\n\5\n\u00f0\n\n\3\n\5\n\u00f3"+
		"\n\n\3\n\5\n\u00f6\n\n\3\n\3\n\3\n\3\n\5\n\u00fc\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\7\n\u0105\n\n\f\n\16\n\u0108\13\n\5\n\u010a\n\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u0111\n\n\f\n\16\n\u0114\13\n\5\n\u0116\n\n\3\n\3\n\5\n\u011a"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0126\n\13"+
		"\f\13\16\13\u0129\13\13\3\13\5\13\u012c\n\13\3\13\5\13\u012f\n\13\3\f"+
		"\3\f\3\f\5\f\u0134\n\f\3\f\3\f\3\f\3\f\5\f\u013a\n\f\7\f\u013c\n\f\f\f"+
		"\16\f\u013f\13\f\3\r\3\r\7\r\u0143\n\r\f\r\16\r\u0146\13\r\3\r\3\r\3\r"+
		"\5\r\u014b\n\r\3\r\3\r\3\r\3\r\7\r\u0151\n\r\f\r\16\r\u0154\13\r\3\r\3"+
		"\r\5\r\u0158\n\r\3\r\5\r\u015b\n\r\3\r\5\r\u015e\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\7\16\u0166\n\16\f\16\16\16\u0169\13\16\5\16\u016b\n\16\3"+
		"\16\3\16\5\16\u016f\n\16\3\17\3\17\5\17\u0173\n\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\7\22\u017e\n\22\f\22\16\22\u0181\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u018a\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u019c\n\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u01a6\n\27\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\7\31\u01ae\n\31\f\31\16\31\u01b1\13\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u01be\n\32\f\32\16\32\u01c1"+
		"\13\32\3\32\3\32\5\32\u01c5\n\32\3\33\3\33\5\33\u01c9\n\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\5\35\u01d2\n\35\3\35\3\35\3\35\5\35\u01d7\n\35"+
		"\3\35\3\35\5\35\u01db\n\35\3\35\3\35\3\35\3\35\5\35\u01e1\n\35\5\35\u01e3"+
		"\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\5\"\u01fd\n\"\3\"\3\"\5\"\u0201\n\"\3\"\3\"\5"+
		"\"\u0205\n\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\5#\u0210\n#\3#\3#\3#\3#\3$"+
		"\3$\3$\7$\u0219\n$\f$\16$\u021c\13$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0234\n&\3&\3&\3&\3&\7&\u023a\n&\f"+
		"&\16&\u023d\13&\3&\5&\u0240\n&\3&\7&\u0243\n&\f&\16&\u0246\13&\3&\3&\5"+
		"&\u024a\n&\3&\3&\3&\3&\7&\u0250\n&\f&\16&\u0253\13&\5&\u0255\n&\3&\3&"+
		"\5&\u0259\n&\3&\3&\3&\7&\u025e\n&\f&\16&\u0261\13&\3&\3&\5&\u0265\n&\5"+
		"&\u0267\n&\3&\3&\3&\3&\3&\5&\u026e\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u0279"+
		"\n&\f&\16&\u027c\13&\3&\3&\3&\3&\3&\5&\u0283\n&\3&\3&\3&\3&\5&\u0289\n"+
		"&\3&\3&\3&\3&\7&\u028f\n&\f&\16&\u0292\13&\5&\u0294\n&\3&\3&\3&\3&\5&"+
		"\u029a\n&\3&\3&\3&\3&\7&\u02a0\n&\f&\16&\u02a3\13&\5&\u02a5\n&\3&\3&\3"+
		"&\3&\3&\3&\3&\7&\u02ae\n&\f&\16&\u02b1\13&\5&\u02b3\n&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u02c5\n&\f&\16&\u02c8\13&\5&\u02ca"+
		"\n&\3&\3&\5&\u02ce\n&\3&\3&\3&\3&\3&\5&\u02d5\n&\3&\3&\7&\u02d9\n&\f&"+
		"\16&\u02dc\13&\3&\3&\5&\u02e0\n&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u02ea\n&\f"+
		"&\16&\u02ed\13&\3&\3&\5&\u02f1\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\5&\u0301\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u0326\n&\f&"+
		"\16&\u0329\13&\5&\u032b\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\7&\u033d\n&\f&\16&\u0340\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\5\'\u034c\n\'\3(\6(\u034f\n(\r(\16(\u0350\3(\2\4\26J)\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLN\2\17\4\2"+
		"  \67\67\13\2\22\22\24\24\27\27\35\35##**,,\64\64??\3\2ef\3\2cd\3\2WX"+
		"\4\2\67\67::\4\2ghll\4\2UV]^\4\2[\\_`\3\2ab\4\2TTmw\5\2\t\t\13\16SS\n"+
		"\2\20\20!!--\60\62\65\6599==@@\u03d1\2S\3\2\2\2\4`\3\2\2\2\6g\3\2\2\2"+
		"\bm\3\2\2\2\n\u00c7\3\2\2\2\f\u00cb\3\2\2\2\16\u00d8\3\2\2\2\20\u00dc"+
		"\3\2\2\2\22\u00eb\3\2\2\2\24\u011b\3\2\2\2\26\u0133\3\2\2\2\30\u015d\3"+
		"\2\2\2\32\u015f\3\2\2\2\34\u0172\3\2\2\2\36\u0174\3\2\2\2 \u0178\3\2\2"+
		"\2\"\u017a\3\2\2\2$\u0182\3\2\2\2&\u019b\3\2\2\2(\u019d\3\2\2\2*\u019f"+
		"\3\2\2\2,\u01a1\3\2\2\2.\u01a7\3\2\2\2\60\u01ab\3\2\2\2\62\u01b4\3\2\2"+
		"\2\64\u01c6\3\2\2\2\66\u01cc\3\2\2\28\u01e2\3\2\2\2:\u01e4\3\2\2\2<\u01e7"+
		"\3\2\2\2>\u01ea\3\2\2\2@\u01f0\3\2\2\2B\u01f8\3\2\2\2D\u0209\3\2\2\2F"+
		"\u0215\3\2\2\2H\u021d\3\2\2\2J\u02f0\3\2\2\2L\u034b\3\2\2\2N\u034e\3\2"+
		"\2\2PR\5\4\3\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TY\3\2\2\2US\3\2"+
		"\2\2VX\5\n\6\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z^\3\2\2\2[Y\3\2"+
		"\2\2\\_\5\b\5\2]_\5\6\4\2^\\\3\2\2\2^]\3\2\2\2_\3\3\2\2\2`a\7|\2\2a\5"+
		"\3\2\2\2bf\5\22\n\2cf\5&\24\2df\5\b\5\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2"+
		"fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\7\3\2\2\2ig\3\2\2\2jl\5\24\13\2kj\3\2"+
		"\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2pr\5N(\2qp\3\2\2"+
		"\2qr\3\2\2\2r\u0081\3\2\2\2s~\7\30\2\2tu\7V\2\2uz\7y\2\2vw\7R\2\2wy\7"+
		"y\2\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\177"+
		"\7U\2\2~t\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080\u0082\7+\2\2\u0081"+
		"s\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0085\7y\2\2\u0084"+
		"\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0087\7 "+
		"\2\2\u0087\u0089\5\30\r\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0093\3\2\2\2\u008a\u008b\7\'\2\2\u008b\u0090\5\30\r\2\u008c\u008d\7"+
		"R\2\2\u008d\u008f\5\30\r\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u008a\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\7M\2\2\u0096\u0097\5\16\b\2\u0097\u0098\7N\2\2\u0098\t\3\2\2\2"+
		"\u0099\u009c\7(\2\2\u009a\u009d\7\65\2\2\u009b\u009d\7B\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u00a0\7\u0080\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\u00a6\7y\2\2\u00a2\u00a3\7\u0080\2\2\u00a3\u00a5\7y\2\2"+
		"\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00b0\7\u0080\2"+
		"\2\u00aa\u00ad\7y\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00ae\7y\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\7g\2\2\u00b0"+
		"\u00aa\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00c8\3\2\2\2\u00b2\u00b4\7("+
		"\2\2\u00b3\u00b5\7\65\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00bb\7y\2\2\u00b7\u00b8\7S\2\2\u00b8\u00ba\7y\2"+
		"\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c5\7S\2\2\u00bf"+
		"\u00c2\7y\2\2\u00c0\u00c1\7\4\2\2\u00c1\u00c3\7y\2\2\u00c2\u00c0\3\2\2"+
		"\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c6\7g\2\2\u00c5\u00bf"+
		"\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u0099\3\2\2\2\u00c7"+
		"\u00b2\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7Q\2\2\u00ca\13\3\2\2\2"+
		"\u00cb\u00d0\7y\2\2\u00cc\u00cd\7S\2\2\u00cd\u00cf\7y\2\2\u00ce\u00cc"+
		"\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\r\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d7\5\20\t\2\u00d4\u00d7\5\22\n"+
		"\2\u00d5\u00d7\5\b\5\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\17\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\5N(\2\u00dc\u00db\3\2\2\2"+
		"\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e3\58\35\2\u00df\u00e0"+
		"\7R\2\2\u00e0\u00e2\58\35\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e6\u00e7\7Q\2\2\u00e7\21\3\2\2\2\u00e8\u00ea\5\24\13\2\u00e9\u00e8"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\7\17\2\2\u00ef\u00ee\3"+
		"\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00f3\7\33\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f6\5N"+
		"(\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00fb\3\2\2\2\u00f7"+
		"\u00f8\5\26\f\2\u00f8\u00f9\7y\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00fc\7\5"+
		"\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0109\7K\2\2\u00fe\u00ff\5\26\f\2\u00ff\u0106\7y\2\2\u0100\u0101\7R\2"+
		"\2\u0101\u0102\5\26\f\2\u0102\u0103\7y\2\2\u0103\u0105\3\2\2\2\u0104\u0100"+
		"\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u00fe\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u0115\7L\2\2\u010c\u010d\7<\2\2\u010d\u0112"+
		"\7y\2\2\u010e\u010f\7R\2\2\u010f\u0111\7y\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2"+
		"\2\2\u0114\u0112\3\2\2\2\u0115\u010c\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0119\3\2\2\2\u0117\u011a\5\60\31\2\u0118\u011a\7Q\2\2\u0119\u0117\3"+
		"\2\2\2\u0119\u0118\3\2\2\2\u011a\23\3\2\2\2\u011b\u011c\7z\2\2\u011c\u012e"+
		"\7y\2\2\u011d\u012b\7K\2\2\u011e\u011f\7y\2\2\u011f\u0120\7T\2\2\u0120"+
		"\u0127\5L\'\2\u0121\u0122\7R\2\2\u0122\u0123\7y\2\2\u0123\u0124\7T\2\2"+
		"\u0124\u0126\5L\'\2\u0125\u0121\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012c\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012c\5L\'\2\u012b\u011e\3\2\2\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012f\7L\2\2\u012e\u011d\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\25\3\2\2\2\u0130\u0131\b\f\1\2\u0131\u0134\5\30\r"+
		"\2\u0132\u0134\5 \21\2\u0133\u0130\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u013d"+
		"\3\2\2\2\u0135\u0136\f\3\2\2\u0136\u0137\7O\2\2\u0137\u0139\7P\2\2\u0138"+
		"\u013a\7Y\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u0135\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\27\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7y\2\2"+
		"\u0141\u0143\7\u0080\2\2\u0142\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2"+
		"\2\2\u0147\u014a\7y\2\2\u0148\u0149\7\3\2\2\u0149\u014b\7y\2\2\u014a\u0148"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0157\3\2\2\2\u014c\u014d\7V\2\2\u014d"+
		"\u0152\5\34\17\2\u014e\u014f\7R\2\2\u014f\u0151\5\34\17\2\u0150\u014e"+
		"\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7U\2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u014c\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159"+
		"\u015b\7Y\2\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e\3\2"+
		"\2\2\u015c\u015e\5\32\16\2\u015d\u0144\3\2\2\2\u015d\u015c\3\2\2\2\u015e"+
		"\31\3\2\2\2\u015f\u0160\7i\2\2\u0160\u0161\5\26\f\2\u0161\u016a\7K\2\2"+
		"\u0162\u0167\5\26\f\2\u0163\u0164\7R\2\2\u0164\u0166\5\26\f\2\u0165\u0163"+
		"\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u016b\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016e\7L\2\2\u016d\u016f\7Y\2\2\u016e\u016d"+
		"\3\2\2\2\u016e\u016f\3\2\2\2\u016f\33\3\2\2\2\u0170\u0173\5\26\f\2\u0171"+
		"\u0173\5\36\20\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173\35\3\2"+
		"\2\2\u0174\u0175\7Y\2\2\u0175\u0176\t\2\2\2\u0176\u0177\5\30\r\2\u0177"+
		"\37\3\2\2\2\u0178\u0179\t\3\2\2\u0179!\3\2\2\2\u017a\u017f\58\35\2\u017b"+
		"\u017c\7R\2\2\u017c\u017e\58\35\2\u017d\u017b\3\2\2\2\u017e\u0181\3\2"+
		"\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180#\3\2\2\2\u0181\u017f"+
		"\3\2\2\2\u0182\u0183\7%\2\2\u0183\u0184\7K\2\2\u0184\u0185\5J&\2\u0185"+
		"\u0186\7L\2\2\u0186\u0189\5&\24\2\u0187\u0188\7\36\2\2\u0188\u018a\5&"+
		"\24\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a%\3\2\2\2\u018b\u019c"+
		"\5(\25\2\u018c\u019c\5\60\31\2\u018d\u019c\5\66\34\2\u018e\u019c\5H%\2"+
		"\u018f\u019c\5$\23\2\u0190\u019c\5> \2\u0191\u019c\5@!\2\u0192\u019c\5"+
		"B\"\2\u0193\u019c\5D#\2\u0194\u019c\5:\36\2\u0195\u019c\5<\37\2\u0196"+
		"\u019c\5\64\33\2\u0197\u019c\5\62\32\2\u0198\u019c\5.\30\2\u0199\u019c"+
		"\5*\26\2\u019a\u019c\5,\27\2\u019b\u018b\3\2\2\2\u019b\u018c\3\2\2\2\u019b"+
		"\u018d\3\2\2\2\u019b\u018e\3\2\2\2\u019b\u018f\3\2\2\2\u019b\u0190\3\2"+
		"\2\2\u019b\u0191\3\2\2\2\u019b\u0192\3\2\2\2\u019b\u0193\3\2\2\2\u019b"+
		"\u0194\3\2\2\2\u019b\u0195\3\2\2\2\u019b\u0196\3\2\2\2\u019b\u0197\3\2"+
		"\2\2\u019b\u0198\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c"+
		"\'\3\2\2\2\u019d\u019e\7Q\2\2\u019e)\3\2\2\2\u019f\u01a0\5J&\2\u01a0+"+
		"\3\2\2\2\u01a1\u01a2\7\21\2\2\u01a2\u01a5\5J&\2\u01a3\u01a4\7Z\2\2\u01a4"+
		"\u01a6\5J&\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6-\3\2\2\2\u01a7"+
		"\u01a8\7;\2\2\u01a8\u01a9\5J&\2\u01a9\u01aa\7Q\2\2\u01aa/\3\2\2\2\u01ab"+
		"\u01af\7M\2\2\u01ac\u01ae\5&\24\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1\3\2"+
		"\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b2\u01b3\7N\2\2\u01b3\61\3\2\2\2\u01b4\u01b5\7>\2\2"+
		"\u01b5\u01bf\5\60\31\2\u01b6\u01b7\7\26\2\2\u01b7\u01b8\7K\2\2\u01b8\u01b9"+
		"\5\30\r\2\u01b9\u01ba\7y\2\2\u01ba\u01bb\7L\2\2\u01bb\u01bc\5\60\31\2"+
		"\u01bc\u01be\3\2\2\2\u01bd\u01b6\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd"+
		"\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c4\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2"+
		"\u01c3\7\"\2\2\u01c3\u01c5\5\60\31\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3"+
		"\2\2\2\u01c5\63\3\2\2\2\u01c6\u01c8\7\63\2\2\u01c7\u01c9\5J&\2\u01c8\u01c7"+
		"\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\7Q\2\2\u01cb"+
		"\65\3\2\2\2\u01cc\u01cd\5\"\22\2\u01cd\u01ce\7Q\2\2\u01ce\67\3\2\2\2\u01cf"+
		"\u01d2\7\6\2\2\u01d0\u01d2\7\7\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d0\3\2"+
		"\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d6\7y\2\2\u01d4\u01d5\7\4\2\2\u01d5"+
		"\u01d7\5\26\f\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01da\3"+
		"\2\2\2\u01d8\u01d9\7T\2\2\u01d9\u01db\5J&\2\u01da\u01d8\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01e3\3\2\2\2\u01dc\u01dd\5\26\f\2\u01dd\u01e0\7"+
		"y\2\2\u01de\u01df\7T\2\2\u01df\u01e1\5J&\2\u01e0\u01de\3\2\2\2\u01e0\u01e1"+
		"\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01d1\3\2\2\2\u01e2\u01dc\3\2\2\2\u01e3"+
		"9\3\2\2\2\u01e4\u01e5\7\23\2\2\u01e5\u01e6\7Q\2\2\u01e6;\3\2\2\2\u01e7"+
		"\u01e8\7\32\2\2\u01e8\u01e9\7Q\2\2\u01e9=\3\2\2\2\u01ea\u01eb\7A\2\2\u01eb"+
		"\u01ec\7K\2\2\u01ec\u01ed\5J&\2\u01ed\u01ee\7L\2\2\u01ee\u01ef\5&\24\2"+
		"\u01ef?\3\2\2\2\u01f0\u01f1\7\34\2\2\u01f1\u01f2\5\60\31\2\u01f2\u01f3"+
		"\7A\2\2\u01f3\u01f4\7K\2\2\u01f4\u01f5\5J&\2\u01f5\u01f6\7L\2\2\u01f6"+
		"\u01f7\7Q\2\2\u01f7A\3\2\2\2\u01f8\u01f9\7$\2\2\u01f9\u01fc\7K\2\2\u01fa"+
		"\u01fd\5\"\22\2\u01fb\u01fd\5F$\2\u01fc\u01fa\3\2\2\2\u01fc\u01fb\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\7Q\2\2\u01ff"+
		"\u0201\5J&\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\3\2\2"+
		"\2\u0202\u0204\7Q\2\2\u0203\u0205\5F$\2\u0204\u0203\3\2\2\2\u0204\u0205"+
		"\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\7L\2\2\u0207\u0208\5&\24\2\u0208"+
		"C\3\2\2\2\u0209\u020a\7\b\2\2\u020a\u020b\7K\2\2\u020b\u020c\5J&\2\u020c"+
		"\u020f\7\4\2\2\u020d\u020e\7y\2\2\u020e\u0210\7R\2\2\u020f\u020d\3\2\2"+
		"\2\u020f\u0210\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\7y\2\2\u0212\u0213"+
		"\7L\2\2\u0213\u0214\5&\24\2\u0214E\3\2\2\2\u0215\u021a\5J&\2\u0216\u0217"+
		"\7R\2\2\u0217\u0219\5J&\2\u0218\u0216\3\2\2\2\u0219\u021c\3\2\2\2\u021a"+
		"\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021bG\3\2\2\2\u021c\u021a\3\2\2\2"+
		"\u021d\u021e\5J&\2\u021e\u021f\7Q\2\2\u021fI\3\2\2\2\u0220\u0221\b&\1"+
		"\2\u0221\u0222\t\4\2\2\u0222\u02f1\5J&\26\u0223\u0224\t\5\2\2\u0224\u02f1"+
		"\5J&\25\u0225\u0226\t\6\2\2\u0226\u02f1\5J&\24\u0227\u0228\7K\2\2\u0228"+
		"\u0229\5\26\f\2\u0229\u022a\7L\2\2\u022a\u022b\5J&\23\u022b\u02f1\3\2"+
		"\2\2\u022c\u022d\7K\2\2\u022d\u022e\5J&\2\u022e\u022f\7L\2\2\u022f\u02f1"+
		"\3\2\2\2\u0230\u02f1\t\7\2\2\u0231\u02f1\5L\'\2\u0232\u0234\5\32\16\2"+
		"\u0233\u0232\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u023f"+
		"\7M\2\2\u0236\u023b\7y\2\2\u0237\u0238\7R\2\2\u0238\u023a\7y\2\2\u0239"+
		"\u0237\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2"+
		"\2\2\u023c\u023e\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u0240\7\n\2\2\u023f"+
		"\u0236\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0244\3\2\2\2\u0241\u0243\5&"+
		"\24\2\u0242\u0241\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245\u0247\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0267\7N"+
		"\2\2\u0248\u024a\5\32\16\2\u0249\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a"+
		"\u024b\3\2\2\2\u024b\u0254\7K\2\2\u024c\u0251\7y\2\2\u024d\u024e\7R\2"+
		"\2\u024e\u0250\7y\2\2\u024f\u024d\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f"+
		"\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0255\3\2\2\2\u0253\u0251\3\2\2\2\u0254"+
		"\u024c\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0259\7L"+
		"\2\2\u0257\u0259\7y\2\2\u0258\u0249\3\2\2\2\u0258\u0257\3\2\2\2\u0259"+
		"\u025a\3\2\2\2\u025a\u0264\7\n\2\2\u025b\u025f\7M\2\2\u025c\u025e\5&\24"+
		"\2\u025d\u025c\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u0260"+
		"\3\2\2\2\u0260\u0262\3\2\2\2\u0261\u025f\3\2\2\2\u0262\u0265\7N\2\2\u0263"+
		"\u0265\5J&\2\u0264\u025b\3\2\2\2\u0264\u0263\3\2\2\2\u0265\u0267\3\2\2"+
		"\2\u0266\u0233\3\2\2\2\u0266\u0258\3\2\2\2\u0267\u02f1\3\2\2\2\u0268\u0269"+
		"\7V\2\2\u0269\u026a\7y\2\2\u026a\u026b\7R\2\2\u026b\u026c\7y\2\2\u026c"+
		"\u026e\7U\2\2\u026d\u0268\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0282\3\2"+
		"\2\2\u026f\u0270\7O\2\2\u0270\u0271\5J&\2\u0271\u0272\7Z\2\2\u0272\u027a"+
		"\5J&\2\u0273\u0274\7R\2\2\u0274\u0275\5J&\2\u0275\u0276\7Z\2\2\u0276\u0277"+
		"\5J&\2\u0277\u0279\3\2\2\2\u0278\u0273\3\2\2\2\u0279\u027c\3\2\2\2\u027a"+
		"\u0278\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027d\3\2\2\2\u027c\u027a\3\2"+
		"\2\2\u027d\u027e\7P\2\2\u027e\u0283\3\2\2\2\u027f\u0280\7O\2\2\u0280\u0281"+
		"\7Z\2\2\u0281\u0283\7P\2\2\u0282\u026f\3\2\2\2\u0282\u027f\3\2\2\2\u0283"+
		"\u02f1\3\2\2\2\u0284\u0285\7V\2\2\u0285\u0286\5\26\f\2\u0286\u0287\7U"+
		"\2\2\u0287\u0289\3\2\2\2\u0288\u0284\3\2\2\2\u0288\u0289\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u0293\7O\2\2\u028b\u0290\5J&\2\u028c\u028d\7R\2\2"+
		"\u028d\u028f\5J&\2\u028e\u028c\3\2\2\2\u028f\u0292\3\2\2\2\u0290\u028e"+
		"\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0294\3\2\2\2\u0292\u0290\3\2\2\2\u0293"+
		"\u028b\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u02f1\7P"+
		"\2\2\u0296\u029a\7y\2\2\u0297\u029a\7:\2\2\u0298\u029a\7\67\2\2\u0299"+
		"\u0296\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u0298\3\2\2\2\u029a\u029b\3\2"+
		"\2\2\u029b\u02a4\7K\2\2\u029c\u02a1\5J&\2\u029d\u029e\7R\2\2\u029e\u02a0"+
		"\5J&\2\u029f\u029d\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1"+
		"\u02a2\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u029c\3\2"+
		"\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02f1\7L\2\2\u02a7"+
		"\u02a8\7.\2\2\u02a8\u02a9\5\30\r\2\u02a9\u02b2\7K\2\2\u02aa\u02af\5J&"+
		"\2\u02ab\u02ac\7R\2\2\u02ac\u02ae\5J&\2\u02ad\u02ab\3\2\2\2\u02ae\u02b1"+
		"\3\2\2\2\u02af\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1"+
		"\u02af\3\2\2\2\u02b2\u02aa\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\3\2"+
		"\2\2\u02b4\u02b5\7L\2\2\u02b5\u02f1\3\2\2\2\u02b6\u02b7\7.\2\2\u02b7\u02b8"+
		"\5\26\f\2\u02b8\u02b9\7O\2\2\u02b9\u02ba\5J&\2\u02ba\u02bb\7P\2\2\u02bb"+
		"\u02ce\3\2\2\2\u02bc\u02bd\7.\2\2\u02bd\u02be\5\26\f\2\u02be\u02bf\7O"+
		"\2\2\u02bf\u02c0\7P\2\2\u02c0\u02c9\7M\2\2\u02c1\u02c6\5J&\2\u02c2\u02c3"+
		"\7R\2\2\u02c3\u02c5\5J&\2\u02c4\u02c2\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6"+
		"\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2"+
		"\2\2\u02c9\u02c1\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb"+
		"\u02cc\7N\2\2\u02cc\u02ce\3\2\2\2\u02cd\u02b6\3\2\2\2\u02cd\u02bc\3\2"+
		"\2\2\u02ce\u02f1\3\2\2\2\u02cf\u02f1\7y\2\2\u02d0\u02d1\7x\2\2\u02d1\u02da"+
		"\5J&\2\u02d2\u02d4\7N\2\2\u02d3\u02d5\7\u0083\2\2\u02d4\u02d3\3\2\2\2"+
		"\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\7\u0081\2\2\u02d7"+
		"\u02d9\5J&\2\u02d8\u02d2\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02d8\3\2\2"+
		"\2\u02da\u02db\3\2\2\2\u02db\u02dd\3\2\2\2\u02dc\u02da\3\2\2\2\u02dd\u02df"+
		"\7N\2\2\u02de\u02e0\7\u0083\2\2\u02df\u02de\3\2\2\2\u02df\u02e0\3\2\2"+
		"\2\u02e0\u02e1\3\2\2\2\u02e1\u02e2\7\u0082\2\2\u02e2\u02f1\3\2\2\2\u02e3"+
		"\u02e4\7C\2\2\u02e4\u02e5\7K\2\2\u02e5\u02e6\5J&\2\u02e6\u02e7\7L\2\2"+
		"\u02e7\u02eb\7M\2\2\u02e8\u02ea\5&\24\2\u02e9\u02e8\3\2\2\2\u02ea\u02ed"+
		"\3\2\2\2\u02eb\u02e9\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ee\3\2\2\2\u02ed"+
		"\u02eb\3\2\2\2\u02ee\u02ef\7N\2\2\u02ef\u02f1\3\2\2\2\u02f0\u0220\3\2"+
		"\2\2\u02f0\u0223\3\2\2\2\u02f0\u0225\3\2\2\2\u02f0\u0227\3\2\2\2\u02f0"+
		"\u022c\3\2\2\2\u02f0\u0230\3\2\2\2\u02f0\u0231\3\2\2\2\u02f0\u0266\3\2"+
		"\2\2\u02f0\u026d\3\2\2\2\u02f0\u0288\3\2\2\2\u02f0\u0299\3\2\2\2\u02f0"+
		"\u02a7\3\2\2\2\u02f0\u02cd\3\2\2\2\u02f0\u02cf\3\2\2\2\u02f0\u02d0\3\2"+
		"\2\2\u02f0\u02e3\3\2\2\2\u02f1\u033e\3\2\2\2\u02f2\u02f3\f\22\2\2\u02f3"+
		"\u02f4\t\b\2\2\u02f4\u033d\5J&\23\u02f5\u02f6\f\21\2\2\u02f6\u02f7\t\4"+
		"\2\2\u02f7\u033d\5J&\22\u02f8\u0300\f\20\2\2\u02f9\u02fa\7V\2\2\u02fa"+
		"\u0301\7V\2\2\u02fb\u02fc\7U\2\2\u02fc\u02fd\7U\2\2\u02fd\u0301\7U\2\2"+
		"\u02fe\u02ff\7U\2\2\u02ff\u0301\7U\2\2\u0300\u02f9\3\2\2\2\u0300\u02fb"+
		"\3\2\2\2\u0300\u02fe\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u033d\5J&\21\u0303"+
		"\u0304\f\17\2\2\u0304\u0305\t\t\2\2\u0305\u033d\5J&\20\u0306\u0307\f\r"+
		"\2\2\u0307\u0308\t\n\2\2\u0308\u033d\5J&\16\u0309\u030a\f\f\2\2\u030a"+
		"\u030b\7i\2\2\u030b\u033d\5J&\r\u030c\u030d\f\13\2\2\u030d\u030e\7k\2"+
		"\2\u030e\u033d\5J&\f\u030f\u0310\f\n\2\2\u0310\u0311\7j\2\2\u0311\u033d"+
		"\5J&\13\u0312\u0313\f\t\2\2\u0313\u0314\t\13\2\2\u0314\u033d\5J&\n\u0315"+
		"\u0316\f\b\2\2\u0316\u0317\7Y\2\2\u0317\u0318\5J&\2\u0318\u0319\7Z\2\2"+
		"\u0319\u031a\5J&\t\u031a\u033d\3\2\2\2\u031b\u031c\f\3\2\2\u031c\u031d"+
		"\t\f\2\2\u031d\u033d\5J&\3\u031e\u031f\f\35\2\2\u031f\u0320\t\r\2\2\u0320"+
		"\u0321\7y\2\2\u0321\u032a\7K\2\2\u0322\u0327\5J&\2\u0323\u0324\7R\2\2"+
		"\u0324\u0326\5J&\2\u0325\u0323\3\2\2\2\u0326\u0329\3\2\2\2\u0327\u0325"+
		"\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u032b\3\2\2\2\u0329\u0327\3\2\2\2\u032a"+
		"\u0322\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u033d\7L"+
		"\2\2\u032d\u032e\f\34\2\2\u032e\u032f\t\r\2\2\u032f\u033d\7y\2\2\u0330"+
		"\u0331\f\32\2\2\u0331\u0332\7O\2\2\u0332\u0333\5J&\2\u0333\u0334\7P\2"+
		"\2\u0334\u033d\3\2\2\2\u0335\u0336\f\27\2\2\u0336\u033d\t\5\2\2\u0337"+
		"\u0338\f\16\2\2\u0338\u0339\7)\2\2\u0339\u033d\7y\2\2\u033a\u033b\f\6"+
		"\2\2\u033b\u033d\7S\2\2\u033c\u02f2\3\2\2\2\u033c\u02f5\3\2\2\2\u033c"+
		"\u02f8\3\2\2\2\u033c\u0303\3\2\2\2\u033c\u0306\3\2\2\2\u033c\u0309\3\2"+
		"\2\2\u033c\u030c\3\2\2\2\u033c\u030f\3\2\2\2\u033c\u0312\3\2\2\2\u033c"+
		"\u0315\3\2\2\2\u033c\u031b\3\2\2\2\u033c\u031e\3\2\2\2\u033c\u032d\3\2"+
		"\2\2\u033c\u0330\3\2\2\2\u033c\u0335\3\2\2\2\u033c\u0337\3\2\2\2\u033c"+
		"\u033a\3\2\2\2\u033d\u0340\3\2\2\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2"+
		"\2\2\u033fK\3\2\2\2\u0340\u033e\3\2\2\2\u0341\u034c\7D\2\2\u0342\u034c"+
		"\7E\2\2\u0343\u034c\7G\2\2\u0344\u034c\7H\2\2\u0345\u034c\7I\2\2\u0346"+
		"\u034c\7F\2\2\u0347\u0348\7y\2\2\u0348\u0349\7S\2\2\u0349\u034c\7\30\2"+
		"\2\u034a\u034c\7J\2\2\u034b\u0341\3\2\2\2\u034b\u0342\3\2\2\2\u034b\u0343"+
		"\3\2\2\2\u034b\u0344\3\2\2\2\u034b\u0345\3\2\2\2\u034b\u0346\3\2\2\2\u034b"+
		"\u0347\3\2\2\2\u034b\u034a\3\2\2\2\u034cM\3\2\2\2\u034d\u034f\t\16\2\2"+
		"\u034e\u034d\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u034e\3\2\2\2\u0350\u0351"+
		"\3\2\2\2\u0351O\3\2\2\2pSY^egmqz~\u0081\u0084\u0088\u0090\u0093\u009c"+
		"\u009f\u00a6\u00ad\u00b0\u00b4\u00bb\u00c2\u00c5\u00c7\u00d0\u00d6\u00d8"+
		"\u00dc\u00e3\u00eb\u00ef\u00f2\u00f5\u00fb\u0106\u0109\u0112\u0115\u0119"+
		"\u0127\u012b\u012e\u0133\u0139\u013d\u0144\u014a\u0152\u0157\u015a\u015d"+
		"\u0167\u016a\u016e\u0172\u017f\u0189\u019b\u01a5\u01af\u01bf\u01c4\u01c8"+
		"\u01d1\u01d6\u01da\u01e0\u01e2\u01fc\u0200\u0204\u020f\u021a\u0233\u023b"+
		"\u023f\u0244\u0249\u0251\u0254\u0258\u025f\u0264\u0266\u026d\u027a\u0282"+
		"\u0288\u0290\u0293\u0299\u02a1\u02a4\u02af\u02b2\u02c6\u02c9\u02cd\u02d4"+
		"\u02da\u02df\u02eb\u02f0\u0300\u0327\u032a\u033c\u033e\u034b\u0350";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
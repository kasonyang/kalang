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
		DOUBLE_COLON=1, AS=2, IN=3, CONSTRUCTOR=4, VAR=5, VAL=6, FOREACH=7, ARROW=8, 
		LAMBDA_ARROW=9, DYNAMIC=10, STAR_DOT=11, STAR_DYNAMIC=12, QUESTION_DOT=13, 
		QUESTION_DOTDOT=14, QUESTION_DYNAMIC=15, OVERRIDE=16, ABSTRACT=17, ASSERT=18, 
		BOOLEAN=19, BREAK=20, BYTE=21, CASE=22, CATCH=23, CHAR=24, CLASS=25, CONST=26, 
		CONTINUE=27, DEFAULT=28, DO=29, DOUBLE=30, ELSE=31, ENUM=32, EXTENDS=33, 
		FINAL=34, FINALLY=35, FLOAT=36, FOR=37, IF=38, GOTO=39, IMPLEMENTS=40, 
		IMPORT=41, INSTANCEOF=42, INT=43, INTERFACE=44, LONG=45, NATIVE=46, NEW=47, 
		PACKAGE=48, PRIVATE=49, PROTECTED=50, PUBLIC=51, RETURN=52, SHORT=53, 
		STATIC=54, STRICTFP=55, SUPER=56, SWITCH=57, SYNCHRONIZED=58, THIS=59, 
		THROW=60, THROWS=61, TRANSIENT=62, TRY=63, VOID=64, VOLATILE=65, WHILE=66, 
		MIXIN=67, WITH=68, IntegerLiteral=69, FloatingPointLiteral=70, BooleanLiteral=71, 
		CharacterLiteral=72, StringLiteral=73, MultiLineStringLiteral=74, NullLiteral=75, 
		LPAREN=76, RPAREN=77, LBRACE=78, RBRACE=79, LBRACK=80, RBRACK=81, SEMI=82, 
		COMMA=83, DOT=84, DOTDOT=85, ASSIGN=86, GT=87, LT=88, BANG=89, TILDE=90, 
		QUESTION=91, COLON=92, EQUAL=93, SAME=94, LE=95, GE=96, NOTEQUAL=97, NOTSAME=98, 
		AND=99, OR=100, INC=101, DEC=102, ADD=103, SUB=104, MUL=105, DIV=106, 
		BITAND=107, BITOR=108, CARET=109, MOD=110, ADD_ASSIGN=111, SUB_ASSIGN=112, 
		MUL_ASSIGN=113, DIV_ASSIGN=114, AND_ASSIGN=115, OR_ASSIGN=116, XOR_ASSIGN=117, 
		MOD_ASSIGN=118, LSHIFT_ASSIGN=119, RSHIFT_ASSIGN=120, URSHIFT_ASSIGN=121, 
		InterpolationPreffixString=122, Identifier=123, AT=124, ELLIPSIS=125, 
		COMPILE_OPTION_LINE=126, WS=127, COMMENT=128, LINE_COMMENT=129, PACKAGE_DELIMITER=130, 
		INTERPOLATION_INTERUPT=131, INTERPOLATION_END=132, INTERPOLATION_STRING=133;
	public static final int
		RULE_compilationUnit = 0, RULE_compileOption = 1, RULE_scriptDef = 2, 
		RULE_classDef = 3, RULE_importDecl = 4, RULE_qualifiedName = 5, RULE_classBody = 6, 
		RULE_fieldDecl = 7, RULE_methodDecl = 8, RULE_paramDecl = 9, RULE_annotation = 10, 
		RULE_type = 11, RULE_classType = 12, RULE_lambdaType = 13, RULE_parameterizedElementType = 14, 
		RULE_wildcardType = 15, RULE_primitiveType = 16, RULE_localVarDecl = 17, 
		RULE_ifStat = 18, RULE_stat = 19, RULE_emptyStat = 20, RULE_errorousStat = 21, 
		RULE_assertStmt = 22, RULE_throwStat = 23, RULE_blockStmt = 24, RULE_tryStat = 25, 
		RULE_returnStat = 26, RULE_varDeclStat = 27, RULE_varDecl = 28, RULE_breakStat = 29, 
		RULE_continueStat = 30, RULE_whileStat = 31, RULE_doWhileStat = 32, RULE_forStat = 33, 
		RULE_forEachStat = 34, RULE_expressions = 35, RULE_exprStat = 36, RULE_expression = 37, 
		RULE_literal = 38, RULE_varModifier = 39;
	public static final String[] ruleNames = {
		"compilationUnit", "compileOption", "scriptDef", "classDef", "importDecl", 
		"qualifiedName", "classBody", "fieldDecl", "methodDecl", "paramDecl", 
		"annotation", "type", "classType", "lambdaType", "parameterizedElementType", 
		"wildcardType", "primitiveType", "localVarDecl", "ifStat", "stat", "emptyStat", 
		"errorousStat", "assertStmt", "throwStat", "blockStmt", "tryStat", "returnStat", 
		"varDeclStat", "varDecl", "breakStat", "continueStat", "whileStat", "doWhileStat", 
		"forStat", "forEachStat", "expressions", "exprStat", "expression", "literal", 
		"varModifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'::'", "'as'", "'in'", "'constructor'", "'var'", "'val'", "'foreach'", 
		"'->'", "'=>'", "'->>'", "'*.'", "'*->>'", "'?.'", "'?..'", "'?->>'", 
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
		"'!=='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", 
		"'%='", "'<<='", "'>>='", "'>>>='", null, null, "'@'", "'...'", null, 
		null, null, null, "'\\'", "'${'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOUBLE_COLON", "AS", "IN", "CONSTRUCTOR", "VAR", "VAL", "FOREACH", 
		"ARROW", "LAMBDA_ARROW", "DYNAMIC", "STAR_DOT", "STAR_DYNAMIC", "QUESTION_DOT", 
		"QUESTION_DOTDOT", "QUESTION_DYNAMIC", "OVERRIDE", "ABSTRACT", "ASSERT", 
		"BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", 
		"CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", 
		"FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", 
		"INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", 
		"PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", 
		"SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRY", "VOID", 
		"VOLATILE", "WHILE", "MIXIN", "WITH", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "MultiLineStringLiteral", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
		"SEMI", "COMMA", "DOT", "DOTDOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", 
		"QUESTION", "COLON", "EQUAL", "SAME", "LE", "GE", "NOTEQUAL", "NOTSAME", 
		"AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", 
		"CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
		"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "InterpolationPreffixString", "Identifier", 
		"AT", "ELLIPSIS", "COMPILE_OPTION_LINE", "WS", "COMMENT", "LINE_COMMENT", 
		"PACKAGE_DELIMITER", "INTERPOLATION_INTERUPT", "INTERPOLATION_END", "INTERPOLATION_STRING"
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
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPILE_OPTION_LINE) {
				{
				{
				setState(80);
				compileOption();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(86);
				importDecl();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(92);
				classDef();
				}
				break;
			case 2:
				{
				setState(93);
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
			setState(96);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << SUPER) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRANSIENT) | (1L << TRY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (VOLATILE - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(101);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(98);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(99);
					stat();
					}
					break;
				case 3:
					{
					setState(100);
					classDef();
					}
					break;
				}
				}
				setState(105);
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
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(106);
				annotation();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (ABSTRACT - 17)) | (1L << (FINAL - 17)) | (1L << (NATIVE - 17)) | (1L << (PRIVATE - 17)) | (1L << (PROTECTED - 17)) | (1L << (PUBLIC - 17)) | (1L << (STATIC - 17)) | (1L << (SYNCHRONIZED - 17)) | (1L << (TRANSIENT - 17)) | (1L << (VOLATILE - 17)))) != 0)) {
				{
				setState(112);
				varModifier();
				}
			}

			setState(129);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(115);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(126);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(116);
					match(LT);
					setState(117);
					((ClassDefContext)_localctx).Identifier = match(Identifier);
					((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(118);
						match(COMMA);
						setState(119);
						((ClassDefContext)_localctx).Identifier = match(Identifier);
						((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
						}
						}
						setState(124);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(125);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(128);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(132);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(131);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(136);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(134);
				match(EXTENDS);
				setState(135);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(147);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(138);
				match(IMPLEMENTS);
				setState(139);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(140);
					match(COMMA);
					setState(141);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(149);
			match(LBRACE);
			setState(150);
			classBody();
			setState(151);
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
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(153);
				match(IMPORT);
				setState(156);
				switch (_input.LA(1)) {
				case STATIC:
					{
					setState(154);
					((ImportDeclContext)_localctx).importMode = match(STATIC);
					}
					break;
				case MIXIN:
					{
					setState(155);
					match(MIXIN);
					}
					break;
				case Identifier:
				case PACKAGE_DELIMITER:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(159);
				_la = _input.LA(1);
				if (_la==PACKAGE_DELIMITER) {
					{
					setState(158);
					((ImportDeclContext)_localctx).root = match(PACKAGE_DELIMITER);
					}
				}

				setState(161);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(162);
						match(PACKAGE_DELIMITER);
						setState(163);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(168);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(169);
				((ImportDeclContext)_localctx).delim = match(PACKAGE_DELIMITER);
				setState(176);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(170);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(173);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(171);
						match(AS);
						setState(172);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(175);
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
				setState(178);
				match(IMPORT);
				setState(180);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(179);
					((ImportDeclContext)_localctx).importMode = match(STATIC);
					}
				}

				setState(182);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(183);
						match(DOT);
						setState(184);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(190);
				((ImportDeclContext)_localctx).delim = match(DOT);
				setState(197);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(191);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(194);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(192);
						match(AS);
						setState(193);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(196);
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
			setState(201);
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
			setState(203);
			match(Identifier);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(204);
				match(DOT);
				setState(205);
				match(Identifier);
				}
				}
				setState(210);
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
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << SYNCHRONIZED) | (1L << TRANSIENT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (VOLATILE - 64)) | (1L << (BITAND - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(214);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(211);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(212);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(213);
					classDef();
					}
					break;
				}
				}
				setState(218);
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
			setState(220);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (ABSTRACT - 17)) | (1L << (FINAL - 17)) | (1L << (NATIVE - 17)) | (1L << (PRIVATE - 17)) | (1L << (PROTECTED - 17)) | (1L << (PUBLIC - 17)) | (1L << (STATIC - 17)) | (1L << (SYNCHRONIZED - 17)) | (1L << (TRANSIENT - 17)) | (1L << (VOLATILE - 17)))) != 0)) {
				{
				setState(219);
				varModifier();
				}
			}

			setState(222);
			varDecl();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(223);
				match(COMMA);
				setState(224);
				varDecl();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
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
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(232);
				annotation();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(238);
				match(OVERRIDE);
				}
			}

			setState(242);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(241);
				match(DEFAULT);
				}
			}

			setState(245);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (ABSTRACT - 17)) | (1L << (FINAL - 17)) | (1L << (NATIVE - 17)) | (1L << (PRIVATE - 17)) | (1L << (PROTECTED - 17)) | (1L << (PUBLIC - 17)) | (1L << (STATIC - 17)) | (1L << (SYNCHRONIZED - 17)) | (1L << (TRANSIENT - 17)) | (1L << (VOLATILE - 17)))) != 0)) {
				{
				setState(244);
				varModifier();
				}
			}

			setState(251);
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
				setState(247);
				((MethodDeclContext)_localctx).returnType = type(0);
				setState(248);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case CONSTRUCTOR:
				{
				{
				setState(250);
				((MethodDeclContext)_localctx).prefix = match(CONSTRUCTOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(253);
			match(LPAREN);
			setState(262);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (BITAND - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(254);
				((MethodDeclContext)_localctx).paramDecl = paramDecl();
				((MethodDeclContext)_localctx).params.add(((MethodDeclContext)_localctx).paramDecl);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(255);
					match(COMMA);
					setState(256);
					((MethodDeclContext)_localctx).paramDecl = paramDecl();
					((MethodDeclContext)_localctx).params.add(((MethodDeclContext)_localctx).paramDecl);
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(264);
			match(RPAREN);
			setState(274);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(265);
				match(THROWS);
				setState(266);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(267);
					match(COMMA);
					setState(268);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(278);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(276);
				blockStmt();
				}
				break;
			case SEMI:
				{
				setState(277);
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
		public Token paramId;
		public ExpressionContext paramDefVal;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
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
			setState(280);
			((ParamDeclContext)_localctx).paramType = type(0);
			setState(281);
			((ParamDeclContext)_localctx).paramId = match(Identifier);
			setState(284);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(282);
				match(ASSIGN);
				setState(283);
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
		enterRule(_localctx, 20, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(AT);
			setState(287);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(305);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(288);
				match(LPAREN);
				setState(302);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					{
					setState(289);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(290);
					match(ASSIGN);
					setState(291);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(292);
						match(COMMA);
						setState(293);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(294);
						match(ASSIGN);
						setState(295);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(300);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(301);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(304);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			switch (_input.LA(1)) {
			case BITAND:
			case Identifier:
				{
				setState(308);
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
				setState(309);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(312);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(313);
					match(LBRACK);
					setState(314);
					match(RBRACK);
					setState(316);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						setState(315);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 24, RULE_classType);
		int _la;
		try {
			int _alt;
			setState(348);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(323);
						((ClassTypeContext)_localctx).Identifier = match(Identifier);
						((ClassTypeContext)_localctx).paths.add(((ClassTypeContext)_localctx).Identifier);
						setState(324);
						match(PACKAGE_DELIMITER);
						}
						} 
					}
					setState(329);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				setState(330);
				((ClassTypeContext)_localctx).rawClass = match(Identifier);
				setState(342);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(331);
					match(LT);
					setState(332);
					((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
					((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(333);
						match(COMMA);
						setState(334);
						((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
						((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
						}
						}
						setState(339);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(340);
					match(GT);
					}
					break;
				}
				setState(345);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(344);
					((ClassTypeContext)_localctx).nullable = match(QUESTION);
					}
					break;
				}
				}
				break;
			case BITAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
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
		enterRule(_localctx, 26, RULE_lambdaType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(BITAND);
			setState(351);
			((LambdaTypeContext)_localctx).returnType = type(0);
			setState(352);
			match(LPAREN);
			setState(361);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (BITAND - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(353);
				((LambdaTypeContext)_localctx).type = type(0);
				((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(354);
					match(COMMA);
					setState(355);
					((LambdaTypeContext)_localctx).type = type(0);
					((LambdaTypeContext)_localctx).paramsTypes.add(((LambdaTypeContext)_localctx).type);
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(363);
			match(RPAREN);
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(364);
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
			setState(369);
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
				setState(367);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
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
		enterRule(_localctx, 30, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(QUESTION);
			setState(372);
			((WildcardTypeContext)_localctx).boundKind = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
				((WildcardTypeContext)_localctx).boundKind = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(373);
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
			setState(375);
			_la = _input.LA(1);
			if ( !(((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (BOOLEAN - 19)) | (1L << (BYTE - 19)) | (1L << (CHAR - 19)) | (1L << (DOUBLE - 19)) | (1L << (FLOAT - 19)) | (1L << (INT - 19)) | (1L << (LONG - 19)) | (1L << (SHORT - 19)) | (1L << (VOID - 19)))) != 0)) ) {
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
		enterRule(_localctx, 34, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			varDecl();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(378);
				match(COMMA);
				setState(379);
				varDecl();
				}
				}
				setState(384);
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
		enterRule(_localctx, 36, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(IF);
			setState(386);
			match(LPAREN);
			setState(387);
			expression(0);
			setState(388);
			match(RPAREN);
			setState(389);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(392);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(390);
				match(ELSE);
				setState(391);
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
		enterRule(_localctx, 38, RULE_stat);
		try {
			setState(410);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				emptyStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				blockStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(396);
				varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(397);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(398);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(399);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(400);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(401);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(402);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(403);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(404);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(405);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(406);
				tryStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(407);
				throwStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(408);
				errorousStat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(409);
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
		enterRule(_localctx, 40, RULE_emptyStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
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
		enterRule(_localctx, 42, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
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
		enterRule(_localctx, 44, RULE_assertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(ASSERT);
			setState(417);
			((AssertStmtContext)_localctx).testCondition = expression(0);
			setState(420);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(418);
				match(COLON);
				setState(419);
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
		enterRule(_localctx, 46, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(THROW);
			setState(423);
			expression(0);
			setState(424);
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
		enterRule(_localctx, 48, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(LBRACE);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(427);
				stat();
				}
				}
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(433);
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
		public List<BlockStmtContext> blockStmt() {
			return getRuleContexts(BlockStmtContext.class);
		}
		public BlockStmtContext blockStmt(int i) {
			return getRuleContext(BlockStmtContext.class,i);
		}
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
		enterRule(_localctx, 50, RULE_tryStat);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(TRY);
			setState(450);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(436);
				match(LPAREN);
				setState(437);
				((TryStatContext)_localctx).varDecl = varDecl();
				((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(438);
						match(SEMI);
						setState(439);
						((TryStatContext)_localctx).varDecl = varDecl();
						((TryStatContext)_localctx).resources.add(((TryStatContext)_localctx).varDecl);
						}
						} 
					}
					setState(444);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				setState(446);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(445);
					match(SEMI);
					}
				}

				setState(448);
				match(RPAREN);
				}
			}

			setState(452);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(453);
				match(CATCH);
				setState(454);
				match(LPAREN);
				setState(455);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(456);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(457);
				match(RPAREN);
				setState(458);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(467);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(465);
				match(FINALLY);
				setState(466);
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
		enterRule(_localctx, 52, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(RETURN);
			setState(471);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(470);
				expression(0);
				}
			}

			setState(473);
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
		enterRule(_localctx, 54, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			localVarDecl();
			setState(476);
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
		enterRule(_localctx, 56, RULE_varDecl);
		int _la;
		try {
			setState(497);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(480);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(478);
					((VarDeclContext)_localctx).varToken = match(VAR);
					}
					break;
				case VAL:
					{
					setState(479);
					((VarDeclContext)_localctx).valToken = match(VAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(482);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(485);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(483);
					match(AS);
					setState(484);
					type(0);
					}
				}

				setState(489);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(487);
					match(ASSIGN);
					setState(488);
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
				setState(491);
				((VarDeclContext)_localctx).varType = type(0);
				setState(492);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(495);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(493);
					match(ASSIGN);
					setState(494);
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
		enterRule(_localctx, 58, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(BREAK);
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
		enterRule(_localctx, 60, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(CONTINUE);
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
		enterRule(_localctx, 62, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(WHILE);
			setState(506);
			match(LPAREN);
			setState(507);
			expression(0);
			setState(508);
			match(RPAREN);
			setState(509);
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
		enterRule(_localctx, 64, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(DO);
			setState(512);
			blockStmt();
			setState(513);
			match(WHILE);
			setState(514);
			match(LPAREN);
			setState(515);
			expression(0);
			setState(516);
			match(RPAREN);
			setState(517);
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
		enterRule(_localctx, 66, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			match(FOR);
			setState(520);
			match(LPAREN);
			setState(523);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(521);
				localVarDecl();
				}
				break;
			case 2:
				{
				setState(522);
				((ForStatContext)_localctx).initExpressions = expressions();
				}
				break;
			}
			setState(525);
			match(SEMI);
			setState(527);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(526);
				((ForStatContext)_localctx).condition = expression(0);
				}
			}

			setState(529);
			match(SEMI);
			setState(531);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(530);
				((ForStatContext)_localctx).updateExpressions = expressions();
				}
			}

			setState(533);
			match(RPAREN);
			setState(534);
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
		public TerminalNode IN() { return getToken(KalangParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(KalangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KalangParser.Identifier, i);
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
		enterRule(_localctx, 68, RULE_forEachStat);
		int _la;
		try {
			setState(560);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				match(FOR);
				setState(537);
				match(LPAREN);
				setState(538);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(541);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(539);
					match(COMMA);
					setState(540);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					}
				}

				setState(543);
				match(IN);
				setState(544);
				expression(0);
				setState(545);
				match(RPAREN);
				setState(546);
				stat();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(548);
				match(FOREACH);
				setState(549);
				match(LPAREN);
				setState(550);
				expression(0);
				setState(551);
				match(AS);
				setState(554);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(552);
					((ForEachStatContext)_localctx).indexId = match(Identifier);
					setState(553);
					match(COMMA);
					}
					break;
				}
				setState(556);
				((ForEachStatContext)_localctx).valueId = match(Identifier);
				setState(557);
				match(RPAREN);
				setState(558);
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
		enterRule(_localctx, 70, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			expression(0);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(563);
				match(COMMA);
				setState(564);
				expression(0);
				}
				}
				setState(569);
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
		enterRule(_localctx, 72, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			expression(0);
			setState(571);
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
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
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
		public ExpressionContext expression;
		public List<ExpressionContext> sizes = new ArrayList<ExpressionContext>();
		public Token s80;
		public List<Token> suffix = new ArrayList<Token>();
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(KalangParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(KalangParser.StringLiteral, 0); }
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
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(574);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(575);
				expression(20);
				}
				break;
			case 2:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(576);
				((PreIncExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(577);
				expression(19);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(578);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(579);
				expression(18);
				}
				break;
			case 4:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(580);
				match(LPAREN);
				setState(581);
				type(0);
				setState(582);
				match(RPAREN);
				setState(583);
				expression(17);
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(585);
				match(LPAREN);
				setState(586);
				expression(0);
				setState(587);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(589);
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
				setState(590);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(640);
				switch (_input.LA(1)) {
				case LBRACE:
				case BITAND:
					{
					{
					setState(592);
					_la = _input.LA(1);
					if (_la==BITAND) {
						{
						setState(591);
						lambdaType();
						}
					}

					setState(594);
					match(LBRACE);
					setState(604);
					switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
					case 1:
						{
						setState(595);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						setState(600);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(596);
							match(COMMA);
							setState(597);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							}
							}
							setState(602);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(603);
						match(LAMBDA_ARROW);
						}
						break;
					}
					setState(609);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						{
						setState(606);
						stat();
						}
						}
						setState(611);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(612);
					match(RBRACE);
					}
					}
					break;
				case LPAREN:
				case Identifier:
					{
					{
					setState(626);
					switch (_input.LA(1)) {
					case LPAREN:
						{
						{
						setState(613);
						match(LPAREN);
						setState(622);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(614);
							((LambdaExprContext)_localctx).Identifier = match(Identifier);
							((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
							setState(619);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(615);
								match(COMMA);
								setState(616);
								((LambdaExprContext)_localctx).Identifier = match(Identifier);
								((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
								}
								}
								setState(621);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(624);
						match(RPAREN);
						}
						}
						break;
					case Identifier:
						{
						setState(625);
						((LambdaExprContext)_localctx).Identifier = match(Identifier);
						((LambdaExprContext)_localctx).lambdaParams.add(((LambdaExprContext)_localctx).Identifier);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(628);
					match(LAMBDA_ARROW);
					setState(638);
					switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
					case 1:
						{
						{
						setState(629);
						match(LBRACE);
						setState(633);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
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
					case 2:
						{
						setState(637);
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
			case 9:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(647);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(642);
					match(LT);
					setState(643);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(644);
					match(COMMA);
					setState(645);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(646);
					match(GT);
					}
				}

				setState(668);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(649);
					match(LBRACK);
					setState(650);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
					setState(651);
					match(COLON);
					setState(652);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(653);
						match(COMMA);
						setState(654);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).expression);
						setState(655);
						match(COLON);
						setState(656);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
						}
						}
						setState(662);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(663);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(665);
					match(LBRACK);
					setState(666);
					match(COLON);
					setState(667);
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
				setState(674);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(670);
					match(LT);
					setState(671);
					type(0);
					setState(672);
					match(GT);
					}
				}

				setState(676);
				match(LBRACK);
				setState(685);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(677);
					expression(0);
					setState(682);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(678);
						match(COMMA);
						setState(679);
						expression(0);
						}
						}
						setState(684);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(687);
				match(RBRACK);
				}
				break;
			case 11:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(691);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(688);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(689);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(690);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(693);
				match(LPAREN);
				setState(702);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(694);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(699);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(695);
						match(COMMA);
						setState(696);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(701);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(704);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(705);
				match(NEW);
				setState(706);
				classType();
				setState(707);
				match(LPAREN);
				setState(716);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(708);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(713);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(709);
						match(COMMA);
						setState(710);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(715);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(718);
				match(RPAREN);
				}
				break;
			case 13:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(754);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(720);
					match(NEW);
					setState(721);
					type(0);
					setState(726); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(722);
							match(LBRACK);
							setState(723);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).sizes.add(((NewArrayExprContext)_localctx).expression);
							setState(724);
							match(RBRACK);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(728); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(734);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(730);
							((NewArrayExprContext)_localctx).s80 = match(LBRACK);
							((NewArrayExprContext)_localctx).suffix.add(((NewArrayExprContext)_localctx).s80);
							setState(731);
							match(RBRACK);
							}
							} 
						}
						setState(736);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
					}
					}
					break;
				case 2:
					{
					setState(737);
					match(NEW);
					setState(738);
					type(0);
					setState(739);
					match(LBRACK);
					setState(740);
					match(RBRACK);
					setState(741);
					match(LBRACE);
					setState(750);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						setState(742);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(747);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(743);
							match(COMMA);
							setState(744);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(749);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(752);
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
				setState(756);
				match(Identifier);
				}
				break;
			case 15:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(757);
				match(InterpolationPreffixString);
				setState(758);
				expression(0);
				setState(767);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(759);
						match(RBRACE);
						setState(761);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(760);
							match(INTERPOLATION_STRING);
							}
						}

						setState(763);
						match(INTERPOLATION_INTERUPT);
						setState(764);
						expression(0);
						}
						} 
					}
					setState(769);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
				}
				setState(770);
				match(RBRACE);
				setState(772);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(771);
					match(INTERPOLATION_STRING);
					}
				}

				setState(774);
				match(INTERPOLATION_END);
				}
				break;
			case 16:
				{
				_localctx = new WithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(776);
				match(WITH);
				setState(777);
				match(LPAREN);
				setState(778);
				expression(0);
				setState(779);
				match(RPAREN);
				setState(780);
				match(LBRACE);
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					{
					setState(781);
					stat();
					}
					}
					setState(786);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(787);
				match(RBRACE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(867);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(865);
					switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(791);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(792);
						_la = _input.LA(1);
						if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (MUL - 105)) | (1L << (DIV - 105)) | (1L << (MOD - 105)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(793);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(794);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(795);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(796);
						expression(16);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(797);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(805);
						switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
						case 1:
							{
							setState(798);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(799);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(800);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(801);
							match(GT);
							setState(802);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(803);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(804);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(807);
						expression(15);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(808);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(809);
						_la = _input.LA(1);
						if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (GT - 87)) | (1L << (LT - 87)) | (1L << (LE - 87)) | (1L << (GE - 87)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(810);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(811);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(812);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (EQUAL - 93)) | (1L << (SAME - 93)) | (1L << (NOTEQUAL - 93)) | (1L << (NOTSAME - 93)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(813);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(814);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(815);
						match(BITAND);
						setState(816);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(817);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(818);
						match(CARET);
						setState(819);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(820);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(821);
						match(BITOR);
						setState(822);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(823);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(824);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(825);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(826);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(827);
						match(QUESTION);
						setState(828);
						expression(0);
						setState(829);
						match(COLON);
						setState(830);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(832);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(833);
						_la = _input.LA(1);
						if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ASSIGN - 86)) | (1L << (ADD_ASSIGN - 86)) | (1L << (SUB_ASSIGN - 86)) | (1L << (MUL_ASSIGN - 86)) | (1L << (DIV_ASSIGN - 86)) | (1L << (AND_ASSIGN - 86)) | (1L << (OR_ASSIGN - 86)) | (1L << (XOR_ASSIGN - 86)) | (1L << (MOD_ASSIGN - 86)) | (1L << (LSHIFT_ASSIGN - 86)) | (1L << (RSHIFT_ASSIGN - 86)) | (1L << (URSHIFT_ASSIGN - 86)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(834);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(835);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(836);
						((InvokeExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << STAR_DOT) | (1L << STAR_DYNAMIC) | (1L << QUESTION_DOT) | (1L << QUESTION_DOTDOT) | (1L << QUESTION_DYNAMIC))) != 0) || _la==DOT || _la==DOTDOT) ) {
							((InvokeExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(837);
						_la = _input.LA(1);
						if ( !(_la==StringLiteral || _la==Identifier) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(838);
						match(LPAREN);
						setState(847);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOID - 64)) | (1L << (WITH - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (BITAND - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(839);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(844);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(840);
								match(COMMA);
								setState(841);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(846);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(849);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(850);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(851);
						((GetFieldExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << STAR_DOT) | (1L << STAR_DYNAMIC) | (1L << QUESTION_DOT) | (1L << QUESTION_DYNAMIC))) != 0) || _la==DOT) ) {
							((GetFieldExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(852);
						_la = _input.LA(1);
						if ( !(_la==StringLiteral || _la==Identifier) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					case 14:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(853);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(854);
						match(LBRACK);
						setState(855);
						expression(0);
						setState(856);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(858);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(859);
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
						setState(860);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(861);
						match(INSTANCEOF);
						setState(862);
						match(Identifier);
						}
						break;
					case 17:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(863);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(864);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(869);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
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
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
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
		enterRule(_localctx, 76, RULE_literal);
		int _la;
		try {
			setState(887);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(870);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(871);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(872);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(873);
				match(StringLiteral);
				}
				break;
			case MultiLineStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(874);
				match(MultiLineStringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(875);
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
				setState(878);
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
					setState(876);
					primitiveType();
					}
					break;
				case Identifier:
					{
					setState(877);
					match(Identifier);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(882);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(880);
					((LiteralContext)_localctx).arrayPrefix = match(LBRACK);
					setState(881);
					match(RBRACK);
					}
				}

				setState(884);
				match(DOT);
				setState(885);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 8);
				{
				setState(886);
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
		enterRule(_localctx, 78, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(889);
				_la = _input.LA(1);
				if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (ABSTRACT - 17)) | (1L << (FINAL - 17)) | (1L << (NATIVE - 17)) | (1L << (PRIVATE - 17)) | (1L << (PROTECTED - 17)) | (1L << (PUBLIC - 17)) | (1L << (STATIC - 17)) | (1L << (SYNCHRONIZED - 17)) | (1L << (TRANSIENT - 17)) | (1L << (VOLATILE - 17)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(892); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (ABSTRACT - 17)) | (1L << (FINAL - 17)) | (1L << (NATIVE - 17)) | (1L << (PRIVATE - 17)) | (1L << (PROTECTED - 17)) | (1L << (PUBLIC - 17)) | (1L << (STATIC - 17)) | (1L << (SYNCHRONIZED - 17)) | (1L << (TRANSIENT - 17)) | (1L << (VOLATILE - 17)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		case 37:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0087\u0381\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\7\2T\n\2\f"+
		"\2\16\2W\13\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\5\2a\n\2\3\3\3\3\3\4"+
		"\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\5\7\5n\n\5\f\5\16\5q\13\5\3\5\5\5t"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\7\5{\n\5\f\5\16\5~\13\5\3\5\5\5\u0081\n\5\3\5"+
		"\5\5\u0084\n\5\3\5\5\5\u0087\n\5\3\5\3\5\5\5\u008b\n\5\3\5\3\5\3\5\3\5"+
		"\7\5\u0091\n\5\f\5\16\5\u0094\13\5\5\5\u0096\n\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\5\6\u009f\n\6\3\6\5\6\u00a2\n\6\3\6\3\6\3\6\7\6\u00a7\n\6\f\6\16"+
		"\6\u00aa\13\6\3\6\3\6\3\6\3\6\5\6\u00b0\n\6\3\6\5\6\u00b3\n\6\3\6\3\6"+
		"\5\6\u00b7\n\6\3\6\3\6\3\6\7\6\u00bc\n\6\f\6\16\6\u00bf\13\6\3\6\3\6\3"+
		"\6\3\6\5\6\u00c5\n\6\3\6\5\6\u00c8\n\6\5\6\u00ca\n\6\3\6\3\6\3\7\3\7\3"+
		"\7\7\7\u00d1\n\7\f\7\16\7\u00d4\13\7\3\b\3\b\3\b\7\b\u00d9\n\b\f\b\16"+
		"\b\u00dc\13\b\3\t\5\t\u00df\n\t\3\t\3\t\3\t\7\t\u00e4\n\t\f\t\16\t\u00e7"+
		"\13\t\3\t\3\t\3\n\7\n\u00ec\n\n\f\n\16\n\u00ef\13\n\3\n\5\n\u00f2\n\n"+
		"\3\n\5\n\u00f5\n\n\3\n\5\n\u00f8\n\n\3\n\3\n\3\n\3\n\5\n\u00fe\n\n\3\n"+
		"\3\n\3\n\3\n\7\n\u0104\n\n\f\n\16\n\u0107\13\n\5\n\u0109\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\7\n\u0110\n\n\f\n\16\n\u0113\13\n\5\n\u0115\n\n\3\n\3\n\5\n"+
		"\u0119\n\n\3\13\3\13\3\13\3\13\5\13\u011f\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\7\f\u012b\n\f\f\f\16\f\u012e\13\f\3\f\5\f\u0131\n\f\3"+
		"\f\5\f\u0134\n\f\3\r\3\r\3\r\5\r\u0139\n\r\3\r\3\r\3\r\3\r\5\r\u013f\n"+
		"\r\7\r\u0141\n\r\f\r\16\r\u0144\13\r\3\16\3\16\7\16\u0148\n\16\f\16\16"+
		"\16\u014b\13\16\3\16\3\16\3\16\3\16\3\16\7\16\u0152\n\16\f\16\16\16\u0155"+
		"\13\16\3\16\3\16\5\16\u0159\n\16\3\16\5\16\u015c\n\16\3\16\5\16\u015f"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0167\n\17\f\17\16\17\u016a\13"+
		"\17\5\17\u016c\n\17\3\17\3\17\5\17\u0170\n\17\3\20\3\20\5\20\u0174\n\20"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\7\23\u017f\n\23\f\23\16"+
		"\23\u0182\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u018b\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u019d\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u01a7"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\7\32\u01af\n\32\f\32\16\32\u01b2\13"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u01bb\n\33\f\33\16\33\u01be"+
		"\13\33\3\33\5\33\u01c1\n\33\3\33\3\33\5\33\u01c5\n\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\7\33\u01cf\n\33\f\33\16\33\u01d2\13\33\3\33\3"+
		"\33\5\33\u01d6\n\33\3\34\3\34\5\34\u01da\n\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\5\36\u01e3\n\36\3\36\3\36\3\36\5\36\u01e8\n\36\3\36\3\36\5"+
		"\36\u01ec\n\36\3\36\3\36\3\36\3\36\5\36\u01f2\n\36\5\36\u01f4\n\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\5#\u020e\n#\3#\3#\5#\u0212\n#\3#\3#\5#\u0216\n#\3#\3#\3#"+
		"\3$\3$\3$\3$\3$\5$\u0220\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u022d"+
		"\n$\3$\3$\3$\3$\5$\u0233\n$\3%\3%\3%\7%\u0238\n%\f%\16%\u023b\13%\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\5\'\u0253\n\'\3\'\3\'\3\'\3\'\7\'\u0259\n\'\f\'\16\'\u025c"+
		"\13\'\3\'\5\'\u025f\n\'\3\'\7\'\u0262\n\'\f\'\16\'\u0265\13\'\3\'\3\'"+
		"\3\'\3\'\3\'\7\'\u026c\n\'\f\'\16\'\u026f\13\'\5\'\u0271\n\'\3\'\3\'\5"+
		"\'\u0275\n\'\3\'\3\'\3\'\7\'\u027a\n\'\f\'\16\'\u027d\13\'\3\'\3\'\5\'"+
		"\u0281\n\'\5\'\u0283\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u028a\n\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0295\n\'\f\'\16\'\u0298\13\'\3\'\3\'\3\'"+
		"\3\'\3\'\5\'\u029f\n\'\3\'\3\'\3\'\3\'\5\'\u02a5\n\'\3\'\3\'\3\'\3\'\7"+
		"\'\u02ab\n\'\f\'\16\'\u02ae\13\'\5\'\u02b0\n\'\3\'\3\'\3\'\3\'\5\'\u02b6"+
		"\n\'\3\'\3\'\3\'\3\'\7\'\u02bc\n\'\f\'\16\'\u02bf\13\'\5\'\u02c1\n\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u02ca\n\'\f\'\16\'\u02cd\13\'\5\'\u02cf"+
		"\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\6\'\u02d9\n\'\r\'\16\'\u02da\3\'"+
		"\3\'\7\'\u02df\n\'\f\'\16\'\u02e2\13\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\7\'\u02ec\n\'\f\'\16\'\u02ef\13\'\5\'\u02f1\n\'\3\'\3\'\5\'\u02f5\n\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u02fc\n\'\3\'\3\'\7\'\u0300\n\'\f\'\16\'\u0303"+
		"\13\'\3\'\3\'\5\'\u0307\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0311"+
		"\n\'\f\'\16\'\u0314\13\'\3\'\3\'\5\'\u0318\n\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0328\n\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u034d\n\'\f\'\16\'"+
		"\u0350\13\'\5\'\u0352\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\7\'\u0364\n\'\f\'\16\'\u0367\13\'\3(\3(\3(\3(\3("+
		"\3(\3(\3(\5(\u0371\n(\3(\3(\5(\u0375\n(\3(\3(\3(\5(\u037a\n(\3)\6)\u037d"+
		"\n)\r)\16)\u037e\3)\2\4\30L*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNP\2\21\4\2##::\13\2\25\25\27\27\32\32  "+
		"&&--//\67\67BB\3\2ij\3\2gh\3\2[\\\4\2::==\4\2klpp\4\2YZab\4\2_`cd\3\2"+
		"ef\4\2XXq{\4\2\f\21VW\4\2KK}}\5\2\f\17\21\21VV\n\2\23\23$$\60\60\63\65"+
		"88<<@@CC\u0406\2U\3\2\2\2\4b\3\2\2\2\6i\3\2\2\2\bo\3\2\2\2\n\u00c9\3\2"+
		"\2\2\f\u00cd\3\2\2\2\16\u00da\3\2\2\2\20\u00de\3\2\2\2\22\u00ed\3\2\2"+
		"\2\24\u011a\3\2\2\2\26\u0120\3\2\2\2\30\u0138\3\2\2\2\32\u015e\3\2\2\2"+
		"\34\u0160\3\2\2\2\36\u0173\3\2\2\2 \u0175\3\2\2\2\"\u0179\3\2\2\2$\u017b"+
		"\3\2\2\2&\u0183\3\2\2\2(\u019c\3\2\2\2*\u019e\3\2\2\2,\u01a0\3\2\2\2."+
		"\u01a2\3\2\2\2\60\u01a8\3\2\2\2\62\u01ac\3\2\2\2\64\u01b5\3\2\2\2\66\u01d7"+
		"\3\2\2\28\u01dd\3\2\2\2:\u01f3\3\2\2\2<\u01f5\3\2\2\2>\u01f8\3\2\2\2@"+
		"\u01fb\3\2\2\2B\u0201\3\2\2\2D\u0209\3\2\2\2F\u0232\3\2\2\2H\u0234\3\2"+
		"\2\2J\u023c\3\2\2\2L\u0317\3\2\2\2N\u0379\3\2\2\2P\u037c\3\2\2\2RT\5\4"+
		"\3\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V[\3\2\2\2WU\3\2\2\2XZ\5\n"+
		"\6\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\`\3\2\2\2][\3\2\2\2^a\5"+
		"\b\5\2_a\5\6\4\2`^\3\2\2\2`_\3\2\2\2a\3\3\2\2\2bc\7\u0080\2\2c\5\3\2\2"+
		"\2dh\5\22\n\2eh\5(\25\2fh\5\b\5\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2hk\3\2"+
		"\2\2ig\3\2\2\2ij\3\2\2\2j\7\3\2\2\2ki\3\2\2\2ln\5\26\f\2ml\3\2\2\2nq\3"+
		"\2\2\2om\3\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rt\5P)\2sr\3\2\2\2st\3\2"+
		"\2\2t\u0083\3\2\2\2u\u0080\7\33\2\2vw\7Z\2\2w|\7}\2\2xy\7U\2\2y{\7}\2"+
		"\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177"+
		"\u0081\7Y\2\2\u0080v\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0084\7.\2\2\u0083u\3\2\2\2\u0083\u0082\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0087\7}\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2"+
		"\2\2\u0088\u0089\7#\2\2\u0089\u008b\5\32\16\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0095\3\2\2\2\u008c\u008d\7*\2\2\u008d\u0092\5\32"+
		"\16\2\u008e\u008f\7U\2\2\u008f\u0091\5\32\16\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\7P\2\2\u0098\u0099\5\16\b\2\u0099\u009a\7Q"+
		"\2\2\u009a\t\3\2\2\2\u009b\u009e\7+\2\2\u009c\u009f\78\2\2\u009d\u009f"+
		"\7E\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u00a2\7\u0084\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a8\7}\2\2\u00a4\u00a5\7\u0084\2"+
		"\2\u00a5\u00a7\7}\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00b2\7\u0084\2\2\u00ac\u00af\7}\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0"+
		"\7}\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00b3\7k\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00ca\3\2"+
		"\2\2\u00b4\u00b6\7+\2\2\u00b5\u00b7\78\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bd\7}\2\2\u00b9\u00ba\7V\2\2\u00ba"+
		"\u00bc\7}\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c7\7V\2\2\u00c1\u00c4\7}\2\2\u00c2\u00c3\7\4\2\2\u00c3\u00c5\7}\2"+
		"\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c8"+
		"\7k\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u009b\3\2\2\2\u00c9\u00b4\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7T"+
		"\2\2\u00cc\13\3\2\2\2\u00cd\u00d2\7}\2\2\u00ce\u00cf\7V\2\2\u00cf\u00d1"+
		"\7}\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\r\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d9\5\20\t"+
		"\2\u00d6\u00d9\5\22\n\2\u00d7\u00d9\5\b\5\2\u00d8\u00d5\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\17\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df"+
		"\5P)\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e5\5:\36\2\u00e1\u00e2\7U\2\2\u00e2\u00e4\5:\36\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7T\2\2\u00e9\21\3\2\2\2"+
		"\u00ea\u00ec\5\26\f\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0"+
		"\u00f2\7\22\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3"+
		"\2\2\2\u00f3\u00f5\7\36\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00f8\5P)\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2"+
		"\2\u00f8\u00fd\3\2\2\2\u00f9\u00fa\5\30\r\2\u00fa\u00fb\7}\2\2\u00fb\u00fe"+
		"\3\2\2\2\u00fc\u00fe\7\6\2\2\u00fd\u00f9\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0108\7N\2\2\u0100\u0105\5\24\13\2\u0101\u0102\7"+
		"U\2\2\u0102\u0104\5\24\13\2\u0103\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0108\u0100\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u0114\7O\2\2\u010b\u010c\7?\2\2\u010c\u0111\7}\2\2\u010d\u010e\7U\2\2"+
		"\u010e\u0110\7}\2\2\u010f\u010d\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u010b\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0119\5\62"+
		"\32\2\u0117\u0119\7T\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119"+
		"\23\3\2\2\2\u011a\u011b\5\30\r\2\u011b\u011e\7}\2\2\u011c\u011d\7X\2\2"+
		"\u011d\u011f\5L\'\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\25\3"+
		"\2\2\2\u0120\u0121\7~\2\2\u0121\u0133\7}\2\2\u0122\u0130\7N\2\2\u0123"+
		"\u0124\7}\2\2\u0124\u0125\7X\2\2\u0125\u012c\5N(\2\u0126\u0127\7U\2\2"+
		"\u0127\u0128\7}\2\2\u0128\u0129\7X\2\2\u0129\u012b\5N(\2\u012a\u0126\3"+
		"\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u0131\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0131\5N(\2\u0130\u0123\3\2\2"+
		"\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134"+
		"\7O\2\2\u0133\u0122\3\2\2\2\u0133\u0134\3\2\2\2\u0134\27\3\2\2\2\u0135"+
		"\u0136\b\r\1\2\u0136\u0139\5\32\16\2\u0137\u0139\5\"\22\2\u0138\u0135"+
		"\3\2\2\2\u0138\u0137\3\2\2\2\u0139\u0142\3\2\2\2\u013a\u013b\f\3\2\2\u013b"+
		"\u013c\7R\2\2\u013c\u013e\7S\2\2\u013d\u013f\7]\2\2\u013e\u013d\3\2\2"+
		"\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013a\3\2\2\2\u0141\u0144"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\31\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0145\u0146\7}\2\2\u0146\u0148\7\u0084\2\2\u0147\u0145"+
		"\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0158\7}\2\2\u014d\u014e\7Z\2"+
		"\2\u014e\u0153\5\36\20\2\u014f\u0150\7U\2\2\u0150\u0152\5\36\20\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7Y\2\2\u0157"+
		"\u0159\3\2\2\2\u0158\u014d\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2"+
		"\2\2\u015a\u015c\7]\2\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015f\3\2\2\2\u015d\u015f\5\34\17\2\u015e\u0149\3\2\2\2\u015e\u015d\3"+
		"\2\2\2\u015f\33\3\2\2\2\u0160\u0161\7m\2\2\u0161\u0162\5\30\r\2\u0162"+
		"\u016b\7N\2\2\u0163\u0168\5\30\r\2\u0164\u0165\7U\2\2\u0165\u0167\5\30"+
		"\r\2\u0166\u0164\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u0163\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\7O\2\2\u016e"+
		"\u0170\7]\2\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\35\3\2\2\2"+
		"\u0171\u0174\5\30\r\2\u0172\u0174\5 \21\2\u0173\u0171\3\2\2\2\u0173\u0172"+
		"\3\2\2\2\u0174\37\3\2\2\2\u0175\u0176\7]\2\2\u0176\u0177\t\2\2\2\u0177"+
		"\u0178\5\32\16\2\u0178!\3\2\2\2\u0179\u017a\t\3\2\2\u017a#\3\2\2\2\u017b"+
		"\u0180\5:\36\2\u017c\u017d\7U\2\2\u017d\u017f\5:\36\2\u017e\u017c\3\2"+
		"\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"%\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184\7(\2\2\u0184\u0185\7N\2\2\u0185"+
		"\u0186\5L\'\2\u0186\u0187\7O\2\2\u0187\u018a\5(\25\2\u0188\u0189\7!\2"+
		"\2\u0189\u018b\5(\25\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\'"+
		"\3\2\2\2\u018c\u019d\5*\26\2\u018d\u019d\5\62\32\2\u018e\u019d\58\35\2"+
		"\u018f\u019d\5J&\2\u0190\u019d\5&\24\2\u0191\u019d\5@!\2\u0192\u019d\5"+
		"B\"\2\u0193\u019d\5D#\2\u0194\u019d\5F$\2\u0195\u019d\5<\37\2\u0196\u019d"+
		"\5> \2\u0197\u019d\5\66\34\2\u0198\u019d\5\64\33\2\u0199\u019d\5\60\31"+
		"\2\u019a\u019d\5,\27\2\u019b\u019d\5.\30\2\u019c\u018c\3\2\2\2\u019c\u018d"+
		"\3\2\2\2\u019c\u018e\3\2\2\2\u019c\u018f\3\2\2\2\u019c\u0190\3\2\2\2\u019c"+
		"\u0191\3\2\2\2\u019c\u0192\3\2\2\2\u019c\u0193\3\2\2\2\u019c\u0194\3\2"+
		"\2\2\u019c\u0195\3\2\2\2\u019c\u0196\3\2\2\2\u019c\u0197\3\2\2\2\u019c"+
		"\u0198\3\2\2\2\u019c\u0199\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019b\3\2"+
		"\2\2\u019d)\3\2\2\2\u019e\u019f\7T\2\2\u019f+\3\2\2\2\u01a0\u01a1\5L\'"+
		"\2\u01a1-\3\2\2\2\u01a2\u01a3\7\24\2\2\u01a3\u01a6\5L\'\2\u01a4\u01a5"+
		"\7^\2\2\u01a5\u01a7\5L\'\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"/\3\2\2\2\u01a8\u01a9\7>\2\2\u01a9\u01aa\5L\'\2\u01aa\u01ab\7T\2\2\u01ab"+
		"\61\3\2\2\2\u01ac\u01b0\7P\2\2\u01ad\u01af\5(\25\2\u01ae\u01ad\3\2\2\2"+
		"\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3"+
		"\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\7Q\2\2\u01b4\63\3\2\2\2\u01b5"+
		"\u01c4\7A\2\2\u01b6\u01b7\7N\2\2\u01b7\u01bc\5:\36\2\u01b8\u01b9\7T\2"+
		"\2\u01b9\u01bb\5:\36\2\u01ba\u01b8\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc\u01ba"+
		"\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf"+
		"\u01c1\7T\2\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2"+
		"\2\2\u01c2\u01c3\7O\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01b6\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01d0\5\62\32\2\u01c7\u01c8\7"+
		"\31\2\2\u01c8\u01c9\7N\2\2\u01c9\u01ca\5\32\16\2\u01ca\u01cb\7}\2\2\u01cb"+
		"\u01cc\7O\2\2\u01cc\u01cd\5\62\32\2\u01cd\u01cf\3\2\2\2\u01ce\u01c7\3"+
		"\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d5\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\7%\2\2\u01d4\u01d6\5\62"+
		"\32\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\65\3\2\2\2\u01d7\u01d9"+
		"\7\66\2\2\u01d8\u01da\5L\'\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dc\7T\2\2\u01dc\67\3\2\2\2\u01dd\u01de\5$\23\2"+
		"\u01de\u01df\7T\2\2\u01df9\3\2\2\2\u01e0\u01e3\7\7\2\2\u01e1\u01e3\7\b"+
		"\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01e7\7}\2\2\u01e5\u01e6\7\4\2\2\u01e6\u01e8\5\30\r\2\u01e7\u01e5\3\2"+
		"\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01ea\7X\2\2\u01ea"+
		"\u01ec\5L\'\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f4\3\2"+
		"\2\2\u01ed\u01ee\5\30\r\2\u01ee\u01f1\7}\2\2\u01ef\u01f0\7X\2\2\u01f0"+
		"\u01f2\5L\'\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f4\3\2"+
		"\2\2\u01f3\u01e2\3\2\2\2\u01f3\u01ed\3\2\2\2\u01f4;\3\2\2\2\u01f5\u01f6"+
		"\7\26\2\2\u01f6\u01f7\7T\2\2\u01f7=\3\2\2\2\u01f8\u01f9\7\35\2\2\u01f9"+
		"\u01fa\7T\2\2\u01fa?\3\2\2\2\u01fb\u01fc\7D\2\2\u01fc\u01fd\7N\2\2\u01fd"+
		"\u01fe\5L\'\2\u01fe\u01ff\7O\2\2\u01ff\u0200\5(\25\2\u0200A\3\2\2\2\u0201"+
		"\u0202\7\37\2\2\u0202\u0203\5\62\32\2\u0203\u0204\7D\2\2\u0204\u0205\7"+
		"N\2\2\u0205\u0206\5L\'\2\u0206\u0207\7O\2\2\u0207\u0208\7T\2\2\u0208C"+
		"\3\2\2\2\u0209\u020a\7\'\2\2\u020a\u020d\7N\2\2\u020b\u020e\5$\23\2\u020c"+
		"\u020e\5H%\2\u020d\u020b\3\2\2\2\u020d\u020c\3\2\2\2\u020d\u020e\3\2\2"+
		"\2\u020e\u020f\3\2\2\2\u020f\u0211\7T\2\2\u0210\u0212\5L\'\2\u0211\u0210"+
		"\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0215\7T\2\2\u0214"+
		"\u0216\5H%\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2"+
		"\2\u0217\u0218\7O\2\2\u0218\u0219\5(\25\2\u0219E\3\2\2\2\u021a\u021b\7"+
		"\'\2\2\u021b\u021c\7N\2\2\u021c\u021f\7}\2\2\u021d\u021e\7U\2\2\u021e"+
		"\u0220\7}\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\3\2"+
		"\2\2\u0221\u0222\7\5\2\2\u0222\u0223\5L\'\2\u0223\u0224\7O\2\2\u0224\u0225"+
		"\5(\25\2\u0225\u0233\3\2\2\2\u0226\u0227\7\t\2\2\u0227\u0228\7N\2\2\u0228"+
		"\u0229\5L\'\2\u0229\u022c\7\4\2\2\u022a\u022b\7}\2\2\u022b\u022d\7U\2"+
		"\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f"+
		"\7}\2\2\u022f\u0230\7O\2\2\u0230\u0231\5(\25\2\u0231\u0233\3\2\2\2\u0232"+
		"\u021a\3\2\2\2\u0232\u0226\3\2\2\2\u0233G\3\2\2\2\u0234\u0239\5L\'\2\u0235"+
		"\u0236\7U\2\2\u0236\u0238\5L\'\2\u0237\u0235\3\2\2\2\u0238\u023b\3\2\2"+
		"\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023aI\3\2\2\2\u023b\u0239"+
		"\3\2\2\2\u023c\u023d\5L\'\2\u023d\u023e\7T\2\2\u023eK\3\2\2\2\u023f\u0240"+
		"\b\'\1\2\u0240\u0241\t\4\2\2\u0241\u0318\5L\'\26\u0242\u0243\t\5\2\2\u0243"+
		"\u0318\5L\'\25\u0244\u0245\t\6\2\2\u0245\u0318\5L\'\24\u0246\u0247\7N"+
		"\2\2\u0247\u0248\5\30\r\2\u0248\u0249\7O\2\2\u0249\u024a\5L\'\23\u024a"+
		"\u0318\3\2\2\2\u024b\u024c\7N\2\2\u024c\u024d\5L\'\2\u024d\u024e\7O\2"+
		"\2\u024e\u0318\3\2\2\2\u024f\u0318\t\7\2\2\u0250\u0318\5N(\2\u0251\u0253"+
		"\5\34\17\2\u0252\u0251\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3\2\2\2"+
		"\u0254\u025e\7P\2\2\u0255\u025a\7}\2\2\u0256\u0257\7U\2\2\u0257\u0259"+
		"\7}\2\2\u0258\u0256\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025f\7\13"+
		"\2\2\u025e\u0255\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0263\3\2\2\2\u0260"+
		"\u0262\5(\25\2\u0261\u0260\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0261\3\2"+
		"\2\2\u0263\u0264\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2\2\2\u0266"+
		"\u0283\7Q\2\2\u0267\u0270\7N\2\2\u0268\u026d\7}\2\2\u0269\u026a\7U\2\2"+
		"\u026a\u026c\7}\2\2\u026b\u0269\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b"+
		"\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2\2\2\u0270"+
		"\u0268\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0275\7O"+
		"\2\2\u0273\u0275\7}\2\2\u0274\u0267\3\2\2\2\u0274\u0273\3\2\2\2\u0275"+
		"\u0276\3\2\2\2\u0276\u0280\7\13\2\2\u0277\u027b\7P\2\2\u0278\u027a\5("+
		"\25\2\u0279\u0278\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2\2\2\u027b"+
		"\u027c\3\2\2\2\u027c\u027e\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u0281\7Q"+
		"\2\2\u027f\u0281\5L\'\2\u0280\u0277\3\2\2\2\u0280\u027f\3\2\2\2\u0281"+
		"\u0283\3\2\2\2\u0282\u0252\3\2\2\2\u0282\u0274\3\2\2\2\u0283\u0318\3\2"+
		"\2\2\u0284\u0285\7Z\2\2\u0285\u0286\7}\2\2\u0286\u0287\7U\2\2\u0287\u0288"+
		"\7}\2\2\u0288\u028a\7Y\2\2\u0289\u0284\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u029e\3\2\2\2\u028b\u028c\7R\2\2\u028c\u028d\5L\'\2\u028d\u028e\7^\2"+
		"\2\u028e\u0296\5L\'\2\u028f\u0290\7U\2\2\u0290\u0291\5L\'\2\u0291\u0292"+
		"\7^\2\2\u0292\u0293\5L\'\2\u0293\u0295\3\2\2\2\u0294\u028f\3\2\2\2\u0295"+
		"\u0298\3\2\2\2\u0296\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0299\3\2"+
		"\2\2\u0298\u0296\3\2\2\2\u0299\u029a\7S\2\2\u029a\u029f\3\2\2\2\u029b"+
		"\u029c\7R\2\2\u029c\u029d\7^\2\2\u029d\u029f\7S\2\2\u029e\u028b\3\2\2"+
		"\2\u029e\u029b\3\2\2\2\u029f\u0318\3\2\2\2\u02a0\u02a1\7Z\2\2\u02a1\u02a2"+
		"\5\30\r\2\u02a2\u02a3\7Y\2\2\u02a3\u02a5\3\2\2\2\u02a4\u02a0\3\2\2\2\u02a4"+
		"\u02a5\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02af\7R\2\2\u02a7\u02ac\5L\'"+
		"\2\u02a8\u02a9\7U\2\2\u02a9\u02ab\5L\'\2\u02aa\u02a8\3\2\2\2\u02ab\u02ae"+
		"\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae"+
		"\u02ac\3\2\2\2\u02af\u02a7\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\3\2"+
		"\2\2\u02b1\u0318\7S\2\2\u02b2\u02b6\7}\2\2\u02b3\u02b6\7=\2\2\u02b4\u02b6"+
		"\7:\2\2\u02b5\u02b2\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b4\3\2\2\2\u02b6"+
		"\u02b7\3\2\2\2\u02b7\u02c0\7N\2\2\u02b8\u02bd\5L\'\2\u02b9\u02ba\7U\2"+
		"\2\u02ba\u02bc\5L\'\2\u02bb\u02b9\3\2\2\2\u02bc\u02bf\3\2\2\2\u02bd\u02bb"+
		"\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02c1\3\2\2\2\u02bf\u02bd\3\2\2\2\u02c0"+
		"\u02b8\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u0318\7O"+
		"\2\2\u02c3\u02c4\7\61\2\2\u02c4\u02c5\5\32\16\2\u02c5\u02ce\7N\2\2\u02c6"+
		"\u02cb\5L\'\2\u02c7\u02c8\7U\2\2\u02c8\u02ca\5L\'\2\u02c9\u02c7\3\2\2"+
		"\2\u02ca\u02cd\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cf"+
		"\3\2\2\2\u02cd\u02cb\3\2\2\2\u02ce\u02c6\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d0\3\2\2\2\u02d0\u02d1\7O\2\2\u02d1\u0318\3\2\2\2\u02d2\u02d3\7\61"+
		"\2\2\u02d3\u02d8\5\30\r\2\u02d4\u02d5\7R\2\2\u02d5\u02d6\5L\'\2\u02d6"+
		"\u02d7\7S\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02d4\3\2\2\2\u02d9\u02da\3\2"+
		"\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02e0\3\2\2\2\u02dc"+
		"\u02dd\7R\2\2\u02dd\u02df\7S\2\2\u02de\u02dc\3\2\2\2\u02df\u02e2\3\2\2"+
		"\2\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02f5\3\2\2\2\u02e2\u02e0"+
		"\3\2\2\2\u02e3\u02e4\7\61\2\2\u02e4\u02e5\5\30\r\2\u02e5\u02e6\7R\2\2"+
		"\u02e6\u02e7\7S\2\2\u02e7\u02f0\7P\2\2\u02e8\u02ed\5L\'\2\u02e9\u02ea"+
		"\7U\2\2\u02ea\u02ec\5L\'\2\u02eb\u02e9\3\2\2\2\u02ec\u02ef\3\2\2\2\u02ed"+
		"\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02f1\3\2\2\2\u02ef\u02ed\3\2"+
		"\2\2\u02f0\u02e8\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2"+
		"\u02f3\7Q\2\2\u02f3\u02f5\3\2\2\2\u02f4\u02d2\3\2\2\2\u02f4\u02e3\3\2"+
		"\2\2\u02f5\u0318\3\2\2\2\u02f6\u0318\7}\2\2\u02f7\u02f8\7|\2\2\u02f8\u0301"+
		"\5L\'\2\u02f9\u02fb\7Q\2\2\u02fa\u02fc\7\u0087\2\2\u02fb\u02fa\3\2\2\2"+
		"\u02fb\u02fc\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\7\u0085\2\2\u02fe"+
		"\u0300\5L\'\2\u02ff\u02f9\3\2\2\2\u0300\u0303\3\2\2\2\u0301\u02ff\3\2"+
		"\2\2\u0301\u0302\3\2\2\2\u0302\u0304\3\2\2\2\u0303\u0301\3\2\2\2\u0304"+
		"\u0306\7Q\2\2\u0305\u0307\7\u0087\2\2\u0306\u0305\3\2\2\2\u0306\u0307"+
		"\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0309\7\u0086\2\2\u0309\u0318\3\2\2"+
		"\2\u030a\u030b\7F\2\2\u030b\u030c\7N\2\2\u030c\u030d\5L\'\2\u030d\u030e"+
		"\7O\2\2\u030e\u0312\7P\2\2\u030f\u0311\5(\25\2\u0310\u030f\3\2\2\2\u0311"+
		"\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0315\3\2"+
		"\2\2\u0314\u0312\3\2\2\2\u0315\u0316\7Q\2\2\u0316\u0318\3\2\2\2\u0317"+
		"\u023f\3\2\2\2\u0317\u0242\3\2\2\2\u0317\u0244\3\2\2\2\u0317\u0246\3\2"+
		"\2\2\u0317\u024b\3\2\2\2\u0317\u024f\3\2\2\2\u0317\u0250\3\2\2\2\u0317"+
		"\u0282\3\2\2\2\u0317\u0289\3\2\2\2\u0317\u02a4\3\2\2\2\u0317\u02b5\3\2"+
		"\2\2\u0317\u02c3\3\2\2\2\u0317\u02f4\3\2\2\2\u0317\u02f6\3\2\2\2\u0317"+
		"\u02f7\3\2\2\2\u0317\u030a\3\2\2\2\u0318\u0365\3\2\2\2\u0319\u031a\f\22"+
		"\2\2\u031a\u031b\t\b\2\2\u031b\u0364\5L\'\23\u031c\u031d\f\21\2\2\u031d"+
		"\u031e\t\4\2\2\u031e\u0364\5L\'\22\u031f\u0327\f\20\2\2\u0320\u0321\7"+
		"Z\2\2\u0321\u0328\7Z\2\2\u0322\u0323\7Y\2\2\u0323\u0324\7Y\2\2\u0324\u0328"+
		"\7Y\2\2\u0325\u0326\7Y\2\2\u0326\u0328\7Y\2\2\u0327\u0320\3\2\2\2\u0327"+
		"\u0322\3\2\2\2\u0327\u0325\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u0364\5L"+
		"\'\21\u032a\u032b\f\17\2\2\u032b\u032c\t\t\2\2\u032c\u0364\5L\'\20\u032d"+
		"\u032e\f\r\2\2\u032e\u032f\t\n\2\2\u032f\u0364\5L\'\16\u0330\u0331\f\f"+
		"\2\2\u0331\u0332\7m\2\2\u0332\u0364\5L\'\r\u0333\u0334\f\13\2\2\u0334"+
		"\u0335\7o\2\2\u0335\u0364\5L\'\f\u0336\u0337\f\n\2\2\u0337\u0338\7n\2"+
		"\2\u0338\u0364\5L\'\13\u0339\u033a\f\t\2\2\u033a\u033b\t\13\2\2\u033b"+
		"\u0364\5L\'\n\u033c\u033d\f\b\2\2\u033d\u033e\7]\2\2\u033e\u033f\5L\'"+
		"\2\u033f\u0340\7^\2\2\u0340\u0341\5L\'\t\u0341\u0364\3\2\2\2\u0342\u0343"+
		"\f\3\2\2\u0343\u0344\t\f\2\2\u0344\u0364\5L\'\3\u0345\u0346\f\35\2\2\u0346"+
		"\u0347\t\r\2\2\u0347\u0348\t\16\2\2\u0348\u0351\7N\2\2\u0349\u034e\5L"+
		"\'\2\u034a\u034b\7U\2\2\u034b\u034d\5L\'\2\u034c\u034a\3\2\2\2\u034d\u0350"+
		"\3\2\2\2\u034e\u034c\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0352\3\2\2\2\u0350"+
		"\u034e\3\2\2\2\u0351\u0349\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0353\3\2"+
		"\2\2\u0353\u0364\7O\2\2\u0354\u0355\f\34\2\2\u0355\u0356\t\17\2\2\u0356"+
		"\u0364\t\16\2\2\u0357\u0358\f\32\2\2\u0358\u0359\7R\2\2\u0359\u035a\5"+
		"L\'\2\u035a\u035b\7S\2\2\u035b\u0364\3\2\2\2\u035c\u035d\f\27\2\2\u035d"+
		"\u0364\t\5\2\2\u035e\u035f\f\16\2\2\u035f\u0360\7,\2\2\u0360\u0364\7}"+
		"\2\2\u0361\u0362\f\6\2\2\u0362\u0364\7V\2\2\u0363\u0319\3\2\2\2\u0363"+
		"\u031c\3\2\2\2\u0363\u031f\3\2\2\2\u0363\u032a\3\2\2\2\u0363\u032d\3\2"+
		"\2\2\u0363\u0330\3\2\2\2\u0363\u0333\3\2\2\2\u0363\u0336\3\2\2\2\u0363"+
		"\u0339\3\2\2\2\u0363\u033c\3\2\2\2\u0363\u0342\3\2\2\2\u0363\u0345\3\2"+
		"\2\2\u0363\u0354\3\2\2\2\u0363\u0357\3\2\2\2\u0363\u035c\3\2\2\2\u0363"+
		"\u035e\3\2\2\2\u0363\u0361\3\2\2\2\u0364\u0367\3\2\2\2\u0365\u0363\3\2"+
		"\2\2\u0365\u0366\3\2\2\2\u0366M\3\2\2\2\u0367\u0365\3\2\2\2\u0368\u037a"+
		"\7G\2\2\u0369\u037a\7H\2\2\u036a\u037a\7J\2\2\u036b\u037a\7K\2\2\u036c"+
		"\u037a\7L\2\2\u036d\u037a\7I\2\2\u036e\u0371\5\"\22\2\u036f\u0371\7}\2"+
		"\2\u0370\u036e\3\2\2\2\u0370\u036f\3\2\2\2\u0371\u0374\3\2\2\2\u0372\u0373"+
		"\7R\2\2\u0373\u0375\7S\2\2\u0374\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375"+
		"\u0376\3\2\2\2\u0376\u0377\7V\2\2\u0377\u037a\7\33\2\2\u0378\u037a\7M"+
		"\2\2\u0379\u0368\3\2\2\2\u0379\u0369\3\2\2\2\u0379\u036a\3\2\2\2\u0379"+
		"\u036b\3\2\2\2\u0379\u036c\3\2\2\2\u0379\u036d\3\2\2\2\u0379\u0370\3\2"+
		"\2\2\u0379\u0378\3\2\2\2\u037aO\3\2\2\2\u037b\u037d\t\20\2\2\u037c\u037b"+
		"\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u037c\3\2\2\2\u037e\u037f\3\2\2\2\u037f"+
		"Q\3\2\2\2xU[`gios|\u0080\u0083\u0086\u008a\u0092\u0095\u009e\u00a1\u00a8"+
		"\u00af\u00b2\u00b6\u00bd\u00c4\u00c7\u00c9\u00d2\u00d8\u00da\u00de\u00e5"+
		"\u00ed\u00f1\u00f4\u00f7\u00fd\u0105\u0108\u0111\u0114\u0118\u011e\u012c"+
		"\u0130\u0133\u0138\u013e\u0142\u0149\u0153\u0158\u015b\u015e\u0168\u016b"+
		"\u016f\u0173\u0180\u018a\u019c\u01a6\u01b0\u01bc\u01c0\u01c4\u01d0\u01d5"+
		"\u01d9\u01e2\u01e7\u01eb\u01f1\u01f3\u020d\u0211\u0215\u021f\u022c\u0232"+
		"\u0239\u0252\u025a\u025e\u0263\u026d\u0270\u0274\u027b\u0280\u0282\u0289"+
		"\u0296\u029e\u02a4\u02ac\u02af\u02b5\u02bd\u02c0\u02cb\u02ce\u02da\u02e0"+
		"\u02ed\u02f0\u02f4\u02fb\u0301\u0306\u0312\u0317\u0327\u034e\u0351\u0363"+
		"\u0365\u0370\u0374\u0379\u037e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
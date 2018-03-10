// Generated from KalangParser.g4 by ANTLR 4.5.1
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
		DOUBLE_COLON=1, AS=2, CONSTRUCTOR=3, VAR=4, VAL=5, FOREACH=6, ARROW=7, 
		START_DOT=8, OVERRIDE=9, ABSTRACT=10, ASSERT=11, BOOLEAN=12, BREAK=13, 
		BYTE=14, CASE=15, CATCH=16, CHAR=17, CLASS=18, CONST=19, CONTINUE=20, 
		DEFAULT=21, DO=22, DOUBLE=23, ELSE=24, ENUM=25, EXTENDS=26, FINAL=27, 
		FINALLY=28, FLOAT=29, FOR=30, IF=31, GOTO=32, IMPLEMENTS=33, IMPORT=34, 
		INSTANCEOF=35, INT=36, INTERFACE=37, LONG=38, NATIVE=39, NEW=40, PACKAGE=41, 
		PRIVATE=42, PROTECTED=43, PUBLIC=44, RETURN=45, SHORT=46, STATIC=47, STRICTFP=48, 
		SUPER=49, SWITCH=50, SYNCHRONIZED=51, THIS=52, THROW=53, THROWS=54, TRANSIENT=55, 
		TRY=56, VOID=57, VOLATILE=58, WHILE=59, IntegerLiteral=60, FloatingPointLiteral=61, 
		BooleanLiteral=62, CharacterLiteral=63, StringLiteral=64, MultiLineStringLiteral=65, 
		NullLiteral=66, LPAREN=67, RPAREN=68, LBRACE=69, RBRACE=70, LBRACK=71, 
		RBRACK=72, SEMI=73, COMMA=74, DOT=75, ASSIGN=76, GT=77, LT=78, BANG=79, 
		TILDE=80, QUESTION=81, COLON=82, EQUAL=83, LE=84, GE=85, NOTEQUAL=86, 
		AND=87, OR=88, INC=89, DEC=90, ADD=91, SUB=92, MUL=93, DIV=94, BITAND=95, 
		BITOR=96, CARET=97, MOD=98, ADD_ASSIGN=99, SUB_ASSIGN=100, MUL_ASSIGN=101, 
		DIV_ASSIGN=102, AND_ASSIGN=103, OR_ASSIGN=104, XOR_ASSIGN=105, MOD_ASSIGN=106, 
		LSHIFT_ASSIGN=107, RSHIFT_ASSIGN=108, URSHIFT_ASSIGN=109, InterpolationPreffixString=110, 
		Identifier=111, AT=112, ELLIPSIS=113, COMPILE_OPTION_LINE=114, WS=115, 
		COMMENT=116, LINE_COMMENT=117, PACKAGE_DELIMITER=118, INTERPOLATION_INTERUPT=119, 
		INTERPOLATION_END=120, INTERPOLATION_STRING=121;
	public static final int
		RULE_compilationUnit = 0, RULE_compileOption = 1, RULE_scriptDef = 2, 
		RULE_classDef = 3, RULE_importDecl = 4, RULE_qualifiedName = 5, RULE_classBody = 6, 
		RULE_fieldDecl = 7, RULE_methodDecl = 8, RULE_annotation = 9, RULE_type = 10, 
		RULE_classType = 11, RULE_parameterizedElementType = 12, RULE_wildcardType = 13, 
		RULE_primitiveType = 14, RULE_localVarDecl = 15, RULE_ifStat = 16, RULE_stat = 17, 
		RULE_emptyStat = 18, RULE_errorousStat = 19, RULE_throwStat = 20, RULE_blockStmt = 21, 
		RULE_tryStat = 22, RULE_returnStat = 23, RULE_postIfStmt = 24, RULE_varDeclStat = 25, 
		RULE_varDecl = 26, RULE_breakStat = 27, RULE_continueStat = 28, RULE_whileStat = 29, 
		RULE_doWhileStat = 30, RULE_forStat = 31, RULE_forEachStat = 32, RULE_expressions = 33, 
		RULE_exprStat = 34, RULE_expression = 35, RULE_literal = 36, RULE_varModifier = 37;
	public static final String[] ruleNames = {
		"compilationUnit", "compileOption", "scriptDef", "classDef", "importDecl", 
		"qualifiedName", "classBody", "fieldDecl", "methodDecl", "annotation", 
		"type", "classType", "parameterizedElementType", "wildcardType", "primitiveType", 
		"localVarDecl", "ifStat", "stat", "emptyStat", "errorousStat", "throwStat", 
		"blockStmt", "tryStat", "returnStat", "postIfStmt", "varDeclStat", "varDecl", 
		"breakStat", "continueStat", "whileStat", "doWhileStat", "forStat", "forEachStat", 
		"expressions", "exprStat", "expression", "literal", "varModifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'::'", "'as'", "'constructor'", "'var'", "'val'", "'foreach'", 
		"'->'", "'*.'", "'override'", "'abstract'", "'assert'", "'boolean'", "'break'", 
		"'byte'", "'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", 
		"'default'", "'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", 
		"'finally'", "'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", 
		"'instanceof'", "'int'", "'interface'", "'long'", "'native'", "'new'", 
		"'package'", "'private'", "'protected'", "'public'", "'return'", "'short'", 
		"'static'", "'strictfp'", "'super'", "'switch'", "'synchronized'", "'this'", 
		"'throw'", "'throws'", "'transient'", "'try'", "'void'", "'volatile'", 
		"'while'", null, null, null, null, null, null, "'null'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", 
		"'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", 
		"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", 
		"'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", 
		"'>>='", "'>>>='", null, null, "'@'", "'...'", null, null, null, null, 
		"'\\'", "'${'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOUBLE_COLON", "AS", "CONSTRUCTOR", "VAR", "VAL", "FOREACH", "ARROW", 
		"START_DOT", "OVERRIDE", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", 
		"CASE", "CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", 
		"DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", 
		"IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", 
		"LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", 
		"RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", 
		"THIS", "THROW", "THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", 
		"IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "MultiLineStringLiteral", "NullLiteral", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
		"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
		"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", 
		"BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPILE_OPTION_LINE) {
				{
				{
				setState(76);
				compileOption();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(82);
				importDecl();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(88);
				classDef();
				}
				break;
			case 2:
				{
				setState(89);
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
			setState(92);
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
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << STATIC) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(97);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(94);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(95);
					stat();
					}
					break;
				case 3:
					{
					setState(96);
					classDef();
					}
					break;
				}
				}
				setState(101);
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(102);
				annotation();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(108);
				varModifier();
				}
			}

			setState(125);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(111);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(122);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(112);
					match(LT);
					setState(113);
					((ClassDefContext)_localctx).Identifier = match(Identifier);
					((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(114);
						match(COMMA);
						setState(115);
						((ClassDefContext)_localctx).Identifier = match(Identifier);
						((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
						}
						}
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(121);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(124);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(127);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(132);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(130);
				match(EXTENDS);
				setState(131);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(143);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(134);
				match(IMPLEMENTS);
				setState(135);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136);
					match(COMMA);
					setState(137);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(145);
			match(LBRACE);
			setState(146);
			classBody();
			setState(147);
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
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(149);
				match(IMPORT);
				setState(151);
				_la = _input.LA(1);
				if (_la==PACKAGE_DELIMITER) {
					{
					setState(150);
					((ImportDeclContext)_localctx).root = match(PACKAGE_DELIMITER);
					}
				}

				setState(153);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(154);
						match(PACKAGE_DELIMITER);
						setState(155);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(161);
				((ImportDeclContext)_localctx).delim = match(PACKAGE_DELIMITER);
				setState(168);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(162);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(165);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(163);
						match(AS);
						setState(164);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(167);
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
				setState(170);
				match(IMPORT);
				setState(171);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(172);
						match(DOT);
						setState(173);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(179);
				((ImportDeclContext)_localctx).delim = match(DOT);
				setState(186);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(180);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(183);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(181);
						match(AS);
						setState(182);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(185);
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
			setState(190);
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
			setState(192);
			match(Identifier);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(193);
				match(DOT);
				setState(194);
				match(Identifier);
				}
				}
				setState(199);
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
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(203);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(200);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(201);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(202);
					classDef();
					}
					break;
				}
				}
				setState(207);
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
			setState(209);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(208);
				varModifier();
				}
			}

			setState(211);
			varDecl();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(212);
				match(COMMA);
				setState(213);
				varDecl();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
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
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(221);
				annotation();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			_la = _input.LA(1);
			if (_la==OVERRIDE) {
				{
				setState(227);
				match(OVERRIDE);
				}
			}

			setState(231);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(230);
				match(DEFAULT);
				}
			}

			setState(234);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(233);
				varModifier();
				}
			}

			setState(240);
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
				setState(236);
				((MethodDeclContext)_localctx).returnType = type(0);
				setState(237);
				((MethodDeclContext)_localctx).name = match(Identifier);
				}
				}
				break;
			case CONSTRUCTOR:
				{
				{
				setState(239);
				((MethodDeclContext)_localctx).prefix = match(CONSTRUCTOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(242);
			match(LPAREN);
			setState(254);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				setState(243);
				((MethodDeclContext)_localctx).type = type(0);
				((MethodDeclContext)_localctx).paramTypes.add(((MethodDeclContext)_localctx).type);
				setState(244);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).paramIds.add(((MethodDeclContext)_localctx).Identifier);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(245);
					match(COMMA);
					setState(246);
					((MethodDeclContext)_localctx).type = type(0);
					((MethodDeclContext)_localctx).paramTypes.add(((MethodDeclContext)_localctx).type);
					setState(247);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).paramIds.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(256);
			match(RPAREN);
			setState(266);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(257);
				match(THROWS);
				setState(258);
				((MethodDeclContext)_localctx).Identifier = match(Identifier);
				((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(259);
					match(COMMA);
					setState(260);
					((MethodDeclContext)_localctx).Identifier = match(Identifier);
					((MethodDeclContext)_localctx).exceptionTypes.add(((MethodDeclContext)_localctx).Identifier);
					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(270);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(268);
				blockStmt();
				}
				break;
			case SEMI:
				{
				setState(269);
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
			setState(272);
			match(AT);
			setState(273);
			((AnnotationContext)_localctx).annotationType = match(Identifier);
			setState(291);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(274);
				match(LPAREN);
				setState(288);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					{
					setState(275);
					((AnnotationContext)_localctx).Identifier = match(Identifier);
					((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
					setState(276);
					match(ASSIGN);
					setState(277);
					((AnnotationContext)_localctx).literal = literal();
					((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(278);
						match(COMMA);
						setState(279);
						((AnnotationContext)_localctx).Identifier = match(Identifier);
						((AnnotationContext)_localctx).annotationValueKey.add(((AnnotationContext)_localctx).Identifier);
						setState(280);
						match(ASSIGN);
						setState(281);
						((AnnotationContext)_localctx).literal = literal();
						((AnnotationContext)_localctx).annotationValue.add(((AnnotationContext)_localctx).literal);
						}
						}
						setState(286);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(287);
					((AnnotationContext)_localctx).annotationDefaultValue = literal();
					}
					break;
				}
				setState(290);
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
			setState(296);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(294);
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
				setState(295);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(298);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(299);
					match(LBRACK);
					setState(300);
					match(RBRACK);
					setState(302);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						setState(301);
						((TypeContext)_localctx).nullable = match(QUESTION);
						}
						break;
					}
					}
					} 
				}
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(309);
					((ClassTypeContext)_localctx).Identifier = match(Identifier);
					((ClassTypeContext)_localctx).paths.add(((ClassTypeContext)_localctx).Identifier);
					setState(310);
					match(PACKAGE_DELIMITER);
					}
					} 
				}
				setState(315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(316);
			((ClassTypeContext)_localctx).rawClass = match(Identifier);
			setState(319);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(317);
				match(DOUBLE_COLON);
				setState(318);
				((ClassTypeContext)_localctx).innerClass = match(Identifier);
				}
				break;
			}
			setState(332);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(321);
				match(LT);
				setState(322);
				((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
				((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(323);
					match(COMMA);
					setState(324);
					((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
					((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
					}
					}
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(330);
				match(GT);
				}
				break;
			}
			setState(335);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(334);
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
		enterRule(_localctx, 24, RULE_parameterizedElementType);
		try {
			setState(339);
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
				setState(337);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
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
		enterRule(_localctx, 26, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(QUESTION);
			setState(342);
			((WildcardTypeContext)_localctx).boundKind = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
				((WildcardTypeContext)_localctx).boundKind = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(343);
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
		enterRule(_localctx, 28, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
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
		enterRule(_localctx, 30, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			varDecl();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(348);
				match(COMMA);
				setState(349);
				varDecl();
				}
				}
				setState(354);
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
		enterRule(_localctx, 32, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(IF);
			setState(356);
			match(LPAREN);
			setState(357);
			expression(0);
			setState(358);
			match(RPAREN);
			setState(359);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(362);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(360);
				match(ELSE);
				setState(361);
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
		enterRule(_localctx, 34, RULE_stat);
		try {
			setState(380);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				emptyStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				blockStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(367);
				postIfStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(368);
				exprStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(369);
				ifStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(370);
				whileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(371);
				doWhileStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(372);
				forStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(373);
				forEachStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(374);
				breakStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(375);
				continueStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(376);
				returnStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(377);
				tryStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(378);
				throwStat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(379);
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
		enterRule(_localctx, 36, RULE_emptyStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
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
		enterRule(_localctx, 38, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
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
		enterRule(_localctx, 40, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(THROW);
			setState(387);
			expression(0);
			setState(388);
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
		enterRule(_localctx, 42, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(LBRACE);
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(391);
				stat();
				}
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(397);
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
		enterRule(_localctx, 44, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(TRY);
			setState(400);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(401);
				match(CATCH);
				setState(402);
				match(LPAREN);
				setState(403);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(404);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(405);
				match(RPAREN);
				setState(406);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(415);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(413);
				match(FINALLY);
				setState(414);
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
		enterRule(_localctx, 46, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(RETURN);
			setState(419);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(418);
				expression(0);
				}
			}

			setState(421);
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
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).enterPostIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KalangParserListener ) ((KalangParserListener)listener).exitPostIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KalangParserVisitor ) return ((KalangParserVisitor<? extends T>)visitor).visitPostIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIfStmtContext postIfStmt() throws RecognitionException {
		PostIfStmtContext _localctx = new PostIfStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_postIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			expression(0);
			setState(424);
			match(IF);
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(425);
				((PostIfStmtContext)_localctx).op = match(EQUAL);
				}
				break;
			case 2:
				{
				setState(426);
				((PostIfStmtContext)_localctx).op = match(LT);
				}
				break;
			case 3:
				{
				setState(427);
				((PostIfStmtContext)_localctx).op = match(GT);
				}
				break;
			case 4:
				{
				setState(428);
				((PostIfStmtContext)_localctx).op = match(NOTEQUAL);
				}
				break;
			case 5:
				{
				setState(429);
				((PostIfStmtContext)_localctx).op = match(GE);
				}
				break;
			case 6:
				{
				setState(430);
				((PostIfStmtContext)_localctx).op = match(LE);
				}
				break;
			}
			setState(433);
			expression(0);
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
		enterRule(_localctx, 50, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			localVarDecl();
			setState(437);
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
		enterRule(_localctx, 52, RULE_varDecl);
		int _la;
		try {
			setState(455);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(439);
				_la = _input.LA(1);
				if ( !(_la==VAR || _la==VAL) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(440);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(443);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(441);
					match(AS);
					setState(442);
					type(0);
					}
				}

				setState(447);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(445);
					match(ASSIGN);
					setState(446);
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
				setState(449);
				((VarDeclContext)_localctx).varType = type(0);
				setState(450);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(453);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(451);
					match(ASSIGN);
					setState(452);
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
		enterRule(_localctx, 54, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(BREAK);
			setState(458);
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
		enterRule(_localctx, 56, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(CONTINUE);
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
		enterRule(_localctx, 58, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(WHILE);
			setState(464);
			match(LPAREN);
			setState(465);
			expression(0);
			setState(466);
			match(RPAREN);
			setState(467);
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
		enterRule(_localctx, 60, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(DO);
			setState(470);
			blockStmt();
			setState(471);
			match(WHILE);
			setState(472);
			match(LPAREN);
			setState(473);
			expression(0);
			setState(474);
			match(RPAREN);
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
		enterRule(_localctx, 62, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(FOR);
			setState(478);
			match(LPAREN);
			setState(481);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(479);
				localVarDecl();
				}
				break;
			case 2:
				{
				setState(480);
				((ForStatContext)_localctx).initExpressions = expressions();
				}
				break;
			}
			setState(483);
			match(SEMI);
			setState(485);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(484);
				((ForStatContext)_localctx).condition = expression(0);
				}
			}

			setState(487);
			match(SEMI);
			setState(489);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(488);
				((ForStatContext)_localctx).updateExpressions = expressions();
				}
			}

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
		enterRule(_localctx, 64, RULE_forEachStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(FOREACH);
			setState(495);
			match(LPAREN);
			setState(496);
			expression(0);
			setState(497);
			match(AS);
			setState(500);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(498);
				match(Identifier);
				setState(499);
				match(COMMA);
				}
				break;
			}
			setState(502);
			match(Identifier);
			setState(503);
			match(RPAREN);
			setState(504);
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
		enterRule(_localctx, 66, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			expression(0);
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(507);
				match(COMMA);
				setState(508);
				expression(0);
				}
				}
				setState(513);
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
		enterRule(_localctx, 68, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			expression(0);
			setState(515);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(518);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(519);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(520);
				((PreIncExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(521);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(522);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(523);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(524);
				match(LPAREN);
				setState(525);
				type(0);
				setState(526);
				match(RPAREN);
				setState(527);
				expression(16);
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(529);
				match(LPAREN);
				setState(530);
				expression(0);
				setState(531);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(533);
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
				setState(534);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(540);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(535);
					match(LT);
					setState(536);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(537);
					match(COMMA);
					setState(538);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(539);
					match(GT);
					}
				}

				setState(560);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(542);
					match(LBRACK);
					setState(543);
					((MapExprContext)_localctx).Identifier = match(Identifier);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
					setState(544);
					match(COLON);
					setState(545);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(552);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(546);
						match(COMMA);
						setState(547);
						((MapExprContext)_localctx).Identifier = match(Identifier);
						((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
						setState(548);
						match(COLON);
						setState(549);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
						}
						}
						setState(554);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(555);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(557);
					match(LBRACK);
					setState(558);
					match(COLON);
					setState(559);
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
				setState(566);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(562);
					match(LT);
					setState(563);
					type(0);
					setState(564);
					match(GT);
					}
				}

				setState(568);
				match(LBRACK);
				setState(577);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(569);
					expression(0);
					setState(574);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(570);
						match(COMMA);
						setState(571);
						expression(0);
						}
						}
						setState(576);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(579);
				match(RBRACK);
				}
				break;
			case 10:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(583);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(580);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(581);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(582);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(585);
				match(LPAREN);
				setState(594);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(586);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(591);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(587);
						match(COMMA);
						setState(588);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
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
				break;
			case 11:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(597);
				match(NEW);
				setState(598);
				classType();
				setState(599);
				match(LPAREN);
				setState(608);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(600);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(605);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(601);
						match(COMMA);
						setState(602);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(607);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(610);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(635);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(612);
					match(NEW);
					setState(613);
					type(0);
					setState(614);
					match(LBRACK);
					setState(615);
					((NewArrayExprContext)_localctx).size = expression(0);
					setState(616);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(618);
					match(NEW);
					setState(619);
					type(0);
					setState(620);
					match(LBRACK);
					setState(621);
					match(RBRACK);
					setState(622);
					match(LBRACE);
					setState(631);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						setState(623);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(628);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(624);
							match(COMMA);
							setState(625);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(630);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(633);
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
				setState(637);
				match(Identifier);
				}
				break;
			case 14:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(638);
				match(InterpolationPreffixString);
				setState(639);
				expression(0);
				setState(648);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(640);
						match(RBRACE);
						setState(642);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(641);
							match(INTERPOLATION_STRING);
							}
						}

						setState(644);
						match(INTERPOLATION_INTERUPT);
						setState(645);
						expression(0);
						}
						} 
					}
					setState(650);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				}
				setState(651);
				match(RBRACE);
				setState(653);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(652);
					match(INTERPOLATION_STRING);
					}
				}

				setState(655);
				match(INTERPOLATION_END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(735);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(733);
					switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(659);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(660);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (MUL - 93)) | (1L << (DIV - 93)) | (1L << (MOD - 93)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(661);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(662);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(663);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(664);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(665);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(673);
						switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
						case 1:
							{
							setState(666);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(667);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(668);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(669);
							match(GT);
							setState(670);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(671);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(672);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(675);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(676);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(677);
						_la = _input.LA(1);
						if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (GT - 77)) | (1L << (LT - 77)) | (1L << (LE - 77)) | (1L << (GE - 77)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(678);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(679);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(680);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(681);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(682);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(683);
						match(BITAND);
						setState(684);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(685);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(686);
						match(CARET);
						setState(687);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(688);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(689);
						match(BITOR);
						setState(690);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(691);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(692);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(693);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(694);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(695);
						match(QUESTION);
						setState(696);
						expression(0);
						setState(697);
						match(COLON);
						setState(698);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(700);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(701);
						_la = _input.LA(1);
						if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ASSIGN - 76)) | (1L << (ADD_ASSIGN - 76)) | (1L << (SUB_ASSIGN - 76)) | (1L << (MUL_ASSIGN - 76)) | (1L << (DIV_ASSIGN - 76)) | (1L << (AND_ASSIGN - 76)) | (1L << (OR_ASSIGN - 76)) | (1L << (XOR_ASSIGN - 76)) | (1L << (MOD_ASSIGN - 76)) | (1L << (LSHIFT_ASSIGN - 76)) | (1L << (RSHIFT_ASSIGN - 76)) | (1L << (URSHIFT_ASSIGN - 76)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(702);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(703);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(704);
						((InvokeExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ARROW || _la==START_DOT || _la==DOT) ) {
							((InvokeExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(705);
						match(Identifier);
						setState(706);
						match(LPAREN);
						setState(715);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (StringLiteral - 64)) | (1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(707);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(712);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(708);
								match(COMMA);
								setState(709);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(714);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(717);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(718);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(719);
						((GetFieldExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ARROW || _la==DOT) ) {
							((GetFieldExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(720);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(721);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(722);
						match(LBRACK);
						setState(723);
						expression(0);
						setState(724);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(726);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(727);
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
						setState(728);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(729);
						match(INSTANCEOF);
						setState(730);
						match(Identifier);
						}
						break;
					case 17:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(731);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(732);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
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
		enterRule(_localctx, 72, RULE_literal);
		try {
			setState(748);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(738);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(739);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(740);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(741);
				match(StringLiteral);
				}
				break;
			case MultiLineStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(742);
				match(MultiLineStringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(743);
				match(BooleanLiteral);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 7);
				{
				setState(744);
				match(Identifier);
				setState(745);
				match(DOT);
				setState(746);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 8);
				{
				setState(747);
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
		enterRule(_localctx, 74, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(750);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(753); 
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
		case 10:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 35:
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
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 26);
		case 13:
			return precpred(_ctx, 25);
		case 14:
			return precpred(_ctx, 23);
		case 15:
			return precpred(_ctx, 20);
		case 16:
			return precpred(_ctx, 11);
		case 17:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3{\u02f6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\7\2P\n\2\f\2\16\2S\13"+
		"\2\3\2\7\2V\n\2\f\2\16\2Y\13\2\3\2\3\2\5\2]\n\2\3\3\3\3\3\4\3\4\3\4\7"+
		"\4d\n\4\f\4\16\4g\13\4\3\5\7\5j\n\5\f\5\16\5m\13\5\3\5\5\5p\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5w\n\5\f\5\16\5z\13\5\3\5\5\5}\n\5\3\5\5\5\u0080\n\5"+
		"\3\5\5\5\u0083\n\5\3\5\3\5\5\5\u0087\n\5\3\5\3\5\3\5\3\5\7\5\u008d\n\5"+
		"\f\5\16\5\u0090\13\5\5\5\u0092\n\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6\u009a\n"+
		"\6\3\6\3\6\3\6\7\6\u009f\n\6\f\6\16\6\u00a2\13\6\3\6\3\6\3\6\3\6\5\6\u00a8"+
		"\n\6\3\6\5\6\u00ab\n\6\3\6\3\6\3\6\3\6\7\6\u00b1\n\6\f\6\16\6\u00b4\13"+
		"\6\3\6\3\6\3\6\3\6\5\6\u00ba\n\6\3\6\5\6\u00bd\n\6\5\6\u00bf\n\6\3\6\3"+
		"\6\3\7\3\7\3\7\7\7\u00c6\n\7\f\7\16\7\u00c9\13\7\3\b\3\b\3\b\7\b\u00ce"+
		"\n\b\f\b\16\b\u00d1\13\b\3\t\5\t\u00d4\n\t\3\t\3\t\3\t\7\t\u00d9\n\t\f"+
		"\t\16\t\u00dc\13\t\3\t\3\t\3\n\7\n\u00e1\n\n\f\n\16\n\u00e4\13\n\3\n\5"+
		"\n\u00e7\n\n\3\n\5\n\u00ea\n\n\3\n\5\n\u00ed\n\n\3\n\3\n\3\n\3\n\5\n\u00f3"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00fc\n\n\f\n\16\n\u00ff\13\n\5\n"+
		"\u0101\n\n\3\n\3\n\3\n\3\n\3\n\7\n\u0108\n\n\f\n\16\n\u010b\13\n\5\n\u010d"+
		"\n\n\3\n\3\n\5\n\u0111\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u011d\n\13\f\13\16\13\u0120\13\13\3\13\5\13\u0123\n\13\3\13"+
		"\5\13\u0126\n\13\3\f\3\f\3\f\5\f\u012b\n\f\3\f\3\f\3\f\3\f\5\f\u0131\n"+
		"\f\7\f\u0133\n\f\f\f\16\f\u0136\13\f\3\r\3\r\7\r\u013a\n\r\f\r\16\r\u013d"+
		"\13\r\3\r\3\r\3\r\5\r\u0142\n\r\3\r\3\r\3\r\3\r\7\r\u0148\n\r\f\r\16\r"+
		"\u014b\13\r\3\r\3\r\5\r\u014f\n\r\3\r\5\r\u0152\n\r\3\16\3\16\5\16\u0156"+
		"\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\7\21\u0161\n\21\f\21"+
		"\16\21\u0164\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u016d\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u017f\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\7\27\u018b\n\27\f\27\16\27\u018e\13\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u019b\n\30\f\30\16\30\u019e\13\30"+
		"\3\30\3\30\5\30\u01a2\n\30\3\31\3\31\5\31\u01a6\n\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01b2\n\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u01be\n\34\3\34\3\34\5\34\u01c2\n"+
		"\34\3\34\3\34\3\34\3\34\5\34\u01c8\n\34\5\34\u01ca\n\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3!\3!\3!\3!\5!\u01e4\n!\3!\3!\5!\u01e8\n!\3!\3!\5!\u01ec\n!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01f7\n\"\3\"\3\"\3\"\3\"\3#\3#\3#\7#\u0200"+
		"\n#\f#\16#\u0203\13#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u021f\n%\3%\3%\3%\3%\3%\3%\3%\3%\7%\u0229"+
		"\n%\f%\16%\u022c\13%\3%\3%\3%\3%\3%\5%\u0233\n%\3%\3%\3%\3%\5%\u0239\n"+
		"%\3%\3%\3%\3%\7%\u023f\n%\f%\16%\u0242\13%\5%\u0244\n%\3%\3%\3%\3%\5%"+
		"\u024a\n%\3%\3%\3%\3%\7%\u0250\n%\f%\16%\u0253\13%\5%\u0255\n%\3%\3%\3"+
		"%\3%\3%\3%\3%\7%\u025e\n%\f%\16%\u0261\13%\5%\u0263\n%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\7%\u0275\n%\f%\16%\u0278\13%\5%\u027a"+
		"\n%\3%\3%\5%\u027e\n%\3%\3%\3%\3%\3%\5%\u0285\n%\3%\3%\7%\u0289\n%\f%"+
		"\16%\u028c\13%\3%\3%\5%\u0290\n%\3%\3%\5%\u0294\n%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\5%\u02a4\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\7%\u02c9\n%\f%\16%\u02cc\13%\5%\u02ce\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\7%\u02e0\n%\f%\16%\u02e3\13%\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\5&\u02ef\n&\3\'\6\'\u02f2\n\'\r\'\16\'\u02f3\3\'\2\4\26H(\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"\2\21\4\2\34\34\63\63\n\2\16\16\20\20\23\23\31\31\37\37&&((;;\3\2\6\7"+
		"\3\2]^\3\2[\\\3\2QR\4\2\63\63\66\66\4\2_`dd\4\2OPVW\4\2UUXX\3\2YZ\4\2"+
		"NNeo\4\2\t\nMM\4\2\t\tMM\5\2\35\35,.\61\61\u0364\2Q\3\2\2\2\4^\3\2\2\2"+
		"\6e\3\2\2\2\bk\3\2\2\2\n\u00be\3\2\2\2\f\u00c2\3\2\2\2\16\u00cf\3\2\2"+
		"\2\20\u00d3\3\2\2\2\22\u00e2\3\2\2\2\24\u0112\3\2\2\2\26\u012a\3\2\2\2"+
		"\30\u013b\3\2\2\2\32\u0155\3\2\2\2\34\u0157\3\2\2\2\36\u015b\3\2\2\2 "+
		"\u015d\3\2\2\2\"\u0165\3\2\2\2$\u017e\3\2\2\2&\u0180\3\2\2\2(\u0182\3"+
		"\2\2\2*\u0184\3\2\2\2,\u0188\3\2\2\2.\u0191\3\2\2\2\60\u01a3\3\2\2\2\62"+
		"\u01a9\3\2\2\2\64\u01b6\3\2\2\2\66\u01c9\3\2\2\28\u01cb\3\2\2\2:\u01ce"+
		"\3\2\2\2<\u01d1\3\2\2\2>\u01d7\3\2\2\2@\u01df\3\2\2\2B\u01f0\3\2\2\2D"+
		"\u01fc\3\2\2\2F\u0204\3\2\2\2H\u0293\3\2\2\2J\u02ee\3\2\2\2L\u02f1\3\2"+
		"\2\2NP\5\4\3\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RW\3\2\2\2SQ\3\2"+
		"\2\2TV\5\n\6\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\\\3\2\2\2YW\3"+
		"\2\2\2Z]\5\b\5\2[]\5\6\4\2\\Z\3\2\2\2\\[\3\2\2\2]\3\3\2\2\2^_\7t\2\2_"+
		"\5\3\2\2\2`d\5\22\n\2ad\5$\23\2bd\5\b\5\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2"+
		"\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\7\3\2\2\2ge\3\2\2\2hj\5\24\13\2ih\3"+
		"\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2\2\2np\5L\'\2on\3"+
		"\2\2\2op\3\2\2\2p\177\3\2\2\2q|\7\24\2\2rs\7P\2\2sx\7q\2\2tu\7L\2\2uw"+
		"\7q\2\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{}"+
		"\7O\2\2|r\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~\u0080\7\'\2\2\177q\3\2\2\2"+
		"\177~\3\2\2\2\u0080\u0082\3\2\2\2\u0081\u0083\7q\2\2\u0082\u0081\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0085\7\34\2\2\u0085"+
		"\u0087\5\30\r\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0091\3"+
		"\2\2\2\u0088\u0089\7#\2\2\u0089\u008e\5\30\r\2\u008a\u008b\7L\2\2\u008b"+
		"\u008d\5\30\r\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0088\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7G"+
		"\2\2\u0094\u0095\5\16\b\2\u0095\u0096\7H\2\2\u0096\t\3\2\2\2\u0097\u0099"+
		"\7$\2\2\u0098\u009a\7x\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u00a0\7q\2\2\u009c\u009d\7x\2\2\u009d\u009f\7q\2"+
		"\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00aa\7x\2\2\u00a4"+
		"\u00a7\7q\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a8\7q\2\2\u00a7\u00a5\3\2\2"+
		"\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\7_\2\2\u00aa\u00a4"+
		"\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00bf\3\2\2\2\u00ac\u00ad\7$\2\2\u00ad"+
		"\u00b2\7q\2\2\u00ae\u00af\7M\2\2\u00af\u00b1\7q\2\2\u00b0\u00ae\3\2\2"+
		"\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00bc\7M\2\2\u00b6\u00b9\7q\2\2\u00b7"+
		"\u00b8\7\4\2\2\u00b8\u00ba\7q\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00bd\7_\2\2\u00bc\u00b6\3\2\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u0097\3\2\2\2\u00be\u00ac\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7K\2\2\u00c1\13\3\2\2\2\u00c2\u00c7"+
		"\7q\2\2\u00c3\u00c4\7M\2\2\u00c4\u00c6\7q\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\r\3\2\2\2"+
		"\u00c9\u00c7\3\2\2\2\u00ca\u00ce\5\20\t\2\u00cb\u00ce\5\22\n\2\u00cc\u00ce"+
		"\5\b\5\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\17\3\2\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\5L\'\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00da\5\66\34\2\u00d6\u00d7\7L\2\2"+
		"\u00d7\u00d9\5\66\34\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00de\7K\2\2\u00de\21\3\2\2\2\u00df\u00e1\5\24\13\2\u00e0\u00df\3\2\2"+
		"\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\7\13\2\2\u00e6\u00e5\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00ea\7\27\2\2\u00e9\u00e8"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00ed\5L\'\2\u00ec"+
		"\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f2\3\2\2\2\u00ee\u00ef\5\26"+
		"\f\2\u00ef\u00f0\7q\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00f3\7\5\2\2\u00f2"+
		"\u00ee\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u0100\7E"+
		"\2\2\u00f5\u00f6\5\26\f\2\u00f6\u00fd\7q\2\2\u00f7\u00f8\7L\2\2\u00f8"+
		"\u00f9\5\26\f\2\u00f9\u00fa\7q\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f7\3\2"+
		"\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u00f5\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u010c\7F\2\2\u0103\u0104\78\2\2\u0104\u0109"+
		"\7q\2\2\u0105\u0106\7L\2\2\u0106\u0108\7q\2\2\u0107\u0105\3\2\2\2\u0108"+
		"\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010d\3\2"+
		"\2\2\u010b\u0109\3\2\2\2\u010c\u0103\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u0110\3\2\2\2\u010e\u0111\5,\27\2\u010f\u0111\7K\2\2\u0110\u010e\3\2"+
		"\2\2\u0110\u010f\3\2\2\2\u0111\23\3\2\2\2\u0112\u0113\7r\2\2\u0113\u0125"+
		"\7q\2\2\u0114\u0122\7E\2\2\u0115\u0116\7q\2\2\u0116\u0117\7N\2\2\u0117"+
		"\u011e\5J&\2\u0118\u0119\7L\2\2\u0119\u011a\7q\2\2\u011a\u011b\7N\2\2"+
		"\u011b\u011d\5J&\2\u011c\u0118\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0123\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"\u0123\5J&\2\u0122\u0115\3\2\2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2"+
		"\2\u0123\u0124\3\2\2\2\u0124\u0126\7F\2\2\u0125\u0114\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\25\3\2\2\2\u0127\u0128\b\f\1\2\u0128\u012b\5\30\r\2\u0129"+
		"\u012b\5\36\20\2\u012a\u0127\3\2\2\2\u012a\u0129\3\2\2\2\u012b\u0134\3"+
		"\2\2\2\u012c\u012d\f\3\2\2\u012d\u012e\7I\2\2\u012e\u0130\7J\2\2\u012f"+
		"\u0131\7S\2\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2"+
		"\2\2\u0132\u012c\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\27\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\7q\2\2"+
		"\u0138\u013a\7x\2\2\u0139\u0137\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"\u0141\7q\2\2\u013f\u0140\7\3\2\2\u0140\u0142\7q\2\2\u0141\u013f\3\2\2"+
		"\2\u0141\u0142\3\2\2\2\u0142\u014e\3\2\2\2\u0143\u0144\7P\2\2\u0144\u0149"+
		"\5\32\16\2\u0145\u0146\7L\2\2\u0146\u0148\5\32\16\2\u0147\u0145\3\2\2"+
		"\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c"+
		"\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7O\2\2\u014d\u014f\3\2\2\2\u014e"+
		"\u0143\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u0152\7S"+
		"\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\31\3\2\2\2\u0153\u0156"+
		"\5\26\f\2\u0154\u0156\5\34\17\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2"+
		"\2\u0156\33\3\2\2\2\u0157\u0158\7S\2\2\u0158\u0159\t\2\2\2\u0159\u015a"+
		"\5\30\r\2\u015a\35\3\2\2\2\u015b\u015c\t\3\2\2\u015c\37\3\2\2\2\u015d"+
		"\u0162\5\66\34\2\u015e\u015f\7L\2\2\u015f\u0161\5\66\34\2\u0160\u015e"+
		"\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"!\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7!\2\2\u0166\u0167\7E\2\2\u0167"+
		"\u0168\5H%\2\u0168\u0169\7F\2\2\u0169\u016c\5$\23\2\u016a\u016b\7\32\2"+
		"\2\u016b\u016d\5$\23\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d#"+
		"\3\2\2\2\u016e\u017f\5&\24\2\u016f\u017f\5,\27\2\u0170\u017f\5\64\33\2"+
		"\u0171\u017f\5\62\32\2\u0172\u017f\5F$\2\u0173\u017f\5\"\22\2\u0174\u017f"+
		"\5<\37\2\u0175\u017f\5> \2\u0176\u017f\5@!\2\u0177\u017f\5B\"\2\u0178"+
		"\u017f\58\35\2\u0179\u017f\5:\36\2\u017a\u017f\5\60\31\2\u017b\u017f\5"+
		".\30\2\u017c\u017f\5*\26\2\u017d\u017f\5(\25\2\u017e\u016e\3\2\2\2\u017e"+
		"\u016f\3\2\2\2\u017e\u0170\3\2\2\2\u017e\u0171\3\2\2\2\u017e\u0172\3\2"+
		"\2\2\u017e\u0173\3\2\2\2\u017e\u0174\3\2\2\2\u017e\u0175\3\2\2\2\u017e"+
		"\u0176\3\2\2\2\u017e\u0177\3\2\2\2\u017e\u0178\3\2\2\2\u017e\u0179\3\2"+
		"\2\2\u017e\u017a\3\2\2\2\u017e\u017b\3\2\2\2\u017e\u017c\3\2\2\2\u017e"+
		"\u017d\3\2\2\2\u017f%\3\2\2\2\u0180\u0181\7K\2\2\u0181\'\3\2\2\2\u0182"+
		"\u0183\5H%\2\u0183)\3\2\2\2\u0184\u0185\7\67\2\2\u0185\u0186\5H%\2\u0186"+
		"\u0187\7K\2\2\u0187+\3\2\2\2\u0188\u018c\7G\2\2\u0189\u018b\5$\23\2\u018a"+
		"\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u018f\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\7H\2\2\u0190"+
		"-\3\2\2\2\u0191\u0192\7:\2\2\u0192\u019c\5,\27\2\u0193\u0194\7\22\2\2"+
		"\u0194\u0195\7E\2\2\u0195\u0196\5\30\r\2\u0196\u0197\7q\2\2\u0197\u0198"+
		"\7F\2\2\u0198\u0199\5,\27\2\u0199\u019b\3\2\2\2\u019a\u0193\3\2\2\2\u019b"+
		"\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a1\3\2"+
		"\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\7\36\2\2\u01a0\u01a2\5,\27\2\u01a1"+
		"\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2/\3\2\2\2\u01a3\u01a5\7/\2\2\u01a4"+
		"\u01a6\5H%\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\3\2\2"+
		"\2\u01a7\u01a8\7K\2\2\u01a8\61\3\2\2\2\u01a9\u01aa\5H%\2\u01aa\u01b1\7"+
		"!\2\2\u01ab\u01b2\7U\2\2\u01ac\u01b2\7P\2\2\u01ad\u01b2\7O\2\2\u01ae\u01b2"+
		"\7X\2\2\u01af\u01b2\7W\2\2\u01b0\u01b2\7V\2\2\u01b1\u01ab\3\2\2\2\u01b1"+
		"\u01ac\3\2\2\2\u01b1\u01ad\3\2\2\2\u01b1\u01ae\3\2\2\2\u01b1\u01af\3\2"+
		"\2\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01b4\5H%\2\u01b4\u01b5\7K\2\2\u01b5\63\3\2\2\2\u01b6\u01b7\5 \21\2\u01b7"+
		"\u01b8\7K\2\2\u01b8\65\3\2\2\2\u01b9\u01ba\t\4\2\2\u01ba\u01bd\7q\2\2"+
		"\u01bb\u01bc\7\4\2\2\u01bc\u01be\5\26\f\2\u01bd\u01bb\3\2\2\2\u01bd\u01be"+
		"\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01c0\7N\2\2\u01c0\u01c2\5H%\2\u01c1"+
		"\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01ca\3\2\2\2\u01c3\u01c4\5\26"+
		"\f\2\u01c4\u01c7\7q\2\2\u01c5\u01c6\7N\2\2\u01c6\u01c8\5H%\2\u01c7\u01c5"+
		"\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01b9\3\2\2\2\u01c9"+
		"\u01c3\3\2\2\2\u01ca\67\3\2\2\2\u01cb\u01cc\7\17\2\2\u01cc\u01cd\7K\2"+
		"\2\u01cd9\3\2\2\2\u01ce\u01cf\7\26\2\2\u01cf\u01d0\7K\2\2\u01d0;\3\2\2"+
		"\2\u01d1\u01d2\7=\2\2\u01d2\u01d3\7E\2\2\u01d3\u01d4\5H%\2\u01d4\u01d5"+
		"\7F\2\2\u01d5\u01d6\5$\23\2\u01d6=\3\2\2\2\u01d7\u01d8\7\30\2\2\u01d8"+
		"\u01d9\5,\27\2\u01d9\u01da\7=\2\2\u01da\u01db\7E\2\2\u01db\u01dc\5H%\2"+
		"\u01dc\u01dd\7F\2\2\u01dd\u01de\7K\2\2\u01de?\3\2\2\2\u01df\u01e0\7 \2"+
		"\2\u01e0\u01e3\7E\2\2\u01e1\u01e4\5 \21\2\u01e2\u01e4\5D#\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01e7\7K\2\2\u01e6\u01e8\5H%\2\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3\2\2"+
		"\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\7K\2\2\u01ea\u01ec\5D#\2\u01eb\u01ea"+
		"\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\7F\2\2\u01ee"+
		"\u01ef\5$\23\2\u01efA\3\2\2\2\u01f0\u01f1\7\b\2\2\u01f1\u01f2\7E\2\2\u01f2"+
		"\u01f3\5H%\2\u01f3\u01f6\7\4\2\2\u01f4\u01f5\7q\2\2\u01f5\u01f7\7L\2\2"+
		"\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9"+
		"\7q\2\2\u01f9\u01fa\7F\2\2\u01fa\u01fb\5$\23\2\u01fbC\3\2\2\2\u01fc\u0201"+
		"\5H%\2\u01fd\u01fe\7L\2\2\u01fe\u0200\5H%\2\u01ff\u01fd\3\2\2\2\u0200"+
		"\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202E\3\2\2\2"+
		"\u0203\u0201\3\2\2\2\u0204\u0205\5H%\2\u0205\u0206\7K\2\2\u0206G\3\2\2"+
		"\2\u0207\u0208\b%\1\2\u0208\u0209\t\5\2\2\u0209\u0294\5H%\25\u020a\u020b"+
		"\t\6\2\2\u020b\u0294\5H%\24\u020c\u020d\t\7\2\2\u020d\u0294\5H%\23\u020e"+
		"\u020f\7E\2\2\u020f\u0210\5\26\f\2\u0210\u0211\7F\2\2\u0211\u0212\5H%"+
		"\22\u0212\u0294\3\2\2\2\u0213\u0214\7E\2\2\u0214\u0215\5H%\2\u0215\u0216"+
		"\7F\2\2\u0216\u0294\3\2\2\2\u0217\u0294\t\b\2\2\u0218\u0294\5J&\2\u0219"+
		"\u021a\7P\2\2\u021a\u021b\7q\2\2\u021b\u021c\7L\2\2\u021c\u021d\7q\2\2"+
		"\u021d\u021f\7O\2\2\u021e\u0219\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0232"+
		"\3\2\2\2\u0220\u0221\7I\2\2\u0221\u0222\7q\2\2\u0222\u0223\7T\2\2\u0223"+
		"\u022a\5H%\2\u0224\u0225\7L\2\2\u0225\u0226\7q\2\2\u0226\u0227\7T\2\2"+
		"\u0227\u0229\5H%\2\u0228\u0224\3\2\2\2\u0229\u022c\3\2\2\2\u022a\u0228"+
		"\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022d\3\2\2\2\u022c\u022a\3\2\2\2\u022d"+
		"\u022e\7J\2\2\u022e\u0233\3\2\2\2\u022f\u0230\7I\2\2\u0230\u0231\7T\2"+
		"\2\u0231\u0233\7J\2\2\u0232\u0220\3\2\2\2\u0232\u022f\3\2\2\2\u0233\u0294"+
		"\3\2\2\2\u0234\u0235\7P\2\2\u0235\u0236\5\26\f\2\u0236\u0237\7O\2\2\u0237"+
		"\u0239\3\2\2\2\u0238\u0234\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\3\2"+
		"\2\2\u023a\u0243\7I\2\2\u023b\u0240\5H%\2\u023c\u023d\7L\2\2\u023d\u023f"+
		"\5H%\2\u023e\u023c\3\2\2\2\u023f\u0242\3\2\2\2\u0240\u023e\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2\2\2\u0243\u023b\3\2"+
		"\2\2\u0243\u0244\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0294\7J\2\2\u0246"+
		"\u024a\7q\2\2\u0247\u024a\7\66\2\2\u0248\u024a\7\63\2\2\u0249\u0246\3"+
		"\2\2\2\u0249\u0247\3\2\2\2\u0249\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b"+
		"\u0254\7E\2\2\u024c\u0251\5H%\2\u024d\u024e\7L\2\2\u024e\u0250\5H%\2\u024f"+
		"\u024d\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2"+
		"\2\2\u0252\u0255\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u024c\3\2\2\2\u0254"+
		"\u0255\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0294\7F\2\2\u0257\u0258\7*\2"+
		"\2\u0258\u0259\5\30\r\2\u0259\u0262\7E\2\2\u025a\u025f\5H%\2\u025b\u025c"+
		"\7L\2\2\u025c\u025e\5H%\2\u025d\u025b\3\2\2\2\u025e\u0261\3\2\2\2\u025f"+
		"\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0263\3\2\2\2\u0261\u025f\3\2"+
		"\2\2\u0262\u025a\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0264\3\2\2\2\u0264"+
		"\u0265\7F\2\2\u0265\u0294\3\2\2\2\u0266\u0267\7*\2\2\u0267\u0268\5\26"+
		"\f\2\u0268\u0269\7I\2\2\u0269\u026a\5H%\2\u026a\u026b\7J\2\2\u026b\u027e"+
		"\3\2\2\2\u026c\u026d\7*\2\2\u026d\u026e\5\26\f\2\u026e\u026f\7I\2\2\u026f"+
		"\u0270\7J\2\2\u0270\u0279\7G\2\2\u0271\u0276\5H%\2\u0272\u0273\7L\2\2"+
		"\u0273\u0275\5H%\2\u0274\u0272\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274"+
		"\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u027a\3\2\2\2\u0278\u0276\3\2\2\2\u0279"+
		"\u0271\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\7H"+
		"\2\2\u027c\u027e\3\2\2\2\u027d\u0266\3\2\2\2\u027d\u026c\3\2\2\2\u027e"+
		"\u0294\3\2\2\2\u027f\u0294\7q\2\2\u0280\u0281\7p\2\2\u0281\u028a\5H%\2"+
		"\u0282\u0284\7H\2\2\u0283\u0285\7{\2\2\u0284\u0283\3\2\2\2\u0284\u0285"+
		"\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0287\7y\2\2\u0287\u0289\5H%\2\u0288"+
		"\u0282\3\2\2\2\u0289\u028c\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2"+
		"\2\2\u028b\u028d\3\2\2\2\u028c\u028a\3\2\2\2\u028d\u028f\7H\2\2\u028e"+
		"\u0290\7{\2\2\u028f\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0291\3\2"+
		"\2\2\u0291\u0292\7z\2\2\u0292\u0294\3\2\2\2\u0293\u0207\3\2\2\2\u0293"+
		"\u020a\3\2\2\2\u0293\u020c\3\2\2\2\u0293\u020e\3\2\2\2\u0293\u0213\3\2"+
		"\2\2\u0293\u0217\3\2\2\2\u0293\u0218\3\2\2\2\u0293\u021e\3\2\2\2\u0293"+
		"\u0238\3\2\2\2\u0293\u0249\3\2\2\2\u0293\u0257\3\2\2\2\u0293\u027d\3\2"+
		"\2\2\u0293\u027f\3\2\2\2\u0293\u0280\3\2\2\2\u0294\u02e1\3\2\2\2\u0295"+
		"\u0296\f\21\2\2\u0296\u0297\t\t\2\2\u0297\u02e0\5H%\22\u0298\u0299\f\20"+
		"\2\2\u0299\u029a\t\5\2\2\u029a\u02e0\5H%\21\u029b\u02a3\f\17\2\2\u029c"+
		"\u029d\7P\2\2\u029d\u02a4\7P\2\2\u029e\u029f\7O\2\2\u029f\u02a0\7O\2\2"+
		"\u02a0\u02a4\7O\2\2\u02a1\u02a2\7O\2\2\u02a2\u02a4\7O\2\2\u02a3\u029c"+
		"\3\2\2\2\u02a3\u029e\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5"+
		"\u02e0\5H%\20\u02a6\u02a7\f\16\2\2\u02a7\u02a8\t\n\2\2\u02a8\u02e0\5H"+
		"%\17\u02a9\u02aa\f\f\2\2\u02aa\u02ab\t\13\2\2\u02ab\u02e0\5H%\r\u02ac"+
		"\u02ad\f\13\2\2\u02ad\u02ae\7a\2\2\u02ae\u02e0\5H%\f\u02af\u02b0\f\n\2"+
		"\2\u02b0\u02b1\7c\2\2\u02b1\u02e0\5H%\13\u02b2\u02b3\f\t\2\2\u02b3\u02b4"+
		"\7b\2\2\u02b4\u02e0\5H%\n\u02b5\u02b6\f\b\2\2\u02b6\u02b7\t\f\2\2\u02b7"+
		"\u02e0\5H%\t\u02b8\u02b9\f\7\2\2\u02b9\u02ba\7S\2\2\u02ba\u02bb\5H%\2"+
		"\u02bb\u02bc\7T\2\2\u02bc\u02bd\5H%\b\u02bd\u02e0\3\2\2\2\u02be\u02bf"+
		"\f\3\2\2\u02bf\u02c0\t\r\2\2\u02c0\u02e0\5H%\3\u02c1\u02c2\f\34\2\2\u02c2"+
		"\u02c3\t\16\2\2\u02c3\u02c4\7q\2\2\u02c4\u02cd\7E\2\2\u02c5\u02ca\5H%"+
		"\2\u02c6\u02c7\7L\2\2\u02c7\u02c9\5H%\2\u02c8\u02c6\3\2\2\2\u02c9\u02cc"+
		"\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02ce\3\2\2\2\u02cc"+
		"\u02ca\3\2\2\2\u02cd\u02c5\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\3\2"+
		"\2\2\u02cf\u02e0\7F\2\2\u02d0\u02d1\f\33\2\2\u02d1\u02d2\t\17\2\2\u02d2"+
		"\u02e0\7q\2\2\u02d3\u02d4\f\31\2\2\u02d4\u02d5\7I\2\2\u02d5\u02d6\5H%"+
		"\2\u02d6\u02d7\7J\2\2\u02d7\u02e0\3\2\2\2\u02d8\u02d9\f\26\2\2\u02d9\u02e0"+
		"\t\6\2\2\u02da\u02db\f\r\2\2\u02db\u02dc\7%\2\2\u02dc\u02e0\7q\2\2\u02dd"+
		"\u02de\f\5\2\2\u02de\u02e0\7M\2\2\u02df\u0295\3\2\2\2\u02df\u0298\3\2"+
		"\2\2\u02df\u029b\3\2\2\2\u02df\u02a6\3\2\2\2\u02df\u02a9\3\2\2\2\u02df"+
		"\u02ac\3\2\2\2\u02df\u02af\3\2\2\2\u02df\u02b2\3\2\2\2\u02df\u02b5\3\2"+
		"\2\2\u02df\u02b8\3\2\2\2\u02df\u02be\3\2\2\2\u02df\u02c1\3\2\2\2\u02df"+
		"\u02d0\3\2\2\2\u02df\u02d3\3\2\2\2\u02df\u02d8\3\2\2\2\u02df\u02da\3\2"+
		"\2\2\u02df\u02dd\3\2\2\2\u02e0\u02e3\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1"+
		"\u02e2\3\2\2\2\u02e2I\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e4\u02ef\7>\2\2\u02e5"+
		"\u02ef\7?\2\2\u02e6\u02ef\7A\2\2\u02e7\u02ef\7B\2\2\u02e8\u02ef\7C\2\2"+
		"\u02e9\u02ef\7@\2\2\u02ea\u02eb\7q\2\2\u02eb\u02ec\7M\2\2\u02ec\u02ef"+
		"\7\24\2\2\u02ed\u02ef\7D\2\2\u02ee\u02e4\3\2\2\2\u02ee\u02e5\3\2\2\2\u02ee"+
		"\u02e6\3\2\2\2\u02ee\u02e7\3\2\2\2\u02ee\u02e8\3\2\2\2\u02ee\u02e9\3\2"+
		"\2\2\u02ee\u02ea\3\2\2\2\u02ee\u02ed\3\2\2\2\u02efK\3\2\2\2\u02f0\u02f2"+
		"\t\20\2\2\u02f1\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f1\3\2\2\2"+
		"\u02f3\u02f4\3\2\2\2\u02f4M\3\2\2\2]QW\\cekox|\177\u0082\u0086\u008e\u0091"+
		"\u0099\u00a0\u00a7\u00aa\u00b2\u00b9\u00bc\u00be\u00c7\u00cd\u00cf\u00d3"+
		"\u00da\u00e2\u00e6\u00e9\u00ec\u00f2\u00fd\u0100\u0109\u010c\u0110\u011e"+
		"\u0122\u0125\u012a\u0130\u0134\u013b\u0141\u0149\u014e\u0151\u0155\u0162"+
		"\u016c\u017e\u018c\u019c\u01a1\u01a5\u01b1\u01bd\u01c1\u01c7\u01c9\u01e3"+
		"\u01e7\u01eb\u01f6\u0201\u021e\u022a\u0232\u0238\u0240\u0243\u0249\u0251"+
		"\u0254\u025f\u0262\u0276\u0279\u027d\u0284\u028a\u028f\u0293\u02a3\u02ca"+
		"\u02cd\u02df\u02e1\u02ee\u02f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
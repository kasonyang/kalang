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
		AS=1, CONSTRUCTOR=2, VAR=3, VAL=4, FOREACH=5, ARROW=6, START_DOT=7, OVERRIDE=8, 
		ABSTRACT=9, ASSERT=10, BOOLEAN=11, BREAK=12, BYTE=13, CASE=14, CATCH=15, 
		CHAR=16, CLASS=17, CONST=18, CONTINUE=19, DEFAULT=20, DO=21, DOUBLE=22, 
		ELSE=23, ENUM=24, EXTENDS=25, FINAL=26, FINALLY=27, FLOAT=28, FOR=29, 
		IF=30, GOTO=31, IMPLEMENTS=32, IMPORT=33, INSTANCEOF=34, INT=35, INTERFACE=36, 
		LONG=37, NATIVE=38, NEW=39, PACKAGE=40, PRIVATE=41, PROTECTED=42, PUBLIC=43, 
		RETURN=44, SHORT=45, STATIC=46, STRICTFP=47, SUPER=48, SWITCH=49, SYNCHRONIZED=50, 
		THIS=51, THROW=52, THROWS=53, TRANSIENT=54, TRY=55, VOID=56, VOLATILE=57, 
		WHILE=58, IntegerLiteral=59, FloatingPointLiteral=60, BooleanLiteral=61, 
		CharacterLiteral=62, StringLiteral=63, MultiLineStringLiteral=64, NullLiteral=65, 
		LPAREN=66, RPAREN=67, LBRACE=68, RBRACE=69, LBRACK=70, RBRACK=71, SEMI=72, 
		COMMA=73, DOT=74, ASSIGN=75, GT=76, LT=77, BANG=78, TILDE=79, QUESTION=80, 
		COLON=81, EQUAL=82, LE=83, GE=84, NOTEQUAL=85, AND=86, OR=87, INC=88, 
		DEC=89, ADD=90, SUB=91, MUL=92, DIV=93, BITAND=94, BITOR=95, CARET=96, 
		MOD=97, ADD_ASSIGN=98, SUB_ASSIGN=99, MUL_ASSIGN=100, DIV_ASSIGN=101, 
		AND_ASSIGN=102, OR_ASSIGN=103, XOR_ASSIGN=104, MOD_ASSIGN=105, LSHIFT_ASSIGN=106, 
		RSHIFT_ASSIGN=107, URSHIFT_ASSIGN=108, InterpolationPreffixString=109, 
		Identifier=110, AT=111, ELLIPSIS=112, WS=113, COMMENT=114, LINE_COMMENT=115, 
		PACKAGE_DELIMITER=116, INTERPOLATION_INTERUPT=117, INTERPOLATION_END=118, 
		INTERPOLATION_STRING=119;
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
		null, "'as'", "'constructor'", "'var'", "'val'", "'foreach'", "'->'", 
		"'*.'", "'override'", "'abstract'", "'assert'", "'boolean'", "'break'", 
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
		"'>>='", "'>>>='", null, null, "'@'", "'...'", null, null, null, "'\\'", 
		"'${'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AS", "CONSTRUCTOR", "VAR", "VAL", "FOREACH", "ARROW", "START_DOT", 
		"OVERRIDE", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", 
		"CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", 
		"ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
		"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", 
		"NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", 
		"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
		"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
		"MultiLineStringLiteral", "NullLiteral", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", 
		"LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", 
		"AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", 
		"CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
		"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "InterpolationPreffixString", "Identifier", 
		"AT", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT", "PACKAGE_DELIMITER", 
		"INTERPOLATION_INTERUPT", "INTERPOLATION_END", "INTERPOLATION_STRING"
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
		enterRule(_localctx, 2, RULE_scriptDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << STATIC) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)) | (1L << (AT - 64)))) != 0)) {
				{
				setState(85);
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
				case 3:
					{
					setState(84);
					classDef();
					}
					break;
				}
				}
				setState(89);
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
		enterRule(_localctx, 4, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(90);
				annotation();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				setState(96);
				varModifier();
				}
			}

			setState(113);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(99);
				((ClassDefContext)_localctx).classKind = match(CLASS);
				setState(110);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(100);
					match(LT);
					setState(101);
					((ClassDefContext)_localctx).Identifier = match(Identifier);
					((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(102);
						match(COMMA);
						setState(103);
						((ClassDefContext)_localctx).Identifier = match(Identifier);
						((ClassDefContext)_localctx).genericTypes.add(((ClassDefContext)_localctx).Identifier);
						}
						}
						setState(108);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(109);
					match(GT);
					}
				}

				}
				break;
			case INTERFACE:
				{
				setState(112);
				((ClassDefContext)_localctx).classKind = match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(116);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(115);
				((ClassDefContext)_localctx).name = match(Identifier);
				}
			}

			setState(120);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(118);
				match(EXTENDS);
				setState(119);
				((ClassDefContext)_localctx).parentClass = classType();
				}
			}

			setState(131);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(122);
				match(IMPLEMENTS);
				setState(123);
				((ClassDefContext)_localctx).classType = classType();
				((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(124);
					match(COMMA);
					setState(125);
					((ClassDefContext)_localctx).classType = classType();
					((ClassDefContext)_localctx).interfaces.add(((ClassDefContext)_localctx).classType);
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(133);
			match(LBRACE);
			setState(134);
			classBody();
			setState(135);
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
		enterRule(_localctx, 6, RULE_importDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(137);
				match(IMPORT);
				setState(139);
				_la = _input.LA(1);
				if (_la==PACKAGE_DELIMITER) {
					{
					setState(138);
					((ImportDeclContext)_localctx).root = match(PACKAGE_DELIMITER);
					}
				}

				setState(141);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(142);
						match(PACKAGE_DELIMITER);
						setState(143);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(148);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(149);
				((ImportDeclContext)_localctx).delim = match(PACKAGE_DELIMITER);
				setState(156);
				switch (_input.LA(1)) {
				case Identifier:
					{
					{
					setState(150);
					((ImportDeclContext)_localctx).name = match(Identifier);
					setState(153);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(151);
						match(AS);
						setState(152);
						((ImportDeclContext)_localctx).alias = match(Identifier);
						}
					}

					}
					}
					break;
				case MUL:
					{
					{
					setState(155);
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
				setState(158);
				match(IMPORT);
				setState(159);
				((ImportDeclContext)_localctx).Identifier = match(Identifier);
				((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(160);
						match(DOT);
						setState(161);
						((ImportDeclContext)_localctx).Identifier = match(Identifier);
						((ImportDeclContext)_localctx).path.add(((ImportDeclContext)_localctx).Identifier);
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(167);
				((ImportDeclContext)_localctx).delim = match(DOT);
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
			}
			setState(178);
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
		enterRule(_localctx, 8, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(Identifier);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(181);
				match(DOT);
				setState(182);
				match(Identifier);
				}
				}
				setState(187);
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
		enterRule(_localctx, 10, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRUCTOR) | (1L << VAR) | (1L << VAL) | (1L << OVERRIDE) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << VOID))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(191);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(188);
					fieldDecl();
					}
					break;
				case 2:
					{
					setState(189);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(190);
					classDef();
					}
					break;
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
			case CONSTRUCTOR:
				{
				{
				setState(227);
				((MethodDeclContext)_localctx).prefix = match(CONSTRUCTOR);
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
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
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
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
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
		enterRule(_localctx, 20, RULE_classType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(297);
					((ClassTypeContext)_localctx).Identifier = match(Identifier);
					((ClassTypeContext)_localctx).paths.add(((ClassTypeContext)_localctx).Identifier);
					setState(298);
					match(PACKAGE_DELIMITER);
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(304);
			((ClassTypeContext)_localctx).rawClass = match(Identifier);
			setState(316);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(305);
				match(LT);
				setState(306);
				((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
				((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(307);
					match(COMMA);
					setState(308);
					((ClassTypeContext)_localctx).parameterizedElementType = parameterizedElementType();
					((ClassTypeContext)_localctx).parameterTypes.add(((ClassTypeContext)_localctx).parameterizedElementType);
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(314);
				match(GT);
				}
				break;
			}
			setState(319);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(318);
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
		enterRule(_localctx, 22, RULE_parameterizedElementType);
		try {
			setState(323);
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
				setState(321);
				type(0);
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
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
		enterRule(_localctx, 24, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(QUESTION);
			setState(326);
			((WildcardTypeContext)_localctx).boundKind = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
				((WildcardTypeContext)_localctx).boundKind = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(327);
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
		enterRule(_localctx, 26, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
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
		enterRule(_localctx, 28, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			varDecl();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(332);
				match(COMMA);
				setState(333);
				varDecl();
				}
				}
				setState(338);
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
		enterRule(_localctx, 30, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(IF);
			setState(340);
			match(LPAREN);
			setState(341);
			expression(0);
			setState(342);
			match(RPAREN);
			setState(343);
			((IfStatContext)_localctx).trueStmt = stat();
			setState(346);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(344);
				match(ELSE);
				setState(345);
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
		enterRule(_localctx, 32, RULE_stat);
		try {
			setState(363);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				varDeclStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				postIfStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				exprStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				ifStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(353);
				whileStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(354);
				doWhileStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(355);
				forStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(356);
				forEachStat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(357);
				breakStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(358);
				continueStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(359);
				returnStat();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(360);
				tryStat();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(361);
				throwStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(362);
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
		enterRule(_localctx, 34, RULE_errorousStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
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
		enterRule(_localctx, 36, RULE_throwStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(THROW);
			setState(368);
			expression(0);
			setState(369);
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
		enterRule(_localctx, 38, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(LBRACE);
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << FOREACH) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << RETURN) | (1L << SUPER) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(372);
				stat();
				}
				}
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(378);
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
		enterRule(_localctx, 40, RULE_tryStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(TRY);
			setState(381);
			((TryStatContext)_localctx).exec = blockStmt();
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(382);
				match(CATCH);
				setState(383);
				match(LPAREN);
				setState(384);
				((TryStatContext)_localctx).classType = classType();
				((TryStatContext)_localctx).catchTypes.add(((TryStatContext)_localctx).classType);
				setState(385);
				((TryStatContext)_localctx).Identifier = match(Identifier);
				((TryStatContext)_localctx).catchVarNames.add(((TryStatContext)_localctx).Identifier);
				setState(386);
				match(RPAREN);
				setState(387);
				((TryStatContext)_localctx).blockStmt = blockStmt();
				((TryStatContext)_localctx).catchExec.add(((TryStatContext)_localctx).blockStmt);
				}
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(396);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(394);
				match(FINALLY);
				setState(395);
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
		enterRule(_localctx, 42, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(RETURN);
			setState(400);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(399);
				expression(0);
				}
			}

			setState(402);
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
		enterRule(_localctx, 44, RULE_postIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			expression(0);
			setState(405);
			match(IF);
			setState(412);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(406);
				((PostIfStmtContext)_localctx).op = match(EQUAL);
				}
				break;
			case 2:
				{
				setState(407);
				((PostIfStmtContext)_localctx).op = match(LT);
				}
				break;
			case 3:
				{
				setState(408);
				((PostIfStmtContext)_localctx).op = match(GT);
				}
				break;
			case 4:
				{
				setState(409);
				((PostIfStmtContext)_localctx).op = match(NOTEQUAL);
				}
				break;
			case 5:
				{
				setState(410);
				((PostIfStmtContext)_localctx).op = match(GE);
				}
				break;
			case 6:
				{
				setState(411);
				((PostIfStmtContext)_localctx).op = match(LE);
				}
				break;
			}
			setState(414);
			expression(0);
			setState(415);
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
		enterRule(_localctx, 46, RULE_varDeclStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			localVarDecl();
			setState(418);
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
		enterRule(_localctx, 48, RULE_varDecl);
		int _la;
		try {
			setState(436);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(420);
				_la = _input.LA(1);
				if ( !(_la==VAR || _la==VAL) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(421);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(424);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(422);
					match(AS);
					setState(423);
					type(0);
					}
				}

				setState(428);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(426);
					match(ASSIGN);
					setState(427);
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
				setState(430);
				((VarDeclContext)_localctx).varType = type(0);
				setState(431);
				((VarDeclContext)_localctx).name = match(Identifier);
				setState(434);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(432);
					match(ASSIGN);
					setState(433);
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
		enterRule(_localctx, 50, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(BREAK);
			setState(439);
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
		enterRule(_localctx, 52, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			match(CONTINUE);
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
		enterRule(_localctx, 54, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(WHILE);
			setState(445);
			match(LPAREN);
			setState(446);
			expression(0);
			setState(447);
			match(RPAREN);
			setState(448);
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
		enterRule(_localctx, 56, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(DO);
			setState(451);
			blockStmt();
			setState(452);
			match(WHILE);
			setState(453);
			match(LPAREN);
			setState(454);
			expression(0);
			setState(455);
			match(RPAREN);
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
		enterRule(_localctx, 58, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(FOR);
			setState(459);
			match(LPAREN);
			setState(461);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << VOID))) != 0) || _la==Identifier) {
				{
				setState(460);
				localVarDecl();
				}
			}

			setState(463);
			match(SEMI);
			setState(465);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(464);
				expression(0);
				}
			}

			setState(467);
			match(SEMI);
			setState(469);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(468);
				expressions();
				}
			}

			setState(471);
			match(RPAREN);
			setState(472);
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
		enterRule(_localctx, 60, RULE_forEachStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(FOREACH);
			setState(475);
			match(LPAREN);
			setState(476);
			expression(0);
			setState(477);
			match(AS);
			setState(480);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(478);
				match(Identifier);
				setState(479);
				match(COMMA);
				}
				break;
			}
			setState(482);
			match(Identifier);
			setState(483);
			match(RPAREN);
			setState(484);
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
		enterRule(_localctx, 62, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			expression(0);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(487);
				match(COMMA);
				setState(488);
				expression(0);
				}
				}
				setState(493);
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
		enterRule(_localctx, 64, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			expression(0);
			setState(495);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(498);
				match(LPAREN);
				setState(499);
				type(0);
				setState(500);
				match(RPAREN);
				setState(501);
				expression(20);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(504);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new PreIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				((PreIncExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(506);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(507);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(508);
				expression(16);
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(509);
				match(LPAREN);
				setState(510);
				expression(0);
				setState(511);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SelfRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(513);
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
				setState(514);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new MapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(520);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(515);
					match(LT);
					setState(516);
					((MapExprContext)_localctx).keyType = match(Identifier);
					setState(517);
					match(COMMA);
					setState(518);
					((MapExprContext)_localctx).valueType = match(Identifier);
					setState(519);
					match(GT);
					}
				}

				setState(540);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(522);
					match(LBRACK);
					setState(523);
					((MapExprContext)_localctx).Identifier = match(Identifier);
					((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
					setState(524);
					match(COLON);
					setState(525);
					((MapExprContext)_localctx).expression = expression(0);
					((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(526);
						match(COMMA);
						setState(527);
						((MapExprContext)_localctx).Identifier = match(Identifier);
						((MapExprContext)_localctx).keys.add(((MapExprContext)_localctx).Identifier);
						setState(528);
						match(COLON);
						setState(529);
						((MapExprContext)_localctx).expression = expression(0);
						((MapExprContext)_localctx).values.add(((MapExprContext)_localctx).expression);
						}
						}
						setState(534);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(535);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(537);
					match(LBRACK);
					setState(538);
					match(COLON);
					setState(539);
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
				setState(546);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(542);
					match(LT);
					setState(543);
					type(0);
					setState(544);
					match(GT);
					}
				}

				setState(548);
				match(LBRACK);
				setState(557);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(549);
					expression(0);
					setState(554);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(550);
						match(COMMA);
						setState(551);
						expression(0);
						}
						}
						setState(556);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(559);
				match(RBRACK);
				}
				break;
			case 10:
				{
				_localctx = new MemberInvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(563);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(560);
					match(Identifier);
					}
					break;
				case THIS:
					{
					setState(561);
					((MemberInvocationExprContext)_localctx).key = match(THIS);
					}
					break;
				case SUPER:
					{
					setState(562);
					((MemberInvocationExprContext)_localctx).key = match(SUPER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(565);
				match(LPAREN);
				setState(574);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(566);
					((MemberInvocationExprContext)_localctx).expression = expression(0);
					((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
					setState(571);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(567);
						match(COMMA);
						setState(568);
						((MemberInvocationExprContext)_localctx).expression = expression(0);
						((MemberInvocationExprContext)_localctx).params.add(((MemberInvocationExprContext)_localctx).expression);
						}
						}
						setState(573);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(576);
				match(RPAREN);
				}
				break;
			case 11:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(577);
				match(NEW);
				setState(578);
				classType();
				setState(579);
				match(LPAREN);
				setState(588);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(580);
					((NewExprContext)_localctx).expression = expression(0);
					((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(581);
						match(COMMA);
						setState(582);
						((NewExprContext)_localctx).expression = expression(0);
						((NewExprContext)_localctx).params.add(((NewExprContext)_localctx).expression);
						}
						}
						setState(587);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(590);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(615);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(592);
					match(NEW);
					setState(593);
					type(0);
					setState(594);
					match(LBRACK);
					setState(595);
					((NewArrayExprContext)_localctx).size = expression(0);
					setState(596);
					match(RBRACK);
					}
					break;
				case 2:
					{
					setState(598);
					match(NEW);
					setState(599);
					type(0);
					setState(600);
					match(LBRACK);
					setState(601);
					match(RBRACK);
					setState(602);
					match(LBRACE);
					setState(611);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
						{
						setState(603);
						((NewArrayExprContext)_localctx).expression = expression(0);
						((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
						setState(608);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(604);
							match(COMMA);
							setState(605);
							((NewArrayExprContext)_localctx).expression = expression(0);
							((NewArrayExprContext)_localctx).initExpr.add(((NewArrayExprContext)_localctx).expression);
							}
							}
							setState(610);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(613);
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
				setState(617);
				match(Identifier);
				}
				break;
			case 14:
				{
				_localctx = new InterpolationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(618);
				match(InterpolationPreffixString);
				setState(619);
				expression(0);
				setState(628);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(620);
						match(RBRACE);
						setState(622);
						_la = _input.LA(1);
						if (_la==INTERPOLATION_STRING) {
							{
							setState(621);
							match(INTERPOLATION_STRING);
							}
						}

						setState(624);
						match(INTERPOLATION_INTERUPT);
						setState(625);
						expression(0);
						}
						} 
					}
					setState(630);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				}
				setState(631);
				match(RBRACE);
				setState(633);
				_la = _input.LA(1);
				if (_la==INTERPOLATION_STRING) {
					{
					setState(632);
					match(INTERPOLATION_STRING);
					}
				}

				setState(635);
				match(INTERPOLATION_END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(715);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(713);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(639);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(640);
						_la = _input.LA(1);
						if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (MUL - 92)) | (1L << (DIV - 92)) | (1L << (MOD - 92)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(641);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(642);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(643);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(644);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new BitShiftExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(645);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(653);
						switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
						case 1:
							{
							setState(646);
							((BitShiftExprContext)_localctx).left = match(LT);
							setState(647);
							((BitShiftExprContext)_localctx).stop = match(LT);
							}
							break;
						case 2:
							{
							setState(648);
							((BitShiftExprContext)_localctx).uright = match(GT);
							setState(649);
							match(GT);
							setState(650);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						case 3:
							{
							setState(651);
							((BitShiftExprContext)_localctx).right = match(GT);
							setState(652);
							((BitShiftExprContext)_localctx).stop = match(GT);
							}
							break;
						}
						setState(655);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(656);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(657);
						_la = _input.LA(1);
						if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (GT - 76)) | (1L << (LT - 76)) | (1L << (LE - 76)) | (1L << (GE - 76)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(658);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(659);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(660);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(661);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(662);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(663);
						match(BITAND);
						setState(664);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(665);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(666);
						match(CARET);
						setState(667);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(668);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(669);
						match(BITOR);
						setState(670);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(671);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(672);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(673);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new QuestionExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(674);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(675);
						match(QUESTION);
						setState(676);
						expression(0);
						setState(677);
						match(COLON);
						setState(678);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(680);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(681);
						_la = _input.LA(1);
						if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (ASSIGN - 75)) | (1L << (ADD_ASSIGN - 75)) | (1L << (SUB_ASSIGN - 75)) | (1L << (MUL_ASSIGN - 75)) | (1L << (DIV_ASSIGN - 75)) | (1L << (AND_ASSIGN - 75)) | (1L << (OR_ASSIGN - 75)) | (1L << (XOR_ASSIGN - 75)) | (1L << (MOD_ASSIGN - 75)) | (1L << (LSHIFT_ASSIGN - 75)) | (1L << (RSHIFT_ASSIGN - 75)) | (1L << (URSHIFT_ASSIGN - 75)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(682);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new InvokeExprContext(new ExpressionContext(_parentctx, _parentState));
						((InvokeExprContext)_localctx).target = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(683);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(684);
						((InvokeExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ARROW || _la==START_DOT || _la==DOT) ) {
							((InvokeExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(685);
						match(Identifier);
						setState(686);
						match(LPAREN);
						setState(695);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (MultiLineStringLiteral - 64)) | (1L << (NullLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACK - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (InterpolationPreffixString - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(687);
							((InvokeExprContext)_localctx).expression = expression(0);
							((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
							setState(692);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(688);
								match(COMMA);
								setState(689);
								((InvokeExprContext)_localctx).expression = expression(0);
								((InvokeExprContext)_localctx).params.add(((InvokeExprContext)_localctx).expression);
								}
								}
								setState(694);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(697);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new GetFieldExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(698);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(699);
						((GetFieldExprContext)_localctx).refKey = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ARROW || _la==DOT) ) {
							((GetFieldExprContext)_localctx).refKey = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(700);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new GetArrayElementExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(701);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(702);
						match(LBRACK);
						setState(703);
						expression(0);
						setState(704);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new IncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(706);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(707);
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
						setState(708);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(709);
						match(INSTANCEOF);
						setState(710);
						match(Identifier);
						}
						break;
					case 17:
						{
						_localctx = new ErrorousMemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(711);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(712);
						match(DOT);
						}
						break;
					}
					} 
				}
				setState(717);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
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
		enterRule(_localctx, 68, RULE_literal);
		try {
			setState(728);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(718);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(719);
				match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(720);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(721);
				match(StringLiteral);
				}
				break;
			case MultiLineStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(722);
				match(MultiLineStringLiteral);
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(723);
				match(BooleanLiteral);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 7);
				{
				setState(724);
				match(Identifier);
				setState(725);
				match(DOT);
				setState(726);
				match(CLASS);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 8);
				{
				setState(727);
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
		enterRule(_localctx, 70, RULE_varModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(730);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(733); 
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
			return precpred(_ctx, 19);
		case 16:
			return precpred(_ctx, 11);
		case 17:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3y\u02e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\3\2\5\2"+
		"S\n\2\3\3\3\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\4\7\4^\n\4\f\4\16\4a\13\4"+
		"\3\4\5\4d\n\4\3\4\3\4\3\4\3\4\3\4\7\4k\n\4\f\4\16\4n\13\4\3\4\5\4q\n\4"+
		"\3\4\5\4t\n\4\3\4\5\4w\n\4\3\4\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\7\4\u0081"+
		"\n\4\f\4\16\4\u0084\13\4\5\4\u0086\n\4\3\4\3\4\3\4\3\4\3\5\3\5\5\5\u008e"+
		"\n\5\3\5\3\5\3\5\7\5\u0093\n\5\f\5\16\5\u0096\13\5\3\5\3\5\3\5\3\5\5\5"+
		"\u009c\n\5\3\5\5\5\u009f\n\5\3\5\3\5\3\5\3\5\7\5\u00a5\n\5\f\5\16\5\u00a8"+
		"\13\5\3\5\3\5\3\5\3\5\5\5\u00ae\n\5\3\5\5\5\u00b1\n\5\5\5\u00b3\n\5\3"+
		"\5\3\5\3\6\3\6\3\6\7\6\u00ba\n\6\f\6\16\6\u00bd\13\6\3\7\3\7\3\7\7\7\u00c2"+
		"\n\7\f\7\16\7\u00c5\13\7\3\b\5\b\u00c8\n\b\3\b\3\b\3\b\7\b\u00cd\n\b\f"+
		"\b\16\b\u00d0\13\b\3\b\3\b\3\t\7\t\u00d5\n\t\f\t\16\t\u00d8\13\t\3\t\5"+
		"\t\u00db\n\t\3\t\5\t\u00de\n\t\3\t\5\t\u00e1\n\t\3\t\3\t\3\t\3\t\5\t\u00e7"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f0\n\t\f\t\16\t\u00f3\13\t\5\t"+
		"\u00f5\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u00fc\n\t\f\t\16\t\u00ff\13\t\5\t\u0101"+
		"\n\t\3\t\3\t\5\t\u0105\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u0111\n\n\f\n\16\n\u0114\13\n\3\n\5\n\u0117\n\n\3\n\5\n\u011a\n\n\3\13"+
		"\3\13\3\13\5\13\u011f\n\13\3\13\3\13\3\13\3\13\5\13\u0125\n\13\7\13\u0127"+
		"\n\13\f\13\16\13\u012a\13\13\3\f\3\f\7\f\u012e\n\f\f\f\16\f\u0131\13\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u0138\n\f\f\f\16\f\u013b\13\f\3\f\3\f\5\f\u013f"+
		"\n\f\3\f\5\f\u0142\n\f\3\r\3\r\5\r\u0146\n\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\7\20\u0151\n\20\f\20\16\20\u0154\13\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u015d\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u016e\n\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u0178\n\25\f\25\16\25\u017b\13\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0188\n\26"+
		"\f\26\16\26\u018b\13\26\3\26\3\26\5\26\u018f\n\26\3\27\3\27\5\27\u0193"+
		"\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u019f\n\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u01ab\n\32\3\32"+
		"\3\32\5\32\u01af\n\32\3\32\3\32\3\32\3\32\5\32\u01b5\n\32\5\32\u01b7\n"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u01d0\n\37\3\37"+
		"\3\37\5\37\u01d4\n\37\3\37\3\37\5\37\u01d8\n\37\3\37\3\37\3\37\3 \3 \3"+
		" \3 \3 \3 \5 \u01e3\n \3 \3 \3 \3 \3!\3!\3!\7!\u01ec\n!\f!\16!\u01ef\13"+
		"!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\5#\u020b\n#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0215\n#\f#\16#\u0218"+
		"\13#\3#\3#\3#\3#\3#\5#\u021f\n#\3#\3#\3#\3#\5#\u0225\n#\3#\3#\3#\3#\7"+
		"#\u022b\n#\f#\16#\u022e\13#\5#\u0230\n#\3#\3#\3#\3#\5#\u0236\n#\3#\3#"+
		"\3#\3#\7#\u023c\n#\f#\16#\u023f\13#\5#\u0241\n#\3#\3#\3#\3#\3#\3#\3#\7"+
		"#\u024a\n#\f#\16#\u024d\13#\5#\u024f\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\7#\u0261\n#\f#\16#\u0264\13#\5#\u0266\n#\3#\3#\5#\u026a"+
		"\n#\3#\3#\3#\3#\3#\5#\u0271\n#\3#\3#\7#\u0275\n#\f#\16#\u0278\13#\3#\3"+
		"#\5#\u027c\n#\3#\3#\5#\u0280\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\5#\u0290\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u02b5\n#\f#\16"+
		"#\u02b8\13#\5#\u02ba\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\7#\u02cc\n#\f#\16#\u02cf\13#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u02db"+
		"\n$\3%\6%\u02de\n%\r%\16%\u02df\3%\2\4\24D&\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\21\4\2\33\33\62\62\n\2\r"+
		"\r\17\17\22\22\30\30\36\36%%\'\'::\3\2\5\6\3\2\\]\3\2Z[\3\2PQ\4\2\62\62"+
		"\65\65\4\2^_cc\4\2NOUV\4\2TTWW\3\2XY\4\2MMdn\4\2\b\tLL\4\2\b\bLL\5\2\34"+
		"\34+-\60\60\u034e\2M\3\2\2\2\4Y\3\2\2\2\6_\3\2\2\2\b\u00b2\3\2\2\2\n\u00b6"+
		"\3\2\2\2\f\u00c3\3\2\2\2\16\u00c7\3\2\2\2\20\u00d6\3\2\2\2\22\u0106\3"+
		"\2\2\2\24\u011e\3\2\2\2\26\u012f\3\2\2\2\30\u0145\3\2\2\2\32\u0147\3\2"+
		"\2\2\34\u014b\3\2\2\2\36\u014d\3\2\2\2 \u0155\3\2\2\2\"\u016d\3\2\2\2"+
		"$\u016f\3\2\2\2&\u0171\3\2\2\2(\u0175\3\2\2\2*\u017e\3\2\2\2,\u0190\3"+
		"\2\2\2.\u0196\3\2\2\2\60\u01a3\3\2\2\2\62\u01b6\3\2\2\2\64\u01b8\3\2\2"+
		"\2\66\u01bb\3\2\2\28\u01be\3\2\2\2:\u01c4\3\2\2\2<\u01cc\3\2\2\2>\u01dc"+
		"\3\2\2\2@\u01e8\3\2\2\2B\u01f0\3\2\2\2D\u027f\3\2\2\2F\u02da\3\2\2\2H"+
		"\u02dd\3\2\2\2JL\5\b\5\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NR\3\2"+
		"\2\2OM\3\2\2\2PS\5\6\4\2QS\5\4\3\2RP\3\2\2\2RQ\3\2\2\2S\3\3\2\2\2TX\5"+
		"\20\t\2UX\5\"\22\2VX\5\6\4\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X[\3\2\2\2Y"+
		"W\3\2\2\2YZ\3\2\2\2Z\5\3\2\2\2[Y\3\2\2\2\\^\5\22\n\2]\\\3\2\2\2^a\3\2"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bd\5H%\2cb\3\2\2\2cd\3\2\2"+
		"\2ds\3\2\2\2ep\7\23\2\2fg\7O\2\2gl\7p\2\2hi\7K\2\2ik\7p\2\2jh\3\2\2\2"+
		"kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2oq\7N\2\2pf\3\2\2\2"+
		"pq\3\2\2\2qt\3\2\2\2rt\7&\2\2se\3\2\2\2sr\3\2\2\2tv\3\2\2\2uw\7p\2\2v"+
		"u\3\2\2\2vw\3\2\2\2wz\3\2\2\2xy\7\33\2\2y{\5\26\f\2zx\3\2\2\2z{\3\2\2"+
		"\2{\u0085\3\2\2\2|}\7\"\2\2}\u0082\5\26\f\2~\177\7K\2\2\177\u0081\5\26"+
		"\f\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085|\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7F\2\2\u0088\u0089\5\f"+
		"\7\2\u0089\u008a\7G\2\2\u008a\7\3\2\2\2\u008b\u008d\7#\2\2\u008c\u008e"+
		"\7v\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0094\7p\2\2\u0090\u0091\7v\2\2\u0091\u0093\7p\2\2\u0092\u0090\3\2\2"+
		"\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009e\7v\2\2\u0098\u009b\7p\2\2\u0099"+
		"\u009a\7\3\2\2\u009a\u009c\7p\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009f\3\2\2\2\u009d\u009f\7^\2\2\u009e\u0098\3\2\2\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00b3\3\2\2\2\u00a0\u00a1\7#\2\2\u00a1\u00a6\7p\2"+
		"\2\u00a2\u00a3\7L\2\2\u00a3\u00a5\7p\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00b0\7L\2\2\u00aa\u00ad\7p\2\2\u00ab\u00ac\7\3\2"+
		"\2\u00ac\u00ae\7p\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1"+
		"\3\2\2\2\u00af\u00b1\7^\2\2\u00b0\u00aa\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"\u00b3\3\2\2\2\u00b2\u008b\3\2\2\2\u00b2\u00a0\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b5\7J\2\2\u00b5\t\3\2\2\2\u00b6\u00bb\7p\2\2\u00b7\u00b8"+
		"\7L\2\2\u00b8\u00ba\7p\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\13\3\2\2\2\u00bd\u00bb\3\2\2"+
		"\2\u00be\u00c2\5\16\b\2\u00bf\u00c2\5\20\t\2\u00c0\u00c2\5\6\4\2\u00c1"+
		"\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\r\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c6\u00c8\5H%\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ce\5\62\32\2\u00ca\u00cb\7K\2\2\u00cb\u00cd\5"+
		"\62\32\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7J"+
		"\2\2\u00d2\17\3\2\2\2\u00d3\u00d5\5\22\n\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\u00db\7\n\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dd\3\2\2\2\u00dc\u00de\7\26\2\2\u00dd\u00dc\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\5H%\2\u00e0\u00df\3\2\2"+
		"\2\u00e0\u00e1\3\2\2\2\u00e1\u00e6\3\2\2\2\u00e2\u00e3\5\24\13\2\u00e3"+
		"\u00e4\7p\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e7\7\4\2\2\u00e6\u00e2\3\2"+
		"\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00f4\7D\2\2\u00e9"+
		"\u00ea\5\24\13\2\u00ea\u00f1\7p\2\2\u00eb\u00ec\7K\2\2\u00ec\u00ed\5\24"+
		"\13\2\u00ed\u00ee\7p\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f5\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00e9\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u0100\7E\2\2\u00f7\u00f8\7\67\2\2\u00f8\u00fd\7p"+
		"\2\2\u00f9\u00fa\7K\2\2\u00fa\u00fc\7p\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff"+
		"\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u00f7\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2"+
		"\2\2\u0102\u0105\5(\25\2\u0103\u0105\7J\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\21\3\2\2\2\u0106\u0107\7q\2\2\u0107\u0119\7p\2\2"+
		"\u0108\u0116\7D\2\2\u0109\u010a\7p\2\2\u010a\u010b\7M\2\2\u010b\u0112"+
		"\5F$\2\u010c\u010d\7K\2\2\u010d\u010e\7p\2\2\u010e\u010f\7M\2\2\u010f"+
		"\u0111\5F$\2\u0110\u010c\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2"+
		"\2\u0112\u0113\3\2\2\2\u0113\u0117\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117"+
		"\5F$\2\u0116\u0109\3\2\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u011a\7E\2\2\u0119\u0108\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\23\3\2\2\2\u011b\u011c\b\13\1\2\u011c\u011f\5\26\f\2\u011d"+
		"\u011f\5\34\17\2\u011e\u011b\3\2\2\2\u011e\u011d\3\2\2\2\u011f\u0128\3"+
		"\2\2\2\u0120\u0121\f\3\2\2\u0121\u0122\7H\2\2\u0122\u0124\7I\2\2\u0123"+
		"\u0125\7R\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2"+
		"\2\2\u0126\u0120\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\25\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7p\2\2"+
		"\u012c\u012e\7v\2\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u013e\7p\2\2\u0133\u0134\7O\2\2\u0134\u0139\5\30\r\2\u0135\u0136\7K\2"+
		"\2\u0136\u0138\5\30\r\2\u0137\u0135\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013d\7N\2\2\u013d\u013f\3\2\2\2\u013e\u0133\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u0142\7R\2\2\u0141\u0140\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\27\3\2\2\2\u0143\u0146\5\24\13\2\u0144"+
		"\u0146\5\32\16\2\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2\u0146\31\3\2"+
		"\2\2\u0147\u0148\7R\2\2\u0148\u0149\t\2\2\2\u0149\u014a\5\26\f\2\u014a"+
		"\33\3\2\2\2\u014b\u014c\t\3\2\2\u014c\35\3\2\2\2\u014d\u0152\5\62\32\2"+
		"\u014e\u014f\7K\2\2\u014f\u0151\5\62\32\2\u0150\u014e\3\2\2\2\u0151\u0154"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\37\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u0156\7 \2\2\u0156\u0157\7D\2\2\u0157\u0158\5D#\2"+
		"\u0158\u0159\7E\2\2\u0159\u015c\5\"\22\2\u015a\u015b\7\31\2\2\u015b\u015d"+
		"\5\"\22\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d!\3\2\2\2\u015e"+
		"\u016e\5(\25\2\u015f\u016e\5\60\31\2\u0160\u016e\5.\30\2\u0161\u016e\5"+
		"B\"\2\u0162\u016e\5 \21\2\u0163\u016e\58\35\2\u0164\u016e\5:\36\2\u0165"+
		"\u016e\5<\37\2\u0166\u016e\5> \2\u0167\u016e\5\64\33\2\u0168\u016e\5\66"+
		"\34\2\u0169\u016e\5,\27\2\u016a\u016e\5*\26\2\u016b\u016e\5&\24\2\u016c"+
		"\u016e\5$\23\2\u016d\u015e\3\2\2\2\u016d\u015f\3\2\2\2\u016d\u0160\3\2"+
		"\2\2\u016d\u0161\3\2\2\2\u016d\u0162\3\2\2\2\u016d\u0163\3\2\2\2\u016d"+
		"\u0164\3\2\2\2\u016d\u0165\3\2\2\2\u016d\u0166\3\2\2\2\u016d\u0167\3\2"+
		"\2\2\u016d\u0168\3\2\2\2\u016d\u0169\3\2\2\2\u016d\u016a\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016d\u016c\3\2\2\2\u016e#\3\2\2\2\u016f\u0170\5D#\2\u0170"+
		"%\3\2\2\2\u0171\u0172\7\66\2\2\u0172\u0173\5D#\2\u0173\u0174\7J\2\2\u0174"+
		"\'\3\2\2\2\u0175\u0179\7F\2\2\u0176\u0178\5\"\22\2\u0177\u0176\3\2\2\2"+
		"\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7G\2\2\u017d)\3\2\2\2\u017e\u017f"+
		"\79\2\2\u017f\u0189\5(\25\2\u0180\u0181\7\21\2\2\u0181\u0182\7D\2\2\u0182"+
		"\u0183\5\26\f\2\u0183\u0184\7p\2\2\u0184\u0185\7E\2\2\u0185\u0186\5(\25"+
		"\2\u0186\u0188\3\2\2\2\u0187\u0180\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187"+
		"\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018e\3\2\2\2\u018b\u0189\3\2\2\2\u018c"+
		"\u018d\7\35\2\2\u018d\u018f\5(\25\2\u018e\u018c\3\2\2\2\u018e\u018f\3"+
		"\2\2\2\u018f+\3\2\2\2\u0190\u0192\7.\2\2\u0191\u0193\5D#\2\u0192\u0191"+
		"\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\7J\2\2\u0195"+
		"-\3\2\2\2\u0196\u0197\5D#\2\u0197\u019e\7 \2\2\u0198\u019f\7T\2\2\u0199"+
		"\u019f\7O\2\2\u019a\u019f\7N\2\2\u019b\u019f\7W\2\2\u019c\u019f\7V\2\2"+
		"\u019d\u019f\7U\2\2\u019e\u0198\3\2\2\2\u019e\u0199\3\2\2\2\u019e\u019a"+
		"\3\2\2\2\u019e\u019b\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\5D#\2\u01a1\u01a2\7J\2"+
		"\2\u01a2/\3\2\2\2\u01a3\u01a4\5\36\20\2\u01a4\u01a5\7J\2\2\u01a5\61\3"+
		"\2\2\2\u01a6\u01a7\t\4\2\2\u01a7\u01aa\7p\2\2\u01a8\u01a9\7\3\2\2\u01a9"+
		"\u01ab\5\24\13\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ae\3"+
		"\2\2\2\u01ac\u01ad\7M\2\2\u01ad\u01af\5D#\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01b7\3\2\2\2\u01b0\u01b1\5\24\13\2\u01b1\u01b4\7"+
		"p\2\2\u01b2\u01b3\7M\2\2\u01b3\u01b5\5D#\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01a6\3\2\2\2\u01b6\u01b0\3\2\2\2\u01b7"+
		"\63\3\2\2\2\u01b8\u01b9\7\16\2\2\u01b9\u01ba\7J\2\2\u01ba\65\3\2\2\2\u01bb"+
		"\u01bc\7\25\2\2\u01bc\u01bd\7J\2\2\u01bd\67\3\2\2\2\u01be\u01bf\7<\2\2"+
		"\u01bf\u01c0\7D\2\2\u01c0\u01c1\5D#\2\u01c1\u01c2\7E\2\2\u01c2\u01c3\5"+
		"\"\22\2\u01c39\3\2\2\2\u01c4\u01c5\7\27\2\2\u01c5\u01c6\5(\25\2\u01c6"+
		"\u01c7\7<\2\2\u01c7\u01c8\7D\2\2\u01c8\u01c9\5D#\2\u01c9\u01ca\7E\2\2"+
		"\u01ca\u01cb\7J\2\2\u01cb;\3\2\2\2\u01cc\u01cd\7\37\2\2\u01cd\u01cf\7"+
		"D\2\2\u01ce\u01d0\5\36\20\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d3\7J\2\2\u01d2\u01d4\5D#\2\u01d3\u01d2\3\2\2"+
		"\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\7J\2\2\u01d6\u01d8"+
		"\5@!\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\7E\2\2\u01da\u01db\5\"\22\2\u01db=\3\2\2\2\u01dc\u01dd\7\7\2\2"+
		"\u01dd\u01de\7D\2\2\u01de\u01df\5D#\2\u01df\u01e2\7\3\2\2\u01e0\u01e1"+
		"\7p\2\2\u01e1\u01e3\7K\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e5\7p\2\2\u01e5\u01e6\7E\2\2\u01e6\u01e7\5\"\22"+
		"\2\u01e7?\3\2\2\2\u01e8\u01ed\5D#\2\u01e9\u01ea\7K\2\2\u01ea\u01ec\5D"+
		"#\2\u01eb\u01e9\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01eeA\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f1\5D#\2\u01f1"+
		"\u01f2\7J\2\2\u01f2C\3\2\2\2\u01f3\u01f4\b#\1\2\u01f4\u01f5\7D\2\2\u01f5"+
		"\u01f6\5\24\13\2\u01f6\u01f7\7E\2\2\u01f7\u01f8\5D#\26\u01f8\u0280\3\2"+
		"\2\2\u01f9\u01fa\t\5\2\2\u01fa\u0280\5D#\24\u01fb\u01fc\t\6\2\2\u01fc"+
		"\u0280\5D#\23\u01fd\u01fe\t\7\2\2\u01fe\u0280\5D#\22\u01ff\u0200\7D\2"+
		"\2\u0200\u0201\5D#\2\u0201\u0202\7E\2\2\u0202\u0280\3\2\2\2\u0203\u0280"+
		"\t\b\2\2\u0204\u0280\5F$\2\u0205\u0206\7O\2\2\u0206\u0207\7p\2\2\u0207"+
		"\u0208\7K\2\2\u0208\u0209\7p\2\2\u0209\u020b\7N\2\2\u020a\u0205\3\2\2"+
		"\2\u020a\u020b\3\2\2\2\u020b\u021e\3\2\2\2\u020c\u020d\7H\2\2\u020d\u020e"+
		"\7p\2\2\u020e\u020f\7S\2\2\u020f\u0216\5D#\2\u0210\u0211\7K\2\2\u0211"+
		"\u0212\7p\2\2\u0212\u0213\7S\2\2\u0213\u0215\5D#\2\u0214\u0210\3\2\2\2"+
		"\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0219"+
		"\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021a\7I\2\2\u021a\u021f\3\2\2\2\u021b"+
		"\u021c\7H\2\2\u021c\u021d\7S\2\2\u021d\u021f\7I\2\2\u021e\u020c\3\2\2"+
		"\2\u021e\u021b\3\2\2\2\u021f\u0280\3\2\2\2\u0220\u0221\7O\2\2\u0221\u0222"+
		"\5\24\13\2\u0222\u0223\7N\2\2\u0223\u0225\3\2\2\2\u0224\u0220\3\2\2\2"+
		"\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u022f\7H\2\2\u0227\u022c"+
		"\5D#\2\u0228\u0229\7K\2\2\u0229\u022b\5D#\2\u022a\u0228\3\2\2\2\u022b"+
		"\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u0230\3\2"+
		"\2\2\u022e\u022c\3\2\2\2\u022f\u0227\3\2\2\2\u022f\u0230\3\2\2\2\u0230"+
		"\u0231\3\2\2\2\u0231\u0280\7I\2\2\u0232\u0236\7p\2\2\u0233\u0236\7\65"+
		"\2\2\u0234\u0236\7\62\2\2\u0235\u0232\3\2\2\2\u0235\u0233\3\2\2\2\u0235"+
		"\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0240\7D\2\2\u0238\u023d\5D#"+
		"\2\u0239\u023a\7K\2\2\u023a\u023c\5D#\2\u023b\u0239\3\2\2\2\u023c\u023f"+
		"\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0241\3\2\2\2\u023f"+
		"\u023d\3\2\2\2\u0240\u0238\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2"+
		"\2\2\u0242\u0280\7E\2\2\u0243\u0244\7)\2\2\u0244\u0245\5\26\f\2\u0245"+
		"\u024e\7D\2\2\u0246\u024b\5D#\2\u0247\u0248\7K\2\2\u0248\u024a\5D#\2\u0249"+
		"\u0247\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2"+
		"\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0246\3\2\2\2\u024e"+
		"\u024f\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\7E\2\2\u0251\u0280\3\2"+
		"\2\2\u0252\u0253\7)\2\2\u0253\u0254\5\24\13\2\u0254\u0255\7H\2\2\u0255"+
		"\u0256\5D#\2\u0256\u0257\7I\2\2\u0257\u026a\3\2\2\2\u0258\u0259\7)\2\2"+
		"\u0259\u025a\5\24\13\2\u025a\u025b\7H\2\2\u025b\u025c\7I\2\2\u025c\u0265"+
		"\7F\2\2\u025d\u0262\5D#\2\u025e\u025f\7K\2\2\u025f\u0261\5D#\2\u0260\u025e"+
		"\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263"+
		"\u0266\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u025d\3\2\2\2\u0265\u0266\3\2"+
		"\2\2\u0266\u0267\3\2\2\2\u0267\u0268\7G\2\2\u0268\u026a\3\2\2\2\u0269"+
		"\u0252\3\2\2\2\u0269\u0258\3\2\2\2\u026a\u0280\3\2\2\2\u026b\u0280\7p"+
		"\2\2\u026c\u026d\7o\2\2\u026d\u0276\5D#\2\u026e\u0270\7G\2\2\u026f\u0271"+
		"\7y\2\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272"+
		"\u0273\7w\2\2\u0273\u0275\5D#\2\u0274\u026e\3\2\2\2\u0275\u0278\3\2\2"+
		"\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0276"+
		"\3\2\2\2\u0279\u027b\7G\2\2\u027a\u027c\7y\2\2\u027b\u027a\3\2\2\2\u027b"+
		"\u027c\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027e\7x\2\2\u027e\u0280\3\2"+
		"\2\2\u027f\u01f3\3\2\2\2\u027f\u01f9\3\2\2\2\u027f\u01fb\3\2\2\2\u027f"+
		"\u01fd\3\2\2\2\u027f\u01ff\3\2\2\2\u027f\u0203\3\2\2\2\u027f\u0204\3\2"+
		"\2\2\u027f\u020a\3\2\2\2\u027f\u0224\3\2\2\2\u027f\u0235\3\2\2\2\u027f"+
		"\u0243\3\2\2\2\u027f\u0269\3\2\2\2\u027f\u026b\3\2\2\2\u027f\u026c\3\2"+
		"\2\2\u0280\u02cd\3\2\2\2\u0281\u0282\f\21\2\2\u0282\u0283\t\t\2\2\u0283"+
		"\u02cc\5D#\22\u0284\u0285\f\20\2\2\u0285\u0286\t\5\2\2\u0286\u02cc\5D"+
		"#\21\u0287\u028f\f\17\2\2\u0288\u0289\7O\2\2\u0289\u0290\7O\2\2\u028a"+
		"\u028b\7N\2\2\u028b\u028c\7N\2\2\u028c\u0290\7N\2\2\u028d\u028e\7N\2\2"+
		"\u028e\u0290\7N\2\2\u028f\u0288\3\2\2\2\u028f\u028a\3\2\2\2\u028f\u028d"+
		"\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u02cc\5D#\20\u0292\u0293\f\16\2\2\u0293"+
		"\u0294\t\n\2\2\u0294\u02cc\5D#\17\u0295\u0296\f\f\2\2\u0296\u0297\t\13"+
		"\2\2\u0297\u02cc\5D#\r\u0298\u0299\f\13\2\2\u0299\u029a\7`\2\2\u029a\u02cc"+
		"\5D#\f\u029b\u029c\f\n\2\2\u029c\u029d\7b\2\2\u029d\u02cc\5D#\13\u029e"+
		"\u029f\f\t\2\2\u029f\u02a0\7a\2\2\u02a0\u02cc\5D#\n\u02a1\u02a2\f\b\2"+
		"\2\u02a2\u02a3\t\f\2\2\u02a3\u02cc\5D#\t\u02a4\u02a5\f\7\2\2\u02a5\u02a6"+
		"\7R\2\2\u02a6\u02a7\5D#\2\u02a7\u02a8\7S\2\2\u02a8\u02a9\5D#\b\u02a9\u02cc"+
		"\3\2\2\2\u02aa\u02ab\f\3\2\2\u02ab\u02ac\t\r\2\2\u02ac\u02cc\5D#\3\u02ad"+
		"\u02ae\f\34\2\2\u02ae\u02af\t\16\2\2\u02af\u02b0\7p\2\2\u02b0\u02b9\7"+
		"D\2\2\u02b1\u02b6\5D#\2\u02b2\u02b3\7K\2\2\u02b3\u02b5\5D#\2\u02b4\u02b2"+
		"\3\2\2\2\u02b5\u02b8\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7"+
		"\u02ba\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b9\u02b1\3\2\2\2\u02b9\u02ba\3\2"+
		"\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02cc\7E\2\2\u02bc\u02bd\f\33\2\2\u02bd"+
		"\u02be\t\17\2\2\u02be\u02cc\7p\2\2\u02bf\u02c0\f\31\2\2\u02c0\u02c1\7"+
		"H\2\2\u02c1\u02c2\5D#\2\u02c2\u02c3\7I\2\2\u02c3\u02cc\3\2\2\2\u02c4\u02c5"+
		"\f\25\2\2\u02c5\u02cc\t\6\2\2\u02c6\u02c7\f\r\2\2\u02c7\u02c8\7$\2\2\u02c8"+
		"\u02cc\7p\2\2\u02c9\u02ca\f\5\2\2\u02ca\u02cc\7L\2\2\u02cb\u0281\3\2\2"+
		"\2\u02cb\u0284\3\2\2\2\u02cb\u0287\3\2\2\2\u02cb\u0292\3\2\2\2\u02cb\u0295"+
		"\3\2\2\2\u02cb\u0298\3\2\2\2\u02cb\u029b\3\2\2\2\u02cb\u029e\3\2\2\2\u02cb"+
		"\u02a1\3\2\2\2\u02cb\u02a4\3\2\2\2\u02cb\u02aa\3\2\2\2\u02cb\u02ad\3\2"+
		"\2\2\u02cb\u02bc\3\2\2\2\u02cb\u02bf\3\2\2\2\u02cb\u02c4\3\2\2\2\u02cb"+
		"\u02c6\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd\u02cb\3\2"+
		"\2\2\u02cd\u02ce\3\2\2\2\u02ceE\3\2\2\2\u02cf\u02cd\3\2\2\2\u02d0\u02db"+
		"\7=\2\2\u02d1\u02db\7>\2\2\u02d2\u02db\7@\2\2\u02d3\u02db\7A\2\2\u02d4"+
		"\u02db\7B\2\2\u02d5\u02db\7?\2\2\u02d6\u02d7\7p\2\2\u02d7\u02d8\7L\2\2"+
		"\u02d8\u02db\7\23\2\2\u02d9\u02db\7C\2\2\u02da\u02d0\3\2\2\2\u02da\u02d1"+
		"\3\2\2\2\u02da\u02d2\3\2\2\2\u02da\u02d3\3\2\2\2\u02da\u02d4\3\2\2\2\u02da"+
		"\u02d5\3\2\2\2\u02da\u02d6\3\2\2\2\u02da\u02d9\3\2\2\2\u02dbG\3\2\2\2"+
		"\u02dc\u02de\t\20\2\2\u02dd\u02dc\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02dd"+
		"\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0I\3\2\2\2[MRWY_clpsvz\u0082\u0085\u008d"+
		"\u0094\u009b\u009e\u00a6\u00ad\u00b0\u00b2\u00bb\u00c1\u00c3\u00c7\u00ce"+
		"\u00d6\u00da\u00dd\u00e0\u00e6\u00f1\u00f4\u00fd\u0100\u0104\u0112\u0116"+
		"\u0119\u011e\u0124\u0128\u012f\u0139\u013e\u0141\u0145\u0152\u015c\u016d"+
		"\u0179\u0189\u018e\u0192\u019e\u01aa\u01ae\u01b4\u01b6\u01cf\u01d3\u01d7"+
		"\u01e2\u01ed\u020a\u0216\u021e\u0224\u022c\u022f\u0235\u023d\u0240\u024b"+
		"\u024e\u0262\u0265\u0269\u0270\u0276\u027b\u027f\u028f\u02b6\u02b9\u02cb"+
		"\u02cd\u02da\u02df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
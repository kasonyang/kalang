// Generated from KalangLexer.g4 by ANTLR 4.7.2
package kalang.compiler.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KalangLexer extends Lexer {
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
		COMMENTS=2, WHITESPACE=3;
	public static final int
		STRING=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "COMMENTS", "WHITESPACE"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "STRING"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOUBLE_COLON", "AS", "IN", "CONSTRUCTOR", "VAR", "VAL", "FOREACH", "ARROW", 
			"LAMBDA_ARROW", "DYNAMIC", "STAR_DOT", "STAR_DYNAMIC", "QUESTION_DOT", 
			"DOUBLE_QUESTION", "QUESTION_DOTDOT", "QUESTION_DYNAMIC", "OVERRIDE", 
			"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", 
			"CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", 
			"EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", 
			"IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", 
			"PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", 
			"STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", 
			"TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "MIXIN", "WITH", "ASYNC", 
			"AWAIT", "YIELD", "IntegerLiteral", "DecimalIntegerLiteral", "HexIntegerLiteral", 
			"OctalIntegerLiteral", "BinaryIntegerLiteral", "IntegerTypeSuffix", "DecimalNumeral", 
			"Digits", "Digit", "NonZeroDigit", "DigitOrUnderscore", "Underscores", 
			"HexNumeral", "HexDigits", "HexDigit", "HexDigitOrUnderscore", "OctalNumeral", 
			"OctalDigits", "OctalDigit", "OctalDigitOrUnderscore", "BinaryNumeral", 
			"BinaryDigits", "BinaryDigit", "BinaryDigitOrUnderscore", "FloatingPointLiteral", 
			"DecimalFloatingPointLiteral", "ExponentPart", "ExponentIndicator", "SignedInteger", 
			"Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", "HexSignificand", 
			"BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", "CharacterLiteral", 
			"SingleCharacter", "StringLiteral", "MultiLineStringLiteral", "StringCharacters", 
			"MultiLineStringCharacters", "StringCharacter", "MultiLineStringCharacter", 
			"EscapeSequence", "OctalEscape", "UnicodeEscape", "ZeroToThree", "NullLiteral", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
			"DOT", "DOTDOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", 
			"EQUAL", "SAME", "LE", "GE", "NOTEQUAL", "NOTSAME", "AND", "OR", "INC", 
			"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", 
			"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
			"URSHIFT_ASSIGN", "InterpolationPreffixString", "Identifier", "JavaLetter", 
			"JavaLetterOrDigit", "AT", "ELLIPSIS", "COMPILE_OPTION_LINE", "WS", "COMMENT", 
			"LINE_COMMENT", "PACKAGE_DELIMITER", "UNTERMINATED_STRING", "UNTERMINATED_MULTILINE_STRING", 
			"UNCLOSED_COMMENT", "UNKNOWN_CHAR", "INTERPOLATION_INTERUPT", "INTERPOLATION_END", 
			"INTERPOLATION_STRING"
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


	//    public static final int WHITESPACE = 3;
	//    public static final int COMMENTS =    4;
	    public boolean inString = false;


	public KalangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KalangLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 124:
			RBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 167:
			InterpolationPreffixString_action((RuleContext)_localctx, actionIndex);
			break;
		case 183:
			INTERPOLATION_END_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			        if(inString) pushMode(STRING);
			    
			break;
		}
	}
	private void InterpolationPreffixString_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			            inString = true;
			        
			break;
		}
	}
	private void INTERPOLATION_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			        popMode();
			        inString = false;
			    
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 169:
			return JavaLetter_sempred((RuleContext)_localctx, predIndex);
		case 170:
			return JavaLetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean JavaLetter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return Character.isJavaIdentifierStart(_input.LA(-1));
		case 1:
			return Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}
	private boolean JavaLetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return Character.isJavaIdentifierPart(_input.LA(-1));
		case 3:
			return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u008f\u0566\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^"+
		"\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j"+
		"\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu"+
		"\4v\tv\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080"+
		"\t\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089"+
		"\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d"+
		"\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092"+
		"\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096"+
		"\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b"+
		"\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f"+
		"\4\u00a0\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4"+
		"\t\u00a4\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8"+
		"\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad"+
		"\t\u00ad\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1"+
		"\4\u00b2\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6"+
		"\t\u00b6\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3"+
		"+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3"+
		"\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\39\3"+
		"9\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3"+
		"?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3B\3B\3B\3"+
		"B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3"+
		"F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3"+
		"J\3J\3J\3J\5J\u033a\nJ\3K\3K\5K\u033e\nK\3L\3L\5L\u0342\nL\3M\3M\5M\u0346"+
		"\nM\3N\3N\5N\u034a\nN\3O\3O\3P\3P\3P\5P\u0351\nP\3P\3P\3P\5P\u0356\nP"+
		"\5P\u0358\nP\3Q\3Q\7Q\u035c\nQ\fQ\16Q\u035f\13Q\3Q\5Q\u0362\nQ\3R\3R\5"+
		"R\u0366\nR\3S\3S\3T\3T\5T\u036c\nT\3U\6U\u036f\nU\rU\16U\u0370\3V\3V\3"+
		"V\3V\3W\3W\7W\u0379\nW\fW\16W\u037c\13W\3W\5W\u037f\nW\3X\3X\3Y\3Y\5Y"+
		"\u0385\nY\3Z\3Z\5Z\u0389\nZ\3Z\3Z\3[\3[\7[\u038f\n[\f[\16[\u0392\13[\3"+
		"[\5[\u0395\n[\3\\\3\\\3]\3]\5]\u039b\n]\3^\3^\3^\3^\3_\3_\7_\u03a3\n_"+
		"\f_\16_\u03a6\13_\3_\5_\u03a9\n_\3`\3`\3a\3a\5a\u03af\na\3b\3b\5b\u03b3"+
		"\nb\3c\3c\3c\5c\u03b8\nc\3c\5c\u03bb\nc\3c\5c\u03be\nc\3c\3c\3c\5c\u03c3"+
		"\nc\3c\5c\u03c6\nc\3c\3c\3c\5c\u03cb\nc\3c\3c\3c\5c\u03d0\nc\3d\3d\3d"+
		"\3e\3e\3f\5f\u03d8\nf\3f\3f\3g\3g\3h\3h\3i\3i\3i\5i\u03e3\ni\3j\3j\5j"+
		"\u03e7\nj\3j\3j\3j\5j\u03ec\nj\3j\3j\5j\u03f0\nj\3k\3k\3k\3l\3l\3m\3m"+
		"\3m\3m\3m\3m\3m\3m\3m\5m\u0400\nm\3n\3n\3n\3n\3n\3n\3n\3n\5n\u040a\nn"+
		"\3o\3o\3p\3p\5p\u0410\np\3p\7p\u0413\np\fp\16p\u0416\13p\3p\3p\3q\3q\3"+
		"q\3q\3q\5q\u041f\nq\3q\3q\3q\3q\3r\6r\u0426\nr\rr\16r\u0427\3s\6s\u042b"+
		"\ns\rs\16s\u042c\3t\3t\3t\3t\5t\u0433\nt\3u\3u\3u\3u\3u\3u\3u\3u\5u\u043d"+
		"\nu\3v\3v\3v\5v\u0442\nv\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\5w\u044f\nw"+
		"\3x\3x\3x\3x\3x\3x\3x\3y\3y\3z\3z\3z\3z\3z\3{\3{\3|\3|\3}\3}\3~\3~\3~"+
		"\3\177\3\177\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0083\3"+
		"\u0083\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0086\3\u0086\3\u0087"+
		"\3\u0087\3\u0088\3\u0088\3\u0089\3\u0089\3\u008a\3\u008a\3\u008b\3\u008b"+
		"\3\u008c\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e"+
		"\3\u008e\3\u008f\3\u008f\3\u008f\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091"+
		"\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\3\u0094"+
		"\3\u0094\3\u0094\3\u0095\3\u0095\3\u0095\3\u0096\3\u0096\3\u0097\3\u0097"+
		"\3\u0098\3\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009b\3\u009b\3\u009c"+
		"\3\u009c\3\u009d\3\u009d\3\u009e\3\u009e\3\u009e\3\u009f\3\u009f\3\u009f"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2\3\u00a2"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a5"+
		"\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a8"+
		"\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\5\u00a9\u04da\n\u00a9"+
		"\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa\3\u00aa\7\u00aa\u04e3"+
		"\n\u00aa\f\u00aa\16\u00aa\u04e6\13\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\5\u00ab\u04ee\n\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\3\u00ac\5\u00ac\u04f6\n\u00ac\3\u00ad\3\u00ad\3\u00ae\3\u00ae"+
		"\3\u00ae\3\u00ae\3\u00af\3\u00af\6\u00af\u0500\n\u00af\r\u00af\16\u00af"+
		"\u0501\3\u00b0\6\u00b0\u0505\n\u00b0\r\u00b0\16\u00b0\u0506\3\u00b0\3"+
		"\u00b0\3\u00b1\3\u00b1\3\u00b1\3\u00b1\7\u00b1\u050f\n\u00b1\f\u00b1\16"+
		"\u00b1\u0512\13\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\7\u00b2\u051d\n\u00b2\f\u00b2\16\u00b2\u0520"+
		"\13\u00b2\3\u00b2\3\u00b2\3\u00b3\3\u00b3\3\u00b4\3\u00b4\5\u00b4\u0528"+
		"\n\u00b4\3\u00b4\7\u00b4\u052b\n\u00b4\f\u00b4\16\u00b4\u052e\13\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\7\u00b5\u0537"+
		"\n\u00b5\f\u00b5\16\u00b5\u053a\13\u00b5\3\u00b5\3\u00b5\3\u00b5\5\u00b5"+
		"\u053f\n\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b6\3\u00b6"+
		"\3\u00b6\3\u00b6\3\u00b6\7\u00b6\u054b\n\u00b6\f\u00b6\16\u00b6\u054e"+
		"\13\u00b6\3\u00b6\5\u00b6\u0551\n\u00b6\3\u00b6\3\u00b6\3\u00b7\6\u00b7"+
		"\u0556\n\u00b7\r\u00b7\16\u00b7\u0557\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b9\3\u00b9\3\u00b9\3\u00ba\6\u00ba\u0563\n\u00ba\r\u00ba"+
		"\16\u00ba\u0564\6\u0510\u0538\u054c\u0557\2\u00bb\4\3\6\4\b\5\n\6\f\7"+
		"\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25"+
		"*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'N(P"+
		")R*T+V,X-Z.\\/^\60`\61b\62d\63f\64h\65j\66l\67n8p9r:t;v<x=z>|?~@\u0080"+
		"A\u0082B\u0084C\u0086D\u0088E\u008aF\u008cG\u008eH\u0090I\u0092J\u0094"+
		"K\u0096\2\u0098\2\u009a\2\u009c\2\u009e\2\u00a0\2\u00a2\2\u00a4\2\u00a6"+
		"\2\u00a8\2\u00aa\2\u00ac\2\u00ae\2\u00b0\2\u00b2\2\u00b4\2\u00b6\2\u00b8"+
		"\2\u00ba\2\u00bc\2\u00be\2\u00c0\2\u00c2\2\u00c4L\u00c6\2\u00c8\2\u00ca"+
		"\2\u00cc\2\u00ce\2\u00d0\2\u00d2\2\u00d4\2\u00d6\2\u00d8\2\u00daM\u00dc"+
		"N\u00de\2\u00e0O\u00e2P\u00e4\2\u00e6\2\u00e8\2\u00ea\2\u00ec\2\u00ee"+
		"\2\u00f0\2\u00f2\2\u00f4Q\u00f6R\u00f8S\u00faT\u00fcU\u00feV\u0100W\u0102"+
		"X\u0104Y\u0106Z\u0108[\u010a\\\u010c]\u010e^\u0110_\u0112`\u0114a\u0116"+
		"b\u0118c\u011ad\u011ce\u011ef\u0120g\u0122h\u0124i\u0126j\u0128k\u012a"+
		"l\u012cm\u012en\u0130o\u0132p\u0134q\u0136r\u0138s\u013at\u013cu\u013e"+
		"v\u0140w\u0142x\u0144y\u0146z\u0148{\u014a|\u014c}\u014e~\u0150\177\u0152"+
		"\u0080\u0154\u0081\u0156\2\u0158\2\u015a\u0082\u015c\u0083\u015e\u0084"+
		"\u0160\u0085\u0162\u0086\u0164\u0087\u0166\u0088\u0168\u0089\u016a\u008a"+
		"\u016c\u008b\u016e\u008c\u0170\u008d\u0172\u008e\u0174\u008f\4\2\3\34"+
		"\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63\4\2GGg"+
		"g\4\2--//\6\2FFHHffhh\4\2RRrr\4\2))^^\7\2\f\f\17\17$$&&^^\4\2$$}}\3\2"+
		"))\3\2\62\65\6\2&&C\\aac|\4\2\2\u0101\ud802\udc01\3\2\ud802\udc01\3\2"+
		"\udc02\ue001\7\2&&\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\16\17\"\"\4\2,,\61"+
		"\61\3\2\61\61\3\2,,\2\u0584\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3"+
		"\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2"+
		"\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3"+
		"\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2"+
		"\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\2"+
		"8\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3"+
		"\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2"+
		"\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2"+
		"\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j"+
		"\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2"+
		"\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082"+
		"\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\2\u008a\3\2\2"+
		"\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090\3\2\2\2\2\u0092\3\2\2\2\2\u0094"+
		"\3\2\2\2\2\u00c4\3\2\2\2\2\u00da\3\2\2\2\2\u00dc\3\2\2\2\2\u00e0\3\2\2"+
		"\2\2\u00e2\3\2\2\2\2\u00f4\3\2\2\2\2\u00f6\3\2\2\2\2\u00f8\3\2\2\2\2\u00fa"+
		"\3\2\2\2\2\u00fc\3\2\2\2\2\u00fe\3\2\2\2\2\u0100\3\2\2\2\2\u0102\3\2\2"+
		"\2\2\u0104\3\2\2\2\2\u0106\3\2\2\2\2\u0108\3\2\2\2\2\u010a\3\2\2\2\2\u010c"+
		"\3\2\2\2\2\u010e\3\2\2\2\2\u0110\3\2\2\2\2\u0112\3\2\2\2\2\u0114\3\2\2"+
		"\2\2\u0116\3\2\2\2\2\u0118\3\2\2\2\2\u011a\3\2\2\2\2\u011c\3\2\2\2\2\u011e"+
		"\3\2\2\2\2\u0120\3\2\2\2\2\u0122\3\2\2\2\2\u0124\3\2\2\2\2\u0126\3\2\2"+
		"\2\2\u0128\3\2\2\2\2\u012a\3\2\2\2\2\u012c\3\2\2\2\2\u012e\3\2\2\2\2\u0130"+
		"\3\2\2\2\2\u0132\3\2\2\2\2\u0134\3\2\2\2\2\u0136\3\2\2\2\2\u0138\3\2\2"+
		"\2\2\u013a\3\2\2\2\2\u013c\3\2\2\2\2\u013e\3\2\2\2\2\u0140\3\2\2\2\2\u0142"+
		"\3\2\2\2\2\u0144\3\2\2\2\2\u0146\3\2\2\2\2\u0148\3\2\2\2\2\u014a\3\2\2"+
		"\2\2\u014c\3\2\2\2\2\u014e\3\2\2\2\2\u0150\3\2\2\2\2\u0152\3\2\2\2\2\u0154"+
		"\3\2\2\2\2\u015a\3\2\2\2\2\u015c\3\2\2\2\2\u015e\3\2\2\2\2\u0160\3\2\2"+
		"\2\2\u0162\3\2\2\2\2\u0164\3\2\2\2\2\u0166\3\2\2\2\2\u0168\3\2\2\2\2\u016a"+
		"\3\2\2\2\2\u016c\3\2\2\2\2\u016e\3\2\2\2\3\u0170\3\2\2\2\3\u0172\3\2\2"+
		"\2\3\u0174\3\2\2\2\4\u0176\3\2\2\2\6\u0179\3\2\2\2\b\u017c\3\2\2\2\n\u017f"+
		"\3\2\2\2\f\u018b\3\2\2\2\16\u018f\3\2\2\2\20\u0193\3\2\2\2\22\u019b\3"+
		"\2\2\2\24\u019e\3\2\2\2\26\u01a1\3\2\2\2\30\u01a5\3\2\2\2\32\u01a8\3\2"+
		"\2\2\34\u01ad\3\2\2\2\36\u01b0\3\2\2\2 \u01b3\3\2\2\2\"\u01b7\3\2\2\2"+
		"$\u01bc\3\2\2\2&\u01c5\3\2\2\2(\u01ce\3\2\2\2*\u01d5\3\2\2\2,\u01dd\3"+
		"\2\2\2.\u01e3\3\2\2\2\60\u01e8\3\2\2\2\62\u01ed\3\2\2\2\64\u01f3\3\2\2"+
		"\2\66\u01f8\3\2\2\28\u01fe\3\2\2\2:\u0204\3\2\2\2<\u020d\3\2\2\2>\u0215"+
		"\3\2\2\2@\u0218\3\2\2\2B\u021f\3\2\2\2D\u0224\3\2\2\2F\u0229\3\2\2\2H"+
		"\u0231\3\2\2\2J\u0237\3\2\2\2L\u023f\3\2\2\2N\u0245\3\2\2\2P\u0249\3\2"+
		"\2\2R\u024c\3\2\2\2T\u0251\3\2\2\2V\u025c\3\2\2\2X\u0263\3\2\2\2Z\u026e"+
		"\3\2\2\2\\\u0272\3\2\2\2^\u027c\3\2\2\2`\u0281\3\2\2\2b\u0288\3\2\2\2"+
		"d\u028c\3\2\2\2f\u0294\3\2\2\2h\u029c\3\2\2\2j\u02a6\3\2\2\2l\u02ad\3"+
		"\2\2\2n\u02b4\3\2\2\2p\u02ba\3\2\2\2r\u02c1\3\2\2\2t\u02ca\3\2\2\2v\u02d0"+
		"\3\2\2\2x\u02d7\3\2\2\2z\u02e4\3\2\2\2|\u02e9\3\2\2\2~\u02ef\3\2\2\2\u0080"+
		"\u02f6\3\2\2\2\u0082\u0300\3\2\2\2\u0084\u0304\3\2\2\2\u0086\u0309\3\2"+
		"\2\2\u0088\u0312\3\2\2\2\u008a\u0318\3\2\2\2\u008c\u031e\3\2\2\2\u008e"+
		"\u0323\3\2\2\2\u0090\u0329\3\2\2\2\u0092\u032f\3\2\2\2\u0094\u0339\3\2"+
		"\2\2\u0096\u033b\3\2\2\2\u0098\u033f\3\2\2\2\u009a\u0343\3\2\2\2\u009c"+
		"\u0347\3\2\2\2\u009e\u034b\3\2\2\2\u00a0\u0357\3\2\2\2\u00a2\u0359\3\2"+
		"\2\2\u00a4\u0365\3\2\2\2\u00a6\u0367\3\2\2\2\u00a8\u036b\3\2\2\2\u00aa"+
		"\u036e\3\2\2\2\u00ac\u0372\3\2\2\2\u00ae\u0376\3\2\2\2\u00b0\u0380\3\2"+
		"\2\2\u00b2\u0384\3\2\2\2\u00b4\u0386\3\2\2\2\u00b6\u038c\3\2\2\2\u00b8"+
		"\u0396\3\2\2\2\u00ba\u039a\3\2\2\2\u00bc\u039c\3\2\2\2\u00be\u03a0\3\2"+
		"\2\2\u00c0\u03aa\3\2\2\2\u00c2\u03ae\3\2\2\2\u00c4\u03b2\3\2\2\2\u00c6"+
		"\u03cf\3\2\2\2\u00c8\u03d1\3\2\2\2\u00ca\u03d4\3\2\2\2\u00cc\u03d7\3\2"+
		"\2\2\u00ce\u03db\3\2\2\2\u00d0\u03dd\3\2\2\2\u00d2\u03df\3\2\2\2\u00d4"+
		"\u03ef\3\2\2\2\u00d6\u03f1\3\2\2\2\u00d8\u03f4\3\2\2\2\u00da\u03ff\3\2"+
		"\2\2\u00dc\u0409\3\2\2\2\u00de\u040b\3\2\2\2\u00e0\u040d\3\2\2\2\u00e2"+
		"\u0419\3\2\2\2\u00e4\u0425\3\2\2\2\u00e6\u042a\3\2\2\2\u00e8\u0432\3\2"+
		"\2\2\u00ea\u043c\3\2\2\2\u00ec\u0441\3\2\2\2\u00ee\u044e\3\2\2\2\u00f0"+
		"\u0450\3\2\2\2\u00f2\u0457\3\2\2\2\u00f4\u0459\3\2\2\2\u00f6\u045e\3\2"+
		"\2\2\u00f8\u0460\3\2\2\2\u00fa\u0462\3\2\2\2\u00fc\u0464\3\2\2\2\u00fe"+
		"\u0467\3\2\2\2\u0100\u0469\3\2\2\2\u0102\u046b\3\2\2\2\u0104\u046d\3\2"+
		"\2\2\u0106\u046f\3\2\2\2\u0108\u0471\3\2\2\2\u010a\u0474\3\2\2\2\u010c"+
		"\u0476\3\2\2\2\u010e\u0478\3\2\2\2\u0110\u047a\3\2\2\2\u0112\u047c\3\2"+
		"\2\2\u0114\u047e\3\2\2\2\u0116\u0480\3\2\2\2\u0118\u0482\3\2\2\2\u011a"+
		"\u0485\3\2\2\2\u011c\u0489\3\2\2\2\u011e\u048c\3\2\2\2\u0120\u048f\3\2"+
		"\2\2\u0122\u0492\3\2\2\2\u0124\u0496\3\2\2\2\u0126\u0499\3\2\2\2\u0128"+
		"\u049c\3\2\2\2\u012a\u049f\3\2\2\2\u012c\u04a2\3\2\2\2\u012e\u04a4\3\2"+
		"\2\2\u0130\u04a6\3\2\2\2\u0132\u04a8\3\2\2\2\u0134\u04aa\3\2\2\2\u0136"+
		"\u04ac\3\2\2\2\u0138\u04ae\3\2\2\2\u013a\u04b0\3\2\2\2\u013c\u04b2\3\2"+
		"\2\2\u013e\u04b5\3\2\2\2\u0140\u04b8\3\2\2\2\u0142\u04bb\3\2\2\2\u0144"+
		"\u04be\3\2\2\2\u0146\u04c1\3\2\2\2\u0148\u04c4\3\2\2\2\u014a\u04c7\3\2"+
		"\2\2\u014c\u04ca\3\2\2\2\u014e\u04ce\3\2\2\2\u0150\u04d2\3\2\2\2\u0152"+
		"\u04d7\3\2\2\2\u0154\u04e0\3\2\2\2\u0156\u04ed\3\2\2\2\u0158\u04f5\3\2"+
		"\2\2\u015a\u04f7\3\2\2\2\u015c\u04f9\3\2\2\2\u015e\u04fd\3\2\2\2\u0160"+
		"\u0504\3\2\2\2\u0162\u050a\3\2\2\2\u0164\u0518\3\2\2\2\u0166\u0523\3\2"+
		"\2\2\u0168\u0525\3\2\2\2\u016a\u0531\3\2\2\2\u016c\u0542\3\2\2\2\u016e"+
		"\u0555\3\2\2\2\u0170\u0559\3\2\2\2\u0172\u055e\3\2\2\2\u0174\u0562\3\2"+
		"\2\2\u0176\u0177\7<\2\2\u0177\u0178\7<\2\2\u0178\5\3\2\2\2\u0179\u017a"+
		"\7c\2\2\u017a\u017b\7u\2\2\u017b\7\3\2\2\2\u017c\u017d\7k\2\2\u017d\u017e"+
		"\7p\2\2\u017e\t\3\2\2\2\u017f\u0180\7e\2\2\u0180\u0181\7q\2\2\u0181\u0182"+
		"\7p\2\2\u0182\u0183\7u\2\2\u0183\u0184\7v\2\2\u0184\u0185\7t\2\2\u0185"+
		"\u0186\7w\2\2\u0186\u0187\7e\2\2\u0187\u0188\7v\2\2\u0188\u0189\7q\2\2"+
		"\u0189\u018a\7t\2\2\u018a\13\3\2\2\2\u018b\u018c\7x\2\2\u018c\u018d\7"+
		"c\2\2\u018d\u018e\7t\2\2\u018e\r\3\2\2\2\u018f\u0190\7x\2\2\u0190\u0191"+
		"\7c\2\2\u0191\u0192\7n\2\2\u0192\17\3\2\2\2\u0193\u0194\7h\2\2\u0194\u0195"+
		"\7q\2\2\u0195\u0196\7t\2\2\u0196\u0197\7g\2\2\u0197\u0198\7c\2\2\u0198"+
		"\u0199\7e\2\2\u0199\u019a\7j\2\2\u019a\21\3\2\2\2\u019b\u019c\7/\2\2\u019c"+
		"\u019d\7@\2\2\u019d\23\3\2\2\2\u019e\u019f\7?\2\2\u019f\u01a0\7@\2\2\u01a0"+
		"\25\3\2\2\2\u01a1\u01a2\7/\2\2\u01a2\u01a3\7@\2\2\u01a3\u01a4\7@\2\2\u01a4"+
		"\27\3\2\2\2\u01a5\u01a6\7,\2\2\u01a6\u01a7\7\60\2\2\u01a7\31\3\2\2\2\u01a8"+
		"\u01a9\7,\2\2\u01a9\u01aa\7/\2\2\u01aa\u01ab\7@\2\2\u01ab\u01ac\7@\2\2"+
		"\u01ac\33\3\2\2\2\u01ad\u01ae\7A\2\2\u01ae\u01af\7\60\2\2\u01af\35\3\2"+
		"\2\2\u01b0\u01b1\7A\2\2\u01b1\u01b2\7A\2\2\u01b2\37\3\2\2\2\u01b3\u01b4"+
		"\7A\2\2\u01b4\u01b5\7\60\2\2\u01b5\u01b6\7\60\2\2\u01b6!\3\2\2\2\u01b7"+
		"\u01b8\7A\2\2\u01b8\u01b9\7/\2\2\u01b9\u01ba\7@\2\2\u01ba\u01bb\7@\2\2"+
		"\u01bb#\3\2\2\2\u01bc\u01bd\7q\2\2\u01bd\u01be\7x\2\2\u01be\u01bf\7g\2"+
		"\2\u01bf\u01c0\7t\2\2\u01c0\u01c1\7t\2\2\u01c1\u01c2\7k\2\2\u01c2\u01c3"+
		"\7f\2\2\u01c3\u01c4\7g\2\2\u01c4%\3\2\2\2\u01c5\u01c6\7c\2\2\u01c6\u01c7"+
		"\7d\2\2\u01c7\u01c8\7u\2\2\u01c8\u01c9\7v\2\2\u01c9\u01ca\7t\2\2\u01ca"+
		"\u01cb\7c\2\2\u01cb\u01cc\7e\2\2\u01cc\u01cd\7v\2\2\u01cd\'\3\2\2\2\u01ce"+
		"\u01cf\7c\2\2\u01cf\u01d0\7u\2\2\u01d0\u01d1\7u\2\2\u01d1\u01d2\7g\2\2"+
		"\u01d2\u01d3\7t\2\2\u01d3\u01d4\7v\2\2\u01d4)\3\2\2\2\u01d5\u01d6\7d\2"+
		"\2\u01d6\u01d7\7q\2\2\u01d7\u01d8\7q\2\2\u01d8\u01d9\7n\2\2\u01d9\u01da"+
		"\7g\2\2\u01da\u01db\7c\2\2\u01db\u01dc\7p\2\2\u01dc+\3\2\2\2\u01dd\u01de"+
		"\7d\2\2\u01de\u01df\7t\2\2\u01df\u01e0\7g\2\2\u01e0\u01e1\7c\2\2\u01e1"+
		"\u01e2\7m\2\2\u01e2-\3\2\2\2\u01e3\u01e4\7d\2\2\u01e4\u01e5\7{\2\2\u01e5"+
		"\u01e6\7v\2\2\u01e6\u01e7\7g\2\2\u01e7/\3\2\2\2\u01e8\u01e9\7e\2\2\u01e9"+
		"\u01ea\7c\2\2\u01ea\u01eb\7u\2\2\u01eb\u01ec\7g\2\2\u01ec\61\3\2\2\2\u01ed"+
		"\u01ee\7e\2\2\u01ee\u01ef\7c\2\2\u01ef\u01f0\7v\2\2\u01f0\u01f1\7e\2\2"+
		"\u01f1\u01f2\7j\2\2\u01f2\63\3\2\2\2\u01f3\u01f4\7e\2\2\u01f4\u01f5\7"+
		"j\2\2\u01f5\u01f6\7c\2\2\u01f6\u01f7\7t\2\2\u01f7\65\3\2\2\2\u01f8\u01f9"+
		"\7e\2\2\u01f9\u01fa\7n\2\2\u01fa\u01fb\7c\2\2\u01fb\u01fc\7u\2\2\u01fc"+
		"\u01fd\7u\2\2\u01fd\67\3\2\2\2\u01fe\u01ff\7e\2\2\u01ff\u0200\7q\2\2\u0200"+
		"\u0201\7p\2\2\u0201\u0202\7u\2\2\u0202\u0203\7v\2\2\u02039\3\2\2\2\u0204"+
		"\u0205\7e\2\2\u0205\u0206\7q\2\2\u0206\u0207\7p\2\2\u0207\u0208\7v\2\2"+
		"\u0208\u0209\7k\2\2\u0209\u020a\7p\2\2\u020a\u020b\7w\2\2\u020b\u020c"+
		"\7g\2\2\u020c;\3\2\2\2\u020d\u020e\7f\2\2\u020e\u020f\7g\2\2\u020f\u0210"+
		"\7h\2\2\u0210\u0211\7c\2\2\u0211\u0212\7w\2\2\u0212\u0213\7n\2\2\u0213"+
		"\u0214\7v\2\2\u0214=\3\2\2\2\u0215\u0216\7f\2\2\u0216\u0217\7q\2\2\u0217"+
		"?\3\2\2\2\u0218\u0219\7f\2\2\u0219\u021a\7q\2\2\u021a\u021b\7w\2\2\u021b"+
		"\u021c\7d\2\2\u021c\u021d\7n\2\2\u021d\u021e\7g\2\2\u021eA\3\2\2\2\u021f"+
		"\u0220\7g\2\2\u0220\u0221\7n\2\2\u0221\u0222\7u\2\2\u0222\u0223\7g\2\2"+
		"\u0223C\3\2\2\2\u0224\u0225\7g\2\2\u0225\u0226\7p\2\2\u0226\u0227\7w\2"+
		"\2\u0227\u0228\7o\2\2\u0228E\3\2\2\2\u0229\u022a\7g\2\2\u022a\u022b\7"+
		"z\2\2\u022b\u022c\7v\2\2\u022c\u022d\7g\2\2\u022d\u022e\7p\2\2\u022e\u022f"+
		"\7f\2\2\u022f\u0230\7u\2\2\u0230G\3\2\2\2\u0231\u0232\7h\2\2\u0232\u0233"+
		"\7k\2\2\u0233\u0234\7p\2\2\u0234\u0235\7c\2\2\u0235\u0236\7n\2\2\u0236"+
		"I\3\2\2\2\u0237\u0238\7h\2\2\u0238\u0239\7k\2\2\u0239\u023a\7p\2\2\u023a"+
		"\u023b\7c\2\2\u023b\u023c\7n\2\2\u023c\u023d\7n\2\2\u023d\u023e\7{\2\2"+
		"\u023eK\3\2\2\2\u023f\u0240\7h\2\2\u0240\u0241\7n\2\2\u0241\u0242\7q\2"+
		"\2\u0242\u0243\7c\2\2\u0243\u0244\7v\2\2\u0244M\3\2\2\2\u0245\u0246\7"+
		"h\2\2\u0246\u0247\7q\2\2\u0247\u0248\7t\2\2\u0248O\3\2\2\2\u0249\u024a"+
		"\7k\2\2\u024a\u024b\7h\2\2\u024bQ\3\2\2\2\u024c\u024d\7i\2\2\u024d\u024e"+
		"\7q\2\2\u024e\u024f\7v\2\2\u024f\u0250\7q\2\2\u0250S\3\2\2\2\u0251\u0252"+
		"\7k\2\2\u0252\u0253\7o\2\2\u0253\u0254\7r\2\2\u0254\u0255\7n\2\2\u0255"+
		"\u0256\7g\2\2\u0256\u0257\7o\2\2\u0257\u0258\7g\2\2\u0258\u0259\7p\2\2"+
		"\u0259\u025a\7v\2\2\u025a\u025b\7u\2\2\u025bU\3\2\2\2\u025c\u025d\7k\2"+
		"\2\u025d\u025e\7o\2\2\u025e\u025f\7r\2\2\u025f\u0260\7q\2\2\u0260\u0261"+
		"\7t\2\2\u0261\u0262\7v\2\2\u0262W\3\2\2\2\u0263\u0264\7k\2\2\u0264\u0265"+
		"\7p\2\2\u0265\u0266\7u\2\2\u0266\u0267\7v\2\2\u0267\u0268\7c\2\2\u0268"+
		"\u0269\7p\2\2\u0269\u026a\7e\2\2\u026a\u026b\7g\2\2\u026b\u026c\7q\2\2"+
		"\u026c\u026d\7h\2\2\u026dY\3\2\2\2\u026e\u026f\7k\2\2\u026f\u0270\7p\2"+
		"\2\u0270\u0271\7v\2\2\u0271[\3\2\2\2\u0272\u0273\7k\2\2\u0273\u0274\7"+
		"p\2\2\u0274\u0275\7v\2\2\u0275\u0276\7g\2\2\u0276\u0277\7t\2\2\u0277\u0278"+
		"\7h\2\2\u0278\u0279\7c\2\2\u0279\u027a\7e\2\2\u027a\u027b\7g\2\2\u027b"+
		"]\3\2\2\2\u027c\u027d\7n\2\2\u027d\u027e\7q\2\2\u027e\u027f\7p\2\2\u027f"+
		"\u0280\7i\2\2\u0280_\3\2\2\2\u0281\u0282\7p\2\2\u0282\u0283\7c\2\2\u0283"+
		"\u0284\7v\2\2\u0284\u0285\7k\2\2\u0285\u0286\7x\2\2\u0286\u0287\7g\2\2"+
		"\u0287a\3\2\2\2\u0288\u0289\7p\2\2\u0289\u028a\7g\2\2\u028a\u028b\7y\2"+
		"\2\u028bc\3\2\2\2\u028c\u028d\7r\2\2\u028d\u028e\7c\2\2\u028e\u028f\7"+
		"e\2\2\u028f\u0290\7m\2\2\u0290\u0291\7c\2\2\u0291\u0292\7i\2\2\u0292\u0293"+
		"\7g\2\2\u0293e\3\2\2\2\u0294\u0295\7r\2\2\u0295\u0296\7t\2\2\u0296\u0297"+
		"\7k\2\2\u0297\u0298\7x\2\2\u0298\u0299\7c\2\2\u0299\u029a\7v\2\2\u029a"+
		"\u029b\7g\2\2\u029bg\3\2\2\2\u029c\u029d\7r\2\2\u029d\u029e\7t\2\2\u029e"+
		"\u029f\7q\2\2\u029f\u02a0\7v\2\2\u02a0\u02a1\7g\2\2\u02a1\u02a2\7e\2\2"+
		"\u02a2\u02a3\7v\2\2\u02a3\u02a4\7g\2\2\u02a4\u02a5\7f\2\2\u02a5i\3\2\2"+
		"\2\u02a6\u02a7\7r\2\2\u02a7\u02a8\7w\2\2\u02a8\u02a9\7d\2\2\u02a9\u02aa"+
		"\7n\2\2\u02aa\u02ab\7k\2\2\u02ab\u02ac\7e\2\2\u02ack\3\2\2\2\u02ad\u02ae"+
		"\7t\2\2\u02ae\u02af\7g\2\2\u02af\u02b0\7v\2\2\u02b0\u02b1\7w\2\2\u02b1"+
		"\u02b2\7t\2\2\u02b2\u02b3\7p\2\2\u02b3m\3\2\2\2\u02b4\u02b5\7u\2\2\u02b5"+
		"\u02b6\7j\2\2\u02b6\u02b7\7q\2\2\u02b7\u02b8\7t\2\2\u02b8\u02b9\7v\2\2"+
		"\u02b9o\3\2\2\2\u02ba\u02bb\7u\2\2\u02bb\u02bc\7v\2\2\u02bc\u02bd\7c\2"+
		"\2\u02bd\u02be\7v\2\2\u02be\u02bf\7k\2\2\u02bf\u02c0\7e\2\2\u02c0q\3\2"+
		"\2\2\u02c1\u02c2\7u\2\2\u02c2\u02c3\7v\2\2\u02c3\u02c4\7t\2\2\u02c4\u02c5"+
		"\7k\2\2\u02c5\u02c6\7e\2\2\u02c6\u02c7\7v\2\2\u02c7\u02c8\7h\2\2\u02c8"+
		"\u02c9\7r\2\2\u02c9s\3\2\2\2\u02ca\u02cb\7u\2\2\u02cb\u02cc\7w\2\2\u02cc"+
		"\u02cd\7r\2\2\u02cd\u02ce\7g\2\2\u02ce\u02cf\7t\2\2\u02cfu\3\2\2\2\u02d0"+
		"\u02d1\7u\2\2\u02d1\u02d2\7y\2\2\u02d2\u02d3\7k\2\2\u02d3\u02d4\7v\2\2"+
		"\u02d4\u02d5\7e\2\2\u02d5\u02d6\7j\2\2\u02d6w\3\2\2\2\u02d7\u02d8\7u\2"+
		"\2\u02d8\u02d9\7{\2\2\u02d9\u02da\7p\2\2\u02da\u02db\7e\2\2\u02db\u02dc"+
		"\7j\2\2\u02dc\u02dd\7t\2\2\u02dd\u02de\7q\2\2\u02de\u02df\7p\2\2\u02df"+
		"\u02e0\7k\2\2\u02e0\u02e1\7|\2\2\u02e1\u02e2\7g\2\2\u02e2\u02e3\7f\2\2"+
		"\u02e3y\3\2\2\2\u02e4\u02e5\7v\2\2\u02e5\u02e6\7j\2\2\u02e6\u02e7\7k\2"+
		"\2\u02e7\u02e8\7u\2\2\u02e8{\3\2\2\2\u02e9\u02ea\7v\2\2\u02ea\u02eb\7"+
		"j\2\2\u02eb\u02ec\7t\2\2\u02ec\u02ed\7q\2\2\u02ed\u02ee\7y\2\2\u02ee}"+
		"\3\2\2\2\u02ef\u02f0\7v\2\2\u02f0\u02f1\7j\2\2\u02f1\u02f2\7t\2\2\u02f2"+
		"\u02f3\7q\2\2\u02f3\u02f4\7y\2\2\u02f4\u02f5\7u\2\2\u02f5\177\3\2\2\2"+
		"\u02f6\u02f7\7v\2\2\u02f7\u02f8\7t\2\2\u02f8\u02f9\7c\2\2\u02f9\u02fa"+
		"\7p\2\2\u02fa\u02fb\7u\2\2\u02fb\u02fc\7k\2\2\u02fc\u02fd\7g\2\2\u02fd"+
		"\u02fe\7p\2\2\u02fe\u02ff\7v\2\2\u02ff\u0081\3\2\2\2\u0300\u0301\7v\2"+
		"\2\u0301\u0302\7t\2\2\u0302\u0303\7{\2\2\u0303\u0083\3\2\2\2\u0304\u0305"+
		"\7x\2\2\u0305\u0306\7q\2\2\u0306\u0307\7k\2\2\u0307\u0308\7f\2\2\u0308"+
		"\u0085\3\2\2\2\u0309\u030a\7x\2\2\u030a\u030b\7q\2\2\u030b\u030c\7n\2"+
		"\2\u030c\u030d\7c\2\2\u030d\u030e\7v\2\2\u030e\u030f\7k\2\2\u030f\u0310"+
		"\7n\2\2\u0310\u0311\7g\2\2\u0311\u0087\3\2\2\2\u0312\u0313\7y\2\2\u0313"+
		"\u0314\7j\2\2\u0314\u0315\7k\2\2\u0315\u0316\7n\2\2\u0316\u0317\7g\2\2"+
		"\u0317\u0089\3\2\2\2\u0318\u0319\7o\2\2\u0319\u031a\7k\2\2\u031a\u031b"+
		"\7z\2\2\u031b\u031c\7k\2\2\u031c\u031d\7p\2\2\u031d\u008b\3\2\2\2\u031e"+
		"\u031f\7y\2\2\u031f\u0320\7k\2\2\u0320\u0321\7v\2\2\u0321\u0322\7j\2\2"+
		"\u0322\u008d\3\2\2\2\u0323\u0324\7c\2\2\u0324\u0325\7u\2\2\u0325\u0326"+
		"\7{\2\2\u0326\u0327\7p\2\2\u0327\u0328\7e\2\2\u0328\u008f\3\2\2\2\u0329"+
		"\u032a\7c\2\2\u032a\u032b\7y\2\2\u032b\u032c\7c\2\2\u032c\u032d\7k\2\2"+
		"\u032d\u032e\7v\2\2\u032e\u0091\3\2\2\2\u032f\u0330\7{\2\2\u0330\u0331"+
		"\7k\2\2\u0331\u0332\7g\2\2\u0332\u0333\7n\2\2\u0333\u0334\7f\2\2\u0334"+
		"\u0093\3\2\2\2\u0335\u033a\5\u0096K\2\u0336\u033a\5\u0098L\2\u0337\u033a"+
		"\5\u009aM\2\u0338\u033a\5\u009cN\2\u0339\u0335\3\2\2\2\u0339\u0336\3\2"+
		"\2\2\u0339\u0337\3\2\2\2\u0339\u0338\3\2\2\2\u033a\u0095\3\2\2\2\u033b"+
		"\u033d\5\u00a0P\2\u033c\u033e\5\u009eO\2\u033d\u033c\3\2\2\2\u033d\u033e"+
		"\3\2\2\2\u033e\u0097\3\2\2\2\u033f\u0341\5\u00acV\2\u0340\u0342\5\u009e"+
		"O\2\u0341\u0340\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0099\3\2\2\2\u0343"+
		"\u0345\5\u00b4Z\2\u0344\u0346\5\u009eO\2\u0345\u0344\3\2\2\2\u0345\u0346"+
		"\3\2\2\2\u0346\u009b\3\2\2\2\u0347\u0349\5\u00bc^\2\u0348\u034a\5\u009e"+
		"O\2\u0349\u0348\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u009d\3\2\2\2\u034b"+
		"\u034c\t\2\2\2\u034c\u009f\3\2\2\2\u034d\u0358\7\62\2\2\u034e\u0355\5"+
		"\u00a6S\2\u034f\u0351\5\u00a2Q\2\u0350\u034f\3\2\2\2\u0350\u0351\3\2\2"+
		"\2\u0351\u0356\3\2\2\2\u0352\u0353\5\u00aaU\2\u0353\u0354\5\u00a2Q\2\u0354"+
		"\u0356\3\2\2\2\u0355\u0350\3\2\2\2\u0355\u0352\3\2\2\2\u0356\u0358\3\2"+
		"\2\2\u0357\u034d\3\2\2\2\u0357\u034e\3\2\2\2\u0358\u00a1\3\2\2\2\u0359"+
		"\u0361\5\u00a4R\2\u035a\u035c\5\u00a8T\2\u035b\u035a\3\2\2\2\u035c\u035f"+
		"\3\2\2\2\u035d\u035b\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0360\3\2\2\2\u035f"+
		"\u035d\3\2\2\2\u0360\u0362\5\u00a4R\2\u0361\u035d\3\2\2\2\u0361\u0362"+
		"\3\2\2\2\u0362\u00a3\3\2\2\2\u0363\u0366\7\62\2\2\u0364\u0366\5\u00a6"+
		"S\2\u0365\u0363\3\2\2\2\u0365\u0364\3\2\2\2\u0366\u00a5\3\2\2\2\u0367"+
		"\u0368\t\3\2\2\u0368\u00a7\3\2\2\2\u0369\u036c\5\u00a4R\2\u036a\u036c"+
		"\7a\2\2\u036b\u0369\3\2\2\2\u036b\u036a\3\2\2\2\u036c\u00a9\3\2\2\2\u036d"+
		"\u036f\7a\2\2\u036e\u036d\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u036e\3\2"+
		"\2\2\u0370\u0371\3\2\2\2\u0371\u00ab\3\2\2\2\u0372\u0373\7\62\2\2\u0373"+
		"\u0374\t\4\2\2\u0374\u0375\5\u00aeW\2\u0375\u00ad\3\2\2\2\u0376\u037e"+
		"\5\u00b0X\2\u0377\u0379\5\u00b2Y\2\u0378\u0377\3\2\2\2\u0379\u037c\3\2"+
		"\2\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037d\3\2\2\2\u037c"+
		"\u037a\3\2\2\2\u037d\u037f\5\u00b0X\2\u037e\u037a\3\2\2\2\u037e\u037f"+
		"\3\2\2\2\u037f\u00af\3\2\2\2\u0380\u0381\t\5\2\2\u0381\u00b1\3\2\2\2\u0382"+
		"\u0385\5\u00b0X\2\u0383\u0385\7a\2\2\u0384\u0382\3\2\2\2\u0384\u0383\3"+
		"\2\2\2\u0385\u00b3\3\2\2\2\u0386\u0388\7\62\2\2\u0387\u0389\5\u00aaU\2"+
		"\u0388\u0387\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038b"+
		"\5\u00b6[\2\u038b\u00b5\3\2\2\2\u038c\u0394\5\u00b8\\\2\u038d\u038f\5"+
		"\u00ba]\2\u038e\u038d\3\2\2\2\u038f\u0392\3\2\2\2\u0390\u038e\3\2\2\2"+
		"\u0390\u0391\3\2\2\2\u0391\u0393\3\2\2\2\u0392\u0390\3\2\2\2\u0393\u0395"+
		"\5\u00b8\\\2\u0394\u0390\3\2\2\2\u0394\u0395\3\2\2\2\u0395\u00b7\3\2\2"+
		"\2\u0396\u0397\t\6\2\2\u0397\u00b9\3\2\2\2\u0398\u039b\5\u00b8\\\2\u0399"+
		"\u039b\7a\2\2\u039a\u0398\3\2\2\2\u039a\u0399\3\2\2\2\u039b\u00bb\3\2"+
		"\2\2\u039c\u039d\7\62\2\2\u039d\u039e\t\7\2\2\u039e\u039f\5\u00be_\2\u039f"+
		"\u00bd\3\2\2\2\u03a0\u03a8\5\u00c0`\2\u03a1\u03a3\5\u00c2a\2\u03a2\u03a1"+
		"\3\2\2\2\u03a3\u03a6\3\2\2\2\u03a4\u03a2\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5"+
		"\u03a7\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a7\u03a9\5\u00c0`\2\u03a8\u03a4"+
		"\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u00bf\3\2\2\2\u03aa\u03ab\t\b\2\2\u03ab"+
		"\u00c1\3\2\2\2\u03ac\u03af\5\u00c0`\2\u03ad\u03af\7a\2\2\u03ae\u03ac\3"+
		"\2\2\2\u03ae\u03ad\3\2\2\2\u03af\u00c3\3\2\2\2\u03b0\u03b3\5\u00c6c\2"+
		"\u03b1\u03b3\5\u00d2i\2\u03b2\u03b0\3\2\2\2\u03b2\u03b1\3\2\2\2\u03b3"+
		"\u00c5\3\2\2\2\u03b4\u03b5\5\u00a2Q\2\u03b5\u03b7\7\60\2\2\u03b6\u03b8"+
		"\5\u00a2Q\2\u03b7\u03b6\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\u03ba\3\2\2"+
		"\2\u03b9\u03bb\5\u00c8d\2\u03ba\u03b9\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb"+
		"\u03bd\3\2\2\2\u03bc\u03be\5\u00d0h\2\u03bd\u03bc\3\2\2\2\u03bd\u03be"+
		"\3\2\2\2\u03be\u03d0\3\2\2\2\u03bf\u03c0\7\60\2\2\u03c0\u03c2\5\u00a2"+
		"Q\2\u03c1\u03c3\5\u00c8d\2\u03c2\u03c1\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3"+
		"\u03c5\3\2\2\2\u03c4\u03c6\5\u00d0h\2\u03c5\u03c4\3\2\2\2\u03c5\u03c6"+
		"\3\2\2\2\u03c6\u03d0\3\2\2\2\u03c7\u03c8\5\u00a2Q\2\u03c8\u03ca\5\u00c8"+
		"d\2\u03c9\u03cb\5\u00d0h\2\u03ca\u03c9\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb"+
		"\u03d0\3\2\2\2\u03cc\u03cd\5\u00a2Q\2\u03cd\u03ce\5\u00d0h\2\u03ce\u03d0"+
		"\3\2\2\2\u03cf\u03b4\3\2\2\2\u03cf\u03bf\3\2\2\2\u03cf\u03c7\3\2\2\2\u03cf"+
		"\u03cc\3\2\2\2\u03d0\u00c7\3\2\2\2\u03d1\u03d2\5\u00cae\2\u03d2\u03d3"+
		"\5\u00ccf\2\u03d3\u00c9\3\2\2\2\u03d4\u03d5\t\t\2\2\u03d5\u00cb\3\2\2"+
		"\2\u03d6\u03d8\5\u00ceg\2\u03d7\u03d6\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8"+
		"\u03d9\3\2\2\2\u03d9\u03da\5\u00a2Q\2\u03da\u00cd\3\2\2\2\u03db\u03dc"+
		"\t\n\2\2\u03dc\u00cf\3\2\2\2\u03dd\u03de\t\13\2\2\u03de\u00d1\3\2\2\2"+
		"\u03df\u03e0\5\u00d4j\2\u03e0\u03e2\5\u00d6k\2\u03e1\u03e3\5\u00d0h\2"+
		"\u03e2\u03e1\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u00d3\3\2\2\2\u03e4\u03e6"+
		"\5\u00acV\2\u03e5\u03e7\7\60\2\2\u03e6\u03e5\3\2\2\2\u03e6\u03e7\3\2\2"+
		"\2\u03e7\u03f0\3\2\2\2\u03e8\u03e9\7\62\2\2\u03e9\u03eb\t\4\2\2\u03ea"+
		"\u03ec\5\u00aeW\2\u03eb\u03ea\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03ed"+
		"\3\2\2\2\u03ed\u03ee\7\60\2\2\u03ee\u03f0\5\u00aeW\2\u03ef\u03e4\3\2\2"+
		"\2\u03ef\u03e8\3\2\2\2\u03f0\u00d5\3\2\2\2\u03f1\u03f2\5\u00d8l\2\u03f2"+
		"\u03f3\5\u00ccf\2\u03f3\u00d7\3\2\2\2\u03f4\u03f5\t\f\2\2\u03f5\u00d9"+
		"\3\2\2\2\u03f6\u03f7\7v\2\2\u03f7\u03f8\7t\2\2\u03f8\u03f9\7w\2\2\u03f9"+
		"\u0400\7g\2\2\u03fa\u03fb\7h\2\2\u03fb\u03fc\7c\2\2\u03fc\u03fd\7n\2\2"+
		"\u03fd\u03fe\7u\2\2\u03fe\u0400\7g\2\2\u03ff\u03f6\3\2\2\2\u03ff\u03fa"+
		"\3\2\2\2\u0400\u00db\3\2\2\2\u0401\u0402\7)\2\2\u0402\u0403\5\u00deo\2"+
		"\u0403\u0404\7)\2\2\u0404\u040a\3\2\2\2\u0405\u0406\7)\2\2\u0406\u0407"+
		"\5\u00ecv\2\u0407\u0408\7)\2\2\u0408\u040a\3\2\2\2\u0409\u0401\3\2\2\2"+
		"\u0409\u0405\3\2\2\2\u040a\u00dd\3\2\2\2\u040b\u040c\n\r\2\2\u040c\u00df"+
		"\3\2\2\2\u040d\u040f\7$\2\2\u040e\u0410\5\u00e4r\2\u040f\u040e\3\2\2\2"+
		"\u040f\u0410\3\2\2\2\u0410\u0414\3\2\2\2\u0411\u0413\7&\2\2\u0412\u0411"+
		"\3\2\2\2\u0413\u0416\3\2\2\2\u0414\u0412\3\2\2\2\u0414\u0415\3\2\2\2\u0415"+
		"\u0417\3\2\2\2\u0416\u0414\3\2\2\2\u0417\u0418\7$\2\2\u0418\u00e1\3\2"+
		"\2\2\u0419\u041a\7)\2\2\u041a\u041b\7)\2\2\u041b\u041c\7)\2\2\u041c\u041e"+
		"\3\2\2\2\u041d\u041f\5\u00e6s\2\u041e\u041d\3\2\2\2\u041e\u041f\3\2\2"+
		"\2\u041f\u0420\3\2\2\2\u0420\u0421\7)\2\2\u0421\u0422\7)\2\2\u0422\u0423"+
		"\7)\2\2\u0423\u00e3\3\2\2\2\u0424\u0426\5\u00e8t\2\u0425\u0424\3\2\2\2"+
		"\u0426\u0427\3\2\2\2\u0427\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u00e5"+
		"\3\2\2\2\u0429\u042b\5\u00eau\2\u042a\u0429\3\2\2\2\u042b\u042c\3\2\2"+
		"\2\u042c\u042a\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u00e7\3\2\2\2\u042e\u0433"+
		"\n\16\2\2\u042f\u0430\7&\2\2\u0430\u0433\n\17\2\2\u0431\u0433\5\u00ec"+
		"v\2\u0432\u042e\3\2\2\2\u0432\u042f\3\2\2\2\u0432\u0431\3\2\2\2\u0433"+
		"\u00e9\3\2\2\2\u0434\u043d\n\r\2\2\u0435\u0436\7)\2\2\u0436\u043d\n\20"+
		"\2\2\u0437\u0438\7)\2\2\u0438\u0439\7)\2\2\u0439\u043a\3\2\2\2\u043a\u043d"+
		"\n\20\2\2\u043b\u043d\5\u00ecv\2\u043c\u0434\3\2\2\2\u043c\u0435\3\2\2"+
		"\2\u043c\u0437\3\2\2\2\u043c\u043b\3\2\2\2\u043d\u00eb\3\2\2\2\u043e\u043f"+
		"\7^\2\2\u043f\u0442\13\2\2\2\u0440\u0442\5\u00f0x\2\u0441\u043e\3\2\2"+
		"\2\u0441\u0440\3\2\2\2\u0442\u00ed\3\2\2\2\u0443\u0444\7^\2\2\u0444\u044f"+
		"\5\u00b8\\\2\u0445\u0446\7^\2\2\u0446\u0447\5\u00b8\\\2\u0447\u0448\5"+
		"\u00b8\\\2\u0448\u044f\3\2\2\2\u0449\u044a\7^\2\2\u044a\u044b\5\u00f2"+
		"y\2\u044b\u044c\5\u00b8\\\2\u044c\u044d\5\u00b8\\\2\u044d\u044f\3\2\2"+
		"\2\u044e\u0443\3\2\2\2\u044e\u0445\3\2\2\2\u044e\u0449\3\2\2\2\u044f\u00ef"+
		"\3\2\2\2\u0450\u0451\7^\2\2\u0451\u0452\7w\2\2\u0452\u0453\5\u00b0X\2"+
		"\u0453\u0454\5\u00b0X\2\u0454\u0455\5\u00b0X\2\u0455\u0456\5\u00b0X\2"+
		"\u0456\u00f1\3\2\2\2\u0457\u0458\t\21\2\2\u0458\u00f3\3\2\2\2\u0459\u045a"+
		"\7p\2\2\u045a\u045b\7w\2\2\u045b\u045c\7n\2\2\u045c\u045d\7n\2\2\u045d"+
		"\u00f5\3\2\2\2\u045e\u045f\7*\2\2\u045f\u00f7\3\2\2\2\u0460\u0461\7+\2"+
		"\2\u0461\u00f9\3\2\2\2\u0462\u0463\7}\2\2\u0463\u00fb\3\2\2\2\u0464\u0465"+
		"\7\177\2\2\u0465\u0466\b~\2\2\u0466\u00fd\3\2\2\2\u0467\u0468\7]\2\2\u0468"+
		"\u00ff\3\2\2\2\u0469\u046a\7_\2\2\u046a\u0101\3\2\2\2\u046b\u046c\7=\2"+
		"\2\u046c\u0103\3\2\2\2\u046d\u046e\7.\2\2\u046e\u0105\3\2\2\2\u046f\u0470"+
		"\7\60\2\2\u0470\u0107\3\2\2\2\u0471\u0472\7\60\2\2\u0472\u0473\7\60\2"+
		"\2\u0473\u0109\3\2\2\2\u0474\u0475\7?\2\2\u0475\u010b\3\2\2\2\u0476\u0477"+
		"\7@\2\2\u0477\u010d\3\2\2\2\u0478\u0479\7>\2\2\u0479\u010f\3\2\2\2\u047a"+
		"\u047b\7#\2\2\u047b\u0111\3\2\2\2\u047c\u047d\7\u0080\2\2\u047d\u0113"+
		"\3\2\2\2\u047e\u047f\7A\2\2\u047f\u0115\3\2\2\2\u0480\u0481\7<\2\2\u0481"+
		"\u0117\3\2\2\2\u0482\u0483\7?\2\2\u0483\u0484\7?\2\2\u0484\u0119\3\2\2"+
		"\2\u0485\u0486\7?\2\2\u0486\u0487\7?\2\2\u0487\u0488\7?\2\2\u0488\u011b"+
		"\3\2\2\2\u0489\u048a\7>\2\2\u048a\u048b\7?\2\2\u048b\u011d\3\2\2\2\u048c"+
		"\u048d\7@\2\2\u048d\u048e\7?\2\2\u048e\u011f\3\2\2\2\u048f\u0490\7#\2"+
		"\2\u0490\u0491\7?\2\2\u0491\u0121\3\2\2\2\u0492\u0493\7#\2\2\u0493\u0494"+
		"\7?\2\2\u0494\u0495\7?\2\2\u0495\u0123\3\2\2\2\u0496\u0497\7(\2\2\u0497"+
		"\u0498\7(\2\2\u0498\u0125\3\2\2\2\u0499\u049a\7~\2\2\u049a\u049b\7~\2"+
		"\2\u049b\u0127\3\2\2\2\u049c\u049d\7-\2\2\u049d\u049e\7-\2\2\u049e\u0129"+
		"\3\2\2\2\u049f\u04a0\7/\2\2\u04a0\u04a1\7/\2\2\u04a1\u012b\3\2\2\2\u04a2"+
		"\u04a3\7-\2\2\u04a3\u012d\3\2\2\2\u04a4\u04a5\7/\2\2\u04a5\u012f\3\2\2"+
		"\2\u04a6\u04a7\7,\2\2\u04a7\u0131\3\2\2\2\u04a8\u04a9\7\61\2\2\u04a9\u0133"+
		"\3\2\2\2\u04aa\u04ab\7(\2\2\u04ab\u0135\3\2\2\2\u04ac\u04ad\7~\2\2\u04ad"+
		"\u0137\3\2\2\2\u04ae\u04af\7`\2\2\u04af\u0139\3\2\2\2\u04b0\u04b1\7\'"+
		"\2\2\u04b1\u013b\3\2\2\2\u04b2\u04b3\7-\2\2\u04b3\u04b4\7?\2\2\u04b4\u013d"+
		"\3\2\2\2\u04b5\u04b6\7/\2\2\u04b6\u04b7\7?\2\2\u04b7\u013f\3\2\2\2\u04b8"+
		"\u04b9\7,\2\2\u04b9\u04ba\7?\2\2\u04ba\u0141\3\2\2\2\u04bb\u04bc\7\61"+
		"\2\2\u04bc\u04bd\7?\2\2\u04bd\u0143\3\2\2\2\u04be\u04bf\7(\2\2\u04bf\u04c0"+
		"\7?\2\2\u04c0\u0145\3\2\2\2\u04c1\u04c2\7~\2\2\u04c2\u04c3\7?\2\2\u04c3"+
		"\u0147\3\2\2\2\u04c4\u04c5\7`\2\2\u04c5\u04c6\7?\2\2\u04c6\u0149\3\2\2"+
		"\2\u04c7\u04c8\7\'\2\2\u04c8\u04c9\7?\2\2\u04c9\u014b\3\2\2\2\u04ca\u04cb"+
		"\7>\2\2\u04cb\u04cc\7>\2\2\u04cc\u04cd\7?\2\2\u04cd\u014d\3\2\2\2\u04ce"+
		"\u04cf\7@\2\2\u04cf\u04d0\7@\2\2\u04d0\u04d1\7?\2\2\u04d1\u014f\3\2\2"+
		"\2\u04d2\u04d3\7@\2\2\u04d3\u04d4\7@\2\2\u04d4\u04d5\7@\2\2\u04d5\u04d6"+
		"\7?\2\2\u04d6\u0151\3\2\2\2\u04d7\u04d9\7$\2\2\u04d8\u04da\5\u00e4r\2"+
		"\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc"+
		"\7&\2\2\u04dc\u04dd\7}\2\2\u04dd\u04de\3\2\2\2\u04de\u04df\b\u00a9\3\2"+
		"\u04df\u0153\3\2\2\2\u04e0\u04e4\5\u0156\u00ab\2\u04e1\u04e3\5\u0158\u00ac"+
		"\2\u04e2\u04e1\3\2\2\2\u04e3\u04e6\3\2\2\2\u04e4\u04e2\3\2\2\2\u04e4\u04e5"+
		"\3\2\2\2\u04e5\u0155\3\2\2\2\u04e6\u04e4\3\2\2\2\u04e7\u04ee\t\22\2\2"+
		"\u04e8\u04e9\n\23\2\2\u04e9\u04ee\6\u00ab\2\2\u04ea\u04eb\t\24\2\2\u04eb"+
		"\u04ec\t\25\2\2\u04ec\u04ee\6\u00ab\3\2\u04ed\u04e7\3\2\2\2\u04ed\u04e8"+
		"\3\2\2\2\u04ed\u04ea\3\2\2\2\u04ee\u0157\3\2\2\2\u04ef\u04f6\t\26\2\2"+
		"\u04f0\u04f1\n\23\2\2\u04f1\u04f6\6\u00ac\4\2\u04f2\u04f3\t\24\2\2\u04f3"+
		"\u04f4\t\25\2\2\u04f4\u04f6\6\u00ac\5\2\u04f5\u04ef\3\2\2\2\u04f5\u04f0"+
		"\3\2\2\2\u04f5\u04f2\3\2\2\2\u04f6\u0159\3\2\2\2\u04f7\u04f8\7B\2\2\u04f8"+
		"\u015b\3\2\2\2\u04f9\u04fa\7\60\2\2\u04fa\u04fb\7\60\2\2\u04fb\u04fc\7"+
		"\60\2\2\u04fc\u015d\3\2\2\2\u04fd\u04ff\7%\2\2\u04fe\u0500\n\27\2\2\u04ff"+
		"\u04fe\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u04ff\3\2\2\2\u0501\u0502\3\2"+
		"\2\2\u0502\u015f\3\2\2\2\u0503\u0505\t\30\2\2\u0504\u0503\3\2\2\2\u0505"+
		"\u0506\3\2\2\2\u0506\u0504\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u0508\3\2"+
		"\2\2\u0508\u0509\b\u00b0\4\2\u0509\u0161\3\2\2\2\u050a\u050b\7\61\2\2"+
		"\u050b\u050c\7,\2\2\u050c\u0510\3\2\2\2\u050d\u050f\13\2\2\2\u050e\u050d"+
		"\3\2\2\2\u050f\u0512\3\2\2\2\u0510\u0511\3\2\2\2\u0510\u050e\3\2\2\2\u0511"+
		"\u0513\3\2\2\2\u0512\u0510\3\2\2\2\u0513\u0514\7,\2\2\u0514\u0515\7\61"+
		"\2\2\u0515\u0516\3\2\2\2\u0516\u0517\b\u00b1\5\2\u0517\u0163\3\2\2\2\u0518"+
		"\u0519\7\61\2\2\u0519\u051a\7\61\2\2\u051a\u051e\3\2\2\2\u051b\u051d\n"+
		"\27\2\2\u051c\u051b\3\2\2\2\u051d\u0520\3\2\2\2\u051e\u051c\3\2\2\2\u051e"+
		"\u051f\3\2\2\2\u051f\u0521\3\2\2\2\u0520\u051e\3\2\2\2\u0521\u0522\b\u00b2"+
		"\5\2\u0522\u0165\3\2\2\2\u0523\u0524\7^\2\2\u0524\u0167\3\2\2\2\u0525"+
		"\u0527\7$\2\2\u0526\u0528\5\u00e4r\2\u0527\u0526\3\2\2\2\u0527\u0528\3"+
		"\2\2\2\u0528\u052c\3\2\2\2\u0529\u052b\7&\2\2\u052a\u0529\3\2\2\2\u052b"+
		"\u052e\3\2\2\2\u052c\u052a\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u052f\3\2"+
		"\2\2\u052e\u052c\3\2\2\2\u052f\u0530\t\27\2\2\u0530\u0169\3\2\2\2\u0531"+
		"\u0532\7)\2\2\u0532\u0533\7)\2\2\u0533\u0534\7)\2\2\u0534\u0538\3\2\2"+
		"\2\u0535\u0537\5\u00e6s\2\u0536\u0535\3\2\2\2\u0537\u053a\3\2\2\2\u0538"+
		"\u0539\3\2\2\2\u0538\u0536\3\2\2\2\u0539\u053e\3\2\2\2\u053a\u0538\3\2"+
		"\2\2\u053b\u053f\7)\2\2\u053c\u053d\7)\2\2\u053d\u053f\7)\2\2\u053e\u053b"+
		"\3\2\2\2\u053e\u053c\3\2\2\2\u053e\u053f\3\2\2\2\u053f\u0540\3\2\2\2\u0540"+
		"\u0541\7\2\2\3\u0541\u016b\3\2\2\2\u0542\u0543\7\61\2\2\u0543\u0544\7"+
		",\2\2\u0544\u054c\3\2\2\2\u0545\u054b\n\31\2\2\u0546\u0547\7,\2\2\u0547"+
		"\u054b\n\32\2\2\u0548\u0549\n\33\2\2\u0549\u054b\7\61\2\2\u054a\u0545"+
		"\3\2\2\2\u054a\u0546\3\2\2\2\u054a\u0548\3\2\2\2\u054b\u054e\3\2\2\2\u054c"+
		"\u054d\3\2\2\2\u054c\u054a\3\2\2\2\u054d\u0550\3\2\2\2\u054e\u054c\3\2"+
		"\2\2\u054f\u0551\7,\2\2\u0550\u054f\3\2\2\2\u0550\u0551\3\2\2\2\u0551"+
		"\u0552\3\2\2\2\u0552\u0553\7\2\2\3\u0553\u016d\3\2\2\2\u0554\u0556\13"+
		"\2\2\2\u0555\u0554\3\2\2\2\u0556\u0557\3\2\2\2\u0557\u0558\3\2\2\2\u0557"+
		"\u0555\3\2\2\2\u0558\u016f\3\2\2\2\u0559\u055a\7&\2\2\u055a\u055b\7}\2"+
		"\2\u055b\u055c\3\2\2\2\u055c\u055d\b\u00b8\6\2\u055d\u0171\3\2\2\2\u055e"+
		"\u055f\7$\2\2\u055f\u0560\b\u00b9\7\2\u0560\u0173\3\2\2\2\u0561\u0563"+
		"\5\u00e8t\2\u0562\u0561\3\2\2\2\u0563\u0564\3\2\2\2\u0564\u0562\3\2\2"+
		"\2\u0564\u0565\3\2\2\2\u0565\u0175\3\2\2\2D\2\3\u0339\u033d\u0341\u0345"+
		"\u0349\u0350\u0355\u0357\u035d\u0361\u0365\u036b\u0370\u037a\u037e\u0384"+
		"\u0388\u0390\u0394\u039a\u03a4\u03a8\u03ae\u03b2\u03b7\u03ba\u03bd\u03c2"+
		"\u03c5\u03ca\u03cf\u03d7\u03e2\u03e6\u03eb\u03ef\u03ff\u0409\u040f\u0414"+
		"\u041e\u0427\u042c\u0432\u043c\u0441\u044e\u04d9\u04e4\u04ed\u04f5\u0501"+
		"\u0506\u0510\u051e\u0527\u052c\u0538\u053e\u054a\u054c\u0550\u0557\u0564"+
		"\b\3~\2\3\u00a9\3\2\5\2\2\4\2\6\2\2\3\u00b9\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
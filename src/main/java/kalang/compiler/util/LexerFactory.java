
package kalang.compiler.util;
import kalang.compiler.antlr.KalangLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
/**
 *
 * @author Kason Yang 
 */
public class LexerFactory {
    
    public static KalangLexer createLexer(CharStream input){
        return new KalangLexer(input);
    }
    
    public static KalangLexer createLexer(String source){
        KalangLexer lexer = createLexer(new ANTLRInputStream(source));
        return lexer;
    }

}

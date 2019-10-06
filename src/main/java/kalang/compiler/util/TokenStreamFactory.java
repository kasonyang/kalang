
package kalang.compiler.util;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;

/**
 *
 * @author Kason Yang 
 */
public class TokenStreamFactory {
    
    public static CommonTokenStream createTokenStream(String source) {
        return createTokenStream(LexerFactory.createLexer(source));
    }
    
    public static CommonTokenStream createTokenStream(TokenSource lexer) {
        return new CommonTokenStream(lexer);
    }
    
}

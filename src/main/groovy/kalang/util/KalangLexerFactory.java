
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.antlr.KalangLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangLexerFactory {
    
    public static KalangLexer createLexer(CharStream input){
        return new KalangLexer(input);
    }
    
    public static KalangLexer createLexer(String source){
        KalangLexer lexer = createLexer(new ANTLRInputStream(source));
        return lexer;
    }

}

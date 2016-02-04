
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.compiler.AntlrErrorString;
import kalang.compiler.SourceParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class SourceParserFactory {
    
    public static SourceParser createSourceParser(String clsName,KalangLexer lexer){
        return createSourceParser(
                clsName
                ,TokenStreamFactory.createTokenStream(lexer)
        );
    }
    
    public static SourceParser createSourceParser(String clsName,String source){
        return createSourceParser(
                clsName
                ,TokenStreamFactory.createTokenStream(source)
        );
    }
        
    public static SourceParser createSourceParser(String clsName,TokenStream tokens){
        KalangParser p = new KalangParser(tokens);
        SourceParser sp = new SourceParser(clsName, p);
        p.setErrorHandler(new DefaultErrorStrategy() {

            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                String msg = AntlrErrorString.exceptionString(recognizer, e);
                RuleContext ctx = e.getCtx();
                if (ctx == null) {
                    Token tk = e.getOffendingToken();
                    sp.reportError(msg, tk);
                } else {
                    sp.reportError(msg, ctx);
                }
            }
        });
        return sp;
    }

}

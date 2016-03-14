
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.compiler.AstBuilder;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class AstBuilderFactory {
    
    public static AstBuilder createAstBuilder(String clsName,KalangLexer lexer){
        return AstBuilderFactory.createAstBuilder(
                clsName
                ,TokenStreamFactory.createTokenStream(lexer)
        );
    }
    
    public static AstBuilder createAstBuilder(String clsName,String source){
        return AstBuilderFactory.createAstBuilder(
                clsName
                ,TokenStreamFactory.createTokenStream(source)
        );
    }
        
    public static AstBuilder createAstBuilder(String clsName,TokenStream tokens){
        KalangParser p = new KalangParser(tokens);
        AstBuilder sp = new AstBuilder(clsName, p);
        p.setErrorHandler(new DefaultErrorStrategy() {

            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                String msg = AntlrErrorString.exceptionString(recognizer, e);
//                RuleContext ctx = e.getCtx();
//                while(ctx!=null && !(ctx instanceof ParserRuleContext)){
//                    ctx = ctx.getParent();
//                }
                sp.reportError(msg, e.getOffendingToken());
//                if(ctx!=null){
//                    sp.reportError(msg, e.getOffendingToken(), (ParserRuleContext) ctx);
//                }else{
//                    sp.reportError(msg, e.getOffendingToken(),null);
//                }
            }
        });
        return sp;
    }

}

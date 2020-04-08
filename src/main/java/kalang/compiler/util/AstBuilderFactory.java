
package kalang.compiler.util;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.compile.*;
import org.antlr.v4.runtime.*;
/**
 *
 * @author Kason Yang 
 */
public class AstBuilderFactory {
    
    public static AstBuilder createAstBuilder(CompilationUnit source,KalangLexer lexer){
        return createAstBuilder(
                source
                ,TokenStreamFactory.createTokenStream(lexer)
        );
    }
    
    public static AstBuilder createAstBuilder(CompilationUnit source){
        return createAstBuilder(
                source
                ,TokenStreamFactory.createTokenStream(source.getSource().getText())
        );
    }
        
    public static AstBuilder createAstBuilder(CompilationUnit compilationUnit,TokenStream tokens){
        KalangParser p = new KalangParser(tokens);
        AstBuilder sp = new AstBuilder(compilationUnit, p);
        DiagnosisReporter diagnosisReporter = new DiagnosisReporter(compilationUnit);
        p.setErrorHandler(new DefaultErrorStrategy() {

            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                String msg = AntlrErrorString.exceptionString(recognizer, e);
                Token end = e.getOffendingToken();
                Token start;
                RuleContext ctx = e.getCtx();
                if(ctx instanceof ParserRuleContext){
                    start = ((ParserRuleContext) ctx).getStart();
                }else{
                    start = end;
                }
                OffsetRange offset = OffsetRangeHelper.getOffsetRange(start, end);
                diagnosisReporter.report(Diagnosis.Kind.ERROR, msg, offset);
            }
        });
        return sp;
    }

}

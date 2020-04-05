package kalang.compiler.antlr;

import kalang.compiler.compile.CompilationUnit;
import org.antlr.v4.runtime.*;

import java.util.logging.Logger;

/**
 * @author KasonYang
 */
public class SLLErrorStrategy extends BailErrorStrategy {

    private final static Logger LOG = Logger.getLogger(SLLErrorStrategy.class.getName());

    private final CompilationUnit compilationUnit;

    public SLLErrorStrategy(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        logSLLFailed(e.getOffendingToken());
        super.recover(recognizer, e);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        ParserRuleContext ctx = recognizer.getContext();
        if (ctx != null) {
            logSLLFailed(ctx.getStart());
        }
        return super.recoverInline(recognizer);
    }

    private void logSLLFailed(Token token) {
        int line = token.getLine();
        String sourceName = compilationUnit.getSource().getFileName();
        LOG.fine("SLL failed:" + sourceName + ":" + line);
    }

}

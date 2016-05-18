
package kalang.compiler;
import kalang.util.OffsetRangeHelper;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author Kason Yang
 */
public class SyntaxError extends CompileError{

    private final ParserRuleContext rule;
    private final Token start;
    private final Token stop;

    public SyntaxError(String description, CompilationUnit source,ParserRuleContext rule,Token start,Token stop) {
        super(description, source,OffsetRangeHelper.getOffsetRange(start,stop));
        this.rule = rule;
        this.start = start;
        this.stop = stop;
    }

    public ParserRuleContext getRule() {
        return rule;
    }

    public Token getStart() {
        return start;
    }

    public Token getStop() {
        return stop;
    }

}


package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.util.OffsetRangeHelper;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
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

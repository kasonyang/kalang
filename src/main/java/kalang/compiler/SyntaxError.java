
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
    private final Token token;

    public SyntaxError(String description, KalangSource source,ParserRuleContext rule,Token token) {
        super(description, source,OffsetRangeHelper.getOffsetRange(token));
        this.rule = rule;
        this.token = token;
    }

    public ParserRuleContext getRule() {
        return rule;
    }

    public Token getToken() {
        return token;
    }

}

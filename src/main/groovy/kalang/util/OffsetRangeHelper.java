
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.OffsetRange;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class OffsetRangeHelper {
    
    public static OffsetRange getOffsetRange(ParserRuleContext tree){
        int start = tree.getStart().getStartIndex();
        int stop = tree.getStop().getStopIndex();
        return new OffsetRange(start,stop+1);
    }
    
    public static OffsetRange getOffsetRange(Token token){
        int start = token.getStartIndex();
        int stop = token.getStopIndex();
        return new OffsetRange(start, stop+1);
    }

}

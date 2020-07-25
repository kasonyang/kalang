package kalang.compiler.util;

import kalang.annotation.Nullable;
import kalang.compiler.compile.OffsetRange;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Kason Yang 
 */
public class OffsetRangeHelper {

    public static OffsetRange getOffsetRange(ParserRuleContext tree) {
        if (tree == null) {
            return OffsetRange.NONE;
        }
        Token start = tree.getStart();
        Token stop = tree.getStop();
        if(start==null || stop==null) return OffsetRange.NONE;
        return getOffsetRange(start, stop);
    }

    public static OffsetRange getOffsetRange(Token token) {
        return getOffsetRange(token, token);
    }

    public static OffsetRange getOffsetRange(Token start, Token stop) {
        OffsetRange offset = new OffsetRange();
        offset.startOffset = start.getStartIndex();
        offset.stopOffset = stop.getStopIndex();
        offset.startLine = start.getLine();
        offset.startLineColumn = start.getCharPositionInLine();
        offset.stopLine = stop.getLine();
        offset.stopLineColumn = stop.getCharPositionInLine();
        return offset;
    }

    @Nullable
    public static OffsetRange lastCharOffset(OffsetRange offset) {
        if (!isValid(offset)) {
            return null;
        }
        OffsetRange r = new OffsetRange();
        r.startOffset = offset.stopOffset - 1;
        r.stopOffset = offset.stopOffset;
        r.startLine = offset.stopLine;
        r.startLineColumn = offset.stopLineColumn;
        r.stopLine = offset.stopLine;
        r.stopLineColumn = offset.stopLineColumn;
        return r;
    }

    public static boolean isValid(OffsetRange offset) {
        return offset != null
                && offset.startOffset >= 0
                && offset.stopOffset >=0
                && offset.stopOffset >= offset.startOffset;
    }

}

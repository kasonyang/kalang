package kalang.compiler.compile;

/**
 *
 * @author Kason Yang 
 */
public class OffsetRange {
    
    public int 
            startOffset,
            stopOffset,
            startLine,
            startLineColumn,
            stopLine,
            stopLineColumn;
    
    public final static OffsetRange NONE = new OffsetRange();

    public OffsetRange(int startOffset, int stopOffset, int startLine, int startLineColumn, int stopLine, int stopLineColumn) {
        this.startOffset = startOffset;
        this.stopOffset = stopOffset;
        this.startLine = startLine;
        this.startLineColumn = startLineColumn;
        this.stopLine = stopLine;
        this.stopLineColumn = stopLineColumn;
    }

    public OffsetRange() {
        startOffset = -1;
        stopOffset =-1;
        startLine = -1;
        startLineColumn = -1;
        stopLine = -1;
        stopLineColumn = -1;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",startOffset,stopOffset);
    }
    
    

}

package kalang.compiler;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class OffsetRange {
    
    public int 
            startOffset = -1,
            stopOffset =-1,
            startLine = -1,
            startLineColumn = -1,
            stopLine = -1,
            stopLineColumn = -1;
    
    public final static OffsetRange NONE = new OffsetRange();

    public OffsetRange() {
        
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",startOffset,stopOffset);
    }
    
    

}

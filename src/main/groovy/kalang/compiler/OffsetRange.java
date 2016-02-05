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

    public int offset;
    public int length;

    public OffsetRange(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

}

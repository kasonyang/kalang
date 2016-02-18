
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class TokenNavigator {
    
    Token[] tokens;
    
    int caretOffset;
    
    int maxCaretOffset=-1;
    
    private final int[] startOffset;
    private int currentTokenIndex = 0;

    public TokenNavigator(Token[] tokens) {
        this.tokens = tokens;
        startOffset = new int[tokens.length];
        if(tokens.length>0){
            for (int i=0;i<tokens.length;i++) {
                startOffset[i] = tokens[i].getStartIndex();
            }
            maxCaretOffset = tokens[tokens.length-1].getStopIndex();
        }
    }
    
    public int move(int caretOffset){
        if(caretOffset<0 || caretOffset > maxCaretOffset){
            throw new IndexOutOfBoundsException();
        }
        currentTokenIndex = getTokenIndexByCaretOffset(caretOffset);
        int oldCaret = this.caretOffset;
        this.caretOffset = caretOffset;
        return oldCaret;
    }
    
    public Token getCurrentToken(){
        return tokens[currentTokenIndex];
    }
    
    public int getCurrentTokenIndex(){
        return currentTokenIndex;
    }
    
    private int getTokenIndexByCaretOffset(int caretOffset){        
        int idx = Arrays.<Token>binarySearch(startOffset,caretOffset);
        if(idx<0){
            idx = -idx - 2;
            if(caretOffset>tokens[idx].getStopIndex()){
                return -1;
            }
        }
        return idx;
    }

}


package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author Kason Yang 
 */
public class TokenNavigator {
    
    Token[] tokens;
    
    int caretOffset;
    
    int maxCaretOffset=-1;
    
    private final int[] startOffset;
    private int currentTokenIndex = 0;
    
    public TokenNavigator(@Nonnull List<Token> tokens){
        this(tokens.toArray(new Token[0]));
    }

    public TokenNavigator(@Nonnull Token[] tokens) {
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
    
    protected void nextIndex(Integer channel,int increment){
        int nextId = -1;
        int newIdx = currentTokenIndex;
        while(nextId==-1){
            newIdx+=increment;
            if(newIdx>=tokens.length){
                throw new IndexOutOfBoundsException("index out of bouds:"+newIdx);
            }
            if(channel!=null && !channel.equals(tokens[newIdx].getChannel())){
                continue;
            }
            break;
        }
        currentTokenIndex = newIdx;
    }
    
    public void next(){
        nextIndex(null,1);
    }
    
    public void next(int channel){
        nextIndex(channel,1);
    }
    
    public void previous(){
        nextIndex(null, -1);
    }
    
    public void previous(int channel){
        nextIndex(channel, -1);
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
    
    public boolean hasNext(){
        return this.currentTokenIndex < this.tokens.length-1;
    }
    
    public boolean hasPrevious(){
        return this.currentTokenIndex>0;
    }

}

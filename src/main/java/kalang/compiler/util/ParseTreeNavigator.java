
package kalang.compiler.util;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
/**
 *
 * @author Kason Yang 
 */
public class ParseTreeNavigator {
    
    private int tokenCounter = 0;
    
    private HashMap<Token,ParseTree> token2tree = new HashMap<>();
    
    private HashMap<Integer,Token> index2token = new HashMap<>();
    
    private void enterParseTree(ParseTree tree){
        int cc = tree.getChildCount();
        for(int i=0;i<cc;i++){
            ParseTree c = tree.getChild(i);
            if(c instanceof RuleNode){
                enterParseTree(c);
            }else if (c instanceof TerminalNode){
                Token t = ((TerminalNode)c).getSymbol();
                index2token.put(tokenCounter, t);
                token2tree.put(t, c);
                tokenCounter ++;
            }else{
                System.err.println("unknown node:" + c);
            }
        }
    }
    
    public ParseTreeNavigator(ParseTree prc) {
        enterParseTree(prc);
    }
    
    public ParseTree getParseTree(Token token){
        return token2tree.get(token);
    }
    
    @Deprecated
    public ParseTree getParseTree(int tokenIndex){
        return token2tree.get(index2token.get(tokenIndex));
    }

}

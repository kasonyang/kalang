package kalang.test;

import java.util.List;
import kalang.compiler.KalangCompiler;
import kalang.util.ParseTreeNavigator;
import kalang.util.TokenNavigator;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangCompilerTest {
    
    public KalangCompilerTest() {
    }
    
    @Test
    public void test(){
        KalangCompiler kc = new KalangCompiler();
        kc.addSource("Test", "class{  }");
        kc.compile();
        CommonTokenStream ts = kc.getTokenStream("Test");
        List<Token> tokens = ts.getTokens();
        testTokenNavigator(tokens.toArray(new Token[0]),kc.getSourceUnit("Test").getParseTree());
    }
    
    private void testTokenNavigator(Token[] tokens,ParseTree tree){
        TokenNavigator tokenNav = new TokenNavigator(tokens);
        ParseTreeNavigator treeNav = new ParseTreeNavigator(tree);
        assertEquals(0,tokenNav.getCurrentTokenIndex());
        assertEquals("class", treeNav.getParseTree(tokenNav.getCurrentToken()).getText());
        
        tokenNav.move(5);
        assertEquals("{", tokenNav.getCurrentToken().getText());
        assertEquals(1,tokenNav.getCurrentTokenIndex());
        tokenNav.move(8);
        assertEquals("}",tokenNav.getCurrentToken().getText());
        
        assertEquals("}", treeNav.getParseTree(tokenNav.getCurrentToken()).getText());
        
    }
}

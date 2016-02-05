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
        testTokenNavigator(tokens.toArray(new Token[0]));
        testParseTreeNavigator(kc.getParser("Test").getParseTree());
    }
    
    private void testParseTreeNavigator(ParseTree tree){
        ParseTreeNavigator treeNavigator = new ParseTreeNavigator(tree);
        assertEquals("class", treeNavigator.getParseTree(0).getText());
        assertEquals("}", treeNavigator.getParseTree(2).getText());
    }
    
    private void testTokenNavigator(Token[] tokens){
        TokenNavigator navgator = new TokenNavigator(tokens);
        assertEquals(0,navgator.getCurrentTokenIndex());
        navgator.move(5);
        assertEquals("{", navgator.getCurrentToken().getText());
        assertEquals(1,navgator.getCurrentTokenIndex());
        navgator.move(8);
        assertEquals("}",navgator.getCurrentToken().getText());
    }
}

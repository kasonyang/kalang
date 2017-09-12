package kalang.test;

import java.util.List;
import kalang.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang 
 */
public class TokenUtilTest {
    
    public TokenUtilTest() {
    }
    
    @Test
    public void test(){
        CommonTokenStream ts = TokenStreamFactory.createTokenStream("class{    }");
        int tokenSize = ts.size();
        assertEquals(0, tokenSize);
        List<Token> tokens = ts.getTokens();
        assertEquals(0, tokens.size());
        ts.consume();
        ts.consume();
        assertEquals("}", ts.LT(1).getText());
        assertEquals("{", ts.LT(-1).getText());
        assertEquals("class", ts.LT(-2).getText());
        //why is it 4?
        assertEquals(4, ts.size());
        int consumeSize = 2;
        while(ts.LA(1)!=IntStream.EOF){
            ts.consume();
            consumeSize++;
        }
        tokens = ts.getTokens();
        assertEquals(5, tokens.size());
        assertEquals(3, consumeSize);
    }
    
}

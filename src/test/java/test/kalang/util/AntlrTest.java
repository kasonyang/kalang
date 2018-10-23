package test.kalang.util;

import java.io.File;
import java.io.IOException;
import kalang.antlr.KalangParser;
import kalang.compiler.KalangSource;
import kalang.util.KalangSourceUtil;
import kalang.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang
 */
public class AntlrTest {
    
    public AntlrTest() {
    }
    
    @Test
    public void testLexer() throws IOException{
        this.createTokenStream().getTokens();
    }
    
    @Test
    public void testParser() throws IOException{
        KalangParser parser = new KalangParser(this.createTokenStream());
        parser.compilationUnit();
    }
    
    private CommonTokenStream createTokenStream() throws IOException{
        KalangSource source = KalangSourceUtil.create(new File("src/test/kalang-snippets"), new File("src/test/kalang-snippets/automation/HelloKalang.kl"));
        return TokenStreamFactory.createTokenStream(source.getText());
    }
    
}

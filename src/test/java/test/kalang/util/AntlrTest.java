package test.kalang.util;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.compile.KalangSource;
import kalang.compiler.util.KalangSourceUtil;
import kalang.compiler.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
        KalangSource source = KalangSourceUtil.create(new File("src/test/kalang-snippets"), new File("src/test/kalang-snippets/automation/HelloKalang.kl"), "utf8");
        return TokenStreamFactory.createTokenStream(source.getText());
    }
    
}

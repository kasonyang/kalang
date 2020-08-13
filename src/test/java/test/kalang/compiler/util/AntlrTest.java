package test.kalang.compiler.util;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.util.TokenStreamFactory;
import kalang.mixin.IOMixin;
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
        parser.standardCompilationUnit();
    }
    
    private CommonTokenStream createTokenStream() throws IOException{
        File file = new File("src/test/kalang-snippets/automation/HelloKalang.kl");
        String src = IOMixin.readToString(file, "utf8");
        return TokenStreamFactory.createTokenStream(src);
    }
    
}

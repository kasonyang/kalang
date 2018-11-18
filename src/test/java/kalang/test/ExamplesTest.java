package kalang.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Kason Yang
 */
public class ExamplesTest extends CompilerTestCase {

    public ExamplesTest() {
    }

    @Test
    public void testExamples() throws IOException {
        addSourceDir(new File("src/test/kalang-snippets"));
        compile();
    }

}

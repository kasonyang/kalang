package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.tool.FileSystemOutputManager;
import org.junit.Test;

/**
 *
 * @author Kason Yang
 */
public class ExamplesTest extends CompilerTestCase {

    public ExamplesTest() {
    }

    @Test
    public void testExamples() throws IOException {
        addSourceDir(new File("examples"));
        compile();
    }

}

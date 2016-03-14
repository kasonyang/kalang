package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.compiler.CompileError;
import kalang.tool.FileSystemCompiler;
import kalang.tool.MainCompiler;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ExamplesTest extends FileSystemCompiler{
    
    public ExamplesTest() {
    }

    @Test
    public void testExamples() throws IOException {
        addSourceDir(new File("examples"));
        addSourceDir(new File("TestScript/source"));
        setOutputDir(new File("build/examples"));
        compile();
    }

    @Override
    public void handleCompileError(CompileError error) {
        super.handleCompileError(error);
        fail(error.getDescription());
    }
    
    
    
}

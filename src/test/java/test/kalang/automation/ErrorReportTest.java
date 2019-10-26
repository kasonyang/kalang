package test.kalang.automation;

import kalang.compiler.CompileException;
import kalang.compiler.tool.KalangShell;
import kalang.mixin.IOMixin;
import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.fail;

public class ErrorReportTest {

    @Test
    public void testErrorReport() throws Exception {
        File srcDir = new File("src/test/kalang-snippets/error");
        testAll(srcDir);
    }

    private void testAll(File file) throws Exception {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File c : children) {
                testAll(c);
            }
            return;
        }
        if (!file.isFile()) {
            return;
        }
        KalangShell shell = new KalangShell();
        String fileContent = IOMixin.readToString(file, "utf8");
        int newLinePos = fileContent.indexOf("\n");
        String expectedErrorMsg = fileContent.substring(0, newLinePos).trim();
        String source = fileContent.substring(newLinePos+1);
        try {
            shell.parse(FilenameUtils.getBaseName(file.getName()), source, file.getName());
            fail("invalid file compile passed");
        } catch (CompileException ce) {
            String actualErrorMsg = ce.getDescription();
            Assert.assertEquals("unexpected error message in file:" + file.getName(), expectedErrorMsg, actualErrorMsg);
        }
    }

}

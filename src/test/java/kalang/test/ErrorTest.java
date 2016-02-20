package kalang.test;

import static org.junit.Assert.*;

import org.junit.Test;
import kalang.compiler.*;
import kalang.compiler.KalangCompiler;
//import kalang.MainCompiler as KC
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import kalang.compiler.AstSemanticError;// as E;
//import kalang.tool.MainCompiler as TC;
public class ErrorTest {
	
    String outDir = "TestScript/generatedCode";
    String srcDir = "antlr/TestScript";
    String errSrcDir = "TestScript/error_src";
	
    int eCode;
	
    String errMsg;
	
    KalangCompiler kc;

    AstSemanticErrorHandler allowErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            //kc.reportAstNodeError(error.getDescription(), error.getClassNode().name, error.getNode());
            System.out.println("on error:" + error.getDescription());
                  eCode = error.getErrorCode();
            errMsg =error.getDescription();
        }
    };
    
    CompileErrorHandler strictErrorHandler = new CompileErrorHandler() {

        @Override
        public void handleCompileError(CompileError error) {
            fail(error.description);
        }
    };
	
    private void compile(AstSemanticErrorHandler errorHandler,CompileErrorHandler compileErrorHandler,String dir,String...name) throws IOException{
        eCode = -1;
        kc = new KalangCompiler(new JavaAstLoader());
        if(errorHandler!=null)
            kc.setAstSemanticErrorHandler(errorHandler);
        if(compileErrorHandler!=null){
            kc.setCompileErrorHandlerrrorHandler(compileErrorHandler);
        }
        for(String n : name){
            File src = new File(dir,n+".kl");//.readLines().join("\r\n");
            String source = FileUtils.readFileToString(src);
            kc.addSource(n,source);
        }
        kc.compile();
        for(CompilationUnit unit:kc.getAllCompilationUnit().values()){
            System.out.println(unit.getJavaCode());
        }
        //
    }
	
    private void cp(String... name) throws IOException{
        this.errMsg = null;
        compile(null,strictErrorHandler,srcDir,name);
    }
	
    private void ecp(String... name) throws IOException{
        compile(allowErrorHandler,null,errSrcDir,name);
    }
	
    @Test
    public void errorTest() throws IOException {
        //throw new RuntimeException("tt")
        //cp "NotImplemented"
        ecp("SyntaxError");
		
        ecp("ErrorAssign");
        assertEquals( eCode , AstSemanticError.UNABLE_TO_CAST);
        //TODO catch sematic error
        //ecp("NotImplemented");
        //assertEquals( eCode , AstSemanticError.CLASS_NOT_FOUND);
        ecp("NotImplemented","MyFace");
        assertEquals( eCode , AstSemanticError.METHOD_NOT_IMPLEMENTED);
    }
	
    @Test
    public void test() throws IOException{
        //cp("TestInput")
        cp("Base");
        //cp("HelloWorld","MyInterface")
        //cp "kava"
    }
	
    @Test
    public void toolTest() throws IOException{
        kalang.tool.MainCompiler.main(new String[]{this.errSrcDir,outDir});
    }
	

}

package kalang.test;

import static org.junit.Assert.*;

import org.junit.Test;

import kalang.compiler.*
//import kalang.Compiler as KC
import jast.ast.*
import kalang.compiler.AstError as E
import kalang.tool.Compiler as TC
@groovy.transform.TypeChecked
class ErrorTest {
	
	String outDir = "TestScript/generatedCode"
	String srcDir = "antlr"
	
	int eCode
	
	String errMsg
	
	KalangCompiler kc
	
	ErrorHandler typeErrorHandler = new TypeErrorHandler();

	class TypeErrorHandler implements ErrorHandler{

		@Override
		public void error(ClassNode clazz,AstNode node, String msg, int errorCode) {
			eCode = errorCode
			errMsg = msg
		}
		
	}
	
	private void compile(String dir,String...name){
		kc = new KalangCompiler(new JavaAstLoader())
		for(def n in name){
			def src = new File("${dir}/${n}.kl").readLines().join("\r\n")
			kc.addSource(n,src)
		}
		kc.setTypeErrorHanlder(typeErrorHandler)
		kc.compile();
		println kc.getJavaCodes();
	}
	
	private void cp(String... name){
		this.errMsg = null;
		compile(srcDir,name)
		if(kc.hasError()){
			throw kc.errors.get(0)
		}
	}
	
	private void ecp(String... name){
		compile("TestScript/error_src",name)
		if(kc.hasError()){
			for(e in kc.errors){
				System.err.println(e)
			}
		}
	}
	
	@Test
	public void errorTest() {
		//throw new RuntimeException("tt")
		//cp "NotImplemented"
		ecp("SyntaxError")
		
		ecp("ErrorAssign")
		assert eCode == E.UNABLE_TO_CAST
		ecp("NotImplemented")
		assert eCode == E.CLASS_NOT_FOUND
		ecp("NotImplemented","MyFace")
		assert eCode == E.METHOD_NOT_IMPLEMENTED
	}
	
	@Test
	void test(){
		cp("TestInput")
		//cp("HelloWorld","MyInterface")
		//cp "kava"
	}
	
	@Test
	void toolTest(){
		TC.main(this.srcDir,outDir)
	}

}

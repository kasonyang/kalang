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
	
	KalangCompiler kc
	
	ErrorHandler typeErrorHandler

	class TypeErrorHandler implements ErrorHandler{

		@Override
		public void error(AstNode node, String errMsg, int errorCode) {
			eCode = errorCode
			System.err.println(errMsg)
		}
		
	}
	
	private void compile(String dir,String...name){
		kc = new KalangCompiler(new JavaAstLoader())
		for(def n in name){
			def src = new File("${dir}/${n}.kl").readLines().join("\r\n")
			kc.addSource(n,src)
		}
		if(this.typeErrorHandler){
			kc.setTypeErrorHanlder(typeErrorHandler)
		}
		kc.compile();
		println kc.getJavaCodes();
		//KC.compile(cls,srces)
	}
	
	private void cp(String... name){
		compile(srcDir,name)
	}
	
	private void ecp(String... name){
		if(!this.typeErrorHandler){
			typeErrorHandler = new TypeErrorHandler();
		}
		compile("TestScript/error_src",name)
	}
	
	@Test
	public void errorTest() {
		//throw new RuntimeException("tt")
		//cp "NotImplemented"
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

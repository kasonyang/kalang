package kalang.test;

import static org.junit.Assert.*;

import org.junit.Test;

import compilier.*
//import kalang.Compiler as KC
import jast.ast.*
import compilier.AstError as E
import kalang.tool.Compiler as TC
@groovy.transform.TypeChecked
class ErrorTest {
	
	String outDir = "TestScript/generatedCode"
	String srcDir = "TestScript/src"
	
	AstError e
	
	KalangCompiler kc

	private void compile(String dir,String...name){
		kc = new KalangCompiler(new JavaAstLoader())
		for(def n in name){
			def src = new File("${dir}/${n}.kl").readLines().join("\r\n")
			kc.addSource(n,src)
		}
		kc.compile();
		println kc.getJavaCodes();
		//KC.compile(cls,srces)
	}
	
	private void cp(String... name){
		compile(srcDir,name)
	}
	
	private void ecp(String... name){
		try{
			compile("TestScript/error_src",name)
		}catch(CompileError error){
			this.e = kc.getAstError()
			println e.message
		}
	}
	
	@Test
	public void errorTest() {
		//throw new RuntimeException("tt")
		//cp "NotImplemented"
		ecp("ErrorAssign")
		assert e.errorCode == E.UNABLE_TO_CAST
		ecp("NotImplemented")
		assert e.errorCode == E.CLASS_NOT_FOUND
		ecp("NotImplemented","MyFace")
		assert e.errorCode == E.METHOD_NOT_IMPLEMENTED
	}
	
	@Test
	void test(){
		cp("HelloWorld","MyInterface")
		cp "kava"
	}
	
	@Test
	void toolTest(){
		TC.main(this.srcDir,outDir)
	}

}

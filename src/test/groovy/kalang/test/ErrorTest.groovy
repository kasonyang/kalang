package kalang.test;

import static org.junit.Assert.*;

import org.junit.Test;

import compilier.*
//import kalang.Compiler as KC
import jast.ast.*
import compilier.AstError as E
@groovy.transform.TypeChecked
class ErrorTest {
	
	AstError e
	
	KalangCompiler kc

	private void compile(String dir,String...name){
		kc = new KalangCompiler(new JavaAstLoader())
		for(def n in name){
			def src = new File("${dir}/${n}.kl").readLines().join("\r\n")
			kc.addSource(n,src)
		}
		def out = "TestScript/"
		kc.compile();
		//KC.compile(cls,srces)
	}
	
	private void cp(String... name){
		compile("TestScript/src",name)
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

}

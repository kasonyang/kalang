package kalang.test;

import static org.junit.Assert.*;

import org.junit.Test;

import compilier.*
import kalang.Compiler as KC
import jast.ast.*
import compilier.AstError as E
@groovy.transform.TypeChecked
class ErrorTest {
	
	AstError e

	private void compile(String dir,String...name){
		def cls = []
		def srces = []
		for(def n in name){
			cls.add(n)
			def src = new File("${dir}/${n}.kl").readLines().join("\r\n")
			srces.add(src)
		}
		def out = "TestScript/"
		KC.compile(cls,srces)
	}
	
	private void cp(String... name){
		compile("TestScript/src",name)
	}
	
	private void ecp(String... name){
		try{
			compile("TestScript/error_src",name)
		}catch(AstError e){
			this.e = e
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

package kava.compiler;

public class CompilerException extends RuntimeException {
	public CompilerException(String msg){
		super(msg);
	}
	
	static void exception(String msg){
		throw new CompilerException(msg);
	}
	
	static void wrongVarName(String name){
		exception("错误的变量名："+name);
	}
	
	static void undefinedVar(String name){
		exception("未定义的变量："+name);
	}
	static void repeatVar(String name){
		exception("重复定义的变量；" + name);
	}
	
}

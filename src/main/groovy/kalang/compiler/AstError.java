/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalang.compiler;

import java.util.List;

import jast.ast.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
@groovy.transform.TypeChecked
public class AstError extends RuntimeException {
    public static final int UNRESOLVED_NAME = 1,
    CLASS_NOT_FOUND = 2,
    METHOD_NOT_FOUND = 3,
    UNABLE_TO_CAST = 4,
    METHOD_NOT_IMPLEMENTED = 5,
	UNSUPPORTED = 6,
	FIELD_NOT_FOUND = 7,
	LACKS_OF_STATEMENT = 8,
	UNCAUGHT_EXCEPTION = 9;
	
	ErrorHandler handler;
	
	ClassNode clazz;
	
    public AstError(ClassNode clazz,ErrorHandler handler){
		this.handler = handler;
		this.clazz = clazz;
    }
	
    public void unsupported(String op,AstNode node){
		fail("It is unsupported to " + op,UNSUPPORTED,node);
	}
    
    public  void fail(String msg,int errorCode,AstNode node){
        handler.error(clazz,node,msg,errorCode);
    }
    
    public  void classNotFound(AstNode node,String className){
        fail("Class not found:" + className,CLASS_NOT_FOUND,node);
    }
    
    public  void methodNotFound(AstNode node,String className,String name,List<String> types){
        String method = AstParser.getMethodDescriptor(name,types,className);
		fail("Method Missing:"+method,METHOD_NOT_FOUND,node);
    }
	
    public  void fieldNotFound(AstNode node,String fieldName){
		fail("Field missing:"+fieldName,FIELD_NOT_FOUND,node);
	}
    
    public  void failedToCast(AstNode node,String fromType,String toType){
        fail("Unable to cast " + fromType + " to "+ toType,UNABLE_TO_CAST,node);
    }
	
    public  void uncaughtException(AstNode node,List<String> exType){
		fail("Uncaught exception:"+exType,UNCAUGHT_EXCEPTION,node);
	}
    
    public  void notImplementedMethods(AstNode node,ClassNode theInterface,List<MethodNode> method){
		String methodStr = AstParser.getMethodDescriptor(method.get(0),theInterface.name);
        fail("The method isn't implemented:"+methodStr,METHOD_NOT_IMPLEMENTED,node);
    }
}


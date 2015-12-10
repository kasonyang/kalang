/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalang.compiler

import jast.ast.*

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
@groovy.transform.TypeChecked
class AstError extends RuntimeException {
    public static final int UNRESOLVED_NAME = 1,
    CLASS_NOT_FOUND = 2,
    METHOD_NOT_FOUND = 3,
    UNABLE_TO_CAST = 4,
    METHOD_NOT_IMPLEMENTED = 5,
	UNSUPPORTED = 6,
	FIELD_NOT_FOUND = 7,
	LACKS_OF_STATEMENT = 8,
	UNCAUGHT_EXCEPTION = 9;
	
	ErrorHandler handler
	
    public AstError(ErrorHandler handler){
		this.handler = handler
    }
	
	void unsupported(String op,AstNode node){
		fail("It is unsupported to ${op}",UNSUPPORTED,node)
	}
    
     void fail(String msg,int errorCode,AstNode node){
        handler.error(node,msg,errorCode);
    }
    
     void classNotFound(AstNode node,String className){
        fail("Class not found:${className}",CLASS_NOT_FOUND,node)
    }
    
     void methodNotFound(AstNode node,String className,String name,List<String> types){
        def method = AstParser.getMethodDescriptor(name,types)
		fail("Method Missing:${className}#${method}",METHOD_NOT_FOUND,node)
    }
	
	 void fieldNotFound(AstNode node,String fieldName){
		fail("Field missing:${fieldName}",FIELD_NOT_FOUND,node)
	}
    
     void failedToCast(AstNode node,String fromType,String toType){
        fail("Unable to cast ${fromType} to ${toType}",UNABLE_TO_CAST,node)
    }
	
	 void uncaughtException(AstNode node,List<String> exType){
		fail("Uncaught exception:${exType}",UNCAUGHT_EXCEPTION,node)
	}
    
     void notImplementedMethods(AstNode node,ClassNode theInterface,List<MethodNode> method){
		String methodStr = theInterface.name + "#" + AstParser.getMethodDescriptor(method.get(0))
        fail("The method isn't implemented:${methodStr}",METHOD_NOT_IMPLEMENTED,node)
    }
}


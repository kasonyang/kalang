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
	FIELD_NOT_FOUND = 7;
    
    AstNode node;
	int errorCode;
    public AstError(String msg,int errorCode,AstNode node){
        super(msg)
        this.node = node
		this.errorCode = errorCode
    }
    
    static void fail(String msg,int errorCode,AstNode node){
        throw new AstError(msg,errorCode,node)
    }
    
    static void classNotFound(AstNode node,String className){
        fail("Class not found:${className}",CLASS_NOT_FOUND,node)
    }
    
    static void methodNotFound(AstNode node,String className,String name,List<String> types){
        def method = AstParser.methodToString(name,types)
		fail("Method Missing:${className}#${method}",METHOD_NOT_FOUND,node)
    }
	
	static void fieldNotFound(AstNode node,String fieldName){
		fail("Field missing:${fieldName}",FIELD_NOT_FOUND,node)
	}
    
    static void failedToCast(AstNode node,String fromType,String toType){
        fail("Unable to cast ${fromType} to ${toType}",UNABLE_TO_CAST,node)
    }
    
    static void notImplementedMethods(AstNode node,ClassNode theInterface,List<MethodNode> method){
		//String methodStr = AstParser.methodToString(
		String methodStr = theInterface.name + "#" + AstParser.methodToString(method.get(0))
        fail("The method isn't implemented:${methodStr}",METHOD_NOT_IMPLEMENTED,node)
    }
}


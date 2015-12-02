/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilier

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
	UNSUPPORTED = 6;
    
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
        fail(className,CLASS_NOT_FOUND,node)
    }
    
    static void methodNotFound(AstNode node,String name,List<String> types){
        fail(name,METHOD_NOT_FOUND,node)
    }
    
    static void failedToCast(AstNode node,String fromType,String toType){
        fail("Unable to cast ${fromType} to ${toType}",UNABLE_TO_CAST,node)
    }
    
    static void notImplementedMethods(AstNode node,ClassNode theInterface,List<MethodNode> method){
		String name = method?.get(0).name
        fail("The method in interface ${theInterface.name} isn't implemented:${name}",METHOD_NOT_IMPLEMENTED,node)
    }
}


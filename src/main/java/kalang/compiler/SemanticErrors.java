/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.compiler;

import kalang.ast.ClassNode;
import kalang.ast.MethodNode;
import kalang.ast.AstNode;
import kalang.util.AstUtil;
import java.util.List;

import java.util.Map;
import static kalang.compiler.SemanticError.*;
import kalang.core.Type;
import kalang.util.MethodUtil;
/**
 *
 * @author Kason Yang
 */
public class SemanticErrors{

    public static SemanticError uncaughtException(AstNode expr, String exType,CompilationUnit unit) {
        return fail("Uncaught exception:" + exType, UNCAUGHT_EXCEPTION, expr,unit);
    }

    public static SemanticError unsupported(String op, AstNode node, CompilationUnit unit) {
        return fail("It is unsupported to " + op, UNSUPPORTED, node,unit);
    }

    public static SemanticError fail(String msg, int errorCode, AstNode node,CompilationUnit unit) {
        return  new SemanticError(msg, unit ,errorCode,node,unit.getAst());
    }

    public static SemanticError classNotFound(AstNode node, String className, CompilationUnit unit) {
        return fail("Class not found:" + className, CLASS_NOT_FOUND, node,unit);
    }

    public static SemanticError methodNotFound(AstNode node, String className, String name, Type[] types, CompilationUnit unit) {
        String method = MethodUtil.toString(className,name, types);
        return fail("Method Missing:" + method, METHOD_NOT_FOUND, node,unit);
    }

    public static SemanticError fieldNotFound(AstNode node, String fieldName, CompilationUnit unit) {
        return fail("Field missing:" + fieldName, FIELD_NOT_FOUND, node,unit);
    }

    public static SemanticError failedToCast(AstNode node, String fromType, String toType, CompilationUnit unit) {
        return fail("Unable to cast " + fromType + " to " + toType, UNABLE_TO_CAST, node,unit);
    }

    public static SemanticError notImplementedMethods(AstNode node, ClassNode theInterface, List<MethodNode> method, CompilationUnit unit) {
        String methodStr = MethodUtil.toString(method.get(0), theInterface.name);
        return fail("The method isn't implemented:" + methodStr, METHOD_NOT_IMPLEMENTED, node,unit);
    }
}

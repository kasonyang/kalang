/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.compiler;

import java.util.List;

import jast.ast.*;
import java.util.Map;
import static kalang.compiler.AstSemanticError.*;
import kalang.core.Type;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class AstSemanticErrorReporter{

    void uncaughtException(AstNode expr, String exType) {
        fail("Uncaught exception:" + exType, UNCAUGHT_EXCEPTION, expr);
    }

    public static interface AstSemanticReporterCallback{
        void handleAstSemanticError(AstSemanticError error);
    }
    
    AstSemanticReporterCallback handler;

    ClassNode clazz;

    public AstSemanticErrorReporter(ClassNode clazz, AstSemanticReporterCallback handler) {
        this.handler = handler;
        this.clazz = clazz;
    }

    public void unsupported(String op, AstNode node) {
        fail("It is unsupported to " + op, UNSUPPORTED, node);
    }

    public void fail(String msg, int errorCode, AstNode node) {
        AstSemanticError ase = new AstSemanticError(msg, errorCode,node,clazz);
        handler.handleAstSemanticError(ase);
    }

    public void classNotFound(AstNode node, String className) {
        fail("Class not found:" + className, CLASS_NOT_FOUND, node);
    }

    public void methodNotFound(AstNode node, String className, String name, List<Type> types) {
        String method = AstMetaParser.getMethodDescriptor(name, types, className);
        fail("Method Missing:" + method, METHOD_NOT_FOUND, node);
    }

    public void fieldNotFound(AstNode node, String fieldName) {
        fail("Field missing:" + fieldName, FIELD_NOT_FOUND, node);
    }

    public void failedToCast(AstNode node, String fromType, String toType) {
        fail("Unable to cast " + fromType + " to " + toType, UNABLE_TO_CAST, node);
    }

    public void notImplementedMethods(AstNode node, ClassNode theInterface, List<MethodNode> method) {
        String methodStr = AstMetaParser.getMethodDescriptor(method.get(0), theInterface.name);
        fail("The method isn't implemented:" + methodStr, METHOD_NOT_IMPLEMENTED, node);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.compiler;

import java.util.LinkedList;
import kalang.ast.ClassNode;
import kalang.ast.MethodNode;
import kalang.ast.AstNode;
import kalang.util.AstUtil;
import java.util.List;

import java.util.Map;
import static kalang.compiler.SemanticError.*;
import kalang.core.MethodDescriptor;
import kalang.core.Type;
import kalang.util.MethodUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class SemanticErrorReporter{

    private CompilationUnit source;

    void uncaughtException(AstNode expr, String exType) {
        fail("Uncaught exception:" + exType, UNCAUGHT_EXCEPTION, expr);
    }

    public static interface AstSemanticReporterCallback{
        void handleAstSemanticError(SemanticError error);
    }
    
    AstSemanticReporterCallback handler;

    ClassNode clazz;

    public SemanticErrorReporter(ClassNode clazz, CompilationUnit source,AstSemanticReporterCallback handler) {
        this.handler = handler;
        this.clazz = clazz;
        this.source = source;
    }

    public void unsupported(String op, AstNode node) {
        fail("It is unsupported to " + op, UNSUPPORTED, node);
    }

    public void fail(String msg, int errorCode, AstNode node) {
        SemanticError ase = new SemanticError(msg, source ,errorCode,node,clazz);
        handler.handleAstSemanticError(ase);
    }

    public void classNotFound(AstNode node, String className) {
        fail("Class not found:" + className, CLASS_NOT_FOUND, node);
    }

    public void methodNotFound(AstNode node, String className, String name, Type[] types) {
        String method = MethodUtil.toString(className,name, types);
        fail("Method Missing:" + method, METHOD_NOT_FOUND, node);
    }

    public void fieldNotFound(AstNode node, String fieldName) {
        fail("Field missing:" + fieldName, FIELD_NOT_FOUND, node);
    }

    public void failedToCast(AstNode node, String fromType, String toType) {
        fail("Unable to cast " + fromType + " to " + toType, UNABLE_TO_CAST, node);
    }

    public void notImplementedMethods(AstNode node, Type theInterface, List<MethodDescriptor> method) {
        List<String> list = new LinkedList();
        for(MethodDescriptor m:method){
            list.add(m.toString());
        }
        String methodStr = String.join("\n", list);
        String msg = String.format("methods require implemented:\n%s", methodStr);
        fail(msg , METHOD_NOT_IMPLEMENTED, node);
    }
}

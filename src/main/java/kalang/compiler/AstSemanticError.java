/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.compiler;

import kalang.ast.AstNode;
import kalang.ast.ClassNode;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class AstSemanticError extends CompileError{

    public static final int UNRESOLVED_NAME = 1,
            CLASS_NOT_FOUND = 2,
            METHOD_NOT_FOUND = 3,
            UNABLE_TO_CAST = 4,
            METHOD_NOT_IMPLEMENTED = 5,
            UNSUPPORTED = 6,
            FIELD_NOT_FOUND = 7,
            LACKS_OF_STATEMENT = 8,
            UNCAUGHT_EXCEPTION = 9;

    ClassNode classNode;
    AstNode node;
    int errorCode;

    AstSemanticError(String description,CompilationUnit compilationUnit, int errorCode, AstNode node, ClassNode clazz) {
        super(description, compilationUnit, node.offset);
        this.classNode = clazz;
        this.node = node;
        this.errorCode = errorCode;
    }

    public ClassNode getClassNode() {
        return classNode;
    }

    public AstNode getNode() {
        return node;
    }

    public int getErrorCode() {
        return errorCode;
    }

}

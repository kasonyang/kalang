/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.compiler;

import jast.ast.AstNode;
import jast.ast.ClassNode;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class AstSemanticError {

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
    String msg;
    int errorCode;

    AstSemanticError(String msg, int errorCode, AstNode node, ClassNode clazz) {
        this.classNode = clazz;
        this.node = node;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public ClassNode getClassNode() {
        return classNode;
    }

    public AstNode getNode() {
        return node;
    }

    public String getMsg() {
        return msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

}

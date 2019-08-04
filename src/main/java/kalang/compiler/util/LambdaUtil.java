package kalang.compiler.util;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.ast.*;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.NullableKind;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import kalang.compiler.exception.Exceptions;

import java.lang.reflect.Modifier;

/**
 *
 * @author Kason Yang
 */
public class LambdaUtil {

    public static void createBridgeRunMethod(ClassNode classNode,MethodNode targetMethod,Type[] expectedTypes, int paramCount) {
        Type returnType = targetMethod.getType();
        int methodParamCount = targetMethod.getParameters().length;
        Type[] paramTypes = new Type[paramCount];
        System.arraycopy(expectedTypes, 0, paramTypes, 0, Math.min(expectedTypes.length,paramTypes.length));
        for (int j = expectedTypes.length; j < paramCount; j++) {
            paramTypes[j] = Types.getRootType();
        }
        ClassType funcType = Types.getFunctionType(returnType, paramTypes, NullableKind.NONNULL);
        classNode.addInterface(funcType);
        MethodNode pmethod = classNode.createMethodNode(returnType, "call", Modifier.PUBLIC);
        ParameterNode[] pNodes = new ParameterNode[paramCount];
        for (int j = 0; j < paramCount; j++) {
            pNodes[j] = pmethod.createParameter(paramTypes[j], "p" + (j + 1));
        }
        ExprNode[] argExprs = new ExprNode[methodParamCount];
        for (int j = 0; j < argExprs.length; j++) {
            argExprs[j] = new ParameterExpr(pNodes[j]);
        }
        ObjectInvokeExpr invokeExpr;
        try {
            invokeExpr = ObjectInvokeExpr.create(new ThisExpr(classNode), "call", argExprs, classNode);
        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
            throw Exceptions.unexpectedException(ex);
        }
        pmethod.getBody().statements.add(new ReturnStmt(invokeExpr));
    }

}

package kalang.util;

import java.lang.reflect.Modifier;
import kalang.AmbiguousMethodException;
import kalang.MethodNotFoundException;
import kalang.ast.ClassNode;
import kalang.ast.ExprNode;
import kalang.ast.MethodNode;
import kalang.ast.ObjectInvokeExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ParameterNode;
import kalang.ast.ReturnStmt;
import kalang.ast.ThisExpr;
import kalang.core.ClassType;
import kalang.core.NullableKind;
import kalang.core.Type;
import kalang.core.Types;
import kalang.exception.Exceptions;

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
            throw Exceptions.unexceptedException(ex);
        }
        pmethod.getBody().statements.add(new ReturnStmt(invokeExpr));
    }

}

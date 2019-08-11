package kalang.compiler.util;

import kalang.annotation.Nullable;
import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class LambdaUtil {

    @Nullable
    public static MethodDescriptor getFunctionalMethod(ClassType classType) {
        if (!ModifierUtil.isInterface(classType.getModifier())) {
            return null;
        }
        List<MethodDescriptor> mustImplMethods = new LinkedList<>();
        MethodDescriptor[] methods = classType.getMethodDescriptors(null, true, true);
        for(MethodDescriptor m:methods) {
            if (!ModifierUtil.isDefault(m.getModifier())) {
                mustImplMethods.add(m);
            }
        }
        if (mustImplMethods.size()!=1) {
            return null;
        }
        return mustImplMethods.get(0);
    }

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

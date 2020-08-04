package kalang.compiler.util;

import kalang.compiler.ast.*;
import kalang.compiler.compile.OffsetRange;
import kalang.compiler.core.*;
import kalang.mixin.CollectionMixin;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kason Yang
 */
public class ImplementationUtil {

    public static Map<MethodDescriptor,MethodNode> getImplementationMap(ClassNode clazz) {
        ObjectType[] interfaces = clazz.getInterfaces();
        Map<MethodDescriptor,MethodNode> result = new HashMap<>();
        ObjectType superType = clazz.getSuperType();
        if (superType != null) {
            doGetImplementationMap(clazz, superType, result);
        }
        for (ObjectType itf : interfaces) {
            doGetImplementationMap(clazz,itf,result);
        }
        return result;
    }

    private static void doGetImplementationMap(ClassNode clazz, ObjectType interfaceType,Map<MethodDescriptor,MethodNode> map) {
        MethodDescriptor[] interfaceMethods = interfaceType.getMethodDescriptors(null, true, true);
        ClassType clazzType = Types.getClassType(clazz, new Type[0]);
        MethodDescriptor[] clazzMethods = CollectionMixin.findAll(
                clazzType.getMethodDescriptors(null, true, false),
                it -> !Modifier.isAbstract(it.getModifier())
        );
        for (MethodDescriptor im : interfaceMethods) {
            String imDeclKey = im.getDeclarationKey();
            MethodDescriptor cm = MethodUtil.getMethodDescriptor(clazzMethods, imDeclKey);
            map.put(im,cm==null ? null : cm.getMethodNode());
        }
    }

    private static void createBridgeMethod(ClassNode clazz,Type returnType,Type[] paramTypes, MethodDescriptor targetMethod) {
        Type[] oldParamTypes = targetMethod.getParameterTypes();
        BlockStmt mb = new BlockStmt();
        mb.offset = OffsetRange.NONE;
        MethodNode m = clazz.createMethodNode(returnType, targetMethod.getName(), targetMethod.getModifier(), mb);
        ParameterNode[] paramNodes = new ParameterNode[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramNodes[i] = m.createParameter(paramTypes[i], "p" + i);
        }
        ExprNode[] params = new ExprNode[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            if (!paramTypes[i].equals(oldParamTypes[i])) {
                CastExpr castExpr = new CastExpr(oldParamTypes[i], new VarExpr(paramNodes[i]));
                AssignExpr assignExpr = new AssignExpr(new VarExpr(paramNodes[i]), castExpr);
                mb.statements.add(new ExprStmt(assignExpr));
            }
            params[i] = new VarExpr(paramNodes[i]);
        }
        ObjectInvokeExpr invokeExpr = new ObjectInvokeExpr(new ThisExpr(clazz), targetMethod, params);
        if (!Types.VOID_TYPE.equals(returnType)) {
            mb.statements.add(new ReturnStmt(invokeExpr));
        } else {
            mb.statements.add(new ExprStmt(invokeExpr));
            mb.statements.add(new ReturnStmt());
        }
    }

}

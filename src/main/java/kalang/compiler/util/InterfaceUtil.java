package kalang.compiler.util;

import kalang.compiler.ast.*;
import kalang.compiler.core.*;

import java.lang.reflect.Modifier;
import java.util.*;

/**
 *
 * @author Kason Yang
 */
public class InterfaceUtil {

    @Deprecated
    public static List<MethodDescriptor> checkAndBuildInterfaceMethods(ClassNode clazz) {
        ObjectType[] interfaces = clazz.getInterfaces();
        List<MethodDescriptor> unimplements = new LinkedList();
        for (ObjectType itf : interfaces) {
            unimplements.addAll(checkAndBuildInterfaceMethods(clazz, itf));
        }
        return unimplements;
    }

    @Deprecated
    public static List<MethodDescriptor> checkAndBuildInterfaceMethods(ClassNode clazz, ObjectType interfaceType) {
        MethodDescriptor[] interfaceMethods = interfaceType.getMethodDescriptors(interfaceType.getClassNode(), true, true);
        ClassType clazzType = Types.getClassType(clazz, new Type[0]);
        MethodDescriptor[] clazzMethods = clazzType.getMethodDescriptors(null, true, false);
        List<MethodDescriptor> unimplements = new LinkedList();
        for (MethodDescriptor im : interfaceMethods) {
            String imDeclKey = im.getDeclarationKey();
            MethodDescriptor cm = MethodUtil.getMethodDescriptor(clazzMethods, imDeclKey);
            if (cm == null) {
                if (Modifier.isAbstract(im.getModifier())) {
                    unimplements.add(im);
                }
                continue;
            }
            Type[] descriptorParamsTypes = im.getParameterTypes();
            MethodNode imMethodNode = im.getMethodNode();
            Type[] interfaceMethodParamsTypes = MethodUtil.getParameterTypes(imMethodNode);
            if (!Arrays.equals(descriptorParamsTypes, interfaceMethodParamsTypes)) {
                createBridgeMethod(clazz, imMethodNode.getType(),interfaceMethodParamsTypes, cm);
            }
        }
        return unimplements;
    }

    public static Map<MethodDescriptor,MethodNode> getImplementationMap(ClassNode clazz) {
        ObjectType[] interfaces = clazz.getInterfaces();
        Map<MethodDescriptor,MethodNode> result = new HashMap<>();
        for (ObjectType itf : interfaces) {
            doGetImplementationMap(clazz,itf,result);
        }
        return result;
    }

    private static void doGetImplementationMap(ClassNode clazz, ObjectType interfaceType,Map<MethodDescriptor,MethodNode> map) {
        MethodDescriptor[] interfaceMethods = interfaceType.getMethodDescriptors(null, true, true);
        ClassType clazzType = Types.getClassType(clazz, new Type[0]);
        MethodDescriptor[] clazzMethods = clazzType.getMethodDescriptors(null, true, false);
        for (MethodDescriptor im : interfaceMethods) {
            String imDeclKey = im.getDeclarationKey();
            MethodDescriptor cm = MethodUtil.getMethodDescriptor(clazzMethods, imDeclKey);
            map.put(im,cm==null ? null : cm.getMethodNode());
        }
    }

    private static void createBridgeMethod(ClassNode clazz,Type returnType,Type[] paramTypes, MethodDescriptor targetMethod) {
        Type[] oldParamTypes = targetMethod.getParameterTypes();
        MethodNode m = clazz.createMethodNode(returnType, targetMethod.getName(), targetMethod.getModifier());
        ParameterNode[] paramNodes = new ParameterNode[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramNodes[i] = m.createParameter(paramTypes[i], "p" + i);
        }
        BlockStmt mb = m.getBody();
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

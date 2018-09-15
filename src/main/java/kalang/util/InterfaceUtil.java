package kalang.util;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kalang.ast.AssignExpr;
import kalang.ast.BlockStmt;
import kalang.ast.CastExpr;
import kalang.ast.ClassNode;
import kalang.ast.ExprNode;
import kalang.ast.ExprStmt;
import kalang.ast.MethodNode;
import kalang.ast.ObjectInvokeExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ParameterNode;
import kalang.ast.ReturnStmt;
import kalang.ast.ThisExpr;
import kalang.core.ClassType;
import kalang.core.ExecutableDescriptor;
import kalang.core.MethodDescriptor;
import kalang.core.ObjectType;
import kalang.core.Type;
import kalang.core.Types;

/**
 *
 * @author Kason Yang
 */
public class InterfaceUtil {

    public static List<MethodDescriptor> checkAndBuildInterfaceMethods(ClassNode clazz) {
        ObjectType[] interfaces = clazz.getInterfaces();
        List<MethodDescriptor> unimplements = new LinkedList();
        for (ObjectType itf : interfaces) {
            unimplements.addAll(checkAndBuildInterfaceMethods(clazz, itf));
        }
        return unimplements;
    }

    public static List<MethodDescriptor> checkAndBuildInterfaceMethods(ClassNode clazz, ObjectType interfaceType) {
        MethodDescriptor[] interfaceMethods = interfaceType.getMethodDescriptors(interfaceType.getClassNode(), true, true);
        ClassType clazzType = Types.getClassType(clazz, new Type[0]);
        MethodDescriptor[] clazzMethods = clazzType.getMethodDescriptors(null, true, false);
        List<MethodDescriptor> unimplements = new LinkedList();
        for (MethodDescriptor im : interfaceMethods) {
            String imDeclKey = im.getDeclarationKey();
            ExecutableDescriptor cm = MethodUtil.getExecutableDescriptor(clazzMethods, imDeclKey);
            if (cm == null) {
                if (Modifier.isAbstract(im.getModifier())) {
                    unimplements.add(im);
                }
                continue;
            }
            Type[] descriptorParamsTypes = im.getParameterTypes();
            Type[] interfaceMethodParamsTypes = MethodUtil.getParameterTypes(im.getMethodNode());
            if (!Arrays.equals(descriptorParamsTypes, interfaceMethodParamsTypes)) {
                createBridgeMethod(clazz, interfaceMethodParamsTypes, cm);
            }
        }
        return unimplements;
    }

    private static void createBridgeMethod(ClassNode clazz, Type[] paramTypes, ExecutableDescriptor targetMethod) {
        Type returnType = targetMethod.getReturnType();
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
                CastExpr castExpr = new CastExpr(oldParamTypes[i], new ParameterExpr(paramNodes[i]));
                AssignExpr assignExpr = new AssignExpr(new ParameterExpr(paramNodes[i]), castExpr);
                mb.statements.add(new ExprStmt(assignExpr));
            }
            params[i] = new ParameterExpr(paramNodes[i]);
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

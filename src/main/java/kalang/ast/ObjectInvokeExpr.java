
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.MethodNotFoundException;
import kalang.core.ClassType;
import kalang.core.Type;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ObjectInvokeExpr extends InvocationExpr{

    public static ObjectInvokeExpr create(ExprNode target, ClassNode clazz, String methodName,ExprNode[] args) throws MethodNotFoundException {
        MethodSelection ms = applyMethod(clazz, methodName, args);
        return new ObjectInvokeExpr(target,clazz,ms.selectedMethod ,ms.appliedArguments);
    }

    private ExprNode invokeTarget;
    
    public static ObjectInvokeExpr create(ExprNode target,String methodName,ExprNode[] args) throws MethodNotFoundException{
        ClassType targetType = (ClassType) target.getType();
        ClassNode clazz = targetType.getClassNode();
        return create(target,clazz,methodName, args);
    }
    private final ClassNode specialClass;

    public ObjectInvokeExpr(ExprNode invokeTarget,ClassNode specialClass, MethodNode method, ExprNode[] args) {
        super(method, args);
        this.invokeTarget = invokeTarget;
        this.specialClass = specialClass;
    }

    public ExprNode getInvokeTarget() {
        return invokeTarget;
    }

    public ClassNode getSpecialClass() {
        return specialClass;
    }
    
}

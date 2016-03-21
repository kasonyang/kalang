
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.MethodNotFoundException;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class StaticInvokeExpr extends InvocationExpr{

    private ClassReference invokeClass;
    
    public static StaticInvokeExpr create(ClassReference clazz, String methodName, ExprNode[] args) throws MethodNotFoundException {
        MethodSelection ms = applyMethod(clazz.getReferencedClassNode() , methodName, args);
        return new StaticInvokeExpr(clazz, ms.selectedMethod, ms.appliedArguments);
    }

    public StaticInvokeExpr(ClassReference invokeClass, MethodNode method, ExprNode[] args) {
        super(method, args);
        this.invokeClass = invokeClass;
    }

    public ClassReference getInvokeClass() {
        return invokeClass;
    }
    
}


package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class StaticInvokeExpr extends InvocationExpr{

    private ClassReference invokeClass;
    
    public static StaticInvokeExpr create(ClassReference clazz, String methodName, ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        MethodSelection ms = applyMethod(clazz.getReferencedClassNode() , methodName, args);
        MethodNode md = ms.selectedMethod;
        if(!AstUtil.isStatic(md.modifier)){
            throw new MethodNotFoundException(methodName + " is not static");
        }
        return new StaticInvokeExpr(clazz, md , ms.appliedArguments);
    }

    public StaticInvokeExpr(ClassReference invokeClass, MethodNode method, ExprNode[] args) {
        super(method, args);
        if(!AstUtil.isStatic(method.modifier)){
            throw new IllegalArgumentException("static method is required");
        }
        this.invokeClass = invokeClass;
    }

    public ClassReference getInvokeClass() {
        return invokeClass;
    }

    @Override
    public List<AstNode> getChildren() {
        ArrayList<AstNode> list = new ArrayList();
        addChild(list, invokeClass);
        addChild(list, arguments);
        return list;
    }
    
    
    
}

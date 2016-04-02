
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ObjectInvokeExpr extends InvocationExpr{

    public static ObjectInvokeExpr create(ExprNode target , String methodName,ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        ClassType targetType = (ClassType) target.getType();
        ClassNode clazz = targetType.getClassNode();
        MethodSelection ms = applyMethod(clazz, methodName, args);
        MethodNode md = ms.selectedMethod;
        if(AstUtil.isStatic(md.modifier)){
            throw new MethodNotFoundException(methodName + " is static");
        }
        return new ObjectInvokeExpr(target,ms.selectedMethod ,ms.appliedArguments);
    }

    private ExprNode invokeTarget;
    
    //private final ClassNode specialClass;

    public ObjectInvokeExpr(ExprNode invokeTarget, MethodNode method, ExprNode[] args) {
        super(method, args);
        //TODO check non-static
        this.invokeTarget = invokeTarget;
    }

    public ExprNode getInvokeTarget() {
        return invokeTarget;
    }

//    public ClassNode getSpecialClass() {
//        return specialClass;
//    }

    @Override
    public List<AstNode> getChildren() {
        List<AstNode> list = new LinkedList();
        addChild(list, invokeTarget);
        addChild(list, arguments);
        return list;
    }
    
    
    
}

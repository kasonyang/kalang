
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nullable;
import kalang.AmbiguousMethodException;
import kalang.MethodNotFoundException;
import kalang.core.ClassType;
import kalang.core.ExecutableDescriptor;
import kalang.core.MethodDescriptor;
import kalang.core.Type;
import kalang.core.Types;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ObjectInvokeExpr extends InvocationExpr{
    
    public static ObjectInvokeExpr create(ExprNode target , String methodName,ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        return create(target, methodName, args, null);
    }
    
    public static ObjectInvokeExpr create(ExprNode target , String methodName,ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException {
        ClassType targetType = (ClassType) target.getType();
        ClassNode clazz = targetType.getClassNode();
        boolean recursive = ! "<init>".equals(methodName);
        //MethodNode[] candidates = AstUtil.listAccessibleMethods(clazz, caller , recursive);
        List<ExecutableDescriptor> candidates = new LinkedList();
        candidates.addAll(Arrays.asList(targetType.getMethodDescriptors(caller,recursive)));
        candidates.addAll(Arrays.asList(targetType.getConstructorDescriptors(caller)));
        MethodSelection ms = applyMethod(targetType, methodName, args,candidates.toArray(new ExecutableDescriptor[candidates.size()]));
        MethodNode md = ms.selectedMethod;
        if(AstUtil.isStatic(md.modifier)){
            throw new MethodNotFoundException(methodName + " is static");
        }
        return new ObjectInvokeExpr(target,ms.selectedMethod ,ms.appliedArguments);
    }

    private ExprNode invokeTarget;
    
    //private final ClassNode specialClass;

    public ObjectInvokeExpr(ExprNode invokeTarget, MethodNode method, ExprNode[] args) {
        super((ClassType)invokeTarget.getType(),method, args);
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

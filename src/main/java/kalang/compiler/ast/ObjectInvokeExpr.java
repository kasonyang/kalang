
package kalang.compiler.ast;

import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.Parameters;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Kason Yang 
 */
public class ObjectInvokeExpr extends InvocationExpr{
    
    public static ObjectInvokeExpr create(ExprNode target , String methodName,ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        return create(target, methodName, args, null);
    }
    
    public static ObjectInvokeExpr create(ExprNode target , String methodName,ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException {
        ObjectType targetType = (ObjectType) target.getType();
        ClassNode clazz = targetType.getClassNode();
        boolean recursive = ! "<init>".equals(methodName);
        //MethodNode[] candidates = AstUtil.listAccessibleMethods(clazz, caller , recursive);
        List<MethodDescriptor> candidates = new LinkedList(Arrays.asList(targetType.getMethodDescriptors(caller, recursive, true)));
        //candidates.addAll(Arrays.asList(targetType.getConstructorDescriptors(caller)));
        MethodSelection ms = applyMethod(targetType, methodName, args,candidates.toArray(new MethodDescriptor[0]));
        MethodDescriptor md = ms.selectedMethod;
        if(AstUtil.isStatic(md.getModifier())){
            throw new MethodNotFoundException(methodName + " is static");
        }
        return new ObjectInvokeExpr(target,ms.selectedMethod ,ms.appliedArguments);
    }

    private ExprNode invokeTarget;
    
    //private final ClassNode specialClass;

    public ObjectInvokeExpr(ExprNode invokeTarget, MethodDescriptor method, ExprNode... args) {
        super((ObjectType)invokeTarget.getType(),method, args);
        Parameters.requireTrue(!Modifier.isStatic(method.getModifier()));
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

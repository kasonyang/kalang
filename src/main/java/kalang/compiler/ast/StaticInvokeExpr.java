
package kalang.compiler.ast;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.core.ExecutableDescriptor;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kason Yang 
 */
public class StaticInvokeExpr extends InvocationExpr{

    private ClassReference invokeClass;
    
    public static StaticInvokeExpr create(ClassReference clazz, String methodName, ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        return create(clazz, methodName, args, null);
    }
    
    public static StaticInvokeExpr create(ClassReference clazz, String methodName, ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException {
        ObjectType clazzType = Types.getClassType(clazz.getReferencedClassNode());
        //TODO static only
        //TODO what about generic static method?
        MethodDescriptor[] candidates = clazzType.getMethodDescriptors(caller, true,true);
        MethodSelection ms = applyMethod(Types.getClassType( clazz.getReferencedClassNode()) , methodName, args,candidates);
        ExecutableDescriptor md = ms.selectedMethod;
        if(!AstUtil.isStatic(md.getModifier())){
            throw new MethodNotFoundException(methodName + " is not static");
        }
        return new StaticInvokeExpr(clazz, md , ms.appliedArguments);
    }

    public StaticInvokeExpr(ClassReference invokeClass, ExecutableDescriptor method, ExprNode[] args) {
        super(Types.getClassType(invokeClass.getReferencedClassNode()),method, args);
        if(!AstUtil.isStatic(method.getModifier())){
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

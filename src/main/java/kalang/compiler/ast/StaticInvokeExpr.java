
package kalang.compiler.ast;

import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import kalang.compiler.util.AstUtil;
import kalang.mixin.CollectionMixin;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
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
        MethodDescriptor[] mds = clazzType.getMethodDescriptors(caller, true, true);
        MethodDescriptor[] candidates = CollectionMixin.findAll(mds, it -> Modifier.isStatic(it.getModifier()));
        MethodSelection ms = applyMethod(Types.getClassType( clazz.getReferencedClassNode()) , methodName, args,candidates);
        MethodDescriptor md = ms.selectedMethod;
        if(!AstUtil.isStatic(md.getModifier())){
            throw new MethodNotFoundException(methodName + " is not static");
        }
        return new StaticInvokeExpr(clazz, md , ms.appliedArguments);
    }

    public StaticInvokeExpr(ClassReference invokeClass, MethodDescriptor method, ExprNode[] args) {
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

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        invokeClass = doUpdateChild(invokeClass, childUpdater);
        doUpdateChildren(arguments, childUpdater);
    }
}

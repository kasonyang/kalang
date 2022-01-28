
package kalang.compiler.ast;

import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import kalang.compiler.util.MethodUtil;
import kalang.compiler.util.ParameterizedUtil;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**
 *
 * @author Kason Yang 
 */
public class NewObjectExpr extends ExprNode{

    protected ObjectType objectType;
    
    protected InvocationExpr constructor;

    public NewObjectExpr(ObjectType objectType, InvocationExpr constructor) {
        this.objectType = objectType;
        this.constructor = constructor;
    }
    
    public NewObjectExpr(ObjectType objectType,ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        this(objectType,args,null);
    }
    
    public NewObjectExpr(ObjectType objectType) throws MethodNotFoundException, AmbiguousMethodException {
        this(objectType,new ExprNode[0],null);
    }
    
    public NewObjectExpr(ObjectType objectType,ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException {
        if (objectType instanceof ClassType) {
            ClassType clsType = (ClassType) objectType;
            if (clsType.getTypeArguments().length <= 0) {
                ClassNode cn = clsType.getClassNode();
                objectType = Types.getClassType(cn, cn.getGenericTypes(), clsType.getNullable());
            }
        }
        this.objectType = objectType;
        initDefaultConstructor(args, caller);
        if (objectType instanceof ClassType) {
            Type[] decTypes = MethodUtil.getParameterTypes(constructor.getMethod().getMethodNode());
            Type[] actTypes = constructor.getArgumentTypes();
            Map<ClassNode, Type> gTypeMap = ParameterizedUtil.getGenericTypeMap(decTypes, actTypes);
            this.objectType = ((ClassType) objectType).toParameterized(gTypeMap);
        }
    }
    
    private void initDefaultConstructor(ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException{
        constructor = 
                ObjectInvokeExpr.create(this, "<init>",args,caller);
    }
    
    @Override
    public List<AstNode> getChildren() {
        return Arrays.asList(constructor.getArguments());
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        doUpdateChildren(constructor.getArguments(), childUpdater);
    }

    @Override
    public Type getType() {
        return getObjectType();
    }

    /**
     * @return the objectType
     */
    public ObjectType getObjectType() {
        return objectType;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(ObjectType objectType) {
        Objects.requireNonNull(objectType);
        this.objectType = objectType;
    }

    /**
     * @return the constructor
     */
    public InvocationExpr getConstructor() {
        return constructor;
    }

    /**
     * @param constructor the constructor to set
     */
    public void setConstructor(InvocationExpr constructor) {
        Objects.requireNonNull(constructor);
        this.constructor = constructor;
    }

}

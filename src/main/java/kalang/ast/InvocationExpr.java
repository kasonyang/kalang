package kalang.ast;

import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.compiler.MethodNotFoundException;
import kalang.core.*;
import kalang.util.AstUtil;

public class InvocationExpr extends ExprNode {

    public static InvocationExpr create(ExprNode target, MethodNode methodNode) {
        return new InvocationExpr(target, methodNode, null);
    }

    /**
     * The target object to invoke
     */
    protected ExprNode target;

    /**
     * The method name of invocation
     */
    //protected String methodName;
    protected ExprNode[] arguments;
    //private ClassNode specialClass;
    private MethodNode method;

    public static InvocationExpr createStatic(ClassNode clazz, String methodName, ExprNode[] args) throws MethodNotFoundException {
        return create(null, clazz, methodName, args);
    }

    public static InvocationExpr create(@Nonnull ExprNode target, String methodName) throws MethodNotFoundException {
        return create(target, methodName, null);
    }
    
//    public static InvocationExpr create(@Nonnull ExprNode target,ClassNode clazz, String methodName, @Nullable ExprNode[] arguments){
//        return create(target, methodNode);
//    }
        /**
     *  select the method for invocation expression,and apply ast transform if needed
     * @param cls
     * @param invocationExpr
     * @param types
     * @return the selected method,or null
     */
    private static InvocationExpr applyMethod(ExprNode target,ClassNode cls,String methodName, ExprNode[] args) throws MethodNotFoundException {
        Type[] types = AstUtil.getExprTypes(args);
        MethodNode md = AstUtil.getMethod(cls, methodName, types);
        if (md != null) {
            return new InvocationExpr(target, md, args);
        } else {
            MethodNode[] methods = AstUtil.getMethodsByName(cls, methodName);
            int matchedCount = 0;
            ExprNode[] matchedParams=null;
            MethodNode matchedMethod = null;
            for (MethodNode m : methods) {
                Type[] mTypes = AstUtil.getParameterTypes(m);
                ExprNode[] mp = AstUtil.matchTypes(args, types, mTypes);
                if (mp != null) {
                    matchedCount++;
                    matchedParams = mp;
                    matchedMethod = m;
                }
            }
            if (matchedCount < 1) {
                throw new MethodNotFoundException(methodName);
            } else if (matchedCount > 1) {
                throw new MethodNotFoundException("the method " + methodName + " is ambiguous");
            }
            return new InvocationExpr(target,matchedMethod, matchedParams);
        }
    }

    public static InvocationExpr create(@Nonnull ExprNode target, String methodName, @Nullable ExprNode[] arguments) throws MethodNotFoundException {
        ClassType targetType = (ClassType) target.getType();
        ClassNode clazz = targetType.getClassNode();
        return create(target, clazz, methodName, arguments);
    }

    public static InvocationExpr create(
            @Nullable ExprNode target,@Nonnull ClassNode clazz, String methodName, @Nullable ExprNode[] args) throws MethodNotFoundException {
        return applyMethod(target,clazz,methodName, args);
    }

    public InvocationExpr(ExprNode target, MethodNode method, ExprNode[] args) {
        this.target = target;
        this.method = method;
        this.arguments = args;
    }

    @Override
    public List<AstNode> getChildren() {
        List<AstNode> ls = new LinkedList();
        addChild(ls, getTarget());
        addChild(ls, getArguments());
        return ls;
    }

    @Nonnull
    public ClassType getInvokeClassType() {
        return Types.getClassType(method.classNode);
    }

    @Nullable
    public Type[] getArgumentTypes() {
        if (getArguments() == null) {
            return null;
        }
        return AstUtil.getExprTypes(getArguments());
    }

    @Override
    public Type getType() {
        return method.type;
    }

    /**
     * @return the target,null if method is static
     */
    public ExprNode getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(ExprNode target) {
        Objects.requireNonNull(target);
        this.target = target;
    }

    /**
     * @return the arguments
     */
    public ExprNode[] getArguments() {
        return arguments;
    }

    /**
     * @param arguments the arguments to set
     */
    public void setArguments(ExprNode[] arguments) {
        //Objects.requireNonNull(arguments);
        this.arguments = arguments;
    }

    public MethodNode getMethod() {
        return method;
    }

}

package kalang.ast;

import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.AmbiguousMethodException;
import kalang.MethodNotFoundException;
import kalang.core.*;
import kalang.util.AstUtil;
import kalang.util.TypeUtil;

public abstract class InvocationExpr extends ExprNode {

    private final ClassType clazz;
    
    public static class MethodSelection{
        public MethodNode selectedMethod;
        public ExprNode[] appliedArguments;

        public MethodSelection(MethodNode selectedMethod, ExprNode[] appliedArguments) {
            this.selectedMethod = selectedMethod;
            this.appliedArguments = appliedArguments;
        }
        
    }

    /**
     * The method name of invocation
     */
    //protected String methodName;
    protected ExprNode[] arguments;
    
    private MethodNode method;

     /**
     *  select the method for invocation expression,and apply ast transform if needed
     * @param specialClass
     * @param invocationExpr
     * @param types
     * @return the selected method,or null
     */
    public static MethodSelection applyMethod(ClassType clazz,String methodName, ExprNode[] args,ExecutableDescriptor[] candidates) throws MethodNotFoundException,AmbiguousMethodException {
        Type[] types = AstUtil.getExprTypes(args);
        ExecutableDescriptor md = AstUtil.getExactedMethod(clazz,candidates, methodName, types);
        if (md != null) {
            return new MethodSelection(md.getMethodNode(), args);
        } else {
            ExecutableDescriptor[] methods = AstUtil.getMethodsByName(candidates, methodName);
            //int matchedCount = 0;
            ExprNode[] matchedParams=null;
            List<MethodNode> matchedMethod = new ArrayList(methods.length);
            for (ExecutableDescriptor m : methods) {
                Type[] mTypes = m.getParameterTypes();
                ExprNode[] mp = AstUtil.matchTypes(args, types, mTypes);
                if (mp != null) {
                    //matchedCount++;
                    matchedParams = mp;
                    matchedMethod.add(m.getMethodNode());
                }
            }
            if (matchedMethod.isEmpty()) {
                throw new MethodNotFoundException(methodName);
            } else if (matchedMethod.size() > 1) {
                throw new AmbiguousMethodException(matchedMethod);
            }
            return new MethodSelection(matchedMethod.get(0), matchedParams);
        }
    }

    public InvocationExpr(ClassType clazz,MethodNode method, ExprNode[] args) {
        this.method = method;
        this.arguments = args;
        this.clazz = clazz;
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
        return TypeUtil.getMethodActualReturnType(clazz, method);
        //method.type;
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

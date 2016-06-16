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
        public ExecutableDescriptor selectedMethod;
        public ExprNode[] appliedArguments;

        public MethodSelection(ExecutableDescriptor selectedMethod, ExprNode[] appliedArguments) {
            this.selectedMethod = selectedMethod;
            this.appliedArguments = appliedArguments;
        }
        
    }

    /**
     * The method name of invocation
     */
    //protected String methodName;
    protected ExprNode[] arguments;
    
    private ExecutableDescriptor method;

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
            return new MethodSelection(md, args);
        } else {
            ExecutableDescriptor[] methods = AstUtil.getMethodsByName(candidates, methodName);
            //int matchedCount = 0;
            ExprNode[] matchedParams=null;
            List<ExecutableDescriptor> matchedMethod = new ArrayList(methods.length);
            for (ExecutableDescriptor m : methods) {
                Type[] mTypes = m.getParameterTypes();
                ExprNode[] mp = AstUtil.matchTypes(args, types, mTypes);
                if (mp != null) {
                    //matchedCount++;
                    matchedParams = mp;
                    matchedMethod.add(m);
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

    public InvocationExpr(ClassType clazz,ExecutableDescriptor method, ExprNode[] args) {
        this.method = method;
        this.arguments = args;
        this.clazz = clazz;
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
        return method.getReturnType();
        //method.type;
    }

    /**
     * @return the arguments
     */
    public ExprNode[] getArguments() {
        return arguments;
    }
    
    public ExecutableDescriptor getMethod() {
        return method;
    }

}

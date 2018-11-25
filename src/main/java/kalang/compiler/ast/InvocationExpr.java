package kalang.compiler.ast;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.compile.KalangMethodSelector;
import kalang.compiler.core.ExecutableDescriptor;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class InvocationExpr extends ExprNode {

    private final ObjectType clazz;
    
    private static final KalangMethodSelector methodSelector = new KalangMethodSelector();
    
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
     * select the method for invocation expression,and apply ast transform if needed
     * @param clazz
     * @param methodName
     * @param args
     * @param candidates
     * @return the selected method,or null
     * @throws MethodNotFoundException
     * @throws AmbiguousMethodException 
     */
    public static MethodSelection applyMethod(ObjectType clazz,String methodName, @Nullable ExprNode[] args,ExecutableDescriptor[] candidates) throws MethodNotFoundException,AmbiguousMethodException {
        if(args == null) args = new ExprNode[0];
        Type[] types = AstUtil.getExprTypes(args);
        if(types==null) types = new Type[0];
        List<ExecutableDescriptor> selectedList = methodSelector.select(candidates, methodName, types);
        if (selectedList.isEmpty()) {
            throw new MethodNotFoundException(clazz,methodName);
        } else if (selectedList.size() > 1) {
            throw new AmbiguousMethodException(selectedList);
        }
        ExecutableDescriptor md = selectedList.get(0);
        ExprNode[] matchedParam = AstUtil.matchTypes(args, types, md.getParameterTypes());
        Objects.requireNonNull(matchedParam);
        if (md instanceof MethodDescriptor) {
            md = ((MethodDescriptor) md).toParameterized(new HashMap<>(),AstUtil.getExprTypes(matchedParam));
        }
        return new MethodSelection(md,matchedParam);
    }
    

    public InvocationExpr(ObjectType clazz,ExecutableDescriptor method, ExprNode[] args) {
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

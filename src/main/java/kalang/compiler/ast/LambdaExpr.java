package kalang.compiler.ast;

import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.Type;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kason Yang
 */
public class LambdaExpr extends ExprNode{

    private Type type;

    private MethodDescriptor interfaceMethod;

    private MethodNode invokeMethod;

    private List<ExprNode> captureArguments = new LinkedList<>();

    private final Map<String, VarObject> accessibleVarObjects = new HashMap();

    public LambdaExpr(Type type) {
        this.type = type;
    }

    public void putAccessibleVarObject(String name, VarObject var) {
        accessibleVarObjects.put(name, var);
    }

    public Map<String, VarObject> getAccessibleVarObjects() {
        return new HashMap(accessibleVarObjects);
    }

    @Override
    public List<AstNode> getChildren() {
        return new LinkedList<>(captureArguments);
    }

    public MethodDescriptor getInterfaceMethod() {
        return interfaceMethod;
    }

    public void setInterfaceMethod(MethodDescriptor interfaceMethod) {
        this.interfaceMethod = interfaceMethod;
    }

    public MethodNode getInvokeMethod() {
        return invokeMethod;
    }

    public void setInvokeMethod(MethodNode invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    public List<ExprNode> getCaptureArguments() {
        return captureArguments;
    }

    public void setCaptureArguments(List<ExprNode> captureArguments) {
        this.captureArguments = captureArguments;
    }

    @Nonnull
    @Override
    public Type getType() {
        return type;
    }

    public void fixType(Type newType) {
        this.type = newType;
    }
}

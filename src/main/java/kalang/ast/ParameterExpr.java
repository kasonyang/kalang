package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ParameterExpr extends ExprNode{
    
    protected ParameterNode parameter;
    
    public ParameterExpr(ParameterNode parameter){
        this.parameter = parameter;
    }

    @Override
    public Type getType() {
        return getParameter().type;
    }

    /**
     * @return the parameter
     */
    public ParameterNode getParameter() {
        return parameter;
    }

}
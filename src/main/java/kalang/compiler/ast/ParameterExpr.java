package kalang.compiler.ast;

import kalang.compiler.core.Type;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class ParameterExpr extends AssignableExpr{
    
    protected ParameterNode parameter;
    
    protected Type overrideType = null;
    
    public ParameterExpr(ParameterNode parameter){
        this.parameter = parameter;
    }

    public ParameterExpr(ParameterNode parameter,@Nullable Type overrideType) {
        this.parameter = parameter;
        this.overrideType = overrideType;
    }

    @Override
    public Type getType() {
        return overrideType !=null ? overrideType : parameter.getType();
    }

    /**
     * @return the parameter
     */
    public ParameterNode getParameter() {
        return parameter;
    }
    
    public void removeOverrideType(){
        overrideType = null;
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

}
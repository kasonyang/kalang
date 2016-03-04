package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ParameterExpr extends ExprNode{
    
    protected VarObject parameter;
    
    
    public ParameterExpr(){
        
    }
    
    
    public ParameterExpr(VarObject parameter){
        
        
            this.parameter = parameter;
        
    }
    
    
    public static ParameterExpr create(){
        ParameterExpr node = new ParameterExpr();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "ParameterExpr{\r\n";
        
        if(getParameter()!=null){
            str += "  parameter:" + getParameter().toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return getParameter().type;
    }

    /**
     * @return the parameter
     */
    public VarObject getParameter() {
        return parameter;
    }

    /**
     * @param parameter the parameter to set
     */
    public void setParameter(VarObject parameter) {
        Objects.requireNonNull(parameter);
        this.parameter = parameter;
    }
}
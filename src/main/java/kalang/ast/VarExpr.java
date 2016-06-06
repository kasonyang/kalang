package kalang.ast;
import java.util.*;
import kalang.core.*;
public class VarExpr extends AssignableExpr{
    
    protected final LocalVarNode var;
    
    public VarExpr(LocalVarNode var){
        this.var = var;
    }
    
    @Override
    public Type getType() {
        return getVar().getType();
    }

    /**
     * @return the var
     */
    public LocalVarNode getVar() {
        return var;
    }

    @Override
    public String toString() {
        return var.name;
    }
    
    
    
}
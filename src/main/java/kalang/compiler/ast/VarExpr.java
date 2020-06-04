package kalang.compiler.ast;

import kalang.compiler.core.Type;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class VarExpr extends AssignableExpr{
    
    protected final VarObject var;
    
    @Nullable
    protected Type overrideType;
    
    public VarExpr(VarObject var){
        this.var = var;
    }

    public VarExpr(VarObject var, @Nullable Type overrideType) {
        this.var = var;
        this.overrideType = overrideType;
    }
    
    @Override
    public Type getType() {
        return overrideType !=null ? overrideType : var.getType();
    }

    /**
     * @return the var
     */
    public VarObject getVar() {
        return var;
    }

    @Override
    public String toString() {
        return Objects.toString(var);
    }
    
    public void overrideType(Type newType) {
        overrideType = newType;
    }
    
    public void removeOverrideType(){
        overrideType = null;
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

}
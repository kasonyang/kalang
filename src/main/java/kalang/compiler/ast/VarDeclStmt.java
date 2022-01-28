package kalang.compiler.ast;

import kalang.mixin.CollectionMixin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class VarDeclStmt extends Statement{
    
    public final List<LocalVarNode> vars = new LinkedList<>();
    
    public VarDeclStmt(LocalVarNode var){
        this(Collections.singletonList(var));
    }
    
    public VarDeclStmt(List<LocalVarNode> var){
        this.vars.addAll(var);
    }
    
    
    @Override
    public List<AstNode> getChildren(){
        return new LinkedList<>(vars);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        doUpdateChildren(vars, childUpdater);
    }

    @Override
    public String toString() {
        List<String> vs = CollectionMixin.map(vars, (v) -> v.getType() + " " + v.getName());
        return String.join(",", vs);
    }
}
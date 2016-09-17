package kalang.ast;
import java.util.*;
import kalang.core.*;
public abstract class VarObject extends AstNode{
    
    public int modifier;
    
    private final Type type;
    
    private final String name;
    
    protected VarObject(int modifier,Type type,String name){
            this.modifier = modifier;
            this.type = type;
            this.name = name;
    }
    
    public Type getType(){
        if(type!=null) return type;
        return Types.getRootType();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name==null ? "[temp]" : name;
    }
    
}
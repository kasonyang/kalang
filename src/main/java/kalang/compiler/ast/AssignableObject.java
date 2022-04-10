package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
public abstract class AssignableObject extends AstNode{
    
    private int modifier;

    private int extendModifier;
    
    private final Type type;
    
    private final String name;
    
    protected AssignableObject(int modifier, Type type, String name){
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

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public void setExtendModifier(int extendModifier) {
        this.extendModifier = extendModifier;
    }

    public int getExtendModifier() {
        return extendModifier;
    }
}
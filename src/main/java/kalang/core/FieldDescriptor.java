package kalang.core;
/**
 *
 * @author Kason Yang
 */
public class FieldDescriptor {
    
    private String name;
    
    private Type type;
    
    private int modifier;

    public FieldDescriptor(String name, Type type, int modifier) {
        this.name = name;
        this.type = type;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getModifier() {
        return modifier;
    }
    
    

}

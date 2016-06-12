package kalang.core;
/**
 *
 * @author Kason Yang
 */
public class ParameterDescriptor {
    
    private String name;
    private Type type;

    public ParameterDescriptor(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
    
    

}

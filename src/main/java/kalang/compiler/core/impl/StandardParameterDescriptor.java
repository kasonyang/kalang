package kalang.compiler.core.impl;

import kalang.compiler.core.ParameterDescriptor;
import kalang.compiler.core.Type;

/**
 *
 * @author Kason Yang
 */
public class StandardParameterDescriptor implements ParameterDescriptor {
    
    private String name;

    private Type type;
    
    private int modifier;

    public StandardParameterDescriptor(String name, Type type,int modifier) {
        this.name = name;
        this.type = type;
        this.modifier = modifier;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getModifier() {
        return modifier;
    }

}

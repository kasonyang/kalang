
package kalang.core;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class Field {
    
    private String name;
    
    private Type type;
    
    private int modifier;

    public Field(String name, Type type, int modifier) {
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

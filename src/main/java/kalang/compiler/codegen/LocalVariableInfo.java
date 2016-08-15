package kalang.compiler.codegen;

import org.objectweb.asm.Label;

/**
 *
 * @author Kason Yang
 */
public class LocalVariableInfo {
    
    private String name;
    
    private String descriptor;
    
    private String signature;
    
    private Label startLabel;
    
    private Label endLabel;
    
    private int index;

    public LocalVariableInfo(String name, String descriptor, String signature, Label startLabel, Label endLabel,int index) {
        this.name = name;
        this.descriptor = descriptor;
        this.signature = signature;
        this.startLabel = startLabel;
        this.endLabel = endLabel;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getSignature() {
        return signature;
    }

    public Label getStartLabel() {
        return startLabel;
    }

    public Label getEndLabel() {
        return endLabel;
    }

    public int getIndex() {
        return index;
    }
    
    

}

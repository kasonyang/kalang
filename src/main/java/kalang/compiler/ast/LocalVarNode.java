
package kalang.compiler.ast;

import kalang.compiler.core.Type;

import javax.annotation.Nullable;
/**
 *
 * @author Kason Yang 
 */
public class LocalVarNode extends VarObject {
    
    public LocalVarNode(Type type,@Nullable String name){
        this(type,name,0);
    }

    public LocalVarNode(Type type, String name,int modifier) {
        super(modifier, type, name);
    }

}

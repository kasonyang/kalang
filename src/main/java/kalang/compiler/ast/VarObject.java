package kalang.compiler.ast;

import kalang.compiler.core.Type;

/**
 * @author KasonYang
 */
public abstract class VarObject extends AssignableObject {

    protected VarObject(int modifier, Type type, String name) {
        super(modifier, type, name);
    }

}

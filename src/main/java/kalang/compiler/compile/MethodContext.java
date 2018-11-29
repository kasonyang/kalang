package kalang.compiler.compile;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.LocalVarNode;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.ast.VarObject;
import kalang.compiler.core.Type;
import kalang.compiler.core.VarTable;

public class MethodContext {

    public final ClassNode classNode;

    public final MethodNode method;

    public boolean returned = false;

    public VarTable<String,LocalVarNode> varTables = new VarTable();

    public VarTable<VarObject, Type> overrideTypes = new VarTable();

    public VarTable<VarObject,Integer> nullState = new VarTable();

    public MethodContext(ClassNode classNode, MethodNode methodNode) {
        this.classNode = classNode;
        this.method = methodNode;
    }

    public void newFrame(){
        this.varTables = varTables.newStack();
    }

    public void popFrame(){
        this.varTables = this.varTables.popStack();
    }

}

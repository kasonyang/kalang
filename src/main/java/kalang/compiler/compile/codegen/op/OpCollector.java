package kalang.compiler.compile.codegen.op;


import kalang.compiler.util.Exceptions;
import org.objectweb.asm.Handle;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author KasonYang
 */
public class OpCollector extends LinkedList<OpBase> {

    private List<LocalVariable> localVariables = new LinkedList<>();

    private List<LineNumber> lineNumbers = new LinkedList<>();

    private List<TryCatchBlock> tryCatchBlocks = new LinkedList<>();

    public OpCollector() {
    }

    public OpCollector(Collection<? extends OpBase> c) {
        super(c);
    }

    public void visitInsn(int code) {
        add(new InsnOp(code));
    }

    public void visitVarInsn(int code, int var) {
        add(new VarInsnOp(code, var));
    }

    public void visitLabel(LabelOp label) {
        add(label);
    }

    public void visitJumpInsn(int code, LabelOp label) {
        add(new JumpInsnOp(code, label));
    }

    public void visitTryCatchBlock(LabelOp start, LabelOp end, LabelOp handler, String type) {
        tryCatchBlocks.add(new TryCatchBlock(start, end, handler, type));
    }

    public void visitLdcInsn(Object v) {
        add(new LdcInsnOp(v));
    }

    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        add(new MethodInsnOp(opcode, owner, name, descriptor, isInterface));
    }

    public void visitTypeInsn(int code, String type) {
        add(new TypeInsnOp(code, type));
    }

    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        add(new FieldInsnOp(opcode, owner, name, descriptor));
    }

    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        add(new MultiANewArrayInsnOp(descriptor, numDimensions));
    }

    public void visitIntInsn(int opcode, int operand) {
        add(new IntInsnOp(opcode, operand));
    }

    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object[] bootstrapMethodArguments) {
        add(new InvokeDynamicInsnOp(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments));
    }

    public void visitIincOp(int varId, int increment) {
        add(new IincOp(varId, increment));
    }

    public void visitLocalVariable(String name, String descriptor, String signature, LabelOp start, LabelOp end, int index) {
        localVariables.add(new LocalVariable(name, descriptor, signature, start, end, index));
    }

    public void visitLineNumber(int lineNum, LabelOp label) {
        lineNumbers.add(new LineNumber(lineNum, label));
    }

    public List<LocalVariable> getLocalVariables() {
        return localVariables;
    }

    public List<LineNumber> getLineNumbers() {
        return lineNumbers;
    }

    public List<TryCatchBlock> getTryCatchBlocks() {
        return tryCatchBlocks;
    }

    public boolean isSamePosition(LabelOp start, LabelOp end) {
        int startPos = indexOf(start);
        ListIterator<OpBase> iter = listIterator(startPos);
        OpBase next;
        while (null != (next = iter.next())) {
            if (next == end) {
                return true;
            } else if (next instanceof LabelOp) {
                continue;
            }
            return false;
        }
        throw Exceptions.illegalArgument("end label not found");
    }

}

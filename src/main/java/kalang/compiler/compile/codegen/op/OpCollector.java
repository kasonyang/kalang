package kalang.compiler.compile.codegen.op;


import kalang.compiler.compile.codegen.util.OpcodeUtil;
import kalang.compiler.util.Exceptions;
import org.objectweb.asm.Handle;

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

    private LabelOp firstBasicBlock = new LabelOp();

    private LabelOp currentBasicBlock;

    public OpCollector() {
        currentBasicBlock = firstBasicBlock;
        addOp(firstBasicBlock);
    }

    public void visitInsn(int code) {
        addOp(new InsnOp(code));
    }

    public void visitVarInsn(int code, int var) {
        addOp(new VarInsnOp(code, var));
    }

    public void visitLabel(LabelOp label) {
        LabelOp prevBasicBlock = currentBasicBlock;
        currentBasicBlock = label;
        int exitCode = prevBasicBlock.getLastOp().opcode;
        if (!OpcodeUtil.isReturn(exitCode) && !OpcodeUtil.isUnconditionalJump(exitCode)) {
            prevBasicBlock.addSuccessor(currentBasicBlock);
        }
        addOp(label);
    }

    public void visitJumpInsn(int code, LabelOp label) {
        JumpInsnOp jumpOp = new JumpInsnOp(code, label);
        currentBasicBlock.addSuccessor(label);
        addOp(jumpOp);
    }

    public void visitTryCatchBlock(LabelOp start, LabelOp end, LabelOp handler, String type) {
        tryCatchBlocks.add(new TryCatchBlock(start, end, handler, type));
    }

    public void visitLdcInsn(Object v) {
        addOp(new LdcInsnOp(v));
    }

    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        addOp(new MethodInsnOp(opcode, owner, name, descriptor, isInterface));
    }

    public void visitTypeInsn(int code, String type) {
        addOp(new TypeInsnOp(code, type));
    }

    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        addOp(new FieldInsnOp(opcode, owner, name, descriptor));
    }

    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        addOp(new MultiANewArrayInsnOp(descriptor, numDimensions));
    }

    public void visitIntInsn(int opcode, int operand) {
        addOp(new IntInsnOp(opcode, operand));
    }

    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object[] bootstrapMethodArguments) {
        addOp(new InvokeDynamicInsnOp(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments));
    }

    public void visitIincOp(int varId, int increment) {
        addOp(new IincOp(varId, increment));
    }

    public YieldOp visitYieldOp(int contextVarId, int varCounter) {
        return addOp(new YieldOp(contextVarId, varCounter));
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

    public boolean isEndLabel(LabelOp label) {
        OpBase lastOp = getLast();
        if (!(lastOp instanceof LabelOp)) {
            return false;
        }
        return isSamePosition(label, (LabelOp)lastOp);
    }

    public boolean isSamePosition(LabelOp start, LabelOp end) {
        int startPos = indexOf(start);
        ListIterator<OpBase> iter = listIterator(startPos);
        while (iter.hasNext()) {
            OpBase next = iter.next();
            if (next == end) {
                return true;
            } else if (next instanceof LabelOp) {
                continue;
            }
            return false;
        }
        throw Exceptions.illegalArgument("end label not found");
    }

    private <T extends OpBase> T addOp(T opcode) {
        currentBasicBlock.setLastOp(opcode);
        add(opcode);
        return opcode;
    }

}

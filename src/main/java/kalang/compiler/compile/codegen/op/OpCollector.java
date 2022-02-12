package kalang.compiler.compile.codegen.op;


import kalang.compiler.compile.codegen.util.OpcodeUtil;
import org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KasonYang
 */
public class OpCollector {

    private List<Attribute> attributes = new LinkedList<>();

    private List<OpBase> opcodes = new LinkedList<>();

    private LabelOp firstBasicBlock = new LabelOp();

    private LabelOp currentBasicBlock;

    private OpBase prevOp;

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
        int exitCode = prevOp.opcode;
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
        attributes.add(new CatchAttr(start, end, handler, type));
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
        attributes.add(new LocalVariableAttr(name, descriptor, signature, start, end, index));
    }

    public void visitLineNumber(int lineNum, LabelOp label) {
        attributes.add(new LineNumberAttr(lineNum, label));
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<OpBase> getOpcodes() {
        return opcodes;
    }

    public void optimize(OpcodeOptimizer... optimizers) {
        List<OpBase> tmpOpcodes = new ArrayList<>(opcodes);
        List<Attribute> tmpAttributes = new ArrayList<>(attributes);
        for (OpcodeOptimizer optimizer : optimizers) {
            optimizer.optimize(tmpOpcodes, tmpAttributes);
        }
        opcodes = new ArrayList<>(tmpOpcodes);
        attributes = new ArrayList<>(tmpAttributes);
    }

    private <T extends OpBase> T addOp(T opcode) {
        prevOp = opcode;
        opcodes.add(opcode);
        return opcode;
    }

}

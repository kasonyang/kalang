package kalang.compiler.compile.codegen.op;

import kalang.annotation.Nullable;

import java.util.Arrays;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class OpOptimizer {

    public void optimize(OpCollector opCollector) {
        OpBase[] ops = opCollector.toArray(new OpBase[0]);
        int w = 0;
        for (int r = 0; r < ops.length; r++,w++) {
            OpBase op = ops[r];
            OpBase prevOp = r > 0 ? ops[r - 1] : null;
            int opCode = getOpCode(op);
            int prevOpCode = getOpCode(prevOp);
            if (opCode == POP || opCode == POP2) {
                if (prevOpCode == ILOAD) {
                    w -= 2;
                    continue;
                }
            } else if (opCode == NOP) {
                if (hasNextNonLabelOp(ops, r + 1)) {
                    w -= 1;
                    continue;
                }
            }
            ops[w] = op;
        }
        OpBase[] newOps = new OpBase[w];
        System.arraycopy(ops, 0, newOps, 0, newOps.length);
        opCollector.clear();
        opCollector.addAll(Arrays.asList(newOps));
    }

    private boolean hasNextNonLabelOp(OpBase[] ops, int startOffset) {
        for (int i = startOffset; i < ops.length; i++) {
            if (!(ops[i] instanceof LabelOp)) {
                return true;
            }
        }
        return false;
    }

    private int getOpCode(@Nullable OpBase op) {
        if (op instanceof InsnOp) {
            return ((InsnOp) op).opcode;
        } else if (op instanceof VarInsnOp) {
            return ((VarInsnOp) op).opcode;
        }
        return -1;
    }

}

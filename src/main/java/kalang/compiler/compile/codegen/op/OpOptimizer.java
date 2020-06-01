package kalang.compiler.compile.codegen.op;

import kalang.compiler.util.Exceptions;

import java.util.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class OpOptimizer {

    public void optimize(OpCollector opCollector) {
        OpBase[] ops = opCollector.toArray(new OpBase[0]);
        int opsLen = ops.length;
        List<TryCatchBlock> tryCatchBlocks = opCollector.getTryCatchBlocks();
        List<LocalVariable> localVariables = opCollector.getLocalVariables();
        for (;;) {
            int newOpsLen = opsLen;
            newOpsLen = removeUnusedLabels(tryCatchBlocks, localVariables, ops, newOpsLen);
            newOpsLen = removeUnreachableOp(ops, newOpsLen);
            newOpsLen = removeUnnecessaryLoadPop(ops, newOpsLen);
            if (newOpsLen > opsLen) {
                throw Exceptions.unexpectedException("fail to optimize");
            } else if (newOpsLen == opsLen) {
                break;
            }
            opsLen = newOpsLen;
        }
        opCollector.clear();
        opCollector.addAll(Arrays.asList(ops).subList(0, opsLen));
    }

    private int removeUnusedLabels(
            List<TryCatchBlock> tryCatchBlocks,
            List<LocalVariable> localVariables,
            OpBase[] ops,
            int len
    ) {
        Set<LabelOp> usedLabels = getUsedLabel(tryCatchBlocks,localVariables, ops, len);
        int w;
        for (int r = w = 0; r < len;) {
            OpBase op = ops[r];
            if (op instanceof LabelOp && !usedLabels.contains(op)) {
                r++;
                continue;
            }
            ops[w++] = ops[r++];
        }
        return w;
    }

    private int removeUnreachableOp(OpBase[] ops, int len) {
        int w;
        for (int r = w = 1; r < len;) {
            OpBase prevOp = ops[w - 1];
            if (isTerminalOp(prevOp.opcode)) {
                while (r < len && !(ops[r] instanceof LabelOp)) {
                    r++;
                }
                if (r >= len) {
                    continue;
                }
            }
            ops[w++] = ops[r++];
        }
        return w;
    }

    private int removeUnnecessaryLoadPop(OpBase[] ops, int len) {
        int w;
        for (int r = w = 1; r < len;) {
            int opCode = ops[r].opcode;
            int prevOpCode = ops[w - 1].opcode;
            if (opCode == POP) {
                if (isLoad1(prevOpCode)) {
                    w--;
                    r++;
                    continue;
                }
            } else if (opCode == POP2) {
                if (isLoad2(prevOpCode)) {
                    w--;
                    r++;
                    continue;
                }
            }
            ops[w++] = ops[r++];
        }
        return w;
    }

    private boolean isLoad1(int opc) {
        return opc == ILOAD || opc == FLOAD || opc == ALOAD;
    }

    private boolean isLoad2(int opc) {
        return opc == LLOAD || opc == DLOAD;
    }

    private boolean isTerminalOp(int opc) {
        switch (opc) {
            case GOTO:
            case ATHROW:
            case RETURN:
            case IRETURN:
            case LRETURN:
            case FRETURN:
            case DRETURN:
            case ARETURN:
                return true;
            default:
                return false;
        }
    }

    private Set<LabelOp> getUsedLabel(
            List<TryCatchBlock> tryCatchBlocks,
            List<LocalVariable> localVariables,
            OpBase[] ops,
            int opsLen
    ) {
        Set<LabelOp> result = new HashSet<>();
        for (int i = 0; i < opsLen; i++) {
            OpBase op = ops[i];
            if (op instanceof JumpInsnOp) {
                result.add(((JumpInsnOp) op).label);
            }
        }
        for (TryCatchBlock tcb : tryCatchBlocks) {
            result.add(tcb.start);
            result.add(tcb.end);
            result.add(tcb.handler);
        }
        for (LocalVariable lv: localVariables) {
            result.add(lv.start);
            result.add(lv.end);
        }
        return result;
    }

}

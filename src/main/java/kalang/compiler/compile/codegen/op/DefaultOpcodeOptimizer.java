package kalang.compiler.compile.codegen.op;

import kalang.compiler.compile.codegen.util.OpcodeUtil;
import kalang.compiler.util.Exceptions;
import kalang.mixin.CollectionMixin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class DefaultOpcodeOptimizer implements OpcodeOptimizer {

    @Override
    public void optimize(List<OpBase> opcodes, List<Attribute> attributes) {
        OpBase[] ops = opcodes.toArray(new OpBase[0]);
        List<CatchAttr> tryCatchBlocks = getTryCatchBlocks(attributes);
        int opsLen = ops.length;
        for (;;) {
            int newOpsLen = opsLen;
            newOpsLen = removeUnreachableOp(ops, newOpsLen, tryCatchBlocks);
            newOpsLen = removeUnnecessaryLoadPop(ops, newOpsLen);
            if (newOpsLen > opsLen) {
                throw Exceptions.unexpectedException("fail to optimize");
            } else if (newOpsLen == opsLen) {
                break;
            }
            opsLen = newOpsLen;
        }
        opcodes.clear();
        opcodes.addAll(Arrays.asList(ops).subList(0, opsLen));
        attributes.removeIf(e -> {
            if (e instanceof LineNumberAttr) {
                LineNumberAttr it = (LineNumberAttr) e;
                return !opcodes.contains(it.label) || OpcodeUtil.isEndLabel(opcodes, it.label);
            } else if (e instanceof LocalVariableAttr) {
                LocalVariableAttr it = (LocalVariableAttr) e;
                return OpcodeUtil.isSamePosition(opcodes, it.start, it.end);
            } else if (e instanceof CatchAttr) {
                return false;
            } else {
                throw Exceptions.unsupportedTypeException(e);
            }
        });
    }

    private List<CatchAttr> getTryCatchBlocks(List<Attribute> attributes) {
        attributes = CollectionMixin.findAll(attributes, it -> it instanceof CatchAttr);
        return CollectionMixin.map(attributes, it -> (CatchAttr) it);
    }

    private int removeUnreachableOp(OpBase[] ops, int len, List<CatchAttr> tryCatchBlocks) {
        Set<LabelOp> entryLabels = getEntryLabels(tryCatchBlocks, ops, len);
        int w;
        startLoop:
        for (int r = w = 1; r < len;) {
            OpBase prevOp = ops[w - 1];
            if (isTerminalOp(prevOp.opcode)) {
                while (r < len) {
                    OpBase op = ops[r];
                    if (op instanceof LabelOp) {
                        ops[w++] = ops[r++];
                        if (entryLabels.contains(op)) {
                            continue startLoop;
                        }
                    } else {
                        r++;
                    }
                }
                break;
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
                } else if (prevOpCode == IINC && r >= 2 && isLoad1(ops[r - 2].opcode)) {
                    ops[w - 2] = ops[w - 1];
                    w--;
                    r++;
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

    private Set<LabelOp> getEntryLabels(List<CatchAttr> tryCatchBlocks, OpBase[] ops, int opsLen) {
        Set<LabelOp> result = new HashSet<>();
        for (int i = 0; i < opsLen; i++) {
            OpBase op = ops[i];
            if (op instanceof JumpInsnOp) {
                result.add(((JumpInsnOp) op).label);
            }
        }
        for (CatchAttr tcb : tryCatchBlocks) {
            result.add(tcb.handler);
        }
        return result;
    }

}

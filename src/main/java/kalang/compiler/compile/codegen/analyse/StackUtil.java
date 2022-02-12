package kalang.compiler.compile.codegen.analyse;

import kalang.annotation.Nullable;
import kalang.compiler.compile.codegen.op.LabelOp;
import kalang.compiler.compile.codegen.op.OpBase;
import kalang.compiler.compile.codegen.util.OpcodeUtil;
import kalang.mixin.CollectionMixin;

import java.util.*;

/**
 * @author KasonYang
 */
public class StackUtil {

    public static String[] getStack(List<OpBase> opcodes, LabelOp currentBasicBlock, OpBase after) {
        Collection<List<String>> list = getCurrentStack(opcodes, currentBasicBlock, after);
        assert list.size() == 1;
        return list.iterator().next().toArray(new String[0]);
    }


    private static Collection<List<String>> getCurrentStack(List<OpBase> opcodes, LabelOp currentBasicBlock, OpBase after) {
        return getFinalStack(opcodes, currentBasicBlock, after, new HashSet<>());
    }

    private static Collection<List<String>> getFinalStack(List<OpBase> opcodes, LabelOp basicBlock, OpBase stopOp, Set<LabelOp> visitedBasicBlocks) {
        visitedBasicBlocks.add(basicBlock);
        Collection<LabelOp> predecessors = basicBlock.getPredecessors();
        predecessors = CollectionMixin.findAll(predecessors, it -> !visitedBasicBlocks.contains(it));
        Collection<List<String>> preFinalStacks = new HashSet<>();
        if (predecessors.isEmpty()) {
            preFinalStacks.add(new LinkedList<>());
        } else {
            for (LabelOp p : predecessors) {
                preFinalStacks.addAll(getFinalStack(opcodes, p, stopOp, visitedBasicBlocks));
            }
        }
        Set<List<String>> result = new HashSet<>(preFinalStacks.size());
        for (List<String> pre : preFinalStacks) {
            Stack<String> stack = new Stack<>();
            stack.addAll(pre);
            executeBlockWithStack(opcodes, basicBlock, stopOp, stack);
            result.add(stack);
        }
        return result;
    }

    /**
     *
     * @param opcodes the opcode collector
     * @param basicBlock the basic block
     * @param stopOp the operator to stop(inclusive)
     * @param stack the stack
     */
    public static void executeBlockWithStack(List<OpBase> opcodes, LabelOp basicBlock, @Nullable OpBase stopOp, Stack<String> stack) {
        int idx = opcodes.indexOf(basicBlock);
        OpBase lastOp = opcodes.get(opcodes.size() - 1);
        for (int i = idx; i < opcodes.size(); i++) {
            OpBase op = opcodes.get(i);
            String[][] ioTypes = op.getIoTypes();
            String[] inTypes = ioTypes[0];
            String[] outTypes = ioTypes[1];
            String[] consumedType = new String[inTypes.length];
            for (int j = inTypes.length - 1; j >= 0; j--) {
                String top = stack.pop();
                //TODO check stack type
                consumedType[j] = top;
            }
            for (int k = 0; k < outTypes.length; k++) {
                if (OpBase.ST_ELEMENT.equals(outTypes[k])) {
                    outTypes[k] = consumedType[1];
                }
            }
            for (String outType : outTypes) {
                stack.push(outType);
            }

            if (op == stopOp || op == lastOp || OpcodeUtil.isBasicBlockEnding(op, opcodes.get(i + 1))) {
                break;
            }
        }
    }


}

package kalang.compiler.compile.codegen.analyse;

import kalang.annotation.Nullable;
import kalang.compiler.compile.codegen.op.LabelOp;
import kalang.compiler.compile.codegen.op.OpBase;
import kalang.compiler.compile.codegen.op.OpCollector;
import kalang.mixin.CollectionMixin;

import java.util.*;

/**
 * @author KasonYang
 */
public class StackUtil {

    public static String[] getStack(OpCollector opCollector, LabelOp currentBasicBlock, OpBase after) {
        Collection<List<String>> list = getCurrentStack(opCollector, currentBasicBlock, after);
        assert list.size() == 1;
        return list.iterator().next().toArray(new String[0]);
    }


    private static Collection<List<String>> getCurrentStack(OpCollector opCollector, LabelOp currentBasicBlock, OpBase after) {
        return getFinalStack(opCollector, currentBasicBlock, after, new HashSet<>());
    }

    private static Collection<List<String>> getFinalStack(OpCollector opCollector, LabelOp basicBlock, OpBase stopOp, Set<LabelOp> visitedBasicBlocks) {
        visitedBasicBlocks.add(basicBlock);
        Collection<LabelOp> predecessors = basicBlock.getPredecessors();
        predecessors = CollectionMixin.findAll(predecessors, it -> !visitedBasicBlocks.contains(it));
        Collection<List<String>> preFinalStacks = new HashSet<>();
        if (predecessors.isEmpty()) {
            preFinalStacks.add(new LinkedList<>());
        } else {
            for (LabelOp p : predecessors) {
                preFinalStacks.addAll(getFinalStack(opCollector, p, stopOp, visitedBasicBlocks));
            }
        }
        Set<List<String>> result = new HashSet<>(preFinalStacks.size());
        for (List<String> pre : preFinalStacks) {
            Stack<String> stack = new Stack<>();
            stack.addAll(pre);
            executeBlockWithStack(opCollector, basicBlock, stopOp, stack);
            result.add(stack);
        }
        return result;
    }

    /**
     *
     * @param opCollector the opcode collector
     * @param basicBlock the basic block
     * @param stopOp the operator to stop(inclusive)
     * @param stack the stack
     */
    public static void executeBlockWithStack(OpCollector opCollector, LabelOp basicBlock, @Nullable OpBase stopOp, Stack<String> stack) {
        int idx = opCollector.indexOf(basicBlock);
        OpBase lastOp = basicBlock.getLastOp();
        assert opCollector.contains(lastOp);
        for (int i = idx; i < opCollector.size(); i++) {
            OpBase op = opCollector.get(i);
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

            if (op == stopOp || op == lastOp) {
                break;
            }
        }
    }


}

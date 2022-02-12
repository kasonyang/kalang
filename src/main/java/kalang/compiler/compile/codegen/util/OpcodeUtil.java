package kalang.compiler.compile.codegen.util;

import kalang.compiler.compile.codegen.op.Attribute;
import kalang.compiler.compile.codegen.op.LabelOp;
import kalang.compiler.compile.codegen.op.OpBase;
import kalang.compiler.util.Exceptions;
import kalang.mixin.CollectionMixin;

import java.util.List;
import java.util.ListIterator;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class OpcodeUtil {

    public static boolean isConditionalJump(int opcode) {
        return opcode >= IFEQ && opcode <= IF_ACMPNE;
    }

    public static boolean isUnconditionalJump(int opcode) {
        return opcode == GOTO;
    }

    public static boolean isReturn(int opcode) {
        return opcode >= IRETURN && opcode <= RETURN;
    }


    public static boolean isEndLabel(List<OpBase> opcodes, LabelOp label) {
        OpBase lastOp = opcodes.get(opcodes.size() - 1);
        if (!(lastOp instanceof LabelOp)) {
            return false;
        }
        return isSamePosition(opcodes, label, (LabelOp)lastOp);
    }

    public static boolean isSamePosition(List<OpBase> opcodes, LabelOp start, LabelOp end) {
        int startPos = opcodes.indexOf(start);
        ListIterator<OpBase> iter = opcodes.listIterator(startPos);
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

    @SuppressWarnings("unchecked")
    public static <T> List<T> getAttributes(List<Attribute> attributes, Class<T> clazz) {
        attributes = CollectionMixin.findAll(attributes, it -> clazz.isAssignableFrom(it.getClass()));
        return CollectionMixin.map(attributes, it -> (T) it);
    }

    public static boolean isBasicBlockEnding(OpBase opcode, OpBase nextOpcode) {
        return nextOpcode instanceof LabelOp
                || isReturn(opcode.opcode)
                || isConditionalJump(opcode.opcode)
                || isUnconditionalJump(opcode.opcode)
                ;
    }

}

package kalang.compiler.compile.codegen.util;

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

}

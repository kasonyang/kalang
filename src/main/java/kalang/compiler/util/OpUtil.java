package kalang.compiler.util;

import kalang.compiler.compile.codegen.op.LocalVariable;
import kalang.compiler.compile.codegen.op.OpBase;
import kalang.compiler.compile.codegen.op.OpCollector;
import kalang.compiler.compile.codegen.op.TryCatchBlock;

/**
 * @author KasonYang
 */
public class OpUtil {

    public static String toString(OpCollector opCollector) {
        StringBuilder sb = new StringBuilder();
        for (OpBase op: opCollector) {
            sb.append(op).append("\n");
        }
        sb.append("\nException tables:\n");
        for (TryCatchBlock tcb : opCollector.getTryCatchBlocks()) {
            sb.append(tcb.type).append(" ")
                    .append(tcb.start).append(" ")
                    .append(tcb.end).append(" ")
                    .append(tcb.handler).append(" \n");
        }
        sb.append("\nVariables:\n");
        for (LocalVariable lv : opCollector.getLocalVariables()) {
            sb.append(lv.name).append(" ").append(lv.start).append(" ").append(lv.end).append(" \n");
        }
        return sb.toString();
    }

}

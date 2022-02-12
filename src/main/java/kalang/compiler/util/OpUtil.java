package kalang.compiler.util;

import kalang.compiler.compile.codegen.op.*;
import kalang.compiler.compile.codegen.util.OpcodeUtil;

import java.util.List;

/**
 * @author KasonYang
 */
public class OpUtil {

    public static String toString(OpCollector opCollector) {
        StringBuilder sb = new StringBuilder();
        for (OpBase op: opCollector.getOpcodes()) {
            sb.append(op).append("\n");
        }
        List<Attribute> attributes = opCollector.getAttributes();
        sb.append("\nException tables:\n");
        List<CatchAttr> tryCatchBlocks = OpcodeUtil.getAttributes(attributes, CatchAttr.class);
        for (CatchAttr tcb : tryCatchBlocks) {
            sb.append(tcb.type).append(" ")
                    .append(tcb.start).append(" ")
                    .append(tcb.end).append(" ")
                    .append(tcb.handler).append(" \n");
        }
        sb.append("\nVariables:\n");
        List<LocalVariableAttr> vars = OpcodeUtil.getAttributes(attributes, LocalVariableAttr.class);
        for (LocalVariableAttr lv : vars) {
            sb.append(lv.name).append(" ").append(lv.start).append(" ").append(lv.end).append(" \n");
        }
        return sb.toString();
    }

}

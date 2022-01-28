package kalang.compiler.compile.codegen.op;

import kalang.compiler.util.Exceptions;

import static org.objectweb.asm.Opcodes.LDC;

/**
 * @author KasonYang
 */
public class LdcInsnOp extends OpBase {

    public Object value;

    public LdcInsnOp(Object value) {
        this.opcode = LDC;
        this.value = value;
    }

    @Override
    public String[][] getIoTypes() {
        if (value instanceof Integer){
            return outTypes(ST_INT);
        } else if (value instanceof Byte){
            return outTypes(ST_BYTE);
        } else if (value instanceof Short){
            return outTypes(ST_SHORT);
        } else if (value instanceof Boolean) {
            return outTypes(ST_BOOLEAN);
        } else if (value instanceof Long) {
            return outTypes(ST_LONG);
        } else if (value instanceof Float) {
            return outTypes(ST_FLOAT);
        } else if (value instanceof Double) {
            return outTypes(ST_DOUBLE);
        } else if (value instanceof String) {
            return outTypes(ST_STRING);
        } else {
            throw Exceptions.unsupportedTypeException(value);
        }
    }

    @Override
    public String toString() {
        return "LDC " + value;
    }
}

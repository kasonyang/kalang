package kalang.compiler.compile.codegen.op;

import kalang.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KasonYang
 */
public abstract class OpBase {

    public int opcode = -1;

    public final static String[] OPC_DESC = new String[512];

    public final static String ST_BOOLEAN = "Z";
    public final static String ST_BYTE = "B";
    public final static String ST_SHORT = "S";

    public final static String ST_CHAR = "C";

    public final static String ST_INT = "I";
    public final static String ST_LONG = "J";
    public final static String ST_FLOAT = "F";
    public final static String ST_DOUBLE = "D";
    public final static String ST_ANY = "a";
    public final static String ST_ELEMENT = "e";

    public final static String ST_STRING = "Ljava/lang/String;";
    public final static String ST_OBJECT = "Ljava/lang/Object;";

    protected final static String[] TYPES_NONE = new String[0];

    public final static int TEMP_OP_YIELD = 511;

    static {
        OPC_DESC[0] = "NOP";
        OPC_DESC[1] = "ACONST_NULL";
        OPC_DESC[2] = "ICONST_M1";
        OPC_DESC[3] = "ICONST_0";
        OPC_DESC[4] = "ICONST_1";
        OPC_DESC[5] = "ICONST_2";
        OPC_DESC[6] = "ICONST_3";
        OPC_DESC[7] = "ICONST_4";
        OPC_DESC[8] = "ICONST_5";
        OPC_DESC[9] = "LCONST_0";
        OPC_DESC[10] = "LCONST_1";
        OPC_DESC[11] = "FCONST_0";
        OPC_DESC[12] = "FCONST_1";
        OPC_DESC[13] = "FCONST_2";
        OPC_DESC[14] = "DCONST_0";
        OPC_DESC[15] = "DCONST_1";
        OPC_DESC[16] = "BIPUSH";
        OPC_DESC[17] = "SIPUSH";
        OPC_DESC[18] = "LDC";
        OPC_DESC[21] = "ILOAD";
        OPC_DESC[22] = "LLOAD";
        OPC_DESC[23] = "FLOAD";
        OPC_DESC[24] = "DLOAD";
        OPC_DESC[25] = "ALOAD";
        OPC_DESC[46] = "IALOAD";
        OPC_DESC[47] = "LALOAD";
        OPC_DESC[48] = "FALOAD";
        OPC_DESC[49] = "DALOAD";
        OPC_DESC[50] = "AALOAD";
        OPC_DESC[51] = "BALOAD";
        OPC_DESC[52] = "CALOAD";
        OPC_DESC[53] = "SALOAD";
        OPC_DESC[54] = "ISTORE";
        OPC_DESC[55] = "LSTORE";
        OPC_DESC[56] = "FSTORE";
        OPC_DESC[57] = "DSTORE";
        OPC_DESC[58] = "ASTORE";
        OPC_DESC[79] = "IASTORE";
        OPC_DESC[80] = "LASTORE";
        OPC_DESC[81] = "FASTORE";
        OPC_DESC[82] = "DASTORE";
        OPC_DESC[83] = "AASTORE";
        OPC_DESC[84] = "BASTORE";
        OPC_DESC[85] = "CASTORE";
        OPC_DESC[86] = "SASTORE";
        OPC_DESC[87] = "POP";
        OPC_DESC[88] = "POP2";
        OPC_DESC[89] = "DUP";
        OPC_DESC[90] = "DUP_X1";
        OPC_DESC[91] = "DUP_X2";
        OPC_DESC[92] = "DUP2";
        OPC_DESC[93] = "DUP2_X1";
        OPC_DESC[94] = "DUP2_X2";
        OPC_DESC[95] = "SWAP";
        OPC_DESC[96] = "IADD";
        OPC_DESC[97] = "LADD";
        OPC_DESC[98] = "FADD";
        OPC_DESC[99] = "DADD";
        OPC_DESC[100] = "ISUB";
        OPC_DESC[101] = "LSUB";
        OPC_DESC[102] = "FSUB";
        OPC_DESC[103] = "DSUB";
        OPC_DESC[104] = "IMUL";
        OPC_DESC[105] = "LMUL";
        OPC_DESC[106] = "FMUL";
        OPC_DESC[107] = "DMUL";
        OPC_DESC[108] = "IDIV";
        OPC_DESC[109] = "LDIV";
        OPC_DESC[110] = "FDIV";
        OPC_DESC[111] = "DDIV";
        OPC_DESC[112] = "IREM";
        OPC_DESC[113] = "LREM";
        OPC_DESC[114] = "FREM";
        OPC_DESC[115] = "DREM";
        OPC_DESC[116] = "INEG";
        OPC_DESC[117] = "LNEG";
        OPC_DESC[118] = "FNEG";
        OPC_DESC[119] = "DNEG";
        OPC_DESC[120] = "ISHL";
        OPC_DESC[121] = "LSHL";
        OPC_DESC[122] = "ISHR";
        OPC_DESC[123] = "LSHR";
        OPC_DESC[124] = "IUSHR";
        OPC_DESC[125] = "LUSHR";
        OPC_DESC[126] = "IAND";
        OPC_DESC[127] = "LAND";
        OPC_DESC[128] = "IOR";
        OPC_DESC[129] = "LOR";
        OPC_DESC[130] = "IXOR";
        OPC_DESC[131] = "LXOR";
        OPC_DESC[132] = "IINC";
        OPC_DESC[133] = "I2L";
        OPC_DESC[134] = "I2F";
        OPC_DESC[135] = "I2D";
        OPC_DESC[136] = "L2I";
        OPC_DESC[137] = "L2F";
        OPC_DESC[138] = "L2D";
        OPC_DESC[139] = "F2I";
        OPC_DESC[140] = "F2L";
        OPC_DESC[141] = "F2D";
        OPC_DESC[142] = "D2I";
        OPC_DESC[143] = "D2L";
        OPC_DESC[144] = "D2F";
        OPC_DESC[145] = "I2B";
        OPC_DESC[146] = "I2C";
        OPC_DESC[147] = "I2S";
        OPC_DESC[148] = "LCMP";
        OPC_DESC[149] = "FCMPL";
        OPC_DESC[150] = "FCMPG";
        OPC_DESC[151] = "DCMPL";
        OPC_DESC[152] = "DCMPG";
        OPC_DESC[153] = "IFEQ";
        OPC_DESC[154] = "IFNE";
        OPC_DESC[155] = "IFLT";
        OPC_DESC[156] = "IFGE";
        OPC_DESC[157] = "IFGT";
        OPC_DESC[158] = "IFLE";
        OPC_DESC[159] = "IF_ICMPEQ";
        OPC_DESC[160] = "IF_ICMPNE";
        OPC_DESC[161] = "IF_ICMPLT";
        OPC_DESC[162] = "IF_ICMPGE";
        OPC_DESC[163] = "IF_ICMPGT";
        OPC_DESC[164] = "IF_ICMPLE";
        OPC_DESC[165] = "IF_ACMPEQ";
        OPC_DESC[166] = "IF_ACMPNE";
        OPC_DESC[167] = "GOTO";
        OPC_DESC[168] = "JSR";
        OPC_DESC[169] = "RET";
        OPC_DESC[170] = "TABLESWITCH";
        OPC_DESC[171] = "LOOKUPSWITCH";
        OPC_DESC[172] = "IRETURN";
        OPC_DESC[173] = "LRETURN";
        OPC_DESC[174] = "FRETURN";
        OPC_DESC[175] = "DRETURN";
        OPC_DESC[176] = "ARETURN";
        OPC_DESC[177] = "RETURN";
        OPC_DESC[178] = "GETSTATIC";
        OPC_DESC[179] = "PUTSTATIC";
        OPC_DESC[180] = "GETFIELD";
        OPC_DESC[181] = "PUTFIELD";
        OPC_DESC[182] = "INVOKEVIRTUAL";
        OPC_DESC[183] = "INVOKESPECIAL";
        OPC_DESC[184] = "INVOKESTATIC";
        OPC_DESC[185] = "INVOKEINTERFACE";
        OPC_DESC[186] = "INVOKEDYNAMIC";
        OPC_DESC[187] = "NEW";
        OPC_DESC[188] = "NEWARRAY";
        OPC_DESC[189] = "ANEWARRAY";
        OPC_DESC[190] = "ARRAYLENGTH";
        OPC_DESC[191] = "ATHROW";
        OPC_DESC[192] = "CHECKCAST";
        OPC_DESC[193] = "INSTANCEOF";
        OPC_DESC[194] = "MONITORENTER";
        OPC_DESC[195] = "MONITOREXIT";
        OPC_DESC[197] = "MULTIANEWARRAY";
        OPC_DESC[198] = "IFNULL";
        OPC_DESC[199] = "IFNONNULL";

        // temp opcode
        OPC_DESC[TEMP_OP_YIELD] = "YIELD";
    }

    /**
     * Get Input/Output types
     * @return [[inputTypes...], [outputTypes...]]
     */
    public abstract String[][] getIoTypes();
    
    static String[][] getIoTypesByMethodDescriptor(String descriptor, @Nullable String targetOwner) {
        List<String> paramTypes = new ArrayList<>(32);
        String[] outType = new String[0];
        char[] chars = descriptor.toCharArray();
        if (chars.length == 0) {
            throw new IllegalArgumentException("empty descriptor");
        }
        if (chars[0] != '(') {
            throw new IllegalArgumentException("illegal start character:" + chars[0]);
        }
        if (targetOwner != null) {
            paramTypes.add("L" + targetOwner + ";");
        }
        int p = 1;
        for (;;) {
            if (chars[p] == ')') {
                if (chars[p + 1] != 'V') {
                    String result = readOneType(chars, p + 1);
                    outType = new String[]{result};
                }
                break;
            }
            String result = readOneType(chars, p);
            paramTypes.add(result);
            p += result.length();
        }
        return ioTypes(paramTypes.toArray(new String[0]), outType);
    }

    static String[][] noTypes() {
        return ioTypes(TYPES_NONE, TYPES_NONE);
    }

    static String[][] ioTypes(String inType, String outType) {
        return ioTypes(new String[]{inType}, new String[]{outType});
    }

    static String[][] ioTypes(String[] inTypes, String[] outTypes) {
        return new String[][]{inTypes, outTypes};
    }

    static String[][] outTypes(String... types) {
        return ioTypes(TYPES_NONE, types);
    }

    static String[][] inTypes(String... types) {
        return ioTypes(types, TYPES_NONE);
    }

    static String[] types(String... types) {
        return types;
    }

    static RuntimeException unsupportedOpcode(int opcode) {
        throw new IllegalArgumentException("unsupported opcode:" + opcode);
    }

    /**
     *
     * @param descriptor the descriptor
     * @param start the start offset
     * @return [slotType, consumeBytes]
     */
    private static String readOneType(char[] descriptor, int start) {
        char c = descriptor[start];
        if (c == '[') {
            return "[" + readOneType(descriptor, start + 1);
        } else if (c == 'L') {
            int p = start + 1;
            while (descriptor[p] != ';') {
                p++;
            }
            return new String(descriptor, start, p - start + 1);
        } else {
            switch (c) {
                case 'Z':
                case 'I':
                case 'C':
                case 'S':
                case 'B':
                case 'J':
                case 'F':
                case 'D':
                    return new String(descriptor, start, 1);
                default:
                    throw new IllegalArgumentException("unknown character:" + c);
            }
        }
    }

}

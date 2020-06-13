package kalang.compiler.util;

/**
 *
 * @author Kason Yang
 */
public class StringLiteralUtil {

    public static String parse(String literal) {
        char[] cs = literal.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < cs.length) {
            char c = cs[i++];
            if (c == '\\') {
                char nc = cs[i++];
                switch (nc) {
                    case 'b':
                        sb.append('\b');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 'u':
                        sb.appendCodePoint(Integer.parseInt(new String(cs, i, 4), 16));
                        i+= 4;
                        break;
                    case '"':
                        sb.append('"');
                        break;
                    case '\'':
                        sb.append('\'');
                        break;
                    case '\\':
                        sb.append('\\');
                        break;
                    default:
                        throw Exceptions.unexpectedValue(nc);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static long parseLong(String longLiteral) throws NumberFormatException {
        if (longLiteral.startsWith("0x") || longLiteral.startsWith("0X")) {
            return Long.parseUnsignedLong(longLiteral.substring(2).replace("_", ""), 16);
        } else if (longLiteral.length() > 1 && longLiteral.startsWith("0")) {
            return Long.parseUnsignedLong(longLiteral.substring(1).replace("_", ""), 8);
        } else {
            return Long.parseUnsignedLong(longLiteral.replace("_", ""), 10);
        }
    }

    public static int parseInteger(String longLiteral) {
        if (longLiteral.startsWith("0x") || longLiteral.startsWith("0X")) {
            return Integer.parseUnsignedInt(longLiteral.substring(2).replace("_", ""), 16);
        } else if (longLiteral.length() > 1 && longLiteral.startsWith("0")) {
            return Integer.parseUnsignedInt(longLiteral.substring(1).replace("_", ""), 8);
        } else {
            return Integer.parseUnsignedInt(longLiteral.replace("_", ""), 10);
        }
    }

}

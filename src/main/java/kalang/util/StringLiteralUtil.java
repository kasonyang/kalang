package kalang.util;
/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class StringLiteralUtil {
    
    public static String parse(String literal){
        char[] cs = literal.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<cs.length){
            char c = cs[i++];
            if(c=='\\'){
                char nc = cs[i++];
                switch(nc){
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
                        sb.append('\\');
                        i--;
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

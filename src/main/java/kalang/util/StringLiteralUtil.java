package kalang.util;
/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class StringLiteralUtil {
    
    public static String parse(String literal){
        //TODO parse unicode
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
    
    private static long parseHex(String hex){
        long ret = 0;
        char[] chars = hex.toUpperCase().toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            int n;
            if(c>='0' && c<='9'){
                n = c - '0';
            }else if(c>='A' && c<='F'){
                n = 10 + (c-'A');
            }else{
                throw new NumberFormatException("unknown charater:" + c);
            }
            ret = ret | ( n << ((chars.length-1- i) * 4) );         
        }
        return ret;
    }
    
        private static long parseOctal(String hex){
        long ret = 0;
        char[] chars = hex.toUpperCase().toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            int n;
            if(c>='0' && c<='7'){
                n = c - '0';
            }else{
                throw new NumberFormatException("unknown charater:" + c);
            }
            ret = ret | ( n << ((chars.length-1- i) * 3) );         
        }
        return ret;
    }
    
    public static long parseLong(String longLiteral) throws NumberFormatException{
        if(longLiteral.startsWith("0x") || longLiteral.startsWith("0X")){
            return parseHex(longLiteral.substring(2));
        }else if(longLiteral.startsWith("0")){
            return parseOctal(longLiteral.substring(1));
        }else{
            return Long.parseLong(longLiteral);
        }
    }

}

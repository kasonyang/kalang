package kalang.compiler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author Kason Yang
 */
public class StringUtil {
    
    public static String indentLines(String str,String indent,String newLineDelimiter){
        StringReader sr = new StringReader(str);
        BufferedReader br = new BufferedReader(sr);
        StringBuilder sb = new StringBuilder();
        String ln;
        try {
            while((ln=br.readLine())!=null){
                if(sb.length()>0){
                    sb.append(newLineDelimiter);
                }
                sb.append(indent).append(ln);
            }
            return sb.toString();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

}

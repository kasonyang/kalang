package kalang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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

}

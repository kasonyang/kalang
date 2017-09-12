package kalang.tool;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Kason Yang 
 */
public interface OutputManager {
    
    OutputStream createOutputStream(String className) throws IOException;

}


package kalang.compiler.compile;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Kason Yang 
 */
public interface KalangSource {

    String[] EXTENSION_STANDARD = new String[] {"kl", "kalang"};

    String[] EXTENSION_SCRIPT = new String[] {"kls"};


    String getClassName();

    InputStream createInputStream() throws IOException;

    String getFileName();

    boolean isScript();

}

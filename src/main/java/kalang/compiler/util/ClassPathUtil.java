package kalang.compiler.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Set;

/**
 * @author KasonYang
 */
public class ClassPathUtil {

    public static void addClasspathFromLibPath(Set<URL> list, File libpath) {
        if (!libpath.exists() || !libpath.isDirectory()) {
            return;
        }
        Collection<File> jars = FileUtils.listFiles(libpath, new String[]{"jar"}, false);
        for (File j : jars) {
            try {
                list.add(j.toURI().toURL());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}

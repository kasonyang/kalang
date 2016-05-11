
package kalang.tool;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class MultiClassLoader extends ClassLoader{

    final List<ClassLoader> classLoaders = new LinkedList<>();

    public MultiClassLoader() {
    }
    
    public MultiClassLoader(ClassLoader... classLoaders) {
        this.classLoaders.addAll(Arrays.asList(classLoaders));
    }
    
    public void addClassLoader(ClassLoader classLoader){
        classLoaders.add(classLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        for(ClassLoader cl:classLoaders){
            try{
                Class<?> clazz = cl.loadClass(name);
                return clazz;
            }catch(ClassNotFoundException ex){
                
            }
        }
        throw new ClassNotFoundException(name);
    }

}

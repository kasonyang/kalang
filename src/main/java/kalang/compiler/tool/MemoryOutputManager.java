package kalang.compiler.tool;

import javax.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kason Yang 
 */
public class MemoryOutputManager implements OutputManager{
    
    final Map<String,ByteArrayOutputStream> oss = new HashMap();

    @Override
    public OutputStream createOutputStream(String className) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        oss.put(className, os);
        return  os;
    }
    
    public String[] getClassNames(){
        return oss.keySet().toArray(new String[0]);
    }

    @Nullable
    public byte [] getBytes(String className) {
        ByteArrayOutputStream os = oss.get(className);
        if(os==null) return null;
        return os.toByteArray();
    }

}

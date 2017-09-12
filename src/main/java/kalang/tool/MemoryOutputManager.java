package kalang.tool;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/**
 *
 * @author Kason Yang 
 */
public class MemoryOutputManager implements OutputManager{
    
    final Map<String,ByteArrayOutputStream> oss = new HashMap();

    @Override
    public OutputStream createOutputStream(String className) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        oss.put(className, os);
        return  os;
    }
    
    public String[] getClassNames(){
        return oss.keySet().toArray(new String[oss.size()]);
    }

    @Nullable
    public byte [] getBytes(String className) {
        ByteArrayOutputStream os = oss.get(className);
        if(os==null) return null;
        return os.toByteArray();
    }

}

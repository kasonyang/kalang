package kalang.script;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.lang.Script;

/**
 *
 * @author Kason Yang
 */
public abstract class ShellScript extends Script {
    
    protected int exec(String command,String... arguments) throws IOException{
        String[] list = new String[arguments.length+1];
        list[0] = command;
        if(arguments.length>0){
            System.arraycopy(arguments, 0, list, 1, arguments.length);
        }
        ProcessBuilder pb = new ProcessBuilder(list);
        pb.inheritIO();
        Process p = pb.start();
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            
        }
        return p.exitValue();
    }
    
    protected int exec(String command) throws IOException{
        return exec(command,new String[0]);
    }

}

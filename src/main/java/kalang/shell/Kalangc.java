package kalang.shell;

import kalang.tool.ShellExecutor;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangc {
    
    public static void main(String[] args) {
        Options ops = new Options();
        ops.addOption("o", true, "output directory");
        ops.addOption("f",true,"output format");
        ShellExecutor executor = new ShellExecutor();
        executor.execute(ShellExecutor.CMD_COMPILE, args, "kalangc", ops);
    }

}

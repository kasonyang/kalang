package kalang.shell;

import kalang.tool.ShellExecutor;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangeditor {

    public static final String SYNTAX = "kalangeditor";

    public static void main(String[] args) {
        Options options = new Options();
        ShellExecutor executor = new ShellExecutor();
        executor.execute(kalang.tool.ShellExecutor.CMD_GUI, args, SYNTAX, options);
    }

}

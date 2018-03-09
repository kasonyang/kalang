package kalang.shell;

import kalang.tool.ShellExecutor;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangsh {

    private final static String SYNTAX = "kalangsh [options] FILE";

    public static void main(String[] args) {
        Options options = new Options();
        ShellExecutor executor = new ShellExecutor();
        executor.execute(ShellExecutor.CMD_RUN, args, SYNTAX, options);
    }

}

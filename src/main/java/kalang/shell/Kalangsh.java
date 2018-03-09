package kalang.shell;

import kalang.tool.Compiler;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangsh {

    private final static String SYNTAX = "kalangsh [options] FILE";

    public static void main(String[] args) {
        Options options = new Options();
        Compiler compiler = new Compiler();
        compiler.compile(Compiler.CMD_RUN, args, SYNTAX, options);
    }

}

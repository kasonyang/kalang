package kalang.shell;

import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangeditor {

    public static final String SYNTAX = "kalangeditor";

    public static void main(String[] args) {
        Options options = new Options();
        kalang.tool.Compiler compiler = new kalang.tool.Compiler();
        compiler.compile(kalang.tool.Compiler.CMD_GUI, args, SYNTAX, options);
    }

}

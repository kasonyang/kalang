package kalang.shell;

import kalang.compiler.Configuration;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangeditor extends ShellBase {

    public static final String SYNTAX = "kalangeditor";

    public static void main(String[] args) {
        new Kalangeditor().run(args);
    }

    private void run(String[] args) {
        Options options = new Options();
        CommandLine cli = this.parseArgs(options, args);
        if (cli == null || cli.hasOption("help")) {
            printUsage(SYNTAX, options);
        }
        Configuration config = this.createConfiguration(cli);
        ClassLoader classLoader = this.createClassLoader(cli);
        kalang.gui.Editor.main(config, classLoader);

    }

}

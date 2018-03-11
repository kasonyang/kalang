package kalang.shell;

import java.io.File;
import java.io.IOException;
import kalang.compiler.Configuration;
import kalang.lang.Script;
import kalang.tool.KalangShell;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangsh extends ShellBase {

    private final static String SYNTAX = "kalangsh [options] FILE [options]";

    public static void main(String[] args) {
        new Kalangsh().run(args);
    }

    private void run(String[] args) {
        Options options = new Options();
        options.addOption("c", "code", true, "run code from code option");
        options.addOption("","check",false,"don't run,just check");
        CommandLine cli = parseArgs(options, args);
        if (cli == null || cli.hasOption("help")) {
            printUsage(SYNTAX, options);
            return;
        }
        run(cli, options);
    }

    private void run(CommandLine cli, Options options) {
        Configuration config = this.createConfiguration(cli);
        ClassLoader classLoader = this.createClassLoader(cli);

        String[] args = cli.getArgs();
        KalangShell sh = new KalangShell(config, classLoader);
        try {
            Script script;
            String[] scriptArgs;
            if (cli.hasOption("c")) {
                scriptArgs = new String[0];
                script = sh.parseScript("Temp", cli.getOptionValue("c"), "Tmp.kl");
            } else {
                if (args.length == 0) {
                    printUsage(SYNTAX, options);
                }
                File file = new File(args[0]);
                scriptArgs = new String[args.length - 1];
                if (args.length > 1) {
                    System.arraycopy(args, 1, scriptArgs, 0, scriptArgs.length);
                }
                script = sh.parseScript(file);
            }
            if (!cli.hasOption("check")) {
                script.run(scriptArgs);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

}

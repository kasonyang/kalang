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

    private final static String APP_NAME = "kalangsh";

    private final static String SYNTAX = "kalangsh [options] FILE [options]";

    private Kalangsh() {
        super(APP_NAME, SYNTAX, createOptions());
    }

    public static void main(String[] args) {
        new Kalangsh().run(args);
    }

    @Override
    protected void execute(CommandLine cli) {
        Configuration config = this.createConfiguration(cli);
        ClassLoader classLoader = this.createClassLoader(cli);

        String[] args = cli.getArgs();
        KalangShell sh = new KalangShell(config, classLoader);
        try {
            Script script;
            String[] scriptArgs;
            if (cli.hasOption("code")) {
                scriptArgs = new String[0];
                script = sh.parseScript("Temp", cli.getOptionValue("code"), "Tmp.kl");
            } else {
                if (args.length == 0) {
                    printUsage();
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

    private static Options createOptions() {
        Options options = new Options();
        options.addOption("c", "code", true, "run code from code option");
        options.addOption(null, "check", false, "don't run,just check");
        return options;
    }

}

package kalang.shell;

import kalang.compiler.Configuration;
import kalang.dependency.Artifact;
import kalang.dependency.DependencyResolver;
import kalang.dependency.ResolveResult;
import kalang.tool.KalangShell;
import kalang.util.ClassExecutor;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import javax.annotation.Nullable;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class Kalangsh extends ShellBase {

    private final static String APP_NAME = "kalangsh";

    private final static String SYNTAX = "kalangsh [options] FILE [options]";

    public Kalangsh() {
        super(APP_NAME, SYNTAX, createOptions());
    }

    public static void main(String[] args) {
        System.exit(new Kalangsh().run(args));
    }

    @Override
    protected int execute(CommandLine cli) {
        Configuration config = this.createConfiguration(cli);
        ClassLoader classLoader = this.createClassLoader(cli);

        String[] args = cli.getArgs();
        try {
            Class clazz;
            String[] scriptArgs;
            if (cli.hasOption("code")) {
                String code = cli.getOptionValue("code");
                KalangShell sh = this.createKalangShell(config, classLoader,new StringReader(code));
                scriptArgs = new String[0];
                clazz = sh.parse("Temp",code, "Tmp.kl");
            } else {
                if (args.length == 0) {
                    printUsage();
                }
                File file = new File(args[0]);
                scriptArgs = new String[args.length - 1];
                if (args.length > 1) {
                    System.arraycopy(args, 1, scriptArgs, 0, scriptArgs.length);
                }
                FileReader fileReader = new FileReader(file);
                KalangShell sh = this.createKalangShell(config, classLoader, fileReader);
                fileReader.close();
                clazz = sh.parse(file);
            }
            if (!cli.hasOption("check")) {
                ClassExecutor.executeMain(clazz, scriptArgs);
            }
            return Constant.SUCCESS;
        } catch (Throwable ex) {
            ex.printStackTrace(System.err);
            return Constant.ERR_UNKNOWN_EXCEPTION;
        }
    }

    private static Options createOptions() {
        Options options = new Options();
        options.addOption("c", "code", true, "run code from code option");
        options.addOption(null, "check", false, "don't run,just check");
        return options;
    }

}

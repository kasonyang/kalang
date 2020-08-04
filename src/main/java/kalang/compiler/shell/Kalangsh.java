package kalang.compiler.shell;

import kalang.compiler.compile.codegen.CodeGenerationException;
import kalang.compiler.tool.CompileException;
import kalang.compiler.compile.Configuration;
import kalang.compiler.tool.KalangShell;
import kalang.compiler.util.AstOutputUtil;
import kalang.compiler.util.ClassExecutor;
import kalang.lang.Script;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

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
        int result = new Kalangsh().run(args);
        if (result != 0) {
            System.exit(result);
        }
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
                KalangOption kalangOption = loadKalangOption(cli, new StringReader(code), null);
                KalangShell sh = this.createKalangShell(config, classLoader, kalangOption);
                scriptArgs = new String[0];
                clazz = sh.parse("Temp",code, "Tmp.kl");
            } else {
                if (args.length == 0) {
                    printUsage();
                    return Constant.ERR_INVALID_ARGUMENTS;
                }
                File file = new File(args[0]);
                scriptArgs = new String[args.length - 1];
                if (args.length > 1) {
                    System.arraycopy(args, 1, scriptArgs, 0, scriptArgs.length);
                }
                File sourceDir = file.getAbsoluteFile().getParentFile();
                KalangOption shellOption;
                try (Reader fileReader = new InputStreamReader(new FileInputStream(file), config.getEncoding())) {
                    shellOption = loadKalangOption(cli, fileReader, sourceDir);
                }
                KalangShell sh = this.createKalangShell(config, classLoader, shellOption);
                sh.addSourcePath(file.getAbsoluteFile().getParentFile());
                clazz = sh.parse(file);
            }
            if (!cli.hasOption("check")) {
                try {
                    if (Script.class.isAssignableFrom(clazz)) { //script check
                        Script scriptInstance = (Script) clazz.newInstance();
                        return scriptInstance.run(scriptArgs);
                    } else {
                        ClassExecutor.executeMain(clazz, scriptArgs);
                    }
                } catch (InvocationTargetException ex) {
                    throw ex.getCause();
                }
            }
            return Constant.SUCCESS;
        } catch (CompileException ex) {
            System.err.println(ex.getMessage());
            return Constant.ERR_COMPILE_ERROR;
        } catch (CodeGenerationException ex) {
            System.err.println(ex.getMessage());
            System.err.println(AstOutputUtil.toString(ex.getClassNode()));
            return Constant.ERR_UNKNOWN_EXCEPTION;
        } catch (Throwable ex) {
            ex.printStackTrace(System.err);
            return Constant.ERR_UNKNOWN_EXCEPTION;
        }
    }

    private static Options createOptions() {
        Options options = new Options();
        options.addOption("c", "code", true, "run code from code option");
        options.addOption(null, "check", false, "don't run,just check");
        options.addOption(null, "disable-dependency-cache", false, "disable dependency cache");
        return options;
    }

}

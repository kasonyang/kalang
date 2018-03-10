package kalang.shell;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import kalang.compiler.Configuration;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang
 */
public class ShellBase {

    protected static void printUsage(String syntax, Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(syntax, options);
    }

    @Nullable
    protected CommandLine parseArgs(Options options, String[] args) {
        options.addOption("h", "help", false, "show this help message");
        options.addOption("v", "verbose", false, "show verbose information");
        options.addOption(null, "script-base", true, "specify default script base class");
        options.addOption("l", "lib-path", true, "library path");
        options.addOption("cp", true, "compile classpath");
        options.addOption("s", true, "source directory");

        DefaultParser parser = new DefaultParser();
        try {
            return parser.parse(options, args, true);
        } catch (ParseException ex) {
            return null;
        }
    }

    protected Configuration createConfiguration(CommandLine cli) {
        String baseScriptClass = cli.getOptionValue("script-base", "");
        Configuration config = new Configuration();
        if (!baseScriptClass.isEmpty()) {
            config.setScriptBaseClass(baseScriptClass);
        }
        return config;
    }

    protected ClassLoader createClassLoader(CommandLine cli) {
        boolean verbose = cli.hasOption("verbose");
        List<URL> urls = new LinkedList();
        String[] libPaths = cli.getOptionValue("lib-path", "").split(";");
        for (String l : libPaths) {
            if (l.isEmpty()) {
                continue;
            }
            File ld = new File(l);
            if (!ld.isDirectory()) {
                continue;
            }
            Collection<File> jars = FileUtils.listFiles(ld, new String[]{"jar"}, false);
            for (File j : jars) {
                try {
                    urls.add(j.toURI().toURL());
                } catch (MalformedURLException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }
        File[] cps = parseClassPath(cli);
        for (int i = 0; i < cps.length; i++) {
            try {
                urls.add(cps[i].toURI().toURL());
            } catch (MalformedURLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        if (verbose) {
            for (URL u : urls) {
                System.out.println("Add class path:" + u);
            }
        }
        return new URLClassLoader(urls.toArray(new URL[urls.size()]));
    }

    protected File[] parseClassPath(CommandLine cli) {
        if (cli.hasOption("cp")) {
            String[] cps = cli.getOptionValue("cp").split(";");
            File[] file = new File[cps.length];
            for (int i = 0; i < cps.length; i++) {
                file[i] = new File(cps[i]);
            }
            return file;
        }
        return new File[0];
    }

}

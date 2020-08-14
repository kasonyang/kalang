package kalang.compiler.shell;

import kalang.compiler.compile.Configuration;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.profile.SpanFormatter;
import kalang.compiler.tool.KalangShell;
import kalang.compiler.util.ClassPathUtil;
import kalang.compiler.util.StringUtil;
import kalang.lang.KalangRuntime;
import org.apache.commons.cli.*;

import javax.annotation.Nullable;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Kason Yang
 */
public abstract class ShellBase {

    private final static Logger LOG = Logger.getLogger(ShellBase.class.getName());

    protected final String appName,syntax;
    
    protected final Options options;

    public ShellBase(String appName,String syntax, Options options) {
        this.appName = appName;
        this.options = options;
        this.syntax = syntax;
        options.addOption("h", "help", false, "show this help message");
        options.addOption(null, "script-base", true, "specify default script base class");
        options.addOption("l", "libpath", true, "library path");
        options.addOption(null,"classpath", true, "compile classpath");
        options.addOption("s","sourcepath", true, "source directory");
        options.addOption("v","version",false,"show version information");
        options.addOption(null,"profile-out",true,"specify destination for profiler's output");
        options.addOption(null, "debug", false, "log in debug level");
        options.addOption(null, "info", false, "log in info level");
    }
    
    public int run(String[] args) {
        DefaultParser parser = new DefaultParser();
        CommandLine cli;
        try {
            cli = parser.parse(options, args, true);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            printUsage();
            return Constant.ERR_INVALID_ARGUMENTS;
        }
        if (cli == null || cli.hasOption("help")) {
            printUsage();
            return Constant.SUCCESS;
        } else if (cli.hasOption("version")) {
            printVersion();
            return Constant.SUCCESS;
        } else {
            String profileOut = cli.getOptionValue("profile-out","");
            if (!profileOut.isEmpty()) {
                Profiler.getInstance().startProfile();
            }
            if (cli.hasOption("info")) {
                setLogLevel(Level.INFO);
            }
            if (cli.hasOption("debug")) {
                setLogLevel(Level.ALL);
            }
            int result = execute(cli);
            if (!profileOut.isEmpty()) {
                Profiler.getInstance().stopProfile();
                outputProfileInfo(profileOut);
            }
            return result;
        }
    }
    
    protected abstract int execute(CommandLine cli);
    
    protected void printUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(syntax, options);
    }
    
    protected void printVersion() {
        KalangRuntime.BuildInfo bi = KalangRuntime.getBuildInfo();
        System.out.println(String.format("%s v%s\nBuild time: %s", appName, KalangRuntime.getVersion(), new Date(bi.getBuildTime())));
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
        Set<URL> urls = new HashSet<>();
        URL runtimeClassPath = KalangRuntime.getRuntimeClassPath();
        LOG.fine("Runtime class path:" + runtimeClassPath);
        urls.add(runtimeClassPath);
        String[] libPaths = cli.getOptionValue("libpath", "").split(File.pathSeparator);
        for (String l : libPaths) {
            if (l.isEmpty()) {
                continue;
            }
            File ld = new File(l);
            ClassPathUtil.addClasspathFromLibPath(urls,ld);
        }
        File[] cps = parseClassPath(cli);
        for (File cp : cps) {
            try {
                urls.add(cp.toURI().toURL());
            } catch (MalformedURLException ex) {
                LOG.warning("Invalid class path:" + cp);
            }
        }
        return new URLClassLoader(urls.toArray(new URL[0]), this.getClass().getClassLoader().getParent());
    }

    protected File[] parseClassPath(CommandLine cli) {
        if (cli.hasOption("classpath")) {
            String[] cps = cli.getOptionValue("classpath").split(File.pathSeparator);
            File[] file = new File[cps.length];
            for (int i = 0; i < cps.length; i++) {
                file[i] = new File(cps[i]);
            }
            return file;
        }
        return new File[0];
    }

    protected KalangOption loadKalangOption(CommandLine cli, Reader shellFileReader, @Nullable File projectPath) throws IOException {
        FileReader optionReader = null;
        if (projectPath != null) {
            File optionFile = new File(projectPath, KalangOption.DEFAULT_OPTION_FILE);
            if (optionFile.exists()) {
                optionReader = new FileReader(optionFile);
            }
        }
        boolean enableDepCache = ! cli.hasOption("disable-dependency-cache");
        KalangOption option = new KalangOption();
        option.parse(shellFileReader, optionReader, enableDepCache);
        String baseScriptClass = cli.getOptionValue("script-base", "");
        if (!baseScriptClass.isEmpty()) {
            option.setScriptBase(baseScriptClass);
        }
        return option;
    }

    protected KalangShell createKalangShell(Configuration config, ClassLoader classLoader, KalangOption compileOptions) throws IOException {
        applyOptionToConf(config, compileOptions);
        URL[] classpaths = compileOptions.getClassPaths();
        File[] sourcepaths = compileOptions.getSourcePaths();
        for (URL cp: classpaths) {
            LOG.fine("Add class path for script:" + cp);
        }
        for (File sp: sourcepaths) {
            LOG.fine("Add source path for script:" + sp);
        }
        if (classpaths.length > 0) {
            classLoader = new URLClassLoader(classpaths,classLoader);
        }
        KalangShell shell = new KalangShell(config, classLoader);
        for(File sp : sourcepaths) {
            shell.addSourcePath(sp);
        }
        return shell;
    }

    private void outputProfileInfo(String destination) {
        Span rootSpan = Profiler.getInstance().getRootSpan();
        PrintStream os;
        if (destination.equals("@stderr")) {
            os = new PrintStream(System.err);
        } else if (destination.equals("@stdout")) {
            os = new PrintStream(System.out);
        } else {
            try {
                os = new PrintStream(new File(destination));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        new SpanFormatter().format(rootSpan,os);
    }

    private void applyOptionToConf(Configuration configuration, KalangOption option) {
        if (StringUtil.isNotEmpty(option.getScriptBase())) {
            configuration.setScriptBaseClass(option.getScriptBase());
        }
    }

    private void setLogLevel(Level logLevel) {
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        int oldLevel = rootLogger.getLevel().intValue();
        int newLevel = logLevel.intValue();
        rootLogger.setLevel(logLevel);
        for (Handler h : rootLogger.getHandlers()) {
            h.setFilter(record -> {
                int lv = record.getLevel().intValue();
                if (lv > oldLevel) {
                    return true;
                }
                String ln = record.getLoggerName();
                return  ln != null && ln.startsWith("kalang.compiler") && lv > newLevel;
            });
            h.setLevel(logLevel);
        }
    }

}

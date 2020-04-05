package kalang.compiler.shell;

import kalang.compiler.compile.Configuration;
import kalang.compiler.dependency.Artifact;
import kalang.compiler.dependency.DependenciesCache;
import kalang.compiler.dependency.DependencyResolver;
import kalang.compiler.dependency.ResolveResult;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.profile.SpanFormatter;
import kalang.compiler.tool.KalangShell;
import kalang.lang.Runtime;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.*;

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
        Runtime.BuildInfo bi = Runtime.getBuildInfo();
        System.out.println(String.format("%s v%s\nBuild time: %s", appName, Runtime.getVersion(), new Date(bi.getBuildTime())));
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
        URL runtimeClassPath = Runtime.getRuntimeClassPath();
        LOG.fine("Runtime class path:" + runtimeClassPath);
        urls.add(runtimeClassPath);
        String[] libPaths = cli.getOptionValue("libpath", "").split(File.pathSeparator);
        for (String l : libPaths) {
            if (l.isEmpty()) {
                continue;
            }
            File ld = new File(l);
            addClasspathFromLibPath(urls,ld);
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

    protected KalangShell createKalangShell(Configuration config, ClassLoader classLoader, Reader reader,@Nullable Reader optionsReader) throws IOException {
        //String scriptBase = "";
        Set<String> dependencies = new HashSet<>();
        Set<String> repositories = new HashSet<>();
        Set<URL> classpaths = new HashSet<>();
        Set<File> sourcepaths = new HashSet<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        Consumer<String> optionHandler = line -> {
            if (line.isEmpty()) {
                return;
            }
            if (line.startsWith("!")) {
                return;
            }
            String[] parts = line.split(" ",2);
            String optionName = parts[0];
            String optionValue = parts.length>1 ? parts[1] : "";
            if (optionValue.isEmpty()) {
                return;
            }
            switch (optionName) {
//                case "script":
//                case "base":
//                    scriptBase = optionValue;
//                    break;
                case "dependency":
                    dependencies.add(optionValue);
                    break;
                case "repository":
                    repositories.add(optionValue);
                    break;
                case "classpath":
                    try {
                        classpaths.add(new File(optionValue).toURI().toURL());
                    } catch (MalformedURLException e) {
                        LOG.warning("Invalid class path in script option:" + optionValue);
                    }
                    break;
                case "libpath":
                    addClasspathFromLibPath(classpaths,new File(optionValue));
                    break;
                case "sourcepath":
                    sourcepaths.add(new File(optionValue));
                    break;
                default:
                    LOG.warning("warn:unknown option:" + optionName);
                    break;
            }
        };
        String line;
        if (optionsReader != null) {
            BufferedReader bfdOptionsReader = new BufferedReader(optionsReader);
            while ((line = bfdOptionsReader.readLine()) != null) {
                optionHandler.accept(line.trim());
            }
        }
        while((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            if (!line.startsWith("#")) {
                break;
            }
            optionHandler.accept(line.substring(1));
        }
//        if (!scriptBase.isEmpty()) {
//            config.setScriptBaseClass(scriptBase);
//        }
        if (!dependencies.isEmpty()) {
            Span rdSpan = Profiler.getInstance().beginSpan("resolving dependencies");
            ResolveResult resolveResult = resolveDependencies(dependencies,repositories);
            Profiler.getInstance().endSpan(rdSpan);
            for(File localFile:resolveResult.getLocalFiles()) {
                classpaths.add(localFile.toURI().toURL());
            }
        }
        for (URL cp: classpaths) {
            LOG.fine("Add class path for script:" + cp);
        }
        for (File sp: sourcepaths) {
            LOG.fine("Add source path for script:" + sp);
        }
        if (!classpaths.isEmpty()) {
            classLoader = new URLClassLoader(classpaths.toArray(new URL[0]),classLoader);
        }
        KalangShell shell = new KalangShell(config, classLoader);
        for(File sp : sourcepaths) {
            shell.addSourcePath(sp);
        }
        return shell;
    }

    public File getAppHomeDir(@Nullable  String subDir, boolean autoCreate) throws IOException {
        File file = new File(FileUtils.getUserDirectory(),".kalang");
        if (subDir != null && !subDir.isEmpty()) {
            file = new File(file, subDir);
        }
        if (!file.exists() && autoCreate && !file.mkdirs()) {
            throw new IOException("failed to create directory:" + file);
        }
        return file;
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



    private ResolveResult resolveDependencies(Set<String> dependencies,Set<String> repositories) throws IOException {
        File cacheFile = new File(getAppHomeDir("cache", true), "dependencies.cache");
        DependenciesCache dc = new DependenciesCache(cacheFile);
        return dc.get(dependencies,() -> {
            List<Artifact> artifacts = new LinkedList<>();
            for(String d:dependencies){
                d = d.trim();
                String[] dParts = d.split(":");
                if (dParts.length!=3) {
                    LOG.warning("illegal artifact:" + d);
                    continue;
                }
                artifacts.add(new Artifact(dParts[0],dParts[1],dParts[2]));
            }
            DependencyResolver resolver =new DependencyResolver(repositories);
            return resolver.resolve(artifacts.toArray(new Artifact[0]));
        });
    }

    private void addClasspathFromLibPath(Set<URL> list,File libpath) {
        if (!libpath.exists() || !libpath.isDirectory()) {
            return;
        }
        Collection<File> jars = FileUtils.listFiles(libpath, new String[]{"jar"}, false);
        for (File j : jars) {
            try {
                list.add(j.toURI().toURL());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
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

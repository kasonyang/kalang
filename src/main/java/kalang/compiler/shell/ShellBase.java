package kalang.compiler.shell;

import kalang.compiler.compile.Configuration;
import kalang.compiler.dependency.Artifact;
import kalang.compiler.dependency.DependencyResolver;
import kalang.compiler.dependency.ResolveResult;
import kalang.compiler.tool.KalangShell;
import kalang.lang.Runtime;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public abstract class ShellBase {

    protected final String appName,syntax;
    
    protected final Options options;

    public ShellBase(String appName,String syntax, Options options) {
        this.appName = appName;
        this.options = options;
        this.syntax = syntax;
        options.addOption("h", "help", false, "show this help message");
        options.addOption(null, "verbose", false, "show verbose information");
        options.addOption(null, "script-base", true, "specify default script base class");
        options.addOption("l", "libpath", true, "library path");
        options.addOption(null,"classpath", true, "compile classpath");
        options.addOption("s","sourcepath", true, "source directory");
        options.addOption("v","version",false,"show version information");
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
            return execute(cli);
        }
    }
    
    protected abstract int execute(CommandLine cli);
    
    protected void printUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(syntax, options);
    }
    
    protected void printVersion() {
        System.out.println(String.format("%s v%s", appName, Runtime.getVersion()));
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
        String[] libPaths = cli.getOptionValue("libpath", "").split(";");
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
                ex.printStackTrace(System.err);
            }
        }
        if (verbose) {
            for (URL u : urls) {
                System.out.println("Add class path:" + u);
            }
        }
        return new URLClassLoader(urls.toArray(new URL[0]));
    }

    protected File[] parseClassPath(CommandLine cli) {
        if (cli.hasOption("classpath")) {
            String[] cps = cli.getOptionValue("classpath").split(";");
            File[] file = new File[cps.length];
            for (int i = 0; i < cps.length; i++) {
                file[i] = new File(cps[i]);
            }
            return file;
        }
        return new File[0];
    }

    protected KalangShell createKalangShell(Configuration config, ClassLoader classLoader, Reader reader) throws IOException {
        String scriptBase = "";
        List<String> dependencies = new LinkedList<>();
        List<String> repositories = new LinkedList<>();
        List<URL> classpaths = new LinkedList<>();
        List<File> sourcepaths = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while((line=bufferedReader.readLine())!=null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (!line.startsWith("#")) {
                break;
            }
            String[] parts = line.split(" ",2);
            String optionName = parts[0].substring(1);
            String optionValue = parts.length>1 ? parts[1] : "";
            if (optionValue.isEmpty()) {
                continue;
            }
            switch (optionName) {
                case "script":
                case "base":
                    scriptBase = optionValue;
                    break;
                case "dependency":
                    dependencies.add(optionValue);
                    break;
                case "repository":
                    repositories.add(optionValue);
                    break;
                case "classpath":
                    classpaths.add(new File(optionValue).toURI().toURL());
                    break;
                case "libpath":
                    addClasspathFromLibPath(classpaths,new File(optionValue));
                    break;
                case "sourcepath":
                    sourcepaths.add(new File(optionValue));
                    break;
                default:
                    break;
            }
        }
        if (!scriptBase.isEmpty()) {
            config.setScriptBaseClass(scriptBase);
        }
        if (!dependencies.isEmpty()) {
            ResolveResult resolveResult = resolveDependencies(dependencies,repositories);
            for(File localFile:resolveResult.getLocalFiles()) {
                classpaths.add(localFile.toURI().toURL());
            }
            classLoader = new URLClassLoader(classpaths.toArray(new URL[0]),classLoader);
        }
        KalangShell shell = new KalangShell(config, classLoader);
        for(File sp : sourcepaths) {
            shell.addSourcePath(sp);
        }
        return shell;
    }

    private ResolveResult resolveDependencies(List<String> dependencies,List<String> repositories) {
        List<Artifact> artifacts = new LinkedList<>();
        for(String d:dependencies){
            d = d.trim();
            String[] dParts = d.split(":");
            if (dParts.length!=3) {
                System.err.println("illeage artifact:" + d);
                continue;
            }
            artifacts.add(new Artifact(dParts[0],dParts[1],dParts[2]));
        }
        DependencyResolver resolver =new DependencyResolver(repositories);
        return resolver.resolve(artifacts.toArray(new Artifact[0]));
    }

    private void addClasspathFromLibPath(List<URL> list,File libpath) {
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

}

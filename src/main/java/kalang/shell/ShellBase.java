package kalang.shell;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

import kalang.compiler.Configuration;
import kalang.dependency.Artifact;
import kalang.dependency.DependencyResolver;
import kalang.dependency.ResolveResult;
import kalang.tool.KalangShell;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;

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
        Properties prop = new Properties();
        InputStream is = this.getClass().getResourceAsStream("/default.properties");
        if (is != null) {
            try {
                prop.load(is);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        String version = prop.getProperty("version", "UNKNOWN");
        System.out.println(String.format("%s %s", appName, version));
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
            switch (optionName) {
                case "script":
                    scriptBase = optionValue;
                    break;
                case "dependency":
                    if (!optionValue.isEmpty()){
                        dependencies.add(optionValue);
                    }
                    break;
                case "repository":
                    if (!optionValue.isEmpty()) {
                        repositories.add(optionValue);
                    }
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
            File[] localFiles = resolveResult.getLocalFiles();
            URL[] localFileURLs = new URL[localFiles.length];
            for(int i=0;i<localFiles.length;i++) {
                localFileURLs[i] = localFiles[i].toURI().toURL();
            }
            classLoader = new URLClassLoader(localFileURLs,classLoader);
        }
        return new KalangShell(config, classLoader);
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

}

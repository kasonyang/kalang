package kalang.compiler.shell;

import kalang.compiler.dependency.Artifact;
import kalang.compiler.dependency.DependenciesCache;
import kalang.compiler.dependency.DependencyResolver;
import kalang.compiler.dependency.ResolveResult;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.util.ClassPathUtil;
import kalang.mixin.CollectionMixin;
import kalang.type.Function0;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * @author KasonYang
 */
public class ShellOptionParser {

    private final static Logger LOG = Logger.getLogger(ShellOptionParser.class.getName());

    private LinkedHashSet<URL> classPaths;

    private LinkedHashSet<File> sourcePaths;

    public void parse(Reader codeReader, @Nullable Reader optionsReader, boolean enableDepCache) throws IOException {
        LinkedHashSet<String> dependencies = new LinkedHashSet<>();
        LinkedHashSet<String> repositories = new LinkedHashSet<>();
        LinkedHashSet<URL> classpaths = new LinkedHashSet<>();
        LinkedHashSet<File> sourcepaths = new LinkedHashSet<>();
        BufferedReader bufferedReader = new BufferedReader(codeReader);
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
                    ClassPathUtil.addClasspathFromLibPath(classpaths,new File(optionValue));
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
        if (!dependencies.isEmpty()) {
            Span rdSpan = Profiler.getInstance().beginSpan("resolving dependencies");
            ResolveResult resolveResult = resolveDependencies(dependencies,new LinkedList<>(repositories), enableDepCache);
            Profiler.getInstance().endSpan(rdSpan);
            for(File localFile:resolveResult.getLocalFiles()) {
                classpaths.add(localFile.toURI().toURL());
            }
        }
        this.classPaths = classpaths;
        this.sourcePaths = sourcepaths;
    }

    private ResolveResult resolveDependencies(Set<String> dependencies, List<String> repositories, boolean enableCache) throws IOException {
        Function0<ResolveResult> depResolver = () -> {
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
        };
        boolean containsSnapshots = CollectionMixin.find(dependencies, it -> it.toUpperCase().endsWith("-SNAPSHOT")) != null;
        if (enableCache && !containsSnapshots) {
            File cacheFile = new File(getAppHomeDir("cache", true), "dependencies.cache");
            DependenciesCache dc = new DependenciesCache(cacheFile);
            return dc.get(dependencies, depResolver);
        }
        return depResolver.call();
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

    public URL[] getClassPaths() {
        return classPaths.toArray(new URL[0]);
    }

    public File[] getSourcePaths() {
        return sourcePaths.toArray(new File[0]);
    }

}

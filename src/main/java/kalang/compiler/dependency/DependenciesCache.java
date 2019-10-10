package kalang.compiler.dependency;

import kalang.mixin.CollectionMixin;
import kalang.mixin.DigestMixin;
import kalang.mixin.IOMixin;
import kalang.mixin.StringMixin;
import kalang.type.Function0;
import lombok.SneakyThrows;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 * @author KasonYang
 */
public class DependenciesCache {

    private final static String ENCODING = "utf8";

    private final static int BLOCK_SIZE = 25;

    private final static int MAX_SIZE = 100;

    private File cacheFile;

    public DependenciesCache(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @SneakyThrows
    public ResolveResult get(Set<String> dependencies, Function0<ResolveResult> resultProvider) {
        String cacheContent = cacheFile.exists() ? IOMixin.readToString(this.cacheFile, ENCODING) : "";
        String[] cacheLines = StringMixin.lines(cacheContent);
        String cachePrefix = getCacheKey(dependencies) + "=";
        ResolveResult result = null;
        int cacheLineIndex = CollectionMixin.findIndex(cacheLines, it -> it.startsWith(cachePrefix));
        if (cacheLineIndex >= 0) {
            result = deserializeResult(cacheLines[cacheLineIndex].substring(cachePrefix.length()));
            if (!this.isValidResolveResult(result)) {
                result = null;
                cacheLineIndex = -1;
                cacheLines[cacheLineIndex] = "";
            } else if (cacheLineIndex > BLOCK_SIZE) {
                cacheLineIndex = -1;
                cacheLines[cacheLineIndex] = "";
            }
        }
        if (result == null) {
            result = resultProvider.call();
        }
        if (cacheLineIndex < 0) {
            //save cache
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(cacheFile))) {
                bos.write(cachePrefix.getBytes(ENCODING));
                bos.write(serializeResult(result).getBytes(ENCODING));
                bos.write('\n');
                int cachedCount = 1;
                for (int i = 0; i < cacheLines.length && cachedCount < MAX_SIZE; i++) {
                    if (cacheLines[i].isEmpty()) {
                        continue;
                    }
                    bos.write(cacheLines[i].getBytes(ENCODING));
                    bos.write('\n');
                    cachedCount++;
                }
            }
        }
        return result;
    }

    private boolean isValidResolveResult(ResolveResult resolveResult) {
        for (File f : resolveResult.getLocalFiles()) {
            if (!f.exists()) {
                return false;
            }
        }
        return true;
    }

    @SneakyThrows
    private ResolveResult deserializeResult(String content) {
        Base64.Decoder decoder = Base64.getDecoder();
        String[] files = new String(decoder.decode(content), ENCODING).split("\n");
        ResolveResult result = new ResolveResult();
        for (String f : files) {
            if (f.isEmpty()) {
                continue;
            }
            result.addLocalFile(new File(f));
        }
        return result;
    }

    @SneakyThrows
    private String serializeResult(ResolveResult result) {
        StringBuilder sb = new StringBuilder();
        for (File f : result.getLocalFiles()) {
            sb.append(f.getCanonicalPath()).append("\n");
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(sb.toString().getBytes(ENCODING));
    }

    @SneakyThrows
    private String getCacheKey(Set<String> dependencies) {
        List<String> depList = new ArrayList<>(dependencies);
        depList.sort(String::compareTo);
        String dependencyKey = String.join("\n", depList);
        return DigestMixin.sha256Hex(dependencyKey);
    }

}

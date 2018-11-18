package kalang.compiler.dependency;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ResolveResult {

    private final List<File> localFiles = new LinkedList<>();

    public void addLocalFile(File file){
        localFiles.add(file);
    }

    public File[] getLocalFiles(){
        return localFiles.toArray(new File[0]);
    }

}

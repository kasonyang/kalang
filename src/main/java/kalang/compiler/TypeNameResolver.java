package kalang.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.util.AstUtil;
import kalang.util.NameUtil;

/**
 *
 * @author Kason Yang
 */
public class TypeNameResolver {

    private Map<String, String> simpleToFullNames = new HashMap();

    private List<String> importPackages = new LinkedList();

    private AstLoader astLoader;

    public TypeNameResolver() {
    }

    public void importClass(String className){
        this.importClass(className,NameUtil.getSimpleClassName(className));
    }
    
    public void importClass(String className,String alias) {
        this.simpleToFullNames.put(alias , className);
    }

    public void importPackage(String packageName) {
        this.importPackages.add(packageName);
    }

    private String fixInnerClassName(String className) {
        String name = "";
        for (String n : className.split("\\.")) {
            name += n;
            if (astLoader !=null && astLoader.getAst(name) != null) {
                name += "$";
            } else {
                name += ".";
            }
        }
        return name.substring(0, name.length() - 1);
    }

    /**
     * 
     * @param id
     * @param topClass
     * @param declaringClass
     * @return full name of type,null if failed.
     */
    @Nullable
    public String resolve(String id,ClassNode topClass, ClassNode declaringClass) {
        if(id.contains(".")) return id;
        if (simpleToFullNames.containsKey(id)) {
            return this.fixInnerClassName(simpleToFullNames.get(id));
        } else {
            String[] innerClassesNames = AstUtil.listInnerClassesNames(topClass, true);
            List<String> candidates = new ArrayList(innerClassesNames.length + 1);
            candidates.add(topClass.name);
            candidates.addAll(Arrays.asList(innerClassesNames));
            for (String c : candidates) {
                if (id.equals(NameUtil.getClassNameWithoutPackage(c))) {
                    return c;
                }
                if ((declaringClass.name + "$" + id).equals(c)) {
                    return c;
                }
            }
            List<String> paths = new ArrayList<>(importPackages.size() + 1);
            paths.add(NameUtil.getPackageName(topClass.name));
            paths.addAll(importPackages);
            for (String p : paths) {
                String clsName;
                if (p != null && p.length() > 0) {
                    clsName = p + "." + id;
                } else {
                    clsName = id;
                }
                if (astLoader!=null &&  astLoader.getAst(this.fixInnerClassName(clsName)) != null) {
                    return clsName;
                }
            }
        }
        return null;
    }

    public void setAstLoader(AstLoader astLoader) {
        this.astLoader = astLoader;
    }
    
}

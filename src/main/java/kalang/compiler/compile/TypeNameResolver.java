package kalang.compiler.compile;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.NameUtil;

import javax.annotation.Nullable;
import java.util.*;

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
        } else if (id.contains("$")){
            String[] idParts = id.split("\\$",2);
            String outerClassName = simpleToFullNames.get(idParts[0]);
            if (outerClassName==null){
                return null;
            }
            return outerClassName + "$" + idParts[1];
        }else {
            String[] innerClassesNames = AstUtil.listInnerClassesNames(topClass, true);
            String path = declaringClass.name;
            while(!path.isEmpty()) {
                String name = path + "$" + id;
                for(String c:innerClassesNames) {
                    if (name.equals(c)) {
                        return c;
                    }
                }
                int last$ = path.lastIndexOf('$');
                path = last$ > 0 ? path.substring(0,last$) : "";
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

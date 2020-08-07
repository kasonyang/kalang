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

    private ClassNodeLoader classNodeLoader;

    private Map<String,Optional<String>> resolvedIdMap = new HashMap<>();

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

    /**
     * 
     * @param id
     * @param topClass
     * @param declaringClass
     * @return full name of type,null if failed.
     */
    @Nullable
    public String resolve(String id,ClassNode topClass, ClassNode declaringClass) {
        String key = String.format("%s|%s|%s",id, topClass.getName(), declaringClass.getName());
        Optional<String> val = resolvedIdMap.get(key);
        if (val==null) {
            String className = doResolve(id, topClass, declaringClass);
            val = className == null ? Optional.empty() : Optional.of(className);
            resolvedIdMap.put(key,val);
        }
        return val.orElse(null);
    }

    public void setClassNodeLoader(ClassNodeLoader classNodeLoader) {
        this.classNodeLoader = classNodeLoader;
    }

    @Nullable
    public String doResolve(String id,ClassNode topClass,ClassNode declaringClass) {
        if(id.contains(".")) return id;
        if (simpleToFullNames.containsKey(id)) {
            return simpleToFullNames.get(id);
        } else if (id.contains("$")){
            String[] idParts = id.split("\\$");
            String outerClassName = this.resolve(idParts[0],topClass,declaringClass);
            if (outerClassName==null){
                return null;
            }
            return outerClassName + "$" + idParts[1];
        }else {
            String[] innerClassesNames = AstUtil.listInnerClassesNames(topClass, true);
            String path = declaringClass.getName();
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
            paths.addAll(importPackages);
            paths.add(NameUtil.getPackageName(topClass.getName()));
            int pathSize = paths.size();
            for (int i=pathSize-1;i>=0;i--) {
                String p = paths.get(i);
                String clsName;
                if (p != null && p.length() > 0) {
                    clsName = p + "." + id;
                } else {
                    clsName = id;
                }
                if (classNodeLoader !=null &&  classNodeLoader.getClassNode(clsName) != null) {
                    return clsName;
                }
            }
        }
        return null;
    }
    
}

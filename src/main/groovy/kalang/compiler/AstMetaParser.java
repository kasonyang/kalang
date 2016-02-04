package kalang.compiler;

import java.util.LinkedList;
import java.util.List;

import jast.ast.*;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AstMetaParser {

    private AstLoader astLoader;

    private TypeSystem typeSystem;

    public AstMetaParser(AstLoader astLoader, TypeSystem typeSystem) {
        this.astLoader = astLoader;
        this.typeSystem = typeSystem;
    }

    public AstMetaParser(AstLoader astLoader) {
        this(astLoader, new TypeSystem(astLoader));
    }

   public static String getMethodDescriptor(String name, List<String> types, String className) {
        String typeStr = String.join(",", types);
        String str = String.format("%s(%s)", name, typeStr);
        if (className != null) {
            str = String.format("%s#%s", className, str);
        }
        return str;
    }

    public static String getMethodDescriptor(MethodNode node, String className) {
        return getMethodDescriptor(node.name, getParameterTypes(node), className);
    }

    public VarObject getField(ClassNode ast, String name) {
        for (VarObject f : ast.fields) {
            if (f.name.equals(name)) {
                return f;
            }
        }
        return null;
    }

    /*MethodNode getMethod(ClassNode ast,String name,String[] types){
		def methods = ast.methods
		for(def m in methods){
			if(m.name!=name) continue
			def ps = m.parameters
			def mtypes = []
			for(def p in ps){
				mtypes.add(p.type)
			}
			if(castSystem.castable(types,mtypes)){
				return m
			}
		}
		return null
	}*/
    public static List<String> getParameterTypes(MethodNode mn) {
        List<String> types = new LinkedList();
        if (mn.parameters == null) {
            return types;
        }
        for (VarObject p : mn.parameters) {
            types.add(p.type);
        }
        return types;
    }

    public List<MethodNode> getUnimplementedMethod(ClassNode theClass, ClassNode theInterface) {
        List<MethodNode> list = new LinkedList();
        for (MethodNode m : theInterface.methods) {
            String name = m.name;
            String[] types = getParameterTypes(m).toArray(new String[0]);
            MethodNode[] methods = this.getMethodsByName(theClass, name);
            MethodNode[] matches = this.matchMethodsByType(methods, types);
            if (matches == null || matches.length == 0) {
                list.add(m);
            }
        }
        return list;
    }
    
    public void createEmptyConstructor(ClassNode clazzNode){
        MethodNode initMethod = MethodNode.create();
        initMethod.modifier = Modifier.PUBLIC | Modifier.STATIC;
        initMethod.name = "<init>";
        initMethod.type = clazzNode.name;
        initMethod.body = BlockStmt.create();
        clazzNode.methods.add(initMethod);
    }

    public MethodNode[] getMethodsByName(ClassNode cls, String methodName) {
        List<MethodNode> methods = new LinkedList();
        for (MethodNode m : cls.methods) {
            if (m.name.equals(methodName)) {
                methods.add(m);
            }
        }
        return methods.toArray(new MethodNode[0]);
    }

    public boolean matchType(String from, String target, boolean matchSubclass, boolean autoCast) {
        if (from.equals(target)) {
            return true;
        }
        try {
            if (matchSubclass && typeSystem.isSubclass(from, target)) {
                return true;
            }
            if (autoCast && this.typeSystem.castable(from, target)) {
                return true;
            }
        } catch (AstNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean matchTypes(String[] from, String[] target, boolean matchSubclass, boolean autoCast) {
        if (from.length != target.length) {
            return false;
        }
        for (int i = 0; i < from.length; i++) {
            String f = from[i];
            String t = target[i];
            if (!matchType(f, t, matchSubclass, autoCast)) {
                return false;
            }
        }
        return true;
    }

    public MethodNode[] matchMethodsByType(MethodNode[] methods, String[] types) {
        return matchMethodsByType(methods, types, false, false);
    }

    public MethodNode[] matchMethodsByType(MethodNode[] methods, String[] types, boolean matchSubclass) {
        return matchMethodsByType(methods, types, matchSubclass, false);
    }

    public MethodNode[] matchMethodsByType(MethodNode[] methods, String[] types, boolean matchSubclass, boolean autoCast) {
        List<MethodNode> list = new LinkedList();
        for (MethodNode m : methods) {
            String[] mTypes = getParameterTypes(m).toArray(new String[0]);
            if (matchTypes(types, mTypes, matchSubclass, autoCast)) {
                list.add(m);
            }
        }
        return list.toArray(new MethodNode[0]);
    }

    public AstLoader getAstLoader() {
        return astLoader;
    }

    public TypeSystem getTypeSystem() {
        return typeSystem;
    }
    
    
    public MethodNode[] selectMethod(ClassNode cls, String methodName, String[] types) {
        MethodNode[] methods = getMethodsByName(cls, methodName);
        MethodNode[] matches;
        matches = matchMethodsByType(methods, types, false, false);
        if (matches == null || matches.length == 0) {
            matches = matchMethodsByType(methods, types, true, false);
        }
        if (matches == null || matches.length == 0) {
            matches = matchMethodsByType(methods, types, true, true);
        }
        return matches;
    }
    
}

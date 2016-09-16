package kalang.ast;
import java.lang.reflect.Modifier;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class MethodNode extends AstNode implements Annotationable{
    
    public int modifier;
    
    public Type type;
    
    public String name;
    
    private final List<ParameterNode> parameters = new LinkedList();
    
    public final List<AnnotationNode> annotations = new LinkedList<>();
    
    @Nullable
    public BlockStmt body = null;
    
    public List<Type> exceptionTypes;
    
    public ClassNode classNode;
    
    
    protected MethodNode(ClassNode classNode){
            this.classNode = classNode;
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
        
    }
    
    
    protected MethodNode(ClassNode classNode,Integer modifier,Type type,String name,List<ParameterNode> parameters,BlockStmt body,List<Type> exceptionTypes){
        this.classNode = classNode;
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
            this.modifier = modifier;
            this.type = type;
            this.name = name;
            this.body = body;
            this.exceptionTypes = exceptionTypes;
    }
    
    
    protected static MethodNode create(ClassNode classNode){
        MethodNode node = new MethodNode(classNode);
        node.exceptionTypes = new LinkedList();
        return node;
    }
    
    public ParameterNode createParameter(Type type,String name){
        return _createParameter(null, type, name);
    }
    
    public ParameterNode createParameter(int index,Type type,String name){
        return _createParameter(index, type, name);
    }
    
    private ParameterNode _createParameter(Integer index,Type type,String name){
        ParameterNode param = new ParameterNode(this, type, name);
        if(index==null){
            parameters.add(param);
        }else{
            this.parameters.add(index,param);
        }
        return param;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,parameters);
        addChild(ls,body);
        return ls;
    }

    @Override
    public AnnotationNode[] getAnnotations() {
        return annotations.toArray(new AnnotationNode[0]);
    }

    @Override
    public String toString() {
        List<String> params = new ArrayList();
        for(ParameterNode p:parameters){
            params.add(String.format("%s %s", p.type,p.name));
        }
        return String.format("%s %s %s(%s)", Modifier.toString(modifier),type.toString(),name,String.join(",", params));
    }
    
    public ParameterNode[] getParameters(){
        return parameters.toArray(new ParameterNode[parameters.size()]);
    }
    
    
}
package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class MethodNode extends AstNode implements Annotationable{
    
    public int modifier;
    
    public Type type;
    
    public String name;
    
    public List<ParameterNode> parameters;
    
    public final List<AnnotationNode> annotations = new LinkedList<>();
    
    @Nullable
    public BlockStmt body = null;
    
    public List<Type> exceptionTypes;
    
    public ClassNode classNode;
    
    
    protected MethodNode(ClassNode classNode){
            this.classNode = classNode;
            if(parameters == null) parameters = new LinkedList();
        
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
        
    }
    
    
    protected MethodNode(ClassNode classNode,Integer modifier,Type type,String name,List<ParameterNode> parameters,BlockStmt body,List<Type> exceptionTypes){
        this.classNode = classNode;
            if(parameters == null) parameters = new LinkedList();
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
            this.modifier = modifier;
            this.type = type;
            this.name = name;
            this.parameters = parameters;
            this.body = body;
            this.exceptionTypes = exceptionTypes;
    }
    
    
    protected static MethodNode create(ClassNode classNode){
        MethodNode node = new MethodNode(classNode);
        node.parameters = new LinkedList();
        node.exceptionTypes = new LinkedList();
        return node;
    }
    
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
    
}
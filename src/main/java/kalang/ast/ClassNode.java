package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
import kalang.util.AstUtil;
/**
 * 
 * @author Kason Yang
 */
public class ClassNode extends AstNode implements Annotationable{
    
    public int modifier;
    
    public String name;
    
    @Nullable
    public ClassType superType;
    
    public final List<FieldNode> fields = new ArrayList<>();
    
    protected final List<MethodNode> methods = new LinkedList();
    
    public final List<ClassType> interfaces = new LinkedList();
    
    public boolean isInterface;
    
    public boolean isArray;
    
    public final List<AnnotationNode> annotations = new LinkedList<>();
    
    public final List<Statement> staticInitStmts = new LinkedList<>();
    
    public final List<Statement> initStmts = new LinkedList<>();
    
    protected List<GenericType> genericTypes = new LinkedList<>();
    
    public ClassNode(){
    
    }
              
    
    public static ClassNode create(){
        ClassNode node = new ClassNode();
        return node;
    }
    
    public void declareGenericType(GenericType type){
        genericTypes.add(type);
    }
    
    public GenericType[] getGenericTypes(){
        return genericTypes.toArray(new GenericType[genericTypes.size()]);
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,fields);
        addChild(ls,methods);
        return ls;
    }


    public FieldNode createField(){
        FieldNode fieldNode = FieldNode.create(this);
        fields.add(fieldNode);
        return fieldNode;
    }
    
    public MethodNode createMethodNode(){
        MethodNode md = MethodNode.create(this);
        methods.add(md);
        return md;
    }
    
    public MethodNode[] getDeclaredMethodNodes(){
        return methods.toArray(new MethodNode[0]);
    }
   
    
    public boolean isSubclassOf(ClassNode clazz){
        if(superType!=null){
            //FIXME wrong impl of isSubclassOf
            ClassNode parent = superType.getClassNode();
            if(parent.equals(clazz)) return true;
            if(parent.isSubclassOf(clazz)) return true;
        }
        if(interfaces!=null){
            for(ClassType i:interfaces){
                ClassNode itf = i.getClassNode();
                if(itf.equals(clazz)) return true;
                if(itf.isSubclassOf(clazz)) return true;
            }
        }
        return false;
    }

    @Override
    public AnnotationNode[] getAnnotations() {
        return annotations.toArray(new AnnotationNode[0]);
    }
    
}
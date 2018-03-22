package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
/**
 * 
 * @author Kason Yang
 */
public class ClassNode extends AstNode implements Annotationable{
    
    public int modifier;
    
    public String name;
    
    @Nullable
    public String fileName = null;
    
    @Nullable
    private ObjectType superType;
    
    private final List<FieldNode> fields = new ArrayList<>();
    
    protected final List<MethodNode> methods = new LinkedList();
    
    private final List<ObjectType> interfaces = new LinkedList();
    
    public final List<AnnotationNode> annotations = new LinkedList<>();
    
    public final List<Statement> staticInitStmts = new LinkedList<>();
    
    public final List<Statement> initStmts = new LinkedList<>();
    
    protected List<GenericType> genericTypes = new LinkedList<>();
    
    public final List<ClassNode> classes = new LinkedList();
    
    @Nullable
    public ClassNode enclosingClass;

    public ClassNode() {
    }
    
    public ClassNode(String name,int modifier){
        this.modifier  =modifier;
        this.name = name;
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
        ls.addAll(this.classes);
        return ls;
    }


    public FieldNode createField(Type type,String name,int modifier){
        FieldNode fieldNode =new FieldNode(this,type,name,modifier);
        fields.add(fieldNode);
        return fieldNode;
    }
    
    public MethodNode createMethodNode(Type type,String name,int modifier){
        MethodNode md = new MethodNode(this, type, name, modifier);
        methods.add(md);
        return md;
    }
    
    public MethodNode[] getDeclaredMethodNodes(){
        return methods.toArray(new MethodNode[0]);
    }

    @Override
    public AnnotationNode[] getAnnotations() {
        return annotations.toArray(new AnnotationNode[0]);
    }
    
    public FieldNode[] getFields(){
        return this.fields.toArray(new FieldNode[fields.size()]);
    }
    
    public void addInterface(ObjectType type){
        this.interfaces.add(type);
    }
    
    public ObjectType[] getInterfaces(){
        return this.interfaces.toArray(new ObjectType[interfaces.size()]);
    }

    public ObjectType getSuperType() {
        return superType;
    }

    public void setSuperType(ObjectType superType) {
        this.superType = superType;
    }
    
}
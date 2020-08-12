package kalang.compiler.ast;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.core.GenericType;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;

import javax.annotation.Nullable;
import java.util.*;

/**
 * 
 * @author Kason Yang
 */
public class ClassNode extends AstNode implements Annotationable{
    
    private int modifier;
    
    private String name;
    
    @Nullable
    private String fileName = null;
    
    @Nullable
    private ObjectType superType;
    
    private final List<FieldNode> fields = new ArrayList<>();
    
    protected final List<MethodNode> methods = new LinkedList();
    
    private final List<ObjectType> interfaces = new LinkedList();

    //TODO make private
    public final List<AnnotationNode> annotations = new LinkedList<>();
    
    public final List<Statement> staticInitStmts = new LinkedList<>();

    public final Map<FieldNode, KalangParser.ExpressionContext> fieldInitExprMap = new HashMap<>();
    
    protected List<GenericType> genericTypes = new LinkedList<>();
    
    public final List<ClassNode> classes = new LinkedList<>();
    
    @Nullable
    public ClassNode enclosingClass;

    public boolean isScript = false;

    public boolean isStructureFinished = false;

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
        return genericTypes.toArray(new GenericType[0]);
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,fields);
        addChild(ls,methods);
        ls.addAll(this.classes);
        return ls;
    }


    public FieldNode createField(Type type, String name, int modifier){
        FieldNode fieldNode =new FieldNode(this,type,name,modifier);
        fields.add(fieldNode);
        return fieldNode;
    }
    
    public MethodNode createMethodNode(Type type,String name,int modifier, BlockStmt body){
        MethodNode md = new MethodNode(this, type, name, modifier, body);
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

    //TODO rename to getDeclaredFields?
    public FieldNode[] getFields(){
        return this.fields.toArray(new FieldNode[fields.size()]);
    }

    public void removeField(FieldNode fieldNode) {
        fields.remove(fieldNode);
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

    @Override
    public String toString() {
        return "ClassNode " + this.name;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getFileName() {
        return fileName;
    }

    public void setFileName(@Nullable String fileName) {
        this.fileName = fileName;
    }
}
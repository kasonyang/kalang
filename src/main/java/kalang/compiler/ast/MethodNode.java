package kalang.compiler.ast;

import kalang.compiler.core.Type;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class MethodNode extends AstNode implements Annotationable{
    
    private final int modifier;
    
    private Type type;
    
    private String name;

    @Nullable
    private ConstExpr defaultReturnValue;
    
    private final List<ParameterNode> parameters = new LinkedList();
    
    private final List<AnnotationNode> annotations = new LinkedList<>();
    
    @Nullable
    private final BlockStmt body;
    
    private final List<Type> exceptionTypes = new LinkedList();
    
    private final ClassNode classNode;
    
    protected MethodNode(ClassNode classNode,Type type,String name,int modifier){
        this.classNode = classNode;
        this.modifier = modifier;
        this.type = type;
        this.name = name;
        this.body = Modifier.isAbstract(modifier) ? null : new BlockStmt();
    }
    
    public ParameterNode createParameter(Type type,String name){
        return _createParameter(null, type, name, 0);
    }

    public ParameterNode createParameter(Type type, String name, int modifier) {
        return _createParameter(null, type, name, modifier);
    }
    
    public ParameterNode createParameter(int index,Type type,String name){
        return _createParameter(index, type, name, 0);
    }
    
    private ParameterNode _createParameter(Integer index,Type type,String name, int modifier){
        ParameterNode param = new ParameterNode(this, modifier, type, name);
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
        return annotations.toArray(new AnnotationNode[annotations.size()]);
    }

    @Override
    public String toString() {
        List<String> params = new ArrayList();
        for(ParameterNode p:parameters){
            params.add(String.format("%s %s", p.getType(), p.getName()));
        }
        return String.format("%s %s %s(%s)", Modifier.toString(modifier),type.toString(),name,String.join(",", params));
    }
    
    public ParameterNode[] getParameters(){
        return parameters.toArray(new ParameterNode[parameters.size()]);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public ClassNode getClassNode() {
        return classNode;
    }

    public int getModifier() {
        return modifier;
    }

    public BlockStmt getBody() {
        return body;
    }
    
    public void addAnnotation(AnnotationNode annotation){
        this.annotations.add(annotation);
    }
    
    public void addExceptionType(Type type){
        this.exceptionTypes.add(type);
    }
    
    public Type[] getExceptionTypes(){
        return this.exceptionTypes.toArray(new Type[exceptionTypes.size()]);
    }

    @Nullable
    public ConstExpr getDefaultReturnValue() {
        return defaultReturnValue;
    }

    public void setDefaultReturnValue(ConstExpr defaultReturnValue) {
        this.defaultReturnValue = defaultReturnValue;
    }

}
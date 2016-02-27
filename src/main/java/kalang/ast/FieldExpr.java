/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
import kalang.util.AstUtil;
public class FieldExpr extends AssignableExpr{
    
    protected ExprNode target;
    
    protected String fieldName;
    
    protected FieldNode matchedField;    
    
    public FieldExpr(){
        
    }
    
    
    public FieldExpr(ExprNode target,String fieldName){
        
        
            this.target = target;
        
            this.fieldName = fieldName;
        
    }
    
    
    public static FieldExpr create(){
        FieldExpr node = new FieldExpr();
        
        return node;
    }
    
    protected void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    protected void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls, getTarget());
        
        return ls;
    }
    
    public String toString(){
        String str = "FieldExpr{\r\n";
        
        if(getTarget()!=null){
            str += "  target:" + getTarget().toString()+"\r\n";
        }
        
        if(getFieldName()!=null){
            str += "  fieldName:" + getFieldName().toString()+"\r\n";
        }
        
        return str+"}";
    }
    
    public ClassType getTargetType(){
        Type tt = getType(getTarget());
        if(!(tt instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + tt);
        }
        return (ClassType) tt;
    }

    @Override
    public Type getType() {
        ClassType ct = getTargetType();
        if(ct==null) return null;
        FieldNode field = AstUtil.getField(ct.getClassNode(), getFieldName());
        if(field==null) return null;
        return field.type;
    }

    /**
     * @return the target
     */
    public ExprNode getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(ExprNode target) {
        Objects.requireNonNull(target);
        this.target = target;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the matchedField
     */
    public FieldNode getMatchedField() {
        return matchedField;
    }

    /**
     * @param matchedField the matchedField to set
     */
    public void setMatchedField(FieldNode matchedField) {
        this.matchedField = matchedField;
    }
}
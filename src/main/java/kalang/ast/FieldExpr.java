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
    private ClassNode specialClass;
    
    public FieldExpr(ExprNode target,String fieldName){
        this.target = target;
        this.fieldName = fieldName;
    }
    
    public FieldExpr(ExprNode target,String fieldName,ClassNode specialClass){
            this.target = target;
            this.fieldName = fieldName;
            this.specialClass = specialClass;
    }
    
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getTarget());
        return ls;
    }
    
    public ClassType getTargetType(){
        if(specialClass!=null){
            return Types.getClassType(specialClass);
        }
        Objects.requireNonNull(target);
        Type tt = getType(target);
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
    
    public FieldNode getField(){
        ClassType targetType = getTargetType();
        ClassNode ast = targetType.getClassNode();
        return AstUtil.getField(ast, fieldName);
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

    public ClassNode getSpecialClass() {
        return specialClass;
    }

    public void setSpecialClass(ClassNode specialClass) {
        this.specialClass = specialClass;
    }
    
    
}
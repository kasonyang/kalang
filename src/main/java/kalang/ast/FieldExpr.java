/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
import kalang.util.AstUtil;
public class FieldExpr extends AssignableExpr{
    
    public ExprNode target;
    
    public String fieldName;
    
    public FieldNode matchedField;    
    
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
        
        addChild(ls,target);
        
        return ls;
    }
    
    public String toString(){
        String str = "FieldExpr{\r\n";
        
        if(target!=null){
            str += "  target:" + target.toString()+"\r\n";
        }
        
        if(fieldName!=null){
            str += "  fieldName:" + fieldName.toString()+"\r\n";
        }
        
        return str+"}";
    }
    
    public ClassType getTargetType(){
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
        FieldNode field = AstUtil.getField(ct.getClassNode(), fieldName);
        if(field==null) return null;
        return field.type;
    }
}
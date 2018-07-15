package kalang.compiler;

import java.lang.reflect.Modifier;
import kalang.util.AstUtil;
import java.util.LinkedList;
import java.util.List;
import kalang.ast.AstNode;
import kalang.ast.AstVisitor;
import kalang.ast.BinaryExpr;
import kalang.ast.ClassNode;
import kalang.ast.ElementExpr;
import kalang.ast.ExprNode;
import kalang.ast.MethodNode;
import kalang.ast.ReturnStmt;
import kalang.ast.UnaryExpr;
import java.util.Set;
import javax.annotation.Nullable;
import kalang.ast.AnnotationNode;
import kalang.ast.AssignableExpr;
import kalang.ast.FieldExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.ParameterExpr;
import kalang.ast.ParameterNode;
import kalang.ast.VarExpr;
import kalang.core.ArrayType;
import kalang.core.FieldDescriptor;
import kalang.core.ObjectType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.exception.Exceptions;
import kalang.util.BoxUtil;

/**
 *  The semantic analyzer class infers and checks the componentType of expressions. It may transform the abstract syntax tree.
 * 
 * @author Kason Yang
 */
public class SemanticAnalyzer extends AstVisitor<Type> {

    private AstLoader astLoader;
    
    private ClassNode clazz;

    private CompilationUnit source;
    
    private final DiagnosisReporter diagnosisReporter;

    public SemanticAnalyzer(CompilationUnit source,AstLoader astLoader) {
        this.astLoader = astLoader;
        this.source = source;
        CompileContext ctx = source.getCompileContext();
        this.diagnosisReporter = new DiagnosisReporter(source);
    }
    
    /**
     * checks whether an expression as assignable to another expression , and transform the expression if needed.
     * 
     * @param expr
     * @param from
     * @param to
     * @param node
     * @return the assignable expression when assignable ,or null
     */
    @Nullable
    private ExprNode checkAssign(ExprNode expr, Type from, Type to, AstNode node) {
        expr = BoxUtil.assign(expr, from, to);
        if (expr == null) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    ,from.getName() + " can not be converted to " + to.getName(),node.offset);
            return null;
        }
        return expr;
    }
    
    @Nullable
    public static PrimitiveType getPrimitiveType(Type t){
        if(t instanceof PrimitiveType){
            return (PrimitiveType) t;
        }else if(t instanceof ObjectType){
            return Types.getPrimitiveType((ObjectType)t);
        }else{
            return null;
        }
    }

    public boolean validateBinaryExpr(BinaryExpr node) {
        ExprNode expr1 = node.getExpr1();
        ExprNode expr2 = node.getExpr2();
        Type t1 = expr1.getType();
        Type t2 = expr2.getType();
        String op = node.getOperation();
        switch (op) {
            case "==":
            case "!=":
                if (Types.isNumber(t1)) {
                    return this.requireNumber(expr2,t2);
                } else {
                    return true;
                    //TODO pass anything.may be Object needed?
                }
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case ">=":
            case "<=":
            case ">":
            case "<":
            case "&":
            case "|":
            case "^":
            case BinaryExpr.OP_SHIFT_LEFT:
            case BinaryExpr.OP_SHIFT_RIGHT:
                return this.requireNumber(expr1, t1) && this.requireNumber(expr2, t2);
            case "&&":
            case "||":
                return requireBoolean(expr1, t1) && requireBoolean(expr2, t2);
            default:
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "unsupport operation:" + op, node.offset);
                return false;
        }
    }

    public boolean validateElementExpr(ElementExpr node) {
        return requireArray(node, node.getArrayExpr().getType());
    }

    public boolean validateUnaryExpr(UnaryExpr node) {
        String op = node.getOperation();
        Type et = node.getExpr().getType();
        switch(op){
            case UnaryExpr.OPERATION_LOGIC_NOT:
                return requireBoolean(node, et);
            case UnaryExpr.OPERATION_NEG:
            case UnaryExpr.OPERATION_POS:
            case UnaryExpr.OPERATION_NOT:
                return requireNumber(node, et);
            default:
                throw Exceptions.unexceptedValue(op);
        }
    }
    
    public boolean validateAssign(AssignableExpr to,ExprNode from, OffsetRange offset,boolean isInitializationStmt){
        if (to instanceof VarExpr) {
            LocalVarNode varObject = ((VarExpr) to).getVar();
            if (!isInitializationStmt && Modifier.isFinal(varObject.modifier)) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("%s is readonly", varObject.getName()),offset);
                return false;
            }
        } else if (to instanceof FieldExpr){
            FieldDescriptor field = ((FieldExpr) to).getField();
            if (!isInitializationStmt && Modifier.isFinal(field.getModifier())) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("%s is readonly", field.getName()),offset);
                return false;
            }
        } else if (to instanceof ParameterExpr) {
            ParameterNode parameter = ((ParameterExpr) to).getParameter();
            if (Modifier.isFinal(parameter.modifier)) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("%s is readonly", parameter.getName()),offset);
                return false;
            }
        }
        Type toType = to.getType();
        Type fromType = from.getType();
        if(!toType.isAssignableFrom(fromType)){
          diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("incompatible types: %s cannot be converted to %s",fromType,toType),offset);
          return false;
        }
        return true;
    }

    public boolean validateReturnStmt(MethodNode method,ReturnStmt node) {
        Type retType = method.getType();
        if (node.expr == null) {
            if(!retType.equals(Types.VOID_TYPE)){
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "missing return value",node.offset);
                return false;
            }
            return true;
        }else{
            Type exType = node.expr.getType();
            node.expr = this.checkAssign(node.expr, exType, retType, node);
            if(node.expr==null) return false;
            return true;
        }
    }

    boolean requireNumber(AstNode node, Type t) {
        if (!isNumber(t)) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "number type required",node.offset);
            return false;
        }
        return true;
    }

    boolean requireBoolean(ExprNode node) {
        return requireBoolean(node, node.getType());
    }

    boolean requireBoolean(AstNode node, Type t) {
        if (!Types.isBoolean(t)) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "boolean type required.",node.offset);
            return false;
        }
        return true;
    }

    boolean isArray(Type t) {
        return t instanceof ArrayType;
    }

    boolean requireArray(AstNode node, Type t) {
        if (!isArray(t)) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "array type required.");
            return false;
        }
        return true;
    }

    public boolean isStatic(int modifier) {
        return AstUtil.isStatic(modifier);
    }

    boolean requireStatic(Integer modifier, AstNode node) {
        boolean isStatic = isStatic(modifier);
        if (!isStatic) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "couldn't refer non-static member in static context",  node.offset);
            return false;
        }
        return true;
    }

    boolean requireNoneVoid(Type type, AstNode node) {
        if (type == null
                || type == Types.VOID_TYPE
                || type == Types.getVoidClassType()
                ){
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "use void type as value", node.offset);
            return false;
        }
        return true;
    }

    private boolean isNumber(Type t1) {
        return Types.isNumber(t1);
    }
    
    protected void validateAnnotation(AnnotationNode[] annotation){
        for(AnnotationNode an:annotation) validateAnnotation(an);
    }
    
    protected boolean validateAnnotation(AnnotationNode annotation){
        MethodNode[] mds = annotation.getAnnotationType().getDeclaredMethodNodes();
        Set<String> attrKeys = annotation.values.keySet();
        List<String> missingValues = new LinkedList<>();
        for(MethodNode m:mds){
            String name = m.getName();
            if(!attrKeys.contains(name)){
                missingValues.add(name);
            }
        }
        if(missingValues.size()>0){
            //TODO add offset on annotationNode
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    ,"Missing attribute for annotation:" + missingValues.toString(),OffsetRange.NONE);
            return false;
        }
        return true;
    }
    
}
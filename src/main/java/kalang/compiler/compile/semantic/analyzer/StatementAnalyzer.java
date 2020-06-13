package kalang.compiler.compile.semantic.analyzer;

import kalang.compiler.ast.*;
import kalang.compiler.compile.CompilationUnit;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.util.DiagnosisReporter;
import kalang.compiler.core.*;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.BoxUtil;

import javax.annotation.Nullable;
import java.util.*;

/**
 * 
 * @author Kason Yang
 */
public class StatementAnalyzer extends AstVisitor<Type> {

    private DiagnosisReporter diagnosisReporter;

    public StatementAnalyzer(CompilationUnit compilationUnit) {
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
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
                if (Types.isNumberPrimitive(t1)) {
                    return this.requireNumber(expr2, t2);
                } else if (Types.isNumberPrimitive(t2)) {
                    return this.requireNumber(expr1, t1);
                } else {
                    return true;
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
            case BinaryExpr.OP_UNSIGNED_SHIFT_RIGHT:
                return this.requireNumber(expr1, t1) && this.requireNumber(expr2, t2);
            case "&&":
            case "||":
                return requireBoolean(expr1, t1) && requireBoolean(expr2, t2);
            default:
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "unsupported operation:" + op, node.offset);
                return false;
        }
    }

    public boolean validateElementExpr(ElementExpr node) {
        return requireArray(node, node.getArrayExpr().getType());
    }

    public boolean validateReturnStmt(MethodNode method,ReturnStmt node) {
        Type retType = method.getType();
        if (node.getExpr() == null) {
            if(!retType.equals(Types.VOID_TYPE)){
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "missing return value",node.offset);
                return false;
            }
            return true;
        }else{
            Type exType = node.getExpr().getType();
            node.setExpr(this.checkAssign(node.getExpr(), exType, retType, node));
            if(node.getExpr() ==null) return false;
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
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "array type required.Found " + t.getName(), node.offset);
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
    
    public void validateAnnotation(AnnotationNode annotation){
        MethodNode[] mds = annotation.getAnnotationType().getDeclaredMethodNodes();
        List<String> missingValues = new LinkedList<>();
        HashMap<String, ConstExpr> unprocessedValues = new HashMap<>(annotation.values);
        for(MethodNode m:mds){
            String name = m.getName();
            ConstExpr attr = unprocessedValues.remove(name);
            if(m.getDefaultValue() == null && attr == null){
                missingValues.add(name);
            }
            if (attr != null && !m.getType().isAssignableFrom(attr.getType())) {
                diagnosisReporter.report(Diagnosis.Kind.ERROR, attr.getType() + " is not applicable to " + m.getType(), attr.offset);
            }
        }
        for (String m : missingValues) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"Missing attribute " + m, annotation.offset);
        }
        for (Map.Entry<String, ConstExpr> e : unprocessedValues.entrySet()) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "Cannot resolve method " + e.getKey(), annotation.offset);
        }
    }
    
}
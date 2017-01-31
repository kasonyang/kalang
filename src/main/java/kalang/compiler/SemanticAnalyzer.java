package kalang.compiler;

import kalang.util.MathType;
import kalang.util.AstUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import kalang.ast.AssignExpr;
import kalang.ast.AstNode;
import kalang.ast.AstVisitor;
import kalang.ast.BinaryExpr;
import kalang.ast.CastExpr;
import kalang.ast.CatchBlock;
import kalang.ast.ClassNode;
import kalang.ast.ElementExpr;
import kalang.ast.ExprNode;
import kalang.ast.IfStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.LoopStmt;
import kalang.ast.MethodNode;
import kalang.ast.ReturnStmt;
import kalang.ast.Statement;
import kalang.ast.TryStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import kalang.ast.AnnotationNode;
import kalang.ast.Annotationable;
import kalang.ast.AssignableExpr;
import kalang.ast.ClassReference;
import kalang.ast.ErrorousExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.ThrowStmt;
import kalang.ast.UnknownFieldExpr;
import kalang.ast.UnknownInvocationExpr;
import kalang.core.ArrayType;
import kalang.core.ObjectType;
import kalang.core.ExecutableDescriptor;
import kalang.core.MethodDescriptor;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.core.VarTable;
import kalang.exception.Exceptions;
import kalang.util.BoxUtil;
import kalang.util.CollectionsUtil;
import kalang.util.MethodUtil;

/**
 *  The semantic analyzer class infers and checks the componentType of expressions. It may transform the abstract syntax tree.
 * 
 * @author Kason Yang
 */
public class SemanticAnalyzer extends AstVisitor<Type> {
    
    private HashMap<String, VarObject> fields;

    private AstLoader astLoader;

    private ClassNode clazz;

   private  MethodNode method;

    private SemanticErrorReporter err;

    private Stack<Map<Type,AstNode>> exceptionStack = new Stack();
    private CompilationUnit source;
    
    private VarTable<LocalVarNode,Void> assignedVars = new VarTable<>();
    private DiagnosisReporter diagnosisReporter;

    public SemanticAnalyzer(CompilationUnit source,AstLoader astLoader) {
        this.astLoader = astLoader;
        this.source = source;
    }
    
    private Type getDefaultType(){
        return Types.getRootType();
    }

    public void setAstSemanticErrorHandler(DiagnosisHandler handler) {
        this.diagnosisReporter = new DiagnosisReporter(
                source.getCompileContext(),handler,source.getSource()
        );
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
            err.failedToCast(node, from.getName(), to.getName());
            return null;
        }
        return expr;
    }

    @Nullable
    public ClassNode loadAst(String name, AstNode node) {
        ClassNode ast = this.astLoader.getAst(name);
        if (ast == null) {
            err.classNotFound(node, name);
            return null;
        }
        return ast;
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

    public static PrimitiveType getMathType(Type t1, Type t2, String op) {
        PrimitiveType pt1= getPrimitiveType(t1);
        PrimitiveType pt2 = getPrimitiveType(t2);
        if(pt1==null){
            throw new IllegalArgumentException(t1.getName());
        }
        if(pt2==null) throw new IllegalArgumentException(t2.getName());
        String ret = MathType.getType(pt1.getName(), pt2.getName(), op);
        return Types.getPrimitiveType(ret);
    }

    public boolean validateBinaryExpr(BinaryExpr node) {
        Type t1 = node.getExpr1().getType();
        Type t2 = node.getExpr2().getType();
        String op = node.getOperation();
        Type t;
        switch (op) {
            case "==":
            case "!=":
                if (Types.isNumber(t1)) {
                    if (!Types.isNumber(t2)) {
                        err.failedToCast(node, t2.getName(), Types.getIntClassType().getName());
                        return false;
                    }
                } else {
                    //TODO pass anything.may be Object needed?
                }
                t = Types.BOOLEAN_TYPE;
                break;
            case "+":
                if(isNumber(t1) && isNumber(t2)){
                    t = getMathType(t1, t2, op);
                }else{
                    err.fail("number type required", 0, node);
                    return false;
                }
                break;
            case "-":
            case "*":
            case "/":
            case "%":
                if(!requireNumber(node, t1)) return false;
                if(!requireNumber(node, t2)) return false;
                t = (getMathType(t1, t2, op));
                break;
            case ">=":
            case "<=":
            case ">":
            case "<":
                if(!requireNumber(node, t1)) return false;
                if(!requireNumber(node, t2)) return false;
                t = Types.BOOLEAN_TYPE;
                break;
            case "&&":
            case "||":
                if(!requireBoolean(node, t1)) return false;
                if(!requireBoolean(node, t2)) return false;
                t = Types.BOOLEAN_TYPE;
                break;
            case "&":
            case "|":
            case "^":
            case BinaryExpr.OP_SHIFT_LEFT:
            case BinaryExpr.OP_SHIFT_RIGHT:
                if(!requireNumber(node, t1)) return false;
                if(!requireNumber(node, t2)) return false;
                t = getPrimitiveType(Types.getHigherType(t1, t2));
                break;
            default:
                err.fail("unsupport operation:" + op, SemanticErrorReporter.UNSUPPORTED, node);
                return false;
        }
        return true;
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

    private void caughException(Type type) {
        Map<Type, AstNode> exceptions = this.exceptionStack.peek();
        Type[] exTypes = exceptions.keySet().toArray(new Type[0]);
        for (Type e : exTypes) {
                if (
                        e.equals(type)
                        || ((ObjectType)e).isSubTypeOf(type)
                        ) {
                    exceptions.remove(e);
                }
        }
    }

    public boolean validateReturnStmt(MethodNode method,ReturnStmt node) {
        Type retType = method.getType();
        if (node.expr == null) {
            if(!retType.equals(Types.VOID_TYPE)){
                err.fail("expression expected", 0, node);
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
            err.failedToCast(node, t.getName(),Types.getIntClassType().getName() );
            return false;
        }
        return true;
    }

    boolean requireBoolean(ExprNode node) {
        visit(node);
        return requireBoolean(node, node.getType());
    }

    boolean requireBoolean(AstNode node, Type t) {
        if (!Types.isBoolean(t)) {
            err.failedToCast(node, t.getName(), Types.getBooleanClassType().getName());
            return false;
        }
        return true;
    }

    boolean isArray(Type t) {
        return t instanceof ArrayType;
    }

    boolean requireArray(AstNode node, Type t) {
        if (!isArray(t)) {
            err.failedToCast(node, t.getName(), "array");
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
            err.fail("couldn't refer non-static member in static context", SemanticErrorReporter.UNSUPPORTED, node);
            return false;
        }
        return true;
    }

    boolean requireNoneVoid(Type type, AstNode node) {
        if (type == null
                || type == Types.VOID_TYPE
                || type == Types.getVoidClassType()
                ){
            err.unsupported("use void type as value", node);
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
            err.fail("Missing attribute for annotation:" + missingValues.toString(), -1, clazz);
            return false;
        }
        return true;
    }
    
    protected void enterNewFrame(){
        assignedVars = new VarTable<>(assignedVars);
    }
    
    protected void exitFrame(){
        assignedVars = assignedVars.getParent();
    }
    
    protected  void addIntersectedAssignedVar(VarTable<LocalVarNode,Void>... assignedVarsList){
        Set<LocalVarNode>[] assigned = new Set[assignedVarsList.length];
        for(int i=0;i<assigned.length;i++){
            assigned[i] = assignedVarsList[i].keySet();
        }
        Set<LocalVarNode> sets = CollectionsUtil.getIntersection(assigned);
        for(LocalVarNode s:sets){
            assignedVars.put(s, null);
        }
    }

}
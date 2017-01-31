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

    @Override
    public Type visitClassNode(ClassNode clz) {
        HashMap<String, VarObject> oldFiels = this.fields;
        this.fields = new HashMap();
        //this.methodDeclared = new LinkedList();
        for (VarObject f : clz.getFields()) {
            this.fields.put(f.getName(), f);
        }
        ClassNode oldClazz = this.clazz;
        this.clazz = clz;
        super.visitClassNode(clz);
        if (clazz.getInterfaces().length > 0) {
            for (ObjectType itfNode : clazz.getInterfaces()) {
                if (itfNode == null) {
                    continue;
                }
                List<MethodDescriptor> unImps = AstUtil.getUnimplementedMethod(clazz, itfNode);
                if (unImps.size() > 0) {
                    err.notImplementedMethods(clazz, itfNode, unImps);
                }
            }
        }
        this.clazz = oldClazz;
        this.fields = oldFiels;
        return null;
    }
    
    public void check(ClassNode clz) {
        err = new SemanticErrorReporter(clz,source ,source.getCompileContext().getDiagnosisHandler());
        this.visit(clz);
    }

    @Override
    public Type visit(AstNode node) {
        if(node==null) return null;
        if(node instanceof VarExpr){
            if(!assignedVars.exist(((VarExpr)node).getVar(), true)){
                err.fail(node.toString() + " is uninitialized!", 0, node);
            }
        }
        Object ret = super.visit(node);
        if (ret instanceof Type) {
            return  (Type) ret;
        }else if(node instanceof ExprNode){
            return ((ExprNode)node).getType();
        }
        return null;
    }

    @Override
    public Type visitAssignExpr(AssignExpr node) {
        AssignableExpr to = node.getTo();
        ExprNode from = node.getFrom();
        visit(from);
        if(to instanceof VarExpr){
            assignedVars.put(((VarExpr)to).getVar(), null);
        }
        Type ft = from.getType();
        Type tt = to.getType();
        if(!requireNoneVoid(ft, node)) return getDefaultType();
        if(!requireNoneVoid(tt, node)) return getDefaultType();
        if(!ft.equals(tt)){
            from = checkAssign(from, ft, tt, node); 
            if(from==null) return getDefaultType();            
            node.setFrom(from);
        }
        return tt;
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

    @Override
    public Type visitInvocationExpr(InvocationExpr node) {
        super.visitInvocationExpr(node);
       ExecutableDescriptor invokeMethod = node.getMethod();
        for(Type et:invokeMethod.getExceptionTypes()){
            this.exceptionStack.peek().put(et,node);
        }
        return node.getType();
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

    @Override
    public Type visitTryStmt(TryStmt node) {
        this.exceptionStack.add(new HashMap<>());
        List<VarTable<LocalVarNode,Void>> assignedList =  new ArrayList(node.getCatchStmts().size()+1);
        enterNewFrame();
        assignedList.add(assignedVars);
        visit(node.getExecStmt());
        exitFrame();
        for(CatchBlock cs:node.getCatchStmts()){
            enterNewFrame();
            assignedList.add(assignedVars);
            visit(cs);
            exitFrame();
        }
        addIntersectedAssignedVar(assignedList.toArray(new VarTable[assignedList.size()]));
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        if (uncaught.size() > 0) {
            this.exceptionStack.peek().putAll(uncaught);
        }
        Statement finallyStmt = node.getFinallyStmt();
        if(finallyStmt!=null){
            visit(finallyStmt);
        }        
        return null;
    }

    @Override
    public Type visitCatchBlock(CatchBlock node) {
        this.caughException(node.catchVar.getType());
        return super.visitCatchBlock(node);
    }

    @Override
    public Type visitIfStmt(IfStmt node) {
        requireBoolean(node.getConditionExpr());
        VarTable<LocalVarNode, Void> trueAssignedVars=null,falseAssignedVars =null;
        if (node.getTrueBody() != null) {
            enterNewFrame();
            trueAssignedVars = assignedVars;
            visit(node.getTrueBody());
            exitFrame();
        }
        if (node.getFalseBody() != null) {
            enterNewFrame();
            falseAssignedVars = assignedVars;
            visit(node.getFalseBody());
            exitFrame();
        }
        if(trueAssignedVars!=null && falseAssignedVars!=null){
            addIntersectedAssignedVar(trueAssignedVars,falseAssignedVars);
        }
        return null;
    }

    
    @Override
    public Type visitLoopStmt(LoopStmt node) {
        if (node.getPreConditionExpr() != null) {
            requireBoolean(node.getPreConditionExpr());
        }
        if (node.getLoopBody() != null) {
            enterNewFrame();
            visit(node.getLoopBody());
            exitFrame();
        }
        if (node.getPostConditionExpr() != null) {
            requireBoolean(node.getPostConditionExpr());
        }
        return null;
    }

    @Override
    public Type visitMethodNode(MethodNode node) {
        method = node;
        this.exceptionStack.push(new HashMap<>());
        super.visitMethodNode(node);
        for (Type e : method.getExceptionTypes()) {
            this.caughException(e);
        }
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        for(Type k:uncaught.keySet()){
            err.uncaughtException(uncaught.get(k),k.getName());
        }
        return null;
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
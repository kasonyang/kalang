package kalang.compiler;

import kalang.util.AstUtil;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import kalang.ast.AssignExpr;
import kalang.ast.AstNode;
import kalang.ast.AstVisitor;
import kalang.ast.BinaryExpr;
import kalang.ast.CastExpr;
import kalang.ast.CatchStmt;
import kalang.ast.ClassExpr;
import kalang.ast.ClassNode;
import kalang.ast.ConstExpr;
import kalang.ast.ElementExpr;
import kalang.ast.ExprNode;
import kalang.ast.FieldExpr;
import kalang.ast.IfStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.KeyExpr;
import kalang.ast.LoopStmt;
import kalang.ast.MethodNode;
import kalang.ast.MultiStmtExpr;
import kalang.ast.NewArrayExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ReturnStmt;
import kalang.ast.Statement;
import kalang.ast.TryStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.VarDeclStmt;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.ast.FieldNode;
import kalang.ast.IncrementExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.NewObjectExpr;
import kalang.ast.ParameterNode;
import kalang.core.ClassType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import static kalang.util.AstUtil.getMethodsByName;
import static kalang.util.AstUtil.getParameterTypes;
import static kalang.util.AstUtil.matchTypes;
import kalang.util.BoxUtil;

/**
 *  The semantic analyzer class infers and checks the componentType of expressions. It may transform the abstract syntax tree.
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class SemanticAnalyzer extends AstVisitor<Type> {
   
    private HashMap<String, VarObject> fields;

    private AstLoader astLoader;

    private ClassNode clazz;

   private  MethodNode method;

    private List<String> methodDeclared;

    private boolean returned;

    private AstSemanticErrorReporter err;

    private AstSemanticErrorHandler errHandler;

    private Stack<Map<Type,AstNode>> exceptionStack = new Stack();

    private Map<AstNode, Type> types = new HashMap<>();

    SemanticAnalyzer(AstLoader astLoader) {
        this.astLoader = astLoader;
        errHandler = new AstSemanticErrorHandler() {
            @Override
            public void handleAstSemanticError(AstSemanticError error) {
                System.err.println(error.toString());
            }
        };
    }
    
    private Type getDefaultType(){
        return Types.ROOT_TYPE;
    }

    public void setAstSemanticErrorHandler(AstSemanticErrorHandler handler) {
        errHandler = handler;
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
    private ExprNode checkAssign(ExprNode expr, Type from, Type to, AstNode node) {
        expr = BoxUtil.assign(expr, from, to);
        if (expr == null) {
            err.failedToCast(node, from.getName(), to.getName());
            return null;
        }
        return expr;
    }

    public ClassNode loadAst(String name, AstNode node) {
        ClassNode ast = this.astLoader.getAst(name);
        if (ast == null) {
            err.classNotFound(node, name);
            return null;
        }
        return ast;
    }

    public void check(ClassNode clz) {
        err = new AstSemanticErrorReporter(clz, new AstSemanticErrorReporter.AstSemanticReporterCallback() {
            @Override
            public void handleAstSemanticError(AstSemanticError error) {
                errHandler.handleAstSemanticError(error);
            }
        });
        this.fields = new HashMap();
        this.methodDeclared = new LinkedList();
        for (VarObject f : clz.fields) {
            this.fields.put(f.name, f);
        }
        this.clazz = clz;
        visit(clazz);
        if (clazz.interfaces.size() > 0) {
            for (ClassNode itf : clazz.interfaces) {
                //assert itf != null;
                ClassNode itfNode = itf;
                if (itfNode == null) {
                    continue;
                }
                List<MethodNode> unImps = AstUtil.getUnimplementedMethod(clazz, itfNode);
                if (unImps.size() > 0) {
                    err.notImplementedMethods(clazz, itfNode, unImps);
                }
            }
        }
    }

    @Override
    public Type visit(AstNode node) {
        if(node==null) return null;
        if (node instanceof Statement && returned) {
            err.fail("unabled to reach statement", AstSemanticError.LACKS_OF_STATEMENT, node);
            return null;
        }
        Object ret = super.visit(node);
        if (ret instanceof Type) {
            types.put(node,(Type) ret);
//            if(node instanceof ExprNode){
//                ExprNode exprNode = ((ExprNode)node);
//                if(exprNode.getType()==null){
//                    exprNode.setType((Type) ret);
//                }
//            }
            return  (Type) ret;
        }
        return null;
    }

    @Override
    public Type visitCastExpr(CastExpr node) {
        Type et = visit(node.expr);
        if(!node.toType.isSubTypeOf(et)
                && !node.toType.equals(et)
                ){
            err.failedToCast(node, et.getName(), node.toType.getName());
        }
        return node.toType;
    }

    @Override
    public Type visitAssignExpr(AssignExpr node) {
        Type ft = visit(node.from);
        Type tt = visit(node.to);
        if(!requireNoneVoid(ft, node)) return getDefaultType();
        if(!requireNoneVoid(tt, node)) return getDefaultType();
        if(!ft.equals(tt)){
            node.from = checkAssign(node.from, ft, tt, node);
            if(node.from==null) return getDefaultType();            
        }
        return tt;
    }
    
    private PrimitiveType getPrimitiveType(Type t){
        if(t instanceof PrimitiveType){
            return (PrimitiveType) t;
        }else if(t instanceof ClassType){
            return Types.getPrimitiveType((ClassType)t);
        }else{
            return null;
        }
    }

    private Type getMathType(Type t1, Type t2, String op) {
        PrimitiveType pt1= getPrimitiveType(t1);
        PrimitiveType pt2 = getPrimitiveType(t2);
        if(pt1==null){
            throw new IllegalArgumentException(t1.getName());
        }
        if(pt2==null) throw new IllegalArgumentException(t2.getName());
        String ret = MathType.getType(pt1.getName(), pt2.getName(), op);
        return Types.getPrimitiveType(ret);
    }

    @Override
    public Type visitBinaryExpr(BinaryExpr node) {
        Type t1 = visit(node.expr1);
        Type t2 = visit(node.expr2);
        String op = node.operation;
        Type t;
        switch (op) {
            case "==":
                if (Types.isNumber(t1)) {
                    if (!Types.isNumber(t2)) {
                        err.failedToCast(node, t2.getName(), Types.INT_CLASS_TYPE.getName());
                        return getDefaultType();
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
                    node.expr1 = checkAssign(node.expr1,t1,Types.STRING_CLASS_TYPE, node);
                    node.expr2 = checkAssign(node.expr2, t2, Types.STRING_CLASS_TYPE, node);
                    t =Types.STRING_CLASS_TYPE;
                }
                break;
            case "-":
            case "*":
            case "/":
            case "%":
                if(!requireNumber(node, t1)) return getDefaultType();
                if(!requireNumber(node, t2)) return getDefaultType();
                t = (getMathType(t1, t2, op));
                break;
            case ">=":
            case "<=":
            case ">":
            case "<":
                if(!requireNumber(node, t1)) return getDefaultType();
                if(!requireNumber(node, t2)) return getDefaultType();
                t = Types.BOOLEAN_TYPE;
                break;
            case "&&":
            case "||":
                if(!requireBoolean(node, t1)) return getDefaultType();
                if(!requireBoolean(node, t2)) return getDefaultType();
                t = Types.BOOLEAN_TYPE;
                break;
            case "&":
            case "|":
            case "^":
                if(!requireNumber(node, t1)) return getDefaultType();
                if(!requireNumber(node, t2)) return getDefaultType();
                t = getPrimitiveType(Types.getHigherType(t1, t2));
                break;
            default:
                err.fail("unsupport operation:" + op, AstSemanticError.UNSUPPORTED, node);
                return getDefaultType();
        }
        return t;
    }

    @Override
    public Type visitConstExpr(ConstExpr node) {
        return node.constType;
    }

    @Override
    public Type visitElementExpr(ElementExpr node) {
        Type type = visit(node.arrayExpr);
        if(!requireArray(node, type)) return getDefaultType();
        return type.getComponentType();
    }

    @Override
    public Type visitFieldExpr(FieldExpr node) {
        if (null == node.target) {
            VarObject field = fields.get(node.fieldName);
            if (isStatic(method.modifier)) {
                if(!requireStatic(field.modifier, node)) return getDefaultType();
            }
            if(isStatic(field.modifier)){
                node.target = new ClassExpr(clazz);
            }else{
                node.target = new KeyExpr("this",Types.getClassType(clazz));
            }
            visit(node.target);
            return field.type;
        }
        Type t = visit(node.target);
        String fname = node.fieldName;
        FieldNode field = t.getField(fname);
        if (field == null) {
            err.fieldNotFound(node, fname);
            return getDefaultType();
        }
        if (node.target instanceof ClassExpr) {
            if(!requireStatic(field.modifier, node)) return getDefaultType();
        }
        node.matchedField = field;
        return field.type;
    }

    @Override
    public Type visitInvocationExpr(InvocationExpr node) {
        List<Type> argTypes = visitAll(node.arguments);
        ClassType target;
        if(node.target==null){
            node.target = new KeyExpr("this",Types.getClassType(clazz));
        }
        //TODO here may be bug
        visit(node.target);
        target = (ClassType) node.target.getType();
        if(target==null){
            throw new IllegalStateException("unknown return value");
        }
        ClassNode ast = target.getClassNode();
        if (ast == null) {
            return getDefaultType();
        }
        MethodNode matched = applyMethod(ast,node,argTypes.toArray(new Type[0]));
        if (matched==null) {
            return getDefaultType();
        }
        //node.matchedMethod = matched;
        boolean inStaticMethod = node.target == null && Modifier.isStatic(this.method.modifier);
        boolean isClassExpr = node.target instanceof ClassExpr;
        if (inStaticMethod || isClassExpr) {
            if(!requireStatic(matched.modifier, node)) return getDefaultType();
        }
        //TODO here could be optim
        for(Type et:matched.exceptionTypes){
            this.exceptionStack.peek().put(et,node);
        }
        return matched.type;
    }

    @Override
    public Type visitParameterExpr(ParameterExpr node) {
        return node.parameter.type;
    }

    @Override
    public Type visitUnaryExpr(UnaryExpr node) {
        String op = node.operation;
        Type et = visit(node.expr);
        if (op.equals("!")) {
            if(!requireBoolean(node, et)) return getDefaultType();
        } else {
            //TODO unary toType check
            //if(!requireNumber(node,et)) return getDefaultType()
        }
        return et;
    }

    @Override
    public Type visitVarExpr(VarExpr node) {
        return node.var.type;
    }

    private void caughException(Type type) {
        Map<Type, AstNode> exceptions = this.exceptionStack.peek();
        Type[] exTypes = exceptions.keySet().toArray(new Type[0]);
        for (Type e : exTypes) {
                if (
                        e.equals(type)
                        || e.isSubTypeOf(type)
                        ) {
                    exceptions.remove(e);
                }
        }
    }

    @Override
    public Type visitTryStmt(TryStmt node) {
        this.exceptionStack.add(new HashMap<>());
        visit(node.execStmt);
        visitAll(node.catchStmts);
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        if (uncaught.size() > 0) {
            this.exceptionStack.peek().putAll(uncaught);
        }
        visit(node.finallyStmt);
        return null;
    }

    @Override
    public Type visitCatchStmt(CatchStmt node) {
        //TODO here may be bug
        this.caughException(node.catchVarDecl.vars.get(0).type);
        return null;
    }

    @Override
    public Type visitClassExpr(ClassExpr node) {
        return Types.getClassType(node.clazz);
    }

    @Override
    public Type visitFieldNode(FieldNode fieldNode) {
        return checkVarDecl(fieldNode);
    }

    @Override
    public Type visitLocalVarNode(LocalVarNode localVarNode) {
        return checkVarDecl(localVarNode);
    }

    private Type checkVarDecl(VarObject var) {
        Type retType = null;
        if(var.initExpr!=null){
            retType = visit(var.initExpr);
            if(!requireNoneVoid(retType, var)) return getDefaultType();
        }
        if (var.type == null) {
            if(retType!=null){
                var.type = retType;
            }else{
                var.type = Types.ROOT_TYPE;
            }
        }
        if(retType!=null){
            var.initExpr = checkAssign(var.initExpr, retType, var.type, var);
        }
        return var.type;
    }

    @Override
    public Type visitNewArrayExpr(NewArrayExpr node) {
        return Types.getArrayType(node.componentType);
    }

    @Override
    public Type visitIfStmt(IfStmt node) {
        //node.conditionExpr = this.checkAndCastToBoolean(node.conditionExpr);
        if(!requireBoolean(node, visit(node.conditionExpr))) return getDefaultType();
        if (node.trueBody != null) {
            visit(node.trueBody);
        }
        boolean returnedOld = returned;
        returned = false;
        if (node.falseBody != null) {
            visit(node.falseBody);
        } else {
            returned = false;
        }
        returned = returnedOld && returned;
        return null;
    }

    @Override
    public Type visitLoopStmt(LoopStmt node) {
        if (node.preConditionExpr != null) {
            requireBoolean(node.preConditionExpr);
        }
        if (node.initStmts != null) {
            visitAll(node.initStmts);
        }
        if (node.loopBody != null) {
            visit(node.loopBody);
        }
        if (node.postConditionExpr != null) {
            requireBoolean(node.postConditionExpr);
        }
        return null;
    }

    @Override
    public Type visitMethodNode(MethodNode node) {
        String mStr = AstUtil.getMethodDescriptor(node, this.clazz.name);
        if (methodDeclared.contains(mStr)) {
            err.unsupported("declare method duplicately:"+mStr, node);
            return getDefaultType();
        }
        methodDeclared.add(mStr);
        method = node;
        returned = false;
        this.exceptionStack.push(new HashMap<>());
        super.visitMethodNode(node);
        if (method.exceptionTypes != null) {
            for (Type e : method.exceptionTypes) {
                this.caughException(e);
            }
        }
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        for(Type k:uncaught.keySet()){
            err.uncaughtException(uncaught.get(k),k.getName());
        }
        boolean needReturn;
//        if(isSpecialMethod(node)){
//            needReturn = isSpecialMethodNeedReturn(node);
//        }else{
            needReturn = (
                    node.type != null
                    && !node.type.equals(Types.VOID_TYPE)
                    );
//        }
       
        if (node.body != null && needReturn && !returned) {
            err.fail("Missing return statement in method:" + mStr, AstSemanticError.LACKS_OF_STATEMENT, node);
        }
        return null;
    }

    @Override
    public Type visitReturnStmt(ReturnStmt node) {
        Type retType = method.type;
        //this.checkCastable(visit(node.expr),retType,node)
        if (node.expr != null) {
            Type exType = visit(node.expr);
            node.expr = this.checkAssign(node.expr, exType, retType, node);
        }
        returned = true;
        return null;
    }

    boolean requireNumber(AstNode node, Type t) {
        if (!isNumber(t)) {
            err.failedToCast(node, t.getName(),Types.INT_CLASS_TYPE.getName() );
            return false;
        }
        return true;
    }

    boolean requireBoolean(AstNode node) {
        Type t = visit(node);
        return requireBoolean(node, t);
    }

    boolean requireBoolean(AstNode node, Type t) {
        if (!Types.isBoolean(t)) {
            err.failedToCast(node, t.getName(), Types.BOOLEAN_CLASS_TYPE.getName());
            return false;
        }
        return true;
    }

    boolean isArray(Type t) {
        return t.isArray();
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
            err.fail("couldn't refer non-static member in static context", AstSemanticError.UNSUPPORTED, node);
            return false;
        }
        return true;
    }

    boolean requireNoneVoid(Type type, AstNode node) {
        if (type == null
                || type == Types.VOID_TYPE
                || type == Types.VOID_CLASS_TYPE
                ){
            err.unsupported("use void type as value", node);
            return false;
        }
        return true;
    }

    @Override
    public Type visitKeyExpr(KeyExpr node) {
        String key = node.key;
        if (key.equals("this")) {
            return Types.getClassType(this.clazz);
        } else if (key.equals("super")) {
            if (clazz.parent == null) {
                return getDefaultType();
            }
            return Types.getClassType(clazz.parent);
        } else {
            System.err.println("Unknown key:" + key);
            return getDefaultType();
        }
    }

    @Override
    public Type visitMultiStmtExpr(MultiStmtExpr node) {
        visitAll(node.stmts);
        return visit(node.reference);
    }
    
    public Type getType(AstNode node){
        return types.get(node);
    }

    public Map<AstNode, Type> getTypes() {
        return types;
    }

    private boolean isNumber(Type t1) {
        return Types.isNumber(t1);
    }

    public boolean isSpecialMethod(MethodNode node) {
        return node.name.startsWith("<");
    }

//    public boolean isSpecialMethodNeedReturn(MethodNode node) {
//        if(node.name.equals("<init>")) return false;
//        else{
//            System.err.println("unknown method:" + node.name);
//            return false;
//        }
//    }

    public AstLoader getAstLoader() {
        return astLoader;
    }
    
    /**
     *  select the method for invocation expression,and apply ast transform if needed
     * @param cls
     * @param invocationExpr
     * @param types
     * @return the selected method,or null
     */
    private MethodNode applyMethod(ClassNode cls, InvocationExpr invocationExpr, Type[] types) {
        String methodName = invocationExpr.methodName;
        MethodNode md = AstUtil.getMethod(cls, methodName, types);
        if (md != null) {
            return md;
        } else {
            MethodNode[] methods = getMethodsByName(cls, methodName);
            ExprNode[] args = invocationExpr.arguments.toArray(new ExprNode[0]);
            int matchedCount = 0;
            ExprNode[] matchedParams=null;
            MethodNode matchedMethod = null;
            for (MethodNode m : methods) {
                Type[] mTypes = AstUtil.getParameterTypes(m);
                ExprNode[] mp = AstUtil.matchTypes(args, types, mTypes);
                if (mp != null) {
                    matchedCount++;
                    matchedParams = mp;
                    matchedMethod = m;
                }
            }
            if (matchedCount < 1) {
                err.methodNotFound(invocationExpr, cls.name, methodName,types);
                return null;
            } else if (matchedCount > 1) {
                err.fail("the method " + methodName + " is ambiguous", AstSemanticError.METHOD_NOT_FOUND, invocationExpr);
                return null;
            }
            invocationExpr.arguments.clear();
            invocationExpr.arguments.addAll(Arrays.asList(matchedParams));
            return matchedMethod;
        }
    }

    @Override
    public Type visitParameterNode(ParameterNode parameterNode) {
        return checkVarDecl(parameterNode);
    }

    @Override
    public Type visitNewObjectExpr(NewObjectExpr node) {
        return node.objectType;
    }

    @Override
    public Type visitIncrementExpr(IncrementExpr expr) {
        visitChildren(expr);
        return expr.expr.getType();
    }
    
    

}
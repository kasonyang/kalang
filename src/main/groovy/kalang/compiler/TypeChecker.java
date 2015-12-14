package kalang.compiler;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import jast.ast.AbstractAstVisitor;
import jast.ast.AssignExpr;
import jast.ast.AstNode;
import jast.ast.AstVisitor;
import jast.ast.BinaryExpr;
import jast.ast.CastExpr;
import jast.ast.CatchStmt;
import jast.ast.ClassExpr;
import jast.ast.ClassNode;
import jast.ast.ConstExpr;
import jast.ast.ElementExpr;
import jast.ast.ExprNode;
import jast.ast.FieldExpr;
import jast.ast.IfStmt;
import jast.ast.InvocationExpr;
import jast.ast.KeyExpr;
import jast.ast.LoopStmt;
import jast.ast.MethodNode;
import jast.ast.MultiStmtExpr;
import jast.ast.NewArrayExpr;
import jast.ast.NewExpr;
import jast.ast.ParameterExpr;
import jast.ast.ReturnStmt;
import jast.ast.Statement;
import jast.ast.TryStmt;
import jast.ast.UnaryExpr;
import jast.ast.VarDeclStmt;
import jast.ast.VarExpr;
import jast.ast.VarObject;
import kalang.compiler.AstError;

@groovy.transform.TypeChecked
class TypeChecker extends AstVisitor<String> {

    static class TypeError extends Exception {

        AstNode node;

        int errorCode;

        public TypeError(int errorCode, String msg, AstNode node) {
            super(msg);
            this.node = node;
            this.errorCode = errorCode;
        }
    }

    HashMap<String, VarObject> fields;

    AstLoader astLoader;

    ClassNode clazz;

    TypeSystem castSys;

    AstParser astParser;

    MethodNode method;

    List<MethodNode> methodDeclared;

    boolean returned;

    private AstError err;

    private ErrorHandler errHandler;

    private Stack<List<String>> exceptionStack = new Stack();

    TypeChecker(AstLoader astLoader) {
        this.astLoader = astLoader;
        this.castSys = new TypeSystem(astLoader);
        this.astParser = new AstParser(astLoader);
    }

    public void setErrorHandler(ErrorHandler handler) {
        errHandler = handler;
    }

    private ExprNode cast(ExprNode expr, String from, String to, AstNode node) {
        try {
            expr = castSys.cast(expr, from, to);
        } catch (AstNotFoundException e) {
            err.classNotFound(node, e.getMessage());
            throw new RuntimeException(e);
        }
        if (expr == null) {
            err.failedToCast(node, from, to);
        }
        return expr;
    }

    public ClassNode loadAst(String name, AstNode node) {
        ClassNode ast = this.astLoader.getAst(name);
        if (ast == null) {
            err.classNotFound(node, name);
        }
        return ast;
    }

    public void check(ClassNode clz) {
        if (this.errHandler != null) {
            err = new AstError(clz, this.errHandler);
        }
        this.fields = new HashMap();
        this.methodDeclared = new LinkedList();
        for (VarObject f : clz.fields) {
            this.fields.put(f.name, f);
        }
        this.clazz = clz;
        visit(clazz);
        if (clazz.interfaces.size() > 0) {
            for (String itfName : clazz.interfaces) {
                ClassNode itfNode = this.loadAst(itfName, clazz);
                if (itfNode == null) {
                    continue;
                }
                List<MethodNode> unImps = astParser.getUnimplementedMethod(clazz, itfNode);
                if (unImps.size() > 0) {
                    String mStr = astParser.getMethodDescriptor(unImps.get(0), null);
                    err.notImplementedMethods(clazz, itfNode, unImps);
                    //fail(CE"unimplemented method:${mStr}",clazz);
                }
            }
        }
        //if(implemented(clazz))
    }

    @Override
    public String visit(AstNode node) {
        if (node instanceof Statement && returned) {
            err.fail("unabled to reach statement", AstError.LACKS_OF_STATEMENT, node);
            return null;
        }
        Object ret = super.visit(node);
        if (ret instanceof String) {
            return (String) ret;
        }
        return null;
    }

    @Override
    public String visitCastExpr(CastExpr node) {
        return node.type;
    }

    @Override
    public String visitAssignExpr(AssignExpr node) {
        String ft = visit(node.from);
        requireNoneVoid(ft, node);
        String tt = visit(node.to);
        node.from = cast(node.from, ft, tt, node);
        //checkCastable(ft,tt,node);
        return tt;
    }

    private String getMathType(String t1, String t2, String op) {
        String pt1 = castSys.getPrimitiveType(t1);
        String pt2 = castSys.getPrimitiveType(t2);
        if (pt1 == null) {
            pt1 = t1;
        }
        if (pt2 == null) {
            pt2 = t2;
        }
        String ret = MathType.getType(pt1, pt2, op);
        return ret;
        //return castSys.classifyType(ret)
    }

    /*  private ExprNode checkAndCastToBoolean(ExprNode expr){
     String type = visit(expr);
     if(!castSys.isBoolean(type)){
     def be = new BinaryExpr();
     be.expr1 = expr;
     be.operation = "!="
     def zero = new ConstExpr();
     if(castSys.isNumber(type)){
     zero.type = INT_CLASS;
     zero.value = 0;
     }else{
     zero.type = NULL_CLASS;
     }
     be.expr2 = zero;
     return be;
     }
     //TODO cast string to boolean
     return expr;
     }*/
    @Override
    public String visitBinaryExpr(BinaryExpr node) {
        String t1 = (visit(node.expr1).toString());
        String t2 = (visit(node.expr2).toString());
        String op = node.operation;
        String t = this.castSys.getRootClass();// this.DEFAULT_CLASS;
        switch (op) {
            case "==":
                if (castSys.isNumber(t1)) {
                    if (!castSys.isNumber(t2)) {
                        err.failedToCast(node, t2,castSys.getIntClass());
                    }
                    //fail("Number required",node);
                } else {
                    //TODO pass anything.may be Object needed?
                }
                t = "boolean";
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                requireNumber(node, t1);
                requireNumber(node, t2);
                t = getMathType(t1, t2, op);
                break;
            case ">=":
            case "<=":
            case ">":
            case "<":
                requireNumber(node, t1);
                requireNumber(node, t2);
                t = "boolean";
                break;
            case "&&":
            case "||":
                requireBoolean(node, t1);
                requireBoolean(node, t2);
                t = "boolean";
                break;
            case "&":
            case "|":
            case "^":
                requireNumber(node, t1);
                requireNumber(node, t2);
                t = castSys.getHigherType(t1, t2);
                break;
            default:
                err.fail("unsupport operation:" + op, AstError.UNSUPPORTED, node);
            //throw new TypeError();
        }
        return t;
    }

    @Override
    public String visitConstExpr(ConstExpr node) {
        return node.type;
    }

    @Override
    public String visitElementExpr(ElementExpr node) {
        String type = visit(node.target);
        //if(!type.endsWith("[]")){
        requireArray(node, type);
        //fail("Array type required",node)
        //}
        return type.substring(0, type.length() - 2);
    }

    @Override
    public String visitFieldExpr(FieldExpr node) {
        if (null == node.target) {
            VarObject field = fields.get(node.fieldName);
            if (isStatic(method.modifier)) {
                requireStatic(field.modifier, node);
            }
            return field.type;
        }
        String t = visit(node.target);
        ClassNode target = this.astLoader.getAst(t);
        if (target == null) {
            err.fieldNotFound(node, t);
            return this.castSys.ROOT_CLASS;
        }
        String fname = node.fieldName;
        VarObject field = this.astParser.getField(target, fname);
        if (field == null) {
            err.fieldNotFound(node, fname);
        }
        if (node.target instanceof ClassExpr) {
            requireStatic(field.modifier, node);
        }
        return field.type;
    }

    @Override
    public String visitInvocationExpr(InvocationExpr node) {
        List<String> types = visitAll(node.arguments);
        String target = node.target != null ? visit(node.target) : this.clazz.name;
        String methodName = node.methodName;
        ClassNode ast = loadAst(target, node);
        MethodNode method = selectMethod(node, ast, methodName, types.toArray(new String[0]));
        if (method == null) {
            return castSys.ROOT_CLASS;
        }
        boolean inStaticMethod = node.target == null && Modifier.isStatic(this.method.modifier);
        boolean isClassExpr = node.target instanceof ClassExpr;
        if (inStaticMethod || isClassExpr) {
            requireStatic(method.modifier, node);
        }
        castInvocationParams(node, method);
        //TODO here could be optim
        this.exceptionStack.peek().addAll(method.exceptionTypes);
        return method.type;
    }

    @Override
    public String visitParameterExpr(ParameterExpr node) {
        return node.parameter.type;
    }

    @Override
    public String visitUnaryExpr(UnaryExpr node) {
        String preOp = node.preOperation;
        String et = visit(node.expr);
        if (preOp != null && preOp.equals("!")) {
            requireBoolean(node, et);
        } else {
			//TODO unary type check
            //requireNumber(node,et)
        }
        return et;
    }

    @Override
    public String visitVarExpr(VarExpr node) {
        //Integer vid = node.varId;
        //def declStmt = this.varDeclStmts.get(vid);
        //declStmt.type
        return node.var.type;
    }

    private void caughException(String type, AstNode node) {
        List<String> exceptions = this.exceptionStack.peek();
        for (String e : exceptions) {
            try {
                if (this.castSys.isSubclass(e, type)) {
                    exceptions.remove(e);
                }
            } catch (AstNotFoundException e1) {
                err.classNotFound(node, e);
                throw new RuntimeException(e1);
            }
        }
    }

    @Override
    public String visitTryStmt(TryStmt node) {
        this.exceptionStack.add(new LinkedList());
        if (method.exceptionTypes != null) {
            for (String e : method.exceptionTypes) {
                this.caughException(e, node);
            }
        }
        List<String> uncaught = this.exceptionStack.pop();
        if (uncaught.size() > 0) {
            err.uncaughtException(node, uncaught);
        }
        return null;
    }

    @Override
    public String visitCatchStmt(CatchStmt node) {
        this.caughException(node.catchVarDecl.var.type, node);
        return null;
    }

    @Override
    public String visitClassExpr(ClassExpr node) {
        return node.name;
    }

    @Override
    public String visitNewExpr(NewExpr node) {
        return node.type;
    }

    @Override
    public String visitVarDeclStmt(VarDeclStmt node) {
        //Type infer
        VarObject var = node.var;
        if (var.type == null) {
            if (var.initExpr != null) {
                var.type = visit(var.initExpr);
                requireNoneVoid(var.type, node);
            } else {
                var.type = castSys.getRootClass();
            }
        }
        //this.varDeclStmts.put(node.varId,node)
        return null;
    }

    @Override
    public String visitNewArrayExpr(NewArrayExpr node) {
        return node.type + "[]";
    }

    @Override
    public String visitIfStmt(IfStmt node) {
        //node.conditionExpr = this.checkAndCastToBoolean(node.conditionExpr);
        this.requireBoolean(node, visit(node.conditionExpr));
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
    public String visitLoopStmt(LoopStmt node) {
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
    public String visitMethodNode(MethodNode node) {
        String mStr = this.astParser.getMethodDescriptor(node, this.clazz.name);
        if (methodDeclared.contains(mStr)) {
            err.unsupported("declare method duplicately", node);
        }
        method = node;
        returned = false;
        this.exceptionStack.push(new LinkedList());
        super.visitMethodNode(node);
        this.exceptionStack.pop();
        boolean needReturn = (node.type != "void" && node.type != null);
        if (node.body != null && needReturn && !returned) {
            err.fail("Missing return statement in method:" + mStr, AstError.LACKS_OF_STATEMENT, node);
        }
        return null;
    }

    @Override
    public String visitReturnStmt(ReturnStmt node) {
        String retType = method.type;
        //this.checkCastable(visit(node.expr),retType,node)
        if (node.expr != null) {
            String exType = visit(node.expr);
            node.expr = this.cast(node.expr, exType, retType, node);
        }
        returned = true;
        return null;
    }

    void requireNumber(AstNode node, String t) {
        if (!castSys.isNumber(t)) {
            err.failedToCast(node, t, castSys.getIntClass());
        }
    }

    void requireBoolean(AstNode node) {
        String t = visit(node);
        requireBoolean(node, t);
    }

    void requireBoolean(AstNode node, String t) {
        if (!castSys.isBoolean(t)) {
            err.failedToCast(node, t, castSys.getBooleanClass());
        }
    }

    boolean isArray(String t) {
        return t.endsWith("[]");
    }

    void requireArray(AstNode node, String t) {
        if (!isArray(t)) {
            err.failedToCast(node, t, "array");
        }
    }

    boolean isStatic(Integer modifier) {
        return modifier != null ? Modifier.isStatic(modifier) : false;
    }

    void requireStatic(Integer modifier, AstNode node) {
        boolean isStatic = isStatic(modifier);
        if (!isStatic) {
            err.fail("couldn't refer non-static member in static context", AstError.UNSUPPORTED, node);
        }
    }

    void requireNoneVoid(String type, AstNode node) {
        if (type == null 
        		|| type.equals(castSys.getVoidPrimitiveType())
        		|| type.equals(castSys.getVoidClass())) {
            err.unsupported("use void type as value", node);
        }
    }

    MethodNode selectMethod(AstNode node, ClassNode cls, String methodName, String[] types) {
        MethodNode[] methods = this.astParser.getMethodsByName(cls, methodName);
        MethodNode[] matches;
        matches = this.astParser.matchMethodsByType(methods, types, false, false);
        if (matches == null || matches.length == 0) {
            matches = this.astParser.matchMethodsByType(methods, types, true, false);
        }
        if (matches == null || matches.length == 0) {
            matches = this.astParser.matchMethodsByType(methods, types, true, true);
        }
        List typeList = new LinkedList();
        if (types != null) {
            typeList.addAll(Arrays.asList(types));
        }
        if (matches == null || matches.length == 0) {
            err.methodNotFound(node, cls.name, methodName, typeList);
            return null;
        }
        if (matches.length > 1) {
            err.fail("the method " + methodName + " is ambiguous", AstError.METHOD_NOT_FOUND, node);
            return null;
        }
        return matches[0];
    }

    private void castInvocationParams(InvocationExpr expr, MethodNode method) {
        List<String> mTypes = this.astParser.getParameterTypes(method);
        int i = 0;
        for (String mt : mTypes) {
            String pt = visit(expr.arguments.get(i));
            try {
                expr.arguments.set(i, this.castSys.cast(expr.arguments.get(i), pt, mt));
            } catch (AstNotFoundException e) {
                err.classNotFound(expr, e.getMessage());
                throw new RuntimeException(e);
            }
            i++;
        }
    }

    @Override
    public String visitKeyExpr(KeyExpr node) {
        String key = node.key;
        if (key.equals("this")) {
            return this.clazz.name;
        } else if (key.equals("super")) {
            if (clazz.parentName == null) {
                return castSys.ROOT_CLASS;
            }
            return this.clazz.parentName;
        } else {
            System.err.println("Unknown key:" + key);
            return null;
        }
    }

	@Override
	public String visitMultiStmtExpr(MultiStmtExpr node) {
		visitAll(node.stmts);
		return visit(node.reference);
	}

}

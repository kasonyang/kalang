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
 *
 * @author Kason Yang
 */
public class ExceptionCatchAnalyzer extends AstVisitor<Type> {

    private AstLoader astLoader;

    private MethodNode method;

    private SemanticErrorReporter err;

    private Stack<Map<Type, AstNode>> exceptionStack = new Stack();

    private CompilationUnit source;

    private DiagnosisReporter diagnosisReporter;

    public ExceptionCatchAnalyzer(CompilationUnit source, AstLoader astLoader) {
        this.astLoader = astLoader;
        this.source = source;
    }

    public void setAstSemanticErrorHandler(DiagnosisHandler handler) {
        this.diagnosisReporter = new DiagnosisReporter(
                source.getCompileContext(), handler, source.getSource()
        );
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

    public void check(ClassNode clz, MethodNode method) {
        err = new SemanticErrorReporter(clz, source, source.getCompileContext().getDiagnosisHandler());
        this.visit(method);
    }

    @Override
    public Type visitInvocationExpr(InvocationExpr node) {
        super.visitInvocationExpr(node);
        ExecutableDescriptor invokeMethod = node.getMethod();
        for (Type et : invokeMethod.getExceptionTypes()) {
            this.exceptionStack.peek().put(et, node);
        }
        return node.getType();
    }

    private void caughException(Type type) {
        Map<Type, AstNode> exceptions = this.exceptionStack.peek();
        Type[] exTypes = exceptions.keySet().toArray(new Type[0]);
        for (Type e : exTypes) {
            if (e.equals(type)
                    || ((ObjectType) e).isSubTypeOf(type)) {
                exceptions.remove(e);
            }
        }
    }

    @Override
    public Type visitTryStmt(TryStmt node) {
        this.exceptionStack.add(new HashMap<>());
        visit(node.getExecStmt());
        for (CatchBlock cs : node.getCatchStmts()) {
            visit(cs);
        }
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        if (uncaught.size() > 0) {
            this.exceptionStack.peek().putAll(uncaught);
        }
        Statement finallyStmt = node.getFinallyStmt();
        if (finallyStmt != null) {
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
    public Type visitMethodNode(MethodNode node) {
        method = node;
        this.exceptionStack.push(new HashMap<>());
        super.visitMethodNode(node);
        for (Type e : method.getExceptionTypes()) {
            this.caughException(e);
        }
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        for (Type k : uncaught.keySet()) {
            err.uncaughtException(uncaught.get(k), k.getName());
        }
        return null;
    }

}

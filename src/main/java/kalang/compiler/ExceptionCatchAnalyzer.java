package kalang.compiler;

import java.util.HashMap;
import java.util.Stack;

import kalang.ast.AstNode;
import kalang.ast.AstVisitor;
import kalang.ast.CatchBlock;
import kalang.ast.ClassNode;
import kalang.ast.InvocationExpr;
import kalang.ast.MethodNode;
import kalang.ast.Statement;
import kalang.ast.TryStmt;
import java.util.Map;
import kalang.core.ObjectType;
import kalang.core.ExecutableDescriptor;
import kalang.core.Type;

/**
 *
 * @author Kason Yang
 */
public class ExceptionCatchAnalyzer extends AstVisitor<Object> {

    private AstLoader astLoader;

    private MethodNode method;

    private Stack<Map<Type, AstNode>> exceptionStack = new Stack();

    private CompilationUnit compilationUnit;

    private DiagnosisReporter diagnosisReporter;

    public ExceptionCatchAnalyzer(CompilationUnit source, AstLoader astLoader) {
        this.astLoader = astLoader;
        this.compilationUnit = source;
    }

    public void check(ClassNode clz, MethodNode method,DiagnosisHandler diagnosisHandler) {
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit.getCompileContext(), diagnosisHandler, compilationUnit.getSource());
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
    public Object visitCatchBlock(CatchBlock node) {
        this.caughException(node.catchVar.getType());
        return super.visitCatchBlock(node);
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        method = node;
        this.exceptionStack.push(new HashMap<>());
        super.visitMethodNode(node);
        for (Type e : method.getExceptionTypes()) {
            this.caughException(e);
        }
        Map<Type, AstNode> uncaught = this.exceptionStack.pop();
        for (Type k : uncaught.keySet()) {
            AstNode n = uncaught.get(k);
            String type = k.getName();
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "unreported exception:" + type,n.offset);
        }
        return null;
    }

}

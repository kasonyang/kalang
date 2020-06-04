package kalang.compiler.ast;

import java.util.*;
public abstract class AbstractAstVisitor<T> implements IAstVisitor<T>{

    public T visit(AstNode node){
        
        if(node==null) return null;
        
        if(node instanceof MultiStmt){
            return visitMultiStmt((MultiStmt)node);
        }
        
        if(node instanceof InstanceOfExpr){
            return visitInstanceOfExpr((InstanceOfExpr)node);
        }
        
        if(node instanceof ErrorousExpr){
            return visitErrorousExpr((ErrorousExpr) node);
        }
        
        if(node instanceof SuperExpr){
            return visitSuperExpr((SuperExpr)node);
        }
        
        if(node instanceof ClassReference){
            return visitClassReference((ClassReference) node);
        }
        
        if(node instanceof UnknownFieldExpr){
            return visitUnknownFieldExpr((UnknownFieldExpr)node);
        }
        
        if(node instanceof UnknownInvocationExpr){
            return visitUnknownInvocationExpr((UnknownInvocationExpr)node);
        }
        
        if(node instanceof ArrayLengthExpr){
            return visitArrayLengthExpr((ArrayLengthExpr) node);
        }
        
        if(node instanceof NewObjectExpr){
            return visitNewObjectExpr((NewObjectExpr)node);
        }
        
        if(node instanceof ClassNode){
            return visitClassNode((ClassNode)node);
        }
        
        if(node instanceof MethodNode){
            return visitMethodNode((MethodNode)node);
        }
        
        if(node instanceof BlockStmt){
            return visitBlockStmt((BlockStmt)node);
        }
        
        if(node instanceof BreakStmt){
            return visitBreakStmt((BreakStmt)node);
        }
        
        if(node instanceof ContinueStmt){
            return visitContinueStmt((ContinueStmt)node);
        }
        
        if(node instanceof ExprStmt){
            return visitExprStmt((ExprStmt)node);
        }
        
        if(node instanceof IfStmt){
            return visitIfStmt((IfStmt)node);
        }
        
        if(node instanceof LoopStmt){
            return visitLoopStmt((LoopStmt)node);
        }
        
        if(node instanceof ReturnStmt){
            return visitReturnStmt((ReturnStmt)node);
        }
        
        if(node instanceof VarDeclStmt){
            return visitVarDeclStmt((VarDeclStmt)node);
        }
        
        if(node instanceof TryStmt){
            return visitTryStmt((TryStmt)node);
        }
        
        if(node instanceof CatchBlock){
            return visitCatchBlock((CatchBlock)node);
        }

        if (node instanceof FinallyBlock) {
            return visitFinallyBlock((FinallyBlock) node);
        }
        
        if(node instanceof ThrowStmt){
            return visitThrowStmt((ThrowStmt)node);
        }
        
        if(node instanceof AssignExpr){
            return visitAssignExpr((AssignExpr)node);
        }
        
        if(node instanceof BinaryExpr){
            return visitBinaryExpr((BinaryExpr)node);
        }
        
        if(node instanceof ConstExpr){
            return visitConstExpr((ConstExpr)node);
        }
        
        if(node instanceof ElementExpr){
            return visitElementExpr((ElementExpr)node);
        }
        
        if(node instanceof FieldExpr){
            return visitFieldExpr((FieldExpr)node);
        }
        
        if(node instanceof InvocationExpr){
            return visitInvocationExpr((InvocationExpr)node);
        }
        
        if(node instanceof UnaryExpr){
            return visitUnaryExpr((UnaryExpr)node);
        }
        
        if(node instanceof VarExpr){
            return visitVarExpr((VarExpr)node);
        }
        
        if(node instanceof CastExpr){
            return visitCastExpr((CastExpr)node);
        }
        
        if(node instanceof PrimitiveCastExpr){
            return visitPrimitiveCastExpr((PrimitiveCastExpr)node);
        }
        
        if(node instanceof NewArrayExpr){
            return visitNewArrayExpr((NewArrayExpr)node);
        }
        
        if(node instanceof ThisExpr){
            return visitThisExpr((ThisExpr)node);
        }
        
        if(node instanceof MultiStmtExpr){
            return visitMultiStmtExpr((MultiStmtExpr)node);
        }
        
        if(node instanceof LocalVarNode){
            return visitLocalVarNode((LocalVarNode) node);
        }
        if(node instanceof ParameterNode){
            return visitParameterNode((ParameterNode)node);
        }
        if(node instanceof FieldNode){
            return visitFieldNode((FieldNode) node);
        }

        if (node instanceof LambdaExpr) {
            return visitLambdaExpr((LambdaExpr) node);
        }
        if (node instanceof IncExpr) {
            return visitIncExpr((IncExpr) node);
        }
        
        throw new IllegalArgumentException("BUG!Unknown node type:"+node.getClass());
    }
    
    protected List<T> visitAll(AstNode[] nodes){
        if(nodes==null) return Collections.emptyList();
        return visitAll(Arrays.asList(nodes));
    }
    
    protected List<T> visitAll(List<? extends AstNode> nodes){
        if(nodes==null) return null;
        List<T> result = new LinkedList<>();
        for(AstNode n:nodes){
            result.add(visit(n));
        }
        return result;
    }
    
    protected Map<AstNode,T> visitChildren(AstNode node){
        Map<AstNode,T> result = new HashMap<>();
        List<AstNode> children = node.getChildren();
        for(AstNode c:children){
            result.put(c,visit(c));
        }
        return result;
    }

}
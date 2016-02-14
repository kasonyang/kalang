package jast.ast;
import java.util.*;
public abstract class AbstractAstVisitor<T> implements IAstVisitor<T>{
    
    abstract public T visitClassNode(ClassNode node);
    
    abstract public T visitMethodNode(MethodNode node);
    
    abstract public T visitBlockStmt(BlockStmt node);
    
    abstract public T visitBreakStmt(BreakStmt node);
    
    abstract public T visitContinueStmt(ContinueStmt node);
    
    abstract public T visitExprStmt(ExprStmt node);
    
    abstract public T visitIfStmt(IfStmt node);
    
    abstract public T visitLoopStmt(LoopStmt node);
    
    abstract public T visitReturnStmt(ReturnStmt node);
    
    abstract public T visitVarDeclStmt(VarDeclStmt node);
    
    abstract public T visitTryStmt(TryStmt node);
    
    abstract public T visitCatchStmt(CatchStmt node);
    
    abstract public T visitThrowStmt(ThrowStmt node);
    
    abstract public T visitAssignExpr(AssignExpr node);
    
    abstract public T visitBinaryExpr(BinaryExpr node);
    
    abstract public T visitConstExpr(ConstExpr node);
    
    abstract public T visitElementExpr(ElementExpr node);
    
    abstract public T visitFieldExpr(FieldExpr node);
    
    abstract public T visitInvocationExpr(InvocationExpr node);
    
    abstract public T visitUnaryExpr(UnaryExpr node);
    
    abstract public T visitVarExpr(VarExpr node);
    
    abstract public T visitClassExpr(ClassExpr node);
    
    abstract public T visitNewExpr(NewExpr node);
    
    abstract public T visitParameterExpr(ParameterExpr node);
    
    abstract public T visitCastExpr(CastExpr node);
    
    abstract public T visitPrimitiveCastExpr(PrimitiveCastExpr node);
    
    abstract public T visitNewArrayExpr(NewArrayExpr node);
    
    abstract public T visitKeyExpr(KeyExpr node);
    
    abstract public T visitMultiStmtExpr(MultiStmtExpr node);
    
    public T visit(AstNode node){
        
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
        
        if(node instanceof CatchStmt){
            return visitCatchStmt((CatchStmt)node);
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
        
        if(node instanceof ClassExpr){
            return visitClassExpr((ClassExpr)node);
        }
        
        if(node instanceof NewExpr){
            return visitNewExpr((NewExpr)node);
        }
        
        if(node instanceof ParameterExpr){
            return visitParameterExpr((ParameterExpr)node);
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
        
        if(node instanceof KeyExpr){
            return visitKeyExpr((KeyExpr)node);
        }
        
        if(node instanceof MultiStmtExpr){
            return visitMultiStmtExpr((MultiStmtExpr)node);
        }
        
        return null;
    }
    
    public List<T> visitAll(List<?  extends AstNode> nodes){
        if(nodes==null) return null;
        List<T> result = new LinkedList();
        for(AstNode n:nodes){
            result.add(visit(n));
        }
        return result;
    }
    
    public Map<AstNode,T> visitChildren(AstNode node){
        Map<AstNode,T> result = new HashMap();
        List<AstNode> children = node.getChildren();
        for(AstNode c:children){
            result.put(c,visit(c));
        }
        return result;
    }
}
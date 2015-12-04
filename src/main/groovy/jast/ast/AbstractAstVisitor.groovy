package jast.ast;

public abstract class AbstractAstVisitor<T> implements IAstVisitor<T>{
    
    abstract public T visitClassNode(ClassNode node);
    
    abstract public T visitFieldNode(FieldNode node);
    
    abstract public T visitMethodNode(MethodNode node);
    
    abstract public T visitParameterNode(ParameterNode node);
    
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
    
    abstract public T visitNewArrayExpr(NewArrayExpr node);
    
    public T visit(AstNode node){
        
        if(node instanceof ClassNode){
            return visitClassNode(node);
        }
        
        if(node instanceof FieldNode){
            return visitFieldNode(node);
        }
        
        if(node instanceof MethodNode){
            return visitMethodNode(node);
        }
        
        if(node instanceof ParameterNode){
            return visitParameterNode(node);
        }
        
        if(node instanceof BlockStmt){
            return visitBlockStmt(node);
        }
        
        if(node instanceof BreakStmt){
            return visitBreakStmt(node);
        }
        
        if(node instanceof ContinueStmt){
            return visitContinueStmt(node);
        }
        
        if(node instanceof ExprStmt){
            return visitExprStmt(node);
        }
        
        if(node instanceof IfStmt){
            return visitIfStmt(node);
        }
        
        if(node instanceof LoopStmt){
            return visitLoopStmt(node);
        }
        
        if(node instanceof ReturnStmt){
            return visitReturnStmt(node);
        }
        
        if(node instanceof VarDeclStmt){
            return visitVarDeclStmt(node);
        }
        
        if(node instanceof TryStmt){
            return visitTryStmt(node);
        }
        
        if(node instanceof CatchStmt){
            return visitCatchStmt(node);
        }
        
        if(node instanceof AssignExpr){
            return visitAssignExpr(node);
        }
        
        if(node instanceof BinaryExpr){
            return visitBinaryExpr(node);
        }
        
        if(node instanceof ConstExpr){
            return visitConstExpr(node);
        }
        
        if(node instanceof ElementExpr){
            return visitElementExpr(node);
        }
        
        if(node instanceof FieldExpr){
            return visitFieldExpr(node);
        }
        
        if(node instanceof InvocationExpr){
            return visitInvocationExpr(node);
        }
        
        if(node instanceof UnaryExpr){
            return visitUnaryExpr(node);
        }
        
        if(node instanceof VarExpr){
            return visitVarExpr(node);
        }
        
        if(node instanceof ClassExpr){
            return visitClassExpr(node);
        }
        
        if(node instanceof NewExpr){
            return visitNewExpr(node);
        }
        
        if(node instanceof ParameterExpr){
            return visitParameterExpr(node);
        }
        
        if(node instanceof CastExpr){
            return visitCastExpr(node);
        }
        
        if(node instanceof NewArrayExpr){
            return visitNewArrayExpr(node);
        }
        
    }
    
    public List<T> visit(List nodes){
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
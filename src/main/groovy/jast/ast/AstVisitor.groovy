package jast.ast;

public class AstVisitor<T> extends AbstractAstVisitor<T> implements IAstVisitor<T>{
    
    @Override
    public T visitClassNode(ClassNode node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitFieldNode(FieldNode node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitMethodNode(MethodNode node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitParameterNode(ParameterNode node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitBlockStmt(BlockStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitBreakStmt(BreakStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitContinueStmt(ContinueStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitExprStmt(ExprStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitIfStmt(IfStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitLoopStmt(LoopStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitReturnStmt(ReturnStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitVarDeclStmt(VarDeclStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitTryStmt(TryStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitCatchStmt(CatchStmt node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitAssignExpr(AssignExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitBinaryExpr(BinaryExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitConstExpr(ConstExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitElementExpr(ElementExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitFieldExpr(FieldExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitInvocationExpr(InvocationExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitUnaryExpr(UnaryExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitVarExpr(VarExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitClassExpr(ClassExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitNewExpr(NewExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitParameterExpr(ParameterExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitCastExpr(CastExpr node){
        this.visitChildren(node);
    }
    
    @Override
    public T visitNewArrayExpr(NewArrayExpr node){
        this.visitChildren(node);
    }
    
}
package kalang.ast;

public class AstVisitor<T> extends AbstractAstVisitor<T> implements IAstVisitor<T>{
    
    @Override
    public T visitClassNode(ClassNode node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitMethodNode(MethodNode node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitBlockStmt(BlockStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitBreakStmt(BreakStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitContinueStmt(ContinueStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitExprStmt(ExprStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitIfStmt(IfStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitLoopStmt(LoopStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitReturnStmt(ReturnStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitVarDeclStmt(VarDeclStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitTryStmt(TryStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitCatchStmt(CatchStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitThrowStmt(ThrowStmt node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitAssignExpr(AssignExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitBinaryExpr(BinaryExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitConstExpr(ConstExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitElementExpr(ElementExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitFieldExpr(FieldExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitInvocationExpr(InvocationExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitUnaryExpr(UnaryExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitVarExpr(VarExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitClassExpr(ClassExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitParameterExpr(ParameterExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitCastExpr(CastExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitPrimitiveCastExpr(PrimitiveCastExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitNewArrayExpr(NewArrayExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitKeyExpr(KeyExpr node){
        this.visitChildren(node);
        return null;
    }
    
    @Override
    public T visitMultiStmtExpr(MultiStmtExpr node){
        this.visitChildren(node);
        return null;
    }

    @Override
    public T visitLocalVarNode(LocalVarNode localVarNode) {
        this.visitChildren(localVarNode);
        return null;
    }

    @Override
    public T visitParameterNode(ParameterNode parameterNode) {
        this.visitChildren(parameterNode);
        return null;
    }

    @Override
    public T visitFieldNode(FieldNode fieldNode) {
        this.visitChildren(fieldNode);
        return null;
    }
    
}
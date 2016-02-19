package kalang.ast;
public interface IAstVisitor<T>{
    
    public T visitClassNode(ClassNode node);
    
    public T visitMethodNode(MethodNode node);
    
    public T visitBlockStmt(BlockStmt node);
    
    public T visitBreakStmt(BreakStmt node);
    
    public T visitContinueStmt(ContinueStmt node);
    
    public T visitExprStmt(ExprStmt node);
    
    public T visitIfStmt(IfStmt node);
    
    public T visitLoopStmt(LoopStmt node);
    
    public T visitReturnStmt(ReturnStmt node);
    
    public T visitVarDeclStmt(VarDeclStmt node);
    
    public T visitTryStmt(TryStmt node);
    
    public T visitCatchStmt(CatchStmt node);
    
    public T visitThrowStmt(ThrowStmt node);
    
    public T visitAssignExpr(AssignExpr node);
    
    public T visitBinaryExpr(BinaryExpr node);
    
    public T visitConstExpr(ConstExpr node);
    
    public T visitElementExpr(ElementExpr node);
    
    public T visitFieldExpr(FieldExpr node);
    
    public T visitInvocationExpr(InvocationExpr node);
    
    public T visitUnaryExpr(UnaryExpr node);
    
    public T visitVarExpr(VarExpr node);
    
    public T visitClassExpr(ClassExpr node);
    
    public T visitParameterExpr(ParameterExpr node);
    
    public T visitCastExpr(CastExpr node);
    
    public T visitPrimitiveCastExpr(PrimitiveCastExpr node);
    
    public T visitNewArrayExpr(NewArrayExpr node);
    
    public T visitKeyExpr(KeyExpr node);
    
    public T visitMultiStmtExpr(MultiStmtExpr node);
    
    public T visitLocalVarNode(LocalVarNode localVarNode);

    public T visitParameterNode(ParameterNode parameterNode);

    public T visitFieldNode(FieldNode fieldNode);
    
}
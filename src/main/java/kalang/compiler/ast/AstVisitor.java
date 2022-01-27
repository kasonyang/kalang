package kalang.compiler.ast;

public class AstVisitor<T> extends AbstractAstVisitor<T>{
    
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
    public T visitCatchBlock(CatchBlock node){
        this.visitChildren(node);
        return null;
    }

    @Override
    public T visitFinallyBlock(FinallyBlock node) {
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
    public T visitThisExpr(ThisExpr node){
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

    @Override
    public T visitNewObjectExpr(NewObjectExpr node) {
        this.visitChildren(node);
        return null;
    }

    @Override
    public T visitArrayLengthExpr(ArrayLengthExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitUnknownFieldExpr(UnknownFieldExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitUnknownInvocationExpr(UnknownInvocationExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitClassReference(ClassReference node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitSuperExpr(SuperExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitErrorousExpr(ErrorousExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitInstanceOfExpr(InstanceOfExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitMultiStmt(MultiStmt node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitLambdaExpr(LambdaExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitIncExpr(IncExpr node) {
        visitChildren(node);
        return null;
    }

    @Override
    public T visitYieldStmt(YieldStmt node) {
        visitChildren(node);
        return null;
    }


}
package kalang.compiler.ast;

import kalang.compiler.function.LambdaExpr;

public interface IAstVisitor<T> {

    T visitInstanceOfExpr(InstanceOfExpr node);

    T visitErrorousExpr(ErrorousExpr node);

    T visitSuperExpr(SuperExpr node);

    T visitClassReference(ClassReference node);

    T visitArrayLengthExpr(ArrayLengthExpr node);

    T visitUnknownFieldExpr(UnknownFieldExpr node);

    T visitUnknownInvocationExpr(UnknownInvocationExpr node);

    T visitClassNode(ClassNode node);

    T visitMethodNode(MethodNode node);

    T visitBlockStmt(BlockStmt node);

    T visitBreakStmt(BreakStmt node);

    T visitContinueStmt(ContinueStmt node);

    T visitExprStmt(ExprStmt node);

    T visitIfStmt(IfStmt node);

    T visitLoopStmt(LoopStmt node);

    T visitReturnStmt(ReturnStmt node);

    T visitVarDeclStmt(VarDeclStmt node);

    T visitTryStmt(TryStmt node);

    T visitCatchBlock(CatchBlock node);

    T visitThrowStmt(ThrowStmt node);

    T visitAssignExpr(AssignExpr node);

    T visitBinaryExpr(BinaryExpr node);

    T visitConstExpr(ConstExpr node);

    T visitElementExpr(ElementExpr node);

    T visitFieldExpr(FieldExpr node);

    T visitInvocationExpr(InvocationExpr node);

    T visitUnaryExpr(UnaryExpr node);

    T visitVarExpr(VarExpr node);

    T visitParameterExpr(ParameterExpr node);

    T visitCastExpr(CastExpr node);

    T visitPrimitiveCastExpr(PrimitiveCastExpr node);

    T visitNewArrayExpr(NewArrayExpr node);

    T visitThisExpr(ThisExpr node);

    T visitMultiStmtExpr(MultiStmtExpr node);

    T visitLocalVarNode(LocalVarNode localVarNode);

    T visitParameterNode(ParameterNode node);

    T visitFieldNode(FieldNode fieldNode);

    T visitNewObjectExpr(NewObjectExpr node);

    T visitMultiStmt(MultiStmt node);

    T visitLambdaExpr(LambdaExpr node);

}
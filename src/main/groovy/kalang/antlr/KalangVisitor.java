// Generated from Kalang.g4 by ANTLR 4.5.1
package kalang.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KalangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KalangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KalangParser#compiliantUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompiliantUnit(KalangParser.CompiliantUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(KalangParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(KalangParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(KalangParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(KalangParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(KalangParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KalangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#noArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArrayType(KalangParser.NoArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#varDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecls(KalangParser.VarDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(KalangParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(KalangParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(KalangParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#tryStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStat(KalangParser.TryStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(KalangParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#postIfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIfStmt(KalangParser.PostIfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#varDeclStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(KalangParser.VarDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(KalangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#breakStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(KalangParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#continueStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(KalangParser.ContinueStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(KalangParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#doWhileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStat(KalangParser.DoWhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#forStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(KalangParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(KalangParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#exprStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(KalangParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(KalangParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(KalangParser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMemberInvocation(KalangParser.ExprMemberInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIdentifier}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdentifier(KalangParser.ExprIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapExpr(KalangParser.MapExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMidOp(KalangParser.ExprMidOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(KalangParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listOrArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListOrArrayExpr(KalangParser.ListOrArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInvocation(KalangParser.ExprInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfRef}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfRef(KalangParser.ExprSelfRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(KalangParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParen(KalangParser.ExprParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetField(KalangParser.ExprGetFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfOp(KalangParser.ExprSelfOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprQuestion}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprQuestion(KalangParser.ExprQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfOpPre(KalangParser.ExprSelfOpPreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetArrayElement(KalangParser.ExprGetArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNewArray}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNewArray(KalangParser.ExprNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(KalangParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#listOrArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListOrArray(KalangParser.ListOrArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(KalangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(KalangParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#varModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarModifier(KalangParser.VarModifierContext ctx);
}
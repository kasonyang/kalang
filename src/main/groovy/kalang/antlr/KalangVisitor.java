// Generated from Kalang.g4 by ANTLR 4.5
package kalang.antlr;
import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link KalangParser#importDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclList(KalangParser.ImportDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(KalangParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#importPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportPath(KalangParser.ImportPathContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#fieldDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclList(KalangParser.FieldDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(KalangParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#setter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetter(KalangParser.SetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#getter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetter(KalangParser.GetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#methodDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclList(KalangParser.MethodDeclListContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#argumentDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentDeclList(KalangParser.ArgumentDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#argumentDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentDecl(KalangParser.ArgumentDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(KalangParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(KalangParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatSuffix(KalangParser.IfStatSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(KalangParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(KalangParser.ReturnStatContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#varInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInit(KalangParser.VarInitContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(KalangParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(KalangParser.ForUpdateContext ctx);
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
	 * Visit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimay(KalangParser.ExprPrimayContext ctx);
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
	 * Visit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimayParen(KalangParser.PrimayParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(KalangParser.PrimaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryIdentifier(KalangParser.PrimaryIdentifierContext ctx);
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
}
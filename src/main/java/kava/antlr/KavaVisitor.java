// Generated from Kava.g4 by ANTLR 4.5
package kava.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KavaParser#dslStatList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslStatList(KavaParser.DslStatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#dslStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslStat(KavaParser.DslStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslVarDecl(KavaParser.DslVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslVarNew(KavaParser.DslVarNewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslExpression(KavaParser.DslExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslChainStat(KavaParser.DslChainStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#dslParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslParam(KavaParser.DslParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(KavaParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#compiliantUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompiliantUnit(KavaParser.CompiliantUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(KavaParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#methodDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclList(KavaParser.MethodDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(KavaParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(KavaParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(KavaParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatSuffix(KavaParser.IfStatSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(KavaParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#varDeclStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(KavaParser.VarDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(KavaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#breakStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(KavaParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#continueStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(KavaParser.ContinueStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(KavaParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#doWhileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStat(KavaParser.DoWhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#forStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(KavaParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(KavaParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(KavaParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(KavaParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#exprStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(KavaParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimay(KavaParser.ExprPrimayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNotOp(KavaParser.ExprNotOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetField(KavaParser.ExprGetFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssign(KavaParser.ArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogicCmp(KavaParser.ExprLogicCmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(KavaParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMidOp(KavaParser.ExprMidOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfOp(KavaParser.ExprSelfOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInvocation(KavaParser.ExprInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogic(KavaParser.ExprLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfOpPre(KavaParser.ExprSelfOpPreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetArrayElement(KavaParser.ExprGetArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#offset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffset(KavaParser.OffsetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimayParen(KavaParser.PrimayParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(KavaParser.PrimaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryIdentifier(KavaParser.PrimaryIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(KavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#genericInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericInvocation(KavaParser.GenericInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(KavaParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KavaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(KavaParser.ArgumentListContext ctx);
}
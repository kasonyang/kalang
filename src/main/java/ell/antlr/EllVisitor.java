// Generated from Ell.g4 by ANTLR 4.5
package ell.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EllParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EllVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EllParser#dslStatList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslStatList(EllParser.DslStatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#dslStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslStat(EllParser.DslStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslVarDecl(EllParser.DslVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslVarNew(EllParser.DslVarNewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslExpression(EllParser.DslExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslChainStat(EllParser.DslChainStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramNamed}
	 * labeled alternative in {@link EllParser#dslParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamNamed(EllParser.ParamNamedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramOrdered}
	 * labeled alternative in {@link EllParser#dslParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamOrdered(EllParser.ParamOrderedContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#dslParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslParam(EllParser.DslParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(EllParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#compiliantUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompiliantUnit(EllParser.CompiliantUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(EllParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#methodDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclList(EllParser.MethodDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(EllParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(EllParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#argumentDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentDeclList(EllParser.ArgumentDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#argumentDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentDecl(EllParser.ArgumentDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(EllParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(EllParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatSuffix(EllParser.IfStatSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(EllParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(EllParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#varDeclStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(EllParser.VarDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(EllParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#breakStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(EllParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#continueStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(EllParser.ContinueStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(EllParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#doWhileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStat(EllParser.DoWhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#forStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(EllParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(EllParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(EllParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(EllParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#exprStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(EllParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimay(EllParser.ExprPrimayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssign(EllParser.ArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMemberInvocation(EllParser.ExprMemberInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(EllParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMidOp(EllParser.ExprMidOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInvocation(EllParser.ExprInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNotOp(EllParser.ExprNotOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetField(EllParser.ExprGetFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogicCmp(EllParser.ExprLogicCmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfOp(EllParser.ExprSelfOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogic(EllParser.ExprLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSelfOpPre(EllParser.ExprSelfOpPreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetArrayElement(EllParser.ExprGetArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#offset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffset(EllParser.OffsetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimayParen(EllParser.PrimayParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(EllParser.PrimaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryIdentifier(EllParser.PrimaryIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(EllParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(EllParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(EllParser.ArgumentListContext ctx);
}
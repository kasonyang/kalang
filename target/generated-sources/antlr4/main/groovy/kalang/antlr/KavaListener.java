// Generated from Kava.g4 by ANTLR 4.4
package main.groovy.kalang.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KavaParser}.
 */
public interface KavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KavaParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStat(@NotNull KavaParser.DoWhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStat(@NotNull KavaParser.DoWhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(@NotNull KavaParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(@NotNull KavaParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(@NotNull KavaParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(@NotNull KavaParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInvocation(@NotNull KavaParser.ExprInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInvocation(@NotNull KavaParser.ExprInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull KavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull KavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(@NotNull KavaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(@NotNull KavaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#dslParam}.
	 * @param ctx the parse tree
	 */
	void enterDslParam(@NotNull KavaParser.DslParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#dslParam}.
	 * @param ctx the parse tree
	 */
	void exitDslParam(@NotNull KavaParser.DslParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(@NotNull KavaParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(@NotNull KavaParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(@NotNull KavaParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(@NotNull KavaParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetArrayElement(@NotNull KavaParser.ExprGetArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetArrayElement(@NotNull KavaParser.ExprGetArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull KavaParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull KavaParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(@NotNull KavaParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(@NotNull KavaParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimay(@NotNull KavaParser.ExprPrimayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimay(@NotNull KavaParser.ExprPrimayContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#offset}.
	 * @param ctx the parse tree
	 */
	void enterOffset(@NotNull KavaParser.OffsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#offset}.
	 * @param ctx the parse tree
	 */
	void exitOffset(@NotNull KavaParser.OffsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(@NotNull KavaParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(@NotNull KavaParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(@NotNull KavaParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(@NotNull KavaParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryIdentifier(@NotNull KavaParser.PrimaryIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryIdentifier(@NotNull KavaParser.PrimaryIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(@NotNull KavaParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(@NotNull KavaParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclList(@NotNull KavaParser.MethodDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclList(@NotNull KavaParser.MethodDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull KavaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull KavaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryLiteral(@NotNull KavaParser.PrimaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryLiteral(@NotNull KavaParser.PrimaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslVarDecl(@NotNull KavaParser.DslVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslVarDecl(@NotNull KavaParser.DslVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslVarNew(@NotNull KavaParser.DslVarNewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslVarNew(@NotNull KavaParser.DslVarNewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(@NotNull KavaParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(@NotNull KavaParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMemberInvocation(@NotNull KavaParser.ExprMemberInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMemberInvocation(@NotNull KavaParser.ExprMemberInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(@NotNull KavaParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(@NotNull KavaParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(@NotNull KavaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(@NotNull KavaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimayParen(@NotNull KavaParser.PrimayParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimayParen(@NotNull KavaParser.PrimayParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull KavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull KavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNotOp(@NotNull KavaParser.ExprNotOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNotOp(@NotNull KavaParser.ExprNotOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogicCmp(@NotNull KavaParser.ExprLogicCmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogicCmp(@NotNull KavaParser.ExprLogicCmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull KavaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull KavaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOp(@NotNull KavaParser.ExprSelfOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOp(@NotNull KavaParser.ExprSelfOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogic(@NotNull KavaParser.ExprLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogic(@NotNull KavaParser.ExprLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOpPre(@NotNull KavaParser.ExprSelfOpPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOpPre(@NotNull KavaParser.ExprSelfOpPreContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull KavaParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull KavaParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull KavaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull KavaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslChainStat(@NotNull KavaParser.DslChainStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslChainStat(@NotNull KavaParser.DslChainStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull KavaParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull KavaParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompiliantUnit(@NotNull KavaParser.CompiliantUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompiliantUnit(@NotNull KavaParser.CompiliantUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMidOp(@NotNull KavaParser.ExprMidOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMidOp(@NotNull KavaParser.ExprMidOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDecl(@NotNull KavaParser.ArgumentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDecl(@NotNull KavaParser.ArgumentDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslExpression(@NotNull KavaParser.DslExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslExpression(@NotNull KavaParser.DslExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetField(@NotNull KavaParser.ExprGetFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetField(@NotNull KavaParser.ExprGetFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#dslStat}.
	 * @param ctx the parse tree
	 */
	void enterDslStat(@NotNull KavaParser.DslStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#dslStat}.
	 * @param ctx the parse tree
	 */
	void exitDslStat(@NotNull KavaParser.DslStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDeclList(@NotNull KavaParser.ArgumentDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDeclList(@NotNull KavaParser.ArgumentDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIfStatSuffix(@NotNull KavaParser.IfStatSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIfStatSuffix(@NotNull KavaParser.IfStatSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(@NotNull KavaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(@NotNull KavaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull KavaParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull KavaParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#dslStatList}.
	 * @param ctx the parse tree
	 */
	void enterDslStatList(@NotNull KavaParser.DslStatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#dslStatList}.
	 * @param ctx the parse tree
	 */
	void exitDslStatList(@NotNull KavaParser.DslStatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull KavaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull KavaParser.VarDeclContext ctx);
}
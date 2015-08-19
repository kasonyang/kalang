// Generated from Ell.g4 by ANTLR 4.5
package ell.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EllParser}.
 */
public interface EllListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EllParser#dslStatList}.
	 * @param ctx the parse tree
	 */
	void enterDslStatList(EllParser.DslStatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#dslStatList}.
	 * @param ctx the parse tree
	 */
	void exitDslStatList(EllParser.DslStatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#dslStat}.
	 * @param ctx the parse tree
	 */
	void enterDslStat(EllParser.DslStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#dslStat}.
	 * @param ctx the parse tree
	 */
	void exitDslStat(EllParser.DslStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslVarDecl(EllParser.DslVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslVarDecl(EllParser.DslVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslVarNew(EllParser.DslVarNewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslVarNew(EllParser.DslVarNewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslExpression(EllParser.DslExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslExpression(EllParser.DslExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslChainStat(EllParser.DslChainStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link EllParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslChainStat(EllParser.DslChainStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramNamed}
	 * labeled alternative in {@link EllParser#dslParamList}.
	 * @param ctx the parse tree
	 */
	void enterParamNamed(EllParser.ParamNamedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramNamed}
	 * labeled alternative in {@link EllParser#dslParamList}.
	 * @param ctx the parse tree
	 */
	void exitParamNamed(EllParser.ParamNamedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramOrdered}
	 * labeled alternative in {@link EllParser#dslParamList}.
	 * @param ctx the parse tree
	 */
	void enterParamOrdered(EllParser.ParamOrderedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramOrdered}
	 * labeled alternative in {@link EllParser#dslParamList}.
	 * @param ctx the parse tree
	 */
	void exitParamOrdered(EllParser.ParamOrderedContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#dslParam}.
	 * @param ctx the parse tree
	 */
	void enterDslParam(EllParser.DslParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#dslParam}.
	 * @param ctx the parse tree
	 */
	void exitDslParam(EllParser.DslParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(EllParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(EllParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompiliantUnit(EllParser.CompiliantUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompiliantUnit(EllParser.CompiliantUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(EllParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(EllParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclList(EllParser.MethodDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclList(EllParser.MethodDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(EllParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(EllParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(EllParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(EllParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDeclList(EllParser.ArgumentDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDeclList(EllParser.ArgumentDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDecl(EllParser.ArgumentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDecl(EllParser.ArgumentDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(EllParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(EllParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(EllParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(EllParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIfStatSuffix(EllParser.IfStatSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIfStatSuffix(EllParser.IfStatSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(EllParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(EllParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(EllParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(EllParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(EllParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(EllParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(EllParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(EllParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(EllParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(EllParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(EllParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(EllParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(EllParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(EllParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStat(EllParser.DoWhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStat(EllParser.DoWhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(EllParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(EllParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(EllParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(EllParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(EllParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(EllParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(EllParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(EllParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(EllParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(EllParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimay(EllParser.ExprPrimayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimay(EllParser.ExprPrimayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(EllParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(EllParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMemberInvocation(EllParser.ExprMemberInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMemberInvocation(EllParser.ExprMemberInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(EllParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(EllParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMidOp(EllParser.ExprMidOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMidOp(EllParser.ExprMidOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInvocation(EllParser.ExprInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInvocation(EllParser.ExprInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNotOp(EllParser.ExprNotOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNotOp(EllParser.ExprNotOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetField(EllParser.ExprGetFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetField(EllParser.ExprGetFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogicCmp(EllParser.ExprLogicCmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogicCmp(EllParser.ExprLogicCmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOp(EllParser.ExprSelfOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOp(EllParser.ExprSelfOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogic(EllParser.ExprLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogic(EllParser.ExprLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOpPre(EllParser.ExprSelfOpPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOpPre(EllParser.ExprSelfOpPreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetArrayElement(EllParser.ExprGetArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetArrayElement(EllParser.ExprGetArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#offset}.
	 * @param ctx the parse tree
	 */
	void enterOffset(EllParser.OffsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#offset}.
	 * @param ctx the parse tree
	 */
	void exitOffset(EllParser.OffsetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimayParen(EllParser.PrimayParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimayParen(EllParser.PrimayParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryLiteral(EllParser.PrimaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryLiteral(EllParser.PrimaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryIdentifier(EllParser.PrimaryIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryIdentifier(EllParser.PrimaryIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(EllParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(EllParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(EllParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(EllParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(EllParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(EllParser.ArgumentListContext ctx);
}
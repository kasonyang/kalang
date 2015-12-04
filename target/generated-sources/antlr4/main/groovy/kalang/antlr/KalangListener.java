// Generated from Kalang.g4 by ANTLR 4.4
package main.groovy.kalang.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KalangParser}.
 */
public interface KalangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KalangParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStat(@NotNull KalangParser.DoWhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStat(@NotNull KalangParser.DoWhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#getter}.
	 * @param ctx the parse tree
	 */
	void enterGetter(@NotNull KalangParser.GetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#getter}.
	 * @param ctx the parse tree
	 */
	void exitGetter(@NotNull KalangParser.GetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(@NotNull KalangParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(@NotNull KalangParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#tryStat}.
	 * @param ctx the parse tree
	 */
	void enterTryStat(@NotNull KalangParser.TryStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#tryStat}.
	 * @param ctx the parse tree
	 */
	void exitTryStat(@NotNull KalangParser.TryStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#listOrArray}.
	 * @param ctx the parse tree
	 */
	void enterListOrArray(@NotNull KalangParser.ListOrArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#listOrArray}.
	 * @param ctx the parse tree
	 */
	void exitListOrArray(@NotNull KalangParser.ListOrArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(@NotNull KalangParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(@NotNull KalangParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInvocation(@NotNull KalangParser.ExprInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInvocation(@NotNull KalangParser.ExprInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull KalangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull KalangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(@NotNull KalangParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(@NotNull KalangParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(@NotNull KalangParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(@NotNull KalangParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetArrayElement(@NotNull KalangParser.ExprGetArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetArrayElement(@NotNull KalangParser.ExprGetArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNewArray}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNewArray(@NotNull KalangParser.ExprNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNewArray}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNewArray(@NotNull KalangParser.ExprNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull KalangParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull KalangParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(@NotNull KalangParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(@NotNull KalangParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimay(@NotNull KalangParser.ExprPrimayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimay(@NotNull KalangParser.ExprPrimayContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull KalangParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull KalangParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(@NotNull KalangParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(@NotNull KalangParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(@NotNull KalangParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(@NotNull KalangParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#importDeclList}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclList(@NotNull KalangParser.ImportDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#importDeclList}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclList(@NotNull KalangParser.ImportDeclListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMapExpr(@NotNull KalangParser.MapExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMapExpr(@NotNull KalangParser.MapExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#fieldDeclList}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclList(@NotNull KalangParser.FieldDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#fieldDeclList}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclList(@NotNull KalangParser.FieldDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(@NotNull KalangParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(@NotNull KalangParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryIdentifier(@NotNull KalangParser.PrimaryIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryIdentifier(@NotNull KalangParser.PrimaryIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(@NotNull KalangParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(@NotNull KalangParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(@NotNull KalangParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(@NotNull KalangParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclList(@NotNull KalangParser.MethodDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclList(@NotNull KalangParser.MethodDeclListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprQuestion}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprQuestion(@NotNull KalangParser.ExprQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprQuestion}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprQuestion(@NotNull KalangParser.ExprQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryLiteral(@NotNull KalangParser.PrimaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryLiteral(@NotNull KalangParser.PrimaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(@NotNull KalangParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(@NotNull KalangParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(@NotNull KalangParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(@NotNull KalangParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMemberInvocation(@NotNull KalangParser.ExprMemberInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMemberInvocation(@NotNull KalangParser.ExprMemberInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(@NotNull KalangParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(@NotNull KalangParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(@NotNull KalangParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(@NotNull KalangParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(@NotNull KalangParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(@NotNull KalangParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimayParen(@NotNull KalangParser.PrimayParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimayParen(@NotNull KalangParser.PrimayParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull KalangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull KalangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#noArrayType}.
	 * @param ctx the parse tree
	 */
	void enterNoArrayType(@NotNull KalangParser.NoArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#noArrayType}.
	 * @param ctx the parse tree
	 */
	void exitNoArrayType(@NotNull KalangParser.NoArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull KalangParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull KalangParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#varInit}.
	 * @param ctx the parse tree
	 */
	void enterVarInit(@NotNull KalangParser.VarInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varInit}.
	 * @param ctx the parse tree
	 */
	void exitVarInit(@NotNull KalangParser.VarInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOp(@NotNull KalangParser.ExprSelfOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOp(@NotNull KalangParser.ExprSelfOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#postIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterPostIfStmt(@NotNull KalangParser.PostIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#postIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitPostIfStmt(@NotNull KalangParser.PostIfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOpPre(@NotNull KalangParser.ExprSelfOpPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOpPre(@NotNull KalangParser.ExprSelfOpPreContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(@NotNull KalangParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(@NotNull KalangParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull KalangParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull KalangParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull KalangParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull KalangParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompiliantUnit(@NotNull KalangParser.CompiliantUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompiliantUnit(@NotNull KalangParser.CompiliantUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMidOp(@NotNull KalangParser.ExprMidOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMidOp(@NotNull KalangParser.ExprMidOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listOrArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListOrArrayExpr(@NotNull KalangParser.ListOrArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listOrArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListOrArrayExpr(@NotNull KalangParser.ListOrArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDecl(@NotNull KalangParser.ArgumentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDecl(@NotNull KalangParser.ArgumentDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetField(@NotNull KalangParser.ExprGetFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetField(@NotNull KalangParser.ExprGetFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDeclList(@NotNull KalangParser.ArgumentDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDeclList(@NotNull KalangParser.ArgumentDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIfStatSuffix(@NotNull KalangParser.IfStatSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIfStatSuffix(@NotNull KalangParser.IfStatSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(@NotNull KalangParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(@NotNull KalangParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull KalangParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull KalangParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#setter}.
	 * @param ctx the parse tree
	 */
	void enterSetter(@NotNull KalangParser.SetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#setter}.
	 * @param ctx the parse tree
	 */
	void exitSetter(@NotNull KalangParser.SetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull KalangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull KalangParser.VarDeclContext ctx);
}
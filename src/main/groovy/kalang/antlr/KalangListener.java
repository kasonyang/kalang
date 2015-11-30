// Generated from Kalang.g4 by ANTLR 4.5
package kalang.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KalangParser}.
 */
public interface KalangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KalangParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompiliantUnit(KalangParser.CompiliantUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompiliantUnit(KalangParser.CompiliantUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#importDeclList}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclList(KalangParser.ImportDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#importDeclList}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclList(KalangParser.ImportDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(KalangParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(KalangParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#importPath}.
	 * @param ctx the parse tree
	 */
	void enterImportPath(KalangParser.ImportPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#importPath}.
	 * @param ctx the parse tree
	 */
	void exitImportPath(KalangParser.ImportPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(KalangParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(KalangParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(KalangParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(KalangParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#fieldDeclList}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclList(KalangParser.FieldDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#fieldDeclList}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclList(KalangParser.FieldDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(KalangParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(KalangParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#setter}.
	 * @param ctx the parse tree
	 */
	void enterSetter(KalangParser.SetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#setter}.
	 * @param ctx the parse tree
	 */
	void exitSetter(KalangParser.SetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#getter}.
	 * @param ctx the parse tree
	 */
	void enterGetter(KalangParser.GetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#getter}.
	 * @param ctx the parse tree
	 */
	void exitGetter(KalangParser.GetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclList(KalangParser.MethodDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclList(KalangParser.MethodDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(KalangParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(KalangParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KalangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KalangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDeclList(KalangParser.ArgumentDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDeclList(KalangParser.ArgumentDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDecl(KalangParser.ArgumentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDecl(KalangParser.ArgumentDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(KalangParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(KalangParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(KalangParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(KalangParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIfStatSuffix(KalangParser.IfStatSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIfStatSuffix(KalangParser.IfStatSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(KalangParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(KalangParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(KalangParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(KalangParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(KalangParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(KalangParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(KalangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(KalangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#varInit}.
	 * @param ctx the parse tree
	 */
	void enterVarInit(KalangParser.VarInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varInit}.
	 * @param ctx the parse tree
	 */
	void exitVarInit(KalangParser.VarInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(KalangParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(KalangParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(KalangParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(KalangParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(KalangParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(KalangParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStat(KalangParser.DoWhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStat(KalangParser.DoWhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(KalangParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(KalangParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(KalangParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(KalangParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(KalangParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(KalangParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(KalangParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(KalangParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(KalangParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(KalangParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimay(KalangParser.ExprPrimayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimay(KalangParser.ExprPrimayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(KalangParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(KalangParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(KalangParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(KalangParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMemberInvocation(KalangParser.ExprMemberInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMemberInvocation(KalangParser.ExprMemberInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMapExpr(KalangParser.MapExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMapExpr(KalangParser.MapExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMidOp(KalangParser.ExprMidOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMidOp(KalangParser.ExprMidOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(KalangParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(KalangParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listOrArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListOrArrayExpr(KalangParser.ListOrArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listOrArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListOrArrayExpr(KalangParser.ListOrArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInvocation(KalangParser.ExprInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInvocation(KalangParser.ExprInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetField(KalangParser.ExprGetFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetField(KalangParser.ExprGetFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOp(KalangParser.ExprSelfOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOp(KalangParser.ExprSelfOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOpPre(KalangParser.ExprSelfOpPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOpPre(KalangParser.ExprSelfOpPreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetArrayElement(KalangParser.ExprGetArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetArrayElement(KalangParser.ExprGetArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimayParen(KalangParser.PrimayParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimayParen(KalangParser.PrimayParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryLiteral(KalangParser.PrimaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryLiteral(KalangParser.PrimaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryIdentifier(KalangParser.PrimaryIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KalangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryIdentifier(KalangParser.PrimaryIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(KalangParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(KalangParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#listOrArray}.
	 * @param ctx the parse tree
	 */
	void enterListOrArray(KalangParser.ListOrArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#listOrArray}.
	 * @param ctx the parse tree
	 */
	void exitListOrArray(KalangParser.ListOrArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(KalangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(KalangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(KalangParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(KalangParser.ArgumentsContext ctx);
}
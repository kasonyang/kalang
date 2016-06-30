// Generated from Kalang.g4 by ANTLR 4.5.1
package kalang.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KalangParser}.
 */
public interface KalangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KalangParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(KalangParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(KalangParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#scriptDef}.
	 * @param ctx the parse tree
	 */
	void enterScriptDef(KalangParser.ScriptDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#scriptDef}.
	 * @param ctx the parse tree
	 */
	void exitScriptDef(KalangParser.ScriptDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(KalangParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(KalangParser.ClassDefContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(KalangParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(KalangParser.AnnotationContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(KalangParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(KalangParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#parameterizedElementType}.
	 * @param ctx the parse tree
	 */
	void enterParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#parameterizedElementType}.
	 * @param ctx the parse tree
	 */
	void exitParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#wildcardType}.
	 * @param ctx the parse tree
	 */
	void enterWildcardType(KalangParser.WildcardTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#wildcardType}.
	 * @param ctx the parse tree
	 */
	void exitWildcardType(KalangParser.WildcardTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(KalangParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(KalangParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecl(KalangParser.LocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecl(KalangParser.LocalVarDeclContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#errorousStat}.
	 * @param ctx the parse tree
	 */
	void enterErrorousStat(KalangParser.ErrorousStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#errorousStat}.
	 * @param ctx the parse tree
	 */
	void exitErrorousStat(KalangParser.ErrorousStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#throwStat}.
	 * @param ctx the parse tree
	 */
	void enterThrowStat(KalangParser.ThrowStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#throwStat}.
	 * @param ctx the parse tree
	 */
	void exitThrowStat(KalangParser.ThrowStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(KalangParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(KalangParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#tryStat}.
	 * @param ctx the parse tree
	 */
	void enterTryStat(KalangParser.TryStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#tryStat}.
	 * @param ctx the parse tree
	 */
	void exitTryStat(KalangParser.TryStatContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#postIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterPostIfStmt(KalangParser.PostIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#postIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitPostIfStmt(KalangParser.PostIfStmtContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#forEachStat}.
	 * @param ctx the parse tree
	 */
	void enterForEachStat(KalangParser.ForEachStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#forEachStat}.
	 * @param ctx the parse tree
	 */
	void exitForEachStat(KalangParser.ForEachStatContext ctx);
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
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(KalangParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(KalangParser.ArrayExprContext ctx);
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
	 * Enter a parse tree produced by the {@code exprIdentifier}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprIdentifier(KalangParser.ExprIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIdentifier}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprIdentifier(KalangParser.ExprIdentifierContext ctx);
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
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(KalangParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(KalangParser.BinaryExprContext ctx);
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
	 * Enter a parse tree produced by the {@code exprSelfRef}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfRef(KalangParser.ExprSelfRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfRef}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfRef(KalangParser.ExprSelfRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(KalangParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(KalangParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInstanceOf}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInstanceOf(KalangParser.ExprInstanceOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInstanceOf}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInstanceOf(KalangParser.ExprInstanceOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(KalangParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(KalangParser.ExprParenContext ctx);
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
	 * Enter a parse tree produced by the {@code errorousMemberExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code errorousMemberExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(KalangParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(KalangParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInc}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInc(KalangParser.ExprIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInc}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInc(KalangParser.ExprIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprQuestion}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprQuestion(KalangParser.ExprQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprQuestion}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprQuestion(KalangParser.ExprQuestionContext ctx);
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
	 * Enter a parse tree produced by the {@code exprNewArray}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNewArray(KalangParser.ExprNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNewArray}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNewArray(KalangParser.ExprNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIncPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprIncPre(KalangParser.ExprIncPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIncPre}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprIncPre(KalangParser.ExprIncPreContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#varModifier}.
	 * @param ctx the parse tree
	 */
	void enterVarModifier(KalangParser.VarModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#varModifier}.
	 * @param ctx the parse tree
	 */
	void exitVarModifier(KalangParser.VarModifierContext ctx);
}
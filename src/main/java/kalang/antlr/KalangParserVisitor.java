// Generated from KalangParser.g4 by ANTLR 4.5.1
package kalang.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KalangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KalangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KalangParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(KalangParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#compileOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileOption(KalangParser.CompileOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#scriptDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptDef(KalangParser.ScriptDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(KalangParser.ClassDefContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(KalangParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KalangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(KalangParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#lambdaType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaType(KalangParser.LambdaTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#parameterizedElementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#wildcardType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardType(KalangParser.WildcardTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(KalangParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#localVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(KalangParser.LocalVarDeclContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#emptyStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStat(KalangParser.EmptyStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#errorousStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorousStat(KalangParser.ErrorousStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#assertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStmt(KalangParser.AssertStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#throwStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStat(KalangParser.ThrowStatContext ctx);
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
	 * Visit a parse tree produced by {@link KalangParser#forEachStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachStat(KalangParser.ForEachStatContext ctx);
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
	 * Visit a parse tree produced by the {@code invokeExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeExpr(KalangParser.InvokeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instanceofExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceofExpr(KalangParser.InstanceofExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code interpolationExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterpolationExpr(KalangParser.InterpolationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(KalangParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code incExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncExpr(KalangParser.IncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(KalangParser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapExpr(KalangParser.MapExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(KalangParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getFieldExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetFieldExpr(KalangParser.GetFieldExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitShiftExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitShiftExpr(KalangParser.BitShiftExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code questionExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionExpr(KalangParser.QuestionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(KalangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getArrayElementExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetArrayElementExpr(KalangParser.GetArrayElementExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preIncExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncExpr(KalangParser.PreIncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code errorousMemberExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(KalangParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(KalangParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(KalangParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberInvocationExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberInvocationExpr(KalangParser.MemberInvocationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(KalangParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExpr(KalangParser.NewArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfRefExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRefExpr(KalangParser.SelfRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(KalangParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(KalangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KalangParser#varModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarModifier(KalangParser.VarModifierContext ctx);
}
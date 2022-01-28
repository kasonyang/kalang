// Generated from KalangParser.g4 by ANTLR 4.7.2
package kalang.compiler.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KalangParser}.
 */
public interface KalangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KalangParser#standardCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterStandardCompilationUnit(KalangParser.StandardCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#standardCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitStandardCompilationUnit(KalangParser.StandardCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#scriptCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterScriptCompilationUnit(KalangParser.ScriptCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#scriptCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitScriptCompilationUnit(KalangParser.ScriptCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#compileOption}.
	 * @param ctx the parse tree
	 */
	void enterCompileOption(KalangParser.CompileOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#compileOption}.
	 * @param ctx the parse tree
	 */
	void exitCompileOption(KalangParser.CompileOptionContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void enterParamDecl(KalangParser.ParamDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void exitParamDecl(KalangParser.ParamDeclContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#lambdaType}.
	 * @param ctx the parse tree
	 */
	void enterLambdaType(KalangParser.LambdaTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#lambdaType}.
	 * @param ctx the parse tree
	 */
	void exitLambdaType(KalangParser.LambdaTypeContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(KalangParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(KalangParser.TypeParameterContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#destructuringLocalVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterDestructuringLocalVarDecl(KalangParser.DestructuringLocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#destructuringLocalVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitDestructuringLocalVarDecl(KalangParser.DestructuringLocalVarDeclContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#unterminatedStmt}.
	 * @param ctx the parse tree
	 */
	void enterUnterminatedStmt(KalangParser.UnterminatedStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#unterminatedStmt}.
	 * @param ctx the parse tree
	 */
	void exitUnterminatedStmt(KalangParser.UnterminatedStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#emptyStat}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(KalangParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#emptyStat}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(KalangParser.EmptyStatContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssertStmt(KalangParser.AssertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssertStmt(KalangParser.AssertStmtContext ctx);
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
	 * Enter a parse tree produced by {@link KalangParser#yieldStat}.
	 * @param ctx the parse tree
	 */
	void enterYieldStat(KalangParser.YieldStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#yieldStat}.
	 * @param ctx the parse tree
	 */
	void exitYieldStat(KalangParser.YieldStatContext ctx);
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
	 * Enter a parse tree produced by the {@code instanceofExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInstanceofExpr(KalangParser.InstanceofExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instanceofExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInstanceofExpr(KalangParser.InstanceofExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code interpolationExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInterpolationExpr(KalangParser.InterpolationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code interpolationExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInterpolationExpr(KalangParser.InterpolationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code incExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIncExpr(KalangParser.IncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code incExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIncExpr(KalangParser.IncExprContext ctx);
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
	 * Enter a parse tree produced by the {@code methodRefExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodRefExpr(KalangParser.MethodRefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodRefExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodRefExpr(KalangParser.MethodRefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getFieldExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGetFieldExpr(KalangParser.GetFieldExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getFieldExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGetFieldExpr(KalangParser.GetFieldExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitShiftExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitShiftExpr(KalangParser.BitShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitShiftExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitShiftExpr(KalangParser.BitShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code questionExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterQuestionExpr(KalangParser.QuestionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code questionExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitQuestionExpr(KalangParser.QuestionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(KalangParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(KalangParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structuringNewExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStructuringNewExpr(KalangParser.StructuringNewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structuringNewExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStructuringNewExpr(KalangParser.StructuringNewExprContext ctx);
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
	 * Enter a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(KalangParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(KalangParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(KalangParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(KalangParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberInvocationExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberInvocationExpr(KalangParser.MemberInvocationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberInvocationExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberInvocationExpr(KalangParser.MemberInvocationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(KalangParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(KalangParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpr(KalangParser.NewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpr(KalangParser.NewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfRefExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSelfRefExpr(KalangParser.SelfRefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfRefExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSelfRefExpr(KalangParser.SelfRefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invokeExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInvokeExpr(KalangParser.InvokeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invokeExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInvokeExpr(KalangParser.InvokeExprContext ctx);
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
	 * Enter a parse tree produced by the {@code awaitExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAwaitExpr(KalangParser.AwaitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code awaitExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAwaitExpr(KalangParser.AwaitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getArrayElementExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGetArrayElementExpr(KalangParser.GetArrayElementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getArrayElementExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGetArrayElementExpr(KalangParser.GetArrayElementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preIncExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncExpr(KalangParser.PreIncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preIncExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncExpr(KalangParser.PreIncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullDefaultExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullDefaultExpr(KalangParser.NullDefaultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullDefaultExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullDefaultExpr(KalangParser.NullDefaultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWithExpr(KalangParser.WithExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWithExpr(KalangParser.WithExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(KalangParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link KalangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(KalangParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KalangParser#optionalKeyValue}.
	 * @param ctx the parse tree
	 */
	void enterOptionalKeyValue(KalangParser.OptionalKeyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KalangParser#optionalKeyValue}.
	 * @param ctx the parse tree
	 */
	void exitOptionalKeyValue(KalangParser.OptionalKeyValueContext ctx);
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
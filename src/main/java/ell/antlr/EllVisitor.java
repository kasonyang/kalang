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
	 * Visit a parse tree produced by {@link EllParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(EllParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(EllParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(EllParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(EllParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(EllParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceModifier(EllParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(EllParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(EllParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(EllParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(EllParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(EllParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(EllParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#enumConstants}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstants(EllParser.EnumConstantsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(EllParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(EllParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(EllParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(EllParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(EllParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(EllParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(EllParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(EllParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(EllParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericMethodDeclaration(EllParser.GenericMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(EllParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericConstructorDeclaration(EllParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(EllParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBodyDeclaration(EllParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(EllParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(EllParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#constantDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclarator(EllParser.ConstantDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(EllParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericInterfaceMethodDeclaration(EllParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(EllParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(EllParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(EllParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(EllParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(EllParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(EllParser.EnumConstantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(EllParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(EllParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(EllParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(EllParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(EllParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedNameList(EllParser.QualifiedNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(EllParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(EllParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(EllParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(EllParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(EllParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(EllParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(EllParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(EllParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(EllParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationName(EllParser.AnnotationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#elementValuePairs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairs(EllParser.ElementValuePairsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(EllParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(EllParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(EllParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(EllParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(EllParser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(EllParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementRest(EllParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodOrConstantRest(EllParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodRest(EllParser.AnnotationMethodRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationConstantRest(EllParser.AnnotationConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(EllParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(EllParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(EllParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(EllParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(EllParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EllParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(EllParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(EllParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(EllParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(EllParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#resources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResources(EllParser.ResourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(EllParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(EllParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(EllParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(EllParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(EllParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#enhancedForControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForControl(EllParser.EnhancedForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(EllParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(EllParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(EllParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(EllParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(EllParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(EllParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(EllParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(EllParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedName(EllParser.CreatedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#innerCreator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerCreator(EllParser.InnerCreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(EllParser.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(EllParser.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocation(EllParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArguments(EllParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(EllParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArgumentsOrDiamond(EllParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#superSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperSuffix(EllParser.SuperSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocationSuffix(EllParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link EllParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(EllParser.ArgumentsContext ctx);
}
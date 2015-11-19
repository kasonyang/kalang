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
	 * Enter a parse tree produced by {@link EllParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(EllParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(EllParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(EllParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(EllParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(EllParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(EllParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(EllParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(EllParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(EllParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(EllParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(EllParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(EllParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(EllParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(EllParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(EllParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(EllParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(EllParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(EllParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(EllParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(EllParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(EllParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(EllParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(EllParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(EllParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(EllParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(EllParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(EllParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(EllParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(EllParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(EllParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(EllParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(EllParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(EllParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(EllParser.TypeListContext ctx);
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
	 * Enter a parse tree produced by {@link EllParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(EllParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(EllParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(EllParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(EllParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(EllParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(EllParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(EllParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(EllParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(EllParser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(EllParser.GenericMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(EllParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(EllParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(EllParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(EllParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(EllParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(EllParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(EllParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(EllParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(EllParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(EllParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(EllParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(EllParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(EllParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(EllParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(EllParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(EllParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(EllParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(EllParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(EllParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(EllParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(EllParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(EllParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(EllParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(EllParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(EllParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(EllParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(EllParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(EllParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(EllParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(EllParser.EnumConstantNameContext ctx);
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
	 * Enter a parse tree produced by {@link EllParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(EllParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(EllParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(EllParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(EllParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(EllParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(EllParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(EllParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(EllParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(EllParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(EllParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(EllParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(EllParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(EllParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(EllParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(EllParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(EllParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(EllParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(EllParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(EllParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(EllParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(EllParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(EllParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(EllParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(EllParser.QualifiedNameContext ctx);
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
	 * Enter a parse tree produced by {@link EllParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(EllParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(EllParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(EllParser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(EllParser.AnnotationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(EllParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(EllParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(EllParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(EllParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(EllParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(EllParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(EllParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(EllParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(EllParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(EllParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(EllParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(EllParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(EllParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(EllParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(EllParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(EllParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(EllParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(EllParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(EllParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(EllParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(EllParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(EllParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(EllParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(EllParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(EllParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(EllParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(EllParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(EllParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(EllParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(EllParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(EllParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(EllParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(EllParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(EllParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(EllParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(EllParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(EllParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(EllParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(EllParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(EllParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(EllParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(EllParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(EllParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(EllParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(EllParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(EllParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(EllParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(EllParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(EllParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(EllParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(EllParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(EllParser.ForControlContext ctx);
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
	 * Enter a parse tree produced by {@link EllParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(EllParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(EllParser.EnhancedForControlContext ctx);
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
	 * Enter a parse tree produced by {@link EllParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(EllParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(EllParser.ParExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link EllParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(EllParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(EllParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(EllParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(EllParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(EllParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(EllParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(EllParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(EllParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(EllParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(EllParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(EllParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(EllParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(EllParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(EllParser.InnerCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(EllParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(EllParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(EllParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(EllParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(EllParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(EllParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(EllParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(EllParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(EllParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(EllParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(EllParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(EllParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(EllParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(EllParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link EllParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(EllParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link EllParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(EllParser.ExplicitGenericInvocationSuffixContext ctx);
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
}
package ell.compiler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;



import ell.antlr.*;
import ell.antlr.EllParser.AnnotationConstantRestContext;
import ell.antlr.EllParser.AnnotationContext;
import ell.antlr.EllParser.AnnotationMethodOrConstantRestContext;
import ell.antlr.EllParser.AnnotationMethodRestContext;
import ell.antlr.EllParser.AnnotationNameContext;
import ell.antlr.EllParser.AnnotationTypeBodyContext;
import ell.antlr.EllParser.AnnotationTypeDeclarationContext;
import ell.antlr.EllParser.AnnotationTypeElementDeclarationContext;
import ell.antlr.EllParser.AnnotationTypeElementRestContext;
import ell.antlr.EllParser.ArgumentsContext;
import ell.antlr.EllParser.ArrayCreatorRestContext;
import ell.antlr.EllParser.ArrayInitializerContext;
import ell.antlr.EllParser.BlockContext;
import ell.antlr.EllParser.BlockStatementContext;
import ell.antlr.EllParser.CatchClauseContext;
import ell.antlr.EllParser.CatchTypeContext;
import ell.antlr.EllParser.ClassBodyContext;
import ell.antlr.EllParser.ClassBodyDeclarationContext;
import ell.antlr.EllParser.ClassCreatorRestContext;
import ell.antlr.EllParser.ClassDeclarationContext;
import ell.antlr.EllParser.ClassOrInterfaceModifierContext;
import ell.antlr.EllParser.ClassOrInterfaceTypeContext;
import ell.antlr.EllParser.CompilationUnitContext;
import ell.antlr.EllParser.ConstDeclarationContext;
import ell.antlr.EllParser.ConstantDeclaratorContext;
import ell.antlr.EllParser.ConstantExpressionContext;
import ell.antlr.EllParser.ConstructorBodyContext;
import ell.antlr.EllParser.ConstructorDeclarationContext;
import ell.antlr.EllParser.CreatedNameContext;
import ell.antlr.EllParser.CreatorContext;
import ell.antlr.EllParser.DefaultValueContext;
import ell.antlr.EllParser.ElementValueArrayInitializerContext;
import ell.antlr.EllParser.ElementValueContext;
import ell.antlr.EllParser.ElementValuePairContext;
import ell.antlr.EllParser.ElementValuePairsContext;
import ell.antlr.EllParser.EnhancedForControlContext;
import ell.antlr.EllParser.EnumBodyDeclarationsContext;
import ell.antlr.EllParser.EnumConstantContext;
import ell.antlr.EllParser.EnumConstantNameContext;
import ell.antlr.EllParser.EnumConstantsContext;
import ell.antlr.EllParser.EnumDeclarationContext;
import ell.antlr.EllParser.ExplicitGenericInvocationContext;
import ell.antlr.EllParser.ExplicitGenericInvocationSuffixContext;
import ell.antlr.EllParser.ExpressionContext;
import ell.antlr.EllParser.ExpressionListContext;
import ell.antlr.EllParser.FieldDeclarationContext;
import ell.antlr.EllParser.FinallyBlockContext;
import ell.antlr.EllParser.ForControlContext;
import ell.antlr.EllParser.ForInitContext;
import ell.antlr.EllParser.ForUpdateContext;
import ell.antlr.EllParser.FormalParameterContext;
import ell.antlr.EllParser.FormalParameterListContext;
import ell.antlr.EllParser.FormalParametersContext;
import ell.antlr.EllParser.GenericConstructorDeclarationContext;
import ell.antlr.EllParser.GenericInterfaceMethodDeclarationContext;
import ell.antlr.EllParser.GenericMethodDeclarationContext;
import ell.antlr.EllParser.ImportDeclarationContext;
import ell.antlr.EllParser.InnerCreatorContext;
import ell.antlr.EllParser.InterfaceBodyContext;
import ell.antlr.EllParser.InterfaceBodyDeclarationContext;
import ell.antlr.EllParser.InterfaceDeclarationContext;
import ell.antlr.EllParser.InterfaceMemberDeclarationContext;
import ell.antlr.EllParser.InterfaceMethodDeclarationContext;
import ell.antlr.EllParser.LastFormalParameterContext;
import ell.antlr.EllParser.LiteralContext;
import ell.antlr.EllParser.LocalVariableDeclarationContext;
import ell.antlr.EllParser.LocalVariableDeclarationStatementContext;
import ell.antlr.EllParser.MemberDeclarationContext;
import ell.antlr.EllParser.MethodBodyContext;
import ell.antlr.EllParser.MethodDeclarationContext;
import ell.antlr.EllParser.ModifierContext;
import ell.antlr.EllParser.NonWildcardTypeArgumentsContext;
import ell.antlr.EllParser.NonWildcardTypeArgumentsOrDiamondContext;
import ell.antlr.EllParser.PackageDeclarationContext;
import ell.antlr.EllParser.ParExpressionContext;
import ell.antlr.EllParser.PrimaryContext;
import ell.antlr.EllParser.PrimitiveTypeContext;
import ell.antlr.EllParser.QualifiedNameContext;
import ell.antlr.EllParser.QualifiedNameListContext;
import ell.antlr.EllParser.ResourceContext;
import ell.antlr.EllParser.ResourceSpecificationContext;
import ell.antlr.EllParser.ResourcesContext;
import ell.antlr.EllParser.StatementContext;
import ell.antlr.EllParser.StatementExpressionContext;
import ell.antlr.EllParser.SuperSuffixContext;
import ell.antlr.EllParser.SwitchBlockStatementGroupContext;
import ell.antlr.EllParser.SwitchLabelContext;
import ell.antlr.EllParser.TypeArgumentContext;
import ell.antlr.EllParser.TypeArgumentsContext;
import ell.antlr.EllParser.TypeArgumentsOrDiamondContext;
import ell.antlr.EllParser.TypeBoundContext;
import ell.antlr.EllParser.TypeContext;
import ell.antlr.EllParser.TypeDeclarationContext;
import ell.antlr.EllParser.TypeListContext;
import ell.antlr.EllParser.TypeParameterContext;
import ell.antlr.EllParser.TypeParametersContext;
import ell.antlr.EllParser.VariableDeclaratorContext;
import ell.antlr.EllParser.VariableDeclaratorIdContext;
import ell.antlr.EllParser.VariableDeclaratorsContext;
import ell.antlr.EllParser.VariableInitializerContext;
import ell.antlr.EllParser.VariableModifierContext;
import static java.lang.String.format;

public class EllCompiler extends AbstractParseTreeVisitor<String> implements EllVisitor<String> {

	private String code;
	
	private void add(String code){
		this.code += code;
	}
	
	public String getCode(){
		return this.code;
	}
	
	private String visitDefault(ParserRuleContext ctx){
		String code = "";
		for(ParseTree c:ctx.children){
			if(c instanceof TerminalNode){
				code += ( " " + c.getText() + " ");
			}else{
				code += " "+ visit(c) + " ";
			}
		}
		return code;
	}

	@Override
	public String visitCompilationUnit(CompilationUnitContext ctx) {
	    return visitDefault(ctx);
		
	}

	@Override
	public String visitPackageDeclaration(PackageDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitImportDeclaration(ImportDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeDeclaration(TypeDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitModifier(ModifierContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitClassOrInterfaceModifier(
			ClassOrInterfaceModifierContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitVariableModifier(VariableModifierContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitClassDeclaration(ClassDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeParameters(TypeParametersContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeParameter(TypeParameterContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeBound(TypeBoundContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitEnumDeclaration(EnumDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitEnumConstants(EnumConstantsContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitEnumConstant(EnumConstantContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitEnumBodyDeclarations(EnumBodyDeclarationsContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitInterfaceDeclaration(InterfaceDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeList(TypeListContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitClassBody(ClassBodyContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitInterfaceBody(InterfaceBodyContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitClassBodyDeclaration(ClassBodyDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitMemberDeclaration(MemberDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitMethodDeclaration(MethodDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitGenericMethodDeclaration(
			GenericMethodDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitGenericConstructorDeclaration(
			GenericConstructorDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitFieldDeclaration(FieldDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitInterfaceBodyDeclaration(
			InterfaceBodyDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitInterfaceMemberDeclaration(
			InterfaceMemberDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitConstDeclaration(ConstDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitConstantDeclarator(ConstantDeclaratorContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitInterfaceMethodDeclaration(
			InterfaceMethodDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitGenericInterfaceMethodDeclaration(
			GenericInterfaceMethodDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitVariableDeclarators(VariableDeclaratorsContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitVariableDeclarator(VariableDeclaratorContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitVariableInitializer(VariableInitializerContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitArrayInitializer(ArrayInitializerContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitEnumConstantName(EnumConstantNameContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitType(TypeContext ctx) {
		String code = "";
		if(ctx.classOrInterfaceType()!=null 
				&&ctx.MUL()!=null){
			String type = ctx.classOrInterfaceType().getText();
			code = format("ArrayList<%s>",type);
			return code;
		}else{
			return visitDefault(ctx);
		}
		
	}

	@Override
	public String visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitPrimitiveType(PrimitiveTypeContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeArguments(TypeArgumentsContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeArgument(TypeArgumentContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitQualifiedNameList(QualifiedNameListContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitFormalParameters(FormalParametersContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitFormalParameterList(FormalParameterListContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitFormalParameter(FormalParameterContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitLastFormalParameter(LastFormalParameterContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitMethodBody(MethodBodyContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitConstructorBody(ConstructorBodyContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitQualifiedName(QualifiedNameContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitLiteral(LiteralContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotation(AnnotationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationName(AnnotationNameContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitElementValuePairs(ElementValuePairsContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitElementValuePair(ElementValuePairContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitElementValue(ElementValueContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitElementValueArrayInitializer(
			ElementValueArrayInitializerContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationTypeDeclaration(
			AnnotationTypeDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationTypeBody(AnnotationTypeBodyContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationTypeElementDeclaration(
			AnnotationTypeElementDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationTypeElementRest(
			AnnotationTypeElementRestContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationMethodOrConstantRest(
			AnnotationMethodOrConstantRestContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationMethodRest(AnnotationMethodRestContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitAnnotationConstantRest(AnnotationConstantRestContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitDefaultValue(DefaultValueContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitBlock(BlockContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitBlockStatement(BlockStatementContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitLocalVariableDeclarationStatement(
			LocalVariableDeclarationStatementContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitLocalVariableDeclaration(
			LocalVariableDeclarationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitStatement(StatementContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitCatchClause(CatchClauseContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitCatchType(CatchTypeContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitFinallyBlock(FinallyBlockContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitResourceSpecification(ResourceSpecificationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitResources(ResourcesContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitResource(ResourceContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitSwitchBlockStatementGroup(
			SwitchBlockStatementGroupContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitSwitchLabel(SwitchLabelContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitForControl(ForControlContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitForInit(ForInitContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitEnhancedForControl(EnhancedForControlContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitForUpdate(ForUpdateContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitParExpression(ParExpressionContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitExpressionList(ExpressionListContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitStatementExpression(StatementExpressionContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitConstantExpression(ConstantExpressionContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitExpression(ExpressionContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitPrimary(PrimaryContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitCreator(CreatorContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitCreatedName(CreatedNameContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitInnerCreator(InnerCreatorContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitArrayCreatorRest(ArrayCreatorRestContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitClassCreatorRest(ClassCreatorRestContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitExplicitGenericInvocation(
			ExplicitGenericInvocationContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitNonWildcardTypeArguments(
			NonWildcardTypeArgumentsContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitNonWildcardTypeArgumentsOrDiamond(
			NonWildcardTypeArgumentsOrDiamondContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitSuperSuffix(SuperSuffixContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitExplicitGenericInvocationSuffix(
			ExplicitGenericInvocationSuffixContext ctx) {
		return visitDefault(ctx);
		
	}

	@Override
	public String visitArguments(ArgumentsContext ctx) {
		return visitDefault(ctx);
		
	}

	
}

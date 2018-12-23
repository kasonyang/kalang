package kalang.compiler.compile;

import kalang.compiler.FieldNotFoundException;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParserBaseVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.util.InvalidModifierException;
import kalang.compiler.util.ModifierUtil;
import kalang.compiler.util.OffsetRangeHelper;
import kalang.compiler.util.StringLiteralUtil;
import kalang.type.FunctionClasses;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

public abstract class AstBuilderBase extends KalangParserBaseVisitor<Object> {

    protected final DiagnosisReporter diagnosisReporter;
    protected final SemanticAnalyzer semanticAnalyzer;
    private CompilationUnit compilationUnit;

    public AstBuilderBase(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
        this.semanticAnalyzer = new SemanticAnalyzer(compilationUnit, compilationUnit.getCompileContext().getAstLoader());
    }

    abstract ClassNode getCurrentClass();

    abstract ClassNode getTopClass();

    protected int parseModifier(KalangParser.VarModifierContext modifier) {
        int defaultModifier = Modifier.PUBLIC;
        if (modifier == null) return defaultModifier;
        String modifierText = parseTreeToText(modifier);
        if (modifierText.isEmpty()) return defaultModifier;
        try {
            return ModifierUtil.parse(modifierText);
        } catch (InvalidModifierException ex) {
            this.handleSyntaxError(ex.getMessage(), modifier);
            return defaultModifier;
        }
    }

    //TODO add stop token
    protected void handleSyntaxError(String msg, Token token) {
        //TODO what does EMPTY means?
        handleSyntaxError(msg, (ParserRuleContext.EMPTY), token, token);
    }

    protected void handleSyntaxError(String msg, ParserRuleContext tree) {
        handleSyntaxError(msg, tree, tree.start, tree.stop);
    }

    //TODO remove rule
    protected void handleSyntaxError(String desc, ParserRuleContext rule, Token start, Token stop) {
        diagnosisReporter.report(Diagnosis.Kind.ERROR, desc, start, stop);
    }

    protected void mapAst(@Nonnull AstNode node, @Nonnull ParserRuleContext tree) {
        node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }

    protected void mapAst(@Nonnull AstNode node, @Nonnull Token token) {
        node.offset = OffsetRangeHelper.getOffsetRange(token);
    }

    @Nullable
    protected ClassNode resolveNamedClass(String id,ClassNode topClass,ClassNode currentClass){
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        AstLoader astLoader = compilationUnit.getCompileContext().getAstLoader();
        String resolvedName = typeNameResolver.resolve(id, topClass, currentClass);
        ClassNode ast = resolvedName==null ? null : astLoader.getAst(resolvedName);
        return ast;
    }

    protected ObjectType parseLambdaType(KalangParser.LambdaTypeContext ctx) {
        NullableKind nullable = ctx.nullable==null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.TypeContext returnTypeCtx = ctx.returnType;
        Type returnType = this.parseType(returnTypeCtx);
        List<KalangParser.TypeContext> paramTypeCtxList = ctx.paramsTypes;
        int paramCount = paramTypeCtxList.size();
        int maxParamCount = FunctionClasses.CLASSES.length-1;
        if (paramCount > maxParamCount) {
            String msg = "only support " +maxParamCount + " parameters";
            diagnosisReporter.report(Diagnosis.Kind.ERROR,msg,ctx);
            return Types.getRootType();
        }
        Type[] paramTypes = new Type[paramCount];
        for(int i=0;i<paramTypes.length;i++) {
            paramTypes[i] = this.parseType(paramTypeCtxList.get(i));
        }
        return Types.getFunctionType(returnType, paramTypes, nullable);
    }

    @Nullable
    protected Type parseType(KalangParser.TypeContext ctx) {
        KalangParser.ClassTypeContext ct = ctx.classType();
        KalangParser.PrimitiveTypeContext pt = ctx.primitiveType();
        if(ct!=null){
            return parseClassType(ct);
        }else if(pt!=null){
            return Types.getPrimitiveType(pt.getText());
        }else{
            NullableKind nullable = ctx.nullable!=null ? NullableKind.NULLABLE : NullableKind.NONNULL;
            KalangParser.TypeContext t = ctx.type();
            Type cpt = parseType(t);
            if(cpt==null) return null;
            return Types.getArrayType(cpt,nullable);
        }
    }

    @Nullable
    protected ObjectType parseClassType(KalangParser.ClassTypeContext ctx){
        NullableKind nullable = ctx.nullable==null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.LambdaTypeContext lambdaType = ctx.lambdaType();
        if (lambdaType!=null) {
            return this.parseLambdaType(lambdaType);
        }
        Token rawTypeToken = ctx.rawClass;
        List<String> classNameParts = new LinkedList();
        for(Token p:ctx.paths){
            classNameParts.add(p.getText());
        }
        if(ctx.innerClass!=null){
            classNameParts.add(rawTypeToken.getText() + "$" + ctx.innerClass.getText());
        }else{
            classNameParts.add(rawTypeToken.getText());
        }
        String rawType = String.join(".", classNameParts);
        for(GenericType gt:getCurrentClass().getGenericTypes()){
            if(rawType.equals(gt.getName())) return gt;
        }
        ObjectType clazzType = requireClassType(rawType,rawTypeToken);
        if(clazzType==null) return null;
        ClassNode clazzNode = clazzType.getClassNode();
        GenericType[] clzDeclaredGenericTypes = clazzNode.getGenericTypes();
        List<KalangParser.ParameterizedElementTypeContext> parameterTypes = ctx.parameterTypes;
        if(parameterTypes!=null && !parameterTypes.isEmpty()){
            Type[] typeArguments = new Type[parameterTypes.size()];
            if(parameterTypes!=null && parameterTypes.size()>0){
                if(clzDeclaredGenericTypes.length!=parameterTypes.size()){
                    diagnosisReporter.report(
                            Diagnosis.Kind.ERROR
                            , "wrong number of type arguments"
                            ,ctx
                    );
                    return null;
                }
                for(int i=0;i<typeArguments.length;i++){
                    typeArguments[i] = parseParameterizedElementType(parameterTypes.get(i));
                    //TODO should return null?
                    if(typeArguments[i]==null) return null;
                }
            }
            return Types.getClassType(clazzType.getClassNode(), typeArguments,nullable);
        } else {
            return Types.getClassType(clazzType.getClassNode(), nullable);
        }
    }

    @Nullable
    protected ObjectType requireClassType(@Nonnull Token token){
        return requireClassType(token.getText(),token);
    }

    @Nullable
    protected ObjectType requireClassType(@Nonnull String id,@Nonnull Token token){
        ClassNode ast = requireAst(id, token);
        if(ast==null) return null;
        return Types.getClassType(ast,new Type[0]);
    }

    @Nullable
    protected ClassNode requireAst(Token token){
        return requireAst(token.getText(),token);
    }

    /**
     * checks whether a class is available
     * @param id
     * @param token
     * @return
     */
    @Nullable
    protected ClassNode requireAst(String id,Token token) {
        ClassNode ast = resolveNamedClass(id, getTopClass(), getCurrentClass());
        if(ast==null){
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "class not found:" + id, token);
        }
        return ast;
    }

    protected ConstExpr parseLiteral(KalangParser.LiteralContext ctx, @Nullable Type exceptedType){
        String t = ctx.getText();
        Object v;
        if (ctx.IntegerLiteral() != null) {
            //NOTE should show tip for autocast?
            if(t.toUpperCase().endsWith("L")){
                t = t.substring(0,t.length()-1);
                exceptedType = Types.LONG_TYPE;
            }else if(t.toLowerCase().endsWith("i")){
                t = t.substring(0,t.length()-1);
                exceptedType = Types.INT_TYPE;
            }
            Number intValue;
            try{
                intValue = StringLiteralUtil.parseInteger(t);
            }catch(NumberFormatException ex){
                this.handleSyntaxError("invalid number", ctx);
                return null;
            }
            if(Types.BYTE_TYPE.equals(exceptedType)){
                //TODO check range
                v = intValue.byteValue();
            }else if(Types.LONG_TYPE.equals(exceptedType)){
                v =  intValue.longValue();
            }else{
                //TODO check range
                v = intValue;
            }
        } else if (ctx.FloatingPointLiteral() != null) {
            Number floatPointValue;
            try{
                floatPointValue = StringLiteralUtil.parseFloatPoint(t);
            }catch(NumberFormatException ex){
                this.handleSyntaxError("invalid float value", ctx);
                return null;
            }
            if(Types.FLOAT_TYPE.equals(exceptedType)){
                v = floatPointValue.floatValue();
            }else{
                v = floatPointValue;
            }
        } else if (ctx.BooleanLiteral() != null) {
            v = ( Boolean.parseBoolean(t));
        } else if (ctx.CharacterLiteral() != null) {
            String strValue = StringLiteralUtil.parse(t);
            char[] chars = strValue.toCharArray();
            v = ( chars[1]);
        } else if (ctx.StringLiteral() != null) {
            v = (StringLiteralUtil.parse(t.substring(1, t.length() - 1)));
        } else if(ctx.MultiLineStringLiteral()!=null){
            v = StringLiteralUtil.parse(t.substring(3,t.length()-3));
        }else if(ctx.Identifier()!=null){
            ClassReference cr = requireClassReference(ctx.Identifier().getSymbol());
            v = (cr);
        } else if(ctx.getText().equals("null")) {
            v = null;
        }else{
            throw Exceptions.unexceptedValue(ctx.getText());
        }
        ConstExpr ce = new ConstExpr(v);
        mapAst(ce,ctx);
        return ce;
    }


    @Nullable
    protected AnnotationNode parseAnnotation(KalangParser.AnnotationContext ctx) {
        ClassNode anType = requireAst(ctx.annotationType);
        if(anType==null) return null;
        List<Token> vk = ctx.annotationValueKey;
        KalangParser.LiteralContext dv = ctx.annotationDefaultValue;
        AnnotationNode anNode = new AnnotationNode(anType);
        if(vk!=null && vk.size()>0){
            List<KalangParser.LiteralContext> anValues = ctx.annotationValue;
            int ksize = vk.size();
            for(int i=0;i<ksize;i++){
                String kname = vk.get(i).getText();
                ConstExpr value = parseLiteral(anValues.get(i),null);
                anNode.values.put(kname, value);
            }
        }else if(dv!=null){
            ConstExpr defaultValue = parseLiteral(dv,null);
            anNode.values.put("value", defaultValue);
        }
        if(!semanticAnalyzer.validateAnnotation(anNode)) return null;
        //TODO validate annotation's values
        return anNode;
    }

    protected List<AnnotationNode> getAnnotations(@Nullable List<KalangParser.AnnotationContext> ctxs){
        List<AnnotationNode> list = new LinkedList<>();
        if(ctxs!=null){
            for(KalangParser.AnnotationContext an:ctxs){
                AnnotationNode anNode = parseAnnotation(an);
                if(anNode!=null) list.add(anNode);
            }
        }
        return list;
    }

    @Nullable
    protected ExprNode getObjectFieldExpr(ExprNode expr,String fieldName,@Nullable ParserRuleContext rule){
        ExprNode ret;
        Type type = expr.getType();
        if(!(type instanceof  ObjectType)){
            //AstBuilder.this.handleSyntaxError("unsupported type", rule==null ? ParserRuleContext.EMPTY : rule);
            return null;
        }
        ObjectType exprType = (ObjectType) type;
        if ((exprType instanceof ArrayType)){
            return null;
        } else {
            try {
                ret = ObjectFieldExpr.create(expr, fieldName,exprType.getClassNode());
            } catch (FieldNotFoundException ex) {
                return null;
            }
        }
        if(rule!=null) mapAst(ret, rule);
        return ret;
    }

    private String parseTreeToText(ParseTree ctx) {
        if (ctx instanceof TerminalNode) return ctx.getText();
        StringBuilder sb = new StringBuilder();
        int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i > 0) sb.append(" ");
            sb.append(parseTreeToText(ctx.getChild(i)));
        }
        return sb.toString();
    }

    private Type parseParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx){
        KalangParser.TypeContext type = ctx.type();
        if(type!=null){
            return parseType(type);
        }else{
            return parseWildcardType(ctx.wildcardType());
        }
    }

    private Type parseWildcardType(KalangParser.WildcardTypeContext ctx){
        ObjectType classType = parseClassType(ctx.classType());
        if(classType==null) return null;
        Type[] bounds = new Type[]{classType};
        String boundKind = ctx.boundKind.getText();
        if(boundKind.equals("super")){
            return new WildcardType(new Type[]{Types.getRootType()},bounds);
        }else{
            return new WildcardType(bounds,null);
        }
    }

    @Nullable
    private ClassReference requireClassReference(@Nonnull Token token){
        ClassNode ast = requireAst(token);
        if(ast==null) return null;
        return new ClassReference(ast);
    }

}

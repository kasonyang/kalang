package kalang.compiler.compile.semantic;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParser.MethodDeclContext;
import kalang.compiler.ast.*;
import kalang.compiler.compile.*;
import kalang.compiler.core.*;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.Exceptions;
import kalang.compiler.util.ModifierUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kason Yang
 */
public class ClassNodeStructureBuilder extends AstBuilder {

    //private AstBuilder astBuilder;
    //private ClassNode thisClazz;
    //private ClassNode topClass;
    
    private Map<MethodNode,KalangParser.StatContext[]> methodStatsContexts = new HashMap<>();

    private List<MissingParamMethodInfo> missParamMethods = new LinkedList<>();

    private final CompilationUnit compilationUnit;

    public ClassNodeStructureBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        super(compilationUnit,parser);
        this.compilationUnit = compilationUnit;
    }

    public void build(ClassNode topClass, ClassNode cn,ParserRuleContext ctx) {
        this.thisClazz = cn;
        this.topClass = topClass;
        visit(ctx);
    }

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        thisClazz.annotations.addAll(getAnnotations(ctx.annotation()));
        //thisClazz.modifier = parseModifier(ctx.varModifier());
        if (ctx.typeParam != null) {
            for (KalangParser.TypeParameterContext tpc : ctx.typeParam) {
                thisClazz.declareGenericType(parseGenericType(tpc));
            }
        }
        ObjectType superType = null;
        if (ctx.parentClass != null) {
            superType = parseClassType(ctx.parentClass);
        }
        if (Modifier.isInterface(thisClazz.getModifier())) {
            //TODO update syntax to support:interface extends T1,T2...
            if (superType!=null) {
                thisClazz.addInterface(superType);
            }
        } else {
            thisClazz.setSuperType(superType==null?Types.getRootType():superType);
        }
        if (ctx.interfaces != null && ctx.interfaces.size() > 0) {
            for (KalangParser.ClassTypeContext itf : ctx.interfaces) {
                thisClazz.addInterface(parseClassType(itf));
            }
        }
        if (AstUtil.isNonStaticInnerClass(thisClazz)) {
            ClassNode parentClass = thisClazz.enclosingClass;
            if (parentClass == null) {
                throw Exceptions.unexpectedValue(null);
            }
            FieldNode field = thisClazz.createField(Types.getClassType(parentClass), "this$0", Modifier.PRIVATE | ModifierConstant.SYNTHETIC);
            field.offset = OffsetRange.NONE;
        }
        visitClassBody(ctx.classBody());
        return null;
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        String name;
        if (ctx.prefix != null && ctx.prefix.getText().equals("constructor")) {
            name = "<init>";
        } else {
            name = ctx.name.getText();
        }
        int modifier = parseModifier(ctx.varModifier());
        boolean isOverriding = ctx.OVERRIDE() != null;
        KalangParser.BlockStmtContext blockStmt = ctx.blockStmt();
        if(blockStmt==null){
            if(ModifierUtil.isInterface(thisClazz.getModifier())){
                modifier |= Modifier.ABSTRACT;
            }else if(!Modifier.isAbstract(modifier)){
                handleSyntaxError("method body required", offset(ctx));
            }else if(!Modifier.isAbstract(thisClazz.getModifier())){
                handleSyntaxError("declare abstract method in non-abstract class", offset(ctx));
            }
        }
        BlockStmt methodBody = null;
        if (!Modifier.isAbstract(modifier)) {
            methodBody = new BlockStmt();
            methodBody.offset = offset(ctx.blockStmt());
        }
        //TODO simplify createMethod method
        MethodNode method = thisClazz.createMethodNode(Types.getRootType(NullableKind.UNKNOWN), name, modifier, methodBody);
        enterMethod(method, () -> {
            //check method duplicated before generate java stub
            if (ctx.typeParam != null) {
                for (KalangParser.TypeParameterContext tpc : ctx.typeParam) {
                    method.declareGenericType(parseGenericType(tpc));
                }
            }
            if (ctx.returnType == null) {
                method.setType(Types.VOID_TYPE);
            } else {
                method.setType(parseType(ctx.returnType));
            }
            List<KalangParser.ParamDeclContext> params = ctx.params;
            for (int i = 0; i < params.size(); i++) {
                KalangParser.ParamDeclContext p = params.get(i);
                Type pt;
                if (p.VARARGS != null) {
                    if (i == params.size() - 1) {
                        method.addModifier(ModifierConstant.VARARGS);
                    } else {
                        handleSyntaxError("Vararg parameter must be the last parameter", offset(p));
                    }
                    pt = Types.getArrayType(parseType(p.paramType));
                } else {
                    pt = parseType(p.paramType);
                }
                ParameterNode pn = method.createParameter(pt, p.paramId.getText());
                mapAst(pn, p);
            }
            if (isOverriding) {
                method.addAnnotation(new AnnotationNode(getAstLoader().loadAst(Override.class.getName())));
            }
            for(AnnotationNode a:getAnnotations(ctx.annotation()))  method.addAnnotation(a);
            KalangParser.BlockStmtContext bstm = ctx.blockStmt();
            if(bstm!=null){
                List<KalangParser.StatContext> stats = bstm.stat();
                if(stats!=null) this.methodStatsContexts.put(method, stats.toArray(new KalangParser.StatContext[0]));
            }
            if (ctx.exceptionTypes != null) {
                for (Token et : ctx.exceptionTypes) {
                    ObjectType exType = requireClassType(et);
                    if(exType!=null){
                        method.addExceptionType(exType);
                    }
                }
            }
            mapAst(method, ctx);
            ParameterNode[] methodParams = method.getParameters();
            int paramsCount = methodParams.length;
            for(int i = 0;i < paramsCount;i++){
                KalangParser.ParamDeclContext p = ctx.params.get(i);
                if (p.paramDefVal != null) {
                    BlockStmt mBody = new BlockStmt();
                    mBody.offset = OffsetRange.NONE;
                    MethodNode m = thisClazz.createMethodNode(method.getType(), method.getName(), method.getModifier(), mBody);
                    for (GenericType gt : method.getGenericTypes()) {
                        m.declareGenericType(gt);
                    }
                    for (int j = 0; j < i; j++) {
                        m.createParameter(methodParams[j].getType(), methodParams[j].getName(), methodParams[j].getModifier());
                    }
                    for (AnnotationNode a: m.getAnnotations()) {
                        m.addAnnotation(a);
                    }
                    for (Type e: m.getExceptionTypes()) {
                        m.addExceptionType(e);
                    }
                    mapAst(m, ctx);
                    missParamMethods.add(new MissingParamMethodInfo(m, method, ctx));
                }
            }
        });
        return null;
    }
    
    @Nullable
    public KalangParser.StatContext[] getStatContexts(MethodNode mn){
        return this.methodStatsContexts.get(mn);
    }

    @Override
    public AstNode visitClassBody(KalangParser.ClassBodyContext ctx) {
        for(KalangParser.MethodDeclContext m:ctx.methodDecl()){
            visitMethodDecl(m);
        }
        for(KalangParser.FieldDeclContext f:ctx.fieldDecl()){
            visitFieldDecl(f);
        }
        return null;
    }
    
    @Override
    public Void visitFieldDecl(KalangParser.FieldDeclContext ctx) {
        int fieldModifier = parseModifier(ctx.varModifier());
        for(KalangParser.VarDeclContext vd:ctx.varDecl()){
            AstBuilder.VarInfo varInfo = varDecl(vd, Types.getRootType());
            varInfo.modifier |= fieldModifier;
            FieldNode fieldNode = thisClazz.createField(varInfo.type, varInfo.name,varInfo.modifier);
            mapAst(fieldNode, offset(ctx));
            KalangParser.ExpressionContext initExpr = vd.expression();
            if (initExpr != null) {
                thisClazz.fieldInitExprMap.put(fieldNode, initExpr);
            }
        }
        return null;
    }

    @Override
    public Object visitScriptDef(KalangParser.ScriptDefContext ctx) {
        thisClazz.setSuperType(this.getScriptType());
        List<MethodDeclContext> mds = ctx.methodDecl();
        if(mds!=null){
            for(MethodDeclContext m:mds){
                visitMethodDecl(m);
            }
        }
        BlockStmt body = new BlockStmt();
        body.offset = offset(ctx);
        MethodNode mm = thisClazz.createMethodNode(Types.INT_TYPE,"execute",Modifier.PUBLIC, body);
        mm.addAnnotation(new AnnotationNode(getAstLoader().loadAst(Override.class.getName())));
        mm.addExceptionType(Types.getExceptionClassType());
        mm.setDefaultReturnValue(new ConstExpr(0));
        mapAst(mm, offset(ctx));
        List<KalangParser.StatContext> stats = ctx.stat();
        if(stats!=null){
            this.methodStatsContexts.put(mm, stats.toArray(new KalangParser.StatContext[0]));
        }
        AstUtil.createEmptyConstructor(thisClazz);
        AstUtil.createScriptMainMethodIfNotExists(thisClazz);
        return null;
    }
        
    private ObjectType getScriptType(){
        CompileContext context = this.compilationUnit.getCompileContext();
        Configuration conf = context.getConfiguration();
        AstLoader astLoader = context.getAstLoader();
        String defaultBaseClass = conf.getScriptBaseClass();
        try{
            return Types.getClassType(astLoader.loadAst(defaultBaseClass));
        }catch (AstNotFoundException ex) {
            throw Exceptions.missingRuntimeClass(defaultBaseClass);
        }
    }

    @Override
    ClassNode getCurrentClass() {
        return thisClazz;
    }

    @Override
    ClassNode getTopClass() {
        return topClass;
    }

    public List<MissingParamMethodInfo> getMissParamMethods() {
        return missParamMethods;
    }

}

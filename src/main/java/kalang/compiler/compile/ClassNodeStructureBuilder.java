package kalang.compiler.compile;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParser.MethodDeclContext;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.ClassTypeUtil;
import kalang.compiler.util.MethodUtil;
import kalang.compiler.util.ModifierUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kason Yang
 */
public class ClassNodeStructureBuilder extends AstBuilder {

    //private AstBuilder astBuilder;
    private ClassNode thisClazz;
    private ClassNode topClass;
    
    private Map<MethodNode,KalangParser.StatContext[]> methodStatsContexts = new HashMap<>();

    private MethodNode method;

    private final CompilationUnit compilationUnit;
    private DiagnosisReporter diagnosisReporter;
    
    public ClassNodeStructureBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        super(compilationUnit,parser);
        this.compilationUnit = compilationUnit;
        //this.astBuilder = astBuilder;
        this.diagnosisReporter = new DiagnosisReporter(this.compilationUnit);
    }

    public void build(ClassNode topClass, ClassNode cn,ParserRuleContext ctx) {
        this.thisClazz = cn;
        this.topClass = topClass;
        thisClazz = cn;
        visit(ctx);
    }

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        thisClazz.annotations.addAll(getAnnotations(ctx.annotation()));
        thisClazz.modifier = parseModifier(ctx.varModifier());
        List<Token> gnrTypes = ctx.genericTypes;
        if (gnrTypes != null && !gnrTypes.isEmpty()) {
            for (Token g : gnrTypes) {
                //TODO suport generic type bounds in syntax
                GenericType gt = new GenericType(g.getText(), Types.getRootType(), null, NullableKind.NONNULL);
                thisClazz.declareGenericType(gt);
            }
        }
        ObjectType superType = null;
        if (ctx.parentClass != null) {
            ObjectType parentClass = parseClassType(ctx.parentClass);
            if (parentClass != null) {
                superType = parentClass;
            }
        } else {
            superType = Types.getRootType();
        }
        if (Modifier.isInterface(thisClazz.modifier)) {
            //TODO update syntax to support:interface extends T1,T2...
            thisClazz.addInterface(superType);
        } else {
            thisClazz.setSuperType(superType);
        }
        if (ctx.interfaces != null && ctx.interfaces.size() > 0) {
            for (KalangParser.ClassTypeContext itf : ctx.interfaces) {
                ObjectType itfClz = parseClassType(itf);
                if (itfClz != null) {
                    thisClazz.addInterface(itfClz);
                }
            }
        }
        if (this.isDeclaringNonStaticInnerClass()) {
            ClassNode parentClass = thisClazz.enclosingClass;
            if (parentClass == null) {
                throw Exceptions.unexceptedValue(parentClass);
            }
            thisClazz.createField(Types.getClassType(parentClass), "this$0", Modifier.PRIVATE | ModifierConstant.SYNTHETIC);
        }
        visitClassBody(ctx.classBody());
        if (!ModifierUtil.isInterface(thisClazz.modifier) 
                && !AstUtil.containsConstructor(thisClazz) 
                && !AstUtil.createEmptyConstructor(thisClazz)) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR
                    , "failed to create constructor with no parameters", ctx
            );
        }
        MethodNode[] methods = thisClazz.getDeclaredMethodNodes();
        for (int i = 0; i < methods.length; i++) {
            MethodNode node = methods[i];
            BlockStmt body = node.getBody();
            if (body != null) {
                if (AstUtil.isConstructor(node)) {//constructor
                    if (this.isDeclaringNonStaticInnerClass()) {
                        ClassNode enclosingClass = thisClazz.enclosingClass;
                        if (enclosingClass == null) {
                            throw Exceptions.unexceptedValue(enclosingClass);
                        }
                        ParameterNode outerInstanceParam = node.createParameter(0, Types.getClassType(enclosingClass), "this$0");
                        ExprNode parentFieldExpr = getObjectFieldExpr(
                                new ThisExpr(Types.getClassType(thisClazz)), "this$0", ParserRuleContext.EMPTY
                        );
                        if (parentFieldExpr == null) {
                            throw Exceptions.unexceptedValue(parentFieldExpr);
                        }
                        body.statements.add(1, new ExprStmt(new AssignExpr((AssignableExpr) parentFieldExpr, new ParameterExpr(outerInstanceParam))));
                    }
                }
            }
        }
        for (FieldNode fieldNode : thisClazz.getFields()) {
            int mdf = fieldNode.modifier;
            if (Modifier.isStatic(mdf)){
                continue;
            }
            if (!Modifier.isPublic(mdf) && !Modifier.isProtected(mdf)){
                continue;
            }
            if (!AstUtil.hasGetter(thisClazz, fieldNode)) {
                AstUtil.createGetter(thisClazz, fieldNode, mdf);
            }
            if (!AstUtil.hasSetter(thisClazz, fieldNode)) {
                AstUtil.createSetter(thisClazz, fieldNode, mdf);
            }
            fieldNode.modifier = ModifierUtil.setPrivate(mdf);
        }
        return null;
    }

    private boolean isNonStaticInnerClass(ClassNode clazz) {
        return clazz.enclosingClass != null && !Modifier.isStatic(clazz.modifier);
    }

    private boolean isDeclaringNonStaticInnerClass() {
        return isNonStaticInnerClass(thisClazz);
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        String name;
        Type type;
        boolean isOverriding = ctx.OVERRIDE() != null;
        if (ctx.prefix != null && ctx.prefix.getText().equals("constructor")) {
            type = Types.VOID_TYPE;
            name = "<init>";
        } else {
            if (ctx.type() == null) {
                type = Types.VOID_TYPE;
            } else {
                type = parseType(ctx.returnType);
            }
            name = ctx.name.getText();
        }
        List<KalangParser.TypeContext> paramTypesCtx = ctx.paramTypes;
        int modifier = parseModifier(ctx.varModifier());
        Type[] paramTypes;
        String[] paramNames;
        if (paramTypesCtx != null) {
            int paramSize = paramTypesCtx.size();
            paramTypes = new Type[paramSize];
            paramNames = new String[paramSize];
            for(int i=0;i<paramSize;i++){
                KalangParser.TypeContext t = paramTypesCtx.get(i);
                paramTypes[i] = parseType(t);
                paramNames[i] = ctx.paramIds.get(i).getText();
            }
        }else{
            paramTypes = new Type[0];
            paramNames = new String[0];
        }
        //check method duplicated before generate java stub
        String mStr = MethodUtil.getDeclarationKey(name,paramTypes);
        boolean existed = Arrays.asList(thisClazz.getDeclaredMethodNodes()).stream().anyMatch((m)->{
            return MethodUtil.getDeclarationKey(m).equals(mStr);
        });
        if (existed) {
            //TODO should remove the duplicated method
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"declare method duplicately:"+mStr, ctx);
            return null;
        }
        KalangParser.BlockStmtContext blockStmt = ctx.blockStmt();
        if(blockStmt==null){
            if(ModifierUtil.isInterface(thisClazz.modifier)){
                modifier |= Modifier.ABSTRACT;
            }else if(!Modifier.isAbstract(modifier)){
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "method body required", ctx);
            }else if(!Modifier.isAbstract(thisClazz.modifier)){
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "declare abstract method in non-abstract class", ctx);
            }
        }
        method = thisClazz.createMethodNode(type,name,modifier);
        for(int i=0;i<paramTypes.length;i++){
            method.createParameter(paramTypes[i], paramNames[i]);
        }
        for(AnnotationNode a:getAnnotations(ctx.annotation()))  method.addAnnotation(a);
        ObjectType superType = thisClazz.getSuperType();
        if(superType==null){//the superType of interface may be null
            superType = Types.getRootType();
        }
        MethodDescriptor overriddenMd = ClassTypeUtil.getMethodDescriptor(superType, mStr, thisClazz, true,true);
        if(overriddenMd==null){
            overriddenMd = ClassTypeUtil.getMethodDescriptor(thisClazz.getInterfaces(), mStr, thisClazz, true,true);
        }
        if(isOverriding && overriddenMd==null){            
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"method does not override or implement a method from a supertype", ctx);
        }
        if(!isOverriding && overriddenMd!=null && !"<init>".equals(overriddenMd.getName())){
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"method overrides or implements a method from a supertype", ctx);
        }
        KalangParser.BlockStmtContext bstm = ctx.blockStmt();
        if(bstm!=null){
            List<KalangParser.StatContext> stats = bstm.stat();
            if(stats!=null) this.methodStatsContexts.put(method, stats.toArray(new KalangParser.StatContext[stats.size()]));
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
        MethodNode m = method;
        method=null;
        return m;
    }
    
    @Nullable
    public KalangParser.StatContext[] getStatContexts(MethodNode mn){
        return this.methodStatsContexts.get(mn);
    }

    @Override
    public AstNode visitClassBody(KalangParser.ClassBodyContext ctx) {
        for(KalangParser.FieldDeclContext f:ctx.fieldDecl()){
            visitFieldDecl(f);
        }
        for(KalangParser.MethodDeclContext m:ctx.methodDecl()){
            visitMethodDecl(m);
        }
        return null;
    }
    
    @Override
    public Void visitFieldDecl(KalangParser.FieldDeclContext ctx) {
        int fieldModifier = parseModifier(ctx.varModifier());
        for(KalangParser.VarDeclContext vd:ctx.varDecl()){
            ExprNode initExpr;
            if(vd.expression()!=null){
                initExpr = visitExpression(vd.expression());
            }else{
                initExpr = null;
            }
            AstBuilder.VarInfo varInfo = varDecl(vd,initExpr==null
                    ?Types.getRootType()
                    :initExpr.getType()
            );
            varInfo.modifier |= fieldModifier;
            FieldNode fieldNode = thisClazz.createField(varInfo.type, varInfo.name,varInfo.modifier);
            //TODO simplify it
            if(initExpr!=null){
                if(AstUtil.isStatic(fieldNode.modifier)){
                    thisClazz.staticInitStmts.add(new ExprStmt(new AssignExpr(new StaticFieldExpr(new ClassReference(thisClazz), fieldNode), initExpr)));
                }else{
                    thisClazz.initStmts.add(new ExprStmt(
                            new AssignExpr(
                                    new ObjectFieldExpr(
                                            new ThisExpr(Types.getClassType(thisClazz)), fieldNode
                                    )
                                    , initExpr
                            )
                        )
                    );
                }
            }
        }
        return null;
    }

    @Override
    public Object visitScriptDef(KalangParser.ScriptDefContext ctx) {
        //FIXME fix filename
        //thisClazz.fileName = this.compilationUnit.getSource().getFileName();
        thisClazz.setSuperType(this.getScriptType());
        List<MethodDeclContext> mds = ctx.methodDecl();
        if(mds!=null){
            for(MethodDeclContext m:mds){
                visitMethodDecl(m);
            }
        }
        MethodNode mm = thisClazz.createMethodNode(Types.INT_TYPE,"execute",Modifier.PUBLIC);
        mm.addExceptionType(Types.getExceptionClassType());
        mm.setDefaultReturnValue(new ConstExpr(0));
        method = mm;
        List<KalangParser.StatContext> stats = ctx.stat();
        if(stats!=null){
            this.methodStatsContexts.put(mm, stats.toArray(new KalangParser.StatContext[stats.size()]));
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
}

package kalang.compiler;

import kalang.MethodNotFoundException;
import kalang.FieldNotFoundException;
import kalang.AmbiguousMethodException;
import kalang.AstNotFoundException;
import javax.annotation.Nonnull;
import kalang.ast.ClassNode;
import kalang.ast.ElementExpr;
import kalang.ast.AssignExpr;
import kalang.ast.Statement;
import kalang.ast.MultiStmtExpr;
import kalang.ast.MethodNode;
import kalang.ast.ContinueStmt;
import kalang.ast.VarObject;
import kalang.ast.ExprNode;
import kalang.ast.AstNode;
import kalang.ast.LoopStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.ExprStmt;
import kalang.ast.BinaryExpr;
import kalang.ast.VarExpr;
import kalang.ast.ThisExpr;
import kalang.ast.ConstExpr;
import kalang.ast.TryStmt;
import kalang.ast.ThrowStmt;
import kalang.ast.CatchBlock;
import kalang.ast.CastExpr;
import kalang.ast.BlockStmt;
import kalang.ast.BreakStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.NewArrayExpr;
import kalang.ast.IfStmt;
import kalang.ast.FieldExpr;
import kalang.ast.ReturnStmt;
import kalang.util.AstUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.antlr.KalangParser;
import kalang.antlr.KalangParser.BlockStmtContext;
import kalang.antlr.KalangParser.BreakStatContext;
import kalang.antlr.KalangParser.CastExprContext;
import kalang.antlr.KalangParser.ClassBodyContext;
import kalang.antlr.KalangParser.CompilantUnitContext;
import kalang.antlr.KalangParser.ContinueStatContext;
import kalang.antlr.KalangParser.DoWhileStatContext;
import kalang.antlr.KalangParser.ExprAssignContext;
import kalang.antlr.KalangParser.ExprGetArrayElementContext;
import kalang.antlr.KalangParser.ExprGetFieldContext;
import kalang.antlr.KalangParser.ExprIdentifierContext;
import kalang.antlr.KalangParser.ExprInvocationContext;
import kalang.antlr.KalangParser.ExprLiteralContext;
import kalang.antlr.KalangParser.ExprMemberInvocationContext;
import kalang.antlr.KalangParser.ExprMidOpContext;
import kalang.antlr.KalangParser.ExprParenContext;
import kalang.antlr.KalangParser.ExprSelfOpPreContext;
import kalang.antlr.KalangParser.ExprSelfRefContext;
import kalang.antlr.KalangParser.ExprStatContext;
import kalang.antlr.KalangParser.ExpressionContext;
import kalang.antlr.KalangParser.ExpressionsContext;
import kalang.antlr.KalangParser.FieldDeclContext;
import kalang.antlr.KalangParser.ForStatContext;
import kalang.antlr.KalangParser.IfStatContext;
import kalang.antlr.KalangParser.ImportDeclContext;
import kalang.antlr.KalangParser.LiteralContext;
import kalang.antlr.KalangParser.MethodDeclContext;
import kalang.antlr.KalangParser.NewExprContext;
import kalang.antlr.KalangParser.QualifiedNameContext;
import kalang.antlr.KalangParser.ReturnStatContext;
import kalang.antlr.KalangParser.StatContext;
import kalang.antlr.KalangParser.TryStatContext;
import kalang.antlr.KalangParser.TypeContext;
import kalang.antlr.KalangParser.VarDeclContext;
import kalang.antlr.KalangParser.VarDeclStatContext;
import kalang.antlr.KalangParser.VarModifierContext;
import kalang.antlr.KalangParser.WhileStatContext;
import kalang.antlr.KalangVisitor;
import kalang.core.VarTable;
import javax.annotation.Nullable;
import kalang.antlr.KalangParser.LocalVarDeclContext;
import kalang.ast.AnnotationNode;
import kalang.ast.ArrayLengthExpr;
import kalang.ast.AssignableExpr;
import kalang.ast.ClassReference;
import kalang.ast.CompareExpr;
import kalang.ast.ErrorousExpr;
import kalang.ast.FieldNode;
import kalang.ast.IncrementExpr;
import kalang.ast.InstanceOfExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.LogicExpr;
import kalang.ast.MathExpr;
import kalang.ast.MultiStmt;
import kalang.ast.NewObjectExpr;
import kalang.ast.ObjectFieldExpr;
import kalang.ast.ObjectInvokeExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ParameterNode;
import kalang.ast.StaticFieldExpr;
import kalang.ast.StaticInvokeExpr;
import kalang.ast.SuperExpr;
import kalang.ast.UnknownFieldExpr;
import kalang.ast.UnknownInvocationExpr;
import kalang.ast.VarDeclStmt;
import kalang.core.ArrayType;
import kalang.core.ClassType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.exception.Exceptions;
import kalang.util.BoxUtil;
import kalang.util.ModifierUtil;
import kalang.util.NameUtil;
import kalang.util.OffsetRangeHelper;
import kalang.util.StringLiteralUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *  build ast from antlr parse tree
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class AstBuilder extends AbstractParseTreeVisitor implements KalangVisitor {
    
    public static final int 
            PARSING_PHASE_META = 1,
            PARSING_PHASE_ALL = 2;
   
    private int parsingPhase=0;
    //static String DEFAULT_VAR_TYPE;// = "java.lang.Object";

    //short name to full name
    @Nonnull
    private final Map<String, String> fullNames = new HashMap<>();
    @Nonnull
    private final List<String> importPaths = new LinkedList<>();
    @Nonnull
    private final ClassNode classAst = new ClassNode();
    private MethodNode method;
    
    protected BlockStmt currentBlock = null;
    private final HashMap<MethodNode,StatContext> methodBodys = new HashMap<>();

    @Nonnull
    private AstLoader astLoader;

    private ParserRuleContext compilationContext;

    @Nonnull
    private TokenStream tokenStream;

    @Nonnull
    private final String className;
    
    @Nonnull
    private String classPath;

    //@Nonnull
    //private VarTable<String, LocalVarNode> vtb;
    
    @Nonnull
    private KalangParser parser;
    
    private CompileErrorHandler errorHandler = (error) ->{
        System.err.println(error);
    };
    
    private final CompilationUnit compilationUnit;
    
    public CompileErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(CompileErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
    
    public ParserRuleContext getParseTree(){
        return compilationContext;
    }

    @Nonnull
    public String getClassName() {
        return className;
    }
    
    @Nullable
    private ClassReference requireClassReference(@Nonnull Token token){
        ClassNode ast = requireAst(token);
        if(ast==null) return null;
        return new ClassReference(ast);
    }
    
    @Nullable
    private ClassType requireClassType(@Nonnull Token token){
        return requireClassType(token.getText(),token);
    }
    
    @Nullable
    private ClassType requireClassType(@Nonnull String id,@Nonnull Token token){
        ClassNode ast = requireAst(id, token);
        if(ast==null) return null;
        return Types.getClassType(ast);
    }

    public void compile(){
        compile(PARSING_PHASE_ALL,null);
    }
    
    public void compile(int targetPhase){
        compile(targetPhase, null);
    }
    
    public void compile(int targetPhase,@Nullable AstLoader astLoader) {
        if(astLoader==null){
            this.astLoader = new AstLoader();
        }else{
            this.astLoader = astLoader;
        }
        if(targetPhase>=PARSING_PHASE_META
                && parsingPhase < PARSING_PHASE_META){
            parsingPhase = PARSING_PHASE_META;
            this.compilationContext = parser.compilantUnit();
            visit(compilationContext);
            if(AstUtil.getMethodsByName(classAst.getDeclaredMethodNodes(), "<init>").length<1){
                AstUtil.createEmptyConstructor(classAst);
            }
        }
        if(targetPhase>=PARSING_PHASE_ALL
                && parsingPhase < PARSING_PHASE_ALL){
            parsingPhase = PARSING_PHASE_ALL;
            for(MethodNode m:classAst.getDeclaredMethodNodes()){
                StatContext body = methodBodys.get(m);
                if(body!=null){
                    method = m;
                    m.body = (BlockStmt) visitStat(body);
                    if(m.body!=null && AstUtil.isConstructor(m)){   
                        @SuppressWarnings("null")
                        List<Statement> bodyStmts = m.body.statements;
                        if(!AstUtil.hasConstructorCallStatement(bodyStmts)){
                            try {
                                bodyStmts.add(0, AstUtil.createDefaultSuperConstructorCall(classAst));
                            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                                AstBuilder.this.handleSyntaxError("default constructor not found", body.start);
                            }
                        }
                    }
                }
            }
        }
    }

    public AstBuilder(@Nonnull CompilationUnit compilationUnit, @Nonnull KalangParser parser) {
        this.compilationUnit = compilationUnit;
        this.className = compilationUnit.getSource().getClassName();
        classAst.name = className;
        this.classPath = "";
        this.parser = parser;
        tokenStream = parser.getTokenStream();
        if (className.contains(".")) {
            classPath = className.substring(0, className.lastIndexOf('.'));
        }
    }
    
        
    @Override
    public String toString(){
        return getClass().getName() + ":" + className;
    }

    @Nonnull
    public AstLoader getAstLoader() {
        return astLoader;
    }

    @Nonnull
    public TokenStream getTokenStream() {
        return tokenStream;
    }

    @Nonnull
    public KalangParser getParser() {
        return parser;
    }
    
    @Nullable
    private ClassNode requireAst(Token token){
        return requireAst(token.getText(),token);
    }

    /**
     * checks whether a class is available
     * @param id
     * @param token
     * @return 
     */
    @Nullable
    private ClassNode requireAst(String id,Token token) {
        id = expandClassName(id);
        try {
            return astLoader.loadAst(id);
        } catch (AstNotFoundException ex) {
            AstBuilder.this.handleSyntaxError("ast not found:" + id, token);
            return null;
        }
    }
    
    @Nullable
    private ClassNode getAst(String id){
        if(id==null || id.length()==0) return null;
        id =expandClassName(id);
        return astLoader.getAst(id);
    }

    @Nullable
    private Type parseSingleType(KalangParser.SingleTypeContext singleTypeContext){
        if(singleTypeContext.Identifier()!=null){
            return requireClassType(singleTypeContext.Identifier().getSymbol());
        }else{
            return Types.getPrimitiveType(singleTypeContext.getText());
        }
    }

    @Nullable
    private Type parseType(TypeContext typeContext) {
        if(typeContext.singleType()!=null){
            return parseSingleType(typeContext.singleType());
        }else{
            Type ct = parseType(typeContext.type());
            if(ct==null) return null;
            return Types.getArrayType(ct);
        }
    }

    @Override
    public Object visit(ParseTree tree) {
        if (tree == null) {
            System.err.println("visit null");
            return null;
        }
        return super.visit(tree);
    }

    public void importPackage(@Nonnull String packageName) {
        this.importPaths.add(packageName);
    }
    
    BlockStmt wrapBlock(Statement... statms){
        BlockStmt bs = newBlock();
        bs.statements.addAll(Arrays.asList(statms));
        popBlock();
        return bs;
    }
    
    BlockStmt newBlock(){
        BlockStmt bs = new BlockStmt(currentBlock);
        currentBlock = bs;
        return bs;
    }
    
    void popBlock(){
        currentBlock = currentBlock.getParentBlock();
    }

    @Nonnull
    public ClassNode getAst() {
        return this.classAst;
    }
    
    private void mapAst(@Nonnull AstNode node,@Nonnull ParserRuleContext tree){
         node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }
    
    private void mapAst(@Nonnull AstNode node,@Nonnull Token token){
        node.offset = OffsetRangeHelper.getOffsetRange(token);
    }
    
    @Override
    public ThrowStmt visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ThrowStmt ts = new ThrowStmt(visitExpression(ctx.expression()));
        mapAst(ts, ctx);
        return ts;
    }

    @Override
    public MultiStmtExpr visitMapExpr(KalangParser.MapExprContext ctx) {
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = Types.MAP_IMPL_CLASS_TYPE;
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(Types.MAP_IMPL_CLASS_TYPE);
        } catch (MethodNotFoundException|AmbiguousMethodException ex) {
            throw new RuntimeException(ex);
        }
        List<Statement> stmts = new LinkedList<>();
        stmts.add(vds);
        stmts.add(new ExprStmt(new AssignExpr(new VarExpr(vo), newExpr)));
        VarExpr ve = new VarExpr(vo);
        List<TerminalNode> ids = ctx.Identifier();
        for (int i = 0; i < ids.size(); i++) {
            ExpressionContext e = ctx.expression(i);
            ExprNode v = (ExprNode) visit(e);
            ConstExpr k = new ConstExpr(ctx.Identifier(i).getText());
            ExprNode[] args = new ExprNode[]{k,v};
            InvocationExpr iv;
            try {
                iv = ObjectInvokeExpr.create(ve, "put",args);
            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                throw new RuntimeException(ex);
            }
            ExprStmt es = new ExprStmt(iv);
            stmts.add(es);
        }
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        mapAst(mse,ctx);
        //TODO set generic toType
        return mse;
    }

    @Override
    public MultiStmtExpr visitListExpr(KalangParser.ListExprContext ctx) {
        List<Statement> stmts = new LinkedList<>();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = Types.LIST_IMPL_CLASS_TYPE;
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(Types.LIST_IMPL_CLASS_TYPE);
        } catch (MethodNotFoundException|AmbiguousMethodException ex) {
            throw new RuntimeException(ex);
        }
        stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        stmts.add(new ExprStmt(new AssignExpr(ve, newExpr)));
        for (ExpressionContext e : ctx.expression()) {
            InvocationExpr iv;
            try {
                iv = ObjectInvokeExpr.create(ve,"add",new ExprNode[]{visitExpression(e)});
            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                throw new RuntimeException(ex);
            }
            stmts.add(new ExprStmt(iv));
        }
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        //TODO set generic toType
        mapAst(mse,ctx);
        return mse;
    }

    @Override
    public ExprNode visitExprNewArray(KalangParser.ExprNewArrayContext ctx) {
        Type type = parseSingleType(ctx.singleType());
        ExprNode ret;
        if(ctx.size!=null){
            ExprNode size = visitExpression(ctx.size);
            ret = new NewArrayExpr(type,size);
        }else{
            ExprNode[] initExprs = new ExprNode[ctx.initExpr.size()];
            for(int i=0;i<initExprs.length;i++){
                initExprs[i] = visitExpression(ctx.initExpr.get(i));
            }
            ret= BoxUtil.createInitializedArray(type, initExprs);
        }
        mapAst(ret, ctx);
        return ret;
    }

    @Override
    public AstNode visitExprQuestion(KalangParser.ExprQuestionContext ctx) {
        List<Statement> stmts = new LinkedList<>();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        ExprNode conditionExpr = (ExprNode) visit(ctx.expression(0));
        ExprNode trueExpr = (ExprNode) visit(ctx.expression(1));
        ExprNode falseExpr = (ExprNode)  visit(ctx.expression(2));
        IfStmt is = new IfStmt(conditionExpr
                ,wrapBlock(new ExprStmt(new AssignExpr(ve, trueExpr)))
                ,wrapBlock(new ExprStmt(new AssignExpr(ve,falseExpr)))
        );
        Type trueType = trueExpr.getType();
        Type falseType  = falseExpr.getType();
        if(trueType.equals(falseType)){
            vo.type = trueType;
        }else{
            //TODO get common type
            vo.type = Types.ROOT_TYPE;
        }
        stmts.add(is);
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        mapAst(ve, ctx);
        return mse;
    }

    @Override
    public AstNode visitPostIfStmt(KalangParser.PostIfStmtContext ctx) {
        ExprNode leftExpr = visitExpression(ctx.expression(0));
        if (!(leftExpr instanceof AssignExpr)) {
            this.handleSyntaxError("AssignExpr required", ctx);
        }
        AssignExpr assignExpr = (AssignExpr) leftExpr;
        AssignableExpr to = assignExpr.getTo();
        ExprNode from = assignExpr.getFrom();
        ExprNode cond = visitExpression(ctx.expression(1));
        Token op = ctx.op;
        if (op != null) {
            String opStr = op.getText();
            BinaryExpr be = createBinaryExpr(to, cond, opStr);
            cond = be;
        }
        AssignExpr as = new AssignExpr(to, from);
        IfStmt is = new IfStmt(cond,wrapBlock(new ExprStmt(as)),null);
        mapAst(is,ctx);
        return is;
    }

    @Override
    public AstNode visitCompilantUnit(CompilantUnitContext ctx) {
        classAst.name = this.className;
        visitChildren(ctx);
        return null;
    }

    @Override
    public AstNode visitClassBody(ClassBodyContext ctx) {
        this.visitChildren(ctx);
        mapAst(classAst, ctx);
        return null;
    }

    @Override
    public Void visitFieldDecl(FieldDeclContext ctx) {
        int mdf = this.parseModifier(ctx.varModifier());
        for(VarDeclContext vd:ctx.varDecl()){
            FieldNode fieldNode = classAst.createField();
            fieldNode.modifier =ModifierUtil.setPrivate(mdf);
            if(vd.expression()!=null){
                ExprNode initExpr = visitExpression(vd.expression());
                varDecl(vd,fieldNode,initExpr.getType());
                //TODO simplify it
                if(AstUtil.isStatic(fieldNode.modifier)){
                    classAst.staticInitStmts.add(new ExprStmt(new AssignExpr(new StaticFieldExpr(new ClassReference(classAst), fieldNode), initExpr)));
                }else{
                    classAst.initStmts.add(new ExprStmt(new AssignExpr(new ObjectFieldExpr(new ThisExpr(Types.getClassType(classAst)), fieldNode), initExpr)));
                }
            }else{
                varDecl(vd,fieldNode,Types.ROOT_TYPE);
            }
            if(!AstUtil.hasGetter(classAst, fieldNode)){
                AstUtil.createGetter(classAst, fieldNode, mdf);
            }
            if(!AstUtil.hasSetter(classAst, fieldNode)){
                AstUtil.createSetter(classAst, fieldNode, mdf);
            }
        }
        return null;
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        method = classAst.createMethodNode();
        method.annotations.addAll(getAnnotations(ctx.annotation()));
        String name;
        Type type;
        int mdf = parseModifier(ctx.varModifier());
        if (ctx.prefix != null && ctx.prefix.getText().equals("constructor")) {
            type = Types.VOID_TYPE;
            name = "<init>";
        } else {
            if (ctx.type() == null) {
                type = Types.VOID_TYPE;
            } else {
                type = parseType(ctx.type());
            }
            name = ctx.name.getText();
        }
        method.modifier = mdf;
        method.type = type;
        method.name = name;
        if (ctx.varDecl() != null) {
            for(VarDeclContext vd:ctx.varDecl()){
                ParameterNode pn = ParameterNode.create(method);
                varDecl(vd, pn,Types.ROOT_TYPE);
                method.parameters.add(pn);
            }
        }
        if (ctx.stat() != null) {
            methodBodys.put(method, ctx.stat());
        }
        if (ctx.exceptionTypes != null) {
            for (Token et : ctx.exceptionTypes) {
                ClassType exType = requireClassType(et);
                if(exType!=null){
                    method.exceptionTypes.add(exType);
                }
            }
        }
        mapAst(method, ctx);
        return method;
    }

    @Override
    public AstNode visitType(TypeContext ctx) {
        //do nothing
        return null;
    }

    public List<Object> visitAll(List<? extends ParserRuleContext> list) {
        List<Object> ret = new ArrayList<>(list.size());
        for (ParserRuleContext i : list) {
            ret.add(visit(i));
        }
        return ret;
    }

    @Override
    public AstNode visitIfStat(IfStatContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        BlockStmt trueBody = null;
        BlockStmt falseBody = null;
        if (ctx.trueStmt != null) {
            trueBody=requireBlock(ctx.trueStmt);
        }
        if (ctx.falseStmt != null) {
            falseBody=requireBlock(ctx.falseStmt);
        }
        IfStmt ifStmt = new IfStmt(expr,trueBody,falseBody);
        mapAst(ifStmt,ctx);
        return ifStmt;
    }

    private ExprNode visitExpression(ExpressionContext expression) {
        Object node = visit(expression);
        if(node instanceof ExprNode){
            return (ExprNode) node;
        }else if(node instanceof AstNode){
            return new ErrorousExpr((AstNode)node);
        }else{
            return new ErrorousExpr();
        }
    }

    @Override
    public Statement visitStat(StatContext ctx) {
        return (Statement) visit(ctx.getChild(0));
    }

    @Override
    public AstNode visitReturnStat(ReturnStatContext ctx) {
        ReturnStmt rs = new ReturnStmt();
        if (ctx.expression() != null) {
            rs.expr = visitExpression(ctx.expression());
        }
        mapAst(rs,ctx);
        return rs;
    }

    @Override
    public Statement visitVarDeclStat(VarDeclStatContext ctx) {
        Statement vars = visitLocalVarDecl(ctx.localVarDecl());
        mapAst(vars,ctx);            
        return vars;
    }

    @Override
    public VarObject visitVarDecl(VarDeclContext ctx) {
        throw new UnsupportedOperationException();
    }
    
    private void varDecl(VarDeclContext ctx,VarObject vds,Type inferedType){
        String name = ctx.name.getText();
        TypeContext type = null;
        if (ctx.varType != null) {
            type = ctx.varType;
        } else if (ctx.type() != null) {
            type = ctx.type();
        }
        Type declType = type != null ? parseType(type) : inferedType;
        if (isDefindedId(name)) {
            AstBuilder.this.handleSyntaxError("the name is definded:" + name, ctx);
        }
        vds.name = name;
        vds.type = declType;
//        if (ctx.expression() != null) {
//            vds.initExpr = visitExpression(ctx.expression());
//            if(vds.type==null && vds.initExpr!=null){
//                vds.type = vds.initExpr.getType();
//            }
//        }
        if(vds.type==null){
            vds.type = Types.ROOT_TYPE;
        }
        mapAst(vds,ctx);
    }
    
    public void methodIsAmbiguous(Token token , AmbiguousMethodException ex){
        AstBuilder.this.handleSyntaxError(ex.getMessage(), token);
    }
    
    public void methodNotFound(Token token , String className,String methodName,ExprNode[] params){
        Type[] types = AstUtil.getExprTypes(params);
        AstBuilder.this.handleSyntaxError("method not found:" + AstUtil.getMethodDescription(className,methodName, types), token);
    }
    
    public void handleSyntaxError(String msg, Token token) {
        //TODO what does EMPTY means?
        handleSyntaxError(msg, (ParserRuleContext.EMPTY), token, token);
    }

    public void handleSyntaxError(String msg,ParserRuleContext tree) {
        handleSyntaxError(msg, tree, tree.start, tree.stop);
    }
    
    public void handleSyntaxError(String desc,ParserRuleContext rule,Token start,Token stop){
        SyntaxError syntaxError = new SyntaxError(desc, compilationUnit, rule, start,stop);
        errorHandler.handleCompileError(syntaxError);
    }

    @Override
    public AstNode visitBreakStat(BreakStatContext ctx) {
        BreakStmt bs = new BreakStmt();
        mapAst(bs,ctx);
        return bs;
    }

    @Override
    public AstNode visitContinueStat(ContinueStatContext ctx) {
        ContinueStmt cs = new ContinueStmt();
        mapAst(cs,ctx);
        return cs;
    }

    @Override
    public AstNode visitWhileStat(WhileStatContext ctx) {
        
        ExprNode preConditionExpr = visitExpression(ctx.expression());
        BlockStmt loopBody = null;
        if (ctx.stat() != null) {
            loopBody = requireBlock(ctx.stat());
        }
        LoopStmt ws = new LoopStmt(loopBody,preConditionExpr,null);
        mapAst(ws,ctx);
        return ws;
    }

    @Override
    public AstNode visitDoWhileStat(DoWhileStatContext ctx) {
        BlockStmt loopBody = null;
        if (ctx.stat() != null) {
            loopBody = requireBlock(ctx.stat());
        }
        ExprNode postConditionExpr = visitExpression(ctx.expression());
        LoopStmt ls = new LoopStmt(loopBody,null,postConditionExpr);
        mapAst(ls,ctx);
        return ls;
    }

    @Override
    public AstNode visitForStat(ForStatContext ctx) {
        //It seems that here lacks of var stack
        BlockStmt forStmt = newBlock();
        if(ctx.localVarDecl()!=null){
            Statement vars = visitLocalVarDecl(ctx.localVarDecl());
            forStmt.statements.add(vars);
        }
        ExprNode preConditionExpr = (ExprNode) visit(ctx.expression());
        BlockStmt bs =newBlock();
        if (ctx.stat() != null) {
            Statement st = visitStat(ctx.stat());
            if(st instanceof BlockStmt){
                bs.statements.addAll(((BlockStmt)st).statements);
            }
        }
        if(ctx.expressions()!=null){
            bs.statements.addAll(visitExpressions(ctx.expressions()));
        }
        popBlock();
        LoopStmt ls = new LoopStmt(bs, preConditionExpr, null);
        mapAst(ls,ctx);
        forStmt.statements.add(ls);
        popBlock();
        return forStmt;
    }

    @Override
    public List<Statement> visitExpressions(ExpressionsContext ctx) {
        List<Statement> list = new LinkedList();
        for (ExpressionContext e : ctx.expression()) {
            ExprNode expr = visitExpression(e);
            list.add(new ExprStmt(expr));
        }
        return list;
    }

    @Override
    public AstNode visitExprStat(ExprStatContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        ExprStmt es = new ExprStmt(expr);
        mapAst(es,ctx);
        return es;
    }

    @Override
    public ExprNode visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
        String methodName;
        if (ctx.key != null) {
            methodName = ctx.key.getText();
        } else {
            methodName = ctx.Identifier().getText();
        }
        if(methodName.equals("this")){
            methodName = "<init>";
        }else if(methodName.equals("super")){
            methodName = "<init>";
        }
        ExprNode[] args = visitAll(ctx.params).toArray(new ExprNode[0]);
        ExprNode ie = getImplicitInvokeExpr(methodName,args,ctx);
        return ie;
    }
    
    private BinaryExpr createBinaryExpr(ExprNode expr1,ExprNode expr2,String op){
        switch(op){
            case "==":
            case "!=":
            case ">":
            case ">=":
            case "<":
            case "<=":
                return new CompareExpr(expr1, expr2, op);
            case "&&":
            case "||":
                return new LogicExpr(expr1, expr2, op);
            default:
                return new MathExpr(expr1, expr2, op);
        }
    }
    
    protected ExprNode createFieldExpr(ExprGetFieldContext to,@Nullable ExpressionContext fromCtx){
        String refKey = to.refKey.getText();
        ExpressionContext exp = to.expression();
        String fname = to.Identifier().getText();
        AssignableExpr toExpr;
        Object expr = visit(exp);
        if(refKey.equals(".")){
            ExprNode fieldExpr;
            if(expr instanceof ExprNode){
                ExprNode exprNode = (ExprNode) expr;
                fieldExpr = getObjectFieldLikeExpr(exprNode,fname,to);
            }else if(expr instanceof ClassReference){
                fieldExpr = getStaticFieldExpr((ClassReference)expr, fname, to);
            }else{
                throw new UnknownError("unknown node:" + expr);
            }
            if(fromCtx==null){
                return fieldExpr;
            }else{
                if(fieldExpr instanceof AssignableExpr){
                    toExpr = (AssignableExpr) fieldExpr;
                }else{
                    AstBuilder.this.handleSyntaxError("unsupported", to);
                    return null;
                }
                return new AssignExpr(toExpr,visitExpression(fromCtx));
            }
        }else if(refKey.equals("->")){
            //ClassNode ast = getAst("kalang.runtime.dynamic.FieldVisitor");
            //if(ast==null) throw new UnknownError();
            ExprNode[] params;
            String methodName;
            if(fromCtx==null){
                params = new ExprNode[0];
                methodName = "get" + NameUtil.firstCharToUpperCase(fname);
            }else{
                params = new ExprNode[1];
                methodName = "set" + NameUtil.firstCharToUpperCase(fname);
            }
            if(expr instanceof ExprNode){
                //params[0] = (ExprNode) expr;
                if(fromCtx!=null) params[0] = visitExpression(fromCtx);
                return getObjectInvokeExpr((ExprNode)expr, methodName, params, to);
            }else{
                //TODO handle static property
                throw Exceptions.unsupportedTypeException(expr);
            }
            //return getStaticInvokeExpr(new ClassReference(classAst),methodName,params, to);
        }else{
            throw new UnsupportedOperationException(refKey);
        }
    }

    @Override
    public ExprNode visitExprAssign(ExprAssignContext ctx) {
        String assignOp = ctx.getChild(1).getText();
        ExpressionContext toCtx = ctx.expression(0);
        ExpressionContext fromCtx = ctx.expression(1);
        if(toCtx instanceof ExprGetFieldContext){
            return createFieldExpr((ExprGetFieldContext)toCtx,fromCtx);
        }
        ExprNode to = visitExpression(toCtx);
        ExprNode from = visitExpression(fromCtx);
        if (assignOp.length() > 1) {
            String op = assignOp.substring(0, assignOp.length() - 1);
            from = createBinaryExpr(to, from, op);
        }
        AssignableExpr toExpr;
        if(to instanceof AssignableExpr){
            toExpr = (AssignableExpr) to;
            AssignExpr aexpr = new AssignExpr(toExpr,from);
            mapAst(aexpr, ctx);
            return aexpr;
        }else{
            AstBuilder.this.handleSyntaxError("unsupported assign statement",ctx);
            return null;
        }
    }

    @Override
    public AstNode visitExprMidOp(ExprMidOpContext ctx) {
        String op = ctx.getChild(1).getText();
        ExprNode expr1 = visitExpression(ctx.expression(0));
        ExprNode expr2 = visitExpression(ctx.expression(1));
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = (type1 instanceof PrimitiveType);
        boolean isPrimitive2 = (type2 instanceof PrimitiveType);
        ExprNode expr;
        if(isPrimitive1 && isPrimitive2){
            BinaryExpr be = createBinaryExpr(expr1,expr2,op);
            expr = be;
        }else if(Types.isNumber(type1) && Types.isNumber(type2)){
            PrimitiveType t = SemanticAnalyzer.getMathType(type1, type2, op);
            expr1 = BoxUtil.assign(expr1, type1, t);
            expr2 = BoxUtil.assign(expr2, type2, t);
            if(expr1==null || expr2 == null){
                throw new UnknownError("cast fail");
            }
            expr = createBinaryExpr(expr1, expr2, op);
        }else if(op.equals("==") || op.equals("!=")){
            expr = createBinaryExpr(expr1, expr2, op);
        }else if(op.equals("+")){
            if(!Types.STRING_CLASS_TYPE.equals(type1)){
                expr1 = BoxUtil.castToString(expr1);
            }
            if(!Types.STRING_CLASS_TYPE.equals(type2)){
                expr2 = BoxUtil.castToString(expr2);
            }
            if(expr1==null || expr2 == null){
                AstBuilder.this.handleSyntaxError("unsupported types", ctx);
                return null;
            }
            InvocationExpr ie;
            try {
                ie = ObjectInvokeExpr.create(expr1, "concat",new ExprNode[]{expr2});
            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                throw new RuntimeException(ex);
            }
            expr = ie;
        }else{
            throw new UnknownError("unknown binary expression");
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private ExprNode getImplicitInvokeExpr(String methodName,ExprNode[] args, ParserRuleContext ctx){
        ExprNode expr;
        try {
            InvocationExpr.MethodSelection ms = InvocationExpr.applyMethod(classAst, methodName, args,AstUtil.listAccessibleMethods(classAst, classAst, true));
            if(Modifier.isStatic(ms.selectedMethod.modifier)){
                expr = new StaticInvokeExpr(new ClassReference(classAst), ms.selectedMethod, ms.appliedArguments);
            }else{
                expr = new ObjectInvokeExpr(new ThisExpr(Types.getClassType(classAst)), ms.selectedMethod, ms.appliedArguments);
            }
        } catch (MethodNotFoundException ex) {
            expr = new UnknownInvocationExpr(null, methodName, args);
        } catch (AmbiguousMethodException ex) {
            methodIsAmbiguous(ctx.start, ex);
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,List<ExpressionContext> argumentsCtx,ParserRuleContext ctx){
        ExprNode[] args = visitAll(argumentsCtx).toArray(new ExprNode[0]);
        return getObjectInvokeExpr(target, methodName, args, ctx);
    }
    
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,ExprNode[] args,ParserRuleContext ctx){
        if("<init>".equals(methodName)){
            throw new UnsupportedOperationException("don't get constructor by this method");
        }
        ExprNode expr;
        try {
            expr = ObjectInvokeExpr.create(target, methodName, args,classAst);
        } catch (MethodNotFoundException ex) {
            expr= new UnknownInvocationExpr(target,methodName,args);
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(ctx.start,ex);
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName,List<ExpressionContext> argumentsCtx,ParserRuleContext ctx){
        return getStaticInvokeExpr(clazz, methodName, visitAll(argumentsCtx).toArray(new ExprNode[0]), ctx);
    }
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName, ExprNode[] argumentsCtx,ParserRuleContext ctx){
        ExprNode[] args = argumentsCtx;
        ExprNode expr;
        try {
            expr = StaticInvokeExpr.create(clazz, methodName, args);
        } catch (MethodNotFoundException ex) {
            expr = new UnknownInvocationExpr(clazz, methodName , args);
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(ctx.start, ex);
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }

    @Override
    public AstNode visitExprInvocation(ExprInvocationContext ctx) {
        Object target = visit(ctx.target);
        if(target==null) return null;
        String mdName = ctx.Identifier().getText();
        String refKey = ctx.refKey.getText();
        if(refKey.equals(".")){
            if(target instanceof ClassReference){
                return getStaticInvokeExpr((ClassReference) target, mdName,ctx.params, ctx);
            }else if(target instanceof ExprNode){
                return getObjectInvokeExpr((ExprNode) target, mdName, ctx.params,ctx);
            }else{
                throw new UnknownError("unknown node:"+ target);
            }
        }else if(refKey.equals("->")){
            ExprNode[] invokeArgs = new ExprNode[3];
            ExprNode[] params = new ExprNode[ctx.params.size()];
            if(target instanceof ClassReference){
                invokeArgs[0] = new ConstExpr(null);
            }else if(target instanceof ExprNode){
                invokeArgs[0] = ((ExprNode) target);
            }
            invokeArgs[1] = new ConstExpr(mdName);
            for(int i=0;i<params.length;i++){
                params[i] = visitExpression(ctx.params.get(i));
            }
            invokeArgs[2] = BoxUtil.createInitializedArray(Types.ROOT_TYPE, params);
            ClassNode dispatcherAst = getAst("kalang.runtime.invoke.MethodDispatcher");
            if(dispatcherAst==null){
                throw new RuntimeException("Runtime library is required!");
            }
            return getStaticInvokeExpr(new ClassReference(dispatcherAst), "invokeMethod", invokeArgs, ctx);
        }else{
            throw new UnsupportedOperationException(refKey);
        }
    }

    @Override
    public ExprNode visitExprGetField(ExprGetFieldContext ctx) {
        return createFieldExpr(ctx, null);
    }

    @Override
    public UnaryExpr visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
        String op = ctx.getChild(0).getText();   
        UnaryExpr ue = new UnaryExpr( visitExpression( ctx.expression() ) , op );
        mapAst(ue, ctx);
        return ue;
    }

    @Override
    public ElementExpr visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
        ElementExpr ee = new ElementExpr(
                visitExpression(ctx.expression(0))
                ,visitExpression(ctx.expression(1))
        );
        mapAst(ee, ctx);
        return ee;
    }
    
    /**
     * expand the class name if could
     * @param id
     * @return 
     */
    private String expandClassName(String id){
        if (fullNames.containsKey(id)) {
            return fullNames.get(id);
        } else {
            List<String> paths = new ArrayList<>(importPaths.size()+1);
            paths.add(classPath);
            paths.addAll(importPaths);
            for (String p : paths) {
                String clsName;
                if(p!=null && p.length()>0){
                    clsName = p + "." + id;
                }else{
                    clsName = id;
                }
                ClassNode cls = astLoader.getAst(clsName);
                if (cls != null) {
                    return clsName;
                }
            }
        }
        return id;
    }
    
    private boolean isDefindedId(String id){
        if(isClassId(id)) return true;
        if(getNodeById(id,null)!=null) return true;
        return false;
    }
    
    private boolean isClassId(String name){
        String id = expandClassName(name);
        ClassNode targetClass = astLoader.getAst(id);
        return (targetClass!=null);
    }
    
    private AstNode requireNameDefined(String name,Token token){
        AstNode n = getNodeById(name, token);
        if(n==null){
            AstBuilder.this.handleSyntaxError(name + " is undefined!", token);
            return null;
        }
        return n;
    }
    
    protected VarTable<String, LocalVarNode> requireVarTable(){
        return currentBlock.getScopeVarTable();
    }
    
    @Nullable
    protected VarTable<String, LocalVarNode> getVarTable(){
        return currentBlock==null ? null : currentBlock.getScopeVarTable();
    }

    @Nullable
    private AstNode getNodeById(@Nonnull String name,@Nullable Token token) {
        if(isClassId(name)){
            ClassReference clsRef = new ClassReference(requireAst(name,token));
            if(token!=null) mapAst(clsRef, token);
            return clsRef;
        }
        VarTable<String, LocalVarNode> vtb = getVarTable();
        if (vtb!=null && vtb.exist(name)) {
            LocalVarNode var = vtb.get(name); //vars.indexOf(vo);
            VarExpr ve = new VarExpr(var);
            if(token!=null) mapAst(ve, token);
            return ve;
        } else {
            //find parameters
            if (method != null && method.parameters != null) {
                for (ParameterNode p : method.parameters) {
                    if (p.name.equals(name)) {
                        ParameterExpr ve = new ParameterExpr(p);
                        if(token!=null) mapAst(ve, token);
                        return ve;
                    }
                }
            }
            if (classAst.fields != null) {
                for (FieldNode f : classAst.fields) {
                    if (f.name!=null && f.name.equals(name)) {
                        FieldExpr fe;
                        if(Modifier.isStatic(f.modifier)){
                            fe = new StaticFieldExpr(new ClassReference(classAst), f);
                        }else{
                            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(classAst)), f);
                        }
                        if(token!=null) mapAst(fe, token);
                        return fe;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ConstExpr visitLiteral(LiteralContext ctx) {
        String t = ctx.getText();
        Object v;
        if (ctx.IntegerLiteral() != null) {
            v = ( Integer.parseInt(t));
        } else if (ctx.FloatingPointLiteral() != null) {
            v = ( Float.parseFloat(t));
        } else if (ctx.BooleanLiteral() != null) {
            v = ( Boolean.parseBoolean(t));
        } else if (ctx.CharacterLiteral() != null) {
            char[] chars = t.toCharArray();
            v = ( chars[1]);
        } else if (ctx.StringLiteral() != null) {
            v = (StringLiteralUtil.parse(t.substring(1, t.length() - 1)));
        }else if(ctx.Identifier()!=null){
            ClassReference cr = requireClassReference(ctx.Identifier().getSymbol());
            v = (cr);
        } else if(ctx.getText().equals("null")) {
            v = null;
        }else{
            throw new UnknownError("unknown literal:"+ctx.getText());
        }
        ConstExpr ce = new ConstExpr(v);
        mapAst(ce,ctx);
        return ce;
    }

    @Override
    public AstNode visitImportDecl(ImportDeclContext ctx) {
        String name = ctx.name.getText();
        String delim = ctx.delim.getText();
        String prefix = "";
        if("\\".equals(delim)){
            boolean relative = ctx.root == null || ctx.root.getText().length() == 0;
            if (relative && this.classPath.length() > 0) {
                prefix = this.classPath + ".";
            }
        }
        if (ctx.path != null) {
            for (Token p : ctx.path) {
                prefix += p.getText() + ".";
            }
        }
        if (name.equals("*")) {
            this.importPaths.add(prefix.substring(0, prefix.length() - 1));
        } else {
            String key = name;
            if (ctx.alias != null) {
                key = ctx.alias.getText();
            }
            this.fullNames.put(key, prefix + name);
        }        
        return null;
    }

    @Override
    public AstNode visitQualifiedName(QualifiedNameContext ctx) {
        //do nothing
        return null;
    }

    private int parseModifier(VarModifierContext modifier) {
        if (modifier == null) {
            return Modifier.PUBLIC;
        }
        int m = 0;
        int access = 0;
        for (ParseTree c : modifier.children) {
            String s = c.getText();
            switch (s) {
                case "public":
                    access = Modifier.PUBLIC;
                    break;
                case "protected":
                    access = Modifier.PROTECTED;
                    break;
                case "private":
                    access = Modifier.PRIVATE;
                    break;
                case "static":
                    m += Modifier.STATIC;
                    break;
                case "final":
                    m += Modifier.FINAL;
                    break;
                default:
                    break;
            }
        }
        if (access == 0) {
            access = Modifier.PUBLIC;
        }
        return m + access;
    }

    @Override
    public AstNode visitNewExpr(NewExprContext ctx) {
        ClassType clsType = requireClassType(ctx.Identifier().getSymbol());
        if(clsType==null) return null;
        ExprNode[] params = visitAll(ctx.params).toArray(new ExprNode[0]);
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(clsType,params);
            mapAst(newExpr,ctx);
            return newExpr;
        } catch (MethodNotFoundException ex) {
            methodNotFound(ctx.Identifier().getSymbol(), clsType.getName(), "<init>", params);
            return null;
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(ctx.Identifier().getSymbol(),ex);
            return null;
        }
    }

    @Override
    public AstNode visitCastExpr(CastExprContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        Type toType = parseType(ctx.type());
        CastExpr ce = new CastExpr(toType,expr);
        mapAst(ce,ctx);
        return ce;
    }

    @Override
    public AstNode visitTryStat(TryStatContext ctx) {
        Statement tryExecStmt = visitStat(ctx.tryStmtList);
        List<CatchBlock> tryCatchBlocks = new LinkedList<>();
        Statement tryFinallyStmt = null;
        if (ctx.catchTypes != null) {
            for (int i = 0; i < ctx.catchTypes.size(); i++) {
                String vName = ctx.catchVarNames.get(i).getText();
                String vType = ctx.catchTypes.get(i).getText();
                LocalVarNode vo = new LocalVarNode();
                vo.name = vName;
                vo.type = requireClassType(vType, ctx.catchTypes.get(i).start);
                BlockStmt catchExecStmt = requireBlock(ctx.catchStmts.get(i));
                CatchBlock catchStmt = new CatchBlock(vo,catchExecStmt); 
                tryCatchBlocks.add(catchStmt);
            }
        }
        if (ctx.finalStmtList != null) {
            tryFinallyStmt = visitStat(ctx.finalStmtList);
        }
        TryStmt tryStmt = new TryStmt(tryExecStmt,tryCatchBlocks,tryFinallyStmt);
        mapAst(tryStmt,ctx);
        return tryStmt;
    }

    @Override
    public Statement visitLocalVarDecl(LocalVarDeclContext ctx) {
        //TODO create statements
        MultiStmt ms = new MultiStmt();
        //List<LocalVarNode> list = new LinkedList();
        for (VarDeclContext v : ctx.varDecl()) {
           ExprNode initExpr = null;
            if(v.expression()!=null){
                initExpr = visitExpression(v.expression());
            }
            LocalVarNode localVar = new LocalVarNode();
            VarDeclStmt vds = new VarDeclStmt(localVar);
            ms.statements.add(vds);
            if(initExpr==null){
                varDecl(v, localVar,Types.ROOT_TYPE);
            }else{
                varDecl(v, localVar,initExpr.getType());
               AssignExpr assignExpr = new AssignExpr(new VarExpr(localVar), initExpr);
                mapAst(assignExpr, v);
                ms.statements.add(new ExprStmt(assignExpr));
            }
            mapAst(localVar,ctx);
            //list.add(localVar);
            requireVarTable().put(localVar.name, localVar);
        }
        return ms;
    }

    @Override
    public AstNode visitExprIdentifier(ExprIdentifierContext ctx) {
        String name = ctx.Identifier().getText();
        AstNode expr = this.getNodeById(name,ctx.Identifier().getSymbol());
        if (expr == null) {
            this.handleSyntaxError(name + " is undefined!", ctx);
            return null;
        }
        mapAst(expr,ctx);
        return expr;
    }

    @Override
    public AstNode visitExprLiteral(ExprLiteralContext ctx) {
        return visitLiteral(ctx.literal());
    }

    @Override
    public AstNode visitExprParen(ExprParenContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public AstNode visitBlockStmt(BlockStmtContext ctx) {
        //TODO var stack?
        BlockStmt bs =newBlock();
        if (ctx.stat() == null) {
            return bs;
        }
        for (StatContext s : ctx.stat()) {
            bs.statements.add(visitStat(s));
        }
        mapAst(bs,ctx);
        popBlock();
        return bs;
    }

    @Override
    public AstNode visitVarModifier(VarModifierContext ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AstNode visitExprSelfRef(ExprSelfRefContext ctx) {
        String key = ctx.ref.getText();
        AstNode expr;
        if(key.equals("this")){
            expr = new ThisExpr(Types.getClassType(classAst));
        }else if(key.equals("super")){
            expr = new SuperExpr(classAst);
        }else{
            throw new UnknownError();
        }
        mapAst(expr, ctx);
        return expr;
    }

    @Override
    public Object visitSingleType(KalangParser.SingleTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object visitPrimitiveType(KalangParser.PrimitiveTypeContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IncrementExpr visitExprInc(KalangParser.ExprIncContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), false);
    }

    @Override
    public IncrementExpr visitExprIncPre(KalangParser.ExprIncPreContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), true);
    }
    
    public IncrementExpr getIncrementExpr(ExpressionContext expressionContext,String op,boolean isPrefix){
        ExprNode expr = visitExpression(expressionContext);
        if(!(expr instanceof AssignableExpr)){
            AstBuilder.this.handleSyntaxError("require assignable expression", expressionContext);
            return null;
        }
        boolean isDesc = op.equals("--");
        return new IncrementExpr((AssignableExpr) expr, isDesc, isPrefix);
    }

    private ExprNode checkBox(ExprNode expr1, Type fromType, Type toType,Token token) {
        ExprNode expr = BoxUtil.assign(expr1,fromType,toType);
        if(expr==null){
            AstBuilder.this.handleSyntaxError("unable to cast " + fromType + " to " + toType, token);
        }
        return expr;
    }
    
    protected ExprNode getObjectFieldLikeExpr(ExprNode expr,String fieldName,ParserRuleContext rule){
        ExprNode ret;
        Type type = expr.getType();
        if(!(type instanceof  ClassType)){
            AstBuilder.this.handleSyntaxError("unsupported type", rule);
            return null;
        }
        ClassType exprType = (ClassType) type;
        if ((exprType instanceof ArrayType)
                && fieldName.equals("length")) {
            ret = new ArrayLengthExpr(expr);
        } else {
            try {
                ret = ObjectFieldExpr.create(expr, fieldName,classAst);
            } catch (FieldNotFoundException ex) {
                ret = new UnknownFieldExpr(expr,exprType.getClassNode(),fieldName);
            }
        }
        mapAst(ret, rule);
        return ret;
    }
    
    protected AssignableExpr getStaticFieldExpr(ClassReference clazz,String fieldName,ParserRuleContext rule){
        AssignableExpr ret;
        try {
            ret = StaticFieldExpr.create(clazz,fieldName,classAst);
        } catch (FieldNotFoundException ex) {
            ret = new UnknownFieldExpr(clazz, clazz.getReferencedClassNode(), fieldName);
        }
        mapAst(ret, rule);
        return ret;
    }

    @Override
    public Object visitErrorousStat(KalangParser.ErrorousStatContext ctx) {
        handleSyntaxError("missing ';'", ctx, ctx.start , ctx.stop);
        return null;
    }

    @Override
    public Object visitErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx) {
        handleSyntaxError("identifier excepted", ctx, ctx.stop , ctx.stop);
        return null;
    }

    @Override
    public Object visitExprInstanceOf(KalangParser.ExprInstanceOfContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        Token ts = ctx.Identifier().getSymbol();
        AstNode tnode = getNodeById(ts.getText(), ts);
        if(tnode instanceof ClassReference){
            InstanceOfExpr ie = new InstanceOfExpr(expr, (ClassReference)tnode);
            mapAst(ie, ctx);
            return ie;
        }else{
            AstBuilder.this.handleSyntaxError("unsupported type", ts);
            return null;
        }
    }

    @Override
    public Object visitScriptDef(KalangParser.ScriptDefContext ctx) {
        classAst.modifier = Modifier.PUBLIC;
        classAst.parent = Types.ROOT_TYPE.getClassNode();
        List<MethodDeclContext> mds = ctx.methodDecl();
        if(mds!=null){
            for(MethodDeclContext m:mds){
                visit(m);
            }
        }
        MethodNode mm = classAst.createMethodNode();
        mm.name = "main";
        mm.modifier = Modifier.PUBLIC  + Modifier.STATIC;
        mm.type = Types.VOID_TYPE;
        //TODO throws exception
        mm.exceptionTypes = Collections.singletonList(Types.EXCEPTION_CLASS_TYPE);
        ParameterNode pn = ParameterNode.create(mm);
        pn.name = "args";
        pn.type = Types.getArrayType(Types.STRING_CLASS_TYPE);
        mm.parameters = Collections.singletonList(pn);
        method = mm;
        List<StatContext> stats = ctx.stat();
        List<Statement> ss = new LinkedList<>();
        BlockStmt body = newBlock();
        //TODO redundant block?
        if(stats!=null){
            for(StatContext s:stats){
                Object statement = visit(s);
                if(statement!=null){
                    ss.add((Statement)statement);
                }
            }
        }
        popBlock();
        body.statements.addAll(ss);
        mm.body = body;
        return null;
    }
    
    protected List<AnnotationNode> getAnnotations(@Nullable List<KalangParser.AnnotationContext> ctxs){
        List<AnnotationNode> list = new LinkedList<>();
        if(ctxs!=null){
            for(KalangParser.AnnotationContext an:ctxs){
                AnnotationNode anNode = visitAnnotation(an);
                if(anNode!=null) list.add(anNode);
            }
        }
        return list;
    }

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        classAst.annotations.addAll(getAnnotations(ctx.annotation()));
        classAst.modifier = parseModifier(ctx.varModifier());
        Token clsType = ctx.classType;
        if(clsType!=null){
            if (clsType.getText().equals("interface")) {
                classAst.isInterface = true;
            }
        }
        if (ctx.parentClass != null) {
            classAst.parent =  requireAst(ctx.parentClass);
        }else{
            classAst.parent = Types.ROOT_TYPE.getClassNode();
        }
        if (ctx.interfaces != null && ctx.interfaces.size() > 0) {
            for (Token itf : ctx.interfaces) {
                ClassNode itfClassNode = requireAst(itf);
                if(itfClassNode!=null){
                    classAst.interfaces.add(itfClassNode);
                }
            }
        }
        visitClassBody(ctx.classBody());
        mapAst(classAst, ctx);
        return null;
    }

    @Override
    public AnnotationNode visitAnnotation(KalangParser.AnnotationContext ctx) {
        ClassNode anType = requireAst(ctx.annotationType);
        if(anType==null) return null;
        List<Token> vk = ctx.annotationValueKey;
        LiteralContext dv = ctx.annotationDefaultValue;
        AnnotationNode anNode = new AnnotationNode(anType);
        if(vk!=null && vk.size()>0){
            List<LiteralContext> anValues = ctx.annotationValue;
            int ksize = vk.size();
            for(int i=0;i<ksize;i++){
                String kname = vk.get(i).getText();
                ConstExpr value = visitLiteral(anValues.get(i));
                anNode.values.put(kname, value);
            }
        }else if(dv!=null){
            ConstExpr defaultValue = visitLiteral(dv);
            anNode.values.put("value", defaultValue);
        }
        //TODO validate values
        return anNode;
    }

    private BlockStmt requireBlock(ParserRuleContext stmt) {
        if(stmt instanceof BlockStmtContext){
            return (BlockStmt)visit(stmt);
        }else{
            BlockStmt bs = newBlock();
            bs.statements.add((Statement)visit(stmt));
            popBlock();
            return bs;
        }
    }

}

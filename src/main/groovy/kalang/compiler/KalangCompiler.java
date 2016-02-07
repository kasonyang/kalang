package kalang.compiler;

import jast.ast.AstNode;
import jast.ast.ClassNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.util.OffsetRangeHelper;
import kalang.util.SourceParserFactory;
import kalang.util.TokenStreamFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

//import SourceParser.OffsetRange
public class KalangCompiler extends AstLoader {

    HashMap<String, String> sources = new HashMap();
    
    HashMap<String, CommonTokenStream> tokenStreams = new HashMap<>();

    HashMap<String, ClassNode> asts = new HashMap();

    HashMap<String, SourceParser> units = new HashMap();
    
    List<String> parseTasks = new LinkedList<>();

    HashMap<String, String> javaCodes = new HashMap();
    
    HashMap<String, TypeChecker> typeCheckers = new HashMap<>();

    AstLoader astLoader;
    
    SourceLoader sourceLoader;

    AstSemanticReporter astError;

    private AstSemanticErrorHandler astSemanticErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            reportAstNodeError(error.getDescription(),error.classNode.name,error.node);
        }
    };
    private SemanticErrorHandler semanticErrorHandler = new SemanticErrorHandler() {
        @Override
        public void handleSemanticError(SemanticErrorException see) {
            Token token = see.getToken();
            RuleContext tree = see.getTree();
            SourceParser parser = see.getSourceParser();
            OffsetRange offsetRange;
            if(token!=null){
                offsetRange = OffsetRangeHelper.getOffsetRange(token);
            }else{
                offsetRange = new OffsetRange(0, 0);
            }
            reportError(see.getDescription(), parser.getClassName(),offsetRange);
        }
    };
    private CompileErrorHandler compileErrorHandlerrrorHandler = new CompileErrorHandler() {
        @Override
        public void handleCompileError(CompileError error) {
            System.err.println(error.toString());
        }
    };

    public KalangCompiler() {
    }

    public KalangCompiler(AstLoader astLoader, SourceLoader sourceLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }
    
    public KalangCompiler(SourceLoader sourceLoader,AstLoader astLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
    }
    
    

    public KalangCompiler(AstLoader astLoader) {
        this.astLoader = astLoader;
    }

    public ClassNode[] getCompiledClasses() {
        return asts.values().toArray(new ClassNode[0]);
    }

    public void addSource(String cls, String text) {
        sources.put(cls, text);
    }

    protected void init() {
        units.clear();
        typeCheckers.clear();
        asts.clear();
        javaCodes.clear();
        Set<String> ks = sources.keySet();
        for (String k : ks) {
            String src = sources.get(k);
            createAst(k,src);
        }
    }

    protected void buildAst() {
        while(parseTasks.size()>0){
            String k = parseTasks.get(0);
            SourceParser cunit = units.get(k);
            cunit.compile(this);
            parseTasks.remove(k);
        }
    }

    public AstSemanticErrorHandler getAstSemanticErrorHandler() {
        return astSemanticErrorHandler;
    }

    public void setAstSemanticErrorHandler(AstSemanticErrorHandler astSemanticErrorHandler) {
        this.astSemanticErrorHandler = astSemanticErrorHandler;
    }
    
    

    protected void typeCheck() {
        Set<String> cnames = this.asts.keySet();
        for (String c : cnames) {
            TypeChecker typeChecker = new TypeChecker(this);
            typeChecker.setAstSemanticErrorHandler(astSemanticErrorHandler);
            typeCheckers.put(c, typeChecker);
            ClassNode cls = asts.get(c);
            typeChecker.check(cls);
        }
    }

    protected void codeGen() {
        Collection<ClassNode> cls = this.asts.values();
        for (ClassNode c : cls) {
            Ast2Java a2j = new Ast2Java();
            String source = a2j.generate(c);
            this.javaCodes.put(c.name, source);
        }
    }

    public void reportError(String msg, String className, OffsetRange loc) {
        String src = sources.get(className);
        int offset = loc.offset;
        int len = loc.length;
        CompileError ce = new CompileError(msg, className, src,loc.offset, offset+len);
        compileErrorHandlerrrorHandler.handleCompileError(ce);
    }

    public void reportAstNodeError(String msg, String className, AstNode node) {
        SourceParser unit = this.units.get(className);
        RuleContext treeOfAstNode = unit.getParseTree(node);
        RuleContext tree = treeOfAstNode;
        while(tree!=null && !(tree instanceof ParserRuleContext)){
            tree = tree.getParent();
        }
        if(tree==null){
            System.err.println("a wrong tree:" + treeOfAstNode);
            return ;
        }
        reportError(msg, className, OffsetRangeHelper.getOffsetRange((ParserRuleContext)tree));
    }

    public void compile() {
        init();
        buildAst();
        typeCheck();
        codeGen();
    }

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if (this.asts.containsKey(className)) {
            return this.asts.get(className);
        }
        if(this.sourceLoader!=null){
            String source = sourceLoader.loadSource(className);
            if(source!=null){
                return createAst(className,source);
            }
        }
        if (this.astLoader != null) {
            return astLoader.findAst(className);
        } else {
            return null;
        }
    }

    public HashMap<String, String> getSources() {
        return sources;
    }

    public HashMap<String, SourceParser> getUnits() {
        return units;
    }

    public HashMap<String, String> getJavaCodes() {
        return javaCodes;
    }

    public SemanticErrorHandler getSemanticErrorHandler() {
        return semanticErrorHandler;
    }

    public void setSemanticErrorHandler(SemanticErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }

    public CompileErrorHandler getCompileErrorHandlerrrorHandler() {
        return compileErrorHandlerrrorHandler;
    }

    public void setCompileErrorHandlerrrorHandler(CompileErrorHandler compileErrorHandlerrrorHandler) {
        this.compileErrorHandlerrrorHandler = compileErrorHandlerrrorHandler;
    }
    
    public TypeChecker getTypeChecker(String className){
        return typeCheckers.get(className);
    }
    
    public SourceParser getParser(String clsName){
        return units.get(clsName);
    }
    
    public ClassNode getClassNode(String clsName){
        return asts.get(clsName);
    }

    private ClassNode createAst(String className,String src) {
        CommonTokenStream tokens = TokenStreamFactory.createTokenStream(src);
        tokenStreams.put(className, tokens);
        SourceParser cunit = SourceParserFactory.createSourceParser(className, tokens);
            cunit.setSemanticErrorHandler(semanticErrorHandler);
            //SourceParser cunit = new SourceParser(k,p);
            cunit.importPackage("java.lang");
            cunit.importPackage("java.util");
            ClassNode cls = cunit.getAst();
            this.parseTasks.add(className);
            this.asts.put(className, cls);
            this.units.put(className, cunit);
            return cls;
    }
    
    public CommonTokenStream getTokenStream(String clsName){
        return tokenStreams.get(clsName);
    }
    
    public HashMap<String, CommonTokenStream> getTokenStream(){
        return tokenStreams;
    }

}

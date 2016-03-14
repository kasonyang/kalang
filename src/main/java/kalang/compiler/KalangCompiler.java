package kalang.compiler;

import kalang.ast.AstNode;
import kalang.ast.ClassNode;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import static kalang.compiler.CompilePhase.*;
/**
 * The core compiler
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangCompiler extends AstLoader {
        
    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final HashMap<String, String> sources = new HashMap();
    
    private int compilingPhase;

    @Nonnull
    private AstLoader astLoader = AstLoader.BASE_AST_LOADER;
    
    private CodeGenerator codeGenerator = new Ast2Java();

    @Nullable
    private SourceLoader sourceLoader;

    @Nonnull
    private AstSemanticErrorHandler astSemanticErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            reportAstNodeError(error.getDescription(), error.classNode.name, error.node);
            compileTargetPhase = PHASE_SEMANTIC;
        }
    };
    
    @Nonnull
    private SourceParsingErrorHandler sourceParsingErrorhandler = new SourceParsingErrorHandler() {
        @Override
        public void handleSemanticError(SourceParsingException see) {
            AstBuilder parser = see.getAstBuilder();
            OffsetRange offsetRange = see.getOffset();
            reportError(see.getDescription(), parser.getClassName(), offsetRange);
            compileTargetPhase = PHASE_PARSING;
        }
    };
    
    @Nonnull
    private CompileErrorHandler compileErrrorHandler = new CompileErrorHandler() {
        @Override
        public void handleCompileError(CompileError error) {
            System.err.println(error.toString());
        }
    };
    

    public KalangCompiler() {
    }

    public KalangCompiler(@Nonnull AstLoader astLoader,@Nonnull SourceLoader sourceLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(@Nonnull SourceLoader sourceLoader, @Nonnull AstLoader astLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(@Nonnull SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(@Nonnull AstLoader astLoader) {
        this.astLoader = astLoader;
    }

    /**
     * add source,which will be compiled
     * 
     * @param className the name of class
     * @param source the source of class
     */
    public void addSource(String className, String source) {
        sources.put(className, source);
        compilationUnits.put(className, createCompilationUnit(className, source));
    }

    @Nonnull
    public AstSemanticErrorHandler getAstSemanticErrorHandler() {
        return astSemanticErrorHandler;
    }

    public void setAstSemanticErrorHandler(@Nonnull AstSemanticErrorHandler astSemanticErrorHandler) {
        this.astSemanticErrorHandler = astSemanticErrorHandler;
    }

    protected void semanticAnalysis() {
        for (CompilationUnit cunit : compilationUnits.values()) {
            cunit.semanticAnalysis(astSemanticErrorHandler);
        }
    }

    public void reportError(String msg, String className, OffsetRange loc) {
        String src = sources.get(className);
        CompileError ce = new CompileError(msg, className, src, loc);
        compileErrrorHandler.handleCompileError(ce);
    }

    public void reportAstNodeError(String msg, String className, AstNode node) {
        reportError(msg, className, node.offset);
    }
    
    public void setCompileTargetPhase(int targetPhase){
        compileTargetPhase = targetPhase;
    }

    public int getCompileTargetPhase() {
        return compileTargetPhase;
    }

    /**
     * compile all sources
     */
    public void compile() {
        while(compilingPhase<compileTargetPhase){
            compilingPhase++;
            for(CompilationUnit unit:compilationUnits.values()){
                unit.compile(compilingPhase);
            }
        }
    }

    @Override
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        if (compilationUnits.containsKey(className)) {
            return compilationUnits.get(className).getAst();
        }
        if (this.sourceLoader != null) {
            String source = sourceLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(className, source).getAst();
            }
        }
        return astLoader.findAst(className);
    }

    @Nonnull
    public HashMap<String, String> getSources() {
        return sources;
    }

    @Nonnull
    public HashMap<String, CompilationUnit> getAllCompilationUnit() {
        return compilationUnits;
    }
    
    @Nullable
    public CompilationUnit getCompilationUnit(@Nonnull String className){
        return compilationUnits.get(className);
    }
    
    @Nonnull
    public SourceParsingErrorHandler getSourceParsingErrorhandler() {
        return sourceParsingErrorhandler;
    }

    public void setSourceParsingErrorhandler(@Nonnull SourceParsingErrorHandler sourceParsingErrorhandler) {
        this.sourceParsingErrorhandler = sourceParsingErrorhandler;
    }

    @Nonnull
    public CompileErrorHandler getCompileErrrorHandler() {
        return compileErrrorHandler;
    }

    public void setCompileErrrorHandler(@Nonnull CompileErrorHandler compileErrrorHandler) {
        this.compileErrrorHandler = compileErrrorHandler;
    }
    
    protected CompilationUnit newCompilationUnit(String className,String source){
        return new CompilationUnit(className, source,this);
    }

    private CompilationUnit createCompilationUnit(String className, String src) {
        CompilationUnit unit = newCompilationUnit(className, src);
        compilationUnits.put(className, unit);
        unit.setParsingErrorHandler(sourceParsingErrorhandler);
        unit.setSemanticErrorHandler(astSemanticErrorHandler);
        unit.setCodeGenerator(codeGenerator);
        unit.compile(compilingPhase);
        return unit;
    }

    @Nonnull
    public AstLoader getAstLoader() {
        return astLoader;
    }

    @Nullable
    public SourceLoader getSourceLoader() {
        return sourceLoader;
    }

    public int getCurrentCompilePhase() {
        return compilingPhase;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

}

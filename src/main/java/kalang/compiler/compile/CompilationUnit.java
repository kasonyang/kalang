package kalang.compiler.compile;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.semantic.AstBuilder;
import kalang.compiler.compile.semantic.MalformedAstException;
import kalang.compiler.compile.util.DiagnosisReporter;
import kalang.helper.PrintHelper;
import kalang.mixin.*;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kason Yang 
 */
public class CompilationUnit {

    private final KalangLexer lexer;
    private final KalangParser parser;
    private final AstBuilder astBuilder;

    private final KalangSource source;
    
    private final CompileContext context;

    private final TypeNameResolver typeNameResolver = new TypeNameResolver();

    public Map<String, MemberImport> staticImportMembers = new HashMap<>();

    public List<ClassNode> staticImportPaths = new LinkedList<>();

    public Map<String, MemberImport> importedMixinMethods = new HashMap<>();

    public List<ClassNode> importedMixinPaths = new LinkedList<>();

    public CompilationUnit(@Nonnull KalangSource source,CompileContext context) {
        this.source = source;
        this.context = context;
        lexer = context.createLexer(this,source.getText());
        parser = context.createParser(this,lexer);
        astBuilder = context.createAstBuilder(this,parser);
        //TODO astBuilder.getAstLoader() != context.getAstLoader?
        AstLoader astLoader = context.getAstLoader();
        //should move to configuration?
        astBuilder.importPackage("java.lang");
        astBuilder.importPackage("java.util");
        astBuilder.importPackage("java.net");
        astBuilder.importPackage("java.io");
        astBuilder.importPackage("java.nio");
        astBuilder.importPackage("kalang.io");
        astBuilder.importPackage("kalang.util");
        astBuilder.importPackage("kalang.lang");
        astBuilder.importStaticMember(astLoader.loadAst(PrintHelper.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(CollectionMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(StringMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(IOMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(DigestMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(DataMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(ObjectMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(PropertiesMixin.class.getName()));
        astBuilder.importMixinMethod(astLoader.loadAst(MapMixin.class.getName()));
        astBuilder.parseInit();
    }

    public void analyzeSemantic() {
        SemanticAnalyzer smtAnalyzer = context.createSemanticAnalyzer(this);
        if (smtAnalyzer == null) {
            throw new IllegalArgumentException("SemanticAnalyzer is missing");
        }
        smtAnalyzer.semanticAnalyze();
    }

    public void generateClass() {
        DiagnosisReporter dnReporter = new DiagnosisReporter(this);
        CodeGenerator codeGenerator = context.createCodeGenerator(this);
        if(codeGenerator == null){
            throw new IllegalStateException("CodeGenerator is missing");
        }
        try {
            codeGenerator.generateCode();
        } catch (MalformedAstException ex) {
            dnReporter.report(Diagnosis.Kind.ERROR, ex.getMessage(), ex.getMalformedNode().offset);
        }
    }

    @Nonnull
    public ClassNode getAst() {
        return astBuilder.getAst();
    }

    @Nonnull
    public AstBuilder getAstBuilder() {
        return astBuilder;
    }

    public KalangLexer getLexer() {
        return lexer;
    }

    public KalangParser getParser() {
        return parser;
    }

    public KalangSource getSource() {
        return source;
    }

    public CompileContext getCompileContext() {
        return context;
    }

    public TypeNameResolver getTypeNameResolver() {
        return typeNameResolver;
    }

    public static class MemberImport {
        public ClassNode classNode;
        public String member;
        public MemberImport(ClassNode classNode, String member) {
            this.classNode = classNode;
            this.member = member;
        }
    }

}

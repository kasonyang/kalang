package kalang.compiler.compile;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParserBaseVisitor;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kason Yang
 */
public class ClassNodeBuilder extends KalangParserBaseVisitor<Object> {

    private ClassNode topClass;

    private ClassNode thisClazz;
    
    private Map<ClassNode,ParserRuleContext> defContext = new HashMap();

    private boolean inScriptMode = false;
    
    private boolean isScript = false;
    
    private ObjectType optionScriptBaseType = null;

    AstBuilder astBuilder;
    private final CompilationUnit compilationUnit;
    private final DiagnosisReporter diagnosisReporter;

    public ClassNodeBuilder(CompilationUnit compilationUnit, AstBuilder astBuilder) {
        this.compilationUnit = compilationUnit;
        this.astBuilder = astBuilder;
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
    }
    
    public ClassNode build(KalangParser.CompilationUnitContext ctx){
        this.visitCompilationUnit(ctx);
        return topClass;
    }

    @Override
    public Object visitCompileOption(KalangParser.CompileOptionContext ctx) {
        String optionLine = ctx.getText().substring(1);//remove # symbol
        String[] optionParts = optionLine.split(" ",2);
        String optionName = optionParts[0];
        //TODO report option error
        if ("script".equals(optionName)) {
            String optionValue = optionParts.length > 1 ? optionParts[1].trim() : "";
            if (!optionValue.isEmpty()) {
                try {
                    this.optionScriptBaseType = Types.getClassType(this.loadAst(optionValue));
                } catch (AstNotFoundException ex) {
                    this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "class "+optionValue+" not found");
                }
            }
        }
        return super.visitCompileOption(ctx);
    }
    
    

    @Override
    public Object visitScriptDef(KalangParser.ScriptDefContext ctx) {
        this.isScript = true;
        this.inScriptMode = true;
        //FIXME fix fileName
        //thisClazz.fileName = this.compilationUnit.getSource().getFileName();
        String className = astBuilder.getClassName();
        int modifier = Modifier.PUBLIC;
        topClass = thisClazz = new ClassNode(className, modifier);
        this.defContext.put(topClass, ctx);
        super.visitScriptDef(ctx);
        return null;
    }    

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        ClassNode oldClass = thisClazz;
        Token nameIdentifier = ctx.name;
        int modifier = astBuilder.parseModifier(ctx.varModifier());
        if (inScriptMode) {
            modifier |= Modifier.STATIC;
        }
        Token classKind = ctx.classKind;
        boolean isInterface = false;
        if (classKind != null) {
            if (classKind.getText().equals("interface")) {
                modifier |= Modifier.ABSTRACT | Modifier.INTERFACE;
                isInterface = true;
            }
        }
        String classDefName;
        if (oldClass != null) {
            if (nameIdentifier == null) {
                diagnosisReporter.report(Diagnosis.Kind.ERROR,"Identifier excepted", ctx);
                return null;
            }
            classDefName = oldClass.name + "$" + nameIdentifier.getText();
        } else {
            classDefName = astBuilder.getClassName();
        }
        ClassNode theClass = thisClazz = new ClassNode(classDefName, modifier);
        astBuilder.thisClazz = thisClazz;
        this.defContext.put(theClass, ctx);
        if (oldClass == null) {
            this.topClass = theClass;
        } else {
            oldClass.classes.add(thisClazz);
            thisClazz.enclosingClass = oldClass;
        }
        //FIXME fix file name
        //thisClazz.fileName = this.compilationUnit.getSource().getFileName();
        boolean oldScriptMode = this.inScriptMode;
        this.inScriptMode = false;
        visit(ctx.classBody());
        this.inScriptMode = oldScriptMode;
        astBuilder.mapAst(thisClazz, ctx);
        thisClazz = oldClass;
        return null;
    }

    private boolean isNonStaticInnerClass(ClassNode clazz) {
        return clazz.enclosingClass != null && !Modifier.isStatic(clazz.modifier);
    }

    private boolean isDeclaringNonStaticInnerClass() {
        return isNonStaticInnerClass(thisClazz);
    }
    
    public ClassNode getClassNode(){
        return topClass;
    }
    
    public ParserRuleContext getClassNodeDefContext(ClassNode classNode){
        return this.defContext.get(classNode);
    }

    public boolean isScript() {
        return isScript;
    }
    
    public ObjectType getOptionScriptBaseType() {
        return this.optionScriptBaseType;
    }
    
    private ClassNode loadAst(String className) throws AstNotFoundException{
        AstLoader astLoader = this.compilationUnit.getCompileContext().getAstLoader();
        return astLoader.loadAst(className);
    }
    
}

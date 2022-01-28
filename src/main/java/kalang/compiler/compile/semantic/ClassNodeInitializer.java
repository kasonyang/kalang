package kalang.compiler.compile.semantic;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.CompilationUnit;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kason Yang
 */
public class ClassNodeInitializer extends AstBuilderBase {

    private final String className;

    private ClassNode topClass;

    private ClassNode thisClazz;
    
    private Map<ClassNode,ParserRuleContext> defContext = new HashMap<>();

    private boolean inScriptMode = false;
    
    private boolean isScript = false;

    private final CompilationUnit compilationUnit;

    public ClassNodeInitializer(CompilationUnit compilationUnit) {
        super(compilationUnit);
        className = compilationUnit.getSource().getClassName();
        this.compilationUnit = compilationUnit;
    }

    @Override
    ClassNode getCurrentClass() {
        return thisClazz;
    }

    @Override
    ClassNode getTopClass() {
        return topClass;
    }

    public ClassNode build(ParserRuleContext ctx){
        visit(ctx);
        return topClass;
    }

    @Override
    public Object visitScriptDef(KalangParser.ScriptDefContext ctx) {
        this.isScript = true;
        this.inScriptMode = true;
        int modifier = Modifier.PUBLIC;
        topClass = thisClazz = new ClassNode(className, modifier);
        thisClazz.setFileName(this.compilationUnit.getSource().getFileName());
        this.defContext.put(topClass, ctx);
        super.visitScriptDef(ctx);
        return null;
    }    

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        ClassNode oldClass = thisClazz;
        Token nameIdentifier = ctx.name;
        int modifier = (int) parseModifier(ctx.varModifier());
        if (inScriptMode) {
            modifier |= Modifier.STATIC;
        }
        Token classKind = ctx.classKind;
        if (classKind != null) {
            if (classKind.getText().equals("interface")) {
                modifier |= Modifier.ABSTRACT | Modifier.INTERFACE;
            }
        }
        String classDefName;
        if (oldClass != null) {
            if (nameIdentifier == null) {
                handleSyntaxError("Identifier excepted", offset(ctx));
                return null;
            }
            classDefName = oldClass.getName() + "$" + nameIdentifier.getText();
        } else {
            classDefName = className;
        }
        ClassNode theClass = thisClazz = new ClassNode(classDefName, modifier);
        this.defContext.put(theClass, ctx);
        if (oldClass == null) {
            this.topClass = theClass;
        } else {
            oldClass.classes.add(thisClazz);
            thisClazz.enclosingClass = oldClass;
        }
        thisClazz.setFileName(compilationUnit.getSource().getFileName());
        boolean oldScriptMode = this.inScriptMode;
        this.inScriptMode = false;
        visit(ctx.classBody());
        this.inScriptMode = oldScriptMode;
        mapAst(thisClazz, ctx);
        thisClazz = oldClass;
        return null;
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
    
}

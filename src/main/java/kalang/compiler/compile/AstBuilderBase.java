package kalang.compiler.compile;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParserBaseVisitor;
import kalang.compiler.ast.AstNode;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.InvalidModifierException;
import kalang.compiler.util.ModifierUtil;
import kalang.compiler.util.OffsetRangeHelper;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Modifier;

public class AstBuilderBase extends KalangParserBaseVisitor<Object> {

    protected final DiagnosisReporter diagnosisReporter;
    private CompilationUnit compilationUnit;
    public AstBuilderBase(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
    }

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

}

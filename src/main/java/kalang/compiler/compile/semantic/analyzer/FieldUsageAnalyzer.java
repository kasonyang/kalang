package kalang.compiler.compile.semantic.analyzer;

import kalang.compiler.ast.AstVisitor;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.FieldExpr;
import kalang.compiler.ast.FieldNode;

import java.util.HashSet;
import java.util.Set;


/**
 * @author lbqh
 */
public class FieldUsageAnalyzer extends AstVisitor {


    private Set<FieldNode> usedFields;

    public void analyzer(ClassNode classNode){
        this.usedFields = new HashSet<>();
        visit(classNode);
    }

    public Set<FieldNode> getUsedFields() {
        return new HashSet<>(usedFields);
    }

    @Override
    public Object visitFieldExpr(FieldExpr node) {
        FieldNode fn = node.getField().getFieldNode();
        usedFields.add(fn);
        return super.visitFieldExpr(node);
    }
}

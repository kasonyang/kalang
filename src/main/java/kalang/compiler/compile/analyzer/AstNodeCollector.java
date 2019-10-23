package kalang.compiler.compile.analyzer;

import kalang.compiler.ast.AstNode;
import kalang.compiler.ast.AstVisitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KasonYang
 */
public class AstNodeCollector extends AstVisitor {

    private List collectList;

    private Class collectClass;

    public <T> List<T> collect(AstNode node, Class<T> clazz) {
        collectList = new LinkedList();
        collectClass = clazz;
        visit(node);
        return new ArrayList<T>(collectList);
    }

    @Override
    public Object visit(AstNode node) {
        if (collectClass.isAssignableFrom(node.getClass())) {
            collectList.add(node);
        }
        return super.visit(node);
    }
}

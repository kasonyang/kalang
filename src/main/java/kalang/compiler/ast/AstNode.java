package kalang.compiler.ast;

import kalang.compiler.compile.OffsetRange;
import kalang.mixin.CollectionMixin;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The base class of any ast node
 *
 * @author Kason Yang
 */
public abstract class AstNode {

    public OffsetRange offset;

    public List<AstNode> getChildren() {
        return noChildren();
    }

    public abstract void updateChildren(ChildUpdater childUpdater);

    protected static <T extends AstNode> T doUpdateChild(T value, ChildUpdater childUpdater) {
        if (value == null) {
            return null;
        }
        return childUpdater.update(value);
    }

    protected static <T extends AstNode> void doUpdateChildren(T[] value, ChildUpdater childUpdater) {
        if (value == null) {
            return;
        }
        for (int i = 0; i < value.length; i++) {
            value[i] = childUpdater.update(value[i]);
        }
    }

    protected static <T extends AstNode> void doUpdateChildren(List<T> value, ChildUpdater childUpdater) {
        if (value == null) {
            return;
        }
        value.replaceAll(childUpdater::update);
    }

    protected static <T> List<T> noNullChildren(T... elements) {
        return CollectionMixin.findAll(Arrays.asList(elements), Objects::nonNull);
    }

    protected static <T> List<T> noChildren() {
        return Collections.emptyList();
    }

    protected static void addChild(List<AstNode> list, @Nullable AstNode[] nodes) {
        if (nodes == null) {
            return;
        }
        list.addAll(Arrays.asList(nodes));
    }

    protected static void addChild(List<AstNode> list, @Nullable List nodes) {
        if (nodes != null) {
            list.addAll(nodes);
        }
    }

    protected static void addChild(List<AstNode> list, @Nullable AstNode node) {
        if (node != null) {
            list.add(node);
        }
    }


}

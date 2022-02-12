package kalang.compiler.compile.codegen.op;

import java.util.List;

/**
 * @author KasonYang
 */
public interface OpcodeOptimizer {

    void optimize(List<OpBase> opcodes, List<Attribute> attributes);

}

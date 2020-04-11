package kalang.compiler.compile.semantic;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.MethodNode;
import lombok.Getter;

/**
 * @author KasonYang
 */
@Getter
public class MissingParamMethodInfo {

    private MethodNode missingParamMethod;

    private MethodNode originMethod;

    private KalangParser.MethodDeclContext methodDeclContext;

    public MissingParamMethodInfo(MethodNode missingParamMethod, MethodNode originMethod, KalangParser.MethodDeclContext methodDeclContext) {
        this.missingParamMethod = missingParamMethod;
        this.originMethod = originMethod;
        this.methodDeclContext = methodDeclContext;
    }

}

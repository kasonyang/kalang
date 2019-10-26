package kalang.compiler.compile.analyzer;

import kalang.compiler.ast.AstVisitor;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.DiagnosisReporter;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import kalang.compiler.util.ClassTypeUtil;
import kalang.compiler.util.MethodUtil;
import kalang.mixin.CollectionMixin;

/**
 * @author KasonYang
 */
public class OverrideAnalyzer extends AstVisitor {

    private DiagnosisReporter diagnosisReporter;

    public OverrideAnalyzer(DiagnosisReporter diagnosisReporter) {
        this.diagnosisReporter = diagnosisReporter;
    }

    public void analyze(ClassNode clazz) {
        visit(clazz);
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        ClassNode clazz = node.getClassNode();
        String mStr = MethodUtil.getDeclarationKey(node);
        String methodStr = MethodUtil.toString(node);

        // check duplicate methods
        MethodNode methodWithSameSignature = CollectionMixin.find(clazz.getDeclaredMethodNodes(), m -> m != node && MethodUtil.getDeclarationKey(m).equals(mStr));
        if (methodWithSameSignature != null) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"declare method is duplicated:" + mStr, node.offset);
        }

        // check override
        boolean isOverriding = CollectionMixin.find(node.getAnnotations(), a -> Override.class.getName().equals(a.getAnnotationType().name)) != null;
        ObjectType superType = clazz.getSuperType();
        if(superType==null){//the superType of interface may be null
            superType = Types.getRootType();
        }
        MethodDescriptor overriddenMd = ClassTypeUtil.getMethodDescriptor(superType, mStr, clazz, true,true);
        if(overriddenMd==null){
            overriddenMd = ClassTypeUtil.getMethodDescriptor(clazz.getInterfaces(), mStr, clazz, true,true);
        }
        if(isOverriding && overriddenMd==null){
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"method " + methodStr + " does not override or implement a method from a supertype", node.offset);
        }
        if(!isOverriding && overriddenMd!=null && !"<init>".equals(overriddenMd.getName())){
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"method " + methodStr + " overrides or implements a method from a supertype", node.offset);
        }
        return null;
    }
}

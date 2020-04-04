package kalang.compiler.compile.analyzer;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.DiagnosisReporter;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import kalang.compiler.util.MethodUtil;
import kalang.mixin.CollectionMixin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author KasonYang
 */
public class MethodDeclarationAnalyzer {

    private DiagnosisReporter diagnosisReporter;

    public MethodDeclarationAnalyzer(DiagnosisReporter diagnosisReporter) {
        this.diagnosisReporter = diagnosisReporter;
    }

    public void analyze(ClassNode clazz) {
        Set<String> declaredMethods = new HashSet<>();
        ObjectType superType = clazz.getSuperType();
        if (superType == null) {//the superType of interface may be null
            superType = Types.getRootType();
        }
        HashMap<String, MethodDescriptor> parentMethodsMap = new HashMap<>();
        for (ObjectType itf : clazz.getInterfaces()) {
            MethodDescriptor[] itfMethods = itf.getMethodDescriptors(clazz, true, true);
            for (MethodDescriptor m : itfMethods) {
                parentMethodsMap.put(m.getDeclarationKey(), m);
            }
        }
        MethodDescriptor[] superMethods = superType.getMethodDescriptors(clazz, true, true);
        for (MethodDescriptor m : superMethods) {
            parentMethodsMap.put(m.getDeclarationKey(), m);
        }
        for (MethodNode node : clazz.getDeclaredMethodNodes()) {
            String declarationKey = MethodUtil.getDeclarationKey(node);
            if (declaredMethods.contains(declarationKey)) {
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "declare method is duplicated:" + declarationKey, node.offset);
            }
            declaredMethods.add(declarationKey);
            // check override
            boolean isOverriding = CollectionMixin.find(node.getAnnotations(), a -> Override.class.getName().equals(a.getAnnotationType().name)) != null;
            MethodDescriptor overriddenMd = parentMethodsMap.get(declarationKey);
            if (isOverriding && overriddenMd == null) {
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "method " + MethodUtil.toString(node) + " does not override or implement a method from a supertype", node.offset);
            }
            if (!isOverriding && overriddenMd != null && !"<init>".equals(overriddenMd.getName())) {
                diagnosisReporter.report(Diagnosis.Kind.ERROR, "method " + MethodUtil.toString(node) + " overrides or implements a method from a supertype", node.offset);
            }
        }
    }

}

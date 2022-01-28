package test.kalang.compiler;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.lang.reflect.Method;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class AsmTest extends ClassLoader {

    public void main() throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_6, ACC_PUBLIC, "demo/HelloWorld", null, "java/lang/Object", null);
        MethodVisitor md = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, "test", "()I", null, null);
        md.visitInsn(LCONST_1);
        md.visitInsn(LCONST_1);
        md.visitInsn(LADD);
        md.visitVarInsn(ISTORE, 0);
        md.visitVarInsn(ISTORE, 1);
        md.visitVarInsn(ILOAD, 1);
        md.visitInsn(IRETURN);
        md.visitMaxs(0,0);
        md.visitEnd();
        byte[] clazz = cw.toByteArray();
        Class<?> clz = defineClass("demo.HelloWorld", clazz, 0, clazz.length);
        Object inst = clz.newInstance();
        Method method = inst.getClass().getMethod("test");
        Object result = method.invoke(inst);
        System.out.println("result:" + result);
    }

}

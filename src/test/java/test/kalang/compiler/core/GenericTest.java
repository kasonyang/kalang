package test.kalang.compiler.core;

import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class GenericTest {

    @Test
    public void testGenericMethod() throws MethodNotFoundException, AmbiguousMethodException {
        ObjectType type = Types.requireClassType(Collections.class.getName());
        MethodDescriptor[] mds = type.getMethodDescriptors(null, "singletonList", true, true);
        StaticInvokeExpr staticInvoke = StaticInvokeExpr.create(new ClassReference(type.getClassNode()), "singletonList", new ExprNode[]{new ConstExpr("test")});
        Assert.assertNotNull(staticInvoke);
        MethodDescriptor md = staticInvoke.getMethod();
        ClassType returnType = (ClassType) md.getReturnType();
        Type[] typeArgs = returnType.getTypeArguments();
        Assert.assertEquals(1,typeArgs.length);
        Assert.assertEquals(Types.getStringClassType(),typeArgs[0]);
    }

    @Test
    public void testGenericMethod2() throws MethodNotFoundException, AmbiguousMethodException {
        ObjectType type = Types.requireClassType(Collections.class.getName());
        ObjectType integerType = Types.getIntClassType();
        ObjectType rawLinkListType = Types.requireClassType(LinkedList.class.getName());
        ClassType linkListType = Types.getClassType(rawLinkListType.getClassNode(), new Type[]{integerType});
        StaticInvokeExpr staticInvoke = StaticInvokeExpr.create(new ClassReference(type.getClassNode()), "min", new ExprNode[]{new NewObjectExpr(linkListType)});
        Assert.assertNotNull(staticInvoke);
        MethodDescriptor md = staticInvoke.getMethod();
        ClassType returnType = (ClassType) md.getReturnType();
        Assert.assertEquals(integerType,returnType);
    }

}

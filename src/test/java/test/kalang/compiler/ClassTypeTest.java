package test.kalang.compiler;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.ClassNodeLoader;
import kalang.compiler.compile.ClassNodeNotFoundException;
import kalang.compiler.compile.DefaultClassNodeLoader;
import kalang.compiler.core.*;
import kalang.mixin.CollectionMixin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Kason Yang 
 */
public class ClassTypeTest {
    
    public ClassTypeTest() {
    }
    
    @Test
    public void testEarsedType() throws ClassNodeNotFoundException {
        ClassNodeLoader astLoader = new DefaultClassNodeLoader();
        ClassType listType = Types.getClassType(astLoader.loadClassNode("java.util.List"),new Type[0]);
        ClassType arrayListType = Types.getClassType(astLoader.loadClassNode("java.util.ArrayList"),new Type[0]);
        assertTrue(arrayListType.isSubTypeOf(listType));
        
    }
    
    @Test
    public void test() throws ClassNodeNotFoundException {
        ClassNodeLoader astLoader = new DefaultClassNodeLoader();
        ClassNode listClass = astLoader.loadClassNode(List.class.getName());
        ClassNode arrayListClass = astLoader.loadClassNode(ArrayList.class.getName());
        
        Type[] paramTypes = new Type[]{Types.getStringClassType()};
        ObjectType listType = Types.getClassType(listClass,paramTypes );
        ArrayType listArrayType = Types.getArrayType(listType);
        ObjectType arrayListType = Types.getClassType(arrayListClass,paramTypes );
        ArrayType arrayListArrayType = Types.getArrayType(arrayListType);
        assertTrue(arrayListType.isSubTypeOf(listType));
        assertTrue(listArrayType.isAssignableFrom(arrayListArrayType));

        String[] mds = CollectionMixin.map(
                listType.getMethodDescriptors(null, false, true),
                String.class,
                Object::toString
        );
        Arrays.sort(mds);
        assertEquals("public abstract T[] toArray(T[] arg0)\n" +
                "public abstract boolean add(java.lang.String arg0)\n" +
                "public abstract boolean addAll(int arg0,java.util.Collection<? extends java.lang.String> arg1)\n" +
                "public abstract boolean addAll(java.util.Collection<? extends java.lang.String> arg0)\n" +
                "public abstract boolean contains(java.lang.Object arg0)\n" +
                "public abstract boolean containsAll(java.util.Collection<? extends java.lang.Object> arg0)\n" +
                "public abstract boolean isEmpty()\n" +
                "public abstract boolean remove(java.lang.Object arg0)\n" +
                "public abstract boolean removeAll(java.util.Collection<? extends java.lang.Object> arg0)\n" +
                "public abstract boolean retainAll(java.util.Collection<? extends java.lang.Object> arg0)\n" +
                "public abstract int indexOf(java.lang.Object arg0)\n" +
                "public abstract int lastIndexOf(java.lang.Object arg0)\n" +
                "public abstract int size()\n" +
                "public abstract java.lang.Object[] toArray()\n" +
                "public abstract java.lang.String get(int arg0)\n" +
                "public abstract java.lang.String remove(int arg0)\n" +
                "public abstract java.lang.String set(int arg0,java.lang.String arg1)\n" +
                "public abstract java.util.Iterator<java.lang.String> iterator()\n" +
                "public abstract java.util.List<java.lang.String> subList(int arg0,int arg1)\n" +
                "public abstract java.util.ListIterator<java.lang.String> listIterator()\n" +
                "public abstract java.util.ListIterator<java.lang.String> listIterator(int arg0)\n" +
                "public abstract void add(int arg0,java.lang.String arg1)\n" +
                "public abstract void clear()\n" +
                "public boolean equals(java.lang.Object arg0)\n" +
                "public boolean removeIf(java.util.function.Predicate<? super java.lang.String> arg0)\n" +
                "public final native java.lang.Class<? extends java.lang.Object> getClass()\n" +
                "public final native void notify()\n" +
                "public final native void notifyAll()\n" +
                "public final native void wait(long arg0)\n" +
                "public final void wait()\n" +
                "public final void wait(long arg0,int arg1)\n" +
                "public java.lang.String toString()\n" +
                "public java.util.Spliterator<java.lang.String> spliterator()\n" +
                "public java.util.stream.Stream<java.lang.String> parallelStream()\n" +
                "public java.util.stream.Stream<java.lang.String> stream()\n" +
                "public native int hashCode()\n" +
                "public void forEach(java.util.function.Consumer<? super java.lang.String> arg0)\n" +
                "public void replaceAll(java.util.function.UnaryOperator<java.lang.String> arg0)\n" +
                "public void sort(java.util.Comparator<? super java.lang.String> arg0)", String.join("\n", mds));
        
        //assertTrue(listType.isSubTypeOf(Types.getRootType()));
    }
    
}

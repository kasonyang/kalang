
package kalang.core;
import jast.ast.ClassNode;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.compiler.AstLoader;
import kalang.compiler.AstNotFoundException;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class Types {
    
    private static Map<String,PrimitiveType> primitiveTypes = new HashMap();
    private static Map<Type,ArrayType> arrayTypes = new HashMap();
    
    private static Map<ClassNode,ClassType> classTypes  = new HashMap<>();
    
    public static final PrimitiveType 
            INT_TYPE = getPrimitiveType("int")
           , LONG_TYPE = getPrimitiveType("long")
            ,FLOAT_TYPE = getPrimitiveType("float")
            ,DOUBLE_TYPE = getPrimitiveType("double")
            ,BYTE_TYPE = getPrimitiveType("byte")
            ,BOOLEAN_TYPE = getPrimitiveType("boolean")
            ,CHAR_TYPE = getPrimitiveType("char")
            ,NULL_TYPE = getPrimitiveType("null")
            ,VOID_TYPE = getPrimitiveType("void")
    ;
    
        private static final String SHORT_PRIMITIVE_TYPE = "short",
            INT_PRIMITIVE_TYPE = "int",
            LONG_PRIMITIVE_TYPE = "long",
            FLOAT_PRIMITIVE_TYPE = "float",
            DOUBLE_PRIMITIVE_TYPE = "double",
            BOOLEAN_PRIMITIVE_TYPE = "boolean",
            BYTE_PRIMITIVE_TYPE = "byte",
            CHAR_PRIMITIVE_TYPE = "char",
            NULL_PRIMITIVE_TYPE = "null",
            VOID_PRIMITIVE_TYPE = "void";

    public static final String FLOAT_CLASS_NAME = "java.lang.Float";
    public static final String DOUBLE_CLASS_NAME = "java.lang.Double";

    public static final String INT_CLASS = "java.lang.Integer";
    public static final String LONG_CLASS = "java.lang.Long";

    public static final String BOOLEAN_CLASS = "java.lang.Boolean";

    public static final String CHAR_CLASS = "java.lang.Character";

    public static final String STRING_CLASS = "java.lang.String";

    public static final String VOID_CLASS = "java.lang.Void";

    public static final String SHORT_CLASS = "java.lang.Short";

    public static final String BYTE_CLASS = "java.lang.Byte";

    public static final String ROOT_CLASS = "java.lang.Object";

    
    public static final ClassType INT_CLASS_TYPE
            ,LONG_CLASS_TYPE,FLOAT_CLASS_TYPE
                    ,DOUBLE_CLASS_TYPE,ROOT_TYPE,VOID_CLASS_TYPE;
    public static final ClassType STRING_CLASS_TYPE;
    public static final ClassType BOOLEAN_CLASS_TYPE;
    public static final ClassType CHAR_CLASS_TYPE;
    public static final ClassType SHORT_CLASS_TYPE;
    public static final String MAP_IMPL_CLASS_NAME = "java.util.Map";
    public static final ClassType MAP_IMPL_TYPE;
    public static final String LIST_IMPL_CLASS_NAME = "java.util.LinkedList";
    public static final ClassType LIST_CLASS_TYPE ;
    private final static DualHashBidiMap<PrimitiveType,ClassType> primitive2class;
    private final static PrimitiveType SHORT_TYPE = getPrimitiveType("short");
    private final static ClassType BYTE_CLASS_TYPE ;
    
    static {
        try {
            AstLoader astLoader = AstLoader.BASE_AST_LOADER;
            INT_CLASS_TYPE = getClassType(astLoader.loadAst(INT_CLASS));
            LONG_CLASS_TYPE = getClassType(astLoader.loadAst(LONG_CLASS));
            FLOAT_CLASS_TYPE = getClassType(astLoader.loadAst(FLOAT_CLASS_NAME));
            DOUBLE_CLASS_TYPE = getClassType(astLoader.loadAst(DOUBLE_CLASS_NAME));
            ROOT_TYPE = getClassType(astLoader.loadAst(ROOT_CLASS));
            VOID_CLASS_TYPE = getClassType(astLoader.loadAst(VOID_CLASS));
            STRING_CLASS_TYPE = getClassType(astLoader.loadAst(STRING_CLASS));
            BOOLEAN_CLASS_TYPE = getClassType(astLoader.loadAst(BOOLEAN_CLASS));
            CHAR_CLASS_TYPE = getClassType(astLoader.loadAst(CHAR_CLASS));
            SHORT_CLASS_TYPE = getClassType(astLoader.loadAst(SHORT_CLASS));
            BYTE_CLASS_TYPE = getClassType(astLoader.loadAst(SHORT_CLASS));
            MAP_IMPL_TYPE = getClassType(astLoader.loadAst(MAP_IMPL_CLASS_NAME));
            LIST_CLASS_TYPE = getClassType(astLoader.loadAst(LIST_IMPL_CLASS_NAME));
        } catch (AstNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        primitive2class = new DualHashBidiMap<>();
        primitive2class.put(INT_TYPE, INT_CLASS_TYPE);
        primitive2class.put(LONG_TYPE, LONG_CLASS_TYPE);
        primitive2class.put(FLOAT_TYPE, FLOAT_CLASS_TYPE);
        primitive2class.put(DOUBLE_TYPE, DOUBLE_CLASS_TYPE);
        primitive2class.put(CHAR_TYPE, CHAR_CLASS_TYPE);
        primitive2class.put(BOOLEAN_TYPE, BOOLEAN_CLASS_TYPE);
        primitive2class.put(VOID_TYPE, VOID_CLASS_TYPE);
        primitive2class.put(SHORT_TYPE, SHORT_CLASS_TYPE);
        primitive2class.put(BYTE_TYPE, BYTE_CLASS_TYPE);
        //m.put(NULL_TYPE, "null");//TODO does null has class type?
    }
    
    private static ClassType[] numberClass = new ClassType[]{
        INT_CLASS_TYPE, LONG_CLASS_TYPE, FLOAT_CLASS_TYPE, DOUBLE_CLASS_TYPE
    };

    private static PrimitiveType[] numberPrimitive = new PrimitiveType[]{
        INT_TYPE, LONG_TYPE, FLOAT_TYPE, DOUBLE_TYPE
    };
    
    public static PrimitiveType getPrimitiveType(String name){
        PrimitiveType t = primitiveTypes.get(name);
        if(t ==null){
            t = new PrimitiveType(name);
            primitiveTypes.put(name, t);
        }
        return t;
    }
    
    public static ArrayType getArrayType(Type componentType){
        ArrayType at = arrayTypes.get(componentType);
        if(at==null){
            at = new ArrayType(componentType);
            arrayTypes.put(componentType,at);
        }
        return at;
    }
    
    public static ClassType getClassType(ClassNode clazz){
        ClassType ct = classTypes.get(clazz);
        if(ct==null){
            ct = new ClassType(clazz);
            classTypes.put(clazz, ct);
        }
        return ct;
    }
    
    public static PrimitiveType getPrimitiveType(ClassType classType){
        return primitive2class.getKey(classType);
    }
    
    public static ClassType getClassType(PrimitiveType primitiveType){
        return primitive2class.get(primitiveType);
    }
    
     public static boolean isNumberPrimitive(Type type) {
        return Arrays.asList(numberPrimitive).contains(type);
    }

    public static boolean isNumberClass(Type type) {
        return Arrays.asList(numberClass).contains(type);
    }

    public static boolean isNumber(Type type) {
        return isNumberPrimitive(type) || isNumberClass(type);
    }

    public static boolean isBoolean(Type type) {
        return type.equals(BOOLEAN_CLASS_TYPE) || type.equals(BOOLEAN_TYPE);
    }

    public  static Type getHigherType(Type type1, Type type2) {
        if (
                type1.equals(DOUBLE_CLASS_TYPE) 
                || type1.equals(DOUBLE_TYPE)
                || type2.equals(DOUBLE_CLASS_TYPE)
                || type2.equals(DOUBLE_TYPE)
                ) {
            return DOUBLE_TYPE;
        }
        if (
                type1.equals(FLOAT_CLASS_TYPE)
                || type1.equals(FLOAT_TYPE)
                || type2.equals(FLOAT_CLASS_TYPE)
                || type2.equals(FLOAT_TYPE)
                ) {
            return FLOAT_TYPE;
        }
        if (
                type1.equals(LONG_CLASS_TYPE) 
                || type1.equals(LONG_TYPE)
                || type2.equals(LONG_CLASS_TYPE)
                || type2.equals(LONG_TYPE)) {
            return LONG_TYPE;
        }
        return INT_TYPE;
    }


}

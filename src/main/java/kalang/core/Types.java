
package kalang.core;
import kalang.ast.ClassNode;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.compiler.AstLoader;
import kalang.AstNotFoundException;
import kalang.util.TypeUtil;
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
    
    private static Map<String,WildcardType> wildcardTypes = new HashMap();
    
    private static final Map<String,ParameterizedType> parameterizedTypes = new HashMap();
    
    private final static DualHashBidiMap<PrimitiveType,String> primitive2class = new DualHashBidiMap<>();;
    
    public static final PrimitiveType 
            BOOLEAN_TYPE = getPrimitiveType("boolean")
            ,BYTE_TYPE = getPrimitiveType("byte")
            ,CHAR_TYPE = getPrimitiveType("char")
            ,SHORT_TYPE = getPrimitiveType("short")
            ,INT_TYPE = getPrimitiveType("int")
           , LONG_TYPE = getPrimitiveType("long")
            ,FLOAT_TYPE = getPrimitiveType("float")
            ,DOUBLE_TYPE = getPrimitiveType("double")
            ,NULL_TYPE = getPrimitiveType("null")
            ,VOID_TYPE = getPrimitiveType("void")
    ;

    public static final String FLOAT_CLASS_NAME = "java.lang.Float";
    public static final String DOUBLE_CLASS_NAME = "java.lang.Double";

    public static final String INT_CLASS_NAME = "java.lang.Integer";
    public static final String LONG_CLASS_NAME = "java.lang.Long";

    public static final String BOOLEAN_CLASS_NAME = "java.lang.Boolean";

    public static final String CHAR_CLASS_NAME = "java.lang.Character";

    public static final String STRING_CLASS_NAME = "java.lang.String";

    public static final String VOID_CLASS_NAME = "java.lang.Void";

    public static final String SHORT_CLASS_NAME = "java.lang.Short";

    public static final String BYTE_CLASS_NAME = "java.lang.Byte";

    public static final String ROOT_CLASS_NAME = "java.lang.Object";
    
    public static final String MAP_IMPL_CLASS_NAME = "java.util.HashMap";
    
    public static final String LIST_IMPL_CLASS_NAME = "java.util.LinkedList";
//    private static final ClassType VoidClassType;
//    private static final ClassType booleanClassType;
//    private static final ClassType byteClassType;
//    private static final ClassType charClassType;
//    
//    private static final ClassType intClassType;
//    private static final ClassType longClassType;
//    private static final ClassType floatClassType;
//    private static final ClassType doubleClassType;
//    private static final ClassType rootType;
//    private static final ClassType stringClassType;
//    private static final ClassType mapImplClassType;
//    private static final ClassType listImplClassType;
//    private static final ClassType exceptionClassType;
//    private static final ClassType shortClassType;
//    private static final ClassType classClassType;
    public final static String EXCEPTION_CLASS_NAME = "java.lang.Exception";
    public final static String CLASS_CLASS_NAME = "java.lang.Class";
            
    static {
//        try {
//            AstLoader astLoader = AstLoader.BASE_AST_LOADER;
//            intClassType = Types.getClassType(astLoader.loadAst(INT_CLASS_NAME));
//            longClassType = Types.getClassType(astLoader.loadAst(LONG_CLASS_NAME));
//            floatClassType = Types.getClassType(astLoader.loadAst(FLOAT_CLASS_NAME));
//            doubleClassType = Types.getClassType(astLoader.loadAst(DOUBLE_CLASS_NAME));
//            rootType = Types.getClassType(astLoader.loadAst(ROOT_CLASS_NAME));
//            VoidClassType = Types.getClassType(astLoader.loadAst(VOID_CLASS_NAME));
//            stringClassType = Types.getClassType(astLoader.loadAst(STRING_CLASS_NAME));
//            booleanClassType = Types.getClassType(astLoader.loadAst(BOOLEAN_CLASS_NAME));
//            charClassType = Types.getClassType(astLoader.loadAst(CHAR_CLASS_NAME));
//            shortClassType = Types.getClassType(astLoader.loadAst(SHORT_CLASS_NAME));
//            byteClassType = Types.getClassType(astLoader.loadAst(SHORT_CLASS_NAME));
//            mapImplClassType = Types.getClassType(astLoader.loadAst(MAP_IMPL_CLASS_NAME));
//            listImplClassType = Types.getClassType(astLoader.loadAst(LIST_IMPL_CLASS_NAME));
//            exceptionClassType = Types.getClassType(astLoader.loadAst("java.lang.Exception"));
//            classClassType = Types.getClassType("java.lang.Class");
//        } catch (AstNotFoundException ex) {
//            //ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
        
        primitive2class.put(INT_TYPE, INT_CLASS_NAME);
        primitive2class.put(LONG_TYPE,LONG_CLASS_NAME);
        primitive2class.put(FLOAT_TYPE, FLOAT_CLASS_NAME);
        primitive2class.put(DOUBLE_TYPE,DOUBLE_CLASS_NAME);
        primitive2class.put(CHAR_TYPE,CHAR_CLASS_NAME);
        primitive2class.put(BOOLEAN_TYPE,BOOLEAN_CLASS_NAME);
        primitive2class.put(VOID_TYPE, VOID_CLASS_NAME);
        primitive2class.put(SHORT_TYPE, SHORT_CLASS_NAME);
        primitive2class.put(BYTE_TYPE, BYTE_CLASS_NAME);
        //m.put(NULL_TYPE, "null");//TODO does null has class type?
    }
    
    private static String[] numberClass = new String[]{
        INT_CLASS_NAME,LONG_CLASS_NAME,FLOAT_CLASS_NAME,DOUBLE_CLASS_NAME};

    private static PrimitiveType[] numberPrimitive = new PrimitiveType[]{
        INT_TYPE, LONG_TYPE, FLOAT_TYPE, DOUBLE_TYPE
    };
    
    @Nonnull
    public static PrimitiveType getPrimitiveType(String name){
        PrimitiveType t = primitiveTypes.get(name);
        if(t ==null){
            t = new PrimitiveType(name);
            primitiveTypes.put(name, t);
        }
        return t;
    }
    
    @Nonnull
    public static ArrayType getArrayType(@Nonnull Type componentType){
        ArrayType at = arrayTypes.get(componentType);
        if(at==null){
            at = new ArrayType(componentType);
            arrayTypes.put(componentType,at);
        }
        return at;
    }
    
    public static ParameterizedType getParameterizedType(ClassType rawType,Type[] argumentsType){
        List<String> argTypes = new ArrayList(argumentsType.length);
        for(Type t:argumentsType){
            argTypes.add(t.getName());
        }
        String key = rawType.getName() + "<" + String.join(",", argTypes) + ">";
        ParameterizedType pt = parameterizedTypes.get(key);
        if(pt==null){
            pt = new ParameterizedType(rawType, argumentsType);
            parameterizedTypes.put(key, pt);
        }
        return pt;
    }
    
    @Nonnull
    public static ClassType getClassType(@Nonnull ClassNode clazz){
        ClassType ct = classTypes.get(clazz);
        if(ct==null){
            ct = new ClassType(clazz,clazz.superType);
            classTypes.put(clazz, ct);
        }
        return ct;
    }
    
    @Nullable
    public static PrimitiveType getPrimitiveType(ClassType classType){
        return primitive2class.getKey(classType.getName());
    }
    
    public static ClassType requireClassType(String className){
        try {
            return getClassType(className);
        } catch (AstNotFoundException ex) {
            Logger.getLogger(Types.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("failed to load class type:"+className);
        }
    }
    
    @Nonnull
    public static ClassType getClassType(String className) throws AstNotFoundException{
        ClassNode ast = AstLoader.BASE_AST_LOADER.loadAst(className);
        return Types.getClassType(ast);
    }
    
    @Nullable
    public static ClassType getClassType(PrimitiveType primitiveType){
        return requireClassType(primitive2class.get(primitiveType));
    }
    
     public static boolean isNumberPrimitive(Type type) {
         if(type instanceof PrimitiveType)
            return Arrays.asList(numberPrimitive).contains((PrimitiveType)type);
         else return false;
    }

    public static boolean isNumberClass(Type type) {
        if(type instanceof ClassType)
            //TODO checking type by name may be bug?
            return Arrays.asList(numberClass).contains(((ClassType)type).getName());
        else return false;
    }

    public static boolean isNumber(Type type) {
        return isNumberPrimitive(type) || isNumberClass(type);
    }

    public static boolean isBoolean(Type type) {
        return type.equals(getBooleanClassType()) || type.equals(BOOLEAN_TYPE);
    }

    @Nonnull
    public  static Type getHigherType(Type type1, Type type2) {
        if (
                type1.equals(getDoubleClassType()) 
                || type1.equals(DOUBLE_TYPE)
                || type2.equals(getDoubleClassType())
                || type2.equals(DOUBLE_TYPE)
                ) {
            return DOUBLE_TYPE;
        }
        if (
                type1.equals(getFloatClassType())
                || type1.equals(FLOAT_TYPE)
                || type2.equals(getFloatClassType())
                || type2.equals(FLOAT_TYPE)
                ) {
            return FLOAT_TYPE;
        }
        if (
                type1.equals(getLongClassType()) 
                || type1.equals(LONG_TYPE)
                || type2.equals(getLongClassType())
                || type2.equals(LONG_TYPE)) {
            return LONG_TYPE;
        }
        return INT_TYPE;
    }

    /**
     * @return the VoidClassType
     */
    public static ClassType getVoidClassType() {
        return requireClassType(VOID_CLASS_NAME);
    }

    /**
     * @return the booleanClassType
     */
    public static ClassType getBooleanClassType() {
        return requireClassType(BOOLEAN_CLASS_NAME);
    }

    /**
     * @return the byteClassType
     */
    public static ClassType getByteClassType() {
        return requireClassType(BYTE_CLASS_NAME);
    }

    /**
     * @return the charClassType
     */
    public static ClassType getCharClassType() {
        return requireClassType(CHAR_CLASS_NAME);
    }

    /**
     * @return the intClassType
     */
    public static ClassType getIntClassType() {
        return requireClassType(INT_CLASS_NAME);
    }

    /**
     * @return the longClassType
     */
    public static ClassType getLongClassType() {
        return requireClassType(LONG_CLASS_NAME);
    }

    /**
     * @return the floatClassType
     */
    public static ClassType getFloatClassType() {
        return requireClassType(FLOAT_CLASS_NAME);
    }

    /**
     * @return the doubleClassType
     */
    public static ClassType getDoubleClassType() {
        return requireClassType(DOUBLE_CLASS_NAME);
    }

    /**
     * @return the mapImplClassType
     */
    public static ClassType getMapImplClassType() {
        return requireClassType(MAP_IMPL_CLASS_NAME);
    }

    /**
     * @return the listImplClassType
     */
    public static ClassType getListImplClassType() {
        return requireClassType(LIST_IMPL_CLASS_NAME);
    }

    /**
     * @return the exceptionClassType
     */
    public static ClassType getExceptionClassType() {
        return requireClassType(EXCEPTION_CLASS_NAME);
    }

    /**
     * @return the shortClassType
     */
    public static ClassType getShortClassType() {
        return requireClassType(SHORT_CLASS_NAME);
    }

    /**
     * @return the classClassType
     */
    public static ClassType getClassClassType() {
        return requireClassType(CLASS_CLASS_NAME);
    }

    /**
     * @return the rootType
     */
    public static ClassType getRootType() {
        return requireClassType(ROOT_CLASS_NAME);
    }

    /**
     * @return the stringClassType
     */
    public static ClassType getStringClassType() {
        return requireClassType(STRING_CLASS_NAME);
    }

    //TODO remove getWildcardType?
    public static WildcardType getWildcartType(Type[] upperBounds, Type[] lowerBounds) {
        String ub = TypeUtil.toString(upperBounds, "&");
        String lb = TypeUtil.toString(lowerBounds,"&");
        String key = ub + "," + lb;
        WildcardType wt = wildcardTypes.get(key);
        if(wt==null){
            wt = new WildcardType(upperBounds, lowerBounds);
            wildcardTypes.put(key, wt);
        }
        return wt;
    }

}

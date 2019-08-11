
package kalang.compiler.core;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.AstLoader;
import kalang.type.Function;
import kalang.type.FunctionClasses;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kason Yang
 */
public class Types {
    
    private static Map<String,PrimitiveType> primitiveTypes = new HashMap();
    private static Map<List,ArrayType> arrayTypes = new HashMap();
    
    //private static Map<List,ObjectType> classTypes  = new HashMap<>();
            
    private static final Map<List,ClassType> classTypes = new HashMap();

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
    
    public static final String SCRIPT_CLASS_NAME = "kalang.Script";
    
    public static final String MAP_IMPL_CLASS_NAME = "java.util.HashMap";
    
    public static final String LIST_IMPL_CLASS_NAME = "java.util.LinkedList";
    
    public final static String EXCEPTION_CLASS_NAME = "java.lang.Exception";
    public final static String CLASS_CLASS_NAME = "java.lang.Class";
    
    public final static String ITERABLE_CLASS_NAME = "java.lang.Iterable";
    
    public final static String ASSERTION_ERROR_CLASS_NAME = AssertionError.class.getName()
            ,FUNCTION_CLASS_NAME = Function.class.getName()
            ;
            
    static {
        primitive2class.put(INT_TYPE, INT_CLASS_NAME);
        primitive2class.put(LONG_TYPE,LONG_CLASS_NAME);
        primitive2class.put(FLOAT_TYPE, FLOAT_CLASS_NAME);
        primitive2class.put(DOUBLE_TYPE,DOUBLE_CLASS_NAME);
        primitive2class.put(CHAR_TYPE,CHAR_CLASS_NAME);
        primitive2class.put(BOOLEAN_TYPE,BOOLEAN_CLASS_NAME);
        primitive2class.put(VOID_TYPE, VOID_CLASS_NAME);
        primitive2class.put(SHORT_TYPE, SHORT_CLASS_NAME);
        primitive2class.put(BYTE_TYPE, BYTE_CLASS_NAME);
    }
    
    private static String[] numberClass = new String[]{
        BYTE_CLASS_NAME,CHAR_CLASS_NAME,SHORT_CLASS_NAME , INT_CLASS_NAME,LONG_CLASS_NAME,FLOAT_CLASS_NAME,DOUBLE_CLASS_NAME};

    private static PrimitiveType[] numberPrimitive = new PrimitiveType[]{
        BYTE_TYPE, CHAR_TYPE,SHORT_TYPE, INT_TYPE, LONG_TYPE, FLOAT_TYPE, DOUBLE_TYPE
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
    
    public static ArrayType getArrayType(ArrayType type,NullableKind nullable){
        return getArrayType(type.getComponentType(),nullable);
    }
    
    @Nonnull
    public static ArrayType getArrayType(@Nonnull Type componentType){
        return getArrayType(componentType,NullableKind.NONNULL);
    }
    
    @Nonnull
    public static ArrayType getArrayType(@Nonnull Type componentType,NullableKind nullable){
        List key = Arrays.asList(componentType,nullable);
        ArrayType at = arrayTypes.get(key);
        if(at==null){
            at = new ArrayType(componentType,nullable);
            arrayTypes.put(key,at);
        }
        return at;
    }
    
    public static ClassType getClassType(ClassNode clazz,Type[] typeArguments){
        return getClassType(clazz, typeArguments,NullableKind.NONNULL);
    }
    
    public static ClassType getClassType(ClassNode clazz,Type[] typeArguments,NullableKind nullable){
        List key = new ArrayList(typeArguments.length+2);
        key.add(clazz);
        key.addAll(Arrays.asList(typeArguments));
        key.add(nullable);
        ClassType pt = classTypes.get(key);
        if(pt==null){
            pt = new ClassType(clazz, typeArguments,nullable);
            classTypes.put(key, pt);
        }
        return pt;
    }
    
    @Nonnull
    public static ClassType getClassType(@Nonnull ClassNode clazz){
        return Types.getClassType(clazz,clazz.getGenericTypes(),NullableKind.NONNULL);
    }
    
    @Nonnull
    public static ClassType getClassType(@Nonnull ClassNode clazz,NullableKind nullable){
        return getClassType(clazz, new Type[0],nullable);
    }
    
    @Nullable
    public static PrimitiveType getPrimitiveType(ObjectType classType){
        return primitive2class.getKey(classType.getName());
    }

    @Deprecated
    public static ClassType requireClassType(String className){
        return Types.getClassType(className);
    }

    public static ClassType requireClassType(String className,NullableKind nullableKind){
        try {
            return Types.getClassType(className,nullableKind);
        } catch (AstNotFoundException ex) {
            Logger.getLogger(Types.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("failed to load class type:"+className);
        }
    }
    
    @Nonnull
    public static ClassType getClassType(String className) throws AstNotFoundException{
        return getClassType(className,NullableKind.NONNULL);
    }
    
    @Nonnull
    public static ClassType getClassType(String className,NullableKind nullable) throws AstNotFoundException{
        ClassNode ast = AstLoader.BASE_AST_LOADER.loadAst(className);
        return Types.getClassType(ast,nullable);
    }
    
    @Nullable
    public static ObjectType getClassType(PrimitiveType primitiveType){
        String classTypeName = primitive2class.get(primitiveType);
        if (classTypeName == null) {
            return null;
        }
        return requireClassType(classTypeName);
    }
    
     public static boolean isNumberPrimitive(Type type) {
         if(type instanceof PrimitiveType)
            return Arrays.asList(numberPrimitive).contains((PrimitiveType)type);
         else return false;
    }

    public static boolean isIntCompatibleType(Type type) {
        Type[] intCompatibleType = new Type[] {
                BOOLEAN_TYPE,BYTE_TYPE,SHORT_TYPE,INT_TYPE
        };
        return Arrays.asList(intCompatibleType).contains(type);
    }

    public static boolean isNumberClass(Type type) {
        if(type instanceof ObjectType)
            return Arrays.asList(numberClass).contains(((ObjectType)type).getName());
        else return false;
    }

    public static boolean isNumber(Type type) {
        return isNumberPrimitive(type) || isNumberClass(type);
    }
    
    public static boolean isFloatPointType(Type type) {
        return FLOAT_TYPE.equals(type) || DOUBLE_TYPE.equals(type)
                || getFloatClassType().equals(type)
                || getDoubleClassType().equals(type);
    }

    public static boolean isStringType(Type type) {
        if (!(type instanceof ObjectType)) {
            return false;
        }
        return Types.getStringClassType().getClassNode().name.equals(((ObjectType) type).getClassNode().name);
    }
    
    public static boolean isExactNumber(Type type) {
        return isNumber(type) && !isFloatPointType(type);
    }
    
    public static boolean isCharType(Type type) {
        return CHAR_TYPE.equals(type) || getCharClassType().equals(type);
    }

    public static boolean isBoolean(Type type) {
        return type.equals(getBooleanClassType()) || type.equals(BOOLEAN_TYPE);
    }
    
    public static boolean isNullType(Type type) {
        return NULL_TYPE.equals(type);
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
    public static ObjectType getVoidClassType() {
        return requireClassType(VOID_CLASS_NAME);
    }

    /**
     * @return the booleanClassType
     */
    public static ObjectType getBooleanClassType() {
        return requireClassType(BOOLEAN_CLASS_NAME);
    }

    /**
     * @return the byteClassType
     */
    public static ObjectType getByteClassType() {
        return requireClassType(BYTE_CLASS_NAME);
    }

    /**
     * @return the charClassType
     */
    public static ObjectType getCharClassType() {
        return requireClassType(CHAR_CLASS_NAME);
    }

    /**
     * @return the intClassType
     */
    public static ObjectType getIntClassType() {
        return requireClassType(INT_CLASS_NAME);
    }

    /**
     * @return the longClassType
     */
    public static ObjectType getLongClassType() {
        return requireClassType(LONG_CLASS_NAME);
    }

    /**
     * @return the floatClassType
     */
    public static ObjectType getFloatClassType() {
        return requireClassType(FLOAT_CLASS_NAME);
    }

    /**
     * @return the doubleClassType
     */
    public static ObjectType getDoubleClassType() {
        return requireClassType(DOUBLE_CLASS_NAME);
    }

    /**
     * @return the mapImplClassType
     */
    public static ObjectType getMapImplClassType() {
        return requireClassType(MAP_IMPL_CLASS_NAME);
    }

    /**
     * @return the listImplClassType
     */
    public static ObjectType getListImplClassType() {
        return requireClassType(LIST_IMPL_CLASS_NAME);
    }

    /**
     * @return the exceptionClassType
     */
    public static ObjectType getExceptionClassType() {
        return requireClassType(EXCEPTION_CLASS_NAME);
    }

    /**
     * @return the shortClassType
     */
    public static ObjectType getShortClassType() {
        return requireClassType(SHORT_CLASS_NAME);
    }

    /**
     * @return the classClassType
     */
    public static ObjectType getClassClassType() {
        return requireClassType(CLASS_CLASS_NAME);
    }

    /**
     * @return the non-null rootType
     * @deprecated
     */
    public static ClassType getRootType() {
        return requireClassType(ROOT_CLASS_NAME);
    }

    public static boolean isRootObjectType(ObjectType type) {
        return type.getClassNode().name.equals(ROOT_CLASS_NAME);
    }
    
    public static ObjectType getScriptType(){
        return requireClassType(SCRIPT_CLASS_NAME);
    }

    /**
     * @return the stringClassType
     */
    public static ObjectType getStringClassType() {
        return requireClassType(STRING_CLASS_NAME);
    }

    public static ObjectType getFunctionType() {
        return requireClassType(FUNCTION_CLASS_NAME);
    }

    public static ClassType getClassType(ClassType clazzType, NullableKind nullable) {
        return Types.getClassType(clazzType.getClassNode(),clazzType.getTypeArguments(),nullable);
    }
    
    public static ObjectType getIterableClassType(){
        return requireClassType(ITERABLE_CLASS_NAME);
    }
    
    public static ObjectType requireAssertionErrorClassType() {
        return requireClassType(ASSERTION_ERROR_CLASS_NAME);
    }
    
    public static boolean isPrimitiveCastable(PrimitiveType fromType,PrimitiveType toType){
        if (fromType.equals(toType)) {
            return true;
        }
        HashMap<PrimitiveType, List> baseMap = new HashMap();
        baseMap.put(BYTE_TYPE,Arrays.asList(new PrimitiveType[]{INT_TYPE,LONG_TYPE,FLOAT_TYPE,DOUBLE_TYPE}));
        baseMap.put(INT_TYPE, Arrays.asList(new PrimitiveType[]{LONG_TYPE, FLOAT_TYPE, DOUBLE_TYPE}));
        baseMap.put(CHAR_TYPE,Arrays.asList(new PrimitiveType[]{INT_TYPE,LONG_TYPE,FLOAT_TYPE,DOUBLE_TYPE}));
        baseMap.put(LONG_TYPE, Arrays.asList(new PrimitiveType[]{FLOAT_TYPE, DOUBLE_TYPE}));
        baseMap.put(FLOAT_TYPE, Arrays.asList(new PrimitiveType[]{DOUBLE_TYPE}));
        baseMap.put(DOUBLE_TYPE, new LinkedList());
        if (baseMap.containsKey(fromType)) {
            return baseMap.get(fromType).contains(toType);
        }
        return false;
    }
    
    public static ClassType getFunctionType(Type returnType,Type[] parameterTypes, NullableKind nullableKind) {
        if (parameterTypes == null) {
            parameterTypes = new Type[0];
        }
        int paramCount = parameterTypes.length;
        if (paramCount > FunctionClasses.CLASSES.length - 1) {
            throw new IllegalArgumentException("");
        }
        List<Type> types = new ArrayList(paramCount + 1);
        types.add(returnType);
        types.addAll(Arrays.asList(parameterTypes));
        int pcount = parameterTypes.length;
        if (pcount > FunctionClasses.CLASSES.length - 1) {
            throw new IllegalArgumentException("");
        }
        ClassNode classNode = Types.requireClassType(FunctionClasses.CLASSES[pcount].getName(), NullableKind.NONNULL).getClassNode();
        return Types.getClassType(classNode,types.toArray(new Type[0]),nullableKind);
    }

    public static boolean isFunctionType(Type type) {
        if (!(type instanceof ClassType)) {
            return false;
        }
        ClassType classType = (ClassType) type;
        return Types.requireClassType(Function.class.getName()).isAssignableFrom(classType);
    }

}

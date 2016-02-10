package kalang.compiler;

import jast.ast.CastExpr;
import jast.ast.ClassExpr;
import jast.ast.ClassNode;
import jast.ast.ExprNode;
import jast.ast.InvocationExpr;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

public class TypeSystem {

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

    public static final String FLOAT_CLASS = "java.lang.Float";
    public static final String DOUBLE_CLASS = "java.lang.Double";

    public static final String INT_CLASS = "java.lang.Integer";
    public static final String LONG_CLASS = "java.lang.Long";

    public static final String BOOLEAN_CLASS = "java.lang.Boolean";

    public static final String CHAR_CLASS = "java.lang.Character";

    public static final String STRING_CLASS = "java.lang.String";

    public static final String VOID_CLASS = "java.lang.Void";

    public static final String SHORT_CLASS = "java.lang.Short";

    public static final String BYTE_CLASS = "java.lang.Byte";

    public static final String ROOT_CLASS = "java.lang.Object";

    private BidiMap<String, String> primitive2class;

    private String[] numberClass = new String[]{
        INT_CLASS, LONG_CLASS, FLOAT_CLASS, DOUBLE_CLASS
    };

    private String[] numberPrimitive = new String[]{
        INT_PRIMITIVE_TYPE, LONG_PRIMITIVE_TYPE, FLOAT_PRIMITIVE_TYPE, DOUBLE_PRIMITIVE_TYPE
    };

    AstLoader astLoader;

    TypeSystem(AstLoader astLoader) {
        BidiMap<String, String> m = primitive2class = new TreeBidiMap();
        m.put(INT_PRIMITIVE_TYPE, INT_CLASS);
        m.put(LONG_PRIMITIVE_TYPE, LONG_CLASS);
        m.put(FLOAT_PRIMITIVE_TYPE, FLOAT_CLASS);
        m.put(DOUBLE_PRIMITIVE_TYPE, DOUBLE_CLASS);
        m.put(CHAR_PRIMITIVE_TYPE, CHAR_CLASS);
        m.put(BOOLEAN_PRIMITIVE_TYPE, BOOLEAN_CLASS);
        m.put(VOID_PRIMITIVE_TYPE, VOID_CLASS);
        m.put(SHORT_PRIMITIVE_TYPE, SHORT_CLASS);
        m.put(BYTE_PRIMITIVE_TYPE, BYTE_CLASS);
        m.put(NULL_PRIMITIVE_TYPE, "null");//TODO does null has class type?
        this.astLoader = astLoader;
    }

    boolean isPrimitiveType(String type) {
        if (type.endsWith("[]")) {
            type = type.substring(0, type.length() - 2);
        }
        return primitive2class.containsKey(type);
    }

    String classifyType(String from) {
        String ret = primitive2class.get(from);
        if (ret == null) {
            return from;
        }
        return ret;
    }

    boolean hasPrimitiveType(String type) {
        return this.primitive2class.containsValue(type);
    }

    String getPrimitiveType(String type) {
        String k = primitive2class.getKey(type);
        if (k == null) {
            return type;
        }
        return k;
    }

    String[] getPrimitiveTypes() {
        return (String[]) primitive2class.values().toArray();
    }

    private boolean primitiveCastable(String from, String to) {
        to = classifyType(to);
        from = classifyType(from);
        if (from.equals(to)) {
            return true;
        }
        HashMap<String, List> baseMap = new HashMap();
        baseMap.put(INT_CLASS, Arrays.asList(new String[]{LONG_CLASS, FLOAT_CLASS, DOUBLE_CLASS}));
        baseMap.put(LONG_CLASS, Arrays.asList(new String[]{FLOAT_CLASS, DOUBLE_CLASS}));
        baseMap.put(FLOAT_CLASS, Arrays.asList(new String[]{DOUBLE_CLASS}));
        baseMap.put(DOUBLE_CLASS, new LinkedList());
        if (baseMap.containsKey(from)) {
            return baseMap.get(from).contains(to);
        }
        return false;
    }

    /*boolean castable(List<String> from,List<String> to){
		if(from.size()!=to.size())  return false
		for(int i=0;i<from.size();i++){
			def f = from.get(i)
			def t = to.get(i)
			if(!castable(f,t)){
				return false
			}
		}
		return true
	}*/
    boolean isNumberPrimitive(String type) {
        return Arrays.asList(this.numberPrimitive).contains(type);
    }

    boolean isNumberClass(String type) {
        return Arrays.asList(this.numberClass).contains(type);
    }

    boolean isNumber(String type) {
        return this.isNumberPrimitive(type) || this.isNumberClass(type);
    }

    boolean isBoolean(String type) {
        return type.equals(BOOLEAN_CLASS) || type.equals(BOOLEAN_PRIMITIVE_TYPE);
    }

    String getHigherType(String type1, String type2) {
        if (type1.equals(DOUBLE_CLASS) || type2.equals(DOUBLE_CLASS)) {
            return DOUBLE_CLASS;
        }
        if (type1.equals(FLOAT_CLASS) || type2.equals(FLOAT_CLASS)) {
            return FLOAT_CLASS;
        }
        if (type1.equals(LONG_CLASS) || type2.equals(LONG_CLASS)) {
            return LONG_CLASS;
        }
        return INT_CLASS;
    }

    boolean isSubclass(String type, String subclassType) throws AstNotFoundException {
        if (isPrimitiveType(type)) {
            return false;
        }
        ClassNode fromAst = astLoader.loadAst(type);
        while (fromAst != null) {
            ClassNode parent = fromAst.parent;
            if (parent == null) {
                return false;
            }
            if (parent.name.equals(subclassType)) {
                return true;
            }
            fromAst = parent;
        }
        return false;
    }

    /**
     * try to cast type if needed
     * @param expr
     * @param fromType
     * @param toType
     * @return
     * @throws AstNotFoundException 
     */
    ExprNode cast(ExprNode expr, String fromType, String toType) throws AstNotFoundException {
        int t = this.getCastMethod(fromType, toType);
        switch (t) {
            case CAST_NOTHING:
                return this.castNothing(expr, fromType, toType);
            case CAST_OBJECT_TO_PRIMITIVE:
                return this.castObject2Primitive(expr, fromType, toType);
            case CAST_PRIMITIVE:
                return this.castPrimitive(expr, fromType, toType);
            case CAST_PRIMITIVE_TO_OBJECT:
                return this.castPrimitive2Object(expr, fromType, toType);
            case CAST_OBJECT_TO_STRING:
                return castObject2String(expr);
            default:
                throw new TypeCastException("unknown cast type:" + fromType + "=>" + toType);
        }
    }

    boolean castable(String fromType, String toType) throws AstNotFoundException {
        return getCastMethod(fromType, toType) > 0;
    }

    private int getCastMethod(String fromType, String toType) throws AstNotFoundException {
        if (fromType.equals(toType)) {
            return this.CAST_NOTHING;
        }
        if (isPrimitiveType(fromType)) {
            if (isPrimitiveType(toType)) {
                if (this.primitiveCastable(fromType, toType)) {
                    return this.CAST_PRIMITIVE;
                }
            } else {
                if (toType.equals(ROOT_CLASS)) {
                    return this.CAST_PRIMITIVE_TO_OBJECT;
                }
                if (fromType.equals(NULL_PRIMITIVE_TYPE)) {
                    return this.CAST_NOTHING;
                }
                String toPriType = getPrimitiveType(toType);
                if (toPriType.equals(fromType)) {
                    return this.CAST_PRIMITIVE_TO_OBJECT;
                }
            }
        } else if (isPrimitiveType(toType)) {
            String fromPrimitive = getPrimitiveType(fromType);
            if (fromPrimitive.equals(toType)) {
                return this.CAST_OBJECT_TO_PRIMITIVE;
            }
        } else if (isSubclass(fromType, toType)) {
            return this.CAST_NOTHING;
        } else if(toType.equals(STRING_CLASS)){
            return CAST_OBJECT_TO_STRING;
        }
        return -1;
    }

    final int CAST_PRIMITIVE = 1,
            CAST_PRIMITIVE_TO_OBJECT = 2,
            CAST_OBJECT_TO_PRIMITIVE = 3,
            CAST_NOTHING = 4,
            CAST_OBJECT_TO_STRING = 5;

    private ExprNode castPrimitive(ExprNode expr, String fromType, String toType) {
        return new CastExpr(toType, expr);
    }

    private ExprNode castPrimitive2Object(ExprNode expr, String fromType, String toType) {
        String classType = this.classifyType(fromType);
        return new InvocationExpr(new ClassExpr(classType), "valueOf", Arrays.asList(new ExprNode[]{expr}));
    }
    
    private ExprNode castObject2String(ExprNode expr){
        return new InvocationExpr(expr, "toString", null);
    }

    private ExprNode castObject2Primitive(ExprNode expr, String fromType, String toType) {
        InvocationExpr inv = new InvocationExpr();
        inv.target = expr;
        inv.methodName = toType + "Value";
        return inv;
    }

    private ExprNode castNothing(ExprNode expr, String fromType, String toType) {
        return expr;
    }

    public String getShortPrimitiveType() {
        return SHORT_PRIMITIVE_TYPE;
    }

    public String getIntPrimitiveType() {
        return INT_PRIMITIVE_TYPE;
    }

    public String getLongPrimitiveType() {
        return LONG_PRIMITIVE_TYPE;
    }

    public String getFloatPrimitiveType() {
        return FLOAT_PRIMITIVE_TYPE;
    }

    public String getDoublePrimitiveType() {
        return DOUBLE_PRIMITIVE_TYPE;
    }

    public String getBooleanPrimitiveType() {
        return BOOLEAN_PRIMITIVE_TYPE;
    }

    public String getBytePrimitiveType() {
        return BYTE_PRIMITIVE_TYPE;
    }

    public String getCharPrimitiveType() {
        return CHAR_PRIMITIVE_TYPE;
    }

    public String getNullPrimitiveType() {
        return NULL_PRIMITIVE_TYPE;
    }

    public String getVoidPrimitiveType() {
        return VOID_PRIMITIVE_TYPE;
    }

    public String getFloatClass() {
        return FLOAT_CLASS;
    }

    public String getDoubleClass() {
        return DOUBLE_CLASS;
    }

    public String getIntClass() {
        return INT_CLASS;
    }

    public String getLongClass() {
        return LONG_CLASS;
    }

    public String getBooleanClass() {
        return BOOLEAN_CLASS;
    }

    public String getCharClass() {
        return CHAR_CLASS;
    }

    public String getStringClass() {
        return STRING_CLASS;
    }

    public String getVoidClass() {
        return VOID_CLASS;
    }

    public String getShortClass() {
        return SHORT_CLASS;
    }

    public String getByteClass() {
        return BYTE_CLASS;
    }

    public String getRootClass() {
        return ROOT_CLASS;
    }

}

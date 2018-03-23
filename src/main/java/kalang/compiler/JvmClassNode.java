package kalang.compiler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kalang.AstNotFoundException;
import kalang.ast.ClassNode;
import kalang.ast.FieldNode;
import kalang.ast.MethodNode;
import kalang.core.ClassType;
import kalang.core.GenericType;
import kalang.core.NullableKind;
import kalang.core.ObjectType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.core.WildcardType;
import kalang.exception.Exceptions;
import kalang.util.ModifierUtil;

/**
 *
 * @author Kason Yang
 */
public class JvmClassNode extends ClassNode {

    private final AstLoader astLoader;

    private final Class clazz;

    private boolean superTypeInitialized,
            fieldsInitialized,
            methodsInitialized,
            interfacesInitialized,
            genericTypesInitialized;

    private Map<TypeVariable, GenericType> genericTypeMap = null;

    public JvmClassNode(Class clazz, AstLoader astLoader) {
        this.astLoader = astLoader;
        this.clazz = clazz;
        this.name = clazz.getName();
        this.modifier = clazz.getModifiers();
    }

    @Override
    public ObjectType getSuperType() {
        if (!this.superTypeInitialized) {
            this.superTypeInitialized = true;
            java.lang.reflect.Type superType = clazz.getGenericSuperclass();
            Class superClazz = clazz.getSuperclass();
            if (superType != null) {
                setSuperType((ObjectType) getType(superType, getGenericTypeMap(), superClazz, NullableKind.NONNULL));
            }
        }
        return super.getSuperType();
    }

    @Override
    public ObjectType[] getInterfaces() {
        if (!this.interfacesInitialized) {
            this.interfacesInitialized = true;
            java.lang.reflect.Type[] typeInterfaces = clazz.getGenericInterfaces();
            Class[] clzInterfaces = clazz.getInterfaces();
            if (clzInterfaces != null) {
                for (int i = 0; i < clzInterfaces.length; i++) {
                    addInterface((ObjectType) getType(typeInterfaces[i], getGenericTypeMap(), clzInterfaces[i], NullableKind.NONNULL));
                }
            }
        }
        return super.getInterfaces();
    }

    @Override
    public FieldNode[] getFields() {
        if (!this.fieldsInitialized) {
            this.fieldsInitialized = true;
            for (Field f : clazz.getDeclaredFields()) {
                NullableKind nullable = getNullable(f.getAnnotations());
                FieldNode fn = createField(getType(f.getGenericType(), getGenericTypeMap(), f.getType(), nullable), f.getName(), f.getModifiers());
            }
        }
        return super.getFields();
    }

    @Override
    public MethodNode[] getDeclaredMethodNodes() {
        if (!this.methodsInitialized) {
            this.methodsInitialized = true;
            List<Executable> methods = new LinkedList();
            methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
            methods.addAll(Arrays.asList(clazz.getDeclaredConstructors()));
            for (Executable m : methods) {
                NullableKind nullable = getNullable(m.getAnnotations());
                Type mType;
                String mName;
                int mModifier;
                if (m instanceof Method) {
                    mType = getType(((Method) m).getGenericReturnType(), getGenericTypeMap(), ((Method) m).getReturnType(), nullable);
                    mName = m.getName();
                    mModifier = m.getModifiers();
                } else if (m instanceof Constructor) {
                    mName = "<init>";
                    mType = Types.VOID_TYPE;// getType(clz);
                    mModifier = m.getModifiers();// | Modifier.STATIC;
                } else {
                    throw Exceptions.unexceptedValue(m);
                }
                MethodNode methodNode = createMethodNode(mType, mName, mModifier);
                for (Parameter p : m.getParameters()) {
                    NullableKind pnullable = getNullable(p.getAnnotations());
                    methodNode.createParameter(getType(p.getParameterizedType(), getGenericTypeMap(), p.getType(), pnullable), p.getName());
                }
                for (Class e : m.getExceptionTypes()) {
                    methodNode.addExceptionType(getType(e, getGenericTypeMap(), e, NullableKind.NONNULL));
                }
            }
        }
        return super.getDeclaredMethodNodes();
    }

    @Override
    public GenericType[] getGenericTypes() {
        if (!this.genericTypesInitialized) {
            this.genericTypesInitialized = true;
            this.getGenericTypeMap();
        }
        return super.getGenericTypes();
    }

    @Nullable
    private Type[] transType(java.lang.reflect.Type[] ts, Map<TypeVariable, GenericType> genericTypes) {
        Type[] ret = new Type[ts.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = transType(ts[i], genericTypes);
            if (ret[i] == null) {
                return null;
            }
        }
        return ret;
    }

    //TODO why transType could be null?
    @Nullable
    private Type transType(java.lang.reflect.Type t, Map<TypeVariable, GenericType> genericTypes) {
        if (t instanceof TypeVariable) {
            GenericType vt = genericTypes.get((TypeVariable) t);
            //FIXME it may be null if TypeVariable comes from method
            if (vt != null) {
                return vt;
            }
            return null;
        } else if (t instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType pt = (java.lang.reflect.ParameterizedType) t;
            Type rawType = transType(pt.getRawType(), genericTypes);
            if (!(rawType instanceof ObjectType)) {
                return null;
            }
            java.lang.reflect.Type[] typeArgs = pt.getActualTypeArguments();
            Type[] gTypes = transType(typeArgs, genericTypes);
            if (gTypes == null) {
                return null;
            }
            return Types.getClassType(((ObjectType) rawType).getClassNode(), gTypes);
        } else if (t instanceof java.lang.reflect.WildcardType) {
            java.lang.reflect.WildcardType wt = (java.lang.reflect.WildcardType) t;
            Type[] upperBounds = transType(wt.getUpperBounds(), genericTypes);
            if (upperBounds == null) {
                return null;
            }
            Type[] lowerBounds = transType(wt.getLowerBounds(), genericTypes);
            if (lowerBounds == null) {
                return null;
            }
            return new WildcardType(upperBounds, lowerBounds);
        } else if (t instanceof GenericArrayType) {
            GenericArrayType gt = (GenericArrayType) t;
            Type ct = transType(gt.getGenericComponentType(), genericTypes);
            if (ct == null) {
                return null;
            }
            return Types.getArrayType(ct, NullableKind.NONNULL);
        } else if (t instanceof Class) {
            Class type = (Class) t;
            if (type.isPrimitive()) {
                return Types.getPrimitiveType(type.getTypeName());
            } else if (type.isArray()) {
                Type ct = transType(type.getComponentType(), genericTypes);
                if (ct == null) {
                    return null;
                }
                return Types.getArrayType(ct);
            } else {
                try {
                    return Types.getClassType(this.astLoader.findAst(type.getName()));
                } catch (AstNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else {
            return null;
        }
    }

    private Type getType(java.lang.reflect.Type t, Map<TypeVariable, GenericType> genericTypes, Class defaultClass, NullableKind nullable) {
        Type type = this.transType(t, genericTypes);
        if (type == null) {
            type = transType(defaultClass, genericTypes);
        }
        //TODO support nullable for other type
        if (type instanceof ClassType) {
            return Types.getClassType((ClassType) type, nullable);
        } else {
            return type;
        }
    }

    private NullableKind getNullable(Annotation[] annotations) {
        for (Annotation a : annotations) {
            Class<? extends Annotation> at = a.annotationType();
            String simpleName = at.getSimpleName().toLowerCase();
            switch (simpleName) {
                case "nullable":
                case "nullallowed":
                    return NullableKind.NULLABLE;
                case "nonnull":
                case "notnull":
                    return NullableKind.NONNULL;
            }
        }
        return NullableKind.UNKNOWN;
    }

    private Map<TypeVariable, GenericType> getGenericTypeMap() {
        if (this.genericTypeMap == null) {
            Map<TypeVariable, GenericType> gTypesMap = new HashMap();
            TypeVariable[] typeParameters = clazz.getTypeParameters();
            if (typeParameters.length > 0) {
                for (TypeVariable pt : typeParameters) {
                    ObjectType[] bounds = castToClassTypes(transType(pt.getBounds(), gTypesMap));
                    ObjectType superType;
                    ObjectType[] interfaces;
                    if (bounds != null && bounds.length > 0) {
                        if (ModifierUtil.isInterface(bounds[0].getModifier())) {
                            superType = Types.getRootType();
                            interfaces = bounds;
                        } else {
                            superType = bounds[0];
                            interfaces = new ObjectType[bounds.length - 1];
                            System.arraycopy(bounds, 1, interfaces, 0, interfaces.length);
                        }
                    } else {
                        superType = Types.getRootType();
                        interfaces = bounds;
                    }
                    GenericType gt = new GenericType(pt.getName(), superType, interfaces, NullableKind.NONNULL);
                    gTypesMap.put(pt, gt);
                    declareGenericType(gt);
                }
            }
            this.genericTypeMap = gTypesMap;
        }
        return this.genericTypeMap;
    }

    private ObjectType[] castToClassTypes(Type[] types) {
        if (types == null) {
            return null;
        }
        ObjectType[] cts = new ObjectType[types.length];
        for (int i = 0; i < types.length; i++) {
            cts[i] = (ClassType) types[i];
        }
        return cts;
    }

}

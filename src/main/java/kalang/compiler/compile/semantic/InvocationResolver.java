package kalang.compiler.compile.semantic;

import kalang.annotation.Nullable;
import kalang.compiler.ast.ExprNode;
import kalang.compiler.core.*;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.BoxUtil;
import kalang.compiler.util.Exceptions;
import kalang.compiler.util.ModifierUtil;

import java.util.*;

/**
 * @author KasonYang
 */
public class InvocationResolver {

    public List<Resolution> resolve(MethodDescriptor[] mds, String name, ExprNode... args) {
        List<Resolution> matched = new ArrayList<>(mds.length);
        for (MethodDescriptor m : mds) {
            if (!name.equals(m.getName())) {
                continue;
            }
            ApplyResult[] applyRes = applyArgsToParams(m.getParameterDescriptors(), args, ModifierUtil.isVarArgs(m.getModifier()));
            if (applyRes == null) {
                continue;
            }
            Resolution rr = new Resolution(m, getAppliedArgs(applyRes));
            if (isFullMatchScore(applyRes)) {
                return Collections.singletonList(rr);
            } else {
                matched.add(rr);
            }
        }
        if (matched.isEmpty()) {
            return Collections.emptyList();
        }
        return selectMostPrecise(matched, args);
    }

    @Nullable
    private ApplyResult[] applyArgsToParams(ParameterDescriptor[] parameters, ExprNode[] args, boolean isVarArgs) {
        if (parameters.length == 0) {
            return args.length == 0 ? new ApplyResult[0] : null;
        }
        ParameterDescriptor lastParam = parameters[parameters.length - 1];
        if (isVarArgs) {
            if (args.length < parameters.length - 1) {
                return null;
            }
            ApplyResult[] result = new ApplyResult[parameters.length];
            ExprNode[] tailArgs = new ExprNode[args.length - parameters.length + 1];
            for (int i = 0; i < result.length - 1; i++) {
                result[i] = applyArgToParam(args[i], parameters[i].getType());
                if (result[i] == null) {
                    return null;
                }
            }
            if (args.length == parameters.length) {
                result[result.length - 1] = applyArgToParam(args[result.length - 1], parameters[result.length - 1].getType());
                if (result[result.length - 1] != null) {
                    return result;
                }
            }
            Type lastComponentType = ((ArrayType) lastParam.getType()).getComponentType();
            for (int i = 0; i < tailArgs.length; i++) {
                ApplyResult tailApplyRes = applyArgToParam(args[parameters.length - 1 + i], lastComponentType);
                if (tailApplyRes == null) {
                    return null;
                }
                tailArgs[i] = tailApplyRes.appliedArgs;
            }
            result[parameters.length - 1] = new ApplyResult(3, AstUtil.createInitializedArray(lastComponentType, tailArgs));
            return result;
        } else {
            if (parameters.length != args.length) {
                return null;
            }
            ApplyResult[] result = new ApplyResult[args.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = applyArgToParam(args[i], parameters[i].getType());
                if (result[i] == null) {
                    return null;
                }
            }
            return result;
        }
    }

    @Nullable
    private ApplyResult applyArgToParam(ExprNode arg, Type paramType) {
        Type argType = arg.getType();
        if (argType.equals(paramType)) {
            return new ApplyResult(0, arg);
        }
        int castMethod = BoxUtil.getCastMethod(arg, paramType);
        Integer score = getMatchScore(castMethod);
        if (score == null) {
            return null;
        }
        ExprNode appliedExpr = BoxUtil.assign(arg, paramType);
        Objects.requireNonNull(appliedExpr);
        return new ApplyResult(score, appliedExpr);
    }

    private boolean isMorePreciseTypes(ExprNode[] arguments, Type[] typesToCompare1, Type[] typesToCompare2) {
        if (typesToCompare1.length != typesToCompare2.length) {
            return false;
        }
        boolean isMorePrecise = false;
        for (int i = 0; i < typesToCompare1.length; i++) {
            Type t1 = typesToCompare1[i];
            Type t2 = typesToCompare2[i];
            if (equalsType(t1, t2)) {
                continue;
            }
            if (t1 instanceof ArrayType || t2 instanceof ArrayType) {
                return false;
            }
            ExprNode at = arguments[i];
            if (isMorePreciseType(at, t2, t1)) {
                return false;
            }
            if (isMorePreciseType(at, t1, t2)) {
                isMorePrecise = true;
            }
        }
        return isMorePrecise;
    }

    private List<Resolution> selectMostPrecise(List<Resolution> mds, ExprNode[] args) {
        int size = mds.size();
        if (size == 0) {
            return new ArrayList<>();
        }
        Resolution ret = mds.get(0);
        for (int i = 1; i < size; i++) {
            Resolution m = mds.get(i);
            Type[] mpts = getMethodParameterTypes(m.method);
            Type[] retTypes = getMethodParameterTypes(ret.method);
            if (isMorePreciseTypes(args, mpts, retTypes)) {
                ret = m;
                continue;
            }
            if (isMorePreciseTypes(args, retTypes, mpts)) {
                continue;
            }
            return Arrays.asList(ret, m);
        }
        return Collections.singletonList(ret);
    }

    protected Type[] getMethodParameterTypes(MethodDescriptor m) {
        return m.getParameterTypes();
    }

    protected boolean isMorePreciseType(ExprNode arg, Type t1, Type t2) {
        Type actualType = arg.getType();
        if (t1.isAssignableFrom(t2)) return false;
        if (t2.isAssignableFrom(t1)) return true;
        if (actualType.equals(t1) && !actualType.equals(t2)) return true;
        if (actualType.equals(t2) && !actualType.equals(t1)) return false;
        if (actualType instanceof ClassType) {
            if ((t1 instanceof ClassType) && (t2 instanceof PrimitiveType)) return true;
        } else if (actualType instanceof PrimitiveType) {
            if ((t1 instanceof PrimitiveType) && (t2 instanceof ClassType)) return true;
            if (t1 instanceof PrimitiveType && t2 instanceof PrimitiveType) {
                return Types.isPrimitiveCastable((PrimitiveType) t1, (PrimitiveType) t2);
            }
        }
        //TODO imcomplete isMorePreciseType
        return false;
    }

    protected boolean equalsType(Type type1, Type type2) {
        return type1.equals(type2);
    }

    @Nullable
    protected Integer getMatchScore(int castMethod) {
        switch (castMethod) {
            case BoxUtil.CAST_CONST:
                return 0;
            case BoxUtil.CAST_UNSUPPORTED:
                return null;
            case BoxUtil.CAST_NOTHING:
                return 1;
            case BoxUtil.CAST_PRIMITIVE_TO_OBJECT:
            case BoxUtil.CAST_OBJECT_TO_PRIMITIVE:
            case BoxUtil.CAST_PRIMITIVE:
                return 2;
            default:
                throw Exceptions.unknownValue(castMethod);

        }
    }

    private boolean isFullMatchScore(ApplyResult[] applyResult) {
        for (ApplyResult res : applyResult) {
            if (res.score != 0) {
                return false;
            }
        }
        return true;
    }

    private ExprNode[] getAppliedArgs(ApplyResult[] results) {
        ExprNode[] exprs = new ExprNode[results.length];
        for (int i = 0; i < results.length; i++) {
            exprs[i] = results[i].appliedArgs;
        }
        return exprs;
    }

    private static class ApplyResult {
        int score;
        ExprNode appliedArgs;

        public ApplyResult(int score, ExprNode appliedArgs) {
            this.score = score;
            this.appliedArgs = appliedArgs;
        }
    }

    public static class Resolution {
        public MethodDescriptor method;
        public ExprNode[] appliedArgs;

        public Resolution(MethodDescriptor method, ExprNode[] appliedArgs) {
            this.method = method;
            this.appliedArgs = appliedArgs;
        }
    }

}

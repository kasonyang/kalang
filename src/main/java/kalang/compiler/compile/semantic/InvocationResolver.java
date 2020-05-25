package kalang.compiler.compile.semantic;

import kalang.compiler.ast.ExprNode;
import kalang.compiler.core.*;
import kalang.compiler.util.*;

import javax.annotation.Nullable;
import java.util.*;

import static kalang.mixin.CollectionMixin.map;

/**
 * @author KasonYang
 */
public class InvocationResolver {

    public List<Resolution> resolve(MethodDescriptor[] methods, String methodName, ExprNode... args) {
        List<Resolution> matched = new ArrayList<>(methods.length);
        for (MethodDescriptor m : methods) {
            if (!methodName.equals(m.getName())) {
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
            Type tailComponentType = tailArgs.length == 0
                    ? lastComponentType
                    : TypeUtil.getCommonType(map(tailArgs, Type.class, ExprNode::getType));
            result[parameters.length - 1] = new ApplyResult(3, AstUtil.createInitializedArray(tailComponentType, tailArgs));
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
            if (Objects.equals(t1, t2)) {
                continue;
            }
            Type at;
            if (t1 instanceof ArrayType || t2 instanceof ArrayType) {
                at = null;
            } else {
                at = arguments[i].getType();
            }
            if (isMorePreciseType(t2, t1, at)) {
                return false;
            }
            if (isMorePreciseType(t1, t2, at)) {
                isMorePrecise = true;
            }
        }
        return isMorePrecise;
    }

    private List<Resolution> selectMostPrecise(List<Resolution> resolutions, ExprNode[] args) {
        int size = resolutions.size();
        if (size == 0) {
            return new ArrayList<>();
        }
        Resolution best = resolutions.get(0);
        for (int i = 1; i < size; i++) {
            Resolution current = resolutions.get(i);
            Type[] ptsOfCurrent = current.method.getParameterTypes();
            Type[] ptsOfBest = best.method.getParameterTypes();
            if (isMorePreciseTypes(args, ptsOfCurrent, ptsOfBest)) {
                best = current;
                continue;
            }
            if (isMorePreciseTypes(args, ptsOfBest, ptsOfCurrent)) {
                continue;
            }
            return Arrays.asList(best, current);
        }
        return Collections.singletonList(best);
    }

    protected boolean isMorePreciseType(Type t1, Type t2, @Nullable Type actualType) {
        if (t1.isAssignableFrom(t2)) return false;
        if (t2.isAssignableFrom(t1)) return true;
        if (actualType != null) {
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
        }
        //TODO imcomplete isMorePreciseType
        return false;
    }

    @Nullable
    protected Integer getMatchScore(int castMethod) {
        switch (castMethod) {
            case BoxUtil.CAST_UNSUPPORTED:
                return null;
            case BoxUtil.CAST_CONST:
                return 0;
            case BoxUtil.CAST_NOTHING:
            case BoxUtil.CAST_PRIMITIVE_TO_OBJECT:
            case BoxUtil.CAST_OBJECT_TO_PRIMITIVE:
            case BoxUtil.CAST_PRIMITIVE:
                return 1;
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

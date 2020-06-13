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

    private final static int SCORE_EQUALS = 0;
    private final static int SCORE_SUBTYPE = 1;
    private final static int SCORE_CASTABLE = 2;
    private final static int SCORE_VARARG = 3;


    public List<Resolution> resolveArgs(MethodDescriptor[] methods, ExprNode... args) {
        List<ArgsApplyResult> appliedList = new ArrayList<>(methods.length);
        for (MethodDescriptor m : methods) {
            ArgsApplyResult argsApplyRes = applyArgsToParams(m, args);
            if (argsApplyRes == null) {
                continue;
            }
            if (isFullMatchScore(argsApplyRes.scores)) {
                return Collections.singletonList(new Resolution(m, argsApplyRes.appliedArgs));
            } else {
                appliedList.add(argsApplyRes);
            }
        }
        if (appliedList.isEmpty()) {
            return Collections.emptyList();
        }
        return selectMostPrecise(appliedList, args);
    }

    @Nullable
    private ArgsApplyResult applyArgsToParams(MethodDescriptor method, ExprNode[] args) {
        ParameterDescriptor[] parameters = method.getParameterDescriptors();
        boolean isVarArgs = ModifierUtil.isVarArgs(method.getModifier());
        if (parameters.length == 0) {
            return args.length == 0 ? new ArgsApplyResult(method, new int[0],new ExprNode[0], new Type[0]) : null;
        }
        int[] scores = new int[args.length];
        Type[] matchTypes = new Type[args.length];
        ExprNode[] appliedArgs = new ExprNode[parameters.length];
        int lastParamIndex = parameters.length - 1;
        ParameterDescriptor lastParam = parameters[lastParamIndex];
        if (isVarArgs) {
            if (args.length < parameters.length - 1) {
                return null;
            }
            ExprNode[] tailArgs = new ExprNode[args.length - parameters.length + 1];
            for (int i = 0; i < parameters.length - 1; i++) {
                SingleApplyResult r = applyArgToParam(args[i], parameters[i].getType(), false);
                if (r == null) {
                    return null;
                }
                scores[i] = r.score;
                appliedArgs[i] = r.appliedArg;
                matchTypes[i] = parameters[i].getType();
            }
            if (args.length == parameters.length) {
                SingleApplyResult r = applyArgToParam(args[lastParamIndex], parameters[lastParamIndex].getType(), false);
                if (r != null) {
                    scores[lastParamIndex] = r.score;
                    appliedArgs[lastParamIndex] = r.appliedArg;
                    matchTypes[lastParamIndex] = parameters[lastParamIndex].getType();
                    return new ArgsApplyResult(method, scores, appliedArgs, matchTypes);
                }
            }
            Type lastComponentType = ((ArrayType) lastParam.getType()).getComponentType();
            for (int i = 0; i < tailArgs.length; i++) {
                SingleApplyResult tailApplyRes = applyArgToParam(args[lastParamIndex + i], lastComponentType, true);
                if (tailApplyRes == null) {
                    return null;
                }
                tailArgs[i] = tailApplyRes.appliedArg;
                scores[lastParamIndex + i] = tailApplyRes.score;
                matchTypes[lastParamIndex + i] = lastComponentType;
            }
            Type tailComponentType = tailArgs.length == 0
                    ? lastComponentType
                    : TypeUtil.getCommonType(map(tailArgs, Type.class, ExprNode::getType));
            appliedArgs[lastParamIndex] = AstUtil.createInitializedArray(tailComponentType, tailArgs);
        } else {
            if (parameters.length != args.length) {
                return null;
            }
            for (int i = 0; i < args.length; i++) {
                SingleApplyResult r = applyArgToParam(args[i], parameters[i].getType(), false);
                if (r == null) {
                    return null;
                }
                scores[i] = r.score;
                appliedArgs[i] = r.appliedArg;
                matchTypes[i] = parameters[i].getType();
            }
        }
        return new ArgsApplyResult(method, scores, appliedArgs, matchTypes);
    }

    @Nullable
    private SingleApplyResult applyArgToParam(ExprNode arg, Type paramType, boolean isVarargMode) {
        Type argType = arg.getType();
        if (argType.equals(paramType)) {
            return new SingleApplyResult(isVarargMode ? SCORE_VARARG : SCORE_EQUALS, arg);
        }
        int castMethod = BoxUtil.getCastMethod(arg, paramType);
        Integer score = getMatchScore(castMethod);
        if (score == null) {
            return null;
        }
        ExprNode appliedArg = BoxUtil.assign(arg, paramType);
        Objects.requireNonNull(appliedArg);
        return new SingleApplyResult(isVarargMode ? SCORE_VARARG : score, appliedArg);
    }

    private boolean isMorePreciseTypes(ExprNode[] args,int[] scores1,int[] scores2, Type[] paramTypes1, Type[] paramTypes2) {
        boolean isMorePrecise = false;
        for (int i = 0; i < args.length; i++) {
            int s1 = scores1[i];
            int s2 = scores2[i];
            if (s1 < s2) {
                isMorePrecise = true;
                continue;
            } else if (s1 > s2) {
                return false;
            }
            Type t1 = paramTypes1[i];
            Type t2 = paramTypes2[i];
            if (Objects.equals(t1, t2)) {
                continue;
            }
            Type  at = args[i].getType();
            if (isMorePreciseType(t2, t1, at)) {
                return false;
            }
            if (isMorePreciseType(t1, t2, at)) {
                isMorePrecise = true;
            }
        }
        if (!isMorePrecise && paramTypes1.length == args.length && paramTypes2.length > args.length) {
            return true;
        }
        return isMorePrecise;
    }

    private List<Resolution> selectMostPrecise(List<ArgsApplyResult> argsApplyResults, ExprNode[] args) {
        int size = argsApplyResults.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        ArgsApplyResult best = argsApplyResults.get(0);
        for (int i = 1; i < size; i++) {
            ArgsApplyResult current = argsApplyResults.get(i);
            Type[] pTypesOfCurrent = current.method.getParameterTypes();
            int[] scoresOfCurrent = current.scores;
            Type[] pTypesOfBest = best.method.getParameterTypes();
            int[] scoresOfBest = best.scores;
            if (isMorePreciseTypes(args,scoresOfCurrent, scoresOfBest,  pTypesOfCurrent, pTypesOfBest)) {
                best = current;
                continue;
            }
            if (isMorePreciseTypes(args,scoresOfBest, scoresOfCurrent, pTypesOfBest, pTypesOfCurrent)) {
                continue;
            }
            return Arrays.asList(new Resolution(best.method, best.appliedArgs),new Resolution(current.method, current.appliedArgs));
        }
        return Collections.singletonList(new Resolution(best.method, best.appliedArgs));
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
                return SCORE_EQUALS;
            case BoxUtil.CAST_NOTHING:
                return SCORE_SUBTYPE;
            case BoxUtil.CAST_PRIMITIVE_TO_OBJECT:
            case BoxUtil.CAST_OBJECT_TO_PRIMITIVE:
            case BoxUtil.CAST_PRIMITIVE:
                return SCORE_CASTABLE;
            default:
                throw Exceptions.unknownValue(castMethod);

        }
    }

    private boolean isFullMatchScore(int[] scores) {
        for (int s : scores) {
            if (s != SCORE_EQUALS) {
                return false;
            }
        }
        return true;
    }

    private static class ArgsApplyResult {
        MethodDescriptor method;
        int[] scores;
        Type[] matchTypes;
        ExprNode[] appliedArgs;

        public ArgsApplyResult(MethodDescriptor method, int[] scores, ExprNode[] appliedArgs,Type[] matchTypes) {
            this.method = method;
            this.scores = scores;
            this.appliedArgs = appliedArgs;
            this.matchTypes = matchTypes;
        }

    }

    private static class SingleApplyResult {
        int score;
        ExprNode appliedArg;

        public SingleApplyResult(int score, ExprNode appliedArg) {
            this.score = score;
            this.appliedArg = appliedArg;
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

package kalang.compiler.util;

import kalang.compiler.core.ExtendModifiers;
import kalang.compiler.core.ModifierConstant;

import java.lang.reflect.Modifier;
import java.util.StringJoiner;

/**
 *
 * @author Kason Yang
 */
public class ModifierUtil {

    public static int setPrivate(int modifier) {
        return modifier
                & (~Modifier.PUBLIC)
                & (~Modifier.PROTECTED)
                | (Modifier.PRIVATE);
    }

    public static int setProtected(int modifier) {
        return modifier
                & (~Modifier.PUBLIC)
                & (~Modifier.PRIVATE)
                | (Modifier.PROTECTED);
    }

    public static int setPublic(int modifier) {
        return modifier
                & (~Modifier.PRIVATE)
                & (~Modifier.PROTECTED)
                | (Modifier.PUBLIC);
    }

    public static boolean isDefault(int modifier) {
        return Modifier.isPublic(modifier) && !Modifier.isAbstract(modifier);
    }

    public static boolean isInterface(int modifier) {
        return Modifier.isInterface(modifier);
    }

    public static boolean isSynthetic(int modifier) {
        return (modifier & ModifierConstant.SYNTHETIC) > 0;
    }

    public static boolean isStatic(int modifier) {
        return Modifier.isStatic(modifier);
    }

    public static boolean isFinal(int modifier) {
        return Modifier.isFinal(modifier);
    }

    public static boolean isVarArgs(int modifier) {
        return (ModifierConstant.VARARGS & modifier) != 0;
    }

    /**
     *
     * @param modifierString the string of modifier,could be multiple modifier
     * such as "public static".
     * @param defaultAccess the default access modifier,should be one of
     * public,protected,private
     * @return modifier value
     * @throws InvalidModifierException
     */
    public static long parse(String modifierString,int defaultAccess) throws InvalidModifierException {
        if (modifierString.isEmpty()) {
            throw new InvalidModifierException("modifier could not be empty");
        }
        long m = 0;
        for (String s : modifierString.split(" ")) {
            m = addModifier(m, parseSingleModfier(s));
        }
        boolean isPublic = Modifier.isPublic((int)m);
        boolean isPrivate = Modifier.isPrivate((int)m);
        boolean isProtected = Modifier.isProtected((int)m);
        if(!isPrivate && !isProtected && !isPublic)  m|=defaultAccess;
        return m;
    }
    
        public static long parse(String modifierString) throws InvalidModifierException {
            return parse(modifierString,Modifier.PUBLIC);
        }

    private static long parseSingleModfier(String s) throws InvalidModifierException {
        switch (s) {
            case "public":
                return Modifier.PUBLIC;
            case "protected":
                return Modifier.PROTECTED;
            case "private":
                return Modifier.PRIVATE;
            case "static":
                return Modifier.STATIC;
            case "final":
                return Modifier.FINAL;
            case "abstract":
                return Modifier.ABSTRACT;
            case "native":
                return Modifier.NATIVE;
            case "synchronized":
                return Modifier.SYNCHRONIZED;
            case "transient":
                return Modifier.TRANSIENT;
            case "volatile":
                return Modifier.VOLATILE;
            case "async":
                return (long)ExtendModifiers.ASYNC << 32;
            default:
                throw new InvalidModifierException("unrecognized modifier:" + s);
        }
    }

    private static long addModifier(long modifiers, long singleModifier) throws InvalidModifierException {
        if ((modifiers & singleModifier) > 0) {
            throw new InvalidModifierException("repeat modifiers:" + toString(singleModifier));
        }
        long result = modifiers | singleModifier;
        boolean isPublic = isPublic(result);
        boolean isPrivate = isPrivate(result);
        boolean isProtected = isProtected(result);
        if (isPublic && isPrivate) {
            throw new InvalidModifierException("invalid combination of modifiers:public private");
        }
        if (isPublic && isProtected) {
            throw new InvalidModifierException("invalid combination of modifiers:public protected");
        }
        if (isProtected && isPrivate) {
            throw new InvalidModifierException("invalid combination of modifiers:protected private");
        }
        return result;
    }

    public static boolean isPublic(long mod) {
        return (mod & Modifier.PUBLIC) != 0;
    }

    public static boolean isPrivate(long mod) {
        return (mod & Modifier.PRIVATE) != 0;
    }

    public static boolean isProtected(long mod) {
        return (mod & Modifier.PROTECTED) != 0;
    }

    public static String toString(long mod) {
        StringJoiner sj = new StringJoiner(" ");
        int extendMod = (int) (mod >> 32);
        if (ExtendModifiers.isAsync(extendMod)) {
            sj.add("async");
        }
        sj.add(Modifier.toString((int)mod));
        return sj.toString();
    }

}

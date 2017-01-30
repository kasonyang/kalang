package kalang.util;

import java.lang.reflect.Modifier;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
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

    /**
     *
     * @param modifierString the string of modifier,could be multiple modifier
     * such as "public static".
     * @param defaultAccess the default access modifier,should be one of
     * public,protected,private
     * @return
     * @throws InvalidModifierException
     */
    public static int valueOf(String modifierString) throws InvalidModifierException {
        if (modifierString.isEmpty()) {
            throw new InvalidModifierException("modifier could not be empty");
        }
        int m = 0;
        for (String s : modifierString.split(" ")) {
            m = addModifier(m, parseSingleModfier(s));
        }
        return m;
    }

    private static int parseSingleModfier(String s) throws InvalidModifierException {
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
            default:
                throw new InvalidModifierException("unrecognized modifier:" + s);
        }
    }

    private static int addModifier(int modifiers, int singleModifier) throws InvalidModifierException {
        if ((modifiers & singleModifier) > 0) {
            throw new InvalidModifierException("repeat modifiers:" + Modifier.toString(singleModifier));
        }
        int result = modifiers | singleModifier;
        boolean isPublic = Modifier.isPublic(result);
        boolean isPrivate = Modifier.isPrivate(result);
        boolean isProtected = Modifier.isProtected(result);
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

}

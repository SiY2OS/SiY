package org.siy.common.utils;

/**
 * @author Ryan
 */
public class EnumUtils {

    public static <E extends Enum<E>> E getEnum(Class<E> eClass, int index) {
        E[] enumConstants = eClass.getEnumConstants();
        for (E enumConstant : enumConstants) {
            if (enumConstant.ordinal() == index) {
                return enumConstant;
            }
        }
        return null;
    }

}

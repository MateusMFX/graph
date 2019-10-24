package util;

import java.lang.reflect.Constructor;

/**
 * Classe debugger de Objecto facilita o rastreamento na procura de erros.
 *
 * @author d3c0de <decospdl@gmail.com>
 * @version 1.0.0
 */
public abstract class Reflection {

    private static String tab = "";

    public static <T> T clone(T object) {
        try {
            Constructor constructor = object.getClass().getConstructor(object.getClass());
            return (T) constructor.newInstance(object);
        } catch (Exception e) {
            return object;
        }
    }
}

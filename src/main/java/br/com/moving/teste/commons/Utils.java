package br.com.moving.teste.commons;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class Utils {

    public static void notNull(Object param) {
        if (param == null) {
            throw new IllegalArgumentsException(param);
        }
    }
}

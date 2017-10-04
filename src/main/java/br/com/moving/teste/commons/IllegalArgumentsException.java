package br.com.moving.teste.commons;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class IllegalArgumentsException extends RuntimeException {
    public IllegalArgumentsException(Object obj) {
        super("O valor de " + obj + " não foi informado!");
    }
}

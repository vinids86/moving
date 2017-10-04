package br.com.moving.teste.commons;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
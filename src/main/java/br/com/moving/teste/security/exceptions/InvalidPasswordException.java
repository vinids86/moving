package br.com.moving.teste.security.exceptions;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String password) {
        super(password);
    }
}

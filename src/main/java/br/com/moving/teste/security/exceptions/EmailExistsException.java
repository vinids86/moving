package br.com.moving.teste.security.exceptions;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String email) {
        super("Já existe uma conta com o email: " + email);
    }
}

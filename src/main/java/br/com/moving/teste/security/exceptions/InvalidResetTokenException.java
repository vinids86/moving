package br.com.moving.teste.security.exceptions;

/**
 * Created by ifc.vinicius.saraiva on 03/10/17.
 */
public class InvalidResetTokenException extends RuntimeException {
    public InvalidResetTokenException(String resetToken) {
        super(resetToken + " inválido!");
    }
}

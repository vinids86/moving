package br.com.moving.teste.security.exceptions;

/**
 * Created by ifc.vinicius.saraiva on 03/10/17.
 */
public class UserIdNotAllowedException extends RuntimeException {
    public UserIdNotAllowedException(String user, String userLogged) {
        super(user + " não pode atualizar a senha do " + userLogged);
    }
}

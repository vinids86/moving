package br.com.moving.teste.commons;

import br.com.moving.teste.security.exceptions.EmailExistsException;
import br.com.moving.teste.security.exceptions.InvalidPasswordException;
import br.com.moving.teste.security.exceptions.UserIdNotAllowedException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public class ControllerAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors userNotFoundExceptionHandler(NotFoundException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndErrors usernameNotFoundExceptionHandler(UsernameNotFoundException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(MailException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    VndErrors mailException(MailException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(EmailExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndErrors emailExistsException(EmailExistsException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UserIdNotAllowedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    VndErrors userIdNotAllowedException(UserIdNotAllowedException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndErrors invalidPasswordException(InvalidPasswordException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }
}

package br.com.moving.teste.security.annotations;

import br.com.moving.teste.security.application.resources.UserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches passwordMatches) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserRequest user = (UserRequest) o;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

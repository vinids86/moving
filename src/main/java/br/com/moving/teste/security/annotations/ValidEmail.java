package br.com.moving.teste.security.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Anotação para validar se email é valido.
 *
 * Para um email ser considerado válido é necessário ter ao menos um alfanumérico, seguido um @
 * ao menos um alfanumérico novamente, ponto(.) e duas letras no final
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Email inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

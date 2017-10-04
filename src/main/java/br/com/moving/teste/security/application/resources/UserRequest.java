package br.com.moving.teste.security.application.resources;

import br.com.moving.teste.security.annotations.PasswordMatches;
import br.com.moving.teste.security.annotations.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Data
@PasswordMatches
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class  UserRequest extends ResourceSupport {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastname;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String confirmPassword;

    private String newPassword;

    private String resetToken;
}

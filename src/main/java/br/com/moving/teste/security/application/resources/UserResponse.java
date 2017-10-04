package br.com.moving.teste.security.application.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserResponse extends ResourceSupport {
    private String name;
    private String lastname;
    private String email;
}

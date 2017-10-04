package br.com.moving.teste.security.vo;

import br.com.moving.teste.commons.AbstractVO;
import lombok.*;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Data
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class UserVO extends AbstractVO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
}

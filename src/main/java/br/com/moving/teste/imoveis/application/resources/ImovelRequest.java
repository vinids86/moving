package br.com.moving.teste.imoveis.application.resources;

import br.com.moving.teste.imoveis.models.Type;
import lombok.*;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class ImovelRequest extends ResourceSupport {
    private final @NonNull
    Long imobiliariaId;
    private final @NonNull
    String description;
    private final @NonNull
    String address;
    private final @NonNull
    Long imovelId;
    private final @NonNull
    Type type;
}

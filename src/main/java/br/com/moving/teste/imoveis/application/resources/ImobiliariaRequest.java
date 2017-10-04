package br.com.moving.teste.imoveis.application.resources;

import br.com.moving.teste.imoveis.models.Imovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class ImobiliariaRequest extends ResourceSupport {
    private String name;
    private String description;
    private List<Imovel> imoveis;
}

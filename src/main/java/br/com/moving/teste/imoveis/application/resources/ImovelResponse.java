package br.com.moving.teste.imoveis.application.resources;

import br.com.moving.teste.imoveis.models.Type;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.Assert;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ImovelResponse extends ResourceSupport {

    private final Type type;
    private final String description;
    private final String address;

    public ImovelResponse(ImovelVO vo) {
        Assert.notNull(vo, "The given ImobiliariaVO must not be null!");
        this.type = vo.getType();
        this.description = vo.getDescription();
        this.address = vo.getAddress();
    }
}

package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.ResourceAssemblerSupportMoving;
import br.com.moving.teste.imoveis.application.ImovelController;
import br.com.moving.teste.imoveis.application.resources.ImovelResponse;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import lombok.NonNull;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
public class ImovelResourceAssembler extends ResourceAssemblerSupportMoving<ImovelVO, ImovelResponse> {

    private final @NonNull
    EntityLinks entityLinks;

    public ImovelResourceAssembler(EntityLinks entityLinks) {
        super(ImovelController.class, ImovelResponse.class);
        this.entityLinks = entityLinks;
    }

    public ImovelResponse toResource(ImovelVO vo) {
        final ImovelResponse resource = new ImovelResponse(vo);
        resource.add(entityLinks.linkToSingleResource(vo));
        return resource;
    }
}

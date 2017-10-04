package br.com.moving.teste.commons;

import br.com.moving.teste.imoveis.models.Imovel;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public interface VOAssembler<Resource extends ResourceSupport, VO extends AbstractVO, ORM extends AbstractEntity> {

    /**
     * Mapeia um Recurso para um VO
     * @param resource Recurso a ser mapeado
     * @return Objeto de Valor
     */
    VO toVO(Resource resource);

    VO toVO(ORM orm);

    List<VO> resourcesToVOList(List<Resource> resources);

    List<VO> ormsToVOList(List<ORM> orms);
}
package br.com.moving.teste.imoveis.services;

import br.com.moving.teste.commons.CRUDService;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public interface ImovelService extends CRUDService<ImovelVO> {

    /**
     * Busca imobiliaria pelo id
     * @param id id da imobiliaria
     * @param pageable interface com informações de paginação
     * @return Lista de imóveis de uma determinada imobiliaria
     */
    Page<ImovelVO> getAllByImobiliaria(Long id, Pageable pageable);
}

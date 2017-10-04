package br.com.moving.teste.imoveis.services;

import br.com.moving.teste.imoveis.models.Imovel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    /**
     * Busca imobiliaria pelo id
     * @param imobiliariaId id da imobiliaria
     * @param pageable interface com informações de paginação
     * @return Lista de imóveis de uma determinada imobiliaria
     */
    Page<Imovel> findByImobiliariaId(Long imobiliariaId, Pageable pageable);
}

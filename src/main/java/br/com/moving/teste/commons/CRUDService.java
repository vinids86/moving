package br.com.moving.teste.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public interface CRUDService<T> {

    /**
     * Salva Persiste VO
     * @param vo VO para ser salvo
     * @return VO após ser salvo
     */
    T save(T vo);

    /**
     * Recupera VO pelo id
     * @param id id do VO
     * @return VO persistido
     */
    T getById(Long id);

    /**
     * Recupera todos os VOs
     * @param pageable interface com informações de paginação
     * @return Todos os VOs persistidos
     */
    Page<T> getAll(Pageable pageable);

    /**
     * Deleta um VO pelo id
     * @param id id do VO
     */
    void delete(Long id);

    /**
     * Atualiza um VO pelo id
     * @param id id do VO
     * @param vo VO com atributos atualizados
     * @return VO persistido após ser atualizado
     */
    T update(Long id, T vo);
}

package br.com.moving.teste.commons;

import java.util.List;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public interface ORMAssembler<VO extends AbstractVO, ORM> {
    /**
     * Mapeia VO para um Objeto Relacional
     * @param vo VO a ser mapeado
     * @return Objeto Relacional
     */
    ORM toORM(VO vo);

    /**
     * Mapeia uma lista de VOs para uma lista de Objetos Relacionais
     * @param vos lista de VOs a ser mapeada
     * @return lista de Objeto Relacionais
     */
    List<ORM> toORMList(List<VO> vos);
}

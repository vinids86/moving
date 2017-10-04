package br.com.moving.teste.commons;

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
}

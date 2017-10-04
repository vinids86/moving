package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.ORMAssembler;
import br.com.moving.teste.imoveis.models.Imobiliaria;
import br.com.moving.teste.imoveis.vos.ImobiliariaVO;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
public class ImobiliariaORMAssembler implements ORMAssembler<ImobiliariaVO, Imobiliaria> {

    @Override
    public Imobiliaria toORM(ImobiliariaVO vo) {
        final Imobiliaria imobiliaria = new Imobiliaria();
        imobiliaria.setName(vo.getName());
        imobiliaria.setDescription(vo.getDescription());
        imobiliaria.setImoveis(vo.getImoveis());
        return imobiliaria;
    }
}

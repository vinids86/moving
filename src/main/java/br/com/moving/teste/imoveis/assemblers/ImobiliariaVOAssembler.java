package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.VOAssembler;
import br.com.moving.teste.imoveis.application.resources.ImobiliariaRequest;
import br.com.moving.teste.imoveis.models.Imobiliaria;
import br.com.moving.teste.imoveis.vos.ImobiliariaVO;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
public class ImobiliariaVOAssembler implements VOAssembler<ImobiliariaRequest, ImobiliariaVO, Imobiliaria> {
    @Override
    public ImobiliariaVO toVO(ImobiliariaRequest request) {
        final ImobiliariaVO vo = new ImobiliariaVO();
        return vo;
    }

    @Override
    public ImobiliariaVO toVO(Imobiliaria imobiliaria) {
        final ImobiliariaVO vo = new ImobiliariaVO();
        vo.setImobiliariaId(imobiliaria.getId());
        vo.setImoveis(imobiliaria.getImoveis());
        vo.setName(imobiliaria.getName());
        vo.setDescription(imobiliaria.getDescription());
        return vo;
    }
}

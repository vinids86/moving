package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.VOAssembler;
import br.com.moving.teste.imoveis.application.resources.ImovelRequest;
import br.com.moving.teste.imoveis.models.Imovel;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
public class ImovelVOAssembler implements VOAssembler<ImovelRequest, ImovelVO, Imovel> {

    @Override
    public ImovelVO toVO(ImovelRequest request) {
        final ImovelVO vo = new ImovelVO();
        vo.setId(request.getImovelId());
        vo.setType(request.getType());
        vo.setAddress(request.getAddress());
        vo.setImobiliariaId(request.getImobiliariaId());
        vo.setDescription(request.getDescription());
        return vo;
    }

    @Override
    public ImovelVO toVO(Imovel imovel) {
        ImovelVO vo = new ImovelVO();
        vo.setId(imovel.getId());
        vo.setType(imovel.getType());
        vo.setAddress(imovel.getAddress());
        vo.setImobiliariaId(imovel.getImobiliaria().getId());
        vo.setDescription(imovel.getDescription());
        return vo;
    }
}

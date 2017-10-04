package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.VOAssembler;
import br.com.moving.teste.imoveis.application.resources.ImobiliariaRequest;
import br.com.moving.teste.imoveis.models.Imobiliaria;
import br.com.moving.teste.imoveis.vos.ImobiliariaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static br.com.moving.teste.commons.Utils.notNull;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImobiliariaVOAssembler implements VOAssembler<ImobiliariaRequest, ImobiliariaVO, Imobiliaria> {


    private final @NotNull ImovelVOAssembler imovelVOAssembler;

    @Override
    public ImobiliariaVO toVO(ImobiliariaRequest request) {
        final ImobiliariaVO vo = new ImobiliariaVO();
        return vo;
    }

    @Override
    public ImobiliariaVO toVO(Imobiliaria imobiliaria) {
        final ImobiliariaVO vo = new ImobiliariaVO();
        vo.setImobiliariaId(imobiliaria.getId());
        vo.setImoveisVO(imovelVOAssembler.ormsToVOList(imobiliaria.getImoveis()));
        vo.setName(imobiliaria.getName());
        vo.setDescription(imobiliaria.getDescription());
        return vo;
    }

    @Override
    public List<ImobiliariaVO> resourcesToVOList(List<ImobiliariaRequest> imobiliariaRequests) {
        notNull(imobiliariaRequests);

        final ArrayList<ImobiliariaVO> imobiliariaVOS = new ArrayList<>();
        imobiliariaRequests.forEach(request -> imobiliariaVOS.add(this.toVO(request)));
        return imobiliariaVOS;
    }

    @Override
    public List<ImobiliariaVO> ormsToVOList(List<Imobiliaria> imobiliarias) {
        notNull(imobiliarias);

        final ArrayList<ImobiliariaVO> imobiliariasVO = new ArrayList<>();
        imobiliarias.forEach(imobiliaria -> imobiliariasVO.add(this.toVO(imobiliaria)));
        return imobiliariasVO;
    }
}

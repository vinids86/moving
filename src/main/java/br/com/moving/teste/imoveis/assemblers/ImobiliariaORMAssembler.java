package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.ORMAssembler;
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
public class ImobiliariaORMAssembler implements ORMAssembler<ImobiliariaVO, Imobiliaria> {

    private final @NotNull ImovelORMAssembler imovelORMAssembler;

    @Override
    public Imobiliaria toORM(ImobiliariaVO vo) {
        notNull(vo);

        final Imobiliaria imobiliaria = new Imobiliaria();
        imobiliaria.setName(vo.getName());
        imobiliaria.setDescription(vo.getDescription());
        imobiliaria.setImoveis(imovelORMAssembler.toORMList(vo.getImoveisVO()));
        return imobiliaria;
    }

    @Override
    public List<Imobiliaria> toORMList(List<ImobiliariaVO> imobiliariaVOS) {
        notNull(imobiliariaVOS);

        final ArrayList<Imobiliaria> imobiliarias = new ArrayList<>();
        imobiliariaVOS.forEach(imobiliariaVO -> imobiliarias.add(this.toORM(imobiliariaVO)));
        return imobiliarias;

    }
}

package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.ORMAssembler;
import br.com.moving.teste.imoveis.models.Imovel;
import br.com.moving.teste.imoveis.services.ImobiliariaRepository;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.moving.teste.commons.Utils.notNull;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImovelORMAssembler implements ORMAssembler<ImovelVO, Imovel> {

    private final @NonNull
    ImobiliariaRepository imobiliariaRepository;

    @Override
    public Imovel toORM(ImovelVO vo) {
        Imovel imovel = new Imovel();
        imovel.setDescription(vo.getDescription());
        imovel.setAddress(vo.getAddress());
        imovel.setType(vo.getType());
        imovel.setImobiliaria(imobiliariaRepository.findOne(vo.getImobiliariaId()));
        return imovel;
    }

    @Override
    public List<Imovel> toORMList(List<ImovelVO> imoveisVO) {
        notNull(imoveisVO);

        final ArrayList<Imovel> imoveis = new ArrayList<>();
        imoveisVO.forEach(imovelVO -> imoveis.add(this.toORM(imovelVO)));
        return imoveis;
    }
}

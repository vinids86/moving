package br.com.moving.teste.imoveis.assemblers;

import br.com.moving.teste.commons.ORMAssembler;
import br.com.moving.teste.imoveis.models.Imovel;
import br.com.moving.teste.imoveis.services.ImobiliariaRepository;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
@RequiredArgsConstructor
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
}

package br.com.moving.teste.imoveis.services;

import br.com.moving.teste.imoveis.assemblers.ImovelORMAssembler;
import br.com.moving.teste.imoveis.assemblers.ImovelVOAssembler;
import br.com.moving.teste.imoveis.exceptions.ImovelNotFoundException;
import br.com.moving.teste.imoveis.models.Imovel;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImovelServiceImpl implements ImovelService {

    private final @NonNull
    ImovelRepository imovelRepository;

    private final @NonNull
    ImovelVOAssembler imovelVOAssembler;
    private final @NonNull
    ImovelORMAssembler imovelORMAssembler;

    private final @NonNull
    ImobiliariaRepository imobiliariaRepository;

    @Override
    @Transactional
    public ImovelVO save(ImovelVO vo) {
        return imovelVOAssembler.toVO(imovelRepository.save(imovelORMAssembler.toORM(vo)));
    }

    @Override
    public ImovelVO getById(Long id) {
        return imovelVOAssembler.toVO(
                Optional.ofNullable(imovelRepository.findOne(id))
                        .orElseThrow(() -> new ImovelNotFoundException(id)));
    }

    @Override
    public Page<ImovelVO> getAll(Pageable pageable) {
        return imovelRepository.findAll(pageable).map(imovelVOAssembler::toVO);
    }

    @Override
    public Page<ImovelVO> getAllByImobiliaria(Long id, Pageable pageable) {
        return imovelRepository.findByImobiliariaId(id, pageable).map(imovelVOAssembler::toVO);
    }

    @Override
    @Transactional
    public ImovelVO update(Long id, ImovelVO vo) {
        final Imovel imovel = imovelRepository.findOne(id);
        imovel.setImobiliaria(imobiliariaRepository.findOne(vo.getImobiliariaId()));
        imovel.setType(vo.getType());
        imovel.setAddress(vo.getAddress());
        imovel.setDescription(vo.getDescription());
        return imovelVOAssembler.toVO(imovelRepository.save(imovel));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        imovelRepository.delete(id);
    }
}

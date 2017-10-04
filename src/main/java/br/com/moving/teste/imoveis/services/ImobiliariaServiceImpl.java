package br.com.moving.teste.imoveis.services;

import br.com.moving.teste.imoveis.assemblers.ImobiliariaORMAssembler;
import br.com.moving.teste.imoveis.assemblers.ImobiliariaVOAssembler;
import br.com.moving.teste.imoveis.exceptions.ImobiliariaNotFoundException;
import br.com.moving.teste.imoveis.vos.ImobiliariaVO;
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
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImobiliariaServiceImpl implements ImobiliariaService {

    private @NonNull
    final ImobiliariaRepository imobiliariaRepository;

    private @NonNull
    final ImobiliariaVOAssembler imobiliariaVOAssembler;
    private @NonNull
    final ImobiliariaORMAssembler imobiliariaORMAssembler;

    @Override
    public ImobiliariaVO save(ImobiliariaVO vo) {
        return imobiliariaVOAssembler.toVO(imobiliariaRepository.save(imobiliariaORMAssembler.toORM(vo)));
    }

    @Override
    public ImobiliariaVO getById(Long id) {
        return imobiliariaVOAssembler.toVO(Optional.ofNullable(imobiliariaRepository.findOne(id))
                .orElseThrow(() -> new ImobiliariaNotFoundException(id)));
    }

    @Override
    public Page<ImobiliariaVO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ImobiliariaVO update(Long id, ImobiliariaVO vo) {
        return null;
    }
}

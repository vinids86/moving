package br.com.moving.teste.imoveis.application;

import br.com.moving.teste.imoveis.application.resources.ImovelRequest;
import br.com.moving.teste.imoveis.application.resources.ImovelResponse;
import br.com.moving.teste.imoveis.assemblers.ImovelResourceAssembler;
import br.com.moving.teste.imoveis.assemblers.ImovelVOAssembler;
import br.com.moving.teste.imoveis.services.ImovelService;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/imovel")
@ExposesResourceFor(ImovelVO.class)
public class ImovelController {

    private final static Logger logger = Logger.getLogger(ImovelController.class);

    private final @NonNull
    ImovelService imovelService;
    private @NonNull
    ImovelVOAssembler imovelVOAssembler;

    private @NonNull
    PagedResourcesAssembler<ImovelVO> pageAssembler;
    private @NonNull
    ImovelResourceAssembler imovelResourceAssembler;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ImovelResponse> createImovel(@RequestBody ImovelRequest imovelRequest) {
        final ImovelVO imovelSaved = imovelService.save(imovelVOAssembler.toVO(imovelRequest));
        final ImovelResponse resource = imovelResourceAssembler.toResource(imovelSaved);
        logger.info("Created::" + imovelSaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ImovelResponse> retrieveImovel(@PathVariable Long id) {
        ImovelVO imovel = imovelService.getById(id);
        final ImovelResponse resource = imovelResourceAssembler.toResource(imovel);
        logger.info("Found Imovel::" + imovel);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<ImovelResponse>> listAllImoveis(Pageable pageable) {
        final Page<ImovelVO> imoveis = imovelService.getAll(pageable);
        final PagedResources<ImovelResponse> resources = pageAssembler.toResource(imoveis, imovelResourceAssembler);
        logger.info("Found " + imoveis.getTotalElements() + " imoveis");
        logger.info(imoveis.getContent());
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ImovelResponse> updateImovel(@PathVariable Long id, @RequestBody ImovelRequest imovel) {
        final ImovelVO imovelSave = imovelService.update(id, imovelVOAssembler.toVO(imovel));
        final ImovelResponse imovelResponse = imovelResourceAssembler.toResource(imovelSave);
        logger.info("Updated::" + imovelSave);
        return ResponseEntity.ok(imovelResponse);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteImovel(@PathVariable Long id) {
        imovelService.getById(id);
        imovelService.delete(id);
        logger.info("Imovel with id " + id + " deleted");
        return ResponseEntity.ok().build();
    }

}


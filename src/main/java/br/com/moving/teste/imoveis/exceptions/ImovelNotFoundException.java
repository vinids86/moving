package br.com.moving.teste.imoveis.exceptions;

import br.com.moving.teste.commons.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImovelNotFoundException extends NotFoundException {
    public ImovelNotFoundException(Long id) {
        super("Imovel com id " + id + " não existe");
    }
}

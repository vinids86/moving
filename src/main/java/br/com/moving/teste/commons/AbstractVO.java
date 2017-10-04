package br.com.moving.teste.commons;

import org.springframework.hateoas.Identifiable;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public class AbstractVO implements Identifiable<Long> {
    Long id;

    @Override
    public Long getId() {
        return id;
    }
}

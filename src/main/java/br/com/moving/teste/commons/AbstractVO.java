package br.com.moving.teste.commons;

import org.springframework.hateoas.Identifiable;

import java.io.Serializable;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public class AbstractVO implements Serializable, Identifiable<Long> {
    Long id;

    @Override
    public Long getId() {
        return id;
    }
}

package br.com.moving.teste.commons;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public abstract class ResourceAssemblerSupportMoving<T, D extends ResourceSupport> extends ResourceAssemblerSupport<T, D> implements ResourceAssembler<T, D> {

    public ResourceAssemblerSupportMoving(Class controllerClass, Class resourceType) {
        super(controllerClass, resourceType);
    }
}

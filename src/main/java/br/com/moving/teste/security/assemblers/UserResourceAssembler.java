package br.com.moving.teste.security.assemblers;

import br.com.moving.teste.commons.ResourceAssemblerSupportMoving;
import br.com.moving.teste.security.application.UserController;
import br.com.moving.teste.security.application.resources.UserResponse;
import br.com.moving.teste.security.vo.UserVO;
import lombok.NonNull;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Service
public class UserResourceAssembler extends ResourceAssemblerSupportMoving<UserVO, UserResponse> {

    private final @NonNull
    EntityLinks entityLinks;

    public UserResourceAssembler(EntityLinks entityLinks) {
        super(UserController.class, UserResponse.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public UserResponse toResource(UserVO vo) {
        final UserResponse resource = new UserResponse();
        resource.setEmail(vo.getEmail());
        resource.setLastname(vo.getLastname());
        resource.setName(vo.getName());
        resource.add(entityLinks.linkToSingleResource(vo));
        return resource;
    }
}

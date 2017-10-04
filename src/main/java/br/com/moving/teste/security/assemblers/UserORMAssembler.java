package br.com.moving.teste.security.assemblers;

import br.com.moving.teste.commons.ORMAssembler;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Service
@RequiredArgsConstructor
public class UserORMAssembler implements ORMAssembler<UserVO, User> {

    @Override
    public User toORM(UserVO vo) {
        final User user = new User();
        user.setEmail(vo.getEmail());
        user.setLastname(vo.getLastname());
        user.setName(vo.getName());
        user.setPassword(vo.getPassword());
        return user;
    }
}

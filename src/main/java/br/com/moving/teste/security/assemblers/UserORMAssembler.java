package br.com.moving.teste.security.assemblers;

import br.com.moving.teste.commons.ORMAssembler;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.moving.teste.commons.Utils.notNull;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
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

    @Override
    public List<User> toORMList(List<UserVO> userVOS) {
        notNull(userVOS);

        final ArrayList<User> users = new ArrayList<>();
        userVOS.forEach(userVO -> users.add(this.toORM(userVO)));
        return users;
    }
}

package br.com.moving.teste.security.assemblers;

import br.com.moving.teste.commons.VOAssembler;
import br.com.moving.teste.security.application.resources.UserRequest;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.moving.teste.commons.Utils.notNull;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Service
@AllArgsConstructor
public class UserVOAssembler implements VOAssembler<UserRequest, UserVO, User> {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserVO toVO(UserRequest request) {
        final UserVO vo = new UserVO();
        vo.setEmail(request.getEmail());
        vo.setLastname(request.getLastname());
        vo.setName(request.getName());
        if (request.getPassword() != null)
            vo.setPassword(passwordEncoder.encode(request.getPassword()));
        return vo;
    }

    @Override
    public UserVO toVO(User user) {
        final UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setEmail(user.getEmail());
        vo.setLastname(user.getLastname());
        vo.setName(user.getName());
        vo.setPassword(user.getPassword());
        return vo;
    }

    @Override
    public List<UserVO> resourcesToVOList(List<UserRequest> userRequests) {
        notNull(userRequests);

        final ArrayList<UserVO> usersVO = new ArrayList<>();
        userRequests.forEach(request -> usersVO.add(this.toVO(request)));
        return usersVO;
    }

    @Override
    public List<UserVO> ormsToVOList(List<User> users) {
        notNull(users);

        final ArrayList<UserVO> usersVO = new ArrayList<>();
        users.forEach(user -> usersVO.add(this.toVO(user)));
        return usersVO;
    }
}

package br.com.moving.teste.security.service;

import br.com.moving.teste.commons.CRUDService;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.vo.UserVO;

import java.util.Optional;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
public interface UserService extends CRUDService<UserVO> {

    /**
     * Atualiza senha do usuário
     * @param id id do usuário
     * @param vo VO com a nova senha
     * @return
     */
    UserVO updatePassword(Long id, UserVO vo);

    /**
     * Acha um usuário pelo email
     * @param email email do usuário
     * @return Usuário com o email passado
     */
    Optional<User> findUserByEmail(String email);

    /**
     * Acha um usuário pelo token
     * @param resetToken token gerado para resetar senha
     * @return Usuário com token passado
     */
    Optional<User> findUserByResetToken(String resetToken);

    /**
     * Envia email para resetar senha
     * @param vo VO com o email da conta
     * @param appUrl Endpoint do email
     */
    void sendForgotPasswordEmail(UserVO vo, String appUrl);
}

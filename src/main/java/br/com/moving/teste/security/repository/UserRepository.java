package br.com.moving.teste.security.repository;

import br.com.moving.teste.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Acha um usuário pelo email
     * @param email email do usuário
     * @return Usuário com email passado
     */
    Optional<User> findOneByEmail(String email);

    /**
     * Acha um usuário pelo token
     * @param resetToken token gerado para resetar senha
     * @return Usuário com token passado
     */
    Optional<User> findByResetToken(String resetToken);
}

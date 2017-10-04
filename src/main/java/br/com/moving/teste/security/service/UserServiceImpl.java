package br.com.moving.teste.security.service;

import br.com.moving.teste.commons.EmailService;
import br.com.moving.teste.security.assemblers.UserORMAssembler;
import br.com.moving.teste.security.assemblers.UserVOAssembler;
import br.com.moving.teste.security.exceptions.EmailExistsException;
import br.com.moving.teste.security.exceptions.InvalidPasswordException;
import br.com.moving.teste.security.exceptions.UserIdNotAllowedException;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.repository.UserRepository;
import br.com.moving.teste.security.vo.UserVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);


    private final @NonNull
    UserRepository userRepository;

    private final @NonNull
    UserVOAssembler userVOAssembler;
    private final @NonNull
    UserORMAssembler userORMAssembler;

    private final @NotNull
    EmailService emailService;

    @Override
    @Transactional
    public UserVO save(UserVO vo) {

        if (emailExists(vo.getEmail()))
            throw new EmailExistsException(vo.getEmail());

        return userVOAssembler.toVO(userRepository.save(userORMAssembler.toORM(vo)));
    }

    @Override
    @Transactional
    public UserVO updatePassword(Long id, UserVO vo, String logged) {

        final User user = Optional.ofNullable(userRepository.findOne(id))
                .orElseThrow(() -> new UsernameNotFoundException(String.valueOf(id)));

        if (!user.getEmail().equals(
                logged))
            throw new UserIdNotAllowedException(user.getEmail(), logged);

        if (vo.getPassword() == null || vo.getPassword().isEmpty())
            throw new InvalidPasswordException(vo.getPassword());

        user.setPassword(vo.getPassword());
        user.setResetToken(null);
        return userVOAssembler.toVO(userRepository.save(user));
    }

    private boolean emailExists(String email) {
        return userRepository.findOneByEmail(email).isPresent();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Optional<User> findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    @Transactional
    public void sendForgotPasswordEmail(UserVO vo, String appUrl) {
        final User user = this.findUserByEmail(vo.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(vo.getEmail()));

        user.setResetToken(UUID.randomUUID().toString());
        userRepository.save(user);

        SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
        passwordResetEmail.setFrom("moving@demo.com");
        passwordResetEmail.setTo(user.getEmail());
        passwordResetEmail.setSubject("Pedido de reset da senha");
        passwordResetEmail.setText("Clique no link abaixo para resetar sua senha:\n" + appUrl
                + "/reset?token=" + user.getResetToken());

        emailService.sendEmail(passwordResetEmail);
    }

    @Override
    public UserVO getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Page<UserVO> getAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional
    public UserVO update(Long id, UserVO vo) {
        throw new UnsupportedOperationException();
    }
}

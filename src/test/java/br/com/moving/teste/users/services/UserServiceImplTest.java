package br.com.moving.teste.users.services;

import br.com.moving.teste.commons.EmailService;
import br.com.moving.teste.commons.test.support.TestFixtureSupport;
import br.com.moving.teste.imoveis.services.ImobiliariaRepository;
import br.com.moving.teste.security.assemblers.UserORMAssembler;
import br.com.moving.teste.security.assemblers.UserVOAssembler;
import br.com.moving.teste.security.exceptions.EmailExistsException;
import br.com.moving.teste.security.exceptions.InvalidPasswordException;
import br.com.moving.teste.security.exceptions.UserIdNotAllowedException;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.repository.UserRepository;
import br.com.moving.teste.security.service.UserServiceImpl;
import br.com.moving.teste.security.vo.UserVO;
import br.com.moving.teste.template.loader.security.UserLoader;
import br.com.moving.teste.template.loader.security.UserVOLoader;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.Mockito.when;

/**
 * Created by ifc.vinicius.saraiva on 03/10/17.
 */
public class UserServiceImplTest extends TestFixtureSupport {

    private static final Long IMOBILIARIA_ID = 999L;
    @Mock
    UserRepository repository;

    @Mock
    UserORMAssembler ormAssembler;

    @Mock
    private UserVOAssembler voAssembler;

    @Mock
    private EmailService emailService;

    private UserServiceImpl service;

    private User user;
    private UserVO voWithAnotherEmail;
    private UserVO userVO;

    @Override
    public void setUp() throws Exception {
        service = new UserServiceImpl(repository, voAssembler, ormAssembler, emailService);
        userVO = Fixture.from(UserVO.class).gimme(UserVOLoader.VALID);
        user = Fixture.from(User.class).gimme(UserLoader.VALID);
        voWithAnotherEmail = Fixture.from(UserVO.class).gimme(UserVOLoader.ANOTHER_EMAIL);
    }

    @Test(expected = EmailExistsException.class)
    public void saveExistingEmail() {
        when(repository.findOneByEmail(userVO.getEmail())).thenReturn(Optional.of(user));

        service.save(userVO);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void updatePasswordOfANonExistentUser() {
        when(repository.findOne(userVO.getId())).thenReturn(null);

        service.updatePassword(userVO.getId(), userVO, userVO.getName());
    }

    @Test(expected = UserIdNotAllowedException.class)
    public void updatePasswordWithAnotherUser() {
        when(repository.findOne(user.getId())).thenReturn(user);

        service.updatePassword(voWithAnotherEmail.getId(), voWithAnotherEmail, voWithAnotherEmail.getEmail());
    }

    @Test(expected = InvalidPasswordException.class)
    public void updateInvalidPassword() {
        when(repository.findOne(user.getId())).thenReturn(user);
        userVO.setPassword("");
        service.updatePassword(user.getId(), userVO, user.getEmail());
    }


}
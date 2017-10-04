package br.com.moving.teste.security.service;

import br.com.moving.teste.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final @NotNull UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

package br.com.moving.teste.security.application;

import br.com.moving.teste.security.application.resources.UserRequest;
import br.com.moving.teste.security.application.resources.UserResponse;
import br.com.moving.teste.security.assemblers.UserResourceAssembler;
import br.com.moving.teste.security.assemblers.UserVOAssembler;
import br.com.moving.teste.security.exceptions.InvalidResetTokenException;
import br.com.moving.teste.security.models.User;
import br.com.moving.teste.security.service.UserService;
import br.com.moving.teste.security.vo.UserVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

/**
 * Created by ifc.vinicius.saraiva on 01/10/17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@ExposesResourceFor(UserVO.class)
public class UserController {

    private final static Logger logger = Logger.getLogger(UserController.class);

    private final @NonNull
    UserService userService;
    private final @NonNull
    UserVOAssembler userVOAssembler;
    private final @NonNull
    UserResourceAssembler userResourceAssembler;
    @Autowired
    private TokenStore tokenStore;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        final UserVO userSaved = userService.save(userVOAssembler.toVO(request));
        final UserResponse resource = userResourceAssembler.toResource(userSaved);
        logger.info("Created::" + userSaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(value = "/{id}/password", method = RequestMethod.PATCH)
    public ResponseEntity<UserResponse> updatePassword(@PathVariable Long id, @RequestBody UserRequest request) {
        request.setPassword(request.getNewPassword());
        final UserVO vo = userService.updatePassword(id, userVOAssembler.toVO(request));
        final UserResponse response = userResourceAssembler.toResource(vo);
        logger.info("Password updated::" + vo);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/{id}/logout", method = RequestMethod.DELETE)
    public ResponseEntity<Void> revokeToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}/password/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgotPassword(@PathVariable Long id, @RequestBody UserRequest userRequest, HttpServletRequest request) {

        String appUrl = request.getScheme() + "://" + request.getServerName();
        userService.sendForgotPasswordEmail(userVOAssembler.toVO(userRequest), appUrl);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}/password/reset", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> resetPassword(@PathVariable Long id, @RequestBody UserRequest request) {

        final User user = userService.findUserByResetToken(request.getResetToken())
                .orElseThrow(() -> new InvalidResetTokenException(request.getResetToken()));

        request.setPassword(request.getNewPassword());
        final UserVO vo = userService.updatePassword(id, userVOAssembler.toVO(request));

        final UserResponse response = userResourceAssembler.toResource(vo);
        logger.info("Password updated::" + vo);
        return ResponseEntity.ok(response);
    }

}
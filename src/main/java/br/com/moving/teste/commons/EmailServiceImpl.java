package br.com.moving.teste.commons;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * Created by ifc.vinicius.saraiva on 02/10/17.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
public class EmailServiceImpl implements EmailService {

    private final @NotNull JavaMailSender javaMailSender;

    @Async
    @Override
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }
}

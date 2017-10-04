package br.com.moving.teste.commons;

import org.springframework.mail.MailException;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by ifc.vinicius.saraiva on 02/10/17.
 */
public class MockMailSender extends JavaMailSenderImpl {

    @Override
    public void send(final SimpleMailMessage simpleMailMessage) throws MailException {
        final MimeMessage mimeMessage = createMimeMessage();
        try {
            final MimeMailMessage mimeMailMessage = new MimeMailMessage(createMimeMessage());
            simpleMailMessage.copyTo(mimeMailMessage);
            System.out.println(simpleMailMessage.toString());
        } catch (final Exception e) {
            throw new MailPreparationException(e);
        }
    }
}
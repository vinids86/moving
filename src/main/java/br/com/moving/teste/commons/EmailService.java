package br.com.moving.teste.commons;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by ifc.vinicius.saraiva on 02/10/17.
 */
public interface EmailService {
    /**
     * Envia email
     * @param email email a ser enviado
     */
    void sendEmail(SimpleMailMessage email);
}

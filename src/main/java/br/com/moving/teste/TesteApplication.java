package br.com.moving.teste;

import br.com.moving.teste.commons.MockMailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class TesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteApplication.class, args);
    }

    @Bean
    public JavaMailSender javaMailSender() {
        return new MockMailSender();
    }
}

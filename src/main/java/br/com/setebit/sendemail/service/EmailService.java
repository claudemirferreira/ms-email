package br.com.setebit.sendemail.service;

import br.com.setebit.sendemail.request.EmailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public boolean sendSimpleMessage(
            EmailRequest emailRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailRequest.getTo());
            message.setTo(emailRequest.getTo());
            message.setSubject(emailRequest.getSubject());
            message.setText(emailRequest.getMessage());
            emailSender.send(message);
        } catch ( MailException e) {
            log.error("erro ao tetar enviar email {}", e.getMessage());
            return false;
        }
        return true;
    }

}

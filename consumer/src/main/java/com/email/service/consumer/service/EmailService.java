package com.email.service.consumer.service;

import com.email.service.consumer.model.EmailModel;
import com.email.service.consumer.model.enums.StatusEmail;
import com.email.service.consumer.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
            System.out.println("Email enviado para " + emailModel.getEmailTo() + " com sucesso!");
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
            System.out.println("Erro ao enviar email para " + emailModel.getEmailTo());
        } finally {
            return emailRepository.save(emailModel);
        }
    }
}

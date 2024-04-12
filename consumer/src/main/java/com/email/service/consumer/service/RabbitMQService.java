package com.email.service.consumer.service;

import com.email.service.consumer.model.EmailModel;
import com.email.service.consumer.model.dto.EnviarEmailRequestDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "enviar-email")
    public void receberMensagem(EnviarEmailRequestDTO enviarEmailRequestDTO) {

        EmailModel emailModel = new EmailModel();

        BeanUtils.copyProperties(enviarEmailRequestDTO, emailModel);
        emailService.sendEmail(emailModel);
    }
}

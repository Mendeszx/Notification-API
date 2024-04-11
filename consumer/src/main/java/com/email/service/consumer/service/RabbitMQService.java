package com.email.service.consumer.service;

import com.email.service.consumer.model.dto.EnviarEmailRequestDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @RabbitListener(queues = "enviar-email")
    public void receberMensagem(EnviarEmailRequestDTO enviarEmailRequestDTO){

        if (enviarEmailRequestDTO.getEmail().contains("@email.com")){
            throw new RuntimeException("Email nao pode ser @email.com");
        }
        System.out.println("Recebi mensagem " + enviarEmailRequestDTO.getEmail());
    }
}

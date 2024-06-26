package com.email.service.producer.service.impl;

import com.email.service.producer.model.enumeration.Queues;
import com.email.service.producer.model.dto.EnviarEmailRequestDTO;
import com.email.service.producer.service.RabbitMQService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean enviarEmail(EnviarEmailRequestDTO enviarEmailRequestDTO) {

        try {
            rabbitTemplate.convertAndSend("email.exchange", "", enviarEmailRequestDTO);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}

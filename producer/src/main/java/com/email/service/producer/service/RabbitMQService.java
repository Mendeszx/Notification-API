package com.email.service.producer.service;

import com.email.service.producer.model.dto.EnviarEmailRequestDTO;

public interface RabbitMQService {
    boolean enviarEmail(EnviarEmailRequestDTO enviarEmailRequestDTO);
}

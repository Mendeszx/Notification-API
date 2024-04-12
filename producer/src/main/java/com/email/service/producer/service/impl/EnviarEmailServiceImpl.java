package com.email.service.producer.service.impl;

import com.email.service.producer.model.dto.EnviarEmailRequestDTO;
import com.email.service.producer.model.dto.EnviarEmailResponseDTO;
import com.email.service.producer.service.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailServiceImpl implements EnviarEmailService {

    @Autowired
    private RabbitMQServiceImpl rabbitMQService;

    @Override
    public ResponseEntity<EnviarEmailResponseDTO> enviarEmail(EnviarEmailRequestDTO enviarEmailRequestDTO) {
        EnviarEmailResponseDTO enviarEmailResponseDTO = new EnviarEmailResponseDTO();

        if (rabbitMQService.enviarEmail(enviarEmailRequestDTO)){
            enviarEmailResponseDTO.setMensagem("Email enviado para fila com sucesso!");
            return ResponseEntity.ok().body(enviarEmailResponseDTO);
        }

        enviarEmailResponseDTO.setMensagem("Falha ao enviar email para fila!");
        return ResponseEntity.internalServerError().body(enviarEmailResponseDTO);
    }
}

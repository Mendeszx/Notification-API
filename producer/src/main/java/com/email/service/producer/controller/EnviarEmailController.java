package com.email.service.producer.controller;

import com.email.service.producer.model.dto.EnviarEmailRequestDTO;
import com.email.service.producer.model.dto.EnviarEmailResponseDTO;
import com.email.service.producer.service.impl.RabbitMQServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EnviarEmailController {

    @Autowired
    private RabbitMQServiceImpl rabbitMQService;

    @PostMapping("/enviar")
    public ResponseEntity<EnviarEmailResponseDTO> enviarEmail(@RequestBody @Valid EnviarEmailRequestDTO enviarEmailRequestDTO) {
        EnviarEmailResponseDTO enviarEmailResponseDTO = new EnviarEmailResponseDTO();

        if (rabbitMQService.enviarEmail(enviarEmailRequestDTO)){
            enviarEmailResponseDTO.setMensagem("Email enviado para fila com sucesso!");
            return ResponseEntity.ok().body(enviarEmailResponseDTO);
        }

        enviarEmailResponseDTO.setMensagem("Falha ao enviar email para fila!");
        return ResponseEntity.internalServerError().body(enviarEmailResponseDTO);
    }
}

package com.email.service.producer.controller;

import com.email.service.producer.model.dto.EnviarEmailRequestDTO;
import com.email.service.producer.model.dto.EnviarEmailResponseDTO;
import com.email.service.producer.service.EnviarEmailService;
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
    private EnviarEmailService enviarEmailService;

    @PostMapping("/enviar")
    public ResponseEntity<EnviarEmailResponseDTO> enviarEmail(@RequestBody @Valid EnviarEmailRequestDTO enviarEmailRequestDTO) {
        return enviarEmailService.enviarEmail(enviarEmailRequestDTO);
    }
}

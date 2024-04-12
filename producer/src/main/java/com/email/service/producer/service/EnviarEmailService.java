package com.email.service.producer.service;

import com.email.service.producer.model.dto.EnviarEmailRequestDTO;
import com.email.service.producer.model.dto.EnviarEmailResponseDTO;
import org.springframework.http.ResponseEntity;

public interface EnviarEmailService {

    public ResponseEntity<EnviarEmailResponseDTO> enviarEmail (EnviarEmailRequestDTO enviarEmailRequestDTO);
}

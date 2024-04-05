package com.email.service.producer.service;

import com.email.service.producer.model.EmailReciver;
import com.email.service.producer.model.dto.EmailReciverRequestDTO;
import com.email.service.producer.model.dto.EmailReciverResponseDTO;
import org.springframework.http.ResponseEntity;

public interface EmailReciverService {
    EmailReciver saveEmailReciver(EmailReciverRequestDTO emailReciverRequestDTO);

    EmailReciver findEmailReciver(Long id);
}

package com.email.service.producer.service;

import com.email.service.producer.model.dto.EmailProducerRequestDTO;
import com.email.service.producer.model.dto.EmailProducerResponseDTO;
import com.email.service.producer.model.dto.EmailReciverRequestDTO;
import com.email.service.producer.model.dto.EmailReciverResponseDTO;
import org.springframework.http.ResponseEntity;

public interface CadastroEmailService {

    ResponseEntity<EmailProducerResponseDTO> consultarEmailProducer(Long id);

    ResponseEntity<EmailReciverResponseDTO> consultarEmailReciver(Long id);

    ResponseEntity<EmailProducerResponseDTO> cadastrarEmailProducer(EmailProducerRequestDTO emailProducerRequestDTO);

    ResponseEntity<EmailReciverResponseDTO> cadastrarEmailReciver(EmailReciverRequestDTO emailReciverRequestDTO);
}

package com.email.service.producer.service.impl;

import com.email.service.producer.model.EmailProducer;
import com.email.service.producer.model.EmailReciver;
import com.email.service.producer.model.dto.EmailProducerRequestDTO;
import com.email.service.producer.model.dto.EmailProducerResponseDTO;
import com.email.service.producer.model.dto.EmailReciverRequestDTO;
import com.email.service.producer.model.dto.EmailReciverResponseDTO;
import com.email.service.producer.service.CadastroEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class CadastroEmailServiceImpl implements CadastroEmailService {

    @Autowired
    private EmailProducerServiceImpl emailProducerService;

    @Autowired
    private EmailReciverServiceImpl emailReciverService;

    @Override
    public ResponseEntity<EmailProducerResponseDTO> consultarEmailProducer(Long id) {
        EmailProducer emailProducer = emailProducerService.findEmailProducer(id);
        EmailProducerResponseDTO emailProducerResponseDTO = new EmailProducerResponseDTO(emailProducer);

        return ResponseEntity.ok().body(emailProducerResponseDTO);
    }

    @Override
    public ResponseEntity<EmailReciverResponseDTO> consultarEmailReciver(Long id) {
        EmailReciver emailReciver = emailReciverService.findEmailReciver(id);
        EmailReciverResponseDTO emailReciverResponseDTO = new EmailReciverResponseDTO(emailReciver);

        return ResponseEntity.ok().body(emailReciverResponseDTO);
    }

    @Override
    public ResponseEntity<EmailProducerResponseDTO> cadastrarEmailProducer(EmailProducerRequestDTO emailProducerRequestDTO) {
        EmailProducer emailProducer = emailProducerService.saveEmailProducer(emailProducerRequestDTO);
        EmailProducerResponseDTO emailProducerResponseDTO = new EmailProducerResponseDTO(emailProducer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/producer/{id}")
                .buildAndExpand(emailProducer.getId())
                .toUri();

        return ResponseEntity.created(location).body(emailProducerResponseDTO);
    }

    @Override
    public ResponseEntity<EmailReciverResponseDTO> cadastrarEmailReciver(EmailReciverRequestDTO emailReciverRequestDTO) {
        EmailReciver emailReciver = emailReciverService.saveEmailReciver(emailReciverRequestDTO);
        EmailReciverResponseDTO emailReciverResponseDTO = new EmailReciverResponseDTO(emailReciver);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/reciver/{id}")
                .buildAndExpand(emailReciver.getId())
                .toUri();

        return ResponseEntity.created(location).body(emailReciverResponseDTO);
    }
}

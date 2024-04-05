package com.email.service.producer.controller;

import com.email.service.producer.model.dto.EmailProducerRequestDTO;
import com.email.service.producer.model.dto.EmailProducerResponseDTO;
import com.email.service.producer.model.dto.EmailReciverRequestDTO;
import com.email.service.producer.model.dto.EmailReciverResponseDTO;
import com.email.service.producer.service.impl.CadastroEmailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastroEmailController {

    @Autowired
    private CadastroEmailServiceImpl cadastroEmailService;

    @GetMapping("/producer/{id}")
    public ResponseEntity<EmailProducerResponseDTO> consultarEmailProducer(@PathVariable Long id) {
        return cadastroEmailService.consultarEmailProducer(id);
    }

    @GetMapping("/reciver/{id}")
    public ResponseEntity<EmailReciverResponseDTO> consultarEmailReciver(@PathVariable Long id) {
        return cadastroEmailService.consultarEmailReciver(id);
    }

    @PostMapping("/email-producer")
    public ResponseEntity<EmailProducerResponseDTO> cadastrarEmailProducer(@RequestBody @Valid EmailProducerRequestDTO emailProducerRequestDTO) {
        return cadastroEmailService.cadastrarEmailProducer(emailProducerRequestDTO);
    }

    @PostMapping("/email-reciver")
    public ResponseEntity<EmailReciverResponseDTO> cadastrarEmailReciver(@RequestBody @Valid EmailReciverRequestDTO emailReciverRequestDTO) {
        return cadastroEmailService.cadastrarEmailReciver(emailReciverRequestDTO);
    }
}

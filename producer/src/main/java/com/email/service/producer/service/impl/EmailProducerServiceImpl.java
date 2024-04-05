package com.email.service.producer.service.impl;

import com.email.service.producer.model.EmailProducer;
import com.email.service.producer.model.dto.EmailProducerRequestDTO;
import com.email.service.producer.repository.EmailProducerRepository;
import com.email.service.producer.service.EmailProducerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailProducerServiceImpl implements EmailProducerService {

    @Autowired
    private EmailProducerRepository emailProducerRepository;

    @Override
    public EmailProducer saveEmailProducer(EmailProducerRequestDTO emailProducerRequestDTO) {
        EmailProducer emailProducer = new EmailProducer();
        BeanUtils.copyProperties(emailProducerRequestDTO, emailProducer);
        return emailProducerRepository.save(emailProducer);
    }

    @Override
    public EmailProducer findEmailProducer(Long id) {
        Optional<EmailProducer> emailProducer = emailProducerRepository.findById(id);

        if (emailProducer.isPresent()) {
            return emailProducer.get();
        }

        throw new RuntimeException("Email não cadastrado!");
    }
}

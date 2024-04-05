package com.email.service.producer.service.impl;

import com.email.service.producer.model.EmailReciver;
import com.email.service.producer.model.dto.EmailReciverRequestDTO;
import com.email.service.producer.repository.EmailReciverRepository;
import com.email.service.producer.service.EmailReciverService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailReciverServiceImpl implements EmailReciverService {

    @Autowired
    private EmailReciverRepository emailReciverRepository;

    @Override
    public EmailReciver saveEmailReciver(EmailReciverRequestDTO emailReciverRequestDTO) {
        EmailReciver emailReciver = new EmailReciver();
        BeanUtils.copyProperties(emailReciverRequestDTO, emailReciver);
        return emailReciverRepository.save(emailReciver);
    }

    @Override
    public EmailReciver findEmailReciver(Long id) {
        Optional<EmailReciver> emailReciver = emailReciverRepository.findById(id);

        if (emailReciver.isPresent()) {
            return emailReciver.get();
        }

        throw new RuntimeException("Email não cadastrado!");
    }
}

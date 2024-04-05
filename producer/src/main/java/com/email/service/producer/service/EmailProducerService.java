package com.email.service.producer.service;

import com.email.service.producer.model.EmailProducer;
import com.email.service.producer.model.dto.EmailProducerRequestDTO;

public interface EmailProducerService {

    EmailProducer saveEmailProducer(EmailProducerRequestDTO emailProducerRequestDTO);

    EmailProducer findEmailProducer(Long id);
}

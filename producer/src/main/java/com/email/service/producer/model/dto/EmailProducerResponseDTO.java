package com.email.service.producer.model.dto;

import com.email.service.producer.model.EmailProducer;
import com.email.service.producer.model.EmailReciver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailProducerResponseDTO {

    private Long id;
    private String email;

    public EmailProducerResponseDTO(EmailProducer emailProducer) {
        this.setId(emailProducer.getId());
        this.setEmail(emailProducer.getEmail());
    }
}

package com.email.service.producer.model.dto;

import com.email.service.producer.model.EmailReciver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailReciverResponseDTO {

    private Long id;
    private String email;

    public EmailReciverResponseDTO(EmailReciver emailReciver) {
        this.setId(emailReciver.getId());
        this.setEmail(emailReciver.getEmail());
    }
}

package com.email.service.producer.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailReciverRequestDTO {

    @Email
    @NotNull
    @NotBlank
    private String email;
}

package com.email.service.producer.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnviarEmailRequestDTO {

    @NotBlank
    @NotNull
    private String ownerRef;

    @NotBlank
    @NotNull
    @Email
    private String emailFrom;

    @NotBlank
    @NotNull
    @Email
    private String emailTo;

    @NotBlank
    @NotNull
    private String subject;

    @NotBlank
    @NotNull
    private String text;

    @NotBlank
    @NotNull
    private int quantity;
}

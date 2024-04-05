package com.email.service.producer.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnviarEmailRequestDTO {

    @NotBlank
    @NotNull
    private String email;
}

package com.email.service.consumer.model.dto;

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

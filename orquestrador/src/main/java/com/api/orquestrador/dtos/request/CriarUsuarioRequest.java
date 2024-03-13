package com.api.orquestrador.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class CriarUsuarioRequest {

    @Valid
    private String nome;

    @Valid
    @Email
    private String email;

    @Valid
    private String senha;
}

package com.api.orquestrador.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CadastroUsuarioRequest {

    @Valid
    private String nome;

    @Valid
    @Email
    private String email;

    @Valid
    private String senha;
}

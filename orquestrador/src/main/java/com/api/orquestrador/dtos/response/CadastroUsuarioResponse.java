package com.api.orquestrador.dtos.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
public class CadastroUsuarioResponse {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String mensagem;
}

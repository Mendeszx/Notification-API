package com.api.orquestrador.dtos.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CiarUsuarioResponse {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String mensagem;
}

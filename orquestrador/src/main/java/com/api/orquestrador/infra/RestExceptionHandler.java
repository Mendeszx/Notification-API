package com.api.orquestrador.infra;

import com.api.orquestrador.dtos.response.CadastroUsuarioResponse;
import com.api.orquestrador.exceptions.EmailCadastradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailCadastradoException.class)
    private ResponseEntity<CadastroUsuarioResponse> emailCadastradoException(EmailCadastradoException emailCadastradoException){
        var cadastroUsuarioResponse = new CadastroUsuarioResponse();

        cadastroUsuarioResponse.setMensagem(emailCadastradoException.getMessage());
        cadastroUsuarioResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        cadastroUsuarioResponse.setHttpStatusCode(400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cadastroUsuarioResponse);
    }
}

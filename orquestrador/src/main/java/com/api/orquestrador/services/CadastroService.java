package com.api.orquestrador.services;

import com.api.orquestrador.dtos.request.CadastroUsuarioRequest;
import com.api.orquestrador.dtos.response.CadastroUsuarioResponse;
import com.api.orquestrador.entities.UsuariosEntity;
import com.api.orquestrador.producers.EmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private QueueService queueService;

    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        CadastroUsuarioResponse cadastroUsuarioResponse;

        String emailUsuariosEntity = usuariosService.cadastrarNovoUsuario(cadastroUsuarioRequest);
        queueService.criarEventoEmailCadastroNaFila(emailUsuariosEntity);
        cadastroUsuarioResponse = criarCadastroUsuarioResponse(201, HttpStatus.CREATED, "Usuário cadastrado com sucesso.");

        return ResponseEntity.status(cadastroUsuarioResponse.getHttpStatusCode()).body(cadastroUsuarioResponse);
    }

    private CadastroUsuarioResponse criarCadastroUsuarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroUsuarioResponse cadastroUsuarioResponse = new CadastroUsuarioResponse();

        cadastroUsuarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroUsuarioResponse.setHttpStatus(httpStatus);
        cadastroUsuarioResponse.setMensagem(mensagem);

        return cadastroUsuarioResponse;
    }
}

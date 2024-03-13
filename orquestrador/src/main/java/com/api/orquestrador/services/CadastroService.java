package com.api.orquestrador.services;

import com.api.orquestrador.dtos.request.CriarUsuarioRequest;
import com.api.orquestrador.dtos.response.CiarUsuarioResponse;
import com.api.orquestrador.dtos.response.DeletarUsuarioResponse;
import jakarta.transaction.Transactional;
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

    @Transactional
    public ResponseEntity<CiarUsuarioResponse> criarUsuario(CriarUsuarioRequest criarUsuarioRequest) {
        CiarUsuarioResponse ciarUsuarioResponse;

        String emailUsuariosEntity = usuariosService.criarUsuario(criarUsuarioRequest);
        queueService.criarEventoEmailCadastroNaFila(emailUsuariosEntity);
        ciarUsuarioResponse = criarCadastroUsuarioResponse(201, HttpStatus.CREATED, "Usuário cadastrado com sucesso.");

        return ResponseEntity.status(ciarUsuarioResponse.getHttpStatusCode()).body(ciarUsuarioResponse);
    }

    private CiarUsuarioResponse criarCadastroUsuarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CiarUsuarioResponse ciarUsuarioResponse = new CiarUsuarioResponse();

        ciarUsuarioResponse.setHttpStatusCode(httpStatusCode);
        ciarUsuarioResponse.setHttpStatus(httpStatus);
        ciarUsuarioResponse.setMensagem(mensagem);

        return ciarUsuarioResponse;
    }

    @Transactional
    public ResponseEntity<DeletarUsuarioResponse> deletarUsuario(long usuarioId) {
        DeletarUsuarioResponse deletarUsuarioResponse;

        String emailUsuariosEntity = usuariosService.deletarUsuario(usuarioId);
        queueService.criarEventoEmailExclusaoNaFila(emailUsuariosEntity);
        deletarUsuarioResponse = criarDeletarUsuarioResponse(200, HttpStatus.OK, "Usuário deletado com sucesso.");

        return ResponseEntity.status(deletarUsuarioResponse.getHttpStatusCode()).body(deletarUsuarioResponse);
    }

    private DeletarUsuarioResponse criarDeletarUsuarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        DeletarUsuarioResponse deletarUsuarioResponse = new DeletarUsuarioResponse();

        deletarUsuarioResponse.setHttpStatusCode(httpStatusCode);
        deletarUsuarioResponse.setHttpStatus(httpStatus);
        deletarUsuarioResponse.setMensagem(mensagem);

        return deletarUsuarioResponse;
    }
}

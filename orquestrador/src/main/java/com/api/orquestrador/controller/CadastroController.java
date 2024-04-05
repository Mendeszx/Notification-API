package com.api.orquestrador.controller;

import com.api.orquestrador.dtos.request.CriarUsuarioRequest;
import com.api.orquestrador.dtos.response.CiarUsuarioResponse;
import com.api.orquestrador.dtos.response.DeletarUsuarioResponse;
import com.api.orquestrador.services.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping("/criar-usuario")
    public ResponseEntity<CiarUsuarioResponse> criarUsuario(@RequestBody @Valid CriarUsuarioRequest criarUsuarioRequest) {
        return cadastroService.criarUsuario(criarUsuarioRequest);
    }

    @DeleteMapping("/deletar-usuario/{usuarioId}")
    public ResponseEntity<DeletarUsuarioResponse> deletarUsuario(@PathVariable long usuarioId) {
        return cadastroService.deletarUsuario(usuarioId);
    }
}

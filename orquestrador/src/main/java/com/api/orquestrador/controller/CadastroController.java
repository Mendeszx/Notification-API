package com.api.orquestrador.controller;

import com.api.orquestrador.dtos.request.CadastroUsuarioRequest;
import com.api.orquestrador.dtos.response.CadastroUsuarioResponse;
import com.api.orquestrador.services.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping("/usuario")
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(@RequestBody @Valid CadastroUsuarioRequest cadastroUsuarioRequest) {
        return cadastroService.cadastrarNovoUsuario(cadastroUsuarioRequest);
    }
}

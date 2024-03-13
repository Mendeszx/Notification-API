package com.api.orquestrador.services;

import com.api.orquestrador.dtos.request.CadastroUsuarioRequest;
import com.api.orquestrador.entities.UsuariosEntity;
import com.api.orquestrador.exceptions.EmailCadastradoException;
import com.api.orquestrador.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public Optional<UsuariosEntity> findByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Transactional
    public void cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {

        validarSeEmailExiste(cadastroUsuarioRequest.getEmail());

        UsuariosEntity usuariosEntity = new UsuariosEntity();
        BeanUtils.copyProperties(cadastroUsuarioRequest, usuariosEntity);

        Date dataDeCadastro = new Date();

        usuariosEntity.setDataDeCadastro(dataDeCadastro);

        usuariosRepository.save(usuariosEntity);
    }

    private void validarSeEmailExiste(String email) {
        Optional<UsuariosEntity> usuariosEntity = findByEmail(email);

        if (usuariosEntity.isPresent()) {
            throw new EmailCadastradoException("Email já cadastrado!");
        }
    }
}

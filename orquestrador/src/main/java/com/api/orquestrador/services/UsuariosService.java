package com.api.orquestrador.services;

import com.api.orquestrador.dtos.request.CriarUsuarioRequest;
import com.api.orquestrador.entities.UsuariosEntity;
import com.api.orquestrador.exceptions.EmailCadastradoException;
import com.api.orquestrador.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Transactional
    public String criarUsuario(CriarUsuarioRequest criarUsuarioRequest) {

        validarSeEmailExisteParaCadastrar(criarUsuarioRequest.getEmail());

        UsuariosEntity usuariosEntity = new UsuariosEntity();
        BeanUtils.copyProperties(criarUsuarioRequest, usuariosEntity);

        Date dataDeCadastro = new Date();

        usuariosEntity.setDataDeCadastro(dataDeCadastro);

        return usuariosRepository.save(usuariosEntity).getEmail();
    }

    private void validarSeEmailExisteParaCadastrar(String email) {
        Optional<UsuariosEntity> usuariosEntity = usuariosRepository.findByEmail(email);

        if (usuariosEntity.isPresent()) {
            throw new EmailCadastradoException("Email já cadastrado!");
        }
    }

    @Transactional
    public String deletarUsuario(long usuarioId) {

        UsuariosEntity usuariosEntity = validarSeUsuarioExisteParaDeletar(usuarioId);
        usuariosRepository.delete(usuariosEntity);
        return usuariosEntity.getEmail();
    }

    private UsuariosEntity validarSeUsuarioExisteParaDeletar(long id) {
        Optional<UsuariosEntity> usuariosEntity = usuariosRepository.findById(id);

        if (usuariosEntity.isEmpty()) {
            throw new EmailCadastradoException("Usuario não cadastrado!");
        }

        return usuariosEntity.get();
    }
}

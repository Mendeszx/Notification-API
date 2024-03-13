package com.api.orquestrador.services;

import com.api.orquestrador.dtos.queue.EmailDto;
import com.api.orquestrador.entities.UsuariosEntity;
import com.api.orquestrador.producers.EmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    @Autowired
    private EmailProducer emailProducer;

    public void criarEventoEmailCadastroNaFila(String emailUsuariosEntity) {
        emailProducer.criarEventoEmailCadastroNaFila(emailUsuariosEntity);
    }

    public void criarEventoEmailExclusaoNaFila(String emailUsuariosEntity) {
        emailProducer.criarEventoEmailExclusaoNaFila(emailUsuariosEntity);
    }
}

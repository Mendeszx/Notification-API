package com.api.orquestrador.producers;

import com.api.orquestrador.dtos.queue.EmailDto;
import com.api.orquestrador.entities.UsuariosEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void criarEventoEmailCadastroNaFila(String emailUsuariosEntity) {
        EmailDto emailDto = criarEmailDto(emailUsuariosEntity);

        rabbitTemplate.convertAndSend("", "email_cadastro", emailDto);
    }

    private EmailDto criarEmailDto(String emailUsuariosEntity) {
        var emailDto = new EmailDto();

        emailDto.setEmailTo(emailUsuariosEntity);
        emailDto.setTexto("Obrigado por se cadastrar no meu projeto!");
        emailDto.setTitulo("Cadastro efetuado com sucesso!");

        return emailDto;
    }
}

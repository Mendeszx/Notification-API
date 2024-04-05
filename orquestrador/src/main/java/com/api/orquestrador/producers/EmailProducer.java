package com.api.orquestrador.producers;

import com.api.orquestrador.dtos.queue.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void criarEventoEmailCadastroNaFila(String emailUsuariosEntity) {

        EmailDto emailDto = criarEmailDto(emailUsuariosEntity,
                "Obrigado por se cadastrar no meu projeto!",
                "Cadastro realizado com sucesso!");
        rabbitTemplate.convertAndSend("", "email_cadastro", emailDto);
    }

    private EmailDto criarEmailDto(String emailUsuariosEntity, String mensagem, String assunto) {
        var emailDto = new EmailDto();

        emailDto.setEmailTo(emailUsuariosEntity);
        emailDto.setMensagem(mensagem);
        emailDto.setAssunto(assunto);

        return emailDto;
    }

    public void criarEventoEmailExclusaoNaFila(String emailUsuariosEntity) {

        EmailDto emailDto = criarEmailDto(emailUsuariosEntity,
                "Foi bom enquanto durou, obrigado pela oportunidade!",
                "Exclusão realizada com sucesso!");
        rabbitTemplate.convertAndSend("", "email_exclusao", emailDto);
    }
}

package com.api.orquestrador.dtos.queue;

import lombok.Data;

@Data
public class EmailDto {
    private String emailTo;
    private String assunto;
    private String mensagem;
}

package com.api.orquestrador.dtos.queue;

import lombok.Data;

@Data
public class EmailDto {
    private String emailTo;
    private String titulo;
    private String texto;
}

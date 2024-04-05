package com.api.orquestrador.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "usuarios")
public class UsuariosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "senha")
    private String senha;
    @Column(nullable = false, name = "data_de_cadastro")
    private Date dataDeCadastro;
}

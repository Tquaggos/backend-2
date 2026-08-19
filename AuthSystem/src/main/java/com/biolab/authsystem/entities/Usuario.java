package com.biolab.authsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=6, max= 20, message = "Teste 1 2")
    private String senha;
    //Deixar a o campo unico
    @Email @Column(unique=true)
    private String email;
    @NotNull
    private String nome;
    private LocalDate dtCriacao;

    public Usuario() {
    }

    public Usuario(String senha, String email, String nome, LocalDate dtCriacao) {
        this.senha = senha;
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.dtCriacao = dtCriacao;
    }

    public Usuario(String senha, long id, String email, String nome, LocalDate dtCriacao) {
        this.senha = senha;
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.dtCriacao = dtCriacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
}



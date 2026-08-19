package com.biolab.authsystem.DTOs;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioRequest {
    @Size(min=6, max= 20, message = "Teste 1 2")
    private String senha;
    @Email
    private String email;
    @NotNull
    private String nome;
    private LocalDate dtCriacao;

    public UsuarioRequest(String senha, String email, String nome, LocalDate dtCriacao) {
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.dtCriacao = dtCriacao;
    }

    public UsuarioRequest( String nome, String senha) {

        this.nome = nome;
        this.senha = senha;
    }

    public UsuarioRequest(){}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

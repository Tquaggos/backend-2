package com.biolab.musicsystem.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioRequest {
    @NotNull
    private String nome;
    @Email
    //email por causa do email
    @Column(unique = true)
    //@Emal: Indica que o campo deve ter formato de e-mail válido
    //@Column:Faz com que o e-mail seja único no banco de dados
    private String email;
    @Size(min=6, max=20)
    //max e min de caracteres
    private String senha;
    private LocalDate dtCriacao;

    public UsuarioRequest(String nome, String email, String senha, LocalDate dtCriacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCriacao = dtCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
}

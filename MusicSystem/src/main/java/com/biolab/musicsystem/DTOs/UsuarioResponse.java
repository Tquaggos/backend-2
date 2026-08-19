package com.biolab.musicsystem.DTOs;

import java.time.LocalDate;

public class UsuarioResponse {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dtCriacao;

    public UsuarioResponse(long id, String nome, String email, String senha, LocalDate dtCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCriacao = dtCriacao;
    }

    public UsuarioResponse(){}

    public UsuarioResponse(long id, String nome, String email) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

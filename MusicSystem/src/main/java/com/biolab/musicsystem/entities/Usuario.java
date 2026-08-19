package com.biolab.musicsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nome;
    @Email @Column(unique = true)
    //@Emal: Indica que o campo deve ter formato de e-mail válido
    //@Column:Faz com que o e-mail seja único no banco de dados
    private String email;
    @Size(min=6, max=20)
    //Vai definir o minimo e o maximo de caracteres para digitar
    private String senha;
    private LocalDate dtCriacao;

    public Usuario(long id, String nome, String email, String senha, LocalDate dtCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCriacao = dtCriacao;
    }

    public Usuario(String nome, String email, String senha, LocalDate dtCriacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCriacao = dtCriacao;
    }

    public Usuario() {}

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

package com.biolab.musicsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Musica {
    //entidade musica, onde fica tudo sobre ela, nome, artista e etc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=0, max= 100, message = "Musica")
    //min e max de caracteres e tambem aparece uma mensagem se der tudo certo
    @NotNull
    private String nome;
    //O usuario vai conseguir pesquisar a musica de acordo com o nome dela
    private String artista;
    private LocalDate dtLancamento;

    public Musica(long id, String nome, String artista, LocalDate dtLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.dtLancamento = dtLancamento;
    }

    public Musica(String nome, String artista, LocalDate dtLancamento) {
        this.nome = nome;
        this.artista = artista;
        this.dtLancamento = dtLancamento;
    }

    public Musica() {}

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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public LocalDate getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(LocalDate dtLancamento) {
        this.dtLancamento = dtLancamento;
    }
}

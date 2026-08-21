package com.biolab.musicsystem.DTOs;

import com.biolab.musicsystem.entities.Musica;

import java.time.LocalDate;

public class MusicaDTO {
    //isso ira aparecer quando o usuario der o get
    private long id;
    private String nome;
    private String artista;
    private LocalDate dtLancamento;

    public MusicaDTO() {
    }

    public MusicaDTO(String nome, String artista, LocalDate dtLancamento) {
        this.nome = nome;
        this.artista = artista;
        this.dtLancamento = dtLancamento;
    }

    public MusicaDTO(long id, String nome, String artista, LocalDate dtLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.dtLancamento = dtLancamento;
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

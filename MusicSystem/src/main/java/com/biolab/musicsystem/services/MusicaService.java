package com.biolab.musicsystem.services;

import com.biolab.musicsystem.DTOs.MusicaDTO;
import com.biolab.musicsystem.entities.Musica;
import com.biolab.musicsystem.entities.Usuario;
import com.biolab.musicsystem.repositories.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
//responsavel por cadastrar cada mudança ou login, ou criação
public class MusicaService {
    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public MusicaDTO addMusica(MusicaDTO dto){
        Musica musica = new Musica();
        musica.setNome(dto.getNome());
        musica.setArtista(dto.getArtista());
        musica.setDtLancamento(dto.getDtLancamento());
        musicaRepository.save(musica);
        return dto;
        //vai adicionar a musica ao banco ou app
    }

    public List<MusicaDTO> mostrarMusica(){
        return musicaRepository.findAll().stream().map(musica -> new
                MusicaDTO(musica.getId(), musica.getNome(), musica.getArtista(),
                musica.getDtLancamento())).toList();
        //vai mostrar a musica no banco
    }

    public MusicaDTO buscarMusica(String nome){
        Musica musica = musicaRepository.findByNome(nome);
        MusicaDTO musicaDTO = new MusicaDTO();
        musicaDTO.setNome(musica.getNome());
        musicaDTO.setArtista(musica.getArtista());
        musicaDTO.setDtLancamento(musica.getDtLancamento());
        return musicaDTO;
//vai bsucar a musica
    }

    public String deletar(long id){
        Optional<Musica> musica = musicaRepository.findById(id);
        if (musica == null){
            return "Usuario não existe";
        }else {
            musicaRepository.deleteAllById(Collections.singleton(id));
            return "Usuario deletado";
        }
        //vai deletar a musica
    }

    public String alterarMusica(String nome, MusicaDTO dto){
        Musica alterarMusica = musicaRepository.findByNome(nome);
        alterarMusica.setNome(dto.getNome());
        musicaRepository.save(alterarMusica);
        return "Alterado com sucesso";
    }
    //vai alterar a musica
}

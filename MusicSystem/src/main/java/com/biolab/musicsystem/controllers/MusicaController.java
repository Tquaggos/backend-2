package com.biolab.musicsystem.controllers;

import com.biolab.musicsystem.DTOs.MusicaDTO;
import com.biolab.musicsystem.services.MusicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Musica")
public class MusicaController {
    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @PostMapping
    public ResponseEntity<?> adicionarMusica(@Validated @RequestBody MusicaDTO dto){
        return ResponseEntity.ok("Adicionado com sucesso" + musicaService.addMusica(dto));
    }

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> mostrar(){
        return ResponseEntity.ok(musicaService.mostrarMusica());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<MusicaDTO> buscarMusica(@PathVariable String nome){
        return ResponseEntity.ok(musicaService.buscarMusica(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagarId(@PathVariable Long id){
        return ResponseEntity.ok(musicaService.deletar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarMusica(@PathVariable Long id, @RequestBody MusicaDTO dto){
        return ResponseEntity.ok(musicaService.alterarMusica(String.valueOf(id), dto));
    }

}

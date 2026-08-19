package com.biolab.musicsystem.controllers;

import com.biolab.musicsystem.DTOs.UsuarioRequest;
import com.biolab.musicsystem.DTOs.UsuarioResponse;
import com.biolab.musicsystem.entities.Usuario;
import com.biolab.musicsystem.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@Validated @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok("Criado com sucesso" + usuarioService.criarUsuario(request));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> mostrar() {
        return ResponseEntity.ok(usuarioService.mostrarUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarID(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagarId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.deletar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest req){
        return ResponseEntity.ok(usuarioService.alterarUsuario(id, req));
    }
}

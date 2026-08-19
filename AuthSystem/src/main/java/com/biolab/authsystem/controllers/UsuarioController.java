package com.biolab.authsystem.controllers;

import com.biolab.authsystem.DTOs.UsuarioRequest;
import com.biolab.authsystem.DTOs.UsuarioResponse;
import com.biolab.authsystem.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@Validated @RequestBody UsuarioRequest req){
        return ResponseEntity.ok("Criado com sucesso" + usuarioService.criarUsuario(req));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> mostrar(){
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

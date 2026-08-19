package com.biolab.authsystem.services;

import com.biolab.authsystem.DTOs.UsuarioRequest;
import com.biolab.authsystem.DTOs.UsuarioResponse;
import com.biolab.authsystem.entities.Usuario;
import com.biolab.authsystem.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioRequest criarUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setDtCriacao(LocalDate.now());
        usuarioRepository.save(usuario);
        return request;
    }

    public List<UsuarioResponse> mostrarUsuario() {
        return usuarioRepository.findAll().stream().map(usuario -> new
                UsuarioResponse(usuario.getId(), usuario.getEmail(),
                usuario.getNome(), usuario.getDtCriacao())).toList();


    }

    public UsuarioResponse buscarID(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNome(usuario.get().getNome());
        usuarioResponse.setEmail(usuario.get().getEmail());
        usuarioResponse.setDtCriacao(usuario.get().getDtCriacao());
        usuarioResponse.setId(usuario.get().getId());
        return usuarioResponse;
    }

    public String deletar(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario == null) {
            return "Usuario não existe";
        } else {
            usuarioRepository.deleteById(id);
            return "Usuario quicado";
        }
    }

    public String alterarUsuario(Long id, UsuarioRequest req) {
        Usuario alterarUsuario = usuarioRepository.findById(id).orElseThrow();
        alterarUsuario.setNome(req.getNome());
        alterarUsuario.setSenha(req.getSenha());
        usuarioRepository.save(alterarUsuario);
        return "oko";

    }
}

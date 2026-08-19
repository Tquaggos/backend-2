package com.biolab.musicsystem.services;

import com.biolab.musicsystem.DTOs.UsuarioRequest;
import com.biolab.musicsystem.DTOs.UsuarioResponse;
import com.biolab.musicsystem.entities.Usuario;
import com.biolab.musicsystem.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioRequest criarUsuario(UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setDtCriacao(request.getDtCriacao());
        usuarioRepository.save(usuario);
        return request;
    }

    public List<UsuarioResponse> mostrarUsuario(){
        return usuarioRepository.findAll().stream().map(usuario -> new
                UsuarioResponse(usuario.getId(),
                usuario.getNome(), usuario.getEmail())).toList();
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
            return "Usuario deletado";
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

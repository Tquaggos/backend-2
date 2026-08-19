package com.biolab.authsystem.services;

import com.biolab.authsystem.DTOs.LoginDTO;
import com.biolab.authsystem.entities.Usuario;
import com.biolab.authsystem.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public String login(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuario == null) {
            return "Usuario não cadastrado";
        }
        if (usuario.getSenha().equals(loginDTO.getSenha())){
            return "Acesso liberado";
        }
        return "Senha ou e-mail incorretos";
    }
}

package br.com.senior.reclamomesmo.service;

import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import br.com.senior.reclamomesmo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Usuario register(String email, String senha, boolean isAdmin){
        var hashedPassword = encoder.encode(senha);
        var usuario = new Usuario(email, hashedPassword, isAdmin);
        usuarioRepository.save(usuario);

        return usuario;
    }
}

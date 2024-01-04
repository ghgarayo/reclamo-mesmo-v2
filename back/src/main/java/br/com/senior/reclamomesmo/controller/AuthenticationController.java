package br.com.senior.reclamomesmo.controller;

import br.com.senior.reclamomesmo.domain.pessoa.Pessoa;
import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import br.com.senior.reclamomesmo.dto.autenticacao.DTOAuthenticationRequest;
import br.com.senior.reclamomesmo.dto.autenticacao.DTOTokenJwt;
import br.com.senior.reclamomesmo.service.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> login(@RequestBody @Valid DTOAuthenticationRequest dto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = manager.authenticate(authenticationToken);
        var token = tokenService.generateToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok().body(new DTOTokenJwt(token));

    }


}

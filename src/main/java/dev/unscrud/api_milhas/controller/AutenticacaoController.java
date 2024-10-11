package dev.unscrud.api_milhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.usuario.DadosAutenticacao;
import dev.unscrud.api_milhas.domain.usuario.Usuario;
import dev.unscrud.api_milhas.infra.security.DadosTokenJWT;
import dev.unscrud.api_milhas.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAuth) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dadosAuth.email(), dadosAuth.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}

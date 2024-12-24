package dev.unscrud.api_milhas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.usuario.DadosAutenticacao;
import dev.unscrud.api_milhas.domain.usuario.DadosCadastro;
import dev.unscrud.api_milhas.domain.usuario.Usuario;
import dev.unscrud.api_milhas.domain.usuario.UsuarioServico;
import dev.unscrud.api_milhas.infra.security.DadosTokenJWT;
import dev.unscrud.api_milhas.infra.security.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    private AuthenticationManager manager;
    private TokenService tokenService;
    private UsuarioServico usuarioServico;

    public AutenticacaoController(
        AuthenticationManager manager,
        TokenService tokenService,
        UsuarioServico usuarioServico
    ){
        this.manager = manager;
        this.tokenService = tokenService;
        this.usuarioServico = usuarioServico;
    }

    @PostMapping("/login")
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAuth) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dadosAuth.email(), dadosAuth.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid DadosCadastro dadosCadastro) {
        usuarioServico.criarUsuario(dadosCadastro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/perfil")
    @SecurityRequirement(name = "bearer-key ")
    public ResponseEntity<DadosCadastro> buscarUsuario(){
        Usuario usuario = usuarioServico.getUsuarioLogado();
        DadosCadastro dadosCadastro = new DadosCadastro(usuario);
        return ResponseEntity.ok(dadosCadastro);
    }

    @PatchMapping("/perfil")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<DadosCadastro> editarUsusario(@RequestBody @Valid DadosCadastro dadosCadastro){
        return ResponseEntity.ok(
                usuarioServico
                        .editarUsuarioLogado(dadosCadastro)
        );
    }
}

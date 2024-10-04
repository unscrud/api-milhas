package dev.unscrud.api_milhas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.usuario.DadosAutenticacao;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @GetMapping("/login")
    public void efetuarLogin(@RequestBody DadosAutenticacao dadosAuth){
        System.out.println(dadosAuth.email() + " - " + dadosAuth.email());
    }
}

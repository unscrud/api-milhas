package dev.unscrud.api_milhas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.passagem.DadosBuscaPassagensDTO;

@RestController
@RequestMapping("/passagem")
public class PassagemController {

    @GetMapping("/search")
    public String buscarPassagens(@ModelAttribute DadosBuscaPassagensDTO dadosBusca) {
        return dadosBusca.toString();
    }
}

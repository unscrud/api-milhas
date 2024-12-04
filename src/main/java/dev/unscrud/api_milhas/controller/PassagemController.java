package dev.unscrud.api_milhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.unscrud.api_milhas.domain.passagem.DadosBuscaPassagensDTO;
import dev.unscrud.api_milhas.domain.passagem.Passagem;
import dev.unscrud.api_milhas.domain.passagem.PassagemServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/passagem")
public class PassagemController {

    @Autowired
    private PassagemServico passagemServico;

    @GetMapping("/search")
    public List<Passagem> buscarPassagens(@ModelAttribute @Valid DadosBuscaPassagensDTO dadosBusca) {
        return passagemServico.listarPorFiltro(dadosBusca);
    }
}

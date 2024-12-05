package dev.unscrud.api_milhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<Passagem> buscarPassagens(
        @ModelAttribute @Valid DadosBuscaPassagensDTO dadosBusca,
        @PageableDefault(size = 5) Pageable paginacao
    ) {
        Page<Passagem> passagens = passagemServico.listarPorFiltro(dadosBusca, paginacao);
        return passagens;
    }
}

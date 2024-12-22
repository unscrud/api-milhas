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
import dev.unscrud.api_milhas.domain.passagem.DadosPassagemResponseDTO;
import dev.unscrud.api_milhas.domain.passagem.PassagemServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/passagem")
public class PassagemController {

    @Autowired
    private PassagemServico passagemServico;

    @GetMapping("/search")
    public Page<DadosPassagemResponseDTO> buscarPassagens(
        @ModelAttribute @Valid DadosBuscaPassagensDTO dadosBusca,
        @PageableDefault(size = 5) Pageable paginacao
    ) {
        return passagemServico.listarPorFiltro(dadosBusca, paginacao);
    }
}

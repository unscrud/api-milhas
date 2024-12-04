package dev.unscrud.api_milhas.domain.passagem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class PassagemServico {

    @Autowired
    private PassagemRepository passagemRepository;

    public List<Passagem> listarPorFiltro(@Valid DadosBuscaPassagensDTO dadosBusca) {
        return passagemRepository.findAll();
    }

}

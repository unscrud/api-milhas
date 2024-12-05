package dev.unscrud.api_milhas.domain.passagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class PassagemServico {

    @Autowired
    private PassagemRepository passagemRepository;

    public Page<Passagem> listarPorFiltro(@Valid DadosBuscaPassagensDTO dadosBusca, Pageable pageable) {
        return passagemRepository.findAll(PassagemSpecifications.comJoinsEFiltro(dadosBusca), pageable);
    }

}

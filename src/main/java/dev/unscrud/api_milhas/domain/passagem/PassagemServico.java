package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class PassagemServico {

    @Autowired
    private PassagemRepository passagemRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public Page<DadosPassagemResponseDTO> listarPorFiltro(@Valid DadosBuscaPassagensDTO dadosBusca, Pageable pageable) {

      Page<Passagem> passagens = passagemRepository.findAll(PassagemSpecifications.comFiltro(dadosBusca), pageable);

      List<PassagemResponseDTO> passagensDTO = passagens.getContent().stream()
          .map( passagem -> {

            List<OrcamentoResponseDTO> orcamentos = new ArrayList<>(); // preencher

            PassagemResponseDTO passagemDTO = new PassagemResponseDTO(
              passagem.getTipoPassagem().getDescricao(),
              passagem.getPrecoIda(),
              passagem.getPrecoVolta(),
              passagem.getTaxaEmbarque(),
              Short.valueOf(passagem.getConexoes()),
              passagem.getTempoVoo(),
              passagem.getOrigem(),
              passagem.getDestino(),
              passagem.getCompanhia(),
              dadosBusca.dataIda() != null ? LocalDate.parse(dadosBusca.dataIda(), FORMATTER) : null,
              dadosBusca.dataVolta() != null ? LocalDate.parse(dadosBusca.dataVolta(), FORMATTER) : null,
              BigDecimal.ZERO,
              orcamentos
            );
            
            
            return passagemDTO;
          }).collect(Collectors.toList());

      
      PrecoDTO preco = passagemRepository.findPrecoIdaMinMax();
      
      DadosPassagemResponseDTO dados = new DadosPassagemResponseDTO(preco.minimo(), preco.maximo(), passagensDTO);

      Page<DadosPassagemResponseDTO> dadosPaginacao = new PageImpl<>(Collections.singletonList(dados), pageable, passagens.getTotalElements());
      
      return dadosPaginacao;
    }

}

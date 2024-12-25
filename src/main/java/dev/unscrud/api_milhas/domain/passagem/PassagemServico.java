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
            List<OrcamentoResponseDTO> orcamento = montarOrcamento(dadosBusca,passagem);

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
              calcularTotalOrcamento(orcamento),
              orcamento
            );

            return passagemDTO;
          }).collect(Collectors.toList());            

      PrecoDTO preco = passagemRepository.findPrecoIdaMinMax();

      DadosPassagemResponseDTO dados = new DadosPassagemResponseDTO(preco.minimo(), preco.maximo(), passagensDTO);

      Page<DadosPassagemResponseDTO> dadosPaginacao = new PageImpl<>(Collections.singletonList(dados), pageable, passagens.getTotalElements());

      return dadosPaginacao;
    }

  private BigDecimal calcularTotalOrcamento(List<OrcamentoResponseDTO> orcamento) {
    return orcamento.stream()
        .map(OrcamentoResponseDTO::total)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
            
  private List<OrcamentoResponseDTO> montarOrcamento(DadosBuscaPassagensDTO dadosBusca, Passagem passagem) {
    List<OrcamentoResponseDTO> orcamentos = new ArrayList<>();

    Boolean somenteIda = dadosBusca.somenteIda() == null || dadosBusca.dataVolta() == null 
        ? true 
        : dadosBusca.somenteIda();

    if (isNaoNuloMaiorQueZero(dadosBusca.passageirosAdultos())) {
      BigDecimal ida = passagem.getPrecoIda()
          .multiply( BigDecimal.valueOf(dadosBusca.passageirosAdultos()));

      BigDecimal volta = somenteIda 
          ? BigDecimal.ZERO 
          : passagem.getPrecoVolta()
              .multiply( BigDecimal.valueOf(dadosBusca.passageirosAdultos()));

      BigDecimal preco = ida.add(volta);
      BigDecimal precoComTaxa = preco.add(passagem.getTaxaEmbarque());

      OrcamentoResponseDTO orcamentoAdulto = new OrcamentoResponseDTO(
      montaDescricaoOrcamento(dadosBusca.passageirosAdultos(), "adulto", passagem.getTipoPassagem()),
      preco,
      passagem.getTaxaEmbarque(),
      precoComTaxa);

      orcamentos.add(orcamentoAdulto);
    }

    if (isNaoNuloMaiorQueZero(dadosBusca.passageirosCriancas())) {
      BigDecimal ida = passagem.getPrecoIda()
          .multiply( BigDecimal.valueOf(dadosBusca.passageirosCriancas()));
      BigDecimal volta = somenteIda 
          ? BigDecimal.ZERO 
          : passagem.getPrecoVolta()
              .multiply( BigDecimal.valueOf(dadosBusca.passageirosCriancas()));
      BigDecimal preco = ida.add(volta);
      BigDecimal precoComTaxa = preco.add(passagem.getTaxaEmbarque());

      OrcamentoResponseDTO orcamentoCrianca = new OrcamentoResponseDTO(
      montaDescricaoOrcamento(dadosBusca.passageirosCriancas(), "criança", passagem.getTipoPassagem()),
      preco,
      passagem.getTaxaEmbarque(),
      precoComTaxa);

      orcamentos.add(orcamentoCrianca);
    }

    if (isNaoNuloMaiorQueZero(dadosBusca.passageirosBebes())) {
      BigDecimal ida = passagem.getPrecoIda()
          .multiply( BigDecimal.valueOf(dadosBusca.passageirosBebes()));
      BigDecimal volta = somenteIda
          ? BigDecimal.ZERO 
          : passagem.getPrecoVolta()
              .multiply( BigDecimal.valueOf(dadosBusca.passageirosBebes()));
      BigDecimal preco = ida.add(volta);
      BigDecimal precoComTaxa = preco.add(passagem.getTaxaEmbarque());

      OrcamentoResponseDTO orcamentoBebe = new OrcamentoResponseDTO(
      montaDescricaoOrcamento(dadosBusca.passageirosBebes(), "bebê", passagem.getTipoPassagem()),
      preco,
      passagem.getTaxaEmbarque(),
      precoComTaxa);

      orcamentos.add(orcamentoBebe);
    }
    
    return orcamentos;
  }

  private boolean isNaoNuloMaiorQueZero(Short valor) {
    return valor != null && valor > 0;
  }

  private String montaDescricaoOrcamento(Short quantidade, String tipoDePassageiro, TipoPassagem tipoPassagem) {
    return String.valueOf(quantidade) + " " 
    + tipoDePassageiro 
    + (quantidade > 1 ? "s": "") + ", "
    + tipoPassagem.getDescricao().toLowerCase();
  }

}

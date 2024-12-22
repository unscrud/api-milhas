package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import dev.unscrud.api_milhas.domain.companhia.Companhia;
import dev.unscrud.api_milhas.domain.estado.Estado;

public record PassagemResponseDTO(
    String tipo,
    BigDecimal precoIda,
    BigDecimal precoVolta,
    BigDecimal taxaEmbarque,
    Short conexoes,
    Short tempoVoo,
    Estado origem,
    Estado destino,
    Companhia companhia,
    LocalDate dataIda,
    LocalDate dataVolta,
    BigDecimal total,
    List<OrcamentoResponseDTO> orcamento
){}

package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;

public record OrcamentoResponseDTO(
    String descricao,
    BigDecimal preco,
    BigDecimal taxaEmbarque,
    BigDecimal total
){}

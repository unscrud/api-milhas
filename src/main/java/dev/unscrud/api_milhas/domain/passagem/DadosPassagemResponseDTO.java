package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;
import java.util.List;

public record DadosPassagemResponseDTO(
    BigDecimal precoMin,
    BigDecimal precoMax,
    List<PassagemResponseDTO> resultado
){}

package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;

public record PrecoDTO (
    BigDecimal minimo,
    BigDecimal maximo
) {}

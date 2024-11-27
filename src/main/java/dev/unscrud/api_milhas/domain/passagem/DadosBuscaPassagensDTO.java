package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosBuscaPassagensDTO(

    @Schema(description = "Buscar somente ida?", defaultValue = "false")
    Boolean somenteIda,

    @Schema(description = "Quantidade de passageiros adultos", defaultValue = "1")
    @Min(0)
    short passageirosAdultos,

    @Schema(description = "Quantidade de passageiros crianças", defaultValue = "0")
    @Min(0)
    short passageirosCriancas,

    @Schema(description = "Quantidade de passageiros bebês", defaultValue = "0")
    @Min(0)
    short passageirosBebes,

    @Schema(description = "Tipo da passagem", allowableValues = {"Executiva", "Econômica"})
    String tipo,

    @Schema(description = "Turno para realizar o voo", allowableValues = {"Manhã", "Tarde", "Noite"})
    byte turno,

    @Schema(description = "Id do estado de onde o passageiro vai sair")
    byte origemId,

    @Schema(description = "Id do estado onde o passageiro vai chegar")
    byte destinoId,

    @Schema(description = "Filtrar por companhias (ids separados por vírgula)")
    String companhiasId,

    @Schema(description = "Valor mínimo da passagem")
    @PositiveOrZero
    BigDecimal precoMin,

    @Schema(description = "Valor máximo da passagem")
    @PositiveOrZero
    BigDecimal precoMax,

    @Schema(description = "Quantidade de conexões desejadas")
    @PositiveOrZero
    byte conexoes,

    @Schema(description = "Tempo de voo máximo", defaultValue = "")
    @PositiveOrZero
    short tempoVoo,

    @Schema(description = "Data da ida", required = true)
    String dataIda,

    @Schema(description = "Data da volta")
    String dataVolta,

    @Schema(description = "Número da página desejada", defaultValue = "1")
    @Min(1)
    Short pagina,

    @Schema(description = "Número de passagens por página desejado", required = true)
    @NotNull
    @Min(1)
    Short porPagina
){}

package dev.unscrud.api_milhas.domain.estado;

import jakarta.validation.constraints.NotBlank;

public record DadosEstado(
    @NotBlank (message = "O id do estado é obrigatorio")
    String id,

    @NotBlank (message = "O nome do estado é obrigatorio")
    String nome,

    @NotBlank (message = "A sigla do estado é obrigatoria")
    String sigla
){
    public DadosEstado(Estado estado) {
        this(
            String.valueOf(estado.getId()),
            estado.getNome(),
            estado.getSigla()
        );
    }
}

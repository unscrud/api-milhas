package dev.unscrud.api_milhas.domain.passagem;

import java.util.Arrays;

import lombok.Getter;

public enum TipoPassagem {
    ECONOMICA("Econômica"),
    EXECUTIVA("Executiva");

    @Getter
    private final String descricao;

    TipoPassagem(String descricao) {
        this.descricao = descricao;
    }

    public static TipoPassagem obterTipoDa (String descricao) {
        return Arrays.stream(TipoPassagem.values())
                .filter(tipo -> tipo.getDescricao().equalsIgnoreCase(descricao))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Descrição inválida"));
    }
}

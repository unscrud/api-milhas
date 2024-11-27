package dev.unscrud.api_milhas.domain.passagem;

import lombok.Getter;

public enum TipoPassagem {
    ECONOMICA("Econômica"),
    EXECUTIVA("Executiva");

    @Getter
    private final String descricao;

    TipoPassagem(String descricao) {
        this.descricao = descricao;
    }
}

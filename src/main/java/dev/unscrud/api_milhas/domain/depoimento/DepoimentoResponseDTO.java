package dev.unscrud.api_milhas.domain.depoimento;

import dev.unscrud.api_milhas.domain.util.ImagemUtil;

public record DepoimentoResponseDTO (
    Long id,
    String texto,
    String autor,
    String avatar
) {
    public DepoimentoResponseDTO(Depoimento depoimento) {
        this(
            depoimento.getId(),
            depoimento.getTexto(),
            depoimento.getAutor(),
            ImagemUtil.gerarUrlImagem(depoimento.getAvatar())
        );
    }
}

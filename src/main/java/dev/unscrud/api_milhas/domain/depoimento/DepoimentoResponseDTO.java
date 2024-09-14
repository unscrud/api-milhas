package dev.unscrud.api_milhas.domain.depoimento;

public record DepoimentoResponseDTO(
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
            depoimento.getAvatar()
        );
    }

}

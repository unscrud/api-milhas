package dev.unscrud.api_milhas.domain.estado;

public record EstadoResponseDTO(
    Byte id,
    String nome,
    String sigla
) {
    public EstadoResponseDTO(Estado estado) {
        this(
            estado.getId(),
            estado.getNome(),
            estado.getSigla()
        );
    }
}

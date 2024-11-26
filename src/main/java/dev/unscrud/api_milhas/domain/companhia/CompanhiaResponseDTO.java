package dev.unscrud.api_milhas.domain.companhia;

public record CompanhiaResponseDTO(Integer id, String nome) {
    public CompanhiaResponseDTO(Companhia companhia) {
        this(
            companhia.getId(), 
            companhia.getNome()
        );
    }
}

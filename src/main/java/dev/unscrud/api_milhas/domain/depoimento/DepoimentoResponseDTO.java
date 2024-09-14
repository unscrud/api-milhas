package dev.unscrud.api_milhas.domain.depoimento;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
            gerarUrlImagem(depoimento.getAvatar())
        );
    }

    private static String gerarUrlImagem(String nomeImagem){
        String urlBase = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        return urlBase + "/images/" + nomeImagem;
    }
}

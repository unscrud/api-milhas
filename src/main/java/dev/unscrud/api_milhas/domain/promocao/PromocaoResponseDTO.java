package dev.unscrud.api_milhas.domain.promocao;

import java.math.BigDecimal;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public record PromocaoResponseDTO(
    Long id,
    String destino,
    String imagem,
    BigDecimal preco
) {
    public PromocaoResponseDTO(Promocao promocao) {
        this(
            promocao.getId(),
            promocao.getDestino(),
            gerarUrlImagem(promocao.getImagem()),
            promocao.getPreco()
        );
    }

    private static String gerarUrlImagem(String nomeImagem){
        String urlBase = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        return urlBase + "/images/" + nomeImagem;
    }
}

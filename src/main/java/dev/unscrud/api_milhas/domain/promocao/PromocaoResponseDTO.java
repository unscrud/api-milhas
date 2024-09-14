package dev.unscrud.api_milhas.domain.promocao;

import java.math.BigDecimal;

import dev.unscrud.api_milhas.domain.util.ImagemUtil;

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
            ImagemUtil.gerarUrlImagem(promocao.getImagem()),
            promocao.getPreco()
        );
    }
}

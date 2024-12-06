package dev.unscrud.api_milhas.domain.passagem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

// import dev.unscrud.api_milhas.domain.companhia.Companhia;
import dev.unscrud.api_milhas.domain.estado.Estado;
import jakarta.persistence.criteria.*;

public class PassagemSpecifications {
    public static Specification<Passagem> comJoinsEFiltro(DadosBuscaPassagensDTO dadosBusca) {
        return (Root<Passagem> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicates = new ArrayList<>();
            
            Predicate predicateIdMaiorQueZero = builder.greaterThan(root.get("id"), 0);
            predicates.add(predicateIdMaiorQueZero);
            
            if (dadosBusca.tipo() != null && !dadosBusca.tipo().isEmpty()) {
                TipoPassagem tipoPassagem = TipoPassagem.valueOf(dadosBusca.tipo());
                Path<String> tipoPassagemPath = root.get("tipoPassagem");
                Predicate predicateTipo = builder.equal(tipoPassagemPath.as(String.class), tipoPassagem.name());
                predicates.add(predicateTipo);
            }

            if (dadosBusca.origemId() != null && dadosBusca.origemId() > 0) {
                Short origemId = dadosBusca.origemId();
                Path<Estado> origem = root.get("origem");
                Predicate predicateOrigemId = builder.equal(origem.get("id"), origemId);
                predicates.add(predicateOrigemId);
            }

            if (dadosBusca.destinoId() != null && dadosBusca.destinoId() > 0) {
                Short destinoId = dadosBusca.destinoId();
                Path<Estado> destino = root.get("destino");
                Predicate predicateDestinoId = builder.equal(destino.get("id"), destinoId);
                predicates.add(predicateDestinoId);
            }

            if (dadosBusca.precoMin() != null && isMaiorQueZero(dadosBusca.precoMin()) ){
                BigDecimal precoMinimo = dadosBusca.precoMin();
                Path<BigDecimal> precoIda = root.get("precoIda");
                Predicate predicatePrecoMinimo = builder.greaterThanOrEqualTo(precoIda, precoMinimo);
                predicates.add(predicatePrecoMinimo);
            }

            if (dadosBusca.precoMax() != null && isMaiorQueZero(dadosBusca.precoMax()) ){
                BigDecimal precoMaximo = dadosBusca.precoMax();
                Path<BigDecimal> precoIda = root.get("precoIda");
                Predicate predicateprecoMaximo = builder.lessThanOrEqualTo(precoIda, precoMaximo);
                predicates.add(predicateprecoMaximo);
            }

            if (dadosBusca.conexoes() != null && dadosBusca.conexoes() > 0) {
                Path<Short> conexoes = root.get("conexoes");
                Predicate predicateConexoes;
                if (dadosBusca.conexoes() > 2){
                    predicateConexoes = builder.greaterThanOrEqualTo(conexoes, dadosBusca.conexoes());
                } else {
                    predicateConexoes = builder.equal(conexoes, dadosBusca.conexoes());
                }
                predicates.add(predicateConexoes);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static boolean isMaiorQueZero(BigDecimal valor) {
        return valor.compareTo(BigDecimal.ZERO) > 0;
    }
}

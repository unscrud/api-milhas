package dev.unscrud.api_milhas.domain.passagem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

// import dev.unscrud.api_milhas.domain.companhia.Companhia;
import dev.unscrud.api_milhas.domain.estado.Estado;
import jakarta.persistence.criteria.*;

public class PassagemSpecifications {
    public static Specification<Passagem> comJoinsEFiltro(DadosBuscaPassagensDTO dadosBusca) {
        return (Root<Passagem> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            // Join<Passagem, Estado> origemJoin = root.join("origem", JoinType.LEFT);
            // Join<Passagem, Estado> destinoJoin = root.join("destino", JoinType.LEFT);
            // Join<Passagem, Companhia> companhiaJoin = root.join("companhia", JoinType.LEFT);

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

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

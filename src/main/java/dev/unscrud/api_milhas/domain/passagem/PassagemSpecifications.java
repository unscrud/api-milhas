package dev.unscrud.api_milhas.domain.passagem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

// import dev.unscrud.api_milhas.domain.companhia.Companhia;
// import dev.unscrud.api_milhas.domain.estado.Estado;
import jakarta.persistence.criteria.*;

public class PassagemSpecifications {
    public static Specification<Passagem> comJoinsEFiltro(DadosBuscaPassagensDTO dadosBusca) {
        return (Root<Passagem> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            // Join<Passagem, Estado> origemJoin = root.join("origem", JoinType.LEFT);
            // Join<Passagem, Estado> destinoJoin = root.join("destino", JoinType.LEFT);
            // Join<Passagem, Companhia> companhiaJoin = root.join("companhia", JoinType.LEFT);

            List<Predicate> predicates = new ArrayList<>();
            
            if (dadosBusca.tipo() != null && !dadosBusca.tipo().isEmpty()) {
                TipoPassagem tipoPassagem = TipoPassagem.valueOf(dadosBusca.tipo());
                var enumTipoPassagem = root.get("tipoPassagem").as(String.class);
                Predicate predicateTipo = builder.equal(enumTipoPassagem, tipoPassagem.name());
                predicates.add(predicateTipo);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

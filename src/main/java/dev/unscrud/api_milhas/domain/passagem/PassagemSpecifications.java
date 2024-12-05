package dev.unscrud.api_milhas.domain.passagem;

import org.springframework.data.jpa.domain.Specification;

import dev.unscrud.api_milhas.domain.companhia.Companhia;
import dev.unscrud.api_milhas.domain.estado.Estado;
import jakarta.persistence.criteria.*;

public class PassagemSpecifications {
    public static Specification<Passagem> comJoinsEFiltro(DadosBuscaPassagensDTO dadosBusca) {
        return (Root<Passagem> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<Passagem, Estado> origemJoin = root.join("origem", JoinType.LEFT);
            Join<Passagem, Estado> destinoJoin = root.join("destino", JoinType.LEFT);
            Join<Passagem, Companhia> companhiaJoin = root.join("companhia", JoinType.LEFT);

            //Predicate[] predicates = new Predicate[0];

            return builder.conjunction();//.and(predicates);
        };
    }
}

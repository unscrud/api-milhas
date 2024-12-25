package dev.unscrud.api_milhas.domain.passagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long>, JpaSpecificationExecutor<Passagem> {
    @Query("""
        SELECT new dev.unscrud.api_milhas.domain.passagem.PrecoDTO ( 
            MIN(p.precoIda), 
            MAX(p.precoIda)
        ) 
        FROM Passagem p
        WHERE p.precoIda > 0
    """)
    PrecoDTO findPrecoIdaMinMax();
}

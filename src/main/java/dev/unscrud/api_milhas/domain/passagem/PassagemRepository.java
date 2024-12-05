package dev.unscrud.api_milhas.domain.passagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PassagemRepository extends JpaRepository<Passagem, Long>, JpaSpecificationExecutor<Passagem> {}

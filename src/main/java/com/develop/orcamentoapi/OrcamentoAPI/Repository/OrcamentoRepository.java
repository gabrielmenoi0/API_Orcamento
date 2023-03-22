package com.develop.orcamentoapi.OrcamentoAPI.Repository;

import com.develop.orcamentoapi.OrcamentoAPI.Domain.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("OrcamentoRepository")

public interface OrcamentoRepository extends JpaRepository<Orcamento, UUID>  {
//    Orcamento alterById(UUID id);
}



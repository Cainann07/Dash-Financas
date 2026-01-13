package com.mateuss.financeiro_api.repository;

import com.mateuss.financeiro_api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}

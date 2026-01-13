package com.mateuss.financeiro_api.repository;

import com.mateuss.financeiro_api.model.Meta;
import com.mateuss.financeiro_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaRepository extends JpaRepository<Meta, String> {
}

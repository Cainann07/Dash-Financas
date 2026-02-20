package com.mateuss.financeiro_api.repository;

import com.mateuss.financeiro_api.model.GastoMensal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GastoMensalRepository extends JpaRepository<GastoMensal, Integer> {
//    ArrayList<GastoMensalDTO> findByIdUsuario(Long idUsuario);

    List<GastoMensal> findAllByUsuarioId(Long idUsuario);
}

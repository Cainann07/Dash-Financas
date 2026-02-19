package com.mateuss.financeiro_api.service;

import com.mateuss.financeiro_api.dto.GastoMensalDTO;
import com.mateuss.financeiro_api.model.GastoMensal;

import java.util.List;

public interface GastoMensalService {

    void adicionarGastoMensal(Long idUsuario, GastoMensalDTO gastoMensalDTO);
    GastoMensalDTO lerGastoMensal(Integer idGasto);
    GastoMensalDTO alterarGastoMensal(GastoMensalDTO gastoMensalDTO);
    List<GastoMensalDTO> listarGastoMensal(Long idUsuario);
    GastoMensal deletarGastoMensal(Integer idGasto);
}

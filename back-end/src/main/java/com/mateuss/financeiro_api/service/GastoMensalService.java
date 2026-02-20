package com.mateuss.financeiro_api.service;

import com.mateuss.financeiro_api.dto.GastoMensalDTOPutRequest;
import com.mateuss.financeiro_api.dto.GastoMensalDTORequest;
import com.mateuss.financeiro_api.dto.GastoMensalDTOResponse;
import com.mateuss.financeiro_api.model.GastoMensal;

import java.util.List;

public interface GastoMensalService {

    void adicionarGastoMensal(Long idUsuario, GastoMensalDTORequest gastoMensalDTO);
    GastoMensalDTOResponse lerGastoMensal(Integer idGasto);
    GastoMensalDTOResponse alterarGastoMensal(GastoMensalDTOPutRequest gastoMensalDTO);
    List<GastoMensalDTOResponse> listarGastoMensal(Long idUsuario);
    GastoMensal deletarGastoMensal(Integer idGasto);
}

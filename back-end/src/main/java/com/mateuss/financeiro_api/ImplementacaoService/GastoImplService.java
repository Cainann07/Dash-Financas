package com.mateuss.financeiro_api.ImplementacaoService;

import com.mateuss.financeiro_api.dto.GastoMensalDTOPutRequest;
import com.mateuss.financeiro_api.dto.GastoMensalDTORequest;
import com.mateuss.financeiro_api.dto.GastoMensalDTOResponse;
import com.mateuss.financeiro_api.exceptions.ResourceNotFoundException;
import com.mateuss.financeiro_api.model.GastoMensal;
import com.mateuss.financeiro_api.model.Usuario;
import com.mateuss.financeiro_api.repository.GastoMensalRepository;
import com.mateuss.financeiro_api.repository.UsuarioRepository;
import com.mateuss.financeiro_api.service.GastoMensalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoImplService implements GastoMensalService {

    private final GastoMensalRepository gastoMensalRepository;

    private final UsuarioRepository usuarioRepository;

    public GastoImplService(GastoMensalRepository gastoMensalRepository, UsuarioRepository usuarioRepository) {
        this.gastoMensalRepository = gastoMensalRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public void adicionarGastoMensal(Long idUsuario, GastoMensalDTORequest gastoMensalDTO) {
        Usuario usuarioLogado = usuarioRepository.findById(idUsuario).orElseThrow(() -> new ResourceNotFoundException("Cliente não existente."));

        GastoMensal novoGastoMensal = new GastoMensal(usuarioLogado, gastoMensalDTO);
        gastoMensalRepository.save(novoGastoMensal);
    }

    @Override
    public GastoMensalDTOResponse lerGastoMensal(Integer idGasto) {
     GastoMensal gastoMensal = gastoMensalRepository.findById(idGasto).orElseThrow(()->new ResourceNotFoundException("Esse gasto não existe."));
        GastoMensalDTOResponse gastoMensalDTO = new GastoMensalDTOResponse(gastoMensal);

     return gastoMensalDTO;
    }

    @Override
    public GastoMensalDTOResponse alterarGastoMensal(GastoMensalDTOPutRequest gastoMensalDTO) {
        GastoMensal gastoMensalAlterado = gastoMensalRepository.findById(Math.toIntExact(gastoMensalDTO.getId())).orElseThrow(() -> new ResourceNotFoundException("Esse gasto não existe."));

        gastoMensalAlterado.setNomeGasto(gastoMensalDTO.getNome());
        gastoMensalAlterado.setValor(gastoMensalDTO.getValor());
        gastoMensalAlterado.setDiaVencimento(gastoMensalDTO.getDiaVencimento());
        gastoMensalAlterado.setDataUltimoPagamento(gastoMensalDTO.getDataUltimoPagamento());

        return new GastoMensalDTOResponse(gastoMensalRepository.save(gastoMensalAlterado));
    }

    @Override
    public List<GastoMensalDTOResponse> listarGastoMensal(Long idUsuario) {
        List<GastoMensal> gastos = gastoMensalRepository.findAllByUsuarioId(idUsuario);
        return gastos.stream().map(GastoMensalDTOResponse::new).toList();
    }

    @Override
    public GastoMensal deletarGastoMensal(Integer idGasto) {
        GastoMensal gastoMensal = gastoMensalRepository.findById(idGasto).orElseThrow(() -> new ResourceNotFoundException("Esse gasto não existe."));
        gastoMensalRepository.deleteById(idGasto);
        return gastoMensal;
    }
}

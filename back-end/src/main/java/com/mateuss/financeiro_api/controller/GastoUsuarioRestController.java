package com.mateuss.financeiro_api.controller;


import com.mateuss.financeiro_api.ImplementacaoService.GastoImplService;
import com.mateuss.financeiro_api.dto.GastoMensalDTORequest;
import com.mateuss.financeiro_api.dto.GastoMensalDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gastos")
public class GastoUsuarioRestController {

    private final GastoImplService gastoImplService;

    public GastoUsuarioRestController(GastoImplService gastoImplService) {
        this.gastoImplService = gastoImplService;
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<Void> criarGasto(@PathVariable Long idUsuario, @RequestBody GastoMensalDTORequest gastoMensalDTO) {
        System.out.println("Dados recebidos: " + gastoMensalDTO.toString());

        gastoImplService.adicionarGastoMensal(idUsuario, gastoMensalDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoMensalDTOResponse> lerGastoMensal(@PathVariable Integer id) {
        GastoMensalDTOResponse gastoMensalDTO = gastoImplService.lerGastoMensal(id);

        if (gastoMensalDTO != null) {
            return ResponseEntity.ok(gastoMensalDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoMensalDTOResponse> alterarGastoMensal(@RequestBody GastoMensalDTORequest gastoMensalDTO) {
        GastoMensalDTOResponse gastoMensalAlterado = gastoImplService.alterarGastoMensal(gastoMensalDTO);
        return ResponseEntity.ok(gastoMensalAlterado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarGastoMensal(@PathVariable Integer id) {
        gastoImplService.deletarGastoMensal(id);
        return ResponseEntity.noContent().build();
    }

}

package com.mateuss.financeiro_api.controller;


import com.mateuss.financeiro_api.ImplementacaoService.GastoImplService;
import com.mateuss.financeiro_api.dto.GastoMensalDTO;
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
    public ResponseEntity<Void> criarGasto(@PathVariable Long idUsuario, @RequestBody GastoMensalDTO gastoMensalDTO) {
        System.out.println("Dados recebidos: " + gastoMensalDTO.toString());

        gastoImplService.adicionarGastoMensal(idUsuario, gastoMensalDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoMensalDTO> lerGastoMensal(@PathVariable Integer id) {
        GastoMensalDTO gastoMensalDTO = gastoImplService.lerGastoMensal(id);

        if (gastoMensalDTO != null) {
            return ResponseEntity.ok(gastoMensalDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoMensalDTO> alterarGastoMensal(@RequestBody GastoMensalDTO gastoMensalDTO) {
        GastoMensalDTO gastoMensalAlterado = gastoImplService.alterarGastoMensal(gastoMensalDTO);
        return ResponseEntity.ok(gastoMensalAlterado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarGastoMensal(@PathVariable Integer id) {
        gastoImplService.deletarGastoMensal(id);
        return ResponseEntity.noContent().build();
    }

}

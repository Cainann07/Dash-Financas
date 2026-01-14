package com.mateuss.financeiro_api.controller;

import com.mateuss.financeiro_api.ImplementacaoService.UsuarioImplService;
import com.mateuss.financeiro_api.dto.UsuarioDTORequest;
import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

    @Autowired
    UsuarioImplService usuarioImplService;

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest) {
        usuarioImplService.adicionarUsuario(usuarioDTORequest);
        // Retorna código 201 (Created) ou 200 (OK)
        return ResponseEntity.ok().build();
    }

    // 2. LER (GET com ID)
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> lerUsuario(@PathVariable Long id) {
        UsuarioDTOResponse usuario = usuarioImplService.lerUsuario(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario); // Retorna 200 e o JSON do usuário
        }
        return ResponseEntity.notFound().build(); // Retorna 404 se não achar
    }

    // 3. ATUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> atualizarUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest, @PathVariable Long id) {
        UsuarioDTOResponse usuarioAtualizado = usuarioImplService.atualizarUsuario(usuarioDTORequest, id);
        return ResponseEntity.ok(usuarioAtualizado);

    }

    // 4. DELETAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> deletarUsuario(@PathVariable Long id) {
        usuarioImplService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}

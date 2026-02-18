package com.mateuss.financeiro_api.controller;

import com.mateuss.financeiro_api.ImplementacaoService.UsuarioImplService;
import com.mateuss.financeiro_api.dto.LoginRequestDTO;
import com.mateuss.financeiro_api.dto.UsuarioDTORequest;
import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

    @Autowired
    UsuarioImplService usuarioImplService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTOResponse> login(@RequestBody LoginRequestDTO loginRequest) {
        UsuarioDTOResponse usuarioLogado = usuarioImplService.autenticarUsuario(loginRequest.email(), loginRequest.senha());
        return ResponseEntity.ok(usuarioLogado);
    }

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest) {
        System.out.println("Dados recebidos: " + usuarioDTORequest.toString());

        usuarioImplService.adicionarUsuario(usuarioDTORequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> lerUsuario(@PathVariable Long id) {
        UsuarioDTOResponse usuario = usuarioImplService.lerUsuario(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> atualizarUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest, @PathVariable Long id) {
        UsuarioDTOResponse usuarioAtualizado = usuarioImplService.atualizarUsuario(usuarioDTORequest, id);
        return ResponseEntity.ok(usuarioAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> deletarUsuario(@PathVariable Long id) {
        usuarioImplService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}

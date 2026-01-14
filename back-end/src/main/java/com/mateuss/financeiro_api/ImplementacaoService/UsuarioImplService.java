package com.mateuss.financeiro_api.ImplementacaoService;


import com.mateuss.financeiro_api.dto.UsuarioDTORequest;
import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import com.mateuss.financeiro_api.exceptions.ResourceAlreadyExistsException;
import com.mateuss.financeiro_api.exceptions.ResourceNotFoundException;
import com.mateuss.financeiro_api.model.Usuario;
import com.mateuss.financeiro_api.repository.UsuarioRepository;
import com.mateuss.financeiro_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplService implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void adicionarUsuario(UsuarioDTORequest usuarioDTORequest) {
        if (usuarioRepository.existsByEmail(usuarioDTORequest.getEmail())) {
            throw new ResourceAlreadyExistsException("Já existe um usuário com esse e-mail.");
        }
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(usuarioDTORequest.getEmail());
        novoUsuario.setNome(usuarioDTORequest.getNome());
        novoUsuario.setSobrenome(usuarioDTORequest.getSobrenome());
        novoUsuario.setSenha(usuarioDTORequest.getSenha());
        usuarioRepository.save(novoUsuario);
    }

    @Override
    public UsuarioDTOResponse lerUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado."));
        UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioDTOResponse.setEmail(usuario.getEmail());
        usuarioDTOResponse.setNome(usuario.getNome());
        usuarioDTOResponse.setSobrenome(usuario.getSobrenome());
        return usuarioDTOResponse;
    }

    public UsuarioDTOResponse atualizarUsuario(UsuarioDTORequest usuarioDTORequest, Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado para atualização de dados."));

        UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioExistente.setEmail(usuarioDTORequest.getEmail());
        usuarioExistente.setNome(usuarioDTORequest.getNome());
        usuarioExistente.setSobrenome(usuarioDTORequest.getSobrenome());
        usuarioExistente.setSenha(usuarioDTORequest.getSenha());
        usuarioRepository.save(usuarioExistente);

        usuarioDTOResponse.setNome(usuarioDTORequest.getNome());
        usuarioDTOResponse.setSobrenome(usuarioDTORequest.getSobrenome());
        usuarioDTOResponse.setEmail(usuarioDTORequest.getEmail());
        return usuarioDTOResponse;

    }

    @Override
    public void deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Usuário com ID " + id + " não encontrado para exclusão.");
        }
    }
}

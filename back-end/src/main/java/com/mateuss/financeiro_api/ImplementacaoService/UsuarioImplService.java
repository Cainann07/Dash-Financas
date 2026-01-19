package com.mateuss.financeiro_api.ImplementacaoService;


import com.mateuss.financeiro_api.dto.UsuarioDTORequest;
import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import com.mateuss.financeiro_api.exceptions.ResourceAlreadyExistsException;
import com.mateuss.financeiro_api.exceptions.ResourceNotFoundException;
import com.mateuss.financeiro_api.model.Usuario;
import com.mateuss.financeiro_api.repository.UsuarioRepository;
import com.mateuss.financeiro_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplService implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UsuarioDTOResponse autenticarUsuario(String email, String senhaRaw) {
        // 1. Busca o usuário pelo email
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email ou senha inválidos.")); // Mensagem genérica por segurança;

        // 2. Compara a senha digitada com a senha criptografada do banco
        if (!passwordEncoder.matches(senhaRaw, usuario.getSenha())) {
            throw new ResourceNotFoundException("Email ou senha inválidos.");
        }

        // 3. Se passou, retorna os dados do usuário
        UsuarioDTOResponse response = new UsuarioDTOResponse();
        response.setEmail(usuario.getEmail());
        response.setNome(usuario.getNome());
        response.setSobrenome(usuario.getSobrenome());

        return response;
    }

    @Override
    public void adicionarUsuario(UsuarioDTORequest usuarioDTORequest) {
        if (usuarioRepository.existsByEmail(usuarioDTORequest.getEmail())) {
            throw new ResourceAlreadyExistsException("Já existe um usuário com esse e-mail.");
        }
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(usuarioDTORequest.getEmail());
        novoUsuario.setNome(usuarioDTORequest.getNome());
        novoUsuario.setSobrenome(usuarioDTORequest.getSobrenome());

        String senhaCriptografada = passwordEncoder.encode(usuarioDTORequest.getSenha());
        novoUsuario.setSenha(senhaCriptografada);
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

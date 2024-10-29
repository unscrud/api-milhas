package dev.unscrud.api_milhas.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServico(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criarUsuario(DadosCadastro dadosCadastro){       
        var nome = dadosCadastro.nome();
        var cpf = dadosCadastro.cpf();
        var nascimento = dadosCadastro.nascimento();
        var telefone = dadosCadastro.telefone();
        var genero = dadosCadastro.genero();
        var email = dadosCadastro.email();
        var senha = passwordEncoder.encode(dadosCadastro.senha());
        var cidade = dadosCadastro.cidade();
        var estado = dadosCadastro.estado().id();
        
        Usuario usuario = new Usuario(null, nome, cpf, nascimento, telefone, genero, email, senha, cidade, estado);
        return usuarioRepository.save(usuario);
    }
}

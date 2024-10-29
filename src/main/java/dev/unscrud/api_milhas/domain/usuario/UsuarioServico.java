package dev.unscrud.api_milhas.domain.usuario;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.unscrud.api_milhas.domain.estado.Estado;

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
        var nascimento = LocalDate.parse(dadosCadastro.nascimento().substring(0, 10));
        var telefone = dadosCadastro.telefone();
        var genero = Genero.valueOf(dadosCadastro.genero().toUpperCase());
        var email = dadosCadastro.email();
        var senha = passwordEncoder.encode(dadosCadastro.senha());
        var cidade = dadosCadastro.cidade();
        Estado estado = new Estado (
            Byte.parseByte(dadosCadastro.estado().id()),
            dadosCadastro.estado().nome(),
            dadosCadastro.estado().sigla()
        );
        
        Usuario usuario = new Usuario(null, nome, cpf, nascimento, telefone, genero, email, senha, cidade, estado);
        return usuarioRepository.save(usuario);
    }
}

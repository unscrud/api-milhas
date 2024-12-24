package dev.unscrud.api_milhas.domain.usuario;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.unscrud.api_milhas.domain.estado.Estado;

@Service
public class UsuarioServico {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServico(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private Usuario converterDadosCadastroParaUsuario(DadosCadastro dadosCadastro, Long id) {
        var nome = dadosCadastro.nome();
        var cpf = dadosCadastro.cpf();
        var nascimento = LocalDate.parse(dadosCadastro.nascimento().substring(0, 10));
        var telefone = dadosCadastro.telefone();
        var genero = Genero.valueOf(dadosCadastro.genero().toUpperCase());
        var email = dadosCadastro.email();
        var senha = passwordEncoder.encode(dadosCadastro.senha());
        var cidade = dadosCadastro.cidade();
        Estado estado = new Estado(
                Byte.parseByte(dadosCadastro.estado().id()),
                dadosCadastro.estado().nome(),
                dadosCadastro.estado().sigla()
        );
        
        return new Usuario(id, nome, cpf, nascimento, telefone, genero, email, senha, cidade, estado);
    }
    
    public Usuario criarUsuario(DadosCadastro dadosCadastro) {
        Usuario usuario = converterDadosCadastroParaUsuario(dadosCadastro, null);
        return usuarioRepository.save(usuario);
    }
    
    public DadosCadastro editarUsuarioLogado(DadosCadastro dadosCadastro) {
        Usuario usuario = getUsuarioLogado();
        Usuario usuarioAlterado = converterDadosCadastroParaUsuario(dadosCadastro, usuario.getId());
        return new DadosCadastro(usuarioRepository.save(usuarioAlterado));
    }    

    public Usuario getUsuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return usuario;
    }
}

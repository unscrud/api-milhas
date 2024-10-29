package dev.unscrud.api_milhas.domain.usuario;

import dev.unscrud.api_milhas.domain.estado.DadosEstado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastro(
    @NotBlank (message = "O nome é obrigatorio")
    String nome,
    
    @NotBlank (message = "O CPF é obrigatorio")
    String cpf,
    
    @NotBlank (message = "A data de nascimento é obrigatoria")
    String nascimento,
    
    @NotBlank (message = "O telefone é obrigatorio")
    String telefone,
    
    @NotBlank (message = "O gênero é obrigatorio")
    String genero,
    
    @NotBlank (message = "O email é obrigatorio")
    @Email (message = "Formato inválido de e-mail")
    String email,
    
    @NotBlank (message = "A senha é obrigatoria")
    String senha,
    
    @NotBlank (message = "A cidade é obrigatoria")
    String cidade,
    
    @Valid
    DadosEstado estado
){}

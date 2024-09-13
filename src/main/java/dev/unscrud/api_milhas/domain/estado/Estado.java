package dev.unscrud.api_milhas.domain.estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "estado")
@Entity(name = "estado")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;

    @NotNull 
    @NotEmpty
    @Column(unique = true)
    private String nome;
    
    @NotNull 
    @NotEmpty
    @Column(unique = true)
    private String sigla;
}

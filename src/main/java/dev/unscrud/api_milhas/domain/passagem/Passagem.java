package dev.unscrud.api_milhas.domain.passagem;

import dev.unscrud.api_milhas.domain.companhia.Companhia;
import dev.unscrud.api_milhas.domain.estado.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity(name = "passagem")
@Table(name = "passagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoPassagem tipoPassagem;

    @NotNull
    private BigDecimal precoIda;

    @NotNull
    private BigDecimal precoVolta;

    @NotNull
    private BigDecimal taxaEmbarque;
    
    @NotNull
    private Short conexoes;

    @NotNull
    private Integer tempoVoo;

    @ManyToOne
    @JoinColumn(name = "origemId", referencedColumnName = "id")
    private Estado origem;

    @ManyToOne
    @JoinColumn(name = "destinoId", referencedColumnName = "id")
    private Estado destino;

    @ManyToOne
    @JoinColumn(name = "companhiaId", referencedColumnName = "id")
    private Companhia companhia;
}

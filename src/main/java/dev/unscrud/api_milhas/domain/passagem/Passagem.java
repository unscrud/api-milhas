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

@Entity
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
    @Column(name = "preco_ida")
    private BigDecimal precoIda;

    @NotNull
    @Column(name = "preco_volta")
    private BigDecimal precoVolta;

    @NotNull
    @Column(name = "taxa_embarque")
    private BigDecimal taxaEmbarque;
    
    @NotNull
    private byte conexoes;

    @NotNull
    @Column(name = "tempo_voo")
    private short tempoVoo;

    @ManyToOne
    @JoinColumn(name = "origem_id", referencedColumnName = "id")
    private Estado origem;

    @ManyToOne
    @JoinColumn(name = "destino_id", referencedColumnName = "id")
    private Estado destino;

    @ManyToOne
    @JoinColumn(name = "companhia_id", referencedColumnName = "id")
    private Companhia companhia;
}

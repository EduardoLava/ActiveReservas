package br.com.active.reservas.bean.itens.inventario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.active.reservas.bean.itens.ItemReservavel;
import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_ativo")
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "idItemReservavel")
@DiscriminatorValue(value = "ATIVO")
public @Data class Ativo extends ItemReservavel{

    @Column(name = "idItemReservavel", updatable = false, insertable = false)
    private Long idItemReservavel;
    
    @NotNull(message = "Informe a data de compra")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_vencimento_garantia")
    private LocalDate dataVencimentoGarantia;
    
    @Column(name = "Valor")
    private Double valor;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "cor")
    private String cor;
    
    @Column(name = "local_retirada")
    private String localRetirada;
    
    @NotNull(message = "Selecione um tipo de ativo")
    @ManyToOne
    @JoinColumn(name = "id_tipo_de_ativo", nullable = false) 
    private TipoDeAtivo tipoDeAtivo;
    
    @NotNull(message = "Selecione um status")
    @Enumerated(EnumType.STRING)
    @Column(name = "status_ativo", nullable = false)
    private StatusAtivo statusAtivo;
    
    @Column(name = "imagem")
    private String imagem;
    
    @Column(name = "fornecedor")
    private String fornecedor;
    
    @Size(max = 150, message = "Informe no máximo 150 caracteres")
    @Column(name = "observacao",length = 150)
    private String observacao;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_inativacao")
    private LocalDate dataInativacao;
    
}

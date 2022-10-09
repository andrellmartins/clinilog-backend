package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pucpr.backend.model.table_rules.ProductMovementRules;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Movimentacao")
@EntityListeners({AuditingEntityListener.class, ProductMovementRules.class})
public class ProductMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long qtd_movimentada;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date data_cadastro = new Date();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch lote;

    @Transient
    private Product product;

    @PostLoad
    public void postLoad(){
        this.product = this.lote.getProduto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQtd_movimentada() {
        return qtd_movimentada;
    }

    public void setQtd_movimentada(Long qtd_movimentada) {
        this.qtd_movimentada = qtd_movimentada;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Batch getLote() {
        return lote;
    }

    public void setLote(Batch lote) {
        this.lote = lote;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

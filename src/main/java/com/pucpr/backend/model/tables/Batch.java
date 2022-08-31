package com.pucpr.backend.model.tables;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Lote")
@EntityListeners(AuditingEntityListener.class)
public class Batch  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_produto;
    private String lote;
    private String validade;
    private Long qtd_inicial;
    private Long qtd_disponivel;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date data_cadastro;
    private String fabricante;
    private String id_func_cadastro;
    private boolean deletado;
    @ManyToOne
    private Product produto;


    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_product) {
        this.id_produto = id_product;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Long getQtd_inicial() {
        return qtd_inicial;
    }

    public void setQtd_inicial(Long qtd_inicial) {
        this.qtd_inicial = qtd_inicial;
    }

    public Long getQtd_disponivel() {
        return qtd_disponivel;
    }

    public void setQtd_disponivel(Long qtd_disponivel) {
        this.qtd_disponivel = qtd_disponivel;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getFabricante() { return fabricante; }

    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getId_func_cadastro() { return id_func_cadastro; }

    public void setId_func_cadastro(String id_func_cadastro) { this.id_func_cadastro = id_func_cadastro; }

    public boolean isDeletado() { return deletado; }

    public void setDeletado(boolean deletado) { this.deletado = deletado; }


}

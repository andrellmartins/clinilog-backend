package com.pucpr.backend.model.tables;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean isMed;
    private Long id_lote;
    private String id_func_cadastro;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date data_cadastro;
    private boolean deletado;
    @OneToMany(mappedBy = "produto")
    private List<Batch> lote;
    @OneToOne(mappedBy = "produto")
    private Medicine medicamento;

    public Medicine getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicine medicamento) {
        this.medicamento = medicamento;
    }

    public void setLote(List<Batch> lote) {
        this.lote = lote;
    }

    public List<Batch> getLote() {
        return lote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isMed() {
        return isMed;
    }

    public void setMed(boolean med) {
        isMed = med;
    }

    public Long getId_lote() {
        return id_lote;
    }

    public void setId_lote(Long id_lote) {
        this.id_lote = id_lote;
    }

    public String getId_func_cadastro() {
        return id_func_cadastro;
    }

    public void setId_func_cadastro(String id_func_cadastro) {
        this.id_func_cadastro = id_func_cadastro;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public boolean isDeletado() { return deletado; }

    public void setDeletado(boolean deletado) { this.deletado = deletado; }




}

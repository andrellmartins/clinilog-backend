package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Produto")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class Product  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotNull
    private String descricao;
    @NotEmpty
    @NotNull
    private boolean isMed;
    @NotEmpty
    @NotNull
    private Long id_lote;
    @NotEmpty
    @NotNull
    @Column(nullable = false)
    private Long qtd_minima = 0L;
    @NotEmpty
    @NotNull
    @Column(nullable = false)
    private Long qtd_disponivel = 0L;
    @ManyToOne()
    @JoinColumn(name="id_func_cadastro", referencedColumnName = "id")
    @JsonBackReference("EmployeeProduct(func)")
    @NotEmpty
    @NotNull
    private Employee func;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @NotEmpty
    @NotNull
    private Date data_cadastro = new Date();
    private boolean deletado;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("ProductBatch(id_produto)")
    private List<Batch> lote;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    @JsonManagedReference("ProductMedicine(id_produto)")
    private Medicine medicamento;

    @PrePersist
    protected void prePersistConfigChild(){
        if(this.medicamento != null) {
            this.medicamento.setProduto(this);
        }
        if(this.lote != null){
            this.lote.forEach(batch -> batch.setProduto(this));
        }
    }

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

    public boolean getIsMed() {
        return isMed;
    }

    public void setIsMed(boolean idMed) {
        isMed = idMed;
    }

    public Long getId_lote() {
        return id_lote;
    }

    public void setId_lote(Long id_lote) {
        this.id_lote = id_lote;
    }

    public Employee getFunc() {
        return func;
    }

    public void setFunc(Employee func) {
        this.func = func;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public boolean isDeletado() { return deletado; }

    public void setDeletado(boolean deletado) { this.deletado = deletado; }

    public Long getQtd_disponivel() {
        return qtd_disponivel;
    }

    public void setQtd_disponivel(Long qtd_disponivel) {
        this.qtd_disponivel = qtd_disponivel;
    }


    public Long getQtd_minima() {
        return qtd_minima;
    }

    public void setQtd_minima(Long qtd_minima) {
        this.qtd_minima = qtd_minima;
    }



}

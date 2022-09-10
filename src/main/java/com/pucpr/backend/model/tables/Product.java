package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Produto")
@EntityListeners(AuditingEntityListener.class)
public class Product  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean isMed;
    private Long id_lote;
    @ManyToOne()
    @JoinColumn(name="id_func_cadastro")
    @JsonBackReference("EmployeeProduct(func)")
    private Employee func;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date data_cadastro;
    private boolean deletado;

    @OneToMany(mappedBy = "produto")
    @JsonManagedReference("ProductBatch(id_produto)")
    private List<Batch> lote;

    @OneToOne(mappedBy = "produto")
    @JsonBackReference("ProductMedicine(id_produto)")
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




}

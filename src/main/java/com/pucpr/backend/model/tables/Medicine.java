package com.pucpr.backend.model.tables;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name="Medicamento")
@EntityListeners(AuditingEntityListener.class)
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String principio_ativo;
    private boolean deletado;
    @OneToOne
    @JoinColumn(name="id_produto")
    @JsonBackReference("ProductMedicine(id_produto)")
    private Product produto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrincipio_ativo() {
        return principio_ativo;
    }

    public void setPrincipio_ativo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }

    public boolean isDeletado() { return deletado; }

    public void setDeletado(boolean deletado) { this.deletado = deletado; }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }
}

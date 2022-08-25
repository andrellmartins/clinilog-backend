package com.pucpr.backend.model.tables;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_produto;
    private String principio_ativo;
    private boolean deletado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getPrincipio_ativo() {
        return principio_ativo;
    }

    public void setPrincipio_ativo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }

    public boolean isDeletado() { return deletado; }

    public void setDeletado(boolean deletado) { this.deletado = deletado; }

}

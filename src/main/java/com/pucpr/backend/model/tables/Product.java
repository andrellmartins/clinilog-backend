package com.pucpr.backend.model.tables;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean isMed;
    private Long id_lote;
    private String id_func_cadastro;
    private boolean deletado;


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

    public boolean isDeletado() { return deletado; }

    public void setDeletado(boolean deletado) { this.deletado = deletado; }


}

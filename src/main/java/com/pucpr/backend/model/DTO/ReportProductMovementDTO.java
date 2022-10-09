package com.pucpr.backend.model.DTO;

import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.model.tables.Product;

import java.util.Date;
import java.util.List;

public class ReportProductMovementDTO{
    private List<Product> produtos;
    private List<Batch> lotes;
    private boolean conciliar_lote;
    private Date data_inicio;
    private Date data_fim;

    public List<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Product> produtos) {
        this.produtos = produtos;
    }

    public List<Batch> getLotes() {
        return lotes;
    }

    public void setLotes(List<Batch> lotes) {
        this.lotes = lotes;
    }

    public boolean isConciliar_lote() {
        return conciliar_lote;
    }

    public void setConciliar_lote(boolean conciliar_lote) {
        this.conciliar_lote = conciliar_lote;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
}

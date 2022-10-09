package com.pucpr.backend.model.table_rules;

import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.model.tables.Product;
import com.pucpr.backend.model.tables.ProductMovement;
import com.pucpr.backend.resource.service.BatchService;
import com.pucpr.backend.resource.service.ProductMovementService;
import com.pucpr.backend.resource.service.ProductService;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.transaction.Transactional;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Component
public class BatchRules {
    private static ProductMovementService movimentacaoService;

    @Autowired
    public void init(
        ProductMovementService movimentacaoService
    )
    {
        BatchRules.movimentacaoService = movimentacaoService;
    }

    public BatchRules() {}

    @PostPersist
    public void inserirNovoLote(Batch lote){
        ProductMovement movimentacao = new ProductMovement();
        movimentacao.setLote(lote);
        movimentacao.setQtd_movimentada(lote.getQtd_inicial());

        movimentacaoService.save(movimentacao);
    }
}

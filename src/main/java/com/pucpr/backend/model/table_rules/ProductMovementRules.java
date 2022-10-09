package com.pucpr.backend.model.table_rules;

import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.model.tables.Product;
import com.pucpr.backend.model.tables.ProductMovement;
import com.pucpr.backend.resource.service.ProductMovementService;
import com.pucpr.backend.resource.service.ProductService;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;

@Component
public class ProductMovementRules extends EmptyInterceptor {
    private static ProductService productService;
    private static EntityManager entityManager;

    private static String state;
    private static ProductMovement currentProductMovement;

    @Autowired
    public void init(
        ProductService productService,
        EntityManager entityManager
    )
    {
        ProductMovementRules.productService = productService;
        ProductMovementRules.entityManager = entityManager;
    }



    public ProductMovementRules() {}

}

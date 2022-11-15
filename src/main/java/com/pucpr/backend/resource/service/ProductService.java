package com.pucpr.backend.resource.service;


import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.model.tables.Product;
import com.pucpr.backend.model.repository.ProductRepository;
import com.pucpr.backend.model.tables.ProductMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService
        implements CrudInterface<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMovementService productMovementService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> save(Product entity) {
        if(entity.getId() != null && entity.getLote() != null){
            Product currentProduct = productRepository.consultaPorId(entity.getId());
            Long qtdProduct = currentProduct.getQtd_disponivel();
            for (Batch lote : entity.getLote()){
                if(lote.getId() == null){
                    qtdProduct+=lote.getQtd_inicial();
                }
            }
            entity.setQtd_disponivel(qtdProduct);
        }
        return Optional.of(productRepository.save(entity));
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public Product consultaPorId(long id) {
        return productRepository.consultaPorId(id);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

}
package com.pucpr.backend.model.repository;


import com.pucpr.backend.model.tables.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {


    public Product findById(long id);

    public List<Product> findAll();

    public Product deleteById(long id);


}



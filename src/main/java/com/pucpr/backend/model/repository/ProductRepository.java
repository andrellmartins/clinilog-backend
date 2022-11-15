package com.pucpr.backend.model.repository;


import com.pucpr.backend.model.tables.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

    @Query(value =
        "SELECT p FROM Product p WHERE p.deletado = false AND p.id=:id"
    )
    Product consultaPorId(@Param("id") long id);

    @Query(value =
            "SELECT p FROM Product p WHERE p.deletado = false AND p.id=:id"
    )
    Optional<Product> findById(@Param("id") long id);

    @Override
    @Query(value =
        "SELECT p FROM Product p WHERE p.deletado = false"
    )
    List<Product> findAll();
}



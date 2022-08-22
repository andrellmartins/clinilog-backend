package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.objects.ProductSimplified;
import com.pucpr.backend.model.tables.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {


    public Product findById(long id);

    @Query(value="SELECT new com.pucpr.pucbay.model.objects.ProductSimplified(p.title, p.available_quantity) FROM Product p", nativeQuery = true)
    public List<ProductSimplified> getTitleQuantity();

    public List<Product> findAll();

    public Product deleteById(long id);


}



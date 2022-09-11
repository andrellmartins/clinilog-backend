package com.pucpr.backend.resource.controller;


import com.pucpr.backend.resource.service.ProductService;
import com.pucpr.backend.model.tables.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return productService.findById(id);
    }

     @GetMapping(value = "/")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Product> save(
            @RequestBody Product product) {
        productService.save(product) ;
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().body("Product " + id + " excluded");
    }


}
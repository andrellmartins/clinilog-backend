package com.pucpr.backend.resource.controller;


import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.resource.service.ProductService;
import com.pucpr.backend.model.tables.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<Product> savedProduct = productService.save(product) ;
        if(!savedProduct.isPresent()){
            throw new Error("Produto não cadastrado!");
        }
        return ResponseEntity.ok().body(savedProduct.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        Optional<Product> pSearch = productService.findById(id);
        if(pSearch.isPresent()){
            Product p = pSearch.get();
            p.setDeletado(true);
            productService.save(p);
            return ResponseEntity.ok().body(true);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
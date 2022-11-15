package com.pucpr.backend.resource.controller;


import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.model.tables.User;
import com.pucpr.backend.resource.service.ProductService;
import com.pucpr.backend.model.tables.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(
        value = "Produtos",
        description = "Gerenciar os dados dos produtos no sistema.",
        tags = "Produtos"
)
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Consulta produto pelo id do produto no sistema ",
            tags = {"Produtos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Product.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Product> getById(@PathVariable long id) {

        try {
            return ResponseEntity.ok(productService.consultaPorId(id));
        }catch( Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    @ApiOperation(
            value = "Consulta todos os produtos no sistema ",
            tags = {"Produtos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Product[].class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<List<Product>> getAll() {
        try {
            return ResponseEntity.ok(productService.findAll());
        }catch( Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation(
            value = "Salva um novo produto ou altera um produto existente.",
            tags = {"Produtos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Product.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Product> save(
            @RequestBody Product product) {
        try {
            Optional<Product> savedProduct = productService.save(product);
            if (!savedProduct.isPresent()) {
                throw new Error("Produto não cadastrado!");
            }
            return ResponseEntity.ok().body(savedProduct.get());
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deleta um produto pelo id do produto no sistema",
            tags = {"Produtos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Boolean.class),
            @ApiResponse( code = 400, message= "Produto não encontrado no sistema", response = ResponseEntity.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {
            Product pSearch = productService.consultaPorId(id);
            if (pSearch != null) {
                pSearch.setDeletado(true);
                productService.save(pSearch);
                return ResponseEntity.ok().body(true);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
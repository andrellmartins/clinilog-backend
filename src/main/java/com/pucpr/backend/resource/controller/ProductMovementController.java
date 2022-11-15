package com.pucpr.backend.resource.controller;


import com.pucpr.backend.model.DTO.ReportProductMovementDTO;
import com.pucpr.backend.model.tables.Product;
import com.pucpr.backend.model.tables.ProductMovement;
import com.pucpr.backend.model.tables.User;
import com.pucpr.backend.resource.service.ProductMovementService;
import com.pucpr.backend.resource.service.ProductService;
import com.sun.istack.Nullable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(
        value = "Movimentação de Produtos",
        description = "Gerenciar os dados das movimentações de produtos no sistema.",
        tags = "Movimentação de Produtos"
)
@RequestMapping("/product-movement")
public class ProductMovementController {

    @Autowired
    private ProductMovementService productMovementService;

    @PostMapping("/chart-data")
    @ApiOperation(
            value = "Consultar todas as movimentações de produto a partir de um filtro de entrada.",
            tags = {"Movimentação de Produtos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = ProductMovement[].class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<List<ProductMovement>> chartMovimentacao(
            @RequestBody @Valid ReportProductMovementDTO reportProductMovementDTO
    ){
        try{
            List<ProductMovement> productMovements = productMovementService.filterReportProductMovement(reportProductMovementDTO);
            return ResponseEntity.ok(productMovements);
        }catch(Exception e){
            e.printStackTrace();
            throw new Error("Erro ao consultar dados do relatório",e);
        }
    }


}
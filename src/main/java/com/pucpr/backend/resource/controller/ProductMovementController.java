package com.pucpr.backend.resource.controller;


import com.pucpr.backend.model.DTO.ReportProductMovementDTO;
import com.pucpr.backend.model.tables.Product;
import com.pucpr.backend.model.tables.ProductMovement;
import com.pucpr.backend.resource.service.ProductMovementService;
import com.pucpr.backend.resource.service.ProductService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-movement")
public class ProductMovementController {

    @Autowired
    private ProductMovementService productMovementService;
    @PostMapping("/chart-data")
    public ResponseEntity<?> chartMovimentacao(
            @RequestBody @Valid ReportProductMovementDTO reportProductMovementDTO
    ){
        try{
            List<ProductMovement> productMovements = productMovementService.filterReportProductMovement(reportProductMovementDTO);
            if(productMovements == null || productMovements.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(productMovements);
        }catch(Exception e){
            e.printStackTrace();
            throw new Error("Erro ao consultar dados do relatório",e);
        }
    }


}
package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.response.ResponseBatch;
import com.pucpr.backend.model.response.ResponseBatchError;
import com.pucpr.backend.model.response.ResponseBatchSuccess;
import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.model.tables.User;
import com.pucpr.backend.resource.service.BatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(
        value = "Lote",
        description = "Gerenciar os dados lotes dos produtos no sistema.",
        tags = "Lote"
)
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;


    @PostMapping("/")
    @ApiOperation(
            value = "Salvar um Lote no Sistema",
            tags = {"Lote"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Batch.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Batch> save(
            @RequestBody Batch batch) {
        try{
            batchService.save(batch) ;
            return ResponseEntity.ok().body(batch);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

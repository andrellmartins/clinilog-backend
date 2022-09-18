package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.response.ResponseBatch;
import com.pucpr.backend.model.response.ResponseBatchError;
import com.pucpr.backend.model.response.ResponseBatchSuccess;
import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.resource.service.BatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping(value = "/")
    @ApiResponses(value={
        @ApiResponse(code = 200, message="Sucesso", response = ResponseBatchSuccess.class),
        @ApiResponse(code = 500, message="Erro", response = ResponseBatchError.class)
    })
    public ResponseEntity<ResponseBatch> getAll() {
        try{
            ResponseBatchSuccess responseBatch = new ResponseBatchSuccess();
            responseBatch.batches = batchService.findAll();
            if(responseBatch.batches == null || responseBatch.batches.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(responseBatch);
        }catch(Exception e){
            ResponseBatchError responseBatch = new ResponseBatchError();
            responseBatch.exception = e;
            return new ResponseEntity<>(responseBatch,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return batchService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Batch> save(
            @RequestBody Batch batch) {
        batchService.save(batch) ;
        return ResponseEntity.ok().body(batch);
    }

    @PutMapping("/")
    public ResponseEntity<Batch> update(
            @RequestBody Batch batch) {
        batchService.save(batch);
        return ResponseEntity.ok().body(batch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        batchService.deleteById(id);
        return ResponseEntity.ok().body("Batch " + id + " excluded");
    }
}

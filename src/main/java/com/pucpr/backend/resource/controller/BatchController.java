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


    @PostMapping("/")
    public ResponseEntity<Batch> save(
            @RequestBody Batch batch) {
        batchService.save(batch) ;
        return ResponseEntity.ok().body(batch);
    }

}

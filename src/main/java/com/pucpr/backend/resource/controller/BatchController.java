package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.resource.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return batchService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Batch> getAll() {
        return batchService.findAll();
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

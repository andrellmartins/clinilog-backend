package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Pharma;
import com.pucpr.backend.resource.service.PharmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pharma")
public class PharmaController {

    @Autowired
    private PharmaService pharmaService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return pharmaService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Pharma> getAll() {
        return pharmaService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Pharma> save(
            @RequestBody Pharma pharma) {
        pharmaService.save(pharma) ;
        return ResponseEntity.ok().body(pharma);
    }

    @PutMapping("/")
    public ResponseEntity<Pharma> update(
            @RequestBody Pharma pharma) {
        pharmaService.save(pharma);
        return ResponseEntity.ok().body(pharma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        pharmaService.deleteById(id);
        return ResponseEntity.ok().body("Pharma " + id + " excluded");
    }
}

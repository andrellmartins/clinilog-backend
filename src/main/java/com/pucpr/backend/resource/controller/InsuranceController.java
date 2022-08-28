package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Insurance;
import com.pucpr.backend.resource.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return insuranceService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Insurance> getAll() {
        return insuranceService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Insurance> save(
            @RequestBody Insurance insurance) {
        insuranceService.save(insurance) ;
        return ResponseEntity.ok().body(insurance);
    }

    @PutMapping("/")
    public ResponseEntity<Insurance> update(
            @RequestBody Insurance insurance) {
        insuranceService.save(insurance);
        return ResponseEntity.ok().body(insurance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        insuranceService.deleteById(id);
        return ResponseEntity.ok().body("Insurance " + id + " excluded");
    }
}


package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Medicine;
import com.pucpr.backend.resource.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return medicineService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Medicine> getAll() {
        return medicineService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Medicine> save(
            @RequestBody Medicine medicine) {
        medicineService.save(medicine) ;
        return ResponseEntity.ok().body(medicine);
    }

    @PutMapping("/")
    public ResponseEntity<Medicine> update(
            @RequestBody Medicine medicine) {
        medicineService.save(medicine);
        return ResponseEntity.ok().body(medicine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        medicineService.deleteById(id);
        return ResponseEntity.ok().body("Medicine " + id + " excluded");
    }
}

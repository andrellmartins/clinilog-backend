package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Patient;
import com.pucpr.backend.resource.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return patientService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Patient> getAll() {
        return patientService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Patient> save(
            @RequestBody Patient Patient) {
        patientService.save(Patient) ;
        return ResponseEntity.ok().body(Patient);
    }

    @PutMapping("/")
    public ResponseEntity<Patient> update(
            @RequestBody Patient Patient) {
        patientService.save(Patient);
        return ResponseEntity.ok().body(Patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        patientService.deleteById(id);
        return ResponseEntity.ok().body("Patient " + id + " excluded");
    }
}

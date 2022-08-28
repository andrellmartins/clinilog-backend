package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Doctor;
import com.pucpr.backend.resource.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return doctorService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Doctor> getAll() {
        return doctorService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Doctor> save(
            @RequestBody Doctor doctor) {
        doctorService.save(doctor) ;
        return ResponseEntity.ok().body(doctor);
    }

    @PutMapping("/")
    public ResponseEntity<Doctor> update(
            @RequestBody Doctor doctor) {
        doctorService.save(doctor);
        return ResponseEntity.ok().body(doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        doctorService.deleteById(id);
        return ResponseEntity.ok().body("Doctor " + id + " excluded");
    }
}

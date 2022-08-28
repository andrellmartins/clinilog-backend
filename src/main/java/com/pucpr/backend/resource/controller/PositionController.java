package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Position;
import com.pucpr.backend.resource.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return positionService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Position> getAll() {
        return positionService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Position> save(
            @RequestBody Position position) {
        positionService.save(position) ;
        return ResponseEntity.ok().body(position);
    }

    @PutMapping("/")
    public ResponseEntity<Position> update(
            @RequestBody Position position) {
        positionService.save(position);
        return ResponseEntity.ok().body(position);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        positionService.deleteById(id);
        return ResponseEntity.ok().body("Position " + id + " excluded");
    }
}

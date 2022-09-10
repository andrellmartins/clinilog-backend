package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Position;
import com.pucpr.backend.resource.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return positionService.findById(id);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Position>> getAll() {
        List<Position> positionsList = positionService.findAll();
        if(positionsList == null || positionsList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(positionsList);
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

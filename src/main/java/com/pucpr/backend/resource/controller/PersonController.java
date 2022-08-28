package com.pucpr.backend.resource.controller;


import com.pucpr.backend.resource.service.PersonService;
import com.pucpr.backend.model.tables.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Person> getAll() {
        return personService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Person> save(
            @RequestBody Person person) {
        personService.save(person) ;
        return ResponseEntity.ok().body(person);
    }

    @PutMapping("/")
    public ResponseEntity<Person> update(
            @RequestBody Person person) {
        personService.save(person);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        personService.deleteById(id);
        return ResponseEntity.ok().body("Person " + id + " excluded");
    }
}

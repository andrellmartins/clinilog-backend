package com.pucpr.backend.controller.resource;


import com.pucpr.backend.controller.service.PersonService;
import com.pucpr.backend.controller.service.ProductService;
import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.model.tables.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Object getPersonById(@PathVariable long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Person> getAllPerson() {
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

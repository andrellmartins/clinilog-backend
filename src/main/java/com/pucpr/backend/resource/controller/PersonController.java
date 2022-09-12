package com.pucpr.backend.resource.controller;


import com.pucpr.backend.model.DTO.CadastroUsuarioDTO;
import com.pucpr.backend.resource.service.PersonService;
import com.pucpr.backend.model.tables.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getById(@PathVariable long id) {
        Optional<Person> person = personService.findById(id);
        if(person.isPresent()){
            return ResponseEntity.ok(person.get());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        Optional<Person> pSearch = personService.findById(id);
        if(pSearch.isPresent()){
            Person p = pSearch.get();
            p.setDeletado(true);
            personService.save(p);
            return ResponseEntity.ok().body(true);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

package com.pucpr.backend.resource.controller;


import com.pucpr.backend.model.tables.User;
import com.pucpr.backend.resource.service.PersonService;
import com.pucpr.backend.model.tables.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@Api(
        value = "Pessoa",
        description = "Gerenciar os dados das pessoas no sistema.",
        tags = "Pessoa"
)
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Consultar pessoa pelo número do ID da pessoa",
            tags = {"Pessoa"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Person.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Person> getById(@PathVariable long id) {
        try{
            Optional<Person> person = personService.findById(id);
            if(person.isPresent()){
                return ResponseEntity.ok(person.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    @ApiOperation(
            value = "Consultar todas as pessoas no sistema",
            tags = {"Pessoa"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Person[].class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<List<Person>> getAll() {
        try{
            return ResponseEntity.ok(personService.findAll());
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/")
    @ApiOperation(
            value = "Salvar uma nova pessoa ou alterar uma pessoa existente no sistema",
            tags = {"Pessoa"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Person.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Person> save(
            @RequestBody Person person) {
        try {
            personService.save(person);
            return ResponseEntity.ok().body(person);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation(
            value = "Alterar pessoa já existente no sistema",
            tags = {"Pessoa"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Person.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Person> update(
            @RequestBody Person person) {
        try{
            personService.save(person);
            return ResponseEntity.ok().body(person);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Remover uma pessoa do sistema pelo id da pessoa no sistema",
            tags = {"Pessoa"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Boolean.class),
            @ApiResponse( code = 400, message= "Pessoa não encontrada no sistema", response = ResponseEntity.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try{
            Optional<Person> pSearch = personService.findById(id);
            if(pSearch.isPresent()){
                Person p = pSearch.get();
                p.setDeletado(true);
                personService.save(p);
                return ResponseEntity.ok().body(true);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

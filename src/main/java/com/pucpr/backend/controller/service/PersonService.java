package com.pucpr.backend.controller.service;


import com.pucpr.backend.model.repository.PersonRepository;
import com.pucpr.backend.model.tables.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService
        implements CrudInterface<Person>{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> save(Person entity) {
        return Optional.of(personRepository.save(entity));
    }

    @Override
    public Optional<Person> findById(long id) {
        return Optional.of(personRepository.findById(id));
    }

    @Override
    public void delete(Person entity) {
        personRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        personRepository.deleteById(id);
    }

    @Override
    public long count() {
        return personRepository.count();
    }
}

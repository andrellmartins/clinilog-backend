package com.pucpr.backend.resource.service;


import com.pucpr.backend.model.repository.PersonRepository;
import com.pucpr.backend.model.tables.Doctor;
import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.model.tables.Pharma;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService
        implements CrudInterface<Person> {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PharmaService pharmaService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> save(Person entity) {
        if(entity.getUsuario() != null){
            entity.getUsuario().setPassword(bCryptPasswordEncoder.encode(entity.getUsuario().getPassword()));
        }
        try {
            return Optional.of(personRepository.save(entity));
        }catch(ConstraintViolationException e){
            throw new Error(e.getErrorCode() + e.getMessage());
        }
    }

    @Override
    public Optional<Person> findById(long id) {
        Person p = personRepository.findById(id);
        return Optional.of(p);
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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Person findByUserLogin(String login) {
        return this.personRepository.findByLogin(login);
    }
}

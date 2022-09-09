package com.pucpr.backend.resource.service;


import com.pucpr.backend.model.DTO.CadastroUsuarioDTO;
import com.pucpr.backend.model.repository.PersonRepository;
import com.pucpr.backend.model.tables.Doctor;
import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.model.tables.Pharma;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    public void cadastrarUsuario(CadastroUsuarioDTO usuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            /*
            * Tabelas:
            *   Pessoa
            *   Usuario
            *   Funcionario
            *   Paciente
            *   Médico
            *   Farmaceutico
            * */
            this.save( usuario.getEmployee().getPessoa() );
            userService.save(usuario.getUser());
            if(usuario.getEmployee() != null){
                employeeService.save(usuario.getEmployee());
                if(usuario.getEmployee().getMedico() != null) {
                    Doctor doctor = usuario.getEmployee().getMedico();
                    doctor.setFunc(usuario.getEmployee());
                    doctorService.save(doctor);
                }
                if(usuario.getEmployee().getFarma() != null) {
                    Pharma pharma = usuario.getEmployee().getFarma();
                    pharma.setFunc(usuario.getEmployee());
                    pharmaService.save(pharma);
                }
            }
            if(usuario.getPatient() != null) {
                patientService.save(usuario.getPatient());
            }
        }catch(Error e){
            transaction.rollback();
        }
        transaction.commit();
    }
}

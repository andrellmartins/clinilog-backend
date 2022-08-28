package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.PatientRepository;
import com.pucpr.backend.model.tables.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService
        implements CrudInterface<Patient>{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> save(Patient entity) {
        return Optional.of(patientRepository.save(entity));
    }

    @Override
    public Optional<Patient> findById(long id) {
        return Optional.of(patientRepository.findById(id));
    }

    @Override
    public void delete(Patient entity) {
        patientRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public long count() {
        return patientRepository.count();
    }
}

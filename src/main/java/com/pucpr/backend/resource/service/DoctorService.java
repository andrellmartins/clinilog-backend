package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.DoctorRepository;
import com.pucpr.backend.model.tables.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService
        implements CrudInterface<Doctor>{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> save(Doctor entity) {
        return Optional.of(doctorRepository.save(entity));
    }

    @Override
    public Optional<Doctor> findById(long id) {
        return Optional.of(doctorRepository.findById(id));
    }

    @Override
    public void delete(Doctor entity) {
        doctorRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public long count() {
        return doctorRepository.count();
    }
}

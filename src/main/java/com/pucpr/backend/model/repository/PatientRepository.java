package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public Patient findById(long id);

    public List<Patient> findAll();

    public Patient deleteById(long id);
}

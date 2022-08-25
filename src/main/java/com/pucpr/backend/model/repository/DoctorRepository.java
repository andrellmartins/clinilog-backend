package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    public Doctor findById(long id);

    public List<Doctor> findAll();

    public Doctor deleteById(long id);

}

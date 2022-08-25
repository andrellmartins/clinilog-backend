package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    public Insurance findById(long id);

    public List<Insurance> findAll();

    public Insurance deleteById(long id);
}

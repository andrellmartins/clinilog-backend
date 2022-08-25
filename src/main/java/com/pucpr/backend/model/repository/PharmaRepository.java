package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Pharma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmaRepository extends JpaRepository<Pharma, Long> {

    public Pharma findById(long id);

    public List<Pharma> findAll();

    public Pharma deleteById(long id);
}

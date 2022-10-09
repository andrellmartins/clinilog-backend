package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    public Batch findById(long id);

    public List<Batch> findAll();

    public Batch deleteById(long id);

}

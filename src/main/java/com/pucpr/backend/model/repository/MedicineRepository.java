package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    public Medicine findById(long id);

    public List<Medicine> findAll();

    public Medicine deleteById(long id);
}

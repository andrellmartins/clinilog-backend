package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Position;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    public Position findById(long id);

    @Query(value ="SELECT DISTINCT p FROM Position p")
    public List<Position> findAll();

    public Position deleteById(long id);
}

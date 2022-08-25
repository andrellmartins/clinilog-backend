package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    public Position findById(long id);

    public List<Position> findAll();

    public Position deleteById(long id);
}

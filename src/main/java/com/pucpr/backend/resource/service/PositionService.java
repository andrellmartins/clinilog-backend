package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.PositionRepository;
import com.pucpr.backend.model.tables.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService
        implements CrudInterface<Position>{

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> save(Position entity) {
        return Optional.of(positionRepository.save(entity));
    }

    @Override
    public Optional<Position> findById(long id) {
        return Optional.of(positionRepository.findById(id));
    }

    @Override
    public void delete(Position entity) {
        positionRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public long count() {
        return positionRepository.count();
    }
}

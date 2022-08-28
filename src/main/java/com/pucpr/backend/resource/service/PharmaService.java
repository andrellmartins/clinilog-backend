package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.PharmaRepository;
import com.pucpr.backend.model.tables.Pharma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PharmaService implements CrudInterface<Pharma>{

    @Autowired
    private PharmaRepository pharmaRepository;

    @Override
    public List<Pharma> findAll() {
        return pharmaRepository.findAll();
    }

    @Override
    public Optional<Pharma> save(Pharma entity) {
        return Optional.of(pharmaRepository.save(entity));
    }

    @Override
    public Optional<Pharma> findById(long id) {
        return Optional.of(pharmaRepository.findById(id));
    }

    @Override
    public void delete(Pharma entity) {
        pharmaRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        pharmaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return pharmaRepository.count();
    }
}

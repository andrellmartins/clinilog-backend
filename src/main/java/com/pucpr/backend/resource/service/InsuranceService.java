package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.InsuranceRepository;
import com.pucpr.backend.model.tables.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService
        implements CrudInterface<Insurance>{

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> findAll() {
        return insuranceRepository.findAll();
    }

    @Override
    public Optional<Insurance> save(Insurance entity) {
        return Optional.of(insuranceRepository.save(entity));
    }

    @Override
    public Optional<Insurance> findById(long id) {
        return Optional.of(insuranceRepository.findById(id));
    }

    @Override
    public void delete(Insurance entity) {
        insuranceRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        insuranceRepository.deleteById(id);
    }

    @Override
    public long count() {
        return insuranceRepository.count();
    }
}

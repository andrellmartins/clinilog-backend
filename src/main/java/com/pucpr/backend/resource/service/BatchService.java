package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.BatchRepository;
import com.pucpr.backend.model.tables.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BatchService
        implements CrudInterface<Batch>{

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public List<Batch> findAll() {
        return batchRepository.findAll();
    }

    @Override
    public Optional<Batch> save(Batch entity) {
        return Optional.of(batchRepository.save(entity));
    }

    @Override
    public Optional<Batch> findById(long id) {
        return Optional.of(batchRepository.findById(id));
    }

    @Override
    public void delete(Batch entity) {
        batchRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        batchRepository.deleteById(id);
    }

    @Override
    public long count() {
        return batchRepository.count();
    }
}

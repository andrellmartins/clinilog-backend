package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.MedicineRepository;
import com.pucpr.backend.model.tables.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService
        implements CrudInterface<Medicine>{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> save(Medicine entity) {
        return Optional.of(medicineRepository.save(entity));
    }

    @Override
    public Optional<Medicine> findById(long id) {
        return Optional.of(medicineRepository.findById(id));
    }

    @Override
    public void delete(Medicine entity) {
        medicineRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public long count() {
        return medicineRepository.count();
    }
}

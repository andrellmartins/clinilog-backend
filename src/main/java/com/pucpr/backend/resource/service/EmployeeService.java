package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.repository.EmployeeRepository;
import com.pucpr.backend.model.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
    implements CrudInterface<Employee>{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> save(Employee entity) {
        return Optional.of(employeeRepository.save(entity));
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.of(employeeRepository.findById(id));
    }

    @Override
    public void delete(Employee entity) {
        employeeRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

}

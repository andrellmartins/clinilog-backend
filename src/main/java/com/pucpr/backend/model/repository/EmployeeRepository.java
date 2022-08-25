package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findById(long id);

    public List<Employee> findAll();

    public Employee deleteById(long id);


}

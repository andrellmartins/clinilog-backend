package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findById(long id);

    public List<Employee> findAll();

    public Employee deleteById(long id);

    @Query(value =
        "SELECT e from Employee e where :idCargo is not null and e.cargo.id = :idCargo"
    )
    List<Employee> findByCargoId(
        @Param("idCargo") Long idCargo
    );
}

package com.pucpr.backend.model.DTO;

import com.pucpr.backend.model.tables.Employee;
import com.pucpr.backend.model.tables.Patient;
import com.pucpr.backend.model.tables.User;

public class CadastroUsuarioDTO {
    User user;
    Employee employee;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    Patient patient;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}



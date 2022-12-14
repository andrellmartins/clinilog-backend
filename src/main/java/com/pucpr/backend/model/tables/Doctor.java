package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name="Medico",
    uniqueConstraints = {
        @UniqueConstraint(name="DOCTOR_UNIQUE_CRM_UF", columnNames = {"crm","crm_uf"}),
        @UniqueConstraint(name="DOCTOR_UNIQUE_ID_PESSOA", columnNames = {"id_employee"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private int crm;
    @NotNull
    @NotEmpty
    private String crm_uf;
    @OneToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    @JsonBackReference("EmployeeDoctor(func)")
    @NotNull
    @NotEmpty
    private Employee func;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getCrm_uf() {
        return crm_uf;
    }

    public void setCrm_uf(String crm_uf) {
        this.crm_uf = crm_uf;
    }

    public Employee getFunc() {
        return func;
    }

    public void setFunc(Employee func) {
        this.func = func;
    }


}

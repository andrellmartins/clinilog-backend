package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(
    name="Medico",
    uniqueConstraints = {
        @UniqueConstraint(name="DOCTOR_UNIQUE_CRM_UF", columnNames = {"crm","crm_uf"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int crm;
    private String crm_uf;
    @OneToOne
    @JoinColumn(name = "id_employee")
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

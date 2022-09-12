package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.Constraint;

@Entity
@Table(
    name="Farmaceutico",
    uniqueConstraints = {
            @UniqueConstraint(name="PHARMA_UNIQUE_CRF_UF",columnNames = {"crf","crf_uf"}),
            @UniqueConstraint(name="PHARMA_UNIQUE_ID_EMPLOYEE",columnNames = {"id_employee"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Pharma  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int crf;
    private String crf_uf;
    @OneToOne
    @JoinColumn(name="id_employee", referencedColumnName = "id")
    @JsonBackReference("EmployeePharma(func)")
    private Employee func;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCrf() {
        return crf;
    }

    public void setCrf(int crf) {
        this.crf = crf;
    }

    public String getCrf_uf() {
        return crf_uf;
    }

    public void setCrf_uf(String crf_uf) {
        this.crf_uf = crf_uf;
    }

    public Employee getFunc() {
        return func;
    }

    public void setFunc(Employee func) {
        this.func = func;
    }


}

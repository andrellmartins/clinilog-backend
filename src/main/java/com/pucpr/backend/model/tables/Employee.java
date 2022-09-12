package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jdk.nashorn.internal.codegen.ObjectClassGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name="Funcionario",
        uniqueConstraints = {
            @UniqueConstraint(name="EMPLOYEE_UNIQUE_PIS", columnNames = {"pis"}),
            @UniqueConstraint(name="EMPLOYEE_UNIQUE_ID_PESSOA", columnNames = {"id_pessoa"})
        }
)
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pis;
    private float salario;

    @OneToOne
    @JoinColumn(name="id_pessoa")
    @JsonBackReference("PessoaEmployee(id_pessoa)")
    private Person pessoa;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="id_position")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property  = "cargo",
            scope     = Position.class
    )
    private Position cargo;

    @OneToOne(mappedBy = "func", cascade = CascadeType.ALL)
    @JsonManagedReference("EmployeeDoctor(func)")
    private Doctor medico;

    @OneToOne(mappedBy = "func", cascade = CascadeType.ALL)
    @JsonManagedReference("EmployeePharma(func)")
    private Pharma farma;

    @OneToMany(mappedBy = "func")
    @JsonBackReference("EmployeeProduct(func)")
    private List<Product> product;

    @PrePersist
    protected void prePersistConfigChild(){
        if(this.medico != null)
            this.medico.setFunc(this);
        if(this.farma != null)
            this.farma.setFunc(this);
    }

    public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Position getCargo() {
        return cargo;
    }

    public void setCargo(Position cargo) {
        this.cargo = cargo;
    }

    public Doctor getMedico() {
        return medico;
    }

    public void setMedico(Doctor medico) {
        this.medico = medico;
    }

    public Pharma getFarma() {
        return farma;
    }

    public void setFarma(Pharma farma) {
        this.farma = farma;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}

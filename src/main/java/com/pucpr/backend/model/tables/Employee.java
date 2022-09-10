package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name="Funcionario",
        uniqueConstraints = {
                @UniqueConstraint(name="EMPLOYEE_UNIQUE_PIS", columnNames = {"pis"})
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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name="id_position")
    @JsonBackReference("PositionEmployee(id_position)")
    private Position cargo;

    @OneToOne(mappedBy = "func", cascade = CascadeType.ALL)
    @JsonBackReference("EmployeeDoctor(func)")
    private Doctor medico;

    @OneToOne(mappedBy = "func", cascade = CascadeType.ALL)
    @JsonBackReference("EmployeePharma(func)")
    private Pharma farma;

    @OneToMany(mappedBy = "func")
    @JsonManagedReference("EmployeeProduct(func)")
    private List<Product> product;

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

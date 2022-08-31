package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pis;
    private float salario;
    @OneToOne
    private Person pessoa;
    @OneToOne(mappedBy = "func")
    private Position cargo;
    @OneToOne(mappedBy = "func")
    private Doctor medico;
    @OneToOne(mappedBy = "func")
    private Pharma farma;


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

    public int getPis() {
        return pis;
    }

    public void setPis(int pis) {
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


}

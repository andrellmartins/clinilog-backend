package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Entity
@Table(name="Pessoa")
@EntityListeners(AuditingEntityListener.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int cpf;
    private String ender;
    private int cep;
    private String data_nasc;
    private String sexo;
    private boolean deletado;
    @OneToOne(mappedBy = "pessoa")
    private Employee employee;
    @OneToOne(mappedBy = "pessoa")
    private Patient paciente;
    @OneToOne(mappedBy = "pessoa")
    private User usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String birth_date) {
        this.data_nasc = birth_date;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sex) {
        this.sexo = sex;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deleted) {
        this.deletado = deleted;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }


}

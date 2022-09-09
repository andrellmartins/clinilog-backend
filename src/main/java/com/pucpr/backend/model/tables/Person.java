package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(
    name="Pessoa",
    uniqueConstraints = {
            @UniqueConstraint(name="PERSON_UNIQUE_CPF", columnNames = {"cpf"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String ender;
    private String cep;
    private Date data_nasc;
    private String sexo;
    private boolean deletado;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Employee employee;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Patient paciente;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date birth_date) {
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

package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty
    @NotNull
    private String nome;
    @NotEmpty
    @NotNull
    private String cpf;
    @NotEmpty
    @NotNull
    private String ender;
    @NotEmpty
    @NotNull
    private String cep;
    @NotEmpty
    @NotNull
    private Date data_nasc;
    @NotEmpty
    @NotNull
    private String sexo;

    private boolean deletado;

    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference("PessoaEmployee(id_pessoa)")
    private Employee employee;

    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference("PersonPatient(id_pessoa)")
    private Patient paciente;

    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference("PersonUser(id_pessoa)")
    private User usuario;

    @PrePersist
    protected void prePersistConfigChild(){
        if(this.employee != null){
            this.employee.setPessoa(this);
        }
        if(this.paciente != null){
            this.paciente.setPessoa(this);
        }
        if(this.usuario != null){
            this.usuario.setPessoa(this);
        }
    }

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

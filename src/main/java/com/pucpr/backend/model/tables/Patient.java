package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Paciente",
uniqueConstraints = {
        @UniqueConstraint(name="PATIENT_UNIQUE_ID_PESSOA", columnNames = {"id_pessoa"})
})
@EntityListeners(AuditingEntityListener.class)

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @JsonBackReference("PersonPatient(id_pessoa)")
    @NotEmpty
    @NotNull
    private Person pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_convenio", referencedColumnName = "id")
    @JsonBackReference("PatientInsurance(id_convenio)")
    @NotEmpty
    @NotNull
    private Insurance convenio;

    public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }

    public Insurance getConvenio() {
        return convenio;
    }

    public void setConvenio(Insurance convenio) {
        this.convenio = convenio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

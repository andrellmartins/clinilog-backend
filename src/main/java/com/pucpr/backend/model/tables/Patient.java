package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Entity
@Table(name="Paciente")
@EntityListeners(AuditingEntityListener.class)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    @JsonBackReference("PersonPatient(id_pessoa)")
    private Person pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_convenio")
    @JsonBackReference("PatientInsurance(id_convenio)")
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

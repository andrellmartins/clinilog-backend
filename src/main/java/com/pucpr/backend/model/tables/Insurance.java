package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String convenio;
    @OneToOne
    private Patient paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }
}

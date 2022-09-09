package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(
    name="Convenio",
    uniqueConstraints = {
            @UniqueConstraint(name="INSURANCE_UNIQUE_CONVENIO", columnNames = {"convenio"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String convenio;

    @OneToMany(mappedBy = "convenio")
    private List<Patient> pacientes;

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

    public List<Patient> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Patient> pacientes) {
        this.pacientes = pacientes;
    }
}

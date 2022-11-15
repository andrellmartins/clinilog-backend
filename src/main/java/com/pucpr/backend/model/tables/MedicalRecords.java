package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="MedicalRecords", uniqueConstraints = {
        @UniqueConstraint(name = "MEDICALRECORDS_PATIENT_UNIQUE", columnNames = {"id_patient"}),
})
@JsonIgnoreProperties(
    value = {"dtCreation", "dtUpdate"},
    allowGetters = true
)
public class MedicalRecords implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_patient", referencedColumnName = "id")
    @JsonBackReference("MedicalRecordsPatient(id_patient)")
    @NotEmpty
    @NotNull
    private Patient patient;

    @OneToMany(mappedBy = "medicalRecord", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JsonManagedReference("MedicalRecordsRecords(id_record)")
    private List<Records> records;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Records> getRecords() {
        return records;
    }

    public void setRecords(List<Records> records) {
        this.records = records;
    }
}


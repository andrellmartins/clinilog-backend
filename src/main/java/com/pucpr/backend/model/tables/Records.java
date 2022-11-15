package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.*;
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
@Table(name="Records")
@EntityListeners(AuditingEntityListener.class)
public class Records implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_record", referencedColumnName = "id")
    @JsonBackReference("MedicalRecordsRecords(id_record)")
    @NotEmpty
    @NotNull
    private MedicalRecords medicalRecord;

    @ManyToOne
    @JoinColumn(name="id_recordType", referencedColumnName = "id")
    @JsonBackReference("RecordsTypeRecords(id_recordType)")
    @NotEmpty
    @NotNull
    private RecordType type;

    @OneToMany(mappedBy = "record", cascade = CascadeType.ALL)
    @JsonManagedReference("RecordsRecordsItems(id_record)")
    private List<RecordsItems> recordItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalRecords getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecords medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public List<RecordsItems> getRecordItems() {
        return recordItems;
    }

    public void setRecordItems(List<RecordsItems> recordItems) {
        this.recordItems = recordItems;
    }
}


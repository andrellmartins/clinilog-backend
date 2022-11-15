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
@Table(name="RecordItems")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dtCreation", "dtUpdate"},
        allowGetters = true)

public class RecordsItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="id_produto")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property  = "product",
            scope     = Product.class
    )
    @NotEmpty
    @NotNull
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="id_record")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property  = "recordItems",
            scope     = RecordsItems[].class
    )
    @NotEmpty
    @NotNull
    private Records record;

    @ManyToOne
    @JoinColumn(name="id_recordType", referencedColumnName = "id")
    @JsonBackReference("RecordsTypeRecords(id_recordType)")
    @NotEmpty
    @NotNull
    private RecordType type;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Records getRecord() {
        return record;
    }

    public void setRecord(Records record) {
        this.record = record;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }
}
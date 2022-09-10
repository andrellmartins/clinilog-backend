package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
    name="Cargo",
    uniqueConstraints = {
            @UniqueConstraint(name="POSITION_UNIQUE_CARGO", columnNames = {"cargo"})
    }
)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"func"})
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cargo;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
    @JsonManagedReference("PositionEmployee(id_position)")
    private List<Employee> func;

    public List<Employee> getFunc() {
        return func;
    }

    public void setFunc(List<Employee> func) {
        this.func = func;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}

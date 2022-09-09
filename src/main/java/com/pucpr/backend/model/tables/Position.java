package com.pucpr.backend.model.tables;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(
    name="Cargo",
    uniqueConstraints = {
            @UniqueConstraint(name="POSITION_UNIQUE_CARGO", columnNames = {"cargo"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cargo;

    @OneToMany(mappedBy = "cargo")
    private List<Employee> func;

    public List<Employee> getEmployee() {
        return func;
    }

    public void setEmployee(List<Employee> func) {
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

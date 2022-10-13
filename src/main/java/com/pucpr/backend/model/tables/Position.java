package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
    @NotEmpty
    @NotNull
    private String cargo;
    @NotNull
    private boolean acesso_modulo_estoque = false;
    @NotNull
    private boolean acesso_modulo_pessoas = false;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property  = "cargo",
            scope     = Employee[].class
    )
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

    public boolean isAcesso_modulo_estoque() {
        return acesso_modulo_estoque;
    }

    public void setAcesso_modulo_estoque(boolean acesso_modulo_estoque) {
        this.acesso_modulo_estoque = acesso_modulo_estoque;
    }

    public boolean isAcesso_modulo_pessoas() {
        return acesso_modulo_pessoas;
    }

    public void setAcesso_modulo_pessoas(boolean acesso_modulo_pessoas) {
        this.acesso_modulo_pessoas = acesso_modulo_pessoas;
    }
}

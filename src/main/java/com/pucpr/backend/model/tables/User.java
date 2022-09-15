package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name="User", uniqueConstraints = {
        @UniqueConstraint(name = "USER_UNIQUE_LOGIN", columnNames = {"login"}),
        @UniqueConstraint(name = "USER_UNIQUE_ID_PESSOA", columnNames = {"id_pessoa"})
})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dtCreation", "dtUpdate"},
        allowGetters = true)

public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotNull
    private String login;
    @NotEmpty
    @NotNull
    private String password;
    @NotEmpty
    @NotNull
    private String firstName;
    @NotEmpty
    @NotNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @NotEmpty
    @NotNull
    private Date dtCreation = new Date();

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @NotEmpty
    @NotNull
    private Date dtUpdate = new Date();

    @OneToOne
    @JoinColumn(name="id_pessoa", referencedColumnName = "id")
    @JsonBackReference("PersonUser(id_pessoa)")
    @NotEmpty
    @NotNull
    private Person pessoa;

    public User() {
    }
    /*
     * INÍCIO OVERRIDE USER_DETAILS
     * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.login != null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.login != null;
    }

    /*
    * FIM OVERRIDE USER_DETAILS
    * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDtCreation() {
        return dtCreation;
    }

    public void setDtCreation(Date dtCreation) {
        this.dtCreation = dtCreation;
    }

    public Date getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }
}
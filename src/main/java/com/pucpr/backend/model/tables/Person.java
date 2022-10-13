package com.pucpr.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pucpr.backend.model.DTO.UserAuthorityDTO;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(
    name="Pessoa",
    uniqueConstraints = {
            @UniqueConstraint(name="PERSON_UNIQUE_CPF", columnNames = {"cpf"}),
            @UniqueConstraint(name="PERSON_UNIQUE_EMAIL", columnNames = {"email"})
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotNull
    private String nome;
    @NotEmpty
    @NotNull
    private String cpf;
    @NotEmpty
    @NotNull
    private String ender;
    @NotEmpty
    @NotNull
    private String cep;
    @NotEmpty
    @NotNull
    private Date data_nasc;
    @NotEmpty
    @NotNull
    private String sexo;
    @NotEmpty
    @NotNull
    private String email;

    private boolean deletado;

    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference("PessoaEmployee(id_pessoa)")
    private Employee employee;

    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference("PersonPatient(id_pessoa)")
    private Patient paciente;

    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    @JsonManagedReference("PersonUser(id_pessoa)")
    private User usuario;

    @PrePersist
    protected void prePersistConfigChild(){
        if(this.employee != null){
            this.employee.setPessoa(this);
        }
        if(this.paciente != null){
            this.paciente.setPessoa(this);
        }
        if(this.usuario != null){
            this.usuario.setPessoa(this);
        }
    }
    /*
     * INÍCIO OVERRIDE USER_DETAILS
     * */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> permissoes = new ArrayList<>();
        if(this.employee != null){
            if(this.employee.getCargo().isAcesso_modulo_estoque()){
                permissoes.add(new UserAuthorityDTO("estoque"));
            }
            if(this.employee.getCargo().isAcesso_modulo_pessoas()){
                permissoes.add(new UserAuthorityDTO("pessoas"));
            }
        }
        return permissoes;
    }

    @Override
    public String getUsername() {

        if(this.usuario != null){
            return this.usuario.getLogin();
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.usuario != null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.usuario != null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.usuario != null;
    }

    @Override
    public boolean isEnabled() {
        return this.usuario != null;
    }

    @Override
    public String getPassword() {
        if(this.usuario != null){
            return this.usuario.getPassword();
        }
        return null;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date birth_date) {
        this.data_nasc = birth_date;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sex) {
        this.sexo = sex;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deleted) {
        this.deletado = deleted;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

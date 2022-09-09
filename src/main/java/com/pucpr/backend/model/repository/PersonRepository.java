package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.DTO.CadastroUsuarioDTO;
import com.pucpr.backend.model.tables.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository
        extends JpaRepository<Person, Long> {

    public Person findById(long id);

    public List<Person> findAll();

    public Person deleteById(long id);


    @Query(value=" EXEC CADASTRARUSUARIODTO " +
            " @DTO = {{usuario}} ", nativeQuery = true)
    void cadastrarUsuario(@Param("usuario") CadastroUsuarioDTO usuario);
}

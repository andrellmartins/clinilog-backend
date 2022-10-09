package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.tables.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository
        extends JpaRepository<Person, Long> {

    @Query(value =
        "SELECT p FROM Person p WHERE p.id = :id AND p.deletado = false"
    )
    public Person findById(
        @Param("id") long id
    );

    @Query(value =
        "SELECT p FROM Person p WHERE p.deletado = false"
    )
    public List<Person> findAll();

    public Person save(Person person);

    @Query(value =
        "SELECT p FROM Person p WHERE p.usuario.login = :login"
    )
    Person findByLogin(@Param("login") String login);
}

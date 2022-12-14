package com.pucpr.backend.resource.service;


import antlr.BaseAST;
import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.model.tables.User;
import com.pucpr.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AliasFor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudInterface<User>, UserDetailsService  {

    private static UserService   userService;

    @Autowired
    private PersonService personService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public static UserService getUserService() {
        if(UserService.userService == null) {
            UserService.userService = new UserService();
        }
        return UserService.userService;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(User entity){
        if(entity.getId() == null){
            entity.setPassword(bCryptPasswordEncoder
                        .encode(entity.getPassword()));
        }

        return Optional.of(userRepository.save(entity));
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.findByUserLogin(username);
        if(person.getUsuario() == null && "admin".equals(username)){
            person = new Person();
            User adminUser = new User();
            adminUser.setLogin("admin");
            adminUser.setPassword(bCryptPasswordEncoder.encode("admin"));
            person.setUsuario(adminUser);
        }
        return person;
    }

    public User findByEmail(String email) {
        return this.userRepository.findByPersonEmail(email);
    }
}
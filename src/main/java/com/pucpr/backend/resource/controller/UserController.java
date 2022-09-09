package com.pucpr.backend.resource.controller;

import com.pucpr.backend.resource.service.UserService;
import com.pucpr.backend.model.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("")
    public ResponseEntity update(@Valid @RequestBody User user) {

        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
        return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }
}

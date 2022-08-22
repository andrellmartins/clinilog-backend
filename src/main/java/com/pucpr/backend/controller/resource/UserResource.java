package com.pucpr.backend.controller.resource;

import com.pucpr.backend.controller.service.UserService;
import com.pucpr.backend.model.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/user")
    public ResponseEntity update(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
        return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }
}

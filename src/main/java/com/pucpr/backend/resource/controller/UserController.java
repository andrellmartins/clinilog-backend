package com.pucpr.backend.resource.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pucpr.backend.config.MailSender;
import com.pucpr.backend.resource.service.UserService;
import com.pucpr.backend.model.tables.User;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private MailSender mailSender;

    public UserController(UserService userService){
        this.userService = userService;
        this.mailSender = new MailSender();
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

    @PutMapping("/recuperar-senha/{nrUser}")
    public ResponseEntity<?> recuperaSenha(
        @PathVariable("nrUser") Long nrUser,
        @Valid @RequestBody String newPassword
    ) {

        Optional<User> optionalUser = userService.findById(nrUser);
        if(!optionalUser.isPresent()){
            return new ResponseEntity<>("Usuário não encontrado.",HttpStatus.BAD_REQUEST);
        }
        //encriptografa a nova senha para validação.
        newPassword= bCryptPasswordEncoder.encode(newPassword);

        User user = optionalUser.get();
        user.setPassword(newPassword);
        userService.save(user);

        return ResponseEntity.ok(true);
    }

    @PostMapping("/recuperar-senha/email")
    public ResponseEntity<?> emailRecuperarSenha(
            @Valid @RequestBody String email
    ) {
        User user = userService.findByEmail(email);
        if(user == null){
            // return new ResponseEntity<>("Email não encontrado.",HttpStatus.BAD_REQUEST);
        }else{
            List<String> destinatarios = new ArrayList<>();
            destinatarios.add(email);
            try{
                mailSender.sendMail(
                    "Email de Recuperação de Senha",
                    String.format(
                        "<p>Foi solicitado a recuperação de senha pelo nosso site. Caso não tenha sido você, desconsidere essa mensagem. <p>"
                        +"<p>Para acessar a pagina de recuperação, favor acessar o link: <a href=\"http://localhost:4200/recuperacao-senha/%s\">http://localhost:4200/recuperacao-senha/%s</a></p>",
                        user.getId().toString(),
                        user.getId().toString()
                    ),
                    destinatarios
                );
            }catch(Exception e){
                return new ResponseEntity<>("Erro ao enviar Email. Erro:"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ResponseEntity.ok(true);
        }



        return ResponseEntity.ok(true);
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

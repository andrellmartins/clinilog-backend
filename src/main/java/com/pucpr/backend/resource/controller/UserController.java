package com.pucpr.backend.resource.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pucpr.backend.config.MailSender;
import com.pucpr.backend.resource.service.UserService;
import com.pucpr.backend.model.tables.User;
import io.swagger.annotations.*;
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
@Api(
    value = "Usuário",
    description = "Gerenciar os dados dos usuários do sistema.",
    tags = "Usuario"
)
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
    @ApiOperation(
            value = "Consultar todos os usuários do sistema",
            tags = {"Usuario"}
    )
    @ApiResponses(value = {
        @ApiResponse( code = 200, message= "Sucesso", response = User[].class),
        @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<List<User>> getUsers() {
        try{
            return ResponseEntity.ok(userService.findAll());
        }catch( Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    @ApiOperation(
            value = "Salvar o usuário, podendo ser usuário novo ou já existente.",
            tags = {"Usuario"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = User.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try{
            userService.save(user);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/recuperar-senha/{nrUser}")
    @ApiOperation(
            value = "Alterar a senha de um usuário existente.",
            tags = {"Usuario"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = User.class),
            @ApiResponse( code = 400, message= "Usuário não encontrado", response = ResponseEntity.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Boolean> recuperaSenha(
        @PathVariable("nrUser") Long nrUser,
        @Valid @RequestBody String newPassword
    ) {
        try{
            Optional<User> optionalUser = userService.findById(nrUser);
            if(!optionalUser.isPresent()){
                return new ResponseEntity("Usuário não encontrado.",HttpStatus.BAD_REQUEST);
            }
            //encriptografa a nova senha para validação.
            newPassword= bCryptPasswordEncoder.encode(newPassword);

            User user = optionalUser.get();
            user.setPassword(newPassword);
            userService.save(user);
            return ResponseEntity.ok(true);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        try{
            userService.save(user);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/recuperar-senha/email")
    @ApiOperation(
            value = "Recuperar a Senha de um Usuário a partir do Email cadastrado.",
            tags = {"Usuario"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = User.class),
            @ApiResponse( code = 400, message= "Usuário não encontrado", response = ResponseEntity.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Boolean> emailRecuperarSenha(
            @Valid @RequestBody String email
    ) {
        try {
            User user = userService.findByEmail(email);
            if (user == null) {
                return new ResponseEntity("Email não encontrado.", HttpStatus.BAD_REQUEST);
            } else {
                List<String> destinatarios = new ArrayList<>();
                destinatarios.add(email);
                try {
                    mailSender.sendMail(
                            "Email de Recuperação de Senha",
                            String.format(
                                    "<p>Foi solicitado a recuperação de senha pelo nosso site. Caso não tenha sido você, desconsidere essa mensagem. <p>"
                                            + "<p>Para acessar a pagina de recuperação, favor acessar o link: <a href=\"http://localhost:4200/recuperacao-senha/%s\">http://localhost:4200/recuperacao-senha/%s</a></p>",
                                    user.getId().toString(),
                                    user.getId().toString()
                            ),
                            destinatarios
                    );
                } catch (Exception e) {
                    return new ResponseEntity("Erro ao enviar Email. Erro:" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
                return ResponseEntity.ok(true);
            }
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("")
    @ApiOperation(
            value = "Deletar um usuário do sistema",
            tags = {"Usuario"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = User.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        try{
            userService.delete(user);
            return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletar um usuário a partir de um id de usuário.",
            tags = {"Usuario"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = User.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try{
            userService.deleteById(id);
            return ResponseEntity.ok().body("User excluded ID: " + id);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

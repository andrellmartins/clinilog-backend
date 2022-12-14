package com.pucpr.backend.resource.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ctc.wstx.shaded.msv.org_jp_gr_xml.dom.XMLMaker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pucpr.backend.config.MailSender;
import com.pucpr.backend.model.tables.Person;
import com.pucpr.backend.model.tables.User;
import io.swagger.annotations.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger.readers.operation.ResponseHeaders;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.parser.Entity;
import javax.websocket.server.PathParam;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.pucpr.backend.config.SecurityConstants.*;
import static com.pucpr.backend.config.SecurityConstants.SECRET;
@RestController
@Api(
        value = "Login",
        description = "Fazer Login no sistema e permitir acesso as outras atividades..",
        tags = "Login"
)
@RequestMapping(SIGN_UP_URL)
public class LoginController {

    private AuthenticationManager authenticationManager;

//    private MailSender mailSender;

    public LoginController(AuthenticationManager authenticationManager){
//        this.mailSender = new MailSender();
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("")
    @ApiOperation(
            value = "Fazer Login no sistema e retornar o token de acesso",
            tags = {"Login"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Person.class),
            @ApiResponse( code = 401, message= "Login mal sucedido", response = ResponseEntity.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<Person> login(
        @RequestBody User user
    ) {
        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    user.getLogin(),
                    user.getPassword(),
                    new ArrayList<>()
                )
            );


            if(auth.isAuthenticated()){
                Person currentUser = (Person) auth.getPrincipal();
                SecurityContextHolder.getContext().setAuthentication(auth);

                /* howtosendmail
                try {
                    List<String> emails = new ArrayList<String>();
                    emails.add("dudu020300@gmail.com");
                    // Set To: header field of the header.
                    mailSender.sendMail("<b>Voc??<b> <br/><br/><br/> logou no clinilog","Foi voc??, n??o ?",emails);
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
                */

                return ResponseEntity.ok()
                        .header(HEADER_STRING,TOKEN_PREFIX + generateJWTToken(currentUser))
                        .body(currentUser);
            }else{
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateJWTToken(Person user){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
    }

}

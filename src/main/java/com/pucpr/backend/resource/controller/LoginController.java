package com.pucpr.backend.resource.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ctc.wstx.shaded.msv.org_jp_gr_xml.dom.XMLMaker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pucpr.backend.model.tables.User;
import io.swagger.annotations.Authorization;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger.readers.operation.ResponseHeaders;

import javax.swing.text.html.parser.Entity;
import javax.websocket.server.PathParam;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.util.ArrayList;
import java.util.Date;

import static com.pucpr.backend.config.SecurityConstants.*;
import static com.pucpr.backend.config.SecurityConstants.SECRET;

@Controller
@RequestMapping(SIGN_UP_URL)
public class LoginController {

    private AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("")
    public ResponseEntity<?> login(
        @RequestBody User user
    ) throws JsonProcessingException {

        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                user.getLogin(),
                user.getPassword(),
                new ArrayList<>()
            )
        );

        if(auth.isAuthenticated()){
            User currentUser = (User) auth.getPrincipal();
            return ResponseEntity.ok()
                    .header(HEADER_STRING,TOKEN_PREFIX + generateJWTToken(currentUser))
                    .body(currentUser);
        }else{
            return new ResponseEntity<>("Não Autenticado",HttpStatus.FORBIDDEN);
        }
    }

    private String generateJWTToken(User user){
        return JWT.create()
                .withSubject(user.getLogin())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
    }

}

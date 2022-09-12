package com.pucpr.backend.config;

import com.pucpr.backend.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.ArrayList;
import java.util.List;

import static com.pucpr.backend.config.SecurityConstants.HEADER_STRING;
import static com.pucpr.backend.config.SecurityConstants.SIGN_UP_URL;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors()
            .and()
        .authorizeRequests()
            //sign up
            .antMatchers(SIGN_UP_URL).permitAll()
            //cadastro pessoa
            .antMatchers(HttpMethod.POST, "/person/").permitAll()
            //consultas do cadastro
            .antMatchers(HttpMethod.GET, "/position/").permitAll()
            //swagger
            .antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**"
            ).permitAll()
            .and()
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }



    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        List<String> allowedOrigins = new ArrayList<>();
        allowedOrigins.add("*");
//        allowedOrigins.add("http://localhost:4200");
//        allowedOrigins.add("http://127.0.0.1:4200");

        List<String> allowedMethods = new ArrayList<>();
        allowedMethods.add("*");
//        allowedMethods.add("GET");
//        allowedMethods.add("POST");
//        allowedMethods.add("PUT");
//        allowedMethods.add("DELETE");

        List<String> allowedHeaders = new ArrayList<>();
        allowedHeaders.add("*");
//        allowedHeaders.add("Content-type");
//        allowedHeaders.add("Accept");
//        allowedHeaders.add("Referer");
//        allowedHeaders.add(HEADER_STRING);

        List<String> exposedHeaders = new ArrayList<>();
        exposedHeaders.add("*");


        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(allowedHeaders);
        corsConfiguration.setAllowedMethods(allowedMethods);
        corsConfiguration.setAllowedOriginPatterns(allowedOrigins);
        corsConfiguration.setExposedHeaders(exposedHeaders);




        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }

}
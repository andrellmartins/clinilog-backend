//package com.pucpr.backend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.CorsProcessor;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//
//
//
//public class CorsFilter extends CorsWebFilter {
//
//    public CorsFilter(CorsConfigurationSource configSource) {
//        super(configSource);
//    }
//
//    public CorsFilter(CorsConfigurationSource configSource, CorsProcessor processor) {
//        super(configSource, processor);
//    }
//
//    @Bean
//    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                // ...
//                .cors(cors -> cors.disable());
//        return http.build();
//    }
//}
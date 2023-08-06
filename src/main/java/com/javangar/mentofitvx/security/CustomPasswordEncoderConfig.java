package com.javangar.mentofitvx.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomPasswordEncoderConfig {
	
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception { 
    	
    	http.csrf().disable().authorizeHttpRequests(requests -> requests
    			.requestMatchers(HttpMethod.POST, "/api/register", "/api/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/", "/api/user", "/api/user/*").hasAuthority("USER","ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/users/login", "/api/users/{username}", "/api/logout").authenticated()
//                .requestMatchers(HttpMethod.POST, "/api/customers", "/api/storages").authenticated()
//                .requestMatchers(HttpMethod.PUT, "/api/customers/{id}", "/api/storages/{id}").authenticated()
//                .requestMatchers(HttpMethod.DELETE, "/api/users/{id}", "/api/storages/{id}", "/api/customers/{id}").authenticated()
                .anyRequest().denyAll()).httpBasic();
    	
         return http.build();
    }
 
    @Bean
    public CustomPasswordEncoder customPasswordEncoder(){
        return new CustomPasswordEncoder();
    }
}
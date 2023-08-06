package com.javangar.mentofitvx.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javangar.mentofitvx.model.User;
import com.javangar.mentofitvx.repository.UserRepository;
import com.javangar.mentofitvx.security.CustomPasswordEncoder;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class UserController implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Lazy
	@Autowired
    private CustomPasswordEncoder customPasswordEncoder;
    
    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
    	User newUser = new User();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(customPasswordEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && customPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") int id){
    	if (userRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(userRepository.findById((long) id));
    }
    
    @GetMapping("/user")
    public ResponseEntity<List<User>> findAll(){
    	List<User> users = userRepository.findAll();
        if (users == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(users);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByEmail(username);
    if(userEntity == null) throw new UsernameNotFoundException(username);

            return new org.springframework.security.core.userdetails.User(username,
                    null,Collections.emptyList());

    }
     
//
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//    	String encryptedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encryptedPassword);
//        userRepository.save(user);
//        return ResponseEntity.ok(user);
//    }
}
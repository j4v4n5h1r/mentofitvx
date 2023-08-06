package com.javangar.mentofitvx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javangar.mentofitvx.model.Message;
import com.javangar.mentofitvx.repository.MessageRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private MessageRepository messageRepository;

	@PostMapping("/message")
	public void create(@RequestBody Message message) {
		messageRepository.save(message);
	}
    
    @GetMapping("/message")
    public ResponseEntity<List<Message>> findAll(){
    	List<Message> messages = messageRepository.findAll();
        if (messages == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(messages);
    }
    
	@GetMapping("/message/{id}")
    public ResponseEntity<Optional<Message>> findById(@PathVariable("id") int id){
    	if (messageRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(messageRepository.findById((long) id));
    }
}
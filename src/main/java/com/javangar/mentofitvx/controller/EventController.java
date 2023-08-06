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

import com.javangar.mentofitvx.model.Event;
import com.javangar.mentofitvx.repository.EventRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;

	@PostMapping("/event")
	public void create(@RequestBody Event event) {
		eventRepository.save(event);
	}
    
    @GetMapping("/event")
    public ResponseEntity<List<Event>> findAll(){
    	List<Event> events = eventRepository.findAll();
        if (events == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(events);
    }
    
	@GetMapping("/event/{id}")
    public ResponseEntity<Optional<Event>> findById(@PathVariable("id") int id){
    	if (eventRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(eventRepository.findById((long) id));
    }
}
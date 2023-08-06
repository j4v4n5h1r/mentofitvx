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

import com.javangar.mentofitvx.model.Save;
import com.javangar.mentofitvx.repository.SaveRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class SaveController {
	@Autowired
	private SaveRepository saveRepository;

	@PostMapping("/save")
	public void create(@RequestBody Save save) {
		saveRepository.save(save);
	}
    
    @GetMapping("/save")
    public ResponseEntity<List<Save>> findAll(){
    	List<Save> saves = saveRepository.findAll();
        if (saves == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(saves);
    }
    
	@GetMapping("/save/{id}")
    public ResponseEntity<Optional<Save>> findById(@PathVariable("id") int id){
    	if (saveRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(saveRepository.findById((long) id));
    }
}
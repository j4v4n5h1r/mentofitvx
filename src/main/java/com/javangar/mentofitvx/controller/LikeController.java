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

import com.javangar.mentofitvx.model.Like;
import com.javangar.mentofitvx.repository.LikeRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class LikeController {
	
	@Autowired
	private LikeRepository likeRepository;

	@PostMapping("/like")
	public void create(@RequestBody Like like) {
		likeRepository.save(like);
	}
    
    @GetMapping("/like")
    public ResponseEntity<List<Like>> findAll(){
    	List<Like> likes = likeRepository.findAll();
        if (likes == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(likes);
    }
    
	@GetMapping("/like/{id}")
    public ResponseEntity<Optional<Like>> findById(@PathVariable("id") int id){
    	if (likeRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(likeRepository.findById((long) id));
    }
}